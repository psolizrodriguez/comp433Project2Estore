## Team Members  
- Julia Cicale  
- Percy Soliz  
# COMP 388/433: Project 3
## Description
Use the case study material as a requirement. Your approach is to provide web service APIs for all functionalities that will provide access to your items that you will sell and to provide your partners to be able to add their inventories to be sold on your site using APIs. We will concentrate developing services for the following:  
###1. Your web service functionalities to sell items would include functionalities such as:
####a. Search item database by product
**URI:** http://18.220.231.8:8080/comp433Project2Estore/services/productservice/product?keywords=FitBit  
-FitBit: Product to perform the search over the inventory  
**Method:** GET  
**Headers:**  
```
Accept:application/json
```
**Body:**  
```
none
```
```
{
    "date": "12/12/17",
    "fromHour": "15:00",
    "toHour": "17:00",
    "hours": 2,
    "priceHour": 25,
    "subTotal": 50,
    "taxes": 5,
    "transportation": 15,
    "total": 70,
    "requiredSkill": "[2]",
    "jobTitle": "Head Chef of Event",
    "description": "Check Engine light always on",
    "profileId": 1,
    "prospectId": 2
} 
```
**Response:**  
```
[
    {
        "productId": "001",
        "inventoryId": "001-001",
        "productName": "FitBit Alta",
        "productDescription": "Activity Tracker",
        "productPrice": 150,
        "availableQuantity": 9
    },
    {
        "productId": "001",
        "inventoryId": "002-001",
        "productName": "FitBit Alta",
        "productDescription": "Activity Tracker",
        "productPrice": 160,
        "availableQuantity": 15
    }
]
```
####b. Accept buy order  
####c. Accept Credit Card payment  
####d. Ship orders  
####e. Provide order status; Provide status of orders in progress  
####f. Order Cancel  
###2. Allowing Partners to use your site to sell their products with functionalities such as:  
####a. Need to register and create profile of partners  
####b. Add product or products in market place  
####c. Push orders that customers made to partners  
####d. Get acknowledgement of order fulfillment  
###3. Features to make your APIs robust:  
####a. ERROR Handling  
####b. Exception handling  
## Tomcat Server Connection Details  
## Data Base Connection Details  
**Host:** 18.220.231.8:8080  
**Project Name:** comp433Project2Estore  
**User:** mapirisoft  
**Password:** mapirisoft062012
# COMP 388/433: Project 2
## Description
Suppose you want to sell any items online (like big eCommerce sites) – you have also decided
that you will also allow other partners/companies to sell their inventory on your site. Your
approach is to provide web service APIs for all functionalities that will provide access to your
items that you will sell and to provide your partners to be able to add their inventories to be
sold on your site using APIs. 
## Use Cases
### Customer Registration
![Customer Registration](https://i.imgur.com/UDAThTs.png)
### Buying Experience
![Buying Experience](https://i.imgur.com/b6otbrU.png)
### Partner Registration
![Partner Registration](https://i.imgur.com/QYRwtCg.png)
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