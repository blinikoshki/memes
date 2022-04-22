package com.memes.plus.events;

import com.memes.plus.p040ui.post_comments.PostComment;
import com.memes.plus.p040ui.posts.Post;
import com.memes.plus.p040ui.posts.commentpreviewbox.PostPreviewComment;
import com.memes.plus.p040ui.profile.user_profile.UserProfile;
import com.memes.plus.p040ui.social_notifications.SocialNotification;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.greenrobot.eventbus.EventBus;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000h\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0002J\u000e\u0010\u0007\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\tJ\u0006\u0010\n\u001a\u00020\u0004J\u000e\u0010\u000b\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\rJ\u0012\u0010\u000b\u001a\u00020\u00042\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fH\u0002J\u000e\u0010\u0010\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\tJ\u0010\u0010\u0010\u001a\u00020\u00042\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fJ\u000e\u0010\u0011\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006J\u000e\u0010\u0012\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\tJ \u0010\u0012\u001a\u00020\u00042\b\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0016J\u000e\u0010\u0017\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0018J\u000e\u0010\u0019\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\tJ\u000e\u0010\u001a\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\tJ\u000e\u0010\u001b\u001a\u00020\u00042\u0006\u0010\u001c\u001a\u00020\u001dJ\u000e\u0010\u001e\u001a\u00020\u00042\u0006\u0010\u001f\u001a\u00020\u0014J\u000e\u0010 \u001a\u00020\u00042\u0006\u0010\u001c\u001a\u00020!J\u0010\u0010\"\u001a\u00020\u00042\b\u0010\f\u001a\u0004\u0018\u00010#J\u000e\u0010$\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\tJ\u0010\u0010$\u001a\u00020\u00042\b\u0010%\u001a\u0004\u0018\u00010&J\u000e\u0010$\u001a\u00020\u00042\u0006\u0010'\u001a\u00020(J\u0018\u0010$\u001a\u00020\u00042\b\u0010)\u001a\u0004\u0018\u00010\u000f2\u0006\u0010*\u001a\u00020\u0014¨\u0006+"}, mo26107d2 = {"Lcom/memes/plus/events/EventNotifier;", "", "()V", "notify", "", "event", "Lcom/memes/plus/events/NotifiableEvent;", "notifyFullPostLiked", "post", "Lcom/memes/plus/ui/posts/Post;", "notifyInviteClosed", "notifyPostComment", "comment", "Lcom/memes/plus/ui/post_comments/PostComment;", "postId", "", "notifyPostDeleted", "notifyPostEdited", "notifyPostLiked", "liked", "", "likesCount", "", "notifyPostNotificationsEnabled", "Lcom/memes/plus/events/PostNotificationsSubscriptionEvent;", "notifyPostReported", "notifyPostSaved", "notifyPostScroll", "state", "Lcom/memes/plus/events/ScrollState;", "notifyPostSoundSettings", "isMute", "notifyPostsPlayer", "Lcom/memes/plus/events/PlayerState;", "notifyPreviewComment", "Lcom/memes/plus/ui/posts/commentpreviewbox/PostPreviewComment;", "notifyUserFollowUpdate", "profile", "Lcom/memes/plus/ui/profile/user_profile/UserProfile;", "notification", "Lcom/memes/plus/ui/social_notifications/SocialNotification;", "userId", "followed", "app_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
/* compiled from: EventNotifier.kt */
public final class EventNotifier {
    public static final EventNotifier INSTANCE = new EventNotifier();

    private EventNotifier() {
    }

    private final void notify(NotifiableEvent notifiableEvent) {
        EventBus.getDefault().postSticky(notifiableEvent);
    }

    public final void notifyPostLiked(String str, boolean z, long j) {
        if (str != null) {
            notify(new PostLikedEvent(str, z, j));
        }
    }

    public final void notifyPostLiked(Post post) {
        Intrinsics.checkNotNullParameter(post, "post");
        notifyPostLiked(post.getPostId(), post.getLiked(), post.getTotalLikes());
    }

    public final void notifyFullPostLiked(Post post) {
        Intrinsics.checkNotNullParameter(post, "post");
        notify(new FullPostLikedEvent(post));
    }

    public final void notifyPostSaved(Post post) {
        Intrinsics.checkNotNullParameter(post, "post");
        notify(new PostSavedEvent(post));
    }

    public final void notifyPostEdited(NotifiableEvent notifiableEvent) {
        Intrinsics.checkNotNullParameter(notifiableEvent, "event");
        notify(notifiableEvent);
    }

    public final void notifyPostReported(Post post) {
        Intrinsics.checkNotNullParameter(post, "post");
        notify(new PostReportedEvent(post));
    }

    public final void notifyPostNotificationsEnabled(PostNotificationsSubscriptionEvent postNotificationsSubscriptionEvent) {
        Intrinsics.checkNotNullParameter(postNotificationsSubscriptionEvent, "event");
        notify(postNotificationsSubscriptionEvent);
    }

    public final void notifyPostsPlayer(PlayerState playerState) {
        Intrinsics.checkNotNullParameter(playerState, "state");
        notify(new PostPlayerEvent(playerState));
    }

    public final void notifyPostScroll(ScrollState scrollState) {
        Intrinsics.checkNotNullParameter(scrollState, "state");
        notify(new PostScrollEvent(scrollState));
    }

    public final void notifyUserFollowUpdate(String str, boolean z) {
        if (str != null) {
            notify(new UserFollowEvent(str, z, 0, 4, (DefaultConstructorMarker) null));
        }
    }

    public final void notifyUserFollowUpdate(Post post) {
        Intrinsics.checkNotNullParameter(post, "post");
        notifyUserFollowUpdate(post.getUserId(), post.getIamfollowing());
    }

    public final void notifyUserFollowUpdate(UserProfile userProfile) {
        String userId;
        if (userProfile != null && (userId = userProfile.getUserId()) != null) {
            notify(new UserFollowEvent(userId, userProfile.getFollowed(), userProfile.getFollower()));
        }
    }

    public final void notifyInviteClosed() {
        notify(new InviteClosedEvent(true));
    }

    public final void notifyPostSoundSettings(boolean z) {
        notify(new PostPlaybackSoundMuteEvent(z));
    }

    public final void notifyUserFollowUpdate(SocialNotification socialNotification) {
        Intrinsics.checkNotNullParameter(socialNotification, "notification");
        notifyUserFollowUpdate(socialNotification.getAuthorId(), socialNotification.getAuthorFollowed());
    }

    public final void notifyPostDeleted(String str) {
        if (str != null) {
            notify(new PostDeletedEvent(str, (String) null, 2, (DefaultConstructorMarker) null));
        }
    }

    public final void notifyPostDeleted(Post post) {
        Intrinsics.checkNotNullParameter(post, "post");
        notifyPostDeleted(post.getPostId());
    }

    private final void notifyPostComment(String str) {
        if (str != null) {
            notify(new PostCommentEvent(str));
        }
    }

    public final void notifyPreviewComment(PostPreviewComment postPreviewComment) {
        if (postPreviewComment != null) {
            notify(new PostPreviewCommentEvent(postPreviewComment));
        }
    }

    public final void notifyPostComment(PostComment postComment) {
        Intrinsics.checkNotNullParameter(postComment, "comment");
        notifyPostComment(postComment.getPostId());
    }
}
