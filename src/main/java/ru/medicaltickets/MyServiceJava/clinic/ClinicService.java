package ru.medicaltickets.MyServiceJava.clinic;

import org.springframework.stereotype.Service;

@Service
public class ClinicService {
    private final ClinicDAO clinicDAO;

    public ClinicService(ClinicDAO clinicDAO) {
        this.clinicDAO = clinicDAO;
    }
}
