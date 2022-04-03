package org.byron4j.config;

import lombok.Data;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

import java.util.List;

@Data
@Component
@PropertySource("classpath:/application.properties")
public class RedisClusterProperties {
    private String nodes;
    private int commandTimeout;
}
