package ru.medicaltickets.MyServiceJava.visit.appointment.handlers;

import ru.medicaltickets.MyServiceJava.visit.appointment.AppointmentService;

public class PostAppointmentHandler {
    private final AppointmentService appointmentService;

    public PostAppointmentHandler(AppointmentService appointmentService) {
        this.appointmentService = appointmentService;
    }
}
