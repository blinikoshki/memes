package com.google.android.gms.tasks;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-tasks@@17.0.2 */
final class zzaa implements Continuation<Void, Task<List<Task<?>>>> {
    private final /* synthetic */ Collection zza;

    zzaa(Collection collection) {
        this.zza = collection;
    }

    public final /* synthetic */ Object then(Task task) throws Exception {
        ArrayList arrayList = new ArrayList();
        arrayList.addAll(this.zza);
        return Tasks.forResult(arrayList);
    }
}
