package com.kingdie.wangweijian.lambda.cart;

import com.alibaba.fastjson.JSON;
import org.junit.Test;

import java.util.List;

/**
 * @ Author : Weijian_Wang
 * @ Date : Created in 14:49 2019/10/12 0012
 * @ Description ：测试类 1.0.0
 */
public class Version1Test {

    @Test
    public void filterElectronicSkus() {
        List<Sku> cartSkuList = CartService.getCartSkuList();
        //查找购物车中电子类商品
        List<Sku> ElectronicSkus = CartService.filterElectronicSkus(cartSkuList);

        System.out.println(JSON.toJSONString(ElectronicSkus, true));
    }

}
