package com.valya.homework.section23LambdaStream.codingExercise;

public class Customer {
    private int id;
    private String name;
    private Integer tier;

    public Customer(int id, String name, Integer tier) {
        this.id = id;
        this.name = name;
        this.tier = tier;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getTier() {
        return tier;
    }

    public void setTier(Integer tier) {
        this.tier = tier;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "id=" + id +
                " : " + name  +
                " : " + tier +
                '}';
    }
}
