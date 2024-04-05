package ru.medicaltickets.MyServiceJava.visit.appointment;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import ru.medicaltickets.MyServiceJava.global.exceptions.InvalidDateSearchException;
import ru.medicaltickets.MyServiceJava.user.doctor.enums.DoctorSpecialty;
import ru.medicaltickets.MyServiceJava.visit.appointment.enums.ConditionStatus;
import ru.medicaltickets.MyServiceJava.visit.ticket.Ticket;

import java.time.LocalDate;
import java.util.List;

@Service
public class AppointmentService {
    private final AppointmentDAO appointmentDAO;

    public AppointmentService(AppointmentDAO appointmentDAO) {
        this.appointmentDAO = appointmentDAO;
    }

    public Appointment getSingle(Long appointmentID) {
        return appointmentDAO.getSingle(appointmentID);
    }

    public List<Appointment> getScheduleByClinic(Long clinicID, LocalDate dateOfVisit, ConditionStatus conditionStatus) {
        return appointmentDAO.getScheduleByClinic(clinicID, dateOfVisit, conditionStatus);
    }

    public List<Appointment> getWeekScheduleByClinic(Long clinicID, LocalDate dateOfVisit, ConditionStatus conditionStatus) {
        return appointmentDAO.getWeekScheduleByClinic(clinicID, dateOfVisit, conditionStatus);
    }

    public List<Appointment> getMonthScheduleByClinic(Long clinicID, LocalDate dateOfVisit, ConditionStatus conditionStatus) {
        return appointmentDAO.getMonthScheduleByClinic(clinicID, dateOfVisit, conditionStatus);
    }

    public List<Appointment> getScheduleByDoctor(Long clinicID, Long doctorID, LocalDate dateOfVisit, ConditionStatus conditionStatus) {
        return appointmentDAO.getScheduleByDoctor(clinicID, doctorID, dateOfVisit, conditionStatus);
    }

    public List<Appointment> getWeekScheduleByDoctor(Long clinicID, Long doctorID, LocalDate dateOfVisit, ConditionStatus conditionStatus) {
        return appointmentDAO.getWeekScheduleByDoctor(clinicID, doctorID, dateOfVisit, conditionStatus);
    }

    public List<Appointment> getMonthScheduleByDoctor(Long clinicID, Long doctorID, LocalDate dateOfVisit,
                                                      ConditionStatus conditionStatus) {
        return appointmentDAO.getMonthScheduleByDoctor(clinicID, doctorID, dateOfVisit, conditionStatus);
    }

    public List<Appointment> getScheduleByDoctorSpecialty(Long clinicID, DoctorSpecialty doctorSpecialty,
                                                              LocalDate dateOfVisit, ConditionStatus conditionStatus) {
        return appointmentDAO.getScheduleByDoctorSpecialty(clinicID, doctorSpecialty, dateOfVisit, conditionStatus);
    }

    public List<Appointment> getWeekScheduleByDoctorSpecialty(Long clinicID, DoctorSpecialty doctorSpecialty,
                                                              LocalDate dateOfVisit, ConditionStatus conditionStatus) {
        return appointmentDAO.getWeekScheduleByDoctorSpecialty(clinicID, doctorSpecialty, dateOfVisit, conditionStatus);
    }

    public List<Appointment> getMonthScheduleByDoctorSpecialty(Long clinicID, DoctorSpecialty doctorSpecialty,
                                                               LocalDate dateOfVisit, ConditionStatus conditionStatus) {
        return appointmentDAO.getMonthScheduleByDoctorSpecialty(clinicID, doctorSpecialty, dateOfVisit, conditionStatus);
    }

    public List<Appointment> getScheduleByClient(Long clientID, LocalDate dateOfVisit, ConditionStatus conditionStatus) {
        return appointmentDAO.getScheduleByClient(clientID, dateOfVisit, conditionStatus);
    }

    public List<Appointment> getWeekScheduleByClient(Long clientID, LocalDate dateOfVisit, ConditionStatus conditionStatus) {
        return appointmentDAO.getWeekScheduleByClient(clientID, dateOfVisit, conditionStatus);
    }

    public List<Appointment> getMonthScheduleByClient(Long clientID, LocalDate dateOfVisit, ConditionStatus conditionStatus) {
        return appointmentDAO.getMonthScheduleByClient(clientID, dateOfVisit, conditionStatus);
    }

    public ResponseEntity<?> post(Appointment appointment) {
        if (appointmentDAO.post(appointment) == 0) return ResponseEntity.status(HttpStatus.CONFLICT).body("Parameter's conflict");
        if (appointmentDAO.post(appointment) == 1) return ResponseEntity.status(HttpStatus.CREATED).body("Successfully added");
        return ResponseEntity.status(HttpStatus.I_AM_A_TEAPOT).body("I am teapot");
    }

    public ResponseEntity<?> update(Appointment appointment) {
        if (appointmentDAO.update(appointment) == 0) return ResponseEntity.status(HttpStatus.CONFLICT).body("Parameter's conflict");
        if (appointmentDAO.update(appointment) == 1) return ResponseEntity.status(HttpStatus.CREATED).body("Successfully added");
        return ResponseEntity.status(HttpStatus.I_AM_A_TEAPOT).body("I am teapot");
    }
}
