package ru.medicaltickets.MyServiceJava.visit.ticket;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import ru.medicaltickets.MyServiceJava.global.exceptions.InvalidDateSearchException;
import ru.medicaltickets.MyServiceJava.user.doctor.enums.DoctorSpecialty;

import java.time.LocalDate;
import java.util.List;

@Service
public class TicketService {
    private final TicketDAO ticketDAO;

    public TicketService(TicketDAO ticketDAO) {
        this.ticketDAO = ticketDAO;
    }

    public Ticket getSingle(Long ticketID) {
        return ticketDAO.getSingle(ticketID);
    }

    public List<Ticket> getTicketsByClinic(Long clinicID, LocalDate dateOfVisit) {
        if (dateOfVisit.isBefore(LocalDate.now().minusDays(1)))
            throw new InvalidDateSearchException("Date is invalid");
        return ticketDAO.getTicketsByClinic(clinicID, dateOfVisit);
    }

    public List<Ticket> getTicketsByDoctor(Long clinicID, Long doctorID, LocalDate dateOfVisit) {
        if (dateOfVisit.isBefore(LocalDate.now().minusDays(1)))
            throw new InvalidDateSearchException("Date is invalid");
        return ticketDAO.getTicketsByDoctor(clinicID, doctorID, dateOfVisit);
    }
    public List<Ticket> getTicketsByClinicAndDoctorsSpecialty(Long clinicID, DoctorSpecialty doctorSpecialty,
                                                              LocalDate dateOfVisit) {
        if (dateOfVisit.isBefore(LocalDate.now().minusDays(1)))
            throw new InvalidDateSearchException("Date is invalid");
        return ticketDAO.getTicketsByClinicAndDoctorsSpecialty(clinicID, doctorSpecialty, dateOfVisit);
    }

    public List<Ticket> getWeekScheduleByClinic(Long clinicID, LocalDate dateOfMonday) {
        if (dateOfMonday.isBefore(LocalDate.now().minusWeeks(1)))
            throw new InvalidDateSearchException("Date is invalid");
        return ticketDAO.getWeekScheduleByClinic(clinicID, dateOfMonday);
    }

    public List<Ticket> getMonthScheduleByClinic(Long clinicID, LocalDate date) {
        if (date.isBefore(LocalDate.now().minusMonths(1)))
            throw new InvalidDateSearchException("Date is invalid");
        return ticketDAO.getMonthScheduleByClinic(clinicID, date);
    }

    public List<Ticket> getWeekScheduleByClinicAndDoctorsSpecialty(Long clinicID, DoctorSpecialty doctorSpecialty,
                                                                   LocalDate dateOfMonday) {
        if (dateOfMonday.isBefore(LocalDate.now().minusWeeks(1)))
            throw new InvalidDateSearchException("Date is invalid");
        return ticketDAO.getWeekScheduleByClinicAndDoctorsSpecialty(clinicID, doctorSpecialty, dateOfMonday);
    }

    public List<Ticket> getMonthScheduleByClinicAndDoctorsSpecialty(Long clinicID, DoctorSpecialty doctorSpecialty,
                                                                    LocalDate date) {
        if (date.isBefore(LocalDate.now().minusMonths(1)))
            throw new InvalidDateSearchException("Date is invalid");
        return ticketDAO.getMonthScheduleByClinicAndDoctorsSpecialty(clinicID, doctorSpecialty, date);
    }

    public ResponseEntity<?> post(Ticket ticket) {
        if (ticketDAO.post(ticket) == 0) return ResponseEntity.status(HttpStatus.CONFLICT).body("Parameter's conflict");
        if (ticketDAO.post(ticket) == 1) return ResponseEntity.status(HttpStatus.CREATED).body("Successfully added");
        return ResponseEntity.status(HttpStatus.I_AM_A_TEAPOT).body("I am teapot");
    }

    public ResponseEntity<?> update(Ticket ticket) {
//        if (ticketDAO.update(ticket) == 0) return ResponseEntity.status(HttpStatus.CONFLICT).body("Parameter's conflict");
//        if (ticketDAO.update(ticket) == 1) return ResponseEntity.status(HttpStatus.CREATED).body("Successfully added");
        return ResponseEntity.status(HttpStatus.I_AM_A_TEAPOT).body("I am teapot");
    }
}
