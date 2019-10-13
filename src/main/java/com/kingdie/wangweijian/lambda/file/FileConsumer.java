package com.kingdie.wangweijian.lambda.file;

/**
 * @ Author : Weijian_Wang
 * @ Date : Created in 17:58 2019/10/13 0013
 * @ Description ：文件处理函数式接口
 */
public interface FileConsumer {

    /**
     * 函数式接口抽象方法
     * @param fileContent - 文件内容字符串
     */
    void fileHandler(String fileContent);
}
