
CREATE TABLE users
(
  id                  BIGINT AUTO_INCREMENT NOT NULL,                    -- // уникальный идентификатор
  login               CHARACTER VARYING NOT NULL UNIQUE,     -- // логин
  surname             CHARACTER VARYING NOT NULL,            -- // фамилия
  name                CHARACTER VARYING NOT NULL,            -- // имя
  password            CHARACTER VARYING NOT NULL,            -- // пароль
  PRIMARY KEY (id),
);

INSERT INTO users (login, surname, name,  password)
VALUES('root','Администратор', 'Администратор',
       '$2a$10$LijUmixpYL0i9rRvwXrnX.heUijboQzE3PsoCrxuJANIDVX28FNjS'
       );



