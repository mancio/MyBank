# MyBank 

## The rest API money transfer app

### Working in progress :)
#### TODO
* change class names removing "_"
* ... a lot of stuff

#### Description

This is a webapp with an online user panel interface to manage bank accounts and transfer money from an account to
another.

#### Design

* Font-end: AngularJs
* Back-end: Java + Spring + oauth2 (security Log in)

#### RestAPI

* [http://localhost:8080](http://localhost:8080) redirect to [http://localhost:8080/login](http://localhost:8080/login)
* [http://localhost:8080/signup](http://localhost:8080)
* [http://localhost:8080/help](http://localhost:8080/help)
* [http://localhost:8080/myaccount/{id}](http://localhost:8080/myaccount/{id})
* [http://localhost:8080/history/{id}](http://localhost:8080/history/{id})
* [http://localhost:8080/transfer/{id}](http://localhost:8080/transfer/{id})


#### Database model

 <img src="https://github.com/mancio/MyBank/blob/master/diagrams/database_workbench.png" alt="Bank Database model" width="100%" >
 
  by [https://dbdiagram.io](https://dbdiagram.io) 
  
#### Bank database sql file

[https://github.com/mancio/MyBank/blob/master/sql/database.sql](https://github.com/mancio/MyBank/blob/master/sql/database.sql)

#### Where is the database?

Is on a free host at [https://remotemysql.com](https://remotemysql.com)

##### Test database
* Mail: jabiro9195@upcmaill.com
* Password mail: 1vHchtIkrQ

DATABASE
* Username: ZCn3bDRv6O
* Database name: ZCn3bDRv6O
* Password: SKkK9BcPIh
* Server: remotemysql.com
* Port: 3306

#### Database design app

* [https://dbdiagram.io](https://dbdiagram.io)

#### Project examples

* [https://github.com/parths049/money-transfer](https://github.com/parths049/money-transfer)
* [https://medium.com/@codespeaks/build-restful-services-with-spring-boot-2-x-in-few-steps-95c895a7abf5](https://medium.com/@codespeaks/build-restful-services-with-spring-boot-2-x-in-few-steps-95c895a7abf5)
  DO NOT SAVE BALANCE AS DOUBLE. USE BIGDECIMAL.
* [https://www.baeldung.com/spring-boot-angular-web](https://www.baeldung.com/spring-boot-angular-web)
* [https://github.com/umangborad123/Online-Banking-with-Java-Spring-Boot-Angular-2](https://github.com/umangborad123/Online-Banking-with-Java-Spring-Boot-Angular-2)
* [https://www.quora.com/Does-banks-store-money-in-SQL](https://www.quora.com/Does-banks-store-money-in-SQL)
* [https://thoughts-on-java.org/best-practices-many-one-one-many-associations-mappings](https://thoughts-on-java.org/best-practices-many-one-one-many-associations-mappings/)
* [https://vladmihalcea.com/eager-fetching-is-a-code-smell](https://vladmihalcea.com/eager-fetching-is-a-code-smell)
* [https://github.com/dmitrykhramov/Online-Bank-Simulator](https://github.com/dmitrykhramov/Online-Bank-Simulator)
* [https://medium.com/@akourtim.ahmed/oauth-2-centralized-authorization-with-spring-boot-2-0-2-and-spring-security-5-and-jdbc-token-store-8dbc063bd5d4](https://medium.com/@akourtim.ahmed/oauth-2-centralized-authorization-with-spring-boot-2-0-2-and-spring-security-5-and-jdbc-token-store-8dbc063bd5d4)
* [https://dzone.com/articles/secure-spring-rest-with-spring-security-and-oauth2](https://dzone.com/articles/secure-spring-rest-with-spring-security-and-oauth2)
* [https://github.com/rajithd/spring-boot-oauth2](https://github.com/rajithd/spring-boot-oauth2)
* [https://github.com/spring-projects/spring-security-oauth/blob/master/spring-security-oauth2/src/main/java/org/springframework/security/oauth2/provider/client/JdbcClientDetailsService.java](https://github.com/spring-projects/spring-security-oauth/blob/master/spring-security-oauth2/src/main/java/org/springframework/security/oauth2/provider/client/JdbcClientDetailsService.java)
to modify tables name, columns and queries
* [https://github.com/spring-projects/spring-security-oauth/blob/master/spring-security-oauth2/src/test/resources/schema.sql](https://github.com/spring-projects/spring-security-oauth/blob/master/spring-security-oauth2/src/test/resources/schema.sql) original sql schema