package ru.medicaltickets.MyServiceJava.visit.ticket;

import org.springframework.lang.NonNull;
import ru.medicaltickets.MyServiceJava.user.AbstractUser;

import java.time.LocalDate;
import java.util.Date;

public class Ticket {
    private Long ID;
    @NonNull
    private Long clinicID;
    @NonNull
    private Long doctorID;
    @NonNull
    private LocalDate dateOfTicket;

    public Ticket(Long ID, @NonNull Long clinicID, @NonNull Long doctorID, @NonNull LocalDate dateOfTicket) {
        this.ID = ID;
        this.clinicID = clinicID;
        this.doctorID = doctorID;
        this.dateOfTicket = dateOfTicket;
    }

    public static Ticket.Builder builder() {
        return new Ticket.Builder();
    }

    public static class Builder<T extends Ticket.Builder<T>> {
        private Long ID;
        @NonNull
        private Long clinicID;
        @NonNull
        private Long doctorID;
        @NonNull
        private LocalDate dateOfVisit;

        private Ticket.Builder self() {
            return this;
        }

        public Ticket.Builder ID (Long ID) {
            this.ID = ID;
            return self();
        }

        public Ticket.Builder clinicID (Long clinicID) {
            this.clinicID = clinicID;
            return self();
        }

        public Ticket.Builder doctorID (Long doctorID) {
            this.doctorID = doctorID;
            return self();
        }

        public Ticket.Builder dateOfVisit (LocalDate dateOfVisit) {
            this.dateOfVisit = dateOfVisit;
            return self();
        }

        public Ticket build() {
            return new Ticket(ID, clinicID, doctorID, dateOfVisit);
        }
    }
}
