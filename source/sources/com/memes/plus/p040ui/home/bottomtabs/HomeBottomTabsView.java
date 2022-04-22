package com.memes.plus.p040ui.home.bottomtabs;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.LinearLayout;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.memes.plus.databinding.HomeBottomTabsViewBinding;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0004\u0018\u00002\u00020\u00012\u00020\u0002B\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0002\u0010\u0007J\u0010\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001aH\u0002J\b\u0010\u001b\u001a\u00020\u0018H\u0014J\u0018\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u00102\u0006\u0010\u001f\u001a\u00020\u001dH\u0016J\u000e\u0010 \u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001aJ\u000e\u0010!\u001a\u00020\u00182\u0006\u0010\"\u001a\u00020\u0002J\u0016\u0010#\u001a\u00020\u00182\u0006\u0010$\u001a\u00020%2\u0006\u0010&\u001a\u00020\u001dJ\u0018\u0010'\u001a\u00020\u00182\u0006\u0010(\u001a\u00020%2\b\u0010)\u001a\u0004\u0018\u00010*J\u0018\u0010+\u001a\u00020\u00182\u0006\u0010(\u001a\u00020%2\b\b\u0001\u0010,\u001a\u00020%J\u0016\u0010+\u001a\u00020\u00182\u0006\u0010(\u001a\u00020%2\u0006\u0010-\u001a\u00020*R\u001b\u0010\b\u001a\u00020\t8BX\u0002¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\n\u0010\u000bR\u0014\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00100\u000fX\u000e¢\u0006\u0002\n\u0000R\u001b\u0010\u0011\u001a\u00020\u00128BX\u0002¢\u0006\f\n\u0004\b\u0015\u0010\r\u001a\u0004\b\u0013\u0010\u0014R\u0010\u0010\u0016\u001a\u0004\u0018\u00010\u0002X\u000e¢\u0006\u0002\n\u0000¨\u0006."}, mo26107d2 = {"Lcom/memes/plus/ui/home/bottomtabs/HomeBottomTabsView;", "Landroid/widget/LinearLayout;", "Lcom/memes/plus/ui/home/bottomtabs/HomeBottomTabsSelectionListener;", "context", "Landroid/content/Context;", "attributeSet", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "binding", "Lcom/memes/plus/databinding/HomeBottomTabsViewBinding;", "getBinding", "()Lcom/memes/plus/databinding/HomeBottomTabsViewBinding;", "binding$delegate", "Lkotlin/Lazy;", "bottomTabs", "", "Lcom/memes/plus/ui/home/bottomtabs/HomeBottomTab;", "bottomTabsAdapter", "Lcom/memes/plus/ui/home/bottomtabs/HomeBottomTabsAdapter;", "getBottomTabsAdapter", "()Lcom/memes/plus/ui/home/bottomtabs/HomeBottomTabsAdapter;", "bottomTabsAdapter$delegate", "bottomTabsTapListener", "initTabs", "", "factory", "Lcom/memes/plus/ui/home/bottomtabs/HomeBottomTabsFactory;", "onFinishInflate", "onHomeBottomTabTapped", "", "bottomTab", "reselected", "setBottomTabsFactory", "setBottomTabsTapListener", "listener", "setSelectedTabId", "selectedTabId", "", "notifyCallback", "setTabBadgeText", "tabId", "badgeText", "", "setTabIcon", "iconResource", "iconPath", "app_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
/* renamed from: com.memes.plus.ui.home.bottomtabs.HomeBottomTabsView */
/* compiled from: HomeBottomTabsView.kt */
public final class HomeBottomTabsView extends LinearLayout implements HomeBottomTabsSelectionListener {
    private final Lazy binding$delegate;
    private List<HomeBottomTab> bottomTabs = CollectionsKt.emptyList();
    private final Lazy bottomTabsAdapter$delegate;
    private HomeBottomTabsSelectionListener bottomTabsTapListener;

    private final HomeBottomTabsViewBinding getBinding() {
        return (HomeBottomTabsViewBinding) this.binding$delegate.getValue();
    }

    private final HomeBottomTabsAdapter getBottomTabsAdapter() {
        return (HomeBottomTabsAdapter) this.bottomTabsAdapter$delegate.getValue();
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public HomeBottomTabsView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        Intrinsics.checkNotNullParameter(context, "context");
        this.binding$delegate = LazyKt.lazy(new HomeBottomTabsView$binding$2(this, context));
        this.bottomTabsAdapter$delegate = LazyKt.lazy(new HomeBottomTabsView$bottomTabsAdapter$2(this, context));
    }

    /* access modifiers changed from: protected */
    public void onFinishInflate() {
        getBinding();
        super.onFinishInflate();
    }

    public final void setBottomTabsFactory(HomeBottomTabsFactory homeBottomTabsFactory) {
        Intrinsics.checkNotNullParameter(homeBottomTabsFactory, "factory");
        initTabs(homeBottomTabsFactory);
    }

    public final void setBottomTabsTapListener(HomeBottomTabsSelectionListener homeBottomTabsSelectionListener) {
        Intrinsics.checkNotNullParameter(homeBottomTabsSelectionListener, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
        this.bottomTabsTapListener = homeBottomTabsSelectionListener;
    }

    public final void setSelectedTabId(int i, boolean z) {
        getBottomTabsAdapter().setSelectedTabId(i, z);
    }

    public final void setTabIcon(int i, int i2) {
        getBottomTabsAdapter().setTabIcon(i, i2);
    }

    public final void setTabIcon(int i, String str) {
        Intrinsics.checkNotNullParameter(str, "iconPath");
        getBottomTabsAdapter().setTabIcon(i, str);
    }

    public final void setTabBadgeText(int i, String str) {
        getBottomTabsAdapter().setTabBadgeText(i, str);
    }

    private final void initTabs(HomeBottomTabsFactory homeBottomTabsFactory) {
        this.bottomTabs = homeBottomTabsFactory.createTabs();
        GridLayoutManager gridLayoutManager = new GridLayoutManager(getContext(), this.bottomTabs.size());
        RecyclerView recyclerView = getBinding().bottomTabsRecyclerView;
        Intrinsics.checkNotNullExpressionValue(recyclerView, "binding.bottomTabsRecyclerView");
        recyclerView.setLayoutManager(gridLayoutManager);
        RecyclerView recyclerView2 = getBinding().bottomTabsRecyclerView;
        Intrinsics.checkNotNullExpressionValue(recyclerView2, "binding.bottomTabsRecyclerView");
        recyclerView2.setOverScrollMode(2);
        getBottomTabsAdapter().setItems(this.bottomTabs);
        RecyclerView recyclerView3 = getBinding().bottomTabsRecyclerView;
        Intrinsics.checkNotNullExpressionValue(recyclerView3, "binding.bottomTabsRecyclerView");
        recyclerView3.setAdapter(getBottomTabsAdapter());
        HomeBottomTabsAdapter.setSelectedTabId$default(getBottomTabsAdapter(), homeBottomTabsFactory.getDefaultTabId(), false, 2, (Object) null);
    }

    public boolean onHomeBottomTabTapped(HomeBottomTab homeBottomTab, boolean z) {
        Intrinsics.checkNotNullParameter(homeBottomTab, "bottomTab");
        HomeBottomTabsSelectionListener homeBottomTabsSelectionListener = this.bottomTabsTapListener;
        if (homeBottomTabsSelectionListener != null) {
            return homeBottomTabsSelectionListener.onHomeBottomTabTapped(homeBottomTab, z);
        }
        return true;
    }
}
