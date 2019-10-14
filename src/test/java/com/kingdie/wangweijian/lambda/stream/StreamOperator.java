package com.kingdie.wangweijian.lambda.stream;

import com.alibaba.fastjson.JSON;
import com.kingdie.wangweijian.lambda.cart.CartService;
import com.kingdie.wangweijian.lambda.cart.Sku;
import com.kingdie.wangweijian.lambda.cart.SkuCategoryEnum;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * @ Author : Weijian_Wang
 * @ Date : Created in 16:11 2019/10/14 0014
 * @ Description ：流的各种操作
 */
public class StreamOperator {

    List<Sku> list;

    @Before
    public void init() {
        list = CartService.getCartSkuList();
    }

    /**
     * filter使用：过滤掉不符合断言判断的数据 嵌套的是Predicate<T>
     */
    @Test
    public void filterTest() {
        list.stream()
                /**
                 * filter
                 */
                .filter(sku ->
                        SkuCategoryEnum.BOOKS
                                .equals(sku.getSkuCategory()))
                .forEach(item ->
                        System.out.println(
                                JSON.toJSONString(
                                        item, true)));
    }

    /**
     * map使用：将一个元素转换成另一个元素 嵌套的是Function<T, R>
     */
    @Test
    public void mapTest() {
        list.stream()
                //map
                .map(sku -> sku.getSkuName())
                .forEach(item ->
                        System.out.println(
                                JSON.toJSONString(item, true)));
    }

    /**
     * flatMap使用：将一个对象转换成流  入参为T, 出参为一个继承了流的R
     */
    @Test
    public void flatMapTest() {
        list.stream()
                //flagMap
                .flatMap(sku -> Arrays.stream(sku.getSkuName().split("")))
                .forEach(item ->
                        System.out.println(JSON.toJSONString(item, true)));
    }

    /**
     * peek使用：对流中元素进行遍历操作，与forEach类似，但不会销毁流元素   参数为Cosumer
     */
    @Test
    public void peekTest() {
        list.stream()
                //peek
                .peek(sku -> System.out.println(sku.getSkuName()))
                .forEach(item ->
                        System.out.println(JSON.toJSONString(item, true)));
    }

    /**
     * sort使用：对流中元素进行排序，可选择自然排序或指定排序规则.有状态操作
     */
    @Test
    public void sortTest() {
        list.stream()
                //和上一个peek对比
                .peek(sku -> sku.getSkuName())
                //sorted
//                .sorted(new Comparator<Sku>() {
//                    @Override
//                    public int compare(Sku sku1, Sku sku2) {
//                        if (sku1.getTotalPrice() > sku2.getTotalPrice()) {
//                            return -1;
//                        } else if (sku1.getTotalPrice() < sku2.getTotalPrice()) {
//                            return 1;
//                        } else {
//                            return 0;
//                        }
//                    }
//                })
                .sorted(Comparator.comparing(Sku::getTotalPrice).reversed())
                .forEach(item -> System.out.println(JSON.toJSONString(item.getTotalPrice(), true)));
    }

    /**
     *distinct使用：对流元素进行去重。有状态操作
     */
    @Test
    public void distinctTest(){
        list.stream()
                .map(sku -> sku.getSkuCategory())
                .distinct()
                .forEach(item -> System.out.println(JSON.toJSONString(item, true)));
    }

    /**
     * skip使用：跳过前N条记录。有状态操作
     */
    @Test
    public void skipTest() {
        list.stream()
                .sorted(Comparator.comparing(Sku::getTotalPrice))
                .skip(3)
                .forEach(item -> System.out.println(JSON.toJSONString(item.getTotalPrice(), true)));
    }

    /**
     * limit使用：截断前N条记录。有状态操作
     */
    @Test
    public void limitTest() {
        list.stream()
                .sorted(Comparator.comparing(Sku::getTotalPrice))
                /**
                 * skip 和 limit 结合实现分页操作
                 */
                .skip(1 * 3)
                .limit(3)
                .forEach(item -> System.out.println(JSON.toJSONString(item.getTotalPrice(), true)));
    }
}
