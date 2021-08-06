create table employee
(
	id int auto_increment,
	code varchar(6) null,
	name varchar(150) null,
	remarks varchar(255) null,
	status tinyint null,
	constraint employee_pk
		primary key (id)
);