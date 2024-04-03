package ru.medicaltickets.MyServiceJava.user.client;

import org.springframework.http.ResponseEntity;

import java.util.List;

public class ClientService {
    private final ClientDAO clientDAO;

    public ClientService(ClientDAO userDAO) {
        this.clientDAO = userDAO;
    }

/*
----------------------------    GLOBAL METHODS    ----------------------------
*/

    private boolean isClientExist(Long userID) {
        return clientDAO.isExist(userID);
    }

/*
----------------------------    GET METHODS    ----------------------------
*/

    public Client getUser(Long userID) {
        return clientDAO.getBy(userID);
    }

    public List<Client> getAllUsers() {
        return clientDAO.getAll();
    }

/*
----------------------------    POST METHODS    ----------------------------
*/

    public ResponseEntity<?> postUser() {
        return null;
    }
}