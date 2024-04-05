package ru.medicaltickets.MyServiceJava.visit.ticket.handlers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import ru.medicaltickets.MyServiceJava.user.doctor.enums.DoctorSpecialty;
import ru.medicaltickets.MyServiceJava.visit.ticket.TicketService;

import java.time.LocalDate;
import java.util.List;

public class GetWeekClinicAndDoctorsSpecialtyTicketsHandler {
    private final TicketService ticketService;

    public GetWeekClinicAndDoctorsSpecialtyTicketsHandler(TicketService ticketService) {
        this.ticketService = ticketService;
    }

    public ResponseEntity<List<?>> handle(String clinicID, String dateOfMonday, String doctorSpecialty) {
        Long parsedClinicID = Long.valueOf(clinicID);
        LocalDate parsedDateOfMonday = LocalDate.parse(dateOfMonday);
        DoctorSpecialty parsedDoctorSpecialty = DoctorSpecialty.valueOf(doctorSpecialty);
        return ResponseEntity.status(HttpStatus.OK).body(ticketService
                .getWeekScheduleByClinicAndDoctorsSpecialty(parsedClinicID, parsedDoctorSpecialty, parsedDateOfMonday));
    }
}
