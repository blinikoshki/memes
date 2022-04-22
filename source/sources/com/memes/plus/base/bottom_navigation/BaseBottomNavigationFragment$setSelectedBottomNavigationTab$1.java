package com.memes.plus.base.bottom_navigation;

import kotlin.Metadata;
import kotlin.jvm.internal.MutablePropertyReference0Impl;

@Metadata(mo26105bv = {1, 0, 3}, mo26108k = 3, mo26109mv = {1, 4, 2})
/* compiled from: BaseBottomNavigationFragment.kt */
final /* synthetic */ class BaseBottomNavigationFragment$setSelectedBottomNavigationTab$1 extends MutablePropertyReference0Impl {
    BaseBottomNavigationFragment$setSelectedBottomNavigationTab$1(BaseBottomNavigationFragment baseBottomNavigationFragment) {
        super(baseBottomNavigationFragment, BaseBottomNavigationFragment.class, "bottomNavigationFragmentChangeListener", "getBottomNavigationFragmentChangeListener()Lcom/memes/plus/base/bottom_navigation/BottomNavigationFragmentChangeListener;", 0);
    }

    public Object get() {
        return BaseBottomNavigationFragment.access$getBottomNavigationFragmentChangeListener$p((BaseBottomNavigationFragment) this.receiver);
    }

    public void set(Object obj) {
        ((BaseBottomNavigationFragment) this.receiver).bottomNavigationFragmentChangeListener = (BottomNavigationFragmentChangeListener) obj;
    }
}
