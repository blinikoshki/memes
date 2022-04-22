package com.memes.plus.data.storage;

import com.memes.network.memes.api.model.auth.AuthResult;
import com.memes.plus.p040ui.profile.self_profile.SelfProfile;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006J\u0018\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\b\u0010\b\u001a\u0004\u0018\u00010\tJ\u0018\u0010\n\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\b\u0010\u000b\u001a\u0004\u0018\u00010\f¨\u0006\r"}, mo26107d2 = {"Lcom/memes/plus/data/storage/InstantStorage;", "", "()V", "clearSession", "", "repository", "Lcom/memes/plus/data/storage/StorageRepository;", "saveAuthResult", "authResult", "Lcom/memes/network/memes/api/model/auth/AuthResult;", "saveProfile", "profile", "Lcom/memes/plus/ui/profile/self_profile/SelfProfile;", "app_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
/* compiled from: InstantStorage.kt */
public final class InstantStorage {
    public static final InstantStorage INSTANCE = new InstantStorage();

    private InstantStorage() {
    }

    public final void saveAuthResult(StorageRepository storageRepository, AuthResult authResult) {
        Intrinsics.checkNotNullParameter(storageRepository, "repository");
        if (authResult != null) {
            storageRepository.m2578float(new InstantStorage$saveAuthResult$1(authResult));
        }
    }

    public final void saveProfile(StorageRepository storageRepository, SelfProfile selfProfile) {
        Intrinsics.checkNotNullParameter(storageRepository, "repository");
        if (selfProfile != null) {
            storageRepository.m2578float(new InstantStorage$saveProfile$1(selfProfile));
        }
    }

    public final void clearSession(StorageRepository storageRepository) {
        Intrinsics.checkNotNullParameter(storageRepository, "repository");
        storageRepository.clearUser();
    }
}
