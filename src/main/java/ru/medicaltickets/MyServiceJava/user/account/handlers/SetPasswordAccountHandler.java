package ru.medicaltickets.MyServiceJava.user.account.handlers;

import ru.medicaltickets.MyServiceJava.user.account.AccountDAO;
import ru.medicaltickets.MyServiceJava.user.account.dto.AccountChangePasswordDTO;

public class SetPasswordAccountHandler {
    private final AccountDAO accountDAO;

    public SetPasswordAccountHandler(AccountDAO accountDAO) {
        this.accountDAO = accountDAO;
    }

    public String handle(AccountChangePasswordDTO accountChangePasswordDTO) {
        return accountDAO.changePassword(accountChangePasswordDTO) == 1 ? "Okay" : "Bad news";
    }
}
