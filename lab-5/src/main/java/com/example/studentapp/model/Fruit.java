package com.example.studentapp.model;

import javafx.beans.property.*;

/**
 * Клас модель для фрукта (Fruit).
 */
public class Fruit {
    private final StringProperty name;
    private final IntegerProperty amount;
    private final DoubleProperty price;

    /**
     * Конструктор за замовчуванням.
     */
    public Fruit() {
        this(null, null, null);
    }

    /**
     * Конструктор із деякими початковими даними.
     *
     * @param name
     * @param amount
     * @param price
     */
    public Fruit(String name, Integer amount, Double price) {
        this.name = new SimpleStringProperty(name);
//Фіктивні дані для зручності
        this.amount = new SimpleIntegerProperty(amount);
        this.price = new SimpleDoubleProperty(price);
    }

    public String getName() {
        return name.get();
    }

    public void setName(String name) {
        this.name.set(name);
    }

    public StringProperty nameProperty() {
        return name;
    }

    public int getAmount() {
        return amount.get();
    }

    public void setAmount(int amount) {
        this.amount.set(amount);
    }

    public IntegerProperty amountProperty() {
        return amount;
    }

    public double getPrice() {
        return price.get();
    }

    public void setPrice(double price) {
        this.price.set(price);
    }

    public DoubleProperty priceProperty() {
        return price;
    }
}

