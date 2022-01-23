package org.byron4j.java8.chapter05.exercise;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 交易员需要做的事情
 */
public class Chapter5Test {
    public static void main(String[] args) {
        // 交易员
        Trader raoul = Trader.builder().name("Raoul").city("Cambridge").build();
        Trader mario = Trader.builder().name("Mario").city("Milan").build();
        Trader alan = Trader.builder().name("Alan").city("Cambridge").build();
        Trader brain = Trader.builder().name("Brain").city("Cambridge").build();

        // 交易
        List<Transaction> transactions = Arrays.asList(
                new Transaction(brain, 2011, 300),
                new Transaction(raoul, 2012, 1000),
                new Transaction(raoul, 2011, 400),
                new Transaction(mario, 2012, 710),
                new Transaction(mario, 2012, 700),
                new Transaction(alan, 2012, 950)
        );

        /**
         * 1. 找出2011年发生的所有交易，并按交易额排序（低到高）
         */
        System.out.println(transactions.stream()
                .filter(ele -> ele.getYear() == 2011)
                .sorted(Comparator.comparing(Transaction::getValue))
                .collect(Collectors.toList())
        );

        /**
         * 2. 交易员在哪些不同的城市工作过
         */
        /*System.out.println(transactions.stream()
                .map(ele -> ele.getTrader().getCity())
                .collect(Collectors.toSet()));*/
        System.out.println(transactions.stream()
                .map(ele -> ele.getTrader().getCity())
                .distinct()
                .collect(Collectors.toList()));

        /**
         * 3. 查找所有来自剑桥的交易员，并按姓名排序
         */
        System.out.println(transactions.stream()
                .filter(ele -> "Cambridge".equals(ele.getTrader().getCity()))
                .map(ele -> ele.getTrader())
                .distinct()
                .sorted(Comparator.comparing(Trader::getName))
                .collect(Collectors.toList()));

        /**
         * 4. 返回所有交易员的姓名字符串，按字母顺序排序
         */
        System.out.println(transactions.stream()
                .map(ele -> ele.getTrader().getName())
                .distinct()
                .sorted()
                .reduce("", (a, b) -> a.concat(b)));


        /**
         * 5. 有没有交易员在米兰工作的
         */
        System.out.println(transactions.stream()
                .anyMatch(ele -> "Milan".equals(ele.getTrader().getCity())));

        /**
         * 6. 打印生活在剑桥的交易员的所有交易额
         */
        transactions.stream()
                .filter(ele->"Cambridge".equals(ele.getTrader().getCity()))
                .map(ele->ele.getValue())
                .forEach(System.out::println);

        /**
         * 7. 所有交易中，最高的交易额是多少
         */
        System.out.println(transactions.stream()
                .map(ele -> ele.getValue())
                .reduce(Integer::max));

        /**
         * 8. 找到交易额最小的交易
         */
        System.out.println(transactions.stream()
                .reduce((a, b) -> a.getValue() < b.getValue() ? a : b));
    }
}
