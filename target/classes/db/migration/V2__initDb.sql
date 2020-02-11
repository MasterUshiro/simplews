
create table person (
    id INT(8) UNSIGNED AUTO_INCREMENT PRIMARY KEY,
    active boolean not null,
    email varchar(255),
    password varchar(255) not null,
    username varchar(255) not null
);