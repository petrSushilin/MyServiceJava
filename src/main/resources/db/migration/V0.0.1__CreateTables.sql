-- Create the table for main entities and combinations --
-- drop table accounts cascade;
create table accounts (
    ID                      bigint generated always as identity primary key,
    login                   varchar(16)     unique          not null,
    password                varchar(30)                     not null,
    constraint valid_login check (login ~ '^[a-zA-Z0-9.]{6,16}$')
);
-- drop table clients cascade;
create table clients (
    ID                      bigint generated always as identity primary key,
    accountID               bigint          unique          not null,
    firstName               varchar(20)                     not null,
    lastName                varchar(20)                     not null,
    gender                  varchar(6)                      not null,
    birthDate               date                            not null,
    foreign key (accountID) references accounts (ID),
    constraint valid_gender check ( clients.gender in ('MALE', 'FEMALE') ),
    constraint valid_firstName check ( clients.firstName ~ '^[a-zA-Zа-яА-Я]' ),
    constraint valid_lastName check ( clients.lastName ~ '^[a-zA-Zа-яА-Я]' )
);
-- drop table doctors cascade;
create table doctors (
    ID                      bigint generated always as identity primary key,
    accountID               bigint                          not null,
    firstName               varchar(20)                     not null,
    lastName                varchar(20)                     not null,
    gender                  varchar(6)                      not null,
    licenceNumber           varchar(50)     unique          not null,
    experience              int                             not null,
    specialty               varchar(100)                    not null,
    foreign key (accountID) references accounts (ID),
    constraint valid_gender check ( doctors.gender in ('MALE', 'FEMALE') ),
    constraint valid_firstName check ( doctors.firstName ~ '^[a-zA-Zа-яА-Я]' ),
    constraint valid_lastName check ( doctors.lastName ~ '^[a-zA-Zа-яА-Я]' ),
    constraint valid_specialty check ( doctors.specialty in ('CARDIOVASCULAR_SURGEON', 'ENT_SPECIALIST', 'ENT_SURGEON',
                            'FAMILY_PHYSICIAN', 'THERAPIST', 'ENDOCRINOLOGIST', 'GYNECOLOGIST', 'OBSTETRICIAN_GYNECOLOGIST',
                            'OPHTHALMIC_SURGEON', 'OPHTHALMOLOGIST', 'PEDIATRICIAN') )
);

-- drop table clinics cascade;
create table cities (
    ID                      bigint generated always as identity primary key,
    city                    varchar(30)                   not null,
    region                  varchar(50)                   not null,
    constraint unique_city_region unique (city, region)
);

create or replace function check_cities()
    returns trigger as $$
begin
    if not exists (
        select 1
        from cities
        where cities.city = NEW.city
          and cities.region = NEW.region
    ) then
        raise exception 'City does not belong to the specified country';
    end if;
    return NEW;
end;
$$ language plpgsql;

-- drop table clinics cascade;
create table clinics (
    ID                      bigint generated always as identity primary key,
    officialName            varchar(40)     unique          not null,
    region                  varchar(40)                     not null,
    city                    varchar(20)                     not null,
    street                  varchar(40)                     not null,
    building                varchar(10)                     not null,
    type                    varchar(20)                     not null,
    constraint valid_region check ( clinics.region in ('MOSCOW', 'SAINTPETERSBURG', 'MOSCOW_REGION', 'LENINGRAD_REGION') ),
    constraint valid_city check ( clinics.city in ('MOSCOW', 'PODOLSK', 'PUTILKOVO', 'MYTISHCHI', 'SAINTPETERSBURG',
                            'PETERHOF', 'PUSHKIN', 'GATCHINA', 'VIBORG') ),
    constraint valid_type check ( clinics.type in ('CARDIOLOGY_POLYCLINIC', 'ENT_POLYCLINIC', 'GYNECOLOGY_POLYCLINIC',
                            'GENERAL_MEDICINE_POLYCLINIC', 'OPHTHALMOLOGY_POLYCLINIC', 'PEDIATRICS_POLYCLINIC') )
);

create trigger cities_trigger
    before insert on clinics
    for each row execute function check_cities();

-- drop table doctors_clinics cascade;
create table doctors_clinics (
    ID                      bigint generated always as identity primary key,
    doctorID                integer         not null,
    clinicID                integer         not null,
    foreign key (doctorID) references clients (ID) on delete cascade,
    foreign key (clinicID) references clinics (ID) on delete cascade
);
-- drop table tickets cascade;
create table tickets (
    ID                      bigint generated always as identity primary key,
    clinicID                bigint          not null,
    doctorID                bigint          not null,
    dateOfVisit             date            not null,
    foreign key (clinicID) references clinics (ID),
    foreign key (doctorID) references doctors (ID),
    constraint unique_ticket unique (clinicID, doctorID, dateOfVisit)
);

create table appointments (
    ID                      bigint generated always as identity primary key,
    ticketID                bigint          not null,
    clientID                bigint          not null,
    dateOfRegistry          date            not null,
    conditionStatus          varchar(12)     not null,
    constraint valid_activityStatus check ( appointments.conditionStatus in ('CREATED', 'CONFIRMATION', 'ACTIVE',
                                                                            'SUSPENDED', 'MISSED', 'DELETED') ),
    constraint unique_appointment unique (ticketID, clientID),
    foreign key (ticketID) references tickets (ID)
);