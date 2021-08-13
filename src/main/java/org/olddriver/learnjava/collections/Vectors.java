package org.olddriver.learnjava.collections;

import java.util.Vector;

public class Vectors {
    public static void main(String[] args) {
        Vector<String> vector = new Vector<>();

        vector.add("hello");
        vector.add("world");
        vector.add("good");
        vector.add("luck");

        vector.forEach((ele)->{
            System.out.println(ele);
        });

    }
}
