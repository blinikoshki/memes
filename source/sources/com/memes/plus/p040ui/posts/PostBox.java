package com.memes.plus.p040ui.posts;

import com.memes.plus.p040ui.apprating.AppRatingRequest;
import com.memes.plus.p040ui.suggestions.SuggestedProfileBox;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0004\u0003\u0004\u0005\u0006B\u0007\b\u0002¢\u0006\u0002\u0010\u0002\u0001\u0004\u0007\b\t\n¨\u0006\u000b"}, mo26107d2 = {"Lcom/memes/plus/ui/posts/PostBox;", "", "()V", "AppRatingItem", "InviteItem", "PostItem", "SuggestedUsersItem", "Lcom/memes/plus/ui/posts/PostBox$PostItem;", "Lcom/memes/plus/ui/posts/PostBox$SuggestedUsersItem;", "Lcom/memes/plus/ui/posts/PostBox$AppRatingItem;", "Lcom/memes/plus/ui/posts/PostBox$InviteItem;", "app_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
/* renamed from: com.memes.plus.ui.posts.PostBox */
/* compiled from: PostBox.kt */
public abstract class PostBox {
    private PostBox() {
    }

    public /* synthetic */ PostBox(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    @Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fHÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0011"}, mo26107d2 = {"Lcom/memes/plus/ui/posts/PostBox$PostItem;", "Lcom/memes/plus/ui/posts/PostBox;", "post", "Lcom/memes/plus/ui/posts/Post;", "(Lcom/memes/plus/ui/posts/Post;)V", "getPost", "()Lcom/memes/plus/ui/posts/Post;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "app_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
    /* renamed from: com.memes.plus.ui.posts.PostBox$PostItem */
    /* compiled from: PostBox.kt */
    public static final class PostItem extends PostBox {
        private final Post post;

        public static /* synthetic */ PostItem copy$default(PostItem postItem, Post post2, int i, Object obj) {
            if ((i & 1) != 0) {
                post2 = postItem.post;
            }
            return postItem.copy(post2);
        }

        public final Post component1() {
            return this.post;
        }

        public final PostItem copy(Post post2) {
            Intrinsics.checkNotNullParameter(post2, "post");
            return new PostItem(post2);
        }

        public boolean equals(Object obj) {
            if (this != obj) {
                return (obj instanceof PostItem) && Intrinsics.areEqual((Object) this.post, (Object) ((PostItem) obj).post);
            }
            return true;
        }

        public int hashCode() {
            Post post2 = this.post;
            if (post2 != null) {
                return post2.hashCode();
            }
            return 0;
        }

        public String toString() {
            return "PostItem(post=" + this.post + ")";
        }

        public final Post getPost() {
            return this.post;
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public PostItem(Post post2) {
            super((DefaultConstructorMarker) null);
            Intrinsics.checkNotNullParameter(post2, "post");
            this.post = post2;
        }
    }

    @Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fHÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0011"}, mo26107d2 = {"Lcom/memes/plus/ui/posts/PostBox$SuggestedUsersItem;", "Lcom/memes/plus/ui/posts/PostBox;", "profileBox", "Lcom/memes/plus/ui/suggestions/SuggestedProfileBox;", "(Lcom/memes/plus/ui/suggestions/SuggestedProfileBox;)V", "getProfileBox", "()Lcom/memes/plus/ui/suggestions/SuggestedProfileBox;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "app_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
    /* renamed from: com.memes.plus.ui.posts.PostBox$SuggestedUsersItem */
    /* compiled from: PostBox.kt */
    public static final class SuggestedUsersItem extends PostBox {
        private final SuggestedProfileBox profileBox;

        public static /* synthetic */ SuggestedUsersItem copy$default(SuggestedUsersItem suggestedUsersItem, SuggestedProfileBox suggestedProfileBox, int i, Object obj) {
            if ((i & 1) != 0) {
                suggestedProfileBox = suggestedUsersItem.profileBox;
            }
            return suggestedUsersItem.copy(suggestedProfileBox);
        }

        public final SuggestedProfileBox component1() {
            return this.profileBox;
        }

        public final SuggestedUsersItem copy(SuggestedProfileBox suggestedProfileBox) {
            Intrinsics.checkNotNullParameter(suggestedProfileBox, "profileBox");
            return new SuggestedUsersItem(suggestedProfileBox);
        }

        public boolean equals(Object obj) {
            if (this != obj) {
                return (obj instanceof SuggestedUsersItem) && Intrinsics.areEqual((Object) this.profileBox, (Object) ((SuggestedUsersItem) obj).profileBox);
            }
            return true;
        }

        public int hashCode() {
            SuggestedProfileBox suggestedProfileBox = this.profileBox;
            if (suggestedProfileBox != null) {
                return suggestedProfileBox.hashCode();
            }
            return 0;
        }

        public String toString() {
            return "SuggestedUsersItem(profileBox=" + this.profileBox + ")";
        }

        public final SuggestedProfileBox getProfileBox() {
            return this.profileBox;
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public SuggestedUsersItem(SuggestedProfileBox suggestedProfileBox) {
            super((DefaultConstructorMarker) null);
            Intrinsics.checkNotNullParameter(suggestedProfileBox, "profileBox");
            this.profileBox = suggestedProfileBox;
        }
    }

    @Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fHÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0011"}, mo26107d2 = {"Lcom/memes/plus/ui/posts/PostBox$AppRatingItem;", "Lcom/memes/plus/ui/posts/PostBox;", "appRatingRequest", "Lcom/memes/plus/ui/apprating/AppRatingRequest;", "(Lcom/memes/plus/ui/apprating/AppRatingRequest;)V", "getAppRatingRequest", "()Lcom/memes/plus/ui/apprating/AppRatingRequest;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "app_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
    /* renamed from: com.memes.plus.ui.posts.PostBox$AppRatingItem */
    /* compiled from: PostBox.kt */
    public static final class AppRatingItem extends PostBox {
        private final AppRatingRequest appRatingRequest;

        public static /* synthetic */ AppRatingItem copy$default(AppRatingItem appRatingItem, AppRatingRequest appRatingRequest2, int i, Object obj) {
            if ((i & 1) != 0) {
                appRatingRequest2 = appRatingItem.appRatingRequest;
            }
            return appRatingItem.copy(appRatingRequest2);
        }

        public final AppRatingRequest component1() {
            return this.appRatingRequest;
        }

        public final AppRatingItem copy(AppRatingRequest appRatingRequest2) {
            Intrinsics.checkNotNullParameter(appRatingRequest2, "appRatingRequest");
            return new AppRatingItem(appRatingRequest2);
        }

        public boolean equals(Object obj) {
            if (this != obj) {
                return (obj instanceof AppRatingItem) && Intrinsics.areEqual((Object) this.appRatingRequest, (Object) ((AppRatingItem) obj).appRatingRequest);
            }
            return true;
        }

        public int hashCode() {
            AppRatingRequest appRatingRequest2 = this.appRatingRequest;
            if (appRatingRequest2 != null) {
                return appRatingRequest2.hashCode();
            }
            return 0;
        }

        public String toString() {
            return "AppRatingItem(appRatingRequest=" + this.appRatingRequest + ")";
        }

        public final AppRatingRequest getAppRatingRequest() {
            return this.appRatingRequest;
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public AppRatingItem(AppRatingRequest appRatingRequest2) {
            super((DefaultConstructorMarker) null);
            Intrinsics.checkNotNullParameter(appRatingRequest2, "appRatingRequest");
            this.appRatingRequest = appRatingRequest2;
        }
    }

    @Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, mo26107d2 = {"Lcom/memes/plus/ui/posts/PostBox$InviteItem;", "Lcom/memes/plus/ui/posts/PostBox;", "()V", "app_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
    /* renamed from: com.memes.plus.ui.posts.PostBox$InviteItem */
    /* compiled from: PostBox.kt */
    public static final class InviteItem extends PostBox {
        public static final InviteItem INSTANCE = new InviteItem();

        private InviteItem() {
            super((DefaultConstructorMarker) null);
        }
    }
}
