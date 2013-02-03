<?xml version="1.0" encoding="UTF-8"?>    
    <bean id="dataSource"
        class="org.springframework.jdbc.datasource.DriverManagerDataSource" 
        p:driverClassName="com.mysql.jdbc.Driver"
        p:url="jdbc:mysql://thu.c40bplvnfwfx.ap-southeast-1.rds.amazonaws.com/thudb" 
        p:username="thudbuser" 
        p:password="thurock2013" />
    <bean id="dataSource2"
        class="org.springframework.jdbc.datasource.DriverManagerDataSource" 
        p:driverClassName="com.mysql.jdbc.Driver"
        p:url="jdbc:mysql://localhost/example" 
        p:username="root" 
        p:password="" />