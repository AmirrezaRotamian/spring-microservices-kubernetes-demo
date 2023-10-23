package pro.teamlead.kubepay.user.client.component;

import feign.RequestInterceptor;
import feign.RequestTemplate;

public class UserClientRequestInterceptor implements RequestInterceptor {

    @Override
    public void apply(RequestTemplate template)  {
        // The method is intentionally left empty for now because no interception is currently needed.
        // However, theoretically, we could use this method to automatically inject a ServicePrincipal
        // if needed in the future.
    }
}
