package com.memes.plus.p040ui.subscription.promo;

import android.graphics.Rect;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.recyclerview.widget.RecyclerView;
import com.memes.plus.C4199R;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0006\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\f\u0012\b\u0012\u00060\u0002R\u00020\u00000\u0001:\u0001\u0015B\u001d\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u000e\b\u0002\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006¢\u0006\u0002\u0010\bJ\b\u0010\u000b\u001a\u00020\fH\u0016J\u001c\u0010\r\u001a\u00020\u000e2\n\u0010\u000f\u001a\u00060\u0002R\u00020\u00002\u0006\u0010\u0010\u001a\u00020\fH\u0016J\u001c\u0010\u0011\u001a\u00060\u0002R\u00020\u00002\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\fH\u0016R\u000e\u0010\t\u001a\u00020\nX\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0016"}, mo26107d2 = {"Lcom/memes/plus/ui/subscription/promo/PromoItemsAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/memes/plus/ui/subscription/promo/PromoItemsAdapter$PromoViewHolder;", "displayRect", "Landroid/graphics/Rect;", "promoTargets", "", "Lcom/memes/plus/ui/subscription/promo/PromoTarget;", "(Landroid/graphics/Rect;Ljava/util/List;)V", "desiredWidth", "", "getItemCount", "", "onBindViewHolder", "", "holder", "position", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "PromoViewHolder", "app_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
/* renamed from: com.memes.plus.ui.subscription.promo.PromoItemsAdapter */
/* compiled from: PromoItemsAdapter.kt */
public final class PromoItemsAdapter extends RecyclerView.Adapter<PromoViewHolder> {
    private final double desiredWidth;
    private final List<PromoTarget> promoTargets;

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ PromoItemsAdapter(Rect rect, List<PromoTarget> list, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(rect, (i & 2) != 0 ? PromoTarget.Companion.all() : list);
    }

    public PromoItemsAdapter(Rect rect, List<? extends PromoTarget> list) {
        Intrinsics.checkNotNullParameter(rect, "displayRect");
        Intrinsics.checkNotNullParameter(list, "promoTargets");
        this.promoTargets = list;
        this.desiredWidth = ((double) rect.width()) * 0.7d;
    }

    public PromoViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        Intrinsics.checkNotNullParameter(viewGroup, "parent");
        View inflate = LayoutInflater.from(viewGroup.getContext()).inflate(C4199R.C4205layout.promo_item, viewGroup, false);
        Intrinsics.checkNotNullExpressionValue(inflate, "itemView");
        return new PromoViewHolder(this, inflate);
    }

    public int getItemCount() {
        return this.promoTargets.size();
    }

    public void onBindViewHolder(PromoViewHolder promoViewHolder, int i) {
        Intrinsics.checkNotNullParameter(promoViewHolder, "holder");
        promoViewHolder.getImageView().getLayoutParams().width = (int) this.desiredWidth;
        promoViewHolder.getImageView().getLayoutParams().height = (int) (this.desiredWidth * 0.95d);
        promoViewHolder.getImageView().setImageResource(this.promoTargets.get(i).getImageRes());
    }

    @Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\t"}, mo26107d2 = {"Lcom/memes/plus/ui/subscription/promo/PromoItemsAdapter$PromoViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "itemView", "Landroid/view/View;", "(Lcom/memes/plus/ui/subscription/promo/PromoItemsAdapter;Landroid/view/View;)V", "imageView", "Landroid/widget/ImageView;", "getImageView", "()Landroid/widget/ImageView;", "app_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
    /* renamed from: com.memes.plus.ui.subscription.promo.PromoItemsAdapter$PromoViewHolder */
    /* compiled from: PromoItemsAdapter.kt */
    public final class PromoViewHolder extends RecyclerView.ViewHolder {
        private final ImageView imageView;
        final /* synthetic */ PromoItemsAdapter this$0;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public PromoViewHolder(PromoItemsAdapter promoItemsAdapter, View view) {
            super(view);
            Intrinsics.checkNotNullParameter(view, "itemView");
            this.this$0 = promoItemsAdapter;
            View findViewById = view.findViewById(C4199R.C4203id.promo_image_view);
            Intrinsics.checkNotNullExpressionValue(findViewById, "itemView.findViewById(R.id.promo_image_view)");
            this.imageView = (ImageView) findViewById;
        }

        public final ImageView getImageView() {
            return this.imageView;
        }
    }
}
