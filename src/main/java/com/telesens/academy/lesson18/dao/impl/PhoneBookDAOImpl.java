package com.telesens.academy.lesson18.dao.impl;


import com.telesens.academy.lesson18.dao.PhoneBookDAO;
import com.telesens.academy.lesson18.dao.SubscriberDAO;
import com.telesens.academy.lesson18.hometask.PhoneBookRecord;
import com.telesens.academy.lesson18.hometask.Subscriber;
import org.apache.poi.ss.formula.functions.Now;
import sun.util.calendar.BaseCalendar;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class PhoneBookDAOImpl extends BaseDAO implements PhoneBookDAO {

    private final String SQL_INSERT = "INSERT INTO operator_number (number, operator_id) VALUES(?, ?)";
    private final String SQL_SELECT_ALL = "SELECT * FROM operator_number"; // select All
    private final String SQL_DELETE = "DELETE FROM operator_number WHERE operator_id = ?";
    private final String SQL_SELECT_ONE = "SELECT * FROM operator_number WHERE number = ? AND operator_id = ?";

    public PhoneBookDAOImpl(String url) throws SQLException {
        super(url);
    }

    @Override
    public boolean save(PhoneBookRecord phoneBookRecord) {
        try {
            PreparedStatement statement = connection.prepareStatement(SQL_INSERT);
            statement.setString(1, phoneBookRecord.getPhoneNumbers());
            statement.setLong(2, phoneBookRecord.getSubscriberId());
            return statement.execute();
        } catch (SQLException e) {
            System.out.println("Warning: " + e.getMessage());
            return false;
        }
    }

    @Override
    public boolean remove(PhoneBookRecord phoneBookRecord) {
        try {
            PreparedStatement statement = connection.prepareStatement(SQL_DELETE);
            statement.setLong(1,phoneBookRecord.getSubscriberId());
            return statement.execute();
        } catch (SQLException e) {
            //e.printStackTrace();
            System.out.println("Warning: " + e.getMessage());
            return false;
        }
    }

    @Override
    public List<PhoneBookRecord> getAll() {
        List<PhoneBookRecord> list = new ArrayList<PhoneBookRecord>();
        try {
            PreparedStatement statement = connection.prepareStatement(SQL_SELECT_ALL);
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                PhoneBookRecord phoneBookRecord  = new PhoneBookRecord();
                phoneBookRecord.setPhoneNumbers(rs.getString("number"));
                phoneBookRecord.setSubscriberId((Long)(rs.getLong("operator_id")));
                list.add(phoneBookRecord);
            }
            return list;
        } catch (SQLException e) {
            System.out.println("Warning: " + e.getMessage());
            return null;
        }
     }

    @Override
    public PhoneBookRecord findByKeys(String phoneNumber, Long operatorId) {
        PhoneBookRecord phoneBookRecord = new PhoneBookRecord();
        try {

            PreparedStatement statement = connection.prepareStatement(SQL_SELECT_ONE);
            statement.setString(1,phoneNumber);
            statement.setLong(2,operatorId);
            ResultSet rs = statement.executeQuery();
            LocalDate localDate = LocalDate.now();
            while (rs.next()) {
                phoneBookRecord.setPhoneNumbers(rs.getString("number"));
                phoneBookRecord.setSubscriberId((Long)rs.getLong("operator_id"));
                phoneBookRecord.setRegisteredDate(localDate);
            }
            return phoneBookRecord;
        } catch (SQLException e) {
            System.out.println("Warning: " + e.getMessage());
            return null;
        }
    }
}
