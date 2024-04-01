package ru.medicaltickets.MyServiceJava.doctor;

import org.jooq.DSLContext;
import org.springframework.stereotype.Repository;

@Repository
public class DoctorDAO {
    private final DSLContext context;

    public DoctorDAO(DSLContext context) {
        this.context = context;
    }
}
