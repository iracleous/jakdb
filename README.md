jakdb application
Dimitris Iracleous
November 2022

Prototype of Jakarta application, using 
- detailed model classes for a simple eshop
- clean architecture with model, repository, service, resource, dto
- implementation using Hibernate Transaction API (JTA) 
 

The application uses 
- Java 17
- MySQL Server 8.0 
- JBoss/Wildfly-27.0.0.Final


The driver for MySQL is
mysql-connector-j-8.0.31.jar
Download from https://dev.mysql.com/downloads/connector/j/

Create a free account at Oracle
Choose platform independent
extract the jar file from the mysql-connector-j-8.0.31.tar.gz


**Creating the DataSource in the Application Server Administration Panel**
 
Configuration -> Subsystems -> DataSources & Drivers


**JDBC Driver details**
- Driver Name             mysql-connector-j-8.0.31.jar
- Driver Module Name      com.mysql
- Driver Class Name       com.mysql.cj.jdbc.Driver



**After the review, you get**
- Name            MySqlDS
- JNDI Name       java:/MySqlDS
- Connection URL  jdbc:mysql://localhost:3306/eshop
- Driver Name     mysql-connector-j-8.0.31.jar
- User Name       ●●●●
- Password        ●●●●●●
