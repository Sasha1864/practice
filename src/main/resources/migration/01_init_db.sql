
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

CREATE TABLE questions
(
 id                  BIGINT AUTO_INCREMENT NOT NULL,
 question            CHARACTER VARYING NOT NULL,
 PRIMARY KEY (id),
);

CREATE TABLE answers
(
 id                  BIGINT AUTO_INCREMENT NOT NULL,
 answer            CHARACTER VARYING NOT NULL,
 status            BOOLEAN DEFAULT FALSE NOT NULL,
 id_question       BIGINT NOT NULL,
 PRIMARY KEY (id),
 FOREIGN KEY (id_question) REFERENCES questions (id)
);



CREATE TABLE user_answers
(
 id                  BIGINT AUTO_INCREMENT NOT NULL,
 id_user             BIGINT NOT NULL,
 id_answer           BIGINT NOT NULL,
 PRIMARY KEY (id),
 FOREIGN KEY (id_user) REFERENCES users (id),
 FOREIGN KEY (id_answer) REFERENCES answers (id),
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

INSERT INTO questions (question)
VALUES('Перевод слова собака?');

INSERT INTO answers (answer, status, id_question)
VALUES('cat',FALSE, 1);

INSERT INTO answers (answer, status, id_question)
VALUES('elephant',FALSE, 1);

INSERT INTO answers (answer, status, id_question)
VALUES('dog',TRUE, 1);

INSERT INTO user_answers (id_user, id_answer)
VALUES(1, 3);


