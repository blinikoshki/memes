package com.giphy.sdk.p013ui.views;

import androidx.lifecycle.Observer;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, mo26107d2 = {"<anonymous>", "", "it", "", "onChanged", "(Ljava/lang/Integer;)V"}, mo26108k = 3, mo26109mv = {1, 1, 13})
/* renamed from: com.giphy.sdk.ui.views.GifsRecyclerView$configureWithLifecycleOwner$3 */
/* compiled from: GifsRecyclerView.kt */
final class GifsRecyclerView$configureWithLifecycleOwner$3<T> implements Observer<Integer> {
    final /* synthetic */ GifsRecyclerView this$0;

    GifsRecyclerView$configureWithLifecycleOwner$3(GifsRecyclerView gifsRecyclerView) {
        this.this$0 = gifsRecyclerView;
    }

    public final void onChanged(Integer num) {
        Function1<Integer, Unit> onResultsUpdateListener = this.this$0.getOnResultsUpdateListener();
        if (num == null) {
            num = 0;
        }
        onResultsUpdateListener.invoke(num);
    }
}
