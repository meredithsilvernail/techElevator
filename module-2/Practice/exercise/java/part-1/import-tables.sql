DROP TABLE IF EXISTS accounts;
DROP TABLE IF EXISTS customers;

CREATE TABLE customers (
	id serial PRIMARY KEY,
	name VARCHAR(50),
	email VARCHAR(40),
	created DATE
);

CREATE TABLE accounts (
	id serial PRIMARY KEY,
	name VARCHAR(50) NOT NULL,
	balance DECIMAL(10, 2) NOT NULL,
	customer_id INT,
	created DATE
);

ALTER TABLE accounts
ADD FOREIGN KEY (customer_id)
REFERENCES customers (id);

INSERT INTO customers (id, name, email, created) VALUES (1, 'MARGARET', 'margaret@myco.com', '9/16/2018');
INSERT INTO customers (id, name, email, created) VALUES (2, 'ANTHONY', 'anthony@myco.com', '12/2/2018');
INSERT INTO customers (id, name, email, created) VALUES (3, 'NICK', 'nick@myco.com', '4/5/2019');
INSERT INTO customers (id, name, email, created) VALUES (4, 'DAVID', 'david@myco.com', '4/6/2019');
INSERT INTO customers (id, name, email, created) VALUES (5, 'GREG', 'greg@myco.com', '11/13/2018');
INSERT INTO customers (id, name, email, created) VALUES (6, 'LEAH', 'leah@myco.com', '3/2/2019');
INSERT INTO customers (id, name, email, created) VALUES (7, 'MEREDITH', 'meredith@myco.com', '3/1/2019');
INSERT INTO customers (id, name, email, created) VALUES (8, 'SHERIN', 'chris@myco.com', '1/31/2019');
INSERT INTO customers (id, name, email, created) VALUES (10, 'VICTORIA', 'victoria@myco.com', '10/19/2019');
INSERT INTO customers (id, name, email, created) VALUES (11, 'SHAAMA', 'shaama@myco.com', '12/22/2018');
INSERT INTO customers (id, name, email, created) VALUES (12, 'TROY', 'troy@myco.com', '2/7/2019');
INSERT INTO customers (id, name, email, created) VALUES (13, NULL, 'nameless@myco.com', '5/5/2019');
ALTER SEQUENCE customers_id_seq RESTART WITH 14;


INSERT INTO accounts (id, name, balance, customer_id, created) VALUES (1, 'CHECKING', 100.00, 1, '9/16/2018');
INSERT INTO accounts (id, name, balance, customer_id, created) VALUES (2, 'SAVINGS', 100.00, 1, '9/16/2019');
INSERT INTO accounts (id, name, balance, customer_id, created) VALUES (3, 'CHECKING', 100.00, 2, '1/15/2019');
INSERT INTO accounts (id, name, balance, customer_id, created) VALUES (4, 'SAVINGS', 100.00, 2, '9/16/2019');
ALTER SEQUENCE accounts_id_seq RESTART WITH 5;


