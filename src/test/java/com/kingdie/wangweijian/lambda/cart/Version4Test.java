package com.kingdie.wangweijian.lambda.cart;

import com.alibaba.fastjson.JSON;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @ Author : Weijian_Wang
 * @ Date : Created in 22:56 2019/10/12 0012
 * @ Description ：Version4.0.0 测试
 */
public class Version4Test {

    @Test
    public void filterSkus() {
        //获取购物车商品列表
        List<Sku> skuList = CartService.getCartSkuList();
        //根据传入参数过滤相应信息
        List<Sku> result = CartService.filterSkus(skuList, new SkuTotalPricePredicate());

        System.out.println(JSON.toJSONString(result,true));
    }
}
