drop table if exists attends cascade;
drop table if exists scouttrip cascade;
drop table if exists scout cascade;

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

