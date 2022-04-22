package com.giphy.sdk.analytics.batching;

import com.giphy.sdk.analytics.models.Session;
import kotlin.Metadata;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, mo26107d2 = {"<anonymous>", "", "run"}, mo26108k = 3, mo26109mv = {1, 1, 13})
/* compiled from: PingbackSubmissionQueue.kt */
final class PingbackSubmissionQueue$add$1 implements Runnable {
    final /* synthetic */ Session $session;
    final /* synthetic */ PingbackSubmissionQueue this$0;

    PingbackSubmissionQueue$add$1(PingbackSubmissionQueue pingbackSubmissionQueue, Session session) {
        this.this$0 = pingbackSubmissionQueue;
        this.$session = session;
    }

    public final void run() {
        if (!this.this$0.getSessions().contains(this.$session)) {
            this.this$0.getSessions().addFirst(this.$session);
            this.this$0.trimQueueIfNecessary();
            this.this$0.submitAllSessions();
        }
    }
}
