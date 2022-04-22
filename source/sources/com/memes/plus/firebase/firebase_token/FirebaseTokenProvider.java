package com.memes.plus.firebase.firebase_token;

import com.google.firebase.installations.FirebaseInstallations;
import com.memes.plus.data.storage.StorageRepository;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001:\u0001\rB\u0007\b\u0002¢\u0006\u0002\u0010\u0002J$\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\n2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\fR\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u000e"}, mo26107d2 = {"Lcom/memes/plus/firebase/firebase_token/FirebaseTokenProvider;", "", "()V", "NOT_ALLOWED", "", "fetch", "", "repository", "Lcom/memes/plus/data/storage/StorageRepository;", "forceRefresh", "", "callback", "Lcom/memes/plus/firebase/firebase_token/FirebaseTokenProvider$Callback;", "Callback", "app_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
/* compiled from: FirebaseTokenProvider.kt */
public final class FirebaseTokenProvider {
    public static final FirebaseTokenProvider INSTANCE = new FirebaseTokenProvider();
    public static final String NOT_ALLOWED = "NOT_ALLOW";

    @Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\bæ\u0001\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H&¨\u0006\u0006"}, mo26107d2 = {"Lcom/memes/plus/firebase/firebase_token/FirebaseTokenProvider$Callback;", "", "onResult", "", "token", "", "app_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
    /* compiled from: FirebaseTokenProvider.kt */
    public interface Callback {
        void onResult(String str);
    }

    private FirebaseTokenProvider() {
    }

    public static /* synthetic */ void fetch$default(FirebaseTokenProvider firebaseTokenProvider, StorageRepository storageRepository, boolean z, Callback callback, int i, Object obj) {
        if ((i & 2) != 0) {
            z = false;
        }
        if ((i & 4) != 0) {
            callback = null;
        }
        firebaseTokenProvider.fetch(storageRepository, z, callback);
    }

    public final void fetch(StorageRepository storageRepository, boolean z, Callback callback) {
        Intrinsics.checkNotNullParameter(storageRepository, "repository");
        if (!z) {
            String firebaseToken = storageRepository.firebaseToken();
            CharSequence charSequence = firebaseToken;
            if (!(charSequence == null || StringsKt.isBlank(charSequence)) && (!Intrinsics.areEqual((Object) firebaseToken, (Object) NOT_ALLOWED))) {
                if (callback != null) {
                    callback.onResult(firebaseToken);
                    return;
                }
                return;
            }
        }
        FirebaseInstallations.getInstance().getToken(z).addOnCompleteListener(new FirebaseTokenProvider$fetch$1(callback, storageRepository));
    }
}
