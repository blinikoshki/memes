package com.memes.plus.p040ui.post_comments;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.text.Editable;
import android.view.View;
import android.view.animation.AnimationUtils;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.LifecycleOwner;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.bumptech.glide.Glide;
import com.bumptech.glide.RequestBuilder;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import com.facebook.share.internal.ShareConstants;
import com.getstream.sdk.chat.model.ModelType;
import com.giphy.sdk.core.models.Media;
import com.giphy.sdk.p013ui.GPHSettings;
import com.giphy.sdk.p013ui.views.GiphyDialogFragment;
import com.memes.commons.imageselection.ImageContent;
import com.memes.commons.imageselection.ImageSelector;
import com.memes.commons.media.MediaFile;
import com.memes.commons.media.MediaType;
import com.memes.commons.pagination.Paginator;
import com.memes.commons.provider.SimpleFileProvider;
import com.memes.commons.util.ActivityStarter;
import com.memes.commons.util.ExtensionsKt;
import com.memes.commons.util.SoftKeyboardUtil;
import com.memes.eventtracker.tracking.EventTrackingManager;
import com.memes.plus.ApiRouting;
import com.memes.plus.App;
import com.memes.plus.C4199R;
import com.memes.plus.base.BaseActivity;
import com.memes.plus.databinding.CommentsActivityBinding;
import com.memes.plus.p040ui.explore_search.ExploreSearchType;
import com.memes.plus.p040ui.explore_search.combined.ExploreSearchViewModel;
import com.memes.plus.p040ui.explore_search.people_search.CatalogueSearchResult;
import com.memes.plus.p040ui.explore_search.people_search.PeopleSearchResult;
import com.memes.plus.p040ui.explore_search.people_search.PeopleSearchResultAdapterListener;
import com.memes.plus.p040ui.explore_search.people_search.PeopleSearchResultsAdapter;
import com.memes.plus.p040ui.explore_search.tag_search.TagSearchResult;
import com.memes.plus.p040ui.explore_search.tag_search.TagSearchResultsAdapter;
import com.memes.plus.p040ui.explore_search.tag_search.TagSearchResultsAdapterListener;
import com.memes.plus.p040ui.media_viewer.MediaViewerActivity;
import com.memes.plus.p040ui.post_comments.PostCommentAction;
import com.memes.plus.p040ui.post_comments.addComment.AddCommentRequest;
import com.memes.plus.p040ui.post_comments.reply.Reply;
import com.memes.plus.p040ui.post_comments.reply.ReplyState;
import com.memes.plus.p040ui.post_comments.reportComment.CommentsReportOptionSelectionHandler;
import com.memes.plus.p040ui.post_comments.reportComment.CommentsReportOptionsBottomSheet;
import com.memes.plus.util.DialogUtil;
import com.memes.plus.util.ExtKt;
import com.memes.plus.util.SocialValidator;
import java.util.List;
import java.util.Objects;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.apache.commons.lang3.StringUtils;
import timber.log.Timber;
import tools.targetednavigation.TargetedNavigation;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000Ö\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\t\u0018\u0000 t2\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u00042\u00020\u00052\u00020\u0006:\u0001tB\u0005¢\u0006\u0002\u0010\u0007J\b\u0010+\u001a\u00020,H\u0002J\b\u0010-\u001a\u00020,H\u0002J\u0010\u0010.\u001a\u00020,2\u0006\u0010/\u001a\u000200H\u0002J\u0010\u00101\u001a\u00020,2\u0006\u00102\u001a\u00020 H\u0002J\b\u00103\u001a\u00020,H\u0016J\b\u00104\u001a\u00020,H\u0002J\u0010\u00105\u001a\u00020,2\u0006\u00106\u001a\u000207H\u0016J\u0010\u00108\u001a\u00020,2\u0006\u00106\u001a\u000207H\u0016J\u0010\u00109\u001a\u00020,2\u0006\u00106\u001a\u000207H\u0016J \u0010:\u001a\u00020,2\u0006\u0010;\u001a\u0002072\u0006\u0010<\u001a\u00020=2\u0006\u0010>\u001a\u00020 H\u0016J\u0018\u0010?\u001a\u00020,2\u0006\u00106\u001a\u0002072\u0006\u0010@\u001a\u00020AH\u0016J\u0010\u0010B\u001a\u00020,2\u0006\u00106\u001a\u000207H\u0016J\u0010\u0010C\u001a\u00020,2\u0006\u00106\u001a\u000207H\u0016J\u0010\u0010D\u001a\u00020,2\u0006\u00106\u001a\u000207H\u0016J\u0018\u0010E\u001a\u00020,2\u0006\u00106\u001a\u0002072\u0006\u0010F\u001a\u00020GH\u0016J\u0012\u0010H\u001a\u00020,2\b\u0010I\u001a\u0004\u0018\u00010JH\u0014J\b\u0010K\u001a\u00020,H\u0016J\u0010\u0010L\u001a\u00020,2\u0006\u00106\u001a\u000207H\u0016J\u0010\u0010M\u001a\u00020,2\u0006\u0010N\u001a\u00020OH\u0016J\u0018\u0010P\u001a\u00020,2\u0006\u0010Q\u001a\u00020=2\u0006\u0010R\u001a\u00020SH\u0016J\u0010\u0010T\u001a\u00020,2\u0006\u0010U\u001a\u00020VH\u0016J\u0010\u0010W\u001a\u00020,2\u0006\u0010X\u001a\u00020YH\u0016J\u0010\u0010Z\u001a\u00020,2\u0006\u0010X\u001a\u00020YH\u0016J\u0010\u0010[\u001a\u00020,2\u0006\u00106\u001a\u00020VH\u0016J\u0010\u0010\\\u001a\u00020,2\u0006\u00106\u001a\u00020VH\u0016J\u0010\u0010]\u001a\u00020,2\u0006\u00106\u001a\u000207H\u0016J\u0010\u0010^\u001a\u00020,2\u0006\u0010_\u001a\u00020`H\u0016J\b\u0010a\u001a\u00020,H\u0002J\u0010\u0010b\u001a\u00020,2\u0006\u0010c\u001a\u00020=H\u0002J\b\u0010d\u001a\u00020,H\u0002J\u0010\u0010e\u001a\u00020,2\u0006\u0010f\u001a\u00020GH\u0002J\u0010\u0010g\u001a\u00020,2\u0006\u0010h\u001a\u00020 H\u0002J\u0018\u0010i\u001a\u00020,2\u000e\u0010j\u001a\n\u0012\u0004\u0012\u00020l\u0018\u00010kH\u0002J\b\u0010m\u001a\u00020,H\u0002J\u0018\u0010n\u001a\u00020,2\u0006\u00106\u001a\u0002072\u0006\u0010o\u001a\u00020 H\u0002J\u0010\u0010p\u001a\u00020,2\u0006\u0010h\u001a\u00020 H\u0002J\u0018\u0010q\u001a\u00020,2\u000e\u0010j\u001a\n\u0012\u0004\u0012\u00020`\u0018\u00010kH\u0002J\b\u0010r\u001a\u00020,H\u0002J\b\u0010s\u001a\u00020,H\u0002R\u001b\u0010\b\u001a\u00020\t8BX\u0002¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\n\u0010\u000bR\u000e\u0010\u000e\u001a\u00020\u000fX.¢\u0006\u0002\n\u0000R\u001b\u0010\u0010\u001a\u00020\u00118BX\u0002¢\u0006\f\n\u0004\b\u0014\u0010\r\u001a\u0004\b\u0012\u0010\u0013R\u000e\u0010\u0015\u001a\u00020\u0016X.¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0018X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u001aX.¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u001cX.¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\u001eX.¢\u0006\u0002\n\u0000R\u000e\u0010\u001f\u001a\u00020 X.¢\u0006\u0002\n\u0000R\u000e\u0010!\u001a\u00020\u001aX.¢\u0006\u0002\n\u0000R\u0010\u0010\"\u001a\u0004\u0018\u00010 X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010#\u001a\u00020 X.¢\u0006\u0002\n\u0000R\u000e\u0010$\u001a\u00020%X.¢\u0006\u0002\n\u0000R\u001b\u0010&\u001a\u00020'8BX\u0002¢\u0006\f\n\u0004\b*\u0010\r\u001a\u0004\b(\u0010)¨\u0006u"}, mo26107d2 = {"Lcom/memes/plus/ui/post_comments/PostCommentsActivity;", "Lcom/memes/plus/base/BaseActivity;", "Lcom/memes/plus/ui/post_comments/PostCommentsAdapterListener;", "Lcom/memes/plus/ui/explore_search/people_search/PeopleSearchResultAdapterListener;", "Lcom/memes/plus/ui/explore_search/tag_search/TagSearchResultsAdapterListener;", "Lcom/giphy/sdk/ui/views/GiphyDialogFragment$GifSelectionListener;", "Lcom/memes/commons/imageselection/ImageSelector$Callback;", "()V", "binding", "Lcom/memes/plus/databinding/CommentsActivityBinding;", "getBinding", "()Lcom/memes/plus/databinding/CommentsActivityBinding;", "binding$delegate", "Lkotlin/Lazy;", "commentsAdapter", "Lcom/memes/plus/ui/post_comments/PostCommentsAdapter;", "exploreSearchViewModel", "Lcom/memes/plus/ui/explore_search/combined/ExploreSearchViewModel;", "getExploreSearchViewModel", "()Lcom/memes/plus/ui/explore_search/combined/ExploreSearchViewModel;", "exploreSearchViewModel$delegate", "giphyDialog", "Lcom/giphy/sdk/ui/views/GiphyDialogFragment;", "imageSelector", "Lcom/memes/commons/imageselection/ImageSelector;", "layoutManager", "Landroidx/recyclerview/widget/LinearLayoutManager;", "pageScrollListener", "Lcom/memes/commons/pagination/Paginator;", "peopleSearchAdapter", "Lcom/memes/plus/ui/explore_search/people_search/PeopleSearchResultsAdapter;", "postId", "", "searchlayoutManager", "selectedGifId", "selectedGifUrl", "tagsSearchAdapter", "Lcom/memes/plus/ui/explore_search/tag_search/TagSearchResultsAdapter;", "viewModel", "Lcom/memes/plus/ui/post_comments/CommentsViewModel;", "getViewModel", "()Lcom/memes/plus/ui/post_comments/CommentsViewModel;", "viewModel$delegate", "addComment", "", "addReply", "applyPostCommentAction", "commentAction", "Lcom/memes/plus/ui/post_comments/PostCommentAction;", "checkForMentions", "inputText", "fetchPreviousComments", "hidePostButton", "onCommentAuthorProfileClicked", "comment", "Lcom/memes/plus/ui/post_comments/PostComment;", "onCommentDeleteClicked", "onCommentEditClicked", "onCommentHighlightedTextTapped", "postComment", "linkType", "", "matchedText", "onCommentImageClicked", "view", "Landroid/view/View;", "onCommentLikeButtonClicked", "onCommentReplyClicked", "onCommentTotalLikesClicked", "onCommentViewAllRepliesClicked", "shouldShowReplies", "", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDismissed", "onEditReplyClicked", "onGifSelected", "media", "Lcom/giphy/sdk/core/models/Media;", "onImageFileSelected", "requestIdentifier", "imageContent", "Lcom/memes/commons/imageselection/ImageContent;", "onLikeReplyClicked", "reply", "Lcom/memes/plus/ui/post_comments/reply/Reply;", "onPeopleSearchResultTapped", "peopleSearchResult", "Lcom/memes/plus/ui/explore_search/people_search/PeopleSearchResult;", "onRemoveSuggestedPersonViewTapped", "onReplyAuthorProfileClicked", "onReplyDeleteClicked", "onReportClicked", "onTagSearchResultTapped", "tagSearchResult", "Lcom/memes/plus/ui/explore_search/tag_search/TagSearchResult;", "registerViewModel", "scrollToPosition", "position", "setEditorListener", "setGifWrapperVisibility", "visibility", "showMentions", "query", "showPeopleList", "updatedList", "", "Lcom/memes/plus/ui/explore_search/people_search/CatalogueSearchResult;", "showPostButton", "showReplySection", "commentText", "showTags", "showTagsList", "updateComment", "updateReply", "Companion", "app_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
/* renamed from: com.memes.plus.ui.post_comments.PostCommentsActivity */
/* compiled from: PostCommentsActivity.kt */
public final class PostCommentsActivity extends BaseActivity implements PostCommentsAdapterListener, PeopleSearchResultAdapterListener, TagSearchResultsAdapterListener, GiphyDialogFragment.GifSelectionListener, ImageSelector.Callback {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private static final String EXTRA_COMMENT_ACTION = "intent_extra_comment_action";
    private static final String EXTRA_POST_ID = "intent_extra_post_id";
    private static final int RC_COMMENT_CAMERA_IMAGE = 46568;
    private final Lazy binding$delegate = LazyKt.lazy(new PostCommentsActivity$binding$2(this));
    /* access modifiers changed from: private */
    public PostCommentsAdapter commentsAdapter;
    private final Lazy exploreSearchViewModel$delegate = LazyKt.lazy(new PostCommentsActivity$exploreSearchViewModel$2(this));
    /* access modifiers changed from: private */
    public GiphyDialogFragment giphyDialog;
    /* access modifiers changed from: private */
    public final ImageSelector imageSelector = new ImageSelector(this, SimpleFileProvider.NAME);
    private LinearLayoutManager layoutManager;
    /* access modifiers changed from: private */
    public Paginator pageScrollListener;
    private PeopleSearchResultsAdapter peopleSearchAdapter;
    private String postId;
    private LinearLayoutManager searchlayoutManager;
    /* access modifiers changed from: private */
    public String selectedGifId;
    private String selectedGifUrl;
    private TagSearchResultsAdapter tagsSearchAdapter;
    private final Lazy viewModel$delegate = LazyKt.lazy(new PostCommentsActivity$viewModel$2(this));

    @Metadata(mo26105bv = {1, 0, 3}, mo26108k = 3, mo26109mv = {1, 4, 2})
    /* renamed from: com.memes.plus.ui.post_comments.PostCommentsActivity$WhenMappings */
    public final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[PostCommentAction.ActionType.values().length];
            $EnumSwitchMapping$0 = iArr;
            iArr[PostCommentAction.ActionType.ADD_COMMENT.ordinal()] = 1;
            iArr[PostCommentAction.ActionType.VIEW_COMMENT.ordinal()] = 2;
            iArr[PostCommentAction.ActionType.ADD_REPLY.ordinal()] = 3;
        }
    }

    /* access modifiers changed from: private */
    public final CommentsActivityBinding getBinding() {
        return (CommentsActivityBinding) this.binding$delegate.getValue();
    }

    private final ExploreSearchViewModel getExploreSearchViewModel() {
        return (ExploreSearchViewModel) this.exploreSearchViewModel$delegate.getValue();
    }

    /* access modifiers changed from: private */
    public final CommentsViewModel getViewModel() {
        return (CommentsViewModel) this.viewModel$delegate.getValue();
    }

    public void onCommentTotalLikesClicked(PostComment postComment) {
        Intrinsics.checkNotNullParameter(postComment, "comment");
    }

    public void onDismissed() {
    }

    public void onRemoveSuggestedPersonViewTapped(PeopleSearchResult peopleSearchResult) {
        Intrinsics.checkNotNullParameter(peopleSearchResult, "peopleSearchResult");
    }

    public static final /* synthetic */ PostCommentsAdapter access$getCommentsAdapter$p(PostCommentsActivity postCommentsActivity) {
        PostCommentsAdapter postCommentsAdapter = postCommentsActivity.commentsAdapter;
        if (postCommentsAdapter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("commentsAdapter");
        }
        return postCommentsAdapter;
    }

    public static final /* synthetic */ GiphyDialogFragment access$getGiphyDialog$p(PostCommentsActivity postCommentsActivity) {
        GiphyDialogFragment giphyDialogFragment = postCommentsActivity.giphyDialog;
        if (giphyDialogFragment == null) {
            Intrinsics.throwUninitializedPropertyAccessException("giphyDialog");
        }
        return giphyDialogFragment;
    }

    public static final /* synthetic */ Paginator access$getPageScrollListener$p(PostCommentsActivity postCommentsActivity) {
        Paginator paginator = postCommentsActivity.pageScrollListener;
        if (paginator == null) {
            Intrinsics.throwUninitializedPropertyAccessException("pageScrollListener");
        }
        return paginator;
    }

    @Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\"\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u00042\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000eR\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007XT¢\u0006\u0002\n\u0000¨\u0006\u000f"}, mo26107d2 = {"Lcom/memes/plus/ui/post_comments/PostCommentsActivity$Companion;", "", "()V", "EXTRA_COMMENT_ACTION", "", "EXTRA_POST_ID", "RC_COMMENT_CAMERA_IMAGE", "", "getStartIntent", "Landroid/content/Intent;", "context", "Landroid/content/Context;", "postId", "action", "Lcom/memes/plus/ui/post_comments/PostCommentAction;", "app_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
    /* renamed from: com.memes.plus.ui.post_comments.PostCommentsActivity$Companion */
    /* compiled from: PostCommentsActivity.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public static /* synthetic */ Intent getStartIntent$default(Companion companion, Context context, String str, PostCommentAction postCommentAction, int i, Object obj) {
            if ((i & 4) != 0) {
                postCommentAction = null;
            }
            return companion.getStartIntent(context, str, postCommentAction);
        }

        public final Intent getStartIntent(Context context, String str, PostCommentAction postCommentAction) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(str, ShareConstants.RESULT_POST_ID);
            Intent intent = new Intent(context, PostCommentsActivity.class);
            intent.putExtra(PostCommentsActivity.EXTRA_POST_ID, str);
            intent.putExtra(PostCommentsActivity.EXTRA_COMMENT_ACTION, postCommentAction);
            return intent;
        }
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        CommentsActivityBinding binding = getBinding();
        Intrinsics.checkNotNullExpressionValue(binding, "binding");
        setContentView((View) binding.getRoot());
        registerViewModel(getViewModel());
        String stringExtra = getIntent().getStringExtra(EXTRA_POST_ID);
        App.Companion.trackingManager().onCommentsPageOpened(stringExtra);
        if (stringExtra == null) {
            finish();
            return;
        }
        this.postId = stringExtra;
        this.giphyDialog = GiphyDialogFragment.Companion.newInstance$default(GiphyDialogFragment.Companion, (GPHSettings) null, 1, (Object) null);
        Context context = this;
        this.layoutManager = new LinearLayoutManager(context);
        this.searchlayoutManager = new LinearLayoutManager(context);
        RecyclerView recyclerView = getBinding().commentsRecyclerView;
        Intrinsics.checkNotNullExpressionValue(recyclerView, "binding.commentsRecyclerView");
        LinearLayoutManager linearLayoutManager = this.layoutManager;
        if (linearLayoutManager == null) {
            Intrinsics.throwUninitializedPropertyAccessException("layoutManager");
        }
        recyclerView.setLayoutManager(linearLayoutManager);
        this.commentsAdapter = new PostCommentsAdapter(context, this);
        getBinding().commentsRecyclerView.clearOnScrollListeners();
        RecyclerView recyclerView2 = getBinding().commentsRecyclerView;
        Intrinsics.checkNotNullExpressionValue(recyclerView2, "binding.commentsRecyclerView");
        LinearLayoutManager linearLayoutManager2 = this.layoutManager;
        if (linearLayoutManager2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("layoutManager");
        }
        this.pageScrollListener = ExtensionsKt.addPaginator(recyclerView2, linearLayoutManager2, PostCommentsActivity$onCreate$1.INSTANCE);
        RecyclerView recyclerView3 = getBinding().commentsRecyclerView;
        Intrinsics.checkNotNullExpressionValue(recyclerView3, "binding.commentsRecyclerView");
        LinearLayoutManager linearLayoutManager3 = this.layoutManager;
        if (linearLayoutManager3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("layoutManager");
        }
        ExtKt.addVisibilityTracker(recyclerView3, linearLayoutManager3);
        RecyclerView recyclerView4 = getBinding().commentsRecyclerView;
        Intrinsics.checkNotNullExpressionValue(recyclerView4, "binding.commentsRecyclerView");
        PostCommentsAdapter postCommentsAdapter = this.commentsAdapter;
        if (postCommentsAdapter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("commentsAdapter");
        }
        recyclerView4.setAdapter(postCommentsAdapter);
        getBinding().includedTopBar.topBarBackImageView.setOnClickListener(new PostCommentsActivity$onCreate$2(this));
        registerViewModel();
        this.peopleSearchAdapter = new PeopleSearchResultsAdapter(context, this);
        this.tagsSearchAdapter = new TagSearchResultsAdapter(context, this);
        EditText editText = getBinding().addCommentEditText;
        Intrinsics.checkNotNullExpressionValue(editText, "binding.addCommentEditText");
        ExtensionsKt.setMultiLineCapSentencesAndDoneAction(editText);
        setEditorListener();
        getBinding().postCommentTextView.setOnClickListener(new PostCommentsActivity$onCreate$3(this));
        getBinding().gifSelectionImageView.setOnClickListener(new PostCommentsActivity$onCreate$4(this));
        getBinding().cameraSelectionImageView.setOnClickListener(new PostCommentsActivity$onCreate$5(this));
        getBinding().selectedGifCloseImageView.setOnClickListener(new PostCommentsActivity$onCreate$6(this));
        getBinding().includedTopBar.topBarTitleTextView.setText(C4199R.string.comments);
        getBinding().replyingCloseImageView.setOnClickListener(new PostCommentsActivity$onCreate$7(this));
        getViewModel().fetchPostComments(stringExtra);
    }

    public void onGifSelected(Media media) {
        Intrinsics.checkNotNullParameter(media, "media");
        Timber.m303e("onGifSelected(" + media.getId() + ')', new Object[0]);
        this.selectedGifId = media.getId();
        getBinding().selectedGifImageView.setImageResource(0);
        RelativeLayout relativeLayout = getBinding().gifWrapperRelativeLayout;
        Intrinsics.checkNotNullExpressionValue(relativeLayout, "binding.gifWrapperRelativeLayout");
        relativeLayout.setVisibility(0);
        ((RequestBuilder) ((RequestBuilder) Glide.with((FragmentActivity) this).asGif().load(ApiRouting.GIPHY_CONTENT_ENDPOINT + media.getId() + "/giphy.gif").diskCacheStrategy(DiskCacheStrategy.NONE)).override(70, 70)).into(getBinding().selectedGifImageView);
        setGifWrapperVisibility(true);
    }

    /* access modifiers changed from: private */
    public final void addComment() {
        AddCommentRequest addCommentRequest = new AddCommentRequest();
        EditText editText = getBinding().addCommentEditText;
        Intrinsics.checkNotNullExpressionValue(editText, "binding.addCommentEditText");
        String obj = editText.getText().toString();
        Objects.requireNonNull(obj, "null cannot be cast to non-null type kotlin.CharSequence");
        addCommentRequest.setCommentText(StringsKt.trim((CharSequence) obj).toString());
        String str = this.postId;
        if (str == null) {
            Intrinsics.throwUninitializedPropertyAccessException(ShareConstants.RESULT_POST_ID);
        }
        addCommentRequest.setPostId(str);
        CharSequence charSequence = this.selectedGifId;
        boolean z = false;
        if (!(charSequence == null || StringsKt.isBlank(charSequence))) {
            addCommentRequest.setStickerId(this.selectedGifId);
            addCommentRequest.setCommentType(String.valueOf(4));
        }
        CharSequence commentImagePath = getViewModel().getCommentImagePath();
        if (commentImagePath == null || commentImagePath.length() == 0) {
            z = true;
        }
        if (!z) {
            addCommentRequest.setCommentImage(getViewModel().getCommentImagePath());
            addCommentRequest.setCommentType(String.valueOf(1));
        }
        SoftKeyboardUtil softKeyboardUtil = SoftKeyboardUtil.INSTANCE;
        EditText editText2 = getBinding().addCommentEditText;
        Intrinsics.checkNotNullExpressionValue(editText2, "binding.addCommentEditText");
        softKeyboardUtil.hideKeyboard(editText2);
        this.selectedGifUrl = "";
        this.selectedGifId = null;
        getViewModel().addComment(addCommentRequest);
    }

    /* access modifiers changed from: private */
    public final void updateComment() {
        AddCommentRequest addCommentRequest = new AddCommentRequest();
        EditText editText = getBinding().addCommentEditText;
        Intrinsics.checkNotNullExpressionValue(editText, "binding.addCommentEditText");
        String obj = editText.getText().toString();
        Objects.requireNonNull(obj, "null cannot be cast to non-null type kotlin.CharSequence");
        addCommentRequest.setCommentText(StringsKt.trim((CharSequence) obj).toString());
        String str = this.postId;
        if (str == null) {
            Intrinsics.throwUninitializedPropertyAccessException(ShareConstants.RESULT_POST_ID);
        }
        addCommentRequest.setPostId(str);
        SoftKeyboardUtil softKeyboardUtil = SoftKeyboardUtil.INSTANCE;
        EditText editText2 = getBinding().addCommentEditText;
        Intrinsics.checkNotNullExpressionValue(editText2, "binding.addCommentEditText");
        softKeyboardUtil.hideKeyboard(editText2);
        this.selectedGifUrl = "";
        String str2 = null;
        this.selectedGifId = str2;
        CharSequence commentImagePath = getViewModel().getCommentImagePath();
        if (!(commentImagePath == null || commentImagePath.length() == 0)) {
            getViewModel().setCommentImagePath(str2);
        }
        getViewModel().updateComment(addCommentRequest);
    }

    /* access modifiers changed from: private */
    public final void updateReply() {
        SoftKeyboardUtil softKeyboardUtil = SoftKeyboardUtil.INSTANCE;
        EditText editText = getBinding().addCommentEditText;
        Intrinsics.checkNotNullExpressionValue(editText, "binding.addCommentEditText");
        softKeyboardUtil.hideKeyboard(editText);
        EditText editText2 = getBinding().addCommentEditText;
        Intrinsics.checkNotNullExpressionValue(editText2, "binding.addCommentEditText");
        String obj = editText2.getText().toString();
        Objects.requireNonNull(obj, "null cannot be cast to non-null type kotlin.CharSequence");
        String obj2 = StringsKt.trim((CharSequence) obj).toString();
        PostComment postComment = getViewModel().getPostComment();
        if (postComment != null) {
            postComment.setCommentText(obj2);
        }
        getViewModel().updateReplyToComment(obj2);
    }

    /* access modifiers changed from: private */
    public final void addReply() {
        SoftKeyboardUtil softKeyboardUtil = SoftKeyboardUtil.INSTANCE;
        EditText editText = getBinding().addCommentEditText;
        Intrinsics.checkNotNullExpressionValue(editText, "binding.addCommentEditText");
        softKeyboardUtil.hideKeyboard(editText);
        EditText editText2 = getBinding().addCommentEditText;
        Intrinsics.checkNotNullExpressionValue(editText2, "binding.addCommentEditText");
        String obj = editText2.getText().toString();
        Objects.requireNonNull(obj, "null cannot be cast to non-null type kotlin.CharSequence");
        getViewModel().addReplyToComment(StringsKt.trim((CharSequence) obj).toString(), this.selectedGifId);
    }

    private final void setEditorListener() {
        EditText editText = getBinding().addCommentEditText;
        Intrinsics.checkNotNullExpressionValue(editText, "binding.addCommentEditText");
        editText.addTextChangedListener(new C4271xa2daedc2(this));
    }

    /* access modifiers changed from: private */
    public final void checkForMentions(String str) {
        if (!StringsKt.isBlank(str)) {
            TextView textView = getBinding().replyingTextView;
            Intrinsics.checkNotNullExpressionValue(textView, "binding.replyingTextView");
            boolean z = false;
            if (textView.getVisibility() == 0) {
                EditText editText = getBinding().addCommentEditText;
                Intrinsics.checkNotNullExpressionValue(editText, "binding.addCommentEditText");
                SocialValidator.INSTANCE.checkForSuggestions(str, editText.getSelectionStart());
                if (SocialValidator.INSTANCE.getMatchedQuery().length() > 0) {
                    z = true;
                }
                if (z) {
                    int currentState = SocialValidator.INSTANCE.getCurrentState();
                    if (currentState == 1) {
                        showMentions(SocialValidator.INSTANCE.getMatchedQuery());
                    } else if (currentState == 2) {
                        showTags(SocialValidator.INSTANCE.getMatchedQuery());
                    } else if (currentState == 3) {
                        RecyclerView recyclerView = getBinding().userSearchRecyclerView;
                        Intrinsics.checkNotNullExpressionValue(recyclerView, "binding.userSearchRecyclerView");
                        recyclerView.setVisibility(8);
                    }
                } else {
                    RecyclerView recyclerView2 = getBinding().userSearchRecyclerView;
                    Intrinsics.checkNotNullExpressionValue(recyclerView2, "binding.userSearchRecyclerView");
                    recyclerView2.setVisibility(8);
                }
            }
        }
    }

    private final void showMentions(String str) {
        Timber.m303e("mention -> @" + str, new Object[0]);
        getExploreSearchViewModel().searchKeywordChanged(str);
        RecyclerView recyclerView = getBinding().userSearchRecyclerView;
        Intrinsics.checkNotNullExpressionValue(recyclerView, "binding.userSearchRecyclerView");
        recyclerView.setVisibility(0);
        getExploreSearchViewModel().search(ExploreSearchType.PEOPLE);
    }

    private final void showTags(String str) {
        Timber.m303e("mention -> #" + str, new Object[0]);
        getExploreSearchViewModel().searchKeywordChanged(str);
        RecyclerView recyclerView = getBinding().userSearchRecyclerView;
        Intrinsics.checkNotNullExpressionValue(recyclerView, "binding.userSearchRecyclerView");
        recyclerView.setVisibility(0);
        getExploreSearchViewModel().search(ExploreSearchType.TAGS);
    }

    /* access modifiers changed from: private */
    public final void applyPostCommentAction(PostCommentAction postCommentAction) {
        String commentId = postCommentAction.getCommentId();
        int i = WhenMappings.$EnumSwitchMapping$0[postCommentAction.getActionType().ordinal()];
        boolean z = true;
        if (i != 1) {
            boolean z2 = false;
            if (i == 2) {
                CharSequence charSequence = commentId;
                if (charSequence == null || StringsKt.isBlank(charSequence)) {
                    z2 = true;
                }
                if (!z2) {
                    PostCommentsAdapter postCommentsAdapter = this.commentsAdapter;
                    if (postCommentsAdapter == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("commentsAdapter");
                    }
                    int findItemPositionWithId = postCommentsAdapter.findItemPositionWithId(commentId);
                    scrollToPosition(findItemPositionWithId);
                    new Handler().postDelayed(new PostCommentsActivity$applyPostCommentAction$1(this, findItemPositionWithId), 1000);
                    return;
                }
                PostCommentsAdapter postCommentsAdapter2 = this.commentsAdapter;
                if (postCommentsAdapter2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("commentsAdapter");
                }
                scrollToPosition(postCommentsAdapter2.getItemCount() - 1);
            } else if (i == 3) {
                CharSequence charSequence2 = commentId;
                if (charSequence2 != null && !StringsKt.isBlank(charSequence2)) {
                    z = false;
                }
                if (!z) {
                    PostCommentsAdapter postCommentsAdapter3 = this.commentsAdapter;
                    if (postCommentsAdapter3 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("commentsAdapter");
                    }
                    int findItemPositionWithId2 = postCommentsAdapter3.findItemPositionWithId(commentId);
                    PostCommentsAdapter postCommentsAdapter4 = this.commentsAdapter;
                    if (postCommentsAdapter4 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("commentsAdapter");
                    }
                    PostComment comment = postCommentsAdapter4.getComment(commentId);
                    scrollToPosition(findItemPositionWithId2);
                    if (comment != null) {
                        onCommentReplyClicked(comment);
                    }
                    new Handler().postDelayed(new PostCommentsActivity$applyPostCommentAction$2(this, findItemPositionWithId2), 1000);
                }
            }
        } else {
            SoftKeyboardUtil softKeyboardUtil = SoftKeyboardUtil.INSTANCE;
            EditText editText = getBinding().addCommentEditText;
            Intrinsics.checkNotNullExpressionValue(editText, "binding.addCommentEditText");
            softKeyboardUtil.showKeyboard(editText);
        }
    }

    private final void scrollToPosition(int i) {
        if (i != -1) {
            getBinding().commentsRecyclerView.postDelayed(new PostCommentsActivity$scrollToPosition$1(this, i), 200);
        }
    }

    public void onTagSearchResultTapped(TagSearchResult tagSearchResult) {
        Intrinsics.checkNotNullParameter(tagSearchResult, "tagSearchResult");
        EditText editText = getBinding().addCommentEditText;
        Intrinsics.checkNotNullExpressionValue(editText, "binding.addCommentEditText");
        editText.getText().replace(SocialValidator.INSTANCE.getStartIndex(), SocialValidator.INSTANCE.getEndIndex(), tagSearchResult.getTagName());
    }

    public void onPeopleSearchResultTapped(PeopleSearchResult peopleSearchResult) {
        Intrinsics.checkNotNullParameter(peopleSearchResult, "peopleSearchResult");
        EditText editText = getBinding().addCommentEditText;
        Intrinsics.checkNotNullExpressionValue(editText, "binding.addCommentEditText");
        Editable text = editText.getText();
        int startIndex = SocialValidator.INSTANCE.getStartIndex();
        int endIndex = SocialValidator.INSTANCE.getEndIndex();
        text.replace(startIndex, endIndex, "@" + peopleSearchResult.getUserName());
    }

    private final void registerViewModel() {
        LifecycleOwner lifecycleOwner = this;
        getViewModel().getCommentsLiveData().observe(lifecycleOwner, new PostCommentsActivity$registerViewModel$1(this));
        getViewModel().getLoadMoreTrackerLiveData().observe(lifecycleOwner, new PostCommentsActivity$registerViewModel$2(this));
        getViewModel().getAddCommentLiveData().observe(lifecycleOwner, new PostCommentsActivity$registerViewModel$3(this));
        getViewModel().getUpdateCommentLiveData().observe(lifecycleOwner, new PostCommentsActivity$registerViewModel$4(this));
        getViewModel().getContentVisibilityLiveData().observe(lifecycleOwner, new PostCommentsActivity$registerViewModel$5(this));
        getViewModel().getAddCommentReplyLiveData().observe(lifecycleOwner, new PostCommentsActivity$registerViewModel$6(this));
        getViewModel().getCommentPostButtonEnablerLiveData().observe(lifecycleOwner, new PostCommentsActivity$registerViewModel$7(this));
        getViewModel().getCommentLikeLiveData().observe(lifecycleOwner, new PostCommentsActivity$registerViewModel$8(this));
        getViewModel().getShowCommentsAllRepliesLiveData().observe(lifecycleOwner, new PostCommentsActivity$registerViewModel$9(this));
        getExploreSearchViewModel().getResultsLiveData().observe(lifecycleOwner, new PostCommentsActivity$registerViewModel$10(this));
        getExploreSearchViewModel().getResultTagSearchLiveData().observe(lifecycleOwner, new PostCommentsActivity$registerViewModel$11(this));
        getViewModel().getDeleteCommentLiveData().observe(lifecycleOwner, new PostCommentsActivity$registerViewModel$12(this));
        getViewModel().getDeleteReplyLiveData().observe(lifecycleOwner, new PostCommentsActivity$registerViewModel$13(this));
        getViewModel().getUpdateReplyLiveData().observe(lifecycleOwner, new PostCommentsActivity$registerViewModel$14(this));
        getViewModel().getLikeReplyLiveData().observe(lifecycleOwner, new PostCommentsActivity$registerViewModel$15(this));
    }

    /* access modifiers changed from: private */
    public final void setGifWrapperVisibility(boolean z) {
        boolean z2 = false;
        if (z) {
            RelativeLayout relativeLayout = getBinding().gifWrapperRelativeLayout;
            Intrinsics.checkNotNullExpressionValue(relativeLayout, "binding.gifWrapperRelativeLayout");
            relativeLayout.setVisibility(0);
            getBinding().selectedGifImageView.setImageResource(0);
            showPostButton();
            return;
        }
        RelativeLayout relativeLayout2 = getBinding().gifWrapperRelativeLayout;
        Intrinsics.checkNotNullExpressionValue(relativeLayout2, "binding.gifWrapperRelativeLayout");
        relativeLayout2.setVisibility(8);
        getBinding().selectedGifImageView.setImageResource(0);
        EditText editText = getBinding().addCommentEditText;
        Intrinsics.checkNotNullExpressionValue(editText, "binding.addCommentEditText");
        CharSequence obj = editText.getText().toString();
        if (obj == null || obj.length() == 0) {
            z2 = true;
        }
        if (z2) {
            hidePostButton();
        }
    }

    /* access modifiers changed from: private */
    public final void showPeopleList(List<? extends CatalogueSearchResult> list) {
        PeopleSearchResultsAdapter peopleSearchResultsAdapter = this.peopleSearchAdapter;
        if (peopleSearchResultsAdapter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("peopleSearchAdapter");
        }
        peopleSearchResultsAdapter.setItems(list);
        RecyclerView recyclerView = getBinding().userSearchRecyclerView;
        Intrinsics.checkNotNullExpressionValue(recyclerView, "binding.userSearchRecyclerView");
        if (!(recyclerView.getAdapter() instanceof PeopleSearchResultsAdapter)) {
            RecyclerView recyclerView2 = getBinding().userSearchRecyclerView;
            Intrinsics.checkNotNullExpressionValue(recyclerView2, "binding.userSearchRecyclerView");
            LinearLayoutManager linearLayoutManager = this.searchlayoutManager;
            if (linearLayoutManager == null) {
                Intrinsics.throwUninitializedPropertyAccessException("searchlayoutManager");
            }
            recyclerView2.setLayoutManager(linearLayoutManager);
            RecyclerView recyclerView3 = getBinding().userSearchRecyclerView;
            Intrinsics.checkNotNullExpressionValue(recyclerView3, "binding.userSearchRecyclerView");
            PeopleSearchResultsAdapter peopleSearchResultsAdapter2 = this.peopleSearchAdapter;
            if (peopleSearchResultsAdapter2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("peopleSearchAdapter");
            }
            recyclerView3.setAdapter(peopleSearchResultsAdapter2);
        }
    }

    /* access modifiers changed from: private */
    public final void showTagsList(List<TagSearchResult> list) {
        TagSearchResultsAdapter tagSearchResultsAdapter = this.tagsSearchAdapter;
        if (tagSearchResultsAdapter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("tagsSearchAdapter");
        }
        tagSearchResultsAdapter.setItems(list);
        RecyclerView recyclerView = getBinding().userSearchRecyclerView;
        Intrinsics.checkNotNullExpressionValue(recyclerView, "binding.userSearchRecyclerView");
        if (!(recyclerView.getAdapter() instanceof TagSearchResultsAdapter)) {
            RecyclerView recyclerView2 = getBinding().userSearchRecyclerView;
            Intrinsics.checkNotNullExpressionValue(recyclerView2, "binding.userSearchRecyclerView");
            LinearLayoutManager linearLayoutManager = this.searchlayoutManager;
            if (linearLayoutManager == null) {
                Intrinsics.throwUninitializedPropertyAccessException("searchlayoutManager");
            }
            recyclerView2.setLayoutManager(linearLayoutManager);
            RecyclerView recyclerView3 = getBinding().userSearchRecyclerView;
            Intrinsics.checkNotNullExpressionValue(recyclerView3, "binding.userSearchRecyclerView");
            TagSearchResultsAdapter tagSearchResultsAdapter2 = this.tagsSearchAdapter;
            if (tagSearchResultsAdapter2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("tagsSearchAdapter");
            }
            recyclerView3.setAdapter(tagSearchResultsAdapter2);
        }
    }

    /* access modifiers changed from: private */
    public final void hidePostButton() {
        TextView textView = getBinding().postCommentTextView;
        Intrinsics.checkNotNullExpressionValue(textView, "binding.postCommentTextView");
        if (textView.getVisibility() == 0) {
            TextView textView2 = getBinding().postCommentTextView;
            Intrinsics.checkNotNullExpressionValue(textView2, "binding.postCommentTextView");
            textView2.setEnabled(false);
            TextView textView3 = getBinding().postCommentTextView;
            Intrinsics.checkNotNullExpressionValue(textView3, "binding.postCommentTextView");
            textView3.setVisibility(8);
            getBinding().postCommentTextView.startAnimation(AnimationUtils.loadAnimation(this, C4199R.anim.slide_to_disapppear));
        }
    }

    /* access modifiers changed from: private */
    public final void showPostButton() {
        TextView textView = getBinding().postCommentTextView;
        Intrinsics.checkNotNullExpressionValue(textView, "binding.postCommentTextView");
        if (textView.getVisibility() == 8) {
            TextView textView2 = getBinding().postCommentTextView;
            Intrinsics.checkNotNullExpressionValue(textView2, "binding.postCommentTextView");
            textView2.setEnabled(true);
            TextView textView3 = getBinding().postCommentTextView;
            Intrinsics.checkNotNullExpressionValue(textView3, "binding.postCommentTextView");
            textView3.setVisibility(0);
            getBinding().postCommentTextView.startAnimation(AnimationUtils.loadAnimation(this, C4199R.anim.slide_to_appear));
        }
    }

    public void onCommentAuthorProfileClicked(PostComment postComment) {
        Intrinsics.checkNotNullParameter(postComment, "comment");
        TargetedNavigation.INSTANCE.launch(this, new TargetedNavigation.ProfilePageRequest(postComment.getUserId(), postComment.getUsername()));
    }

    public void onCommentHighlightedTextTapped(PostComment postComment, int i, String str) {
        Intrinsics.checkNotNullParameter(postComment, "postComment");
        Intrinsics.checkNotNullParameter(str, "matchedText");
        if (i == 1) {
            TargetedNavigation.INSTANCE.launch(this, new TargetedNavigation.HashTagPageRequest(str));
        } else if (i == 2) {
            TargetedNavigation.INSTANCE.launch(this, new TargetedNavigation.ProfilePageRequest((String) null, str));
        }
    }

    public void onReplyAuthorProfileClicked(Reply reply) {
        Intrinsics.checkNotNullParameter(reply, "comment");
        TargetedNavigation.INSTANCE.launch(this, new TargetedNavigation.ProfilePageRequest(reply.getUserId(), reply.getUsername()));
    }

    public void onCommentLikeButtonClicked(PostComment postComment) {
        Intrinsics.checkNotNullParameter(postComment, "comment");
        EventTrackingManager trackingManager = App.Companion.trackingManager();
        CharSequence commentImage = postComment.getCommentImage();
        trackingManager.onCommentLiked(!(commentImage == null || StringsKt.isBlank(commentImage)), postComment.getPostId(), postComment.getCommentId());
        getViewModel().switchCommentLikeStatus(postComment);
    }

    public void onCommentReplyClicked(PostComment postComment) {
        Intrinsics.checkNotNullParameter(postComment, "comment");
        EventTrackingManager trackingManager = App.Companion.trackingManager();
        CharSequence commentImage = postComment.getCommentImage();
        trackingManager.onReplyLiked(!(commentImage == null || StringsKt.isBlank(commentImage)), postComment.getPostId(), postComment.getCommentId(), postComment.getReplyId());
        postComment.setState(ReplyState.INSTANCE.getSTATE_ADD());
        showReplySection(postComment, "@" + postComment.getUsername() + StringUtils.SPACE);
    }

    private final void showReplySection(PostComment postComment, String str) {
        getBinding().addCommentEditText.setText(str);
        getBinding().addCommentEditText.setSelection(str.length());
        RelativeLayout relativeLayout = getBinding().replyingRelativeLayout;
        Intrinsics.checkNotNullExpressionValue(relativeLayout, "binding.replyingRelativeLayout");
        relativeLayout.setVisibility(0);
        TextView textView = getBinding().replyingTextView;
        Intrinsics.checkNotNullExpressionValue(textView, "binding.replyingTextView");
        textView.setText("reply to " + postComment.getUsername());
        getViewModel().setPostComment(postComment);
        SoftKeyboardUtil softKeyboardUtil = SoftKeyboardUtil.INSTANCE;
        EditText editText = getBinding().addCommentEditText;
        Intrinsics.checkNotNullExpressionValue(editText, "binding.addCommentEditText");
        softKeyboardUtil.showKeyboard(editText);
    }

    public void onReplyDeleteClicked(Reply reply) {
        Intrinsics.checkNotNullParameter(reply, "comment");
        DialogUtil.INSTANCE.askConfirmation((Context) this, "", getString(C4199R.string.delete_confirmation_message), true, (DialogUtil.Callback<Boolean>) new PostCommentsActivity$onReplyDeleteClicked$1(this, reply));
    }

    public void onCommentDeleteClicked(PostComment postComment) {
        Intrinsics.checkNotNullParameter(postComment, "comment");
        DialogUtil.INSTANCE.askConfirmation((Context) this, "", getString(C4199R.string.delete_confirmation_message), true, (DialogUtil.Callback<Boolean>) new PostCommentsActivity$onCommentDeleteClicked$1(this, postComment));
    }

    public void onCommentImageClicked(PostComment postComment, View view) {
        String commentImage;
        Intrinsics.checkNotNullParameter(postComment, "comment");
        Intrinsics.checkNotNullParameter(view, ViewHierarchyConstants.VIEW_KEY);
        if (postComment.getCommentType() == 1) {
            String commentImageUrl = postComment.getCommentImageUrl();
            if (commentImageUrl != null) {
                ActivityStarter.Companion.mo57312of(MediaViewerActivity.Companion.getStartIntent(this, MediaType.NETWORK_PHOTO, commentImageUrl)).startFrom((Activity) this);
            }
        } else if (postComment.getCommentType() == 4 && (commentImage = postComment.getCommentImage()) != null) {
            ActivityStarter.Companion.mo57312of(MediaViewerActivity.Companion.getStartIntent(this, MediaType.NETWORK_GIF, ApiRouting.GIPHY_CONTENT_ENDPOINT + commentImage + "/giphy.gif")).startFrom((Activity) this);
        }
    }

    public void fetchPreviousComments() {
        CommentsViewModel viewModel = getViewModel();
        String str = this.postId;
        if (str == null) {
            Intrinsics.throwUninitializedPropertyAccessException(ShareConstants.RESULT_POST_ID);
        }
        viewModel.fetchPostComments(str);
    }

    public void onLikeReplyClicked(Reply reply) {
        Intrinsics.checkNotNullParameter(reply, ModelType.message_reply);
        getViewModel().likeReply(reply);
    }

    public void onReportClicked(PostComment postComment) {
        Intrinsics.checkNotNullParameter(postComment, "comment");
        CommentsReportOptionsBottomSheet commentsReportOptionsBottomSheet = new CommentsReportOptionsBottomSheet();
        FragmentManager supportFragmentManager = getSupportFragmentManager();
        Intrinsics.checkNotNullExpressionValue(supportFragmentManager, "supportFragmentManager");
        commentsReportOptionsBottomSheet.show(supportFragmentManager, new CommentsReportOptionSelectionHandler(getViewModel(), postComment));
    }

    public void onEditReplyClicked(PostComment postComment) {
        Intrinsics.checkNotNullParameter(postComment, "comment");
        getViewModel().setPostComment((PostComment) null);
        postComment.setState(ReplyState.INSTANCE.getSTATE_UPDATE());
        ImageView imageView = getBinding().gifSelectionImageView;
        Intrinsics.checkNotNullExpressionValue(imageView, "binding.gifSelectionImageView");
        imageView.setVisibility(8);
        String commentText = postComment.getCommentText();
        if (commentText != null) {
            showReplySection(postComment, commentText);
        }
    }

    public void onCommentEditClicked(PostComment postComment) {
        Intrinsics.checkNotNullParameter(postComment, "comment");
        ImageView imageView = getBinding().gifSelectionImageView;
        Intrinsics.checkNotNullExpressionValue(imageView, "binding.gifSelectionImageView");
        imageView.setVisibility(8);
        getBinding().addCommentEditText.setText(postComment.getCommentText());
        EditText editText = getBinding().addCommentEditText;
        String commentText = postComment.getCommentText();
        Integer valueOf = commentText != null ? Integer.valueOf(commentText.length()) : null;
        Intrinsics.checkNotNull(valueOf);
        editText.setSelection(valueOf.intValue());
        getViewModel().setCommentId(postComment.getCommentId());
        showPostButton();
    }

    public void onCommentViewAllRepliesClicked(PostComment postComment, boolean z) {
        Intrinsics.checkNotNullParameter(postComment, "comment");
        if (z) {
            getViewModel().fetchCommentsAllReplies(postComment);
            return;
        }
        String commentId = postComment.getCommentId();
        if (commentId != null) {
            PostCommentsAdapter postCommentsAdapter = this.commentsAdapter;
            if (postCommentsAdapter == null) {
                Intrinsics.throwUninitializedPropertyAccessException("commentsAdapter");
            }
            postCommentsAdapter.removeListReplies(commentId);
        }
    }

    public void onImageFileSelected(int i, ImageContent imageContent) {
        Intrinsics.checkNotNullParameter(imageContent, "imageContent");
        if (i == RC_COMMENT_CAMERA_IMAGE) {
            MediaFile file = imageContent.getFile();
            getBinding().selectedGifImageView.setImageResource(0);
            RelativeLayout relativeLayout = getBinding().gifWrapperRelativeLayout;
            Intrinsics.checkNotNullExpressionValue(relativeLayout, "binding.gifWrapperRelativeLayout");
            relativeLayout.setVisibility(0);
            ((RequestBuilder) ((RequestBuilder) Glide.with((FragmentActivity) this).load(Uri.fromFile(file)).diskCacheStrategy(DiskCacheStrategy.NONE)).override(70, 70)).into(getBinding().selectedGifImageView);
            setGifWrapperVisibility(true);
            getViewModel().setCommentImagePath(file.getAbsolutePath());
            this.selectedGifId = null;
        }
    }
}
