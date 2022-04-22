package com.giphy.sdk.p013ui.list;

import android.content.Context;
import android.os.Build;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.paging.PagedList;
import androidx.paging.PagedListAdapter;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.RecyclerView;
import com.giphy.sdk.core.models.Media;
import com.giphy.sdk.core.models.enums.RenditionType;
import com.giphy.sdk.p013ui.C1800R;
import com.giphy.sdk.p013ui.ConstantsKt;
import com.giphy.sdk.p013ui.ads.AdPillAlreadySeen;
import com.giphy.sdk.p013ui.ads.AdPillSize;
import com.giphy.sdk.p013ui.pagination.NetworkState;
import com.giphy.sdk.p013ui.pagination.NetworkStateItemViewHolder;
import com.giphy.sdk.p013ui.pagination.NoContentItemViewHolder;
import com.giphy.sdk.p013ui.pagination.Status;
import com.giphy.sdk.p013ui.themes.GridType;
import com.giphy.sdk.p013ui.views.GifView;
import com.giphy.sdk.tracking.GPHAdSession;
import com.giphy.sdk.tracking.GifTrackingCallback;
import com.giphy.sdk.tracking.MediaExtensionKt;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import timber.log.Timber;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 W2\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u00012\u00020\u0004:\u0001WB\u001b\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\b¢\u0006\u0002\u0010\nJ\b\u0010A\u001a\u00020-H\u0016J\u0010\u0010B\u001a\u00020-2\u0006\u0010.\u001a\u00020-H\u0016J\b\u0010C\u001a\u00020\u0012H\u0002J\u001e\u0010D\u001a\u00020\u00122\u0006\u0010.\u001a\u00020-2\f\u0010E\u001a\b\u0012\u0004\u0012\u00020\t0\bH\u0016J\u0012\u0010F\u001a\u0004\u0018\u00010\u00022\u0006\u0010.\u001a\u00020-H\u0016J\u0010\u0010G\u001a\u00020\t2\u0006\u00106\u001a\u000207H\u0016J\u0018\u0010H\u001a\u00020\t2\u0006\u0010I\u001a\u00020\u00032\u0006\u0010.\u001a\u00020-H\u0016J\b\u0010J\u001a\u00020KH\u0002J\u0018\u0010L\u001a\u00020\u00032\u0006\u0010M\u001a\u00020N2\u0006\u0010O\u001a\u00020-H\u0016J\u0018\u0010\"\u001a\u00020\t2\u000e\u0010P\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010QH\u0016J\u0010\u0010R\u001a\u00020\t2\u0006\u0010I\u001a\u00020\u0003H\u0016J\u001f\u0010S\u001a\u00020\t2\b\u0010T\u001a\u0004\u0018\u00010!2\b\u0010U\u001a\u0004\u0018\u00010-¢\u0006\u0002\u0010VR\u000e\u0010\u000b\u001a\u00020\fX\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u000e\u0010\u000f\u001a\u00020\u0010X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u0013\u001a\u00020\u0014X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\u001a\u0010\u0019\u001a\u00020\u0012X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001cR\u0016\u0010\u001d\u001a\n \u001f*\u0004\u0018\u00010\u001e0\u001eX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010 \u001a\u0004\u0018\u00010!X\u000e¢\u0006\u0002\n\u0000R\"\u0010\"\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b#\u0010$\"\u0004\b%\u0010&RR\u0010'\u001a:\u0012\u0019\u0012\u0017\u0012\u0004\u0012\u00020\u00020)¢\u0006\f\b*\u0012\b\b+\u0012\u0004\b\b(,\u0012\u0013\u0012\u00110-¢\u0006\f\b*\u0012\b\b+\u0012\u0004\b\b(.\u0012\u0004\u0012\u00020\t\u0018\u00010(X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b/\u00100\"\u0004\b1\u00102RR\u00103\u001a:\u0012\u0019\u0012\u0017\u0012\u0004\u0012\u00020\u00020)¢\u0006\f\b*\u0012\b\b+\u0012\u0004\b\b(,\u0012\u0013\u0012\u00110-¢\u0006\f\b*\u0012\b\b+\u0012\u0004\b\b(.\u0012\u0004\u0012\u00020\t\u0018\u00010(X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b4\u00100\"\u0004\b5\u00102R\u0010\u00106\u001a\u0004\u0018\u000107X\u000e¢\u0006\u0002\n\u0000R\u001c\u00108\u001a\u0004\u0018\u000109X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b:\u0010;\"\u0004\b<\u0010=R\u001a\u0010>\u001a\u00020\u0012X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b?\u0010\u001a\"\u0004\b@\u0010\u001cR\u0014\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\bX\u0004¢\u0006\u0002\n\u0000¨\u0006X"}, mo26107d2 = {"Lcom/giphy/sdk/ui/list/GifsPagedListAdapter;", "Landroidx/paging/PagedListAdapter;", "Lcom/giphy/sdk/core/models/Media;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "Lcom/giphy/sdk/tracking/GifTrackingCallback;", "context", "Landroid/content/Context;", "retryCallback", "Lkotlin/Function0;", "", "(Landroid/content/Context;Lkotlin/jvm/functions/Function0;)V", "adPillAlreadySeen", "Lcom/giphy/sdk/ui/ads/AdPillAlreadySeen;", "getContext", "()Landroid/content/Context;", "dummyOMView", "Landroid/view/View;", "emptyResults", "", "gridType", "Lcom/giphy/sdk/ui/themes/GridType;", "getGridType", "()Lcom/giphy/sdk/ui/themes/GridType;", "setGridType", "(Lcom/giphy/sdk/ui/themes/GridType;)V", "isBackgroundVisible", "()Z", "setBackgroundVisible", "(Z)V", "layoutInflater", "Landroid/view/LayoutInflater;", "kotlin.jvm.PlatformType", "networkState", "Lcom/giphy/sdk/ui/pagination/NetworkState;", "onCurrentListChanged", "getOnCurrentListChanged", "()Lkotlin/jvm/functions/Function0;", "setOnCurrentListChanged", "(Lkotlin/jvm/functions/Function0;)V", "onGifClickListener", "Lkotlin/Function2;", "", "Lkotlin/ParameterName;", "name", "gifs", "", "position", "getOnGifClickListener", "()Lkotlin/jvm/functions/Function2;", "setOnGifClickListener", "(Lkotlin/jvm/functions/Function2;)V", "onGifLongPressListener", "getOnGifLongPressListener", "setOnGifLongPressListener", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "renditionType", "Lcom/giphy/sdk/core/models/enums/RenditionType;", "getRenditionType", "()Lcom/giphy/sdk/core/models/enums/RenditionType;", "setRenditionType", "(Lcom/giphy/sdk/core/models/enums/RenditionType;)V", "resetTracking", "getResetTracking", "setResetTracking", "getItemCount", "getItemViewType", "hasExtraRow", "isMediaLoadedForIndex", "onLoad", "mediaForIndex", "onAttachedToRecyclerView", "onBindViewHolder", "holder", "onCreateGifViewHolder", "Lcom/giphy/sdk/ui/list/GifViewHolder;", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "currentList", "Landroidx/paging/PagedList;", "onViewRecycled", "setNetworkState", "newNetworkState", "resultCount", "(Lcom/giphy/sdk/ui/pagination/NetworkState;Ljava/lang/Integer;)V", "Companion", "ui-sdk_release"}, mo26108k = 1, mo26109mv = {1, 1, 13})
/* renamed from: com.giphy.sdk.ui.list.GifsPagedListAdapter */
/* compiled from: GifsPagedListAdapter.kt */
public final class GifsPagedListAdapter extends PagedListAdapter<Media, RecyclerView.ViewHolder> implements GifTrackingCallback {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    /* access modifiers changed from: private */
    public static final DiffUtil.ItemCallback<Media> POST_COMPARATOR = new GifsPagedListAdapter$Companion$POST_COMPARATOR$1();
    public static final int VIEW_ITEM = 1;
    public static final int VIEW_LOADING = 0;
    public static final int VIEW_NO_CONTENT = 2;
    private final AdPillAlreadySeen adPillAlreadySeen = new AdPillAlreadySeen();
    private final Context context;
    private View dummyOMView;
    private boolean emptyResults;
    private GridType gridType = GridType.waterfall;
    private boolean isBackgroundVisible = true;
    private LayoutInflater layoutInflater;
    private NetworkState networkState;
    private Function0<Unit> onCurrentListChanged;
    private Function2<? super List<Media>, ? super Integer, Unit> onGifClickListener;
    private Function2<? super List<Media>, ? super Integer, Unit> onGifLongPressListener;
    private RecyclerView recyclerView;
    private RenditionType renditionType;
    private boolean resetTracking;
    private final Function0<Unit> retryCallback;

    public final Context getContext() {
        return this.context;
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public GifsPagedListAdapter(Context context2, Function0<Unit> function0) {
        super(POST_COMPARATOR);
        Intrinsics.checkParameterIsNotNull(context2, "context");
        Intrinsics.checkParameterIsNotNull(function0, "retryCallback");
        this.context = context2;
        this.retryCallback = function0;
        this.layoutInflater = LayoutInflater.from(context2);
        this.dummyOMView = new View(context2);
    }

    public final boolean isBackgroundVisible() {
        return this.isBackgroundVisible;
    }

    public final void setBackgroundVisible(boolean z) {
        this.isBackgroundVisible = z;
    }

    public final Function2<List<Media>, Integer, Unit> getOnGifClickListener() {
        return this.onGifClickListener;
    }

    public final void setOnGifClickListener(Function2<? super List<Media>, ? super Integer, Unit> function2) {
        this.onGifClickListener = function2;
    }

    public final Function2<List<Media>, Integer, Unit> getOnGifLongPressListener() {
        return this.onGifLongPressListener;
    }

    public final void setOnGifLongPressListener(Function2<? super List<Media>, ? super Integer, Unit> function2) {
        this.onGifLongPressListener = function2;
    }

    public final Function0<Unit> getOnCurrentListChanged() {
        return this.onCurrentListChanged;
    }

    public final void setOnCurrentListChanged(Function0<Unit> function0) {
        this.onCurrentListChanged = function0;
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

    public void onAttachedToRecyclerView(RecyclerView recyclerView2) {
        Intrinsics.checkParameterIsNotNull(recyclerView2, "recyclerView");
        this.recyclerView = recyclerView2;
    }

    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        Intrinsics.checkParameterIsNotNull(viewGroup, "parent");
        if (i == 0) {
            View inflate = this.layoutInflater.inflate(this.gridType == GridType.waterfall ? C1800R.C1804layout.gph_network_state_item : C1800R.C1804layout.gph_network_state_item_carousel, viewGroup, false);
            Intrinsics.checkExpressionValueIsNotNull(inflate, "layoutInflater.inflate(\n…                        )");
            return new NetworkStateItemViewHolder(inflate, this.retryCallback);
        } else if (i == 1) {
            return onCreateGifViewHolder();
        } else {
            if (i == 2) {
                View inflate2 = this.layoutInflater.inflate(this.gridType == GridType.waterfall ? C1800R.C1804layout.gph_no_content_item : C1800R.C1804layout.gph_no_content_item_carousel, viewGroup, false);
                Intrinsics.checkExpressionValueIsNotNull(inflate2, "layoutInflater.inflate(\n…                        )");
                return new NoContentItemViewHolder(inflate2);
            }
            throw new IllegalArgumentException("onCreateViewHolder: Invalid item type");
        }
    }

    public final boolean getResetTracking() {
        return this.resetTracking;
    }

    public final void setResetTracking(boolean z) {
        this.resetTracking = z;
    }

    public void onCurrentListChanged(PagedList<Media> pagedList) {
        Function0<Unit> function0;
        if (this.resetTracking && (function0 = this.onCurrentListChanged) != null) {
            Unit invoke = function0.invoke();
        }
        this.resetTracking = true;
    }

    private final GifViewHolder onCreateGifViewHolder() {
        GifView gifView = new GifView(this.context, (AttributeSet) null, 0, 6, (DefaultConstructorMarker) null);
        if (Build.VERSION.SDK_INT >= 23) {
            gifView.setForeground(this.context.getResources().getDrawable(C1800R.C1802drawable.grid_view_selector));
        }
        gifView.setBackgroundVisible(this.isBackgroundVisible);
        gifView.setAdPill(AdPillSize.LARGE);
        return new GifViewHolder(gifView);
    }

    public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int i) {
        GPHAdSession adSession;
        GPHAdSession adSession2;
        Intrinsics.checkParameterIsNotNull(viewHolder, "holder");
        int itemViewType = getItemViewType(i);
        if (itemViewType == 0) {
            ((NetworkStateItemViewHolder) viewHolder).bindTo(this.networkState);
        } else if (itemViewType == 1) {
            Media media = (Media) getItem(i);
            if (!(media == null || (adSession2 = MediaExtensionKt.getAdSession(media)) == null)) {
                adSession2.start();
            }
            if (media != null) {
                GifViewHolder gifViewHolder = (GifViewHolder) viewHolder;
                GifView view = gifViewHolder.getView();
                if (view != null) {
                    view.setBackgroundVisible(this.isBackgroundVisible);
                }
                GifView view2 = gifViewHolder.getView();
                if (view2 != null) {
                    view2.setShouldAnimateAdPill(!this.adPillAlreadySeen.markSeen(i));
                }
                GifView view3 = gifViewHolder.getView();
                if (!(view3 == null || (adSession = MediaExtensionKt.getAdSession(media)) == null)) {
                    adSession.registerView(view3);
                }
                gifViewHolder.setData(media, ConstantsKt.getPlaceholderColor(i), this.renditionType);
                View view4 = gifViewHolder.itemView;
                if (view4 != null) {
                    view4.setOnClickListener(new GifsPagedListAdapter$onBindViewHolder$$inlined$let$lambda$1(this, viewHolder, i, media));
                }
                View view5 = gifViewHolder.itemView;
                if (view5 != null) {
                    view5.setOnLongClickListener(new GifsPagedListAdapter$onBindViewHolder$$inlined$let$lambda$2(this, viewHolder, i, media));
                }
                GifView view6 = gifViewHolder.getView();
                float f = 0.7f;
                if (view6 != null) {
                    view6.setScaleX(Intrinsics.areEqual((Object) MediaExtensionKt.isEmoji(media), (Object) true) ? 0.7f : 1.0f);
                }
                GifView view7 = gifViewHolder.getView();
                if (view7 != null) {
                    if (!Intrinsics.areEqual((Object) MediaExtensionKt.isEmoji(media), (Object) true)) {
                        f = 1.0f;
                    }
                    view7.setScaleY(f);
                }
            }
        } else if (itemViewType == 2) {
            ((NoContentItemViewHolder) viewHolder).bind();
        }
    }

    public void onViewRecycled(RecyclerView.ViewHolder viewHolder) {
        GPHAdSession adSession;
        Intrinsics.checkParameterIsNotNull(viewHolder, "holder");
        super.onViewRecycled(viewHolder);
        if (!(viewHolder instanceof GifViewHolder)) {
            viewHolder = null;
        }
        GifViewHolder gifViewHolder = (GifViewHolder) viewHolder;
        if (gifViewHolder != null) {
            Media media = gifViewHolder.getView().getMedia();
            if (!(media == null || (adSession = MediaExtensionKt.getAdSession(media)) == null)) {
                adSession.registerView(this.dummyOMView);
            }
            GifView.setMedia$default(gifViewHolder.getView(), (Media) null, (RenditionType) null, (Integer) null, 6, (Object) null);
            gifViewHolder.getView().setOnPingbackGifLoadSuccess((Function0<Unit>) null);
        }
    }

    public int getItemViewType(int i) {
        Timber.m300d("getItemViewType " + i + ' ' + hasExtraRow() + ' ' + this.networkState, new Object[0]);
        if (hasExtraRow() && i == 0 && Intrinsics.areEqual((Object) this.networkState, (Object) NetworkState.Companion.getLOADED_INITIAL()) && this.emptyResults) {
            return 2;
        }
        if (!hasExtraRow() || i != getItemCount() - 1) {
            return i < getItemCount() ? 1 : -1;
        }
        return 0;
    }

    public int getItemCount() {
        return super.getItemCount() + (hasExtraRow() ? 1 : 0);
    }

    private final boolean hasExtraRow() {
        if (Intrinsics.areEqual((Object) this.networkState, (Object) NetworkState.Companion.getLOADED_INITIAL())) {
            return this.emptyResults;
        }
        NetworkState networkState2 = this.networkState;
        return networkState2 != null && (Intrinsics.areEqual((Object) networkState2, (Object) NetworkState.Companion.getLOADED()) ^ true) && (Intrinsics.areEqual((Object) this.networkState, (Object) NetworkState.Companion.getLOADED_INITIAL()) ^ true);
    }

    public final void setNetworkState(NetworkState networkState2, Integer num) {
        boolean hasExtraRow = hasExtraRow();
        NetworkState networkState3 = this.networkState;
        this.networkState = networkState2;
        this.emptyResults = num != null && num.intValue() == 0;
        boolean hasExtraRow2 = hasExtraRow();
        StringBuilder sb = new StringBuilder();
        sb.append("setNetworkState ");
        sb.append(hasExtraRow);
        sb.append(' ');
        sb.append(hasExtraRow2);
        sb.append(' ');
        Status status = null;
        sb.append(networkState3 != null ? networkState3.getStatus() : null);
        sb.append(' ');
        if (networkState2 != null) {
            status = networkState2.getStatus();
        }
        sb.append(status);
        sb.append(' ');
        sb.append(num);
        Timber.m300d(sb.toString(), new Object[0]);
        if (hasExtraRow != hasExtraRow2) {
            if (hasExtraRow) {
                notifyItemRemoved(super.getItemCount());
            } else {
                notifyItemInserted(super.getItemCount());
            }
        } else if (hasExtraRow2 && (!Intrinsics.areEqual((Object) networkState3, (Object) networkState2))) {
            notifyItemChanged(getItemCount() - 1);
        }
        if (Intrinsics.areEqual((Object) networkState2, (Object) NetworkState.Companion.getLOADED_INITIAL())) {
            this.adPillAlreadySeen.clear();
        }
    }

    public Media mediaForIndex(int i) {
        try {
            return (Media) getItem(i);
        } catch (Throwable unused) {
            Timber.m303e("Pingbacks error. Please fix MOB-3131", new Object[0]);
            return null;
        }
    }

    public boolean isMediaLoadedForIndex(int i, Function0<Unit> function0) {
        Intrinsics.checkParameterIsNotNull(function0, "onLoad");
        RecyclerView recyclerView2 = this.recyclerView;
        RecyclerView.ViewHolder findViewHolderForAdapterPosition = recyclerView2 != null ? recyclerView2.findViewHolderForAdapterPosition(i) : null;
        if (!(findViewHolderForAdapterPosition instanceof GifViewHolder)) {
            return false;
        }
        GifViewHolder gifViewHolder = (GifViewHolder) findViewHolderForAdapterPosition;
        if (!gifViewHolder.isGifLoaded()) {
            gifViewHolder.getView().setOnPingbackGifLoadSuccess(new GifsPagedListAdapter$isMediaLoadedForIndex$1(function0));
        }
        return gifViewHolder.isGifLoaded();
    }

    @Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0017\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u000e\u0010\b\u001a\u00020\tXT¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\tXT¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\tXT¢\u0006\u0002\n\u0000¨\u0006\f"}, mo26107d2 = {"Lcom/giphy/sdk/ui/list/GifsPagedListAdapter$Companion;", "", "()V", "POST_COMPARATOR", "Landroidx/recyclerview/widget/DiffUtil$ItemCallback;", "Lcom/giphy/sdk/core/models/Media;", "getPOST_COMPARATOR", "()Landroid/support/v7/util/DiffUtil$ItemCallback;", "VIEW_ITEM", "", "VIEW_LOADING", "VIEW_NO_CONTENT", "ui-sdk_release"}, mo26108k = 1, mo26109mv = {1, 1, 13})
    /* renamed from: com.giphy.sdk.ui.list.GifsPagedListAdapter$Companion */
    /* compiled from: GifsPagedListAdapter.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final DiffUtil.ItemCallback<Media> getPOST_COMPARATOR() {
            return GifsPagedListAdapter.POST_COMPARATOR;
        }
    }
}
