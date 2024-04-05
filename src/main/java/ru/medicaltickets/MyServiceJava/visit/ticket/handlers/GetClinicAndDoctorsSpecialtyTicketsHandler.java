package ru.medicaltickets.MyServiceJava.visit.ticket.handlers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import ru.medicaltickets.MyServiceJava.user.doctor.enums.DoctorSpecialty;
import ru.medicaltickets.MyServiceJava.visit.ticket.TicketService;

import java.time.LocalDate;
import java.util.List;

public class GetClinicAndDoctorsSpecialtyTicketsHandler {
    private final TicketService ticketService;

    public GetClinicAndDoctorsSpecialtyTicketsHandler(TicketService ticketService) {
        this.ticketService = ticketService;
    }

    public ResponseEntity<List<?>> handle(String clinicID, String doctorSpecialty, String dateOfVisit) {
        Long parsedClinicID = Long.valueOf(clinicID);
        DoctorSpecialty parsedDoctorSpecialty = DoctorSpecialty.valueOf(doctorSpecialty);
        LocalDate parsedDateOfVisit = LocalDate.parse(dateOfVisit);
        return ResponseEntity.status(HttpStatus.OK).body(ticketService
                        .getTicketsByClinicAndDoctorsSpecialty(parsedClinicID, parsedDoctorSpecialty, parsedDateOfVisit));
    }
}
