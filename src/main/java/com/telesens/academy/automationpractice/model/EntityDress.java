package com.telesens.academy.automationpractice.model;

import java.util.Objects;

public class EntityDress implements Comparable <EntityDress> {
    private String model;
    private String name;
    private String size;
    private String color;
    // TODO migrate to BigDecimal
    private double price;

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public EntityDress withModel(String model) {
        this.model = model;
        return this;
    }

    public EntityDress withName(String name) {
        this.name = name;
        return this;
    }

    public EntityDress withSize(String size) {
        this.size = size;
        return this;
    }

    public EntityDress withColor(String color) {
        this.color = color;
        return this;
    }

    public EntityDress withPrice(double price) {
        this.price = price;
        return this;
    }

    @Override
    public String toString() {
        return "Позиция{" +
                "model='" + model + '\'' +
                ", name='" + name + '\'' +
                ", size='" + size + '\'' +
                ", color='" + color + '\'' +
                ", price=" + price + "$" +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        EntityDress that = (EntityDress) o;
        return Double.compare(that.price, price) == 0 &&
                Objects.equals(model, that.model) &&
                Objects.equals(name, that.name) &&
                Objects.equals(size, that.size) &&
                Objects.equals(color, that.color);
    }

    @Override
    public int hashCode() {
        return Objects.hash(model, name, size, color, price);
    }
    @Override
    public int compareTo(EntityDress other){
        return this.model.compareTo(other.model);

    }
}
