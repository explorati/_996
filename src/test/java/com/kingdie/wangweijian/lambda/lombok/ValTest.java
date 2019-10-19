package com.kingdie.wangweijian.lambda.lombok;

import lombok.val;

import java.util.ArrayList;

/**
 * @ Author : Weijian_Wang
 * @ Date : Created in 15:17 2019/10/19 0019
 * @ Description ：@Val注解，弱语言变量
 */
public class ValTest {

    public ValTest() {
        val field = "explorati";

        val list = new ArrayList<>();
        list.add("explorati");
        list.add('a');
    }
}
