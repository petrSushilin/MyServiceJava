package ru.medicaltickets.MyServiceJava.visit.appointment;

import org.jooq.*;
import org.jooq.Record;
import org.springframework.stereotype.Repository;
import ru.medicaltickets.MyServiceJava.jooq.tables.records.AppointmentsRecord;
import ru.medicaltickets.MyServiceJava.user.doctor.enums.DoctorSpecialty;
import ru.medicaltickets.MyServiceJava.visit.appointment.enums.ConditionStatus;
import ru.medicaltickets.MyServiceJava.visit.ticket.Ticket;
import ru.medicaltickets.MyServiceJava.visit.ticket.TicketDAO;

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

    private static TableField[] SELECT_FIELDS = {APPOINTMENTS.ID, APPOINTMENTS.TICKETID, TICKETS.CLINICID,
            TICKETS.DOCTORID, APPOINTMENTS.CLIENTID, TICKETS.DATEOFVISIT, DOCTORS.LASTNAME, DOCTORS.FIRSTNAME,
            CLIENTS.LASTNAME, CLIENTS.FIRSTNAME, APPOINTMENTS.DATEOFREGISTRY, APPOINTMENTS.CONDITIONSTATUS};

    private SelectOnConditionStep<Record> contextConditionAppointmentsWithJoinsTicketsClientsClinicsDoctors() {
        return context
                .select(SELECT_FIELDS)
                .from(APPOINTMENTS)
                .join(TICKETS).on(APPOINTMENTS.TICKETID.eq(TICKETS.ID))
                .join(CLIENTS).on(APPOINTMENTS.CLIENTID.eq(CLIENTS.ID))
                .join(CLINICS).on(TICKETS.CLINICID.eq(CLINICS.ID))
                .join(DOCTORS).on(TICKETS.DOCTORID.eq(DOCTORS.ID));
    }

    public Appointment getSingle(Long AppointmentID) {
        return contextConditionAppointmentsWithJoinsTicketsClientsClinicsDoctors()
                .where(APPOINTMENTS.ID.eq(AppointmentID))
                .fetchSingle(AppointmentDAO::buildAppointment);
    }

    public List<Appointment> getScheduleByClinic(Long clinicID, LocalDate dateOfVisit, ConditionStatus status) {
        return contextConditionAppointmentsWithJoinsTicketsClientsClinicsDoctors()
                .where(TICKETS.CLINICID.eq(clinicID).and(APPOINTMENTS.CONDITIONSTATUS.eq(String.valueOf(status)))
                        .and(TICKETS.DATEOFVISIT.eq(dateOfVisit)))
                .fetch(AppointmentDAO::buildAppointment);
    }

    public List<Appointment> getWeekScheduleByClinic(Long clinicID, LocalDate dateOfMonday, ConditionStatus status) {
        return contextConditionAppointmentsWithJoinsTicketsClientsClinicsDoctors()
                .where(TICKETS.CLINICID.eq(clinicID).and(APPOINTMENTS.CONDITIONSTATUS.eq(String.valueOf(status)))
                        .and(TICKETS.DATEOFVISIT.between(dateOfMonday, dateOfMonday.plusWeeks(1))))
                .fetch(AppointmentDAO::buildAppointment);
    }

    public List<Appointment> getMonthScheduleByClinic(Long clinicID, LocalDate date, ConditionStatus status) {
        return contextConditionAppointmentsWithJoinsTicketsClientsClinicsDoctors()
                .where(TICKETS.CLINICID.eq(clinicID).and(APPOINTMENTS.CONDITIONSTATUS.eq(String.valueOf(status)))
                        .and(TICKETS.DATEOFVISIT.between(date, date.plusMonths(1))))
                .fetch(AppointmentDAO::buildAppointment);
    }

    public List<Appointment> getScheduleByDoctor(Long clinicID, Long doctorID, LocalDate dateOfVisit, ConditionStatus status) {
        return contextConditionAppointmentsWithJoinsTicketsClientsClinicsDoctors()
                .where(TICKETS.CLINICID.eq(clinicID).and(TICKETS.DOCTORID.eq(doctorID))
                        .and(APPOINTMENTS.CONDITIONSTATUS.eq(String.valueOf(status))).and(TICKETS.DATEOFVISIT.eq(dateOfVisit)))
                .fetch(AppointmentDAO::buildAppointment);
    }

    public List<Appointment> getWeekScheduleByDoctor(Long clinicID, Long doctorID, LocalDate dateOfMonday, ConditionStatus status) {
        return contextConditionAppointmentsWithJoinsTicketsClientsClinicsDoctors()
                .where(TICKETS.CLINICID.eq(clinicID).and(TICKETS.DOCTORID.eq(doctorID))
                        .and(APPOINTMENTS.CONDITIONSTATUS.eq(String.valueOf(status)))
                        .and(TICKETS.DATEOFVISIT.between(dateOfMonday, dateOfMonday.plusWeeks(1))))
                .fetch(AppointmentDAO::buildAppointment);
    }

    public List<Appointment> getMonthScheduleByDoctor(Long clinicID, Long doctorID, LocalDate date, ConditionStatus status) {
        return contextConditionAppointmentsWithJoinsTicketsClientsClinicsDoctors()
                .where(TICKETS.CLINICID.eq(clinicID).and(TICKETS.DOCTORID.eq(doctorID))
                        .and(APPOINTMENTS.CONDITIONSTATUS.eq(String.valueOf(status)))
                        .and(TICKETS.DATEOFVISIT.between(date, date.plusMonths(1))))
                .fetch(AppointmentDAO::buildAppointment);
    }

    public List<Appointment> getScheduleByDoctorSpecialty(Long clinicID, DoctorSpecialty doctorSpecialty,
                                                                LocalDate dateOfVisit, ConditionStatus status) {
        return contextConditionAppointmentsWithJoinsTicketsClientsClinicsDoctors()
                .where(TICKETS.CLINICID.eq(clinicID).and(APPOINTMENTS.CONDITIONSTATUS.eq(String.valueOf(status)))
                        .and(DOCTORS.SPECIALTY.eq(String.valueOf(doctorSpecialty))).and(TICKETS.DATEOFVISIT.eq(dateOfVisit)))
                .fetch(AppointmentDAO::buildAppointment);
    }

    public List<Appointment> getWeekScheduleByDoctorSpecialty(Long clinicID, DoctorSpecialty doctorSpecialty,
                                                                LocalDate dateOfMonday, ConditionStatus status) {
        return contextConditionAppointmentsWithJoinsTicketsClientsClinicsDoctors()
                .where(TICKETS.CLINICID.eq(clinicID).and(APPOINTMENTS.CONDITIONSTATUS.eq(String.valueOf(status)))
                        .and(DOCTORS.SPECIALTY.eq(String.valueOf(doctorSpecialty))
                        .and(TICKETS.DATEOFVISIT.between(dateOfMonday, dateOfMonday.plusWeeks(1)))))
                .fetch(AppointmentDAO::buildAppointment);
    }

    public List<Appointment> getMonthScheduleByDoctorSpecialty(Long clinicID, DoctorSpecialty doctorSpecialty,
                                                                        LocalDate date, ConditionStatus status) {
        return contextConditionAppointmentsWithJoinsTicketsClientsClinicsDoctors()
                .where(TICKETS.CLINICID.eq(clinicID).and(APPOINTMENTS.CONDITIONSTATUS.eq(String.valueOf(status)))
                        .and(DOCTORS.SPECIALTY.eq(String.valueOf(doctorSpecialty))
                        .and(TICKETS.DATEOFVISIT.between(date, date.plusMonths(1)))))
                .fetch(AppointmentDAO::buildAppointment);
    }

    public List<Appointment> getScheduleByClient(Long clientID, LocalDate dateOfVisit, ConditionStatus status) {
        return contextConditionAppointmentsWithJoinsTicketsClientsClinicsDoctors()
                .where(APPOINTMENTS.CLIENTID.eq(clientID).and(APPOINTMENTS.CONDITIONSTATUS.eq(String.valueOf(status)))
                        .and(TICKETS.DATEOFVISIT.eq(dateOfVisit)))
                .fetch(AppointmentDAO::buildAppointment);
    }

    public List<Appointment> getWeekScheduleByClient(Long clientID, LocalDate dateOfMonday, ConditionStatus status) {
        return contextConditionAppointmentsWithJoinsTicketsClientsClinicsDoctors()
                .where(APPOINTMENTS.CLIENTID.eq(clientID).and(APPOINTMENTS.CONDITIONSTATUS.eq(String.valueOf(status)))
                        .and(TICKETS.DATEOFVISIT.between(dateOfMonday, dateOfMonday.plusWeeks(1))))
                .fetch(AppointmentDAO::buildAppointment);
    }

    public List<Appointment> getMonthScheduleByClient(Long clientID, LocalDate date, ConditionStatus status) {
        return contextConditionAppointmentsWithJoinsTicketsClientsClinicsDoctors()
                .where(APPOINTMENTS.CLIENTID.eq(clientID).and(APPOINTMENTS.CONDITIONSTATUS.eq(String.valueOf(status)))
                        .and(TICKETS.DATEOFVISIT.between(date, date.plusMonths(1))))
                .fetch(AppointmentDAO::buildAppointment);
    }

    public int post(Appointment appointment) {
        return context.newRecord(APPOINTMENTS, appointment).store();
    }

    public int update(Appointment appointment) {
        return context.newRecord(APPOINTMENTS, appointment).update();
    }

}
