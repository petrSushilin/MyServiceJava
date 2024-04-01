package user.doctor;

import org.springframework.lang.NonNull;
import user.doctor.enums.DoctorsSpecialties;
import user.AbstractUser;

import java.util.List;

public class Doctor extends AbstractUser {
    @NonNull
    private String licenceNumber;
    @NonNull
    private int experience;
    @NonNull
    private List<DoctorsSpecialties> doctorsSpecialties;

    public Doctor.Builder builder() {
        return new Doctor.Builder();
    }

    public static class Builder extends AbstractUser.Builder<Doctor.Builder> {
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
