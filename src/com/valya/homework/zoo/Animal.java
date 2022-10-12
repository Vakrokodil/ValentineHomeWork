package com.valya.homework.zoo;

class Animal {

    protected String name;
    protected double age;
    protected String sex;
    protected static int countAnimal;
    protected double weight;

    public Animal(String name, double age, String sex, double weight) {
        this.name = name;
        this.age = age;
        this.sex = sex;
        this.weight = weight;

        countAnimal += 1;
    }

    public Animal(String name, int age) {
        this(name, age, "unknown", 0);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getAge() {
        return age;
    }

    public void setAge(double age) {
        this.age = age;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public static int getCountAnimal() {
        return countAnimal;
    }

    public void goSleep() {
        System.out.println("I'm go to sleep! Do not disturb!");
    }

    public void goSleep(String message) {
        System.out.println(message);
        System.out.println("I'm go to sleep! Do not disturb");
    }

}
