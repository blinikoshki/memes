package editor.mediaselection.redditposts;

import android.content.Context;
import android.os.Bundle;
import android.text.Editable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import com.memes.commons.contentlayout.ContentLayout;
import com.memes.commons.pagination.Paginator;
import com.memes.commons.util.ExtensionsKt;
import com.memes.commons.util.SoftKeyboardUtil;
import com.memes.editor.C4175R;
import com.memes.editor.databinding.NRedditPostsFragmentBinding;
import editor.mediaselection.BaseMediaCategoryAdapter;
import editor.mediaselection.MediaSelectionFragment;
import editor.mediaselection.suggestions.MediaCategorySuggestionsAdapter;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000x\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010!\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010 \n\u0002\b\u0002\b\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u001fH\u0016J\u0018\u0010 \u001a\u00020\u001d2\u0006\u0010!\u001a\u00020\"2\u0006\u0010#\u001a\u00020\"H\u0016J&\u0010$\u001a\u0004\u0018\u00010%2\u0006\u0010&\u001a\u00020'2\b\u0010(\u001a\u0004\u0018\u00010)2\b\u0010*\u001a\u0004\u0018\u00010+H\u0016J\b\u0010,\u001a\u00020\u001dH\u0016J\u0010\u0010-\u001a\u00020\u001d2\u0006\u0010.\u001a\u00020\u0016H\u0002J\u001a\u0010/\u001a\u00020\u001d2\u0006\u00100\u001a\u00020%2\b\u0010*\u001a\u0004\u0018\u00010+H\u0016J\b\u00101\u001a\u00020\u001dH\u0002J\u0018\u00102\u001a\u00020\u001d2\u000e\u00103\u001a\n\u0012\u0004\u0012\u00020\u0016\u0018\u000104H\u0016J\b\u00105\u001a\u00020\u0016H\u0016R\u000e\u0010\u0003\u001a\u00020\u0004X.¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X.¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX.¢\u0006\u0002\n\u0000R\u001b\u0010\t\u001a\u00020\n8BX\u0002¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000b\u0010\fR\u001b\u0010\u000f\u001a\u00020\u00108BX\u0002¢\u0006\f\n\u0004\b\u0013\u0010\u000e\u001a\u0004\b\u0011\u0010\u0012R\u0014\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00160\u0015X\u0004¢\u0006\u0002\n\u0000R\u001b\u0010\u0017\u001a\u00020\u00188BX\u0002¢\u0006\f\n\u0004\b\u001b\u0010\u000e\u001a\u0004\b\u0019\u0010\u001a¨\u00066"}, mo26107d2 = {"Leditor/mediaselection/redditposts/RedditPostsFragment;", "Leditor/mediaselection/MediaSelectionFragment;", "()V", "binding", "Lcom/memes/editor/databinding/NRedditPostsFragmentBinding;", "paginator", "Lcom/memes/commons/pagination/Paginator;", "redditPostSelectedListener", "Leditor/mediaselection/redditposts/OnRedditPostSelectedListener;", "redditPostsAdapter", "Leditor/mediaselection/redditposts/RedditPostsAdapter;", "getRedditPostsAdapter", "()Leditor/mediaselection/redditposts/RedditPostsAdapter;", "redditPostsAdapter$delegate", "Lkotlin/Lazy;", "redditPostsViewModel", "Leditor/mediaselection/redditposts/RedditPostsViewModel;", "getRedditPostsViewModel", "()Leditor/mediaselection/redditposts/RedditPostsViewModel;", "redditPostsViewModel$delegate", "selectedItemIds", "", "", "subredditSuggestionsAdapter", "Leditor/mediaselection/suggestions/MediaCategorySuggestionsAdapter;", "getSubredditSuggestionsAdapter", "()Leditor/mediaselection/suggestions/MediaCategorySuggestionsAdapter;", "subredditSuggestionsAdapter$delegate", "onAttach", "", "context", "Landroid/content/Context;", "onContentLayoutErrorResolutionButtonTapped", "who", "", "why", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onDestroyView", "onSearchQueryChanged", "query", "onViewCreated", "view", "performSearch", "setSelectedItemIds", "itemIds", "", "tag", "editor_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
/* compiled from: RedditPostsFragment.kt */
public final class RedditPostsFragment extends MediaSelectionFragment {
    /* access modifiers changed from: private */
    public NRedditPostsFragmentBinding binding;
    private Paginator paginator;
    /* access modifiers changed from: private */
    public OnRedditPostSelectedListener redditPostSelectedListener;
    private final Lazy redditPostsAdapter$delegate = LazyKt.lazy(new RedditPostsFragment$redditPostsAdapter$2(this));
    private final Lazy redditPostsViewModel$delegate = LazyKt.lazy(new RedditPostsFragment$redditPostsViewModel$2(this));
    private final List<String> selectedItemIds = new ArrayList();
    private final Lazy subredditSuggestionsAdapter$delegate = LazyKt.lazy(new RedditPostsFragment$subredditSuggestionsAdapter$2(this));

    /* access modifiers changed from: private */
    public final RedditPostsAdapter getRedditPostsAdapter() {
        return (RedditPostsAdapter) this.redditPostsAdapter$delegate.getValue();
    }

    /* access modifiers changed from: private */
    public final RedditPostsViewModel getRedditPostsViewModel() {
        return (RedditPostsViewModel) this.redditPostsViewModel$delegate.getValue();
    }

    /* access modifiers changed from: private */
    public final MediaCategorySuggestionsAdapter getSubredditSuggestionsAdapter() {
        return (MediaCategorySuggestionsAdapter) this.subredditSuggestionsAdapter$delegate.getValue();
    }

    public String tag() {
        return "reddit-posts-fragment";
    }

    public static final /* synthetic */ NRedditPostsFragmentBinding access$getBinding$p(RedditPostsFragment redditPostsFragment) {
        NRedditPostsFragmentBinding nRedditPostsFragmentBinding = redditPostsFragment.binding;
        if (nRedditPostsFragmentBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        return nRedditPostsFragmentBinding;
    }

    public static final /* synthetic */ OnRedditPostSelectedListener access$getRedditPostSelectedListener$p(RedditPostsFragment redditPostsFragment) {
        OnRedditPostSelectedListener onRedditPostSelectedListener = redditPostsFragment.redditPostSelectedListener;
        if (onRedditPostSelectedListener == null) {
            Intrinsics.throwUninitializedPropertyAccessException("redditPostSelectedListener");
        }
        return onRedditPostSelectedListener;
    }

    public void onAttach(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        this.redditPostSelectedListener = (OnRedditPostSelectedListener) context;
        super.onAttach(context);
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        Intrinsics.checkNotNullParameter(layoutInflater, "inflater");
        if (this.binding != null) {
            NRedditPostsFragmentBinding nRedditPostsFragmentBinding = this.binding;
            if (nRedditPostsFragmentBinding == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
            }
            return nRedditPostsFragmentBinding.getRoot();
        }
        NRedditPostsFragmentBinding inflate = NRedditPostsFragmentBinding.inflate(layoutInflater, viewGroup, false);
        Intrinsics.checkNotNullExpressionValue(inflate, "NRedditPostsFragmentBind…flater, container, false)");
        this.binding = inflate;
        if (inflate == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        return inflate.getRoot();
    }

    public void onViewCreated(View view, Bundle bundle) {
        Intrinsics.checkNotNullParameter(view, ViewHierarchyConstants.VIEW_KEY);
        getActivityHandle().registerViewModel(getRedditPostsViewModel());
        NRedditPostsFragmentBinding nRedditPostsFragmentBinding = this.binding;
        if (nRedditPostsFragmentBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        nRedditPostsFragmentBinding.contentLayout.setCallback(this);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(requireContext(), 0, false);
        NRedditPostsFragmentBinding nRedditPostsFragmentBinding2 = this.binding;
        if (nRedditPostsFragmentBinding2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        RecyclerView recyclerView = nRedditPostsFragmentBinding2.suggestionsRecyclerView;
        Intrinsics.checkNotNullExpressionValue(recyclerView, "binding.suggestionsRecyclerView");
        recyclerView.setLayoutManager(linearLayoutManager);
        NRedditPostsFragmentBinding nRedditPostsFragmentBinding3 = this.binding;
        if (nRedditPostsFragmentBinding3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        RecyclerView recyclerView2 = nRedditPostsFragmentBinding3.suggestionsRecyclerView;
        Intrinsics.checkNotNullExpressionValue(recyclerView2, "binding.suggestionsRecyclerView");
        recyclerView2.setAdapter(getSubredditSuggestionsAdapter());
        StaggeredGridLayoutManager staggeredGridLayoutManager = new StaggeredGridLayoutManager(2, 1);
        NRedditPostsFragmentBinding nRedditPostsFragmentBinding4 = this.binding;
        if (nRedditPostsFragmentBinding4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        RecyclerView recyclerView3 = nRedditPostsFragmentBinding4.recyclerView;
        Intrinsics.checkNotNullExpressionValue(recyclerView3, "binding.recyclerView");
        RecyclerView.LayoutManager layoutManager = staggeredGridLayoutManager;
        recyclerView3.setLayoutManager(layoutManager);
        NRedditPostsFragmentBinding nRedditPostsFragmentBinding5 = this.binding;
        if (nRedditPostsFragmentBinding5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        RecyclerView recyclerView4 = nRedditPostsFragmentBinding5.recyclerView;
        Intrinsics.checkNotNullExpressionValue(recyclerView4, "binding.recyclerView");
        recyclerView4.setAdapter(getRedditPostsAdapter());
        BaseMediaCategoryAdapter.setSelectedItemIds$default(getRedditPostsAdapter(), this.selectedItemIds, false, 2, (Object) null);
        NRedditPostsFragmentBinding nRedditPostsFragmentBinding6 = this.binding;
        if (nRedditPostsFragmentBinding6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        nRedditPostsFragmentBinding6.recyclerView.clearOnScrollListeners();
        NRedditPostsFragmentBinding nRedditPostsFragmentBinding7 = this.binding;
        if (nRedditPostsFragmentBinding7 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        RecyclerView recyclerView5 = nRedditPostsFragmentBinding7.recyclerView;
        Intrinsics.checkNotNullExpressionValue(recyclerView5, "binding.recyclerView");
        this.paginator = ExtensionsKt.addPaginator(recyclerView5, layoutManager, new RedditPostsFragment$onViewCreated$1(this));
        NRedditPostsFragmentBinding nRedditPostsFragmentBinding8 = this.binding;
        if (nRedditPostsFragmentBinding8 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        EditText editText = nRedditPostsFragmentBinding8.includedSearchLayout.searchEditText;
        Intrinsics.checkNotNullExpressionValue(editText, "binding.includedSearchLayout.searchEditText");
        editText.setHint(getString(C4175R.string.reddit_posts_search_hint));
        NRedditPostsFragmentBinding nRedditPostsFragmentBinding9 = this.binding;
        if (nRedditPostsFragmentBinding9 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        nRedditPostsFragmentBinding9.includedSearchLayout.searchEditText.setOnEditorActionListener(new RedditPostsFragment$onViewCreated$2(this));
        NRedditPostsFragmentBinding nRedditPostsFragmentBinding10 = this.binding;
        if (nRedditPostsFragmentBinding10 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        EditText editText2 = nRedditPostsFragmentBinding10.includedSearchLayout.searchEditText;
        Intrinsics.checkNotNullExpressionValue(editText2, "binding.includedSearchLayout.searchEditText");
        editText2.addTextChangedListener(new C4828x2cc97745(this));
        NRedditPostsFragmentBinding nRedditPostsFragmentBinding11 = this.binding;
        if (nRedditPostsFragmentBinding11 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        nRedditPostsFragmentBinding11.includedSearchLayout.searchInputCancelImageView.setOnClickListener(new RedditPostsFragment$onViewCreated$4(this));
        NRedditPostsFragmentBinding nRedditPostsFragmentBinding12 = this.binding;
        if (nRedditPostsFragmentBinding12 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        nRedditPostsFragmentBinding12.includedSearchLayout.searchImageView.setOnClickListener(new RedditPostsFragment$onViewCreated$5(this));
        getRedditPostsViewModel().onQueryTextUpdateAvailable().observe(getViewLifecycleOwner(), new RedditPostsFragment$onViewCreated$6(this));
        getRedditPostsViewModel().subreddits().observe(getViewLifecycleOwner(), new RedditPostsFragment$onViewCreated$7(this));
        getRedditPostsViewModel().redditPosts().observe(getViewLifecycleOwner(), new RedditPostsFragment$onViewCreated$8(this));
        getRedditPostsViewModel().onContentVisibilityChanged().observe(getViewLifecycleOwner(), new RedditPostsFragment$onViewCreated$9(this));
        getRedditPostsViewModel().fetchSubreddits();
    }

    /* access modifiers changed from: private */
    public final void onSearchQueryChanged(String str) {
        NRedditPostsFragmentBinding nRedditPostsFragmentBinding = this.binding;
        if (nRedditPostsFragmentBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        ImageView imageView = nRedditPostsFragmentBinding.includedSearchLayout.searchInputCancelImageView;
        Intrinsics.checkNotNullExpressionValue(imageView, "binding.includedSearchLa…earchInputCancelImageView");
        CharSequence charSequence = str;
        int i = 0;
        if ((charSequence.length() == 0) || StringsKt.isBlank(charSequence)) {
            i = 8;
        }
        imageView.setVisibility(i);
    }

    /* access modifiers changed from: private */
    public final void performSearch() {
        String str;
        NRedditPostsFragmentBinding nRedditPostsFragmentBinding = this.binding;
        if (nRedditPostsFragmentBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        EditText editText = nRedditPostsFragmentBinding.includedSearchLayout.searchEditText;
        Intrinsics.checkNotNullExpressionValue(editText, "binding.includedSearchLayout.searchEditText");
        Editable text = editText.getText();
        if (text == null || (str = text.toString()) == null) {
            str = "";
        }
        getRedditPostsViewModel().queryTextChanged(str);
        Paginator paginator2 = this.paginator;
        if (paginator2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("paginator");
        }
        paginator2.resetState();
        SoftKeyboardUtil softKeyboardUtil = SoftKeyboardUtil.INSTANCE;
        NRedditPostsFragmentBinding nRedditPostsFragmentBinding2 = this.binding;
        if (nRedditPostsFragmentBinding2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        EditText editText2 = nRedditPostsFragmentBinding2.includedSearchLayout.searchEditText;
        Intrinsics.checkNotNullExpressionValue(editText2, "binding.includedSearchLayout.searchEditText");
        softKeyboardUtil.hideKeyboard(editText2);
        getRedditPostsViewModel().search();
    }

    public void setSelectedItemIds(List<String> list) {
        this.selectedItemIds.clear();
        Collection collection = list;
        if (!(collection == null || collection.isEmpty())) {
            this.selectedItemIds.addAll(collection);
        }
    }

    public void onContentLayoutErrorResolutionButtonTapped(int i, int i2) {
        NRedditPostsFragmentBinding nRedditPostsFragmentBinding = this.binding;
        if (nRedditPostsFragmentBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        ContentLayout contentLayout = nRedditPostsFragmentBinding.contentLayout;
        Intrinsics.checkNotNullExpressionValue(contentLayout, "binding.contentLayout");
        if (i == contentLayout.getId() && i2 == 1211) {
            getRedditPostsViewModel().refresh();
            Paginator paginator2 = this.paginator;
            if (paginator2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("paginator");
            }
            paginator2.resetState();
            return;
        }
        super.onContentLayoutErrorResolutionButtonTapped(i, i2);
    }

    public void onDestroyView() {
        if (this.binding != null) {
            NRedditPostsFragmentBinding nRedditPostsFragmentBinding = this.binding;
            if (nRedditPostsFragmentBinding == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
            }
            nRedditPostsFragmentBinding.recyclerView.clearOnScrollListeners();
        }
        super.onDestroyView();
    }
}
