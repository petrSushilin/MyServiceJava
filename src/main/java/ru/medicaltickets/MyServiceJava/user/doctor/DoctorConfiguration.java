package ru.medicaltickets.MyServiceJava.user.doctor;

import org.jooq.DSLContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import ru.medicaltickets.MyServiceJava.user.doctor.handlers.*;

@Configuration
public class DoctorConfiguration {
    @Bean
    public DoctorDAO doctorDAO(DSLContext context) {
        return new DoctorDAO(context);
    }

    @Bean
    public DoctorService doctorService(DoctorDAO doctorDAO) {
        return new DoctorService(doctorDAO);
    }

    @Bean
    public GetDoctorHandler getDoctorHandler (DoctorService doctorService) {
        return new GetDoctorHandler(doctorService);
    }

    @Bean
    public GetDoctorsFullNameHandler getAllDoctorsHandler (DoctorService doctorService) {
        return new GetDoctorsFullNameHandler(doctorService);
    }

    @Bean
    public GetDoctorsSpecialtyAndExperienceHandler getDoctorsSpecialtyAndExperienceHandler (DoctorService doctorService) {
        return new GetDoctorsSpecialtyAndExperienceHandler(doctorService);
    }

    @Bean
    public GetDoctorsSpecialtyHandler getDoctorsSpecialtyHandler (DoctorService doctorService) {
        return new GetDoctorsSpecialtyHandler(doctorService);
    }

    @Bean
    public PostDoctorHandler postDoctorHandler (DoctorService doctorService) {
        return new PostDoctorHandler(doctorService);
    }

    @Bean
    public UpdateDoctorHandler updateDoctorHandler (DoctorService doctorService) {
        return new UpdateDoctorHandler(doctorService);
    }

    @Bean
    public DoctorController doctorController (GetDoctorHandler getDoctorHandler,
                                              GetDoctorsFullNameHandler getDoctorsFullNameHandler,
                                              GetDoctorsSpecialtyHandler getDoctorsSpecialtyHandler,
                                              GetDoctorsSpecialtyAndExperienceHandler getDoctorsSpecialtyAndExperienceHandler,
                                              PostDoctorHandler postDoctorHandler,
                                              UpdateDoctorHandler updateDoctorHandler) {
        return new DoctorController(getDoctorHandler, getDoctorsFullNameHandler, getDoctorsSpecialtyHandler,
                                        getDoctorsSpecialtyAndExperienceHandler, postDoctorHandler, updateDoctorHandler);
    }
}
