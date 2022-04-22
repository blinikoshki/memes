package com.google.firebase.auth.ktx;

import com.google.firebase.components.Component;
import com.google.firebase.components.ComponentRegistrar;
import com.google.firebase.platforminfo.LibraryVersionComponent;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0012\u0010\u0003\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00050\u0004H\u0016¨\u0006\u0006"}, mo26107d2 = {"Lcom/google/firebase/auth/ktx/FirebaseAuthKtxRegistrar;", "Lcom/google/firebase/components/ComponentRegistrar;", "()V", "getComponents", "", "Lcom/google/firebase/components/Component;", "java.com.google.android.libraries.firebase.firebase_auth_ktx_granule"}, mo26108k = 1, mo26109mv = {1, 4, 1})
/* compiled from: com.google.firebase:firebase-auth-ktx@@20.0.2 */
public final class FirebaseAuthKtxRegistrar implements ComponentRegistrar {
    public List<Component<?>> getComponents() {
        return CollectionsKt.listOf(LibraryVersionComponent.create(AuthKt.LIBRARY_NAME, BuildConfig.VERSION_NAME));
    }
}
