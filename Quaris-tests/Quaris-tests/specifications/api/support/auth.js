var apiPrefix = "http://localhost:8090/api";
var api = require("supertest-as-promised")(apiPrefix);

function auth(credentials){
    return api
        .post('/auth')
        .set('Content-Type', 'application/json')
        .send(credentials)
        .then(function(response){
            return response;
        });
}

module.exports = {
    auth: auth
}