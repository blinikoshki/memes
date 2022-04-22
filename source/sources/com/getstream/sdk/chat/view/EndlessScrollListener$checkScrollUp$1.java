package com.getstream.sdk.chat.view;

import kotlin.Metadata;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, mo26107d2 = {"<anonymous>", "", "run"}, mo26108k = 3, mo26109mv = {1, 4, 2})
/* compiled from: EndlessScrollListener.kt */
final class EndlessScrollListener$checkScrollUp$1 implements Runnable {
    final /* synthetic */ EndlessScrollListener this$0;

    EndlessScrollListener$checkScrollUp$1(EndlessScrollListener endlessScrollListener) {
        this.this$0 = endlessScrollListener;
    }

    public final void run() {
        if (this.this$0.paginationEnabled) {
            this.this$0.loadMoreListener.invoke();
        }
    }
}
