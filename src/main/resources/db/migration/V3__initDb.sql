create table person_roles (
    id_person INT(8) UNSIGNED,
    roles varchar(255)
);

ALTER TABLE
    `simplews`.`person_roles` ADD CONSTRAINT personroles_fk1 FOREIGN KEY (`id_person`) REFERENCES
    `simplews`.`person` (`id`);