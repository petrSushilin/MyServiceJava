package ru.medicaltickets.MyServiceJava.clinic.handlers;

import ru.medicaltickets.MyServiceJava.clinic.ClinicService;

public class GetAllClinicsHandler {
    private final ClinicService clinicService;

    public GetAllClinicsHandler(ClinicService clinicService) {
        this.clinicService = clinicService;
    }
}
