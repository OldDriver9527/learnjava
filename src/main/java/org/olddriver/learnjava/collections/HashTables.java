package org.olddriver.learnjava.collections;

import java.util.Hashtable;

public class HashTables {
    public static void main(String[] args) {
        Hashtable<String,String> hashTable = new Hashtable<>();

        hashTable.put("hello","world");
        hashTable.put("good","luck");

        hashTable.forEach((key,value)->{
            System.out.println(key+"--"+value);
        });

    }
}
