var apiPrefix = "http://localhost:8090";
var api = require("supertest-as-promised")(apiPrefix);
var Chance = require("chance");
var chance = new Chance();

function registration(application){
    return api
        .post('/api/registrations')
        .set('Content-Type', 'application/json')
        .send(application)
        .then(function(response){
            return response;
        });
}

function getApplications(){
    var request = api.get('/api/registrations');
    
    return request
        .then(function(response){
            return response;
        });
}

function generateApplication(){
    return {
        applicationName: chance.first() + chance.second(),
        password: "sooo secret"
    }
}

module.exports = {
    generateApplication: generateApplication,
    registration: registration,
    getApplications: getApplications
}