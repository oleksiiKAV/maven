package com.telesens.academy.lesson18.dao;

import com.telesens.academy.lesson18.hometask.Operator;
import com.telesens.academy.lesson18.hometask.PhoneBookRecord;

import java.util.List;

public interface PhoneBookDAO extends AutoCloseable {
    boolean save(PhoneBookRecord record);
    boolean remove(PhoneBookRecord record);
	List<PhoneBookRecord> getAll();
	PhoneBookRecord findByKeys(String phoneNumber, Long operatorId);
}
