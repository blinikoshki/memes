package com.memes.plus.custom.changeable_tab_visibility;

import com.google.firebase.analytics.FirebaseAnalytics;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010!\n\u0000\n\u0002\u0010\b\n\u0002\u0010#\n\u0002\b\u0003\u0018\u00002\u00020\u0001:\u0001\u0014B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u000e\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u0007J\u0014\u0010\r\u001a\u00020\u000b2\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00070\u000fJ\u0010\u0010\u0010\u001a\u00020\u00112\u0006\u0010\f\u001a\u00020\u0007H\u0002J\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00070\u0012J\u000e\u0010\u0013\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u0007R*\u0010\u0005\u001a\u001e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u0006j\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b`\tX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0015"}, mo26107d2 = {"Lcom/memes/plus/custom/changeable_tab_visibility/TabReplicaOrderBackup;", "", "callback", "Lcom/memes/plus/custom/changeable_tab_visibility/TabReplicaOrderBackup$Callback;", "(Lcom/memes/plus/custom/changeable_tab_visibility/TabReplicaOrderBackup$Callback;)V", "backupMap", "Ljava/util/LinkedHashMap;", "Lcom/memes/plus/custom/changeable_tab_visibility/TabReplica;", "", "Lkotlin/collections/LinkedHashMap;", "addItem", "", "item", "createBackupOf", "items", "", "findItemPosition", "", "", "removeItem", "Callback", "app_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
/* compiled from: TabReplicaOrderBackup.kt */
public final class TabReplicaOrderBackup {
    private final LinkedHashMap<TabReplica, Boolean> backupMap = new LinkedHashMap<>();
    private final Callback callback;

    @Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H&J\u0018\u0010\b\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H&¨\u0006\t"}, mo26107d2 = {"Lcom/memes/plus/custom/changeable_tab_visibility/TabReplicaOrderBackup$Callback;", "", "onAddTabRequested", "", "index", "", "tabReplica", "Lcom/memes/plus/custom/changeable_tab_visibility/TabReplica;", "onRemoveTabRequested", "app_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
    /* compiled from: TabReplicaOrderBackup.kt */
    public interface Callback {
        void onAddTabRequested(int i, TabReplica tabReplica);

        void onRemoveTabRequested(int i, TabReplica tabReplica);
    }

    public TabReplicaOrderBackup(Callback callback2) {
        Intrinsics.checkNotNullParameter(callback2, "callback");
        this.callback = callback2;
    }

    public final void createBackupOf(List<TabReplica> list) {
        Intrinsics.checkNotNullParameter(list, FirebaseAnalytics.Param.ITEMS);
        this.backupMap.clear();
        for (TabReplica put : list) {
            this.backupMap.put(put, true);
        }
    }

    public final Set<TabReplica> items() {
        Set<TabReplica> keySet = this.backupMap.keySet();
        Intrinsics.checkNotNullExpressionValue(keySet, "backupMap.keys");
        return keySet;
    }

    public final void removeItem(TabReplica tabReplica) {
        Intrinsics.checkNotNullParameter(tabReplica, "item");
        System.out.println("Removing: " + tabReplica);
        this.backupMap.containsKey(tabReplica);
        if (!Intrinsics.areEqual((Object) this.backupMap.get(tabReplica), (Object) false)) {
            this.callback.onRemoveTabRequested(findItemPosition(tabReplica), tabReplica);
            this.backupMap.put(tabReplica, false);
        }
    }

    public final void addItem(TabReplica tabReplica) {
        Intrinsics.checkNotNullParameter(tabReplica, "item");
        System.out.println("Adding: " + tabReplica);
        this.backupMap.containsKey(tabReplica);
        if (!Intrinsics.areEqual((Object) this.backupMap.get(tabReplica), (Object) true)) {
            this.backupMap.put(tabReplica, true);
            this.callback.onAddTabRequested(findItemPosition(tabReplica), tabReplica);
        }
    }

    private final int findItemPosition(TabReplica tabReplica) {
        int i = 0;
        for (Map.Entry entry : this.backupMap.entrySet()) {
            if (((Boolean) entry.getValue()).booleanValue()) {
                if (Intrinsics.areEqual((Object) (TabReplica) entry.getKey(), (Object) tabReplica)) {
                    break;
                }
                i++;
            }
        }
        return i;
    }
}
