package com.google.firebase.remoteconfig.internal;

import com.google.android.gms.common.util.BiConsumer;

/* compiled from: ConfigGetParameterHandler */
final /* synthetic */ class ConfigGetParameterHandler$$Lambda$1 implements Runnable {
    private final BiConsumer arg$1;
    private final String arg$2;
    private final ConfigContainer arg$3;

    private ConfigGetParameterHandler$$Lambda$1(BiConsumer biConsumer, String str, ConfigContainer configContainer) {
        this.arg$1 = biConsumer;
        this.arg$2 = str;
        this.arg$3 = configContainer;
    }

    public static Runnable lambdaFactory$(BiConsumer biConsumer, String str, ConfigContainer configContainer) {
        return new ConfigGetParameterHandler$$Lambda$1(biConsumer, str, configContainer);
    }

    public void run() {
        this.arg$1.accept(this.arg$2, this.arg$3);
    }
}
