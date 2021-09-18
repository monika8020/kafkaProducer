DROP TABLE IF EXISTS t_kafka_producer;

create TABLE t_kafka_producer (
id INT PRIMARY KEY,
first_name VARCHAR(250) Not NULL,
last_name VARCHAR(250) ,
email VARCHAR(250) Not Null,
password VARCHAR(250) Not NULL
);

insert into t_kafka_producer values(1001,'harsh','jain','xyz@email.com','12345');
insert into t_kafka_producer values(1012,'Nancy','jain','xyz@email.com','12345');