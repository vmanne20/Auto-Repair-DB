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


CREATE SEQUENCE Customer_Id;
CREATE TABLE Customer
(
  customer_id INT DEFAULT nextval('Customer_Id') NOT NULL,
  c_name VARCHAR(60) NOT NULL,
  c_address VARCHAR(100) NOT NULL,
  PRIMARY KEY (customer_id)
);

CREATE SEQUENCE Phone_Id;
CREATE TABLE phone_number
(
  p_id INT DEFAULT nextval('Phone_Id') NOT NULL,
  c_id VARCHAR(20) NOT NULL,
  c_name VARCHAR(60) NOT NULL,
  c_number VARCHAR(20) NOT NULL,
  PRIMARY KEY (p_id)
--   FOREIGN KEY (customer_id) REFERENCES Customer(customer_id)
);

CREATE SEQUENCE car_ID;
CREATE TABLE Car
(
  car_ID INT DEFAULT nextval('car_ID') NOT NULL,
  make_year VARCHAR(5) NOT NULL,
  make VARCHAR(60) NOT NULL,
  model VARCHAR(60) NOT NULL,
  customer_id INT NOT NULL,
  PRIMARY KEY (car_ID),
  FOREIGN KEY (customer_id) REFERENCES Customer(customer_id)
);


