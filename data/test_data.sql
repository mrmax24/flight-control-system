INSERT INTO air_companies (name, company_type, founded_at, is_deleted)
SELECT 'Boeing', 'AIRLINE', '1975-02-05', false
    WHERE NOT EXISTS (SELECT 1 FROM air_companies);

INSERT INTO air_companies (name, company_type, founded_at, is_deleted)
SELECT 'JetSuite', 'CHARTER', '2001-03-14', false
    WHERE (SELECT COUNT(*) FROM air_companies) = 1;

INSERT INTO air_companies (name, company_type, founded_at, is_deleted)
SELECT 'Antonov', 'CARGO', '1965-07-02', false
    WHERE (SELECT COUNT(*) FROM air_companies) = 2;

INSERT INTO air_companies (name, company_type, founded_at, is_deleted)
SELECT 'Embraer', 'PRIVATE', '1993-05-10', false
    WHERE (SELECT COUNT(*) FROM air_companies) = 3;


INSERT INTO airplanes (name, factory_serial_number, company_id, number_of_flights, flight_distance, fuel_capacity, type, created_at, is_deleted)
SELECT 'Boeing777', '54321', 1, 120, 10000, 2000, 'COMMERCIAL', '1997-06-01', false
    WHERE NOT EXISTS (SELECT 1 FROM airplanes);

INSERT INTO airplanes (name, factory_serial_number, company_id, number_of_flights, flight_distance, fuel_capacity, type, created_at, is_deleted)
SELECT 'Lockheed JetStar', '67890', 2, 15, 8000, 1500, 'BUSINESS_JET', '2015-08-12', false
    WHERE (SELECT COUNT(*) FROM airplanes) = 1;

INSERT INTO airplanes (name, factory_serial_number, company_id, number_of_flights, flight_distance, fuel_capacity, type, created_at, is_deleted)
SELECT 'AN-250', '36489', 3, 65, 15000, 6000, 'CARGO', '2000-03-22', false
    WHERE (SELECT COUNT(*) FROM airplanes) = 2;

INSERT INTO airplanes (name, factory_serial_number, company_id, number_of_flights, flight_distance, fuel_capacity, type, created_at, is_deleted)
SELECT 'Embraer Legacy 600', '15478', 4, 32, 12000, 1200, 'PRIVATE', '2006-07-15', false
    WHERE (SELECT COUNT(*) FROM airplanes) = 3;


INSERT INTO flights (flight_status, company_id, airplane_id, departure_country, destination_country, distance, estimated_flight_time, started_at, ended_at, delay_started_at, created_at, is_deleted)
SELECT 'ACTIVE', 2, 2, 'Japan', 'USA', 1500, 3, UTC_TIMESTAMP() - INTERVAL 29 HOUR, NULL, NULL, UTC_TIMESTAMP(), false
    WHERE NOT EXISTS (SELECT 1 FROM flights);

INSERT INTO flights (flight_status, company_id, airplane_id, departure_country, destination_country, distance, estimated_flight_time, started_at, ended_at, delay_started_at, created_at, is_deleted)
SELECT 'ACTIVE', 2, 2, 'Brazil', 'Netherlands', 1500, 3, UTC_TIMESTAMP() - INTERVAL 26 HOUR, NULL, NULL, UTC_TIMESTAMP(), false
    WHERE (SELECT COUNT(*) FROM flights) = 1;

INSERT INTO flights (flight_status, company_id, airplane_id, departure_country, destination_country, distance, estimated_flight_time, started_at, ended_at, delay_started_at, created_at, is_deleted)
SELECT 'COMPLETED', 3, 3, 'Spain', 'Ukraine', 2000, 1, UTC_TIMESTAMP() - INTERVAL 3 HOUR, UTC_TIMESTAMP(), UTC_TIMESTAMP() - INTERVAL 2 HOUR, UTC_TIMESTAMP(), false
    WHERE (SELECT COUNT(*) FROM flights) = 2;

INSERT INTO flights (flight_status, company_id, airplane_id, departure_country, destination_country, distance, estimated_flight_time, started_at, ended_at, delay_started_at, created_at, is_deleted)
SELECT 'DELAYED', 4, 4, 'USA', 'Poland', 2000, 4, UTC_TIMESTAMP() - INTERVAL 5 HOUR, NULL, UTC_TIMESTAMP() - INTERVAL 1 HOUR, UTC_TIMESTAMP(), false
WHERE (SELECT COUNT(*) FROM flights) = 3;




