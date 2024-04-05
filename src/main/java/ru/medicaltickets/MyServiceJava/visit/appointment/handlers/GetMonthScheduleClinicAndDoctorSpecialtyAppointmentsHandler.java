package ru.medicaltickets.MyServiceJava.visit.appointment.handlers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import ru.medicaltickets.MyServiceJava.user.doctor.enums.DoctorSpecialty;
import ru.medicaltickets.MyServiceJava.visit.appointment.AppointmentService;
import ru.medicaltickets.MyServiceJava.visit.appointment.enums.ConditionStatus;

import java.time.LocalDate;
import java.util.List;

public class GetMonthScheduleClinicAndDoctorSpecialtyAppointmentsHandler {
    private final AppointmentService appointmentService;

    public GetMonthScheduleClinicAndDoctorSpecialtyAppointmentsHandler(AppointmentService appointmentService) {
        this.appointmentService = appointmentService;
    }

    public ResponseEntity<List<?>> handle(String clinicID, String doctorSpecialty, String date, String conditionStatus) {
        Long parsedClinicID = Long.valueOf(clinicID);
        DoctorSpecialty parsedDoctorSpecialty = DoctorSpecialty.valueOf(doctorSpecialty);
        LocalDate parsedDate = LocalDate.parse(date);
        ConditionStatus parsedConditionStatus = ConditionStatus.valueOf(conditionStatus);
        return ResponseEntity.status(HttpStatus.OK).body(appointmentService
                .getMonthScheduleByDoctorSpecialty(parsedClinicID, parsedDoctorSpecialty, parsedDate, parsedConditionStatus));
    }
}
