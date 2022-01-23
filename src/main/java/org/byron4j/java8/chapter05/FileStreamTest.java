package org.byron4j.java8.chapter05;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.stream.Collectors;

/**
 * 文件中有多少不同的单词
 */
public class FileStreamTest {
    public static void main(String[] args) throws IOException {
        System.out.println(Files.lines(Paths.get("src/main/resources/data.txt"), Charset.defaultCharset())
                .flatMap(ele -> Arrays.stream(ele.split(" ")))
                .distinct()
                .collect(Collectors.toList()));
        System.out.println(Files.lines(Paths.get("src/main/resources/data.txt"), Charset.defaultCharset())
                .flatMap(ele -> Arrays.stream(ele.split(" ")))
                .distinct()
                .count());
    }
}
