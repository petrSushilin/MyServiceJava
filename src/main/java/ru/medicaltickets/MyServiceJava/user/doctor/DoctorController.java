package ru.medicaltickets.MyServiceJava.user.doctor;

import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import ru.medicaltickets.MyServiceJava.user.doctor.handlers.*;

@RequestMapping("doctors")
@RestController
@Validated
public class DoctorController {
    private final GetDoctorHandler getDoctorHandler;
    private final GetDoctorsFullNameHandler getDoctorsFullNameHandler;
    private final GetDoctorsSpecialtyHandler getDoctorsSpecialtyHandler;
    private final GetDoctorsSpecialtyAndExperienceHandler getDoctorsSpecialtyAndExperienceHandler;
    private final PostDoctorHandler postDoctorHandler;
    private final UpdateDoctorHandler updateDoctorHandler;

    public DoctorController(GetDoctorHandler getDoctorHandler, GetDoctorsFullNameHandler getDoctorsFullNameHandler,
                            GetDoctorsSpecialtyHandler getDoctorsSpecialtyHandler,
                            GetDoctorsSpecialtyAndExperienceHandler getDoctorsSpecialtyAndExperienceHandler,
                            PostDoctorHandler postDoctorHandler, UpdateDoctorHandler updateDoctorHandler) {
        this.getDoctorHandler = getDoctorHandler;
        this.getDoctorsFullNameHandler = getDoctorsFullNameHandler;
        this.getDoctorsSpecialtyHandler = getDoctorsSpecialtyHandler;
        this.getDoctorsSpecialtyAndExperienceHandler = getDoctorsSpecialtyAndExperienceHandler;
        this.postDoctorHandler = postDoctorHandler;
        this.updateDoctorHandler = updateDoctorHandler;
    }

    @GetMapping("/doctor{doctorID}")
    public ResponseEntity<?> getSingle(@PathVariable("doctorID") String doctorID) {
        return getDoctorHandler.handle(doctorID);
    }

    @GetMapping("/doctor")
    public ResponseEntity<?> getByFullName(@Valid @RequestParam String firstName,
                                           @Valid @RequestParam String lastName) {
        return getDoctorsFullNameHandler.handle(firstName, lastName);
    }

    @GetMapping("/specialty")
    public ResponseEntity<?> getBySpecialtyAndExperience(@RequestParam String doctorSpecialty,
                                                         @RequestParam String experience) {
        return getDoctorsSpecialtyAndExperienceHandler.handle(doctorSpecialty, experience);
    }

    @GetMapping("/specialty")
    public ResponseEntity<?> getBySpecialty(@RequestParam String doctorSpecialty) {
        return getDoctorsSpecialtyHandler.handle(doctorSpecialty);
    }

    @PostMapping("/new")
    public ResponseEntity<?> post(@Valid @RequestBody Doctor doctor) {
        return postDoctorHandler.handle(doctor);
    }

    @PostMapping("/doctor{doctorID}")
    public ResponseEntity<?> update(@PathVariable("doctorID") String doctorID,
                                    @RequestBody Doctor doctor) {
        return updateDoctorHandler.handle(doctorID, doctor);
    }
}
