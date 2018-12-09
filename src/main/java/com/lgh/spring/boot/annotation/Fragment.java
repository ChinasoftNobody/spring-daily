package com.lgh.spring.boot.annotation;

import java.lang.annotation.*;

@Retention(RetentionPolicy.RUNTIME)
@Target(value={ElementType.METHOD})
@Documented
@Inherited
public @interface Fragment {
}
