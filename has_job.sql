create table has_job (
	job_id INT REFERENCES Job(job_id),
	person_id INT REFERENCES Person(person_id),
	start_date DATE,
	end_date DATE,
    PRIMARY KEY(person_id, job_id)
);
insert into has_job (job_id, person_id, start_date, end_date) values (8, 15, to_date('2012-11-28', 'YYYY-MM-DD'), to_date('2016-08-23', 'YYYY-MM-DD'));
insert into has_job (job_id, person_id, start_date, end_date) values (12, 3, to_date('2012-09-02', 'YYYY-MM-DD'), to_date('2017-04-17', 'YYYY-MM-DD'));
insert into has_job (job_id, person_id, start_date, end_date) values (2, 13, to_date('2011-03-03', 'YYYY-MM-DD'), to_date('2016-06-16', 'YYYY-MM-DD'));
insert into has_job (job_id, person_id, start_date, end_date) values (3, 15, to_date('2011-12-19', 'YYYY-MM-DD'), to_date('2016-04-27', 'YYYY-MM-DD'));
insert into has_job (job_id, person_id, start_date, end_date) values (11, 26, to_date('2011-08-20', 'YYYY-MM-DD'), to_date('2016-05-22', 'YYYY-MM-DD'));
insert into has_job (job_id, person_id, start_date, end_date) values (23, 4, to_date('2016-01-22', 'YYYY-MM-DD'), to_date('2016-07-19', 'YYYY-MM-DD'));
insert into has_job (job_id, person_id, start_date, end_date) values (2, 9, to_date('2011-02-03', 'YYYY-MM-DD'), to_date('2016-06-22', 'YYYY-MM-DD'));
insert into has_job (job_id, person_id, start_date, end_date) values (29, 1, to_date('2013-12-20', 'YYYY-MM-DD'), to_date('2016-11-21', 'YYYY-MM-DD'));
insert into has_job (job_id, person_id, start_date, end_date) values (14, 29, to_date('2012-10-05', 'YYYY-MM-DD'), to_date('2016-08-06', 'YYYY-MM-DD'));
insert into has_job (job_id, person_id, start_date, end_date) values (29, 12, to_date('2012-09-05', 'YYYY-MM-DD'), to_date('2016-10-26', 'YYYY-MM-DD'));
insert into has_job (job_id, person_id, start_date, end_date) values (19, 19, to_date('2015-07-26', 'YYYY-MM-DD'), to_date('2017-03-29', 'YYYY-MM-DD'));
insert into has_job (job_id, person_id, start_date, end_date) values (10, 20, to_date('2015-11-10', 'YYYY-MM-DD'), to_date('2016-07-19', 'YYYY-MM-DD'));
insert into has_job (job_id, person_id, start_date, end_date) values (22, 8, to_date('2012-12-15', 'YYYY-MM-DD'), to_date('2017-03-09', 'YYYY-MM-DD'));
insert into has_job (job_id, person_id, start_date, end_date) values (17, 4, to_date('2012-10-12', 'YYYY-MM-DD'), to_date('2016-11-19', 'YYYY-MM-DD'));
insert into has_job (job_id, person_id, start_date, end_date) values (12, 12, to_date('2016-01-26', 'YYYY-MM-DD'), to_date('2017-03-05', 'YYYY-MM-DD'));