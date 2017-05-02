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
insert into Company (comp_id, c_name, street, city, st, zip_code, primary_sector, NAICS_code) values (1, 'Gorczany, Kovacek and Sanford', '33478 Schmedeman Alley', 'Wilkes Barre', 'Pennsylvania', '18706', 'tourism', 334511);
insert into Company (comp_id, c_name, street, city, st, zip_code, primary_sector, NAICS_code) values (2, 'Barton, Schowalter and Abbott', '97 Hoffman Park', 'Washington', 'District of Columbia', '20099', 'technology', 423430);
insert into Company (comp_id, c_name, street, city, st, zip_code, primary_sector, NAICS_code) values (3, 'Huel, Hauck and Baumbach', '1107 Granby Street', 'Cincinnati', 'Ohio', '45243', 'oil and mining', 511210);
insert into Company (comp_id, c_name, street, city, st, zip_code, primary_sector, NAICS_code) values (4, 'Emmerich-Kuhic', '5511 Melrose Avenue', 'Camden', 'New Jersey', '08104', 'oil and mining', 514210);
insert into Company (comp_id, c_name, street, city, st, zip_code, primary_sector, NAICS_code) values (5, 'Stiedemann-Keeling', '85721 Graceland Center', 'San Jose', 'California', '95160', 'service', 334112);
insert into Company (comp_id, c_name, street, city, st, zip_code, primary_sector, NAICS_code) values (6, 'Bergnaum, Kunde and Daniel', '3847 Jenifer Road', 'Largo', 'Florida', '34643', 'technology', 421430);
insert into Company (comp_id, c_name, street, city, st, zip_code, primary_sector, NAICS_code) values (7, 'Jerde, Grant and Weber', '559 Monument Terrace', 'Houston', 'Texas', '77218', 'tourism', 443120);
insert into Company (comp_id, c_name, street, city, st, zip_code, primary_sector, NAICS_code) values (8, 'Spencer, Morar and Schoen', '679 Garrison Road', 'Reston', 'Virginia', '22096', 'technology', 334511);
insert into Company (comp_id, c_name, street, city, st, zip_code, primary_sector, NAICS_code) values (9, 'Schmitt Inc', '9011 Transport Junction', 'Erie', 'Pennsylvania', '16505', 'oil and mining', 519130);
insert into Company (comp_id, c_name, street, city, st, zip_code, primary_sector, NAICS_code) values (10, 'Grant, Rau and Howe', '913 Sheridan Crossing', 'Virginia Beach', 'Virginia', '23471', 'service', 334119);
insert into Company (comp_id, c_name, street, city, st, zip_code, primary_sector, NAICS_code) values (11, 'Muller, Walsh and Rodriguez', '43865 Del Sol Trail', 'Oklahoma City', 'Oklahoma', '73190', 'tourism', 333295);
insert into Company (comp_id, c_name, street, city, st, zip_code, primary_sector, NAICS_code) values (12, 'Koelpin, Thiel and Heidenreich', '7 Eastlawn Drive', 'Provo', 'Utah', '84605', 'entertainment', 334111);
insert into Company (comp_id, c_name, street, city, st, zip_code, primary_sector, NAICS_code) values (13, 'Krajcik-Metz', '5324 Forest Run Point', 'Jacksonville', 'Florida', '32209', 'tourism', 541710);
insert into Company (comp_id, c_name, street, city, st, zip_code, primary_sector, NAICS_code) values (14, 'Koepp, Wilkinson and Spinka', '761 Arrowood Court', 'Houston', 'Texas', '77293', 'tourism', 541512);
insert into Company (comp_id, c_name, street, city, st, zip_code, primary_sector, NAICS_code) values (15, 'Daugherty Group', '7 Lyons Place', 'Winston Salem', 'North Carolina', '27116', 'education', 334113);
