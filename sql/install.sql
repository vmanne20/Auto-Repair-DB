drop table if exists attends cascade;
drop table if exists scouttrip cascade;
drop table if exists scout cascade;
drop table if exists Customer cascade;
drop table if exists Car cascade;
drop table if exists phone_number cascade;

CREATE SEQUENCE ScoutTrip_Id;
CREATE TABLE ScoutTrip
(
  Id INT DEFAULT nextval('ScoutTrip_Id') NOT NULL,
  Location VARCHAR(256) NOT NULL,
  TripDate DATE NOT NULL,
  MinAge VARCHAR(16),
  MinRank VARCHAR(16),
  PRIMARY KEY (Id),
  UNIQUE (TripDate)
);

CREATE SEQUENCE Scout_Id;
CREATE TABLE Scout
(
  Id INT DEFAULT nextval('Scout_Id') NOT NULL,
  Name VARCHAR(60) NOT NULL,
  DOB DATE NOT NULL,
  Rank VARCHAR(60) NOT NULL,
  tempfield VARCHAR(60) NOT NULL,
  PRIMARY KEY (Id),
  UNIQUE (Name)
);

CREATE TABLE Attends
(
  ScoutTrip_Id INT NOT NULL,
  Scout_Id INT NOT NULL,
  PRIMARY KEY (ScoutTrip_Id, Scout_Id),
  FOREIGN KEY (ScoutTrip_Id) REFERENCES ScoutTrip(Id),
  FOREIGN KEY (Scout_Id) REFERENCES Scout(Id)
);


CREATE SEQUENCE customer_ID;
CREATE TABLE Customer
(
  customer_ID INT DEFAULT nextval('customer_ID') NOT NULL,
  c_name VARCHAR NOT NULL,
  c_address VARCHAR NOT NULL,
  PRIMARY KEY (customer_ID)
);

CREATE SEQUENCE car_ID;
CREATE TABLE Car
(
  car_ID INT DEFAULT nextval('car_ID') NOT NULL,
  make_year INT NOT NULL,
  make VARCHAR NOT NULL,
  model VARCHAR NOT NULL,
  customer_ID INT NOT NULL,
  PRIMARY KEY (car_ID),
  FOREIGN KEY (customer_ID) REFERENCES Customer(customer_ID)
);

CREATE TABLE PhoneNumber
(
  c_number CHAR(20) NOT NULL,
  customer_ID INT NOT NULL,
  PRIMARY KEY (c_number, customer_ID),
  FOREIGN KEY (customer_ID) REFERENCES Customer(customer_ID)
);
