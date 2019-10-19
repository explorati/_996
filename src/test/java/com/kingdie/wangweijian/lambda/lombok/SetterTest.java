package com.kingdie.wangweijian.lambda.lombok;

import com.sun.istack.internal.NotNull;
import lombok.AccessLevel;
import lombok.Setter;

/**
 * @ Author : Weijian_Wang
 * @ Date : Created in 14:26 2019/10/19 0019
 * @ Description ：@Setter注解：为属性生成set方法
 */
public class SetterTest {

    @Setter
    private String field1;

    @Setter(
            value = AccessLevel.PRIVATE,
            onParam_ = { @NotNull}
    )
    private String field2;
}
