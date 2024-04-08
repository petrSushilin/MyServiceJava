package ru.medicaltickets.MyServiceJava.user.client;

import org.jooq.DSLContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import ru.medicaltickets.MyServiceJava.user.client.handlers.*;

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
    public GetByFullNameHandler getByFullNameHandler(ClientService clientService) {
        return new GetByFullNameHandler(clientService);
    }

    @Bean
    public GetByGenderAndBirthdateHandler getByGenderAndBirthdateHandler (ClientService clientService) {
        return new GetByGenderAndBirthdateHandler(clientService);
    }

    @Bean
    public GetByLastNameAndGenderHandler getByLastNameAndGenderHandler (ClientService clientService) {
        return new GetByLastNameAndGenderHandler(clientService);
    }

    @Bean
    public GetElderThenHandler getElderThenHandler (ClientService clientService) {
        return new GetElderThenHandler(clientService);
    }

    @Bean
    public GetPensionersHandler getPensionersHandler (ClientService clientService) {
        return new GetPensionersHandler(clientService);
    }

    @Bean
    public GetSingleClientHandler getClientHandler (ClientService clientService) {
        return new GetSingleClientHandler(clientService);
    }

    @Bean
    public GetYoungerThenHandler getYoungerThenHandler (ClientService clientService) {
        return new GetYoungerThenHandler(clientService);
    }

    @Bean
    public PostClientHandler postClientHandler (ClientService clientService) {
        return new PostClientHandler(clientService);
    }

    @Bean
    public UpdateClientHandler updateClientHandler (ClientService clientService) {
        return new UpdateClientHandler(clientService);
    }

    @Bean
    public ClientController clientController (GetByFullNameHandler getByFullNameHandler,
                                              GetByGenderAndBirthdateHandler getByGenderAndBirthdateHandler,
                                              GetByLastNameAndGenderHandler getByLastNameAndGenderHandler,
                                              GetElderThenHandler getElderThenHandler,
                                              GetPensionersHandler getPensionersHandler,
                                              GetSingleClientHandler getSingleClientHandler,
                                              GetYoungerThenHandler getYoungerThenHandler,
                                              PostClientHandler postClientHandler,
                                              UpdateClientHandler updateClientHandler) {
        return new ClientController(getByFullNameHandler, getByGenderAndBirthdateHandler, getByLastNameAndGenderHandler,
                getElderThenHandler, getPensionersHandler, getSingleClientHandler, getYoungerThenHandler,
                postClientHandler, updateClientHandler);
    }
}
