create database sip13_help_desk;
use sip13_help_desk;

create table ticket (
    id mediumint(8) unsigned not null auto_increment primary key,
    user_name varchar(80) not null,
    user_email varchar(80) not null,
    description varchar(4000) not null,
    date_created timestamp not null
) engine = InnoDB;

insert into ticket values
    (0, 'Chris Mahurin', 'chris@example.com', 'The login doesn''t seem to work.', now()),
    (0, 'Phil Turner', 'phil@example.com', 'I received an A but it should have been a B.', now()),
    (0, 'Dardy Chen', 'dardy@example.com', 'This class costs too much.', now());
