package com.kingdie.wangweijian.lambda.file;

import org.junit.Test;

import java.util.function.*;

/**
 * @ Author : Weijian_Wang
 * @ Date : Created in 22:42 2019/10/13 0013
 * @ Description ：常用函数式接口及使用测试 ： java.util.function包下可以找到
 */
public class FunctionalProgrammingTest {

    @Test
    public void functionalProgramming(){
        //测试一：Function<T, R>   入参为T，返回值为R， 方法apply(T, R)
        String str = "abcdefg";
        Function<String, Integer> function = (String string) -> string.length();

        System.out.println("the length of str is :" + function.apply(str));

        //测试二：Consumer<T>, 入参为T，返回值为void  accept(T)
        String str1 = "Consumer";
        Consumer<String> consumer = (String string) -> System.out.println("test " + string);
        consumer.accept(str1);

        //测试三：BinaryOperator<T> , 入参<T, T>, 返回值 T， apply(T, T)
        BinaryOperator<Integer> binaryOperator = (Integer i1, Integer i2) -> (i1 + i2);
        System.out.println("add result : " + binaryOperator.apply(3, 6));

        //测试四：Predicate<T>, 入参<T>, 返回值boolean, test(T)
        Predicate<Integer> predicate = (Integer i) -> i > 1000;
        System.out.println("the test number is bigger than 1000 : " + predicate.test(1500));

    }
}
