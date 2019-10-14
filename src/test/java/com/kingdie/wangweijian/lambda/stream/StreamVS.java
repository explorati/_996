package com.kingdie.wangweijian.lambda.stream;

import com.alibaba.fastjson.JSON;
import com.kingdie.wangweijian.lambda.cart.CartService;
import com.kingdie.wangweijian.lambda.cart.Sku;
import com.kingdie.wangweijian.lambda.cart.SkuCategoryEnum;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.concurrent.atomic.AtomicReference;
import java.util.stream.Collectors;

/**
 * @ Author : Weijian_Wang
 * @ Date : Created in 9:34 2019/10/14 0014
 * @ Description ：对比 原始集合操作 与 Stream集合操作
 */
public class StreamVS {

    /**
     * 1.想看看购物车里都有什么东西
     * 2.图书类商品都给买
     * 3.其余的商品之中买两件最贵的
     * 4.只需要两件商品的名称和总价
     */

    /**
     * 以最原始的集合操作实现需求
     */
    @Test
    public void oldCartHandle() {
        List<Sku> skuList = CartService.getCartSkuList();

        /**
         * 实现需求一：购物车中都有什么
         */
        System.out.println("购物车中商品有：");
        System.out.println(JSON.toJSONString(skuList, true));

        /**
         * 实现需求二：图书类商品都买
         */
        List<Sku> notBooksSkuList = new ArrayList<>();
        //将除了图书类的商品放入新建集合notBooksSkuList内
        for (Sku sku : skuList) {
            if (!sku.getSkuCategory().equals(SkuCategoryEnum.BOOKS)) {
                notBooksSkuList.add(sku);
            }
        }
//        List<Sku> bookCategoryList = CartService.filterSkus(skuList,
//                (Sku sku) -> sku.getSkuCategory().equals(SkuCategoryEnum.BOOKS));

        /**
         * 实现需求三：其余商品之中买两件最贵的
         */
        //先对除了图书类的商品集合进行排序
        notBooksSkuList.sort(new Comparator<Sku>() {
            @Override
            public int compare(Sku sku1, Sku sku2) {
                if (sku1.getTotalPrice() > sku2.getTotalPrice()) {
                    return -1;
                } else if (sku1.getTotalPrice() < sku2.getTotalPrice()) {
                    return 1;
                } else {
                    return 0;
                }
            }
        });

        //创建一个新的集合，大小为2
        List<Sku> top2SkuList = new ArrayList<Sku>();
        //将除图书类之外的 排好序的商品集合 中的前两位放到新集合中
        for (int i = 0; i < 2; i++) {
            top2SkuList.add(notBooksSkuList.get(i));
        }

        /**
         * 实现需求四：求两件商品的总价和名称
         */
        Double money = 0.0;
        //计算总价
        for (Sku sku : top2SkuList) {
            money += sku.getTotalPrice();
        }

        //打印最贵的两件商品名称
        List<String> resultSkuNameList = new ArrayList<>();
        for (Sku sku : top2SkuList) {
            resultSkuNameList.add(sku.getSkuName());
        }

        //打印输出结果
        System.out.println("最贵的两件商品名称为：");
        System.out.println(JSON.toJSONString(resultSkuNameList, true));
        System.out.println("商品总价：" + money);

        System.out.println("------------另一种方式实现需求四-------------");

        //用优先队列比较，重写比较器(由于Java自带的是最小堆)
        PriorityQueue<Sku> pq = new PriorityQueue<>(new Comparator<Sku>() {
            @Override
            public int compare(Sku sku1, Sku sku2) {
                if (sku1.getTotalPrice() > sku2.getTotalPrice()) {
                    return -1;
                } else if (sku1.getTotalPrice() < sku2.getTotalPrice()) {
                    return 1;
                } else {
                    return 0;
                }
            }
        });

        //将除图书类商品外的所有商品放入最大堆中
        for (Sku sku : notBooksSkuList) {
            pq.add(sku);
        }

        //查看堆顶元素
        System.out.println("最初堆顶元素为：" + pq.peek().getSkuName());

        //打印最贵两件商品名称
        System.out.print("最贵的两件商品 名称为：");
        for (int i = 2; i >= 1; i--) {
            System.out.print(pq.poll().getSkuName() + "  ");
        }

        //查看剩余商品中最贵商品名称
        System.out.println();
        System.out.println("除去最贵的两件商品 最贵的商品名称为：" + pq.peek().getSkuName());
    }

    /**
     * 以Stream流方式实现需求
     */
    @Test
    public void newCartHandle() {
        AtomicReference<Double> money = new AtomicReference<>(Double.valueOf(0.0));
        List<String> skuList =
                 CartService.getCartSkuList()
                        .stream()
                        /**
                         * 1.打印商品信息
                         */
                        .peek(sku -> System.out.println(JSON.toJSONString(sku, true)))
                        /**
                         * 2.过滤掉所有图书类商品
                         */
                        .filter(sku -> !SkuCategoryEnum.BOOKS.equals(sku.getSkuCategory()))
                        /**
                         * 排序
                         */
                        .sorted(Comparator.comparing(Sku::getTotalPrice).reversed())
                        /**
                         * TOP2
                         */
                        .limit(2)
                        /**
                         * 累加商品总金额
                         */
                        .peek(sku -> money.set(money.get() + sku.getTotalPrice()))
                        /**
                         * 获取商品名称
                         */
                        .map(sku -> sku.getSkuName())
                        /**
                         * 收集结果
                         */
                        .collect(Collectors.toList());

        /**
         * 打印输出结果
          */
        System.out.println(JSON.toJSONString(skuList,true));
        System.out.println("商品总价：" + money.get());

    }
}
