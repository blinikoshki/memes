package com.memes.plus.p040ui.profile.edit_profile;

import androidx.lifecycle.Observer;
import com.memes.plus.C4199R;
import com.memes.plus.util.picasso.PicassoExtKt;
import com.squareup.picasso.Picasso;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, mo26107d2 = {"<anonymous>", "", "imagePath", "", "kotlin.jvm.PlatformType", "onChanged"}, mo26108k = 3, mo26109mv = {1, 4, 2})
/* renamed from: com.memes.plus.ui.profile.edit_profile.EditProfileActivity$onCreate$22 */
/* compiled from: EditProfileActivity.kt */
final class EditProfileActivity$onCreate$22<T> implements Observer<String> {
    final /* synthetic */ EditProfileActivity this$0;

    EditProfileActivity$onCreate$22(EditProfileActivity editProfileActivity) {
        this.this$0 = editProfileActivity;
    }

    public final void onChanged(String str) {
        CharSequence charSequence = str;
        if (charSequence == null || StringsKt.isBlank(charSequence)) {
            this.this$0.getBinding().coverImageView.setImageResource(C4199R.C4201color.MemeBackgroundcolor);
            return;
        }
        Picasso picasso = Picasso.get();
        Intrinsics.checkNotNullExpressionValue(picasso, "Picasso.get()");
        PicassoExtKt.log$default(picasso, (Object) this.this$0, str, (String) null, 4, (Object) null).load(str).placeholder((int) C4199R.C4201color.MemeBackgroundcolor).error((int) C4199R.C4201color.MemeBackgroundcolor).into(this.this$0.getBinding().coverImageView);
    }
}
