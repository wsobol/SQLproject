create table preferred (
	job_id INT REFERENCES Job(job_id),
	k_code VARCHAR(7) REFERENCES Knowledge_skill(k_code),
    PRIMARY KEY(job_id, k_code)
);
insert into preferred (job_id, k_code) values (12, '15-1141');
insert into preferred (job_id, k_code) values (3, '15-1141');
insert into preferred (job_id, k_code) values (29, '15-1143');
insert into preferred (job_id, k_code) values (7, '15-1143');
insert into preferred (job_id, k_code) values (12, '15-1134');
insert into preferred (job_id, k_code) values (12, '15-1121');
insert into preferred (job_id, k_code) values (19, '15-1117');
insert into preferred (job_id, k_code) values (26, '15-1133');
insert into preferred (job_id, k_code) values (13, '15-1143');
insert into preferred (job_id, k_code) values (4, '15-1117');
insert into preferred (job_id, k_code) values (22, '15-1134');
insert into preferred (job_id, k_code) values (23, '15-1116');
insert into preferred (job_id, k_code) values (4, '15-1122');
insert into preferred (job_id, k_code) values (19, '15-1113');
insert into preferred (job_id, k_code) values (19, '15-1134');
insert into preferred (job_id, k_code) values (23, '15-1142');
insert into preferred (job_id, k_code) values (17, '15-1115');
insert into preferred (job_id, k_code) values (24, '15-1134');
insert into preferred (job_id, k_code) values (4, '15-1133');
insert into preferred (job_id, k_code) values (15, '15-1143');
insert into preferred (job_id, k_code) values (20, '15-1143');
insert into preferred (job_id, k_code) values (17, '15-1116');
insert into preferred (job_id, k_code) values (21, '15-1132');
insert into preferred (job_id, k_code) values (13, '15-1133');
insert into preferred (job_id, k_code) values (2, '15-1115');
insert into preferred (job_id, k_code) values (6, '15-1141');
insert into preferred (job_id, k_code) values (15, '15-1141');
insert into preferred (job_id, k_code) values (9, '15-1142');
insert into preferred (job_id, k_code) values (10, '15-1131');
insert into preferred (job_id, k_code) values (15, '15-1113');
