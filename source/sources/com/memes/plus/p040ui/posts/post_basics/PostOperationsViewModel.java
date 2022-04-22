package com.memes.plus.p040ui.posts.post_basics;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModelKt;
import com.facebook.share.internal.ShareConstants;
import com.google.android.gms.common.Scopes;
import com.memes.commons.media.MediaContent;
import com.memes.commons.media.MediaContentDownloader;
import com.memes.commons.media.MediaType;
import com.memes.commons.output.OutputExtension;
import com.memes.commons.output.OutputTarget;
import com.memes.commons.output.OutputTargetGenerator;
import com.memes.commons.util.SingleLiveEvent;
import com.memes.commons.viewmodel.BaseViewModel;
import com.memes.network.core.ResultState;
import com.memes.network.memes.MemesSession;
import com.memes.plus.App;
import com.memes.plus.base.BaseRxJavaViewModel;
import com.memes.plus.data.source.memes.MemesRepository;
import com.memes.plus.data.storage.StorageRepository;
import com.memes.plus.events.PostNotificationsSubscriptionEvent;
import com.memes.plus.p040ui.create_post.tagpeople.TagPeopleActivity;
import com.memes.plus.p040ui.post_comments.commentLike.PostCommentLikeRequest;
import com.memes.plus.p040ui.posts.Post;
import com.memes.plus.p040ui.posts.commentpreviewbox.PostPreviewComment;
import com.memes.plus.p040ui.posts.post_basics.follow_user.FollowUserRequest;
import com.memes.plus.p040ui.posts.post_basics.follow_user.FollowUserResult;
import com.memes.plus.p040ui.posts.post_basics.post_delete.PostDeleteRequest;
import com.memes.plus.p040ui.posts.post_basics.post_delete.PostDeleteResult;
import com.memes.plus.p040ui.posts.post_basics.post_like.PostLikeRequest;
import com.memes.plus.p040ui.posts.post_basics.post_like.PostLikeType;
import com.memes.plus.p040ui.posts.post_basics.post_notifications.PostNotificationSubscriptionRequest;
import com.memes.plus.p040ui.posts.post_basics.post_report.PostReportRequest;
import com.memes.plus.p040ui.posts.post_basics.post_report.PostReportResult;
import com.memes.plus.p040ui.posts.post_basics.post_save.PostSaveRequest;
import com.memes.plus.p040ui.posts.post_basics.post_save.PostSaveType;
import com.memes.plus.p040ui.posts.post_tags_dialog.PostTaggedUser;
import com.memes.plus.p040ui.posts.postfile.PostFile;
import com.memes.plus.p040ui.social_notifications.SocialNotification;
import com.memes.plus.p040ui.suggestions.SuggestedProfile;
import com.memes.plus.util.Constants;
import java.io.File;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.SafeContinuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.text.StringsKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Job;
import p015io.reactivex.android.schedulers.AndroidSchedulers;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0013\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\t\u0018\u00002\u00020\u0001:\u0001NB\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u000e\u0010\"\u001a\u00020#2\u0006\u0010$\u001a\u00020\u0012J\u0019\u0010%\u001a\u00020&2\u0006\u0010$\u001a\u00020\u0012H@ø\u0001\u0000¢\u0006\u0002\u0010'J\u000e\u0010(\u001a\u00020#2\u0006\u0010$\u001a\u00020\u0012J\u000e\u0010)\u001a\u00020#2\u0006\u0010*\u001a\u00020+J\f\u0010,\u001a\b\u0012\u0004\u0012\u00020\u000b0-J\f\u0010.\u001a\b\u0012\u0004\u0012\u00020\u001f0-J\f\u0010/\u001a\b\u0012\u0004\u0012\u00020\r0-J\f\u00100\u001a\b\u0012\u0004\u0012\u00020\u000f0-J\f\u00101\u001a\b\u0012\u0004\u0012\u00020\u00120-J\f\u00102\u001a\b\u0012\u0004\u0012\u00020\u00140-J\f\u00103\u001a\b\u0012\u0004\u0012\u00020\u00160-J\f\u00104\u001a\b\u0012\u0004\u0012\u00020\r0-J\f\u00105\u001a\b\u0012\u0004\u0012\u00020\u00120-J\f\u00106\u001a\b\u0012\u0004\u0012\u00020\r0-J\u0018\u00107\u001a\u0014\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001d0\u001c0\u001b0-J\u0016\u00108\u001a\u00020#2\u0006\u0010$\u001a\u00020\u00122\u0006\u00109\u001a\u00020+J\u000e\u0010:\u001a\u00020#2\u0006\u0010$\u001a\u00020\u0012J\u000e\u0010;\u001a\u00020#2\u0006\u0010$\u001a\u00020\u0012J\u000e\u0010<\u001a\u00020#2\u0006\u0010$\u001a\u00020\u0012J\u0016\u0010=\u001a\u00020#2\u0006\u0010$\u001a\u00020\u00122\u0006\u0010>\u001a\u00020\u001fJ\u000e\u0010?\u001a\u00020#2\u0006\u0010@\u001a\u00020AJ\u000e\u0010?\u001a\u00020#2\u0006\u0010B\u001a\u00020CJ\"\u0010?\u001a\u00020#2\b\u0010*\u001a\u0004\u0018\u00010+2\u0006\u0010D\u001a\u00020\u000b2\b\b\u0002\u0010E\u001a\u00020FJ\u000e\u0010G\u001a\u00020#2\u0006\u0010$\u001a\u00020\u0012J\u000e\u0010H\u001a\u00020#2\u0006\u0010$\u001a\u00020\u0012J\u000e\u0010I\u001a\u00020#2\u0006\u0010$\u001a\u00020\u0012J\u000e\u0010J\u001a\u00020#2\u0006\u0010*\u001a\u00020+J\u000e\u0010K\u001a\u00020#2\u0006\u0010L\u001a\u00020\u000bJ\f\u0010M\u001a\b\u0012\u0004\u0012\u00020!0-R\u0014\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\nX\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\f\u001a\b\u0012\u0004\u0012\u00020\r0\nX\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u000f0\nX\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00120\u0011X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00140\nX\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00160\nX\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\r0\nX\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00120\nX\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\r0\nX\u0004¢\u0006\u0002\n\u0000R \u0010\u001a\u001a\u0014\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001d0\u001c0\u001b0\nX\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u001f0\u0011X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010 \u001a\b\u0012\u0004\u0012\u00020!0\nX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000\u0002\u0004\n\u0002\b\u0019¨\u0006O"}, mo26107d2 = {"Lcom/memes/plus/ui/posts/post_basics/PostOperationsViewModel;", "Lcom/memes/plus/base/BaseRxJavaViewModel;", "repository", "Lcom/memes/plus/data/source/memes/MemesRepository;", "storageRepository", "Lcom/memes/plus/data/storage/StorageRepository;", "outputTargetGenerator", "Lcom/memes/commons/output/OutputTargetGenerator;", "(Lcom/memes/plus/data/source/memes/MemesRepository;Lcom/memes/plus/data/storage/StorageRepository;Lcom/memes/commons/output/OutputTargetGenerator;)V", "_playbackSoundSetting", "Lcom/memes/commons/util/SingleLiveEvent;", "", "_postContentDownloadLiveData", "Lcom/memes/plus/ui/posts/postfile/PostFile;", "_postDeleteLiveData", "Lcom/memes/plus/ui/posts/post_basics/post_delete/PostDeleteResult;", "_postLikeLiveData", "Landroidx/lifecycle/MutableLiveData;", "Lcom/memes/plus/ui/posts/Post;", "_postNotificationsLiveData", "Lcom/memes/plus/events/PostNotificationsSubscriptionEvent;", "_postReportLiveData", "Lcom/memes/plus/ui/posts/post_basics/post_report/PostReportResult;", "_postRepostLiveData", "_postSaveLiveData", "_postShareLiveData", "_postTaggedUsersLiveData", "Lcom/memes/network/core/ResultState;", "", "Lcom/memes/plus/ui/posts/post_tags_dialog/PostTaggedUser;", "_previewCommentLiveData", "Lcom/memes/plus/ui/posts/commentpreviewbox/PostPreviewComment;", "_userFollowLiveData", "Lcom/memes/plus/ui/posts/post_basics/follow_user/FollowUserResult;", "deletePost", "", "post", "downloadPostContent", "Lcom/memes/plus/ui/posts/post_basics/PostOperationsViewModel$PostDownloadResult;", "(Lcom/memes/plus/ui/posts/Post;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "fetchPostTaggedUsers", "followUser", "userId", "", "playbackSoundSetting", "Landroidx/lifecycle/LiveData;", "postCommentLikeUpdated", "postContentDownloadUpdated", "postDeleteUpdated", "postLikeUpdated", "postNotificationsUpdated", "postReportUpdated", "postRepostUpdated", "postSaveUpdated", "postShareUpdated", "postTaggedUsersUpdated", "reportPost", "reason", "repostPost", "savePostToGallery", "sharePost", "toggleCommentLike", "comment", "toggleFollowUser", "notification", "Lcom/memes/plus/ui/social_notifications/SocialNotification;", "profile", "Lcom/memes/plus/ui/suggestions/SuggestedProfile;", "isFollowed", "followerCount", "", "togglePostLike", "togglePostNotifications", "togglePostSave", "unfollowUser", "updatePlaybackSoundSetting", "isMuted", "userFollowUpdated", "PostDownloadResult", "app_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
/* renamed from: com.memes.plus.ui.posts.post_basics.PostOperationsViewModel */
/* compiled from: PostOperationsViewModel.kt */
public final class PostOperationsViewModel extends BaseRxJavaViewModel {
    /* access modifiers changed from: private */
    public final SingleLiveEvent<Boolean> _playbackSoundSetting = new SingleLiveEvent<>();
    /* access modifiers changed from: private */
    public final SingleLiveEvent<PostFile> _postContentDownloadLiveData = new SingleLiveEvent<>();
    /* access modifiers changed from: private */
    public final SingleLiveEvent<PostDeleteResult> _postDeleteLiveData = new SingleLiveEvent<>();
    /* access modifiers changed from: private */
    public final MutableLiveData<Post> _postLikeLiveData = new MutableLiveData<>();
    /* access modifiers changed from: private */
    public final SingleLiveEvent<PostNotificationsSubscriptionEvent> _postNotificationsLiveData = new SingleLiveEvent<>();
    /* access modifiers changed from: private */
    public final SingleLiveEvent<PostReportResult> _postReportLiveData = new SingleLiveEvent<>();
    /* access modifiers changed from: private */
    public final SingleLiveEvent<PostFile> _postRepostLiveData = new SingleLiveEvent<>();
    /* access modifiers changed from: private */
    public final SingleLiveEvent<Post> _postSaveLiveData = new SingleLiveEvent<>();
    /* access modifiers changed from: private */
    public final SingleLiveEvent<PostFile> _postShareLiveData = new SingleLiveEvent<>();
    /* access modifiers changed from: private */
    public final SingleLiveEvent<ResultState<List<PostTaggedUser>>> _postTaggedUsersLiveData = new SingleLiveEvent<>();
    /* access modifiers changed from: private */
    public final MutableLiveData<PostPreviewComment> _previewCommentLiveData = new MutableLiveData<>();
    /* access modifiers changed from: private */
    public final SingleLiveEvent<FollowUserResult> _userFollowLiveData = new SingleLiveEvent<>();
    private final OutputTargetGenerator outputTargetGenerator;
    /* access modifiers changed from: private */
    public final MemesRepository repository;
    /* access modifiers changed from: private */
    public final StorageRepository storageRepository;

    public PostOperationsViewModel(MemesRepository memesRepository, StorageRepository storageRepository2, OutputTargetGenerator outputTargetGenerator2) {
        Intrinsics.checkNotNullParameter(memesRepository, "repository");
        Intrinsics.checkNotNullParameter(storageRepository2, "storageRepository");
        Intrinsics.checkNotNullParameter(outputTargetGenerator2, "outputTargetGenerator");
        this.repository = memesRepository;
        this.storageRepository = storageRepository2;
        this.outputTargetGenerator = outputTargetGenerator2;
        Job unused = BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), (CoroutineContext) null, (CoroutineStart) null, new C43231(this, (Continuation) null), 3, (Object) null);
    }

    public final LiveData<Post> postLikeUpdated() {
        return this._postLikeLiveData;
    }

    public final void togglePostLike(Post post) {
        Intrinsics.checkNotNullParameter(post, "post");
        if (!post.getLiked()) {
            App.Companion.trackingManager().onPostLikeButtonTapped(MemesSession.INSTANCE.getUserId(), post.getPostId());
        }
        PostLikeRequest postLikeRequest = new PostLikeRequest();
        postLikeRequest.setPostId(post.getPostId());
        postLikeRequest.setType(post.getLiked() ? PostLikeType.UNLIKE : PostLikeType.LIKE);
        this.repository.togglePostLike(postLikeRequest).observeOn(AndroidSchedulers.mainThread()).subscribe(new PostOperationsViewModel$togglePostLike$1(this, post, postLikeRequest));
    }

    public final LiveData<Post> postSaveUpdated() {
        return this._postSaveLiveData;
    }

    public final void togglePostSave(Post post) {
        Intrinsics.checkNotNullParameter(post, "post");
        if (!post.getSaved()) {
            App.Companion.trackingManager().onPostSaveButtonTapped(MemesSession.INSTANCE.getUserId(), post.getPostId());
        }
        PostSaveRequest postSaveRequest = new PostSaveRequest();
        postSaveRequest.setPostId(post.getPostId());
        postSaveRequest.setType(post.getSaved() ? PostSaveType.UNSAVE : PostSaveType.SAVE);
        this.repository.togglePostSave(postSaveRequest).observeOn(AndroidSchedulers.mainThread()).subscribe(new PostOperationsViewModel$togglePostSave$1(this, post, postSaveRequest));
    }

    public final LiveData<PostFile> postShareUpdated() {
        return this._postShareLiveData;
    }

    public final void sharePost(Post post) {
        Intrinsics.checkNotNullParameter(post, "post");
        Job unused = BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), (CoroutineContext) null, (CoroutineStart) null, new PostOperationsViewModel$sharePost$1(this, post, (Continuation) null), 3, (Object) null);
    }

    public final LiveData<PostDeleteResult> postDeleteUpdated() {
        return this._postDeleteLiveData;
    }

    public final void deletePost(Post post) {
        Intrinsics.checkNotNullParameter(post, "post");
        PostDeleteRequest postDeleteRequest = new PostDeleteRequest();
        postDeleteRequest.setPostId(post.getPostId());
        this.repository.deletePost(postDeleteRequest).observeOn(AndroidSchedulers.mainThread()).subscribe(new PostOperationsViewModel$deletePost$1(this, post));
    }

    public final LiveData<PostReportResult> postReportUpdated() {
        return this._postReportLiveData;
    }

    public final void reportPost(Post post, String str) {
        Intrinsics.checkNotNullParameter(post, "post");
        Intrinsics.checkNotNullParameter(str, "reason");
        PostReportRequest postReportRequest = new PostReportRequest();
        postReportRequest.setPostId(post.getPostId());
        postReportRequest.setReportReason(str);
        this.repository.reportPost(postReportRequest).observeOn(AndroidSchedulers.mainThread()).subscribe(new PostOperationsViewModel$reportPost$1(this, post));
    }

    public final LiveData<FollowUserResult> userFollowUpdated() {
        return this._userFollowLiveData;
    }

    public final void followUser(String str) {
        Intrinsics.checkNotNullParameter(str, TagPeopleActivity.USER_ID);
        toggleFollowUser$default(this, str, false, 0, 4, (Object) null);
    }

    public final void unfollowUser(String str) {
        Intrinsics.checkNotNullParameter(str, TagPeopleActivity.USER_ID);
        toggleFollowUser$default(this, str, true, 0, 4, (Object) null);
    }

    public final void toggleFollowUser(SuggestedProfile suggestedProfile) {
        Intrinsics.checkNotNullParameter(suggestedProfile, Scopes.PROFILE);
        toggleFollowUser$default(this, suggestedProfile.requireUserId(), suggestedProfile.getIamFollowing(), 0, 4, (Object) null);
    }

    public final void toggleFollowUser(SocialNotification socialNotification) {
        Intrinsics.checkNotNullParameter(socialNotification, "notification");
        toggleFollowUser$default(this, socialNotification.getAuthorId(), socialNotification.getAuthorFollowed(), 0, 4, (Object) null);
    }

    public static /* synthetic */ void toggleFollowUser$default(PostOperationsViewModel postOperationsViewModel, String str, boolean z, long j, int i, Object obj) {
        if ((i & 4) != 0) {
            j = -1;
        }
        postOperationsViewModel.toggleFollowUser(str, z, j);
    }

    public final void toggleFollowUser(String str, boolean z, long j) {
        FollowUserRequest followUserRequest = new FollowUserRequest();
        followUserRequest.setTargetUserId(str);
        followUserRequest.setType(z ? FollowUserRequest.UNFOLLOW : FollowUserRequest.FOLLOW);
        BaseViewModel.showBlockingProgressDialog$default(this, (String) null, 1, (Object) null);
        this.repository.toggleFollowUser(followUserRequest).observeOn(AndroidSchedulers.mainThread()).subscribe(new PostOperationsViewModel$toggleFollowUser$1(this, j, z, str));
    }

    public final LiveData<PostPreviewComment> postCommentLikeUpdated() {
        return this._previewCommentLiveData;
    }

    public final void toggleCommentLike(Post post, PostPreviewComment postPreviewComment) {
        Intrinsics.checkNotNullParameter(post, "post");
        Intrinsics.checkNotNullParameter(postPreviewComment, "comment");
        CharSequence commentId = postPreviewComment.getCommentId();
        if (commentId == null || StringsKt.isBlank(commentId)) {
            toast(Constants.UNUSUAL_ERROR);
            return;
        }
        PostCommentLikeRequest postCommentLikeRequest = new PostCommentLikeRequest();
        postCommentLikeRequest.setCommentId(postPreviewComment.getCommentId());
        postCommentLikeRequest.setPostId(post.getPostId());
        this.repository.toggleCommentLike(postCommentLikeRequest).observeOn(AndroidSchedulers.mainThread()).subscribe(new PostOperationsViewModel$toggleCommentLike$1(this, postPreviewComment));
    }

    public final LiveData<PostFile> postRepostUpdated() {
        return this._postRepostLiveData;
    }

    public final void repostPost(Post post) {
        Intrinsics.checkNotNullParameter(post, "post");
        Job unused = BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), (CoroutineContext) null, (CoroutineStart) null, new PostOperationsViewModel$repostPost$1(this, post, (Continuation) null), 3, (Object) null);
    }

    public final LiveData<PostFile> postContentDownloadUpdated() {
        return this._postContentDownloadLiveData;
    }

    public final void savePostToGallery(Post post) {
        Intrinsics.checkNotNullParameter(post, "post");
        Job unused = BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), (CoroutineContext) null, (CoroutineStart) null, new PostOperationsViewModel$savePostToGallery$1(this, post, (Continuation) null), 3, (Object) null);
    }

    public final LiveData<PostNotificationsSubscriptionEvent> postNotificationsUpdated() {
        return this._postNotificationsLiveData;
    }

    public final void togglePostNotifications(Post post) {
        Intrinsics.checkNotNullParameter(post, "post");
        String str = post.getNotificationsEnabled() ? "0" : "1";
        PostNotificationSubscriptionRequest postNotificationSubscriptionRequest = new PostNotificationSubscriptionRequest();
        postNotificationSubscriptionRequest.setType(str);
        postNotificationSubscriptionRequest.setTargetUserId(post.getUserId());
        this.repository.togglePostNotificationsSubscription(postNotificationSubscriptionRequest).observeOn(AndroidSchedulers.mainThread()).subscribe(new PostOperationsViewModel$togglePostNotifications$1(this, post));
    }

    public final LiveData<ResultState<List<PostTaggedUser>>> postTaggedUsersUpdated() {
        return this._postTaggedUsersLiveData;
    }

    public final void fetchPostTaggedUsers(Post post) {
        Intrinsics.checkNotNullParameter(post, "post");
        Job unused = BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), (CoroutineContext) null, (CoroutineStart) null, new PostOperationsViewModel$fetchPostTaggedUsers$1(this, post, (Continuation) null), 3, (Object) null);
    }

    public final LiveData<Boolean> playbackSoundSetting() {
        return this._playbackSoundSetting;
    }

    public final void updatePlaybackSoundSetting(boolean z) {
        Job unused = BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), (CoroutineContext) null, (CoroutineStart) null, new PostOperationsViewModel$updatePlaybackSoundSetting$1(this, z, (Continuation) null), 3, (Object) null);
    }

    @Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H@¢\u0006\u0004\b\u0003\u0010\u0004"}, mo26107d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;"}, mo26108k = 3, mo26109mv = {1, 4, 2})
    @DebugMetadata(mo26807c = "com.memes.plus.ui.posts.post_basics.PostOperationsViewModel$1", mo26808f = "PostOperationsViewModel.kt", mo26809i = {}, mo26810l = {}, mo26811m = "invokeSuspend", mo26812n = {}, mo26813s = {})
    /* renamed from: com.memes.plus.ui.posts.post_basics.PostOperationsViewModel$1 */
    /* compiled from: PostOperationsViewModel.kt */
    static final class C43231 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;
        final /* synthetic */ PostOperationsViewModel this$0;

        {
            this.this$0 = r1;
        }

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            Intrinsics.checkNotNullParameter(continuation, "completion");
            return new C43231(this.this$0, continuation);
        }

        public final Object invoke(Object obj, Object obj2) {
            return ((C43231) create(obj, (Continuation) obj2)).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label == 0) {
                ResultKt.throwOnFailure(obj);
                this.this$0._playbackSoundSetting.setValue(Boxing.boxBoolean(this.this$0.storageRepository.isPlaybackSoundMuted()));
                return Unit.INSTANCE;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ Object downloadPostContent(Post post, Continuation<? super PostDownloadResult> continuation) {
        int i;
        Ref.ObjectRef objectRef = new Ref.ObjectRef();
        objectRef.element = post.getPostImage();
        CharSequence charSequence = (String) objectRef.element;
        if (charSequence == null || StringsKt.isBlank(charSequence)) {
            return new PostDownloadResult.Error("Unable to download this post.");
        }
        Ref.IntRef intRef = new Ref.IntRef();
        int contentType = post.contentType();
        if (contentType == 1) {
            i = MediaType.NETWORK_PHOTO;
        } else if (contentType != 2) {
            return new PostDownloadResult.Error("Unable to download this post.");
        } else {
            i = MediaType.NETWORK_VIDEO;
        }
        intRef.element = i;
        Ref.ObjectRef objectRef2 = new Ref.ObjectRef();
        objectRef2.element = post.contentType() == 2 ? OutputExtension.MP4 : OutputExtension.JPG;
        Ref.ObjectRef objectRef3 = new Ref.ObjectRef();
        objectRef3.element = OutputTargetGenerator.setDefaultOutputDestination$default(this.outputTargetGenerator, OutputTarget.FOLDER_DOWNLOAD_MEMES, (String) null, (String) objectRef2.element, true, false, 2, (Object) null).getOutputFile();
        BaseViewModel.showBlockingProgressDialog$default(this, (String) null, 1, (Object) null);
        SafeContinuation safeContinuation = new SafeContinuation(IntrinsicsKt.intercepted(continuation));
        MediaContentDownloader.Companion.get().storeAt((File) objectRef3.element, (String) objectRef2.element).withFileName(post.getPostId()).callback(new C4324xd42b439e(safeContinuation, this, post, objectRef3, objectRef2, intRef, objectRef)).download(new MediaContent(intRef.element, (String) objectRef.element, (Integer) null, (Integer) null, 12, (DefaultConstructorMarker) null));
        Object orThrow = safeContinuation.getOrThrow();
        if (orThrow == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            DebugProbesKt.probeCoroutineSuspended(continuation);
        }
        return orThrow;
    }

    @Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b2\u0018\u00002\u00020\u0001:\u0002\u0003\u0004B\u0007\b\u0002¢\u0006\u0002\u0010\u0002\u0001\u0002\u0005\u0006¨\u0006\u0007"}, mo26107d2 = {"Lcom/memes/plus/ui/posts/post_basics/PostOperationsViewModel$PostDownloadResult;", "", "()V", "Error", "Success", "Lcom/memes/plus/ui/posts/post_basics/PostOperationsViewModel$PostDownloadResult$Success;", "Lcom/memes/plus/ui/posts/post_basics/PostOperationsViewModel$PostDownloadResult$Error;", "app_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
    /* renamed from: com.memes.plus.ui.posts.post_basics.PostOperationsViewModel$PostDownloadResult */
    /* compiled from: PostOperationsViewModel.kt */
    private static abstract class PostDownloadResult {

        @Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fHÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0011"}, mo26107d2 = {"Lcom/memes/plus/ui/posts/post_basics/PostOperationsViewModel$PostDownloadResult$Success;", "Lcom/memes/plus/ui/posts/post_basics/PostOperationsViewModel$PostDownloadResult;", "postFile", "Lcom/memes/plus/ui/posts/postfile/PostFile;", "(Lcom/memes/plus/ui/posts/postfile/PostFile;)V", "getPostFile", "()Lcom/memes/plus/ui/posts/postfile/PostFile;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "app_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
        /* renamed from: com.memes.plus.ui.posts.post_basics.PostOperationsViewModel$PostDownloadResult$Success */
        /* compiled from: PostOperationsViewModel.kt */
        public static final class Success extends PostDownloadResult {
            private final PostFile postFile;

            public static /* synthetic */ Success copy$default(Success success, PostFile postFile2, int i, Object obj) {
                if ((i & 1) != 0) {
                    postFile2 = success.postFile;
                }
                return success.copy(postFile2);
            }

            public final PostFile component1() {
                return this.postFile;
            }

            public final Success copy(PostFile postFile2) {
                Intrinsics.checkNotNullParameter(postFile2, "postFile");
                return new Success(postFile2);
            }

            public boolean equals(Object obj) {
                if (this != obj) {
                    return (obj instanceof Success) && Intrinsics.areEqual((Object) this.postFile, (Object) ((Success) obj).postFile);
                }
                return true;
            }

            public int hashCode() {
                PostFile postFile2 = this.postFile;
                if (postFile2 != null) {
                    return postFile2.hashCode();
                }
                return 0;
            }

            public String toString() {
                return "Success(postFile=" + this.postFile + ")";
            }

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            public Success(PostFile postFile2) {
                super((DefaultConstructorMarker) null);
                Intrinsics.checkNotNullParameter(postFile2, "postFile");
                this.postFile = postFile2;
            }

            public final PostFile getPostFile() {
                return this.postFile;
            }
        }

        private PostDownloadResult() {
        }

        public /* synthetic */ PostDownloadResult(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fHÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0010"}, mo26107d2 = {"Lcom/memes/plus/ui/posts/post_basics/PostOperationsViewModel$PostDownloadResult$Error;", "Lcom/memes/plus/ui/posts/post_basics/PostOperationsViewModel$PostDownloadResult;", "message", "", "(Ljava/lang/String;)V", "getMessage", "()Ljava/lang/String;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "app_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
        /* renamed from: com.memes.plus.ui.posts.post_basics.PostOperationsViewModel$PostDownloadResult$Error */
        /* compiled from: PostOperationsViewModel.kt */
        public static final class Error extends PostDownloadResult {
            private final String message;

            public static /* synthetic */ Error copy$default(Error error, String str, int i, Object obj) {
                if ((i & 1) != 0) {
                    str = error.message;
                }
                return error.copy(str);
            }

            public final String component1() {
                return this.message;
            }

            public final Error copy(String str) {
                Intrinsics.checkNotNullParameter(str, ShareConstants.WEB_DIALOG_PARAM_MESSAGE);
                return new Error(str);
            }

            public boolean equals(Object obj) {
                if (this != obj) {
                    return (obj instanceof Error) && Intrinsics.areEqual((Object) this.message, (Object) ((Error) obj).message);
                }
                return true;
            }

            public int hashCode() {
                String str = this.message;
                if (str != null) {
                    return str.hashCode();
                }
                return 0;
            }

            public String toString() {
                return "Error(message=" + this.message + ")";
            }

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            public Error(String str) {
                super((DefaultConstructorMarker) null);
                Intrinsics.checkNotNullParameter(str, ShareConstants.WEB_DIALOG_PARAM_MESSAGE);
                this.message = str;
            }

            public final String getMessage() {
                return this.message;
            }
        }
    }
}
