package com.kingdie.wangweijian.lambda.cart;

/**
 * @ Author : Weijian_Wang
 * @ Date : Created in 17:38 2019/10/12 0012
 * @ Description ：Sku选择谓词接口
 */
public interface SkuPredicate {

    /**
     * 选择判断标准
     * @param sku
     * @return
     */
    boolean test(Sku sku);
}
