package com.ecommercerest.config.cache;

import com.google.common.cache.CacheBuilder;
import org.springframework.cache.guava.GuavaCache;

import java.util.concurrent.TimeUnit;

public class SubGrupoCache {

    private static SubGrupoCache INSTANCE = null;
    public static final String SINGLE_SUBGRUPO = "SINGLE_SUBGRUPO";

    private SubGrupoCache() {

    }

    public static SubGrupoCache getInstance() {
        if (INSTANCE == null) {
            synchronized (SubGrupoCache.class) {
                if (INSTANCE == null) {
                    INSTANCE = new SubGrupoCache();
                }
            }
        }
        return INSTANCE;
    }

    public GuavaCache createSingleSubGrupoCache() {
        return new GuavaCache(SINGLE_SUBGRUPO, CacheBuilder
                .newBuilder()
                .maximumSize(1000)
                .expireAfterAccess(120, TimeUnit.MINUTES)
                .build(),
                false);
    }

}
