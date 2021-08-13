package org.olddriver.learnjava.oo;

public class Sub extends Foo  {
    private String name = "Sub";

    public Sub() {
    }

    public Sub(String name) {
        this.name = name;
    }

    public String getName() {
        System.out.println(name);
        return name;
    }

    public static void main(String[] args) {
        new Sub();
    }
}
