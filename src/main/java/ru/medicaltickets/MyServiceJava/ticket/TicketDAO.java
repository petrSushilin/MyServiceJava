package ru.medicaltickets.MyServiceJava.ticket;

import org.jooq.DSLContext;
import org.springframework.stereotype.Repository;

@Repository
public class TicketDAO {
    private final DSLContext context;

    public TicketDAO(DSLContext context) {
        this.context = context;
    }
}
