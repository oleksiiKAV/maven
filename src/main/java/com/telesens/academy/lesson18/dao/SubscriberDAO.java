package com.telesens.academy.lesson18.dao;

import com.telesens.academy.lesson18.hometask.Subscriber;

import java.util.List;

public interface SubscriberDAO extends AutoCloseable {
    boolean save(Subscriber subscriber);
    boolean remove(Subscriber subscriber);
    List<Subscriber> getAll();
    Subscriber findById(long id);
}
