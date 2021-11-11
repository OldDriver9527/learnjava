package org.olddriver.learnjava.oo;

public enum Enumeration {
    ONE,TWO("q");

    Enumeration() {
    }

    Enumeration(String value) {
    }

    public static void main(String[] args) {
        Enumeration[] values = values();
        for(Enumeration temp : values){
            System.out.println(temp.getClass());
        }
    }
}
