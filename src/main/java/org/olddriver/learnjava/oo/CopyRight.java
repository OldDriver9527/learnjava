package org.olddriver.learnjava.oo;

import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(value = RetentionPolicy.RUNTIME)
@Inherited
public @interface CopyRight {
    String value() default "olddriver";
}
