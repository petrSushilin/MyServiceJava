package ru.medicaltickets.MyServiceJava.visit.appointment;

import org.springframework.stereotype.Service;

@Service
public class AppointmentService {
    private final AppointmentDAO appointmentDAO;

    public AppointmentService(AppointmentDAO appointmentDAO) {
        this.appointmentDAO = appointmentDAO;
    }
}
