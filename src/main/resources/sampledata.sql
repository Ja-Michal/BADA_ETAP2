INSERT INTO address (addres_id,city_name,street,building_number,zip_code)
VALUES(addres_id_seq.NEXTVAL,'Warszawa', 'Nowowiejska', '15', '00-665'),
(addres_id_seq.NEXTVAL,'Warszawa', 'Krajewskiego', '1A', '01-532'),
(addres_id_seq.NEXTVAL,'Studzianki Pancerne', 'Studzianki Pancerne', '14', '26-903'),
(addres_id_seq.NEXTVAL,'Zielonka', '1 Maja', '1', '12B', '05-220'),
(addres_id_seq.NEXTVAL,'Warszawa', 'Krakowskie Przedmiescie', '46/48', '00-071'),
(addres_id_seq.NEXTVAL,'Sulejowek', 'Jozefa Pilsudskiego', '29', '05-070');

INSERT INTO address (addres_id,city_name,street,building_number,apartment_number,zip_code)
VALUES(addres_id_seq.NEXTVAL,'Warszawa', 'Sylwestra Kaliskiego', '2', '65', '01-485'),
(addres_id_seq.NEXTVAL,'Siedlce', 'Jozefa Pilsudskiego', '47', '8', '08-110'),
(addres_id_seq.NEXTVAL,'Zielonka', '1 Maja', '1', '12B', '05-220'),
(addres_id_seq.NEXTVAL,'Warszawa', 'plac Defilad', '1', '2716' ,'00-901');

INSERT INTO locations (location_id,location_name,addres_id)
VALUES(location_id_seq.NEXTVAL,'CZNR',1),
(location_id_seq.NEXTVAL,'AutoSerwis',2);

INSERT INTO brands (brand_id,brand_name)
VALUES (brand_id_seq.NEXTVAL, 'FSO'),
(brand_id_seq.NEXTVAL, 'FSR');

INSERT INTO models (model_id,model_name,brand_id)
VALUES (model_id_seq.NEXTVAL,'Warszawa', 1),
(model_id_seq.NEXTVAL,'Honker',2);

INSERT INTO Workshops (location_id,workstation_count)
VALUES (0,4),
(1,2);

INSERT INTO cars(car_id,registration,manufacturing_date,millage,next_inspection_date,technical_state,model_id)
VALUES (car_id_seq.NEXTVAL,'WX12345', to_date('1965-06-15', 'YYYY-MM-DD'), 150000, to_date('2025-06-15', 'YYYY-MM-DD'), 'GOOD', 1),
(car_id_seq.NEXTVAL,'UB3456', to_date('1981-12-13', 'YYYY-MM-DD'), 300000, to_date('2024-05-10', 'YYYY-MM-DD'), 'ADEQUATE', 2),
(car_id_seq.NEXTVAL,'HB1111', to_date('1966-12-24', 'YYYY-MM-DD'), 1000, to_date('2028-12-10', 'YYYY-MM-DD'), 'NEW',  2);

INSERT INTO positions(position_id,position_name,description)
VALUES (position_id_seq.NEXTVAL,'Kierownik napraw', 'Zarzadza serwisami'),
(position_id_seq.NEXTVAL,'Kierownik warsztatu', 'zarzadza warsztatem'),
(position_id_seq.NEXTVAL,'Mechanik', 'Przeprowadza serwisy pojazdów');

INSERT INTO employees (employee_id,name,surname,pesel,telephone_number,location_id,position_id,addres_id)
VALUES(employee_id_seq.NEXTVAL,'Jan', 'Kowalski', '89012345678', '501234567', 1, 3, 3),
(employee_id_seq.NEXTVAL,'Anna', 'Nowak', '92040578901', '502345678', 1,1, 5),
(employee_id_seq.NEXTVAL,'Jan', 'Bogdan', '88888888888', '888888888', 2,1, 4),
(employee_id_seq.NEXTVAL,'Gustaw', 'Husak', '92041118912', '423867421', 2,2, 9),
(employee_id_seq.NEXTVAL,'Katarzyna', 'Wisniewska', '503456789', 1,3,7),
(employee_id_seq.NEXTVAL,'Florian', 'Siwicki', '230706890', 1,2,6),
(employee_id_seq.NEXTVAL,'Marceli', 'Nowotko', '123098456', 2,3,8);

INSERT INTO services (service_id,start_date,cost,description,car_id,location_id)
VALUES (service_id_seq.NEXTVAL,to_date('2024-11-25', 'YYYY-MM-DD'), 500.00, 'Wymiana klocków hamulcowych', 1, 1),
(service_id_seq.NEXTVAL,to_date('2024-12-01', 'YYYY-MM-DD'), 800.00, 'Przeglad techniczny', 2, 2);

INSERT INTO assigned_employees (employee_id,service_id)
VALUES (0,1),
(8,1),
(0,2);

INSERT INTO serviced_brands (location_id,brand_id)
VALUES (1,2),
(1,1),
(2,1);





