var apiPrefix = "http://localhost:8090";
var api = require("supertest-as-promised")(apiPrefix);
var Chance = require("chance");
var chance = new Chance();

function getbadges(){
    var request = api.get('/api/badges');
    var config = {'Authorization': 'eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJXZXNsZXkiLCJleHAiOjE0ODU1OTI5ODB9.iBHaapd9ClvRIWlFRMsjIrMQSMV2qsJuQ34jV3-QKtYqXuH88ao1dgau77Y2VnilGK4hnpWjVHLiq6ohILWyOQ'};
    request.set(config);

    return request
        .then(function(response){
            return response;
        });
}

function addBadge(badge){
     var config = {'Authorization': 'eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJXZXNsZXkiLCJleHAiOjE0ODU1OTI5ODB9.iBHaapd9ClvRIWlFRMsjIrMQSMV2qsJuQ34jV3-QKtYqXuH88ao1dgau77Y2VnilGK4hnpWjVHLiq6ohILWyOQ', 'Content-Type': 'application/json'};
    return api
        .post('/api/badges')
        .set(config)
        .send(badge)
        .then(function(response){
            return response;
        });
}

function getbadgeByName(name){
    var request = api.get('/api/badges/' + name);
    var config = {'Authorization': 'eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJXZXNsZXkiLCJleHAiOjE0ODU1OTI5ODB9.iBHaapd9ClvRIWlFRMsjIrMQSMV2qsJuQ34jV3-QKtYqXuH88ao1dgau77Y2VnilGK4hnpWjVHLiq6ohILWyOQ'};

    return request
        .set(config)
        .then(function(response){
            return response;
        });
}

function generateBadge(){
    return {
        name: chance.name(),
        description: "for test app"
    }
}

module.exports = {
    getbadges: getbadges,
    addBadge: addBadge,
    getbadgeByName: getbadgeByName,
    generateBadge: generateBadge
}