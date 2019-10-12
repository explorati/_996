package com.kingdie.wangweijian.lambda.cart;

/**
 * @ Author : Weijian_Wang
 * @ Date : Created in 17:46 2019/10/12 0012
 * @ Description ：对Sku的商品类型为图书类的判断标准
 */
public class SkuBooksCategoryPredicate implements SkuPredicate {
    public boolean test(Sku sku) {
        return SkuCategoryEnum.BOOKS.equals(sku.getSkuCategory());
    }
}
