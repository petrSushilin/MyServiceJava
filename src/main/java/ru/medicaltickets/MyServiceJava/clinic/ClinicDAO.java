package ru.medicaltickets.MyServiceJava.clinic;

import org.jooq.DSLContext;
import org.springframework.stereotype.Repository;

@Repository
public class ClinicDAO {
    private final DSLContext context;

    public ClinicDAO(DSLContext context) {
        this.context = context;
    }
}
