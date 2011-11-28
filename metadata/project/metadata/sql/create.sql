use demo;

CREATE TABLE t_bank(
	id int primary key auto_increment,
	bank_name varchar(32) not null unique,
	create_date timestamp not null default now()
)ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE t_bank_log(
	id int primary key auto_increment,
	bankid int not null,
	tran_ref_no varchar(32) not null unique,
	code varchar(16) not null,
	description varchar(512) not null,
	create_date timestamp not null default now()
)ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE t_bank_transfer(
	id int primary key auto_increment,
	bankid int not null,
	tran_ref_no varchar(32) not null unique,
	tran_date varchar(16) null,
	tran_time varchar(16) null,
	tran_flag varchar(16) null,
	tran_msg varchar(16) null,
	tran_fee varchar(16) null,
	taocan_flag varchar(16) null,
	taocan_type varchar(16) null,
	p_flowno varchar(16) null,
	create_date timestamp not null default now()
)ENGINE=InnoDB DEFAULT CHARSET=utf8;
