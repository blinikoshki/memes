package com.memes.plus.data.storage;

import com.memes.network.memes.MemesSession;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010\t\n\u0002\b\u0015\b\u0007\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0001¢\u0006\u0002\u0010\u0003J\n\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016J\u0012\u0010\u0004\u001a\u00020\u00062\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016J\b\u0010\u0007\u001a\u00020\bH\u0016J\n\u0010\t\u001a\u0004\u0018\u00010\u0005H\u0016J\u0010\u0010\t\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\u0005H\u0016J\b\u0010\u000b\u001a\u00020\bH\u0016J\n\u0010\f\u001a\u0004\u0018\u00010\u0005H\u0016J\u0012\u0010\f\u001a\u00020\u00062\b\u0010\f\u001a\u0004\u0018\u00010\u0005H\u0016J\u0010\u0010\r\u001a\u00020\b2\u0006\u0010\u000e\u001a\u00020\u0005H\u0016J\u0018\u0010\r\u001a\u00020\u00062\u0006\u0010\u000e\u001a\u00020\u00052\u0006\u0010\u000f\u001a\u00020\bH\u0016J\u0018\u0010\u0010\u001a\u00020\b2\u0006\u0010\u000e\u001a\u00020\u00052\u0006\u0010\u0011\u001a\u00020\bH\u0016J\b\u0010\u0012\u001a\u00020\u0006H\u0016J\b\u0010\u0013\u001a\u00020\u0006H\u0016J\n\u0010\u0014\u001a\u0004\u0018\u00010\u0005H\u0016J\u0012\u0010\u0014\u001a\u00020\u00062\b\u0010\u0014\u001a\u0004\u0018\u00010\u0005H\u0016J\n\u0010\u0015\u001a\u0004\u0018\u00010\u0005H\u0016J\u0012\u0010\u0015\u001a\u00020\u00062\b\u0010\u0015\u001a\u0004\u0018\u00010\u0005H\u0016J\n\u0010\u0016\u001a\u0004\u0018\u00010\u0005H\u0016J\u0012\u0010\u0016\u001a\u00020\u00062\b\u0010\u0016\u001a\u0004\u0018\u00010\u0005H\u0016J\n\u0010\u0017\u001a\u0004\u0018\u00010\u0005H\u0016J\u0012\u0010\u0017\u001a\u00020\u00062\b\u0010\u0017\u001a\u0004\u0018\u00010\u0005H\u0016J\u001f\u0010\u0018\u001a\u00020\u00062\u0017\u0010\u0019\u001a\u0013\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00060\u001a¢\u0006\u0002\b\u001bJ\u0010\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u000e\u001a\u00020\u0005H\u0016J\u0018\u0010\u001c\u001a\u00020\u00062\u0006\u0010\u000e\u001a\u00020\u00052\u0006\u0010\u000f\u001a\u00020\u001dH\u0016J\u0006\u0010\u001e\u001a\u00020\bJ\b\u0010\u001f\u001a\u00020\bH\u0016J\b\u0010 \u001a\u00020\bH\u0016J\n\u0010!\u001a\u0004\u0018\u00010\u0005H\u0016J\u0012\u0010!\u001a\u00020\u00062\b\u0010\"\u001a\u0004\u0018\u00010\u0005H\u0016J\n\u0010#\u001a\u0004\u0018\u00010\u0005H\u0016J\u0012\u0010#\u001a\u00020\u00062\b\u0010#\u001a\u0004\u0018\u00010\u0005H\u0016J\n\u0010$\u001a\u0004\u0018\u00010\u0005H\u0016J\u0012\u0010$\u001a\u00020\u00062\b\u0010$\u001a\u0004\u0018\u00010\u0005H\u0016J\u0010\u0010%\u001a\u00020&2\u0006\u0010\u000e\u001a\u00020\u0005H\u0016J\u0018\u0010%\u001a\u00020\u00062\u0006\u0010\u000e\u001a\u00020\u00052\u0006\u0010\u000f\u001a\u00020&H\u0016J\u000f\u0010'\u001a\u0004\u0018\u00010\u001dH\u0016¢\u0006\u0002\u0010(J\u0017\u0010'\u001a\u00020\u00062\b\u0010)\u001a\u0004\u0018\u00010\u001dH\u0016¢\u0006\u0002\u0010*J\n\u0010+\u001a\u0004\u0018\u00010\u0005H\u0016J\u0012\u0010+\u001a\u00020\u00062\b\u0010+\u001a\u0004\u0018\u00010\u0005H\u0016J\n\u0010,\u001a\u0004\u0018\u00010\u0005H\u0016J\u0012\u0010,\u001a\u00020\u00062\b\u0010,\u001a\u0004\u0018\u00010\u0005H\u0016J\n\u0010-\u001a\u0004\u0018\u00010\u0005H\u0016J\u0012\u0010-\u001a\u00020\u00062\b\u0010-\u001a\u0004\u0018\u00010\u0005H\u0016J\n\u0010.\u001a\u0004\u0018\u00010\u0005H\u0016J\u0012\u0010.\u001a\u00020\u00062\b\u0010.\u001a\u0004\u0018\u00010\u0005H\u0016J\u0006\u0010/\u001a\u00020\u0006J\u0010\u00100\u001a\u00020\u00062\u0006\u00101\u001a\u00020\bH\u0016J\u0010\u00102\u001a\u00020\u00062\u0006\u00103\u001a\u00020\bH\u0016J\u0010\u00104\u001a\u00020\u00062\u0006\u00105\u001a\u00020\bH\u0016J\u0010\u00106\u001a\u00020\u00062\u0006\u00107\u001a\u00020\bH\u0016J\u0012\u00108\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u000e\u001a\u00020\u0005H\u0016J\u001a\u00108\u001a\u00020\u00062\u0006\u0010\u000e\u001a\u00020\u00052\b\u0010\u000f\u001a\u0004\u0018\u00010\u0005H\u0016J\n\u0010\"\u001a\u0004\u0018\u00010\u0005H\u0016J\u0012\u0010\"\u001a\u00020\u00062\b\u0010\"\u001a\u0004\u0018\u00010\u0005H\u0016J\n\u00109\u001a\u0004\u0018\u00010\u0005H\u0016J\u0012\u00109\u001a\u00020\u00062\b\u00109\u001a\u0004\u0018\u00010\u0005H\u0016J\n\u0010:\u001a\u0004\u0018\u00010\u0005H\u0016J\u0012\u0010:\u001a\u00020\u00062\b\u0010:\u001a\u0004\u0018\u00010\u0005H\u0016R\u000e\u0010\u0002\u001a\u00020\u0001X\u0004¢\u0006\u0002\n\u0000¨\u0006;"}, mo26107d2 = {"Lcom/memes/plus/data/storage/StorageRepository;", "Lcom/memes/plus/data/storage/StorageDataSource;", "storageDataSource", "(Lcom/memes/plus/data/storage/StorageDataSource;)V", "age", "", "", "appRatingConfirmed", "", "appUpdateConfig", "config", "autoSavePost", "bio", "booleanPref", "key", "value", "booleanPrefWithDefault", "default", "clear", "clearUser", "coverPic", "coverPicThumbnail", "email", "firebaseToken", "float", "block", "Lkotlin/Function1;", "Lkotlin/ExtensionFunctionType;", "intPref", "", "isAuthenticated", "isPlaybackSoundMuted", "isWelcomed", "jwtToken", "token", "location", "loginSource", "longPref", "", "messagingId", "()Ljava/lang/Integer;", "id", "(Ljava/lang/Integer;)V", "name", "profilePic", "profilePicThumbnail", "realUserId", "refreshSession", "setAppRatingConfirmed", "confirmed", "setAutoSavePost", "autoSave", "setPlaybackSoundMuted", "isMuted", "setWelcomed", "seen", "stringPref", "userId", "userName", "app_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
/* compiled from: StorageRepository.kt */
public final class StorageRepository implements StorageDataSource {
    private final StorageDataSource storageDataSource;

    public StorageRepository(StorageDataSource storageDataSource2) {
        Intrinsics.checkNotNullParameter(storageDataSource2, "storageDataSource");
        this.storageDataSource = storageDataSource2;
    }

    public final boolean isAuthenticated() {
        return (userId() == null || token() == null) ? false : true;
    }

    public final void refreshSession() {
        MemesSession.INSTANCE.setUserId(userId());
        MemesSession.INSTANCE.setUserName(userName());
        MemesSession.INSTANCE.setToken(token());
        MemesSession.INSTANCE.setFirebaseToken(firebaseToken());
        MemesSession.INSTANCE.setId(realUserId());
        MemesSession.INSTANCE.setJwtToken(jwtToken());
        MemesSession.INSTANCE.setMessagingId(messagingId());
    }

    /* renamed from: float  reason: not valid java name */
    public final void m2578float(Function1<? super StorageRepository, Unit> function1) {
        Intrinsics.checkNotNullParameter(function1, "block");
        function1.invoke(this);
    }

    public boolean isWelcomed() {
        return this.storageDataSource.isWelcomed();
    }

    public void setWelcomed(boolean z) {
        this.storageDataSource.setWelcomed(z);
    }

    public String appUpdateConfig() {
        return this.storageDataSource.appUpdateConfig();
    }

    public void appUpdateConfig(String str) {
        Intrinsics.checkNotNullParameter(str, "config");
        this.storageDataSource.appUpdateConfig(str);
    }

    public String userId() {
        return this.storageDataSource.userId();
    }

    public void userId(String str) {
        this.storageDataSource.userId(str);
        MemesSession.INSTANCE.setUserId(str);
    }

    public String realUserId() {
        return this.storageDataSource.realUserId();
    }

    public void realUserId(String str) {
        this.storageDataSource.realUserId(str);
        MemesSession.INSTANCE.setId(str);
        MemesSession.INSTANCE.setMessagingId(str != null ? StringsKt.toIntOrNull(str) : null);
    }

    public String userName() {
        return this.storageDataSource.userName();
    }

    public void userName(String str) {
        this.storageDataSource.userName(str);
        MemesSession.INSTANCE.setUserName(str);
    }

    public String token() {
        return this.storageDataSource.token();
    }

    public void token(String str) {
        this.storageDataSource.token(str);
        MemesSession.INSTANCE.setToken(str);
    }

    public String firebaseToken() {
        return this.storageDataSource.firebaseToken();
    }

    public void firebaseToken(String str) {
        this.storageDataSource.firebaseToken(str);
        MemesSession.INSTANCE.setFirebaseToken(str);
    }

    public String loginSource() {
        return this.storageDataSource.loginSource();
    }

    public void loginSource(String str) {
        this.storageDataSource.loginSource(str);
    }

    public String name() {
        return this.storageDataSource.name();
    }

    public void name(String str) {
        this.storageDataSource.name(str);
    }

    public String profilePic() {
        return this.storageDataSource.profilePic();
    }

    public void profilePic(String str) {
        this.storageDataSource.profilePic(str);
    }

    public String profilePicThumbnail() {
        return this.storageDataSource.profilePicThumbnail();
    }

    public void profilePicThumbnail(String str) {
        this.storageDataSource.profilePicThumbnail(str);
    }

    public String coverPic() {
        return this.storageDataSource.coverPic();
    }

    public void coverPic(String str) {
        this.storageDataSource.coverPic(str);
    }

    public String coverPicThumbnail() {
        return this.storageDataSource.coverPicThumbnail();
    }

    public void coverPicThumbnail(String str) {
        this.storageDataSource.coverPicThumbnail(str);
    }

    public String email() {
        return this.storageDataSource.email();
    }

    public void email(String str) {
        this.storageDataSource.email(str);
    }

    public String age() {
        return this.storageDataSource.age();
    }

    public void age(String str) {
        this.storageDataSource.age(str);
    }

    public String bio() {
        return this.storageDataSource.bio();
    }

    public void bio(String str) {
        this.storageDataSource.bio(str);
    }

    public String location() {
        return this.storageDataSource.location();
    }

    public void location(String str) {
        this.storageDataSource.location(str);
    }

    public boolean appRatingConfirmed() {
        return this.storageDataSource.appRatingConfirmed();
    }

    public void setAppRatingConfirmed(boolean z) {
        this.storageDataSource.setAppRatingConfirmed(z);
    }

    public String jwtToken() {
        return this.storageDataSource.jwtToken();
    }

    public void jwtToken(String str) {
        this.storageDataSource.jwtToken(str);
        MemesSession.INSTANCE.setJwtToken(str);
    }

    public Integer messagingId() {
        return this.storageDataSource.messagingId();
    }

    public void messagingId(Integer num) {
        this.storageDataSource.messagingId(num);
        MemesSession.INSTANCE.setMessagingId(num);
    }

    public boolean autoSavePost() {
        return this.storageDataSource.autoSavePost();
    }

    public void setAutoSavePost(boolean z) {
        this.storageDataSource.setAutoSavePost(z);
    }

    public boolean isPlaybackSoundMuted() {
        return this.storageDataSource.isPlaybackSoundMuted();
    }

    public void setPlaybackSoundMuted(boolean z) {
        this.storageDataSource.setPlaybackSoundMuted(z);
    }

    public void clear() {
        boolean isWelcomed = isWelcomed();
        String firebaseToken = firebaseToken();
        this.storageDataSource.clear();
        MemesSession.INSTANCE.clear();
        this.storageDataSource.setWelcomed(isWelcomed);
        this.storageDataSource.firebaseToken(firebaseToken);
        MemesSession.INSTANCE.setFirebaseToken(firebaseToken);
    }

    public void clearUser() {
        clear();
    }

    public String stringPref(String str) {
        Intrinsics.checkNotNullParameter(str, "key");
        return this.storageDataSource.stringPref(str);
    }

    public void stringPref(String str, String str2) {
        Intrinsics.checkNotNullParameter(str, "key");
        this.storageDataSource.stringPref(str, str2);
    }

    public boolean booleanPref(String str) {
        Intrinsics.checkNotNullParameter(str, "key");
        return this.storageDataSource.booleanPref(str);
    }

    public boolean booleanPrefWithDefault(String str, boolean z) {
        Intrinsics.checkNotNullParameter(str, "key");
        return this.storageDataSource.booleanPrefWithDefault(str, z);
    }

    public void booleanPref(String str, boolean z) {
        Intrinsics.checkNotNullParameter(str, "key");
        this.storageDataSource.booleanPref(str, z);
    }

    public int intPref(String str) {
        Intrinsics.checkNotNullParameter(str, "key");
        return this.storageDataSource.intPref(str);
    }

    public void intPref(String str, int i) {
        Intrinsics.checkNotNullParameter(str, "key");
        this.storageDataSource.intPref(str, i);
    }

    public long longPref(String str) {
        Intrinsics.checkNotNullParameter(str, "key");
        return this.storageDataSource.longPref(str);
    }

    public void longPref(String str, long j) {
        Intrinsics.checkNotNullParameter(str, "key");
        this.storageDataSource.longPref(str, j);
    }
}
