package org.olddriver.learnspring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class A{

    @Autowired
    private static B b;

    public B getB() {
        return b;
    }

    public void setB(B b) {
        this.b = b;
    }

}
