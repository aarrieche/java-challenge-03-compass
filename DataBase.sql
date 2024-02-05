-- Se já existe, deleta a database. comentar se necessário

DROP DATABASE IF EXISTS ECommerce;

-- Cria o banco de dados;
CREATE DATABASE EComerce;

-- Dados do cliente (não utilizado nesse momento);

CREATE TABLE Clients (
    id serial primary key,
    name character varying(60) not null,
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
    value character double not null,
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
    total character double not null,
    Type_payments integer references Type_payments (id),
    Payment_data character varying (15) not null,
    status_order_id integer references status_order (id),
);

CREATE TABLE Product_order (
    id serial primary key,
    quantity integer not null,
    products_id integer references Categories (id),
    orders_id integer references Categories (id)
);


