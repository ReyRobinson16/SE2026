package apiproject;
import apiproject.webserver.WebServer;
public class PrototypeSomeAPi {
public void prototypeSomeApi(WebServer server) {
    Loginresponse response = server.login(new LoginRequest());
    // load their profile
if (loginResponse.success()) {
ProfileLoadResponse profileLoadResponse = server.loadProfile(loginResponse.getUserIdentifier());
}
    // make a change to the profile

    // reload the updated version of the profile

    // log out

    } 
}
