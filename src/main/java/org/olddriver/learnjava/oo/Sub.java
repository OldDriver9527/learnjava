package org.olddriver.learnjava.oo;

public class Sub extends NestedClass.Inner {
    private String name = "Sub";

    public Sub(NestedClass o) {
        o.super();
    }

    public static void main(String[] args) {
        NestedClass.Inner i = new NestedClass().new Inner();
    }
}
