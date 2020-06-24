package com.ecommercerest.config.cache;

import org.springframework.cache.CacheManager;
import org.springframework.cache.support.SimpleCacheManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;

@Configuration
public class CacheConfiguration {

    @Bean
    public CacheManager cacheManager() {
        SimpleCacheManager simpleCacheManager = new SimpleCacheManager();
        simpleCacheManager.setCaches(Arrays.asList(
                GrupoCache.getInstance().createSingleGrupoCache(),
                SubGrupoCache.getInstance().createSingleSubGrupoCache()));
        return simpleCacheManager;
    }

}
