INSERT INTO air_companies (name, company_type, founded_at, is_deleted)
SELECT 'Boeing', 'AIRLINE', NOW(), false
    WHERE NOT EXISTS (SELECT 1 FROM air_companies);

INSERT INTO air_companies (name, company_type, founded_at, is_deleted)
SELECT 'JetSuite', 'CHARTER', NOW(), false
    WHERE (SELECT COUNT(*) FROM air_companies) = 1;

INSERT INTO airplanes (name, factory_serial_number, air_company_id, number_of_flights, flight_distance, fuel_capacity, type, created_at, is_deleted)
SELECT 'Boeing777', '54321', 1, 20, 10000, 2000, 'COMMERCIAL', NOW(), false
    WHERE NOT EXISTS (SELECT 1 FROM airplanes);

INSERT INTO airplanes (name, factory_serial_number, air_company_id, number_of_flights, flight_distance, fuel_capacity, type, created_at, is_deleted)
SELECT 'Airbus A300', '67890', 2, 15, 8000, 1500, 'PRIVATE', NOW(), false
    WHERE (SELECT COUNT(*) FROM airplanes) = 1;

INSERT INTO flights (flight_status, air_company_id, airplane_id, departure_country, destination_country, distance, estimated_flight_time, started_at, ended_at, delay_started_at, created_at, is_deleted)
SELECT 'ACTIVE', 1, 1, 'Ukraine', 'Germany', 1500, 3, NOW() - INTERVAL 2 HOUR, NOW(), NOW(), NOW(), false
    WHERE NOT EXISTS (SELECT 1 FROM flights);

INSERT INTO flights (flight_status, air_company_id, airplane_id, departure_country, destination_country, distance, estimated_flight_time, started_at, ended_at, delay_started_at, created_at, is_deleted)
SELECT 'COMPLETED', 2, 2, 'Spain', 'Ukraine', 2000, 4, NOW() - INTERVAL 3 HOUR, NOW(), NOW(), NOW(), false
    WHERE (SELECT COUNT(*) FROM flights) = 1;

