insert into person (username, password, email, active)
    values ('admin', 'pass', '', true);

insert into person_roles (id_person, roles)
    values (1, 'USER'), (1, 'ADMIN');
