package ru.medicaltickets.MyServiceJava.user.doctor;

import org.jooq.DSLContext;
import org.jooq.Record;
import org.jooq.TableField;
import org.springframework.stereotype.Repository;
import ru.medicaltickets.MyServiceJava.jooq.tables.records.DoctorsRecord;
import ru.medicaltickets.MyServiceJava.user.doctor.enums.DoctorSpecialty;
import ru.medicaltickets.MyServiceJava.user.enums.Gender;

import java.util.List;

import static ru.medicaltickets.MyServiceJava.jooq.tables.Doctors.DOCTORS;

@Repository
public class DoctorDAO {
    private final DSLContext context;

    public DoctorDAO(DSLContext context) {
        this.context = context;
    }

    private final List<TableField<DoctorsRecord, ?>> DOCTOR_FIELDS = List.of(
            DOCTORS.ID,
            DOCTORS.ACCOUNTID,
            DOCTORS.FIRSTNAME,
            DOCTORS.LASTNAME,
            DOCTORS.GENDER,
            DOCTORS.LICENCENUMBER,
            DOCTORS.EXPERIENCE,
            DOCTORS.SPECIALTY
    );

    private static Doctor buildDoctor(Record record) {
        return Doctor.builder()
                .ID(record.get(DOCTORS.ID))
                .accountID(record.get(DOCTORS.ID))
                .firstName(record.get(DOCTORS.FIRSTNAME))
                .lastName(record.get(DOCTORS.LASTNAME))
                .gender(Gender.valueOf(record.get(DOCTORS.GENDER)))
                .licenceNumber(record.get(DOCTORS.LICENCENUMBER))
                .experience(record.get(DOCTORS.EXPERIENCE))
                .doctorSpecialty(DoctorSpecialty.valueOf(record.get(DOCTORS.SPECIALTY)))
                .build();
    }

    public boolean isExist(Long ID) {
        return context
                .select(DOCTOR_FIELDS)
                .from(DOCTORS)
                .where(DOCTORS.ID.eq(ID))
                .stream().findFirst().isPresent();
    }

    public Doctor getSingle(Long ID) {
        return context
                .select(DOCTOR_FIELDS)
                .from(DOCTORS)
                .where(DOCTORS.ID.eq(ID))
                .fetchSingle(DoctorDAO::buildDoctor);
    }

    public List<Doctor> getByFullName(String fullName) {
        return context
                .select(DOCTOR_FIELDS)
                .from(DOCTORS)
                .where(DOCTORS.LASTNAME.concat(" ").concat(DOCTORS.FIRSTNAME).eq(fullName))
                .or(DOCTORS.FIRSTNAME.concat(" ").concat(DOCTORS.LASTNAME).eq(fullName))
                .fetch(DoctorDAO::buildDoctor);
    }

    public List<Doctor> getWithSpecialty(DoctorSpecialty specialty) {
        return context
                .select(DOCTOR_FIELDS)
                .from(DOCTORS)
                .where(DOCTORS.SPECIALTY.eq(String.valueOf(specialty)))
                .fetch(DoctorDAO::buildDoctor);
    }

    public List<Doctor> getWithSpecialty(DoctorSpecialty specialty, int experience) {
        return context
                .select(DOCTOR_FIELDS)
                .from(DOCTORS)
                .where(DOCTORS.SPECIALTY.eq(String.valueOf(specialty)))
                .and(DOCTORS.EXPERIENCE.ge(experience))
                .fetch(DoctorDAO::buildDoctor);
    }

    public int update(Doctor doctor) {
        return context.newRecord(DOCTORS, doctor).update();
    }

    public int post(Doctor doctor) {
        return context.newRecord(DOCTORS, doctor).store();
    }
}
