package ru.medicaltickets.MyServiceJava.client;

import org.jooq.DSLContext;
import org.jooq.Record;
import org.jooq.TableField;
import ru.medicaltickets.MyServiceJava.global.abstracts.AbstractSubject;
import ru.medicaltickets.MyServiceJava.jooq.tables.records.UsersRecord;

import java.util.List;

import static ru.medicaltickets.MyServiceJava.jooq.Tables.USERS;

public class ClientDAO {
    private final DSLContext context;

    public ClientDAO(DSLContext context) {
        this.context = context;
    }
    private final List<TableField<ClientsRecord, ?>> CLIENT_FIELDS = List.of(
            CLIENTS.ID,
            CLIENTS.FIRSTNAME,
            CLIENTS.LASTNAME,
            CLIENTS.LOGIN
    );

    private static AbstractSubject buildClient(Record record) {
        return Client.builder()
                .ID(record.get(CLIENTS.ID))
                .firstName(record.get(CLIENTS.FIRSTNAME))
                .lastName(record.get(CLIENTS.LASTNAME))
                .login(record.get(CLIENTS.LOGIN))
                .password(record.get(CLIENTS.PASSWORD).toCharArray())
                .build();
    }

    public boolean isClientExists(Long ID) {
        return context
                .select(CLIENT_FIELDS)
                .from(CLIENTS)
                .where(CLIENTS.ID.eq(ID))
                .stream().findAny().isPresent();
    }

    public AbstractSubject getUserByID(Long ID) {
        return null;
    }

    public List<AbstractSubject> getAll() {
         context
                .select(CLIENT_FIELDS)
                .from(CLIENTS)
                .fetch(Client::builder).stream().toList();
    }
}
