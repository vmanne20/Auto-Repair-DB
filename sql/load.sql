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

insert into customer (c_name, c_address) values ('Carl Yao', '130 Main St.');
insert into customer (c_name, c_address) values ('Vamsi Manne', '220 Main St.');
insert into customer (c_name, c_address) values ('Sid Hingorani', '50 Main St.');
insert into customer (c_name, c_address) values ('AJ Goudel', '500 Main St.');
insert into customer (c_name, c_address) values ('Bob Smith', '780 Main St.');
insert into customer (c_name, c_address) values ('Jack Davis', '320 Main St.');
insert into customer (c_name, c_address) values ('John Wellesley', '455 Main St.');
insert into customer (c_name, c_address) values ('Donald Trump', '1600 Pennsylvania Ave.');
insert into customer (c_name, c_address) values ('Robert Mueller', '10 First St.');
insert into customer (c_name, c_address) values ('Nancy Pelosi', '10 First St.');

insert into phone_number (c_id, p_number) values (1, '(316) 874-3435');
insert into phone_number (c_id, p_number) values (1, '(703) 234-1209');
insert into phone_number (c_id, p_number) values (1, '(404) 234-9742');
insert into phone_number (c_id, p_number) values (1, '(304) 237-2349');
insert into phone_number (c_id, p_number) values (2, '(375) 529-2179');
insert into phone_number (c_id, p_number) values (2, '(989) 470-4397');
insert into phone_number (c_id, p_number) values (2, '(224) 761-3489');
insert into phone_number (c_id, p_number) values (3, '(703) 434-2487');
insert into phone_number (c_id, p_number) values (3, '(311) 582-5381');
insert into phone_number (c_id, p_number) values (4, '(554) 690-6469');
insert into phone_number (c_id, p_number) values (4, '(316) 874-3435');
insert into phone_number (c_id, p_number) values (4, '(375) 529-2179');
insert into phone_number (c_id, p_number) values (4, '(989) 470-4397');
insert into phone_number (c_id, p_number) values (5, '(204) 386-9308');
insert into phone_number (c_id, p_number) values (5, '(921) 781-7476');
insert into phone_number (c_id, p_number) values (6, '(827) 406-8498');
insert into phone_number (c_id, p_number) values (7, '(554) 690-6469');
insert into phone_number (c_id, p_number) values (7, '(224) 761-3489');
insert into phone_number (c_id, p_number) values (7, '(911) 489-2920');
insert into phone_number (c_id, p_number) values (8, '(310) 301-4766');
insert into phone_number (c_id, p_number) values (8, '(607) 857-3535');
insert into phone_number (c_id, p_number) values (8, '(383) 554-7756');
insert into phone_number (c_id, p_number) values (8, '(807) 472-8953');
insert into phone_number (c_id, p_number) values (9, '(824) 791-9502');
insert into phone_number (c_id, p_number) values (9, '(383) 588-5457');
insert into phone_number (c_id, p_number) values (9, '(311) 582-5381');
insert into phone_number (c_id, p_number) values (10, '(679) 939-5399');
insert into phone_number (c_id, p_number) values (10, '(971) 559-5233');

insert into Car (c_id, make_year, make, model) values (1, '2001', 'Honda', 'Accord');
insert into Car (c_id, make_year, make, model) values (1, '2004', 'Mazda', 'CX-9');
insert into Car (c_id, make_year, make, model) values (2, '2005', 'BMW', '335i');
insert into Car (c_id, make_year, make, model) values (2, '2007', 'Mercedes-Benz', 'C200');
insert into Car (c_id, make_year, make, model) values (2, '2009', 'Audi', 'A6');
insert into Car (c_id, make_year, make, model) values (3, '1996', 'Ford', 'Taurus');
insert into Car (c_id, make_year, make, model) values (4, '2015', 'Toyota', 'Corolla');
insert into Car (c_id, make_year, make, model) values (4, '2018', 'Honda', 'Civic');
insert into Car (c_id, make_year, make, model) values (5, '2003', 'Toyota', 'Camry');
insert into Car (c_id, make_year, make, model) values (5, '2008', 'Honda', 'Pilot');
insert into Car (c_id, make_year, make, model) values (6, '1994', 'Aston Martin', 'Vantage');
insert into Car (c_id, make_year, make, model) values (6, '2006', 'Dodge', 'Challenger');
insert into Car (c_id, make_year, make, model) values (6, '2008', 'Ford', 'Mustang');
insert into Car (c_id, make_year, make, model) values (7, '2015', 'Honda', 'Odyssey');
insert into Car (c_id, make_year, make, model) values (7, '2013', 'Toyota', 'Sienna');
insert into Car (c_id, make_year, make, model) values (8, '1987', 'Chevrolet', 'Camaro');
insert into Car (c_id, make_year, make, model) values (9, '2009', 'Volkswagen', 'Golf');
insert into Car (c_id, make_year, make, model) values (10, '2018', 'Toyota', 'Camry');

insert into repair (r_name, r_descript, parts_cost, r_time) values ('Brakes', 'fix braking system', 25.00, 2.5);
insert into repair (r_name, r_descript, parts_cost, r_time) values ('Engine', 'replace or tune engine, solve engine light problems', 50.00, 3.0);
insert into repair (r_name, r_descript, parts_cost, r_time) values ('Flywheel', 'replace or fix flywheel in wheel', 15.00, 2.5);
insert into repair (r_name, r_descript, parts_cost, r_time) values ('Oil Change', 'replace oil and oil filter', 10.00, 2.0);
insert into repair (r_name, r_descript, parts_cost, r_time) values ('Fuel Injection', 'clean or replace fuel injector', 30.00, 3.0);
insert into repair (r_name, r_descript, parts_cost, r_time) values ('Tires', 'replace tires', 20.00, 1.5);
insert into repair (r_name, r_descript, parts_cost, r_time) values ('Transmission', 'fix or replace drums, pumps, shafts, or converters', 70.00, 4.0);
insert into repair (r_name, r_descript, parts_cost, r_time) values ('Clutch', 'replace or fix clutch', 20.00, 2.0);
insert into repair (r_name, r_descript, parts_cost, r_time) values ('Ignition', 'fix ignition lock and cylinder', 20.00, 3.5);
insert into repair (r_name, r_descript, parts_cost, r_time) values ('Cooling System', 'clean or replace cooling system', 30.00, 3.0);

insert into mechanic (m_name, years_exp, hourly_rate) values ('John Hammer', 2, 15.00);
insert into mechanic (m_name, years_exp, hourly_rate) values ('Bob Smith', 3, 17.00);
insert into mechanic (m_name, years_exp, hourly_rate) values ('Tucker Carlson', 1, 12.00);
insert into mechanic (m_name, years_exp, hourly_rate) values ('Sean Hannity', 2, 15.00);
insert into mechanic (m_name, years_exp, hourly_rate) values ('Dustin Rockwell', 5, 20.00);
insert into mechanic (m_name, years_exp, hourly_rate) values ('James Thomas', 7, 25.00);
insert into mechanic (m_name, years_exp, hourly_rate) values ('Connor Giles', 1, 12.00);
insert into mechanic (m_name, years_exp, hourly_rate) values ('Shane Black', 1, 12.00);
insert into mechanic (m_name, years_exp, hourly_rate) values ('Robert Downey, Jr.', 3, 17.00);
insert into mechanic (m_name, years_exp, hourly_rate) values ('Chris Evans', 5, 20.00);


-- CERTIFICATIONS
insert into certification (cert_name) values ('Brakes');
insert into certification (cert_name) values ('Electronic Systems');
insert into certification (cert_name) values ('Engine Repair');
insert into certification (cert_name) values ('Suspension and Drive Train');
insert into certification (cert_name) values ('Axles');
insert into certification (cert_name) values ('Automatic Transmission');
insert into certification (cert_name) values ('Heating and Air Conditioning');

-- repair_certification
insert into repair_certification (r_id, cert_id) values (1, 1);
insert into repair_certification (r_id, cert_id) values (1, 2);
insert into repair_certification (r_id, cert_id) values (2, 2);
insert into repair_certification (r_id, cert_id) values (2, 3);
insert into repair_certification (r_id, cert_id) values (2, 4);
insert into repair_certification (r_id, cert_id) values (3, 5);
insert into repair_certification (r_id, cert_id) values (5, 2);
insert into repair_certification (r_id, cert_id) values (5, 4);
insert into repair_certification (r_id, cert_id) values (5, 6);
insert into repair_certification (r_id, cert_id) values (6, 5);

insert into repair_certification (r_id, cert_id) values (7, 2);
insert into repair_certification (r_id, cert_id) values (7, 4);
insert into repair_certification (r_id, cert_id) values (7, 6);
insert into repair_certification (r_id, cert_id) values (8, 2);
insert into repair_certification (r_id, cert_id) values (8, 4);
insert into repair_certification (r_id, cert_id) values (9, 2);
insert into repair_certification (r_id, cert_id) values (9, 4);
insert into repair_certification (r_id, cert_id) values (10, 2);
insert into repair_certification (r_id, cert_id) values (10, 7);


-- mechanic_certification
insert into mechanic_certification (m_id, cert_id) values (1, 1);
insert into mechanic_certification (m_id, cert_id) values (1, 2);
insert into mechanic_certification (m_id, cert_id) values (1, 5);
insert into mechanic_certification (m_id, cert_id) values (1, 4);
insert into mechanic_certification (m_id, cert_id) values (2, 5);
insert into mechanic_certification (m_id, cert_id) values (2, 2);
insert into mechanic_certification (m_id, cert_id) values (2, 4);
insert into mechanic_certification (m_id, cert_id) values (2, 6);
insert into mechanic_certification (m_id, cert_id) values (3, 2);
insert into mechanic_certification (m_id, cert_id) values (3, 7);

insert into mechanic_certification (m_id, cert_id) values (4, 2);
insert into mechanic_certification (m_id, cert_id) values (4, 3);
insert into mechanic_certification (m_id, cert_id) values (4, 4);
insert into mechanic_certification (m_id, cert_id) values (4, 6);
insert into mechanic_certification (m_id, cert_id) values (5, 1);
insert into mechanic_certification (m_id, cert_id) values (5, 2);
insert into mechanic_certification (m_id, cert_id) values (5, 5);
insert into mechanic_certification (m_id, cert_id) values (5, 4);
insert into mechanic_certification (m_id, cert_id) values (6, 5);
insert into mechanic_certification (m_id, cert_id) values (6, 2);


insert into mechanic_certification (m_id, cert_id) values (6, 4);
insert into mechanic_certification (m_id, cert_id) values (6, 6);
insert into mechanic_certification (m_id, cert_id) values (6, 7);
insert into mechanic_certification (m_id, cert_id) values (7, 1);
insert into mechanic_certification (m_id, cert_id) values (7, 2);
insert into mechanic_certification (m_id, cert_id) values (8, 2);
insert into mechanic_certification (m_id, cert_id) values (8, 3);
insert into mechanic_certification (m_id, cert_id) values (8, 4);
insert into mechanic_certification (m_id, cert_id) values (8, 6);
insert into mechanic_certification (m_id, cert_id) values (8, 7);


insert into mechanic_certification (m_id, cert_id) values (9, 1);
insert into mechanic_certification (m_id, cert_id) values (9, 2);
insert into mechanic_certification (m_id, cert_id) values (9, 5);
insert into mechanic_certification (m_id, cert_id) values (10, 1);
insert into mechanic_certification (m_id, cert_id) values (10, 2);
insert into mechanic_certification (m_id, cert_id) values (10, 5);
insert into mechanic_certification (m_id, cert_id) values (10, 4);
insert into mechanic_certification (m_id, cert_id) values (10, 7);




-- -- BRAKES
-- -- mechanics 1, 5, 7, 9, 10
-- -- cert ID's: 1, 2

-- insert into certification (cert_name, r_id, m_id) values ('Brakes', 1, 5);  
-- insert into certification (cert_name, r_id, m_id) values ('Electronic Systems', 1, 5);

-- insert into certification (cert_name, r_id, m_id) values ('Brakes', 1, 7);
-- insert into certification (cert_name, r_id, m_id) values ('Electronic Systems', 1, 7);

-- insert into certification (cert_name, r_id, m_id) values ('Brakes', 1, 9);
-- insert into certification (cert_name, r_id, m_id) values ('Electronic Systems', 1, 9);

-- insert into certification (cert_name, r_id, m_id) values ('Brakes', 1, 10);
-- insert into certification (cert_name, r_id, m_id) values ('Electronic Systems', 1, 10);

-- -- ENGINE
-- -- mechanics 4, 8
-- -- cert ID's: 2, 3, 4


-- insert into certification (cert_name, r_id, m_id) values ('Electronic Systems', 2, 4);

-- insert into certification (cert_name, r_id, m_id) values ('Engine Repair', 2, 8);
-- insert into certification (cert_name, r_id, m_id) values ('Suspension and Drive Train', 2, 8);
-- insert into certification (cert_name, r_id, m_id) values ('Electronic Systems', 2, 8);

-- -- FLYWHEEL
-- -- mechanics 1, 2, 5, 6, 9, 10
-- -- cert ID's: 5
-- insert into certification (cert_name, r_id, m_id) values ('Axles', 3, 1);
-- insert into certification (cert_name, r_id, m_id) values ('Axles', 3, 2);
-- insert into certification (cert_name, r_id, m_id) values ('Axles', 3, 5);
-- insert into certification (cert_name, r_id, m_id) values ('Axles', 3, 6);
-- insert into certification (cert_name, r_id, m_id) values ('Axles', 3, 9);
-- insert into certification (cert_name, r_id, m_id) values ('Axles', 3, 10);

-- -- OIL CHANGE

-- -- FUEL INJECTION
-- -- mechanics 2, 4, 6, 8
-- -- cert ID's: 2, 4 ,6
-- insert into certification (cert_name, r_id, m_id) values ('Automatic Transmission', 5, 2);
-- insert into certification (cert_name, r_id, m_id) values ('Suspension and Drive Train', 5, 2);
-- insert into certification (cert_name, r_id, m_id) values ('Electronic Systems', 5, 2);

-- insert into certification (cert_name, r_id, m_id) values ('Automatic Transmission', 5, 3);
-- insert into certification (cert_name, r_id, m_id) values ('Suspension and Drive Train', 5, 3);
-- insert into certification (cert_name, r_id, m_id) values ('Electronic Systems', 5, 3);

-- insert into certification (cert_name, r_id, m_id) values ('Automatic Transmission', 5, 7);
-- insert into certification (cert_name, r_id, m_id) values ('Suspension and Drive Train', 5, 7);
-- insert into certification (cert_name, r_id, m_id) values ('Electronic Systems', 5, 7);

-- -- TIRES
-- -- mechs 1, 2, 5, 6, 9, 10
-- -- cert ID's: 5
-- insert into certification (cert_name, r_id, m_id) values ('Axles', 6, 1);
-- insert into certification (cert_name, r_id, m_id) values ('Axles', 6, 2);
-- insert into certification (cert_name, r_id, m_id) values ('Axles', 6, 3);
-- insert into certification (cert_name, r_id, m_id) values ('Axles', 6, 5);
-- insert into certification (cert_name, r_id, m_id) values ('Axles', 6, 6);
-- insert into certification (cert_name, r_id, m_id) values ('Axles', 6, 8);


-- -- TRANSMISSION
-- -- mechs 2, 4, 6, 8
-- -- cert ID's: 2, 4, 6
-- insert into certification (cert_name, r_id, m_id) values ('Automatic Transmission', 7, 2);
-- insert into certification (cert_name, r_id, m_id) values ('Suspension and Drive Train', 7, 2);
-- insert into certification (cert_name, r_id, m_id) values ('Electronic Systems', 7, 2);

-- insert into certification (cert_name, r_id, m_id) values ('Automatic Transmission', 7, 4);
-- insert into certification (cert_name, r_id, m_id) values ('Suspension and Drive Train', 7, 4);
-- insert into certification (cert_name, r_id, m_id) values ('Electronic Systems', 7, 4);


-- insert into certification (cert_name, r_id, m_id) values ('Suspension and Drive Train', 7, 6);
-- insert into certification (cert_name, r_id, m_id) values ('Electronic Systems', 7, 6);

-- insert into certification (cert_name, r_id, m_id) values ('Automatic Transmission', 7, 8);
-- insert into certification (cert_name, r_id, m_id) values ('Suspension and Drive Train', 7, 8);
-- insert into certification (cert_name, r_id, m_id) values ('Electronic Systems', 7, 8);

-- insert into certification (cert_name, r_id, m_id) values ('Automatic Transmission', 7, 10);
-- insert into certification (cert_name, r_id, m_id) values ('Suspension and Drive Train', 7, 10);
-- insert into certification (cert_name, r_id, m_id) values ('Electronic Systems', 7, 10);

-- -- CLUTCH
-- -- mechs 1, 2, 4, 5, 6, 8, 10
-- -- cert ID's: 2, 4
-- insert into certification (cert_name, r_id, m_id) values ('Suspension and Drive Train', 8, 3);
-- insert into certification (cert_name, r_id, m_id) values ('Electronic Systems', 8, 3);

-- insert into certification (cert_name, r_id, m_id) values ('Suspension and Drive Train', 8, 5);
-- insert into certification (cert_name, r_id, m_id) values ('Electronic Systems', 8, 5);

-- insert into certification (cert_name, r_id, m_id) values ('Suspension and Drive Train', 8, 7);
-- insert into certification (cert_name, r_id, m_id) values ('Electronic Systems', 8, 7);

-- insert into certification (cert_name, r_id, m_id) values ('Suspension and Drive Train', 8, 9);
-- insert into certification (cert_name, r_id, m_id) values ('Electronic Systems', 8, 9);


-- -- IGNITION
-- -- mechs 1, 2, 4, 5, 6, 8, 10
-- -- cert ID's: 2, 4
-- insert into certification (cert_name, r_id, m_id) values ('Suspension and Drive Train', 9, 1);
-- insert into certification (cert_name, r_id, m_id) values ('Electronic Systems', 9, 1);

-- insert into certification (cert_name, r_id, m_id) values ('Suspension and Drive Train', 9, 2);
-- insert into certification (cert_name, r_id, m_id) values ('Electronic Systems', 9, 2);

-- insert into certification (cert_name, r_id, m_id) values ('Suspension and Drive Train', 9, 4);
-- insert into certification (cert_name, r_id, m_id) values ('Electronic Systems', 9, 4);

-- insert into certification (cert_name, r_id, m_id) values ('Suspension and Drive Train', 9, 5);
-- insert into certification (cert_name, r_id, m_id) values ('Electronic Systems', 9, 5);

-- insert into certification (cert_name, r_id, m_id) values ('Suspension and Drive Train', 9, 7);
-- insert into certification (cert_name, r_id, m_id) values ('Electronic Systems', 9, 7);


-- -- COOLING SYSTEM
-- -- mechs 3, 6, 8, 10
-- -- cert ID's: 2, 7
-- insert into certification (cert_name, r_id, m_id) values ('Heating and Air Conditioning', 10, 3);
-- insert into certification (cert_name, r_id, m_id) values ('Electronic Systems', 10, 3);

-- insert into certification (cert_name, r_id, m_id) values ('Heating and Air Conditioning', 10, 6);
-- insert into certification (cert_name, r_id, m_id) values ('Electronic Systems', 10, 6);

-- insert into certification (cert_name, r_id, m_id) values ('Heating and Air Conditioning', 10, 8);
-- insert into certification (cert_name, r_id, m_id) values ('Electronic Systems', 10, 8);


-- insert into certification (cert_name, r_id, m_id) values ('Electronic Systems', 10, 10);












