package ru.medicaltickets.MyServiceJava.user.account;

import org.jooq.DSLContext;
import org.jooq.Record;
import org.jooq.TableField;
import org.jooq.impl.DSL;

import org.jooq.impl.SQLDataType;
import org.springframework.stereotype.Repository;
import ru.medicaltickets.MyServiceJava.jooq.tables.records.AccountsRecord;
import ru.medicaltickets.MyServiceJava.user.account.dto.AccountChangePasswordDTO;
import ru.medicaltickets.MyServiceJava.user.account.dto.AccountCheckLoginAvailableDTO;

import java.util.Arrays;
import java.util.List;

import static ru.medicaltickets.MyServiceJava.jooq.Tables.ACCOUNTS;

@Repository
public class AccountDAO {
    private final DSLContext context;

    public AccountDAO(DSLContext context) {
        this.context = context;
    }

    private final List<TableField<AccountsRecord, ?>> ACCOUNT_FIELDS = List.of(
            ACCOUNTS.ID,
            ACCOUNTS.LOGIN
    );

    private static Account buildAccount(Record record) {
        return Account.builder()
                .ID(record.get(ACCOUNTS.ID))
                .login(record.get(ACCOUNTS.LOGIN))
                .build();
    }

    public Account getByLogin(AccountCheckLoginAvailableDTO accountDTO) {
        return context
                .select(ACCOUNT_FIELDS)
                .from(ACCOUNTS)
                .where(ACCOUNTS.LOGIN.eq(accountDTO.login()))
                .fetchSingle(AccountDAO::buildAccount);
    }

    public int changePassword(AccountChangePasswordDTO accountDTO) {
        return context
                .update(ACCOUNTS)
                .set(ACCOUNTS.PASSWORD, DSL.val(accountDTO.newPassword(), SQLDataType.VARCHAR(30)))
                .where(ACCOUNTS.LOGIN.eq(accountDTO.login()))
                        .and(ACCOUNTS.PASSWORD.eq(Arrays.toString(accountDTO.oldPassword())))
                .execute();
    }

    public int post(Account account) {
        return context.newRecord(ACCOUNTS, account).store();
    }
}
