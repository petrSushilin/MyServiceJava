package ru.medicaltickets.MyServiceJava.visit.appointment;

import org.jooq.DSLContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import ru.medicaltickets.MyServiceJava.visit.appointment.handlers.*;

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
    public GetClientAppointmentsHandler getClientAppointmentsHandler(AppointmentService appointmentService) {
        return new GetClientAppointmentsHandler(appointmentService);
    }

    @Bean
    public GetClinicAndDoctorSpecialityAppointmentsHandler getClinicAndDoctorSpecialityAppointmentsHandler(AppointmentService appointmentService) {
        return new GetClinicAndDoctorSpecialityAppointmentsHandler(appointmentService);
    }

    @Bean
    public GetClinicAppointmentsHandler getClinicAppointmentsHandler(AppointmentService appointmentService) {
        return new GetClinicAppointmentsHandler(appointmentService);
    }

    @Bean
    public GetDoctorAppointmentsHandler getDoctorAppointmentsHandler(AppointmentService appointmentService) {
        return new GetDoctorAppointmentsHandler(appointmentService);
    }

    @Bean
    public GetMonthScheduleClientAppointmentsHandler getMonthScheduleClientAppointmentsHandler(AppointmentService appointmentService) {
        return new GetMonthScheduleClientAppointmentsHandler(appointmentService);
    }

    @Bean
    public GetMonthScheduleClinicAndDoctorSpecialtyAppointmentsHandler getMonthScheduleClinicAndDoctorSpecialtyAppointmentsHandler(AppointmentService appointmentService) {
        return new GetMonthScheduleClinicAndDoctorSpecialtyAppointmentsHandler(appointmentService);
    }

    @Bean
    public GetMonthScheduleClinicAppointmentsHandler getMonthScheduleClinicAppointmentsHandler(AppointmentService appointmentService) {
        return new GetMonthScheduleClinicAppointmentsHandler(appointmentService);
    }

    @Bean
    public GetMonthScheduleDoctorAppointmentsHandler getMonthScheduleDoctorAppointmentsHandler(AppointmentService appointmentService) {
        return new GetMonthScheduleDoctorAppointmentsHandler(appointmentService);
    }

    @Bean
    public GetSingleAppointmentHandler getSingleAppointmentHandler(AppointmentService appointmentService) {
        return new GetSingleAppointmentHandler(appointmentService);
    }

    @Bean
    public GetWeekScheduleClientAppointmentsHandler getWeekScheduleClientAppointmentsHandler(AppointmentService appointmentService) {
        return new GetWeekScheduleClientAppointmentsHandler(appointmentService);
    }

    @Bean
    public GetWeekScheduleClinicAndDoctorSpecialtyAppointmentsHandler getWeekScheduleClinicAndDoctorSpecialtyAppointmentsHandler(AppointmentService appointmentService) {
        return new GetWeekScheduleClinicAndDoctorSpecialtyAppointmentsHandler(appointmentService);
    }

    @Bean
    public GetWeekScheduleClinicAppointmentsHandler getWeekScheduleClinicAppointmentsHandler(AppointmentService appointmentService) {
        return new GetWeekScheduleClinicAppointmentsHandler(appointmentService);
    }

    @Bean
    public GetWeekScheduleDoctorAppointmentsHandler getWeekScheduleDoctorAppointmentsHandler(AppointmentService appointmentService) {
        return new GetWeekScheduleDoctorAppointmentsHandler(appointmentService);
    }

    @Bean
    public PostAppointmentHandler postAppointmentHandler(AppointmentService appointmentService) {
        return new PostAppointmentHandler(appointmentService);
    }

    @Bean
    public UpdateAppointmentHandler updateAppointmentHandler(AppointmentService appointmentService) {
        return new UpdateAppointmentHandler(appointmentService);
    }

    @Bean
    public AppointmentController appointmentController(GetClientAppointmentsHandler getClientAppointmentsHandler,
                                                       GetClinicAndDoctorSpecialityAppointmentsHandler getClinicAndDoctorSpecialityAppointmentsHandler,
                                                       GetClinicAppointmentsHandler getClinicAppointmentsHandler,
                                                       GetDoctorAppointmentsHandler getDoctorAppointmentsHandler,
                                                       GetMonthScheduleClientAppointmentsHandler getMonthScheduleClientAppointmentsHandler,
                                                       GetMonthScheduleClinicAndDoctorSpecialtyAppointmentsHandler getMonthScheduleClinicAndDoctorSpecialtyAppointmentsHandler,
                                                       GetMonthScheduleClinicAppointmentsHandler getMonthScheduleClinicAppointmentsHandler,
                                                       GetMonthScheduleDoctorAppointmentsHandler getMonthScheduleDoctorAppointmentsHandler,
                                                       GetSingleAppointmentHandler getSingleAppointmentHandler,
                                                       GetWeekScheduleClientAppointmentsHandler getWeekScheduleClientAppointmentsHandler,
                                                       GetWeekScheduleClinicAndDoctorSpecialtyAppointmentsHandler getWeekScheduleClinicAndDoctorSpecialtyAppointmentsHandler,
                                                       GetWeekScheduleClinicAppointmentsHandler getWeekScheduleClinicAppointmentsHandler,
                                                       GetWeekScheduleDoctorAppointmentsHandler getWeekScheduleDoctorAppointmentsHandler,
                                                       PostAppointmentHandler postAppointmentHandler,
                                                       UpdateAppointmentHandler updateAppointmentHandler) {
        return new AppointmentController(getClientAppointmentsHandler,
                                            getClinicAndDoctorSpecialityAppointmentsHandler,
                                            getClinicAppointmentsHandler,
                                            getDoctorAppointmentsHandler,
                                            getMonthScheduleClientAppointmentsHandler,
                                            getMonthScheduleClinicAndDoctorSpecialtyAppointmentsHandler,
                                            getMonthScheduleClinicAppointmentsHandler,
                                            getMonthScheduleDoctorAppointmentsHandler,
                                            getSingleAppointmentHandler,
                                            getWeekScheduleClientAppointmentsHandler,
                                            getWeekScheduleClinicAndDoctorSpecialtyAppointmentsHandler,
                                            getWeekScheduleClinicAppointmentsHandler,
                                            getWeekScheduleDoctorAppointmentsHandler,
                                            postAppointmentHandler,
                                            updateAppointmentHandler);
    }
}
