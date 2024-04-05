package ru.medicaltickets.MyServiceJava.visit.ticket.handlers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import ru.medicaltickets.MyServiceJava.visit.ticket.TicketService;

import java.time.LocalDate;
import java.util.List;

public class GetWeekClinicTicketsHandler {
    private final TicketService ticketService;

    public GetWeekClinicTicketsHandler(TicketService ticketService) {
        this.ticketService = ticketService;
    }

    public ResponseEntity<List<?>> handle(String clinicID, String dateOfMonday) {
        Long parsedClinicID = Long.valueOf(clinicID);
        LocalDate parsedDateOfMonday = LocalDate.parse(dateOfMonday);
        return ResponseEntity.status(HttpStatus.OK).body(ticketService
                                                        .getWeekScheduleByClinic(parsedClinicID, parsedDateOfMonday));
    }
}
