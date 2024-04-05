package ru.medicaltickets.MyServiceJava.visit.appointment.handlers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import ru.medicaltickets.MyServiceJava.visit.appointment.AppointmentService;
import ru.medicaltickets.MyServiceJava.visit.appointment.enums.ConditionStatus;

import java.time.LocalDate;
import java.util.List;

public class GetWeekScheduleDoctorAppointmentsHandler {
    private final AppointmentService appointmentService;

    public GetWeekScheduleDoctorAppointmentsHandler(AppointmentService appointmentService) {
        this.appointmentService = appointmentService;
    }

    public ResponseEntity<List<?>> handle(String clinicID, String doctorID, String dateOfMonday, String conditionStatus) {
        Long parsedClinicID = Long.valueOf(clinicID);
        Long parsedDoctorID = Long.valueOf(doctorID);
        LocalDate parsedDateOfMonday = LocalDate.parse(dateOfMonday);
        ConditionStatus parsedConditionStatus = ConditionStatus.valueOf(conditionStatus);
        return ResponseEntity.status(HttpStatus.OK).body(appointmentService
                .getWeekScheduleByDoctor(parsedClinicID, parsedDoctorID, parsedDateOfMonday, parsedConditionStatus));
    }
}
