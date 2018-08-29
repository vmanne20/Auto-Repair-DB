/* Sample data to be inserted at run time */
insert into ScoutTrip (id, TripDate, Location, MinAge, MinRank) values (1, '2018-06-01', 'Grand Canyon', 14, 'Star');
insert into ScoutTrip (id, TripDate, Location, MinAge, MinRank) values (2, '2018-05-09', 'Mountain Lake', null, null);
insert into ScoutTrip (id, TripDate, Location, MinAge, MinRank) values (3, '2018-04-06', 'Camp Ottari', null, 'Tenderfoot');
insert into ScoutTrip (id, TripDate, Location, MinAge, MinRank) values (4, '2018-03-12', 'New River', 12, null);
insert into ScoutTrip (id, TripDate, Location, MinAge, MinRank) values (5, '2018-02-18', 'Claytor Lake', null, 'Scout');


insert into Scout (id, Name, DOB, Rank) values (1, 'Joe', '2006-03-21', 'Tenderfoot');
insert into Scout (id, Name, DOB, Rank) values (2, 'Parikh', '2004-03-21', 'Star');
insert into Scout (id, Name, DOB, Rank) values (3, 'Timmy', '2002-03-21', 'Eagle');


insert into attends (ScoutTrip_Id, Scout_Id) values (1, 3);
insert into attends (ScoutTrip_Id, Scout_Id) values (2, 1);
insert into attends (ScoutTrip_Id, Scout_Id) values (2, 2);
insert into attends (ScoutTrip_Id, Scout_Id) values (2, 3);

