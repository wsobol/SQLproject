create table Company (
	comp_id INT PRIMARY KEY,
	c_name VARCHAR(50),
	street VARCHAR(50),
	city VARCHAR(50),
	st VARCHAR(50),
	zip_code VARCHAR(50),
	primary_sector VARCHAR(14),
	NAICS_code VARCHAR(6) REFERENCES NAICS(NAICS_code)
);

create table company_specialty (
	comp_id INT REFERENCES COMPANY(comp_id),
	specialty_name VARCHAR(17) REFERENCES  Specialty(specialty_name),
    PRIMARY KEY(comp_id, specialty_name)
);

create table core (
	cate_code INT REFERENCES Job_Category(cate_code),
	k_code VARCHAR(7) REFERENCES Knowledge_skill(k_code),
    PRIMARY KEY(cate_code, k_code)
);

create table Course (
	course_id INT PRIMARY KEY,
	title VARCHAR(36),
	lvl VARCHAR(4),
	credits VARCHAR(1)
);

create table course_skill (
	course_id INT REFERENCES Course(course_id),
	k_code VARCHAR(7) REFERENCES Knowledge_skill(k_code),
    PRIMARY KEY(course_id, k_code)
);

create table has_job (
	job_id INT REFERENCES Job(job_id),
	person_id INT REFERENCES Person(person_id),
	start_date DATE,
	end_date DATE,
    PRIMARY KEY(person_id, job_id)
);

create table has_skill (
	person_id INT REFERENCES Person(person_id),
	k_code VARCHAR(7),
    PRIMARY KEY(person_id, k_code)
);

create table Job (
	job_id INT PRIMARY KEY,
	pay_rate VARCHAR(50),
	pay_type VARCHAR(6),
	comp_id VARCHAR(11),
	emp_mode VARCHAR(9),
	cate_code VARCHAR(7)
);

create table Job_category (
	cate_code INT PRIMARY KEY,
	pay_range_low VARCHAR(50),
	pay_range_high VARCHAR(50),
	title VARCHAR(50),
	parent_cate INT,
	soc VARCHAR(44) REFERENCES SOC(detail_soc)
);

create table Knowledge_Skill (
	k_code VARCHAR(7) PRIMARY KEY,
	title VARCHAR(38),
	lvl VARCHAR(8),
	k_type VARCHAR(29)
);

create table NAICS (
	NAICS_code VARCHAR(6) PRIMARY KEY,
	title VARCHAR(90)
);

create table NWCET (
	skill_name VARCHAR(43) PRIMARY KEY
);

create table NWCET_skill (
	k_code VARCHAR(7) REFERENCES Knowledge_Skill(k_code),
	skill_name VARCHAR(43) REFERENCES NWCET(skill_name),
    PRIMARY KEY(k_code, skill_name)
);

create table Person (
	person_id INT PRIMARY KEY,
	p_name VARCHAR(50),
	address VARCHAR(50),
	city VARCHAR(50),
	st VARCHAR(50),
	zip_code VARCHAR(50),
	email VARCHAR(50),
	gender VARCHAR(50),
	phone VARCHAR(50)
);

create table person_phone (
	person_id INT REFERENCES Person(person_id),
	p_number VARCHAR(50),
	p_type VARCHAR(6),
    PRIMARY KEY(person_id,p_number)
);

create table Phone (
	p_number VARCHAR(50) PRIMARY KEY,
	p_type VARCHAR(6)
    );
	
create table pre_req (
	prereq_id INT,
	course_id INT REFERENCES Course(course_id),
    PRIMARY KEY(prereq_id, course_id)
);

create table preferred (
	job_id INT REFERENCES Job(job_id),
	k_code VARCHAR(7) REFERENCES Knowledge_skill(k_code),
    PRIMARY KEY(job_id, k_code)
);

create table required (
	job_id INT REFERENCES Job(job_id),
	k_code VARCHAR(7) REFERENCES Knowledge_skill(k_code),
    PRIMARY KEY(job_id, k_code)
);

create table Section (
	sec_id INT PRIMARY KEY,
	semester VARCHAR(6),
	yr VARCHAR(4),
    completion_date DATE,
	price VARCHAR(50),
	course_id INT REFERENCES Course(course_id)
);

create table SOC (
	major_soc VARCHAR(7),
	detail_soc VARCHAR(44) PRIMARY KEY
);

create table Specialty (
	specialty_name VARCHAR(17) PRIMARY KEY
);

create table takes (
	person_id INT REFERENCES Person(person_id),
	sec_id INT,
	semester VARCHAR(9),
	yr VARCHAR(4),
	grade VARCHAR(1),
    PRIMARY KEY(person_id,sec_id,semester,yr)
);