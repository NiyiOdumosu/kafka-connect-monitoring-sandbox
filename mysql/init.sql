CREATE database if not exists db;

USE db;

create table if not exists customers  (
	id INT NOT NULL PRIMARY KEY,
	first_name VARCHAR(50),
	last_name VARCHAR(50),
	email VARCHAR(50)
);

insert into customers (id, first_name, last_name, email) values (1, 'Tommy', 'Galfour', 'tgalfour0@shareasale.com');
insert into customers (id, first_name, last_name, email) values (2, 'Carmine', 'Delgardillo', 'cdelgardillo1@hhs.gov');
insert into customers (id, first_name, last_name, email) values (3, 'Staci', 'Jehan', 'sjehan2@nsw.gov.au');
insert into customers (id, first_name, last_name, email) values (4, 'Riobard', 'Matthai', 'rmatthai3@yellowbook.com');
insert into customers (id, first_name, last_name, email) values (5, 'Eward', 'Normanvill', 'enormanvill4@ebay.co.uk');
insert into customers (id, first_name, last_name, email) values (6, 'Karry', 'Bowne', 'kbowne5@istockphoto.com');
insert into customers (id, first_name, last_name, email) values (7, 'Phoebe', 'Isac', 'pisac6@e-recht24.de');
insert into customers (id, first_name, last_name, email) values (8, 'Emmalyn', 'Fausset', 'efausset7@hugedomains.com');
insert into customers (id, first_name, last_name, email) values (9, 'Gwyn', 'Doxey', 'gdoxey8@bing.com');
insert into customers (id, first_name, last_name, email) values (10, 'Riccardo', 'Wallis', 'rwallis9@washingtonpost.com');



create table if not exists orders (
	id INT NOT NULL PRIMARY KEY,
	customer_id INT NOT NULL,
	product_name VARCHAR(50) NOT NULL,
	order_number INT(8) NOT NULL,
	order_date TIMESTAMP NOT NULL,
	COST DECIMAL NOT NULL
);
insert into orders (id, customer_id, product_name, order_number, order_date, cost) values (1, 1, '#3324 White blouse', 78279424, '2022-01-15 02:22:34', 25.99);
insert into orders (id, customer_id, product_name, order_number, order_date, cost) values (2, 2, '#7653 red air force ones', 98734982, '2022-01-16 02:22:34', 129.99);
insert into orders (id, customer_id, product_name, order_number, order_date, cost) values (3, 3, '#1798 Black leather pants', 12394834, '2022-01-17 02:22:34', 45.99);
insert into orders (id, customer_id, product_name, order_number, order_date, cost) values (4, 4, '#2254 Black peacoat', 68394347, '2022-01-17 02:22:34', 365.00);
insert into orders (id, customer_id, product_name, order_number, order_date, cost) values (5, 5, '#4324 Blue denim jeans', 09448333, '2022-01-18 02:22:34', 44.00);
insert into orders (id, customer_id, product_name, order_number, order_date, cost) values (6, 6, '#9877 white leather jacket', 09448333, '2022-01-19 02:22:34', 37.00);
insert into orders (id, customer_id, product_name, order_number, order_date, cost) values (7, 7, '#0948 Red Jordan Ones', 09448333, '2022-01-20 02:22:34', 250.00);
insert into orders (id, customer_id, product_name, order_number, order_date, cost) values (8, 8, '#2345 Green Nike Tracksuit', 09448333, '2022-01-21 02:22:34', 99.00);
insert into orders (id, customer_id, product_name, order_number, order_date, cost) values (9, 9, '#7645 Pink Linen Blouse', 09448333, '2022-01-22 02:22:34', 90.99);
insert into orders (id, customer_id, product_name, order_number, order_date, cost) values (10, 10, '#1983 Orange Silk dress', 09448333, '2022-01-23 02:22:34', 65.49);
