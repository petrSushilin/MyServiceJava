package ru.medicaltickets.MyServiceJava.visit.ticket;

import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import ru.medicaltickets.MyServiceJava.visit.ticket.handlers.*;

import java.util.List;

@RequestMapping("tickets")
@RestController
@Validated
public class TicketController {
    private final GetClinicAndDoctorsSpecialtyTicketsHandler getClinicAndDoctorsSpecialtyTicketsHandler;
    private final GetClinicTicketsHandler getClinicTicketsHandler;
    private final GetDoctorTicketsHandler getDoctorTicketsHandler;
    private final GetMonthClinicTicketsHandler getMonthClinicTicketsHandler;
    private final GetMonthDoctorSpecialtyTicketsHandler getMonthDoctorSpecialtyTicketsHandler;
    private final GetSingleTicketHandler getSingleTicketHandler;
    private final GetWeekClinicAndDoctorsSpecialtyTicketsHandler getWeekClinicAndDoctorsSpecialtyTicketsHandler;
    private final GetWeekClinicTicketsHandler getWeekClinicTicketsHandler;
    private final PostTicketHandler postTicketHandler;
    private final UpdateTicketHandler updateTicketHandler;

    public TicketController(GetClinicAndDoctorsSpecialtyTicketsHandler getClinicAndDoctorsSpecialtyTicketsHandler,
                            GetClinicTicketsHandler getClinicTicketsHandler,
                            GetDoctorTicketsHandler getDoctorTicketsHandler,
                            GetMonthClinicTicketsHandler getMonthClinicTicketsHandler,
                            GetMonthDoctorSpecialtyTicketsHandler getMonthDoctorSpecialtyTicketsHandler,
                            GetSingleTicketHandler getSingleTicketHandler,
                            GetWeekClinicAndDoctorsSpecialtyTicketsHandler getWeekClinicAndDoctorsSpecialtyTicketsHandler,
                            GetWeekClinicTicketsHandler getWeekClinicTicketsHandler,
                            PostTicketHandler postTicketHandler,
                            UpdateTicketHandler updateTicketHandler) {
        this.getClinicAndDoctorsSpecialtyTicketsHandler = getClinicAndDoctorsSpecialtyTicketsHandler;
        this.getClinicTicketsHandler = getClinicTicketsHandler;
        this.getDoctorTicketsHandler = getDoctorTicketsHandler;
        this.getMonthClinicTicketsHandler = getMonthClinicTicketsHandler;
        this.getMonthDoctorSpecialtyTicketsHandler = getMonthDoctorSpecialtyTicketsHandler;
        this.getSingleTicketHandler = getSingleTicketHandler;
        this.getWeekClinicAndDoctorsSpecialtyTicketsHandler = getWeekClinicAndDoctorsSpecialtyTicketsHandler;
        this.getWeekClinicTicketsHandler = getWeekClinicTicketsHandler;
        this.postTicketHandler = postTicketHandler;
        this.updateTicketHandler = updateTicketHandler;
    }

    @GetMapping("/ticket{ticketID}")
    public ResponseEntity<?> getSingle(@PathVariable("ticketID") String ticketID) {
        return getSingleTicketHandler.handle(ticketID);
    }

    @GetMapping("/clinic{clinicID}/timetable")
    public ResponseEntity<List<?>> getTicketsByClinic(@PathVariable("clinicID") String clinicID,
                                                  @RequestParam String dateOfVisit) {
        return getClinicTicketsHandler.handle(clinicID, dateOfVisit);
    }

    @GetMapping("/clinic{clinicID}/doctor{doctorID}/timetable")
    public ResponseEntity<List<?>> getTicketsByDoctor(@PathVariable("clinicID") String clinicID,
                                                  @PathVariable("doctorID") String doctorID,
                                                  @RequestParam String dateOfVisit) {
        return getDoctorTicketsHandler.handle(clinicID, doctorID, dateOfVisit);
    }

    @GetMapping("/clinic{clinicID}/specialty/timetable")
    public ResponseEntity<List<?>> getTicketsByClinicAndDoctorsSpecialty(@PathVariable("clinicID") String clinicID,
                                                                      @RequestParam String doctorSpecialty,
                                                                      @RequestParam String dateOfVisit) {
        return getClinicAndDoctorsSpecialtyTicketsHandler.handle(clinicID, doctorSpecialty, dateOfVisit);
    }

    @GetMapping("/clinic{clinicID}/week/timetable")
    public ResponseEntity<List<?>> getWeekScheduleByClinic(@PathVariable("clinicID") String clinicID,
                                                           @RequestParam String dateOfMonday) {
        return getWeekClinicTicketsHandler.handle(clinicID, dateOfMonday);
    }

    @GetMapping("/clinic{clinicID}/month/timetable")
    public ResponseEntity<List<?>> getMonthScheduleByClinic(@PathVariable("clinicID") String clinicID,
                                                            @RequestParam String date) {
        return getMonthClinicTicketsHandler.handle(clinicID, date);
    }

    @GetMapping("/clinic{clinicID}/specialty/week/timetable")
    public ResponseEntity<List<?>> getWeekScheduleByClinicAndDoctorsSpecialty(@PathVariable("clinicID") String clinicID,
                                                                            @RequestParam String doctorSpecialty,
                                                                            @RequestParam String dateOfMonday) {
        return getWeekClinicAndDoctorsSpecialtyTicketsHandler.handle(clinicID, doctorSpecialty, dateOfMonday);
    }

    @GetMapping("/clinic{clinicID}specialty/month/timetable")
    public ResponseEntity<List<?>> getMonthScheduleByClinicAndDoctorsSpecialty(@PathVariable("clinicID") String clinicID,
                                                                              @RequestParam String doctorSpecialty,
                                                                              @RequestParam String date) {
        return getMonthDoctorSpecialtyTicketsHandler.handle(clinicID, doctorSpecialty, date);
    }

    @PostMapping("/new")
    public ResponseEntity<?> post(@RequestBody Ticket ticket) {
        System.out.println(ticket.toString());
        return postTicketHandler.handle(ticket);
    }

    @PostMapping("/ticket{ticketID}")
    public ResponseEntity<?> update(@PathVariable("ticketID") String ticketID,
                                    @RequestBody Ticket ticket) {
        return updateTicketHandler.handle(ticketID, ticket);
    }
}
