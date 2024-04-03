package ru.medicaltickets.MyServiceJava.visit.appointment.handlers;

import ru.medicaltickets.MyServiceJava.visit.appointment.AppointmentService;

public class UpdateAppointmentHandler {
    private final AppointmentService appointmentService;

    public UpdateAppointmentHandler(AppointmentService appointmentService) {
        this.appointmentService = appointmentService;
    }
}
