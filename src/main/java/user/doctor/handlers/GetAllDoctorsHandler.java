package user.doctor.handlers;

import user.doctor.DoctorService;

public class GetAllDoctorsHandler {
    private DoctorService doctorService;

    public GetAllDoctorsHandler(DoctorService doctorService) {
        this.doctorService = doctorService;
    }
}
