package com.telesens.academy.lesson18;

import com.telesens.academy.lesson17.PropertyDemo;

import java.sql.*;

public class TestDBMySQL {
    public static void main(String[] args) {
        try(Connection conn = DriverManager.getConnection(
                PropertyDemo.readProperty("jdbc.url"));) {
            Class.forName("com.mysql.cj.jdbc.Driver"); // подключаем драйвер

            Statement statement = conn.createStatement();
            //PreparedStatement statement_predefine = conn.prepareStatement(
              //      "INSERT INTO abonent VALUES(?, ?, ?, ?, ?)");

            statement.executeUpdate(
                   "INSERT INTO subscriber VALUES(423, 40, 'Наливайченко', 'm', 'Петр')");
            statement.executeUpdate(
                    "UPDATE subscriber SET first_name='112Петр', last_name='112Наливайченко' WHERE id=27");

            ResultSet rs = statement.executeQuery("SELECT * FROM subscriber");
            while (rs.next()) {
                int id = rs.getInt("id");
                String firstName = rs.getString("first_name");
                String lastName = rs.getString("last_name");
                String gender = rs.getString("gender");
                int age = rs.getInt("age");
                System.out.println(String.format("%d| %-15s| %-15s| %s| %d",
                        id, firstName, lastName, gender, age));
            }
            //statement.executeUpdate("DELETE FROM abonent WHERE abonent_id=7");
            rs.close(); // закрываем рессурсы
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}


