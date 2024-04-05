package ru.medicaltickets.MyServiceJava.visit.appointment.handlers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import ru.medicaltickets.MyServiceJava.visit.appointment.Appointment;
import ru.medicaltickets.MyServiceJava.visit.appointment.AppointmentService;
import ru.medicaltickets.MyServiceJava.visit.ticket.Ticket;

public class PostAppointmentHandler {
    private final AppointmentService appointmentService;

    public PostAppointmentHandler(AppointmentService appointmentService) {
        this.appointmentService = appointmentService;
    }

    public ResponseEntity<?> handle(Appointment appointment) {
        return ResponseEntity.status(HttpStatus.OK).body(appointmentService.post(appointment));
    }
}
