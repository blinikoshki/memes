package com.memes.plus.p040ui.posts;

import android.content.Context;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import com.google.android.gms.common.Scopes;
import com.livinglifetechway.quickpermissions_kotlin.PermissionsManagerKt;
import com.livinglifetechway.quickpermissions_kotlin.util.QuickPermissionsOptions;
import com.memes.commons.choices.Choice;
import com.memes.commons.choices.ChoicesBottomSheet;
import com.memes.commons.util.ExtensionsKt;
import com.memes.eventtracker.tracking.EventTrackingManager;
import com.memes.network.core.ResultState;
import com.memes.plus.App;
import com.memes.plus.base.ActivityHandle;
import com.memes.plus.base.BaseFragment;
import com.memes.plus.integrations.facebook.FacebookIntegrationViewModel;
import com.memes.plus.p040ui.create_post.tagpeople.TagPeopleActivity;
import com.memes.plus.p040ui.post_comments.PostCommentAction;
import com.memes.plus.p040ui.post_comments.PostCommentsActivity;
import com.memes.plus.p040ui.posts.commentpreviewbox.PostPreviewComment;
import com.memes.plus.p040ui.posts.post_basics.PostOperationsViewModel;
import com.memes.plus.p040ui.posts.post_basics.post_options.PostOption;
import com.memes.plus.p040ui.posts.post_basics.post_options.PostOptionsSelectionHandler;
import com.memes.plus.p040ui.posts.post_basics.post_save.PostSaveOptionSelectionHandler;
import com.memes.plus.p040ui.posts.post_basics.post_save.PostSaveOptionsBottomSheet;
import com.memes.plus.p040ui.posts.post_tags_dialog.PostTaggedUser;
import com.memes.plus.p040ui.posts.post_tags_dialog.PostTaggedUsersDialogCallBack;
import com.memes.plus.p040ui.posts.post_tags_dialog.PostTaggedUsersDialogFragment;
import com.memes.plus.p040ui.profile.ProfileFragmentProxy;
import com.memes.plus.p040ui.suggestions.SuggestedProfile;
import com.memes.plus.p040ui.tagged_posts.TaggedPostsFragment;
import com.memes.plus.p040ui.user_listing.UserListingFragment;
import com.memes.plus.util.Constants;
import java.util.List;
import java.util.Objects;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import timber.log.Timber;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0010\u0003\u0004\u0005\u0006\u0007\b\t\n\u000b\f\r\u000e\u000f\u0010\u0011\u0012B\u0007\b\u0002¢\u0006\u0002\u0010\u0002\u0001\u000e\u0013\u0014\u0015\u0016\u0017\u0018\u0019\u001a\u001b\u001c\u001d\u001e\u001f ¨\u0006!"}, mo26107d2 = {"Lcom/memes/plus/ui/posts/PostAction;", "", "()V", "AddCommentTapped", "FollowUserTapped", "Handler", "HighlightedTextTapped", "LikeCommentTapped", "LikeCountTapped", "LikeTapped", "Listener", "OptionsTapped", "SaveTapped", "ShareTapped", "TogglePlaybackSoundTapped", "ViewComments", "ViewProfile", "ViewSuggestedUsers", "ViewTaggedPeople", "Lcom/memes/plus/ui/posts/PostAction$FollowUserTapped;", "Lcom/memes/plus/ui/posts/PostAction$HighlightedTextTapped;", "Lcom/memes/plus/ui/posts/PostAction$LikeTapped;", "Lcom/memes/plus/ui/posts/PostAction$LikeCountTapped;", "Lcom/memes/plus/ui/posts/PostAction$SaveTapped;", "Lcom/memes/plus/ui/posts/PostAction$ShareTapped;", "Lcom/memes/plus/ui/posts/PostAction$OptionsTapped;", "Lcom/memes/plus/ui/posts/PostAction$AddCommentTapped;", "Lcom/memes/plus/ui/posts/PostAction$LikeCommentTapped;", "Lcom/memes/plus/ui/posts/PostAction$TogglePlaybackSoundTapped;", "Lcom/memes/plus/ui/posts/PostAction$ViewProfile;", "Lcom/memes/plus/ui/posts/PostAction$ViewTaggedPeople;", "Lcom/memes/plus/ui/posts/PostAction$ViewComments;", "Lcom/memes/plus/ui/posts/PostAction$ViewSuggestedUsers;", "app_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
/* renamed from: com.memes.plus.ui.posts.PostAction */
/* compiled from: PostAction.kt */
public abstract class PostAction {

    @Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H&¨\u0006\u0006"}, mo26107d2 = {"Lcom/memes/plus/ui/posts/PostAction$Listener;", "", "onPostActionPerformed", "", "action", "Lcom/memes/plus/ui/posts/PostAction;", "app_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
    /* renamed from: com.memes.plus.ui.posts.PostAction$Listener */
    /* compiled from: PostAction.kt */
    public interface Listener {
        void onPostActionPerformed(PostAction postAction);
    }

    private PostAction() {
    }

    public /* synthetic */ PostAction(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    @Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0000\u0018\u00002\u00020\u00012\u00020\u0002B)\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\n\u0010\u0005\u001a\u0006\u0012\u0002\b\u00030\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\n¢\u0006\u0002\u0010\u000bJ\u0012\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015H\u0016J\u0010\u0010\u0016\u001a\u00020\u00132\u0006\u0010\u0017\u001a\u00020\u0018H\u0016J\u001a\u0010\u0019\u001a\u00020\u00132\u0012\u0010\u001a\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00180\u001c0\u001bR\u000e\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0004¢\u0006\u0002\n\u0000R\u0012\u0010\u0005\u001a\u0006\u0012\u0002\b\u00030\u0006X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0004¢\u0006\u0002\n\u0000R\u001b\u0010\f\u001a\u00020\r8BX\u0002¢\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u001d"}, mo26107d2 = {"Lcom/memes/plus/ui/posts/PostAction$Handler;", "Lcom/memes/plus/ui/posts/PostAction$Listener;", "Lcom/memes/plus/ui/posts/post_tags_dialog/PostTaggedUsersDialogCallBack;", "context", "Landroid/content/Context;", "fragment", "Lcom/memes/plus/base/BaseFragment;", "postOperationsViewModel", "Lcom/memes/plus/ui/posts/post_basics/PostOperationsViewModel;", "facebookIntegrationViewModel", "Lcom/memes/plus/integrations/facebook/FacebookIntegrationViewModel;", "(Landroid/content/Context;Lcom/memes/plus/base/BaseFragment;Lcom/memes/plus/ui/posts/post_basics/PostOperationsViewModel;Lcom/memes/plus/integrations/facebook/FacebookIntegrationViewModel;)V", "postOptionsSelectionHandler", "Lcom/memes/plus/ui/posts/post_basics/post_options/PostOptionsSelectionHandler;", "getPostOptionsSelectionHandler", "()Lcom/memes/plus/ui/posts/post_basics/post_options/PostOptionsSelectionHandler;", "postOptionsSelectionHandler$delegate", "Lkotlin/Lazy;", "onPostActionPerformed", "", "action", "Lcom/memes/plus/ui/posts/PostAction;", "onViewProfilePageTapped", "taggedUser", "Lcom/memes/plus/ui/posts/post_tags_dialog/PostTaggedUser;", "setTaggedUsersResultState", "resultState", "Lcom/memes/network/core/ResultState;", "", "app_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
    /* renamed from: com.memes.plus.ui.posts.PostAction$Handler */
    /* compiled from: PostAction.kt */
    public static final class Handler implements Listener, PostTaggedUsersDialogCallBack {
        /* access modifiers changed from: private */
        public final Context context;
        /* access modifiers changed from: private */
        public final FacebookIntegrationViewModel facebookIntegrationViewModel;
        private final BaseFragment<?> fragment;
        /* access modifiers changed from: private */
        public final PostOperationsViewModel postOperationsViewModel;
        private final Lazy postOptionsSelectionHandler$delegate = LazyKt.lazy(new PostAction$Handler$postOptionsSelectionHandler$2(this));

        /* access modifiers changed from: private */
        public final PostOptionsSelectionHandler getPostOptionsSelectionHandler() {
            return (PostOptionsSelectionHandler) this.postOptionsSelectionHandler$delegate.getValue();
        }

        public Handler(Context context2, BaseFragment<?> baseFragment, PostOperationsViewModel postOperationsViewModel2, FacebookIntegrationViewModel facebookIntegrationViewModel2) {
            Intrinsics.checkNotNullParameter(context2, "context");
            Intrinsics.checkNotNullParameter(baseFragment, "fragment");
            Intrinsics.checkNotNullParameter(postOperationsViewModel2, "postOperationsViewModel");
            Intrinsics.checkNotNullParameter(facebookIntegrationViewModel2, "facebookIntegrationViewModel");
            this.context = context2;
            this.fragment = baseFragment;
            this.postOperationsViewModel = postOperationsViewModel2;
            this.facebookIntegrationViewModel = facebookIntegrationViewModel2;
        }

        public void onPostActionPerformed(PostAction postAction) {
            if (postAction instanceof AddCommentTapped) {
                this.context.startActivity(PostCommentsActivity.Companion.getStartIntent(this.context, ((AddCommentTapped) postAction).getPost().requirePostId(), PostCommentAction.Companion.ofAddComment()));
            } else if (postAction instanceof FollowUserTapped) {
                FollowUserTapped followUserTapped = (FollowUserTapped) postAction;
                if (followUserTapped.isFollowing()) {
                    this.postOperationsViewModel.unfollowUser(followUserTapped.getUserId());
                } else {
                    this.postOperationsViewModel.followUser(followUserTapped.getUserId());
                }
            } else {
                String str = null;
                boolean z = false;
                if (postAction instanceof HighlightedTextTapped) {
                    HighlightedTextTapped highlightedTextTapped = (HighlightedTextTapped) postAction;
                    String matchedText = highlightedTextTapped.getMatchedText();
                    Objects.requireNonNull(matchedText, "null cannot be cast to non-null type java.lang.String");
                    String substring = matchedText.substring(1);
                    Intrinsics.checkNotNullExpressionValue(substring, "(this as java.lang.String).substring(startIndex)");
                    if (highlightedTextTapped.isForHashTag()) {
                        App.Companion.trackingManager().onHashTagTapped(substring);
                        ActivityHandle.DefaultImpls.replaceFragment$default(this.fragment.getActivityHandle(), TaggedPostsFragment.Companion.newInstance(substring), TaggedPostsFragment.TAG, false, 4, (Object) null);
                    } else if (highlightedTextTapped.isForUserMention()) {
                        App.Companion.trackingManager().onUserMentionTapped(substring);
                        ActivityHandle.DefaultImpls.replaceFragment$default(this.fragment.getActivityHandle(), ProfileFragmentProxy.INSTANCE.newInstance((String) null, substring), ProfileFragmentProxy.TAG, false, 4, (Object) null);
                    } else {
                        Timber.m303e("Unhandled HighlightedTextTapped action: " + postAction, new Object[0]);
                    }
                } else if (postAction instanceof LikeCommentTapped) {
                    LikeCommentTapped likeCommentTapped = (LikeCommentTapped) postAction;
                    Post post = likeCommentTapped.getPost();
                    PostPreviewComment comment = likeCommentTapped.getComment();
                    EventTrackingManager trackingManager = App.Companion.trackingManager();
                    CharSequence imageUrl = comment.getImageUrl();
                    if (imageUrl == null || StringsKt.isBlank(imageUrl)) {
                        z = true;
                    }
                    trackingManager.onCommentLiked(!z, post.getPostId(), comment.getCommentId());
                    comment.setPostId(post.getPostId());
                    this.postOperationsViewModel.toggleCommentLike(post, comment);
                } else if (postAction instanceof LikeCountTapped) {
                    ActivityHandle.DefaultImpls.replaceFragment$default(this.fragment.getActivityHandle(), UserListingFragment.Companion.newPostLikeUsersInstance(((LikeCountTapped) postAction).getPost().requirePostId()), UserListingFragment.TAG, false, 4, (Object) null);
                } else if (postAction instanceof LikeTapped) {
                    this.postOperationsViewModel.togglePostLike(((LikeTapped) postAction).getPost());
                } else if (postAction instanceof OptionsTapped) {
                    Post post2 = ((OptionsTapped) postAction).getPost();
                    App.Companion.trackingManager().onPostOptionsIconTapped(post2.getPostId());
                    List<Choice> createForPost = PostOption.Companion.createForPost(post2);
                    ChoicesBottomSheet choicesBottomSheet = new ChoicesBottomSheet();
                    FragmentManager childFragmentManager = this.fragment.getChildFragmentManager();
                    Intrinsics.checkNotNullExpressionValue(childFragmentManager, "fragment.childFragmentManager");
                    choicesBottomSheet.show(childFragmentManager, createForPost, new PostAction$Handler$onPostActionPerformed$1(this, post2));
                } else if (postAction instanceof SaveTapped) {
                    Post post3 = ((SaveTapped) postAction).getPost();
                    PostSaveOptionsBottomSheet postSaveOptionsBottomSheet = new PostSaveOptionsBottomSheet();
                    FragmentManager childFragmentManager2 = this.fragment.getChildFragmentManager();
                    Intrinsics.checkNotNullExpressionValue(childFragmentManager2, "fragment.childFragmentManager");
                    postSaveOptionsBottomSheet.show(childFragmentManager2, new PostSaveOptionSelectionHandler(this.postOperationsViewModel, post3), post3);
                } else if (postAction instanceof ShareTapped) {
                    Post post4 = ((ShareTapped) postAction).getPost();
                    App.Companion.trackingManager().onPostShareButtonTapped(post4.getPostId());
                    PermissionsManagerKt.runWithPermissions$default(this.context, new String[]{"android.permission.WRITE_EXTERNAL_STORAGE"}, (QuickPermissionsOptions) null, (Function0) new PostAction$Handler$onPostActionPerformed$2(this, post4), 2, (Object) null);
                } else if (postAction instanceof TogglePlaybackSoundTapped) {
                    this.postOperationsViewModel.updatePlaybackSoundSetting(((TogglePlaybackSoundTapped) postAction).isMuted());
                } else if (postAction instanceof ViewComments) {
                    ViewComments viewComments = (ViewComments) postAction;
                    PostPreviewComment targetComment = viewComments.getTargetComment();
                    if (targetComment != null) {
                        str = targetComment.getCommentId();
                    }
                    this.context.startActivity(PostCommentsActivity.Companion.getStartIntent(this.context, viewComments.getPost().requirePostId(), PostCommentAction.Companion.ofViewComment(str)));
                } else if (postAction instanceof ViewProfile) {
                    ViewProfile viewProfile = (ViewProfile) postAction;
                    App.Companion.trackingManager().onPostProfilePicTapped(viewProfile.getPostId(), viewProfile.getUserId());
                    ActivityHandle.DefaultImpls.replaceFragment$default(this.fragment.getActivityHandle(), ProfileFragmentProxy.INSTANCE.newInstance(viewProfile.getUserId(), viewProfile.getUserName()), ProfileFragmentProxy.TAG, false, 4, (Object) null);
                } else if (postAction instanceof ViewSuggestedUsers) {
                    ActivityHandle.DefaultImpls.replaceFragment$default(this.fragment.getActivityHandle(), UserListingFragment.Companion.newSuggestionUsersInstance(), UserListingFragment.TAG, false, 4, (Object) null);
                } else if (postAction instanceof ViewTaggedPeople) {
                    PostTaggedUsersDialogFragment postTaggedUsersDialogFragment = new PostTaggedUsersDialogFragment();
                    FragmentManager parentFragmentManager = this.fragment.getParentFragmentManager();
                    Intrinsics.checkNotNullExpressionValue(parentFragmentManager, "fragment.parentFragmentManager");
                    postTaggedUsersDialogFragment.show(parentFragmentManager, this);
                    this.postOperationsViewModel.fetchPostTaggedUsers(((ViewTaggedPeople) postAction).getPost());
                } else if (postAction == null) {
                    ExtensionsKt.toast(this.context, Constants.UNUSUAL_ERROR);
                }
            }
        }

        public void onViewProfilePageTapped(PostTaggedUser postTaggedUser) {
            Intrinsics.checkNotNullParameter(postTaggedUser, "taggedUser");
            onPostActionPerformed(new ViewProfile(postTaggedUser.requireUserId(), postTaggedUser.requireUserName(), postTaggedUser.requirePostId()));
        }

        public final void setTaggedUsersResultState(ResultState<? extends List<PostTaggedUser>> resultState) {
            Intrinsics.checkNotNullParameter(resultState, "resultState");
            Fragment findFragmentByTag = this.fragment.getParentFragmentManager().findFragmentByTag(PostTaggedUsersDialogFragment.TAG);
            if (!(findFragmentByTag instanceof PostTaggedUsersDialogFragment)) {
                findFragmentByTag = null;
            }
            PostTaggedUsersDialogFragment postTaggedUsersDialogFragment = (PostTaggedUsersDialogFragment) findFragmentByTag;
            if (postTaggedUsersDialogFragment != null && postTaggedUsersDialogFragment.isVisible()) {
                postTaggedUsersDialogFragment.update(resultState);
            }
        }
    }

    @Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\t\u0010\n\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000b\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\r\u001a\u00020\u00052\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fHÖ\u0003J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001J\t\u0010\u0012\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0004\u0010\u0007R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\t¨\u0006\u0013"}, mo26107d2 = {"Lcom/memes/plus/ui/posts/PostAction$FollowUserTapped;", "Lcom/memes/plus/ui/posts/PostAction;", "userId", "", "isFollowing", "", "(Ljava/lang/String;Z)V", "()Z", "getUserId", "()Ljava/lang/String;", "component1", "component2", "copy", "equals", "other", "", "hashCode", "", "toString", "app_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
    /* renamed from: com.memes.plus.ui.posts.PostAction$FollowUserTapped */
    /* compiled from: PostAction.kt */
    public static final class FollowUserTapped extends PostAction {
        private final boolean isFollowing;
        private final String userId;

        public static /* synthetic */ FollowUserTapped copy$default(FollowUserTapped followUserTapped, String str, boolean z, int i, Object obj) {
            if ((i & 1) != 0) {
                str = followUserTapped.userId;
            }
            if ((i & 2) != 0) {
                z = followUserTapped.isFollowing;
            }
            return followUserTapped.copy(str, z);
        }

        public final String component1() {
            return this.userId;
        }

        public final boolean component2() {
            return this.isFollowing;
        }

        public final FollowUserTapped copy(String str, boolean z) {
            Intrinsics.checkNotNullParameter(str, TagPeopleActivity.USER_ID);
            return new FollowUserTapped(str, z);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof FollowUserTapped)) {
                return false;
            }
            FollowUserTapped followUserTapped = (FollowUserTapped) obj;
            return Intrinsics.areEqual((Object) this.userId, (Object) followUserTapped.userId) && this.isFollowing == followUserTapped.isFollowing;
        }

        public int hashCode() {
            String str = this.userId;
            int hashCode = (str != null ? str.hashCode() : 0) * 31;
            boolean z = this.isFollowing;
            if (z) {
                z = true;
            }
            return hashCode + (z ? 1 : 0);
        }

        public String toString() {
            return "FollowUserTapped(userId=" + this.userId + ", isFollowing=" + this.isFollowing + ")";
        }

        public final String getUserId() {
            return this.userId;
        }

        public final boolean isFollowing() {
            return this.isFollowing;
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public FollowUserTapped(String str, boolean z) {
            super((DefaultConstructorMarker) null);
            Intrinsics.checkNotNullParameter(str, TagPeopleActivity.USER_ID);
            this.userId = str;
            this.isFollowing = z;
        }
    }

    @Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0005\b\b\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\t\u0010\t\u001a\u00020\u0003HÂ\u0003J\t\u0010\n\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\u000b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fHÖ\u0003J\t\u0010\u0010\u001a\u00020\u0003HÖ\u0001J\u0006\u0010\u0011\u001a\u00020\rJ\u0006\u0010\u0012\u001a\u00020\rJ\t\u0010\u0013\u001a\u00020\u0005HÖ\u0001R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\u0014"}, mo26107d2 = {"Lcom/memes/plus/ui/posts/PostAction$HighlightedTextTapped;", "Lcom/memes/plus/ui/posts/PostAction;", "linkType", "", "matchedText", "", "(ILjava/lang/String;)V", "getMatchedText", "()Ljava/lang/String;", "component1", "component2", "copy", "equals", "", "other", "", "hashCode", "isForHashTag", "isForUserMention", "toString", "app_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
    /* renamed from: com.memes.plus.ui.posts.PostAction$HighlightedTextTapped */
    /* compiled from: PostAction.kt */
    public static final class HighlightedTextTapped extends PostAction {
        private final int linkType;
        private final String matchedText;

        private final int component1() {
            return this.linkType;
        }

        public static /* synthetic */ HighlightedTextTapped copy$default(HighlightedTextTapped highlightedTextTapped, int i, String str, int i2, Object obj) {
            if ((i2 & 1) != 0) {
                i = highlightedTextTapped.linkType;
            }
            if ((i2 & 2) != 0) {
                str = highlightedTextTapped.matchedText;
            }
            return highlightedTextTapped.copy(i, str);
        }

        public final String component2() {
            return this.matchedText;
        }

        public final HighlightedTextTapped copy(int i, String str) {
            Intrinsics.checkNotNullParameter(str, "matchedText");
            return new HighlightedTextTapped(i, str);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof HighlightedTextTapped)) {
                return false;
            }
            HighlightedTextTapped highlightedTextTapped = (HighlightedTextTapped) obj;
            return this.linkType == highlightedTextTapped.linkType && Intrinsics.areEqual((Object) this.matchedText, (Object) highlightedTextTapped.matchedText);
        }

        public int hashCode() {
            int i = this.linkType * 31;
            String str = this.matchedText;
            return i + (str != null ? str.hashCode() : 0);
        }

        public String toString() {
            return "HighlightedTextTapped(linkType=" + this.linkType + ", matchedText=" + this.matchedText + ")";
        }

        public final String getMatchedText() {
            return this.matchedText;
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public HighlightedTextTapped(int i, String str) {
            super((DefaultConstructorMarker) null);
            Intrinsics.checkNotNullParameter(str, "matchedText");
            this.linkType = i;
            this.matchedText = str;
        }

        public final boolean isForHashTag() {
            return this.linkType == 1;
        }

        public final boolean isForUserMention() {
            return this.linkType == 2;
        }
    }

    @Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fHÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0011"}, mo26107d2 = {"Lcom/memes/plus/ui/posts/PostAction$LikeTapped;", "Lcom/memes/plus/ui/posts/PostAction;", "post", "Lcom/memes/plus/ui/posts/Post;", "(Lcom/memes/plus/ui/posts/Post;)V", "getPost", "()Lcom/memes/plus/ui/posts/Post;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "app_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
    /* renamed from: com.memes.plus.ui.posts.PostAction$LikeTapped */
    /* compiled from: PostAction.kt */
    public static final class LikeTapped extends PostAction {
        private final Post post;

        public static /* synthetic */ LikeTapped copy$default(LikeTapped likeTapped, Post post2, int i, Object obj) {
            if ((i & 1) != 0) {
                post2 = likeTapped.post;
            }
            return likeTapped.copy(post2);
        }

        public final Post component1() {
            return this.post;
        }

        public final LikeTapped copy(Post post2) {
            Intrinsics.checkNotNullParameter(post2, "post");
            return new LikeTapped(post2);
        }

        public boolean equals(Object obj) {
            if (this != obj) {
                return (obj instanceof LikeTapped) && Intrinsics.areEqual((Object) this.post, (Object) ((LikeTapped) obj).post);
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
            return "LikeTapped(post=" + this.post + ")";
        }

        public final Post getPost() {
            return this.post;
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public LikeTapped(Post post2) {
            super((DefaultConstructorMarker) null);
            Intrinsics.checkNotNullParameter(post2, "post");
            this.post = post2;
        }
    }

    @Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fHÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0011"}, mo26107d2 = {"Lcom/memes/plus/ui/posts/PostAction$LikeCountTapped;", "Lcom/memes/plus/ui/posts/PostAction;", "post", "Lcom/memes/plus/ui/posts/Post;", "(Lcom/memes/plus/ui/posts/Post;)V", "getPost", "()Lcom/memes/plus/ui/posts/Post;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "app_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
    /* renamed from: com.memes.plus.ui.posts.PostAction$LikeCountTapped */
    /* compiled from: PostAction.kt */
    public static final class LikeCountTapped extends PostAction {
        private final Post post;

        public static /* synthetic */ LikeCountTapped copy$default(LikeCountTapped likeCountTapped, Post post2, int i, Object obj) {
            if ((i & 1) != 0) {
                post2 = likeCountTapped.post;
            }
            return likeCountTapped.copy(post2);
        }

        public final Post component1() {
            return this.post;
        }

        public final LikeCountTapped copy(Post post2) {
            Intrinsics.checkNotNullParameter(post2, "post");
            return new LikeCountTapped(post2);
        }

        public boolean equals(Object obj) {
            if (this != obj) {
                return (obj instanceof LikeCountTapped) && Intrinsics.areEqual((Object) this.post, (Object) ((LikeCountTapped) obj).post);
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
            return "LikeCountTapped(post=" + this.post + ")";
        }

        public final Post getPost() {
            return this.post;
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public LikeCountTapped(Post post2) {
            super((DefaultConstructorMarker) null);
            Intrinsics.checkNotNullParameter(post2, "post");
            this.post = post2;
        }
    }

    @Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fHÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0011"}, mo26107d2 = {"Lcom/memes/plus/ui/posts/PostAction$SaveTapped;", "Lcom/memes/plus/ui/posts/PostAction;", "post", "Lcom/memes/plus/ui/posts/Post;", "(Lcom/memes/plus/ui/posts/Post;)V", "getPost", "()Lcom/memes/plus/ui/posts/Post;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "app_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
    /* renamed from: com.memes.plus.ui.posts.PostAction$SaveTapped */
    /* compiled from: PostAction.kt */
    public static final class SaveTapped extends PostAction {
        private final Post post;

        public static /* synthetic */ SaveTapped copy$default(SaveTapped saveTapped, Post post2, int i, Object obj) {
            if ((i & 1) != 0) {
                post2 = saveTapped.post;
            }
            return saveTapped.copy(post2);
        }

        public final Post component1() {
            return this.post;
        }

        public final SaveTapped copy(Post post2) {
            Intrinsics.checkNotNullParameter(post2, "post");
            return new SaveTapped(post2);
        }

        public boolean equals(Object obj) {
            if (this != obj) {
                return (obj instanceof SaveTapped) && Intrinsics.areEqual((Object) this.post, (Object) ((SaveTapped) obj).post);
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
            return "SaveTapped(post=" + this.post + ")";
        }

        public final Post getPost() {
            return this.post;
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public SaveTapped(Post post2) {
            super((DefaultConstructorMarker) null);
            Intrinsics.checkNotNullParameter(post2, "post");
            this.post = post2;
        }
    }

    @Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fHÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0011"}, mo26107d2 = {"Lcom/memes/plus/ui/posts/PostAction$ShareTapped;", "Lcom/memes/plus/ui/posts/PostAction;", "post", "Lcom/memes/plus/ui/posts/Post;", "(Lcom/memes/plus/ui/posts/Post;)V", "getPost", "()Lcom/memes/plus/ui/posts/Post;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "app_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
    /* renamed from: com.memes.plus.ui.posts.PostAction$ShareTapped */
    /* compiled from: PostAction.kt */
    public static final class ShareTapped extends PostAction {
        private final Post post;

        public static /* synthetic */ ShareTapped copy$default(ShareTapped shareTapped, Post post2, int i, Object obj) {
            if ((i & 1) != 0) {
                post2 = shareTapped.post;
            }
            return shareTapped.copy(post2);
        }

        public final Post component1() {
            return this.post;
        }

        public final ShareTapped copy(Post post2) {
            Intrinsics.checkNotNullParameter(post2, "post");
            return new ShareTapped(post2);
        }

        public boolean equals(Object obj) {
            if (this != obj) {
                return (obj instanceof ShareTapped) && Intrinsics.areEqual((Object) this.post, (Object) ((ShareTapped) obj).post);
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
            return "ShareTapped(post=" + this.post + ")";
        }

        public final Post getPost() {
            return this.post;
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public ShareTapped(Post post2) {
            super((DefaultConstructorMarker) null);
            Intrinsics.checkNotNullParameter(post2, "post");
            this.post = post2;
        }
    }

    @Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fHÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0011"}, mo26107d2 = {"Lcom/memes/plus/ui/posts/PostAction$OptionsTapped;", "Lcom/memes/plus/ui/posts/PostAction;", "post", "Lcom/memes/plus/ui/posts/Post;", "(Lcom/memes/plus/ui/posts/Post;)V", "getPost", "()Lcom/memes/plus/ui/posts/Post;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "app_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
    /* renamed from: com.memes.plus.ui.posts.PostAction$OptionsTapped */
    /* compiled from: PostAction.kt */
    public static final class OptionsTapped extends PostAction {
        private final Post post;

        public static /* synthetic */ OptionsTapped copy$default(OptionsTapped optionsTapped, Post post2, int i, Object obj) {
            if ((i & 1) != 0) {
                post2 = optionsTapped.post;
            }
            return optionsTapped.copy(post2);
        }

        public final Post component1() {
            return this.post;
        }

        public final OptionsTapped copy(Post post2) {
            Intrinsics.checkNotNullParameter(post2, "post");
            return new OptionsTapped(post2);
        }

        public boolean equals(Object obj) {
            if (this != obj) {
                return (obj instanceof OptionsTapped) && Intrinsics.areEqual((Object) this.post, (Object) ((OptionsTapped) obj).post);
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
            return "OptionsTapped(post=" + this.post + ")";
        }

        public final Post getPost() {
            return this.post;
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public OptionsTapped(Post post2) {
            super((DefaultConstructorMarker) null);
            Intrinsics.checkNotNullParameter(post2, "post");
            this.post = post2;
        }
    }

    @Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fHÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0011"}, mo26107d2 = {"Lcom/memes/plus/ui/posts/PostAction$AddCommentTapped;", "Lcom/memes/plus/ui/posts/PostAction;", "post", "Lcom/memes/plus/ui/posts/Post;", "(Lcom/memes/plus/ui/posts/Post;)V", "getPost", "()Lcom/memes/plus/ui/posts/Post;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "app_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
    /* renamed from: com.memes.plus.ui.posts.PostAction$AddCommentTapped */
    /* compiled from: PostAction.kt */
    public static final class AddCommentTapped extends PostAction {
        private final Post post;

        public static /* synthetic */ AddCommentTapped copy$default(AddCommentTapped addCommentTapped, Post post2, int i, Object obj) {
            if ((i & 1) != 0) {
                post2 = addCommentTapped.post;
            }
            return addCommentTapped.copy(post2);
        }

        public final Post component1() {
            return this.post;
        }

        public final AddCommentTapped copy(Post post2) {
            Intrinsics.checkNotNullParameter(post2, "post");
            return new AddCommentTapped(post2);
        }

        public boolean equals(Object obj) {
            if (this != obj) {
                return (obj instanceof AddCommentTapped) && Intrinsics.areEqual((Object) this.post, (Object) ((AddCommentTapped) obj).post);
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
            return "AddCommentTapped(post=" + this.post + ")";
        }

        public final Post getPost() {
            return this.post;
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public AddCommentTapped(Post post2) {
            super((DefaultConstructorMarker) null);
            Intrinsics.checkNotNullParameter(post2, "post");
            this.post = post2;
        }
    }

    @Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\t\u0010\f\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\r\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0015HÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u0016"}, mo26107d2 = {"Lcom/memes/plus/ui/posts/PostAction$LikeCommentTapped;", "Lcom/memes/plus/ui/posts/PostAction;", "post", "Lcom/memes/plus/ui/posts/Post;", "comment", "Lcom/memes/plus/ui/posts/commentpreviewbox/PostPreviewComment;", "(Lcom/memes/plus/ui/posts/Post;Lcom/memes/plus/ui/posts/commentpreviewbox/PostPreviewComment;)V", "getComment", "()Lcom/memes/plus/ui/posts/commentpreviewbox/PostPreviewComment;", "getPost", "()Lcom/memes/plus/ui/posts/Post;", "component1", "component2", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "app_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
    /* renamed from: com.memes.plus.ui.posts.PostAction$LikeCommentTapped */
    /* compiled from: PostAction.kt */
    public static final class LikeCommentTapped extends PostAction {
        private final PostPreviewComment comment;
        private final Post post;

        public static /* synthetic */ LikeCommentTapped copy$default(LikeCommentTapped likeCommentTapped, Post post2, PostPreviewComment postPreviewComment, int i, Object obj) {
            if ((i & 1) != 0) {
                post2 = likeCommentTapped.post;
            }
            if ((i & 2) != 0) {
                postPreviewComment = likeCommentTapped.comment;
            }
            return likeCommentTapped.copy(post2, postPreviewComment);
        }

        public final Post component1() {
            return this.post;
        }

        public final PostPreviewComment component2() {
            return this.comment;
        }

        public final LikeCommentTapped copy(Post post2, PostPreviewComment postPreviewComment) {
            Intrinsics.checkNotNullParameter(post2, "post");
            Intrinsics.checkNotNullParameter(postPreviewComment, "comment");
            return new LikeCommentTapped(post2, postPreviewComment);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof LikeCommentTapped)) {
                return false;
            }
            LikeCommentTapped likeCommentTapped = (LikeCommentTapped) obj;
            return Intrinsics.areEqual((Object) this.post, (Object) likeCommentTapped.post) && Intrinsics.areEqual((Object) this.comment, (Object) likeCommentTapped.comment);
        }

        public int hashCode() {
            Post post2 = this.post;
            int i = 0;
            int hashCode = (post2 != null ? post2.hashCode() : 0) * 31;
            PostPreviewComment postPreviewComment = this.comment;
            if (postPreviewComment != null) {
                i = postPreviewComment.hashCode();
            }
            return hashCode + i;
        }

        public String toString() {
            return "LikeCommentTapped(post=" + this.post + ", comment=" + this.comment + ")";
        }

        public final Post getPost() {
            return this.post;
        }

        public final PostPreviewComment getComment() {
            return this.comment;
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public LikeCommentTapped(Post post2, PostPreviewComment postPreviewComment) {
            super((DefaultConstructorMarker) null);
            Intrinsics.checkNotNullParameter(post2, "post");
            Intrinsics.checkNotNullParameter(postPreviewComment, "comment");
            this.post = post2;
            this.comment = postPreviewComment;
        }
    }

    @Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0006\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\u0007\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\b\u001a\u00020\u00032\b\u0010\t\u001a\u0004\u0018\u00010\nHÖ\u0003J\t\u0010\u000b\u001a\u00020\fHÖ\u0001J\t\u0010\r\u001a\u00020\u000eHÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0002\u0010\u0005¨\u0006\u000f"}, mo26107d2 = {"Lcom/memes/plus/ui/posts/PostAction$TogglePlaybackSoundTapped;", "Lcom/memes/plus/ui/posts/PostAction;", "isMuted", "", "(Z)V", "()Z", "component1", "copy", "equals", "other", "", "hashCode", "", "toString", "", "app_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
    /* renamed from: com.memes.plus.ui.posts.PostAction$TogglePlaybackSoundTapped */
    /* compiled from: PostAction.kt */
    public static final class TogglePlaybackSoundTapped extends PostAction {
        private final boolean isMuted;

        public static /* synthetic */ TogglePlaybackSoundTapped copy$default(TogglePlaybackSoundTapped togglePlaybackSoundTapped, boolean z, int i, Object obj) {
            if ((i & 1) != 0) {
                z = togglePlaybackSoundTapped.isMuted;
            }
            return togglePlaybackSoundTapped.copy(z);
        }

        public final boolean component1() {
            return this.isMuted;
        }

        public final TogglePlaybackSoundTapped copy(boolean z) {
            return new TogglePlaybackSoundTapped(z);
        }

        public boolean equals(Object obj) {
            if (this != obj) {
                return (obj instanceof TogglePlaybackSoundTapped) && this.isMuted == ((TogglePlaybackSoundTapped) obj).isMuted;
            }
            return true;
        }

        public int hashCode() {
            boolean z = this.isMuted;
            if (z) {
                return 1;
            }
            return z ? 1 : 0;
        }

        public String toString() {
            return "TogglePlaybackSoundTapped(isMuted=" + this.isMuted + ")";
        }

        public final boolean isMuted() {
            return this.isMuted;
        }

        public TogglePlaybackSoundTapped(boolean z) {
            super((DefaultConstructorMarker) null);
            this.isMuted = z;
        }
    }

    @Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\f\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\b\b\u0018\u0000 \u00162\u00020\u0001:\u0001\u0016B!\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0006J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\r\u001a\u0004\u0018\u00010\u0003HÆ\u0003J)\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012HÖ\u0003J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001J\t\u0010\u0015\u001a\u00020\u0003HÖ\u0001R\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\b¨\u0006\u0017"}, mo26107d2 = {"Lcom/memes/plus/ui/posts/PostAction$ViewProfile;", "Lcom/memes/plus/ui/posts/PostAction;", "userId", "", "userName", "postId", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getPostId", "()Ljava/lang/String;", "getUserId", "getUserName", "component1", "component2", "component3", "copy", "equals", "", "other", "", "hashCode", "", "toString", "Companion", "app_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
    /* renamed from: com.memes.plus.ui.posts.PostAction$ViewProfile */
    /* compiled from: PostAction.kt */
    public static final class ViewProfile extends PostAction {
        public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
        private final String postId;
        private final String userId;
        private final String userName;

        public static /* synthetic */ ViewProfile copy$default(ViewProfile viewProfile, String str, String str2, String str3, int i, Object obj) {
            if ((i & 1) != 0) {
                str = viewProfile.userId;
            }
            if ((i & 2) != 0) {
                str2 = viewProfile.userName;
            }
            if ((i & 4) != 0) {
                str3 = viewProfile.postId;
            }
            return viewProfile.copy(str, str2, str3);
        }

        public final String component1() {
            return this.userId;
        }

        public final String component2() {
            return this.userName;
        }

        public final String component3() {
            return this.postId;
        }

        public final ViewProfile copy(String str, String str2, String str3) {
            Intrinsics.checkNotNullParameter(str, TagPeopleActivity.USER_ID);
            Intrinsics.checkNotNullParameter(str2, TagPeopleActivity.USER_NAME);
            return new ViewProfile(str, str2, str3);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof ViewProfile)) {
                return false;
            }
            ViewProfile viewProfile = (ViewProfile) obj;
            return Intrinsics.areEqual((Object) this.userId, (Object) viewProfile.userId) && Intrinsics.areEqual((Object) this.userName, (Object) viewProfile.userName) && Intrinsics.areEqual((Object) this.postId, (Object) viewProfile.postId);
        }

        public int hashCode() {
            String str = this.userId;
            int i = 0;
            int hashCode = (str != null ? str.hashCode() : 0) * 31;
            String str2 = this.userName;
            int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
            String str3 = this.postId;
            if (str3 != null) {
                i = str3.hashCode();
            }
            return hashCode2 + i;
        }

        public String toString() {
            return "ViewProfile(userId=" + this.userId + ", userName=" + this.userName + ", postId=" + this.postId + ")";
        }

        public final String getUserId() {
            return this.userId;
        }

        public final String getUserName() {
            return this.userName;
        }

        /* JADX INFO: this call moved to the top of the method (can break code semantics) */
        public /* synthetic */ ViewProfile(String str, String str2, String str3, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this(str, str2, (i & 4) != 0 ? null : str3);
        }

        public final String getPostId() {
            return this.postId;
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public ViewProfile(String str, String str2, String str3) {
            super((DefaultConstructorMarker) null);
            Intrinsics.checkNotNullParameter(str, TagPeopleActivity.USER_ID);
            Intrinsics.checkNotNullParameter(str2, TagPeopleActivity.USER_NAME);
            this.userId = str;
            this.userName = str2;
            this.postId = str3;
        }

        @Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006J\u000e\u0010\u0007\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\tJ\u0012\u0010\u0007\u001a\u0004\u0018\u00010\u00042\b\u0010\n\u001a\u0004\u0018\u00010\u000bJ\u000e\u0010\u0007\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\r¨\u0006\u000e"}, mo26107d2 = {"Lcom/memes/plus/ui/posts/PostAction$ViewProfile$Companion;", "", "()V", "of", "Lcom/memes/plus/ui/posts/PostAction$ViewProfile;", "profile", "Lcom/memes/plus/ui/suggestions/SuggestedProfile;", "ofAuthor", "post", "Lcom/memes/plus/ui/posts/Post;", "sourcePost", "Lcom/memes/plus/ui/posts/Repost;", "comment", "Lcom/memes/plus/ui/posts/commentpreviewbox/PostPreviewComment;", "app_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
        /* renamed from: com.memes.plus.ui.posts.PostAction$ViewProfile$Companion */
        /* compiled from: PostAction.kt */
        public static final class Companion {
            private Companion() {
            }

            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            public final ViewProfile ofAuthor(Post post) {
                Intrinsics.checkNotNullParameter(post, "post");
                return new ViewProfile(post.requireAuthorUserId(), post.requireAuthorUserName(), post.requirePostId());
            }

            public final ViewProfile ofAuthor(PostPreviewComment postPreviewComment) {
                Intrinsics.checkNotNullParameter(postPreviewComment, "comment");
                return new ViewProfile(postPreviewComment.requireAuthorUserId(), postPreviewComment.requireAuthorUserName(), postPreviewComment.requirePostId());
            }

            public final ViewProfile ofAuthor(Repost repost) {
                if (repost == null) {
                    return null;
                }
                return new ViewProfile(repost.requireAuthorUserId(), repost.requireAuthorUserName(), repost.requirePostId());
            }

            /* renamed from: of */
            public final ViewProfile mo59836of(SuggestedProfile suggestedProfile) {
                Intrinsics.checkNotNullParameter(suggestedProfile, Scopes.PROFILE);
                return new ViewProfile(suggestedProfile.requireUserId(), suggestedProfile.requireUserName(), (String) null, 4, (DefaultConstructorMarker) null);
            }
        }
    }

    @Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fHÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0011"}, mo26107d2 = {"Lcom/memes/plus/ui/posts/PostAction$ViewTaggedPeople;", "Lcom/memes/plus/ui/posts/PostAction;", "post", "Lcom/memes/plus/ui/posts/Post;", "(Lcom/memes/plus/ui/posts/Post;)V", "getPost", "()Lcom/memes/plus/ui/posts/Post;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "app_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
    /* renamed from: com.memes.plus.ui.posts.PostAction$ViewTaggedPeople */
    /* compiled from: PostAction.kt */
    public static final class ViewTaggedPeople extends PostAction {
        private final Post post;

        public static /* synthetic */ ViewTaggedPeople copy$default(ViewTaggedPeople viewTaggedPeople, Post post2, int i, Object obj) {
            if ((i & 1) != 0) {
                post2 = viewTaggedPeople.post;
            }
            return viewTaggedPeople.copy(post2);
        }

        public final Post component1() {
            return this.post;
        }

        public final ViewTaggedPeople copy(Post post2) {
            Intrinsics.checkNotNullParameter(post2, "post");
            return new ViewTaggedPeople(post2);
        }

        public boolean equals(Object obj) {
            if (this != obj) {
                return (obj instanceof ViewTaggedPeople) && Intrinsics.areEqual((Object) this.post, (Object) ((ViewTaggedPeople) obj).post);
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
            return "ViewTaggedPeople(post=" + this.post + ")";
        }

        public final Post getPost() {
            return this.post;
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public ViewTaggedPeople(Post post2) {
            super((DefaultConstructorMarker) null);
            Intrinsics.checkNotNullParameter(post2, "post");
            this.post = post2;
        }
    }

    @Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B\u0019\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\f\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u001f\u0010\r\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005HÆ\u0001J\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0015HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u0016"}, mo26107d2 = {"Lcom/memes/plus/ui/posts/PostAction$ViewComments;", "Lcom/memes/plus/ui/posts/PostAction;", "post", "Lcom/memes/plus/ui/posts/Post;", "targetComment", "Lcom/memes/plus/ui/posts/commentpreviewbox/PostPreviewComment;", "(Lcom/memes/plus/ui/posts/Post;Lcom/memes/plus/ui/posts/commentpreviewbox/PostPreviewComment;)V", "getPost", "()Lcom/memes/plus/ui/posts/Post;", "getTargetComment", "()Lcom/memes/plus/ui/posts/commentpreviewbox/PostPreviewComment;", "component1", "component2", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "app_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
    /* renamed from: com.memes.plus.ui.posts.PostAction$ViewComments */
    /* compiled from: PostAction.kt */
    public static final class ViewComments extends PostAction {
        private final Post post;
        private final PostPreviewComment targetComment;

        public static /* synthetic */ ViewComments copy$default(ViewComments viewComments, Post post2, PostPreviewComment postPreviewComment, int i, Object obj) {
            if ((i & 1) != 0) {
                post2 = viewComments.post;
            }
            if ((i & 2) != 0) {
                postPreviewComment = viewComments.targetComment;
            }
            return viewComments.copy(post2, postPreviewComment);
        }

        public final Post component1() {
            return this.post;
        }

        public final PostPreviewComment component2() {
            return this.targetComment;
        }

        public final ViewComments copy(Post post2, PostPreviewComment postPreviewComment) {
            Intrinsics.checkNotNullParameter(post2, "post");
            return new ViewComments(post2, postPreviewComment);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof ViewComments)) {
                return false;
            }
            ViewComments viewComments = (ViewComments) obj;
            return Intrinsics.areEqual((Object) this.post, (Object) viewComments.post) && Intrinsics.areEqual((Object) this.targetComment, (Object) viewComments.targetComment);
        }

        public int hashCode() {
            Post post2 = this.post;
            int i = 0;
            int hashCode = (post2 != null ? post2.hashCode() : 0) * 31;
            PostPreviewComment postPreviewComment = this.targetComment;
            if (postPreviewComment != null) {
                i = postPreviewComment.hashCode();
            }
            return hashCode + i;
        }

        public String toString() {
            return "ViewComments(post=" + this.post + ", targetComment=" + this.targetComment + ")";
        }

        public final Post getPost() {
            return this.post;
        }

        /* JADX INFO: this call moved to the top of the method (can break code semantics) */
        public /* synthetic */ ViewComments(Post post2, PostPreviewComment postPreviewComment, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this(post2, (i & 2) != 0 ? null : postPreviewComment);
        }

        public final PostPreviewComment getTargetComment() {
            return this.targetComment;
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public ViewComments(Post post2, PostPreviewComment postPreviewComment) {
            super((DefaultConstructorMarker) null);
            Intrinsics.checkNotNullParameter(post2, "post");
            this.post = post2;
            this.targetComment = postPreviewComment;
        }
    }

    @Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, mo26107d2 = {"Lcom/memes/plus/ui/posts/PostAction$ViewSuggestedUsers;", "Lcom/memes/plus/ui/posts/PostAction;", "()V", "app_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
    /* renamed from: com.memes.plus.ui.posts.PostAction$ViewSuggestedUsers */
    /* compiled from: PostAction.kt */
    public static final class ViewSuggestedUsers extends PostAction {
        public static final ViewSuggestedUsers INSTANCE = new ViewSuggestedUsers();

        private ViewSuggestedUsers() {
            super((DefaultConstructorMarker) null);
        }
    }
}
