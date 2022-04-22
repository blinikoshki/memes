package com.memes.commons.contentlayout;

import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.MutablePropertyReference0Impl;

@Metadata(mo26105bv = {1, 0, 3}, mo26108k = 3, mo26109mv = {1, 4, 2})
/* compiled from: NestedContentLayout.kt */
final /* synthetic */ class NestedContentLayout$showChildren$1 extends MutablePropertyReference0Impl {
    NestedContentLayout$showChildren$1(NestedContentLayout nestedContentLayout) {
        super(nestedContentLayout, NestedContentLayout.class, "children", "getChildren()Ljava/util/List;", 0);
    }

    public Object get() {
        return NestedContentLayout.access$getChildren$p((NestedContentLayout) this.receiver);
    }

    public void set(Object obj) {
        ((NestedContentLayout) this.receiver).children = (List) obj;
    }
}
