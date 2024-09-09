# Spring Boot + Spring Data JPA example

This is the source code for [Spring Boot + Spring Data JPA example](https://mkyong.com/spring-boot/spring-boot-spring-data-jpa/)

## Technologies used:
* Spring Boot 3.1.2
* Spring Data JPA (Hibernate 6  is the default JPA implementation)
* H2 in-memory database
* Maven
* Java 17
* JUnit 5

## How to run it
```

注意:
  mvnw是Maven Wrapper的縮寫
  簡單地說，Maven Wrapper就是給一個項目提供一個獨立的，指定版本的Maven給它使用。
  我們安裝Maven時，默認情況下，系統所有項目都會使用全域安裝的Maven版本。
  但是，我們需要給一個特定的項目，安裝我們指定版本的Maven，其他項目不受影響，這時就可以使用Maven Wrapper。
  
  安裝Maven Wrapper最簡單的方式是在項目的根目錄（即pom.xml所在的目錄）
  下運行安裝命令：
  mvn -N io.takari:maven:0.7.6:wrapper
  它會自動使用最新版本的Maven。
  注意0.7.6是Maven Wrapper的版本。
  
  如果要指定使用的Maven版本，使用下面的安裝命令指定版本，
  例如3.3.3：
  mvn -N io.takari:maven:0.7.6:wrapper -Dmaven=3.3.3
  
$ git clone https://github.com/mkyong/spring-boot.git

$ cd spring-data-jpa

$ ./mvnw spring-boot:run
```


