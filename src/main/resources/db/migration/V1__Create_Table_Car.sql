CREATE TABLE car (
    uuid UUID PRIMARY KEY,
    name VARCHAR(255),
    brand VARCHAR(255),
    model VARCHAR(255),
    manufacturing_Date DATE,
    average_Fuel_Consumption_City DOUBLE,
    average_Fuel_Consumption_Highway DOUBLE
);