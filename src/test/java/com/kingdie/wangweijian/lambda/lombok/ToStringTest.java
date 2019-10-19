package com.kingdie.wangweijian.lambda.lombok;

import lombok.Setter;
import lombok.ToString;
import org.junit.Test;

/**
 * @ Author : Weijian_Wang
 * @ Date : Created in 14:38 2019/10/19 0019
 * @ Description ：@ToString注解：生成toString()方法
 */
@ToString(
        includeFieldNames = false,
//        exclude = {"field1"},
//        of = {"field1"},
        doNotUseGetters = false
)
public class ToStringTest {

    @Setter
    private String field1;

    @Setter
    private String field2;

    public String getField2() {
        System.out.println("调用get方法");
        return this.field2;
    }

    @Test
    public void test() {
        ToStringTest toStringTest = new ToStringTest();
        toStringTest.setField1("张三");
        toStringTest.setField2("李四");

        System.out.println(toStringTest.toString());
    }

}
