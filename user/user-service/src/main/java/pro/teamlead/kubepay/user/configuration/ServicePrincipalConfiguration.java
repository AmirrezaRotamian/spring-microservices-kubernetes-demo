package pro.teamlead.kubepay.user.configuration;

import pro.teamlead.kubepay.auth.client.AuthClient;
import pro.teamlead.kubepay.auth.sdk.user.ServicePrincipal;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;


@Slf4j
@Configuration
@RequiredArgsConstructor
public class ServicePrincipalConfiguration {

    private final AuthClient authClient;

    /**
     * WARNING: This implementation is CONCEPTUAL and NOT production-ready.
     * You should implement proper caching mechanisms for the token to avoid
     * unnecessary calls and potential rate limits. Always ensure security
     * and efficiency when handling tokens in a real-world scenario.
     */
    @Bean
    @Scope(value = "request", proxyMode = ScopedProxyMode.TARGET_CLASS)
    public ServicePrincipal servicePrincipal(@Value("${spring.application.name}") final String service,
                                             @Value("${service.key}") final String key) {
        var token = authClient.serviceToken(key);
        log.warn("Service authToken refreshed");
        return new ServicePrincipal(service, token.getToken());
    }
}
