# challenge-fullapp
The idea of this project is try to push my knowlege in both back-end and front-end.
This software is like a store with products and orders and shipping orders...

<h1>Back end structure</h1>
The back end is based on two parts. The main part based on java and the second part that will recive a lot of call in Node JS.
Every thing will be monitored by a "central" in Grafana to monitoring the request and status of the application, every thing will be integrated with kafka...

<h3>Java API</h3>
This API is the main and responsible for every bussines part of the store. Getting and processing the orders and so on...
<li> The main API will work in java with Spring frame-work
<li> The Relational DataBase that I will use is postgreSQL. But with flyway it is possible to work with any data base and the all versios files is on the project so just change the docker compose and the .env file and be happy :)
<li> All calls is passed through the message broker. I will use RabbitMQ for that.
<li> In addicition to end points there are some background services for Shipping order and some message issue of the orders.

<h3>Node API</h3>
This API will be responsible for monitoring the Shipping order and will be called by the Main API in java
<li> This API will work with node
<li> The database here will be Mongo (NoSQL) to be fast
  
  <h1>Front-end structure</h1>
  The front end is divided on several parts. I have decided to use the best technologies for diferent kind of use.
<li> <b>Web Application:</b> React JS
<li> <b>Mobile:</b> Flutter
<li> <b>Desktop:</b> Electron + React JS
    
    
    
# configure postgres on docker-compose https://hub.docker.com/_/postgres

# start the docker compose: docker-compose -f docker-compose.yml -p app up

