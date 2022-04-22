package com.giphy.sdk.p013ui.views;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.OnLifecycleEvent;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.giphy.sdk.analytics.models.enums.ActionType;
import com.giphy.sdk.core.models.Media;
import com.giphy.sdk.core.models.enums.MediaType;
import com.giphy.sdk.core.models.enums.RenditionType;
import com.giphy.sdk.p013ui.list.GifsPagedListAdapter;
import com.giphy.sdk.p013ui.list.WrapStaggeredGridLayoutManager;
import com.giphy.sdk.p013ui.pagination.GifsQuery;
import com.giphy.sdk.p013ui.pagination.GifsViewModel;
import com.giphy.sdk.p013ui.themes.GridType;
import com.giphy.sdk.p013ui.tracking.GifTrackingManagerWrapper;
import com.giphy.sdk.tracking.GifTrackingManager;
import java.util.HashMap;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import timber.log.Timber;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000§\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005*\u0001P\u0018\u00002\u00020\u00012\u00020\u0002B%\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b¢\u0006\u0002\u0010\tJ\b\u0010@\u001a\u00020&H\u0003J\u000e\u0010A\u001a\u00020&2\u0006\u0010B\u001a\u00020CJ\u000e\u0010A\u001a\u00020&2\u0006\u0010D\u001a\u00020EJ\b\u0010F\u001a\u00020&H\u0002J\u0010\u0010G\u001a\u00020&2\u0006\u0010H\u001a\u00020IH\u0002J\u0010\u0010J\u001a\u00020K2\u0006\u0010L\u001a\u00020\bH\u0002J\b\u0010M\u001a\u00020KH\u0002J\b\u0010N\u001a\u00020KH\u0002J\r\u0010O\u001a\u00020PH\u0002¢\u0006\u0002\u0010QJ\u001e\u0010R\u001a\u00020&2\f\u0010S\u001a\b\u0012\u0004\u0012\u00020!0T2\u0006\u0010U\u001a\u00020\bH\u0002J\b\u0010V\u001a\u00020WH\u0002J\b\u0010X\u001a\u00020&H\u0002J\u001e\u0010Y\u001a\u00020&2\f\u0010S\u001a\b\u0012\u0004\u0012\u00020!0T2\u0006\u0010U\u001a\u00020\bH\u0002J\u0010\u0010Z\u001a\u00020W2\u0006\u0010[\u001a\u00020\u0019H\u0002R\u001c\u0010\n\u001a\u0004\u0018\u00010\u000bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u000e\u0010\u0010\u001a\u00020\u0011X.¢\u0006\u0002\n\u0000R\u001a\u0010\u0012\u001a\u00020\u0013X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R$\u0010\u001a\u001a\u00020\u00192\u0006\u0010\u0018\u001a\u00020\u0019@FX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001eR=\u0010\u001f\u001a%\u0012\u0004\u0012\u00020!\u0012\u0015\u0012\u0013\u0018\u00010\"¢\u0006\f\b#\u0012\b\b$\u0012\u0004\b\b(%\u0012\u0004\u0012\u00020&0 X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b'\u0010(\"\u0004\b)\u0010*R&\u0010+\u001a\u000e\u0012\u0004\u0012\u00020!\u0012\u0004\u0012\u00020&0,X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b-\u0010.\"\u0004\b/\u00100R&\u00101\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020&0,X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b2\u0010.\"\u0004\b3\u00100R(\u00105\u001a\u0004\u0018\u0001042\b\u0010\u0018\u001a\u0004\u0018\u000104@FX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b6\u00107\"\u0004\b8\u00109R\u001c\u0010:\u001a\u0004\u0018\u00010;X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b<\u0010=\"\u0004\b>\u0010?¨\u0006\\"}, mo26107d2 = {"Lcom/giphy/sdk/ui/views/GifsRecyclerView;", "Landroidx/recyclerview/widget/RecyclerView;", "Landroidx/lifecycle/LifecycleObserver;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "gifTrackingManager", "Lcom/giphy/sdk/tracking/GifTrackingManager;", "getGifTrackingManager", "()Lcom/giphy/sdk/tracking/GifTrackingManager;", "setGifTrackingManager", "(Lcom/giphy/sdk/tracking/GifTrackingManager;)V", "gifsViewModel", "Lcom/giphy/sdk/ui/pagination/GifsViewModel;", "gridType", "Lcom/giphy/sdk/ui/themes/GridType;", "getGridType", "()Lcom/giphy/sdk/ui/themes/GridType;", "setGridType", "(Lcom/giphy/sdk/ui/themes/GridType;)V", "value", "Lcom/giphy/sdk/core/models/enums/MediaType;", "mediaType", "getMediaType", "()Lcom/giphy/sdk/core/models/enums/MediaType;", "setMediaType", "(Lcom/giphy/sdk/core/models/enums/MediaType;)V", "onGifLongPressListener", "Lkotlin/Function2;", "Lcom/giphy/sdk/core/models/Media;", "Landroid/view/View;", "Lkotlin/ParameterName;", "name", "anchor", "", "getOnGifLongPressListener", "()Lkotlin/jvm/functions/Function2;", "setOnGifLongPressListener", "(Lkotlin/jvm/functions/Function2;)V", "onGifSelectedListener", "Lkotlin/Function1;", "getOnGifSelectedListener", "()Lkotlin/jvm/functions/Function1;", "setOnGifSelectedListener", "(Lkotlin/jvm/functions/Function1;)V", "onResultsUpdateListener", "getOnResultsUpdateListener", "setOnResultsUpdateListener", "Lcom/giphy/sdk/ui/pagination/GifsQuery;", "query", "getQuery", "()Lcom/giphy/sdk/ui/pagination/GifsQuery;", "setQuery", "(Lcom/giphy/sdk/ui/pagination/GifsQuery;)V", "renditionType", "Lcom/giphy/sdk/core/models/enums/RenditionType;", "getRenditionType", "()Lcom/giphy/sdk/core/models/enums/RenditionType;", "setRenditionType", "(Lcom/giphy/sdk/core/models/enums/RenditionType;)V", "cleanUp", "configure", "fragment", "Landroidx/fragment/app/Fragment;", "activity", "Landroidx/fragment/app/FragmentActivity;", "configureRecyclerViewForGridType", "configureWithLifecycleOwner", "lifecycleOwner", "Landroidx/lifecycle/LifecycleOwner;", "createItemDecorationForGrid", "Landroidx/recyclerview/widget/RecyclerView$ItemDecoration;", "spanCount", "createItemDecorationForLinear", "createItemDecorationForStaggered", "getSpanSizeLookup", "com/giphy/sdk/ui/views/GifsRecyclerView$getSpanSizeLookup$1", "()Lcom/giphy/sdk/ui/views/GifsRecyclerView$getSpanSizeLookup$1;", "gifClickListener", "gifs", "", "position", "needToConfigureRecyclerViewForGridType", "", "onCurrentListChanged", "onGifLongClickListener", "showBackgroundForMediaType", "type", "ui-sdk_release"}, mo26108k = 1, mo26109mv = {1, 1, 13})
/* renamed from: com.giphy.sdk.ui.views.GifsRecyclerView */
/* compiled from: GifsRecyclerView.kt */
public final class GifsRecyclerView extends RecyclerView implements LifecycleObserver {
    private HashMap _$_findViewCache;
    private GifTrackingManager gifTrackingManager;
    /* access modifiers changed from: private */
    public GifsViewModel gifsViewModel;
    private GridType gridType;
    private MediaType mediaType;
    private Function2<? super Media, ? super View, Unit> onGifLongPressListener;
    private Function1<? super Media, Unit> onGifSelectedListener;
    private Function1<? super Integer, Unit> onResultsUpdateListener;
    private GifsQuery query;
    private RenditionType renditionType;

    @Metadata(mo26105bv = {1, 0, 3}, mo26108k = 3, mo26109mv = {1, 1, 13})
    /* renamed from: com.giphy.sdk.ui.views.GifsRecyclerView$WhenMappings */
    public final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;
        public static final /* synthetic */ int[] $EnumSwitchMapping$1;

        static {
            int[] iArr = new int[GridType.values().length];
            $EnumSwitchMapping$0 = iArr;
            iArr[GridType.waterfall.ordinal()] = 1;
            iArr[GridType.carousel.ordinal()] = 2;
            iArr[GridType.emoji.ordinal()] = 3;
            int[] iArr2 = new int[MediaType.values().length];
            $EnumSwitchMapping$1 = iArr2;
            iArr2[MediaType.gif.ordinal()] = 1;
            iArr2[MediaType.emoji.ordinal()] = 2;
        }
    }

    public GifsRecyclerView(Context context) {
        this(context, (AttributeSet) null, 0, 6, (DefaultConstructorMarker) null);
    }

    public GifsRecyclerView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, (DefaultConstructorMarker) null);
    }

    public void _$_clearFindViewByIdCache() {
        HashMap hashMap = this._$_findViewCache;
        if (hashMap != null) {
            hashMap.clear();
        }
    }

    public View _$_findCachedViewById(int i) {
        if (this._$_findViewCache == null) {
            this._$_findViewCache = new HashMap();
        }
        View view = (View) this._$_findViewCache.get(Integer.valueOf(i));
        if (view != null) {
            return view;
        }
        View findViewById = findViewById(i);
        this._$_findViewCache.put(Integer.valueOf(i), findViewById);
        return findViewById;
    }

    public static final /* synthetic */ GifsViewModel access$getGifsViewModel$p(GifsRecyclerView gifsRecyclerView) {
        GifsViewModel gifsViewModel2 = gifsRecyclerView.gifsViewModel;
        if (gifsViewModel2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("gifsViewModel");
        }
        return gifsViewModel2;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ GifsRecyclerView(Context context, AttributeSet attributeSet, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i2 & 2) != 0 ? null : attributeSet, (i2 & 4) != 0 ? 0 : i);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public GifsRecyclerView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Intrinsics.checkParameterIsNotNull(context, "context");
        this.gridType = GridType.waterfall;
        this.mediaType = MediaType.gif;
        this.onResultsUpdateListener = GifsRecyclerView$onResultsUpdateListener$1.INSTANCE;
        this.onGifSelectedListener = GifsRecyclerView$onGifSelectedListener$1.INSTANCE;
        this.onGifLongPressListener = GifsRecyclerView$onGifLongPressListener$1.INSTANCE;
    }

    public final GifsQuery getQuery() {
        return this.query;
    }

    public final void setQuery(GifsQuery gifsQuery) {
        if (!(this.gifsViewModel == null || gifsQuery == null)) {
            GifsViewModel gifsViewModel2 = this.gifsViewModel;
            if (gifsViewModel2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("gifsViewModel");
            }
            gifsViewModel2.setQuery(gifsQuery);
        }
        this.query = gifsQuery;
    }

    public final GridType getGridType() {
        return this.gridType;
    }

    public final void setGridType(GridType gridType2) {
        Intrinsics.checkParameterIsNotNull(gridType2, "<set-?>");
        this.gridType = gridType2;
    }

    public final RenditionType getRenditionType() {
        return this.renditionType;
    }

    public final void setRenditionType(RenditionType renditionType2) {
        this.renditionType = renditionType2;
    }

    public final MediaType getMediaType() {
        return this.mediaType;
    }

    public final void setMediaType(MediaType mediaType2) {
        Intrinsics.checkParameterIsNotNull(mediaType2, "value");
        this.mediaType = mediaType2;
        RecyclerView.Adapter adapter = getAdapter();
        if (!(adapter instanceof GifsPagedListAdapter)) {
            adapter = null;
        }
        GifsPagedListAdapter gifsPagedListAdapter = (GifsPagedListAdapter) adapter;
        if (gifsPagedListAdapter != null) {
            gifsPagedListAdapter.setBackgroundVisible(showBackgroundForMediaType(mediaType2));
        }
    }

    public final Function1<Integer, Unit> getOnResultsUpdateListener() {
        return this.onResultsUpdateListener;
    }

    public final void setOnResultsUpdateListener(Function1<? super Integer, Unit> function1) {
        Intrinsics.checkParameterIsNotNull(function1, "<set-?>");
        this.onResultsUpdateListener = function1;
    }

    public final Function1<Media, Unit> getOnGifSelectedListener() {
        return this.onGifSelectedListener;
    }

    public final void setOnGifSelectedListener(Function1<? super Media, Unit> function1) {
        Intrinsics.checkParameterIsNotNull(function1, "<set-?>");
        this.onGifSelectedListener = function1;
    }

    public final Function2<Media, View, Unit> getOnGifLongPressListener() {
        return this.onGifLongPressListener;
    }

    public final void setOnGifLongPressListener(Function2<? super Media, ? super View, Unit> function2) {
        Intrinsics.checkParameterIsNotNull(function2, "<set-?>");
        this.onGifLongPressListener = function2;
    }

    public final GifTrackingManager getGifTrackingManager() {
        return this.gifTrackingManager;
    }

    public final void setGifTrackingManager(GifTrackingManager gifTrackingManager2) {
        this.gifTrackingManager = gifTrackingManager2;
    }

    public final void configure(Fragment fragment) {
        Intrinsics.checkParameterIsNotNull(fragment, "fragment");
        ViewModel viewModel = ViewModelProviders.m15of(fragment).get(GifsViewModel.class);
        Intrinsics.checkExpressionValueIsNotNull(viewModel, "ViewModelProviders.of(fr…ifsViewModel::class.java)");
        this.gifsViewModel = (GifsViewModel) viewModel;
        ViewModel viewModel2 = ViewModelProviders.m15of(fragment).get(GifTrackingManagerWrapper.class);
        Intrinsics.checkExpressionValueIsNotNull(viewModel2, "ViewModelProviders.of(fr…nagerWrapper::class.java)");
        this.gifTrackingManager = ((GifTrackingManagerWrapper) viewModel2).getGifTrackingManager();
        GifsViewModel gifsViewModel2 = this.gifsViewModel;
        if (gifsViewModel2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("gifsViewModel");
        }
        Timber.m300d(String.valueOf(gifsViewModel2), new Object[0]);
        configureWithLifecycleOwner(fragment);
    }

    public final void configure(FragmentActivity fragmentActivity) {
        Intrinsics.checkParameterIsNotNull(fragmentActivity, "activity");
        ViewModel viewModel = ViewModelProviders.m17of(fragmentActivity).get(GifsViewModel.class);
        Intrinsics.checkExpressionValueIsNotNull(viewModel, "ViewModelProviders.of(ac…ifsViewModel::class.java)");
        this.gifsViewModel = (GifsViewModel) viewModel;
        ViewModel viewModel2 = ViewModelProviders.m17of(fragmentActivity).get(GifTrackingManagerWrapper.class);
        Intrinsics.checkExpressionValueIsNotNull(viewModel2, "ViewModelProviders.of(ac…nagerWrapper::class.java)");
        this.gifTrackingManager = ((GifTrackingManagerWrapper) viewModel2).getGifTrackingManager();
        configureWithLifecycleOwner(fragmentActivity);
    }

    private final void configureWithLifecycleOwner(LifecycleOwner lifecycleOwner) {
        GifsQuery gifsQuery;
        Context context = getContext();
        Intrinsics.checkExpressionValueIsNotNull(context, "context");
        GifsPagedListAdapter gifsPagedListAdapter = new GifsPagedListAdapter(context, new GifsRecyclerView$configureWithLifecycleOwner$adapter$1(this));
        GifsRecyclerView gifsRecyclerView = this;
        gifsPagedListAdapter.setOnGifClickListener(new GifsRecyclerView$configureWithLifecycleOwner$adapter$2$1(gifsRecyclerView));
        gifsPagedListAdapter.setOnGifLongPressListener(new GifsRecyclerView$configureWithLifecycleOwner$adapter$2$2(gifsRecyclerView));
        gifsPagedListAdapter.setOnCurrentListChanged(new GifsRecyclerView$configureWithLifecycleOwner$adapter$2$3(gifsRecyclerView));
        gifsPagedListAdapter.setGridType(this.gridType);
        gifsPagedListAdapter.setRenditionType(this.renditionType);
        gifsPagedListAdapter.setBackgroundVisible(showBackgroundForMediaType(this.mediaType));
        setAdapter(gifsPagedListAdapter);
        GifsViewModel gifsViewModel2 = this.gifsViewModel;
        if (gifsViewModel2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("gifsViewModel");
        }
        gifsViewModel2.getGifItems().observe(lifecycleOwner, new GifsRecyclerView$configureWithLifecycleOwner$1(gifsPagedListAdapter));
        GifsViewModel gifsViewModel3 = this.gifsViewModel;
        if (gifsViewModel3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("gifsViewModel");
        }
        gifsViewModel3.getResponseState().observe(lifecycleOwner, new GifsRecyclerView$configureWithLifecycleOwner$2(gifsPagedListAdapter));
        GifsViewModel gifsViewModel4 = this.gifsViewModel;
        if (gifsViewModel4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("gifsViewModel");
        }
        gifsViewModel4.getTotalItemsCount().observe(lifecycleOwner, new GifsRecyclerView$configureWithLifecycleOwner$3(this));
        GifsViewModel gifsViewModel5 = this.gifsViewModel;
        if (gifsViewModel5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("gifsViewModel");
        }
        if (gifsViewModel5.getQueryParams().getValue() == null && (gifsQuery = this.query) != null) {
            GifsViewModel gifsViewModel6 = this.gifsViewModel;
            if (gifsViewModel6 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("gifsViewModel");
            }
            gifsViewModel6.setQuery(gifsQuery);
        }
        GifTrackingManager gifTrackingManager2 = this.gifTrackingManager;
        if (gifTrackingManager2 != null) {
            gifTrackingManager2.attachToRecyclerView(this, gifsPagedListAdapter);
        }
        lifecycleOwner.getLifecycle().addObserver(this);
        configureRecyclerViewForGridType();
    }

    /* access modifiers changed from: private */
    public final void gifClickListener(List<Media> list, int i) {
        GifTrackingManager gifTrackingManager2 = this.gifTrackingManager;
        if (gifTrackingManager2 != null) {
            GifTrackingManager.trackMedia$default(gifTrackingManager2, list.get(i), ActionType.CLICK, (String) null, (String) null, 12, (Object) null);
        }
        this.onGifSelectedListener.invoke(list.get(i));
    }

    /* access modifiers changed from: private */
    public final void onGifLongClickListener(List<Media> list, int i) {
        Function2<? super Media, ? super View, Unit> function2 = this.onGifLongPressListener;
        Media media = list.get(i);
        RecyclerView.ViewHolder findViewHolderForAdapterPosition = findViewHolderForAdapterPosition(i);
        function2.invoke(media, findViewHolderForAdapterPosition != null ? findViewHolderForAdapterPosition.itemView : null);
    }

    /* access modifiers changed from: private */
    public final void onCurrentListChanged() {
        Timber.m300d("onCurrentListChanged", new Object[0]);
        GifTrackingManager gifTrackingManager2 = this.gifTrackingManager;
        if (gifTrackingManager2 != null) {
            gifTrackingManager2.reset();
        }
        configureRecyclerViewForGridType();
    }

    private final RecyclerView.ItemDecoration createItemDecorationForStaggered() {
        return new GifsRecyclerView$createItemDecorationForStaggered$1(this);
    }

    private final RecyclerView.ItemDecoration createItemDecorationForLinear() {
        return new GifsRecyclerView$createItemDecorationForLinear$1(this);
    }

    private final boolean needToConfigureRecyclerViewForGridType() {
        return (this.gridType == GridType.waterfall && !(getLayoutManager() instanceof WrapStaggeredGridLayoutManager)) || (this.gridType == GridType.carousel && !(getLayoutManager() instanceof LinearLayoutManager)) || (this.gridType == GridType.emoji && !(getLayoutManager() instanceof GridLayoutManager));
    }

    private final void configureRecyclerViewForGridType() {
        if (needToConfigureRecyclerViewForGridType()) {
            while (getItemDecorationCount() > 0) {
                removeItemDecorationAt(0);
            }
            int i = WhenMappings.$EnumSwitchMapping$0[this.gridType.ordinal()];
            if (i == 1) {
                setLayoutManager(new WrapStaggeredGridLayoutManager(2, 1));
                addItemDecoration(createItemDecorationForStaggered());
            } else if (i == 2) {
                setLayoutManager(new LinearLayoutManager(getContext(), 0, false));
                addItemDecoration(createItemDecorationForLinear());
            } else if (i == 3) {
                GridLayoutManager gridLayoutManager = new GridLayoutManager(getContext(), 5);
                gridLayoutManager.setSpanSizeLookup(getSpanSizeLookup());
                setLayoutManager(gridLayoutManager);
                addItemDecoration(createItemDecorationForGrid(5));
            }
        }
    }

    private final GifsRecyclerView$getSpanSizeLookup$1 getSpanSizeLookup() {
        return new GifsRecyclerView$getSpanSizeLookup$1(this);
    }

    private final RecyclerView.ItemDecoration createItemDecorationForGrid(int i) {
        return new GifsRecyclerView$createItemDecorationForGrid$1(this, i);
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
    private final void cleanUp() {
        Timber.m300d("cleanUp", new Object[0]);
    }

    private final boolean showBackgroundForMediaType(MediaType mediaType2) {
        int i = WhenMappings.$EnumSwitchMapping$1[mediaType2.ordinal()];
        return (i == 1 || i == 2) ? false : true;
    }
}
