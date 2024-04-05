package ru.medicaltickets.MyServiceJava.visit.ticket.handlers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import ru.medicaltickets.MyServiceJava.visit.ticket.TicketService;

import java.time.LocalDate;
import java.util.List;

public class GetDoctorTicketsHandler {
    private final TicketService ticketService;

    public GetDoctorTicketsHandler(TicketService ticketService) {
        this.ticketService = ticketService;
    }

    public ResponseEntity<List<?>> handle(String clinicID, String doctorID, String dateOfVisit) {
        Long parsedClinicID = Long.valueOf(clinicID);
        Long parsedDoctorID = Long.valueOf(doctorID);
        LocalDate parsedDateOfVisit = LocalDate.parse(dateOfVisit);
        return ResponseEntity.status(HttpStatus.OK).body(ticketService
                                                    .getTicketsByDoctor(parsedClinicID, parsedDoctorID, parsedDateOfVisit));
    }
}
