package ru.medicaltickets.MyServiceJava.doctor.handlers;

import ru.medicaltickets.MyServiceJava.doctor.DoctorService;

public class GetAllDoctorsHandler {
    private DoctorService doctorService;

    public GetAllDoctorsHandler(DoctorService doctorService) {
        this.doctorService = doctorService;
    }
}
