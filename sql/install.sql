drop table if exists attends cascade;
drop table if exists scouttrip cascade;
drop table if exists scout cascade;

drop table if exists customer cascade;
drop table if exists car cascade;
drop table if exists phone_number cascade;

drop table if exists repair;
drop table if exists mechanic;
drop table if exists certification;
drop table if exists car_repair_mechanic;
drop table if exists repair_certification;
drop table if exists mechanic_certification;

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
CREATE TABLE customer
(
  c_id INT DEFAULT nextval('Customer_Id') NOT NULL,
  c_name VARCHAR(60) NOT NULL,
  c_address VARCHAR(100) NOT NULL,
  PRIMARY KEY (c_id)
);

CREATE SEQUENCE Phone_Id;
CREATE TABLE phone_number
(
    p_id INT DEFAULT nextval('Phone_Id') NOT NULL,
    c_id INT NOT NULL,
    p_number VARCHAR(20) NOT NULL,
    PRIMARY KEY (p_id),
    FOREIGN KEY (c_id) REFERENCES customer(c_id),
    UNIQUE (p_number)
);

CREATE SEQUENCE Car_ID;
CREATE TABLE car
(
  car_id INT DEFAULT nextval('Car_ID') NOT NULL,
  c_id INT NOT NULL,
  make_year VARCHAR(5) NOT NULL,
  make VARCHAR(60) NOT NULL,
  model VARCHAR(60) NOT NULL,
  PRIMARY KEY (car_id),
  FOREIGN KEY (c_id) REFERENCES customer(c_id)
);

CREATE SEQUENCE Repair_ID;
CREATE TABLE repair
(
  r_id INT DEFAULT nextval('Repair_ID') NOT NULL,
  r_name VARCHAR(100) NOT NULL,
  r_descript VARCHAR(500) NOT NULL,
  parts_cost FLOAT NOT NULL,
  r_time FLOAT NOT NULL,
  PRIMARY KEY (r_id)
);

CREATE SEQUENCE Mech_ID;
CREATE TABLE mechanic
(
  m_id INT DEFAULT nextval('Mech_ID') NOT NULL,
  m_name VARCHAR(60) NOT NULL,
  years_exp INT NOT NULL,
  hourly_rate FLOAT NOT NULL,
  PRIMARY KEY (m_id)
);

-- TERNARY RELATIONSHIP TABLE
CREATE TABLE car_repair_mechanic
(
  car_id INT NOT NULL,
  m_id INT NOT NULL,
  r_id INT NOT NULL,
  r_date VARCHAR(100) NOT NULL, 
  PRIMARY KEY (car_id, m_id, r_id),
  FOREIGN KEY (car_id) REFERENCES car(car_id),
  FOREIGN KEY (m_id) REFERENCES mechanic(m_id),
  FOREIGN KEY (r_id) REFERENCES repair(r_id)
);

-- CREATE VIEW repair_info
-- (
--   car_id INT NOT NULL,
--   m_id INT NOT NULL,
--   r_id INT NOT NULL,
--   r_date VARCHAR(100) NOT NULL, 
--   PRIMARY KEY (car_id, m_id, r_id),
--   FOREIGN KEY (car_id) REFERENCES car(car_id),
--   FOREIGN KEY (m_id) REFERENCES mechanic(m_id),
--   FOREIGN KEY (r_id) REFERENCES repair(r_id)
-- );

CREATE SEQUENCE Cert_ID;
CREATE TABLE certification
(
  cert_id INT DEFAULT nextval('Cert_ID') NOT NULL,
  cert_name VARCHAR(100) NOT NULL,
  PRIMARY KEY (cert_id)
--   FOREIGN KEY (r_id) REFERENCES repair(r_id),
--   FOREIGN KEY (m_id) REFERENCES mechanic(m_id)
);

CREATE TABLE repair_certification
(
  r_id INT NOT NULL,
  cert_id INT NOT NULL,
  PRIMARY KEY (r_id, cert_id),
  FOREIGN KEY (r_id) REFERENCES repair(r_id),
  FOREIGN KEY (cert_id) REFERENCES certification(cert_id)
);

CREATE TABLE mechanic_certification
(
  m_id INT NOT NULL,
  cert_id INT NOT NULL,
  PRIMARY KEY (m_id, cert_id),
  FOREIGN KEY (m_id) REFERENCES mechanic(m_id),
  FOREIGN KEY (cert_id) REFERENCES certification(cert_id)
);

