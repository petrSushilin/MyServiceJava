package user.doctor;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import user.doctor.handlers.GetAllDoctorsHandler;
import user.doctor.handlers.GetDoctorHandler;
import user.doctor.handlers.PostDoctorHandler;

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
