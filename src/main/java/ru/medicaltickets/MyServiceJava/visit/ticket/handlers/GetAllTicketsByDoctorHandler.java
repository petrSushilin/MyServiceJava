package ru.medicaltickets.MyServiceJava.visit.ticket.handlers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import ru.medicaltickets.MyServiceJava.visit.ticket.TicketService;

import java.time.LocalDate;
import java.util.List;

public class GetAllTicketsByDoctorHandler {
    private final TicketService ticketService;

    public GetAllTicketsByDoctorHandler(TicketService ticketService) {
        this.ticketService = ticketService;
    }

    public ResponseEntity<List<?>> handle(String clinicID, String doctorID) {
        Long parsedClinicID = Long.valueOf(clinicID);
        Long parsedDoctorID = Long.valueOf(doctorID);
        return ticketService.getByDoctor(parsedClinicID, parsedDoctorID);
    }

    public ResponseEntity<List<?>> handle(String clinicID, String doctorID, String dateOfVisit) {
        Long parsedClinicID = Long.valueOf(clinicID);
        Long parsedDoctorID = Long.valueOf(doctorID);
        LocalDate parsedDateOfVisit = LocalDate.parse(dateOfVisit);
        return ticketService.getByDoctor(parsedClinicID, parsedDoctorID, parsedDateOfVisit);
    }
}
