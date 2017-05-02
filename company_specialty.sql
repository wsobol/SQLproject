create table company_specialty (
	comp_id INT REFERENCES COMPANY(comp_id),
	specialty_name VARCHAR(17) REFERENCES  Specialty(specialty_name),
    PRIMARY KEY(comp_id, specialty_name)
);
insert into company_specialty (comp_id, specialty_name) values (3, 'IT consulting');
insert into company_specialty (comp_id, specialty_name) values (1, 'logistics service');
insert into company_specialty (comp_id, specialty_name) values (11, 'software');
insert into company_specialty (comp_id, specialty_name) values (14, 'construction');
insert into company_specialty (comp_id, specialty_name) values (3, 'software');
insert into company_specialty (comp_id, specialty_name) values (7, 'electronics');
insert into company_specialty (comp_id, specialty_name) values (8, 'IT consulting');
insert into company_specialty (comp_id, specialty_name) values (13, 'transportation');
insert into company_specialty (comp_id, specialty_name) values (6, 'IT consulting');
insert into company_specialty (comp_id, specialty_name) values (12, 'computer hardware');
