package ru.medicaltickets.MyServiceJava.client.handlers;

import org.springframework.http.ResponseEntity;
import ru.medicaltickets.MyServiceJava.global.abstracts.AbstractSubject;
import ru.medicaltickets.MyServiceJava.client.ClientService;

import java.util.List;

public class GetAllClientsHandler {
    private final ClientService userService;

    public GetAllClientsHandler(ClientService userService) {
        this.userService = userService;
    }

//    public List<AbstractSubject> handle() {
//        List<AbstractSubject> listUsers = userService.getAllUsers().map(ResponseEntity::ok)
//                .orElse(ResponseEntity.notFound().build());
//        return listUsers;
//        }
}
