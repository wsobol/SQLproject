create table Section (
	sec_id INT PRIMARY KEY,
	semester VARCHAR(6),
	yr VARCHAR(4),
    completion_date DATE,
	price VARCHAR(50),
	course_id INT REFERENCES Course(course_id)
);
insert into Section (sec_id, semester, yr, completion_date, course_id) values (1, 'Summer', 2012, to_date('2012-08-01', 'YYYY-MM-DD'), '$331.16', 2);
insert into Section (sec_id, semester, yr, completion_date, course_id) values (2, 'Spring', 2017, to_date('2017-05-01', 'YYYY-MM-DD'), '$221.26', 16);
insert into Section (sec_id, semester, yr, completion_date, course_id) values (3, 'Summer', 2011, to_date('2011-08-01', 'YYYY-MM-DD'), '$441.36', 8);
insert into Section (sec_id, semester, yr, completion_date, course_id) values (4, 'Spring', 2015, to_date('2015-05-01', 'YYYY-MM-DD'), '$551.46', 2);
insert into Section (sec_id, semester, yr, completion_date, course_id) values (5, 'Summer', 2011, to_date('2011-08-01', 'YYYY-MM-DD'), '222.55', 4);
insert into Section (sec_id, semester, yr, completion_date, course_id) values (6, 'Spring', 2017, to_date('2017-05-01', 'YYYY-MM-DD'), '$333.66', 8);
insert into Section (sec_id, semester, yr, completion_date, course_id) values (7, 'Spring', 2014, to_date('2014-05-01', 'YYYY-MM-DD'), '$444.76', 8);
insert into Section (sec_id, semester, yr, completion_date, course_id) values (8, 'Spring', 2014, to_date('2014-05-01', 'YYYY-MM-DD'), '$555.86', 13);
insert into Section (sec_id, semester, yr, completion_date, course_id) values (9, 'Fall', 2013, to_date('2013-12-15', 'YYYY-MM-DD'), '$321.96', 4);
insert into Section (sec_id, semester, yr, completion_date, course_id) values (10, 'Fall', 2014, to_date('2014-12-15', 'YYYY-MM-DD'), '$232.22', 6);
insert into Section (sec_id, semester, yr, completion_date, course_id) values (11, 'Spring', 2013, to_date('2013-05-01', 'YYYY-MM-DD'), '$431.33', 14);
insert into Section (sec_id, semester, yr, completion_date, course_id) values (12, 'Spring', 2015, to_date('2015-05-01', 'YYYY-MM-DD'), '$531.44', 9);
insert into Section (sec_id, semester, yr, completion_date, course_id) values (13, 'Spring', 2013, to_date('2013-05-01', 'YYYY-MM-DD'), '$541.55', 7);
insert into Section (sec_id, semester, yr, completion_date, course_id) values (14, 'Fall', 2009, to_date('2009-12-15', 'YYYY-MM-DD'), '$354.66', 14);
insert into Section (sec_id, semester, yr, completion_date, course_id) values (15, 'Summer', 2010, to_date('2010-08-01', 'YYYY-MM-DD'), '$422.77', 7);
insert into Section (sec_id, semester, yr, completion_date, course_id) values (16, 'Spring', 2009, to_date('2009-05-01', 'YYYY-MM-DD'), '$411.88', 11);
insert into Section (sec_id, semester, yr, completion_date, course_id) values (17, 'Spring', 2014, to_date('2014-05-01', 'YYYY-MM-DD'), '$290.99', 2);
insert into Section (sec_id, semester, yr, completion_date, course_id) values (18, 'Fall', 2009, to_date('2009-12-15', 'YYYY-MM-DD'), '$390.00', 11);
insert into Section (sec_id, semester, yr, completion_date, course_id) values (19, 'Spring', 2010, to_date('2010-05-01', 'YYYY-MM-DD'), '$490.11', 3);
insert into Section (sec_id, semester, yr, completion_date, course_id) values (20, 'Summer', 2011, to_date('2011-08-01', 'YYYY-MM-DD'), '$414.22', 13);
