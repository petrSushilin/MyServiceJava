package ru.medicaltickets.MyServiceJava.user.client;

import org.jooq.DSLContext;
import org.jooq.DatePart;
import org.jooq.Record;
import org.jooq.TableField;
import ru.medicaltickets.MyServiceJava.jooq.tables.records.ClientsRecord;
import ru.medicaltickets.MyServiceJava.user.enums.Gender;

import java.time.LocalDate;
import java.util.List;

import static org.jooq.impl.DSL.extract;
import static ru.medicaltickets.MyServiceJava.jooq.Tables.CLIENTS;

public class ClientDAO {
    private final DSLContext context;

    public ClientDAO(DSLContext context) {
        this.context = context;
    }
    private final List<TableField<ClientsRecord, ?>> CLIENT_FIELDS = List.of(
            CLIENTS.ID,
            CLIENTS.ACCOUNTID,
            CLIENTS.FIRSTNAME,
            CLIENTS.LASTNAME,
            CLIENTS.GENDER,
            CLIENTS.BIRTHDATE
    );

    private static Client buildClient(Record record) {
        return Client.builder()
                .ID(record.get(CLIENTS.ID))
                .accountID(record.get(CLIENTS.ACCOUNTID))
                .firstName(record.get(CLIENTS.FIRSTNAME))
                .lastName(record.get(CLIENTS.LASTNAME))
                .gender(Gender.valueOf(record.get(CLIENTS.GENDER)))
                .build();
    }

    public boolean isExist(Long ID) {
        return context
                .select(CLIENT_FIELDS)
                .from(CLIENTS)
                .where(CLIENTS.ID.eq(ID))
                .stream().findAny().isPresent();
    }

    public Client getBy(Long ID) {
        return context
                .select(CLIENT_FIELDS)
                .from(CLIENTS)
                .where(CLIENTS.ID.eq(ID))
                .fetchSingle(ClientDAO::buildClient);
    }

    public List<Client> getByParams(String fullName) {
        return context
                .select(CLIENT_FIELDS)
                .from(CLIENTS)
                .where(CLIENTS.LASTNAME.concat(" ").concat(CLIENTS.FIRSTNAME).eq(fullName))
                .or(CLIENTS.FIRSTNAME.concat(" ").concat(CLIENTS.LASTNAME).eq(fullName))
                .fetch(ClientDAO::buildClient);
    }

    public List<Client> getByParams(String lastName, Gender gender) {
        return context
                .select(CLIENT_FIELDS)
                .from(CLIENTS)
                .where(CLIENTS.LASTNAME.eq(lastName).and(CLIENTS.GENDER.eq(String.valueOf(gender))))
                .fetch(ClientDAO::buildClient);
    }

    public List<Client> getByParams(Gender gender, LocalDate birthdate) {
        return context
                .select(CLIENT_FIELDS)
                .from(CLIENTS)
                .where(CLIENTS.GENDER.eq(String.valueOf(gender)).and(CLIENTS.BIRTHDATE.eq(birthdate)))
                .fetch(ClientDAO::buildClient);
    }

    public List<Client> getByParams(String fullName, LocalDate birthdate) {
        return context
                .select(CLIENT_FIELDS)
                .from(CLIENTS)
                .where((CLIENTS.LASTNAME.concat(" ").concat(CLIENTS.FIRSTNAME).eq(fullName))
                .or(CLIENTS.FIRSTNAME.concat(" ").concat(CLIENTS.LASTNAME).eq(fullName))
                .and(CLIENTS.BIRTHDATE.eq(birthdate)))
                .fetch(ClientDAO::buildClient);
    }

    public List<Client> getAll() {
         return context
                .select(CLIENT_FIELDS)
                .from(CLIENTS)
                .fetch(ClientDAO::buildClient);
    }


    public List<Client> getAllByAgeElder(LocalDate birthdate) {
        return context
                .select(CLIENT_FIELDS)
                .from(CLIENTS)
                .where(CLIENTS.BIRTHDATE.le(birthdate))
                .fetch(ClientDAO::buildClient);
    }

    public List<Client> getAllByAgeElderWithGender(LocalDate birthdate, Gender gender) {
        return context
                .select(CLIENT_FIELDS)
                .from(CLIENTS)
                .where(CLIENTS.GENDER.eq(String.valueOf(gender)).and(CLIENTS.BIRTHDATE.le(birthdate)))
                .fetch(ClientDAO::buildClient);
    }

    public List<Client> getAllByAgeYounger(LocalDate birthdate) {
        return context
                .select(CLIENT_FIELDS)
                .from(CLIENTS)
                .where(CLIENTS.BIRTHDATE.ge(birthdate))
                .fetch(ClientDAO::buildClient);
    }

    public List<Client> getAllByAgeYoungerWithGender(LocalDate birthdate, Gender gender) {
        return context
                .select(CLIENT_FIELDS)
                .from(CLIENTS)
                .where(CLIENTS.GENDER.eq(String.valueOf(gender)).and(CLIENTS.BIRTHDATE.ge(birthdate)))
                .fetch(ClientDAO::buildClient);
    }

    public List<Client> getAllWithBirthdayOnDate(LocalDate date) {
        return context
                .select(CLIENT_FIELDS)
                .from(CLIENTS)
                .where(extract(CLIENTS.BIRTHDATE, DatePart.MONTH).eq(extract(date, DatePart.MONTH))
                        .and(extract(CLIENTS.BIRTHDATE, DatePart.DAY).eq(extract(date, DatePart.DAY))))
                .fetch(ClientDAO::buildClient);
    }

    public int update(Client client) {
        return context.newRecord(CLIENTS, client).update();
    }

    public int post(Client client) {
        return context.newRecord(CLIENTS, client).store();
    }
}
