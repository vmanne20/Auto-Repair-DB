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

/* Sample data to be inserted at run time .
*/
insert into Customer (customer_ID, c_name, c_address) values (1, 'Carl Yao', '130 Main St.');
insert into Customer (customer_ID, c_name, c_address) values (2, 'Vamsi Manne', '220 Main St.');
insert into Customer (customer_ID, c_name, c_address) values (3, 'Sid Hingorani', '50 Main St.');
insert into Customer (customer_ID, c_name, c_address) values (4, 'AJ Goudel', '500 Main St.');
insert into Customer (customer_ID, c_name, c_address) values (5, 'Bob Smith', '780 Main St.');
insert into Customer (customer_ID, c_name, c_address) values (6, 'Jack Davis', '320 Main St.');
insert into Customer (customer_ID, c_name, c_address) values (7, 'John Wellesley', '455 Main St.');
insert into Customer (customer_ID, c_name, c_address) values (8, 'Donald Trump', '1600 Pennsylvania Ave.');
insert into Customer (customer_ID, c_name, c_address) values (9, 'Robert Mueller', '10 First St.');
insert into Customer (customer_ID, c_name, c_address) values (10, 'Nancy Pelosi', '10 First St.');

insert into Car (car_ID, make_year, make, model, customer_ID) values (1, '2001', 'Honda', 'Accord', 2);
insert into Car (car_ID, make_year, make, model, customer_ID) values (2, '2004', 'Mazda', 'CX-9', 1);
insert into Car (car_ID, make_year, make, model, customer_ID) values (3, '2005', 'BMW', '335i', 3);
insert into Car (car_ID, make_year, make, model, customer_ID) values (4, '2007', 'Mercedes-Benz', 'C200', 4);
insert into Car (car_ID, make_year, make, model, customer_ID) values (5, '2009', 'Audi', 'A6', 6);
insert into Car (car_ID, make_year, make, model, customer_ID) values (6, '1996', 'Ford', 'Taurus', 7);
insert into Car (car_ID, make_year, make, model, customer_ID) values (7, '2015', 'Toyota', 'Corolla', 5);
insert into Car (car_ID, make_year, make, model, customer_ID) values (8, '2018', 'Honda', 'Civic', 2);
insert into Car (car_ID, make_year, make, model, customer_ID) values (9, '2003', 'Toyota', 'Camry', 10);
insert into Car (car_ID, make_year, make, model, customer_ID) values (10, '2008', 'Honda', 'Pilot', 9);
insert into Car (car_ID, make_year, make, model, customer_ID) values (11, '1990', 'Dodge', 'Ram', 8);
insert into Car (car_ID, make_year, make, model, customer_ID) values (12, '2005', 'BMW', 'X5', 1);
insert into Car (car_ID, make_year, make, model, customer_ID) values (13, '2013', 'Audi', 'Q7', 2);
insert into Car (car_ID, make_year, make, model, customer_ID) values (14, '2018', 'BMW', 'X7', 10);
insert into Car (car_ID, make_year, make, model, customer_ID) values (15, '1999', 'Audi', 'A4', 8);

insert into PhoneNumber (customer_ID, c_number) values (1, '(316) 874-3435');
insert into PhoneNumber (customer_ID, c_number) values (1, '(375) 529-2179');
insert into PhoneNumber (customer_ID, c_number) values (1, '(989) 470-4397');
insert into PhoneNumber (customer_ID, c_number) values (2, '(204) 386-9308');
insert into PhoneNumber (customer_ID, c_number) values (2, '(921) 781-7476');
insert into PhoneNumber (customer_ID, c_number) values (3, '(827) 406-8498');
insert into PhoneNumber (customer_ID, c_number) values (4, '(554) 690-6469');
insert into PhoneNumber (customer_ID, c_number) values (5, '(224) 761-3489');
insert into PhoneNumber (customer_ID, c_number) values (6, '(911) 489-2920');
insert into PhoneNumber (customer_ID, c_number) values (6, '(310) 301-4766');
insert into PhoneNumber (customer_ID, c_number) values (7, '(607) 857-3535');
insert into PhoneNumber (customer_ID, c_number) values (7, '(383) 554-7756');
insert into PhoneNumber (customer_ID, c_number) values (7, '(807) 472-8953');
insert into PhoneNumber (customer_ID, c_number) values (8, '(824) 791-9502');
insert into PhoneNumber (customer_ID, c_number) values (8, '(383) 588-5457');
insert into PhoneNumber (customer_ID, c_number) values (9, '(311) 582-5381');
insert into PhoneNumber (customer_ID, c_number) values (10, '(679) 939-5399');
insert into PhoneNumber (customer_ID, c_number) values (10, '(971) 559-5233');


