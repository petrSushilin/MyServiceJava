package user.client;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import user.client.handlers.GetAllClientsHandler;
import user.client.handlers.GetClientHandler;
import user.client.handlers.PostClientHandler;

@RequestMapping("client")
@RestController
public class ClientController {
    private GetAllClientsHandler getAllUsersHandler;
    private GetClientHandler getUserHandler;
    private PostClientHandler postClientHandler;

    public ClientController(GetAllClientsHandler getAllUsersHandler, GetClientHandler getUserHandler,
                            PostClientHandler postClientHandler) {
        this.getAllUsersHandler = getAllUsersHandler;
        this.getUserHandler = getUserHandler;
        this.postClientHandler = postClientHandler;
    }

    //    @GetMapping("/all")
//    public ResponseEntity<?> getAllUsers() {
//        return getAllUsersHandler.handle();
//    }

//    @GetMapping("/{userID}")
//    public ResponseEntity<?> getUser(@RequestParam Long userID) {
//        return getUserHandler.handle(userID);
//    }
}
