package com.memes.plus.p040ui.post_comments;

import android.os.Parcel;
import android.os.Parcelable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\b\u0018\u0000 \u001c2\u00020\u0001:\u0002\u001b\u001cB\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\f\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u001f\u0010\r\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005HÆ\u0001J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\u0013\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013HÖ\u0003J\t\u0010\u0014\u001a\u00020\u000fHÖ\u0001J\t\u0010\u0015\u001a\u00020\u0005HÖ\u0001J\u0019\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u000fHÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u001d"}, mo26107d2 = {"Lcom/memes/plus/ui/post_comments/PostCommentAction;", "Landroid/os/Parcelable;", "actionType", "Lcom/memes/plus/ui/post_comments/PostCommentAction$ActionType;", "commentId", "", "(Lcom/memes/plus/ui/post_comments/PostCommentAction$ActionType;Ljava/lang/String;)V", "getActionType", "()Lcom/memes/plus/ui/post_comments/PostCommentAction$ActionType;", "getCommentId", "()Ljava/lang/String;", "component1", "component2", "copy", "describeContents", "", "equals", "", "other", "", "hashCode", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "ActionType", "Companion", "app_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
/* renamed from: com.memes.plus.ui.post_comments.PostCommentAction */
/* compiled from: PostCommentAction.kt */
public final class PostCommentAction implements Parcelable {
    public static final Parcelable.Creator<PostCommentAction> CREATOR = new Creator();
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private final ActionType actionType;
    private final String commentId;

    @Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, mo26107d2 = {"Lcom/memes/plus/ui/post_comments/PostCommentAction$ActionType;", "", "(Ljava/lang/String;I)V", "ADD_COMMENT", "VIEW_COMMENT", "ADD_REPLY", "app_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
    /* renamed from: com.memes.plus.ui.post_comments.PostCommentAction$ActionType */
    /* compiled from: PostCommentAction.kt */
    public enum ActionType {
        ADD_COMMENT,
        VIEW_COMMENT,
        ADD_REPLY
    }

    @Metadata(mo26105bv = {1, 0, 3}, mo26108k = 3, mo26109mv = {1, 4, 2})
    /* renamed from: com.memes.plus.ui.post_comments.PostCommentAction$Creator */
    public static class Creator implements Parcelable.Creator<PostCommentAction> {
        public final PostCommentAction createFromParcel(Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "in");
            return new PostCommentAction((ActionType) Enum.valueOf(ActionType.class, parcel.readString()), parcel.readString());
        }

        public final PostCommentAction[] newArray(int i) {
            return new PostCommentAction[i];
        }
    }

    public static /* synthetic */ PostCommentAction copy$default(PostCommentAction postCommentAction, ActionType actionType2, String str, int i, Object obj) {
        if ((i & 1) != 0) {
            actionType2 = postCommentAction.actionType;
        }
        if ((i & 2) != 0) {
            str = postCommentAction.commentId;
        }
        return postCommentAction.copy(actionType2, str);
    }

    public final ActionType component1() {
        return this.actionType;
    }

    public final String component2() {
        return this.commentId;
    }

    public final PostCommentAction copy(ActionType actionType2, String str) {
        Intrinsics.checkNotNullParameter(actionType2, "actionType");
        return new PostCommentAction(actionType2, str);
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof PostCommentAction)) {
            return false;
        }
        PostCommentAction postCommentAction = (PostCommentAction) obj;
        return Intrinsics.areEqual((Object) this.actionType, (Object) postCommentAction.actionType) && Intrinsics.areEqual((Object) this.commentId, (Object) postCommentAction.commentId);
    }

    public int hashCode() {
        ActionType actionType2 = this.actionType;
        int i = 0;
        int hashCode = (actionType2 != null ? actionType2.hashCode() : 0) * 31;
        String str = this.commentId;
        if (str != null) {
            i = str.hashCode();
        }
        return hashCode + i;
    }

    public String toString() {
        return "PostCommentAction(actionType=" + this.actionType + ", commentId=" + this.commentId + ")";
    }

    public void writeToParcel(Parcel parcel, int i) {
        Intrinsics.checkNotNullParameter(parcel, "parcel");
        parcel.writeString(this.actionType.name());
        parcel.writeString(this.commentId);
    }

    public PostCommentAction(ActionType actionType2, String str) {
        Intrinsics.checkNotNullParameter(actionType2, "actionType");
        this.actionType = actionType2;
        this.commentId = str;
    }

    public final ActionType getActionType() {
        return this.actionType;
    }

    public final String getCommentId() {
        return this.commentId;
    }

    @Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0006\u0010\u0003\u001a\u00020\u0004J\u0012\u0010\u0005\u001a\u00020\u00042\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007J\u0012\u0010\b\u001a\u00020\u00042\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007¨\u0006\t"}, mo26107d2 = {"Lcom/memes/plus/ui/post_comments/PostCommentAction$Companion;", "", "()V", "ofAddComment", "Lcom/memes/plus/ui/post_comments/PostCommentAction;", "ofAddReply", "commentId", "", "ofViewComment", "app_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
    /* renamed from: com.memes.plus.ui.post_comments.PostCommentAction$Companion */
    /* compiled from: PostCommentAction.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public static /* synthetic */ PostCommentAction ofViewComment$default(Companion companion, String str, int i, Object obj) {
            if ((i & 1) != 0) {
                str = null;
            }
            return companion.ofViewComment(str);
        }

        public final PostCommentAction ofViewComment(String str) {
            return new PostCommentAction(ActionType.VIEW_COMMENT, str);
        }

        public static /* synthetic */ PostCommentAction ofAddReply$default(Companion companion, String str, int i, Object obj) {
            if ((i & 1) != 0) {
                str = null;
            }
            return companion.ofAddReply(str);
        }

        public final PostCommentAction ofAddReply(String str) {
            return new PostCommentAction(ActionType.ADD_REPLY, str);
        }

        public final PostCommentAction ofAddComment() {
            return new PostCommentAction(ActionType.ADD_COMMENT, (String) null);
        }
    }
}
