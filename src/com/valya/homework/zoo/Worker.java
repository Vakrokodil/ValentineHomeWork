package com.valya.homework.zoo;

import java.time.LocalDate;

class Worker {

    private String name;
    private int age;
    private String sex;
    private String position;
    private int timeStartWork ;
    private int timeFinishWork;
    private int employmentDate;
    private double startingSalary;
    private boolean combinesPositions;

    public Worker(String name, int age, String sex, String position, int timeStartWork, int timeFinishWork,
                  int employmentDate, double startingSalary, boolean combinesPositions) {
        this.name = name;
        this.age = age;
        this.sex = sex;
        this.position = position;
        this.timeStartWork = timeStartWork;
        this.timeFinishWork = timeFinishWork;
        this.employmentDate = employmentDate;
        this.startingSalary = startingSalary;
        this.combinesPositions = combinesPositions;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getSex() {
        return sex;
    }

    public String getPosition() {
        return position;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public int getTimeStartWork() {
        return timeStartWork;
    }

    public void setTimeStartWork(int timeStartWork) {
        this.timeStartWork = timeStartWork;
    }

    public int getTimeFinishWork() {
        return timeFinishWork;
    }

    public void setTimeFinishWork(int timeFinishWork) {
        this.timeFinishWork = timeFinishWork;
    }

    public int getEmploymentDate() {
        return employmentDate;
    }

    public void setEmploymentDate(int employmentDate) {
        this.employmentDate = employmentDate;
    }

    public double getStartingSalary() {
        return startingSalary;
    }

    public void setStartingSalary(double salary) {
        this.startingSalary = salary;
    }

    public boolean isCombinesPositions() {
        return combinesPositions;
    }

    public void setCombinesPositions(boolean combinesPositions) {
        this.combinesPositions = combinesPositions;
    }



    public void workTime(int time) {
        if (time >= timeStartWork && time < timeFinishWork) {
            System.out.println("Welcome to the zoo!");
        } else {
            System.out.println("I'm not at work right now");
        }
    }

    /*The method of calculating salaries with bonuses*/

    public double calculateSalary (int month) {

        double bonus = 0;

        int currentYear = LocalDate.now().getYear();
        int workerExperience = currentYear - employmentDate + 1;

        //april or december
        if(month == 12 || month == 4) {
            bonus += 100;
        }

        if(workerExperience > 5 || age > 50) {
            bonus +=  startingSalary * 0.1;
        }

        if(combinesPositions) {
            bonus += startingSalary * 0.2;
        }
        return Math.round(startingSalary + bonus);
    }

}
