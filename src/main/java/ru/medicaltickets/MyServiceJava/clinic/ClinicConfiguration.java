package ru.medicaltickets.MyServiceJava.clinic;

import org.jooq.DSLContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import ru.medicaltickets.MyServiceJava.clinic.handlers.GetAllClinicsHandler;
import ru.medicaltickets.MyServiceJava.clinic.handlers.GetClinicHandler;
import ru.medicaltickets.MyServiceJava.clinic.handlers.PostClinicHandler;

@Configuration
public class ClinicConfiguration {
    @Bean
    public ClinicDAO clinicDAO (DSLContext context) {
        return new ClinicDAO(context);
    }

    @Bean
    public ClinicService clinicService (ClinicDAO clinicDAO) {
        return new ClinicService(clinicDAO);
    }

    @Bean
    public GetAllClinicsHandler getAllClinicsHandler (ClinicService clinicService) {
        return new GetAllClinicsHandler(clinicService);
    }

    @Bean
    public GetClinicHandler getClinicHandler (ClinicService clinicService) {
        return new GetClinicHandler(clinicService);
    }

    @Bean
    public PostClinicHandler postClinicHandler (ClinicService clinicService) {
        return new PostClinicHandler(clinicService);
    }
}
