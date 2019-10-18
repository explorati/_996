package com.kingdie.wangweijian.lambda.guava;

import com.google.common.base.Charsets;
import com.google.common.io.CharSink;
import com.google.common.io.CharSource;
import com.google.common.io.Files;

import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;

/**
 * @ Author : Weijian_Wang
 * @ Date : Created in 22:16 2019/10/17 0017
 * @ Description ：演示如何使用流(Source) 与 汇(Sink) 来对文件进行常用操作
 */
public class IOTest {

    public void copyFile() throws IOException {
        /**
         * 创建对应的Source 和 Sink
         */
        CharSource charSource = Files.asCharSource(new File(""), Charsets.UTF_8);

        CharSink charSink = Files.asCharSink(new File(""), Charsets.UTF_8);

        /**
         * 拷贝
         */
        charSource.copyTo(charSink);
    }
}
