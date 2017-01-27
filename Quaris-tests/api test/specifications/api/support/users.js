var apiPrefix = "http://localhost:8090";
var api = require("supertest-as-promised")(apiPrefix);

function getUsers(jsonWebToken){
    var request = api.get("/api/users");
    if(jsonWebToken != undefined){
        request.set("Autorization", "Bearer " + jsonWebToken);
    }
    return request
        .then(function(response){
            return response;
        });
}
function getUserById(id, jsonWebToken){
    var request = api.get("/api/users/" + id);
    if(jsonWebToken != undefined){
        request.set("Autorization", "Bearer " + jsonWebToken);
    }
    return request
        .then(function(response){
            return response;
        });
}

module.exports = {
    getUsers: getUsers,
    getUserById: getUserById
}