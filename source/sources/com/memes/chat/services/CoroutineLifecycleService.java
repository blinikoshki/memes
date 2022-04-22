package com.memes.chat.services;

import androidx.lifecycle.LifecycleService;
import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.coroutines.CoroutineContext;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.SupervisorKt;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\b&\u0018\u00002\u00020\u00012\u00020\u0002B\u0005¢\u0006\u0002\u0010\u0003J\b\u0010\n\u001a\u00020\u000bH\u0016R\u0014\u0010\u0004\u001a\u00020\u00058VX\u0004¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007R\u000e\u0010\b\u001a\u00020\tX\u000e¢\u0006\u0002\n\u0000¨\u0006\f"}, mo26107d2 = {"Lcom/memes/chat/services/CoroutineLifecycleService;", "Landroidx/lifecycle/LifecycleService;", "Lkotlinx/coroutines/CoroutineScope;", "()V", "coroutineContext", "Lkotlin/coroutines/CoroutineContext;", "getCoroutineContext", "()Lkotlin/coroutines/CoroutineContext;", "coroutineJob", "Lkotlinx/coroutines/Job;", "onDestroy", "", "chat_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
/* compiled from: CoroutineLifecycleService.kt */
public abstract class CoroutineLifecycleService extends LifecycleService implements CoroutineScope {
    private Job coroutineJob = SupervisorKt.SupervisorJob$default((Job) null, 1, (Object) null);

    public CoroutineContext getCoroutineContext() {
        return Dispatchers.getIO().plus(this.coroutineJob);
    }

    public void onDestroy() {
        Job.DefaultImpls.cancel$default(this.coroutineJob, (CancellationException) null, 1, (Object) null);
        super.onDestroy();
    }
}
