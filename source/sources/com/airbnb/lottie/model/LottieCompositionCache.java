package com.airbnb.lottie.model;

import androidx.collection.LruCache;
import com.airbnb.lottie.LottieComposition;

public class LottieCompositionCache {
    private static final int CACHE_SIZE_MB = 10;
    private static final LottieCompositionCache INSTANCE = new LottieCompositionCache();
    private final LruCache<String, LottieComposition> cache = new LruCache<>(10485760);

    public static LottieCompositionCache getInstance() {
        return INSTANCE;
    }

    LottieCompositionCache() {
    }

    public LottieComposition getRawRes(int i) {
        return get(Integer.toString(i));
    }

    public LottieComposition get(String str) {
        return this.cache.get(str);
    }

    public void put(int i, LottieComposition lottieComposition) {
        put(Integer.toString(i), lottieComposition);
    }

    public void put(String str, LottieComposition lottieComposition) {
        if (str != null) {
            this.cache.put(str, lottieComposition);
        }
    }
}
