# Spring Boot + Spring Data JPA + MySQL example

Article link : https://mkyong.com/spring-boot/spring-boot-spring-data-jpa-mysql-example/

## Technologies used:
* Spring Boot 3.1.2
* Spring Data JPA (Hibernate 6 is the default JPA implementation)
* MySQL 8
* Java 17
* Maven 3
* JUnit 5
* Spring Test using TestRestTemplate
* Docker, [Testcontainers](https://testcontainers.com/) (for Spring integration tests using a MySQL container)

## How to run it
```

$ git clone [https://github.com/mkyong/spring-boot.git](https://github.com/mkyong/spring-boot.git)

$ cd spring-data-jpa-mysql

# Run MySQL container for testing
$ docker run --name c1 -p 3306:3306 -e MYSQL_USER=mkyong -e MYSQL_PASSWORD=password -e MYSQL_ROOT_PASSWORD=password -e MYSQL_DATABASE=mydb -d mysql:8.1
  其中的參數說明
  --name c1 – Set the container’s name.
  -p 3306:3306 – Set the port mapping maps from the local port 3306 to the container port 3306 (inside Docker).
  -e – Set the environment variables.
  -e MYSQL_USER=mkyong – Create a new user named "mkyong" for the MySQL database.
  -e MYSQL_PASSWORD=password – Create a new password for the user specified in MYSQL_USER.
  -e MYSQL_DATABASE=mydb – Set the database name to be created on image startup and grand superuser access for the user specified in MYSQL_USER.
  -e MYSQL_ROOT_PASSWORD=password – Set the password for the MySQL root user.
  -d – Run the container in the background.
  mysql:8.1 – MySQL 8.1.

# Skip test, the Testcontainers takes time
$ ./mvnw clean package -Dmaven.test.skip=true

$ ./mvnw spring-boot:run

```


