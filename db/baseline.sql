CREATE TABLE player
(
       player_id SERIAL PRIMARY KEY,
       name character varying(255) NOT NULL,
       team character varying(255) NOT NULL,
       number int NOT NULL,
       age int NOT NULL
 );

insert into player (name, team, number, age)
       values ('Amber Houle', 'Honeycrisps', 13, 25);

insert into player (name, team, number, age)
       values ('Carol Schofield', 'Oncelers', 9, 25);