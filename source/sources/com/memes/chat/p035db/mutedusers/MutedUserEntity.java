package com.memes.chat.p035db.mutedusers;

import java.util.Date;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import p015io.getstream.chat.android.client.models.ContentUtils;
import p015io.getstream.chat.android.client.models.Mute;
import p015io.getstream.chat.android.client.models.User;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0001\u0018\u0000 \u00152\u00020\u0001:\u0001\u0015B5\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\b¢\u0006\u0002\u0010\nJ\u0006\u0010\u0013\u001a\u00020\u0014R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\fR\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\fR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\fR\u0011\u0010\t\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u000f¨\u0006\u0016"}, mo26107d2 = {"Lcom/memes/chat/db/mutedusers/MutedUserEntity;", "", "id", "", "name", "image", "mutedBy", "mutedAt", "Ljava/util/Date;", "updatedAt", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/Date;Ljava/util/Date;)V", "getId", "()Ljava/lang/String;", "getImage", "getMutedAt", "()Ljava/util/Date;", "getMutedBy", "getName", "getUpdatedAt", "toMute", "Lio/getstream/chat/android/client/models/Mute;", "Companion", "chat_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
/* renamed from: com.memes.chat.db.mutedusers.MutedUserEntity */
/* compiled from: MutedUserEntity.kt */
public final class MutedUserEntity {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);

    /* renamed from: id */
    private final String f936id;
    private final String image;
    private final Date mutedAt;
    private final String mutedBy;
    private final String name;
    private final Date updatedAt;

    public MutedUserEntity(String str, String str2, String str3, String str4, Date date, Date date2) {
        Intrinsics.checkNotNullParameter(str, "id");
        Intrinsics.checkNotNullParameter(str2, "name");
        Intrinsics.checkNotNullParameter(str3, "image");
        Intrinsics.checkNotNullParameter(str4, "mutedBy");
        Intrinsics.checkNotNullParameter(date, "mutedAt");
        Intrinsics.checkNotNullParameter(date2, "updatedAt");
        this.f936id = str;
        this.name = str2;
        this.image = str3;
        this.mutedBy = str4;
        this.mutedAt = date;
        this.updatedAt = date2;
    }

    public final String getId() {
        return this.f936id;
    }

    public final String getName() {
        return this.name;
    }

    public final String getImage() {
        return this.image;
    }

    public final String getMutedBy() {
        return this.mutedBy;
    }

    public final Date getMutedAt() {
        return this.mutedAt;
    }

    public final Date getUpdatedAt() {
        return this.updatedAt;
    }

    @Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006¨\u0006\u0007"}, mo26107d2 = {"Lcom/memes/chat/db/mutedusers/MutedUserEntity$Companion;", "", "()V", "from", "Lcom/memes/chat/db/mutedusers/MutedUserEntity;", "mute", "Lio/getstream/chat/android/client/models/Mute;", "chat_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
    /* renamed from: com.memes.chat.db.mutedusers.MutedUserEntity$Companion */
    /* compiled from: MutedUserEntity.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final MutedUserEntity from(Mute mute) {
            Intrinsics.checkNotNullParameter(mute, "mute");
            return new MutedUserEntity(mute.getTarget().getId(), ContentUtils.getName(mute.getTarget()), ContentUtils.getImage(mute.getTarget()), mute.getUser().getId(), mute.getCreatedAt(), mute.getUpdatedAt());
        }
    }

    public final Mute toMute() {
        User user = r1;
        User user2 = new User(this.mutedBy, (String) null, false, false, (List) null, false, (Date) null, (Date) null, (Date) null, 0, 0, 0, (List) null, (List) null, (List) null, (Map) null, 65534, (DefaultConstructorMarker) null);
        User user3 = new User(this.f936id, (String) null, false, false, (List) null, false, (Date) null, (Date) null, (Date) null, 0, 0, 0, (List) null, (List) null, (List) null, (Map) null, 65534, (DefaultConstructorMarker) null);
        user3.getExtraData().put("name", this.name);
        user3.getExtraData().put("image", this.image);
        Unit unit = Unit.INSTANCE;
        return new Mute(user, user3, this.mutedAt, this.updatedAt);
    }
}
