package com.kingdie.wangweijian.lambda.guava;

import com.alibaba.fastjson.JSON;
import com.google.common.collect.Lists;
import com.google.common.collect.Sets;
import org.junit.Test;

import java.util.List;
import java.util.Set;

/**
 * @ Author : Weijian_Wang
 * @ Date : Created in 16:15 2019/10/17 0017
 * @ Description ：Lists / Sets 使用
 */
public class SetsTest {
    /**
     * Sets工具类的常用方法
     * 并集 / 交集 / 差集 / 分解集合中的所有子集 / 求两个集合的笛卡尔积
     * <p>
     * Lists工具类的常用方式
     * 反转 / 拆分
     */

    private static final Set set1 = Sets.newHashSet(1, 2, 3, 4);
    private static final Set set2 = Sets.newHashSet(4, 5, 6);

    /**
     * 并集
     */
    @Test
    public void union() {
        Set<Integer> set = Sets.union(set1, set2);

        System.out.println(set);
    }

    /**
     * 交集
     */
    @Test
    public void intersection() {
        Set<Integer> set = Sets.intersection(set1, set2);

        System.out.println(set);
    }

    //差集：如果元素属于A而且不属于B
    @Test
    public void difference() {
        Set<Integer> set = Sets.difference(set1, set2);

        System.out.println(set);

        //相对差集：属于A而且不属于B 或者 属于B而且不属于A
        set = Sets.symmetricDifference(set1, set2);

        System.out.println(set);
    }

    //拆分
    @Test
    public void powerSet() {
        Set<Set<Integer>> powerSet = Sets.powerSet(set1);
        System.out.println(JSON.toJSONString(powerSet));
    }

    //笛卡尔积
    @Test
    public void cartesianProduct() {
        Set<List<Integer>> product = Sets.cartesianProduct(set1, set2);

        System.out.println(JSON.toJSONString(product));
    }

    /**
     * 拆分
     */
    @Test
    public void partition() {
        List<Integer> list = Lists.newArrayList(1, 2, 3, 4, 5, 6, 7);
        List<List<Integer>> lists = Lists.partition(list, 3);
        System.out.println(JSON.toJSONString(lists));
    }

    /**
     * 反转
     */
    @Test
    public void reverse() {
        List<Integer> list = Lists.newLinkedList();
        list.add(1);
        list.add(2);
        list.add(3);

        List<Integer> newList = Lists.reverse(list);

        System.out.println(newList);
    }
}
