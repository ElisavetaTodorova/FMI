var inputEl = document.getElementById('input-field');
var colorsEl = document.getElementsByClassName('color-box');
var btnSaveEl = document.getElementById('btn-save');
var btnDeleteEl = document.getElementById('btn-delete');
var listEl = document.getElementById('listed');
var inputMailEl = document.getElementById('input-field-mail');
var btnSendEl = document.getElementById('btn-send');

var noteCount = 0;
var activeNote = null;

var request = new XMLHttpRequest();
request.open('GET', 'http://localhost:8080/notes/', true);
request.onload = function () {

  var data = JSON.parse(this.response);
  if (request.status >= 200 && request.status < 400) {
    data.forEach(note => {

      var textEl = document.createElement('p');
      textEl.setAttribute('class', 'card-text p-3');
      textEl.appendChild(document.createTextNode(note.noteBody));
      var containerEl = document.createElement('div');
      containerEl.setAttribute('id', 'note' + note.id);
      containerEl.setAttribute('class', 'card shadow-sm rounded');
      containerEl.setAttribute('onclick', 'editNote(' + note.id + ')');
      containerEl.style.backgroundColor = note.noteColor || '#fff';
      containerEl.appendChild(textEl);
      listEl.appendChild(containerEl);
    });
  } else {
    const errorMessage = document.createElement('marquee');
    errorMessage.textContent = `Gah, it's not working!`;
    app.appendChild(errorMessage);
  }
}
request.send();


for (var i = 0; i < colorsEl.length; i++) {
  var color = convertColor(colorsEl[i].style.backgroundColor);
  colorsEl[i].setAttribute('onclick', 'inputColor("' + color + '")');
}

function convertColor(color) {
  var result = w3color(color.toLowerCase());
  return result.valid ? result.toHexString() : '';
}

function inputColor(color) {
  inputEl.style.backgroundColor = color;
}

inputEl.onkeypress = function (event) {
  var keycode = (event.keyCode ? event.keyCode : event.which);
  if (keycode == '13') {
    btnSaveEl.onclick();
  }
}

btnSaveEl.onclick = function () {
  var text = inputEl.value;
  if (text === '') {
    alert('Please write a note.');
    return;
  }
  var id = noteCount + 1;
  var color = inputEl.style.backgroundColor;
  if (activeNote) {
    document.querySelector('#listed div[id=note' + activeNote + ']').style.backgroundColor = color;
    document.querySelector('#listed div[id=note' + activeNote + '] p').textContent = text;
    document.getElementById("btn-icon").classList.remove("fa-remove");
    document.getElementById("btn-icon").classList.add("fa-eraser");
    activeNote = null;
  } else {
    var request = new XMLHttpRequest();
    request.open('POST', 'http://localhost:8080/notes/add', true);
    request.onload = function () {

      if (request.status >= 200 && request.status < 400) {
        var textEl = document.createElement('p');
        textEl.setAttribute('class', 'card-text p-3');
        textEl.appendChild(document.createTextNode(text));
        var containerEl = document.createElement('div');
        containerEl.setAttribute('id', 'note' + id);
        containerEl.setAttribute('class', 'card shadow-sm rounded');
        containerEl.setAttribute('onclick', 'editNote(' + id + ')');
        containerEl.style.backgroundColor = color || '#fff';

        containerEl.appendChild(textEl);
        listEl.appendChild(containerEl);

        noteCount++;
      }

    }
    request.setRequestHeader('Content-Type', 'application/json');
    request.send(JSON.stringify({
      noteBody: text,
      noteColor: color
    }));
  }

  inputEl.value = '';
  inputEl.style.backgroundColor = '#fff';
}

function editNote(id) {
  var itemEl = document.getElementById('note' + id);
  var textItem = itemEl.querySelector('p').textContent;
  activeNote = id;
  inputEl.value = textItem;
  inputEl.style.backgroundColor = itemEl.style.backgroundColor;

  document.getElementById("btn-icon").classList.remove("fa-eraser");
  document.getElementById("btn-icon").classList.add("fa-remove");
}

btnDeleteEl.onclick = function () {
  if (activeNote) {
    var note = listEl.querySelector('div[id=note' + activeNote + ']');
    var request = new XMLHttpRequest();
    request.open('DELETE', 'http://localhost:8080/notes/' + activeNote, true);
    request.onload = function () {
      if (request.status >= 200 && request.status < 400) {
        note.remove();
        activeNote = null;
      }
    }
    request.send();
  }
  inputEl.value = '';
  inputEl.style.backgroundColor = '#fff';
  document.getElementById("btn-icon").classList.remove("fa-remove");
  document.getElementById("btn-icon").classList.add("fa-eraser");
}


btnSendEl.onclick = function () {
  if (activeNote) {
    var mailRecip = inputMailEl.value;
    var itemEl = document.getElementById('note' + activeNote);
  var textItem = itemEl.querySelector('p').textContent;
    var request = new XMLHttpRequest();
    request.open('POST', 'http://localhost:8080/notes/send', true);
    request.onload = function () {
      if (request.status >= 200 && request.status < 400) {
        alert('Email Sent!');
        activeNote = null;
      }
    }
    request.setRequestHeader('Content-Type', 'application/json');
    request.send(JSON.stringify({
      recipient: mailRecip,
      body: textItem
    }));
  }
  mailRecip.value = '';
  mailRecip.style.backgroundColor = '#fff';
  document.getElementById("btn-icon").classList.remove("fa-remove");
  document.getElementById("btn-icon").classList.add("fa-eraser");
}