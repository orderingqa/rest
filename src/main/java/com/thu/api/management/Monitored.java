
package com.thu.api.management;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Indicates that an annotated class or method should be monitored
 *
 * @author liushuai
 */
@Target({ElementType.TYPE, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface Monitored {

    /**
     * The value may be used when presenting information related to the monitored
     * method or class
     * 
     * @return the name, if any
     */
    String value() default "";
    
}