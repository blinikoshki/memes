package com.memes.plus.base;

import androidx.fragment.app.Fragment;
import com.memes.commons.viewmodel.BaseViewModel;
import kotlin.Metadata;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H'J\b\u0010\u0004\u001a\u00020\u0005H&J\u0010\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\bH&J\"\u0010\t\u001a\u00020\u00052\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\b\b\u0002\u0010\u000e\u001a\u00020\u000fH&¨\u0006\u0010"}, mo26107d2 = {"Lcom/memes/plus/base/ActivityHandle;", "", "fragmentContainerId", "", "popFragment", "", "registerViewModel", "viewModel", "Lcom/memes/commons/viewmodel/BaseViewModel;", "replaceFragment", "fragment", "Landroidx/fragment/app/Fragment;", "fragmentTag", "", "addToBackStack", "", "app_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
/* compiled from: ActivityHandle.kt */
public interface ActivityHandle {
    int fragmentContainerId();

    void popFragment();

    void registerViewModel(BaseViewModel baseViewModel);

    void replaceFragment(Fragment fragment, String str, boolean z);

    @Metadata(mo26105bv = {1, 0, 3}, mo26108k = 3, mo26109mv = {1, 4, 2})
    /* compiled from: ActivityHandle.kt */
    public static final class DefaultImpls {
        public static /* synthetic */ void replaceFragment$default(ActivityHandle activityHandle, Fragment fragment, String str, boolean z, int i, Object obj) {
            if (obj == null) {
                if ((i & 4) != 0) {
                    z = true;
                }
                activityHandle.replaceFragment(fragment, str, z);
                return;
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: replaceFragment");
        }
    }
}
