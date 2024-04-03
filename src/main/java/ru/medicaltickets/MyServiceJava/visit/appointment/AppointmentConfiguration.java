package ru.medicaltickets.MyServiceJava.visit.appointment;

import org.jooq.DSLContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import ru.medicaltickets.MyServiceJava.visit.appointment.handlers.GetAppointmentHandler;
import ru.medicaltickets.MyServiceJava.visit.appointment.handlers.PostAppointmentHandler;
import ru.medicaltickets.MyServiceJava.visit.appointment.handlers.UpdateAppointmentHandler;

@Configuration
public class AppointmentConfiguration {
    @Bean
    public AppointmentDAO appointmentDAO(DSLContext context) {
        return new AppointmentDAO(context);
    }

    @Bean
    public AppointmentService appointmentService(AppointmentDAO appointmentDAO) {
        return new AppointmentService(appointmentDAO);
    }

    @Bean
    public GetAppointmentHandler getAppointmentHandler(AppointmentService appointmentService) {
        return new GetAppointmentHandler(appointmentService);
    }

    @Bean
    public PostAppointmentHandler postAppointmentHandler(AppointmentService appointmentService) {
        return new PostAppointmentHandler(appointmentService);
    }

    @Bean
    public UpdateAppointmentHandler updateAppointmentHandler(AppointmentService appointmentService) {
        return new UpdateAppointmentHandler(appointmentService);
    }
}
