package ru.medicaltickets.MyServiceJava.user.doctor;

import org.springframework.lang.NonNull;
import ru.medicaltickets.MyServiceJava.user.doctor.enums.DoctorSpecialty;
import ru.medicaltickets.MyServiceJava.user.AbstractUser;

import java.util.List;

public class Doctor extends AbstractUser {
    @NonNull
    private String licenceNumber;
    @NonNull
    private int experience;
    @NonNull
    private DoctorSpecialty doctorSpecialty;

    public static Doctor.Builder builder() {
        return new Doctor.Builder();
    }

    public static class Builder extends AbstractUser.Builder<Doctor.Builder> {
        @NonNull
        private String licenceNumber;
        @NonNull
        private int experience;
        @NonNull
        private DoctorSpecialty doctorSpecialty;

        @Override
        public Doctor build() {
            Doctor doctor = new Doctor();
            doctor.licenceNumber = licenceNumber;
            doctor.experience = experience;
            doctor.doctorSpecialty = doctorSpecialty;
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

        public Doctor.Builder doctorSpecialty(DoctorSpecialty doctorSpecialty) {
            this.doctorSpecialty = doctorSpecialty;
            return this;
        }
    }
}
