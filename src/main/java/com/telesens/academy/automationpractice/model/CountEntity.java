package com.telesens.academy.automationpractice.model;

import java.util.Objects;

public class CountEntity extends EntityDress {
    private int countEntity;

    public int getCountEntity() {
        return countEntity;
    }

    public int setCountEntity(int countEntity) {
        this.countEntity = countEntity;
        return countEntity;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        CountEntity that = (CountEntity) o;
        return countEntity == that.countEntity;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), countEntity);
    }
}
