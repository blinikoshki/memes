package editor.core;

import androidx.recyclerview.widget.RecyclerView;
import kotlin.Metadata;
import kotlin.jvm.internal.MutablePropertyReference0Impl;

@Metadata(mo26105bv = {1, 0, 3}, mo26108k = 3, mo26109mv = {1, 4, 2})
/* compiled from: NicoRecyclerAdapter.kt */
final /* synthetic */ class NicoRecyclerAdapter$scrollToCenterHorizontally$1 extends MutablePropertyReference0Impl {
    NicoRecyclerAdapter$scrollToCenterHorizontally$1(NicoRecyclerAdapter nicoRecyclerAdapter) {
        super(nicoRecyclerAdapter, NicoRecyclerAdapter.class, "recyclerView", "getRecyclerView()Landroidx/recyclerview/widget/RecyclerView;", 0);
    }

    public Object get() {
        return NicoRecyclerAdapter.access$getRecyclerView$p((NicoRecyclerAdapter) this.receiver);
    }

    public void set(Object obj) {
        ((NicoRecyclerAdapter) this.receiver).recyclerView = (RecyclerView) obj;
    }
}
