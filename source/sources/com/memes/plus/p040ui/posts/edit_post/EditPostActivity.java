package com.memes.plus.p040ui.posts.edit_post;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.Editable;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.LifecycleOwner;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.bumptech.glide.Glide;
import com.bumptech.glide.RequestBuilder;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.memes.commons.util.ActivityResultExtKt;
import com.memes.commons.util.ExtensionsKt;
import com.memes.crashreporter.CrashLog;
import com.memes.crashreporter.HarmlessCrashException;
import com.memes.plus.App;
import com.memes.plus.C4199R;
import com.memes.plus.base.BaseActivity;
import com.memes.plus.databinding.EditPostActivityBinding;
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
import com.memes.plus.util.Constants;
import com.memes.plus.util.SocialValidator;
import java.util.Collection;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.apache.commons.lang3.StringUtils;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 A2\u00020\u00012\u00020\u00022\u00020\u0003:\u0001AB\u0005¢\u0006\u0002\u0010\u0004J\b\u0010!\u001a\u00020\"H\u0002J\u0010\u0010#\u001a\u00020\"2\u0006\u0010$\u001a\u00020%H\u0002J\b\u0010&\u001a\u00020\"H\u0002J\b\u0010'\u001a\u00020\"H\u0002J\u0012\u0010(\u001a\u00020\"2\b\u0010)\u001a\u0004\u0018\u00010*H\u0014J\u0010\u0010+\u001a\u00020\"2\u0006\u0010,\u001a\u00020-H\u0016J\u0010\u0010.\u001a\u00020\"2\u0006\u0010,\u001a\u00020-H\u0016J\b\u0010/\u001a\u00020\"H\u0002J\b\u00100\u001a\u00020\"H\u0002J\u0010\u00101\u001a\u00020\"2\u0006\u00102\u001a\u000203H\u0016J\u0010\u00104\u001a\u00020\"2\u0006\u00105\u001a\u00020\u001aH\u0002J\u0010\u00106\u001a\u00020\"2\u0006\u00107\u001a\u00020\u001aH\u0002J\u0010\u00108\u001a\u00020\"2\u0006\u00107\u001a\u00020\u001aH\u0002J\u0018\u00109\u001a\u00020\"2\u000e\u0010:\u001a\n\u0012\u0004\u0012\u000203\u0018\u00010;H\u0002J\u0018\u0010<\u001a\u00020\"2\u000e\u0010:\u001a\n\u0012\u0004\u0012\u00020=\u0018\u00010;H\u0002J\u0012\u0010>\u001a\u00020\"2\b\u0010?\u001a\u0004\u0018\u00010@H\u0002R\u001b\u0010\u0005\u001a\u00020\u00068BX\u0002¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u0007\u0010\bR\u001b\u0010\u000b\u001a\u00020\f8BX\u0002¢\u0006\f\n\u0004\b\u000f\u0010\n\u001a\u0004\b\r\u0010\u000eR\u001b\u0010\u0010\u001a\u00020\u00118BX\u0002¢\u0006\f\n\u0004\b\u0014\u0010\n\u001a\u0004\b\u0012\u0010\u0013R\u000e\u0010\u0015\u001a\u00020\u0016X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0018X.¢\u0006\u0002\n\u0000R\u0010\u0010\u0019\u001a\u0004\u0018\u00010\u001aX\u000e¢\u0006\u0002\n\u0000R\u001c\u0010\u001b\u001a\u0010\u0012\f\u0012\n \u001e*\u0004\u0018\u00010\u001d0\u001d0\u001cX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001f\u001a\u00020 X.¢\u0006\u0002\n\u0000¨\u0006B"}, mo26107d2 = {"Lcom/memes/plus/ui/posts/edit_post/EditPostActivity;", "Lcom/memes/plus/base/BaseActivity;", "Lcom/memes/plus/ui/explore_search/people_search/PeopleSearchResultAdapterListener;", "Lcom/memes/plus/ui/explore_search/tag_search/TagSearchResultsAdapterListener;", "()V", "binding", "Lcom/memes/plus/databinding/EditPostActivityBinding;", "getBinding", "()Lcom/memes/plus/databinding/EditPostActivityBinding;", "binding$delegate", "Lkotlin/Lazy;", "editPostViewModel", "Lcom/memes/plus/ui/posts/edit_post/EditPostViewModel;", "getEditPostViewModel", "()Lcom/memes/plus/ui/posts/edit_post/EditPostViewModel;", "editPostViewModel$delegate", "exploreSearchViewModel", "Lcom/memes/plus/ui/explore_search/combined/ExploreSearchViewModel;", "getExploreSearchViewModel", "()Lcom/memes/plus/ui/explore_search/combined/ExploreSearchViewModel;", "exploreSearchViewModel$delegate", "isEditingCaptionManually", "", "peopleSearchAdapter", "Lcom/memes/plus/ui/explore_search/people_search/PeopleSearchResultsAdapter;", "postId", "", "tagPeopleContractLauncher", "Landroidx/activity/result/ActivityResultLauncher;", "Landroid/content/Intent;", "kotlin.jvm.PlatformType", "tagsSearchAdapter", "Lcom/memes/plus/ui/explore_search/tag_search/TagSearchResultsAdapter;", "attachObservers", "", "handleTagPeopleActivityResult", "result", "Landroidx/activity/result/ActivityResult;", "initCaptionTagSuggestionsUi", "initUi", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onPeopleSearchResultTapped", "peopleSearchResult", "Lcom/memes/plus/ui/explore_search/people_search/PeopleSearchResult;", "onRemoveSuggestedPersonViewTapped", "onShareExportedMemeViewTapped", "onTagPeopleViewTapped", "onTagSearchResultTapped", "tagSearchResult", "Lcom/memes/plus/ui/explore_search/tag_search/TagSearchResult;", "refreshSuggestions", "inputText", "searchForHashTagSuggestions", "query", "searchForPeopleSuggestions", "showHashTagSuggestions", "items", "", "showPeopleSuggestions", "Lcom/memes/plus/ui/explore_search/people_search/CatalogueSearchResult;", "showPostDetails", "post", "Lcom/memes/plus/ui/posts/edit_post/EditPostInput;", "Companion", "app_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
/* renamed from: com.memes.plus.ui.posts.edit_post.EditPostActivity */
/* compiled from: EditPostActivity.kt */
public final class EditPostActivity extends BaseActivity implements PeopleSearchResultAdapterListener, TagSearchResultsAdapterListener {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private static final String EXTRA_EDIT_POST = "intent.extra._edit_post";
    private final Lazy binding$delegate = LazyKt.lazy(new EditPostActivity$binding$2(this));
    private final Lazy editPostViewModel$delegate = LazyKt.lazy(new EditPostActivity$editPostViewModel$2(this));
    private final Lazy exploreSearchViewModel$delegate = LazyKt.lazy(new EditPostActivity$exploreSearchViewModel$2(this));
    /* access modifiers changed from: private */
    public boolean isEditingCaptionManually;
    private PeopleSearchResultsAdapter peopleSearchAdapter;
    private String postId;
    private final ActivityResultLauncher<Intent> tagPeopleContractLauncher;
    private TagSearchResultsAdapter tagsSearchAdapter;

    /* access modifiers changed from: private */
    public final EditPostActivityBinding getBinding() {
        return (EditPostActivityBinding) this.binding$delegate.getValue();
    }

    /* access modifiers changed from: private */
    public final EditPostViewModel getEditPostViewModel() {
        return (EditPostViewModel) this.editPostViewModel$delegate.getValue();
    }

    private final ExploreSearchViewModel getExploreSearchViewModel() {
        return (ExploreSearchViewModel) this.exploreSearchViewModel$delegate.getValue();
    }

    public void onRemoveSuggestedPersonViewTapped(PeopleSearchResult peopleSearchResult) {
        Intrinsics.checkNotNullParameter(peopleSearchResult, "peopleSearchResult");
    }

    public EditPostActivity() {
        ActivityResultLauncher<Intent> registerForActivityResult = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), new EditPostActivity$tagPeopleContractLauncher$1(this));
        Intrinsics.checkNotNullExpressionValue(registerForActivityResult, "registerForActivityResul…eActivityResult(result) }");
        this.tagPeopleContractLauncher = registerForActivityResult;
    }

    @Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0016\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nR\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u000b"}, mo26107d2 = {"Lcom/memes/plus/ui/posts/edit_post/EditPostActivity$Companion;", "", "()V", "EXTRA_EDIT_POST", "", "getStartIntent", "Landroid/content/Intent;", "context", "Landroid/content/Context;", "editPostInput", "Lcom/memes/plus/ui/posts/edit_post/EditPostInput;", "app_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
    /* renamed from: com.memes.plus.ui.posts.edit_post.EditPostActivity$Companion */
    /* compiled from: EditPostActivity.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final Intent getStartIntent(Context context, EditPostInput editPostInput) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(editPostInput, "editPostInput");
            Intent intent = new Intent(context, EditPostActivity.class);
            intent.putExtra(EditPostActivity.EXTRA_EDIT_POST, editPostInput);
            return intent;
        }
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        EditPostActivityBinding binding = getBinding();
        Intrinsics.checkNotNullExpressionValue(binding, "binding");
        setContentView((View) binding.getRoot());
        initUi();
        attachObservers();
        EditPostInput editPostInput = (EditPostInput) getIntent().getParcelableExtra(EXTRA_EDIT_POST);
        Uri uri = null;
        getEditPostViewModel().onPostIdChanged(editPostInput != null ? editPostInput.getPostId() : null);
        getEditPostViewModel().mediaContentChange(editPostInput != null ? editPostInput.getPostUrl() : null, editPostInput != null ? Integer.valueOf(editPostInput.contentType()) : null);
        if (editPostInput != null) {
            uri = editPostInput.getPostUrl();
        }
        if (uri == null) {
            ExtensionsKt.toast((Context) this, Constants.UNUSUAL_ERROR);
            finish();
            return;
        }
        ((RequestBuilder) ((RequestBuilder) ((RequestBuilder) Glide.with((FragmentActivity) this).load(editPostInput.getPostThumb()).placeholder((int) C4199R.C4202drawable.ic_placeholder)).diskCacheStrategy(DiskCacheStrategy.NONE)).skipMemoryCache(true)).into(getBinding().memePreviewImageView);
        showPostDetails(editPostInput);
    }

    private final void initUi() {
        getBinding().backImageView.setOnClickListener(new EditPostActivity$initUi$1(this));
        EditText editText = getBinding().memeCaptionEditText;
        Intrinsics.checkNotNullExpressionValue(editText, "binding.memeCaptionEditText");
        ExtensionsKt.setMultiLineCapSentencesAndDoneAction(editText);
        EditText editText2 = getBinding().memeCaptionEditText;
        Intrinsics.checkNotNullExpressionValue(editText2, "binding.memeCaptionEditText");
        editText2.addTextChangedListener(new EditPostActivity$initUi$$inlined$addTextChangedListener$1(this));
        EditText editText3 = getBinding().memeCaptionEditText;
        Intrinsics.checkNotNullExpressionValue(editText3, "binding.memeCaptionEditText");
        editText3.addTextChangedListener(new EditPostActivity$initUi$$inlined$addTextChangedListener$2(this));
        getBinding().taggedPeopleLayout.setOnClickListener(new EditPostActivity$initUi$4(this));
        getBinding().editPostDoneTextView.setOnClickListener(new EditPostActivity$initUi$5(this));
        initCaptionTagSuggestionsUi();
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

    private final void showPostDetails(EditPostInput editPostInput) {
        String str = null;
        ((RequestBuilder) ((RequestBuilder) ((RequestBuilder) ((RequestBuilder) Glide.with((FragmentActivity) this).load(editPostInput != null ? editPostInput.getAuthorProfileThumb() : null).placeholder((int) C4199R.C4202drawable.placeholder_profile)).error((int) C4199R.C4202drawable.placeholder_profile)).diskCacheStrategy(DiskCacheStrategy.NONE)).skipMemoryCache(true)).into((ImageView) getBinding().editPostAuthorImageView);
        TextView textView = getBinding().editPostAuthorNameTextView;
        Intrinsics.checkNotNullExpressionValue(textView, "binding.editPostAuthorNameTextView");
        textView.setText(editPostInput != null ? editPostInput.getAuthorName() : null);
        getBinding().memeCaptionEditText.setText(editPostInput != null ? editPostInput.getPostText() : null);
        EditPostViewModel editPostViewModel = getEditPostViewModel();
        if (editPostInput != null) {
            str = editPostInput.getPostId();
        }
        editPostViewModel.fetchPostTaggedUsers(str);
    }

    private final void attachObservers() {
        registerViewModel(getEditPostViewModel());
        LifecycleOwner lifecycleOwner = this;
        getEditPostViewModel().postEdited().observe(lifecycleOwner, new EditPostActivity$attachObservers$1(this));
        getEditPostViewModel().getPostTaggedUsersLiveData().observe(lifecycleOwner, new EditPostActivity$attachObservers$2(this));
        getExploreSearchViewModel().getResultsLiveData().observe(lifecycleOwner, new EditPostActivity$attachObservers$3(this));
        getExploreSearchViewModel().getResultTagSearchLiveData().observe(lifecycleOwner, new EditPostActivity$attachObservers$4(this));
        getExploreSearchViewModel().getContentVisibilityLiveData().observe(lifecycleOwner, EditPostActivity$attachObservers$5.INSTANCE);
    }

    /* access modifiers changed from: private */
    public final void onTagPeopleViewTapped() {
        Uri postUri = getEditPostViewModel().getPostUri();
        if (postUri != null) {
            this.tagPeopleContractLauncher.launch(TagPeopleActivity.Companion.getStartIntent(this, postUri.toString(), getEditPostViewModel().getContentType(), getEditPostViewModel().getTaggedPeopleJson()));
        }
    }

    /* access modifiers changed from: private */
    public final void onShareExportedMemeViewTapped() {
        App.Companion.trackingManager().onUploadPostTapped();
        getEditPostViewModel().editMeme();
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
                getEditPostViewModel().taggedPeopleInputChanged((String) null);
            } else {
                getEditPostViewModel().taggedPeopleInputChanged(stringExtra);
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
}
