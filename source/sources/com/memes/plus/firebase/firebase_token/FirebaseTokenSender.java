package com.memes.plus.firebase.firebase_token;

import com.memes.network.memes.MemesSession;
import com.memes.plus.data.storage.StorageRepository;
import com.memes.plus.util.RepositoryInjection;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import p015io.reactivex.android.schedulers.AndroidSchedulers;
import timber.log.Timber;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006J\u000e\u0010\u0007\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\t¨\u0006\n"}, mo26107d2 = {"Lcom/memes/plus/firebase/firebase_token/FirebaseTokenSender;", "", "()V", "send", "", "token", "", "sendFrom", "storageRepository", "Lcom/memes/plus/data/storage/StorageRepository;", "app_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
/* compiled from: FirebaseTokenSender.kt */
public final class FirebaseTokenSender {
    public static final FirebaseTokenSender INSTANCE = new FirebaseTokenSender();

    private FirebaseTokenSender() {
    }

    public final void sendFrom(StorageRepository storageRepository) {
        Intrinsics.checkNotNullParameter(storageRepository, "storageRepository");
        storageRepository.refreshSession();
        send(storageRepository.firebaseToken());
    }

    public final void send(String str) {
        CharSequence charSequence = str;
        if (charSequence == null || StringsKt.isBlank(charSequence)) {
            Timber.m303e("Unable to send null token.", new Object[0]);
        } else if (!MemesSession.INSTANCE.isEmpty()) {
            FirebaseTokenRequest firebaseTokenRequest = new FirebaseTokenRequest();
            firebaseTokenRequest.setToken(str);
            RepositoryInjection.INSTANCE.memesRepository().updateFirebaseToken(firebaseTokenRequest).observeOn(AndroidSchedulers.mainThread()).subscribe(new FirebaseTokenSender$send$1());
        }
    }
}
