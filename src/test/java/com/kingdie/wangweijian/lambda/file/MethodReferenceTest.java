package com.kingdie.wangweijian.lambda.file;

import org.junit.Test;

import java.util.function.Function;

/**
 * @ Author : Weijian_Wang
 * @ Date : Created in 23:13 2019/10/13 0013
 * @ Description ：方法引用：调用特定方法的Lambda表达式的一种快捷写法，
 *                  让你可以重复使用现有的方法定义，并向Lambda表达式一样传递他们
 */
public class MethodReferenceTest {

    @Test
    public void methodReferenceTest(){
        //方法引用测试：指向静态方法的方法引用
        Function<String, Integer> function1 = Integer::parseInt;
        System.out.println("the Integer is ：" + function1.apply("123"));

        //方法引用测试二：指向实例方法的方法引用
        StringBuilder sb = new StringBuilder();
        sb.append("I am ");
        Function<String, StringBuilder> function2 = sb::append;
        System.out.println(function2.apply("a boy").toString());

    }
}
