package pro.teamlead.kubepay.user.client.configuration;

import org.zalando.logbook.Logbook;
import org.zalando.logbook.openfeign.FeignLogbookLogger;
import pro.teamlead.kubepay.auth.sdk.feign.JwtPrincipalFeignContract;
import pro.teamlead.kubepay.user.client.component.UserClientErrorDecoder;
import pro.teamlead.kubepay.user.client.component.UserClientRequestInterceptor;
import feign.Contract;
import feign.Logger;
import feign.RequestInterceptor;
import feign.codec.ErrorDecoder;
import org.springframework.context.annotation.Bean;

public class UserClientConfiguration {

    @Bean
    public Contract feignContract() {

//        List<AnnotatedParameterProcessor> argumentResolvers = new ArrayList();
//        argumentResolvers.add(new RequestHeaderParameterProcessor());
//        argumentResolvers.add(new JwtPrincipalParameterProcessor());
//        ...
//        return new SpringMvcContract(argumentResolvers);

        return new JwtPrincipalFeignContract();
    }

    @Bean
    public Logger logger(Logbook logbook) {
        return new FeignLogbookLogger(logbook);
    }

    @Bean
    public Logger.Level loglevel() {
        return Logger.Level.FULL;
    }

    @Bean
    public ErrorDecoder errorDecoder() {
        return new UserClientErrorDecoder();
    }

    @Bean
    public RequestInterceptor requestInterceptor() {
        return new UserClientRequestInterceptor();
    }
}
