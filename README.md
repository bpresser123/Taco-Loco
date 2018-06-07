# **Taco Loco User Guide**

*Taco Loco Requirements: Java 8, Apache Maven 3.5.3 and the Postman application.*

Link to Postman: https://www.getpostman.com/


1. Open Postman and go to the “Headers” section. Add Content-Type as the key and application/json as the value.

![image](https://user-images.githubusercontent.com/15268672/41075077-fdd11008-69d8-11e8-8090-0468a3c1bf7d.png)

2. Set the URI to https://taco-loco.herokuapp.com/placeOrder and set the HTTP request method to POST.

![image](https://user-images.githubusercontent.com/15268672/41075095-0e855a1c-69d9-11e8-8d4a-0e6a7d745ee5.png)

3. Follow the steps in the Response Examples section below to see different responses from the Taco Loco application.

# **Taco Loco Menu**

- Veggie Taco ($2.50)
- Beef Taco ($3.00)
- Chicken Taco ($3.00)
- Chorizo Taco ($3.50)

# **Response Examples**

1. Copy and paste the JSON object (taco order) shown below into the body of the request.

```
  {
      "firstName": "Michael", "lastName": "Jordan", "orderItems": ["veggie taco", "veggie taco", "veggie taco", "veggie taco"]
  }
```

2. Select “Send” to POST the taco order and check the response shown in the Response section of the Postman application (below the Request section). In this case, the order total should be $8.00 after a 20% discount is applied.


![image](https://user-images.githubusercontent.com/15268672/41074805-d4d84974-69d7-11e8-9093-71a8734d7d6a.png)


1. Copy and paste the JSON object (taco order) shown below into the body of the request.

```
  {
      "firstName": "David", "lastName": "Blaine", "orderItems": ["veggie taco", "chorizo taco", "BEEF taco"]
  }
```

2. Select “Send” to POST the taco order and check the response shown in the Response section of the Postman application (below the Request section). In this case, the order total should be $9.00.


![image](https://user-images.githubusercontent.com/15268672/41074846-08336dee-69d8-11e8-903e-2a39b593fa07.png)


1. Copy and paste the JSON object (taco order) shown below into the body of the request.

```
  {
      "firstName": "Rick", "lastName": "James", "orderItems": ["veggie taco", "veggie taco", "veggie taco", "chicken "]
  }
```

2. Select “Send” to POST the taco order and check the response shown in the Response section of the Postman application (below the Request section). In this case, you should see a Bad Request error (400) with a message saying "chicken is not a valid entry.. Please choose from the following options: Veggie Taco ($2.50), Beef Taco ($3.00), Chicken Taco ($3.00), Chorizo Taco ($3.50)"


![image](https://user-images.githubusercontent.com/15268672/41075168-68330d5c-69d9-11e8-906e-ef6a22799d4c.png)


1. Copy and paste the JSON object (taco order) shown below into the body of the request.

```
  {
      "firstName": "Brandon", "lastName": "Manson", "orderItems": []
  }
```

2. Select “Send” to POST the taco order and check the response shown in the Response section of the Postman application (below the Request section). In this case, you should see a Bad Request error (400) with a message saying "Your order is empty.. "


![image](https://user-images.githubusercontent.com/15268672/41074933-6270d288-69d8-11e8-8e13-b3d6d37335fc.png)

