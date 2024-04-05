package ru.medicaltickets.MyServiceJava.visit.ticket;

import org.jooq.DSLContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import ru.medicaltickets.MyServiceJava.visit.ticket.handlers.*;

@Configuration
public class TicketConfiguration {
    @Bean
    public TicketDAO ticketDAO(DSLContext context) {
        return new TicketDAO(context);
    }

    @Bean
    public TicketService ticketService(TicketDAO ticketDAO) {
        return new TicketService(ticketDAO);
    }

    @Bean
    public GetClinicAndDoctorsSpecialtyTicketsHandler getAllTicketsByClinicAndDoctorsSpecialty(TicketService ticketService) {
        return new GetClinicAndDoctorsSpecialtyTicketsHandler(ticketService);
    }

    @Bean
    public GetClinicTicketsHandler getAllTicketsByClinicHandler(TicketService ticketService) {
        return new GetClinicTicketsHandler(ticketService);
    }

    @Bean
    public GetDoctorTicketsHandler getAllTicketsByDoctorHandler(TicketService ticketService) {
        return new GetDoctorTicketsHandler(ticketService);
    }

    @Bean
    public GetMonthClinicTicketsHandler getAllMonthTicketsHandler(TicketService ticketService) {
        return new GetMonthClinicTicketsHandler(ticketService);
    }

    @Bean
    public GetMonthDoctorSpecialtyTicketsHandler getMonthDoctorSpecialtyTicketsHandler(TicketService ticketService) {
        return new GetMonthDoctorSpecialtyTicketsHandler(ticketService);
    }

    @Bean
    public GetSingleTicketHandler getTicketHandler(TicketService ticketService) {
        return new GetSingleTicketHandler(ticketService);
    }

    @Bean
    public GetWeekClinicAndDoctorsSpecialtyTicketsHandler getWeekClinicAndDoctorsSpecialtyTicketsHandler(TicketService ticketService) {
        return new GetWeekClinicAndDoctorsSpecialtyTicketsHandler(ticketService);
    }

    @Bean
    public GetWeekClinicTicketsHandler getAllWeekTicketsHandler(TicketService ticketService) {
        return new GetWeekClinicTicketsHandler(ticketService);
    }

    @Bean
    public PostTicketHandler postTicketHandler(TicketService ticketService) {
        return new PostTicketHandler(ticketService);
    }

    @Bean
    public UpdateTicketHandler updateTicketHandler(TicketService ticketService) {
        return new UpdateTicketHandler(ticketService);
    }

    @Bean
    public TicketController ticketController(GetClinicAndDoctorsSpecialtyTicketsHandler getClinicAndDoctorsSpecialtyTicketsHandler,
                                             GetClinicTicketsHandler getClinicTicketsHandler,
                                             GetDoctorTicketsHandler getDoctorTicketsHandler,
                                             GetMonthClinicTicketsHandler getMonthClinicTicketsHandler,
                                             GetMonthDoctorSpecialtyTicketsHandler getMonthDoctorSpecialtyTicketsHandler,
                                             GetSingleTicketHandler getSingleTicketHandler,
                                             GetWeekClinicAndDoctorsSpecialtyTicketsHandler getWeekClinicAndDoctorsSpecialtyTicketsHandler,
                                             GetWeekClinicTicketsHandler getWeekClinicTicketsHandler,
                                             PostTicketHandler postTicketHandler,
                                             UpdateTicketHandler updateTicketHandler) {
        return new TicketController(getClinicAndDoctorsSpecialtyTicketsHandler,
                                        getClinicTicketsHandler, getDoctorTicketsHandler,getMonthClinicTicketsHandler,
                                        getMonthDoctorSpecialtyTicketsHandler, getSingleTicketHandler,
                                        getWeekClinicAndDoctorsSpecialtyTicketsHandler, getWeekClinicTicketsHandler,
                                        postTicketHandler, updateTicketHandler);
    }
}
