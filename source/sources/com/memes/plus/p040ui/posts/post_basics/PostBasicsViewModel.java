package com.memes.plus.p040ui.posts.post_basics;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModelKt;
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
import com.memes.plus.events.PostNotificationsSubscriptionEvent;
import com.memes.plus.integrations.screenshots.PostScreenshotItem;
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
import com.memes.plus.p040ui.posts.post_basics.post_options.PostOption;
import com.memes.plus.p040ui.posts.post_basics.post_report.PostReportRequest;
import com.memes.plus.p040ui.posts.post_basics.post_report.PostReportResult;
import com.memes.plus.p040ui.posts.post_basics.post_save.PostSaveRequest;
import com.memes.plus.p040ui.posts.post_basics.post_save.PostSaveType;
import com.memes.plus.p040ui.posts.post_tags_dialog.PostTaggedUser;
import com.memes.plus.p040ui.posts.postfile.PostFile;
import com.memes.plus.p040ui.suggestions.SuggestedProfile;
import com.memes.plus.util.Constants;
import java.io.File;
import java.util.HashMap;
import java.util.List;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.CoroutineExceptionHandler;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Job;
import p015io.reactivex.android.schedulers.AndroidSchedulers;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000¨\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0005\b\u0017\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u000e\u00102\u001a\u0002032\u0006\u00104\u001a\u00020\u0012J\u0018\u00105\u001a\u0002032\u0006\u00104\u001a\u00020\u00122\b\b\u0002\u00106\u001a\u000207J\u000e\u00108\u001a\u0002032\u0006\u00104\u001a\u00020\u0012J\u000e\u00109\u001a\u0002032\u0006\u00104\u001a\u00020\u0012J\u000e\u0010:\u001a\u0002032\u0006\u0010;\u001a\u00020+J\f\u0010<\u001a\b\u0012\u0004\u0012\u00020\t0=J\f\u0010>\u001a\b\u0012\u0004\u0012\u00020\u00190=J\u0018\u0010?\u001a\u0002032\u0006\u00106\u001a\u0002072\u0006\u0010@\u001a\u00020\tH\u0002J\u0016\u0010A\u001a\u0002032\u0006\u00104\u001a\u00020\u00122\u0006\u0010B\u001a\u00020+J\u000e\u0010C\u001a\u0002032\u0006\u00104\u001a\u00020\u0012J\u000e\u0010D\u001a\u0002032\u0006\u00104\u001a\u00020\u0012J\u0016\u0010D\u001a\u0002032\u0006\u00104\u001a\u00020\u00122\u0006\u0010E\u001a\u00020FJ\u0016\u0010G\u001a\u0002032\u0006\u00104\u001a\u00020\u00122\u0006\u0010H\u001a\u00020\u0019J\u000e\u0010I\u001a\u0002032\u0006\u0010J\u001a\u00020-J\"\u0010I\u001a\u0002032\b\u0010;\u001a\u0004\u0018\u00010+2\u0006\u0010K\u001a\u00020L2\b\b\u0002\u0010M\u001a\u00020NJ\u000e\u0010O\u001a\u0002032\u0006\u00104\u001a\u00020\u0012J\u0010\u0010P\u001a\u0002032\u0006\u00104\u001a\u00020\u0012H\u0002J\u000e\u0010Q\u001a\u0002032\u0006\u00104\u001a\u00020\u0012J\u000e\u0010R\u001a\u0002032\u0006\u0010;\u001a\u00020+R\u0014\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\bX\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\b¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000e0\b¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\fR\u0017\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00120\u0011¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0017\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00160\b¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\fR\u0017\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00190\u0011¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0014R\u0017\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u001c0\b¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\fR\u0017\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\t0\b¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010\fR\u0017\u0010 \u001a\b\u0012\u0004\u0012\u00020\u00120\b¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\fR\u0017\u0010\"\u001a\b\u0012\u0004\u0012\u00020\t0\b¢\u0006\b\n\u0000\u001a\u0004\b#\u0010\fR#\u0010$\u001a\u0014\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020'0&0%0\b¢\u0006\b\n\u0000\u001a\u0004\b(\u0010\fR\"\u0010)\u001a\u0016\u0012\u0004\u0012\u00020+\u0012\f\u0012\n\u0012\u0004\u0012\u00020'\u0018\u00010&0*X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u0017\u0010,\u001a\b\u0012\u0004\u0012\u00020-0\b¢\u0006\b\n\u0000\u001a\u0004\b.\u0010\fR\u0017\u0010/\u001a\b\u0012\u0004\u0012\u0002000\b¢\u0006\b\n\u0000\u001a\u0004\b1\u0010\f¨\u0006S"}, mo26107d2 = {"Lcom/memes/plus/ui/posts/post_basics/PostBasicsViewModel;", "Lcom/memes/plus/base/BaseRxJavaViewModel;", "repository", "Lcom/memes/plus/data/source/memes/MemesRepository;", "outputTargetGenerator", "Lcom/memes/commons/output/OutputTargetGenerator;", "(Lcom/memes/plus/data/source/memes/MemesRepository;Lcom/memes/commons/output/OutputTargetGenerator;)V", "_postDownloadedLiveData", "Lcom/memes/commons/util/SingleLiveEvent;", "Lcom/memes/plus/ui/posts/postfile/PostFile;", "editPostLiveData", "getEditPostLiveData", "()Lcom/memes/commons/util/SingleLiveEvent;", "postDeleteLiveData", "Lcom/memes/plus/ui/posts/post_basics/post_delete/PostDeleteResult;", "getPostDeleteLiveData", "postLikeLiveData", "Landroidx/lifecycle/MutableLiveData;", "Lcom/memes/plus/ui/posts/Post;", "getPostLikeLiveData", "()Landroidx/lifecycle/MutableLiveData;", "postNotificationsEnabledLiveData", "Lcom/memes/plus/events/PostNotificationsSubscriptionEvent;", "getPostNotificationsEnabledLiveData", "postPreviewCommentLiveData", "Lcom/memes/plus/ui/posts/commentpreviewbox/PostPreviewComment;", "getPostPreviewCommentLiveData", "postReportLiveData", "Lcom/memes/plus/ui/posts/post_basics/post_report/PostReportResult;", "getPostReportLiveData", "postRepostLiveData", "getPostRepostLiveData", "postSaveLiveData", "getPostSaveLiveData", "postShareLiveData", "getPostShareLiveData", "postTaggedUsersLiveData", "Lcom/memes/network/core/ResultState;", "", "Lcom/memes/plus/ui/posts/post_tags_dialog/PostTaggedUser;", "getPostTaggedUsersLiveData", "postTaggedUsersMap", "Ljava/util/HashMap;", "", "suggestedUserFollowLiveData", "Lcom/memes/plus/ui/suggestions/SuggestedProfile;", "getSuggestedUserFollowLiveData", "userFollowLiveData", "Lcom/memes/plus/ui/posts/post_basics/follow_user/FollowUserResult;", "getUserFollowLiveData", "deletePost", "", "post", "downloadPost", "selectedOption", "Lcom/memes/plus/ui/posts/post_basics/post_options/PostOption;", "editPost", "fetchPostTaggedUsers", "followUser", "userId", "onPostDownloaded", "Landroidx/lifecycle/LiveData;", "onPostPreviewCommentUpdate", "performActionAfterDownload", "postFile", "reportPost", "reason", "repost", "sharePost", "screenshotItem", "Lcom/memes/plus/integrations/screenshots/PostScreenshotItem;", "toggleCommentLike", "comment", "toggleFollowUser", "profile", "isFollowed", "", "followerCount", "", "togglePostLike", "togglePostNotificationsSubscription", "togglePostSave", "unfollowUser", "app_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
@Deprecated(message = " Use PostOperations ViewModel")
/* renamed from: com.memes.plus.ui.posts.post_basics.PostBasicsViewModel */
/* compiled from: PostBasicsViewModel.kt */
public class PostBasicsViewModel extends BaseRxJavaViewModel {
    private final SingleLiveEvent<PostFile> _postDownloadedLiveData = new SingleLiveEvent<>();
    private final SingleLiveEvent<PostFile> editPostLiveData = new SingleLiveEvent<>();
    /* access modifiers changed from: private */
    public final OutputTargetGenerator outputTargetGenerator;
    private final SingleLiveEvent<PostDeleteResult> postDeleteLiveData = new SingleLiveEvent<>();
    private final MutableLiveData<Post> postLikeLiveData = new MutableLiveData<>();
    private final SingleLiveEvent<PostNotificationsSubscriptionEvent> postNotificationsEnabledLiveData = new SingleLiveEvent<>();
    private final MutableLiveData<PostPreviewComment> postPreviewCommentLiveData = new MutableLiveData<>();
    private final SingleLiveEvent<PostReportResult> postReportLiveData = new SingleLiveEvent<>();
    private final SingleLiveEvent<PostFile> postRepostLiveData = new SingleLiveEvent<>();
    private final SingleLiveEvent<Post> postSaveLiveData = new SingleLiveEvent<>();
    private final SingleLiveEvent<PostFile> postShareLiveData = new SingleLiveEvent<>();
    private final SingleLiveEvent<ResultState<List<PostTaggedUser>>> postTaggedUsersLiveData = new SingleLiveEvent<>();
    private final HashMap<String, List<PostTaggedUser>> postTaggedUsersMap = new HashMap<>();
    /* access modifiers changed from: private */
    public final MemesRepository repository;
    private final SingleLiveEvent<SuggestedProfile> suggestedUserFollowLiveData = new SingleLiveEvent<>();
    private final SingleLiveEvent<FollowUserResult> userFollowLiveData = new SingleLiveEvent<>();

    @Metadata(mo26105bv = {1, 0, 3}, mo26108k = 3, mo26109mv = {1, 4, 2})
    /* renamed from: com.memes.plus.ui.posts.post_basics.PostBasicsViewModel$WhenMappings */
    public final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[PostOption.values().length];
            $EnumSwitchMapping$0 = iArr;
            iArr[PostOption.SAVE_TO_GALLERY.ordinal()] = 1;
            iArr[PostOption.SHARE.ordinal()] = 2;
            iArr[PostOption.REPOST.ordinal()] = 3;
            iArr[PostOption.EDIT.ordinal()] = 4;
        }
    }

    public PostBasicsViewModel(MemesRepository memesRepository, OutputTargetGenerator outputTargetGenerator2) {
        Intrinsics.checkNotNullParameter(memesRepository, "repository");
        Intrinsics.checkNotNullParameter(outputTargetGenerator2, "outputTargetGenerator");
        this.repository = memesRepository;
        this.outputTargetGenerator = outputTargetGenerator2;
    }

    public final MutableLiveData<Post> getPostLikeLiveData() {
        return this.postLikeLiveData;
    }

    public final SingleLiveEvent<Post> getPostSaveLiveData() {
        return this.postSaveLiveData;
    }

    public final SingleLiveEvent<PostDeleteResult> getPostDeleteLiveData() {
        return this.postDeleteLiveData;
    }

    public final SingleLiveEvent<PostReportResult> getPostReportLiveData() {
        return this.postReportLiveData;
    }

    public final SingleLiveEvent<PostNotificationsSubscriptionEvent> getPostNotificationsEnabledLiveData() {
        return this.postNotificationsEnabledLiveData;
    }

    public final SingleLiveEvent<FollowUserResult> getUserFollowLiveData() {
        return this.userFollowLiveData;
    }

    public final SingleLiveEvent<PostFile> getPostShareLiveData() {
        return this.postShareLiveData;
    }

    public final LiveData<PostFile> onPostDownloaded() {
        return this._postDownloadedLiveData;
    }

    public final SingleLiveEvent<PostFile> getPostRepostLiveData() {
        return this.postRepostLiveData;
    }

    public final SingleLiveEvent<PostFile> getEditPostLiveData() {
        return this.editPostLiveData;
    }

    public final SingleLiveEvent<SuggestedProfile> getSuggestedUserFollowLiveData() {
        return this.suggestedUserFollowLiveData;
    }

    public final SingleLiveEvent<ResultState<List<PostTaggedUser>>> getPostTaggedUsersLiveData() {
        return this.postTaggedUsersLiveData;
    }

    public final MutableLiveData<PostPreviewComment> getPostPreviewCommentLiveData() {
        return this.postPreviewCommentLiveData;
    }

    public final LiveData<PostPreviewComment> onPostPreviewCommentUpdate() {
        return this.postPreviewCommentLiveData;
    }

    public final void fetchPostTaggedUsers(Post post) {
        Intrinsics.checkNotNullParameter(post, "post");
        Job unused = BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), (CoroutineContext) null, (CoroutineStart) null, new PostBasicsViewModel$fetchPostTaggedUsers$1(this, post, (Continuation) null), 3, (Object) null);
    }

    public final void togglePostLike(Post post) {
        Intrinsics.checkNotNullParameter(post, "post");
        if (!post.getLiked()) {
            App.Companion.trackingManager().onPostLikeButtonTapped(MemesSession.INSTANCE.getUserId(), post.getPostId());
        }
        PostLikeRequest postLikeRequest = new PostLikeRequest();
        postLikeRequest.setPostId(post.getPostId());
        postLikeRequest.setType(post.getLiked() ? PostLikeType.UNLIKE : PostLikeType.LIKE);
        this.repository.togglePostLike(postLikeRequest).observeOn(AndroidSchedulers.mainThread()).subscribe(new PostBasicsViewModel$togglePostLike$1(this, post, postLikeRequest));
    }

    public final void togglePostSave(Post post) {
        Intrinsics.checkNotNullParameter(post, "post");
        if (!post.getSaved()) {
            App.Companion.trackingManager().onPostSaveButtonTapped(MemesSession.INSTANCE.getUserId(), post.getPostId());
        }
        PostSaveRequest postSaveRequest = new PostSaveRequest();
        postSaveRequest.setPostId(post.getPostId());
        postSaveRequest.setType(post.getSaved() ? PostSaveType.UNSAVE : PostSaveType.SAVE);
        this.repository.togglePostSave(postSaveRequest).observeOn(AndroidSchedulers.mainThread()).subscribe(new PostBasicsViewModel$togglePostSave$1(this, post, postSaveRequest));
    }

    public final void deletePost(Post post) {
        Intrinsics.checkNotNullParameter(post, "post");
        PostDeleteRequest postDeleteRequest = new PostDeleteRequest();
        postDeleteRequest.setPostId(post.getPostId());
        this.repository.deletePost(postDeleteRequest).observeOn(AndroidSchedulers.mainThread()).subscribe(new PostBasicsViewModel$deletePost$1(this, post));
    }

    public final void sharePost(Post post) {
        Intrinsics.checkNotNullParameter(post, "post");
        downloadPost(post, PostOption.SHARE);
    }

    public final void sharePost(Post post, PostScreenshotItem postScreenshotItem) {
        Intrinsics.checkNotNullParameter(post, "post");
        Intrinsics.checkNotNullParameter(postScreenshotItem, "screenshotItem");
        String postId = post.getPostId();
        CharSequence charSequence = postId;
        if (!(charSequence == null || StringsKt.isBlank(charSequence))) {
            Job unused = BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), new C4322x60fe494d(CoroutineExceptionHandler.Key, this), (CoroutineStart) null, new PostBasicsViewModel$sharePost$1(this, postId, postScreenshotItem, post, (Continuation) null), 2, (Object) null);
        }
    }

    public final void repost(Post post) {
        Intrinsics.checkNotNullParameter(post, "post");
        downloadPost(post, PostOption.REPOST);
    }

    public final void editPost(Post post) {
        Intrinsics.checkNotNullParameter(post, "post");
        downloadPost(post, PostOption.EDIT);
    }

    public static /* synthetic */ void downloadPost$default(PostBasicsViewModel postBasicsViewModel, Post post, PostOption postOption, int i, Object obj) {
        if (obj == null) {
            if ((i & 2) != 0) {
                postOption = PostOption.SAVE_TO_GALLERY;
            }
            postBasicsViewModel.downloadPost(post, postOption);
            return;
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: downloadPost");
    }

    public final void downloadPost(Post post, PostOption postOption) {
        int i;
        Intrinsics.checkNotNullParameter(post, "post");
        Intrinsics.checkNotNullParameter(postOption, "selectedOption");
        String postImage = post.getPostImage();
        CharSequence charSequence = postImage;
        if (charSequence == null || StringsKt.isBlank(charSequence)) {
            toast("Unable to download this post.");
            return;
        }
        int contentType = post.contentType();
        if (contentType == 1) {
            i = MediaType.NETWORK_PHOTO;
        } else if (contentType != 2) {
            toast("Unable to download this post.");
            return;
        } else {
            i = MediaType.NETWORK_VIDEO;
        }
        String str = post.contentType() == 2 ? OutputExtension.MP4 : OutputExtension.JPG;
        File outputFile = OutputTargetGenerator.setDefaultOutputDestination$default(this.outputTargetGenerator, OutputTarget.FOLDER_DOWNLOAD_MEMES, (String) null, str, true, false, 2, (Object) null).getOutputFile();
        BaseViewModel.showBlockingProgressDialog$default(this, (String) null, 1, (Object) null);
        MediaContentDownloader.Companion.get().storeAt(outputFile, str).withFileName(post.getPostId()).callback(new PostBasicsViewModel$downloadPost$1(this, postOption, post)).download(new MediaContent(i, postImage, (Integer) null, (Integer) null, 12, (DefaultConstructorMarker) null));
    }

    /* access modifiers changed from: private */
    public final void performActionAfterDownload(PostOption postOption, PostFile postFile) {
        int i = WhenMappings.$EnumSwitchMapping$0[postOption.ordinal()];
        if (i == 1) {
            this._postDownloadedLiveData.setValue(postFile);
            toast("Meme saved successfully");
        } else if (i == 2) {
            this.postShareLiveData.setValue(postFile);
        } else if (i == 3) {
            this.postRepostLiveData.setValue(postFile);
        } else if (i == 4) {
            this.editPostLiveData.setValue(postFile);
        } else {
            throw new RuntimeException("This option (" + postOption + ") is not supported after download.");
        }
    }

    public final void reportPost(Post post, String str) {
        Intrinsics.checkNotNullParameter(post, "post");
        Intrinsics.checkNotNullParameter(str, "reason");
        PostReportRequest postReportRequest = new PostReportRequest();
        postReportRequest.setPostId(post.getPostId());
        postReportRequest.setReportReason(str);
        this.repository.reportPost(postReportRequest).observeOn(AndroidSchedulers.mainThread()).subscribe(new PostBasicsViewModel$reportPost$1(this, post));
    }

    private final void togglePostNotificationsSubscription(Post post) {
        String str = post.getNotificationsEnabled() ? "0" : "1";
        PostNotificationSubscriptionRequest postNotificationSubscriptionRequest = new PostNotificationSubscriptionRequest();
        postNotificationSubscriptionRequest.setType(str);
        postNotificationSubscriptionRequest.setTargetUserId(post.getUserId());
        this.repository.togglePostNotificationsSubscription(postNotificationSubscriptionRequest).observeOn(AndroidSchedulers.mainThread()).subscribe(new PostBasicsViewModel$togglePostNotificationsSubscription$1(this, post));
    }

    public final void followUser(String str) {
        Intrinsics.checkNotNullParameter(str, TagPeopleActivity.USER_ID);
        toggleFollowUser$default(this, str, false, 0, 4, (Object) null);
    }

    public final void unfollowUser(String str) {
        Intrinsics.checkNotNullParameter(str, TagPeopleActivity.USER_ID);
        toggleFollowUser$default(this, str, true, 0, 4, (Object) null);
    }

    public static /* synthetic */ void toggleFollowUser$default(PostBasicsViewModel postBasicsViewModel, String str, boolean z, long j, int i, Object obj) {
        if (obj == null) {
            if ((i & 4) != 0) {
                j = -1;
            }
            postBasicsViewModel.toggleFollowUser(str, z, j);
            return;
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: toggleFollowUser");
    }

    public final void toggleFollowUser(String str, boolean z, long j) {
        FollowUserRequest followUserRequest = new FollowUserRequest();
        followUserRequest.setTargetUserId(str);
        followUserRequest.setType(z ? FollowUserRequest.UNFOLLOW : FollowUserRequest.FOLLOW);
        BaseViewModel.showBlockingProgressDialog$default(this, (String) null, 1, (Object) null);
        this.repository.toggleFollowUser(followUserRequest).observeOn(AndroidSchedulers.mainThread()).subscribe(new PostBasicsViewModel$toggleFollowUser$1(this, str, z, j));
    }

    public final void toggleFollowUser(SuggestedProfile suggestedProfile) {
        Intrinsics.checkNotNullParameter(suggestedProfile, Scopes.PROFILE);
        FollowUserRequest followUserRequest = new FollowUserRequest();
        followUserRequest.setTargetUserId(suggestedProfile.getUserId());
        followUserRequest.setType(suggestedProfile.getIamFollowing() ? FollowUserRequest.UNFOLLOW : FollowUserRequest.FOLLOW);
        this.repository.toggleFollowUser(followUserRequest).observeOn(AndroidSchedulers.mainThread()).subscribe(new PostBasicsViewModel$toggleFollowUser$2(this, suggestedProfile));
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
        this.repository.toggleCommentLike(postCommentLikeRequest).observeOn(AndroidSchedulers.mainThread()).subscribe(new PostBasicsViewModel$toggleCommentLike$1(this, postPreviewComment));
    }
}
