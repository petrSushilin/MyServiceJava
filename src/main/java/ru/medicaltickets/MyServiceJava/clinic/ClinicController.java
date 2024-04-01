package ru.medicaltickets.MyServiceJava.clinic;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.medicaltickets.MyServiceJava.client.handlers.GetAllClientsHandler;
import ru.medicaltickets.MyServiceJava.client.handlers.PostClientHandler;
import ru.medicaltickets.MyServiceJava.clinic.handlers.GetClinicHandler;

@RequestMapping("clinic")
@RestController
public class ClinicController {
    private GetAllClientsHandler getAllClientsHandler;
    private GetClinicHandler getClinicHandler;
    private PostClientHandler postClientHandler;

    public ClinicController(GetAllClientsHandler getAllClientsHandler, GetClinicHandler getClinicHandler, PostClientHandler postClientHandler) {
        this.getAllClientsHandler = getAllClientsHandler;
        this.getClinicHandler = getClinicHandler;
        this.postClientHandler = postClientHandler;
    }
}