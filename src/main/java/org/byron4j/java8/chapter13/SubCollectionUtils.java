package org.byron4j.java8.chapter13;

import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 获取数学上的子集
 */
public class SubCollectionUtils {
    public static void main(String[] args) {
        List<Integer> integers = Arrays.asList(1, 2, 3, 4);
        System.out.println(subList(integers));
    }

    public static List<List<Integer>> subList(List<Integer> list){
        // 空集合则返回子集{}
        if (CollectionUtils.isEmpty(list)) {
            List<List<Integer>> result = new ArrayList<>();
            result.add(Collections.emptyList());
            return result;
        }
        Integer first = list.get(0);
        List<Integer> remainList = list.subList(1, list.size());
        List<List<Integer>> lists = subList(remainList);
        List<List<Integer>> lists2 = insertAll(lists, first);
        return concat(lists, lists2);
    }

    private static List<List<Integer>> concat(List<List<Integer>> lists, List<List<Integer>> lists2) {
        for (List<Integer> list : lists) {
            for (List<Integer> integers : lists2) {
                list.addAll(integers);
            }

        }
        return lists;
    }

    private static List<List<Integer>> insertAll(List<List<Integer>> lists, Integer first) {
        for (List<Integer> list : lists) {
            list.add(first);
        }
        return lists;
    }

}
