package com.kingdie.wangweijian.lambda.cart;

import com.alibaba.fastjson.JSON;
import org.junit.Test;

import java.util.List;

/**
 * @ Author : Weijian_Wang
 * @ Date : Created in 15:41 2019/10/12 0012
 * @ Description ：
 */
public class Version2Test {

    @Test
    public void filterSkuByCategory(){
        //获取购物车商品列表
        List<Sku> cartSkuList = CartService.getCartSkuList();
        //根据方法过滤出传入的类型参数的商品
        List<Sku> result = CartService.filterSkusByCategory(cartSkuList, SkuCategoryEnum.BOOKS);

        //参数传入 true 展现效果会更好
        System.out.println(JSON.toJSONString(result, true));
    }

}
