package com.kingdie.wangweijian.lambda.file;

import org.junit.Test;

import java.io.IOException;

/**
 * @ Author : Weijian_Wang
 * @ Date : Created in 18:13 2019/10/13 0013
 * @ Description ：测试函数式接口处理方式
 */
public class FileServiceTest {

    @Test
    public void fileHandler() throws IOException {
        FileService fileService = new FileService();

        //通过lambda表达式打印文件内容
        fileService.fileHandle("D:\\告别996，开启Java高效编程之门" +
                        "\\_996\\src\\test\\java\\com\\kingdie\\wangweijian\\lambda" +
                        "\\file\\FileServiceTest.java",
                fileContent -> System.out.println(fileContent));
    }
}
