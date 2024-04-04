package ru.medicaltickets.MyServiceJava.visit.ticket;

import org.jooq.DSLContext;
import org.jooq.Record;
import org.jooq.SelectFieldOrAsterisk;
import org.jooq.TableField;
import org.springframework.stereotype.Repository;
import ru.medicaltickets.MyServiceJava.jooq.tables.records.TicketsRecord;
import ru.medicaltickets.MyServiceJava.user.doctor.enums.DoctorSpecialty;

import java.time.LocalDate;
import java.util.List;

import static ru.medicaltickets.MyServiceJava.jooq.Tables.DOCTORS;
import static ru.medicaltickets.MyServiceJava.jooq.Tables.TICKETS;

@Repository
public class TicketDAO {
    private final DSLContext context;

    public TicketDAO(DSLContext context) {
        this.context = context;
    }

    private static final List<TableField<TicketsRecord, ?>> TICKET_FIELDS = List.of(
            TICKETS.ID,
            TICKETS.CLINICID,
            TICKETS.DOCTORID,
            TICKETS.DATEOFVISIT
    );

    private static Ticket buildTicket(Record record) {
        return Ticket.builder()
                .ID(record.get(TICKETS.ID))
                .clinicID(record.get(TICKETS.CLINICID))
                .doctorID(record.get(TICKETS.DOCTORID))
                .dateOfVisit(record.get(TICKETS.DATEOFVISIT))
                .build();
    }

    public Ticket getSingle(Long ticketID) {
        return context
                .select(TICKET_FIELDS)
                .from(TICKETS)
                .where(TICKETS.ID.eq(ticketID))
                .fetchSingle(TicketDAO::buildTicket);
    }

    public List<Ticket> getByClinic(Long clinicID) {
        return context
                .select(TICKET_FIELDS)
                .from(TICKETS)
                .where(TICKETS.CLINICID.eq(clinicID))
                .fetch(TicketDAO::buildTicket);
    }

    public List<Ticket> getByClinic(Long clinicID, LocalDate dateOfVisit) {
        return context
                .select(TICKET_FIELDS)
                .from(TICKETS)
                .where(TICKETS.DATEOFVISIT.eq(dateOfVisit).and(TICKETS.CLINICID.eq(clinicID)))
                .fetch(TicketDAO::buildTicket);
    }

    public List<Ticket> getByDoctor(Long clinicID, Long doctorID) {
        return context
                .select(TICKET_FIELDS)
                .from(TICKETS)
                .where(TICKETS.CLINICID.eq(clinicID).and(TICKETS.DOCTORID.eq(doctorID)))
                .fetch(TicketDAO::buildTicket);
    }

    public List<Ticket> getByDoctor(Long clinicID, Long doctorID, LocalDate dateOfVisit) {
        return context
                .select(TICKET_FIELDS)
                .from(TICKETS)
                .where(TICKETS.DATEOFVISIT.eq(dateOfVisit).and(TICKETS.CLINICID.eq(clinicID)
                        .and(TICKETS.DOCTORID.eq(doctorID))))
                .fetch(TicketDAO::buildTicket);
    }

    public List<Ticket> getByClinicAndDoctorsSpecialty(Long clinicID, DoctorSpecialty doctorSpecialty) {
        return context
                .select((SelectFieldOrAsterisk) TICKET_FIELDS, DOCTORS.SPECIALTY)
                .from(TICKETS)
                .join(DOCTORS).on(TICKETS.DOCTORID.eq(DOCTORS.ID))
                .where((TICKETS.CLINICID.eq(clinicID)).and(DOCTORS.SPECIALTY.eq(String.valueOf(doctorSpecialty))))
                .fetch(TicketDAO::buildTicket);
    }

    public List<Ticket> getByClinicAndDoctorsSpecialty(Long clinicID, DoctorSpecialty doctorSpecialty,
                                                                                    LocalDate dateOfVisit) {
        return context
                .select((SelectFieldOrAsterisk) TICKET_FIELDS, DOCTORS.SPECIALTY)
                .from(TICKETS)
                .join(DOCTORS).on(TICKETS.DOCTORID.eq(DOCTORS.ID))
                .where(TICKETS.DATEOFVISIT.eq(dateOfVisit).and(TICKETS.CLINICID.eq(clinicID)
                                .and(DOCTORS.SPECIALTY.eq(String.valueOf(doctorSpecialty)))))
                .fetch(TicketDAO::buildTicket);
    }

    public List<Ticket> getAll() {
        return context
                .select(TICKET_FIELDS)
                .from(TICKETS)
                .fetch(TicketDAO::buildTicket);
    }

    public int update(Ticket ticket) {
        return context.newRecord(TICKETS, ticket).update();
    }

    public int post(Ticket ticket) {
        return context.newRecord(TICKETS, ticket).store();
    }
}
