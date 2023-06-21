# Bookstore application
## Example of Spring framework application

To run application:
```
1. docker compose up 
2. ./mvnw spring-boot:run
```

Users in the database
```
1. Admin: admin@gmail.com admin
2.  User: user@gmail.com user
```


Models creaded:
```
Book - Item
Order
OrderItem
User
```

## Functionalities
* Admin and User roles
* Adding items to cart
* Making orders
* Realizing orders by Admin

# API endpoints

These endpoints allow you to handle Stripe subscriptions for Publish and Analyze.


### GET
`http://localhost:8080/login` [login](http://localhost:8080/login) <br/>
`http://localhost:8080/logout` [logout](http://localhost:8080/logout) <br/>
`http://localhost:8080/add/{itemId}` [add item to cart](http://localhost:8080/add/{itemId}) <br/>
`http://localhost:8080/order/cart` [show cart](http://localhost:8080/order/cart) <br/>
`http://localhost:8080/order/decrease/{itemId}` [decreas number of item](http://localhost:8080/order/decrease/{itemId}) <br/>
`http://localhost:8080/order/increase/{itemId}` [increase number of item](http://localhost:8080/order/increase/{itemId}) <br/>
`http://localhost:8080/order/remove/{itemId}` [remove item from cart](http://localhost:8080/order/remove/{itemId}) <br/>
`http://localhost:8080/order/summary` [summary order](http://localhost:8080/order/summary) <br/>

### POST
`http://localhost:8080/order/saveorder` [make order](http://localhost:8080/order/saveorder) <br/>

## Adminl endoints

### GET
`http://localhost:8080/admin` [add item](http://localhost:8080/admin) <br/>
`http://localhost:8080/admin/delete` [delete item](http://localhost:8080/admin/delete) <br/>
`http://localhost:8080/admin/delete/{itemId}` [delete item by id](http://localhost:8080/admin/delete/{itemId}) <br/>
`http://localhost:8080/admin/realizeorder/{orderId}` [realize order by id](http://localhost:8080/admin/realizeorder/{orderId}) <br/>
`http://localhost:8080/admin/showorders` [show all orders](http://localhost:8080/admin/showorders) <br/>

### PUT
`http://localhost:8080/admin` [update book](http://localhost:8080/admin) <br/>






### POST
`http://localhost:8080/admin` [send forms item](http://localhost:8080/admin) <br/>
___

# TO DO:

- [x] Example models
- [x] Postman Json API overwiew
- [x] Frontend 
- [x] Full CRUD
- [ ] HATEOAS
- [ ] Swagger
