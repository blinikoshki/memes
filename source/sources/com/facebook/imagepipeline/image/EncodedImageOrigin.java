package com.facebook.imagepipeline.image;

import com.appsflyer.ServerParameters;

public enum EncodedImageOrigin {
    NOT_SET("not_set"),
    NETWORK(ServerParameters.NETWORK),
    DISK("disk"),
    ENCODED_MEM_CACHE("encoded_mem_cache");
    
    private final String mOrigin;

    private EncodedImageOrigin(String str) {
        this.mOrigin = str;
    }

    public String toString() {
        return this.mOrigin;
    }
}
