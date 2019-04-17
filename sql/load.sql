/* Sample data to be inserted at run time 
   Note we fudge the dates to provide meaningful examples in the interface.
*/
insert into ScoutTrip (TripDate, Location, MinAge, MinRank) values (current_date, 'Grand Canyon', 14, 'Star');
insert into ScoutTrip (TripDate, Location, MinAge, MinRank) values (current_date - interval '8 days', 'Mountain Lake', null, null);
insert into ScoutTrip (TripDate, Location, MinAge, MinRank) values (current_date - interval '90 days', 'Camp Ottari', null, 'Tenderfoot');
insert into ScoutTrip (TripDate, Location, MinAge, MinRank) values (current_date - interval '7 months', 'New River', 12, null);
insert into ScoutTrip (TripDate, Location, MinAge, MinRank) values ('2018-02-18', 'Claytor Lake', null, 'Scout');


insert into Scout (Name, DOB, Rank, tempfield) values ('Joe', '2006-03-21', 'Tenderfoot', 'hello');
insert into Scout (Name, DOB, Rank, tempfield) values ('Parikh', '2004-03-21', 'Star', 'hello');
insert into Scout (Name, DOB, Rank, tempfield) values ('Timmy', '2002-03-21', 'Eagle', 'hello');
insert into Scout (Name, DOB, Rank, tempfield) values ('Sally', '2008-03-21', 'First Class', 'hello');
insert into Scout (Name, DOB, Rank, tempfield) values ('Lazy Larry', '2006-03-21', 'Scout', 'hello');

insert into attends (ScoutTrip_Id, Scout_Id) values (1, 3);
insert into attends (ScoutTrip_Id, Scout_Id) values (2, 1);
insert into attends (ScoutTrip_Id, Scout_Id) values (3, 2);
insert into attends (ScoutTrip_Id, Scout_Id) values (4, 4);


insert into Customer (c_name, c_address) values ('Carl Yao', '130 Main St.');
insert into Customer (c_name, c_address) values ('Vamsi Manne', '220 Main St.');
insert into Customer (c_name, c_address) values ('Sid Hingorani', '50 Main St.');
insert into Customer (c_name, c_address) values ('AJ Goudel', '500 Main St.');
insert into Customer (c_name, c_address) values ('Bob Smith', '780 Main St.');
insert into Customer (c_name, c_address) values ('Jack Davis', '320 Main St.');
insert into Customer (c_name, c_address) values ('John Wellesley', '455 Main St.');
insert into Customer (c_name, c_address) values ('Donald Trump', '1600 Pennsylvania Ave.');
insert into Customer (c_name, c_address) values ('Robert Mueller', '10 First St.');
insert into Customer (c_name, c_address) values ('Nancy Pelosi', '10 First St.');

insert into Car (c_id, c_name, make_year, make, model) values (2, 'Vamsi Manne', '2001', 'Honda', 'Accord');
insert into Car (c_id, c_name, make_year, make, model) values (1, 'Carl Yao', '2004', 'Mazda', 'CX-9');
insert into Car (c_id, c_name, make_year, make, model) values (3, 'Sid Hingorani', '2005', 'BMW', '335i');
insert into Car (c_id, c_name, make_year, make, model) values (4, 'AJ Goudel', '2007', 'Mercedes-Benz', 'C200');
insert into Car (c_id, c_name, make_year, make, model) values (6, 'Jack Davis', '2009', 'Audi', 'A6');
insert into Car (c_id, c_name, make_year, make, model) values (7, 'John Wellesley', '1996', 'Ford', 'Taurus');
insert into Car (c_id, c_name, make_year, make, model) values (5, 'Bob Smith', '2015', 'Toyota', 'Corolla');
insert into Car (c_id, c_name, make_year, make, model) values (2, 'Vamsi Manne', '2018', 'Honda', 'Civic');
insert into Car (c_id, c_name, make_year, make, model) values (10, 'Nancy Pelosi', '2003', 'Toyota', 'Camry');
insert into Car (c_id, c_name, make_year, make, model) values (9, 'Robert Mueller', '2008', 'Honda', 'Pilot');

insert into phone_number (c_id, c_name, c_number) values (1, , 'Carl Yao', '(316) 874-3435');
insert into phone_number (c_id, c_name, c_number) values (8, 'Donald Trump', '(703) 234-1209');
insert into phone_number (c_id, c_name, c_number) values (5, 'Bob Smith', '(404) 234-9742');
insert into phone_number (c_id, c_name, c_number) values (2, 'Vamsi Manne', '(316) 874-3435');
insert into phone_number (c_id, c_name, c_number) values (3, 'Sid Hingorani', '(375) 529-2179');
insert into phone_number (c_id, c_name, c_number) values (4, 'AJ Goudel', '(989) 470-4397');
insert into phone_number (c_id, c_name, c_number) values (6, 'Jack Davis', '(224) 761-3489');
insert into phone_number (c_id, c_name, c_number) values (7, 'John Wellesley', '(703) 434-2487');
insert into phone_number (c_id, c_name, c_number) values (8, 'Donald Trump', '(311) 582-5381');
insert into phone_number (c_id, c_name, c_number) values (9, 'Robert Mueller', '(554) 690-6469');


-- insert into phone_number (c_id, c_number) values ('1', '(316) 874-3435');
-- insert into phone_number (c_id, c_number) values ('8', '(703) 234-1209');
-- insert into phone_number (c_id, c_number) values ('5', '(404) 234-9742');

-- insert into PhoneNumber (customer_ID, c_number) values (1, '(316) 874-3435');
-- insert into PhoneNumber (customer_ID, c_number) values (1, '(375) 529-2179');
-- insert into PhoneNumber (customer_ID, c_number) values (1, '(989) 470-4397');
-- insert into PhoneNumber (customer_ID, c_number) values (2, '(204) 386-9308');
-- insert into PhoneNumber (customer_ID, c_number) values (2, '(921) 781-7476');
-- insert into PhoneNumber (customer_ID, c_number) values (3, '(827) 406-8498');
-- insert into PhoneNumber (customer_ID, c_number) values (4, '(554) 690-6469');
-- insert into PhoneNumber (customer_ID, c_number) values (5, '(224) 761-3489');
-- insert into PhoneNumber (customer_ID, c_number) values (6, '(911) 489-2920');
-- insert into PhoneNumber (customer_ID, c_number) values (6, '(310) 301-4766');
-- insert into PhoneNumber (customer_ID, c_number) values (7, '(607) 857-3535');
-- insert into PhoneNumber (customer_ID, c_number) values (7, '(383) 554-7756');
-- insert into PhoneNumber (customer_ID, c_number) values (7, '(807) 472-8953');
-- insert into PhoneNumber (customer_ID, c_number) values (8, '(824) 791-9502');
-- insert into PhoneNumber (customer_ID, c_number) values (8, '(383) 588-5457');
-- insert into PhoneNumber (customer_ID, c_number) values (9, '(311) 582-5381');
-- insert into PhoneNumber (customer_ID, c_number) values (10, '(679) 939-5399');
-- insert into PhoneNumber (customer_ID, c_number) values (10, '(971) 559-5233');


