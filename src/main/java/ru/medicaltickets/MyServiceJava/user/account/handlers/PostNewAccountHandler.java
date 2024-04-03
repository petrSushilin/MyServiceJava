package ru.medicaltickets.MyServiceJava.user.account.handlers;

import ru.medicaltickets.MyServiceJava.user.account.Account;
import ru.medicaltickets.MyServiceJava.user.account.AccountDAO;

public class PostNewAccountHandler {
    private final AccountDAO accountDAO;

    public PostNewAccountHandler(AccountDAO accountDAO) {
        this.accountDAO = accountDAO;
    }

    public String handle(Account account) {
        return accountDAO.post(account) == 1 ? "Okay" : "Bad";
    }
}
