create table Section (
	sec_id INT PRIMARY KEY,
	semester VARCHAR(6),
	yr VARCHAR(4),
	course_id INT REFERENCES Course(course_id)
);
insert into Section (sec_id, semester, yr, course_id) values (1, 'Summer', 2012, 2);
insert into Section (sec_id, semester, yr, course_id) values (2, 'Spring', 2017, 16);
insert into Section (sec_id, semester, yr, course_id) values (3, 'Summer', 2011, 8);
insert into Section (sec_id, semester, yr, course_id) values (4, 'Spring', 2015, 2);
insert into Section (sec_id, semester, yr, course_id) values (5, 'Summer', 2011, 4);
insert into Section (sec_id, semester, yr, course_id) values (6, 'Spring', 2017, 8);
insert into Section (sec_id, semester, yr, course_id) values (7, 'Spring', 2014, 8);
insert into Section (sec_id, semester, yr, course_id) values (8, 'Spring', 2014, 13);
insert into Section (sec_id, semester, yr, course_id) values (9, 'Fall', 2013, 4);
insert into Section (sec_id, semester, yr, course_id) values (10, 'Fall', 2014, 6);
insert into Section (sec_id, semester, yr, course_id) values (11, 'Spring', 2013, 14);
insert into Section (sec_id, semester, yr, course_id) values (12, 'Spring', 2015, 9);
insert into Section (sec_id, semester, yr, course_id) values (13, 'Spring', 2013, 7);
insert into Section (sec_id, semester, yr, course_id) values (14, 'Fall', 2009, 14);
insert into Section (sec_id, semester, yr, course_id) values (15, 'Summer', 2010, 7);
insert into Section (sec_id, semester, yr, course_id) values (16, 'Spring', 2009, 11);
insert into Section (sec_id, semester, yr, course_id) values (17, 'Spring', 2014, 2);
insert into Section (sec_id, semester, yr, course_id) values (18, 'Fall', 2009, 11);
insert into Section (sec_id, semester, yr, course_id) values (19, 'Spring', 2010, 3);
insert into Section (sec_id, semester, yr, course_id) values (20, 'Summer', 2011, 13);
