package com.kingdie.wangweijian.lambda.stream;

import com.alibaba.fastjson.JSON;
import com.kingdie.wangweijian.lambda.cart.CartService;
import com.kingdie.wangweijian.lambda.cart.Sku;
import org.junit.Before;
import org.junit.Test;

import java.util.List;
import java.util.Optional;
import java.util.OptionalDouble;

/**
 * @ Author : Weijian_Wang
 * @ Date : Created in 20:16 2019/10/14 0014
 * @ Description ：
 */
public class StreamTerminalOperator {
    List<Sku> list;

    @Before
    public void init() {
        list = CartService.getCartSkuList();
    }

    /**
     * allMathch使用：终端操作，短路操作。 所有元素匹配，返回true
     */
    @Test
    public void allMatchTest() {
        boolean match = list.stream()
                .peek(sku -> System.out.println(sku.getSkuName()))
                //当遍历到不符合的元素，就返回 --短路操作
                .allMatch(sku -> sku.getTotalPrice() > 100);
        System.out.println("购物车中所有商品总价是否都大于100：" + match);
    }

    /**
     * anyMatch使用：任何元素匹配，返回true
     */
    @Test
    public void anyMatch() {
        boolean match = list.stream()
                .peek(sku -> System.out.println(sku.getSkuName()))
                .anyMatch(sku -> sku.getTotalPrice() > 100);
        System.out.println("购物车中是否有商品总价大于100的商品：" + match);
    }

    /**
     * noneMatch使用：没有一个元素匹配，返回true
     */
    @Test
    public void noneMatchTest() {
        boolean match = list.stream()
                .peek(sku -> System.out.println(sku.getSkuName()))
                .noneMatch(sku -> sku.getTotalPrice() > 10000);

        System.out.println("购物车中是否所有商品总价都大于10000：" + match);
    }

    /**
     * 找到第一个
     */
    @Test
    public void findFirstTest() {
        Optional<Sku> optional = list.stream()
                .findFirst();

        System.out.println("the first element is : " + JSON.toJSONString(optional.get()));
    }

    /**
     * 找到任意一个元素：并行上比findFirst好，但有可能会随机取得一个元素
     */
    @Test
    public void findAnyTest() {
        Optional<Sku> optional = list.stream()
                .findAny();
        System.out.println(JSON.toJSONString(optional.get(), true));
    }

    /**
     * max:找到最大值
     */
    @Test
    public void maxTest() {
        OptionalDouble optionalDouble = list.stream()
                //获取总价
                .mapToDouble(sku -> sku.getTotalPrice())
                .max();

        System.out.println(optionalDouble.getAsDouble());
    }

    @Test
    public void minTest() {
        OptionalDouble optionalDouble = list.stream()
                //获取总价
                .mapToDouble(sku -> sku.getTotalPrice())
                .min();
        System.out.println(optionalDouble.getAsDouble());
    }

    @Test
    public void count() {
        long count = list.stream()
                .count();
        System.out.println("stream流中所有元素的个数为：" + count);
    }
}
