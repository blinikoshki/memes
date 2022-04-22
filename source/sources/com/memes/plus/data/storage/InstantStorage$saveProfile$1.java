package com.memes.plus.data.storage;

import com.memes.plus.p040ui.profile.self_profile.SelfProfile;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n¢\u0006\u0002\b\u0003"}, mo26107d2 = {"<anonymous>", "", "Lcom/memes/plus/data/storage/StorageRepository;", "invoke"}, mo26108k = 3, mo26109mv = {1, 4, 2})
/* compiled from: InstantStorage.kt */
final class InstantStorage$saveProfile$1 extends Lambda implements Function1<StorageRepository, Unit> {
    final /* synthetic */ SelfProfile $profile;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    InstantStorage$saveProfile$1(SelfProfile selfProfile) {
        super(1);
        this.$profile = selfProfile;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((StorageRepository) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(StorageRepository storageRepository) {
        Intrinsics.checkNotNullParameter(storageRepository, "$receiver");
        storageRepository.userId(this.$profile.getUserId());
        storageRepository.realUserId(this.$profile.getId());
        storageRepository.userName(this.$profile.getUsername());
        storageRepository.profilePic(this.$profile.getProfileImage());
        storageRepository.profilePicThumbnail(this.$profile.getProfileImageThumb());
        storageRepository.coverPic(this.$profile.getCoverImage());
        storageRepository.coverPicThumbnail(this.$profile.getCoverImageThumb());
        storageRepository.name(this.$profile.getFullName());
        storageRepository.email(this.$profile.getEmail());
        storageRepository.age(this.$profile.getAge());
        storageRepository.location(this.$profile.getLocation());
        storageRepository.bio(this.$profile.getUserBio());
    }
}
