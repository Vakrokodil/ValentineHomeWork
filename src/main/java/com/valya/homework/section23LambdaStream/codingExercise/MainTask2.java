package com.valya.homework.section23LambdaStream.codingExercise;

import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;


public class MainTask2 {
    public static void main(String[] args) {

        Product notebookHP = new Product(1, "HP", "Notebook", 199.99);
        Product notebookLenovo = new Product(1, "Lenovo", "Notebook", 170.99);
        Product notebookDell = new Product(1, "Dell", "Notebook", 220.99);
        Product phoneSamsung = new Product(2, "Samsung", "Phone", 129.99);
        Product phoneNokia = new Product(3, "Nokia", "Phone", 100.99);
        Product phoneMotorola = new Product(4, "Motorola", "Phone", 130.99);

        List<Product> products = new ArrayList<>();
        products.add(phoneNokia);
        products.add(notebookHP);
        products.add(phoneSamsung);

        List<Product> products2 = new ArrayList<>();
        products2.add(notebookHP);
        products2.add(phoneSamsung);
        products2.add(notebookLenovo);

        List<Product> products3 = new ArrayList<>();
        products3.add(phoneNokia);
        products3.add(phoneMotorola);

        List<Product> products4 = new ArrayList<>();
        products4.add(notebookHP);
        products4.add(notebookDell);
        products4.add(phoneNokia);
        products4.add(phoneMotorola);

        List<Product> products5 = new ArrayList<>();
        products5.add(notebookHP);
        products5.add(notebookDell);
        products5.add(phoneNokia);
        products5.add(null);

        Customer theShop = new Customer(1, "TheShop", 3);
        Customer Ananas = new Customer(2, "Ananas", 1);
        Customer Shopster = new Customer(3, "Shopster", 2);

        Order orderTheShop1 = new Order(1, LocalDate.of(2022, 12, 14), LocalDate.of(2022, 12, 15), "ready"
                , theShop, products);
        Order orderTheShop2 = new Order(2, LocalDate.of(2022, 2, 20), LocalDate.of(2022, 12, 15), "ready"
                , Ananas, products2);
        Order orderTheShop3 = new Order(3, LocalDate.of(2022, 5, 9), LocalDate.of(2022, 12, 15), "ready"
                , Shopster, products3);
        Order orderTheShop4 = new Order(4, LocalDate.of(2022, 10, 11), LocalDate.of(2022, 12, 15), "ready"
                , Shopster, products4);
        Order orderTheShop5 = new Order(5, LocalDate.of(2022, 3, 14), LocalDate.of(2022, 12, 15), "ready"
                , theShop, products);
        Order orderTheShop6 = new Order(6, LocalDate.of(2022, 6, 12), LocalDate.of(2022, 12, 15), "ready"
                , theShop, products2);
        Order orderTheShop7 = new Order(7, LocalDate.of(2022, 6, 12), LocalDate.of(2022, 12, 15), "ready"
                , Shopster, products4);
        Order orderTheShop8 = new Order(8, LocalDate.of(2022, 2, 20), LocalDate.of(2022, 12, 15), "ready"
                , Shopster, products3);


        List<Order> orders = new ArrayList<>();
        orders.add(orderTheShop1);
        orders.add(orderTheShop2);
        orders.add(orderTheShop3);
        orders.add(orderTheShop4);
        orders.add(orderTheShop5);
        orders.add(orderTheShop6);
        orders.add(orderTheShop7);
        orders.add(orderTheShop8);

        //1 Получить список товаров из категории «n» с ценой > 130

        List<Product> listProduct = products4.stream()
                .filter(p -> p.getCategory().equals("Phone") && p.getPrice() > 130)
                .collect(Collectors.toList());

        System.out.println("Task 1. Product list: " + listProduct);

        //2 Получить список заказов с товарами, относящимися к категории «n»

        List<Order> orderList = orders.stream()
                .filter(o -> o.getProducts().stream()
                        .anyMatch(p -> p.getCategory().equalsIgnoreCase("notebook")))
                .collect(Collectors.toList());

        System.out.print("Task 2. ID order with products with category n : " );
        orderList.forEach(o -> System.out.print(o.getId() + " "));
        System.out.println();

        //3 Получите список товаров с категорией «n», а затем примените скидку 25%

        List<Product> productsSale = products2.stream()
                .filter(p -> p.getCategory().equals("Phone"))
                .map(p -> new Product(p.getId(),p.getName(),p.getCategory(),p.getPrice() * 0.75))
                .collect(Collectors.toList());

        System.out.println("Task 3. Product list: " + productsSale);

        //4 Получите список товаров, заказанных клиентом уровня 3 в период с 01 марта 2022 г. по 30 июня 2022 г.

        List<Product> pr1 = orders.stream()
                .filter(o -> o.getOrderDate().isAfter(LocalDate.of(2022, 3, 1)) &&
                        o.getOrderDate().isBefore(LocalDate.of(2022, 6, 30)) &&
                        o.getCustomer().getTier() == 3)
                .map(Order::getProducts)
                .flatMap(Collection::stream)
                .distinct()
                .collect(Collectors.toList())
                ;

        System.out.println("Task 4. Product list: " + pr1);

        //5 Получите самые дешевые товары категории «n»

       List<Product> cheapestProducts = orders.stream()
               .map(Order::getProducts)
               .flatMap(Collection::stream)
               .filter(p -> p.getCategory().equalsIgnoreCase("notebook"))
               .distinct()
               .sorted(Comparator.comparing(Product::getPrice))
               .limit(2)
               .collect(Collectors.toList());

        System.out.println("Task 5. The cheapest products : " + cheapestProducts);


        //6 Получите 5 последних заказа

        List<Order> orderLast = orders.stream()
                .sorted((o1,o2) -> o2.getOrderDate().compareTo(o1.getOrderDate()))
                .limit(2)
                .collect(Collectors.toList());

        System.out.println("Task 6. Order list: " + orderLast);

        //7 Получите список заказов, которые были заказаны 12 июня 2022 года. Выведите все записи заказов в консоль. Верните список продуктов.

        List<Product> pr2 = orders.stream()
                .filter(o -> o.getOrderDate().isEqual(LocalDate.of(2022, 6, 12)))
                .peek(System.out::println)
                .map(Order::getProducts)
                .flatMap(Collection::stream)
                .distinct()
                .collect(Collectors.toList())
                ;

        System.out.println("Task 7. Product list: " + pr2);

        //8 Рассчитайте общую сумму всех заказов, сделанных в июне

        double sumOrder = orders.stream()
                .filter(o -> o.getOrderDate().getMonth() == Month.JUNE)
                .map(Order::getProducts)
                .flatMap(Collection::stream)
                .mapToDouble(Product::getPrice).sum();

        System.out.println("Task 8. Price all products in june: " + sumOrder);

        //9 Рассчитать среднюю сумму заказов за 20 февраля

        long count = orders.stream()
                .filter(o -> o.getOrderDate().isEqual(LocalDate.of(2022, 2, 20)))
                .count();

        double sum = orders.stream()
                .filter(o -> o.getOrderDate().isEqual(LocalDate.of(2022, 2, 20)))
                .map(Order::getProducts)
                .flatMap(Collection::stream).
                mapToDouble(Product::getPrice).sum();

        double avrSum = sum / count;

        System.out.println("Task 9. Average price products 20.02.22: " + avrSum);

        //10 Получите Map'у с идентификатором заказа и количеством продуктов в заказе

        Map<Integer, Integer> mapIdCountOrder = orders.stream()
                .collect(Collectors.toMap(Order::getId, order ->  order.getProducts().size()));

        System.out.println("Task 10. Map with Id and total number of products : " + mapIdCountOrder);

        //11 Получите Map'у с заказом и общей суммой товаров

        Map<Integer, Double> mapIdPriceOrder = orders.stream()
                .collect(Collectors.toMap(Order::getId, order ->
                                order.getProducts().stream().mapToDouble(Product::getPrice).sum()));

        System.out.println("Task 11. Map with Id and total amount of products : " + mapIdPriceOrder);

        //12 Получите самый дорогой продукт по категории

        Optional<Product> optionalProduct2 = orders.stream()
                .map(Order::getProducts)
                .flatMap(Collection::stream)
                .filter(p -> p.getCategory().equalsIgnoreCase("notebook"))
                .max(Comparator.comparingDouble(Product::getPrice));

        if (optionalProduct2.isPresent()) {
            System.out.println("Task 12. The most expensive product : " + optionalProduct2.get());

        } else {
            System.out.println("There are no any products in this category");
        }

        //13 Добавить null к какой-нибудь коллекции и использовать Optional

        Optional<Product> isProduct = products5.stream()
                .filter(Objects::nonNull)
                .reduce((prod1, prod2) -> prod1.getPrice() > prod2.getPrice() ? prod2 : prod1);

        isProduct.ifPresent(System.out::println);

        isProduct.map(Product::getPrice)
                .flatMap(price -> Optional.of(price  *1.10))
                .ifPresent(System.out::println);

    }

}

