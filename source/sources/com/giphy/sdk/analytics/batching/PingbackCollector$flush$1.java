package com.giphy.sdk.analytics.batching;

import kotlin.Metadata;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, mo26107d2 = {"<anonymous>", "", "run"}, mo26108k = 3, mo26109mv = {1, 1, 13})
/* compiled from: PingbackCollector.kt */
final class PingbackCollector$flush$1 implements Runnable {
    final /* synthetic */ PingbackCollector this$0;

    PingbackCollector$flush$1(PingbackCollector pingbackCollector) {
        this.this$0 = pingbackCollector;
    }

    public final void run() {
        this.this$0.processPingbacksBatch();
        this.this$0.submitAllSessions();
        this.this$0.submissionQueue.flush();
    }
}
