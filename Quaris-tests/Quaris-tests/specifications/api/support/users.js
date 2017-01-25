var apiPrefix = "http://localhost:8090/api";
var api = require("supertest-as-promised")(apiPrefix);
var context = {};

function getUsers(jsonWebToken) {
    context.token = jsonWebToken.headers.authorization.replace(/Bearer */i, "");
    var request = api.get("/users");
    if (context.token != undefined) {
        request.set("Authorization", context.token);
    }
    return request
        .then(function(response) {
            return response;
        });
}

function getUserById(id, jsonWebToken) {
    var request = api.get("/users/" + id);
    if (context.token != undefined) {
        request.set("Authorization", context.token);
    }
    return request
        .then(function(response) {
            return response;
        });
}

module.exports = {
    getUsers: getUsers,
    getUserById: getUserById
}