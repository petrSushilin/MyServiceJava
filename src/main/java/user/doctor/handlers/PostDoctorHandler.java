package user.doctor.handlers;

import user.doctor.DoctorService;

public class PostDoctorHandler {
    private DoctorService doctorService;

    public PostDoctorHandler(DoctorService doctorService) {
        this.doctorService = doctorService;
    }
}
