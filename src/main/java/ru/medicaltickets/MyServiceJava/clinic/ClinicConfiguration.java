package ru.medicaltickets.MyServiceJava.clinic;

import org.jooq.DSLContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import ru.medicaltickets.MyServiceJava.clinic.handlers.*;

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
    public GetByLocationHandler getByLocationHandler (ClinicService clinicService) {
        return new GetByLocationHandler(clinicService);
    }

    @Bean
    public GetByNameHandler getByNameHandler (ClinicService clinicService) {
        return new GetByNameHandler(clinicService);
    }

    @Bean
    public GetSingleHandler getSingleHandler (ClinicService clinicService) {
        return new GetSingleHandler(clinicService);
    }

    @Bean
    public PostClinicHandler postClinicHandler (ClinicService clinicService) {
        return new PostClinicHandler(clinicService);
    }

    @Bean
    public UpdateClinicHandler updateClinicHandler (ClinicService clinicService) {
        return new UpdateClinicHandler(clinicService);
    }

    @Bean
    public ClinicController clinicController (GetByLocationHandler getByLocationHandler, GetByNameHandler getByNameHandler,
                                              GetSingleHandler getSingleHandler, PostClinicHandler postClinicHandler,
                                              UpdateClinicHandler updateClinicHandler) {
        return new ClinicController(getByLocationHandler, getByNameHandler, getSingleHandler,
                                                                            postClinicHandler, updateClinicHandler);
    }
}
