package user.authentication;

import org.jooq.DSLContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AuthenticationConfiguration {
    @Bean
    public AuthenticationDAO authenticationDAO(DSLContext context) {
        return new AuthenticationDAO(context);
    }

    @Bean
    public AuthenticationHandler authenticationHandler(AuthenticationDAO authenticationDAO) {
        return new AuthenticationHandler(authenticationDAO);
    }

    @Bean
    public AuthenticationController authenticationController(AuthenticationHandler authenticationHandler) {
        return new AuthenticationController(authenticationHandler);
    }
}
