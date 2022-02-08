create table orders (
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
