package pro.teamlead.kubepay.auth.sdk.util;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class JwtFields {

    public static final String SCOPE = "scope";

    public static final String USER = "sub";

    public static final String ISSUED_AT = "iat";

    public static final String EXPIRE_AT = "exp";
}
