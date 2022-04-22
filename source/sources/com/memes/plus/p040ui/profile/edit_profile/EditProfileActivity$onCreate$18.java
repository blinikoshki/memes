package com.memes.plus.p040ui.profile.edit_profile;

import android.view.View;
import com.memes.plus.App;
import kotlin.Metadata;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, mo26107d2 = {"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"}, mo26108k = 3, mo26109mv = {1, 4, 2})
/* renamed from: com.memes.plus.ui.profile.edit_profile.EditProfileActivity$onCreate$18 */
/* compiled from: EditProfileActivity.kt */
final class EditProfileActivity$onCreate$18 implements View.OnClickListener {
    public static final EditProfileActivity$onCreate$18 INSTANCE = new EditProfileActivity$onCreate$18();

    EditProfileActivity$onCreate$18() {
    }

    public final void onClick(View view) {
        App.Companion.trackingManager().onRestorePurchasesTapped();
    }
}
