package ru.medicaltickets.MyServiceJava.clinic;

import org.springframework.stereotype.Service;
import ru.medicaltickets.MyServiceJava.clinic.enums.City;
import ru.medicaltickets.MyServiceJava.clinic.enums.Region;

import java.util.List;

@Service
public class ClinicService {
    private final ClinicDAO clinicDAO;

    public ClinicService(ClinicDAO clinicDAO) {
        this.clinicDAO = clinicDAO;
    }

    public Clinic getSingle(Long clinicID) {
        return clinicDAO.getSingle(clinicID);
    }

    public List<Clinic> getByName(String officialName) {
        return clinicDAO.getByName(officialName);
    }

    public List<Clinic> getByLocation(Region region) {
        return clinicDAO.getByLocation(region);
    }

    public List<Clinic> getByLocation(Region region, City city) {
        return clinicDAO.getByLocation(region, city);
    }

    public int post(Clinic clinic) {
        return clinicDAO.post(clinic);
    }

    public int update(Clinic clinic) {
        return clinicDAO.update(clinic);
    }
}
