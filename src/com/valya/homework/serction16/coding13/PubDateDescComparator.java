package com.valya.homework.serction16.coding13;

import java.util.Comparator;

public class PubDateDescComparator implements Comparator<Book> {

    @Override
    public int compare(Book o1, Book o2) {
        if(o1.getYear() > o2.getYear()) {
            return -1;
        } else if (o1.getYear() < o2.getYear()) {
            return 1;
        } else {
            return o1.compareTo(o2);
        }
    }
}
