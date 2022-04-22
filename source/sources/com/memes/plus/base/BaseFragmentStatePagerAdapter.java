package com.memes.plus.base;

import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b&\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004¨\u0006\u0005"}, mo26107d2 = {"Lcom/memes/plus/base/BaseFragmentStatePagerAdapter;", "Landroidx/fragment/app/FragmentStatePagerAdapter;", "fragmentManager", "Landroidx/fragment/app/FragmentManager;", "(Landroidx/fragment/app/FragmentManager;)V", "app_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
/* compiled from: BaseFragmentStatePagerAdapter.kt */
public abstract class BaseFragmentStatePagerAdapter extends FragmentStatePagerAdapter {
    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public BaseFragmentStatePagerAdapter(FragmentManager fragmentManager) {
        super(fragmentManager, 1);
        Intrinsics.checkNotNullParameter(fragmentManager, "fragmentManager");
    }
}
