package user.client.handlers;


import org.springframework.http.ResponseEntity;
import user.client.Client;
import user.client.ClientService;

public class PostClientHandler {
    private final ClientService clientService;

    public PostClientHandler(ClientService userService) {
        this.clientService = userService;
    }

    public ResponseEntity<?> handle(Client client) {
        return clientService.postUser();
    }
}
