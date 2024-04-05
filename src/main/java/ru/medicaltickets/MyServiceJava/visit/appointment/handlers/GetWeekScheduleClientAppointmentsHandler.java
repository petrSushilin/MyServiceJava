package ru.medicaltickets.MyServiceJava.visit.appointment.handlers;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import ru.medicaltickets.MyServiceJava.visit.appointment.AppointmentService;
import ru.medicaltickets.MyServiceJava.visit.appointment.enums.ConditionStatus;

import java.time.LocalDate;
import java.util.List;

public class GetWeekScheduleClientAppointmentsHandler {
    private final AppointmentService appointmentService;

    public GetWeekScheduleClientAppointmentsHandler(AppointmentService appointmentService) {

        this.appointmentService = appointmentService;
    }

    public ResponseEntity<List<?>> handle(String clientID, String dateOfMonday, String conditionStatus) {
        Long parsedClientID = Long.valueOf(clientID);
        LocalDate parsedDateOfMonday = LocalDate.parse(dateOfMonday);
        ConditionStatus parsedConditionStatus = ConditionStatus.valueOf(conditionStatus);
        return ResponseEntity.status(HttpStatus.OK).body(appointmentService
                .getWeekScheduleByClinic(parsedClientID, parsedDateOfMonday, parsedConditionStatus));
    }
}
