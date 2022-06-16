create table persons
(
	p_id bigint primary key auto_increment,
    p_email varchar(100) not null unique,
    p_password varchar(255) not null,
    p_first_name varchar(50) not null,
    p_last_name varchar(100) not null,
    p_role varchar(20) default 'USER',
    p_status varchar(20) default 'ACTIVE'
);

insert into persons (p_id, p_email, p_password, p_first_name, p_last_name) values
(1, 'ebay@gmail.com', 'user', 'Eugene', 'Bay');
insert into persons (p_id, p_email, p_password, p_first_name, p_last_name, p_role, p_status) values
(2, 'mbay@gmail.com', 'admin', 'Michael', 'Bay', 'ADMIN', 'ACTIVE');