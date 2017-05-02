create table takes (
	person_id INT REFERENCES Person(person_id),
	sec_id INT,
	semester VARCHAR(9),
	yr VARCHAR(4),
	grade VARCHAR(1),
    PRIMARY KEY(person_id,sec_id,semester,yr)
);
insert into takes (person_id, sec_id, semester, yr, grade) values (11, 10, 'Spring', 2009, 'A');
insert into takes (person_id, sec_id, semester, yr, grade) values (6, 1, 'Spring', 2016, 'B');
insert into takes (person_id, sec_id, semester, yr, grade) values (6, 15, 'Spring', 2012, 'D');
insert into takes (person_id, sec_id, semester, yr, grade) values (10, 4, 'Summer', 2016, 'B');
insert into takes (person_id, sec_id, semester, yr, grade) values (14, 10, 'Spring', 2009, 'A');
insert into takes (person_id, sec_id, semester, yr, grade) values (9, 9, 'Spring', 2014, 'C');
insert into takes (person_id, sec_id, semester, yr, grade) values (13, 10, 'Spring', 2009, 'C');
insert into takes (person_id, sec_id, semester, yr, grade) values (20, 16, 'Summer', 2011, 'F');
insert into takes (person_id, sec_id, semester, yr, grade) values (1, 17, 'Fall', 2009, 'C');
insert into takes (person_id, sec_id, semester, yr, grade) values (30, 16, 'Summer', 2011, 'C');
insert into takes (person_id, sec_id, semester, yr, grade) values (19, 5, 'Summer', 2013, 'A');
insert into takes (person_id, sec_id, semester, yr, grade) values (2, 9, 'Spring', 2014, 'B');
insert into takes (person_id, sec_id, semester, yr, grade) values (20, 10, 'Spring', 2009, 'A');
insert into takes (person_id, sec_id, semester, yr, grade) values (7, 7, 'Spring', 2014, 'A');
insert into takes (person_id, sec_id, semester, yr, grade) values (1, 9, 'Spring', 2014, 'B');
insert into takes (person_id, sec_id, semester, yr, grade) values (28, 2, 'Spring', 2012, 'B');
insert into takes (person_id, sec_id, semester, yr, grade) values (29, 2, 'Spring', 2012, 'B');
insert into takes (person_id, sec_id, semester, yr, grade) values (18, 4, 'Summer', 2016, 'A');
insert into takes (person_id, sec_id, semester, yr, grade) values (22, 5, 'Summer', 2013, 'C');
insert into takes (person_id, sec_id, semester, yr, grade) values (7, 11, 'Fall', 2015, 'B');
