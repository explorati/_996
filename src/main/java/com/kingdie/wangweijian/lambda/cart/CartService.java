package com.kingdie.wangweijian.lambda.cart;

import sun.util.cldr.CLDRLocaleDataMetaInfo;

import java.util.ArrayList;
import java.util.List;

/**
 * @ Author : Weijian_Wang
 * @ Date : Created in 12:37 2019/10/12 0012
 * @ Description ：购物车服务类
 */
public class CartService {
    //加入到购物车中的商品信息
    private static List<Sku> cartSkuList = new ArrayList<Sku>(){
        {
            add(new Sku(654032, "无人机", 4999.00, 1, 4999.00, SkuCategoryEnum.ELECTRONICS));
            add(new Sku(642934, "VR一体机", 2299.00, 1, 2299.00,SkuCategoryEnum.ELECTRONICS));
            add(new Sku(645321, "纯色衬衫", 409.00,3,1227.00, SkuCategoryEnum.CLOTHING));
            add(new Sku(654327, "牛仔裤", 528.00,1,528.00, SkuCategoryEnum.CLOTHING));
            add(new Sku(675489, "跑步机", 2699.00,1,2699.00, SkuCategoryEnum.SPORTS));
            add(new Sku(644564, "Java编程思想", 79.80, 1,79.80, SkuCategoryEnum.BOOKS));
            add(new Sku(678678, "Java核心技术", 149.00, 1, 149.00, SkuCategoryEnum.BOOKS));
            add(new Sku(697894, "算法", 78.20, 1, 78.20, SkuCategoryEnum.BOOKS));
            add(new Sku(696968, "TensorFlow进阶指南", 85.10, 1, 85.10, SkuCategoryEnum.BOOKS));
        }
    };

    /**
     * 获取商品信息列表
     * @return
     */
    public static List<Sku> getCartSkuList(){
        return cartSkuList;
    }

    /**
     * Version1.0.0
     * 找出购物车中所有电子类商品
     * @param cartSkuList
     * @return
     */
    public static List<Sku> filterElectronicSkus(List<Sku> cartSkuList){
        List<Sku> electronicSkus = new ArrayList<Sku>();

        for(Sku cartSku : cartSkuList){
            //如果商品类型 等于 电子类
            if(cartSku.getSkuCategory().equals(SkuCategoryEnum.ELECTRONICS)){
                electronicSkus.add(cartSku);
            }
        }

        return electronicSkus;
    }
}
