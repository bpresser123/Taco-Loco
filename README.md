# **Taco Loco User Guide**

*Taco Loco Requirements: Java 8, Apache Maven 3.5.3 and the Postman application.*

Link to Postman: https://www.getpostman.com/

1. From your Taco Loco project folder, run `mvn package` in the command line to create a JAR file in the target folder.
2. Navigate to tacoLoco/target and run `java -jar <jar-file-name>.jar` in the command line to run the application.
3. Open Postman and add Content-Type as the key and application/json as the value in the “Headers” section.

![image](https://user-images.githubusercontent.com/15268672/39932971-a7821888-550f-11e8-8564-abdb34709881.png)

4. Set the URI to http://localhost:8080/placeOrder and set the HTTP request method to POST.

![image](https://user-images.githubusercontent.com/15268672/39933137-21b8a536-5510-11e8-8947-f4f378682a6f.png)

5. Follow the steps in the Response Examples section below to see different responses from the Taco Loco application.

# **Taco Loco Menu**

- Veggie Taco ($2.50)
- Beef Taco ($3.00)
- Chicken Taco ($3.00)
- Chorizo Taco ($3.50)

# **Response Examples**

1. Copy and paste the JSON object (taco order) shown below into the body of the request.

```
  {
      "orderItems": ["veggie taco", "veggie taco", "veggie taco", "veggie taco"]
  }
```

2. Select “Send” to POST the taco order and check the response shown in the Response section of the Postman application (below the Request section). In this case, the order total should be $8.00 after a 20% discount is applied.


![image](https://user-images.githubusercontent.com/15268672/39932821-31a5284e-550f-11e8-8c01-16f6156be8d5.png)


1. Copy and paste the JSON object (taco order) shown below into the body of the request.

```
  {
      "orderItems": ["veggie taco", "veggie taco", "veggie taco"]
  }
```

2. Select “Send” to POST the taco order and check the response shown in the Response section of the Postman application (below the Request section). In this case, the order total should be $7.50.


<img width="1593" alt="screen shot 2018-05-14 at 11 57 47 am" src="https://user-images.githubusercontent.com/15268672/40008925-90ef3bc6-576e-11e8-80bc-d314ba0d67ea.png">


1. Copy and paste the JSON object (taco order) shown below into the body of the request.

```
  {
      "orderItems": ["veggie taco", "veggie taco", "veggie taco", "beef"]
  }
```

2. Select “Send” to POST the taco order and check the response shown in the Response section of the Postman application (below the Request section). In this case, you should see a Bad Request error (400) with a message saying "beef is not a valid entry.. Please choose from the following options: Veggie Taco ($2.50), Beef Taco ($3.00), Chicken Taco ($3.00), Chorizo Taco ($3.50)"


<img width="1593" alt="screen shot 2018-05-14 at 11 57 30 am" src="https://user-images.githubusercontent.com/15268672/40009672-af1bc720-5770-11e8-834c-83aec504948f.png">


1. Copy and paste the JSON object (taco order) shown below into the body of the request.

```
  {
      "orderItems": []
  }
```

2. Select “Send” to POST the taco order and check the response shown in the Response section of the Postman application (below the Request section). In this case, you should see a Bad Request error (400) with a message saying "Your order is empty.. "


<img width="1593" alt="screen shot 2018-05-14 at 11 57 56 am" src="https://user-images.githubusercontent.com/15268672/40009734-d341a926-5770-11e8-8405-36b291cf6d2b.png">
