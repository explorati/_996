package com.kingdie.wangweijian.lambda.stream;

import org.junit.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.stream.Stream;

/**
 * @ Author : Weijian_Wang
 * @ Date : Created in 9:07 2019/10/15 0015
 * @ Description ：流的四种构建形式
 */
public class StreamConstructor {

    /**
     * 由数值直接构建流
     */
    @Test
    public void streamFromValue() {
        Stream stream = Stream.of(1, 2, 3, 4, 5);
//        stream.forEach(item -> System.out.println(item));
        stream.forEach(System.out::println);
    }

    /**
     * 由数组构建流
     */
    @Test
    public void streamFromArray() {
        int[] nums = {1, 2, 3, 4, 5};
        Arrays.stream(nums)
                .forEach(System.out::println);
    }

    /**
     * 使用文件生成stream流
     * @throws IOException
     */
    @Test
    public void streamFromFile() throws IOException {
        String url = "D:\\告别996，开启Java高效编程之门\\_996\\src\\test\\java\\com\\kingdie\\wangweijian\\lambda\\stream" +
                "\\StreamConstructor.java";

        Stream<String> stream = Files.lines(Paths.get(url.replace("\\", "/")));
        stream.forEach(System.out::println);
    }

    /**
     * 使用函数生成流(无限流) iterate/generate
     */
    @Test
    public void streamFromFunction() {
        //无限的流
//        Stream.iterate(0, x -> x + 2)
//                .forEach(System.out::println);
        Stream.generate(Math::random)
                //限制个数100个
                .limit(100)
                .forEach(System.out::println);
    }

}
