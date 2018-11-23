package com.telesens.academy.lesson18.dao;

import com.telesens.academy.lesson18.hometask.Operator;
import com.telesens.academy.lesson18.hometask.Subscriber;

import java.util.List;

public interface OperatorDAO extends AutoCloseable {
    boolean save(Operator operator);
    boolean remove(Operator operator);
    List<Operator> getAll();
    Operator findById(long id);
}
