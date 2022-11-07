package com.valya.homework.section13.coding10;

import java.lang.reflect.Method;

public class SimpleUnitTester {

    public static void main(String[] args) throws Exception {

        Class reflectionClass = Reflection.class;
        System.out.println("We have " + execute(reflectionClass) + " methods whose names start with the keyword \"test\" and return a boolean value.");
    }

    public static int execute(Class clazz) throws Exception {

        int failedCount = 0;
        Method[] methodsArray = clazz.getDeclaredMethods();

        for (Method method : methodsArray) {
            if (method.getName().startsWith("test") && method.getReturnType() == boolean.class) {
                failedCount++;
            }
        }

        return failedCount;
    }

}