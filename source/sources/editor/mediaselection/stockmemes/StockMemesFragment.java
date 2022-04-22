package editor.mediaselection.stockmemes;

import android.content.Context;
import android.os.Bundle;
import android.text.Editable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import com.memes.commons.contentlayout.ContentLayout;
import com.memes.commons.pagination.Paginator;
import com.memes.commons.util.ExtensionsKt;
import com.memes.commons.util.SoftKeyboardUtil;
import com.memes.editor.C4175R;
import com.memes.editor.databinding.NStockMemesFragmentBinding;
import editor.mediaselection.BaseMediaCategoryAdapter;
import editor.mediaselection.MediaSelectionFragment;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000p\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010 \n\u0002\b\u0002\b\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001aH\u0016J\u0018\u0010\u001b\u001a\u00020\u00182\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u001dH\u0016J&\u0010\u001f\u001a\u0004\u0018\u00010 2\u0006\u0010!\u001a\u00020\"2\b\u0010#\u001a\u0004\u0018\u00010$2\b\u0010%\u001a\u0004\u0018\u00010&H\u0016J\b\u0010'\u001a\u00020\u0018H\u0016J\u0010\u0010(\u001a\u00020\u00182\u0006\u0010)\u001a\u00020\u000fH\u0002J\u001a\u0010*\u001a\u00020\u00182\u0006\u0010+\u001a\u00020 2\b\u0010%\u001a\u0004\u0018\u00010&H\u0016J\b\u0010,\u001a\u00020\u0018H\u0002J\u0018\u0010-\u001a\u00020\u00182\u000e\u0010.\u001a\n\u0012\u0004\u0012\u00020\u000f\u0018\u00010/H\u0016J\b\u00100\u001a\u00020\u000fH\u0016R\u000e\u0010\u0003\u001a\u00020\u0004X.¢\u0006\u0002\n\u0000R\u001b\u0010\u0005\u001a\u00020\u00068BX\u0002¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u0007\u0010\bR\u000e\u0010\u000b\u001a\u00020\fX.¢\u0006\u0002\n\u0000R\u0014\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000eX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X.¢\u0006\u0002\n\u0000R\u001b\u0010\u0012\u001a\u00020\u00138BX\u0002¢\u0006\f\n\u0004\b\u0016\u0010\n\u001a\u0004\b\u0014\u0010\u0015¨\u00061"}, mo26107d2 = {"Leditor/mediaselection/stockmemes/StockMemesFragment;", "Leditor/mediaselection/MediaSelectionFragment;", "()V", "binding", "Lcom/memes/editor/databinding/NStockMemesFragmentBinding;", "memesAdapter", "Leditor/mediaselection/stockmemes/StockMemesAdapter;", "getMemesAdapter", "()Leditor/mediaselection/stockmemes/StockMemesAdapter;", "memesAdapter$delegate", "Lkotlin/Lazy;", "paginator", "Lcom/memes/commons/pagination/Paginator;", "selectedItemIds", "", "", "stockMemeSelectedListener", "Leditor/mediaselection/stockmemes/OnStockMemeSelectedListener;", "stockMemesViewModel", "Leditor/mediaselection/stockmemes/StockMemesViewModel;", "getStockMemesViewModel", "()Leditor/mediaselection/stockmemes/StockMemesViewModel;", "stockMemesViewModel$delegate", "onAttach", "", "context", "Landroid/content/Context;", "onContentLayoutErrorResolutionButtonTapped", "who", "", "why", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onDestroyView", "onSearchQueryChanged", "query", "onViewCreated", "view", "performSearch", "setSelectedItemIds", "itemIds", "", "tag", "editor_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
/* compiled from: StockMemesFragment.kt */
public final class StockMemesFragment extends MediaSelectionFragment {
    /* access modifiers changed from: private */
    public NStockMemesFragmentBinding binding;
    private final Lazy memesAdapter$delegate = LazyKt.lazy(new StockMemesFragment$memesAdapter$2(this));
    private Paginator paginator;
    private final List<String> selectedItemIds = new ArrayList();
    /* access modifiers changed from: private */
    public OnStockMemeSelectedListener stockMemeSelectedListener;
    private final Lazy stockMemesViewModel$delegate = LazyKt.lazy(new StockMemesFragment$stockMemesViewModel$2(this));

    /* access modifiers changed from: private */
    public final StockMemesAdapter getMemesAdapter() {
        return (StockMemesAdapter) this.memesAdapter$delegate.getValue();
    }

    /* access modifiers changed from: private */
    public final StockMemesViewModel getStockMemesViewModel() {
        return (StockMemesViewModel) this.stockMemesViewModel$delegate.getValue();
    }

    public String tag() {
        return "stock_memes-fragment";
    }

    public static final /* synthetic */ NStockMemesFragmentBinding access$getBinding$p(StockMemesFragment stockMemesFragment) {
        NStockMemesFragmentBinding nStockMemesFragmentBinding = stockMemesFragment.binding;
        if (nStockMemesFragmentBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        return nStockMemesFragmentBinding;
    }

    public static final /* synthetic */ OnStockMemeSelectedListener access$getStockMemeSelectedListener$p(StockMemesFragment stockMemesFragment) {
        OnStockMemeSelectedListener onStockMemeSelectedListener = stockMemesFragment.stockMemeSelectedListener;
        if (onStockMemeSelectedListener == null) {
            Intrinsics.throwUninitializedPropertyAccessException("stockMemeSelectedListener");
        }
        return onStockMemeSelectedListener;
    }

    public void onAttach(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        this.stockMemeSelectedListener = (OnStockMemeSelectedListener) context;
        super.onAttach(context);
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        Intrinsics.checkNotNullParameter(layoutInflater, "inflater");
        if (this.binding != null) {
            NStockMemesFragmentBinding nStockMemesFragmentBinding = this.binding;
            if (nStockMemesFragmentBinding == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
            }
            return nStockMemesFragmentBinding.getRoot();
        }
        NStockMemesFragmentBinding inflate = NStockMemesFragmentBinding.inflate(layoutInflater, viewGroup, false);
        Intrinsics.checkNotNullExpressionValue(inflate, "NStockMemesFragmentBindi…flater, container, false)");
        this.binding = inflate;
        if (inflate == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        return inflate.getRoot();
    }

    public void onViewCreated(View view, Bundle bundle) {
        Intrinsics.checkNotNullParameter(view, ViewHierarchyConstants.VIEW_KEY);
        getActivityHandle().registerViewModel(getStockMemesViewModel());
        NStockMemesFragmentBinding nStockMemesFragmentBinding = this.binding;
        if (nStockMemesFragmentBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        nStockMemesFragmentBinding.contentLayout.setCallback(this);
        StaggeredGridLayoutManager staggeredGridLayoutManager = new StaggeredGridLayoutManager(2, 1);
        NStockMemesFragmentBinding nStockMemesFragmentBinding2 = this.binding;
        if (nStockMemesFragmentBinding2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        RecyclerView recyclerView = nStockMemesFragmentBinding2.memesRecyclerView;
        Intrinsics.checkNotNullExpressionValue(recyclerView, "binding.memesRecyclerView");
        RecyclerView.LayoutManager layoutManager = staggeredGridLayoutManager;
        recyclerView.setLayoutManager(layoutManager);
        NStockMemesFragmentBinding nStockMemesFragmentBinding3 = this.binding;
        if (nStockMemesFragmentBinding3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        RecyclerView recyclerView2 = nStockMemesFragmentBinding3.memesRecyclerView;
        Intrinsics.checkNotNullExpressionValue(recyclerView2, "binding.memesRecyclerView");
        recyclerView2.setAdapter(getMemesAdapter());
        BaseMediaCategoryAdapter.setSelectedItemIds$default(getMemesAdapter(), this.selectedItemIds, false, 2, (Object) null);
        NStockMemesFragmentBinding nStockMemesFragmentBinding4 = this.binding;
        if (nStockMemesFragmentBinding4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        nStockMemesFragmentBinding4.memesRecyclerView.clearOnScrollListeners();
        NStockMemesFragmentBinding nStockMemesFragmentBinding5 = this.binding;
        if (nStockMemesFragmentBinding5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        RecyclerView recyclerView3 = nStockMemesFragmentBinding5.memesRecyclerView;
        Intrinsics.checkNotNullExpressionValue(recyclerView3, "binding.memesRecyclerView");
        this.paginator = ExtensionsKt.addPaginator(recyclerView3, layoutManager, new StockMemesFragment$onViewCreated$1(this));
        getStockMemesViewModel().onQueryTextUpdateAvailable().observe(getViewLifecycleOwner(), new StockMemesFragment$onViewCreated$2(this));
        getStockMemesViewModel().memes().observe(getViewLifecycleOwner(), new StockMemesFragment$onViewCreated$3(this));
        getStockMemesViewModel().onContentVisibilityChanged().observe(getViewLifecycleOwner(), new StockMemesFragment$onViewCreated$4(this));
        NStockMemesFragmentBinding nStockMemesFragmentBinding6 = this.binding;
        if (nStockMemesFragmentBinding6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        EditText editText = nStockMemesFragmentBinding6.includedSearchLayout.searchEditText;
        Intrinsics.checkNotNullExpressionValue(editText, "binding.includedSearchLayout.searchEditText");
        editText.setHint(getString(C4175R.string.stock_memes_search_hint));
        NStockMemesFragmentBinding nStockMemesFragmentBinding7 = this.binding;
        if (nStockMemesFragmentBinding7 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        nStockMemesFragmentBinding7.includedSearchLayout.searchEditText.setOnEditorActionListener(new StockMemesFragment$onViewCreated$5(this));
        NStockMemesFragmentBinding nStockMemesFragmentBinding8 = this.binding;
        if (nStockMemesFragmentBinding8 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        EditText editText2 = nStockMemesFragmentBinding8.includedSearchLayout.searchEditText;
        Intrinsics.checkNotNullExpressionValue(editText2, "binding.includedSearchLayout.searchEditText");
        editText2.addTextChangedListener(new C4834x9e5deb3d(this));
        NStockMemesFragmentBinding nStockMemesFragmentBinding9 = this.binding;
        if (nStockMemesFragmentBinding9 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        nStockMemesFragmentBinding9.includedSearchLayout.searchInputCancelImageView.setOnClickListener(new StockMemesFragment$onViewCreated$7(this));
        NStockMemesFragmentBinding nStockMemesFragmentBinding10 = this.binding;
        if (nStockMemesFragmentBinding10 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        nStockMemesFragmentBinding10.includedSearchLayout.searchImageView.setOnClickListener(new StockMemesFragment$onViewCreated$8(this));
        performSearch();
    }

    /* access modifiers changed from: private */
    public final void onSearchQueryChanged(String str) {
        NStockMemesFragmentBinding nStockMemesFragmentBinding = this.binding;
        if (nStockMemesFragmentBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        ImageView imageView = nStockMemesFragmentBinding.includedSearchLayout.searchInputCancelImageView;
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
        NStockMemesFragmentBinding nStockMemesFragmentBinding = this.binding;
        if (nStockMemesFragmentBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        EditText editText = nStockMemesFragmentBinding.includedSearchLayout.searchEditText;
        Intrinsics.checkNotNullExpressionValue(editText, "binding.includedSearchLayout.searchEditText");
        Editable text = editText.getText();
        if (text == null || (str = text.toString()) == null) {
            str = "";
        }
        getStockMemesViewModel().queryTextChanged(str);
        Paginator paginator2 = this.paginator;
        if (paginator2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("paginator");
        }
        paginator2.resetState();
        SoftKeyboardUtil softKeyboardUtil = SoftKeyboardUtil.INSTANCE;
        NStockMemesFragmentBinding nStockMemesFragmentBinding2 = this.binding;
        if (nStockMemesFragmentBinding2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        EditText editText2 = nStockMemesFragmentBinding2.includedSearchLayout.searchEditText;
        Intrinsics.checkNotNullExpressionValue(editText2, "binding.includedSearchLayout.searchEditText");
        softKeyboardUtil.hideKeyboard(editText2);
        getStockMemesViewModel().search();
    }

    public void setSelectedItemIds(List<String> list) {
        this.selectedItemIds.clear();
        Collection collection = list;
        if (!(collection == null || collection.isEmpty())) {
            this.selectedItemIds.addAll(collection);
        }
    }

    public void onContentLayoutErrorResolutionButtonTapped(int i, int i2) {
        NStockMemesFragmentBinding nStockMemesFragmentBinding = this.binding;
        if (nStockMemesFragmentBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        ContentLayout contentLayout = nStockMemesFragmentBinding.contentLayout;
        Intrinsics.checkNotNullExpressionValue(contentLayout, "binding.contentLayout");
        if (i == contentLayout.getId() && i2 == 1211) {
            getStockMemesViewModel().refresh();
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
            NStockMemesFragmentBinding nStockMemesFragmentBinding = this.binding;
            if (nStockMemesFragmentBinding == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
            }
            nStockMemesFragmentBinding.memesRecyclerView.clearOnScrollListeners();
        }
        super.onDestroyView();
    }
}
