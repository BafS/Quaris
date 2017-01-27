var apiPrefix = "http://localhost:8090";
var api = require("supertest-as-promised")(apiPrefix);
var Chance = require("chance");
var chance = new Chance();

function getRules(){
    var request = api.get('/api/rules');
    var config = {'Authorization': 'eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJXZXNsZXkiLCJleHAiOjE0ODU1OTI5ODB9.iBHaapd9ClvRIWlFRMsjIrMQSMV2qsJuQ34jV3-QKtYqXuH88ao1dgau77Y2VnilGK4hnpWjVHLiq6ohILWyOQ'};
   
    return request
        .set(config)
        .then(function(response){
            return response;
        });
}

function addRule(rule){

    var config = {'Authorization': 'eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJXZXNsZXkiLCJleHAiOjE0ODU1OTI5ODB9.iBHaapd9ClvRIWlFRMsjIrMQSMV2qsJuQ34jV3-QKtYqXuH88ao1dgau77Y2VnilGK4hnpWjVHLiq6ohILWyOQ'};
    return api
        .post('/api/rules')
        .set(config)
        .send(rule)
        .then(function(response){
            return response;
        });
}

function generateRule(){
    return {
        name: chance.name(),
        condition:chance.name(),	
        action: chance.name(),
        enabled: chance.bool()
    }
}

module.exports = {
    getRules: getRules,
    addRule: addRule,
    generateRule: generateRule
}