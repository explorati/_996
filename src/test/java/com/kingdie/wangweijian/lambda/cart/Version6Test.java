package com.kingdie.wangweijian.lambda.cart;

import com.alibaba.fastjson.JSON;
import org.junit.Test;

import java.util.List;

/**
 * @ Author : Weijian_Wang
 * @ Date : Created in 13:07 2019/10/13 0013
 * @ Description ：
 */
public class Version6Test {
    @Test
    public void filterSkus(){
        List<Sku> skuList = CartService.getCartSkuList();
        //使用匿名内部类，不用多创建新类
        List<Sku> result = CartService.filterSkus(skuList, (Sku sku) -> sku.getSkuPrice() > 1000.00);

        System.out.println(JSON.toJSONString(result, true));
    }
}
