package com.valya.homework.section23LambdaStream.codingExercise;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.OptionalInt;
import java.util.Random;
import java.util.function.BiFunction;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

class User {
    private String name;
    private String role;

    private int luck;


    User(String name, String role) {
        this.name = name;
        this.role = role;
    }

    public static void main(String[] args) {
        List<User> users = new ArrayList<>();
        users.add(new User("Denis", "mentor"));
        users.add(new User("Evgenii", "intern"));
        users.add(new User("Ekaterina", "intern"));
        users.add(new User("Valentina", "intern"));


//        getInterns(users);
//        System.out.println("-------------------------------------------------");
//        System.out.println(addUserCountSameRole(users, "Ana", "intern"));
//        System.out.println(addUserCountSameRole(users, "Ekaterina", "mentor"));
//        System.out.println("-------------------------------------------------");
//        printUser(users,"intern");
//        System.out.println("-------------------------------------------------");
//        getLuck(users);
//        System.out.println(users.get(0).getLuck());

        List<User> internList = users.stream().filter(user -> user.getRole().equals("intern")).collect(Collectors.toList());
        //System.out.println(internList);
        //System.out.println(users.stream().filter(user -> user.getName().toLowerCase().startsWith("e")).collect(Collectors.toList()));

        //1 method
       //System.out.println(changeListNewRole(users, "intern", "software engineer"));

        //2 method
        secondMethod(users, "intern", "software engineer");
        System.out.println(users);

        //skip & limit
        System.out.println(getSliceOfStream(users, 1, 3));

        //anyMatch --True, когда хоть один элемент соответствует условиям
        boolean info = users.stream().anyMatch(user -> (user.getName().length() == 5));
        System.out.println(info);

        //noneMatch	-- True, когда ни один элемент не соответствует условиям
        boolean info2 = users.stream().noneMatch(user ->
                Character.isLowerCase(user.getName().charAt(0))
                        && Character.isUpperCase(user.getRole().charAt(0)));

        System.out.println(info2);


    }

    //1
    public static List<User> changeListNewRole(List<User> users, String oldRole,String newRole) {

        users = users.stream()
                .map(user -> changeRole(user, oldRole, newRole))
                .collect(Collectors.toList());
        return users;
    }

    public static User changeRole(User user, String oldRole,String newRole) {

        Predicate<User> predicate = u -> u.role.equalsIgnoreCase(oldRole);
        if(predicate.test(user)) {
            user.setRole(newRole);
        }
        return user;
    }

    //2
    public static void secondMethod(List<User> users, String oldRole,String newRole) {

        users.stream()
                .filter(user -> user.getRole().equalsIgnoreCase(oldRole))
                .forEach(intern -> intern.setRole(newRole));
    }

    public static <T> List<T> getSliceOfStream (List<T> list, int skipNumber, int limitNimver) {

        return list.stream()
                .skip(skipNumber)
                .limit(limitNimver).collect(Collectors.toList());
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

}

