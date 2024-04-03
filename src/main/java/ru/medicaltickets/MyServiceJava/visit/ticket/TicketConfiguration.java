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
    public GetAllTodayTicketsHandler getAllTodayTicketsHandler(TicketService ticketService) {
        return new GetAllTodayTicketsHandler(ticketService);
    }

    @Bean
    public GetAllMonthTicketsHandler getAllMonthTicketsHandler(TicketService ticketService) {
        return new GetAllMonthTicketsHandler(ticketService);
    }

    @Bean
    public GetAllTicketsByClientHandler getAllTicketsByClientHandler(TicketService ticketService) {
        return new GetAllTicketsByClientHandler(ticketService);
    }

    @Bean
    public GetAllTicketsByClinicHandler getAllTicketsByClinicHandler(TicketService ticketService) {
        return new GetAllTicketsByClinicHandler(ticketService);
    }

    @Bean
    public GetTicketHandler getTicketHandler(TicketService ticketService) {
        return new GetTicketHandler(ticketService);
    }

    @Bean
    public PostTicketHandler postTicketHandler(TicketService ticketService) {
        return new PostTicketHandler(ticketService);
    }

    @Bean
    public TicketController ticketController(GetAllTodayTicketsHandler getAllTodayTicketsHandler,
                  GetAllMonthTicketsHandler getAllMonthTicketsHandler, GetAllTicketsByClientHandler getAllTicketsByClientHandler,
                  GetAllTicketsByClinicHandler getAllTicketsByClinicHandler, GetTicketHandler getTicketHandler,
                  PostTicketHandler postTicketHandler) {
        return new TicketController(getAllTodayTicketsHandler, getAllMonthTicketsHandler, getAllTicketsByClientHandler,
                                            getAllTicketsByClinicHandler, getTicketHandler, postTicketHandler);
    }
}
