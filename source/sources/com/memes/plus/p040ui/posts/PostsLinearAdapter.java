package com.memes.plus.p040ui.posts;

import android.content.Context;
import android.net.Uri;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.exoplayer2.ExoPlaybackException;
import com.google.android.exoplayer2.p024ui.PlayerView;
import com.google.android.gms.common.Scopes;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.memes.commons.contentlayout.ContentLayout;
import com.memes.commons.recycleradapter.AdapterUpdate;
import com.memes.commons.recycleradapter.AdapterViewHolderPayload;
import com.memes.commons.recycleradapter.BaseRecyclerAdapter;
import com.memes.commons.recycleradapter.BaseViewHolder;
import com.memes.commons.util.ExtensionsKt;
import com.memes.commons.util.PrettyCounter;
import com.memes.network.memes.MemesSession;
import com.memes.plus.C4199R;
import com.memes.plus.custom.UserAvatarView;
import com.memes.plus.custom.player.ExoPlayerHelper;
import com.memes.plus.custom.player.PlayerEventListenerAdapter;
import com.memes.plus.custom.rv_item_visibility_awarance.VisibilityAware;
import com.memes.plus.databinding.AppRatingRequestItemBinding;
import com.memes.plus.databinding.PostCommentPreviewBoxItemBinding;
import com.memes.plus.databinding.PostInviteViewBoxBinding;
import com.memes.plus.databinding.PostItemBinding;
import com.memes.plus.databinding.PostSuggestedProfilesItemBinding;
import com.memes.plus.databinding.SnippetPostMediaProgressBarBinding;
import com.memes.plus.events.PostCommentDeleteEvent;
import com.memes.plus.events.PostCommentEvent;
import com.memes.plus.events.PostDeletedEvent;
import com.memes.plus.events.PostEditedEvent;
import com.memes.plus.events.PostNotificationsSubscriptionEvent;
import com.memes.plus.events.PostPreviewCommentEvent;
import com.memes.plus.events.UserFollowEvent;
import com.memes.plus.p040ui.apprating.AppRatingItemTapListener;
import com.memes.plus.p040ui.apprating.AppRatingRequest;
import com.memes.plus.p040ui.posts.PostAction;
import com.memes.plus.p040ui.posts.PostBox;
import com.memes.plus.p040ui.posts.commentpreviewbox.PostCommentPreviewItem;
import com.memes.plus.p040ui.posts.commentpreviewbox.PostPreviewComment;
import com.memes.plus.p040ui.posts.invite.InviteItemTapListener;
import com.memes.plus.p040ui.posts.post_basics.follow_user.FollowUserResult;
import com.memes.plus.p040ui.posts.post_basics.post_delete.PostDeleteResult;
import com.memes.plus.p040ui.posts.suggestions.PostSuggestedProfilesAdapter;
import com.memes.plus.p040ui.posts.suggestions.SuggestedProfilesOnItemTouchListener;
import com.memes.plus.p040ui.suggestions.SuggestedProfile;
import com.memes.plus.p040ui.suggestions.SuggestedProfileBox;
import com.memes.plus.util.picasso.PicassoExtKt;
import com.memes.plus.util.zoom.ImageZoomUtility;
import com.squareup.picasso.Picasso;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000¸\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0015\u0018\u0000 S2\u0014\u0012\u0004\u0012\u00020\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00020\u00030\u0001:\bRSTUVWXYB-\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b¢\u0006\u0002\u0010\fJ\u0014\u0010$\u001a\u00020%2\f\u0010&\u001a\b\u0012\u0004\u0012\u00020(0'J\u000e\u0010)\u001a\u00020%2\u0006\u0010*\u001a\u00020+J\u000e\u0010)\u001a\u00020%2\u0006\u0010*\u001a\u00020,J\u000e\u0010)\u001a\u00020%2\u0006\u0010*\u001a\u00020-J\u000e\u0010)\u001a\u00020%2\u0006\u0010*\u001a\u00020.J\u000e\u0010)\u001a\u00020%2\u0006\u0010/\u001a\u000200J\u000e\u0010)\u001a\u00020%2\u0006\u0010*\u001a\u000201J\u000e\u0010)\u001a\u00020%2\u0006\u0010*\u001a\u000202J\u000e\u0010)\u001a\u00020%2\u0006\u00103\u001a\u000204J\u000e\u0010)\u001a\u00020%2\u0006\u0010/\u001a\u000205J\u000e\u0010)\u001a\u00020%2\u0006\u0010/\u001a\u000206J\u000e\u0010)\u001a\u00020%2\u0006\u0010\u000f\u001a\u00020\u0010J&\u00107\u001a\b\u0012\u0004\u0012\u00020\u00020\u00032\u0006\u00108\u001a\u0002092\u0006\u0010:\u001a\u00020;2\u0006\u0010<\u001a\u00020\u0012H\u0016JA\u0010=\u001a\u00020%26\u0010>\u001a2\u0012\u0013\u0012\u00110\u0012¢\u0006\f\b@\u0012\b\bA\u0012\u0004\b\b(B\u0012\u0013\u0012\u00110(¢\u0006\f\b@\u0012\b\bA\u0012\u0004\b\b(C\u0012\u0004\u0012\u00020\u00100?H\bJA\u0010D\u001a\u00020%26\u0010>\u001a2\u0012\u0013\u0012\u00110\u0012¢\u0006\f\b@\u0012\b\bA\u0012\u0004\b\b(B\u0012\u0013\u0012\u00110E¢\u0006\f\b@\u0012\b\bA\u0012\u0004\b\b(F\u0012\u0004\u0012\u00020\u00100?H\bJ\u0010\u0010G\u001a\u00020\u00122\u0006\u0010H\u001a\u00020\u0012H\u0016J\u0016\u0010I\u001a\u00020%2\f\u0010J\u001a\b\u0012\u0004\u0012\u00020\u00020\u0003H\u0016J\u0006\u0010K\u001a\u00020%J\u0006\u0010L\u001a\u00020%J\u0006\u0010M\u001a\u00020%J\u0006\u0010N\u001a\u00020%J\u000e\u0010O\u001a\u00020%2\u0006\u0010P\u001a\u00020(J\u000e\u0010Q\u001a\u00020%2\u0006\u0010P\u001a\u00020(R\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012XD¢\u0006\u0002\n\u0000R\u0012\u0010\u0013\u001a\u00060\u0014R\u00020\u0000X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0004¢\u0006\u0002\n\u0000R\u001b\u0010\u0015\u001a\u00020\u00168BX\u0002¢\u0006\f\n\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u0017\u0010\u0018R\u001b\u0010\u001b\u001a\u00020\u00128BX\u0002¢\u0006\f\n\u0004\b\u001e\u0010\u001a\u001a\u0004\b\u001c\u0010\u001dR\u001b\u0010\u001f\u001a\u00020 8BX\u0002¢\u0006\f\n\u0004\b#\u0010\u001a\u001a\u0004\b!\u0010\"¨\u0006Z"}, mo26107d2 = {"Lcom/memes/plus/ui/posts/PostsLinearAdapter;", "Lcom/memes/commons/recycleradapter/BaseRecyclerAdapter;", "Lcom/memes/plus/ui/posts/PostBox;", "Lcom/memes/commons/recycleradapter/BaseViewHolder;", "context", "Landroid/content/Context;", "postActionListener", "Lcom/memes/plus/ui/posts/PostAction$Listener;", "inviteItemTapListener", "Lcom/memes/plus/ui/posts/invite/InviteItemTapListener;", "appRatingItemTapListener", "Lcom/memes/plus/ui/apprating/AppRatingItemTapListener;", "(Landroid/content/Context;Lcom/memes/plus/ui/posts/PostAction$Listener;Lcom/memes/plus/ui/posts/invite/InviteItemTapListener;Lcom/memes/plus/ui/apprating/AppRatingItemTapListener;)V", "exoPlayerHelper", "Lcom/memes/plus/custom/player/ExoPlayerHelper;", "isMuted", "", "mediaProgressLayoutBackgroundColor", "", "playerStateCallback", "Lcom/memes/plus/ui/posts/PostsLinearAdapter$PlayerStateCallback;", "postCornerRadius", "", "getPostCornerRadius", "()F", "postCornerRadius$delegate", "Lkotlin/Lazy;", "profileImageSize", "getProfileImageSize", "()I", "profileImageSize$delegate", "suggestedProfilesOnItemTouchListener", "Lcom/memes/plus/ui/posts/suggestions/SuggestedProfilesOnItemTouchListener;", "getSuggestedProfilesOnItemTouchListener", "()Lcom/memes/plus/ui/posts/suggestions/SuggestedProfilesOnItemTouchListener;", "suggestedProfilesOnItemTouchListener$delegate", "applyPostsAdapterUpdate", "", "adapterUpdate", "Lcom/memes/commons/recycleradapter/AdapterUpdate;", "Lcom/memes/plus/ui/posts/Post;", "consume", "event", "Lcom/memes/plus/events/PostCommentDeleteEvent;", "Lcom/memes/plus/events/PostCommentEvent;", "Lcom/memes/plus/events/PostDeletedEvent;", "Lcom/memes/plus/events/PostEditedEvent;", "result", "Lcom/memes/plus/events/PostNotificationsSubscriptionEvent;", "Lcom/memes/plus/events/PostPreviewCommentEvent;", "Lcom/memes/plus/events/UserFollowEvent;", "postPreviewComment", "Lcom/memes/plus/ui/posts/commentpreviewbox/PostPreviewComment;", "Lcom/memes/plus/ui/posts/post_basics/follow_user/FollowUserResult;", "Lcom/memes/plus/ui/posts/post_basics/post_delete/PostDeleteResult;", "createItemViewHolder", "inflater", "Landroid/view/LayoutInflater;", "parent", "Landroid/view/ViewGroup;", "viewType", "executeForAllPosts", "block", "Lkotlin/Function2;", "Lkotlin/ParameterName;", "name", "index", "post", "executeForAllSuggestions", "Lcom/memes/plus/ui/suggestions/SuggestedProfileBox;", "item", "getItemViewType", "position", "onViewRecycled", "holder", "pausePlayer", "releasePlayer", "removeInviteBoxes", "resumePlayer", "updateLikedFlag", "updatedPost", "updateSavedStatus", "AppRatingItemHolder", "Companion", "PlayerStateCallback", "PostImageViewHolder", "PostInviteViewHolder", "PostSuggestionViewHolder", "PostVideoViewHolder", "PostViewHolder", "app_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
/* renamed from: com.memes.plus.ui.posts.PostsLinearAdapter */
/* compiled from: PostsLinearAdapter.kt */
public final class PostsLinearAdapter extends BaseRecyclerAdapter<PostBox, BaseViewHolder<PostBox>> {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    public static final String PAYLOAD_COMMENT_UPDATE = "payload_comment_update";
    public static final String PAYLOAD_FOLLOW_CHANGE = "payload_follow_change";
    public static final String PAYLOAD_LIKE_CHANGE = "payload_like_change";
    public static final String PAYLOAD_PLAYBACK_SOUND_MUTED = "payload_refresh_sound_Settings";
    public static final String PAYLOAD_PREVIEW_COMMENT = "payload_update_preview_comment";
    public static final String PAYLOAD_SAVE_CHANGE = "payload_save_change";
    public static final String PAYLOAD_SUGGESTED_PROFILE_FOLLOW_CHANGE = "payload_suggested_profile_follow_change";
    private static final int TYPE_APP_RATING = 1235;
    private static final int TYPE_INVITE = 1234;
    private static final int TYPE_POST_IMAGE = 1231;
    private static final int TYPE_POST_VIDEO = 1232;
    private static final int TYPE_SUGGESTED_PROFILES = 1233;
    /* access modifiers changed from: private */
    public final AppRatingItemTapListener appRatingItemTapListener;
    /* access modifiers changed from: private */
    public final Context context;
    /* access modifiers changed from: private */
    public final ExoPlayerHelper exoPlayerHelper;
    /* access modifiers changed from: private */
    public final InviteItemTapListener inviteItemTapListener;
    /* access modifiers changed from: private */
    public boolean isMuted;
    /* access modifiers changed from: private */
    public final int mediaProgressLayoutBackgroundColor;
    /* access modifiers changed from: private */
    public final PlayerStateCallback playerStateCallback;
    /* access modifiers changed from: private */
    public final PostAction.Listener postActionListener;
    private final Lazy postCornerRadius$delegate;
    private final Lazy profileImageSize$delegate;
    private final Lazy suggestedProfilesOnItemTouchListener$delegate;

    /* access modifiers changed from: private */
    public final float getPostCornerRadius() {
        return ((Number) this.postCornerRadius$delegate.getValue()).floatValue();
    }

    /* access modifiers changed from: private */
    public final int getProfileImageSize() {
        return ((Number) this.profileImageSize$delegate.getValue()).intValue();
    }

    /* access modifiers changed from: private */
    public final SuggestedProfilesOnItemTouchListener getSuggestedProfilesOnItemTouchListener() {
        return (SuggestedProfilesOnItemTouchListener) this.suggestedProfilesOnItemTouchListener$delegate.getValue();
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ PostsLinearAdapter(Context context2, PostAction.Listener listener, InviteItemTapListener inviteItemTapListener2, AppRatingItemTapListener appRatingItemTapListener2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(context2, listener, (i & 4) != 0 ? null : inviteItemTapListener2, (i & 8) != 0 ? null : appRatingItemTapListener2);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public PostsLinearAdapter(Context context2, PostAction.Listener listener, InviteItemTapListener inviteItemTapListener2, AppRatingItemTapListener appRatingItemTapListener2) {
        super(context2);
        Intrinsics.checkNotNullParameter(context2, "context");
        Intrinsics.checkNotNullParameter(listener, "postActionListener");
        this.context = context2;
        this.postActionListener = listener;
        this.inviteItemTapListener = inviteItemTapListener2;
        this.appRatingItemTapListener = appRatingItemTapListener2;
        this.profileImageSize$delegate = LazyKt.lazy(new PostsLinearAdapter$profileImageSize$2(this));
        this.postCornerRadius$delegate = LazyKt.lazy(new PostsLinearAdapter$postCornerRadius$2(this));
        this.exoPlayerHelper = new ExoPlayerHelper(context2);
        this.playerStateCallback = new PlayerStateCallback();
        this.suggestedProfilesOnItemTouchListener$delegate = LazyKt.lazy(PostsLinearAdapter$suggestedProfilesOnItemTouchListener$2.INSTANCE);
        this.isMuted = true;
    }

    @Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u0005\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fXT¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\fXT¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\fXT¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\fXT¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\fXT¢\u0006\u0002\n\u0000¨\u0006\u0011"}, mo26107d2 = {"Lcom/memes/plus/ui/posts/PostsLinearAdapter$Companion;", "", "()V", "PAYLOAD_COMMENT_UPDATE", "", "PAYLOAD_FOLLOW_CHANGE", "PAYLOAD_LIKE_CHANGE", "PAYLOAD_PLAYBACK_SOUND_MUTED", "PAYLOAD_PREVIEW_COMMENT", "PAYLOAD_SAVE_CHANGE", "PAYLOAD_SUGGESTED_PROFILE_FOLLOW_CHANGE", "TYPE_APP_RATING", "", "TYPE_INVITE", "TYPE_POST_IMAGE", "TYPE_POST_VIDEO", "TYPE_SUGGESTED_PROFILES", "app_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
    /* renamed from: com.memes.plus.ui.posts.PostsLinearAdapter$Companion */
    /* compiled from: PostsLinearAdapter.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public BaseViewHolder<PostBox> createItemViewHolder(LayoutInflater layoutInflater, ViewGroup viewGroup, int i) {
        Intrinsics.checkNotNullParameter(layoutInflater, "inflater");
        Intrinsics.checkNotNullParameter(viewGroup, "parent");
        switch (i) {
            case 1231:
                PostItemBinding inflate = PostItemBinding.inflate(layoutInflater, viewGroup, false);
                Intrinsics.checkNotNullExpressionValue(inflate, "PostItemBinding.inflate(inflater, parent, false)");
                return new PostImageViewHolder(this, inflate);
            case 1232:
                PostItemBinding inflate2 = PostItemBinding.inflate(layoutInflater, viewGroup, false);
                Intrinsics.checkNotNullExpressionValue(inflate2, "PostItemBinding.inflate(inflater, parent, false)");
                return new PostVideoViewHolder(this, inflate2);
            case 1233:
                PostSuggestedProfilesItemBinding inflate3 = PostSuggestedProfilesItemBinding.inflate(layoutInflater, viewGroup, false);
                Intrinsics.checkNotNullExpressionValue(inflate3, "PostSuggestedProfilesIte…(inflater, parent, false)");
                return new PostSuggestionViewHolder(this, inflate3);
            case 1234:
                PostInviteViewBoxBinding inflate4 = PostInviteViewBoxBinding.inflate(layoutInflater, viewGroup, false);
                Intrinsics.checkNotNullExpressionValue(inflate4, "PostInviteViewBoxBinding…(inflater, parent, false)");
                return new PostInviteViewHolder(this, inflate4);
            case 1235:
                AppRatingRequestItemBinding inflate5 = AppRatingRequestItemBinding.inflate(layoutInflater, viewGroup, false);
                Intrinsics.checkNotNullExpressionValue(inflate5, "AppRatingRequestItemBind…(inflater, parent, false)");
                return new AppRatingItemHolder(this, inflate5);
            default:
                throw new RuntimeException("Unknown view-type: " + i);
        }
    }

    public int getItemViewType(int i) {
        PostBox postBox = (PostBox) getItemAt(i);
        if (postBox instanceof PostBox.PostItem) {
            int contentType = ((PostBox.PostItem) postBox).getPost().contentType();
            if (contentType == 1) {
                return 1231;
            }
            if (contentType == 2) {
                return 1232;
            }
            throw new RuntimeException("Unknown post-type " + contentType + " for position " + i);
        } else if (postBox instanceof PostBox.SuggestedUsersItem) {
            return 1233;
        } else {
            if (postBox instanceof PostBox.InviteItem) {
                return 1234;
            }
            if (postBox instanceof PostBox.AppRatingItem) {
                return 1235;
            }
            throw new RuntimeException("Unknown view position: " + i);
        }
    }

    public final void removeInviteBoxes() {
        int i = 0;
        for (PostBox postBox : getItems()) {
            if (postBox instanceof PostBox.InviteItem) {
                removeItemAt(i);
            }
            i++;
        }
    }

    private final void executeForAllSuggestions(Function2<? super Integer, ? super SuggestedProfileBox, Boolean> function2) {
        int i = 0;
        for (PostBox postBox : getItems()) {
            if (!(postBox instanceof PostBox.SuggestedUsersItem) || !function2.invoke(Integer.valueOf(i), ((PostBox.SuggestedUsersItem) postBox).getProfileBox()).booleanValue()) {
                i++;
            } else {
                return;
            }
        }
    }

    private final void executeForAllPosts(Function2<? super Integer, ? super Post, Boolean> function2) {
        int i = 0;
        for (PostBox postBox : getItems()) {
            if (!(postBox instanceof PostBox.PostItem) || !function2.invoke(Integer.valueOf(i), ((PostBox.PostItem) postBox).getPost()).booleanValue()) {
                i++;
            } else {
                return;
            }
        }
    }

    public final void applyPostsAdapterUpdate(AdapterUpdate<Post> adapterUpdate) {
        List list;
        Intrinsics.checkNotNullParameter(adapterUpdate, "adapterUpdate");
        int page = adapterUpdate.getPage();
        List<Post> items = adapterUpdate.getItems();
        if (items != null) {
            Iterable<Post> iterable = items;
            Collection arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(iterable, 10));
            for (Post postItem : iterable) {
                arrayList.add(new PostBox.PostItem(postItem));
            }
            list = (List) arrayList;
        } else {
            list = null;
        }
        applyAdapterUpdate(new AdapterUpdate(page, list));
    }

    @Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010!\n\u0002\u0010\u0000\n\u0000\b\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\u0010\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fH\u0002J\b\u0010\u0010\u001a\u00020\rH\u0002J\b\u0010\u0011\u001a\u00020\rH\u0002J\b\u0010\u0012\u001a\u00020\rH\u0014J\u0010\u0010\u0013\u001a\u00020\r2\u0006\u0010\u0014\u001a\u00020\u0002H\u0016J\u0010\u0010\u0015\u001a\u00020\r2\u0006\u0010\u0016\u001a\u00020\u0017H\u0002J\u000e\u0010\u0018\u001a\u00020\r2\u0006\u0010\u0019\u001a\u00020\u001aJ\u0010\u0010\u001b\u001a\u00020\r2\u0006\u0010\u001c\u001a\u00020\u0017H\u0002J\b\u0010\u001d\u001a\u00020\rH\u0002J\b\u0010\u001e\u001a\u00020\rH\u0002J\u0012\u0010\u001f\u001a\u00020\r2\b\u0010 \u001a\u0004\u0018\u00010!H\u0002J\b\u0010\"\u001a\u00020\rH\u0002J\u0006\u0010#\u001a\u00020\rJ\b\u0010$\u001a\u00020\rH\u0002J\b\u0010%\u001a\u00020\rH\u0002J\u0016\u0010&\u001a\u00020\r2\f\u0010'\u001a\b\u0012\u0004\u0012\u00020)0(H\u0016R\u000e\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0006\u001a\u00020\u0007X.¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000b¨\u0006*"}, mo26107d2 = {"Lcom/memes/plus/ui/posts/PostsLinearAdapter$PostViewHolder;", "Lcom/memes/commons/recycleradapter/BaseViewHolder;", "Lcom/memes/plus/ui/posts/PostBox;", "binding", "Lcom/memes/plus/databinding/PostItemBinding;", "(Lcom/memes/plus/ui/posts/PostsLinearAdapter;Lcom/memes/plus/databinding/PostItemBinding;)V", "post", "Lcom/memes/plus/ui/posts/Post;", "getPost", "()Lcom/memes/plus/ui/posts/Post;", "setPost", "(Lcom/memes/plus/ui/posts/Post;)V", "animateLikeHearts", "", "view", "Landroid/view/View;", "attachZoomHelper", "likePostTemporarily", "onPostMediaVolumeToggleButtonTapped", "setItem", "item", "showCommentsCountString", "postCommentCount", "", "showMuted", "isMuted", "", "showPostLikeCount", "postLikesCount", "showPostLikes", "showPreviewCommentsIfAvailable", "showRepostInfo", "repost", "Lcom/memes/plus/ui/posts/Repost;", "showSavedPost", "togglePostLike", "togglePostSave", "unlikePostTemporarily", "updateWithPayload", "payloads", "", "", "app_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
    /* renamed from: com.memes.plus.ui.posts.PostsLinearAdapter$PostViewHolder */
    /* compiled from: PostsLinearAdapter.kt */
    public class PostViewHolder extends BaseViewHolder<PostBox> {
        /* access modifiers changed from: private */
        public final PostItemBinding binding;
        protected Post post;
        final /* synthetic */ PostsLinearAdapter this$0;

        /* access modifiers changed from: protected */
        public void onPostMediaVolumeToggleButtonTapped() {
        }

        /* JADX WARNING: Illegal instructions before constructor call */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public PostViewHolder(com.memes.plus.p040ui.posts.PostsLinearAdapter r5, com.memes.plus.databinding.PostItemBinding r6) {
            /*
                r4 = this;
                java.lang.String r0 = "binding"
                kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r6, r0)
                r4.this$0 = r5
                android.widget.LinearLayout r0 = r6.getRoot()
                java.lang.String r1 = "binding.root"
                kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r0, r1)
                android.view.View r0 = (android.view.View) r0
                r4.<init>(r0)
                r4.binding = r6
                android.widget.LinearLayout r0 = r6.getRoot()
                kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r0, r1)
                android.view.View r0 = (android.view.View) r0
                float r1 = r5.getPostCornerRadius()
                r2 = 0
                r3 = 2
                com.memes.commons.outlineprovider.ViewCornerOutlineProviderKt.roundCorners$default((android.view.View) r0, (float) r1, (com.memes.commons.outlineprovider.ViewCornerOutlineProvider.CornerType) r2, (int) r3, (java.lang.Object) r2)
                com.memes.commons.contentlayout.ContentLayout r0 = r6.postMediaContentLayout
                r1 = 1
                r0.setOverlayMode(r1)
                com.memes.commons.contentlayout.ContentLayout r0 = r6.postMediaContentLayout
                java.lang.String r2 = "binding.postMediaContentLayout"
                kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r0, r2)
                r0.setResizeMode(r1)
                com.memes.plus.databinding.SnippetPostMediaProgressBarBinding r0 = r6.includedMediaProgressLayout
                java.lang.String r1 = "binding.includedMediaProgressLayout"
                kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r0, r1)
                android.widget.LinearLayout r0 = r0.getRoot()
                int r5 = r5.mediaProgressLayoutBackgroundColor
                r0.setBackgroundColor(r5)
                com.memes.plus.ui.posts.PostsLinearAdapter$PostViewHolder$1 r5 = new com.memes.plus.ui.posts.PostsLinearAdapter$PostViewHolder$1
                r5.<init>(r4)
                android.view.View$OnClickListener r5 = (android.view.View.OnClickListener) r5
                android.widget.TextView r0 = r6.postAuthorUserNameTextView
                r0.setOnClickListener(r5)
                com.memes.plus.custom.UserAvatarView r0 = r6.postAuthorImageView
                r0.setOnClickListener(r5)
                android.widget.TextView r5 = r6.postFollowTextView
                com.memes.plus.ui.posts.PostsLinearAdapter$PostViewHolder$3 r0 = new com.memes.plus.ui.posts.PostsLinearAdapter$PostViewHolder$3
                r0.<init>(r4)
                android.view.View$OnClickListener r0 = (android.view.View.OnClickListener) r0
                r5.setOnClickListener(r0)
                com.memes.plus.ui.posts.PostsLinearAdapter$PostViewHolder$4 r5 = new com.memes.plus.ui.posts.PostsLinearAdapter$PostViewHolder$4
                r5.<init>(r4)
                android.view.View$OnClickListener r5 = (android.view.View.OnClickListener) r5
                com.makeramen.roundedimageview.RoundedImageView r0 = r6.postByUserImageview
                r0.setOnClickListener(r5)
                android.widget.TextView r0 = r6.postedByUserNameTextView
                r0.setOnClickListener(r5)
                com.memes.commons.enhancedtext.socialtext.SocialTextView r5 = r6.postDescriptionTextView
                com.memes.plus.ui.posts.PostsLinearAdapter$PostViewHolder$6 r0 = new com.memes.plus.ui.posts.PostsLinearAdapter$PostViewHolder$6
                r0.<init>(r4)
                com.memes.commons.enhancedtext.socialtext.SocialTextView$OnLinkClickListener r0 = (com.memes.commons.enhancedtext.socialtext.SocialTextView.OnLinkClickListener) r0
                r5.setOnLinkClickListener(r0)
                android.widget.ImageView r5 = r6.postLikeImageView
                com.memes.plus.ui.posts.PostsLinearAdapter$PostViewHolder$7 r0 = new com.memes.plus.ui.posts.PostsLinearAdapter$PostViewHolder$7
                r0.<init>(r4)
                android.view.View$OnClickListener r0 = (android.view.View.OnClickListener) r0
                r5.setOnClickListener(r0)
                android.widget.ImageView r5 = r6.postSaveImageView
                com.memes.plus.ui.posts.PostsLinearAdapter$PostViewHolder$8 r0 = new com.memes.plus.ui.posts.PostsLinearAdapter$PostViewHolder$8
                r0.<init>(r4)
                android.view.View$OnClickListener r0 = (android.view.View.OnClickListener) r0
                r5.setOnClickListener(r0)
                android.widget.ImageView r5 = r6.postShareImageView
                com.memes.plus.ui.posts.PostsLinearAdapter$PostViewHolder$9 r0 = new com.memes.plus.ui.posts.PostsLinearAdapter$PostViewHolder$9
                r0.<init>(r4)
                android.view.View$OnClickListener r0 = (android.view.View.OnClickListener) r0
                r5.setOnClickListener(r0)
                com.memes.commons.ui.IconTextHorizontalButton r5 = r6.postShareButton
                com.memes.plus.ui.posts.PostsLinearAdapter$PostViewHolder$10 r0 = new com.memes.plus.ui.posts.PostsLinearAdapter$PostViewHolder$10
                r0.<init>(r4)
                android.view.View$OnClickListener r0 = (android.view.View.OnClickListener) r0
                r5.setOnClickListener(r0)
                android.widget.TextView r5 = r6.postLikeCountTextView
                com.memes.plus.ui.posts.PostsLinearAdapter$PostViewHolder$11 r0 = new com.memes.plus.ui.posts.PostsLinearAdapter$PostViewHolder$11
                r0.<init>(r4)
                android.view.View$OnClickListener r0 = (android.view.View.OnClickListener) r0
                r5.setOnClickListener(r0)
                android.widget.FrameLayout r5 = r6.parentMedia
                com.memes.plus.ui.posts.PostsLinearAdapter$PostViewHolder$12 r0 = new com.memes.plus.ui.posts.PostsLinearAdapter$PostViewHolder$12
                r0.<init>(r4)
                android.view.View$OnClickListener r0 = (android.view.View.OnClickListener) r0
                r5.setOnClickListener(r0)
                com.memes.plus.ui.posts.post_basics.viewcount.PostViewCountView r5 = r6.postViewCountIndicatorView
                com.memes.plus.ui.posts.PostsLinearAdapter$PostViewHolder$13 r0 = new com.memes.plus.ui.posts.PostsLinearAdapter$PostViewHolder$13
                r0.<init>(r4)
                android.view.View$OnClickListener r0 = (android.view.View.OnClickListener) r0
                r5.setOnClickListener(r0)
                android.widget.ImageView r5 = r6.postTaggedUsersIndicatorView
                com.memes.plus.ui.posts.PostsLinearAdapter$PostViewHolder$14 r0 = new com.memes.plus.ui.posts.PostsLinearAdapter$PostViewHolder$14
                r0.<init>(r4)
                android.view.View$OnClickListener r0 = (android.view.View.OnClickListener) r0
                r5.setOnClickListener(r0)
                com.memes.commons.ui.IconTextHorizontalButton r5 = r6.postSaveButton
                com.memes.plus.ui.posts.PostsLinearAdapter$PostViewHolder$15 r0 = new com.memes.plus.ui.posts.PostsLinearAdapter$PostViewHolder$15
                r0.<init>(r4)
                android.view.View$OnClickListener r0 = (android.view.View.OnClickListener) r0
                r5.setOnClickListener(r0)
                com.memes.plus.ui.posts.PostsLinearAdapter$PostViewHolder$16 r5 = new com.memes.plus.ui.posts.PostsLinearAdapter$PostViewHolder$16
                r5.<init>(r4)
                android.view.View$OnClickListener r5 = (android.view.View.OnClickListener) r5
                android.widget.ImageView r0 = r6.postCommentsImageView
                r0.setOnClickListener(r5)
                android.widget.TextView r0 = r6.commentsTextView
                r0.setOnClickListener(r5)
                android.widget.ImageView r5 = r6.postOptionsImageView
                com.memes.plus.ui.posts.PostsLinearAdapter$PostViewHolder$18 r0 = new com.memes.plus.ui.posts.PostsLinearAdapter$PostViewHolder$18
                r0.<init>(r4)
                android.view.View$OnClickListener r0 = (android.view.View.OnClickListener) r0
                r5.setOnClickListener(r0)
                android.widget.LinearLayout r5 = r6.addCommentLayout
                com.memes.plus.ui.posts.PostsLinearAdapter$PostViewHolder$19 r0 = new com.memes.plus.ui.posts.PostsLinearAdapter$PostViewHolder$19
                r0.<init>(r4)
                android.view.View$OnClickListener r0 = (android.view.View.OnClickListener) r0
                r5.setOnClickListener(r0)
                android.widget.ImageView r5 = r6.postMediaVolumeToggleButton
                com.memes.plus.ui.posts.PostsLinearAdapter$PostViewHolder$20 r6 = new com.memes.plus.ui.posts.PostsLinearAdapter$PostViewHolder$20
                r6.<init>(r4)
                android.view.View$OnClickListener r6 = (android.view.View.OnClickListener) r6
                r5.setOnClickListener(r6)
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.memes.plus.p040ui.posts.PostsLinearAdapter.PostViewHolder.<init>(com.memes.plus.ui.posts.PostsLinearAdapter, com.memes.plus.databinding.PostItemBinding):void");
        }

        /* access modifiers changed from: protected */
        public final Post getPost() {
            Post post2 = this.post;
            if (post2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("post");
            }
            return post2;
        }

        /* access modifiers changed from: protected */
        public final void setPost(Post post2) {
            Intrinsics.checkNotNullParameter(post2, "<set-?>");
            this.post = post2;
        }

        /* JADX WARNING: Removed duplicated region for block: B:61:0x0183  */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void setItem(com.memes.plus.p040ui.posts.PostBox r6) {
            /*
                r5 = this;
                java.lang.String r0 = "item"
                kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r6, r0)
                com.memes.plus.ui.posts.PostBox$PostItem r6 = (com.memes.plus.p040ui.posts.PostBox.PostItem) r6
                com.memes.plus.ui.posts.Post r6 = r6.getPost()
                r5.post = r6
                r5.attachZoomHelper()
                com.memes.plus.databinding.PostItemBinding r6 = r5.binding
                com.memes.commons.contentlayout.ContentLayout r6 = r6.postMediaContentLayout
                r6.showContent()
                com.memes.plus.ui.posts.Post r6 = r5.post
                java.lang.String r0 = "post"
                if (r6 != 0) goto L_0x0020
                kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r0)
            L_0x0020:
                float r6 = r6.aspectRatio()
                r1 = 1
                float r2 = (float) r1
                int r2 = (r6 > r2 ? 1 : (r6 == r2 ? 0 : -1))
                if (r2 >= 0) goto L_0x0034
                com.memes.plus.databinding.PostItemBinding r6 = r5.binding
                com.memes.commons.contentlayout.ContentLayout r6 = r6.postMediaContentLayout
                r2 = 1065353216(0x3f800000, float:1.0)
                r6.setAspectRatio(r2)
                goto L_0x003b
            L_0x0034:
                com.memes.plus.databinding.PostItemBinding r2 = r5.binding
                com.memes.commons.contentlayout.ContentLayout r2 = r2.postMediaContentLayout
                r2.setAspectRatio(r6)
            L_0x003b:
                com.memes.plus.databinding.PostItemBinding r6 = r5.binding
                com.memes.plus.custom.UserAvatarView r6 = r6.postAuthorImageView
                com.memes.plus.ui.posts.Post r2 = r5.post
                if (r2 != 0) goto L_0x0046
                kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r0)
            L_0x0046:
                boolean r2 = r2.isProUser()
                r6.setProUser(r2)
                com.memes.plus.databinding.PostItemBinding r6 = r5.binding
                com.memes.plus.custom.UserAvatarView r6 = r6.postAuthorImageView
                com.memes.plus.ui.posts.Post r2 = r5.post
                if (r2 != 0) goto L_0x0058
                kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r0)
            L_0x0058:
                java.lang.String r2 = r2.getProfileImageThumb()
                r3 = 2131231340(0x7f08026c, float:1.8078758E38)
                com.memes.plus.ui.posts.PostsLinearAdapter r4 = r5.this$0
                int r4 = r4.getProfileImageSize()
                java.lang.Integer r4 = java.lang.Integer.valueOf(r4)
                r6.loadUrl(r2, r3, r4)
                com.memes.plus.ui.posts.Post r6 = r5.post
                if (r6 != 0) goto L_0x0073
                kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r0)
            L_0x0073:
                com.memes.plus.ui.posts.Repost r6 = r6.getRePost()
                r5.showRepostInfo(r6)
                com.memes.plus.databinding.PostItemBinding r6 = r5.binding
                android.widget.TextView r6 = r6.postAuthorUserNameTextView
                java.lang.String r2 = "binding.postAuthorUserNameTextView"
                kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r6, r2)
                com.memes.plus.ui.posts.Post r2 = r5.post
                if (r2 != 0) goto L_0x008a
                kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r0)
            L_0x008a:
                java.lang.String r2 = r2.getUsername()
                java.lang.CharSequence r2 = (java.lang.CharSequence) r2
                r6.setText(r2)
                com.memes.plus.databinding.PostItemBinding r6 = r5.binding
                android.widget.TextView r6 = r6.postTimeTextView
                java.lang.String r2 = "binding.postTimeTextView"
                kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r6, r2)
                com.memes.commons.util.PrettyTime r2 = com.memes.commons.util.PrettyTime.INSTANCE
                com.memes.plus.ui.posts.Post r3 = r5.post
                if (r3 != 0) goto L_0x00a5
                kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r0)
            L_0x00a5:
                java.lang.Long r3 = r3.getCreatedDate()
                java.lang.String r2 = r2.getTimeAgoString(r3)
                java.lang.CharSequence r2 = (java.lang.CharSequence) r2
                r6.setText(r2)
                com.memes.plus.ui.posts.Post r6 = r5.post
                if (r6 != 0) goto L_0x00b9
                kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r0)
            L_0x00b9:
                java.lang.String r6 = r6.getPostText()
                java.lang.CharSequence r6 = (java.lang.CharSequence) r6
                r2 = 0
                if (r6 == 0) goto L_0x00ca
                boolean r6 = kotlin.text.StringsKt.isBlank(r6)
                if (r6 == 0) goto L_0x00c9
                goto L_0x00ca
            L_0x00c9:
                r1 = 0
            L_0x00ca:
                java.lang.String r6 = "binding.postDescriptionTextView"
                r3 = 8
                if (r1 == 0) goto L_0x00e4
                com.memes.plus.databinding.PostItemBinding r1 = r5.binding
                com.memes.commons.enhancedtext.socialtext.SocialTextView r1 = r1.postDescriptionTextView
                kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r1, r6)
                r1.setVisibility(r3)
                com.memes.plus.databinding.PostItemBinding r6 = r5.binding
                com.memes.commons.enhancedtext.socialtext.SocialTextView r6 = r6.postDescriptionTextView
                java.lang.String r1 = ""
                r6.setLinkText(r1)
                goto L_0x0104
            L_0x00e4:
                com.memes.plus.databinding.PostItemBinding r1 = r5.binding
                com.memes.commons.enhancedtext.socialtext.SocialTextView r1 = r1.postDescriptionTextView
                kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r1, r6)
                r1.setVisibility(r2)
                com.memes.plus.databinding.PostItemBinding r6 = r5.binding
                com.memes.commons.enhancedtext.socialtext.SocialTextView r6 = r6.postDescriptionTextView
                com.memes.plus.ui.posts.Post r1 = r5.post
                if (r1 != 0) goto L_0x00f9
                kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r0)
            L_0x00f9:
                java.lang.String r1 = r1.getPostText()
                java.lang.String r1 = com.memes.commons.util.ExtensionsKt.encode(r1)
                r6.setLinkText(r1)
            L_0x0104:
                com.memes.plus.databinding.PostItemBinding r6 = r5.binding
                android.widget.LinearLayout r6 = r6.postInfoPopupContainer
                java.lang.String r1 = "binding.postInfoPopupContainer"
                kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r6, r1)
                r6.setVisibility(r2)
                com.memes.plus.databinding.PostItemBinding r6 = r5.binding
                com.memes.plus.ui.posts.post_basics.viewcount.PostViewCountView r6 = r6.postViewCountIndicatorView
                java.lang.String r1 = "binding.postViewCountIndicatorView"
                kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r6, r1)
                r6.setVisibility(r2)
                com.memes.plus.databinding.PostItemBinding r6 = r5.binding
                com.memes.plus.ui.posts.post_basics.viewcount.PostViewCountView r6 = r6.postViewCountIndicatorView
                com.memes.plus.ui.posts.Post r1 = r5.post
                if (r1 != 0) goto L_0x0127
                kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r0)
            L_0x0127:
                java.lang.String r1 = r1.getTotalViews()
                r6.setViewCount((java.lang.String) r1)
                com.memes.plus.databinding.PostItemBinding r6 = r5.binding
                android.widget.ImageView r6 = r6.postTaggedUsersIndicatorView
                java.lang.String r1 = "binding.postTaggedUsersIndicatorView"
                kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r6, r1)
                com.memes.plus.ui.posts.Post r1 = r5.post
                if (r1 != 0) goto L_0x013e
                kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r0)
            L_0x013e:
                boolean r1 = r1.isTagged()
                if (r1 == 0) goto L_0x0146
                r1 = 0
                goto L_0x0148
            L_0x0146:
                r1 = 8
            L_0x0148:
                r6.setVisibility(r1)
                com.memes.plus.databinding.PostItemBinding r6 = r5.binding
                android.widget.TextView r6 = r6.postFollowTextView
                java.lang.String r1 = "binding.postFollowTextView"
                kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r6, r1)
                com.memes.plus.ui.posts.Post r1 = r5.post
                if (r1 != 0) goto L_0x015b
                kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r0)
            L_0x015b:
                boolean r1 = r1.getIamfollowing()
                if (r1 != 0) goto L_0x0177
                com.memes.network.memes.MemesSession r1 = com.memes.network.memes.MemesSession.INSTANCE
                com.memes.plus.ui.posts.Post r4 = r5.post
                if (r4 != 0) goto L_0x016a
                kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r0)
            L_0x016a:
                java.lang.String r4 = r4.getUserId()
                boolean r1 = r1.isOf(r4)
                if (r1 == 0) goto L_0x0175
                goto L_0x0177
            L_0x0175:
                r1 = 0
                goto L_0x0179
            L_0x0177:
                r1 = 8
            L_0x0179:
                r6.setVisibility(r1)
                r5.showPostLikes()
                com.memes.plus.ui.posts.Post r6 = r5.post
                if (r6 != 0) goto L_0x0186
                kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r0)
            L_0x0186:
                long r0 = r6.getTotalComments()
                r5.showCommentsCountString(r0)
                r5.showSavedPost()
                com.memes.plus.databinding.PostItemBinding r6 = r5.binding
                android.widget.LinearLayout r6 = r6.addCommentBox
                java.lang.String r0 = "binding.addCommentBox"
                kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r6, r0)
                r6.setVisibility(r2)
                r5.showPreviewCommentsIfAvailable()
                com.memes.plus.databinding.PostItemBinding r6 = r5.binding
                android.widget.TextView r6 = r6.postContentIdentifierView
                java.lang.String r0 = "binding.postContentIdentifierView"
                kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r6, r0)
                r6.setVisibility(r3)
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.memes.plus.p040ui.posts.PostsLinearAdapter.PostViewHolder.setItem(com.memes.plus.ui.posts.PostBox):void");
        }

        private final void attachZoomHelper() {
            ImageZoomUtility.Companion companion = ImageZoomUtility.Companion;
            FrameLayout frameLayout = this.binding.parentMedia;
            Intrinsics.checkNotNullExpressionValue(frameLayout, "binding.parentMedia");
            companion.addZoomableView(frameLayout);
        }

        private final void showRepostInfo(Repost repost) {
            if (repost == null) {
                LinearLayout linearLayout = this.binding.repostLinearLayout;
                Intrinsics.checkNotNullExpressionValue(linearLayout, "binding.repostLinearLayout");
                linearLayout.setVisibility(8);
                return;
            }
            LinearLayout linearLayout2 = this.binding.repostLinearLayout;
            Intrinsics.checkNotNullExpressionValue(linearLayout2, "binding.repostLinearLayout");
            linearLayout2.setVisibility(0);
            TextView textView = this.binding.postedByUserNameTextView;
            Intrinsics.checkNotNullExpressionValue(textView, "binding.postedByUserNameTextView");
            textView.setText("By " + repost.getUsername());
            Picasso picasso = Picasso.get();
            Intrinsics.checkNotNullExpressionValue(picasso, "Picasso.get()");
            PicassoExtKt.log$default(picasso, (Object) this, repost.getProfileImage(), (String) null, 4, (Object) null).load(repost.getProfileImage()).placeholder((int) C4199R.C4202drawable.placeholder_profile).error((int) C4199R.C4202drawable.placeholder_profile).fit().into((ImageView) this.binding.postByUserImageview);
        }

        private final void showSavedPost() {
            Post post2 = this.post;
            if (post2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("post");
            }
            if (post2.getSaved()) {
                this.binding.postSaveButton.setText((int) C4199R.string.Saved);
                this.binding.postSaveImageView.setImageResource(C4199R.C4202drawable.icon_post_save_tag_filled);
                return;
            }
            this.binding.postSaveButton.setText((int) C4199R.string.Save);
            this.binding.postSaveImageView.setImageResource(C4199R.C4202drawable.icon_post_save_tag);
        }

        private final void showPostLikes() {
            ImageView imageView = this.binding.postLikeImageView;
            Post post2 = this.post;
            if (post2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("post");
            }
            imageView.setImageResource(post2.getLiked() ? C4199R.C4202drawable.icon_post_heart_like_filled : C4199R.C4202drawable.icon_post_heart_like);
            Post post3 = this.post;
            if (post3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("post");
            }
            if (post3.getLiked()) {
                this.binding.postLikeCountTextView.setTextColor(ExtensionsKt.getColorFromAttr$default(this.this$0.context, C4199R.attr.colorHighlightedPrimary, (TypedValue) null, false, 6, (Object) null));
            } else {
                this.binding.postLikeCountTextView.setTextColor(ContextCompat.getColor(this.this$0.context, C4199R.C4201color.white));
            }
            Post post4 = this.post;
            if (post4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("post");
            }
            showPostLikeCount(post4.getTotalLikes());
        }

        private final void showPostLikeCount(long j) {
            String str;
            TextView textView = this.binding.postLikeCountTextView;
            Intrinsics.checkNotNullExpressionValue(textView, "binding.postLikeCountTextView");
            int i = (j > 1 ? 1 : (j == 1 ? 0 : -1));
            if (i == 0) {
                str = String.valueOf(j);
            } else {
                str = i > 0 ? String.valueOf(PrettyCounter.INSTANCE.apply(j)) : "0";
            }
            textView.setText(str);
        }

        private final void showCommentsCountString(long j) {
            CharSequence charSequence;
            TextView textView = this.binding.commentsTextView;
            Intrinsics.checkNotNullExpressionValue(textView, "binding.commentsTextView");
            if (j > 0) {
                int i = (j > 1 ? 1 : (j == 1 ? 0 : -1));
                if (i != 0) {
                    if (i > 0) {
                        Post post2 = this.post;
                        if (post2 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("post");
                        }
                        charSequence = String.valueOf(post2.getTotalComments());
                    } else {
                        Post post3 = this.post;
                        if (post3 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("post");
                        }
                        charSequence = String.valueOf(post3.getTotalComments());
                    }
                }
            }
            textView.setText(charSequence);
        }

        public final void showMuted(boolean z) {
            this.this$0.exoPlayerHelper.setMuted(z);
            ImageView imageView = this.binding.postMediaVolumeToggleButton;
            Intrinsics.checkNotNullExpressionValue(imageView, "binding.postMediaVolumeToggleButton");
            imageView.setSelected(!z);
        }

        public final void togglePostLike() {
            PostAction.Listener access$getPostActionListener$p = this.this$0.postActionListener;
            Post post2 = this.post;
            if (post2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("post");
            }
            access$getPostActionListener$p.onPostActionPerformed(new PostAction.LikeTapped(post2));
            Post post3 = this.post;
            if (post3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("post");
            }
            if (post3.getLiked()) {
                unlikePostTemporarily();
                return;
            }
            ImageView imageView = this.binding.heartView;
            Intrinsics.checkNotNullExpressionValue(imageView, "binding.heartView");
            animateLikeHearts(imageView);
            likePostTemporarily();
        }

        /* access modifiers changed from: private */
        public final void togglePostSave() {
            Post post2 = this.post;
            if (post2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("post");
            }
            if (post2.getSaved()) {
                this.binding.postSaveButton.setText((int) C4199R.string.Save);
            } else {
                this.binding.postSaveButton.setText((int) C4199R.string.Saved);
            }
            PostAction.Listener access$getPostActionListener$p = this.this$0.postActionListener;
            Post post3 = this.post;
            if (post3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("post");
            }
            access$getPostActionListener$p.onPostActionPerformed(new PostAction.SaveTapped(post3));
        }

        private final void likePostTemporarily() {
            this.binding.postLikeImageView.setImageResource(C4199R.C4202drawable.icon_post_heart_like_filled);
            Post post2 = this.post;
            if (post2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("post");
            }
            showPostLikeCount(post2.getTotalLikes() + 1);
        }

        private final void unlikePostTemporarily() {
            this.binding.postLikeImageView.setImageResource(C4199R.C4202drawable.icon_post_heart_like);
            Post post2 = this.post;
            if (post2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("post");
            }
            showPostLikeCount(post2.getTotalLikes() - 1);
        }

        private final void animateLikeHearts(View view) {
            view.setVisibility(0);
            view.animate().scaleX(2.0f).scaleY(2.0f).alpha(1.0f).setDuration(600).setListener(new PostsLinearAdapter$PostViewHolder$animateLikeHearts$1(view));
        }

        private final void showPreviewCommentsIfAvailable() {
            Post post2 = this.post;
            if (post2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("post");
            }
            List<PostPreviewComment> comments = post2.getComments();
            Collection collection = comments;
            if (collection == null || collection.isEmpty()) {
                PostCommentPreviewBoxItemBinding postCommentPreviewBoxItemBinding = this.binding.includedCommentPreviewBox;
                Intrinsics.checkNotNullExpressionValue(postCommentPreviewBoxItemBinding, "binding.includedCommentPreviewBox");
                LinearLayout root = postCommentPreviewBoxItemBinding.getRoot();
                Intrinsics.checkNotNullExpressionValue(root, "binding.includedCommentPreviewBox.root");
                root.setVisibility(8);
                TextView textView = this.binding.topCommentsHeaderTextView;
                Intrinsics.checkNotNullExpressionValue(textView, "binding.topCommentsHeaderTextView");
                textView.setVisibility(8);
                return;
            }
            TextView textView2 = this.binding.topCommentsHeaderTextView;
            Intrinsics.checkNotNullExpressionValue(textView2, "binding.topCommentsHeaderTextView");
            textView2.setVisibility(0);
            PostPreviewComment postPreviewComment = (PostPreviewComment) CollectionsKt.first(comments);
            PostCommentPreviewItem postCommentPreviewItem = this.binding.includedCommentPreviewBox.firstCommentPreviewView;
            Post post3 = this.post;
            if (post3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("post");
            }
            postCommentPreviewItem.load(post3, postPreviewComment, this.this$0.postActionListener);
            if (comments.size() > 1) {
                PostPreviewComment postPreviewComment2 = comments.get(1);
                PostCommentPreviewItem postCommentPreviewItem2 = this.binding.includedCommentPreviewBox.secondCommentPreviewView;
                Post post4 = this.post;
                if (post4 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("post");
                }
                postCommentPreviewItem2.load(post4, postPreviewComment2, this.this$0.postActionListener);
                PostCommentPreviewItem postCommentPreviewItem3 = this.binding.includedCommentPreviewBox.secondCommentPreviewView;
                Intrinsics.checkNotNullExpressionValue(postCommentPreviewItem3, "binding.includedCommentP….secondCommentPreviewView");
                postCommentPreviewItem3.setVisibility(0);
            } else {
                PostCommentPreviewItem postCommentPreviewItem4 = this.binding.includedCommentPreviewBox.secondCommentPreviewView;
                Intrinsics.checkNotNullExpressionValue(postCommentPreviewItem4, "binding.includedCommentP….secondCommentPreviewView");
                postCommentPreviewItem4.setVisibility(8);
            }
            PostCommentPreviewBoxItemBinding postCommentPreviewBoxItemBinding2 = this.binding.includedCommentPreviewBox;
            Intrinsics.checkNotNullExpressionValue(postCommentPreviewBoxItemBinding2, "binding.includedCommentPreviewBox");
            LinearLayout root2 = postCommentPreviewBoxItemBinding2.getRoot();
            Intrinsics.checkNotNullExpressionValue(root2, "binding.includedCommentPreviewBox.root");
            root2.setVisibility(0);
        }

        public void updateWithPayload(List<Object> list) {
            int i;
            Intrinsics.checkNotNullParameter(list, "payloads");
            for (Object next : list) {
                if (next instanceof AdapterViewHolderPayload) {
                    AdapterViewHolderPayload adapterViewHolderPayload = (AdapterViewHolderPayload) next;
                    String key = adapterViewHolderPayload.getKey();
                    switch (key.hashCode()) {
                        case -2122198744:
                            if (!key.equals(PostsLinearAdapter.PAYLOAD_PLAYBACK_SOUND_MUTED)) {
                                break;
                            } else {
                                showMuted(this.this$0.isMuted);
                                break;
                            }
                        case -1740680153:
                            if (!key.equals("payload_like_change")) {
                                break;
                            } else {
                                Object value = adapterViewHolderPayload.getValue();
                                Objects.requireNonNull(value, "null cannot be cast to non-null type com.memes.plus.ui.posts.Post");
                                Post post2 = (Post) value;
                                Post post3 = this.post;
                                if (post3 == null) {
                                    Intrinsics.throwUninitializedPropertyAccessException("post");
                                }
                                post3.setLiked(post2.getLiked());
                                Post post4 = this.post;
                                if (post4 == null) {
                                    Intrinsics.throwUninitializedPropertyAccessException("post");
                                }
                                post4.setTotalLikes(post2.getTotalLikes());
                                showPostLikes();
                                break;
                            }
                        case -393060595:
                            if (!key.equals(PostsLinearAdapter.PAYLOAD_FOLLOW_CHANGE)) {
                                break;
                            } else {
                                Object value2 = adapterViewHolderPayload.getValue();
                                Objects.requireNonNull(value2, "null cannot be cast to non-null type com.memes.plus.ui.posts.Post");
                                Post post5 = (Post) value2;
                                Post post6 = this.post;
                                if (post6 == null) {
                                    Intrinsics.throwUninitializedPropertyAccessException("post");
                                }
                                post6.setIamfollowing(post5.getIamfollowing());
                                TextView textView = this.binding.postFollowTextView;
                                Intrinsics.checkNotNullExpressionValue(textView, "binding.postFollowTextView");
                                Post post7 = this.post;
                                if (post7 == null) {
                                    Intrinsics.throwUninitializedPropertyAccessException("post");
                                }
                                if (!post7.getIamfollowing()) {
                                    MemesSession memesSession = MemesSession.INSTANCE;
                                    Post post8 = this.post;
                                    if (post8 == null) {
                                        Intrinsics.throwUninitializedPropertyAccessException("post");
                                    }
                                    if (!memesSession.isOf(post8.getUserId())) {
                                        i = 0;
                                        textView.setVisibility(i);
                                        break;
                                    }
                                }
                                i = 8;
                                textView.setVisibility(i);
                            }
                        case 676179322:
                            if (key.equals(PostsLinearAdapter.PAYLOAD_COMMENT_UPDATE)) {
                                Post post9 = this.post;
                                if (post9 == null) {
                                    Intrinsics.throwUninitializedPropertyAccessException("post");
                                }
                                showCommentsCountString(post9.getTotalComments());
                                break;
                            } else {
                                break;
                            }
                        case 1730507649:
                            if (!key.equals(PostsLinearAdapter.PAYLOAD_SAVE_CHANGE)) {
                                break;
                            } else {
                                Object value3 = adapterViewHolderPayload.getValue();
                                Objects.requireNonNull(value3, "null cannot be cast to non-null type com.memes.plus.ui.posts.Post");
                                Post post10 = (Post) value3;
                                Post post11 = this.post;
                                if (post11 == null) {
                                    Intrinsics.throwUninitializedPropertyAccessException("post");
                                }
                                post11.setSaved(post10.getSaved());
                                showSavedPost();
                                break;
                            }
                        case 2140089155:
                            if (!key.equals(PostsLinearAdapter.PAYLOAD_PREVIEW_COMMENT)) {
                                break;
                            } else {
                                Object value4 = adapterViewHolderPayload.getValue();
                                Objects.requireNonNull(value4, "null cannot be cast to non-null type com.memes.plus.ui.posts.Post");
                                this.post = (Post) value4;
                                showPreviewCommentsIfAvailable();
                                break;
                            }
                    }
                }
            }
        }
    }

    @Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000+\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0007\b\u0004\u0018\u00002\u00060\u0001R\u00020\u0002B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\u0010\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0016J\b\u0010\r\u001a\u00020\nH\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u00020\u0007X\u0004¢\u0006\u0004\n\u0002\u0010\b¨\u0006\u000e"}, mo26107d2 = {"Lcom/memes/plus/ui/posts/PostsLinearAdapter$PostImageViewHolder;", "Lcom/memes/plus/ui/posts/PostsLinearAdapter$PostViewHolder;", "Lcom/memes/plus/ui/posts/PostsLinearAdapter;", "binding", "Lcom/memes/plus/databinding/PostItemBinding;", "(Lcom/memes/plus/ui/posts/PostsLinearAdapter;Lcom/memes/plus/databinding/PostItemBinding;)V", "picassoCallback", "com/memes/plus/ui/posts/PostsLinearAdapter$PostImageViewHolder$picassoCallback$1", "Lcom/memes/plus/ui/posts/PostsLinearAdapter$PostImageViewHolder$picassoCallback$1;", "setItem", "", "item", "Lcom/memes/plus/ui/posts/PostBox;", "showImage", "app_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
    /* renamed from: com.memes.plus.ui.posts.PostsLinearAdapter$PostImageViewHolder */
    /* compiled from: PostsLinearAdapter.kt */
    public final class PostImageViewHolder extends PostViewHolder {
        /* access modifiers changed from: private */
        public final PostItemBinding binding;
        private final PostsLinearAdapter$PostImageViewHolder$picassoCallback$1 picassoCallback = new PostsLinearAdapter$PostImageViewHolder$picassoCallback$1(this);
        final /* synthetic */ PostsLinearAdapter this$0;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public PostImageViewHolder(PostsLinearAdapter postsLinearAdapter, PostItemBinding postItemBinding) {
            super(postsLinearAdapter, postItemBinding);
            Intrinsics.checkNotNullParameter(postItemBinding, "binding");
            this.this$0 = postsLinearAdapter;
            this.binding = postItemBinding;
        }

        public void setItem(PostBox postBox) {
            Intrinsics.checkNotNullParameter(postBox, "item");
            super.setItem(postBox);
            PlayerView playerView = this.binding.postContentVideoView;
            Intrinsics.checkNotNullExpressionValue(playerView, "binding.postContentVideoView");
            if (playerView.getParent() != null) {
                this.binding.parentMedia.removeView(this.binding.postContentVideoView);
            }
            showImage();
        }

        private final void showImage() {
            Uri mediaThumbUrl = getPost().mediaThumbUrl();
            SnippetPostMediaProgressBarBinding snippetPostMediaProgressBarBinding = this.binding.includedMediaProgressLayout;
            Intrinsics.checkNotNullExpressionValue(snippetPostMediaProgressBarBinding, "binding.includedMediaProgressLayout");
            LinearLayout root = snippetPostMediaProgressBarBinding.getRoot();
            Intrinsics.checkNotNullExpressionValue(root, "binding.includedMediaProgressLayout.root");
            root.setVisibility(0);
            Picasso picasso = Picasso.get();
            Intrinsics.checkNotNullExpressionValue(picasso, "Picasso.get()");
            PicassoExtKt.log$default(picasso, (Object) this, mediaThumbUrl != null ? mediaThumbUrl.toString() : null, (String) null, 4, (Object) null).load(mediaThumbUrl).placeholder((int) C4199R.C4201color.primary_background_lighter).error((int) C4199R.C4201color.primary_background_lighter).into(this.binding.postContentImageView, this.picassoCallback);
            ImageView imageView = this.binding.postContentImageView;
            Intrinsics.checkNotNullExpressionValue(imageView, "binding.postContentImageView");
            imageView.setVisibility(0);
            ContentLayout contentLayout = this.binding.postMediaContentLayout;
            Intrinsics.checkNotNullExpressionValue(contentLayout, "binding.postMediaContentLayout");
            contentLayout.setVisibility(0);
        }
    }

    @Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0004\u0018\u00002\u00060\u0001R\u00020\u00022\u00020\u0003B\r\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\b\u0010\t\u001a\u00020\nH\u0016J\b\u0010\u000b\u001a\u00020\fH\u0014J\u0010\u0010\r\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\bH\u0016J\u0010\u0010\u000f\u001a\u00020\f2\u0006\u0010\u0010\u001a\u00020\u0011H\u0016J\b\u0010\u0012\u001a\u00020\fH\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u000e¢\u0006\u0002\n\u0000¨\u0006\u0013"}, mo26107d2 = {"Lcom/memes/plus/ui/posts/PostsLinearAdapter$PostVideoViewHolder;", "Lcom/memes/plus/ui/posts/PostsLinearAdapter$PostViewHolder;", "Lcom/memes/plus/ui/posts/PostsLinearAdapter;", "Lcom/memes/plus/custom/rv_item_visibility_awarance/VisibilityAware;", "binding", "Lcom/memes/plus/databinding/PostItemBinding;", "(Lcom/memes/plus/ui/posts/PostsLinearAdapter;Lcom/memes/plus/databinding/PostItemBinding;)V", "holderVisibility", "", "getVisibilityTargetView", "Landroid/view/View;", "onPostMediaVolumeToggleButtonTapped", "", "onVisibilityChanged", "newVisibility", "setItem", "item", "Lcom/memes/plus/ui/posts/PostBox;", "showVideo", "app_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
    /* renamed from: com.memes.plus.ui.posts.PostsLinearAdapter$PostVideoViewHolder */
    /* compiled from: PostsLinearAdapter.kt */
    public final class PostVideoViewHolder extends PostViewHolder implements VisibilityAware {
        private final PostItemBinding binding;
        private int holderVisibility = 2;
        final /* synthetic */ PostsLinearAdapter this$0;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public PostVideoViewHolder(PostsLinearAdapter postsLinearAdapter, PostItemBinding postItemBinding) {
            super(postsLinearAdapter, postItemBinding);
            Intrinsics.checkNotNullParameter(postItemBinding, "binding");
            this.this$0 = postsLinearAdapter;
            this.binding = postItemBinding;
        }

        public void setItem(PostBox postBox) {
            Intrinsics.checkNotNullParameter(postBox, "item");
            super.setItem(postBox);
            showVideo();
        }

        private final void showVideo() {
            Uri mediaThumbUrl = getPost().mediaThumbUrl();
            Picasso picasso = Picasso.get();
            Intrinsics.checkNotNullExpressionValue(picasso, "Picasso.get()");
            PicassoExtKt.log$default(picasso, (Object) this, mediaThumbUrl != null ? mediaThumbUrl.toString() : null, (String) null, 4, (Object) null).load(mediaThumbUrl).placeholder((int) C4199R.C4201color.primary_background_lighter).error((int) C4199R.C4201color.primary_background_lighter).into(this.binding.postContentImageView);
            SnippetPostMediaProgressBarBinding snippetPostMediaProgressBarBinding = this.binding.includedMediaProgressLayout;
            Intrinsics.checkNotNullExpressionValue(snippetPostMediaProgressBarBinding, "binding.includedMediaProgressLayout");
            LinearLayout root = snippetPostMediaProgressBarBinding.getRoot();
            Intrinsics.checkNotNullExpressionValue(root, "binding.includedMediaProgressLayout.root");
            root.setVisibility(8);
            ImageView imageView = this.binding.postContentImageView;
            Intrinsics.checkNotNullExpressionValue(imageView, "binding.postContentImageView");
            imageView.setVisibility(0);
            PlayerView playerView = this.binding.postContentVideoView;
            Intrinsics.checkNotNullExpressionValue(playerView, "binding.postContentVideoView");
            playerView.setVisibility(0);
            ContentLayout contentLayout = this.binding.postMediaContentLayout;
            Intrinsics.checkNotNullExpressionValue(contentLayout, "binding.postMediaContentLayout");
            contentLayout.setVisibility(0);
            ImageView imageView2 = this.binding.postMediaVolumeToggleButton;
            Intrinsics.checkNotNullExpressionValue(imageView2, "binding.postMediaVolumeToggleButton");
            imageView2.setVisibility(0);
        }

        /* access modifiers changed from: protected */
        public void onPostMediaVolumeToggleButtonTapped() {
            PostsLinearAdapter postsLinearAdapter = this.this$0;
            postsLinearAdapter.isMuted = !postsLinearAdapter.isMuted;
            showMuted(this.this$0.isMuted);
            this.this$0.postActionListener.onPostActionPerformed(new PostAction.TogglePlaybackSoundTapped(this.this$0.isMuted));
        }

        public View getVisibilityTargetView() {
            ContentLayout contentLayout = this.binding.postMediaContentLayout;
            Intrinsics.checkNotNullExpressionValue(contentLayout, "binding.postMediaContentLayout");
            return contentLayout;
        }

        public void onVisibilityChanged(int i) {
            if (i != this.holderVisibility) {
                this.holderVisibility = i;
                if (i == 1) {
                    ExoPlayerHelper access$getExoPlayerHelper$p = this.this$0.exoPlayerHelper;
                    Uri mediaUrl = getPost().mediaUrl();
                    PlayerView playerView = this.binding.postContentVideoView;
                    Intrinsics.checkNotNullExpressionValue(playerView, "binding.postContentVideoView");
                    access$getExoPlayerHelper$p.start(mediaUrl, playerView, this.this$0.playerStateCallback.changeBinding(this.binding));
                    showMuted(this.this$0.isMuted);
                    return;
                }
                this.this$0.exoPlayerHelper.release();
                this.binding.postMediaContentLayout.showContent();
                ImageView imageView = this.binding.postContentImageView;
                Intrinsics.checkNotNullExpressionValue(imageView, "binding.postContentImageView");
                imageView.setVisibility(0);
            }
        }
    }

    @Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010!\n\u0002\u0010\u0000\n\u0000\b\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0003B\r\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u000e\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0012J\u0010\u0010\u0013\u001a\u00020\u00102\u0006\u0010\u0014\u001a\u00020\u0015H\u0016J\u0010\u0010\u0016\u001a\u00020\u00102\u0006\u0010\u0014\u001a\u00020\u0015H\u0016J\u000e\u0010\u0017\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0012J\u0010\u0010\u0018\u001a\u00020\u00102\u0006\u0010\u0019\u001a\u00020\u0002H\u0016J\u0016\u0010\u001a\u001a\u00020\u00102\f\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u001d0\u001cH\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX.¢\u0006\u0002\n\u0000R\u001b\u0010\t\u001a\u00020\n8BX\u0002¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000b\u0010\f¨\u0006\u001e"}, mo26107d2 = {"Lcom/memes/plus/ui/posts/PostsLinearAdapter$PostSuggestionViewHolder;", "Lcom/memes/commons/recycleradapter/BaseViewHolder;", "Lcom/memes/plus/ui/posts/PostBox;", "Lcom/memes/plus/ui/posts/suggestions/PostSuggestedProfilesAdapter$Callback;", "binding", "Lcom/memes/plus/databinding/PostSuggestedProfilesItemBinding;", "(Lcom/memes/plus/ui/posts/PostsLinearAdapter;Lcom/memes/plus/databinding/PostSuggestedProfilesItemBinding;)V", "profileBox", "Lcom/memes/plus/ui/suggestions/SuggestedProfileBox;", "profilesAdapter", "Lcom/memes/plus/ui/posts/suggestions/PostSuggestedProfilesAdapter;", "getProfilesAdapter", "()Lcom/memes/plus/ui/posts/suggestions/PostSuggestedProfilesAdapter;", "profilesAdapter$delegate", "Lkotlin/Lazy;", "addItemTouchListener", "", "listener", "Landroidx/recyclerview/widget/RecyclerView$OnItemTouchListener;", "onFollowSuggestedProfileTapped", "profile", "Lcom/memes/plus/ui/suggestions/SuggestedProfile;", "onSuggestedProfileTapped", "removeItemTouchListener", "setItem", "item", "updateWithPayload", "payloads", "", "", "app_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
    /* renamed from: com.memes.plus.ui.posts.PostsLinearAdapter$PostSuggestionViewHolder */
    /* compiled from: PostsLinearAdapter.kt */
    public final class PostSuggestionViewHolder extends BaseViewHolder<PostBox> implements PostSuggestedProfilesAdapter.Callback {
        private final PostSuggestedProfilesItemBinding binding;
        private SuggestedProfileBox profileBox;
        private final Lazy profilesAdapter$delegate = LazyKt.lazy(new PostsLinearAdapter$PostSuggestionViewHolder$profilesAdapter$2(this));
        final /* synthetic */ PostsLinearAdapter this$0;

        private final PostSuggestedProfilesAdapter getProfilesAdapter() {
            return (PostSuggestedProfilesAdapter) this.profilesAdapter$delegate.getValue();
        }

        /* JADX WARNING: Illegal instructions before constructor call */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public PostSuggestionViewHolder(com.memes.plus.p040ui.posts.PostsLinearAdapter r5, com.memes.plus.databinding.PostSuggestedProfilesItemBinding r6) {
            /*
                r4 = this;
                java.lang.String r0 = "binding"
                kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r6, r0)
                r4.this$0 = r5
                android.widget.LinearLayout r0 = r6.getRoot()
                java.lang.String r1 = "binding.root"
                kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r0, r1)
                android.view.View r0 = (android.view.View) r0
                r4.<init>(r0)
                r4.binding = r6
                com.memes.plus.ui.posts.PostsLinearAdapter$PostSuggestionViewHolder$profilesAdapter$2 r0 = new com.memes.plus.ui.posts.PostsLinearAdapter$PostSuggestionViewHolder$profilesAdapter$2
                r0.<init>(r4)
                kotlin.jvm.functions.Function0 r0 = (kotlin.jvm.functions.Function0) r0
                kotlin.Lazy r0 = kotlin.LazyKt.lazy(r0)
                r4.profilesAdapter$delegate = r0
                android.widget.TextView r0 = r6.seeAllTextView
                java.lang.String r1 = "binding.seeAllTextView"
                kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r0, r1)
                android.view.View r0 = (android.view.View) r0
                r1 = 2131165671(0x7f0701e7, float:1.7945566E38)
                r2 = 0
                r3 = 2
                com.memes.commons.outlineprovider.ViewCornerOutlineProviderKt.roundCorners$default((android.view.View) r0, (int) r1, (com.memes.commons.outlineprovider.ViewCornerOutlineProvider.CornerType) r2, (int) r3, (java.lang.Object) r2)
                android.widget.TextView r0 = r6.seeAllTextView
                com.memes.plus.ui.posts.PostsLinearAdapter$PostSuggestionViewHolder$1 r1 = new com.memes.plus.ui.posts.PostsLinearAdapter$PostSuggestionViewHolder$1
                r1.<init>(r4)
                android.view.View$OnClickListener r1 = (android.view.View.OnClickListener) r1
                r0.setOnClickListener(r1)
                androidx.recyclerview.widget.LinearLayoutManager r0 = new androidx.recyclerview.widget.LinearLayoutManager
                android.content.Context r1 = r5.context
                r2 = 0
                r0.<init>(r1, r2, r2)
                androidx.recyclerview.widget.RecyclerView r1 = r6.profilesRecyclerView
                java.lang.String r3 = "binding.profilesRecyclerView"
                kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r1, r3)
                androidx.recyclerview.widget.RecyclerView$LayoutManager r0 = (androidx.recyclerview.widget.RecyclerView.LayoutManager) r0
                r1.setLayoutManager(r0)
                androidx.recyclerview.widget.RecyclerView r0 = r6.profilesRecyclerView
                kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r0, r3)
                r0.setNestedScrollingEnabled(r2)
                com.memes.plus.ui.posts.suggestions.PostSuggestedProfilesAdapter r0 = r4.getProfilesAdapter()
                r0.clear()
                androidx.recyclerview.widget.RecyclerView r6 = r6.profilesRecyclerView
                kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r6, r3)
                com.memes.plus.ui.posts.suggestions.PostSuggestedProfilesAdapter r0 = r4.getProfilesAdapter()
                androidx.recyclerview.widget.RecyclerView$Adapter r0 = (androidx.recyclerview.widget.RecyclerView.Adapter) r0
                r6.setAdapter(r0)
                com.memes.plus.ui.posts.suggestions.SuggestedProfilesOnItemTouchListener r5 = r5.getSuggestedProfilesOnItemTouchListener()
                androidx.recyclerview.widget.RecyclerView$OnItemTouchListener r5 = (androidx.recyclerview.widget.RecyclerView.OnItemTouchListener) r5
                r4.addItemTouchListener(r5)
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.memes.plus.p040ui.posts.PostsLinearAdapter.PostSuggestionViewHolder.<init>(com.memes.plus.ui.posts.PostsLinearAdapter, com.memes.plus.databinding.PostSuggestedProfilesItemBinding):void");
        }

        public void setItem(PostBox postBox) {
            Intrinsics.checkNotNullParameter(postBox, "item");
            this.profileBox = ((PostBox.SuggestedUsersItem) postBox).getProfileBox();
            PostSuggestedProfilesAdapter profilesAdapter = getProfilesAdapter();
            SuggestedProfileBox suggestedProfileBox = this.profileBox;
            if (suggestedProfileBox == null) {
                Intrinsics.throwUninitializedPropertyAccessException("profileBox");
            }
            profilesAdapter.setItems(suggestedProfileBox.getProfiles());
        }

        public final void addItemTouchListener(RecyclerView.OnItemTouchListener onItemTouchListener) {
            Intrinsics.checkNotNullParameter(onItemTouchListener, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
            this.binding.profilesRecyclerView.addOnItemTouchListener(onItemTouchListener);
        }

        public final void removeItemTouchListener(RecyclerView.OnItemTouchListener onItemTouchListener) {
            Intrinsics.checkNotNullParameter(onItemTouchListener, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
            this.binding.profilesRecyclerView.removeOnItemTouchListener(onItemTouchListener);
        }

        public void updateWithPayload(List<Object> list) {
            Intrinsics.checkNotNullParameter(list, "payloads");
            for (Object next : list) {
                if (next instanceof AdapterViewHolderPayload) {
                    AdapterViewHolderPayload adapterViewHolderPayload = (AdapterViewHolderPayload) next;
                    String key = adapterViewHolderPayload.getKey();
                    if (key.hashCode() == 1210366235 && key.equals(PostsLinearAdapter.PAYLOAD_SUGGESTED_PROFILE_FOLLOW_CHANGE)) {
                        Object value = adapterViewHolderPayload.getValue();
                        Objects.requireNonNull(value, "null cannot be cast to non-null type com.memes.plus.ui.suggestions.SuggestedProfile");
                        getProfilesAdapter().updateFollow((SuggestedProfile) value);
                    }
                }
            }
        }

        public void onSuggestedProfileTapped(SuggestedProfile suggestedProfile) {
            Intrinsics.checkNotNullParameter(suggestedProfile, Scopes.PROFILE);
            this.this$0.postActionListener.onPostActionPerformed(PostAction.ViewProfile.Companion.mo59836of(suggestedProfile));
        }

        public void onFollowSuggestedProfileTapped(SuggestedProfile suggestedProfile) {
            Intrinsics.checkNotNullParameter(suggestedProfile, Scopes.PROFILE);
            this.this$0.postActionListener.onPostActionPerformed(new PostAction.FollowUserTapped(suggestedProfile.requireUserId(), suggestedProfile.getIamFollowing()));
        }
    }

    @Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\b\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\u0010\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0002H\u0016¨\u0006\t"}, mo26107d2 = {"Lcom/memes/plus/ui/posts/PostsLinearAdapter$PostInviteViewHolder;", "Lcom/memes/commons/recycleradapter/BaseViewHolder;", "Lcom/memes/plus/ui/posts/PostBox;", "binding", "Lcom/memes/plus/databinding/PostInviteViewBoxBinding;", "(Lcom/memes/plus/ui/posts/PostsLinearAdapter;Lcom/memes/plus/databinding/PostInviteViewBoxBinding;)V", "setItem", "", "item", "app_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
    /* renamed from: com.memes.plus.ui.posts.PostsLinearAdapter$PostInviteViewHolder */
    /* compiled from: PostsLinearAdapter.kt */
    public final class PostInviteViewHolder extends BaseViewHolder<PostBox> {
        final /* synthetic */ PostsLinearAdapter this$0;

        public void setItem(PostBox postBox) {
            Intrinsics.checkNotNullParameter(postBox, "item");
        }

        /* JADX WARNING: Illegal instructions before constructor call */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public PostInviteViewHolder(com.memes.plus.p040ui.posts.PostsLinearAdapter r2, com.memes.plus.databinding.PostInviteViewBoxBinding r3) {
            /*
                r1 = this;
                java.lang.String r0 = "binding"
                kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r3, r0)
                r1.this$0 = r2
                androidx.cardview.widget.CardView r2 = r3.getRoot()
                java.lang.String r0 = "binding.root"
                kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r2, r0)
                android.view.View r2 = (android.view.View) r2
                r1.<init>(r2)
                com.memes.plus.ui.posts.PostsLinearAdapter$PostInviteViewHolder$1 r2 = new com.memes.plus.ui.posts.PostsLinearAdapter$PostInviteViewHolder$1
                r2.<init>(r1)
                android.view.View$OnClickListener r2 = (android.view.View.OnClickListener) r2
                android.widget.Button r0 = r3.inviteButton
                r0.setOnClickListener(r2)
                android.widget.RelativeLayout r0 = r3.parentViewLayout
                r0.setOnClickListener(r2)
                android.widget.ImageView r2 = r3.closeInviteImageView
                com.memes.plus.ui.posts.PostsLinearAdapter$PostInviteViewHolder$3 r3 = new com.memes.plus.ui.posts.PostsLinearAdapter$PostInviteViewHolder$3
                r3.<init>(r1)
                android.view.View$OnClickListener r3 = (android.view.View.OnClickListener) r3
                r2.setOnClickListener(r3)
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.memes.plus.p040ui.posts.PostsLinearAdapter.PostInviteViewHolder.<init>(com.memes.plus.ui.posts.PostsLinearAdapter, com.memes.plus.databinding.PostInviteViewBoxBinding):void");
        }
    }

    @Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\b\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\u0010\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u0002H\u0016R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u000e\u0010\b\u001a\u00020\tX.¢\u0006\u0002\n\u0000¨\u0006\r"}, mo26107d2 = {"Lcom/memes/plus/ui/posts/PostsLinearAdapter$AppRatingItemHolder;", "Lcom/memes/commons/recycleradapter/BaseViewHolder;", "Lcom/memes/plus/ui/posts/PostBox;", "binding", "Lcom/memes/plus/databinding/AppRatingRequestItemBinding;", "(Lcom/memes/plus/ui/posts/PostsLinearAdapter;Lcom/memes/plus/databinding/AppRatingRequestItemBinding;)V", "getBinding", "()Lcom/memes/plus/databinding/AppRatingRequestItemBinding;", "ratingRequest", "Lcom/memes/plus/ui/apprating/AppRatingRequest;", "setItem", "", "item", "app_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
    /* renamed from: com.memes.plus.ui.posts.PostsLinearAdapter$AppRatingItemHolder */
    /* compiled from: PostsLinearAdapter.kt */
    public final class AppRatingItemHolder extends BaseViewHolder<PostBox> {
        private final AppRatingRequestItemBinding binding;
        private AppRatingRequest ratingRequest;
        final /* synthetic */ PostsLinearAdapter this$0;

        /* JADX WARNING: Illegal instructions before constructor call */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public AppRatingItemHolder(com.memes.plus.p040ui.posts.PostsLinearAdapter r2, com.memes.plus.databinding.AppRatingRequestItemBinding r3) {
            /*
                r1 = this;
                java.lang.String r0 = "binding"
                kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r3, r0)
                r1.this$0 = r2
                androidx.constraintlayout.widget.ConstraintLayout r2 = r3.getRoot()
                java.lang.String r0 = "binding.root"
                kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r2, r0)
                android.view.View r2 = (android.view.View) r2
                r1.<init>(r2)
                r1.binding = r3
                android.widget.Button r2 = r3.addReviewButton
                com.memes.plus.ui.posts.PostsLinearAdapter$AppRatingItemHolder$1 r3 = new com.memes.plus.ui.posts.PostsLinearAdapter$AppRatingItemHolder$1
                r3.<init>(r1)
                android.view.View$OnClickListener r3 = (android.view.View.OnClickListener) r3
                r2.setOnClickListener(r3)
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.memes.plus.p040ui.posts.PostsLinearAdapter.AppRatingItemHolder.<init>(com.memes.plus.ui.posts.PostsLinearAdapter, com.memes.plus.databinding.AppRatingRequestItemBinding):void");
        }

        public final AppRatingRequestItemBinding getBinding() {
            return this.binding;
        }

        public void setItem(PostBox postBox) {
            Intrinsics.checkNotNullParameter(postBox, "item");
            this.ratingRequest = ((PostBox.AppRatingItem) postBox).getAppRatingRequest();
            UserAvatarView userAvatarView = this.binding.profileImageView;
            AppRatingRequest appRatingRequest = this.ratingRequest;
            if (appRatingRequest == null) {
                Intrinsics.throwUninitializedPropertyAccessException("ratingRequest");
            }
            UserAvatarView.loadUrl$default(userAvatarView, appRatingRequest.getProfilePic(), C4199R.C4202drawable.placeholder_profile, (Integer) null, 4, (Object) null);
            TextView textView = this.binding.reviewHeadingTextView;
            Intrinsics.checkNotNullExpressionValue(textView, "binding.reviewHeadingTextView");
            AppRatingRequest appRatingRequest2 = this.ratingRequest;
            if (appRatingRequest2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("ratingRequest");
            }
            textView.setText(ExtensionsKt.encode(appRatingRequest2.getMemerText()));
        }
    }

    @Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\b\u0004\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0012\u0010\u0005\u001a\u00060\u0000R\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u0004J\u0010\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0016J\u0018\u0010\u000b\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fH\u0016R\u000e\u0010\u0003\u001a\u00020\u0004X.¢\u0006\u0002\n\u0000¨\u0006\u0010"}, mo26107d2 = {"Lcom/memes/plus/ui/posts/PostsLinearAdapter$PlayerStateCallback;", "Lcom/memes/plus/custom/player/PlayerEventListenerAdapter;", "(Lcom/memes/plus/ui/posts/PostsLinearAdapter;)V", "binding", "Lcom/memes/plus/databinding/PostItemBinding;", "changeBinding", "Lcom/memes/plus/ui/posts/PostsLinearAdapter;", "onPlayerError", "", "playbackException", "Lcom/google/android/exoplayer2/ExoPlaybackException;", "onPlayerStateChanged", "playWhenReady", "", "playbackState", "", "app_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
    /* renamed from: com.memes.plus.ui.posts.PostsLinearAdapter$PlayerStateCallback */
    /* compiled from: PostsLinearAdapter.kt */
    public final class PlayerStateCallback extends PlayerEventListenerAdapter {
        private PostItemBinding binding;

        public PlayerStateCallback() {
        }

        public final PlayerStateCallback changeBinding(PostItemBinding postItemBinding) {
            Intrinsics.checkNotNullParameter(postItemBinding, "binding");
            this.binding = postItemBinding;
            return this;
        }

        public void onPlayerError(ExoPlaybackException exoPlaybackException) {
            Intrinsics.checkNotNullParameter(exoPlaybackException, "playbackException");
            String str = "Error occurred while playing media: " + exoPlaybackException.getMessage();
            PostItemBinding postItemBinding = this.binding;
            if (postItemBinding == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
            }
            TextView textView = postItemBinding.postContentIdentifierView;
            Intrinsics.checkNotNullExpressionValue(textView, "binding.postContentIdentifierView");
            textView.setText(str);
            PostItemBinding postItemBinding2 = this.binding;
            if (postItemBinding2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
            }
            TextView textView2 = postItemBinding2.postContentIdentifierView;
            Intrinsics.checkNotNullExpressionValue(textView2, "binding.postContentIdentifierView");
            textView2.setVisibility(0);
            PostItemBinding postItemBinding3 = this.binding;
            if (postItemBinding3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
            }
            postItemBinding3.postMediaContentLayout.showContentNotAvailable(str);
        }

        public void onPlayerStateChanged(boolean z, int i) {
            PostItemBinding postItemBinding = this.binding;
            if (postItemBinding == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
            }
            postItemBinding.postMediaContentLayout.showContent();
            PostItemBinding postItemBinding2 = this.binding;
            if (postItemBinding2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
            }
            TextView textView = postItemBinding2.postContentIdentifierView;
            Intrinsics.checkNotNullExpressionValue(textView, "binding.postContentIdentifierView");
            textView.setVisibility(8);
            if (i == 2) {
                PostItemBinding postItemBinding3 = this.binding;
                if (postItemBinding3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("binding");
                }
                ContentLayout.showProgress$default(postItemBinding3.postMediaContentLayout, (String) null, 1, (Object) null);
            }
            if (i == 3 && z) {
                PostItemBinding postItemBinding4 = this.binding;
                if (postItemBinding4 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("binding");
                }
                ImageView imageView = postItemBinding4.postContentImageView;
                Intrinsics.checkNotNullExpressionValue(imageView, "binding.postContentImageView");
                imageView.setVisibility(8);
                PostItemBinding postItemBinding5 = this.binding;
                if (postItemBinding5 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("binding");
                }
                postItemBinding5.postMediaContentLayout.showContent();
            }
        }
    }

    public final void pausePlayer() {
        this.exoPlayerHelper.pause();
    }

    public final void resumePlayer() {
        this.exoPlayerHelper.resume();
    }

    public final void releasePlayer() {
        this.exoPlayerHelper.release();
    }

    public final void consume(FollowUserResult followUserResult) {
        Intrinsics.checkNotNullParameter(followUserResult, "result");
        String userId = followUserResult.getUserId();
        CharSequence charSequence = userId;
        if (!(charSequence == null || StringsKt.isBlank(charSequence))) {
            consume(new UserFollowEvent(userId, followUserResult.getFollowed(), followUserResult.getFollowerCount()));
        }
    }

    public final void consume(boolean z) {
        this.isMuted = z;
        int i = 0;
        for (PostBox postBox : getItems()) {
            if (postBox instanceof PostBox.PostItem) {
                ((PostBox.PostItem) postBox).getPost();
                notifyItemChanged(i, new AdapterViewHolderPayload(PAYLOAD_PLAYBACK_SOUND_MUTED, (Object) null));
            }
            i++;
        }
    }

    public void onViewRecycled(BaseViewHolder<PostBox> baseViewHolder) {
        Intrinsics.checkNotNullParameter(baseViewHolder, "holder");
        if (baseViewHolder instanceof VisibilityAware) {
            ((VisibilityAware) baseViewHolder).onVisibilityChanged(2);
        }
        if (baseViewHolder instanceof PostSuggestionViewHolder) {
            ((PostSuggestionViewHolder) baseViewHolder).removeItemTouchListener(getSuggestedProfilesOnItemTouchListener());
        }
    }

    public final void updateLikedFlag(Post post) {
        boolean z;
        Intrinsics.checkNotNullParameter(post, "updatedPost");
        int i = 0;
        for (PostBox postBox : getItems()) {
            if (postBox instanceof PostBox.PostItem) {
                if (Intrinsics.areEqual((Object) ((PostBox.PostItem) postBox).getPost().getPostId(), (Object) post.getPostId())) {
                    notifyItemChanged(i, new AdapterViewHolderPayload("payload_like_change", post));
                    z = true;
                } else {
                    z = false;
                }
                if (z) {
                    return;
                }
            }
            i++;
        }
    }

    public final void updateSavedStatus(Post post) {
        boolean z;
        Intrinsics.checkNotNullParameter(post, "updatedPost");
        int i = 0;
        for (PostBox postBox : getItems()) {
            if (postBox instanceof PostBox.PostItem) {
                if (Intrinsics.areEqual((Object) ((PostBox.PostItem) postBox).getPost().getPostId(), (Object) post.getPostId())) {
                    notifyItemChanged(i, new AdapterViewHolderPayload(PAYLOAD_SAVE_CHANGE, post));
                    z = true;
                } else {
                    z = false;
                }
                if (z) {
                    return;
                }
            }
            i++;
        }
    }

    public final void consume(PostDeleteResult postDeleteResult) {
        boolean z;
        Intrinsics.checkNotNullParameter(postDeleteResult, "result");
        int i = 0;
        for (PostBox postBox : getItems()) {
            if (postBox instanceof PostBox.PostItem) {
                if (Intrinsics.areEqual((Object) ((PostBox.PostItem) postBox).getPost().getPostId(), (Object) postDeleteResult.getPostId())) {
                    removeItemAt(i);
                    z = true;
                } else {
                    z = false;
                }
                if (z) {
                    return;
                }
            }
            i++;
        }
    }

    public final void consume(PostNotificationsSubscriptionEvent postNotificationsSubscriptionEvent) {
        Intrinsics.checkNotNullParameter(postNotificationsSubscriptionEvent, "result");
        for (PostBox postBox : getItems()) {
            if (postBox instanceof PostBox.PostItem) {
                Post post = ((PostBox.PostItem) postBox).getPost();
                if (Intrinsics.areEqual((Object) post.getUserId(), (Object) postNotificationsSubscriptionEvent.getUserId())) {
                    post.setNotificationsEnabled(postNotificationsSubscriptionEvent.getEnabled());
                }
            }
        }
    }

    public final void consume(UserFollowEvent userFollowEvent) {
        Intrinsics.checkNotNullParameter(userFollowEvent, "event");
        int i = 0;
        int i2 = 0;
        for (PostBox postBox : getItems()) {
            if (postBox instanceof PostBox.PostItem) {
                Post post = ((PostBox.PostItem) postBox).getPost();
                if (Intrinsics.areEqual((Object) post.getUserId(), (Object) userFollowEvent.getUserId())) {
                    post.setIamfollowing(userFollowEvent.getFollowed());
                    notifyItemChanged(i2, new AdapterViewHolderPayload(PAYLOAD_FOLLOW_CHANGE, post));
                }
            }
            i2++;
        }
        for (PostBox postBox2 : getItems()) {
            if (postBox2 instanceof PostBox.SuggestedUsersItem) {
                for (SuggestedProfile next : ((PostBox.SuggestedUsersItem) postBox2).getProfileBox().getProfiles()) {
                    if (Intrinsics.areEqual((Object) next.getUserId(), (Object) userFollowEvent.getUserId())) {
                        next.setIamFollowing(userFollowEvent.getFollowed());
                        notifyItemChanged(i, new AdapterViewHolderPayload(PAYLOAD_SUGGESTED_PROFILE_FOLLOW_CHANGE, next));
                    }
                }
            }
            i++;
        }
    }

    public final void consume(PostCommentEvent postCommentEvent) {
        boolean z;
        Intrinsics.checkNotNullParameter(postCommentEvent, "event");
        int i = 0;
        for (PostBox postBox : getItems()) {
            if (postBox instanceof PostBox.PostItem) {
                Post post = ((PostBox.PostItem) postBox).getPost();
                if (Intrinsics.areEqual((Object) post.getPostId(), (Object) postCommentEvent.getPostId())) {
                    post.setTotalComments(post.getTotalComments() + 1);
                    notifyItemChanged(i, new AdapterViewHolderPayload(PAYLOAD_COMMENT_UPDATE, Long.valueOf(post.getTotalComments())));
                    z = true;
                } else {
                    z = false;
                }
                if (z) {
                    return;
                }
            }
            i++;
        }
    }

    public final void consume(PostPreviewCommentEvent postPreviewCommentEvent) {
        boolean z;
        List list;
        Intrinsics.checkNotNullParameter(postPreviewCommentEvent, "event");
        int i = 0;
        for (PostBox postBox : getItems()) {
            if (postBox instanceof PostBox.PostItem) {
                Post post = ((PostBox.PostItem) postBox).getPost();
                if (Intrinsics.areEqual((Object) post.getPostId(), (Object) postPreviewCommentEvent.getComment().getPostId())) {
                    List<PostPreviewComment> comments = post.getComments();
                    if (comments == null || (list = CollectionsKt.toMutableList(comments)) == null) {
                        list = new ArrayList();
                    }
                    PostPreviewComment comment = postPreviewCommentEvent.getComment();
                    Iterator it = list.iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            break;
                        }
                        PostPreviewComment postPreviewComment = (PostPreviewComment) it.next();
                        if (Intrinsics.areEqual((Object) postPreviewComment.getCommentId(), (Object) comment.getCommentId())) {
                            list.remove(postPreviewComment);
                            break;
                        }
                    }
                    list.add(0, postPreviewCommentEvent.getComment());
                    post.setComments(list);
                    notifyItemChanged(i, new AdapterViewHolderPayload(PAYLOAD_PREVIEW_COMMENT, post));
                    z = true;
                } else {
                    z = false;
                }
                if (z) {
                    return;
                }
            }
            i++;
        }
    }

    public final void consume(PostPreviewComment postPreviewComment) {
        boolean z;
        List list;
        Intrinsics.checkNotNullParameter(postPreviewComment, "postPreviewComment");
        int i = 0;
        for (PostBox postBox : getItems()) {
            if (postBox instanceof PostBox.PostItem) {
                Post post = ((PostBox.PostItem) postBox).getPost();
                if (Intrinsics.areEqual((Object) post.getPostId(), (Object) postPreviewComment.getPostId())) {
                    List<PostPreviewComment> comments = post.getComments();
                    if (comments == null || (list = CollectionsKt.toMutableList(comments)) == null) {
                        list = new ArrayList();
                    }
                    Iterator it = list.iterator();
                    int i2 = 0;
                    while (true) {
                        if (!it.hasNext()) {
                            break;
                        } else if (Intrinsics.areEqual((Object) ((PostPreviewComment) it.next()).getCommentId(), (Object) postPreviewComment.getCommentId())) {
                            list.set(i2, postPreviewComment);
                            post.setComments(list);
                            notifyItemChanged(i, new AdapterViewHolderPayload(PAYLOAD_PREVIEW_COMMENT, post));
                            break;
                        } else {
                            i2++;
                        }
                    }
                    z = true;
                } else {
                    z = false;
                }
                if (z) {
                    return;
                }
            }
            i++;
        }
    }

    public final void consume(PostCommentDeleteEvent postCommentDeleteEvent) {
        boolean z;
        Intrinsics.checkNotNullParameter(postCommentDeleteEvent, "event");
        int i = 0;
        for (PostBox postBox : getItems()) {
            if (postBox instanceof PostBox.PostItem) {
                Post post = ((PostBox.PostItem) postBox).getPost();
                if (Intrinsics.areEqual((Object) post.getPostId(), (Object) postCommentDeleteEvent.getPostId())) {
                    post.setTotalComments(post.getTotalComments() - ((long) postCommentDeleteEvent.getCommentsToDeleteCount()));
                    notifyItemChanged(i, new AdapterViewHolderPayload(PAYLOAD_COMMENT_UPDATE, Long.valueOf(post.getTotalComments())));
                    z = true;
                } else {
                    z = false;
                }
                if (z) {
                    return;
                }
            }
            i++;
        }
    }

    public final void consume(PostDeletedEvent postDeletedEvent) {
        boolean z;
        Intrinsics.checkNotNullParameter(postDeletedEvent, "event");
        int i = 0;
        for (PostBox postBox : getItems()) {
            if (postBox instanceof PostBox.PostItem) {
                if (Intrinsics.areEqual((Object) ((PostBox.PostItem) postBox).getPost().getPostId(), (Object) postDeletedEvent.getPostId())) {
                    removeItemAt(i);
                    z = true;
                } else {
                    z = false;
                }
                if (z) {
                    return;
                }
            }
            i++;
        }
    }

    public final void consume(PostEditedEvent postEditedEvent) {
        boolean z;
        Intrinsics.checkNotNullParameter(postEditedEvent, "event");
        int i = 0;
        for (PostBox postBox : getItems()) {
            if (postBox instanceof PostBox.PostItem) {
                Post post = ((PostBox.PostItem) postBox).getPost();
                if (Intrinsics.areEqual((Object) post.getPostId(), (Object) postEditedEvent.getPostId())) {
                    post.setPostText(postEditedEvent.getPostText());
                    post.setTagged(postEditedEvent.isTagged());
                    notifyItemChanged(i);
                    z = true;
                } else {
                    z = false;
                }
                if (z) {
                    return;
                }
            }
            i++;
        }
    }
}
