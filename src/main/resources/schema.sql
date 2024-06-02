CREATE TABLE PRODUCTS(
                         PCODE BIGINT PRIMARY KEY,
                         NAME VARCHAR(100),
                         PRICE DECIMAL(5,2)
);
CREATE TABLE EMPLOYEES(
                          EMPLOYEE_ID BIGINT PRIMARY KEY,
                          FIRST_NAME VARCHAR(100),
                          LAST_NAME VARCHAR(100),
                          LOGIN VARCHAR(100) UNIQUE,
                          PASSWORD VARCHAR(100)
);
CREATE TABLE ORDERS(
                       ORDER_ID BIGINT PRIMARY KEY,
                       NAME VARCHAR(100),
                       LAST_NAME VARCHAR(100),
                       STATUS VARCHAR(15),
                       ORDER_DATE DATETIME,
                       EMPLOYEE_ID BIGINT,
                       FOREIGN KEY (EMPLOYEE_ID) REFERENCES EMPLOYEES(EMPLOYEE_ID)
);
CREATE TABLE PRODUCTSORDERS(
                               ORDER_ID BIGINT PRIMARY KEY ,
                               PCODE BIGINT NOT NULL,
                               QUANTITY INT,
                               FOREIGN KEY(ORDER_ID) REFERENCES ORDERS(ORDER_ID),
                               FOREIGN KEY(PCODE) REFERENCES PRODUCTS(PCODE)
);
