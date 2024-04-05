package ru.medicaltickets.MyServiceJava.visit.appointment.handlers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import ru.medicaltickets.MyServiceJava.visit.appointment.AppointmentService;
import ru.medicaltickets.MyServiceJava.visit.appointment.enums.ConditionStatus;

import java.time.LocalDate;
import java.util.List;

public class GetMonthScheduleDoctorAppointmentsHandler {
    private final AppointmentService appointmentService;

    public GetMonthScheduleDoctorAppointmentsHandler(AppointmentService appointmentService) {
        this.appointmentService = appointmentService;
    }

    public ResponseEntity<List<?>> handle(String clinicID, String doctorID, String date, String conditionStatus) {
        Long parsedClinicID = Long.valueOf(clinicID);
        Long parsedDoctorID = Long.valueOf(doctorID);
        LocalDate parsedDate = LocalDate.parse(date);
        ConditionStatus parsedConditionStatus = ConditionStatus.valueOf(conditionStatus);
        return ResponseEntity.status(HttpStatus.OK).body(appointmentService
                .getMonthScheduleByDoctor(parsedClinicID, parsedDoctorID, parsedDate, parsedConditionStatus));
    }
}
