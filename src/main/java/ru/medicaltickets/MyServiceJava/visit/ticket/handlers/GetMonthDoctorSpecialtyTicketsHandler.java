package ru.medicaltickets.MyServiceJava.visit.ticket.handlers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import ru.medicaltickets.MyServiceJava.user.doctor.enums.DoctorSpecialty;
import ru.medicaltickets.MyServiceJava.visit.ticket.TicketService;

import java.time.LocalDate;
import java.util.List;

public class GetMonthDoctorSpecialtyTicketsHandler {
    private final TicketService ticketService;

    public GetMonthDoctorSpecialtyTicketsHandler(TicketService ticketService) {
        this.ticketService = ticketService;
    }

    public ResponseEntity<List<?>> handle(String clinicID, String date, String doctorSpecialty) {
        Long parsedClinicID = Long.valueOf(clinicID);
        LocalDate parsedDate = LocalDate.parse(date);
        DoctorSpecialty parsedDoctorSpecialty = DoctorSpecialty.valueOf(doctorSpecialty);
        return ResponseEntity.status(HttpStatus.OK).body(ticketService
                .getMonthScheduleByClinicAndDoctorsSpecialty(parsedClinicID, parsedDoctorSpecialty, parsedDate));
    }
}
