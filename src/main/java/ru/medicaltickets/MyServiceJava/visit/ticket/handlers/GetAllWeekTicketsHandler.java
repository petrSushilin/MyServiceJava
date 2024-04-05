package ru.medicaltickets.MyServiceJava.visit.ticket.handlers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import ru.medicaltickets.MyServiceJava.user.doctor.enums.DoctorSpecialty;
import ru.medicaltickets.MyServiceJava.visit.ticket.TicketService;

import java.time.LocalDate;
import java.util.List;

public class GetAllWeekTicketsHandler {
    private final TicketService ticketService;

    public GetAllWeekTicketsHandler(TicketService ticketService) {
        this.ticketService = ticketService;
    }

    public ResponseEntity<List<?>> handle(String clinicID, String dateOfMonday) {
        Long parsedClinicID = Long.valueOf(clinicID);
        LocalDate parsedDateOfMonday = LocalDate.parse(dateOfMonday);
        return ticketService.getWeekScheduleByClinic(parsedClinicID, parsedDateOfMonday);
    }

    public ResponseEntity<List<?>> handle(String clinicID, String dateOfMonday, String doctorSpecialty) {
        Long parsedClinicID = Long.valueOf(clinicID);
        LocalDate parsedDateOfMonday = LocalDate.parse(dateOfMonday);
        DoctorSpecialty parsedDoctorSpecialty = DoctorSpecialty.valueOf(doctorSpecialty);
        return ticketService.getWeekScheduleByClinicAndDoctorsSpecialty(parsedClinicID, parsedDoctorSpecialty,
                                                                                                parsedDateOfMonday);
    }
}
