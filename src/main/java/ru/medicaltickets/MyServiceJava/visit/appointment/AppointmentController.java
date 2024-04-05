package ru.medicaltickets.MyServiceJava.visit.appointment;

import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;
import ru.medicaltickets.MyServiceJava.visit.appointment.handlers.*;
import ru.medicaltickets.MyServiceJava.visit.ticket.Ticket;

import java.util.List;

@Component
@RestController
@RequestMapping("appointment")
public class AppointmentController {
    private final GetClientAppointmentsHandler getClientAppointmentsHandler;
    private final GetClinicAndDoctorSpecialityAppointmentsHandler getClinicAndDoctorSpecialityAppointmentsHandler;
    private final GetClinicAppointmentsHandler getClinicAppointmentsHandler;
    private final GetDoctorAppointmentsHandler getDoctorAppointmentsHandler;
    private final GetMonthScheduleClientAppointmentsHandler getMonthScheduleClientAppointmentsHandler;
    private final GetMonthScheduleClinicAndDoctorSpecialtyAppointmentsHandler getMonthScheduleClinicAndDoctorSpecialtyAppointmentsHandler;
    private final GetMonthScheduleClinicAppointmentsHandler getMonthScheduleClinicAppointmentsHandler;
    private final GetMonthScheduleDoctorAppointmentsHandler getMonthScheduleDoctorAppointmentsHandler;
    private final GetSingleAppointmentHandler getSingleAppointmentHandler;
    private final GetWeekScheduleClientAppointmentsHandler getWeekScheduleClientAppointmentsHandler;
    private final GetWeekScheduleClinicAndDoctorSpecialtyAppointmentsHandler getWeekScheduleClinicAndDoctorSpecialtyAppointmentsHandler;
    private final GetWeekScheduleClinicAppointmentsHandler getWeekScheduleClinicAppointmentsHandler;
    private final GetWeekScheduleDoctorAppointmentsHandler getWeekScheduleDoctorAppointmentsHandler;
    private final PostAppointmentHandler postAppointmentHandler;
    private final UpdateAppointmentHandler updateAppointmentHandler;

    public AppointmentController(GetClientAppointmentsHandler getClientAppointmentsHandler,
                                 GetClinicAndDoctorSpecialityAppointmentsHandler getClinicAndDoctorSpecialityAppointmentsHandler,
                                 GetClinicAppointmentsHandler getClinicAppointmentsHandler,
                                 GetDoctorAppointmentsHandler getDoctorAppointmentsHandler,
                                 GetMonthScheduleClientAppointmentsHandler getMonthScheduleClientAppointmentsHandler,
                                 GetMonthScheduleClinicAndDoctorSpecialtyAppointmentsHandler getMonthScheduleClinicAndDoctorSpecialtyAppointmentsHandler,
                                 GetMonthScheduleClinicAppointmentsHandler getMonthScheduleClinicAppointmentsHandler,
                                 GetMonthScheduleDoctorAppointmentsHandler getMonthScheduleDoctorAppointmentsHandler,
                                 GetSingleAppointmentHandler getSingleAppointmentHandler,
                                 GetWeekScheduleClientAppointmentsHandler getWeekScheduleClientAppointmentsHandler,
                                 GetWeekScheduleClinicAndDoctorSpecialtyAppointmentsHandler getWeekScheduleClinicAndDoctorSpecialtyAppointmentsHandler,
                                 GetWeekScheduleClinicAppointmentsHandler getWeekScheduleClinicAppointmentsHandler,
                                 GetWeekScheduleDoctorAppointmentsHandler getWeekScheduleDoctorAppointmentsHandler,
                                 PostAppointmentHandler postAppointmentHandler,
                                 UpdateAppointmentHandler updateAppointmentHandler) {
        this.getClientAppointmentsHandler = getClientAppointmentsHandler;
        this.getClinicAndDoctorSpecialityAppointmentsHandler = getClinicAndDoctorSpecialityAppointmentsHandler;
        this.getClinicAppointmentsHandler = getClinicAppointmentsHandler;
        this.getDoctorAppointmentsHandler = getDoctorAppointmentsHandler;
        this.getMonthScheduleClientAppointmentsHandler = getMonthScheduleClientAppointmentsHandler;
        this.getMonthScheduleClinicAndDoctorSpecialtyAppointmentsHandler = getMonthScheduleClinicAndDoctorSpecialtyAppointmentsHandler;
        this.getMonthScheduleClinicAppointmentsHandler = getMonthScheduleClinicAppointmentsHandler;
        this.getMonthScheduleDoctorAppointmentsHandler = getMonthScheduleDoctorAppointmentsHandler;
        this.getSingleAppointmentHandler = getSingleAppointmentHandler;
        this.getWeekScheduleClientAppointmentsHandler = getWeekScheduleClientAppointmentsHandler;
        this.getWeekScheduleClinicAndDoctorSpecialtyAppointmentsHandler = getWeekScheduleClinicAndDoctorSpecialtyAppointmentsHandler;
        this.getWeekScheduleClinicAppointmentsHandler = getWeekScheduleClinicAppointmentsHandler;
        this.getWeekScheduleDoctorAppointmentsHandler = getWeekScheduleDoctorAppointmentsHandler;
        this.postAppointmentHandler = postAppointmentHandler;
        this.updateAppointmentHandler = updateAppointmentHandler;
    }

    @GetMapping("/appointment{ID}")
    public ResponseEntity<?> getSingle(@PathVariable("ID") String ticketID) {
        return getSingleAppointmentHandler.handle(ticketID);
    }

    @GetMapping("/schedule/client{clientID}")
    public ResponseEntity<List<?>> getClientAppointments(@PathVariable("clientID") String clientID,
                                                         @RequestParam String dateOfVisit,
                                                         @RequestParam String conditionStatus) {
        return getClientAppointmentsHandler.handle(clientID, dateOfVisit, conditionStatus);
    }

    @GetMapping("/schedule/clinic{clinicID}/specialty")
    public ResponseEntity<List<?>> getClinicAndDoctorSpecialtyAppointments(@PathVariable("clinicID") String clinicID,
                                                         @RequestParam String doctorSpecialty,
                                                         @RequestParam String dateOfVisit,
                                                         @RequestParam String conditionStatus) {
        return getClinicAndDoctorSpecialityAppointmentsHandler.handle(clinicID, doctorSpecialty, dateOfVisit, conditionStatus);
    }

    @GetMapping("/schedule/clinic{clinicID}")
    public ResponseEntity<List<?>> getClinicAppointments(@PathVariable("clinicID") String clinicID,
                                                  @RequestParam String dateOfVisit,
                                                  @RequestParam String conditionStatus) {
        return getClinicAppointmentsHandler.handle(clinicID, dateOfVisit, conditionStatus);
    }

    @GetMapping("/schedule/clinic{clinicID}/doctor{doctorID}")
    public ResponseEntity<List<?>> getDoctorAppointments(@PathVariable("clinicID") String clinicID,
                                                  @PathVariable("doctorID") String doctorID,
                                                  @RequestParam String dateOfVisit,
                                                  @RequestParam String conditionStatus) {
        return getDoctorAppointmentsHandler.handle(clinicID, doctorID, dateOfVisit, conditionStatus);
    }

    @GetMapping("/schedule/client{clientID}/week")
    public ResponseEntity<List<?>> getWeekClientAppointments(@PathVariable("clientID") String clientID,
                                                         @RequestParam String dateOfMonday,
                                                         @RequestParam String conditionStatus) {
        return getWeekScheduleClientAppointmentsHandler.handle(clientID, dateOfMonday, conditionStatus);
    }

    @GetMapping("/schedule/clinic{clinicID}/specialty/week")
    public ResponseEntity<List<?>> getWeekClinicAndDoctorSpecialtyAppointments(@PathVariable("clinicID") String clinicID,
                                                                           @RequestParam String doctorSpecialty,
                                                                           @RequestParam String dateOfMonday,
                                                                           @RequestParam String conditionStatus) {
        return getWeekScheduleClinicAndDoctorSpecialtyAppointmentsHandler.handle(clinicID, doctorSpecialty, dateOfMonday, conditionStatus);
    }

    @GetMapping("/schedule/clinic{clinicID}/week")
    public ResponseEntity<List<?>> getWeekClinicAppointments(@PathVariable("clinicID") String clinicID,
                                                         @RequestParam String dateOfMonday,
                                                         @RequestParam String conditionStatus) {
        return getWeekScheduleClinicAppointmentsHandler.handle(clinicID, dateOfMonday, conditionStatus);
    }

    @GetMapping("/schedule/clinic{clinicID}/doctor{doctorID}/week")
    public ResponseEntity<List<?>> getWeekDoctorAppointments(@PathVariable("clinicID") String clinicID,
                                                         @PathVariable("doctorID") String doctorID,
                                                         @RequestParam String dateOfMonday,
                                                         @RequestParam String conditionStatus) {
        return getWeekScheduleDoctorAppointmentsHandler.handle(clinicID, doctorID, dateOfMonday, conditionStatus);
    }

    @GetMapping("/schedule/client{clientID}/month")
    public ResponseEntity<List<?>> getMonthClientAppointments(@PathVariable("clientID") String clientID,
                                                         @RequestParam String date,
                                                         @RequestParam String conditionStatus) {
        return getMonthScheduleClientAppointmentsHandler.handle(clientID, date, conditionStatus);
    }

    @GetMapping("/schedule/clinic{clinicID}/specialty/month")
    public ResponseEntity<List<?>> getMonthClinicAndDoctorSpecialtyAppointments(@PathVariable("clinicID") String clinicID,
                                                                           @RequestParam String doctorSpecialty,
                                                                           @RequestParam String date,
                                                                           @RequestParam String conditionStatus) {
        return getMonthScheduleClinicAndDoctorSpecialtyAppointmentsHandler.handle(clinicID, doctorSpecialty, date, conditionStatus);
    }

    @GetMapping("/schedule/clinic{clinicID}/month")
    public ResponseEntity<List<?>> getMonthClinicAppointments(@PathVariable("clinicID") String clinicID,
                                                         @RequestParam String date,
                                                         @RequestParam String conditionStatus) {
        return getMonthScheduleClinicAppointmentsHandler.handle(clinicID, date, conditionStatus);
    }

    @GetMapping("/schedule/clinic{clinicID}/doctor{doctorID}/month")
    public ResponseEntity<List<?>> getMonthDoctorAppointments(@PathVariable("clinicID") String clinicID,
                                                         @PathVariable("doctorID") String doctorID,
                                                         @RequestParam String date,
                                                         @RequestParam String conditionStatus) {
        return getMonthScheduleDoctorAppointmentsHandler.handle(clinicID, doctorID, date, conditionStatus);
    }

    @PostMapping("/new")
    public ResponseEntity<?> post(@Valid @RequestBody Appointment appointment) {
        return postAppointmentHandler.handle(appointment);
    }

    @PostMapping("/appointment{ID}")
    public ResponseEntity<?> update(@PathVariable("ID") String ticketID,
                                    @RequestBody Ticket ticket) {
        return updateAppointmentHandler.handle(ticketID, ticket);
    }
}
