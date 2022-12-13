package com.valya.homework.section23LambdaStream.codingExercise;


import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Random;
import java.util.function.BiFunction;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

class User {
    private String name;
    private String role;

    private int luck;


    User(String name, String role) {
        this.name = name;
        this.role = role;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public int getLuck() {
        return luck;
    }

    public void setLuck(int luck) {
        this.luck = luck;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", role='" + role + '\'' +
                '}';
    }

    public static void main(String[] args) {
        List<User> users = new ArrayList<>();
        users.add(new User("Denis", "mentor"));
        users.add(new User("Evgenii", "intern"));
        users.add(new User("Ekaterina", "intern"));
        users.add(new User("Valentina", "intern"));

        // TODO Task 1: using Predicate to get interns list.
        getInterns(users);

        // TODO Task 2: using Function to add to the list new user and return a number of users with the same role.
        System.out.println("-------------------------------------------------");
        System.out.println(addUserCountSameRole(users, "Ana", "intern"));
        System.out.println(addUserCountSameRole(users, "Ekaterina", "mentor"));

        // TODO Task 3: using Consumer to do pretty output the given user.
        System.out.println("-------------------------------------------------");
        printUser(users,"intern");

        // TODO Task 4: Add new field, like "luck". using Supplier to randomly set luck (0 - 100)
        System.out.println("-------------------------------------------------");
        getLuck(users);

        System.out.println(users.get(0).getLuck());

    }

    public static void getInterns(List<User> users) {

        for (User user : users) {

            Predicate<User> predicate = u -> u.getRole().equalsIgnoreCase("intern");

            if (predicate.test(user)) {
                System.out.println(user);
            }
        }
    }

    public static int addUserCountSameRole(List<User> users, String name, String role) {

        BiFunction<String, String, User> function1 = (nameUser, roleUser) -> new User(nameUser, roleUser);

        User newUser = function1.apply(name, role);
        users.add(newUser);

        Function<String, Boolean> function2 = r -> r.equalsIgnoreCase(role);

        int count = 0;
        for (User user : users) {
            if (function2.apply(user.getRole())) {
                count++;
            }
        }
        return count;
    }

    public static void printUser(List<User> users, String role) {

        Predicate<String> predicate = r -> r.equalsIgnoreCase(role);
        Consumer<User> consumer = System.out::println;

        for (User user : users) {
            if(predicate.test(user.getRole())) {
                consumer.accept(user);
            }
        }
    }

    public static void getLuck(List<User> users) {

        Random random = new Random();

        Supplier<Integer> supplier = () -> random.nextInt(100);

        for (User user : users) {
            user.setLuck(supplier.get());
        }

        Consumer<User> consumer = u -> System.out.println(u.getName() + " : luck at that moment: " + u.getLuck());
        for (User user : users) {
             consumer.accept(user);
        }
    }
}