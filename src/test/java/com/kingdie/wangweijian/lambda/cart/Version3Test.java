package com.kingdie.wangweijian.lambda.cart;

import com.alibaba.fastjson.JSON;
import org.junit.Test;

import java.util.List;

/**
 * @ Author : Weijian_Wang
 * @ Date : Created in 16:22 2019/10/12 0012
 * @ Description ：
 */
public class Version3Test {

    @Test
    public void filterSkus(){
        //获取购物车中商品列表
        List<Sku> skuList = CartService.getCartSkuList();
        //根据总价来过滤购物车中超过2000元的商品列表
        List<Sku> result = CartService.filterSkus(skuList, null, 2000.00, false);

        System.out.println(JSON.toJSONString(result, true));
    }

}
