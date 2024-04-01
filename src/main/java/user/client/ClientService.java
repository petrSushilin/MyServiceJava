package ru.medicaltickets.MyServiceJava.client;

import org.springframework.http.ResponseEntity;
import ru.medicaltickets.MyServiceJava.global.abstracts.AbstractSubject;

import java.util.List;
import java.util.Optional;

public class ClientService {
    private final ClientDAO clientDAO;

    public ClientService(ClientDAO userDAO) {
        this.clientDAO = userDAO;
    }

/*
----------------------------    GLOBAL METHODS    ----------------------------
*/

    private boolean isUserExists(Long userID) {
        return clientDAO.isClientExists(userID);
    }

/*
----------------------------    GET METHODS    ----------------------------
*/

    public Optional<AbstractSubject> getUser(Long userID) {
        if (!isUserExists(userID)) {
            throw new RuntimeException("User is not found.");
        }
        return Optional.ofNullable(clientDAO.getUserByID(userID));
    }

    public List<AbstractSubject> getAllUsers() {
        return clientDAO.getAll();
    }

/*
----------------------------    POST METHODS    ----------------------------
*/

    public ResponseEntity<?> postUser() {
        return null;
    }
}