# COMP 388/433: Project 3
### INTRODUCTION 
# It is an amazing project
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
**-keywords:** Name of the product to perform the search over the inventory  
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
        "partner": {
            "partnerId": 1,
            "name": "Amazon",
            "userName": "amazon"
        },
        "product": {
            "productId": 1,
            "title": "FitBit Alta",
            "description": "Activity Tracker"
        },
        "price": 150,
        "quantity": 9
    },
    {
        "inventoryId": 4,
        "partner": {
            "partnerId": 2,
            "name": "Ebay",
            "userName": "ebay"
        },
        "product": {
            "productId": 1,
            "title": "FitBit Alta",
            "description": "Activity Tracker"
        },
        "price": 160,
        "quantity": 15
    }
]
```
#### b. Create Order for Customer
##### Description: 
This method allows us to create a customerOrder from a customer. Used when you are a customer and would like to place an order of an item you are interested 
##### URI: 
http://18.220.231.8:8080/comp433Project2Estore/services/orderService/customerOrder
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
	"customerId": 1,
	"billingAddressId": 2,
	"orderDetails": [
		{
			"inventoryId": 1,
			"quantity": 1,
			"addressId": 1
		},
		{
			"inventoryId": 5,
			"quantity": 1	
		}
	],
	"paymentMethod": [
		{
			"subTotal": 150,
			"transactionId": "XVF1022",
			"accountEmail": "julia.cicale@gmail.com"
		},
		{
			"subTotal": 160,
			"creditCardNumber": "5216740121470216",
			"nameOnCard": "Julia Cicale",
			"securityCode": "000",
			"validDate": "12/21"
		}
	]
}
```
##### Response:  
```
{
    "orderId": 1,
    "orderDetails": [
        {
            "orderDetailId": 1,
            "inventory": {
                "inventoryId": 1,
                "partner": {
                    "partnerId": 1,
                    "name": "Amazon",
                    "userName": "amazon"
                },
                "product": {
                    "productId": 1,
                    "title": "FitBit Alta",
                    "description": "Activity Tracker"
                },
                "price": 150,
                "quantity": 10
            },
            "quantity": 1,
            "subTotal": 150,
            "orderState": "Pending"
        },
        {
            "orderDetailId": 2,
            "inventory": {
                "inventoryId": 5,
                "partner": {
                    "partnerId": 2,
                    "name": "Ebay",
                    "userName": "ebay"
                },
                "product": {
                    "productId": 1,
                    "title": "FitBit Alta",
                    "description": "Activity Tracker"
                },
                "price": 160,
                "quantity": 15
            },
            "quantity": 1,
            "subTotal": 160,
            "orderState": "Pending"
        }
    ],
    "paymentStatus": "Pending",
    "customer": {
        "customerId": 1,
        "lastName": "Cicale",
        "firstName": "Julia",
        "userName": "julia.cicale",
        "password": "078c57f6a6270578fcbb9bbc6a8372bb55fa2a16",
        "billingAddress": {
            "addressId": 1,
            "street": "123 Home St.",
            "unit": "Chicago",
            "city": "Chicago",
            "state": "IL",
            "zip": "60657"
        },
        "shippingAddress": {
            "addressId": 2,
            "street": "123 Business Rd.",
            "unit": "Chicago",
            "city": "Chicago",
            "state": "IL",
            "zip": "60601"
        }
    },
    "orderState": "Pending",
    "billingAddress": {
        "addressId": 2,
        "street": "123 Business Rd.",
        "unit": "Chicago",
        "city": "Chicago",
        "state": "IL",
        "zip": "60601"
    },
    "total": 310,
    "paymentMethod": [
        {
            "paymentId": 1,
            "paymentStatus": "Pending",
            "subTotal": 150,
            "transactionId": "XVF1022",
            "accountEmail": "julia.cicale@gmail.com"
        },
        {
            "paymentId": 2,
            "paymentStatus": "Pending",
            "subTotal": 160,
            "creditCardNumber": "5216740121470216",
            "nameOnCard": "Julia Cicale",
            "securityCode": "000",
            "validDate": "12/21"
        }
    ]
}
```
#### c. Accept Credit Card payment  
##### Description: 
This method allows us to validate and accept the payments of an order
##### URI: 
http://18.220.231.8:8080/comp433Project2Estore/services/orderService/customerOrder/1/accept
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
none
##### Response:  
```
{
    "orderId": 1,
    "orderDetails": [
        {
            "orderDetailId": 1,
            "inventory": {
                "inventoryId": 1,
                "partner": {
                    "partnerId": 1,
                    "name": "Amazon",
                    "userName": "amazon"
                },
                "product": {
                    "productId": 1,
                    "title": "FitBit Alta",
                    "description": "Activity Tracker"
                },
                "price": 150,
                "quantity": 10
            },
            "quantity": 1,
            "subTotal": 150,
            "orderState": "Pending"
        },
        {
            "orderDetailId": 2,
            "inventory": {
                "inventoryId": 5,
                "partner": {
                    "partnerId": 2,
                    "name": "Ebay",
                    "userName": "ebay"
                },
                "product": {
                    "productId": 1,
                    "title": "FitBit Alta",
                    "description": "Activity Tracker"
                },
                "price": 160,
                "quantity": 15
            },
            "quantity": 1,
            "subTotal": 160,
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
            "addressId": 1,
            "street": "123 Home St.",
            "unit": "Chicago",
            "city": "Chicago",
            "state": "IL",
            "zip": "60657"
        },
        "shippingAddress": {
            "addressId": 2,
            "street": "123 Business Rd.",
            "unit": "Chicago",
            "city": "Chicago",
            "state": "IL",
            "zip": "60601"
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
    "total": 310,
    "paymentMethod": [
        {
            "paymentId": 1,
            "paymentStatus": "Verified",
            "subTotal": 150,
            "transactionId": "XVF1022",
            "accountEmail": "julia.cicale@gmail.com"
        },
        {
            "paymentId": 2,
            "paymentStatus": "Verified",
            "subTotal": 160,
            "creditCardNumber": "5216740121470216",
            "nameOnCard": "Julia Cicale",
            "securityCode": "000",
            "validDate": "12/21"
        }
    ]
}
```
#### d. Accept buy order  
##### Description: 
This method allows us to validate the order after the payment has been verified. It is now fulfilled and Partners can ship.
##### URI: 
http://18.220.231.8:8080/comp433Project2Estore/services/orderService/customerOrder/1/fulfill
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
none
##### Response:  
```
{
    "orderId": 1,
    "orderDetails": [
        {
            "orderDetailId": 1,
            "inventory": {
                "inventoryId": 1,
                "partner": {
                    "partnerId": 1,
                    "name": "Amazon",
                    "userName": "amazon"
                },
                "product": {
                    "productId": 1,
                    "title": "FitBit Alta",
                    "description": "Activity Tracker"
                },
                "price": 150,
                "quantity": 10
            },
            "quantity": 1,
            "subTotal": 150,
            "orderState": "Ready to Ship"
        },
        {
            "orderDetailId": 2,
            "inventory": {
                "inventoryId": 5,
                "partner": {
                    "partnerId": 2,
                    "name": "Ebay",
                    "userName": "ebay"
                },
                "product": {
                    "productId": 1,
                    "title": "FitBit Alta",
                    "description": "Activity Tracker"
                },
                "price": 160,
                "quantity": 14
            },
            "quantity": 1,
            "subTotal": 160,
            "orderState": "Ready to Pickup"
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
            "addressId": 1,
            "street": "123 Home St.",
            "unit": "Chicago",
            "city": "Chicago",
            "state": "IL",
            "zip": "60657"
        },
        "shippingAddress": {
            "addressId": 2,
            "street": "123 Business Rd.",
            "unit": "Chicago",
            "city": "Chicago",
            "state": "IL",
            "zip": "60601"
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
    "total": 310,
    "paymentMethod": [
        {
            "paymentId": 1,
            "paymentStatus": "Paid",
            "subTotal": 150,
            "transactionId": "XVF1022",
            "accountEmail": "julia.cicale@gmail.com"
        },
        {
            "paymentId": 2,
            "paymentStatus": "Paid",
            "subTotal": 160,
            "creditCardNumber": "5216740121470216",
            "nameOnCard": "Julia Cicale",
            "securityCode": "000",
            "validDate": "12/21"
        }
    ]
}
```
#### e. Ship orders  
##### Description: 
This method allows us to ship an Order once it has been fulfilled
##### URI: 
http://18.220.231.8:8080/comp433Project2Estore/services/orderService/customerOrder/1/orderDetail/1/ship
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
	"trackingNumber": "1234567898765432123456"
}
```
##### Response:  
```
{
    "orderDetailId": 1,
    "inventory": {
        "inventoryId": 1,
        "partner": {
            "partnerId": 1,
            "name": "Amazon",
            "userName": "amazon"
        },
        "product": {
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
```
#### f. Provide order status; Provide status of orders in progress
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
                "orderDetailId": 1,
                "inventory": {
                    "inventoryId": 1,
                    "partner": {
                        "partnerId": 1,
                        "name": "Amazon",
                        "userName": "amazon"
                    },
                    "product": {
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
            },
            {
                "orderDetailId": 2,
                "inventory": {
                    "inventoryId": 5,
                    "partner": {
                        "partnerId": 2,
                        "name": "Ebay",
                        "userName": "ebay"
                    },
                    "product": {
                        "productId": 1,
                        "title": "FitBit Alta",
                        "description": "Activity Tracker"
                    },
                    "price": 160,
                    "quantity": 14
                },
                "quantity": 1,
                "subTotal": 160,
                "orderState": "Ready to Pickup"
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
                "addressId": 1,
                "street": "123 Home St.",
                "unit": "Chicago",
                "city": "Chicago",
                "state": "IL",
                "zip": "60657"
            },
            "shippingAddress": {
                "addressId": 2,
                "street": "123 Business Rd.",
                "unit": "Chicago",
                "city": "Chicago",
                "state": "IL",
                "zip": "60601"
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
        "total": 310,
        "paymentMethod": [
            {
                "paymentId": 1,
                "paymentStatus": "Paid",
                "subTotal": 150,
                "transactionId": "XVF1022",
                "accountEmail": "julia.cicale@gmail.com"
            },
            {
                "paymentId": 2,
                "paymentStatus": "Paid",
                "subTotal": 160,
                "creditCardNumber": "5216740121470216",
                "nameOnCard": "Julia Cicale",
                "securityCode": "000",
                "validDate": "12/21"
            }
        ]
    }
]
```
#### g. Order Cancel  
##### Description: 
This method allows us to cancel an order (instead of shipping it)
##### URI: 
http://18.220.231.8:8080/comp433Project2Estore/services/orderService/customerOrder/1/orderDetail/2/cancel
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
none
##### Response:  
```
{
    "orderDetailId": 2,
    "inventory": {
        "inventoryId": 5,
        "partner": {
            "partnerId": 2,
            "name": "Ebay",
            "userName": "ebay"
        },
        "product": {
            "productId": 1,
            "title": "FitBit Alta",
            "description": "Activity Tracker"
        },
        "price": 160,
        "quantity": 15
    },
    "quantity": 1,
    "subTotal": 160,
    "orderState": "Canceled"
}
```
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
##### Description: 
This method allows the partners to get a list of all the OrderDetails that had been placed over their inventories.  
##### URI: 
http://18.220.231.8:8080/comp433Project2Estore/services/partnerService/searchOrderDetailByPartnerIdAndOrderState?partnerId=1&orderState=Shipped  
##### Parameters
**-partnerId:** Id of thepartner to retrieve the orders for  
**-orderState:** specify state of the order detail (optional)[Pending, Ready to Ship, Shipped, Ready to Pickup]  
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
        "orderDetailId": 1,
        "inventory": {
            "inventoryId": 1,
            "partner": {
                "partnerId": 1,
                "name": "Amazon",
                "userName": "amazon"
            },
            "product": {
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
]
```
#### e. Get acknowledgement of order fulfillment  
##### Description: 
This method allows us to mark one orderDetail item as delivered, only if the current status is "Shipped".  
Once this is done, the previous method can be used to check all the "Delivered" orders from that partner.  
http://18.220.231.8:8080/comp433Project2Estore/services/partnerService/searchOrderDetailByPartnerIdAndOrderState?partnerId=1&orderState=Delivered
##### URI: 
http://18.220.231.8:8080/comp433Project2Estore/services/partnerService/markOrderAsDelivered
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
	"orderDetailId" : 1,
	"deliveredTime": "10/30/17 20:30"
} 
```
##### Response:  
```
Ok: 200
```
### 3. Features to make your APIs robust:  
#### a. ERROR Handling  
We create a null variable that will be sent back to the user no matter if the operation was completed successfully or not. If there is a problem, we make sure the variable to be sent is set to null.  

```
	@GET
	@Produces({ "application/xml", "application/json" })
	@Path("/searchInventoryofProduct")
	public List<InventoryRepresentation> getProducts(@QueryParam("keywords") String keywords) {
		List<InventoryRepresentation> listInventoryRepresentation = null;
		try {
			listInventoryRepresentation = orderActivity.getProducts(keywords);
		} catch (Exception e) {
			e.printStackTrace();
			listInventoryRepresentation = null;
		}
		return listInventoryRepresentation;
	}
```
Furthermore, we can consider the underlying logic of the requested operation as a normal method. Which would return true when the operation is completed successfully, and false if not. Then we return a 200 or a 400 error code respectively.  

```
	@PUT
	@Produces({ "application/xml", "application/json" })
	@Path("/markOrderAsDelivered")
	public Response deliveredOrderDetail(OrderDetailDeliveredRequest orderDetailDeliveredRequest) {
		try {
			if (partnerActivity.deliveredOrderDetail(orderDetailDeliveredRequest)) {
				return Response.status(Status.OK).build();
			} else {
				return Response.status(Status.BAD_REQUEST).build();
			}
		} catch (Exception e) {
			e.printStackTrace();
			return Response.status(Status.INTERNAL_SERVER_ERROR).build();
		}
	}
```
#### b. Exception handling  
We are adding a try and a catch block surrounding the code that could cause an exception in all methods, then we print the exception to the log files of the server and send a response with the generic error 500.  

```
	try {
			if (partnerActivity.fulfillOrder(customerOrderRequest)) {
				return Response.status(Status.OK).build();
			} else {
				return Response.status(Status.BAD_REQUEST).build();
			}
		} catch (Exception e) {
			e.printStackTrace();
			return Response.status(Status.INTERNAL_SERVER_ERROR).build();
		}
```
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
