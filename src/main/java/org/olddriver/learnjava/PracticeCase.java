package org.olddriver.learnjava;

public class PracticeCase {
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
}
