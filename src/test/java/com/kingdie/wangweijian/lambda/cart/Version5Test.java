package com.kingdie.wangweijian.lambda.cart;

import com.alibaba.fastjson.JSON;
import org.junit.Test;

import java.util.List;

/**
 * @ Author : Weijian_Wang
 * @ Date : Created in 12:58 2019/10/13 0013
 * @ Description ：使用匿名内部类优化测试
 */
public class Version5Test {

    @Test
    public void filterSkus(){
        List<Sku> skuList = CartService.getCartSkuList();
        //使用匿名内部类，不用多创建新类
        List<Sku> result = CartService.filterSkus(skuList, new SkuPredicate() {
            public boolean test(Sku sku) {
                return sku.getSkuPrice() > 1000.00;
            }
        });

        System.out.println(JSON.toJSONString(result, true));
    }
}
