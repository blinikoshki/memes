package com.memes.plus.data.storage;

import com.memes.network.memes.api.model.auth.AuthResult;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n¢\u0006\u0002\b\u0003"}, mo26107d2 = {"<anonymous>", "", "Lcom/memes/plus/data/storage/StorageRepository;", "invoke"}, mo26108k = 3, mo26109mv = {1, 4, 2})
/* compiled from: InstantStorage.kt */
final class InstantStorage$saveAuthResult$1 extends Lambda implements Function1<StorageRepository, Unit> {
    final /* synthetic */ AuthResult $authResult;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    InstantStorage$saveAuthResult$1(AuthResult authResult) {
        super(1);
        this.$authResult = authResult;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((StorageRepository) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(StorageRepository storageRepository) {
        Intrinsics.checkNotNullParameter(storageRepository, "$receiver");
        storageRepository.userId(this.$authResult.getUserId());
        storageRepository.realUserId(this.$authResult.getId());
        storageRepository.userName(this.$authResult.getUsername());
        storageRepository.token(this.$authResult.getLoginToken());
        storageRepository.profilePic(this.$authResult.getProfileImage());
        storageRepository.profilePicThumbnail(this.$authResult.getProfileImageThumb());
        storageRepository.coverPic(this.$authResult.getCoverImage());
        storageRepository.coverPicThumbnail(this.$authResult.getCoverImageThumb());
        storageRepository.name(this.$authResult.getFullName());
        storageRepository.email(this.$authResult.getEmail());
        storageRepository.age(this.$authResult.getAge());
        storageRepository.location(this.$authResult.getLocation());
        storageRepository.bio(this.$authResult.getUserBio());
    }
}
