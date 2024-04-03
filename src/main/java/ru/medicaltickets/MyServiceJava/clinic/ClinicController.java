package ru.medicaltickets.MyServiceJava.clinic;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.medicaltickets.MyServiceJava.user.client.handlers.GetAllClientsHandler;
import ru.medicaltickets.MyServiceJava.user.client.handlers.PostClientHandler;
import ru.medicaltickets.MyServiceJava.clinic.handlers.GetClinicHandler;

@RequestMapping("clinic")
@RestController
public class ClinicController {
    private final GetAllClientsHandler getAllClientsHandler;
    private final GetClinicHandler getClinicHandler;
    private final PostClientHandler postClientHandler;

    public ClinicController(GetAllClientsHandler getAllClientsHandler, GetClinicHandler getClinicHandler,
                            PostClientHandler postClientHandler) {
        this.getAllClientsHandler = getAllClientsHandler;
        this.getClinicHandler = getClinicHandler;
        this.postClientHandler = postClientHandler;
    }
}
