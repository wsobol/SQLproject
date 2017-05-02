create table course_skill (
	course_id INT REFERENCES Course(course_id),
	k_code VARCHAR(7) REFERENCES Knowledge_skill(k_code),
    PRIMARY KEY(course_id, k_code)
);
insert into course_skill (course_id, k_code) values (17, '15-1117');
insert into course_skill (course_id, k_code) values (10, '15-1121');
insert into course_skill (course_id, k_code) values (17, '15-1116');
insert into course_skill (course_id, k_code) values (7, '15-1143');
insert into course_skill (course_id, k_code) values (13, '15-1143');
insert into course_skill (course_id, k_code) values (7, '15-1114');
insert into course_skill (course_id, k_code) values (4, '15-1133');
insert into course_skill (course_id, k_code) values (13, '15-1117');
insert into course_skill (course_id, k_code) values (5, '15-1122');
insert into course_skill (course_id, k_code) values (5, '15-1113');
insert into course_skill (course_id, k_code) values (6, '15-1117');
insert into course_skill (course_id, k_code) values (3, '15-1143');
insert into course_skill (course_id, k_code) values (3, '15-1100');
insert into course_skill (course_id, k_code) values (16, '15-1116');
insert into course_skill (course_id, k_code) values (11, '15-1113');
