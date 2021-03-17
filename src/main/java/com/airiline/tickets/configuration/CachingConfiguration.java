package com.airiline.tickets.configuration;

import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.concurrent.ConcurrentMapCacheManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableCaching
public class CachingConfiguration {

    public static final String WEATHER_CACHE = "weather";

    @Bean
    public CacheManager cacheManager() {
        return new ConcurrentMapCacheManager(WEATHER_CACHE);
    }
}
