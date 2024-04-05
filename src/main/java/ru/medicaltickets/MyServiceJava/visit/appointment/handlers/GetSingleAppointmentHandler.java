package ru.medicaltickets.MyServiceJava.visit.appointment.handlers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import ru.medicaltickets.MyServiceJava.visit.appointment.AppointmentService;

public class GetSingleAppointmentHandler {
    private final AppointmentService appointmentService;

    public GetSingleAppointmentHandler(AppointmentService appointmentService) {
        this.appointmentService = appointmentService;
    }

    public ResponseEntity<?> handle(String ticketID) {
        Long parsedTicketID = Long.valueOf(ticketID);
        return ResponseEntity.status(HttpStatus.OK).body(appointmentService.getSingle(parsedTicketID));
    }
}
