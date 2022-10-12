package com.valya.homework.zoo;

/**Реализовать класс,
 * как минимум с одним статическим полем,
 * как минимум с одним статическим методом,
 как минимум один метод должен быть перегружен,
 как минимум один метод на каждый тип
 (то есть, один метод принимает в качествве параметра int, один метод принимает в качествве параметра String, ... boolean, ... массив),
 должен быть реализовано как минимум два конструктора.
 *
 Выполнить задание на реальном, логичном примере (то есть, не просто это все реализовать,
 а сделать это в соответствии с каким-нибудь объектом из жизни: Students, Animals, Cars и т.д.)*/

public class AnimalInZoo{
    public static void main(String[] args) {

        Animal animal1 = new Animal("Rosa",3);
        Lion lion1 = new Lion("Mufasa",5,"male",240);
        Lion lion2 = new Lion("Saraby",4,"female",180);
        Lion lion3 = new Lion("Simba",1,"female",50);
        Lion lion4 = new Lion("Zara", 6, "female", 222);

        Animal[] arrayAnimals = {animal1, lion1, lion2, lion3, lion4};

        Worker worker1 = new Worker("Anna", 52,"female", "veterinarian", 10, 17,
                                      2019,3000,false);
        Worker worker2 = new Worker("Nick",30,"male","sheff", 7, 15,
                                     2020, 2000,true);
        Worker worker3 = new Worker("Tom",23,"male","cleaner", 9, 18,
                                      2021, 1000, true);
        Worker worker4 = new Worker("Rick",35,"male","administrator",10, 20,
                                      2016,1300,false);
        Worker worker5 = new Worker("Liza", 43,"female","cashier", 10,19,
                                      2014, 1200, true);

        Worker[] arrayWorkers = {worker1, worker2, worker3, worker4, worker5};

        MyZoo myZoo = new MyZoo(arrayAnimals, arrayWorkers);
        MyZoo.givePositionAndName(arrayWorkers);
        MyZoo.sortByWeight(arrayAnimals);

//        worker1.workTime(9);
//        worker3.workTime(9);

//        System.out.println("Salary for OCTOBER: ");
//        MyZoo.giveAllSalary(arrayWorkers, 10);
//        System.out.println("Salary for DECEMBER: ");
//        MyZoo.giveAllSalary(arrayWorkers, 12);
//
//        System.out.println("\nPortion for: " + lion1.getName() + " "+ lion1.countMeetPortion(true));
//        System.out.println("Portion for: " + lion2.getName() + " "+ lion2.countMeetPortion(true));
//        System.out.println("Portion for: " + lion3.getName() + " "+ lion3.countMeetPortion(false));
//        System.out.println("Portion for: " + lion4.getName() + " "+ lion4.countMeetPortion(false));

        myZoo.doGrooming(lion1,2);
        myZoo.doGrooming(lion3,3);

//        System.out.println("\nWe have " + Animal.getCountAnimal() + " animals");
//
//        animal1.goSleep("Oh,guys,sorry...");
//        lion1.goSleep();
//        System.out.println("Portion for Jane today is " + lion2.countMeetPortion(true));
//        System.out.println("Portion for Alex today is " + lion1.countMeetPortion(true));


    }
}


