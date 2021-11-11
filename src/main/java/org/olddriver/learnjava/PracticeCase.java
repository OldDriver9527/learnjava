package org.olddriver.learnjava;

import org.olddriver.learnjava.oo.Foo;

public class PracticeCase extends Foo {
    /**
     * 阶乘
     * @param number
     * @return
     */
    public static int factorial(int number){
        if(number == 1){
            return 1;
        }else{
            return number * factorial(number - 1);
        }
    }


    public static void main(String[] args) {
        PracticeCase sub = new PracticeCase();
        sub.test();

    }
}
