package ru.medicaltickets.MyServiceJava.user.account;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.medicaltickets.MyServiceJava.user.account.dto.AccountChangePasswordDTO;
import ru.medicaltickets.MyServiceJava.user.account.handlers.PostNewAccountHandler;
import ru.medicaltickets.MyServiceJava.user.account.handlers.SetPasswordAccountHandler;

@RequestMapping("auth")
public class AccountController {
    private final PostNewAccountHandler postNewAccountHandler;
    private final SetPasswordAccountHandler setPasswordAccountHandler;

    public AccountController(PostNewAccountHandler postNewAccountHandler, SetPasswordAccountHandler setPasswordAccountHandler) {
        this.postNewAccountHandler = postNewAccountHandler;
        this.setPasswordAccountHandler = setPasswordAccountHandler;
    }

    @PostMapping("new")
    public String postNewAccount(Account account) {
        return postNewAccountHandler.handle(account);
    }

    @PostMapping("change")
    public String setPassword(AccountChangePasswordDTO account) {
        return setPasswordAccountHandler.handle(account);
    }
}
