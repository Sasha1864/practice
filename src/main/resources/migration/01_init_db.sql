
CREATE TABLE users
(
  id                  BIGINT AUTO_INCREMENT NOT NULL,                    -- // уникальный идентификатор
  login               CHARACTER VARYING NOT NULL UNIQUE,     -- // логин
  surname             CHARACTER VARYING NOT NULL,            -- // фамилия
  name                CHARACTER VARYING NOT NULL,            -- // имя
  password            CHARACTER VARYING NOT NULL,            -- // пароль
  date_create         TIMESTAMP NOT NULL,                    -- // дата создания
  date_close          TIMESTAMP,
  PRIMARY KEY (id),
);
CREATE TABLE messages
(
 id                  BIGINT AUTO_INCREMENT NOT NULL,
 id_sender           BIGINT NOT NULL,
 id_receiver         BIGINT NOT NULL,
 message             CHARACTER VARYING NOT NULL,
 date_create         TIMESTAMP NOT NULL,                    -- // дата создания
 date_close          TIMESTAMP,
  PRIMARY KEY (id),
  FOREIGN KEY (id_sender) REFERENCES users (id),
  FOREIGN KEY (id_receiver) REFERENCES users (id)
);

CREATE TABLE countries
(
 id                  BIGINT AUTO_INCREMENT NOT NULL,
 name                CHARACTER VARYING NOT NULL,
 image               CHARACTER VARYING NOT NULL,
 date_create         TIMESTAMP NOT NULL,                    -- // дата создания
 date_close          TIMESTAMP,
 PRIMARY KEY (id)
);

CREATE TABLE questions
(
 id                  BIGINT AUTO_INCREMENT NOT NULL,
 id_country          BIGINT NOT NULL,
 question            CHARACTER VARYING NOT NULL,
 date_create         TIMESTAMP NOT NULL,                    -- // дата создания
 date_close          TIMESTAMP,
 PRIMARY KEY (id),
 FOREIGN KEY (id_country) REFERENCES countries (id)
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
 date_create       TIMESTAMP NOT NULL,
  date_update       TIMESTAMP,
 PRIMARY KEY (id),
 FOREIGN KEY (id_user) REFERENCES users (id),
 FOREIGN KEY (id_answer) REFERENCES answers (id),
);


INSERT INTO users (login, surname, name,  password, date_create)
VALUES('root','Администратор', 'Администратор',
       '$2a$10$LijUmixpYL0i9rRvwXrnX.heUijboQzE3PsoCrxuJANIDVX28FNjS', '2019-04-25');

INSERT INTO users (login, surname, name,  password, date_create)
VALUES('admin','Андрей', 'Пользователь',
       '$2a$10$LijUmixpYL0i9rRvwXrnX.heUijboQzE3PsoCrxuJANIDVX28FNjS', '2019-04-25');

INSERT INTO messages (id_sender, id_receiver, message, date_create)
VALUES(1,2, 'Администратор', '2019-04-25' );

INSERT INTO countries (name, image, date_create)
VALUES('Ukraine', 'https://cf.ppt-online.org/files2/slide/e/eSlwcx6dTURr2mXCLnjNKyE4kHAPtZBpsFao1v/slide-2.jpg', '2019-04-25');

INSERT INTO countries (name, image, date_create)
VALUES('Poland', 'https://cf.ppt-online.org/files2/slide/e/eSlwcx6dTURr2mXCLnjNKyE4kHAPtZBpsFao1v/slide-2.jpg', '2019-04-25');

INSERT INTO questions (question, id_country, date_create)
VALUES('Перевод слова собака?', 1, '2019-04-25');

INSERT INTO questions (question, id_country, date_create)
VALUES('Перевод слова кот?', 1, '2019-04-25');

INSERT INTO questions (question, id_country, date_create)
VALUES('Перевод слова море?', 2, '2019-04-25');

INSERT INTO answers (answer, status, id_question)
VALUES('cat',FALSE, 1);

INSERT INTO answers (answer, status, id_question)
VALUES('elephant',FALSE, 1);

INSERT INTO answers (answer, status, id_question)
VALUES('dog',TRUE, 1);

INSERT INTO answers (answer, status, id_question)
VALUES('cat',TRUE, 2);

INSERT INTO answers (answer, status, id_question)
VALUES('elephant',FALSE, 2);

INSERT INTO answers (answer, status, id_question)
VALUES('sea',TRUE, 3);

INSERT INTO answers (answer, status, id_question)
VALUES('grey',FALSE, 3);

INSERT INTO user_answers (id_user, id_answer, date_create)
VALUES(1, 3, '2019-04-25');



