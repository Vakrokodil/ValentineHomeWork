package com.valya.homework.zoo;

import java.util.Scanner;

class MyZoo {

    Animal[] animals;
    Worker[] workers;

    public MyZoo(Animal[] animals, Worker[] workers) {
        this.animals = animals;
        this.workers = workers;
    }

    /*Information about the names and positions of all employees*/
    public static void givePositionAndName(Worker[] arrayWorkers) {
        System.out.println("\nWe have " + arrayWorkers.length + " workers:");
        for (Worker element : arrayWorkers) {
            System.out.println(element.getPosition() + " - " + element.getName());
        }
    }

    /*Info about salary in month*/
    public static void giveAllSalary(Worker[] arrayWorkers, int month) {
        for (Worker arrayWorker : arrayWorkers) {
            System.out.println("\nSalary " + arrayWorker.getName() + " for " + month + " " + arrayWorker.calculateSalary(month) +
                    " And Starting salary: " + arrayWorker.getStartingSalary());
        }
    }

    /*Grooming lion*/
    public void doGrooming(Lion lion, int month) {
        Scanner scanner = new Scanner(System.in);
        switch (month) {
            case 1, 3, 5, 7, 9, 11 -> System.out.println(lion.getName() + " looks great!");
            default -> {
                System.out.println("Grooming is not scheduled for this month.");
                System.out.println("Do grooming anyway? If yes please enter 1, if no enter 2: ");
                if (scanner.nextInt() == 1) {
                    System.out.println(lion.getName() + " looks great!");
                } else {
                    System.out.println("We'll brush you next time...");
                }
            }
        }
    }

    /*Sort by weight in ascending order*/
    public static void sortByWeight(Animal[] animals) {
        Animal animalTemp;
        for(int i = 0; i < animals.length; i++){
            for (int j = i + 1; j <animals.length; j++) {

                if(animals[i].getWeight() > animals[j].getWeight()) {
                    animalTemp = animals[j];
                    animals[j] = animals[i];
                    animals[i] = animalTemp;
                }
            }
        }
        System.out.println("\nAnimal and weight in order:");
        for(Animal element : animals) {
            System.out.println(element.getName() + " - " + element.getWeight());
        }
    }
}
