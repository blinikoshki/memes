package com.memes.plus.p040ui.posts.post_basics.post_options;

import com.memes.commons.choices.Choice;
import com.memes.network.memes.MemesSession;
import com.memes.plus.p040ui.posts.Post;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u000f\b\u0001\u0018\u0000 \u001a2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u001aB\u0019\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\b\u0010\u000b\u001a\u00020\fH\u0016R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012j\u0002\b\u0013j\u0002\b\u0014j\u0002\b\u0015j\u0002\b\u0016j\u0002\b\u0017j\u0002\b\u0018j\u0002\b\u0019¨\u0006\u001b"}, mo26107d2 = {"Lcom/memes/plus/ui/posts/post_basics/post_options/PostOption;", "", "title", "", "highlightType", "Lcom/memes/commons/choices/Choice$HighlightType;", "(Ljava/lang/String;ILjava/lang/String;Lcom/memes/commons/choices/Choice$HighlightType;)V", "getHighlightType", "()Lcom/memes/commons/choices/Choice$HighlightType;", "getTitle", "()Ljava/lang/String;", "toChoice", "Lcom/memes/commons/choices/Choice;", "SHARE_TO_FACEBOOK", "SHARE_PROFILE", "SAVE_TO_GALLERY", "REPOST", "COPY_LINK", "REPORT_SPAM", "REPORT_INAPPROPRIATE", "REPORT", "EDIT", "DELETE", "FOLLOW", "UNFOLLOW", "SHARE", "Companion", "app_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
/* renamed from: com.memes.plus.ui.posts.post_basics.post_options.PostOption */
/* compiled from: PostOption.kt */
public enum PostOption {
    SHARE_TO_FACEBOOK("Share To Facebook", (int) null, 2, (Choice.HighlightType) null),
    SHARE_PROFILE("Share This Profile", (int) null, 2, (Choice.HighlightType) null),
    SAVE_TO_GALLERY("Save To Gallery", (int) null, 2, (Choice.HighlightType) null),
    REPOST("Repost", (int) null, 2, (Choice.HighlightType) null),
    COPY_LINK("Copy Link", (int) null, 2, (Choice.HighlightType) null),
    REPORT_SPAM("It's Spam", (int) null, 2, (Choice.HighlightType) null),
    REPORT_INAPPROPRIATE("It's Inappropriate", (int) null, 2, (Choice.HighlightType) null),
    EDIT("Edit", (int) null, 2, (Choice.HighlightType) null),
    DELETE("Delete", Choice.HighlightType.DANGER),
    FOLLOW("Follow", (int) null, 2, (Choice.HighlightType) null),
    UNFOLLOW("Unfollow", Choice.HighlightType.DANGER),
    SHARE("Share", (int) null, 2, (Choice.HighlightType) null);
    
    public static final Companion Companion = null;
    private final Choice.HighlightType highlightType;
    private final String title;

    private PostOption(String str, Choice.HighlightType highlightType2) {
        this.title = str;
        this.highlightType = highlightType2;
    }

    public final String getTitle() {
        return this.title;
    }

    public final Choice.HighlightType getHighlightType() {
        return this.highlightType;
    }

    static {
        Companion = new Companion((DefaultConstructorMarker) null);
    }

    @Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bÆ\u0001\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016¨\u0006\u0004"}, mo26107d2 = {"Lcom/memes/plus/ui/posts/post_basics/post_options/PostOption$REPORT;", "Lcom/memes/plus/ui/posts/post_basics/post_options/PostOption;", "toChoice", "Lcom/memes/commons/choices/Choice;", "app_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
    /* renamed from: com.memes.plus.ui.posts.post_basics.post_options.PostOption$REPORT */
    /* compiled from: PostOption.kt */
    static final class REPORT extends PostOption {
        REPORT(String str, int i) {
            super(str, i, "Report", Choice.HighlightType.DANGER, (DefaultConstructorMarker) null);
        }

        public Choice toChoice() {
            Choice choice = PostOption.super.toChoice();
            choice.addChoice(PostOption.REPORT_SPAM.toChoice());
            choice.addChoice(PostOption.REPORT_INAPPROPRIATE.toChoice());
            return choice;
        }
    }

    public Choice toChoice() {
        return Choice.Companion.create$default(Choice.Companion, name(), this.title, false, this.highlightType, 4, (Object) null);
    }

    @Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010\u0006\u001a\u00020\u0007¨\u0006\b"}, mo26107d2 = {"Lcom/memes/plus/ui/posts/post_basics/post_options/PostOption$Companion;", "", "()V", "createForPost", "", "Lcom/memes/commons/choices/Choice;", "post", "Lcom/memes/plus/ui/posts/Post;", "app_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
    /* renamed from: com.memes.plus.ui.posts.post_basics.post_options.PostOption$Companion */
    /* compiled from: PostOption.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final List<Choice> createForPost(Post post) {
            List list;
            Intrinsics.checkNotNullParameter(post, "post");
            if (Intrinsics.areEqual((Object) post.getUserId(), (Object) MemesSession.INSTANCE.getUserId())) {
                list = CollectionsKt.mutableListOf(PostOption.SHARE_TO_FACEBOOK, PostOption.SHARE_PROFILE, PostOption.SAVE_TO_GALLERY, PostOption.COPY_LINK, PostOption.EDIT, PostOption.DELETE);
            } else {
                List mutableListOf = CollectionsKt.mutableListOf(PostOption.SHARE_TO_FACEBOOK, PostOption.SHARE_PROFILE, PostOption.SAVE_TO_GALLERY, PostOption.REPOST, PostOption.COPY_LINK, PostOption.REPORT);
                if (post.getIamfollowing()) {
                    mutableListOf.add(PostOption.UNFOLLOW);
                } else {
                    mutableListOf.add(PostOption.FOLLOW);
                }
                list = mutableListOf;
            }
            Iterable<PostOption> iterable = list;
            Collection arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(iterable, 10));
            for (PostOption choice : iterable) {
                arrayList.add(choice.toChoice());
            }
            return (List) arrayList;
        }
    }
}
