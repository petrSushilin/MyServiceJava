package ru.medicaltickets.MyServiceJava.clinic;

import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import ru.medicaltickets.MyServiceJava.clinic.handlers.*;

@RequestMapping("clinic")
@RestController
@Validated
public class ClinicController {
    private final GetByLocationHandler getByLocationHandler;
    private final GetByNameHandler getByNameHandler;
    private final GetSingleHandler getSingleHandler;
    private final PostClinicHandler postClinicHandler;
    private final UpdateClinicHandler updateClinicHandler;

    public ClinicController(GetByLocationHandler getByLocationHandler, GetByNameHandler getByNameHandler,
                            GetSingleHandler getSingleHandler, PostClinicHandler postClinicHandler,
                            UpdateClinicHandler updateClinicHandler) {
        this.getByLocationHandler = getByLocationHandler;
        this.getByNameHandler = getByNameHandler;
        this.getSingleHandler = getSingleHandler;
        this.postClinicHandler = postClinicHandler;
        this.updateClinicHandler = updateClinicHandler;
    }

    @GetMapping("/clinic{clinicID}")
    public ResponseEntity<?> getSingle(@PathVariable("clinicID") String clinicID) {
        return getSingleHandler.handle(clinicID);
    }

    @GetMapping("/{officialName}")
    public ResponseEntity<?> getByName(@PathVariable("officialName") String officialName) {
        return getByNameHandler.handle(officialName);
    }

    @GetMapping("/location/{region}")
    public ResponseEntity<?> getByLocation(@PathVariable("region") String region) {
        return getByLocationHandler.handle(region);
    }

    @GetMapping("/location/{region}/{city}")
    public ResponseEntity<?> getByLocation(@PathVariable("region") String region,
                                           @PathVariable("city") String city) {
        return getByLocationHandler.handle(region, city);
    }

    @PostMapping("/new")
    public ResponseEntity<?> post(@Valid @RequestBody Clinic clinic) {
        return postClinicHandler.handle(clinic);
    }

    @PostMapping("/clinic{clinicID}")
    public ResponseEntity<?> update(@PathVariable("clinicID") String clinicID,
                                    @Valid @RequestBody Clinic clinic) {
        return updateClinicHandler.handle(clinicID, clinic);
    }
}
