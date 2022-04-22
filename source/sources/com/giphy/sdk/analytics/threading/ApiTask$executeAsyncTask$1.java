package com.giphy.sdk.analytics.threading;

import android.util.Log;
import com.giphy.sdk.analytics.network.api.CompletionHandler;
import java.io.InterruptedIOException;
import java.util.concurrent.ExecutionException;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002H\n¢\u0006\u0002\b\u0003"}, mo26107d2 = {"<anonymous>", "", "V", "run"}, mo26108k = 3, mo26109mv = {1, 1, 13})
/* compiled from: ApiTask.kt */
final class ApiTask$executeAsyncTask$1 implements Runnable {
    final /* synthetic */ CompletionHandler $completionHandler;
    final /* synthetic */ ApiTask this$0;

    ApiTask$executeAsyncTask$1(ApiTask apiTask, CompletionHandler completionHandler) {
        this.this$0 = apiTask;
        this.$completionHandler = completionHandler;
    }

    public final void run() {
        try {
            final Object call = this.this$0.callable.call();
            Thread currentThread = Thread.currentThread();
            Intrinsics.checkExpressionValueIsNotNull(currentThread, "Thread.currentThread()");
            if (!currentThread.isInterrupted()) {
                this.this$0.completionExecutor.execute(new Runnable(this) {
                    final /* synthetic */ ApiTask$executeAsyncTask$1 this$0;

                    {
                        this.this$0 = r1;
                    }

                    public final void run() {
                        CompletionHandler completionHandler = this.this$0.$completionHandler;
                        if (completionHandler != null) {
                            completionHandler.onComplete(call, (Throwable) null);
                        }
                    }
                });
                return;
            }
            throw new InterruptedException();
        } catch (ExecutionException e) {
            Log.e("apiTask", "Unable to perform async task, cancelling…", e);
            this.this$0.completionExecutor.execute(new Runnable(this) {
                final /* synthetic */ ApiTask$executeAsyncTask$1 this$0;

                {
                    this.this$0 = r1;
                }

                public final void run() {
                    CompletionHandler completionHandler = this.this$0.$completionHandler;
                    if (completionHandler != null) {
                        completionHandler.onComplete(null, e);
                    }
                }
            });
        } catch (InterruptedIOException | InterruptedException unused) {
        } catch (Throwable th) {
            this.this$0.completionExecutor.execute(new Runnable(this) {
                final /* synthetic */ ApiTask$executeAsyncTask$1 this$0;

                {
                    this.this$0 = r1;
                }

                public final void run() {
                    CompletionHandler completionHandler = this.this$0.$completionHandler;
                    if (completionHandler != null) {
                        completionHandler.onComplete(null, th);
                    }
                }
            });
        }
    }
}
