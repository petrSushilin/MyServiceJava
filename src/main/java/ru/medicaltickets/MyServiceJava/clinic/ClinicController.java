package ru.medicaltickets.MyServiceJava.clinic;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.medicaltickets.MyServiceJava.user.client.handlers.GetByFullNameHandler;
import ru.medicaltickets.MyServiceJava.user.client.handlers.PostClientHandler;
import ru.medicaltickets.MyServiceJava.clinic.handlers.GetClinicHandler;

@RequestMapping("clinic")
@RestController
public class ClinicController {
    private final GetByFullNameHandler getByFullNameHandler;
    private final GetClinicHandler getClinicHandler;
    private final PostClientHandler postClientHandler;

    public ClinicController(GetByFullNameHandler getByFullNameHandler, GetClinicHandler getClinicHandler,
                            PostClientHandler postClientHandler) {
        this.getByFullNameHandler = getByFullNameHandler;
        this.getClinicHandler = getClinicHandler;
        this.postClientHandler = postClientHandler;
    }
}
