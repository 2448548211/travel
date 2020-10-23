package com.xlibaba.travel.util.myutils;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 成员变量注解类
 * @author ChenWang
 * @annotationName FieldColName
 * @date 2020/10/15 20:22
 * @since JDK 1.8
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
public @interface FieldColName {
    String value() default "";
}
