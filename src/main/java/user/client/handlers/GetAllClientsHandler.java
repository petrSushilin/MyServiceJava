package user.client.handlers;

import user.client.ClientService;

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
