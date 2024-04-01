package ru.medicaltickets.MyServiceJava.doctor.handlers;

import ru.medicaltickets.MyServiceJava.doctor.DoctorService;

public class PostDoctorHandler {
    private DoctorService doctorService;

    public PostDoctorHandler(DoctorService doctorService) {
        this.doctorService = doctorService;
    }
}
