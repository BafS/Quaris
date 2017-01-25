var apiPrefix = "http://localhost:8090/api";
var api = require("supertest-as-promised")(apiPrefix);
var Chance = require("chance");
var chance = new Chance();

function registration(application){
    return api
        .post('/registrations')
        .set('Content-Type', 'application/json')
        .send(application)
        .then(function(response){
            return response;
        });
}

function getApplications(){
    var request = api.get("/registrations");
    /*if(jsonWebToken != undefined){
        request.set("Autorization", "Bearer " + jsonWebToken);
    }*/
    return request
        .then(function(response) {
            return response;
        });
}

function generateApplication(){
    return {
        applicationName: chance.guid(),
        password: "testPass"
    }
}

module.exports = {
    generateApplication: generateApplication,
    registration: registration,
    getApplications: getApplications
}