package com.kingdie.wangweijian.lambda.lombok;

import com.sun.istack.internal.NotNull;
import lombok.AccessLevel;
import lombok.Getter;

/**
 * @ Author : Weijian_Wang
 * @ Date : Created in 13:28 2019/10/19 0019
 * @ Description ：@Getter注解：为属性生成get方法
 */
public class GetterTest {

    @Getter(
            lazy = true
    )
    private final String field1 = "explorati";

    @Getter(
            value = AccessLevel.PRIVATE,
            onMethod_ = { @NotNull}
    )
    private String field2;
}
