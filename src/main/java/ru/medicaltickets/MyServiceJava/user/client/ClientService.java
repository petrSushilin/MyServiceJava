package ru.medicaltickets.MyServiceJava.user.client;

import org.springframework.http.ResponseEntity;
import ru.medicaltickets.MyServiceJava.user.doctor.Doctor;
import ru.medicaltickets.MyServiceJava.user.doctor.enums.DoctorSpecialty;
import ru.medicaltickets.MyServiceJava.user.enums.Gender;

import java.time.LocalDate;
import java.util.List;

public class ClientService {
    private final ClientDAO clientDAO;

    public ClientService(ClientDAO clientDAO) {
        this.clientDAO = clientDAO;
    }

    public Client getSingle(Long doctorID) {
        return clientDAO.getSingle(doctorID);
    }

    public List<Client> getByFullName(String fullName) {
        return clientDAO.getByFullName(fullName);
    }

    public List<Client> getByLastNameAndGender(String lastName, Gender gender) {
        return clientDAO.getByLastNameAndGender(lastName, gender);
    }

    public List<Client> getByGenderAndBirthdate (Gender gender, LocalDate birthdate) {
        return clientDAO.getByGenderAndBirthdate(gender, birthdate);
    }

    public List<Client> getByFullNameAndBirthdate (String fullName, LocalDate birthdate) {
        return clientDAO.getByFullNameAndBirthdate(fullName, birthdate);
    }

    public List<Client> getElderThen (LocalDate birthdate) {
        return clientDAO.getElderThen(birthdate);
    }

    public List<Client> getElderThen (LocalDate birthdate, Gender gender) {
        return clientDAO.getElderThen(birthdate, gender);
    }

    public List<Client> getYoungerThen (LocalDate birthdate) {
        return clientDAO.getYoungerThen(birthdate);
    }

    public List<Client> getYoungerThen (LocalDate birthdate, Gender gender) {
        return clientDAO.getYoungerThen(birthdate, gender);
    }

    public List<Client> getPensioners() {
        return clientDAO.getPensioners(LocalDate.now());
    }

    public int update(Client client) {
        return clientDAO.update(client);
    }

    public int post(Client client) {
        return clientDAO.post(client);
    }
}