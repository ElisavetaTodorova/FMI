fetch("https://google-translate1.p.rapidapi.com/language/translate/v2", {
	"method": "POST",
	"headers": {
		"content-type": "application/x-www-form-urlencoded",
		"accept-encoding": "application/gzip",
		"x-rapidapi-key": "b95e5becc9msh534f7a0fc5888ebp17b662jsn4c8157d970cf",
		"x-rapidapi-host": "google-translate1.p.rapidapi.com"
	},
	"body": {
		"q": "Hello, world!",
		"target": "es",
		"source": "en"
	}
})
.then(response => {
	console.log(response);
})
.catch(err => {
	console.error(err);
});