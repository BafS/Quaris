var apiPrefix = "http://localhost:8090/api";
var api = require("supertest-as-promised")(apiPrefix);

var Chance = require("chance");
var chance = new Chance();
var context = {}

function addEvent(event, jsonWebToken) {
    context.token = jsonWebToken.headers.authorization.replace(/Bearer */i, "");
    return api
        .post('/events')
        .set("Authorization", context.token)
        .set('Content-Type', 'application/json')
        .send(event)
        .then(function(response) {
            return response;
        });
}

function generateEvent() {
    return {
        identifier: chance.name(),
        type: chance.name()
    }
    /*,timestamp: chance.timestamp()*/
}

module.exports = {
    addEvent: addEvent,
    generateEvent: generateEvent
}