package user.doctor;

import org.springframework.stereotype.Service;

@Service
public class DoctorService {
    private DoctorDAO doctorDAO;

    public DoctorService(DoctorDAO doctorDAO) {
        this.doctorDAO = doctorDAO;
    }
}
