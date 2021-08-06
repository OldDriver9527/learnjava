package org.olddriver.learnjava.oo;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(value = RetentionPolicy.RUNTIME)
public @interface CopyRight {
    String value() default "olddriver";
}
