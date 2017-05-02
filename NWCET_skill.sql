create table NWCET_skill (
	k_code VARCHAR(7) REFERENCES Knowledge_Skill(k_code),
	skill_name VARCHAR(43) REFERENCES NWCET(skill_name),
    PRIMARY KEY(k_code, skill_name)
);
insert into NWCET_skill (k_code, skill_name) values ('15-1116', 'Enterprise Systems Analysis and Integration');
insert into NWCET_skill (k_code, skill_name) values ('15-1115', 'Network Design and Administration');
insert into NWCET_skill (k_code, skill_name) values ('15-1121', 'Web Administration');
insert into NWCET_skill (k_code, skill_name) values ('15-1121', 'Software Engineering');
insert into NWCET_skill (k_code, skill_name) values ('15-1132', 'Database Development');
insert into NWCET_skill (k_code, skill_name) values ('15-1143', 'Network Design and Administration');
insert into NWCET_skill (k_code, skill_name) values ('15-1122', 'Technical Writing');
insert into NWCET_skill (k_code, skill_name) values ('15-1133', 'Programming');
insert into NWCET_skill (k_code, skill_name) values ('15-1134', 'Database Development');
insert into NWCET_skill (k_code, skill_name) values ('15-1131', 'Database Development');
insert into NWCET_skill (k_code, skill_name) values ('15-1116', 'Digital Media');
insert into NWCET_skill (k_code, skill_name) values ('15-1142', 'Web Development');
insert into NWCET_skill (k_code, skill_name) values ('15-1116', 'Programming');
insert into NWCET_skill (k_code, skill_name) values ('15-1141', 'Web Development');
insert into NWCET_skill (k_code, skill_name) values ('15-1132', 'Programming');
