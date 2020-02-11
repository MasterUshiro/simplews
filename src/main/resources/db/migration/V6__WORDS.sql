create table words_type (
  id   INT(8) not null,
  name varchar(100),
  type varchar(100),
  CONSTRAINT id_words_type PRIMARY KEY (id)
);


create table words_general (
  id            int8 not null,
  id_lang       INT(8) UNSIGNED not null,
  word          varchar(255),
  transcription varchar(255),
  CONSTRAINT id_words_general PRIMARY KEY (id)
);

create table words_translation (
  id            int8 not null,
  id_words      int8 not null,
  translate     varchar(500),
  type INT(8) not null,
  priority int8 not null,
  CONSTRAINT id_words_translation PRIMARY KEY (id)

);

ALTER TABLE `simplews`.`words_general`
ADD CONSTRAINT words_general_lang_fk FOREIGN KEY (`id_lang`)
REFERENCES `simplews`.`languages` (`id`);

ALTER TABLE `simplews`.`words_translation` 
ADD CONSTRAINT words_translation_id_words_fk FOREIGN KEY (`id_words`) 
REFERENCES `simplews`.`words_general` (`id`);

ALTER TABLE `simplews`.`words_translation` 
ADD CONSTRAINT words_translation_id_type_fk FOREIGN KEY (`type`) 
REFERENCES `simplews`.`words_type` (`id`);



