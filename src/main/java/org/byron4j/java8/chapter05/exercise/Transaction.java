package org.byron4j.java8.chapter05.exercise;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 交易
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class Transaction {
    private Trader trader;
    private int year;
    private int value;
}
