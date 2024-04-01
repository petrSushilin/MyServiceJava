package ru.medicaltickets.MyServiceJava.doctor;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.medicaltickets.MyServiceJava.doctor.handlers.GetAllDoctorsHandler;
import ru.medicaltickets.MyServiceJava.doctor.handlers.GetDoctorHandler;
import ru.medicaltickets.MyServiceJava.doctor.handlers.PostDoctorHandler;

@RequestMapping("doctor")
@RestController
public class DoctorController {
    private GetAllDoctorsHandler getAllDoctorsHandler;
    private GetDoctorHandler getDoctorHandler;
    private PostDoctorHandler postDoctorHandler;

    public DoctorController(GetAllDoctorsHandler getAllDoctorsHandler, GetDoctorHandler getDoctorHandler, PostDoctorHandler postDoctorHandler) {
        this.getAllDoctorsHandler = getAllDoctorsHandler;
        this.getDoctorHandler = getDoctorHandler;
        this.postDoctorHandler = postDoctorHandler;
    }
}
