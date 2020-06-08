DROP TABLE IF EXISTS ro_birth_certificate;
DROP TABLE IF EXISTS ro_marriage_certificate;
DROP TABLE IF EXISTS ro_passport;
DROP TABLE IF EXISTS ro_person;

CREATE TABLE ro_person(
   person_id SERIAL,
   sex smallint not null,
   first_name varchar(100) not null,
   last_name varchar(100) not null,
   patronymic varchar(100),
   date_of_birth date,
   PRIMARY KEY (person_id)
);

CREATE TABLE ro_passport(
   passport_id SERIAL,
   person_id integer not null,
   seria varchar(10) not null,
   number varchar(10) not null,
   isue_date date not null,
   isue_department varchar(200),
   PRIMARY KEY (passport_id),
   FOREIGN KEY (person_id) REFERENCES ro_person(person_id) ON DELETE RESTRICT
);

CREATE TABLE ro_birth_certificate(
   birth_certificate_id SERIAL,
   number_certificate varchar(20) not null,
   isue_date date not null,
   person_id integer not null,
   father_id integer,
   mather_id integer,
   PRIMARY KEY (birth_certificate_id),
   FOREIGN KEY (person_id) REFERENCES ro_person(person_id) ON DELETE RESTRICT,
   FOREIGN KEY (father_id) REFERENCES ro_person(person_id) ON DELETE RESTRICT,
   FOREIGN KEY (mather_id) REFERENCES ro_person(person_id) ON DELETE RESTRICT
);

CREATE TABLE ro_marriage_certificate(
   marriage_certificate_id SERIAL,
   number_certificate varchar(20) not null,
   isue_date date not null,
   husband_id integer not null,
   wife_id integer not null,
   active boolean DEFAULT  FALSE,
   end_date date,
   PRIMARY KEY (marriage_certificate_id),
   FOREIGN KEY (husband_id) REFERENCES ro_person(person_id) ON DELETE RESTRICT,
   FOREIGN KEY (wife_id) REFERENCES ro_person(person_id) ON DELETE RESTRICT
);

INSERT INTO ro_person(sex,first_name,last_name,patronymic,date_of_Birth)
VALUES (1,'Елена','Васильева','Сергеевна','1998-03-24'),
(2,'Олег','Васильев','Петрович','1997-10-16'),
(2,'Николай','Васильев','Олегович','2018-10-21');

INSERT INTO ro_passport(person_id,seria,number,isue_date,isue_department)
VALUES (1,'1000','123456','2018-04-10','Department passport');

INSERT INTO ro_birth_certificate(number_certificate,isue_date,person_id,father_id,mather_id)
VALUES ('123 Birth','2018-01-11',3,2,1);