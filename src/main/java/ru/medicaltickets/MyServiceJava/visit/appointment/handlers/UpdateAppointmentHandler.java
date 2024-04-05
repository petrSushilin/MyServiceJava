package ru.medicaltickets.MyServiceJava.visit.appointment.handlers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import ru.medicaltickets.MyServiceJava.global.exceptions.IdentifierMismatchException;
import ru.medicaltickets.MyServiceJava.visit.appointment.Appointment;
import ru.medicaltickets.MyServiceJava.visit.appointment.AppointmentService;

public class UpdateAppointmentHandler {
    private final AppointmentService appointmentService;

    public UpdateAppointmentHandler(AppointmentService appointmentService) {
        this.appointmentService = appointmentService;
    }

    public ResponseEntity<?> handle(String appointmentID, Appointment appointment) {
        Long parsedAppointmentID = Long.valueOf(appointmentID);
        if (!appointment.getID().equals(parsedAppointmentID)) throw new IdentifierMismatchException("Attempt to throw a forbidden ID");
        return ResponseEntity.status(HttpStatus.OK).body(appointmentService.post(appointment));
    }
}
