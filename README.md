
# COMP 388/433: Project 3
## Team Members  
- Julia Cicale  
- Percy Soliz  

## Tomcat Server Connection Details  
**Host:** 18.220.231.8:8080  
**Project Name:** comp433Project2Estore  
**User:** mapirisoft  
**Password:** mapirisoft062012

## Description
Use the case study material as a requirement. Your approach is to provide web service APIs for all functionalities that will provide access to your items that you will sell and to provide your partners to be able to add their inventories to be sold on your site using APIs. We will concentrate developing services for the following:  
### 1. Your web service functionalities to sell items would include functionalities such as:
#### a. Search item database by product
##### Description: 
This method performs a search over the title column of product table joining it with inventory and verifying the quantity is bigger than 0  
##### URI: 
http://18.220.231.8:8080/comp433Project2Estore/services/orderService/searchInventoryofProduct?keywords=FitBit 
##### Parameters
-keywords: Name of the product to perform the search over the inventory  
##### Method: 
GET  
##### Headers:   
```
Accept:application/json  
```
##### Body:  
```
none
```
##### Response:  
```
[
    {
        "inventoryId": 1,
        "productRepresentation": {
            "productId": 1,
            "title": "FitBit Alta",
            "description": "Activity Tracker"
        },
        "price": 150,
        "quantity": 9
    },
    {
        "inventoryId": 4,
        "productRepresentation": {
            "productId": 1,
            "title": "FitBit Alta",
            "description": "Activity Tracker"
        },
        "price": 160,
        "quantity": 15
    }
]
```
#### b. Accept Credit Card payment  
##### Description: 
This method allows us to validate and accept the payments of an order
##### URI: 
http://18.220.231.8:8080/comp433Project2Estore/services/partnerService/acceptPayment
##### Parameters
none  
##### Method: 
PUT 
##### Headers:   
```
Accept:application/json  
Content-Type:application/json  
```
##### Body:  
```
{
	"customerOrderId": 2
} 
```
##### Response:  
```
{
    "orderId": 2,
    "orderDetails": [
        {
            "orderDetailId": 3,
            "inventory": {
                "inventoryId": 1,
                "productRepresentation": {
                    "productId": 1,
                    "title": "FitBit Alta",
                    "description": "Activity Tracker"
                },
                "price": 150,
                "quantity": 9
            },
            "quantity": 1,
            "subTotal": 150,
            "orderState": "Pending"
        }
    ],
    "paymentStatus": "Verified",
    "customer": {
        "customerId": 1,
        "lastName": "Cicale",
        "firstName": "Julia",
        "userName": "julia.cicale",
        "password": "078c57f6a6270578fcbb9bbc6a8372bb55fa2a16",
        "billingAddress": {
            "addressId": 2,
            "street": "123 Business Rd.",
            "unit": "Chicago",
            "city": "Chicago",
            "state": "IL",
            "zip": "60601"
        },
        "shippingAddress": {
            "addressId": 1,
            "street": "123 Home St.",
            "unit": "Chicago",
            "city": "Chicago",
            "state": "IL",
            "zip": "60657"
        }
    },
    "orderState": "Ready to Ship",
    "billingAddress": {
        "addressId": 2,
        "street": "123 Business Rd.",
        "unit": "Chicago",
        "city": "Chicago",
        "state": "IL",
        "zip": "60601"
    },
    "total": 150,
    "paymentMethod": [
        {
            "paymentId": 3,
            "paymentStatus": "Verified",
            "subTotal": 150,
            "creditCardNumber": "1010101010101010101020",
            "nameOnCard": "Julia Cicale",
            "securityCode": "911",
            "validDate": "20/20"
        }
    ]
}
```
#### c. Accept buy order  
##### Description: 
This method allows us to accept the order after the payment has been validated. It is now fulfilled and can be shipped.
##### URI: 
http://18.220.231.8:8080/comp433Project2Estore/services/partnerService/fulfillOrder
##### Parameters
none  
##### Method: 
PUT 
##### Headers:   
```
Accept:application/json  
Content-Type:application/json  
```
##### Body:  
```
{
	"customerOrderId": 3
} 
```
##### Response:  
```
{
    "orderId": 3,
    "orderDetails": [
        {
            "orderDetailId": 3,
            "inventory": {
                "inventoryId": 1,
                "productRepresentation": {
                    "productId": 1,
                    "title": "FitBit Alta",
                    "description": "Activity Tracker"
                },
                "price": 150,
                "quantity": 9
            },
            "quantity": 1,
            "subTotal": 150,
            "orderState": "Pending"
        }
    ],
    "paymentStatus": "Verified",
    "customer": {
        "customerId": 1,
        "lastName": "Cicale",
        "firstName": "Julia",
        "userName": "julia.cicale",
        "password": "078c57f6a6270578fcbb9bbc6a8372bb55fa2a16",
        "billingAddress": {
            "addressId": 2,
            "street": "123 Business Rd.",
            "unit": "Chicago",
            "city": "Chicago",
            "state": "IL",
            "zip": "60601"
        },
        "shippingAddress": {
            "addressId": 1,
            "street": "123 Home St.",
            "unit": "Chicago",
            "city": "Chicago",
            "state": "IL",
            "zip": "60657"
        }
    },
    "orderState": "Fulfilled",
    "billingAddress": {
        "addressId": 2,
        "street": "123 Business Rd.",
        "unit": "Chicago",
        "city": "Chicago",
        "state": "IL",
        "zip": "60601"
    },
    "total": 150,
    "paymentMethod": [
        {
            "paymentId": 3,
            "paymentStatus": "Paid",
            "subTotal": 150,
            "creditCardNumber": "1010101010101010101020",
            "nameOnCard": "Julia Cicale",
            "securityCode": "911",
            "validDate": "20/20"
        }
    ]
}
```
#### d. Ship orders  
##### Description: 
This method allows us to ship an Order once it has been fulfilled
##### URI: 
http://18.220.231.8:8080/comp433Project2Estore/services/partnerService/shipOrder
##### Parameters
none  
##### Method: 
PUT 
##### Headers:   
```
Accept:application/json  
Content-Type:application/json  
```
##### Body:  
```
{
	"orderDetailId": 5,
	"trackingNumber": "1234567898765432123456"
}
```
##### Response:  
```
{
    "orderDetailId": 5,
    "inventory": {
        "inventoryId": 1,
        "productRepresentation": {
            "productId": 1,
            "title": "FitBit Alta",
            "description": "Activity Tracker"
        },
        "price": 150,
        "quantity": 8
    },
    "quantity": 1,
    "subTotal": 150,
    "orderState": "Shipped"
}
```
comp433Project2Estore/services/orderService/searchCustomerOrders?customerId=1&orderState=Fulfilled
#### e. Provide order status; Provide status of orders in progress
##### Description: 
This method performs a search for orders that match a certain customerId, as well as an orderState if one is specified.
##### URI: 
http://18.220.231.8:8080/comp433Project2Estore/services/orderService/searchCustomerOrders?customerId=1&orderState=Fulfilled
##### Parameters
-customerId: Id of the customer to retrieve the orders for  
-orderState: specify state of the order (optional)  
##### Method: 
GET  
##### Headers:   
```
Accept:application/json  
```
##### Body:  
```
none
```
##### Response:  
```
[
    {
        "orderId": 1,
        "orderDetails": [
            {
                "orderDetailId": 2,
                "inventory": {
                    "inventoryId": 5,
                    "productRepresentation": {
                        "productId": 2,
                        "title": "Bluetooth Headphones",
                        "description": "Wireless and comfortable headphones for running"
                    },
                    "price": 70,
                    "quantity": 14
                },
                "quantity": 2,
                "subTotal": 140,
                "orderState": "Canceled"
            },
            {
                "orderDetailId": 1,
                "inventory": {
                    "inventoryId": 1,
                    "productRepresentation": {
                        "productId": 1,
                        "title": "FitBit Alta",
                        "description": "Activity Tracker"
                    },
                    "price": 150,
                    "quantity": 9
                },
                "quantity": 1,
                "subTotal": 150,
                "orderState": "Shipped"
            }
        ],
        "paymentStatus": "Verified",
        "customer": {
            "customerId": 1,
            "lastName": "Cicale",
            "firstName": "Julia",
            "userName": "julia.cicale",
            "password": "078c57f6a6270578fcbb9bbc6a8372bb55fa2a16",
            "billingAddress": {
                "addressId": 2,
                "street": "123 Business Rd.",
                "unit": "Chicago",
                "city": "Chicago",
                "state": "IL",
                "zip": "60601"
            },
            "shippingAddress": {
                "addressId": 1,
                "street": "123 Home St.",
                "unit": "Chicago",
                "city": "Chicago",
                "state": "IL",
                "zip": "60657"
            }
        },
        "orderState": "Fulfilled",
        "billingAddress": {
            "addressId": 2,
            "street": "123 Business Rd.",
            "unit": "Chicago",
            "city": "Chicago",
            "state": "IL",
            "zip": "60601"
        },
        "total": 150,
        "paymentMethod": [
            {
                "paymentId": 2,
                "paymentStatus": "Partially Refunded",
                "subTotal": 190,
                "transactionId": "XVF1022",
                "accountEmail": "julia.cicale@gmail.com"
            },
            {
                "paymentId": 1,
                "paymentStatus": "Refunded",
                "subTotal": 100,
                "creditCardNumber": "1010101010101010101020",
                "nameOnCard": "Julia Cicale",
                "securityCode": "911",
                "validDate": "20/20"
            }
        ]
    },
    {
        "orderId": 4,
        "orderDetails": [
            {
                "orderDetailId": 6,
                "inventory": {
                    "inventoryId": 5,
                    "productRepresentation": {
                        "productId": 2,
                        "title": "Bluetooth Headphones",
                        "description": "Wireless and comfortable headphones for running"
                    },
                    "price": 70,
                    "quantity": 14
                },
                "quantity": 1,
                "subTotal": 70,
                "orderState": "Ready to Pickup"
            },
            {
                "orderDetailId": 5,
                "inventory": {
                    "inventoryId": 1,
                    "productRepresentation": {
                        "productId": 1,
                        "title": "FitBit Alta",
                        "description": "Activity Tracker"
                    },
                    "price": 150,
                    "quantity": 9
                },
                "quantity": 1,
                "subTotal": 150,
                "orderState": "Pending"
            }
        ],
        "paymentStatus": "Verified",
        "customer": {
            "customerId": 1,
            "lastName": "Cicale",
            "firstName": "Julia",
            "userName": "julia.cicale",
            "password": "078c57f6a6270578fcbb9bbc6a8372bb55fa2a16",
            "billingAddress": {
                "addressId": 2,
                "street": "123 Business Rd.",
                "unit": "Chicago",
                "city": "Chicago",
                "state": "IL",
                "zip": "60601"
            },
            "shippingAddress": {
                "addressId": 1,
                "street": "123 Home St.",
                "unit": "Chicago",
                "city": "Chicago",
                "state": "IL",
                "zip": "60657"
            }
        },
        "orderState": "Fulfilled",
        "billingAddress": {
            "addressId": 2,
            "street": "123 Business Rd.",
            "unit": "Chicago",
            "city": "Chicago",
            "state": "IL",
            "zip": "60601"
        },
        "total": 220,
        "paymentMethod": [
            {
                "paymentId": 5,
                "paymentStatus": "Paid",
                "subTotal": 220,
                "creditCardNumber": "1010101010101010101020",
                "nameOnCard": "Julia Cicale",
                "securityCode": "911",
                "validDate": "20/20"
            }
        ]
    }
]
```
#### f. Order Cancel  
##### Description: 
This method allows us to cancel an order (instead of shipping it)
##### URI: 
http://18.220.231.8:8080/comp433Project2Estore/services/partnerService/cancelOrder
##### Parameters
none  
##### Method: 
PUT 
##### Headers:   
```
Accept:application/json  
Content-Type:application/json  
```
##### Body:  
```
{
	"orderDetailId": 6,
	"orderId": 4
}
```
##### Response:  
```
{
    "orderDetailId": 6,
    "inventory": {
        "inventoryId": 5,
        "productRepresentation": {
            "productId": 2,
            "title": "Bluetooth Headphones",
            "description": "Wireless and comfortable headphones for running"
        },
        "price": 70,
        "quantity": 15
    },
    "quantity": 1,
    "subTotal": 70,
    "orderState": "Canceled"
}
```
#### g. Create Order for Customer
### 2. Allowing Partners to use your site to sell their products with functionalities such as:  
#### a. Need to register and create profile of partners  
##### Description: 
This method allows us to register a new Partner inside of the application  
##### URI: 
http://18.220.231.8:8080/comp433Project2Estore/services/partnerService/partner
##### Parameters
none  
##### Method: 
POST  
##### Headers:   
```
Accept:application/json  
Content-Type:application/json  
```
##### Body:  
```
{
	"name": "JackRabbit",
	"userName": "jackrabbit",
	"password": "password12345"
} 
```
##### Response:  
```
{
    "partnerId": 3,
    "name": "JackRabbit",
    "userName": "jackrabbit",
    "inventory": []
}
```
#### b. Add product or products in market place  
##### Description: 
This method allows us to register a new product in the database  
##### URI: 
http://18.220.231.8:8080/comp433Project2Estore/services/partnerService/product
##### Parameters
none  
##### Method: 
POST  
##### Headers:   
```
Accept:application/json  
Content-Type:application/json  
```
##### Body:  
```
{
    "productId": 0,
    "title": "Amazon Echo",
    "description": "Alexa enabled device with a speaker"
} 
```
##### Response:  
```
{
    "productId": 5,
    "title": "Amazon Echo",
    "description": "Alexa enabled device with a speaker"
}
```
#### c. Add products to inventory of partners 
##### Description: 
This method allows us to increase the inventory of a partner in the database  
##### URI: 
http://18.220.231.8:8080/comp433Project2Estore/services/partnerService/inventory
##### Parameters
none  
##### Method: 
POST  
##### Headers:   
```
Accept:application/json  
Content-Type:application/json  
```
##### Body:  
```
{
    "inventoryId": 0,
    "partnerId" : 3,
    "productId": 5,
    "price": 49.99,
    "quantity": 10
} 
```
##### Response:  
```
{
    "inventoryId": 9,
    "productRepresentation": {
        "productId": 5,
        "title": "Amazon Echo",
        "description": "Alexa enabled device with a speaker"
    },
    "price": 49.99,
    "quantity": 10
}
```
#### d. Push orders that customers made to partners  
#### e. Get acknowledgement of order fulfillment  
### 3. Features to make your APIs robust:  
#### a. ERROR Handling  
#### b. Exception handling  

# COMP 388/433: Project 2
## Description
Suppose you want to sell any items online (like big eCommerce sites) � you have also decided
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