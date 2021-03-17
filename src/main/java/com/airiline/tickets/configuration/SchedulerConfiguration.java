package com.airiline.tickets.configuration;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cache.CacheManager;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

import static com.airiline.tickets.configuration.CachingConfiguration.WEATHER_CACHE;


@Slf4j
@Configuration
@EnableScheduling
@RequiredArgsConstructor
public class SchedulerConfiguration {

    private final CacheManager cacheManager;

    @Scheduled(cron = "${job.clear-weather-cache.cron-expresion}")
    public void clearWeatherCacheSchedule() {
        log.info("Clear {} cache job started.", WEATHER_CACHE);
        cacheManager.getCache(WEATHER_CACHE).clear();
        log.info("Clear {} cache job completed.", WEATHER_CACHE);
    }
}
