package pro.teamlead.kubepay.auth.sdk.util;

import org.springframework.security.access.expression.method.MethodSecurityExpressionOperations;

public class AuthorizationLogic {

    public boolean decide(MethodSecurityExpressionOperations operations) {

        return true;
    }
}

