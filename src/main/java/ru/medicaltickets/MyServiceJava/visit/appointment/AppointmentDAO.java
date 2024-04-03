package ru.medicaltickets.MyServiceJava.visit.appointment;

import org.jooq.*;
import org.jooq.Record;
import org.springframework.stereotype.Repository;
import ru.medicaltickets.MyServiceJava.jooq.tables.records.AppointmentsRecord;
import ru.medicaltickets.MyServiceJava.visit.appointment.enums.ConditionStatus;

import java.time.LocalDate;
import java.util.List;

import static ru.medicaltickets.MyServiceJava.jooq.Tables.*;

@Repository
public class AppointmentDAO {
    private final DSLContext context;

    public AppointmentDAO(DSLContext context) {
        this.context = context;
    }

    private static final List<TableField<AppointmentsRecord, ?>> APPOINTMENT_FIELDS = List.of(
            APPOINTMENTS.ID,
            APPOINTMENTS.TICKETID,
            APPOINTMENTS.CLIENTID,
            APPOINTMENTS.DATEOFREGISTRY,
            APPOINTMENTS.CONDITIONSTATUS
    );

    private static Appointment buildAppointment(Record record) {
        return Appointment.builder()
                .ID(record.get(APPOINTMENTS.ID))
                .ticketID(record.get(APPOINTMENTS.TICKETID))
                .clinicID(record.get(TICKETS.CLINICID))
                .doctorID(record.get(TICKETS.DOCTORID))
                .clientID(record.get(APPOINTMENTS.CLIENTID))
                .dateOfVisit(record.get(TICKETS.DATEOFVISIT))
                .fullNameOfDoctor(record.get(DOCTORS.LASTNAME.concat(" ").concat(DOCTORS.FIRSTNAME)))
                .doctorSpecialty(record.get(DOCTORS.SPECIALTY))
                .fullNameOfClient(record.get(CLIENTS.LASTNAME.concat(" ").concat(CLIENTS.FIRSTNAME)))
                .dateOfReservation(record.get(APPOINTMENTS.DATEOFREGISTRY))
                .conditionStatus(ConditionStatus.valueOf(record.get(APPOINTMENTS.CONDITIONSTATUS)))
                .build();
    }

    private SelectOnConditionStep<Record12<Long, Long, Long, Long, Long, LocalDate, String, String, String, String,
                              LocalDate, String>> contextConditionAppointmentsWithJoinsTicketsClientsClinicsDoctors() {
        return context
                .select(APPOINTMENTS.ID, APPOINTMENTS.TICKETID, TICKETS.CLINICID, TICKETS.DOCTORID,
                        APPOINTMENTS.CLIENTID, TICKETS.DATEOFVISIT, DOCTORS.LASTNAME, DOCTORS.FIRSTNAME,
                        CLIENTS.LASTNAME, CLIENTS.FIRSTNAME, APPOINTMENTS.DATEOFREGISTRY,
                        APPOINTMENTS.CONDITIONSTATUS)
                .from(APPOINTMENTS)
                .join(TICKETS).on(APPOINTMENTS.TICKETID.eq(TICKETS.ID))
                .join(CLIENTS).on(APPOINTMENTS.CLIENTID.eq(CLIENTS.ID))
                .join(CLINICS).on(TICKETS.CLINICID.eq(CLINICS.ID))
                .join(DOCTORS).on(TICKETS.DOCTORID.eq(DOCTORS.ID));
    }

    public Appointment getBy(Long AppointmentID) {
        return contextConditionAppointmentsWithJoinsTicketsClientsClinicsDoctors()
                .where(APPOINTMENTS.ID.eq(AppointmentID))
                .fetchSingle(AppointmentDAO::buildAppointment);
    }

    public List<Appointment> getByClient(Long clientID) {
        return contextConditionAppointmentsWithJoinsTicketsClientsClinicsDoctors()
                .where(CLIENTS.ID.eq(clientID))
                .fetch(AppointmentDAO::buildAppointment);
    }

    public List<Appointment> getByClient(Long clientID, LocalDate dateOfVisit) {
        return contextConditionAppointmentsWithJoinsTicketsClientsClinicsDoctors()
                .where(CLIENTS.ID.eq(clientID).and(TICKETS.DATEOFVISIT.eq(dateOfVisit)))
                .fetch(AppointmentDAO::buildAppointment);
    }

    public List<Appointment> getByDoctor(Long doctorID) {
        return contextConditionAppointmentsWithJoinsTicketsClientsClinicsDoctors()
                .where(DOCTORS.ID.eq(doctorID))
                .fetch(AppointmentDAO::buildAppointment);
    }

    public List<Appointment> getByDoctor(Long doctorID, LocalDate dateOfVisit) {
        return contextConditionAppointmentsWithJoinsTicketsClientsClinicsDoctors()
                .where(DOCTORS.ID.eq(doctorID).and(TICKETS.DATEOFVISIT.eq(dateOfVisit)))
                .fetch(AppointmentDAO::buildAppointment);
    }

    public List<Appointment> getByClinic(Long clinicID) {
        return contextConditionAppointmentsWithJoinsTicketsClientsClinicsDoctors()
                .where(CLINICS.ID.eq(clinicID))
                .fetch(AppointmentDAO::buildAppointment);
    }

    public List<Appointment> getByClinic(Long clinicID, LocalDate dateOfVisit) {
        return contextConditionAppointmentsWithJoinsTicketsClientsClinicsDoctors()
                .where(CLINICS.ID.eq(clinicID).and(TICKETS.DATEOFVISIT.eq(dateOfVisit)))
                .fetch(AppointmentDAO::buildAppointment);
    }


}
