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

    public ResponseEntity<?> getSingle(Long ticketID) {
        return ResponseEntity.status(HttpStatus.OK).body(ticketDAO.getSingle(ticketID));
    }

    public ResponseEntity<List<?>> getByClinic(Long clinicID) {
        return ResponseEntity.status(HttpStatus.OK).body(ticketDAO.getByClinic(clinicID));
    }

    public ResponseEntity<List<?>> getByClinic(Long clinicID, LocalDate dateOfVisit) {
        if (dateOfVisit.isBefore(LocalDate.now().minusDays(1)))
            throw new InvalidDateSearchException("Date is invalid");
        return ResponseEntity.status(HttpStatus.OK).body(ticketDAO.getByClinic(clinicID, dateOfVisit));
    }

    public ResponseEntity<List<?>> getByDoctor(Long clinicID, Long doctorID) {
        return ResponseEntity.status(HttpStatus.OK).body(ticketDAO.getByDoctor(clinicID, doctorID));
    }

    public ResponseEntity<List<?>> getByDoctor(Long clinicID, Long doctorID, LocalDate dateOfVisit) {
        if (dateOfVisit.isBefore(LocalDate.now().minusDays(1)))
            throw new InvalidDateSearchException("Date is invalid");
        return ResponseEntity.status(HttpStatus.OK).body(ticketDAO.getByDoctor(clinicID, doctorID, dateOfVisit));
    }

    public ResponseEntity<List<?>> getByClinicAndDoctorsSpecialty(Long clinicID, DoctorSpecialty doctorSpecialty) {
        return ResponseEntity.status(HttpStatus.OK)
                .body(ticketDAO.getByClinicAndDoctorsSpecialty(clinicID, doctorSpecialty));
    }
    public ResponseEntity<List<?>> getByClinicAndDoctorsSpecialty(Long clinicID, DoctorSpecialty doctorSpecialty,
                                                                                            LocalDate dateOfVisit) {
        if (dateOfVisit.isBefore(LocalDate.now().minusDays(1)))
            throw new InvalidDateSearchException("Date is invalid");
        return ResponseEntity.status(HttpStatus.OK)
                .body(ticketDAO.getByClinicAndDoctorsSpecialty(clinicID, doctorSpecialty, dateOfVisit));
    }

    public ResponseEntity<List<?>> getWeekScheduleByClinic(Long clinicID, LocalDate dateOfMonday) {
        if (dateOfMonday.isBefore(LocalDate.now().minusWeeks(1)))
            throw new InvalidDateSearchException("Date is invalid");
        return ResponseEntity.status(HttpStatus.OK).body(ticketDAO.getWeekScheduleByClinic(clinicID, dateOfMonday));
    }

    public ResponseEntity<List<?>> getWeekScheduleByClinicAndDoctorsSpecialty(Long clinicID,
                                                            DoctorSpecialty doctorSpecialty, LocalDate dateOfMonday) {
        if (dateOfMonday.isBefore(LocalDate.now().minusWeeks(1)))
            throw new InvalidDateSearchException("Date is invalid");
        return ResponseEntity.status(HttpStatus.OK)
                .body(ticketDAO.getWeekScheduleByClinicAndDoctorsSpecialty(clinicID, doctorSpecialty, dateOfMonday));
    }

    public ResponseEntity<List<?>> getMonthScheduleByClinic(Long clinicID, LocalDate date) {
        if (date.isBefore(LocalDate.now().minusMonths(1)))
            throw new InvalidDateSearchException("Date is invalid");
        return ResponseEntity.status(HttpStatus.OK).body(ticketDAO.getMonthScheduleByClinic(clinicID, date));
    }

    public ResponseEntity<List<?>> getMonthScheduleByClinicAndDoctorsSpecialty(Long clinicID,
                                                             DoctorSpecialty doctorSpecialty, LocalDate date) {
        if (date.isBefore(LocalDate.now().minusMonths(1)))
            throw new InvalidDateSearchException("Date is invalid");
        return ResponseEntity.status(HttpStatus.OK)
                .body(ticketDAO.getMonthScheduleByClinicAndDoctorsSpecialty(clinicID, doctorSpecialty, date));
    }

    public ResponseEntity<List<?>> getAll() {
        return ResponseEntity.status(HttpStatus.OK).body(ticketDAO.getAll());
    }

    public ResponseEntity<?> post(Ticket ticket) {
        if (ticketDAO.post(ticket) == 0) return ResponseEntity.status(HttpStatus.CONFLICT).body("Parameter's conflict");
        if (ticketDAO.post(ticket) == 1) return ResponseEntity.status(HttpStatus.CREATED).body("Successfully added");
        return ResponseEntity.status(HttpStatus.I_AM_A_TEAPOT).body("I am teapot");
    }

    public ResponseEntity<?> update(Ticket ticket) {
        if (ticketDAO.update(ticket) == 0) return ResponseEntity.status(HttpStatus.CONFLICT).body("Parameter's conflict");
        if (ticketDAO.update(ticket) == 1) return ResponseEntity.status(HttpStatus.CREATED).body("Successfully added");
        return ResponseEntity.status(HttpStatus.I_AM_A_TEAPOT).body("I am teapot");
    }
}
