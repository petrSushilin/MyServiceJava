package ru.medicaltickets.MyServiceJava.visit.appointment.handlers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import ru.medicaltickets.MyServiceJava.visit.appointment.AppointmentService;
import ru.medicaltickets.MyServiceJava.visit.appointment.enums.ConditionStatus;

import java.time.LocalDate;
import java.util.List;

public class GetWeekScheduleClinicAppointmentsHandler {
    private final AppointmentService appointmentService;

    public GetWeekScheduleClinicAppointmentsHandler(AppointmentService appointmentService) {
        this.appointmentService = appointmentService;
    }

    public ResponseEntity<List<?>> handle(String clinicID, String dateOfMonday, String conditionStatus) {
        Long parsedClinicID = Long.valueOf(clinicID);
        LocalDate parsedDateOfMonday = LocalDate.parse(dateOfMonday);
        ConditionStatus parsedConditionStatus = ConditionStatus.valueOf(conditionStatus);
        return ResponseEntity.status(HttpStatus.OK).body(appointmentService
                .getWeekScheduleByClinic(parsedClinicID, parsedDateOfMonday, parsedConditionStatus));
    }
}
