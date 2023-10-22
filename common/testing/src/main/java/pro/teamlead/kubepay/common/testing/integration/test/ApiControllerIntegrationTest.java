package pro.teamlead.kubepay.common.testing.integration.test;

import com.github.tomakehurst.wiremock.WireMockServer;
import pro.teamlead.kubepay.auth.sdk.authority.Authority;
import pro.teamlead.kubepay.auth.sdk.util.JwtTokenProvider;
import pro.teamlead.kubepay.common.testing.integration.annotation.IntegrationTest;
import pro.teamlead.kubepay.common.testing.integration.annotation.WireMockEnabled;
import pro.teamlead.kubepay.common.util.RandomStringUtil;
import org.junit.jupiter.api.BeforeEach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.SpyBean;
import org.springframework.test.web.servlet.MockMvc;


@IntegrationTest
@WireMockEnabled
public class ApiControllerIntegrationTest {

    @Autowired
    protected MockMvc mockMvc;

    @SpyBean
    protected JwtTokenProvider provider;

    @Autowired
    protected WireMockServer wireMockServer;

    @BeforeEach
    protected void init() {
        RandomStringUtil.removeMock();
        wireMockServer.resetAll();
    }

    protected String customToken(Authority ... authorities) {
        return "Bearer " + provider.createToken(userName(), authorities);
    }

    protected String serviceToken() {
        return "Bearer " + provider.createToken(userName(), Authority.ROLE_SERVICE);
    }

    protected String userToken() {
        return "Bearer " + provider.createToken(userName(), Authority.ROLE_USER);
    }

    protected String userName() {
        return "user";
    }
}
