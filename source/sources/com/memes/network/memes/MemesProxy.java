package com.memes.network.memes;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\bÀ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0005\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\u0004J\u000e\u0010\b\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\u0004R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\n"}, mo26107d2 = {"Lcom/memes/network/memes/MemesProxy;", "", "()V", "MEMES_CDN", "", "isJustCdnPath", "", "input", "toAbsoluteCdnUrl", "relativeUrl", "network_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
/* compiled from: MemesProxy.kt */
public final class MemesProxy {
    public static final MemesProxy INSTANCE = new MemesProxy();
    private static final String MEMES_CDN = "https://cdn.memes.com/";

    private MemesProxy() {
    }

    public final String toAbsoluteCdnUrl(String str) {
        Intrinsics.checkNotNullParameter(str, "relativeUrl");
        return "https://cdn.memes.com/" + str;
    }

    public final boolean isJustCdnPath(String str) {
        return Intrinsics.areEqual((Object) str, (Object) "https://cdn.memes.com/");
    }
}
