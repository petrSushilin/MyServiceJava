package ru.medicaltickets.MyServiceJava.client.handlers;

import org.springframework.http.ResponseEntity;
import ru.medicaltickets.MyServiceJava.global.abstracts.AbstractSubject;
import ru.medicaltickets.MyServiceJava.client.ClientService;

import java.util.Optional;

public class GetClientHandler {
    private final ClientService userService;

    public GetClientHandler(ClientService userService) {
        this.userService = userService;
    }

    public ResponseEntity<?> handle(Long userID) {
        Optional<AbstractSubject> optionalUser = userService.getUser(userID);

        return optionalUser.map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
}
