drop table if exists user CASCADE;
     create table user
     (
         seq bigint not null auto_increment,
         id varchar(20) not null,
         password varchar(100) not null,
         name varchar(255),
         phone varchar(20),
         type int not null,
         createdAt timestamp default current_timestamp,
         primary key (seq),
         unique (id)
);