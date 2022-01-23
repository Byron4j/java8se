package org.byron4j.java8.chapter05.exercise;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 交易员
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class Trader {
    private String name;
    private String city;
}
