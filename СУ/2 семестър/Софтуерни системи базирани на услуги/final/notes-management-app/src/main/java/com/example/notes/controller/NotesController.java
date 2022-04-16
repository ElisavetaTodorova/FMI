package com.example.notes.controller;

import com.example.notes.config.SoapClient;
import com.example.notes.exception.ResourceNotFoundException;
import com.example.notes.model.Note;
import com.example.notes.model.NoteToMail;
import com.example.notes.model.NoteUI;
import com.example.notes.repository.NotesRepository;
import com.example.notes.soap.mailSender.SendEmailInput;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.json.GsonBuilderUtils;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping(path = "/notes")
@Api(value = "Notes Management API")
public class NotesController {

    @Autowired
    private NotesRepository notesRepository;

    @Autowired
    private SoapClient soapClient;

    @ApiOperation(value = "Retrieves All Notes")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "The request has succeeded"),
            @ApiResponse(code = 404, message = "The server has not found anything matching the Request-URI")})
    @GetMapping("/")
    public List<Note> getNotes() {
        return notesRepository.findAll();
    }


    @ApiOperation(value = "Creates New Note")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "The request has succeeded"),
            @ApiResponse(code = 404, message = "The Create Operation cannot be executed")})
    @PostMapping("/add")
    public ResponseEntity<?> addNote(@RequestBody NoteUI note) {
        return ResponseEntity.ok(notesRepository.save(new Note(note.getNoteBody(), note.getNoteColor())));
    }

    @ApiOperation(value = "Deletes Note")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "The request has succeeded"),
            @ApiResponse(code = 404, message = "The Delete Operation cannot be executed")})
    @DeleteMapping("/{noteId}")
    public ResponseEntity<?> deleteNote(
            @PathVariable Long noteId) {
        if (!notesRepository.existsById(noteId)) {
            throw new ResourceNotFoundException("Note not found with id " + noteId);
        }

        return notesRepository.findById(noteId)
                .map(note -> {
                    notesRepository.delete(note);
                    return ResponseEntity.ok().build();
                }).orElseThrow(() -> new ResourceNotFoundException("Note not found with id " + noteId));

    }

    @ApiOperation(value = "Send Note to Someone's Email")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "The request has succeeded"),
            @ApiResponse(code = 404, message = "The Send Operation cannot be executed")})
    @PostMapping("/send")
    public ResponseEntity<?> sendNote(@RequestBody NoteToMail note) {
        return ResponseEntity.ok(soapClient.sendNoteToMail(new SendEmailInput(note.getRecipient(), note.getBody())));
    }
}
