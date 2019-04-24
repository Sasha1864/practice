
CREATE TABLE users
(
  id                  BIGINT AUTO_INCREMENT NOT NULL,                    -- // уникальный идентификатор
  login               CHARACTER VARYING NOT NULL UNIQUE,     -- // логин
  surname             CHARACTER VARYING NOT NULL,            -- // фамилия
  name                CHARACTER VARYING NOT NULL,            -- // имя
  password            CHARACTER VARYING NOT NULL,            -- // пароль
  PRIMARY KEY (id),
);
CREATE TABLE messages
(
 id                  BIGINT AUTO_INCREMENT NOT NULL,
 id_sender           BIGINT NOT NULL,
 id_receiver         BIGINT NOT NULL,
 message             CHARACTER VARYING NOT NULL,
  PRIMARY KEY (id),
  FOREIGN KEY (id_sender) REFERENCES users (id),
  FOREIGN KEY (id_receiver) REFERENCES users (id)
);
INSERT INTO users (login, surname, name,  password)
VALUES('root','Администратор', 'Администратор',
       '$2a$10$LijUmixpYL0i9rRvwXrnX.heUijboQzE3PsoCrxuJANIDVX28FNjS'
       );
INSERT INTO users (login, surname, name,  password)
VALUES('admin','Андрей', 'Пользователь',
       '$2a$10$LijUmixpYL0i9rRvwXrnX.heUijboQzE3PsoCrxuJANIDVX28FNjS'
       );
INSERT INTO messages (id_sender, id_receiver, message)
VALUES(1,2, 'Администратор'
       );




