package com.memes.plus.custom.changeable_tab_visibility;

import android.content.Context;
import android.util.AttributeSet;
import com.google.android.material.tabs.TabLayout;
import com.memes.plus.custom.changeable_tab_visibility.TabReplicaOrderBackup;
import java.util.ArrayList;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0006\u0018\u00002\u00020\u00012\u00020\u0002B\u0015\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\b\u0010\u0010\u001a\u00020\u0011H\u0002J\u0012\u0010\u0012\u001a\u0004\u0018\u00010\u00132\u0006\u0010\u0014\u001a\u00020\u0015H\u0002J\u000e\u0010\u0016\u001a\u00020\u00112\u0006\u0010\u0014\u001a\u00020\u0015J\u0018\u0010\u0017\u001a\u00020\u00112\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u0013H\u0016J\b\u0010\u001b\u001a\u00020\u0011H\u0014J\u0018\u0010\u001c\u001a\u00020\u00112\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u0013H\u0016J\u0006\u0010\u001d\u001a\u00020\tJ\u000e\u0010\u001e\u001a\u00020\u00112\u0006\u0010\u0014\u001a\u00020\u0015R\u000e\u0010\b\u001a\u00020\tX\u000e¢\u0006\u0002\n\u0000R\u001b\u0010\n\u001a\u00020\u000b8BX\u0002¢\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\f\u0010\r¨\u0006\u001f"}, mo26107d2 = {"Lcom/memes/plus/custom/changeable_tab_visibility/ChangeableTabVisibilityTabLayout;", "Lcom/google/android/material/tabs/TabLayout;", "Lcom/memes/plus/custom/changeable_tab_visibility/TabReplicaOrderBackup$Callback;", "context", "Landroid/content/Context;", "attributeSet", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "ignoreSelectionChange", "", "itemOrderBackup", "Lcom/memes/plus/custom/changeable_tab_visibility/TabReplicaOrderBackup;", "getItemOrderBackup", "()Lcom/memes/plus/custom/changeable_tab_visibility/TabReplicaOrderBackup;", "itemOrderBackup$delegate", "Lkotlin/Lazy;", "createBackupTabs", "", "findTabReplica", "Lcom/memes/plus/custom/changeable_tab_visibility/TabReplica;", "identifier", "", "hideTab", "onAddTabRequested", "index", "", "tabReplica", "onFinishInflate", "onRemoveTabRequested", "shouldIgnoreSelection", "showTab", "app_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
/* compiled from: ChangeableTabVisibilityTabLayout.kt */
public final class ChangeableTabVisibilityTabLayout extends TabLayout implements TabReplicaOrderBackup.Callback {
    private boolean ignoreSelectionChange;
    private final Lazy itemOrderBackup$delegate = LazyKt.lazy(new ChangeableTabVisibilityTabLayout$itemOrderBackup$2(this));

    private final TabReplicaOrderBackup getItemOrderBackup() {
        return (TabReplicaOrderBackup) this.itemOrderBackup$delegate.getValue();
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ChangeableTabVisibilityTabLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(attributeSet, "attributeSet");
    }

    /* access modifiers changed from: protected */
    public void onFinishInflate() {
        super.onFinishInflate();
        createBackupTabs();
    }

    private final void createBackupTabs() {
        List arrayList = new ArrayList();
        int tabCount = getTabCount();
        for (int i = 0; i < tabCount; i++) {
            TabLayout.Tab tabAt = getTabAt(i);
            if (tabAt != null) {
                Intrinsics.checkNotNullExpressionValue(tabAt, "getTabAt(tabIndex) ?: continue");
                CharSequence contentDescription = tabAt.getContentDescription();
                if (contentDescription != null) {
                    boolean isBlank = StringsKt.isBlank(contentDescription);
                }
                arrayList.add(new TabReplica(tabAt.getText(), tabAt.getIcon(), tabAt.getContentDescription()));
            }
        }
        getItemOrderBackup().createBackupOf(arrayList);
    }

    public final void showTab(String str) {
        Intrinsics.checkNotNullParameter(str, "identifier");
        TabReplica findTabReplica = findTabReplica(str);
        if (findTabReplica != null) {
            getItemOrderBackup().addItem(findTabReplica);
        }
    }

    public final void hideTab(String str) {
        Intrinsics.checkNotNullParameter(str, "identifier");
        TabReplica findTabReplica = findTabReplica(str);
        if (findTabReplica != null) {
            getItemOrderBackup().removeItem(findTabReplica);
        }
    }

    public final boolean shouldIgnoreSelection() {
        return this.ignoreSelectionChange;
    }

    private final TabReplica findTabReplica(String str) {
        for (TabReplica next : getItemOrderBackup().items()) {
            if (Intrinsics.areEqual((Object) next.getIdentifier(), (Object) str)) {
                return next;
            }
        }
        return null;
    }

    public void onAddTabRequested(int i, TabReplica tabReplica) {
        Intrinsics.checkNotNullParameter(tabReplica, "tabReplica");
        TabLayout.Tab contentDescription = newTab().setIcon(tabReplica.getIcon()).setText(tabReplica.getTitle()).setContentDescription(tabReplica.getIdentifier());
        Intrinsics.checkNotNullExpressionValue(contentDescription, "newTab()\n\t\t\t.setIcon(tab…on(tabReplica.identifier)");
        addTab(contentDescription, i);
    }

    public void onRemoveTabRequested(int i, TabReplica tabReplica) {
        Intrinsics.checkNotNullParameter(tabReplica, "tabReplica");
        int tabCount = getTabCount();
        for (int i2 = 0; i2 < tabCount; i2++) {
            TabLayout.Tab tabAt = getTabAt(i2);
            if (tabAt != null) {
                Intrinsics.checkNotNullExpressionValue(tabAt, "getTabAt(tabIndex) ?: continue");
                if (Intrinsics.areEqual((Object) tabAt.getContentDescription(), (Object) tabReplica.getIdentifier())) {
                    this.ignoreSelectionChange = true;
                    removeTab(tabAt);
                    Unit unit = Unit.INSTANCE;
                    this.ignoreSelectionChange = false;
                }
            }
        }
    }
}
