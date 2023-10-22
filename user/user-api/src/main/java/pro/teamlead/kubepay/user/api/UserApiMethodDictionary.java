package pro.teamlead.kubepay.user.api;

public interface UserApiMethodDictionary {

    String CREATE_USER = "/create";

    String GET_PASSWORD_HASH = "/getPasswordHash/{user}";

    String GET_MY_INFO = "/me";

    String GET_USER_INFO = "/info/{user}";
}
