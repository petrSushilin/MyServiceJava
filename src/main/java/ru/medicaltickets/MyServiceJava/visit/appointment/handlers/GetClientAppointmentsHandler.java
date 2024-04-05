package ru.medicaltickets.MyServiceJava.visit.appointment.handlers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import ru.medicaltickets.MyServiceJava.visit.appointment.AppointmentService;
import ru.medicaltickets.MyServiceJava.visit.appointment.enums.ConditionStatus;

import java.time.LocalDate;
import java.util.List;

public class GetClientAppointmentsHandler {
    private final AppointmentService appointmentService;
    public GetClientAppointmentsHandler(AppointmentService appointmentService1) {
        this.appointmentService = appointmentService1;
    }

    public ResponseEntity<List<?>> handle(String clientID, String dateOfVisit, String conditionStatus) {
        Long parsedClientID = Long.valueOf(clientID);
        LocalDate parsedDateOfVisit = LocalDate.parse(dateOfVisit);
        ConditionStatus parsedConditionStatus = ConditionStatus.valueOf(conditionStatus);
        return ResponseEntity.status(HttpStatus.OK).body(appointmentService.getScheduleByClient(parsedClientID,
                parsedDateOfVisit, parsedConditionStatus));
    }
}
