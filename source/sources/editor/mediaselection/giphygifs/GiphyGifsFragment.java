package editor.mediaselection.giphygifs;

import android.content.Context;
import android.os.Bundle;
import android.text.Editable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.ConcatAdapter;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import com.memes.commons.contentlayout.ContentLayout;
import com.memes.commons.pagination.Paginator;
import com.memes.commons.util.ExtensionsKt;
import com.memes.commons.util.SoftKeyboardUtil;
import com.memes.editor.C4175R;
import com.memes.editor.databinding.NGiphyGifsFragmentBinding;
import editor.mediaselection.BaseMediaCategoryAdapter;
import editor.mediaselection.MediaSelectionFragment;
import editor.mediaselection.suggestions.GiphyBrandLogoAdapter;
import editor.mediaselection.suggestions.MediaCategorySuggestionsAdapter;
import editor.optionsui.addcontent.giphy.GiphyGifSelectedListener;
import editor.optionsui.addcontent.giphy.GiphyProxy;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010 \n\u0002\b\u0002\b\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010$\u001a\u00020%2\u0006\u0010&\u001a\u00020'H\u0016J\u0018\u0010(\u001a\u00020%2\u0006\u0010)\u001a\u00020*2\u0006\u0010+\u001a\u00020*H\u0016J&\u0010,\u001a\u0004\u0018\u00010-2\u0006\u0010.\u001a\u00020/2\b\u00100\u001a\u0004\u0018\u0001012\b\u00102\u001a\u0004\u0018\u000103H\u0016J\b\u00104\u001a\u00020%H\u0016J\u0010\u00105\u001a\u00020%2\u0006\u00106\u001a\u00020 H\u0002J\u001a\u00107\u001a\u00020%2\u0006\u00108\u001a\u00020-2\b\u00102\u001a\u0004\u0018\u000103H\u0016J\b\u00109\u001a\u00020%H\u0002J\b\u0010:\u001a\u00020%H\u0002J\u0018\u0010;\u001a\u00020%2\u000e\u0010<\u001a\n\u0012\u0004\u0012\u00020 \u0018\u00010=H\u0016J\b\u0010>\u001a\u00020 H\u0016R\u001b\u0010\u0003\u001a\u00020\u00048BX\u0002¢\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\u0005\u0010\u0006R\u000e\u0010\t\u001a\u00020\nX.¢\u0006\u0002\n\u0000R\u001b\u0010\u000b\u001a\u00020\f8BX\u0002¢\u0006\f\n\u0004\b\u000f\u0010\b\u001a\u0004\b\r\u0010\u000eR\u000e\u0010\u0010\u001a\u00020\u0011X.¢\u0006\u0002\n\u0000R\u001b\u0010\u0012\u001a\u00020\u00138BX\u0002¢\u0006\f\n\u0004\b\u0016\u0010\b\u001a\u0004\b\u0014\u0010\u0015R\u001b\u0010\u0017\u001a\u00020\u00188BX\u0002¢\u0006\f\n\u0004\b\u001b\u0010\b\u001a\u0004\b\u0019\u0010\u001aR\u000e\u0010\u001c\u001a\u00020\u001dX.¢\u0006\u0002\n\u0000R\u0014\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020 0\u001fX\u0004¢\u0006\u0002\n\u0000R\u001b\u0010!\u001a\u00020\u00048BX\u0002¢\u0006\f\n\u0004\b#\u0010\b\u001a\u0004\b\"\u0010\u0006¨\u0006?"}, mo26107d2 = {"Leditor/mediaselection/giphygifs/GiphyGifsFragment;", "Leditor/mediaselection/MediaSelectionFragment;", "()V", "appliedSearchQueryAdapter", "Leditor/mediaselection/suggestions/MediaCategorySuggestionsAdapter;", "getAppliedSearchQueryAdapter", "()Leditor/mediaselection/suggestions/MediaCategorySuggestionsAdapter;", "appliedSearchQueryAdapter$delegate", "Lkotlin/Lazy;", "binding", "Lcom/memes/editor/databinding/NGiphyGifsFragmentBinding;", "giphyBrandLogoAdapter", "Leditor/mediaselection/suggestions/GiphyBrandLogoAdapter;", "getGiphyBrandLogoAdapter", "()Leditor/mediaselection/suggestions/GiphyBrandLogoAdapter;", "giphyBrandLogoAdapter$delegate", "giphyGifSelectedListener", "Leditor/mediaselection/giphygifs/OnGiphyGifSelectedListener;", "giphyGifsAdapter", "Leditor/mediaselection/giphygifs/GiphyGifsAdapter;", "getGiphyGifsAdapter", "()Leditor/mediaselection/giphygifs/GiphyGifsAdapter;", "giphyGifsAdapter$delegate", "giphyGifsViewModel", "Leditor/mediaselection/giphygifs/GiphyGifsViewModel;", "getGiphyGifsViewModel", "()Leditor/mediaselection/giphygifs/GiphyGifsViewModel;", "giphyGifsViewModel$delegate", "paginator", "Lcom/memes/commons/pagination/Paginator;", "selectedItemIds", "", "", "suggestionsAdapter", "getSuggestionsAdapter", "suggestionsAdapter$delegate", "onAttach", "", "context", "Landroid/content/Context;", "onContentLayoutErrorResolutionButtonTapped", "who", "", "why", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onDestroyView", "onSearchQueryChanged", "query", "onViewCreated", "view", "openGiphyDialog", "performSearch", "setSelectedItemIds", "itemIds", "", "tag", "editor_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
/* compiled from: GiphyGifsFragment.kt */
public final class GiphyGifsFragment extends MediaSelectionFragment {
    private final Lazy appliedSearchQueryAdapter$delegate = LazyKt.lazy(new GiphyGifsFragment$appliedSearchQueryAdapter$2(this));
    /* access modifiers changed from: private */
    public NGiphyGifsFragmentBinding binding;
    private final Lazy giphyBrandLogoAdapter$delegate = LazyKt.lazy(new GiphyGifsFragment$giphyBrandLogoAdapter$2(this));
    /* access modifiers changed from: private */
    public OnGiphyGifSelectedListener giphyGifSelectedListener;
    private final Lazy giphyGifsAdapter$delegate = LazyKt.lazy(new GiphyGifsFragment$giphyGifsAdapter$2(this));
    private final Lazy giphyGifsViewModel$delegate = LazyKt.lazy(new GiphyGifsFragment$giphyGifsViewModel$2(this));
    private Paginator paginator;
    private final List<String> selectedItemIds = new ArrayList();
    private final Lazy suggestionsAdapter$delegate = LazyKt.lazy(new GiphyGifsFragment$suggestionsAdapter$2(this));

    /* access modifiers changed from: private */
    public final MediaCategorySuggestionsAdapter getAppliedSearchQueryAdapter() {
        return (MediaCategorySuggestionsAdapter) this.appliedSearchQueryAdapter$delegate.getValue();
    }

    private final GiphyBrandLogoAdapter getGiphyBrandLogoAdapter() {
        return (GiphyBrandLogoAdapter) this.giphyBrandLogoAdapter$delegate.getValue();
    }

    /* access modifiers changed from: private */
    public final GiphyGifsAdapter getGiphyGifsAdapter() {
        return (GiphyGifsAdapter) this.giphyGifsAdapter$delegate.getValue();
    }

    /* access modifiers changed from: private */
    public final GiphyGifsViewModel getGiphyGifsViewModel() {
        return (GiphyGifsViewModel) this.giphyGifsViewModel$delegate.getValue();
    }

    /* access modifiers changed from: private */
    public final MediaCategorySuggestionsAdapter getSuggestionsAdapter() {
        return (MediaCategorySuggestionsAdapter) this.suggestionsAdapter$delegate.getValue();
    }

    public String tag() {
        return "giphy-gifs-fragment";
    }

    public static final /* synthetic */ NGiphyGifsFragmentBinding access$getBinding$p(GiphyGifsFragment giphyGifsFragment) {
        NGiphyGifsFragmentBinding nGiphyGifsFragmentBinding = giphyGifsFragment.binding;
        if (nGiphyGifsFragmentBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        return nGiphyGifsFragmentBinding;
    }

    public static final /* synthetic */ OnGiphyGifSelectedListener access$getGiphyGifSelectedListener$p(GiphyGifsFragment giphyGifsFragment) {
        OnGiphyGifSelectedListener onGiphyGifSelectedListener = giphyGifsFragment.giphyGifSelectedListener;
        if (onGiphyGifSelectedListener == null) {
            Intrinsics.throwUninitializedPropertyAccessException("giphyGifSelectedListener");
        }
        return onGiphyGifSelectedListener;
    }

    public void onAttach(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        this.giphyGifSelectedListener = (OnGiphyGifSelectedListener) context;
        super.onAttach(context);
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        Intrinsics.checkNotNullParameter(layoutInflater, "inflater");
        if (this.binding != null) {
            NGiphyGifsFragmentBinding nGiphyGifsFragmentBinding = this.binding;
            if (nGiphyGifsFragmentBinding == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
            }
            return nGiphyGifsFragmentBinding.getRoot();
        }
        NGiphyGifsFragmentBinding inflate = NGiphyGifsFragmentBinding.inflate(layoutInflater, viewGroup, false);
        Intrinsics.checkNotNullExpressionValue(inflate, "NGiphyGifsFragmentBindin…flater, container, false)");
        this.binding = inflate;
        if (inflate == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        return inflate.getRoot();
    }

    public void onViewCreated(View view, Bundle bundle) {
        Intrinsics.checkNotNullParameter(view, ViewHierarchyConstants.VIEW_KEY);
        getActivityHandle().registerViewModel(getGiphyGifsViewModel());
        NGiphyGifsFragmentBinding nGiphyGifsFragmentBinding = this.binding;
        if (nGiphyGifsFragmentBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        nGiphyGifsFragmentBinding.contentLayout.setCallback(this);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(requireContext(), 0, false);
        NGiphyGifsFragmentBinding nGiphyGifsFragmentBinding2 = this.binding;
        if (nGiphyGifsFragmentBinding2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        RecyclerView recyclerView = nGiphyGifsFragmentBinding2.suggestionsRecyclerView;
        Intrinsics.checkNotNullExpressionValue(recyclerView, "binding.suggestionsRecyclerView");
        recyclerView.setLayoutManager(linearLayoutManager);
        NGiphyGifsFragmentBinding nGiphyGifsFragmentBinding3 = this.binding;
        if (nGiphyGifsFragmentBinding3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        RecyclerView recyclerView2 = nGiphyGifsFragmentBinding3.suggestionsRecyclerView;
        Intrinsics.checkNotNullExpressionValue(recyclerView2, "binding.suggestionsRecyclerView");
        recyclerView2.setAdapter(new ConcatAdapter((RecyclerView.Adapter<? extends RecyclerView.ViewHolder>[]) new RecyclerView.Adapter[]{getGiphyBrandLogoAdapter(), getAppliedSearchQueryAdapter(), getSuggestionsAdapter()}));
        StaggeredGridLayoutManager staggeredGridLayoutManager = new StaggeredGridLayoutManager(2, 1);
        NGiphyGifsFragmentBinding nGiphyGifsFragmentBinding4 = this.binding;
        if (nGiphyGifsFragmentBinding4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        RecyclerView recyclerView3 = nGiphyGifsFragmentBinding4.recyclerView;
        Intrinsics.checkNotNullExpressionValue(recyclerView3, "binding.recyclerView");
        RecyclerView.LayoutManager layoutManager = staggeredGridLayoutManager;
        recyclerView3.setLayoutManager(layoutManager);
        NGiphyGifsFragmentBinding nGiphyGifsFragmentBinding5 = this.binding;
        if (nGiphyGifsFragmentBinding5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        RecyclerView recyclerView4 = nGiphyGifsFragmentBinding5.recyclerView;
        Intrinsics.checkNotNullExpressionValue(recyclerView4, "binding.recyclerView");
        recyclerView4.setAdapter(getGiphyGifsAdapter());
        BaseMediaCategoryAdapter.setSelectedItemIds$default(getGiphyGifsAdapter(), this.selectedItemIds, false, 2, (Object) null);
        NGiphyGifsFragmentBinding nGiphyGifsFragmentBinding6 = this.binding;
        if (nGiphyGifsFragmentBinding6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        nGiphyGifsFragmentBinding6.recyclerView.clearOnScrollListeners();
        NGiphyGifsFragmentBinding nGiphyGifsFragmentBinding7 = this.binding;
        if (nGiphyGifsFragmentBinding7 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        RecyclerView recyclerView5 = nGiphyGifsFragmentBinding7.recyclerView;
        Intrinsics.checkNotNullExpressionValue(recyclerView5, "binding.recyclerView");
        this.paginator = ExtensionsKt.addPaginator(recyclerView5, layoutManager, new GiphyGifsFragment$onViewCreated$1(this));
        NGiphyGifsFragmentBinding nGiphyGifsFragmentBinding8 = this.binding;
        if (nGiphyGifsFragmentBinding8 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        EditText editText = nGiphyGifsFragmentBinding8.includedSearchLayout.searchEditText;
        Intrinsics.checkNotNullExpressionValue(editText, "binding.includedSearchLayout.searchEditText");
        editText.setHint(getString(C4175R.string.giphy_gifs_search_hint));
        NGiphyGifsFragmentBinding nGiphyGifsFragmentBinding9 = this.binding;
        if (nGiphyGifsFragmentBinding9 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        nGiphyGifsFragmentBinding9.includedSearchLayout.searchEditText.setOnEditorActionListener(new GiphyGifsFragment$onViewCreated$2(this));
        NGiphyGifsFragmentBinding nGiphyGifsFragmentBinding10 = this.binding;
        if (nGiphyGifsFragmentBinding10 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        EditText editText2 = nGiphyGifsFragmentBinding10.includedSearchLayout.searchEditText;
        Intrinsics.checkNotNullExpressionValue(editText2, "binding.includedSearchLayout.searchEditText");
        editText2.addTextChangedListener(new C4806xd370a75e(this));
        NGiphyGifsFragmentBinding nGiphyGifsFragmentBinding11 = this.binding;
        if (nGiphyGifsFragmentBinding11 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        nGiphyGifsFragmentBinding11.includedSearchLayout.searchInputCancelImageView.setOnClickListener(new GiphyGifsFragment$onViewCreated$4(this));
        NGiphyGifsFragmentBinding nGiphyGifsFragmentBinding12 = this.binding;
        if (nGiphyGifsFragmentBinding12 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        nGiphyGifsFragmentBinding12.includedSearchLayout.searchImageView.setOnClickListener(new GiphyGifsFragment$onViewCreated$5(this));
        getGiphyGifsViewModel().onQueryTextUpdateAvailable().observe(getViewLifecycleOwner(), new GiphyGifsFragment$onViewCreated$6(this));
        getGiphyGifsViewModel().suggestions().observe(getViewLifecycleOwner(), new GiphyGifsFragment$onViewCreated$7(this));
        getGiphyGifsViewModel().giphyGifs().observe(getViewLifecycleOwner(), new GiphyGifsFragment$onViewCreated$8(this));
        getGiphyGifsViewModel().onContentVisibilityChanged().observe(getViewLifecycleOwner(), new GiphyGifsFragment$onViewCreated$9(this));
        getGiphyGifsViewModel().fetchSearchSuggestions();
    }

    /* access modifiers changed from: private */
    public final void onSearchQueryChanged(String str) {
        NGiphyGifsFragmentBinding nGiphyGifsFragmentBinding = this.binding;
        if (nGiphyGifsFragmentBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        ImageView imageView = nGiphyGifsFragmentBinding.includedSearchLayout.searchInputCancelImageView;
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
        NGiphyGifsFragmentBinding nGiphyGifsFragmentBinding = this.binding;
        if (nGiphyGifsFragmentBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        EditText editText = nGiphyGifsFragmentBinding.includedSearchLayout.searchEditText;
        Intrinsics.checkNotNullExpressionValue(editText, "binding.includedSearchLayout.searchEditText");
        Editable text = editText.getText();
        if (text == null || (str = text.toString()) == null) {
            str = "";
        }
        getGiphyGifsViewModel().queryTextChanged(str);
        Paginator paginator2 = this.paginator;
        if (paginator2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("paginator");
        }
        paginator2.resetState();
        SoftKeyboardUtil softKeyboardUtil = SoftKeyboardUtil.INSTANCE;
        NGiphyGifsFragmentBinding nGiphyGifsFragmentBinding2 = this.binding;
        if (nGiphyGifsFragmentBinding2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        EditText editText2 = nGiphyGifsFragmentBinding2.includedSearchLayout.searchEditText;
        Intrinsics.checkNotNullExpressionValue(editText2, "binding.includedSearchLayout.searchEditText");
        softKeyboardUtil.hideKeyboard(editText2);
        getGiphyGifsViewModel().search();
    }

    /* access modifiers changed from: private */
    public final void openGiphyDialog() {
        GiphyProxy giphyProxy = GiphyProxy.INSTANCE;
        FragmentManager parentFragmentManager = getParentFragmentManager();
        Intrinsics.checkNotNullExpressionValue(parentFragmentManager, "parentFragmentManager");
        giphyProxy.showGiphyDialog(parentFragmentManager, new GiphyGifSelectedListener(new GiphyGifsFragment$openGiphyDialog$1(this)));
    }

    public void setSelectedItemIds(List<String> list) {
        this.selectedItemIds.clear();
        Collection collection = list;
        if (!(collection == null || collection.isEmpty())) {
            this.selectedItemIds.addAll(collection);
        }
    }

    public void onContentLayoutErrorResolutionButtonTapped(int i, int i2) {
        NGiphyGifsFragmentBinding nGiphyGifsFragmentBinding = this.binding;
        if (nGiphyGifsFragmentBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        ContentLayout contentLayout = nGiphyGifsFragmentBinding.contentLayout;
        Intrinsics.checkNotNullExpressionValue(contentLayout, "binding.contentLayout");
        if (i == contentLayout.getId() && i2 == 1211) {
            getGiphyGifsViewModel().refresh();
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
            NGiphyGifsFragmentBinding nGiphyGifsFragmentBinding = this.binding;
            if (nGiphyGifsFragmentBinding == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
            }
            nGiphyGifsFragmentBinding.recyclerView.clearOnScrollListeners();
        }
        super.onDestroyView();
    }
}
