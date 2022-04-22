package com.google.firebase.remoteconfig;

import com.google.android.gms.common.util.BiConsumer;
import com.google.firebase.remoteconfig.internal.ConfigContainer;
import com.google.firebase.remoteconfig.internal.Personalization;

/* compiled from: RemoteConfigComponent */
final /* synthetic */ class RemoteConfigComponent$$Lambda$4 implements BiConsumer {
    private final Personalization arg$1;

    private RemoteConfigComponent$$Lambda$4(Personalization personalization) {
        this.arg$1 = personalization;
    }

    public static BiConsumer lambdaFactory$(Personalization personalization) {
        return new RemoteConfigComponent$$Lambda$4(personalization);
    }

    public void accept(Object obj, Object obj2) {
        this.arg$1.logArmActive((String) obj, (ConfigContainer) obj2);
    }
}
