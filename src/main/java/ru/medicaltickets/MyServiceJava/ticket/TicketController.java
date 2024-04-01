package ru.medicaltickets.MyServiceJava.ticket;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.medicaltickets.MyServiceJava.ticket.handlers.*;

@RequestMapping("ticket")
@RestController
public class TicketController {
    private GetAllTodayTicketsHandler getAllTodayTicketsHandler;
    private GetAllMonthTicketsHandler getAllMonthTicketsHandler;
    private GetAllTicketsByClientHandler getAllTicketsByClientHandler;
    private GetAllTicketsByClinicHandler getAllTicketsByClinicHandler;
    private GetTicketHandler getTicketHandler;
    private PostTicketHandler postTicketHandler;

    public TicketController(GetAllTodayTicketsHandler getAllTodayTicketsHandler, GetAllMonthTicketsHandler getAllMonthTicketsHandler,
                            GetAllTicketsByClientHandler getAllTicketsByClientHandler, GetAllTicketsByClinicHandler getAllTicketsByClinicHandler,
                            GetTicketHandler getTicketHandler, PostTicketHandler postTicketHandler) {
        this.getAllTodayTicketsHandler = getAllTodayTicketsHandler;
        this.getAllMonthTicketsHandler = getAllMonthTicketsHandler;
        this.getAllTicketsByClientHandler = getAllTicketsByClientHandler;
        this.getAllTicketsByClinicHandler = getAllTicketsByClinicHandler;
        this.getTicketHandler = getTicketHandler;
        this.postTicketHandler = postTicketHandler;
    }
}
