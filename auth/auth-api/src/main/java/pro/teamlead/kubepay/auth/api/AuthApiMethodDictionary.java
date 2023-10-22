package pro.teamlead.kubepay.auth.api;

public interface AuthApiMethodDictionary {

    String AUTH_SIGNUP = "/signup";

    String AUTH_LOGIN = "/login";

    String AUTH_LOGOUT = "/logout";

    String SERVICE_TOKEN = "/service/{key}";
}
