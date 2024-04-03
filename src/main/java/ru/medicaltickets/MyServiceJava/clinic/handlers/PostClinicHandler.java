package ru.medicaltickets.MyServiceJava.clinic.handlers;

import ru.medicaltickets.MyServiceJava.clinic.ClinicService;

public class PostClinicHandler {
    private final ClinicService clinicService;

    public PostClinicHandler(ClinicService clinicService) {
        this.clinicService = clinicService;
    }
}
