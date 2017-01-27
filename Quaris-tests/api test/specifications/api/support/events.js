var apiPrefix = "http://localhost:8090";
var api = require("supertest-as-promised")(apiPrefix);
var Chance = require("chance");
var chance = new Chance();

function addEvent(event){
    
    var config = {'Authorization': 'eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJXZXNsZXkiLCJleHAiOjE0ODU1OTI5ODB9.iBHaapd9ClvRIWlFRMsjIrMQSMV2qsJuQ34jV3-QKtYqXuH88ao1dgau77Y2VnilGK4hnpWjVHLiq6ohILWyOQ'};
    return api
        .post('/api/events')
        .set(config)
        .set('Content-Type', 'application/json')
        .send(event)
        .then(function(response){
            return response;
        });
}

function generateEvent(){
    return {
        identifier: chance.phone(),
        type: chance.string(),
        name: chance.name(),	
        payload: {},
        createdAt:	chance.timestamp()
    }
}

module.exports = {
    addEvent: addEvent,
    generateEvent: generateEvent
}