ALTER SESSION SET CONTAINER=freepdb1;

CREATE USER DB_USER IDENTIFIED BY 123456 QUOTA UNLIMITED ON USERS;

GRANT CONNECT, RESOURCE TO DB_USER;