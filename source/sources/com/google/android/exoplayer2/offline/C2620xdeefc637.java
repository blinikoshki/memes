package com.google.android.exoplayer2.offline;

import com.google.android.exoplayer2.offline.DownloadManager;
import java.util.Comparator;

/* renamed from: com.google.android.exoplayer2.offline.-$$Lambda$DownloadManager$InternalHandler$OH12G4NteYquO91-EYFUVBFeiK8 */
/* compiled from: lambda */
public final /* synthetic */ class C2620xdeefc637 implements Comparator {
    public static final /* synthetic */ C2620xdeefc637 INSTANCE = new C2620xdeefc637();

    private /* synthetic */ C2620xdeefc637() {
    }

    public final int compare(Object obj, Object obj2) {
        return DownloadManager.InternalHandler.compareStartTimes((Download) obj, (Download) obj2);
    }
}
