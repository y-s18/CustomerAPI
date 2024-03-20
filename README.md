# CustomerAPI

A simple Spring boot application that demonstrates the usage of RESTful API using Spring boot, Docker and PostgreSQL.

## Tools and Technologies used

* Java 17
* Spring boot 3.2.3
* PostgreSQL
* JPA
* Docker
* Maven
* VS Code

## Steps to install

**1. Clone the application**

```bash
git clone https://github.com/y-s18/CustomerAPI.git
```

**2. Change PostgreSQL Username and Password as per your PostgreSQL Installation**
	
+ open `src/main/resources/application.yml` file.

+ change `spring.datasource.username` and `spring.datasource.password` as per your installation.

+ open `docker-compose.yml` file.

+ change `services.db.environment.POSTGRES_USER` and `services.db.environment.POSTGRES_PASSWORD` as per your installation.

**3. Build the app with Compose**

Before building the app, make sure that Docker Desktop is installed and running.
You can build the app by typing the following command

```bash
docker compose -f "docker-compose.yml" up -d --build
```

Or by right clicking the `docker-compose.yml` file then clicking `Compose Up`

**4. Create a database**

Run the following command to list all running Docker containers

```bash
docker ps
```

You should see the name `postgres`. To enter the container, start a bash shell by running the following command

```bash
docker exec -it postgres bash
```

Execute the `psql` command along with the username to make a connection with the Postgres Database Server

```bash
psql -U root
```

Create the database `customer` by running the following command. Run `\l` to list the databases

```bash
CREATE DATABASE customer;
```

If you named the database otherwise, open `src/main/resources/application.yml` file and change `spring.datasource.url` to your database name instead of `customer`.

Run the following command to establish a Connection With the database

```bash
\c customer
```

Press `ctrl + d` to exit the shell

**5. Run the app**

Go to the `CustomerApiApplication.java` file and click run.

## Explore Rest APIs

The app defines following CRUD APIs.

    GET /api/v1/customers
    
    POST /api/v1/customers
    
    PUT /api/v1/customers
    
    DELETE /api/v1/customers/{customerId}

You can test them using postman or any other rest client.
