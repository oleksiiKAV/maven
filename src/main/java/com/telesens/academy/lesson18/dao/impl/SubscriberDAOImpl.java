package com.telesens.academy.lesson18.dao.impl;


import com.telesens.academy.lesson18.hometask.Subscriber;
import com.telesens.academy.lesson18.dao.SubscriberDAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class SubscriberDAOImpl extends BaseDAO implements SubscriberDAO {

    private final String SQL_INSERT = "INSERT INTO subscriber (id, first_name, last_name, age, gender) VALUES(?, ?, ?, ?, ?)"; // id, age, first_name, gender, last_name\n";
    private final String SQL_SELECT_ALL = "SELECT * FROM subscriber"; // select All
    private final String SQL_DELETE = "DELETE FROM subscriber WHERE id = ?"; // id, age, first_name, gender, last_name\n";
    private final String SQL_SELECT_ONE = "SELECT * FROM subscriber WHERE id = ?"; // id, age, first_name, gender, last_name\n";

    public SubscriberDAOImpl(String url) throws SQLException {
        super(url);
    }

    @Override
    public boolean save(Subscriber subscriber) {
        try {
            PreparedStatement statement = connection.prepareStatement(SQL_INSERT);
            statement.setLong(1, subscriber.getId());
            statement.setString(2, subscriber.getFirstName());
            statement.setString(3, subscriber.getLastName());
            statement.setInt(4, subscriber.getAge());
            statement.setString(5, subscriber.getGender());
            return statement.execute();
        } catch (SQLException e) {
            System.out.println("Warning: " + e.getMessage());
            return false;
        }
    }

    @Override
    public boolean remove(Subscriber subscriber) {
        try {
            PreparedStatement statement = connection.prepareStatement(SQL_DELETE);
            statement.setLong(1,subscriber.getId());
            return statement.execute();
        } catch (SQLException e) {
            //e.printStackTrace();
            System.out.println("Warning: " + e.getMessage());
            return false;
        }
    }

    @Override
    public List<Subscriber> getAll() {
        List<Subscriber> list = new ArrayList<Subscriber>();
        try {
            PreparedStatement statement = connection.prepareStatement(SQL_SELECT_ALL);
            ResultSet rs = statement.executeQuery();

            while (rs.next()) {
                Subscriber subscriber = new Subscriber();
                subscriber.setId((Long)(rs.getLong("id")));
                subscriber.setFirstName(rs.getString("first_name"));
                subscriber.setLastName(rs.getString("last_name"));
                subscriber.setGender(rs.getString("gender"));
                subscriber.setAge(rs.getInt("age"));
                list.add(subscriber);
            }
            return list;
        } catch (SQLException e) {
            System.out.println("Warning: " + e.getMessage());
            return null;
        }
     }

    @Override
    public Subscriber findById(long id) {
        Subscriber subscriber = new Subscriber((long) 0,"","",0,"","");
        try {

            PreparedStatement statement = connection.prepareStatement(SQL_SELECT_ONE);
            statement.setLong(1,id);
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                subscriber.setId((Long)rs.getLong("id"));
                subscriber.setFirstName(rs.getString("first_name"));
                subscriber.setLastName(rs.getString("last_name"));
                subscriber.setGender(rs.getString("gender"));
                subscriber.setAge(rs.getInt("age"));
            }
            return subscriber;
        } catch (SQLException e) {
            System.out.println("Warning: " + e.getMessage());
            return null;
        }
    }
}
