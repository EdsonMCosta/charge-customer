create schema if not exists customers_db;

create table customers_db.customers_address(
  customer_address_id bigint primary key AUTO_INCREMENT,
  street varchar(100) NOT NULL,
  number varchar(10) NOT NULL,
  complement varchar(10) NOT NULL,
  postal_code varchar(100) NOT NULL,
  neighborhood varchar(100) NOT NULL,
  city varchar(100) NOT NULL,
  state varchar(100) NOT NULL
 );

create table customers_db.customers(
  customer_id bigint primary key AUTO_INCREMENT,
  first_name varchar(100) NOT NULL,
  last_name varchar(100) NOT NULL,
  document varchar(100) NOT NULL,
  mobile varchar(100) NOT NULL,
  email varchar(100) NOT NULL,
  total_debt_value bigint NOT NULL,
  debit_start_date date NOT NULL,
  description varchar(100) NOT NULL,
  customer_address_id bigint REFERENCES customers_db.customers_address(customer_address_id)
);

