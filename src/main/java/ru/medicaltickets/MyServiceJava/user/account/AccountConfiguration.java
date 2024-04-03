package ru.medicaltickets.MyServiceJava.user.account;

import org.jooq.DSLContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import ru.medicaltickets.MyServiceJava.user.account.handlers.PostNewAccountHandler;
import ru.medicaltickets.MyServiceJava.user.account.handlers.SetPasswordAccountHandler;

@Configuration
public class AccountConfiguration {
    @Bean
    public AccountDAO authenticationDAO(DSLContext context) {
        return new AccountDAO(context);
    }

    @Bean
    public PostNewAccountHandler postNewAccountHandler(AccountDAO accountDAO) {
        return new PostNewAccountHandler(accountDAO);
    }

    @Bean
    public SetPasswordAccountHandler setPasswordAccountHandler(AccountDAO accountDAO) {
        return new SetPasswordAccountHandler(accountDAO);
    }

    @Bean
    public AccountController accountController(PostNewAccountHandler postNewAccountHandler,
                                                               SetPasswordAccountHandler setPasswordAccountHandler) {
        return new AccountController(postNewAccountHandler, setPasswordAccountHandler);
    }
}
