package ru.medicaltickets.MyServiceJava.visit.appointment.handlers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import ru.medicaltickets.MyServiceJava.user.doctor.enums.DoctorSpecialty;
import ru.medicaltickets.MyServiceJava.visit.appointment.AppointmentService;
import ru.medicaltickets.MyServiceJava.visit.appointment.enums.ConditionStatus;

import java.time.LocalDate;
import java.util.List;

public class GetClinicAndDoctorSpecialityAppointmentsHandler {
    private final AppointmentService appointmentService;

    public GetClinicAndDoctorSpecialityAppointmentsHandler(AppointmentService appointmentService) {
        this.appointmentService = appointmentService;
    }

    public ResponseEntity<List<?>> handle(String clinicID, String doctorSpecialty, String dateOfVisit, String conditionStatus) {
        Long parsedClinicID = Long.valueOf(clinicID);
        DoctorSpecialty parsedDoctorSpecialty = DoctorSpecialty.valueOf(doctorSpecialty);
        LocalDate parsedDateOfVisit = LocalDate.parse(dateOfVisit);
        ConditionStatus parsedConditionStatus = ConditionStatus.valueOf(conditionStatus);
        return ResponseEntity.status(HttpStatus.OK).body(appointmentService.getScheduleByDoctorSpecialty(parsedClinicID,
                parsedDoctorSpecialty, parsedDateOfVisit, parsedConditionStatus));
    }
}
