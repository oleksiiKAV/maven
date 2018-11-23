package com.telesens.academy.lesson18.dao.impl;


import com.telesens.academy.lesson18.dao.OperatorDAO;
import com.telesens.academy.lesson18.dao.SubscriberDAO;
import com.telesens.academy.lesson18.hometask.Operator;
import com.telesens.academy.lesson18.hometask.Subscriber;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class OperatorDAOImpl extends BaseDAO implements OperatorDAO {

    private final String SQL_INSERT = "INSERT INTO operator (operator_id, first_name, address) VALUES(?, ?, ?)";
    private final String SQL_SELECT_ALL = "SELECT * FROM operator order by operator_id"; // select All
    private final String SQL_DELETE = "DELETE FROM operator WHERE id = ?"; // id, age, first_name, gender, last_name\n";
    private final String SQL_SELECT_ONE = "SELECT * FROM operator WHERE id = ?"; // id, age, first_name, gender, last_name\n";

    public OperatorDAOImpl(String url) throws SQLException {
        super(url);
    }

    @Override
    public boolean save(Operator operator) {
        try {
            PreparedStatement statement = connection.prepareStatement(SQL_INSERT);
            statement.setLong(1, operator.getOperatorId());
            statement.setString(2, operator.getName());
            statement.setString(3, operator.getAddress());
            return statement.execute();
        } catch (SQLException e) {
            System.out.println("Warning: " + e.getMessage());
            return false;
        }
    }

    @Override
    public boolean remove(Operator operator) {
        try {
            PreparedStatement statement = connection.prepareStatement(SQL_DELETE);
            statement.setLong(1,operator.getOperatorId());
            return statement.execute();
        } catch (SQLException e) {
            //e.printStackTrace();
            System.out.println("Warning: " + e.getMessage());
            return false;
        }
    }

    @Override
    public List<Operator> getAll() {
        List<Operator> list = new ArrayList<Operator>();
        try {
            PreparedStatement statement = connection.prepareStatement(SQL_SELECT_ALL);
            ResultSet rs = statement.executeQuery();
            Operator operator = new Operator();
            while (rs.next()) {

                operator.setOperatorId((Long)(rs.getLong("id")));
                operator.setName(rs.getString("name"));
                operator.setAddress(rs.getString("address"));
                list.add(operator);
            }
            return list;
        } catch (SQLException e) {
            System.out.println("Warning: " + e.getMessage());
            return null;
        }
     }

    @Override
    public Operator findById(long id) {
        Operator operator = new Operator();
        try {
            PreparedStatement statement = connection.prepareStatement(SQL_SELECT_ONE);
            statement.setLong(1,id);
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                operator.setOperatorId((Long)(rs.getLong("id")));
                operator.setName(rs.getString("name"));
                operator.setAddress(rs.getString("address"));
            }
            return operator;
        } catch (SQLException e) {
            System.out.println("Warning: " + e.getMessage());
            return null;
        }
    }
}
