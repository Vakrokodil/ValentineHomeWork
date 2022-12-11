package com.valya.homework.section22.bakery;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class BakeryCreate {

    public static void main(String[] args) {
        Properties properties = new Properties();

        try (InputStream input = new FileInputStream("src/main/resources/sql.properties")) {
            properties.load(input);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        try (Connection connection = DriverManager.getConnection(properties.getProperty("database.url"),
                properties.getProperty("database.login"),
                properties.getProperty("database.pass"));
             Statement statement = connection.createStatement()
        ) {
//            String insertDataQuery = "create database bakery;";
//            String insertDataQuery = "CREATE TABLE Bakery_name_address(id bigint PRIMARY KEY\n" +
//                    "auto_increment,\n" +
//                    "title varchar(500) not null,\n" +
//                    "city varchar(500) not null,\n" +
//                    "street varchar(500) not null,\n" +
//                    "house bigint not null,\n" +
//                    "phone varchar(500) not null);";

//            String insertDataQuery = "CREATE TABLE Products(id bigint PRIMARY KEY\n" +
//                    "auto_increment,\n" +
//                    "title varchar(500) not null);";

//            String insertDataQuery = "CREATE TABLE Employees(id bigint PRIMARY KEY auto_increment, " +
//                    "first_name varchar(500) not null, last_name varchar(500) not null, birthday varchar(500) not null," +
//                    " bakery_id bigint, FOREIGN KEY (bakery_id) REFERENCES bakery_name_address(id))";

//            String insertDataQuery = "CREATE TABLE products_in_bakery(id bigint PRIMARY KEY\n" +
//                    "auto_increment,\n" +
//                    "product_id bigint not null,\n" +
//                    "bakery_id bigint not null,\n" +
//                    "FOREIGN KEY (product_id) REFERENCES products(id),\n" +
//                    "FOREIGN KEY (bakery_id) REFERENCES bakery_name_address(id),\n" +
//                    "CONSTRAINT UNIQUE(product_id, bakery_id));";

//            statement.execute(insertDataQuery);

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }


        try (Connection connection = DriverManager.getConnection(properties.getProperty("database.url"),
                properties.getProperty("database.login"),
                properties.getProperty("database.pass"))
        ) {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("select bnm.title as bakery_name, emp.first_name, emp.last_name\n" +
                    "from bakery_name_address bnm, \n" +
                    "\t\t\t  employees emp\n" +
                    "where bnm.id = emp.bakery_id");

//            while (resultSet.next()) {
//                System.out.println(resultSet.getString("bakery_name") + " | " +
//                        resultSet.getString("first_name") + " | " +
//                        resultSet.getString("last_name"));
//            }


        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        } ;


        try (Connection connection = DriverManager.getConnection(properties.getProperty("database.url"),
                properties.getProperty("database.login"),
                properties.getProperty("database.pass"))
        ) {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("select mm.bakery_id, bna.title as bakery_name,  mm.name_product\n" +
                    "                from\n" +
                    "        (select pib.bakery_id, p.title as name_product\n" +
                    "        from products_in_bakery pib left join products p on pib.product_id = p.id) mm\n" +
                    "        left join bakery_name_address bna  on mm.bakery_id = bna.id\n" +
                    "\n" +
                    "        order by mm.bakery_id");

            while (resultSet.next()) {
                System.out.println(resultSet.getString("bakery_id") + " | " +
                        resultSet.getString("bakery_name") + " | " +
                        resultSet.getString("name_product"));
            }


        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        } ;






    }
}
