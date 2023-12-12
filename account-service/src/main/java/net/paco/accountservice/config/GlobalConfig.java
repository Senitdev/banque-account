package net.paco.accountservice.config;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "global.params") public record GlobalConfig(int p1, int p2 , int x, int y) {
}
