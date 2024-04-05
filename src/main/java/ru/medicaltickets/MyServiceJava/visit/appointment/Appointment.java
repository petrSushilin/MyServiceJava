package ru.medicaltickets.MyServiceJava.visit.appointment;

import org.springframework.lang.NonNull;
import ru.medicaltickets.MyServiceJava.visit.appointment.enums.ConditionStatus;
import ru.medicaltickets.MyServiceJava.visit.ticket.Ticket;
import jakarta.validation.constraints.Pattern;

import java.time.LocalDate;

public class Appointment extends Ticket {
    @NonNull
    private Long TicketID;
    @NonNull
    private Long clientID;
    @Pattern(regexp = "^[a-zA-Zа-яА-Я]")
    @NonNull
    private String fullNameOfDoctor;
    @NonNull
    private String doctorSpecialty;
    @Pattern(regexp = "^[a-zA-Zа-яА-Я]")
    @NonNull
    private String fullNameOfClient;
    @NonNull
    private LocalDate dateOfReservation;
    @NonNull
    private ConditionStatus conditionStatus;

    public Appointment(Long ID, @NonNull Long ticketID, Long clinicID, Long doctorID, @NonNull Long clientID,
                       LocalDate dateOfTicket, @NonNull String fullNameOfDoctor, @NonNull String doctorSpecialty,
                       @NonNull String fullNameOfClient, @NonNull LocalDate dateOfReservation,
                       @NonNull ConditionStatus conditionStatus) {
        super(ID, clinicID, doctorID, dateOfTicket);
        TicketID = ticketID;
        this.clientID = clientID;
        this.fullNameOfDoctor = fullNameOfDoctor;
        this.doctorSpecialty = doctorSpecialty;
        this.fullNameOfClient = fullNameOfClient;
        this.dateOfReservation = dateOfReservation;
        this.conditionStatus = conditionStatus;
    }

    public static Appointment.Builder builder() {
        return new Appointment.Builder();
    }

    public static class Builder extends Ticket.Builder<Builder> {
        private Long ID;
        @NonNull
        private Long ticketID;
        @NonNull
        private Long clinicID;
        @NonNull
        private Long doctorID;
        @NonNull
        private Long clientID;
        @NonNull
        private LocalDate dateOfVisit;
        @NonNull
        private String fullNameOfDoctor;
        @NonNull
        private String doctorSpecialty;
        @NonNull
        private String fullNameOfClient;
        @NonNull
        private LocalDate dateOfReservation;
        @NonNull
        private ConditionStatus conditionStatus;


        private Appointment.Builder self() {
            return this;
        }

        @Override
        public Appointment build() {
            return new Appointment(ID, ticketID, clinicID, doctorID, clientID, dateOfVisit, fullNameOfDoctor, doctorSpecialty,
                    fullNameOfClient, dateOfReservation, conditionStatus);
        }

        public Appointment.Builder ID(Long ID) {
            this.ID = ID;
            return self();
        }

        @Override
        public Appointment.Builder clinicID(Long clinicID) {
            this.clinicID = clinicID;
            return self();
        }

        @Override
        public Appointment.Builder doctorID(Long doctorID) {
            this.doctorID = doctorID;
            return self();
        }

        public Appointment.Builder clientID(Long clientID) {
            this.clientID = clientID;
            return self();
        }

        public Appointment.Builder ticketID(Long ticketID) {
            this.ticketID = ticketID;
            return self();
        }

        @Override
        public Appointment.Builder dateOfVisit(LocalDate dateOfVisit) {
            this.dateOfVisit = dateOfVisit;
            return self();
        }

        public Appointment.Builder fullNameOfDoctor(String fullNameOfDoctor) {
            this.fullNameOfDoctor = fullNameOfDoctor;
            return self();
        }

        public Appointment.Builder doctorSpecialty(String doctorSpecialty) {
            this.doctorSpecialty = doctorSpecialty;
            return self();
        }

        public Appointment.Builder fullNameOfClient(String fullNameOfClient) {
            this.fullNameOfClient = fullNameOfClient;
            return self();
        }

        public Appointment.Builder dateOfReservation(LocalDate dateOfReservation) {
            this.dateOfReservation = dateOfReservation;
            return self();
        }

        public Appointment.Builder conditionStatus(ConditionStatus conditionStatus) {
            this.conditionStatus = conditionStatus;
            return self();
        }
    }
}
