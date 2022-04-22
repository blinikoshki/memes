package editor.mediaselection.items;

import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.bumptech.glide.RequestManager;
import editor.mediaselection.BaseMediaCategoryAdapter;
import editor.mediaselection.items.MediaSelectionItem;
import editor.optionsui.layerpaint.LayerPaint;
import editor.util.DrawableUtil;
import editor.util.ExtKt;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0002 !B\u0019\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0002\u0010\u0007J\u0010\u0010\u0013\u001a\u00020\u00102\u0006\u0010\u0014\u001a\u00020\u0002H\u0016J\u0018\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\tH\u0016J\u0018\u0010\u001a\u001a\u00020\u00182\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\tH\u0016J\u000e\u0010\u001e\u001a\u00020\u00162\u0006\u0010\u001f\u001a\u00020\u0010R\u000e\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000R\u001b\u0010\b\u001a\u00020\t8BX\u0002¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\n\u0010\u000bR\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0004¢\u0006\u0002\n\u0000R.\u0010\u000e\u001a\"\u0012\u0004\u0012\u00020\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u00110\u000fj\u0010\u0012\u0004\u0012\u00020\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u0011`\u0012X\u0004¢\u0006\u0002\n\u0000¨\u0006\""}, mo26107d2 = {"Leditor/mediaselection/items/MediaSelectionItemsAdapter;", "Leditor/mediaselection/BaseMediaCategoryAdapter;", "Leditor/mediaselection/items/MediaSelectionItem;", "context", "Landroid/content/Context;", "onSelectedItemTappedListener", "Leditor/mediaselection/items/MediaSelectionItemsAdapter$OnSelectedItemTappedListener;", "(Landroid/content/Context;Leditor/mediaselection/items/MediaSelectionItemsAdapter$OnSelectedItemTappedListener;)V", "itemHorizontalMargin", "", "getItemHorizontalMargin", "()I", "itemHorizontalMargin$delegate", "Lkotlin/Lazy;", "paintDrawablesMap", "Ljava/util/HashMap;", "", "Landroid/graphics/drawable/Drawable;", "Lkotlin/collections/HashMap;", "getItemId", "item", "onBindViewHolder", "", "holder", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "position", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "removeItemsById", "itemId", "MediaItemViewHolder", "OnSelectedItemTappedListener", "editor_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
/* compiled from: MediaSelectionItemsAdapter.kt */
public final class MediaSelectionItemsAdapter extends BaseMediaCategoryAdapter<MediaSelectionItem> {
    /* access modifiers changed from: private */
    public final Context context;
    private final Lazy itemHorizontalMargin$delegate;
    /* access modifiers changed from: private */
    public final OnSelectedItemTappedListener onSelectedItemTappedListener;
    /* access modifiers changed from: private */
    public final HashMap<String, Drawable> paintDrawablesMap;

    @Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bæ\u0001\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&¨\u0006\u0006"}, mo26107d2 = {"Leditor/mediaselection/items/MediaSelectionItemsAdapter$OnSelectedItemTappedListener;", "", "onSelectedItemTapped", "", "item", "Leditor/mediaselection/items/MediaSelectionItem;", "editor_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
    /* compiled from: MediaSelectionItemsAdapter.kt */
    public interface OnSelectedItemTappedListener {
        void onSelectedItemTapped(MediaSelectionItem mediaSelectionItem);
    }

    private final int getItemHorizontalMargin() {
        return ((Number) this.itemHorizontalMargin$delegate.getValue()).intValue();
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ MediaSelectionItemsAdapter(Context context2, OnSelectedItemTappedListener onSelectedItemTappedListener2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(context2, (i & 2) != 0 ? null : onSelectedItemTappedListener2);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public MediaSelectionItemsAdapter(Context context2, OnSelectedItemTappedListener onSelectedItemTappedListener2) {
        super(context2, (Function2) null, 2, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(context2, "context");
        this.context = context2;
        this.onSelectedItemTappedListener = onSelectedItemTappedListener2;
        this.paintDrawablesMap = new HashMap<>();
        this.itemHorizontalMargin$delegate = LazyKt.lazy(new MediaSelectionItemsAdapter$itemHorizontalMargin$2(this));
    }

    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        Intrinsics.checkNotNullParameter(viewGroup, "parent");
        MediaSelectionItemView mediaSelectionItemView = new MediaSelectionItemView(this.context, (AttributeSet) null);
        mediaSelectionItemView.setResizeMode(2);
        ExtKt.enableChangingTransitionType(mediaSelectionItemView);
        ViewGroup.MarginLayoutParams marginLayoutParams = new ViewGroup.MarginLayoutParams(-2, -1);
        marginLayoutParams.setMarginStart(getItemHorizontalMargin());
        marginLayoutParams.setMarginEnd(getItemHorizontalMargin());
        mediaSelectionItemView.setLayoutParams(marginLayoutParams);
        return new MediaItemViewHolder(this, mediaSelectionItemView);
    }

    public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int i) {
        Intrinsics.checkNotNullParameter(viewHolder, "holder");
        if (viewHolder instanceof MediaItemViewHolder) {
            ((MediaItemViewHolder) viewHolder).setItem((MediaSelectionItem) getItemAt(i));
        }
    }

    public String getItemId(MediaSelectionItem mediaSelectionItem) {
        Intrinsics.checkNotNullParameter(mediaSelectionItem, "item");
        return mediaSelectionItem.getIdentifier();
    }

    public final void removeItemsById(String str) {
        Intrinsics.checkNotNullParameter(str, "itemId");
        Collection arrayList = new ArrayList();
        for (Object next : getItems()) {
            if (Intrinsics.areEqual((Object) str, (Object) getItemId((MediaSelectionItem) next))) {
                arrayList.add(next);
            }
        }
        for (MediaSelectionItem removeItem : (List) arrayList) {
            removeItem(removeItem);
        }
    }

    @Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\b\u0004\u0018\u00002\f0\u0001R\b\u0012\u0004\u0012\u00020\u00030\u0002B\r\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0010\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0016J\b\u0010\f\u001a\u00020\u0003H\u0016J\u0010\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010H\u0002J\u0010\u0010\u0011\u001a\u00020\t2\u0006\u0010\u0012\u001a\u00020\u0013H\u0016J\u0010\u0010\u0014\u001a\u00020\t2\u0006\u0010\u0007\u001a\u00020\u0003H\u0016R\u000e\u0010\u0007\u001a\u00020\u0003X.¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0015"}, mo26107d2 = {"Leditor/mediaselection/items/MediaSelectionItemsAdapter$MediaItemViewHolder;", "Leditor/mediaselection/BaseMediaCategoryAdapter$BaseMediaCategoryItemViewHolder;", "Leditor/mediaselection/BaseMediaCategoryAdapter;", "Leditor/mediaselection/items/MediaSelectionItem;", "selectionItemView", "Leditor/mediaselection/items/MediaSelectionItemView;", "(Leditor/mediaselection/items/MediaSelectionItemsAdapter;Leditor/mediaselection/items/MediaSelectionItemView;)V", "item", "cleanup", "", "glideRequestManager", "Lcom/bumptech/glide/RequestManager;", "getItem", "getOrCreatePaintDrawable", "Landroid/graphics/drawable/Drawable;", "layerPaint", "Leditor/optionsui/layerpaint/LayerPaint;", "onSelectionIndicatorVisibilityChanged", "isVisible", "", "setItem", "editor_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
    /* compiled from: MediaSelectionItemsAdapter.kt */
    private final class MediaItemViewHolder extends BaseMediaCategoryAdapter<MediaSelectionItem>.BaseMediaCategoryItemViewHolder {
        /* access modifiers changed from: private */
        public MediaSelectionItem item;
        private final MediaSelectionItemView selectionItemView;
        final /* synthetic */ MediaSelectionItemsAdapter this$0;

        public void onSelectionIndicatorVisibilityChanged(boolean z) {
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public MediaItemViewHolder(MediaSelectionItemsAdapter mediaSelectionItemsAdapter, MediaSelectionItemView mediaSelectionItemView) {
            super(mediaSelectionItemsAdapter, mediaSelectionItemView);
            Intrinsics.checkNotNullParameter(mediaSelectionItemView, "selectionItemView");
            this.this$0 = mediaSelectionItemsAdapter;
            this.selectionItemView = mediaSelectionItemView;
            mediaSelectionItemView.setOnClickListener(new View.OnClickListener(this) {
                final /* synthetic */ MediaItemViewHolder this$0;

                {
                    this.this$0 = r1;
                }

                public final void onClick(View view) {
                    OnSelectedItemTappedListener access$getOnSelectedItemTappedListener$p = this.this$0.this$0.onSelectedItemTappedListener;
                    if (access$getOnSelectedItemTappedListener$p != null) {
                        access$getOnSelectedItemTappedListener$p.onSelectedItemTapped(MediaItemViewHolder.access$getItem$p(this.this$0));
                    }
                }
            });
        }

        public static final /* synthetic */ MediaSelectionItem access$getItem$p(MediaItemViewHolder mediaItemViewHolder) {
            MediaSelectionItem mediaSelectionItem = mediaItemViewHolder.item;
            if (mediaSelectionItem == null) {
                Intrinsics.throwUninitializedPropertyAccessException("item");
            }
            return mediaSelectionItem;
        }

        public MediaSelectionItem getItem() {
            MediaSelectionItem mediaSelectionItem = this.item;
            if (mediaSelectionItem == null) {
                Intrinsics.throwUninitializedPropertyAccessException("item");
            }
            return mediaSelectionItem;
        }

        public void setItem(MediaSelectionItem mediaSelectionItem) {
            Intrinsics.checkNotNullParameter(mediaSelectionItem, "item");
            this.item = mediaSelectionItem;
            if (mediaSelectionItem instanceof MediaSelectionItem.Paint) {
                this.selectionItemView.setAspectRatio(1.0f);
                this.selectionItemView.loadDrawable(getOrCreatePaintDrawable(((MediaSelectionItem.Paint) mediaSelectionItem).getPaint()));
            } else {
                this.selectionItemView.load(mediaSelectionItem, this.this$0.getGlideRequestManager());
            }
            super.setItem(mediaSelectionItem);
        }

        public void cleanup(RequestManager requestManager) {
            Intrinsics.checkNotNullParameter(requestManager, "glideRequestManager");
            this.selectionItemView.cleanup(requestManager);
        }

        private final Drawable getOrCreatePaintDrawable(LayerPaint layerPaint) {
            Drawable drawable;
            Drawable drawable2;
            String id = layerPaint.getId();
            if (this.this$0.paintDrawablesMap.containsKey(id) && (drawable2 = (Drawable) this.this$0.paintDrawablesMap.get(id)) != null) {
                return drawable2;
            }
            if (layerPaint instanceof LayerPaint.Color) {
                drawable = new ColorDrawable(((LayerPaint.Color) layerPaint).colorInt());
            } else if (layerPaint instanceof LayerPaint.Gradient) {
                drawable = DrawableUtil.INSTANCE.createDrawable((LayerPaint.Gradient) layerPaint);
            } else if (layerPaint instanceof LayerPaint.Pattern) {
                drawable = DrawableUtil.INSTANCE.createDrawable(this.this$0.context, (LayerPaint.Pattern) layerPaint);
            } else {
                throw new NoWhenBranchMatchedException();
            }
            this.this$0.paintDrawablesMap.put(id, drawable);
            return drawable;
        }
    }
}
