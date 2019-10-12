package com.kingdie.wangweijian.lambda.cart;

/**
 * @ Author : Weijian_Wang
 * @ Date : Created in 12:39 2019/10/12 0012
 * @ Description ：商品类型枚举
 */
public enum SkuCategoryEnum {
    CLOTHING(10, "服装类"),
    ELECTRONICS(20, "数码类"),
    SPORTS(30, "运动类"),
    BOOKS(40, "图书类");

    //商品类型编号
    private Integer code;
    //商品类型名称
    private String name;

    /**
     * 构造方法
     * @param code
     * @param name
     */
    SkuCategoryEnum(Integer code, String name) {
        this.code = code;
        this.name = name;
    }

}
