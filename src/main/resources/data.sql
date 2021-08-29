
INSERT INTO USERS (FULL_NAME,NICK_NAME,CLIENT_TYPE,EMAIL,PASSWORD,PHONE_NUMBER, CREATED_AT) VALUES

    ('Marcin Wozniak','XYZ','GOLD','marcin0207@gmail.com','$2a$10$bNc2gBD6P/1lsi4WlPQmPuTLzwwCeAo7NeMgD8qb5kFcyHWxL8PrO','665 694 088','2000-04-11 09:31:15'),
    ('Adam Mickiewicz','Wieszczu','SILVER','adammiszcz@wp.pl','def','444 444 444','2000-04-11 09:31:15'),
    ('Jan Nowak','Zajebisty669','SILVER','nowak7@gmail.com','zxc','555 555 555','2011-11-11 09:31:15');

INSERT INTO ADDRESSES (ADDRESS_NAME,CITY,COUNTRY,HOUSE_NUMBER,IS_DEFAULT,LOCAL_NUMBER,POSTAL_CODE,STREET,USER_ID) VALUES
    ('Dom','Warszawa','Polska','10',TRUE,'24','04-359','Kobielska',1),
    ('Wakacyjny Dom','Sopot','Polska','3',TRUE,'9','80-336','Bohaterów Monte Casino',2),
    ('Jeszcze bardziej wakacyjny dom','Split','Chorwacja','14A',TRUE,'244','21312','Grljevačka',3);

INSERT INTO ORDERS (CREATED_AT,DELIVERY_DATE,ORDER_STATUS,PRICE,USER_ID) VALUES
    ('2021-05-02 11:33:32','2021-05-05 09:33:32','DELIVERED','15',1),
    ('2021-06-12 21:28:52','2021-06-14 07:03:47','RETURNED_AND_PAID','25',2),
    ('2021-05-22 16:03:25','2021-05-25 08:12:38','DELIVERED','20',3);

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

INSERT INTO RATES (COMMENT,VALUE,MOVIE_ID,USER_ID) VALUES
  ('Słabizna, zmarnowane 2 godziny życia',3,1,2),
  ('Słabizna, zmarnowane 3 godziny życia',2,2,2),
  ('kto robi te filmy?!',1,3,2),
  ('takie o, lepsze niż jedynka',6,1,1),
  ('no romantyczne takie nawet :)',8,2,1),
  ('o co w tym chodziło?',4,3,3);
INSERT INTO ORDER_ARCHIVE (A_ORDER_ID,A_MOVIE_ID,USER_ID,ORDER_CREATED_AT,FINAL_PRICE) VALUES
  (1,1,2,'2001-04-11 09:31:15',30),
  (1,2,2,'2001-04-11 09:31:15',30),
  (1,3,2,'2001-04-11 09:31:15',30),
  (2,1,1,'2001-05-25 09:31:15',20),
  (2,2,1,'2001-05-25 09:31:15',20),
  (3,3,3,'2001-05-25 09:31:15',10);


 INSERT INTO ROLE (ID,NAME) VALUES
    (1,'ROLE_ADMIN'),
    (2,'ROLE_STAFF'),
    (3,'ROLE_USER');

 INSERT INTO USERS_ROLES (USER_ID, ROLE_ID) VALUES
    (1,1),
    (2,3),
    (2,3);