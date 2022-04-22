package com.memes.plus.p040ui.profile.edit_profile;

import androidx.lifecycle.Observer;
import kotlin.Metadata;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, mo26107d2 = {"<anonymous>", "", "it", "", "kotlin.jvm.PlatformType", "onChanged"}, mo26108k = 3, mo26109mv = {1, 4, 2})
/* renamed from: com.memes.plus.ui.profile.edit_profile.EditProfileActivity$onCreate$23 */
/* compiled from: EditProfileActivity.kt */
final class EditProfileActivity$onCreate$23<T> implements Observer<String> {
    final /* synthetic */ EditProfileActivity this$0;

    EditProfileActivity$onCreate$23(EditProfileActivity editProfileActivity) {
        this.this$0 = editProfileActivity;
    }

    public final void onChanged(String str) {
        this.this$0.getBinding().nameEditText.setText(str);
    }
}
