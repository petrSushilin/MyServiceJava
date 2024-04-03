package ru.medicaltickets.MyServiceJava.visit.appointment;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.medicaltickets.MyServiceJava.visit.appointment.handlers.GetAppointmentHandler;
import ru.medicaltickets.MyServiceJava.visit.appointment.handlers.PostAppointmentHandler;
import ru.medicaltickets.MyServiceJava.visit.appointment.handlers.UpdateAppointmentHandler;

@RestController
@RequestMapping("appointment")
public class AppointmentController {
    private final GetAppointmentHandler getAppointmentHandler;
    private final PostAppointmentHandler postAppointmentHandler;
    private final UpdateAppointmentHandler updateAppointmentHandler;

    public AppointmentController(GetAppointmentHandler getAppointmentHandler, PostAppointmentHandler postAppointmentHandler,
                                 UpdateAppointmentHandler updateAppointmentHandler) {
        this.getAppointmentHandler = getAppointmentHandler;
        this.postAppointmentHandler = postAppointmentHandler;
        this.updateAppointmentHandler = updateAppointmentHandler;
    }


}
