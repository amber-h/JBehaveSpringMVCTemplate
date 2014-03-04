CREATE TABLE player
(
       player_id SERIAL PRIMARY KEY,
       name character varying(255) NOT NULL,
       team character varying(255) NOT NULL,
       number tinyint NOT NULL,
       age tinyint NOT NULL
 );

 insert into player (name, team, number, age)
       values ('Amber Houle', 'Honeycrisps', 13, 25);