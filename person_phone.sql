create table person_phone (
	person_id INT REFERENCES Person(person_id),
	p_number VARCHAR(50),
	p_type VARCHAR(6),
    PRIMARY KEY(person_id,p_number)
);
insert into person_phone (person_id, p_number, p_type) values (15, '86-(517)494-1177', 'Mobile');
insert into person_phone (person_id, p_number, p_type) values (29, '62-(480)797-9066', 'Home');
insert into person_phone (person_id, p_number, p_type) values (7, '66-(214)319-8147', 'Home');
insert into person_phone (person_id, p_number, p_type) values (13, '63-(689)510-4525', 'Home');
insert into person_phone (person_id, p_number, p_type) values (23, '7-(117)944-7630', 'Home');
insert into person_phone (person_id, p_number, p_type) values (26, '66-(460)384-4813', 'Work');
insert into person_phone (person_id, p_number, p_type) values (18, '54-(714)504-3342', 'Home');
insert into person_phone (person_id, p_number, p_type) values (3, '30-(820)481-4487', 'Mobile');
insert into person_phone (person_id, p_number, p_type) values (21, '598-(287)793-5986', 'Home');
insert into person_phone (person_id, p_number, p_type) values (9, '420-(310)465-5422', 'Home');
insert into person_phone (person_id, p_number, p_type) values (24, '51-(769)653-5042', 'Home');
insert into person_phone (person_id, p_number, p_type) values (22, '62-(975)426-7498', 'Work');
insert into person_phone (person_id, p_number, p_type) values (4, '7-(465)554-1409', 'Work');
insert into person_phone (person_id, p_number, p_type) values (22, '55-(422)295-7048', 'Work');
insert into person_phone (person_id, p_number, p_type) values (13, '86-(122)531-8951', 'Work');
