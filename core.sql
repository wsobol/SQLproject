create table core (
	cate_code INT REFERENCES Job_Category(cate_code),
	k_code VARCHAR(7) REFERENCES Knowledge_skill(k_code),
    PRIMARY KEY(cate_code, k_code)
);
insert into core (cate_code, k_code) values (7, '15-1133');
insert into core (cate_code, k_code) values (5, '15-1121');
insert into core (cate_code, k_code) values (3, '15-1100');
insert into core (cate_code, k_code) values (1, '15-1131');
insert into core (cate_code, k_code) values (8, '15-1141');
insert into core (cate_code, k_code) values (4, '15-1114');
insert into core (cate_code, k_code) values (1, '15-1133');
insert into core (cate_code, k_code) values (3, '15-1115');
insert into core (cate_code, k_code) values (9, '15-1115');
insert into core (cate_code, k_code) values (8, '15-1142');
insert into core (cate_code, k_code) values (9, '15-1132');
insert into core (cate_code, k_code) values (2, '15-1133');
