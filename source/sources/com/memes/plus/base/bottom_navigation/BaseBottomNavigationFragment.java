package com.memes.plus.base.bottom_navigation;

import android.content.Context;
import androidx.viewbinding.ViewBinding;
import com.memes.plus.base.BaseFragment;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import timber.log.Timber;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u00004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\b&\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u00022\b\u0012\u0004\u0012\u0002H\u00010\u0003B\u0005¢\u0006\u0002\u0010\u0004J\u0006\u0010\t\u001a\u00020\nJ\u0006\u0010\u000b\u001a\u00020\bJ\u0010\u0010\f\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\u000eH\u0016J\u000e\u0010\u000f\u001a\u00020\n2\u0006\u0010\u0010\u001a\u00020\u0011R\u000e\u0010\u0005\u001a\u00020\u0006X.¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u000e¢\u0006\u0002\n\u0000¨\u0006\u0012"}, mo26107d2 = {"Lcom/memes/plus/base/bottom_navigation/BaseBottomNavigationFragment;", "BINDING", "Landroidx/viewbinding/ViewBinding;", "Lcom/memes/plus/base/BaseFragment;", "()V", "bottomNavigationFragmentChangeListener", "Lcom/memes/plus/base/bottom_navigation/BottomNavigationFragmentChangeListener;", "tabUpdateEnabled", "", "enableBottomNavigationTabUpdateCapability", "", "isBottomNavigationTabUpdateEnabled", "onAttach", "context", "Landroid/content/Context;", "setSelectedBottomNavigationTab", "newBottomNavTabItemId", "", "app_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
/* compiled from: BaseBottomNavigationFragment.kt */
public abstract class BaseBottomNavigationFragment<BINDING extends ViewBinding> extends BaseFragment<BINDING> {
    /* access modifiers changed from: private */
    public BottomNavigationFragmentChangeListener bottomNavigationFragmentChangeListener;
    private boolean tabUpdateEnabled;

    public static final /* synthetic */ BottomNavigationFragmentChangeListener access$getBottomNavigationFragmentChangeListener$p(BaseBottomNavigationFragment baseBottomNavigationFragment) {
        BottomNavigationFragmentChangeListener bottomNavigationFragmentChangeListener2 = baseBottomNavigationFragment.bottomNavigationFragmentChangeListener;
        if (bottomNavigationFragmentChangeListener2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("bottomNavigationFragmentChangeListener");
        }
        return bottomNavigationFragmentChangeListener2;
    }

    public void onAttach(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        if (context instanceof BottomNavigationFragmentChangeListener) {
            this.bottomNavigationFragmentChangeListener = (BottomNavigationFragmentChangeListener) context;
        }
        super.onAttach(context);
    }

    public final boolean isBottomNavigationTabUpdateEnabled() {
        return this.tabUpdateEnabled;
    }

    public final void enableBottomNavigationTabUpdateCapability() {
        this.tabUpdateEnabled = true;
    }

    public final void setSelectedBottomNavigationTab(int i) {
        if (this.tabUpdateEnabled) {
            if (this.bottomNavigationFragmentChangeListener == null) {
                Timber.m312w("BottomNavigationFragmentChangeListener is not initialized. Ignore me.", new Object[0]);
                return;
            }
            BottomNavigationFragmentChangeListener bottomNavigationFragmentChangeListener2 = this.bottomNavigationFragmentChangeListener;
            if (bottomNavigationFragmentChangeListener2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("bottomNavigationFragmentChangeListener");
            }
            bottomNavigationFragmentChangeListener2.onBottomNavigationFragmentChanged(i);
        }
    }
}
