# COMP 388/433: Assignment 2
## Team Members
- Julia Cicale  
- Percy Soliz  
## Description
Suppose you want to sell any items online (like big eCommerce sites) – you have also decided
that you will also allow other partners/companies to sell their inventory on your site. Your
approach is to provide web service APIs for all functionalities that will provide access to your
items that you will sell and to provide your partners to be able to add their inventories to be
sold on your site using APIs. 
## Use Cases
### Customer Registration
[Customer Registration](https://i.imgur.com/UDAThTs.png)
### Buying Experience
[Buying Experience](https://i.imgur.com/b6otbrU.png)
### Partner Registration
[Partner Registration](https://i.imgur.com/QYRwtCg.png)
## Import Git Project in eclipse
1) Create directory "comp433Project2Estore" inside of your workspace  
2) Execute the following code inside of that directory once Git is installed in your machine: 
```
git init  
git remote add comp433Project2Estore https://github.com/psolizrodriguez/comp433Project2Estore.git  
git pull comp433Project2Estore master
```
3) Create a Dynamic Web with tomcat 9 as container on eclipse using that path  
4) The class **com.ebook.common.controllers.MainController** has the code to test and insert all the dummy data  
## Main Controller with Dummy Data
[MainController.java](./src/com/ebook/common/controllers/MainController.java)
## Data Base Connection Details
**Host:** 18.220.231.8  
**Database:** test  
**User:** jcicale  
**Password:** jcicale  
## Class Diagram
![EStore_CD](https://i.imgur.com/xyUaF1D.gif)
## Entity Relationship Diagram
![EStore_ERD](https://i.imgur.com/7TRWs6v.png)