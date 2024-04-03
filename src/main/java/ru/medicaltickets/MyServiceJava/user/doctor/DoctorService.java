package ru.medicaltickets.MyServiceJava.user.doctor;

import org.springframework.stereotype.Service;

@Service
public class DoctorService {
    private final DoctorDAO doctorDAO;

    public DoctorService(DoctorDAO doctorDAO) {
        this.doctorDAO = doctorDAO;
    }
}
