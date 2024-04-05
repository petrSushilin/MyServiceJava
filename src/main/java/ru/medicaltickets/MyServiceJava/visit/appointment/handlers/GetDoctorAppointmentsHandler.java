package ru.medicaltickets.MyServiceJava.visit.appointment.handlers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import ru.medicaltickets.MyServiceJava.visit.appointment.AppointmentService;
import ru.medicaltickets.MyServiceJava.visit.appointment.enums.ConditionStatus;

import java.time.LocalDate;
import java.util.List;

public class GetDoctorAppointmentsHandler {
    private final AppointmentService appointmentService;

    public GetDoctorAppointmentsHandler(AppointmentService appointmentService) {
        this.appointmentService = appointmentService;
    }

    public ResponseEntity<List<?>> handle(String clinicID, String doctorID, String dateOfVisit, String conditionStatus) {
        Long parsedClinicID = Long.valueOf(clinicID);
        Long parsedDoctorID = Long.valueOf(doctorID);
        LocalDate parsedDateOfVisit = LocalDate.parse(dateOfVisit);
        ConditionStatus parsedConditionStatus = ConditionStatus.valueOf(conditionStatus);
        return ResponseEntity.status(HttpStatus.OK).body(appointmentService.getScheduleByDoctor(parsedClinicID, parsedDoctorID,
                parsedDateOfVisit, parsedConditionStatus));
    }
}
