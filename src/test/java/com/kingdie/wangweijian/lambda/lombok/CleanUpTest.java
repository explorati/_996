package com.kingdie.wangweijian.lambda.lombok;

import lombok.Cleanup;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * @ Author : Weijian_Wang
 * @ Date : Created in 16:22 2019/10/19 0019
 * @ Description ：@Cleanup注解：资源关闭
 */
public class CleanUpTest {

    @Test
    public void copyFile(String in, String out) throws IOException {
        @Cleanup FileInputStream fileInputStream = new FileInputStream(in);
        @Cleanup FileOutputStream fileOutputStream = new FileOutputStream(out);

        int r;

        while((r = fileInputStream.read()) != -1) {
            fileOutputStream.write(r);
        }
    }
}
