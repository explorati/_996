package com.kingdie.wangweijian.lambda.lombok;

import lombok.EqualsAndHashCode;

/**
 * @ Author : Weijian_Wang
 * @ Date : Created in 15:08 2019/10/19 0019
 * @ Description ：@EqualsAndHashCode注解，生成equals和HashCode方法
 */
@EqualsAndHashCode(
        exclude = { "field1"}
)
public class EqualsAndHashCodeTest {

    private String field1;

    private String field2;

}
