package ru.medicaltickets.MyServiceJava.visit.appointment.handlers;

import ru.medicaltickets.MyServiceJava.visit.appointment.AppointmentService;

public class GetAppointmentHandler {
    private final AppointmentService appointmentService;

    public GetAppointmentHandler(AppointmentService appointmentService) {
        this.appointmentService = appointmentService;
    }
}
