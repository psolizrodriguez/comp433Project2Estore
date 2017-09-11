# Helpful SQL Notes
[SQL Notes](./documents/SQL_helpful_notes.md)
# Connection Details
**Host:** 18.220.231.8  
**Database:** test  
**User:** jcicale  
**Password:** jcicale  
# Class Diagram
![EStore](https://i.imgur.com/pZ1eb2O.gif)
# To do
## 1. Create SQL statements for the following tables:
### -Order
### -Customer
### -Address
CREATE TABLE `Address` (
  `address_id` int(11) NOT NULL,
  `street` varchar(100) DEFAULT NULL,
  `unit` varchar(45) DEFAULT NULL,
  `city` varchar(100) DEFAULT NULL,
  `state` varchar(45) DEFAULT NULL,
  `zip` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`address_id`)
);
### -Product
CREATE TABLE `Product` (
  `id` int(11) NOT NULL,
  `title` varchar(45) DEFAULT NULL,
  `price` decimal(4,2) DEFAULT NULL,
  PRIMARY KEY (`id`)
);
### -Book
### -Order Detail
## 2. Insert SQL statements for the following tables:
### -Order
### -Customer
### -Address
### -Product
### -Book
### -Order Detail