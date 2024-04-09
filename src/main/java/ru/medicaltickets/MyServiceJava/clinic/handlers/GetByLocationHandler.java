package ru.medicaltickets.MyServiceJava.clinic.handlers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import ru.medicaltickets.MyServiceJava.clinic.ClinicService;
import ru.medicaltickets.MyServiceJava.clinic.enums.City;
import ru.medicaltickets.MyServiceJava.clinic.enums.Region;

public class GetByLocationHandler {
    private final ClinicService clinicService;

    public GetByLocationHandler(ClinicService clinicService) {
        this.clinicService = clinicService;
    }

    public ResponseEntity<?> handle(String region) {
        Region parsedRegion = Region.valueOf(region);
        return ResponseEntity.status(HttpStatus.OK).body(clinicService.getByLocation(parsedRegion));
    }

    public ResponseEntity<?> handle(String region, String city) {
        Region parsedRegion = Region.valueOf(region);
        City parsedCity = City.valueOf(city);
        return ResponseEntity.status(HttpStatus.OK).body(clinicService.getByLocation(parsedRegion, parsedCity));
    }
}
