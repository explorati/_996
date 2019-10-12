package com.kingdie.wangweijian.lambda.cart;

/**
 * @ Author : Weijian_Wang
 * @ Date : Created in 22:51 2019/10/12 0012
 * @ Description ：对Sku总价是否超出2000作为判断标准
 */
public class SkuTotalPricePredicate implements SkuPredicate{
    public boolean test(Sku sku) {
        return sku.getTotalPrice() > 2000.00;
    }
}
