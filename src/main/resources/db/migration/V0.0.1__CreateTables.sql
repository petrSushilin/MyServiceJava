-- Create the table for main entities and combinations --

create table authentications (
    ID                      bigint generated always as identity primary key,
    login                   varchar(16)     unique          not null,
    password                varchar(30)                     not null,
    constraint valid_login check (login ~ '^[a-zA-Z0-9.]{6,16}$')
);

create table clients (
    ID                      bigint generated always as identity primary key,
    authenticationsID       bigint          unique          not null,
    firstName               varchar(20)                     not null,
    lastName                varchar(20)                     not null,
    gender                  varchar(6)                      not null,
    foreign key (authenticationsID) references authentications (ID),
    constraint valid_gender check ( clients.gender in ('MALE', 'FEMALE') ),
    constraint valid_firstName check (firstName ~ '^[a-zA-Zа-яА-Я]'),
    constraint valid_lastName check (lastName ~ '^[a-zA-Zа-яА-Я]')
);

create table doctors (
    ID                      bigint generated always as identity primary key,
    authenticationsID       bigint          unique          not null,
    firstName               varchar(20)                     not null,
    lastName                varchar(20)                     not null,
    specialties             varchar(20)                     not null,
    foreign key (authenticationsID) references authentications (ID),
    constraint valid_specialties check ( doctors.specialties in ('CARDIOVASCULAR_SURGEON', 'ENT_SPECIALIST', 'ENT_SURGEON',
                            'FAMILY_PHYSICIAN', 'THERAPIST', 'ENDOCRINOLOGIST', 'GYNECOLOGIST', 'OBSTETRICIAN_GYNECOLOGIST',
                            'OPHTHALMIC_SURGEON', 'OPHTHALMOLOGIST', 'PEDIATRICIAN') )
);

create table clinics (
    ID                      bigint generated always as identity primary key,
    name                    varchar(40)     unique          not null,
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

create table doctors_clinics (
    ID                      bigint generated always as identity primary key,
    doctorID                integer         not null,
    clinicID                integer         not null,
    foreign key (doctorID) references clients (ID),
    foreign key (clinicID) references clinics (ID)
);

create table tickets (
    ID                      bigint generated always as identity primary key,
    clientID                bigint          not null,
    clinicID                bigint          not null,
    doctorID                bigint          not null,
    dateOfVisit             date            not null,
    dateOfRegistry          date            not null,
    activityStatus          varchar(12)     not null,
    constraint valid_activityStatus check ( tickets.activityStatus in ('CREATED', 'CONFIRMATION', 'ACTIVE', 'SUSPENDED',
                            'MISSED', 'DELETED') ),
    foreign key (clientID) references clients (ID),
    foreign key (clinicID) references clinics (ID),
    foreign key (doctorID) references doctors (ID)
);