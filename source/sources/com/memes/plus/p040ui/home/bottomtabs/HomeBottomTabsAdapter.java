package com.memes.plus.p040ui.home.bottomtabs;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.core.content.res.ResourcesCompat;
import com.bumptech.glide.Glide;
import com.bumptech.glide.RequestBuilder;
import com.bumptech.glide.request.BaseRequestOptions;
import com.bumptech.glide.request.RequestOptions;
import com.memes.commons.recycleradapter.AdapterViewHolderPayload;
import com.memes.commons.recycleradapter.BaseRecyclerAdapter;
import com.memes.commons.recycleradapter.BaseViewHolder;
import com.memes.plus.C4199R;
import com.memes.plus.databinding.HomeBottomTabItemBinding;
import java.util.Iterator;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\u0018\u0000 &2\u0012\u0012\u0004\u0012\u00020\u0002\u0012\b\u0012\u00060\u0003R\u00020\u00000\u0001:\u0002%&B\u0015\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ$\u0010\u0013\u001a\u00060\u0003R\u00020\u00002\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u0012H\u0016J\u0006\u0010\u0019\u001a\u00020\u0012J\u0018\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u00122\b\b\u0002\u0010\u001d\u001a\u00020\u001eJ\u0018\u0010\u001f\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u00122\b\u0010 \u001a\u0004\u0018\u00010!J\u0018\u0010\"\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u00122\b\b\u0001\u0010#\u001a\u00020\u0012J\u0016\u0010\"\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u00122\u0006\u0010$\u001a\u00020!R\u000e\u0010\u0006\u001a\u00020\u0007X\u0004¢\u0006\u0002\n\u0000R\u001b\u0010\t\u001a\u00020\n8BX\u0002¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000b\u0010\fR\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u000e¢\u0006\u0002\n\u0000¨\u0006'"}, mo26107d2 = {"Lcom/memes/plus/ui/home/bottomtabs/HomeBottomTabsAdapter;", "Lcom/memes/commons/recycleradapter/BaseRecyclerAdapter;", "Lcom/memes/plus/ui/home/bottomtabs/HomeBottomTab;", "Lcom/memes/plus/ui/home/bottomtabs/HomeBottomTabsAdapter$BottomTabViewHolder;", "context", "Landroid/content/Context;", "bottomTabsSelectionListener", "Lcom/memes/plus/ui/home/bottomtabs/HomeBottomTabsSelectionListener;", "(Landroid/content/Context;Lcom/memes/plus/ui/home/bottomtabs/HomeBottomTabsSelectionListener;)V", "circleCropTransformRequestOptions", "Lcom/bumptech/glide/request/RequestOptions;", "getCircleCropTransformRequestOptions", "()Lcom/bumptech/glide/request/RequestOptions;", "circleCropTransformRequestOptions$delegate", "Lkotlin/Lazy;", "selectionChangedPayload", "Lcom/memes/commons/recycleradapter/AdapterViewHolderPayload;", "selectionItemId", "", "createItemViewHolder", "inflater", "Landroid/view/LayoutInflater;", "parent", "Landroid/view/ViewGroup;", "viewType", "getSelectedTabId", "setSelectedTabId", "", "tabId", "notify", "", "setTabBadgeText", "badgeText", "", "setTabIcon", "iconResource", "iconPath", "BottomTabViewHolder", "Companion", "app_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
/* renamed from: com.memes.plus.ui.home.bottomtabs.HomeBottomTabsAdapter */
/* compiled from: HomeBottomTabsAdapter.kt */
public final class HomeBottomTabsAdapter extends BaseRecyclerAdapter<HomeBottomTab, BottomTabViewHolder> {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private static final String PAYLOAD_SELECTION_CHANGED = "payload_selection_changed";
    /* access modifiers changed from: private */
    public final HomeBottomTabsSelectionListener bottomTabsSelectionListener;
    private final Lazy circleCropTransformRequestOptions$delegate = LazyKt.lazy(HomeBottomTabsAdapter$circleCropTransformRequestOptions$2.INSTANCE);
    /* access modifiers changed from: private */
    public final Context context;
    private final AdapterViewHolderPayload selectionChangedPayload = new AdapterViewHolderPayload(PAYLOAD_SELECTION_CHANGED, (Object) null);
    /* access modifiers changed from: private */
    public int selectionItemId = -1;

    /* access modifiers changed from: private */
    public final RequestOptions getCircleCropTransformRequestOptions() {
        return (RequestOptions) this.circleCropTransformRequestOptions$delegate.getValue();
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public HomeBottomTabsAdapter(Context context2, HomeBottomTabsSelectionListener homeBottomTabsSelectionListener) {
        super(context2);
        Intrinsics.checkNotNullParameter(context2, "context");
        Intrinsics.checkNotNullParameter(homeBottomTabsSelectionListener, "bottomTabsSelectionListener");
        this.context = context2;
        this.bottomTabsSelectionListener = homeBottomTabsSelectionListener;
    }

    @Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, mo26107d2 = {"Lcom/memes/plus/ui/home/bottomtabs/HomeBottomTabsAdapter$Companion;", "", "()V", "PAYLOAD_SELECTION_CHANGED", "", "app_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
    /* renamed from: com.memes.plus.ui.home.bottomtabs.HomeBottomTabsAdapter$Companion */
    /* compiled from: HomeBottomTabsAdapter.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public BottomTabViewHolder createItemViewHolder(LayoutInflater layoutInflater, ViewGroup viewGroup, int i) {
        Intrinsics.checkNotNullParameter(layoutInflater, "inflater");
        Intrinsics.checkNotNullParameter(viewGroup, "parent");
        HomeBottomTabItemBinding inflate = HomeBottomTabItemBinding.inflate(layoutInflater, viewGroup, false);
        Intrinsics.checkNotNullExpressionValue(inflate, "HomeBottomTabItemBinding…(inflater, parent, false)");
        return new BottomTabViewHolder(this, inflate);
    }

    public final int getSelectedTabId() {
        return this.selectionItemId;
    }

    public static /* synthetic */ void setSelectedTabId$default(HomeBottomTabsAdapter homeBottomTabsAdapter, int i, boolean z, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            z = false;
        }
        homeBottomTabsAdapter.setSelectedTabId(i, z);
    }

    public final void setSelectedTabId(int i, boolean z) {
        Object obj;
        boolean z2;
        int i2 = this.selectionItemId;
        this.selectionItemId = i;
        notifyItemChanged(i2, this.selectionChangedPayload);
        notifyItemChanged(i, this.selectionChangedPayload);
        if (z) {
            Iterator it = getItems().iterator();
            while (true) {
                if (!it.hasNext()) {
                    obj = null;
                    break;
                }
                obj = it.next();
                if (((HomeBottomTab) obj).getId() == i) {
                    z2 = true;
                    continue;
                } else {
                    z2 = false;
                    continue;
                }
                if (z2) {
                    break;
                }
            }
            HomeBottomTab homeBottomTab = (HomeBottomTab) obj;
            if (homeBottomTab != null) {
                this.bottomTabsSelectionListener.onHomeBottomTabTapped(homeBottomTab, false);
            }
        }
    }

    public final void setTabIcon(int i, int i2) {
        HomeBottomTab homeBottomTab;
        Iterator it = getItems().iterator();
        int i3 = 0;
        while (true) {
            if (!it.hasNext()) {
                i3 = -1;
                break;
            }
            if (((HomeBottomTab) it.next()).getId() == i) {
                break;
            }
            i3++;
        }
        if (i3 != -1 && (homeBottomTab = (HomeBottomTab) getItemAt(i3)) != null) {
            homeBottomTab.setIconResource(i2);
            notifyItemChanged(i3);
        }
    }

    public final void setTabIcon(int i, String str) {
        HomeBottomTab homeBottomTab;
        Intrinsics.checkNotNullParameter(str, "iconPath");
        Iterator it = getItems().iterator();
        int i2 = 0;
        while (true) {
            if (!it.hasNext()) {
                i2 = -1;
                break;
            }
            if (((HomeBottomTab) it.next()).getId() == i) {
                break;
            }
            i2++;
        }
        if (i2 != -1 && (homeBottomTab = (HomeBottomTab) getItemAt(i2)) != null) {
            homeBottomTab.setIconPath(str);
            notifyItemChanged(i2);
        }
    }

    public final void setTabBadgeText(int i, String str) {
        HomeBottomTab homeBottomTab;
        Iterator it = getItems().iterator();
        int i2 = 0;
        while (true) {
            if (!it.hasNext()) {
                i2 = -1;
                break;
            }
            if (((HomeBottomTab) it.next()).getId() == i) {
                break;
            }
            i2++;
        }
        if (i2 != -1 && (homeBottomTab = (HomeBottomTab) getItemAt(i2)) != null) {
            homeBottomTab.setBadgeText(str);
            notifyItemChanged(i2);
        }
    }

    @Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0010!\n\u0002\u0010\u0000\n\u0000\b\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\b\u0010\u0007\u001a\u00020\bH\u0002J\b\u0010\t\u001a\u00020\bH\u0002J\b\u0010\n\u001a\u00020\bH\u0002J\b\u0010\u000b\u001a\u00020\bH\u0002J\u0010\u0010\f\u001a\u00020\b2\u0006\u0010\r\u001a\u00020\u0002H\u0016J\u0016\u0010\u000e\u001a\u00020\b2\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00110\u0010H\u0016R\u000e\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0002X.¢\u0006\u0002\n\u0000¨\u0006\u0012"}, mo26107d2 = {"Lcom/memes/plus/ui/home/bottomtabs/HomeBottomTabsAdapter$BottomTabViewHolder;", "Lcom/memes/commons/recycleradapter/BaseViewHolder;", "Lcom/memes/plus/ui/home/bottomtabs/HomeBottomTab;", "binding", "Lcom/memes/plus/databinding/HomeBottomTabItemBinding;", "(Lcom/memes/plus/ui/home/bottomtabs/HomeBottomTabsAdapter;Lcom/memes/plus/databinding/HomeBottomTabItemBinding;)V", "bottomTab", "handleTabSelection", "", "loadBadgeText", "loadIcon", "refreshSelection", "setItem", "item", "updateWithPayload", "payloads", "", "", "app_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
    /* renamed from: com.memes.plus.ui.home.bottomtabs.HomeBottomTabsAdapter$BottomTabViewHolder */
    /* compiled from: HomeBottomTabsAdapter.kt */
    public final class BottomTabViewHolder extends BaseViewHolder<HomeBottomTab> {
        private final HomeBottomTabItemBinding binding;
        private HomeBottomTab bottomTab;
        final /* synthetic */ HomeBottomTabsAdapter this$0;

        /* JADX WARNING: Illegal instructions before constructor call */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public BottomTabViewHolder(com.memes.plus.p040ui.home.bottomtabs.HomeBottomTabsAdapter r2, com.memes.plus.databinding.HomeBottomTabItemBinding r3) {
            /*
                r1 = this;
                java.lang.String r0 = "binding"
                kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r3, r0)
                r1.this$0 = r2
                androidx.constraintlayout.widget.ConstraintLayout r2 = r3.getRoot()
                java.lang.String r0 = "binding.root"
                kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r2, r0)
                android.view.View r2 = (android.view.View) r2
                r1.<init>(r2)
                r1.binding = r3
                androidx.constraintlayout.widget.ConstraintLayout r2 = r3.getRoot()
                com.memes.plus.ui.home.bottomtabs.HomeBottomTabsAdapter$BottomTabViewHolder$1 r3 = new com.memes.plus.ui.home.bottomtabs.HomeBottomTabsAdapter$BottomTabViewHolder$1
                r3.<init>(r1)
                android.view.View$OnClickListener r3 = (android.view.View.OnClickListener) r3
                r2.setOnClickListener(r3)
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.memes.plus.p040ui.home.bottomtabs.HomeBottomTabsAdapter.BottomTabViewHolder.<init>(com.memes.plus.ui.home.bottomtabs.HomeBottomTabsAdapter, com.memes.plus.databinding.HomeBottomTabItemBinding):void");
        }

        public void setItem(HomeBottomTab homeBottomTab) {
            Intrinsics.checkNotNullParameter(homeBottomTab, "item");
            this.bottomTab = homeBottomTab;
            loadIcon();
            loadBadgeText();
            refreshSelection();
        }

        /* access modifiers changed from: private */
        public final void handleTabSelection() {
            HomeBottomTab homeBottomTab = this.bottomTab;
            if (homeBottomTab == null) {
                Intrinsics.throwUninitializedPropertyAccessException("bottomTab");
            }
            if (homeBottomTab.getId() != this.this$0.selectionItemId) {
                HomeBottomTabsSelectionListener access$getBottomTabsSelectionListener$p = this.this$0.bottomTabsSelectionListener;
                HomeBottomTab homeBottomTab2 = this.bottomTab;
                if (homeBottomTab2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("bottomTab");
                }
                if (access$getBottomTabsSelectionListener$p.onHomeBottomTabTapped(homeBottomTab2, false)) {
                    HomeBottomTabsAdapter homeBottomTabsAdapter = this.this$0;
                    HomeBottomTab homeBottomTab3 = this.bottomTab;
                    if (homeBottomTab3 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("bottomTab");
                    }
                    HomeBottomTabsAdapter.setSelectedTabId$default(homeBottomTabsAdapter, homeBottomTab3.getId(), false, 2, (Object) null);
                    return;
                }
                return;
            }
            HomeBottomTabsSelectionListener access$getBottomTabsSelectionListener$p2 = this.this$0.bottomTabsSelectionListener;
            HomeBottomTab homeBottomTab4 = this.bottomTab;
            if (homeBottomTab4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("bottomTab");
            }
            access$getBottomTabsSelectionListener$p2.onHomeBottomTabTapped(homeBottomTab4, true);
        }

        private final void loadIcon() {
            RequestBuilder<Drawable> requestBuilder = null;
            HomeBottomTab homeBottomTab = this.bottomTab;
            if (homeBottomTab == null) {
                Intrinsics.throwUninitializedPropertyAccessException("bottomTab");
            }
            Integer iconResource = homeBottomTab.getIconResource();
            if (iconResource != null) {
                requestBuilder = Glide.with(this.this$0.context).load(iconResource);
            }
            HomeBottomTab homeBottomTab2 = this.bottomTab;
            if (homeBottomTab2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("bottomTab");
            }
            String iconPath = homeBottomTab2.getIconPath();
            if (iconPath != null) {
                requestBuilder = (RequestBuilder) ((RequestBuilder) Glide.with(this.this$0.context).asBitmap().load(iconPath).placeholder((int) C4199R.C4202drawable.placeholder_profile)).error((int) C4199R.C4202drawable.placeholder_profile);
            }
            if (requestBuilder == null) {
                this.binding.iconImageView.setImageResource(0);
                return;
            }
            HomeBottomTab homeBottomTab3 = this.bottomTab;
            if (homeBottomTab3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("bottomTab");
            }
            if (homeBottomTab3.getIconRoundingAllowed()) {
                requestBuilder = requestBuilder.apply((BaseRequestOptions<?>) this.this$0.getCircleCropTransformRequestOptions());
            }
            requestBuilder.into((ImageView) this.binding.iconImageView);
        }

        private final void loadBadgeText() {
            HomeBottomTab homeBottomTab = this.bottomTab;
            if (homeBottomTab == null) {
                Intrinsics.throwUninitializedPropertyAccessException("bottomTab");
            }
            String badgeText = homeBottomTab.getBadgeText();
            CharSequence charSequence = badgeText;
            int i = 0;
            if (charSequence == null || StringsKt.isBlank(charSequence)) {
                TextView textView = this.binding.badgeTextView;
                Intrinsics.checkNotNullExpressionValue(textView, "binding.badgeTextView");
                textView.setVisibility(8);
                return;
            }
            Integer intOrNull = StringsKt.toIntOrNull(badgeText);
            if (intOrNull != null) {
                TextView textView2 = this.binding.badgeTextView;
                Intrinsics.checkNotNullExpressionValue(textView2, "binding.badgeTextView");
                textView2.setText("");
                TextView textView3 = this.binding.badgeTextView;
                Intrinsics.checkNotNullExpressionValue(textView3, "binding.badgeTextView");
                if (intOrNull.intValue() <= 0) {
                    i = 8;
                }
                textView3.setVisibility(i);
                return;
            }
            TextView textView4 = this.binding.badgeTextView;
            Intrinsics.checkNotNullExpressionValue(textView4, "binding.badgeTextView");
            textView4.setText("");
            TextView textView5 = this.binding.badgeTextView;
            Intrinsics.checkNotNullExpressionValue(textView5, "binding.badgeTextView");
            textView5.setVisibility(0);
        }

        private final void refreshSelection() {
            HomeBottomTab homeBottomTab = this.bottomTab;
            if (homeBottomTab == null) {
                Intrinsics.throwUninitializedPropertyAccessException("bottomTab");
            }
            if (!homeBottomTab.getTintAllowed()) {
                AppCompatImageView appCompatImageView = this.binding.iconImageView;
                Intrinsics.checkNotNullExpressionValue(appCompatImageView, "binding.iconImageView");
                appCompatImageView.setImageTintList((ColorStateList) null);
                return;
            }
            AppCompatImageView appCompatImageView2 = this.binding.iconImageView;
            Intrinsics.checkNotNullExpressionValue(appCompatImageView2, "binding.iconImageView");
            if (appCompatImageView2.getImageTintList() == null) {
                AppCompatImageView appCompatImageView3 = this.binding.iconImageView;
                Intrinsics.checkNotNullExpressionValue(appCompatImageView3, "binding.iconImageView");
                appCompatImageView3.setImageTintList(ResourcesCompat.getColorStateList(this.this$0.context.getResources(), C4199R.C4201color.home_bottom_tab_state, this.this$0.context.getTheme()));
            }
            HomeBottomTab homeBottomTab2 = this.bottomTab;
            if (homeBottomTab2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("bottomTab");
            }
            boolean z = homeBottomTab2.getId() == this.this$0.selectionItemId;
            AppCompatImageView appCompatImageView4 = this.binding.iconImageView;
            Intrinsics.checkNotNullExpressionValue(appCompatImageView4, "binding.iconImageView");
            appCompatImageView4.setSelected(z);
        }

        public void updateWithPayload(List<Object> list) {
            Intrinsics.checkNotNullParameter(list, "payloads");
            if (!list.isEmpty()) {
                for (Object next : list) {
                    if ((next instanceof AdapterViewHolderPayload) && Intrinsics.areEqual((Object) ((AdapterViewHolderPayload) next).getKey(), (Object) HomeBottomTabsAdapter.PAYLOAD_SELECTION_CHANGED)) {
                        refreshSelection();
                    }
                }
            }
        }
    }
}
