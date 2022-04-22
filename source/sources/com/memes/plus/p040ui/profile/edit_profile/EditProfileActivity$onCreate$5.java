package com.memes.plus.p040ui.profile.edit_profile;

import android.view.View;
import com.memes.plus.App;
import kotlin.Metadata;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\u0016\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u00032\u0006\u0010\u0005\u001a\u00020\u0006H\n¢\u0006\u0002\b\u0007"}, mo26107d2 = {"<anonymous>", "", "<anonymous parameter 0>", "Landroid/view/View;", "kotlin.jvm.PlatformType", "hasFocus", "", "onFocusChange"}, mo26108k = 3, mo26109mv = {1, 4, 2})
/* renamed from: com.memes.plus.ui.profile.edit_profile.EditProfileActivity$onCreate$5 */
/* compiled from: EditProfileActivity.kt */
final class EditProfileActivity$onCreate$5 implements View.OnFocusChangeListener {
    public static final EditProfileActivity$onCreate$5 INSTANCE = new EditProfileActivity$onCreate$5();

    EditProfileActivity$onCreate$5() {
    }

    public final void onFocusChange(View view, boolean z) {
        if (z) {
            App.Companion.trackingManager().onNameFieldTapped();
        }
    }
}
