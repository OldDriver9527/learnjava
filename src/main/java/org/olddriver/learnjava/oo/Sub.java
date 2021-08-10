package org.olddriver.learnjava.oo;

public class Sub extends Foo  {

    private String baseName = "sub";
    public void callName() {
        System.out.println(super.getClass().getName());
    }

    public static void main(String[] args) {
        new Sub().callName();
    }
}
