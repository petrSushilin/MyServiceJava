package ru.medicaltickets.MyServiceJava.doctor.handlers;

import ru.medicaltickets.MyServiceJava.doctor.DoctorService;

public class GetDoctorHandler {
    private DoctorService doctorService;

    public GetDoctorHandler(DoctorService doctorService) {
        this.doctorService = doctorService;
    }
}
