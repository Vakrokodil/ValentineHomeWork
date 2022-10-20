package com.valya.homework.section7;

import com.google.common.base.CharMatcher;

public class TestGuava {
    public static void main(String[] args)
    {
        String str = "Hello, World_123!!";
        String charsToRemove = ",_!";

        str = CharMatcher.anyOf(charsToRemove).removeFrom(str);
        System.out.println(str);

        String str2 = "1,16,315";
        String charsToRemove2 = ",";

        str2 = CharMatcher.anyOf(charsToRemove2).removeFrom(str2);
        System.out.println(str2);

        String str3 = "Hello, World_123!!";

        //str3 = str3.replaceAll("[^\\w+]", "");
        //str3 = str3.replaceAll(",", "");

        str3 = str3.replace(",", "");
        System.out.println(str3);

        String str4 = "Hello, World_123!!";

        str4 = str4.replaceAll("[^a-zA-Z]", "");
        System.out.println(str4);


    }
}