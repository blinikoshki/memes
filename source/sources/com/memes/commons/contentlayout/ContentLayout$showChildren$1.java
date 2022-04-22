package com.memes.commons.contentlayout;

import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.MutablePropertyReference0Impl;

@Metadata(mo26105bv = {1, 0, 3}, mo26108k = 3, mo26109mv = {1, 4, 2})
/* compiled from: ContentLayout.kt */
final /* synthetic */ class ContentLayout$showChildren$1 extends MutablePropertyReference0Impl {
    ContentLayout$showChildren$1(ContentLayout contentLayout) {
        super(contentLayout, ContentLayout.class, "children", "getChildren()Ljava/util/List;", 0);
    }

    public Object get() {
        return ContentLayout.access$getChildren$p((ContentLayout) this.receiver);
    }

    public void set(Object obj) {
        ((ContentLayout) this.receiver).children = (List) obj;
    }
}
