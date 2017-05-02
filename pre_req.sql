create table pre_req (
	prereq_id INT,
	course_id INT REFERENCES Course(course_id),
    PRIMARY KEY(prereq_id, course_id)
);
insert into pre_req (prereq_id, course_id) values (1, 17);
insert into pre_req (prereq_id, course_id) values (2, 4);
insert into pre_req (prereq_id, course_id) values (3, 6);
insert into pre_req (prereq_id, course_id) values (4, 13);
insert into pre_req (prereq_id, course_id) values (5, 3);
insert into pre_req (prereq_id, course_id) values (6, 4);
insert into pre_req (prereq_id, course_id) values (7, 11);
insert into pre_req (prereq_id, course_id) values (8, 2);
insert into pre_req (prereq_id, course_id) values (9, 1);
insert into pre_req (prereq_id, course_id) values (10, 2);
