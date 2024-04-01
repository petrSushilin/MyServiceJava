package ru.medicaltickets.MyServiceJava.doctor;

import org.springframework.lang.NonNull;
import ru.medicaltickets.MyServiceJava.doctor.enums.DoctorsSpecialties;
import ru.medicaltickets.MyServiceJava.global.abstracts.AbstractSubject;

import java.util.List;

public class Doctor extends AbstractSubject {
    @NonNull
    private String licenceNumber;
    @NonNull
    private int experience;
    @NonNull
    private List<DoctorsSpecialties> doctorsSpecialties;

    public Doctor.Builder builder() {
        return new Doctor.Builder();
    }

    public static class Builder extends AbstractSubject.Builder<Doctor.Builder> {
        @NonNull
        private String licenceNumber;
        @NonNull
        private int experience;
        @NonNull
        private List<DoctorsSpecialties> doctorsSpecialties;

        @Override
        public Doctor build() {
            Doctor doctor = new Doctor();
            doctor.licenceNumber = licenceNumber;
            doctor.experience = experience;
            doctor.doctorsSpecialties = doctorsSpecialties;
            return doctor;
        }

        @Override
        protected Doctor.Builder self() {
            return this;
        }

        public Doctor.Builder licenceNumber(String licenceNumber) {
            this.licenceNumber = licenceNumber;
            return this;
        }

        public Doctor.Builder experience(int experience) {
            this.experience = experience;
            return this;
        }

        public Doctor.Builder doctorsSpecialties(List<DoctorsSpecialties> doctorsSpecialties) {
            this.doctorsSpecialties = doctorsSpecialties;
            return this;
        }
    }
}
