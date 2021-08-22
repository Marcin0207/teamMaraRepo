
INSERT INTO USERS (FULL_NAME,NICK_NAME,CLIENT_TYPE,EMAIL,PASSWORD,PHONE_NUMBER, CREATED_AT) VALUES
    ('Marcin Wozniak','XYZ','GOLD','marcin0207@gmail.com','abc','665 694 088','2000-04-11 09:31:15'),
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