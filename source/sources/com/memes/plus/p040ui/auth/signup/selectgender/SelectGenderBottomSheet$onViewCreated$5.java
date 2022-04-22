package com.memes.plus.p040ui.auth.signup.selectgender;

import android.view.View;
import com.memes.plus.p040ui.auth.signup.selectgender.SelectGenderBottomSheet;
import kotlin.Metadata;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, mo26107d2 = {"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"}, mo26108k = 3, mo26109mv = {1, 4, 2})
/* renamed from: com.memes.plus.ui.auth.signup.selectgender.SelectGenderBottomSheet$onViewCreated$5 */
/* compiled from: SelectGenderBottomSheet.kt */
final class SelectGenderBottomSheet$onViewCreated$5 implements View.OnClickListener {
    final /* synthetic */ SelectGenderBottomSheet this$0;

    SelectGenderBottomSheet$onViewCreated$5(SelectGenderBottomSheet selectGenderBottomSheet) {
        this.this$0 = selectGenderBottomSheet;
    }

    public final void onClick(View view) {
        SelectGenderBottomSheet.Callback access$getCallback$p = this.this$0.callback;
        if (access$getCallback$p != null) {
            access$getCallback$p.onGenderSelected(this.this$0.selectedGender);
        }
        this.this$0.dismiss();
    }
}
