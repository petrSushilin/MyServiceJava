package ru.medicaltickets.MyServiceJava.visit.ticket;

import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import ru.medicaltickets.MyServiceJava.user.doctor.enums.DoctorSpecialty;
import ru.medicaltickets.MyServiceJava.visit.ticket.handlers.*;

import java.time.LocalDate;
import java.util.List;

@RequestMapping("ticket")
@RestController
@Validated
public class TicketController {
    private final GetAllTodayTicketsHandler getAllTodayTicketsHandler;
    private final GetAllMonthTicketsHandler getAllMonthTicketsHandler;
    private final GetAllTicketsByClinicHandler getAllTicketsByClinicHandler;
    private final GetAllTicketsByClinicAndDoctorsSpecialty getAllTicketsByClinicAndDoctorsSpecialty;
    private final GetAllTicketsByDoctorHandler getAllTicketsByDoctorHandler;
    private final GetTicketHandler getTicketHandler;
    private final PostTicketHandler postTicketHandler;
    private final UpdateTicketHandler updateTicketHandler;

    public TicketController(GetAllTodayTicketsHandler getAllTodayTicketsHandler,
                            GetAllMonthTicketsHandler getAllMonthTicketsHandler,
                            GetAllTicketsByClinicHandler getAllTicketsByClinicHandler,
                            GetAllTicketsByClinicAndDoctorsSpecialty getAllTicketsByClinicAndDoctorsSpecialty,
                            GetAllTicketsByDoctorHandler getAllTicketsByDoctorHandler,
                            GetTicketHandler getTicketHandler,
                            PostTicketHandler postTicketHandler,
                            UpdateTicketHandler updateTicketHandler) {
        this.getAllTodayTicketsHandler = getAllTodayTicketsHandler;
        this.getAllMonthTicketsHandler = getAllMonthTicketsHandler;
        this.getAllTicketsByClinicHandler = getAllTicketsByClinicHandler;
        this.getAllTicketsByClinicAndDoctorsSpecialty = getAllTicketsByClinicAndDoctorsSpecialty;
        this.getAllTicketsByDoctorHandler = getAllTicketsByDoctorHandler;
        this.getTicketHandler = getTicketHandler;
        this.postTicketHandler = postTicketHandler;
        this.updateTicketHandler = updateTicketHandler;
    }

    @GetMapping("/ticket{ID}")
    public ResponseEntity<?> getSingle(@PathVariable("ID") String ticketID) {
        return getTicketHandler.handle(ticketID);
    }

    @GetMapping("/clinic{clinicID}")
    public ResponseEntity<List<?>> getAllByClinic(@PathVariable("clinicID") String clinicID) {
        return getAllTicketsByClinicHandler.handle(clinicID);
    }

    @GetMapping("/clinic{clinicID}")
    public ResponseEntity<List<?>> getAllByClinic(@PathVariable("clinicID") String clinicID,
                                                  @RequestParam String dateOfVisit) {
        return getAllTicketsByClinicHandler.handle(clinicID, dateOfVisit);
    }

    @GetMapping("/clinicID{clinicID}")
    public ResponseEntity<List<?>> getAllTicketsByClinicAndDoctorsSpecialty(@PathVariable("clinicID") String clinicID,
                                                                      @RequestParam String doctorSpecialty) {
        return getAllTicketsByClinicAndDoctorsSpecialty.handle(clinicID, doctorSpecialty);
    }

    @GetMapping("/clinicID{clinicID}")
    public ResponseEntity<List<?>> getAllTicketsByClinicAndDoctorsSpecialty(@PathVariable("clinicID") String clinicID,
                                                                      @RequestParam String doctorSpecialty,
                                                                      @RequestParam String dateOfVisit) {
        return getAllTicketsByClinicAndDoctorsSpecialty.handle(clinicID, doctorSpecialty, dateOfVisit);
    }

    @GetMapping("/clinic{clinicID}/doctor{doctorID}")
    public ResponseEntity<List<?>> getAllByDoctor(@PathVariable("clinicID") String clinicID,
                                                  @PathVariable("doctorID") String doctorID) {
        return getAllTicketsByDoctorHandler.handle(clinicID, doctorID);
    }

    @GetMapping("/clinic{clinicID}/doctor{doctorID}")
    public ResponseEntity<List<?>> getAllByDoctor(@PathVariable("clinicID") String clinicID,
                                                  @PathVariable("doctorID") String doctorID,
                                                  @RequestParam String dateOfVisit) {
        return getAllTicketsByDoctorHandler.handle(clinicID, doctorID, dateOfVisit);
    }

    @GetMapping("/list")
    public ResponseEntity<List<?>> getAll() {
        return getTicketHandler.handle();
    }

    @PostMapping("/new")
    public ResponseEntity<?> post(@RequestBody Ticket ticket) {
        return postTicketHandler.handle(ticket);
    }

    @PostMapping("/ticket{ID}")
    public ResponseEntity<?> update(@PathVariable("ID") String ticketID,
                                    @RequestBody Ticket ticket) {
        return updateTicketHandler.handle(ticketID, ticket);
    }
}
