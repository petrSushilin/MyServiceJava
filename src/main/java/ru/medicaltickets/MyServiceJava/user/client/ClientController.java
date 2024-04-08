package ru.medicaltickets.MyServiceJava.user.client;

import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.medicaltickets.MyServiceJava.user.client.handlers.*;

@RequestMapping("client")
@RestController
public class ClientController {
    private final GetByFullNameHandler getByFullNameHandler;
    private final GetByGenderAndBirthdateHandler getByGenderAndBirthdateHandler;
    private final GetByLastNameAndGenderHandler getByLastNameAndGenderHandler;
    private final GetElderThenHandler getElderThenHandler;
    private final GetPensionersHandler getPensionersHandler;
    private final GetSingleClientHandler getSingleClientHandler;
    private final GetYoungerThenHandler getYoungerThenHandler;
    private final PostClientHandler postClientHandler;
    private final UpdateClientHandler updateClientHandler;

    public ClientController(GetByFullNameHandler getByFullNameHandler,
                            GetByGenderAndBirthdateHandler getByGenderAndBirthdateHandler,
                            GetByLastNameAndGenderHandler getByLastNameAndGenderHandler,
                            GetElderThenHandler getElderThenHandler,
                            GetPensionersHandler getPensionersHandler,
                            GetSingleClientHandler getSingleClientHandler,
                            GetYoungerThenHandler getYoungerThenHandler,
                            PostClientHandler postClientHandler,
                            UpdateClientHandler updateClientHandler) {
        this.getByFullNameHandler = getByFullNameHandler;
        this.getByGenderAndBirthdateHandler = getByGenderAndBirthdateHandler;
        this.getByLastNameAndGenderHandler = getByLastNameAndGenderHandler;
        this.getElderThenHandler = getElderThenHandler;
        this.getPensionersHandler = getPensionersHandler;
        this.getSingleClientHandler = getSingleClientHandler;
        this.getYoungerThenHandler = getYoungerThenHandler;
        this.postClientHandler = postClientHandler;
        this.updateClientHandler = updateClientHandler;
    }

    @GetMapping("/client{clientID}")
    public ResponseEntity<?> getSingle(@PathVariable("clientID") String clientID) {
        return getSingleClientHandler.handle(clientID);
    }

    @GetMapping("/{firstName}.{lastName}")
    public ResponseEntity<?> getByFullName(@Valid @PathVariable("firstName") String firstName,
                                           @Valid @PathVariable("lastName") String lastName) {
        return getByFullNameHandler.handle(firstName, lastName);
    }

    @GetMapping("/{gender}/birthdate")
    public ResponseEntity<?> getByGenderAndBirthdate(@PathVariable("gender") String gender,
                                                     @RequestParam String birthdate) {
        return getByGenderAndBirthdateHandler.handle(gender, birthdate);
    }

    @GetMapping("/{gender}/{lastName}")
    public ResponseEntity<?> getByLastNameAndGender(@Valid @PathVariable("lastName") String lastName,
                                                    @PathVariable("gender") String gender) {
        return getByLastNameAndGenderHandler.handle(lastName, gender);
    }

    @GetMapping("/elder/{birthdate}")
    public ResponseEntity<?> getElderThen(@Valid @PathVariable("birthdate") String birthdate) {
        return getElderThenHandler.handle(birthdate);
    }

    @GetMapping("/elder/{gender}/{birthdate}")
    public ResponseEntity<?> getElderThen(@PathVariable("gender") String gender,
                                          @Valid @PathVariable("birthdate") String birthdate) {
        return getElderThenHandler.handle(gender, birthdate);
    }

    @GetMapping("/younger/{birthdate}")
    public ResponseEntity<?> getYoungerThen(@Valid @PathVariable("birthdate") String birthdate) {
        return getYoungerThenHandler.handle(birthdate);
    }

    @GetMapping("/younger/{gender}/{birthdate}")
    public ResponseEntity<?> getYoungerThen(@PathVariable("gender") String gender,
                                            @Valid @PathVariable("birthdate") String birthdate) {
        return getYoungerThenHandler.handle(gender, birthdate);
    }

    @GetMapping("/pensioners")
    public ResponseEntity<?> getPensioners() {
        return getPensionersHandler.handle();
    }

    @PostMapping("/new")
    public ResponseEntity<?> post(@Valid @RequestBody Client client) {
        return postClientHandler.handle(client);
    }

    @PostMapping("/client{clientID}")
    public ResponseEntity<?> update(@PathVariable("clientID") String clientID,
                                    @RequestBody Client client) {
        return updateClientHandler.handle(clientID, client);
    }
}
