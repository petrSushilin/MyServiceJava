package ru.medicaltickets.MyServiceJava.user.client;

import org.jooq.DSLContext;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import ru.medicaltickets.MyServiceJava.user.client.handlers.GetAllClientsHandler;
import ru.medicaltickets.MyServiceJava.user.client.handlers.GetClientHandler;
import ru.medicaltickets.MyServiceJava.user.client.handlers.PostClientHandler;

@Configuration
public class ClientConfiguration {
    @Bean
    public ClientDAO clientDAO(DSLContext context){
        return new ClientDAO(context);
    }

    @Bean
    public ClientService clientService(ClientDAO clientDAO) {
        return new ClientService(clientDAO);
    }

    @Bean
    public GetAllClientsHandler getAllClientsHandler(ClientService clientService) {
        return new GetAllClientsHandler(clientService);
    }

    @Bean
    public GetClientHandler getClientHandler(ClientService clientService) {
        return new GetClientHandler(clientService);
    }

    @Bean
    public PostClientHandler postClientHandler(ClientService clientService) {
        return new PostClientHandler(clientService);
    }

    @Bean
    public ClientController clientController(GetAllClientsHandler getAllClientsHandler, GetClientHandler getClientHandler,
                                             PostClientHandler postClientHandler) {
        return new ClientController(getAllClientsHandler, getClientHandler, postClientHandler);
    }
}
