package com.telesens.academy.lesson18.hometask;

import java.time.LocalDate;
import java.util.Date;
import java.util.Objects;

public class PhoneBookRecord {//implements Comparable<Operator> {

    private String phoneNumbers;
    private Long subscriberId;
    private LocalDate registeredDate;

    public PhoneBookRecord() {
    }

    public String getPhoneNumbers() {
        return phoneNumbers;
    }

    public void setPhoneNumbers(String phoneNumbers) {
        this.phoneNumbers = phoneNumbers;
    }

    public Long getSubscriberId() {
        return subscriberId;
    }

    public void setSubscriberId(Long subscriberId) {
        this.subscriberId = subscriberId;
    }

    public void setRegisteredDate(LocalDate registeredDate) {
        this.registeredDate = registeredDate;
    }

    @Override
    public String toString() {
        return "PhoneBookRecord{" +
                "phoneNumbers='" + phoneNumbers + '\'' +
                ", subscriberId=" + subscriberId +
                ", registeredDate=" + registeredDate +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PhoneBookRecord that = (PhoneBookRecord) o;
        return Objects.equals(phoneNumbers, that.phoneNumbers) &&
                Objects.equals(subscriberId, that.subscriberId) &&
                Objects.equals(registeredDate, that.registeredDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(phoneNumbers, subscriberId, registeredDate);
    }
}
