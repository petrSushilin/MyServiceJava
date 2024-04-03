package ru.medicaltickets.MyServiceJava.clinic;

import org.jooq.DSLContext;
import org.jooq.Record;
import org.jooq.TableField;
import org.springframework.stereotype.Repository;
import ru.medicaltickets.MyServiceJava.clinic.enums.City;
import ru.medicaltickets.MyServiceJava.clinic.enums.Region;
import ru.medicaltickets.MyServiceJava.jooq.tables.records.ClinicsRecord;

import java.util.List;

import static ru.medicaltickets.MyServiceJava.jooq.Tables.CLINICS;

@Repository
public class ClinicDAO {
    private final DSLContext context;

    public ClinicDAO(DSLContext context) {
        this.context = context;
    }

    private final List<TableField<ClinicsRecord, ?>> CLINIC_FIELDS = List.of(
            CLINICS.ID,
            CLINICS.OFFICIALNAME,
            CLINICS.REGION,
            CLINICS.CITY,
            CLINICS.STREET,
            CLINICS.BUILDING,
            CLINICS.TYPE
    );

    private static Clinic buildClinic(Record record) {
        return new Clinic.Builder()
                .ID(record.get(CLINICS.ID))
                .name(record.get(CLINICS.OFFICIALNAME))
                .region(Region.valueOf(record.get(CLINICS.REGION)))
                .city(City.valueOf(record.get(CLINICS.CITY)))
                .street(record.get(CLINICS.STREET))
                .building(record.get(CLINICS.BUILDING))
                .build();
    }

    public Clinic getBy(Long ID) {
        return context
                .select(CLINIC_FIELDS)
                .from(CLINICS)
                .where(CLINICS.ID.eq(ID))
                .fetchSingle(ClinicDAO::buildClinic);
    }

    public List<Clinic> getByParams(String officialName) {
        return context
                .select(CLINIC_FIELDS)
                .from(CLINICS)
                .where(CLINICS.OFFICIALNAME.eq(officialName))
                .fetch(ClinicDAO::buildClinic);
    }

    public List<Clinic> getByParams(Region region) {
        return context
                .select(CLINIC_FIELDS)
                .from(CLINICS)
                .where(CLINICS.REGION.eq(String.valueOf(region)))
                .fetch(ClinicDAO::buildClinic);
    }

    public List<Clinic> getByParams(Region region, City city) {
        return context
                .select(CLINIC_FIELDS)
                .from(CLINICS)
                .where(CLINICS.REGION.eq(String.valueOf(region))
                        .and(CLINICS.CITY.eq(String.valueOf(city))))
                .fetch(ClinicDAO::buildClinic);
    }

    public List<Clinic> getAll() {
        return context
                .select(CLINIC_FIELDS)
                .from(CLINICS)
                .fetch(ClinicDAO::buildClinic);
    }

    public int update(Clinic clinic) {
        return context.newRecord(CLINICS, clinic).update();
    }

    public int post(Clinic clinic) {
        return context.newRecord(CLINICS, clinic).store();
    }
}
