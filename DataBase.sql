-- Deletes database. Comment if necessary

DROP DATABASE IF EXISTS ECommerce;

-- Creates the database;
CREATE DATABASE ECommerce;

CREATE TABLE Clients (
    id serial primary key,
    name character varying(60) not null unique,
    email character varying(60) unique,
    adress character varying(60) not null,    
    phone VARCHAR(11)
);

CREATE TABLE Type_payments (
    id serial primary key,
    type VARCHAR(15)
);

CREATE TABLE Categories (
    id serial primary key,
    name VARCHAR(50)
);

CREATE TABLE Products (
    id serial primary key,
    name character varying (50) not null,
    description character varying (200) not null,
    value double precision not null,
    quantity integer not null,
    Categories_id integer references Categories (id)
);

CREATE TABLE status_order (
    id serial primary key,
    status character varying (15) not null
);

CREATE TABLE orders (
    id serial primary key,
    date_time timestamp default current_timestamp NOT NULL,
    clients_id integer references Clients (id),
    total double precision not null,
    Type_payments integer references Type_payments (id),
    Payment_data character varying (15) not null,
    status_order_id integer references status_order (id)
);

CREATE TABLE Product_order (
    id serial primary key,
    quantity integer not null,
    products_id integer references Categories (id),
    orders_id integer references Categories (id)
);



-- Inserir dados na tabela Clients
INSERT INTO Clients (name, email, adress, phone) VALUES
    ('John Doe', 'john.doe@example.com', '123 Main Street', '12345678901'),
    ('Jane Smith', 'jane.smith@example.com', '456 Oak Avenue', '98765432109');

-- Inserir dados na tabela Type_payments
INSERT INTO Type_payments (type) VALUES
    ('Credit Card'),
    ('PayPal'),
    ('Cash');

-- Inserir dados na tabela Categories
INSERT INTO Categories (name) VALUES
    ('Comum'),
    ('Wok'),
    ('Com cabo'),
    ('Pressão'),
    ('Caçarola');

-- Inserir dados na tabela Products
INSERT INTO Products (name, description, value, quantity, Categories_id) VALUES
    ('Wok Inox', 'wok de inox', 999.99, 50, 2),
    ('Wok antiaderente', 'wok de material antiaderente', 599.99, 100, 2),
    ('Panela de pressão inox', 'Panela de pressão inox tramontina', 1299.99, 30, 4);

-- Inserir dados na tabela status_order
INSERT INTO status_order (status) VALUES
    ('Processing'),
    ('Shipped'),
    ('Delivered');

-- Inserir dados na tabela orders
INSERT INTO orders (date_time, clients_id, total, Type_payments, Payment_data, status_order_id) VALUES
    (CURRENT_TIMESTAMP, 1, 999.99, 1, '1234-5678', 1),
    (CURRENT_TIMESTAMP, 2, 39.98, 2, '9012-3456', 2);

-- Inserir dados na tabela Product_order
INSERT INTO Product_order (quantity, products_id, orders_id) VALUES
    (2, 1, 1),
    (3, 2, 2),
    (1, 3, 2);