
INSERT INTO USERS (FULL_NAME,NICK_NAME,CLIENT_TYPE,EMAIL,PASSWORD,PHONE_NUMBER, CREATED_AT) VALUES
  ('Marcin Wozniak','XYZ','GOLD','marcin0207@gmail.com','abc','665 694 088','2000-04-11 09:31:15'),
  ('Adam Mickiewicz','Wieszczu','SILVER','adammiszcz@wp.pl','def','444 444 444','2000-04-11 09:31:15'),
  ('Jan Nowak','Zajebisty669','SILVER','nowak7@gmail.com','zxc','555 555 555','2011-11-11 09:31:15');

INSERT INTO MOVIES (AVG_RATE,DESCRIPTION,DIRECTOR,MOVIE_GENRE,PREMIERE_DATE,TITLE,MOVIE_STATUS,CREATED_AT) VALUES
  ('9.3','Niepełnosprawny weteran wciela się w obce ciało by poderwać niebieską kosmitkę','James Cameron','SCI_FI','2009-12-25','Avatar','CLASSIC', '2000-04-11 09:31:15'),
  ('7.8','Duch z depresją nawiedza dzieciaka swoimi problemami małrzeńskimi','M. Night Shaymalan','THRILLER','2000-01-14','Szósty zmysł','CLASSIC','2000-04-11 09:31:15'),
  ('6.7','Były pastor przetrzymuje w piwnicy imigranta cierpiącego na wodostręt','M. Night Shaymalan','THRILLER','2002-11-08','Znaki','CLASSIC','2000-04-11 09:31:15');

INSERT INTO COPIES (MOVIE_ID, ORDER_ID) VALUES

(1,1),
(2,1),
(3,1);

INSERT INTO COPIES (MOVIE_ID) VALUES

(1),
(1),
(2),
(2),
(2),
(3),
(3),
(2);
