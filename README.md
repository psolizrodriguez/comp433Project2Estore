# Helpful SQL Notes
[SQL Notes](./documents/SQL_helpful_notes.md)
# Git Import project in eclipse
1) create directory "comp433Project2Estore" inside of your workspace
2) git init
3) git remote add comp433Project2Estore https://github.com/psolizrodriguez/comp433Project2Estore.git
4) git pull comp433Project2Estore master
5) create a Dynamic Web Project on eclipse using that path
# Connection Details
**Host:** 18.220.231.8  
**Database:** test  
**User:** jcicale  
**Password:** jcicale  
# Class Diagram
![EStore](https://i.imgur.com/pZ1eb2O.gif)
# To do
## 1. Create SQL statements for the following tables:
### * Order
CREATE TABLE `Orders` ( 
  `order_id` int(11) NOT NULL, 
  `payment_received` bool DEFAULT NULL, 
  `order_state` varchar(45) DEFAULT NULL, 
  PRIMARY KEY (`order_id`) 
);
### * Customer
CREATE TABLE `Customer` (
  `customer_id` varchar(45) NOT NULL, 
  `last_name` varchar(45) DEFAULT NULL, 
  `first_name` varchar(45) DEFAULT NULL, 
  PRIMARY KEY (`customer_id`) 
);
### * Address
CREATE TABLE `Address` (
  `address_id` int(11) NOT NULL,
  `street` varchar(100) DEFAULT NULL,
  `unit` varchar(45) DEFAULT NULL,
  `city` varchar(100) DEFAULT NULL,
  `state` varchar(45) DEFAULT NULL,
  `zip` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`address_id`)
);
### * Product
CREATE TABLE `Product` (
  `id` int(11) NOT NULL,
  `title` varchar(45) DEFAULT NULL,
  `price` decimal(4,2) DEFAULT NULL,
  PRIMARY KEY (`id`)
);
### * Book
CREATE TABLE `Book` (
  `isbn` bigint(13) NOT NULL, 
  `author` varchar(45) DEFAULT NULL, 
  PRIMARY KEY (`isbn`) 
);
### * Order Detail
## 2. Insert SQL statements for the following tables:
### * Order
INSERT INTO `Orders` VALUES (0001, false, 'Canceled');  
INSERT INTO `Orders` VALUES (0002, true, 'Delivered');  
INSERT INTO `Orders` VALUES (0003, true, 'Shipped');  
INSERT INTO `Orders` VALUES (0004, false, 'Processing');  
INSERT INTO `Orders` VALUES (0005, true, 'Shipped');  
### * Customer
INSERT INTO `Customer` VALUES ('A001', 'Lemon', 'Liz');  
INSERT INTO `Customer` VALUES ('A002', 'Solo', 'Han');  
INSERT INTO `Customer` VALUES ('A003', 'Granger', 'Hermione');  
INSERT INTO `Customer` VALUES ('A004', 'Swanson', 'Ron');  
INSERT INTO `Customer` VALUES ('A005', 'Bluth', 'Gob');  
### * Address
INSERT INTO `Address` VALUES (00001, '123 Clark St.', 'Apt 1', 'Chicago', 'IL', '60601');  
INSERT INTO `Address` VALUES (00002, '500 Main St.', 'Apt G', 'Indianapolis', 'IN', '46107');  
INSERT INTO `Address` VALUES (00003, '345 Water St', 'Unit 4', 'Ithaca', 'NY', '14850');  
INSERT INTO `Address` VALUES (00004, '307 E 91st St', 'Apt 3R', 'New York', 'NY', '10128');  
INSERT INTO `Address` VALUES (00005, '1842 Cooper Ave', 'Unit 2', 'Voorhees', 'NJ', '08043');  
### * Product
INSERT INTO `Product` VALUES (000001, 'FitBit Alta', 99.99);  
INSERT INTO `Product` VALUES (000002, 'Bluetooth Headphones', 74.99);  
INSERT INTO `Product` VALUES (000003, 'Laptop Bag', 45.00);  
INSERT INTO `Product` VALUES (000004, 'Graphing Calculator', 84.97);  
INSERT INTO `Product` VALUES (000005, 'iPhone 6 Charging Cable', 12.99);  
### * Book
INSERT INTO `Book` VALUES (9780143114963, 'Pollan, Michael');  
INSERT INTO `Book` VALUES (9780321127426, 'Fowler, Martin');  
INSERT INTO `Book` VALUES (9780385333481, 'Vonnegut, Kurt');  
INSERT INTO `Book` VALUES (9780316769488, 'Salinger, J.D.');  
INSERT INTO `Book` VALUES (9780451524935, 'Orwell, George');  
### * Order Detail
