package ru.medicaltickets.MyServiceJava.ticket;

import org.springframework.lang.NonNull;
import ru.medicaltickets.MyServiceJava.ticket.enums.ActivityStatus;

import java.util.Date;

public record Ticket(Long ID, String visitorName, String clinicName, String address, String doctorName, Date dateOfTicket, Date dateOfRegistry, ActivityStatus activityStatus) {
    public Ticket.Builder builder () {
        return new Ticket.Builder();
    }

    public static class Builder {
        private Long ID;
        @NonNull
        private String visitorName;
        @NonNull
        private String clinicName;
        @NonNull
        private String address;
        @NonNull
        private String doctorName;
        @NonNull
        private Date dateOfVisit;
        @NonNull
        private Date dateOfRegistry;
        @NonNull
        private ActivityStatus activityStatus;

        private Builder self() {
            return this;
        }

        public Ticket.Builder ID (Long ID) {
            this.ID = ID;
            return self();
        }

        public Ticket.Builder visitorName (String visitorName) {
            this.visitorName = visitorName;
            return self();
        }

        public Ticket.Builder clinicName (String clinicName) {
            this.clinicName = clinicName;
            return self();
        }

        public Ticket.Builder address (String address) {
            this.address = address;
            return self();
        }

        public Ticket.Builder doctorName (String doctorName) {
            this.doctorName = doctorName;
            return self();
        }

        public Ticket.Builder dateOfVisit (Date dateOfVisit) {
            this.dateOfVisit = dateOfVisit;
            return self();
        }

        public Ticket.Builder dateOfRegistry (Date dateOfRegistry) {
            this.dateOfRegistry = dateOfRegistry;
            return self();
        }

        public Ticket.Builder activityStatus (ActivityStatus activityStatus) {
            this.activityStatus = activityStatus;
            return self();
        }

        public Ticket build() {
            return new Ticket(ID, visitorName, clinicName, address, doctorName, dateOfVisit, dateOfRegistry, activityStatus);
        }

        public Ticket.Builder copyFrom(Long ID, @NonNull String visitorName, @NonNull String clinicName,
                                       @NonNull String address, @NonNull String doctorName, @NonNull ActivityStatus activityStatus) {
            this.ID = ID;
            this.visitorName = visitorName;
            this.clinicName = clinicName;
            this.address = address;
            this.doctorName = doctorName;
            this.activityStatus = activityStatus;
            return this;
        }
    }
}
