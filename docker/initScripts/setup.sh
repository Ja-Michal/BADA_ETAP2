echo "-- create tables section -------------------------------------------------

      -- table pracownicy

      create table if not exists employees(
        employee_id integer not null,
        name varchar2(20 ) not null,
        surname varchar2(30 ) not null,
        pesel char(11 ),
        telephone_number varchar2(15 ) not null,
        location_id integer,
        position_id integer not null,
        addres_id integer not null,
        primary key (employee_id)
      );


      -- create indexes for table pracownicy


      create index if not exists ix_employees_location_id on Employees (location_id);


      create index if not exists ix_employees_position_id on employees (position_id);


      create SEQUENCE employee_id_seq
      START WITH 17
      MINVALUE 0
      MAXVALUE 200000
      INCREMENT BY 17
      CYCLE;



      -- add keys for table pracownicy

      alter table employees add constraint pesel unique (pesel);


      -- table samochody

      create table if not exists cars(
        car_id integer not null,
        registration varchar2(8 ) not null,
        manufacturing_date date not null,
        millage integer not null,
        next_inspection_date date not null,
        technical_state varchar2(30 ) not null
              check (technical_state in ('NEW', 'GOOD', 'ADEQUATE', 'SERVICE_REQUIRED')),
        model_id integer not null,
        primary key (car_id)
      );


      -- create indexes for table samochody

      create index if not exists ix_cars_model_id on cars (model_id);


      -- add keys for table samochody

      alter table cars add constraint registration unique (registration);

      create SEQUENCE car_id_seq
      START WITH 0
      INCREMENT by 1
      MINVALUE 0
      MAXVALUE 200000
      NOCYCLE;

      -- table serwisy

      create table if not exists services(
        service_id integer not null,
        start_date date not null,
        cost number(10,2) not null,
        description varchar2(1000 ) not null,
        car_id integer not null,
        location_id integer not null,
        primary key (service_id)
      );


      -- create indexes for table serwisy

      create index if not exists ix_services_car_id on services (car_id);


      create index if not exists ix_services_location_id on services (location_id);

      create SEQUENCE service_id_seq
      START WITH 0
      INCREMENT by 1
      MINVALUE 0
      MAXVALUE 200000
      NOCYCLE;


      -- add keys for table serwisy

      -- table placowki

      create table if not exists locations(
        location_id integer not null,
        location_name varchar2(30 ) not null,
        addres_id integer not null,
        primary key (location_id)
      );


      -- create indexes for table placowki

      -- add keys for table placowki

      alter table locations add constraint location_name unique (location_name);

      create SEQUENCE location_id_seq
      START WITH 0
      INCREMENT by 1
      MINVALUE 0
      MAXVALUE 200000
      NOCYCLE;

      -- table warsztaty

      create table if not exists Workshops(
        location_id integer not null,
        workstation_count integer not null,
        primary key (location_id)
      );


      -- add keys for table warsztaty

      -- table przydzialy_serwisowe

      create table if not exists assigned_employees(
        employee_id integer not null,
        service_id integer not null
      );




      -- table adresy

      create table if not exists address(
        addres_id integer not null,
        city_name varchar2(30 ) not null,
        street varchar2(30 ) not null,
        building_number varchar2(5 ) not null,
        apartment_number varchar2(5 ),
        zip_code char(6 ) not null,
        primary key (addres_id)
      );


      -- add keys for table adresy

      create SEQUENCE addres_id_seq
      START WITH 0
      INCREMENT by 1
      MINVALUE 0
      MAXVALUE 200000
      NOCYCLE;

      -- table modele

      create table if not exists models(
        model_id integer not null,
        model_name varchar2(10 ) not null,
        brand_id integer not null,
        primary key (model_id)
      );

      create SEQUENCE model_id_seq
      START WITH 0
      INCREMENT by 1
      MINVALUE 0
      MAXVALUE 200000
      NOCYCLE;

      -- create indexes for table modele

      -- add keys for table modele

      -- table marki

      create table if not exists brands(
        brand_id integer not null,
        brand_name varchar2(10 ) not null,
        primary key (brand_id)
      );


      -- create indexes for table marki

      create SEQUENCE brand_id_seq
      START WITH 0
      INCREMENT by 1
      MINVALUE 0
      MAXVALUE 200000
      NOCYCLE;

      -- add keys for table marki


      alter table brands add constraint brand_name unique (brand_name);


      -- table serwisowane_marki

      create table if not exists serviced_brands(
        location_id integer not null,
        brand_id integer not null,
        primary key (location_id,brand_id)
      );


      -- add keys for table serwisowane_marki


      -- table stanowiska

      create table if not exists positions(
        position_id integer not null,
        position_name varchar2(20 ) not null,
        description varchar2(300 ) not null,
        primary key (position_id)
      );

      create SEQUENCE position_id_seq
      START WITH 0
      INCREMENT by 1
      MINVALUE 0
      MAXVALUE 200000
      NOCYCLE;

      -- add keys for table stanowiska

      alter table positions add constraint position_name unique (position_name);



      -- create foreign keys (relationships) section -------------------------------------------------


      alter table employees add constraint pracuje_w_placowce foreign key (location_id) references locations (location_id);




      alter table services add constraint samochod_jest_serwisowany foreign key (car_id) references cars (car_id);





      alter table models add constraint model_jest_danej_marki foreign key (brand_id) references brands (brand_id);




      alter table cars add constraint samochod_jest_dango_modelu foreign key (model_id) references models (model_id);




      alter table serviced_brands add constraint warsztat_serwisuje_marki foreign key (location_id) references Workshops (location_id);




      alter table serviced_brands add constraint marka_jest_serwisowana_przez_warsztat foreign key (brand_id) references brands (brand_id);




      alter table employees add constraint ma_stanowisko foreign key (position_id) references positions (position_id);




      alter table services add constraint serwis_odbywa_sie_w_warsztacie foreign key (location_id) references Workshops (location_id);




      alter table employees add constraint pracownik_ma_adres foreign key (addres_id) references address (addres_id);




      alter table locations add constraint placowka_ma_adrs foreign key (addres_id) references address (addres_id);




      alter table assigned_employees add constraint works_on_service foreign key (employee_id) references employees (employee_id);




      alter table assigned_employees add constraint is_the_service_being_done foreign key (service_id) references services (service_id);






" >> schema.sql

sqlplus -s DB_USER/123456@//localhost/FREEPDB1 @schema.sql

rm schema.sql
