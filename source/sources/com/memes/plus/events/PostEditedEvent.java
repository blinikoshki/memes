package com.memes.plus.events;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u000b\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B!\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\u000b\u0010\f\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\r\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010\u000e\u001a\u00020\u0006HÆ\u0003J+\u0010\u000f\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0006HÆ\u0001J\u0013\u0010\u0010\u001a\u00020\u00062\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012HÖ\u0003J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001J\t\u0010\u0015\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\bR\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\n¨\u0006\u0016"}, mo26107d2 = {"Lcom/memes/plus/events/PostEditedEvent;", "Lcom/memes/plus/events/BaseNotifiableEvent;", "postId", "", "postText", "isTagged", "", "(Ljava/lang/String;Ljava/lang/String;Z)V", "()Z", "getPostId", "()Ljava/lang/String;", "getPostText", "component1", "component2", "component3", "copy", "equals", "other", "", "hashCode", "", "toString", "app_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
/* compiled from: PostEditedEvent.kt */
public final class PostEditedEvent extends BaseNotifiableEvent {
    private final boolean isTagged;
    private final String postId;
    private final String postText;

    public static /* synthetic */ PostEditedEvent copy$default(PostEditedEvent postEditedEvent, String str, String str2, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            str = postEditedEvent.postId;
        }
        if ((i & 2) != 0) {
            str2 = postEditedEvent.postText;
        }
        if ((i & 4) != 0) {
            z = postEditedEvent.isTagged;
        }
        return postEditedEvent.copy(str, str2, z);
    }

    public final String component1() {
        return this.postId;
    }

    public final String component2() {
        return this.postText;
    }

    public final boolean component3() {
        return this.isTagged;
    }

    public final PostEditedEvent copy(String str, String str2, boolean z) {
        return new PostEditedEvent(str, str2, z);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof PostEditedEvent)) {
            return false;
        }
        PostEditedEvent postEditedEvent = (PostEditedEvent) obj;
        return Intrinsics.areEqual((Object) this.postId, (Object) postEditedEvent.postId) && Intrinsics.areEqual((Object) this.postText, (Object) postEditedEvent.postText) && this.isTagged == postEditedEvent.isTagged;
    }

    public int hashCode() {
        String str = this.postId;
        int i = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.postText;
        if (str2 != null) {
            i = str2.hashCode();
        }
        int i2 = (hashCode + i) * 31;
        boolean z = this.isTagged;
        if (z) {
            z = true;
        }
        return i2 + (z ? 1 : 0);
    }

    public String toString() {
        return "PostEditedEvent(postId=" + this.postId + ", postText=" + this.postText + ", isTagged=" + this.isTagged + ")";
    }

    public final String getPostId() {
        return this.postId;
    }

    public final String getPostText() {
        return this.postText;
    }

    public final boolean isTagged() {
        return this.isTagged;
    }

    public PostEditedEvent(String str, String str2, boolean z) {
        this.postId = str;
        this.postText = str2;
        this.isTagged = z;
    }
}
