package pro.teamlead.kubepay.user.api;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class UserApiMethodDictionary {

    public static final String CREATE_USER = "/create";

    public static final String GET_PASSWORD_HASH = "/getPasswordHash/{user}";

    public static final String GET_MY_INFO = "/me";

    public static final String GET_USER_INFO = "/info/{user}";
}
