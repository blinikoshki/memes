package com.memes.plus.p040ui.create_post;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Space;
import android.widget.TextView;
import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.widget.SwitchCompat;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.lifecycle.LifecycleOwner;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.facebook.share.internal.ShareConstants;
import com.livinglifetechway.quickpermissions_kotlin.PermissionsManagerKt;
import com.livinglifetechway.quickpermissions_kotlin.util.QuickPermissionsOptions;
import com.memes.commons.media.MediaContent;
import com.memes.commons.media.MediaFile;
import com.memes.commons.recycleradapter.AdapterItemCountChangeListener;
import com.memes.commons.util.ActivityResultExtKt;
import com.memes.commons.util.ExtensionsKt;
import com.memes.commons.util.Intents;
import com.memes.commons.util.SoftKeyboardUtil;
import com.memes.crashreporter.CrashLog;
import com.memes.crashreporter.HarmlessCrashException;
import com.memes.plus.App;
import com.memes.plus.C4199R;
import com.memes.plus.base.BaseActivity;
import com.memes.plus.custom.SpacingItemDecoration;
import com.memes.plus.databinding.ExportPostActivityBinding;
import com.memes.plus.p040ui.apprating.AppRatingRequestBottomSheet;
import com.memes.plus.p040ui.create_post.SavedHashTagsAdapter;
import com.memes.plus.p040ui.create_post.catalogueselection.ExportCatalogueSelectionActivity;
import com.memes.plus.p040ui.create_post.catalogueselection.ExportCatalogueType;
import com.memes.plus.p040ui.create_post.tagpeople.TagPeopleActivity;
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
import com.memes.plus.p040ui.subscription.validation.SubscriptionStatusViewModel;
import com.memes.plus.util.Constants;
import com.memes.plus.util.ShareFileUtil;
import com.memes.plus.util.SocialValidator;
import editor.editor.plan.EditorPlan;
import java.util.Collection;
import java.util.List;
import java.util.Objects;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlin.text.StringsKt;
import org.apache.commons.lang3.StringUtils;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000¾\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 l2\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u00042\u00020\u0005:\u0001lB\u0005¢\u0006\u0002\u0010\u0006J\b\u00108\u001a\u000209H\u0002J\u0010\u0010:\u001a\u0002092\u0006\u0010;\u001a\u00020<H\u0002J\b\u0010=\u001a\u000209H\u0002J\b\u0010>\u001a\u000209H\u0002J\b\u0010?\u001a\u000209H\u0002J\u0018\u0010@\u001a\u0002092\u0006\u0010A\u001a\u00020B2\u0006\u0010C\u001a\u00020BH\u0002J\b\u0010D\u001a\u000209H\u0002J\u0010\u0010E\u001a\u0002092\u0006\u0010F\u001a\u00020\u001eH\u0002J\u0012\u0010G\u001a\u0002092\b\u0010H\u001a\u0004\u0018\u00010IH\u0014J\u0010\u0010J\u001a\u0002092\u0006\u0010K\u001a\u00020LH\u0016J\u0010\u0010M\u001a\u0002092\u0006\u0010K\u001a\u00020LH\u0016J\u0010\u0010N\u001a\u0002092\u0006\u0010O\u001a\u00020BH\u0016J\b\u0010P\u001a\u000209H\u0002J\u0010\u0010Q\u001a\u0002092\u0006\u0010R\u001a\u00020SH\u0016J\u0010\u0010T\u001a\u0002092\u0006\u0010R\u001a\u00020SH\u0016J\b\u0010U\u001a\u000209H\u0014J\b\u0010V\u001a\u000209H\u0002J\b\u0010W\u001a\u000209H\u0002J\b\u0010X\u001a\u000209H\u0002J\b\u0010Y\u001a\u000209H\u0002J\u0010\u0010Z\u001a\u0002092\u0006\u0010[\u001a\u00020\\H\u0016J\b\u0010]\u001a\u000209H\u0002J\u0010\u0010^\u001a\u0002092\u0006\u0010_\u001a\u00020LH\u0002J\u0010\u0010`\u001a\u0002092\u0006\u0010a\u001a\u00020LH\u0002J\u0010\u0010b\u001a\u0002092\u0006\u0010a\u001a\u00020LH\u0002J\b\u0010c\u001a\u000209H\u0002J\b\u0010d\u001a\u000209H\u0002J\u0018\u0010e\u001a\u0002092\u000e\u0010f\u001a\n\u0012\u0004\u0012\u00020\\\u0018\u00010gH\u0002J\u0018\u0010h\u001a\u0002092\u000e\u0010f\u001a\n\u0012\u0004\u0012\u00020i\u0018\u00010gH\u0002J\u0010\u0010j\u001a\u0002092\u0006\u0010k\u001a\u00020\u001eH\u0002R\u001b\u0010\u0007\u001a\u00020\b8BX\u0002¢\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\t\u0010\nR\u000e\u0010\r\u001a\u00020\u000eX\u0004¢\u0006\u0002\n\u0000R\u001b\u0010\u000f\u001a\u00020\u00108BX\u0002¢\u0006\f\n\u0004\b\u0013\u0010\f\u001a\u0004\b\u0011\u0010\u0012R\u001c\u0010\u0014\u001a\u0010\u0012\f\u0012\n \u0017*\u0004\u0018\u00010\u00160\u00160\u0015X\u0004¢\u0006\u0002\n\u0000R\u001b\u0010\u0018\u001a\u00020\u00198BX\u0002¢\u0006\f\n\u0004\b\u001c\u0010\f\u001a\u0004\b\u001a\u0010\u001bR\u000e\u0010\u001d\u001a\u00020\u001eX\u000e¢\u0006\u0002\n\u0000R\u001b\u0010\u001f\u001a\u00020 8BX\u0002¢\u0006\f\n\u0004\b#\u0010\f\u001a\u0004\b!\u0010\"R\u000e\u0010$\u001a\u00020%X.¢\u0006\u0002\n\u0000R\u001b\u0010&\u001a\u00020'8BX\u0002¢\u0006\f\n\u0004\b*\u0010\f\u001a\u0004\b(\u0010)R\u001b\u0010+\u001a\u00020,8BX\u0002¢\u0006\f\n\u0004\b/\u0010\f\u001a\u0004\b-\u0010.R\u001b\u00100\u001a\u0002018BX\u0002¢\u0006\f\n\u0004\b4\u0010\f\u001a\u0004\b2\u00103R\u001c\u00105\u001a\u0010\u0012\f\u0012\n \u0017*\u0004\u0018\u00010\u00160\u00160\u0015X\u0004¢\u0006\u0002\n\u0000R\u000e\u00106\u001a\u000207X.¢\u0006\u0002\n\u0000¨\u0006m"}, mo26107d2 = {"Lcom/memes/plus/ui/create_post/ExportPostActivity;", "Lcom/memes/plus/base/BaseActivity;", "Lcom/memes/plus/ui/create_post/SavedHashTagsAdapter$Callback;", "Lcom/memes/plus/ui/explore_search/people_search/PeopleSearchResultAdapterListener;", "Lcom/memes/plus/ui/explore_search/tag_search/TagSearchResultsAdapterListener;", "Lcom/memes/commons/recycleradapter/AdapterItemCountChangeListener;", "()V", "binding", "Lcom/memes/plus/databinding/ExportPostActivityBinding;", "getBinding", "()Lcom/memes/plus/databinding/ExportPostActivityBinding;", "binding$delegate", "Lkotlin/Lazy;", "editorPlan", "Leditor/editor/plan/EditorPlan;", "exploreSearchViewModel", "Lcom/memes/plus/ui/explore_search/combined/ExploreSearchViewModel;", "getExploreSearchViewModel", "()Lcom/memes/plus/ui/explore_search/combined/ExploreSearchViewModel;", "exploreSearchViewModel$delegate", "exportCatalogueContractLauncher", "Landroidx/activity/result/ActivityResultLauncher;", "Landroid/content/Intent;", "kotlin.jvm.PlatformType", "exportPostViewModel", "Lcom/memes/plus/ui/create_post/ExportPostViewModel;", "getExportPostViewModel", "()Lcom/memes/plus/ui/create_post/ExportPostViewModel;", "exportPostViewModel$delegate", "isEditingCaptionManually", "", "itemTouchReOrder", "Landroidx/recyclerview/widget/ItemTouchHelper;", "getItemTouchReOrder", "()Landroidx/recyclerview/widget/ItemTouchHelper;", "itemTouchReOrder$delegate", "peopleSearchAdapter", "Lcom/memes/plus/ui/explore_search/people_search/PeopleSearchResultsAdapter;", "savedHashTagsAdapter", "Lcom/memes/plus/ui/create_post/SavedHashTagsAdapter;", "getSavedHashTagsAdapter", "()Lcom/memes/plus/ui/create_post/SavedHashTagsAdapter;", "savedHashTagsAdapter$delegate", "shareFileUtil", "Lcom/memes/plus/util/ShareFileUtil;", "getShareFileUtil", "()Lcom/memes/plus/util/ShareFileUtil;", "shareFileUtil$delegate", "subscriptionStatusViewModel", "Lcom/memes/plus/ui/subscription/validation/SubscriptionStatusViewModel;", "getSubscriptionStatusViewModel", "()Lcom/memes/plus/ui/subscription/validation/SubscriptionStatusViewModel;", "subscriptionStatusViewModel$delegate", "tagPeopleContractLauncher", "tagsSearchAdapter", "Lcom/memes/plus/ui/explore_search/tag_search/TagSearchResultsAdapter;", "attachObservers", "", "handleTagPeopleActivityResult", "result", "Landroidx/activity/result/ActivityResult;", "initCaptionTagSuggestionsUi", "initSavedHashTagsUi", "initUi", "moveItem", "from", "", "to", "onAddHashTagViewTapped", "onChangeAutoSavePreference", "checked", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDeleteHashTagTapped", "hashTag", "", "onHashTagTapped", "onItemCountChanged", "newCount", "onMemePreviewThumbnailTapped", "onPeopleSearchResultTapped", "peopleSearchResult", "Lcom/memes/plus/ui/explore_search/people_search/PeopleSearchResult;", "onRemoveSuggestedPersonViewTapped", "onResume", "onSaveExportedMemeViewTapped", "onShareExportedMemeViewTapped", "onShowSharingOptionsViewTapped", "onTagPeopleViewTapped", "onTagSearchResultTapped", "tagSearchResult", "Lcom/memes/plus/ui/explore_search/tag_search/TagSearchResult;", "rateApp", "refreshSuggestions", "inputText", "searchForHashTagSuggestions", "query", "searchForPeopleSuggestions", "showAppRatingSheetIfNotRated", "showAutoSavePreferences", "showHashTagSuggestions", "items", "", "showPeopleSuggestions", "Lcom/memes/plus/ui/explore_search/people_search/CatalogueSearchResult;", "updatePremiumButtonLayout", "shouldShow", "Companion", "app_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
/* renamed from: com.memes.plus.ui.create_post.ExportPostActivity */
/* compiled from: ExportPostActivity.kt */
public final class ExportPostActivity extends BaseActivity implements SavedHashTagsAdapter.Callback, PeopleSearchResultAdapterListener, TagSearchResultsAdapterListener, AdapterItemCountChangeListener {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private static final String EXTRA_MEDIA_CONTENT = "intent.extra._media_content";
    private static final String EXTRA_POST_ID = "intent.extra._post_id";
    private final Lazy binding$delegate = LazyKt.lazy(new ExportPostActivity$binding$2(this));
    /* access modifiers changed from: private */
    public final EditorPlan editorPlan = EditorPlan.Companion.rookie();
    private final Lazy exploreSearchViewModel$delegate = LazyKt.lazy(new ExportPostActivity$exploreSearchViewModel$2(this));
    private final ActivityResultLauncher<Intent> exportCatalogueContractLauncher;
    private final Lazy exportPostViewModel$delegate = LazyKt.lazy(new ExportPostActivity$exportPostViewModel$2(this));
    /* access modifiers changed from: private */
    public boolean isEditingCaptionManually;
    private final Lazy itemTouchReOrder$delegate = LazyKt.lazy(new ExportPostActivity$itemTouchReOrder$2(this));
    private PeopleSearchResultsAdapter peopleSearchAdapter;
    private final Lazy savedHashTagsAdapter$delegate = LazyKt.lazy(new ExportPostActivity$savedHashTagsAdapter$2(this));
    private final Lazy shareFileUtil$delegate = LazyKt.lazy(new ExportPostActivity$shareFileUtil$2(this));
    private final Lazy subscriptionStatusViewModel$delegate = LazyKt.lazy(new ExportPostActivity$subscriptionStatusViewModel$2(this));
    private final ActivityResultLauncher<Intent> tagPeopleContractLauncher;
    private TagSearchResultsAdapter tagsSearchAdapter;

    /* access modifiers changed from: private */
    public final ExportPostActivityBinding getBinding() {
        return (ExportPostActivityBinding) this.binding$delegate.getValue();
    }

    private final ExploreSearchViewModel getExploreSearchViewModel() {
        return (ExploreSearchViewModel) this.exploreSearchViewModel$delegate.getValue();
    }

    /* access modifiers changed from: private */
    public final ExportPostViewModel getExportPostViewModel() {
        return (ExportPostViewModel) this.exportPostViewModel$delegate.getValue();
    }

    private final ItemTouchHelper getItemTouchReOrder() {
        return (ItemTouchHelper) this.itemTouchReOrder$delegate.getValue();
    }

    /* access modifiers changed from: private */
    public final SavedHashTagsAdapter getSavedHashTagsAdapter() {
        return (SavedHashTagsAdapter) this.savedHashTagsAdapter$delegate.getValue();
    }

    /* access modifiers changed from: private */
    public final ShareFileUtil getShareFileUtil() {
        return (ShareFileUtil) this.shareFileUtil$delegate.getValue();
    }

    private final SubscriptionStatusViewModel getSubscriptionStatusViewModel() {
        return (SubscriptionStatusViewModel) this.subscriptionStatusViewModel$delegate.getValue();
    }

    public void onRemoveSuggestedPersonViewTapped(PeopleSearchResult peopleSearchResult) {
        Intrinsics.checkNotNullParameter(peopleSearchResult, "peopleSearchResult");
    }

    public ExportPostActivity() {
        ActivityResultLauncher<Intent> registerForActivityResult = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), new ExportPostActivity$exportCatalogueContractLauncher$1(this));
        Intrinsics.checkNotNullExpressionValue(registerForActivityResult, "registerForActivityResul…r.addItem(hashTag)\n\t\t}\n\t}");
        this.exportCatalogueContractLauncher = registerForActivityResult;
        ActivityResultLauncher<Intent> registerForActivityResult2 = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), new ExportPostActivity$tagPeopleContractLauncher$1(this));
        Intrinsics.checkNotNullExpressionValue(registerForActivityResult2, "registerForActivityResul…eActivityResult(result) }");
        this.tagPeopleContractLauncher = registerForActivityResult2;
    }

    @Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0016\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bJ\u001e\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u0004J\u0016\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\r\u001a\u00020\u000eR\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u000f"}, mo26107d2 = {"Lcom/memes/plus/ui/create_post/ExportPostActivity$Companion;", "", "()V", "EXTRA_MEDIA_CONTENT", "", "EXTRA_POST_ID", "getStartIntent", "Landroid/content/Intent;", "context", "Landroid/content/Context;", "mediaContent", "Lcom/memes/commons/media/MediaContent;", "postId", "mediaFile", "Lcom/memes/commons/media/MediaFile;", "app_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
    /* renamed from: com.memes.plus.ui.create_post.ExportPostActivity$Companion */
    /* compiled from: ExportPostActivity.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final Intent getStartIntent(Context context, MediaContent mediaContent) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(mediaContent, "mediaContent");
            Intent intent = new Intent(context, ExportPostActivity.class);
            intent.putExtra("intent.extra._media_content", mediaContent);
            return intent;
        }

        public final Intent getStartIntent(Context context, MediaFile mediaFile) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(mediaFile, "mediaFile");
            return getStartIntent(context, mediaFile.toMediaContent());
        }

        public final Intent getStartIntent(Context context, MediaContent mediaContent, String str) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(mediaContent, "mediaContent");
            Intrinsics.checkNotNullParameter(str, ShareConstants.RESULT_POST_ID);
            Intent intent = new Intent(context, ExportPostActivity.class);
            intent.putExtra("intent.extra._media_content", mediaContent);
            intent.putExtra("intent.extra._post_id", str);
            return intent;
        }
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        ExportPostActivityBinding binding = getBinding();
        Intrinsics.checkNotNullExpressionValue(binding, "binding");
        setContentView((View) binding.getRoot());
        initUi();
        attachObservers();
        MediaContent mediaContent = (MediaContent) getIntent().getParcelableExtra("intent.extra._media_content");
        getExportPostViewModel().onPostIdChanged(getIntent().getStringExtra("intent.extra._post_id"));
        if (mediaContent == null) {
            ExtensionsKt.toast((Context) this, Constants.UNUSUAL_ERROR);
            finish();
            return;
        }
        getExportPostViewModel().mediaContentChanged(mediaContent);
        getExportPostViewModel().fetchSavedHashTags();
        showAppRatingSheetIfNotRated();
        showAutoSavePreferences();
    }

    private final void initUi() {
        getBinding().backImageView.setOnClickListener(new ExportPostActivity$initUi$1(this));
        getBinding().memePreviewImageView.setOnClickListener(new ExportPostActivity$initUi$2(this));
        EditText editText = getBinding().memeCaptionEditText;
        Intrinsics.checkNotNullExpressionValue(editText, "binding.memeCaptionEditText");
        ExtensionsKt.setMultiLineCapSentencesAndDoneAction(editText);
        EditText editText2 = getBinding().memeCaptionEditText;
        Intrinsics.checkNotNullExpressionValue(editText2, "binding.memeCaptionEditText");
        editText2.addTextChangedListener(new ExportPostActivity$initUi$$inlined$addTextChangedListener$1(this));
        EditText editText3 = getBinding().memeCaptionEditText;
        Intrinsics.checkNotNullExpressionValue(editText3, "binding.memeCaptionEditText");
        editText3.addTextChangedListener(new ExportPostActivity$initUi$$inlined$addTextChangedListener$2(this));
        getBinding().addHashTagsTextView.setOnClickListener(new ExportPostActivity$initUi$5(this));
        getBinding().hashTagsTitleTextView.setOnClickListener(new ExportPostActivity$initUi$6(this));
        getBinding().addYourFavoriteTextView.setOnClickListener(new ExportPostActivity$initUi$7(this));
        getBinding().tagPeopleLayout.setOnClickListener(new ExportPostActivity$initUi$8(this));
        getBinding().moreSharingLayout.setOnClickListener(new ExportPostActivity$initUi$9(this));
        getBinding().savePostTextView.setOnClickListener(new ExportPostActivity$initUi$10(this));
        getBinding().exportPostTextView.setOnClickListener(new ExportPostActivity$initUi$11(this));
        getBinding().premiumButtonLayout.setOnClickListener(new ExportPostActivity$initUi$12(this));
        getBinding().memeAutoSaveSwitch.setOnCheckedChangeListener(new ExportPostActivity$initUi$13(this));
        initCaptionTagSuggestionsUi();
        initSavedHashTagsUi();
    }

    /* access modifiers changed from: private */
    public final void onChangeAutoSavePreference(boolean z) {
        getExportPostViewModel().setAutoSavePost(z);
    }

    private final void showAutoSavePreferences() {
        SwitchCompat switchCompat = getBinding().memeAutoSaveSwitch;
        Intrinsics.checkNotNullExpressionValue(switchCompat, "binding.memeAutoSaveSwitch");
        switchCompat.setChecked(getExportPostViewModel().isAutoSavePost());
    }

    private final void initCaptionTagSuggestionsUi() {
        Context context = this;
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(context);
        RecyclerView recyclerView = getBinding().captionSuggestionsRecyclerView;
        Intrinsics.checkNotNullExpressionValue(recyclerView, "binding.captionSuggestionsRecyclerView");
        recyclerView.setLayoutManager(linearLayoutManager);
        this.peopleSearchAdapter = new PeopleSearchResultsAdapter(context, this);
        this.tagsSearchAdapter = new TagSearchResultsAdapter(context, this);
    }

    private final void initSavedHashTagsUi() {
        RecyclerView recyclerView = getBinding().hashTagsRecyclerView;
        Intrinsics.checkNotNullExpressionValue(recyclerView, "recyclerView");
        recyclerView.setLayoutManager(new LinearLayoutManager(this, 0, false));
        int dimensionPixelSize = getResources().getDimensionPixelSize(C4199R.dimen._5sdp);
        recyclerView.addItemDecoration(new SpacingItemDecoration(dimensionPixelSize, dimensionPixelSize));
        getSavedHashTagsAdapter().setAdapterItemCountChangeListener(this);
        recyclerView.setAdapter(getSavedHashTagsAdapter());
        getItemTouchReOrder().attachToRecyclerView(getBinding().hashTagsRecyclerView);
    }

    private final void attachObservers() {
        registerViewModel(getExportPostViewModel());
        LifecycleOwner lifecycleOwner = this;
        getExportPostViewModel().preview().observe(lifecycleOwner, new ExportPostActivity$attachObservers$1(this));
        getExportPostViewModel().showPreviewVideoIndicator().observe(lifecycleOwner, new ExportPostActivity$attachObservers$2(this));
        getExportPostViewModel().savedTags().observe(lifecycleOwner, new ExportPostActivity$attachObservers$3(this));
        getExportPostViewModel().shareExternal().observe(lifecycleOwner, new ExportPostActivity$attachObservers$4(this));
        getExportPostViewModel().posted().observe(lifecycleOwner, new ExportPostActivity$attachObservers$5(this));
        getExploreSearchViewModel().getResultsLiveData().observe(lifecycleOwner, new ExportPostActivity$attachObservers$6(this));
        getExploreSearchViewModel().getResultTagSearchLiveData().observe(lifecycleOwner, new ExportPostActivity$attachObservers$7(this));
        getExploreSearchViewModel().getContentVisibilityLiveData().observe(lifecycleOwner, ExportPostActivity$attachObservers$8.INSTANCE);
        getSubscriptionStatusViewModel().onPremiumVerificationResultAvailable().observe(lifecycleOwner, new ExportPostActivity$attachObservers$9(this));
        getLifecycle().addObserver(getSubscriptionStatusViewModel().getBillingClientLifecycle());
        getExportPostViewModel().onAutoSavePostChanged().observe(lifecycleOwner, new ExportPostActivity$attachObservers$10(this));
    }

    /* access modifiers changed from: private */
    public final void updatePremiumButtonLayout(boolean z) {
        Space space = getBinding().premiumButtonSpacer;
        Intrinsics.checkNotNullExpressionValue(space, "binding.premiumButtonSpacer");
        ViewGroup.LayoutParams layoutParams = space.getLayoutParams();
        Objects.requireNonNull(layoutParams, "null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
        ConstraintLayout.LayoutParams layoutParams2 = (ConstraintLayout.LayoutParams) layoutParams;
        if (z) {
            LinearLayout linearLayout = getBinding().premiumButtonLayout;
            Intrinsics.checkNotNullExpressionValue(linearLayout, "binding.premiumButtonLayout");
            linearLayout.setVisibility(0);
            layoutParams2.height = getResources().getDimensionPixelOffset(C4199R.dimen._32sdp);
            return;
        }
        LinearLayout linearLayout2 = getBinding().premiumButtonLayout;
        Intrinsics.checkNotNullExpressionValue(linearLayout2, "binding.premiumButtonLayout");
        linearLayout2.setVisibility(8);
        layoutParams2.height = getResources().getDimensionPixelOffset(C4199R.dimen._24sdp);
    }

    /* access modifiers changed from: private */
    public final void onMemePreviewThumbnailTapped() {
        startActivity(MediaViewerActivity.Companion.getStartIntent(this, getExportPostViewModel().requireMediaFile()));
    }

    /* access modifiers changed from: private */
    public final void onAddHashTagViewTapped() {
        this.exportCatalogueContractLauncher.launch(ExportCatalogueSelectionActivity.Companion.getStartIntent(this, ExportCatalogueType.HASHTAGS));
    }

    /* access modifiers changed from: private */
    public final void onTagPeopleViewTapped() {
        this.tagPeopleContractLauncher.launch(TagPeopleActivity.Companion.getStartIntent(this, getExportPostViewModel().requireMediaFile(), getExportPostViewModel().getTaggedPeopleJson()));
    }

    /* access modifiers changed from: private */
    public final void onShowSharingOptionsViewTapped() {
        App.Companion.trackingManager().onShareCreatedPostTapped();
        PermissionsManagerKt.runWithPermissions$default((Context) this, new String[]{"android.permission.WRITE_EXTERNAL_STORAGE"}, (QuickPermissionsOptions) null, (Function0) new ExportPostActivity$onShowSharingOptionsViewTapped$1(this), 2, (Object) null);
    }

    /* access modifiers changed from: private */
    public final void onSaveExportedMemeViewTapped() {
        if (!getExportPostViewModel().isAutoSavePost()) {
            App.Companion.trackingManager().onCreatePostPageSaveTapped();
            PermissionsManagerKt.runWithPermissions$default((Context) this, new String[]{"android.permission.WRITE_EXTERNAL_STORAGE"}, (QuickPermissionsOptions) null, (Function0) new ExportPostActivity$onSaveExportedMemeViewTapped$1(this), 2, (Object) null);
        }
    }

    /* access modifiers changed from: private */
    public final void onShareExportedMemeViewTapped() {
        App.Companion.trackingManager().onUploadPostTapped();
        getExportPostViewModel().postMeme();
    }

    /* access modifiers changed from: private */
    public final void handleTagPeopleActivityResult(ActivityResult activityResult) {
        Intent dataIfOkResult = ActivityResultExtKt.getDataIfOkResult(activityResult);
        if (dataIfOkResult != null) {
            String stringExtra = dataIfOkResult.getStringExtra(TagPeopleActivity.EXTRA_TAGGED_PEOPLE);
            boolean z = false;
            int intExtra = dataIfOkResult.getIntExtra(TagPeopleActivity.EXTRA_TAGGED_PEOPLE_COUNT, 0);
            String stringExtra2 = dataIfOkResult.getStringExtra(TagPeopleActivity.EXTRA_TAGGED_PEOPLE_NAME);
            if (intExtra == 0) {
                stringExtra2 = "";
            } else if (intExtra != 1) {
                stringExtra2 = intExtra + " People";
            } else {
                CharSequence charSequence = stringExtra2;
                if (charSequence == null || StringsKt.isBlank(charSequence)) {
                    z = true;
                }
                if (z) {
                    stringExtra2 = "1";
                }
            }
            TextView textView = getBinding().tagsPeopleCountTextView;
            Intrinsics.checkNotNullExpressionValue(textView, "binding.tagsPeopleCountTextView");
            textView.setText(stringExtra2);
            if (intExtra <= 0) {
                getExportPostViewModel().taggedPeopleInputChanged((String) null);
            } else {
                getExportPostViewModel().taggedPeopleInputChanged(stringExtra);
            }
        }
    }

    /* access modifiers changed from: private */
    public final void refreshSuggestions(String str) {
        if (!StringsKt.isBlank(str)) {
            EditText editText = getBinding().memeCaptionEditText;
            Intrinsics.checkNotNullExpressionValue(editText, "binding.memeCaptionEditText");
            SocialValidator.INSTANCE.checkForSuggestions(str, editText.getSelectionStart());
            String matchedQuery = SocialValidator.INSTANCE.getMatchedQuery();
            if (matchedQuery.length() > 0) {
                int currentState = SocialValidator.INSTANCE.getCurrentState();
                if (currentState == 1) {
                    searchForPeopleSuggestions(matchedQuery);
                } else if (currentState == 2) {
                    searchForHashTagSuggestions(matchedQuery);
                } else if (currentState == 3) {
                    RecyclerView recyclerView = getBinding().captionSuggestionsRecyclerView;
                    Intrinsics.checkNotNullExpressionValue(recyclerView, "binding.captionSuggestionsRecyclerView");
                    recyclerView.setVisibility(8);
                }
            } else {
                RecyclerView recyclerView2 = getBinding().captionSuggestionsRecyclerView;
                Intrinsics.checkNotNullExpressionValue(recyclerView2, "binding.captionSuggestionsRecyclerView");
                recyclerView2.setVisibility(8);
            }
        }
    }

    private final void searchForPeopleSuggestions(String str) {
        getExploreSearchViewModel().searchKeywordChanged(str);
        getExploreSearchViewModel().search(ExploreSearchType.PEOPLE);
    }

    private final void searchForHashTagSuggestions(String str) {
        getExploreSearchViewModel().searchKeywordChanged(str);
        getExploreSearchViewModel().search(ExploreSearchType.TAGS);
    }

    /* access modifiers changed from: private */
    public final void showPeopleSuggestions(List<? extends CatalogueSearchResult> list) {
        PeopleSearchResultsAdapter peopleSearchResultsAdapter = this.peopleSearchAdapter;
        if (peopleSearchResultsAdapter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("peopleSearchAdapter");
        }
        peopleSearchResultsAdapter.setItems(list);
        RecyclerView recyclerView = getBinding().captionSuggestionsRecyclerView;
        Intrinsics.checkNotNullExpressionValue(recyclerView, "binding.captionSuggestionsRecyclerView");
        if (!(recyclerView.getAdapter() instanceof PeopleSearchResultsAdapter)) {
            RecyclerView recyclerView2 = getBinding().captionSuggestionsRecyclerView;
            Intrinsics.checkNotNullExpressionValue(recyclerView2, "binding.captionSuggestionsRecyclerView");
            PeopleSearchResultsAdapter peopleSearchResultsAdapter2 = this.peopleSearchAdapter;
            if (peopleSearchResultsAdapter2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("peopleSearchAdapter");
            }
            recyclerView2.setAdapter(peopleSearchResultsAdapter2);
        }
        Collection collection = list;
        if (collection == null || collection.isEmpty()) {
            RecyclerView recyclerView3 = getBinding().captionSuggestionsRecyclerView;
            Intrinsics.checkNotNullExpressionValue(recyclerView3, "binding.captionSuggestionsRecyclerView");
            recyclerView3.setVisibility(8);
            return;
        }
        RecyclerView recyclerView4 = getBinding().captionSuggestionsRecyclerView;
        Intrinsics.checkNotNullExpressionValue(recyclerView4, "binding.captionSuggestionsRecyclerView");
        recyclerView4.setVisibility(0);
    }

    /* access modifiers changed from: private */
    public final void showHashTagSuggestions(List<TagSearchResult> list) {
        TagSearchResultsAdapter tagSearchResultsAdapter = this.tagsSearchAdapter;
        if (tagSearchResultsAdapter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("tagsSearchAdapter");
        }
        tagSearchResultsAdapter.setItems(list);
        RecyclerView recyclerView = getBinding().captionSuggestionsRecyclerView;
        Intrinsics.checkNotNullExpressionValue(recyclerView, "binding.captionSuggestionsRecyclerView");
        if (!(recyclerView.getAdapter() instanceof TagSearchResultsAdapter)) {
            RecyclerView recyclerView2 = getBinding().captionSuggestionsRecyclerView;
            Intrinsics.checkNotNullExpressionValue(recyclerView2, "binding.captionSuggestionsRecyclerView");
            TagSearchResultsAdapter tagSearchResultsAdapter2 = this.tagsSearchAdapter;
            if (tagSearchResultsAdapter2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("tagsSearchAdapter");
            }
            recyclerView2.setAdapter(tagSearchResultsAdapter2);
        }
        Collection collection = list;
        if (collection == null || collection.isEmpty()) {
            RecyclerView recyclerView3 = getBinding().captionSuggestionsRecyclerView;
            Intrinsics.checkNotNullExpressionValue(recyclerView3, "binding.captionSuggestionsRecyclerView");
            recyclerView3.setVisibility(8);
            return;
        }
        RecyclerView recyclerView4 = getBinding().captionSuggestionsRecyclerView;
        Intrinsics.checkNotNullExpressionValue(recyclerView4, "binding.captionSuggestionsRecyclerView");
        recyclerView4.setVisibility(0);
    }

    public void onPeopleSearchResultTapped(PeopleSearchResult peopleSearchResult) {
        Intrinsics.checkNotNullParameter(peopleSearchResult, "peopleSearchResult");
        try {
            getExploreSearchViewModel().searchKeywordChanged((String) null);
            RecyclerView recyclerView = getBinding().captionSuggestionsRecyclerView;
            Intrinsics.checkNotNullExpressionValue(recyclerView, "binding.captionSuggestionsRecyclerView");
            recyclerView.setVisibility(8);
            EditText editText = getBinding().memeCaptionEditText;
            Intrinsics.checkNotNullExpressionValue(editText, "binding.memeCaptionEditText");
            Editable text = editText.getText();
            int startIndex = SocialValidator.INSTANCE.getStartIndex();
            int endIndex = SocialValidator.INSTANCE.getEndIndex();
            text.replace(startIndex, endIndex, "@" + peopleSearchResult.getUserName() + StringUtils.SPACE);
        } catch (Exception e) {
            CrashLog.Builder addMessage = new CrashLog.Builder(new HarmlessCrashException()).markHarmless().addMessage("We have encountered an issue in onPeopleSearchResultTapped.");
            CrashLog.Builder addMessage2 = addMessage.addMessage(" -> throwable-msg: " + e.getMessage());
            CrashLog.Builder addMessage3 = addMessage2.addMessage(" -> throwable-stack: " + e.getStackTrace());
            StringBuilder sb = new StringBuilder();
            sb.append(" -> current-text: ");
            EditText editText2 = getBinding().memeCaptionEditText;
            Intrinsics.checkNotNullExpressionValue(editText2, "binding.memeCaptionEditText");
            sb.append(editText2.getText());
            sb.append('}');
            CrashLog.Builder addMessage4 = addMessage3.addMessage(sb.toString());
            CrashLog.Builder addMessage5 = addMessage4.addMessage(" -> indices : startIndex : " + SocialValidator.INSTANCE.getStartIndex() + "   endIndex :" + SocialValidator.INSTANCE.getEndIndex());
            StringBuilder sb2 = new StringBuilder();
            sb2.append(" -> people result : ");
            sb2.append(peopleSearchResult.getFullName());
            App.Companion.crashReporter().report(addMessage5.addMessage(sb2.toString()).build());
        }
    }

    public void onTagSearchResultTapped(TagSearchResult tagSearchResult) {
        Intrinsics.checkNotNullParameter(tagSearchResult, "tagSearchResult");
        try {
            getExploreSearchViewModel().searchKeywordChanged((String) null);
            RecyclerView recyclerView = getBinding().captionSuggestionsRecyclerView;
            Intrinsics.checkNotNullExpressionValue(recyclerView, "binding.captionSuggestionsRecyclerView");
            recyclerView.setVisibility(8);
            EditText editText = getBinding().memeCaptionEditText;
            Intrinsics.checkNotNullExpressionValue(editText, "binding.memeCaptionEditText");
            editText.getText().replace(SocialValidator.INSTANCE.getStartIndex(), SocialValidator.INSTANCE.getEndIndex(), Intrinsics.stringPlus(tagSearchResult.getTagName(), StringUtils.SPACE));
        } catch (Exception e) {
            CrashLog.Builder addMessage = new CrashLog.Builder(new HarmlessCrashException()).markHarmless().addMessage("We have encountered an issue in onTagSearchResultTapped.");
            CrashLog.Builder addMessage2 = addMessage.addMessage(" -> throwable-msg: " + e.getMessage());
            CrashLog.Builder addMessage3 = addMessage2.addMessage(" -> throwable-stack: " + e.getStackTrace());
            StringBuilder sb = new StringBuilder();
            sb.append(" -> current-text: ");
            EditText editText2 = getBinding().memeCaptionEditText;
            Intrinsics.checkNotNullExpressionValue(editText2, "binding.memeCaptionEditText");
            sb.append(editText2.getText());
            sb.append('}');
            CrashLog.Builder addMessage4 = addMessage3.addMessage(sb.toString());
            CrashLog.Builder addMessage5 = addMessage4.addMessage(" -> indices : startIndex : " + SocialValidator.INSTANCE.getStartIndex() + "   endIndex :" + SocialValidator.INSTANCE.getEndIndex());
            StringBuilder sb2 = new StringBuilder();
            sb2.append(" -> tag result : ");
            sb2.append(tagSearchResult.getTagName());
            App.Companion.crashReporter().report(addMessage5.addMessage(sb2.toString()).build());
        }
    }

    public void onHashTagTapped(String str) {
        String str2;
        Intrinsics.checkNotNullParameter(str, "hashTag");
        SoftKeyboardUtil softKeyboardUtil = SoftKeyboardUtil.INSTANCE;
        EditText editText = getBinding().memeCaptionEditText;
        Intrinsics.checkNotNullExpressionValue(editText, "binding.memeCaptionEditText");
        softKeyboardUtil.hideKeyboard(editText);
        this.isEditingCaptionManually = true;
        if (StringsKt.startsWith$default(str, "#", false, 2, (Object) null)) {
            str2 = ' ' + str;
        } else {
            str2 = " #" + str;
        }
        EditText editText2 = getBinding().memeCaptionEditText;
        Intrinsics.checkNotNullExpressionValue(editText2, "binding.memeCaptionEditText");
        String obj = editText2.getText().toString();
        EditText editText3 = getBinding().memeCaptionEditText;
        Intrinsics.checkNotNullExpressionValue(editText3, "binding.memeCaptionEditText");
        int coerceAtLeast = RangesKt.coerceAtLeast(editText3.getSelectionStart(), 0);
        StringBuilder sb = new StringBuilder(obj);
        sb.insert(coerceAtLeast, str2);
        getBinding().memeCaptionEditText.setText(sb.toString());
        getBinding().memeCaptionEditText.setSelection(coerceAtLeast + str2.length());
        getBinding().memeCaptionEditText.postDelayed(new ExportPostActivity$onHashTagTapped$1(this), 100);
    }

    public void onDeleteHashTagTapped(String str) {
        Intrinsics.checkNotNullParameter(str, "hashTag");
        getExportPostViewModel().deleteSavedHashTag(str);
    }

    private final void showAppRatingSheetIfNotRated() {
        if (!getExportPostViewModel().isAppRatingConfirmed()) {
            new AppRatingRequestBottomSheet(getExportPostViewModel().createAppRatingRequest(), new C4241x2382d9ba(this)).show(getSupportFragmentManager(), AppRatingRequestBottomSheet.TAG);
        }
    }

    /* access modifiers changed from: private */
    public final void rateApp() {
        Intent playStoreIntent$default = Intents.getPlayStoreIntent$default(Intents.INSTANCE, this, (String) null, 2, (Object) null);
        if (playStoreIntent$default == null) {
            ExtensionsKt.toast((Context) this, (int) C4199R.string.error_rate_app);
        } else {
            startActivity(playStoreIntent$default);
        }
    }

    public void onItemCountChanged(int i) {
        if (getSavedHashTagsAdapter().getItemCount() == i && i == 0) {
            TextView textView = getBinding().addYourFavoriteTextView;
            Intrinsics.checkNotNullExpressionValue(textView, "binding.addYourFavoriteTextView");
            textView.setVisibility(0);
            RecyclerView recyclerView = getBinding().hashTagsRecyclerView;
            Intrinsics.checkNotNullExpressionValue(recyclerView, "binding.hashTagsRecyclerView");
            recyclerView.setVisibility(8);
            TextView textView2 = getBinding().deleteReorderTextView;
            Intrinsics.checkNotNullExpressionValue(textView2, "binding.deleteReorderTextView");
            textView2.setVisibility(8);
            return;
        }
        RecyclerView recyclerView2 = getBinding().hashTagsRecyclerView;
        Intrinsics.checkNotNullExpressionValue(recyclerView2, "binding.hashTagsRecyclerView");
        recyclerView2.setVisibility(0);
        TextView textView3 = getBinding().addYourFavoriteTextView;
        Intrinsics.checkNotNullExpressionValue(textView3, "binding.addYourFavoriteTextView");
        textView3.setVisibility(8);
        TextView textView4 = getBinding().deleteReorderTextView;
        Intrinsics.checkNotNullExpressionValue(textView4, "binding.deleteReorderTextView");
        textView4.setVisibility(0);
    }

    /* access modifiers changed from: protected */
    public void onResume() {
        getSubscriptionStatusViewModel().verifySubscription();
        super.onResume();
    }

    /* access modifiers changed from: private */
    public final void moveItem(int i, int i2) {
        String str = (String) getSavedHashTagsAdapter().getItems().get(i);
        getSavedHashTagsAdapter().getItems().remove(i);
        if (i2 < i) {
            getSavedHashTagsAdapter().getItems().add(i2, str);
            getExportPostViewModel().setSavedHashTags(getSavedHashTagsAdapter().getItems());
            return;
        }
        getSavedHashTagsAdapter().getItems().add(i2 - 1, str);
        getExportPostViewModel().setSavedHashTags(getSavedHashTagsAdapter().getItems());
    }
}
