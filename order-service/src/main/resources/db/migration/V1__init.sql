CREATE TABLE SALE_ORDER (
	
  ID VARCHAR (255) NOT NULL,
	BUYER_NAME VARCHAR (50) NOT NULL,
  STATUS VARCHAR (50) NOT NULL DEFAULT ('created'),
	CREATED_ON TIMESTAMP WITH TIME ZONE DEFAULT CURRENT_TIMESTAMP,

  CONSTRAINT ORDER_PK PRIMARY KEY (ID)

);

CREATE TABLE ORDER_PACKAGE (
	
  ID VARCHAR (255) NOT NULL,
  SALE_ORDER_ID VARCHAR (255) NOT NULL,
	PRODUCT_GTIN VARCHAR (14) NOT NULL,
  AMOUNT  INTEGER NOT NULL, 
  STATUS VARCHAR (50) NOT NULL DEFAULT ('created'),
	CREATED_ON TIMESTAMP WITH TIME ZONE DEFAULT CURRENT_TIMESTAMP,

  CONSTRAINT ORDER_PACKAGE_PK PRIMARY KEY (ID),
  CONSTRAINT SALE_ORDER_PACKAGE FOREIGN KEY (SALE_ORDER_ID)
    REFERENCES SALE_ORDER(ID)
);