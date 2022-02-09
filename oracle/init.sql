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
	customer_id INT,
	product_name VARCHAR(50),
	order_number INT(8),
	ORDER_DATE DATE,
	COST DECIMAL
);
insert into customers (id, first_name, last_name, email) values (1, 1, '#3324 White blouse', 78279424, '01/15/2022', 25.99);
insert into customers (id, first_name, last_name, email) values (2, 2, '#7653 red air force ones', 98734982, '01/15/2022', 129.99);
insert into customers (id, first_name, last_name, email) values (3, 3, '#1798 Black leather pants', 12394834, '01/16/2022', 45.99);
insert into customers (id, first_name, last_name, email) values (4, 4, '#2254 Black peacoat', 68394347, '01/16/2022', 365.00);
insert into customers (id, first_name, last_name, email) values (5, 5, '#4324 Blue denim jeans', 09448333, '01/18/2022', 44.00);
insert into customers (id, first_name, last_name, email) values (6, 6, '#9877 white leather jacket', 09448333, '01/19/2022', 37.00);
insert into customers (id, first_name, last_name, email) values (7, 7, '#0948 Red Jordan Ones', 09448333, '01/20/2022', 250.00);
insert into customers (id, first_name, last_name, email) values (8, 8, '#2345 Green Nike Tracksuit', 09448333, '01/21/2022', 99.00');
insert into customers (id, first_name, last_name, email) values (9, 9, '#7645 Pink Linen Blouse', 09448333, '01/22/2022', 90.99);
insert into customers (id, first_name, last_name, email) values (10, 10, '#1983 Orange Silk dress', 09448333, '01/23/2022', 65.49);
