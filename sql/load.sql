/* Sample data to be inserted at run time */
insert into ScoutTrip (TripDate, Location, MinAge, MinRank) values ('2018-06-01', 'Grand Canyon', 14, 'Star');
insert into ScoutTrip (TripDate, Location, MinAge, MinRank) values ('2018-05-09', 'Mountain Lake', null, null);
insert into ScoutTrip (TripDate, Location, MinAge, MinRank) values ('2018-04-06', 'Camp Ottari', null, 'Tenderfoot');
insert into ScoutTrip (TripDate, Location, MinAge, MinRank) values ('2018-03-12', 'New River', 12, null);
insert into ScoutTrip (TripDate, Location, MinAge, MinRank) values ('2018-02-18', 'Claytor Lake', null, 'Scout');


insert into Scout (Name, DOB, Rank) values ('Joe', '2006-03-21', 'Tenderfoot');
insert into Scout (Name, DOB, Rank) values ('Parikh', '2004-03-21', 'Star');
insert into Scout (Name, DOB, Rank) values ('Timmy', '2002-03-21', 'Eagle');


insert into attends (ScoutTrip_Id, Scout_Id) values (1, 3);
insert into attends (ScoutTrip_Id, Scout_Id) values (2, 1);
insert into attends (ScoutTrip_Id, Scout_Id) values (2, 2);
insert into attends (ScoutTrip_Id, Scout_Id) values (2, 3);

