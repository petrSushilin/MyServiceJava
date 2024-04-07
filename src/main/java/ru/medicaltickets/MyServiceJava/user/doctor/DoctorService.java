package ru.medicaltickets.MyServiceJava.user.doctor;

import org.springframework.stereotype.Service;
import ru.medicaltickets.MyServiceJava.user.doctor.enums.DoctorSpecialty;

import java.util.List;

@Service
public class DoctorService {
    private final DoctorDAO doctorDAO;

    public DoctorService(DoctorDAO doctorDAO) {
        this.doctorDAO = doctorDAO;
    }

    public Doctor getSingle(Long doctorID) {
        return doctorDAO.getSingle(doctorID);
    }

    public List<Doctor> getByFullName(String fullName) {
        return doctorDAO.getByFullName(fullName);
    }

    public List<Doctor> getBySpecialty(DoctorSpecialty doctorSpecialty) {
        return doctorDAO.getWithSpecialty(doctorSpecialty);
    }

    public List<Doctor> getBySpecialty(DoctorSpecialty doctorSpecialty, int experience) {
        return doctorDAO.getWithSpecialty(doctorSpecialty, experience);
    }

    public int update(Doctor doctor) {
        return doctorDAO.update(doctor);
    }

    public int post(Doctor doctor) {
        return doctorDAO.post(doctor);
    }
}
