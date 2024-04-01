package ru.medicaltickets.MyServiceJava.clinic;

import org.springframework.lang.NonNull;
import ru.medicaltickets.MyServiceJava.clinic.enums.City;
import ru.medicaltickets.MyServiceJava.clinic.enums.ClinicSpecialty;

import java.util.List;

public record Clinic (Long ID, String name, City city, String street, String building, List<ClinicSpecialty> clinicSpecialties) {
    public static Clinic.Builder builder() {
        return new Clinic.Builder();
    }
    public static class Builder {
        private Long ID;
        @NonNull
        private String name;
        @NonNull
        private City city;
        @NonNull
        private String street;
        @NonNull
        private String building;
        @NonNull
        private List<ClinicSpecialty> clinicSpecialties;

        private Clinic.Builder self() {
            return this;
        }

        public Clinic build() {
            return new Clinic(ID, name, city, street, building, clinicSpecialties);
        }

        public Clinic.Builder ID(Long ID) {
            this.ID = ID;
            return self();
        }
        public Clinic.Builder name(@NonNull String name) {
            this.name = name;
            return this;
        }

        public Clinic.Builder city(@NonNull City city) {
            this.city = city;
            return this;
        }

        public Clinic.Builder street(@NonNull String street) {
            this.street = street;
            return this;
        }

        public Clinic.Builder building(@NonNull String building) {
            this.building = building;
            return this;
        }

        public Clinic.Builder types(@NonNull List<ClinicSpecialty> clinicSpecialties) {
            this.clinicSpecialties = clinicSpecialties;
            return this;
        }
    }
}
