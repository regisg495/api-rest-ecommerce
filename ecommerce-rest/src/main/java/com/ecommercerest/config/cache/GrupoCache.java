package com.ecommercerest.config.cache;

import com.google.common.cache.CacheBuilder;
import org.springframework.cache.guava.GuavaCache;

import java.util.concurrent.TimeUnit;

public class GrupoCache {

    private static GrupoCache INSTANCE = null;
    public static final String SINGLE_GRUPO = "SINGLE_GRUPO";

    private GrupoCache() {

    }

    public static GrupoCache getInstance() {
        if (INSTANCE == null) {
            synchronized (GrupoCache.class) {
                if (INSTANCE == null) {
                    INSTANCE = new GrupoCache();
                }
            }
        }
        return INSTANCE;
    }

    public GuavaCache createSingleGrupoCache() {
        return new GuavaCache(SINGLE_GRUPO, CacheBuilder
                .newBuilder()
                .maximumSize(1000)
                .expireAfterAccess(240, TimeUnit.MINUTES)
                .build(),
                false);
    }


}
