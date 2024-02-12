package com.sky.annotation;

import com.sky.enumeration.OperationType;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @program: sky-take-out
 * @description:
 * @author: Liming Huang
 * @create-time: 2023-10-17 00:10
 **/

@Target(ElementType.METHOD)//指定注解的作用域：类注解、方法注解etc
@Retention(RetentionPolicy.RUNTIME) // supresswarning等不需要compile 的可以用source，百分之九十九都是runtime，全周期生效
public @interface AutoFill { //@interface即自定义注解
     OperationType value(); //value作为annotation的参数，如果想要默认值可以加default，operationType为枚举类
}
