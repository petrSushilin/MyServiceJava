package ru.medicaltickets.MyServiceJava.visit.ticket.handlers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import ru.medicaltickets.MyServiceJava.visit.ticket.TicketService;

import java.time.LocalDate;
import java.util.List;

public class GetClinicTicketsHandler {
    private final TicketService ticketService;

    public GetClinicTicketsHandler(TicketService ticketService) {
        this.ticketService = ticketService;
    }

    public ResponseEntity<List<?>> handle(String clinicID, String dateOfVisit) {
        Long parsedClinicID = Long.valueOf(clinicID);
        LocalDate parsedDateOfVisit = LocalDate.parse(dateOfVisit);
        return ResponseEntity.status(HttpStatus.OK).body(ticketService.getTicketsByClinic(parsedClinicID, parsedDateOfVisit));
    }
}
