package user.doctor.handlers;

import user.doctor.DoctorService;

public class GetDoctorHandler {
    private DoctorService doctorService;

    public GetDoctorHandler(DoctorService doctorService) {
        this.doctorService = doctorService;
    }
}
