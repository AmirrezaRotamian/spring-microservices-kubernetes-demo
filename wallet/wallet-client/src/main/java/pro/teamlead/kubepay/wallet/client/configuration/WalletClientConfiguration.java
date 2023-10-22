package pro.teamlead.kubepay.wallet.client.configuration;

import pro.teamlead.kubepay.wallet.client.component.WalletClientErrorDecoder;
import pro.teamlead.kubepay.wallet.client.component.WalletClientRequestInterceptor;
import feign.codec.ErrorDecoder;
import org.zalando.logbook.Logbook;
import org.zalando.logbook.openfeign.FeignLogbookLogger;
import pro.teamlead.kubepay.auth.sdk.feign.JwtPrincipalFeignContract;
import feign.Contract;
import feign.Logger;
import feign.RequestInterceptor;
import org.springframework.context.annotation.Bean;

public class WalletClientConfiguration {

    @Bean
    public Contract feignContract() {

        return new JwtPrincipalFeignContract();

//        List<AnnotatedParameterProcessor> argumentResolvers = new ArrayList();
//        argumentResolvers.add(new RequestHeaderParameterProcessor());
//        argumentResolvers.add(new JwtPrincipalParameterProcessor());
//        ...
//        return new SpringMvcContract(argumentResolvers);
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
        return new WalletClientErrorDecoder();
    }

    @Bean
    public RequestInterceptor requestInterceptor() {
        return new WalletClientRequestInterceptor();
    }
}
