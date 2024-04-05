package ru.medicaltickets.MyServiceJava.visit.appointment.handlers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import ru.medicaltickets.MyServiceJava.visit.appointment.AppointmentService;
import ru.medicaltickets.MyServiceJava.visit.appointment.enums.ConditionStatus;

import java.time.LocalDate;
import java.util.List;

public class GetMonthScheduleClientAppointmentsHandler {
    private final AppointmentService appointmentService;

    public GetMonthScheduleClientAppointmentsHandler(AppointmentService appointmentService) {
        this.appointmentService = appointmentService;
    }

    public ResponseEntity<List<?>> handle(String clientID, String date, String conditionStatus) {
        Long parsedClientID = Long.valueOf(clientID);
        LocalDate parsedDate = LocalDate.parse(date);
        ConditionStatus parsedConditionStatus = ConditionStatus.valueOf(conditionStatus);
        return ResponseEntity.status(HttpStatus.OK).body(appointmentService
                .getMonthScheduleByClient(parsedClientID, parsedDate, parsedConditionStatus));
    }
}
