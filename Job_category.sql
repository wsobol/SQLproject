create table Job_category (
	cate_code INT PRIMARY KEY,
	pay_range_low VARCHAR(50),
	pay_range_high VARCHAR(50),
	title VARCHAR(50),
	parent_cate INT,
	soc VARCHAR(44) REFERENCES SOC(detail_soc)
);
insert into Job_category (cate_code, pay_range_low, pay_range_high, title, parent_cate, soc) values (1, '$42897.96', '$69053.79', 'Data Coordiator', 1, 'Software Developers/Applications');
insert into Job_category (cate_code, pay_range_low, pay_range_high, title, parent_cate, soc) values (2, '$44096.99', '$83940.98', 'Social Worker', 2, 'Software Developers/Systems Software');
insert into Job_category (cate_code, pay_range_low, pay_range_high, title, parent_cate, soc) values (3, '$41904.27', '$74709.51', 'Analog Circuit Design manager', 3, 'Software Developers/Systems Software');
insert into Job_category (cate_code, pay_range_low, pay_range_high, title, parent_cate, soc) values (4, '$39882.85', '$83585.73', 'Marketing Manager', 4, 'Computer Systems Analysts');
insert into Job_category (cate_code, pay_range_low, pay_range_high, title, parent_cate, soc) values (5, '$36471.93', '$80394.40', 'Help Desk Operator', 5, 'Computer Occupations/Other');
insert into Job_category (cate_code, pay_range_low, pay_range_high, title, parent_cate, soc) values (6, '$41467.37', '$73862.19', 'Project Manager', 6, 'Software Developers/Applications');
insert into Job_category (cate_code, pay_range_low, pay_range_high, title, parent_cate, soc) values (7, '$44079.23', '$83743.47', 'Marketing Assistant', 7, 'Computer Systems Analysts');
insert into Job_category (cate_code, pay_range_low, pay_range_high, title, parent_cate, soc) values (8, '$42523.87', '$80954.14', 'Tax Accountant', 8, 'Computer Systems Analysts');
insert into Job_category (cate_code, pay_range_low, pay_range_high, title, parent_cate, soc) values (9, '$34790.09', '$76819.74', 'Quality Control Specialist', 9, 'Software Developers/Systems Software');
insert into Job_category (cate_code, pay_range_low, pay_range_high, title, parent_cate, soc) values (10, '$39202.41', '$74814.99', 'Media Manager I', 10, 'Software Developers/Systems Software');
