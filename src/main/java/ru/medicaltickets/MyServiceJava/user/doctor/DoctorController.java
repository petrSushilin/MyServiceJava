package ru.medicaltickets.MyServiceJava.user.doctor;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.medicaltickets.MyServiceJava.user.doctor.handlers.GetAllDoctorsHandler;
import ru.medicaltickets.MyServiceJava.user.doctor.handlers.GetDoctorHandler;
import ru.medicaltickets.MyServiceJava.user.doctor.handlers.PostDoctorHandler;

@RequestMapping("doctor")
@RestController
public class DoctorController {
    private final GetAllDoctorsHandler getAllDoctorsHandler;
    private final GetDoctorHandler getDoctorHandler;
    private final PostDoctorHandler postDoctorHandler;

    public DoctorController(GetAllDoctorsHandler getAllDoctorsHandler, GetDoctorHandler getDoctorHandler, PostDoctorHandler postDoctorHandler) {
        this.getAllDoctorsHandler = getAllDoctorsHandler;
        this.getDoctorHandler = getDoctorHandler;
        this.postDoctorHandler = postDoctorHandler;
    }
}
