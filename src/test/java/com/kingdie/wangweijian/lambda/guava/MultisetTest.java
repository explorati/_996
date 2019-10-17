package com.kingdie.wangweijian.lambda.guava;

import com.google.common.collect.ConcurrentHashMultiset;
import com.google.common.collect.HashMultiset;
import com.google.common.collect.Multiset;
import com.google.common.primitives.Chars;
import org.junit.Test;

import java.util.Arrays;
import java.util.Iterator;
import java.util.stream.Stream;

/**
 * @ Author : Weijian_Wang
 * @ Date : Created in 11:01 2019/10/17 0017
 * @ Description ：实现：使用Multiset统计一首古诗的文字出现频率
 */
public class MultisetTest {

    private static final String text =
            "《南陵别儿童入京》" +
                    "白酒新熟山中归";

    @Test
    public void handle(){
        //String 转成 char数组
        char[] chars = text.toCharArray();
        //multiset创建
        Multiset<Character> multiset = HashMultiset.create();

        //遍历数组，添加到multiset中
        Chars.asList(chars)
                .stream()
                .forEach(item -> multiset.add(item));

//        Iterator<Character> iter = multiset.iterator();
//        while(iter.hasNext()){
//            System.out.println(iter.next());
//        }

        Chars.asList(chars)
                .stream()
                .filter(item -> item.equals("中"))
                .forEach(item -> multiset.remove(item));
//        Stream.of(iter)
//                .forEach(item -> System.out.println(iter.next()));

//        Chars.asList(chars)
//                .stream()
//                .forEach(item -> multiset.iterator());

        System.out.println("size : " + multiset.size());

        System.out.println("count : " + multiset.count('中'));

        System.out.println("count : " + multiset.count('童'));
    }
}
