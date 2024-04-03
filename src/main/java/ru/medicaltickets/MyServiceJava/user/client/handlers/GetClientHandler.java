package ru.medicaltickets.MyServiceJava.user.client.handlers;

import org.springframework.http.ResponseEntity;
import ru.medicaltickets.MyServiceJava.user.AbstractUser;
import ru.medicaltickets.MyServiceJava.user.client.ClientService;

import java.util.Optional;

public class GetClientHandler {
    private final ClientService userService;

    public GetClientHandler(ClientService userService) {
        this.userService = userService;
    }

//    public ResponseEntity<?> handle(Long userID) {
//        Optional<AbstractUser> optionalUser = userService.getUser(userID);
//
//        return optionalUser.map(ResponseEntity::ok)
//                .orElse(ResponseEntity.notFound().build());
//    }
}
