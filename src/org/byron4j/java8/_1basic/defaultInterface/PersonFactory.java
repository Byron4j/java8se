package org.byron4j.java8._1basic.defaultInterface;

/**
 * @program: java8se
 * @author: Byron
 * @create: 2019/07/25
 */
@FunctionalInterface
public interface PersonFactory<P> {
    P create(String firstName, String lastName);
}
