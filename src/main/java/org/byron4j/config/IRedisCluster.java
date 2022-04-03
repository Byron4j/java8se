package org.byron4j.config;

public interface IRedisCluster {

    String set(String key, String value);

    String get(String key);
}