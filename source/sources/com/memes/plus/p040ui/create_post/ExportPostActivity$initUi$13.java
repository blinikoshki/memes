package com.memes.plus.p040ui.create_post;

import android.widget.CompoundButton;
import kotlin.Metadata;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\u0016\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u00032\u0006\u0010\u0005\u001a\u00020\u0006H\n¢\u0006\u0002\b\u0007"}, mo26107d2 = {"<anonymous>", "", "buttonView", "Landroid/widget/CompoundButton;", "kotlin.jvm.PlatformType", "isChecked", "", "onCheckedChanged"}, mo26108k = 3, mo26109mv = {1, 4, 2})
/* renamed from: com.memes.plus.ui.create_post.ExportPostActivity$initUi$13 */
/* compiled from: ExportPostActivity.kt */
final class ExportPostActivity$initUi$13 implements CompoundButton.OnCheckedChangeListener {
    final /* synthetic */ ExportPostActivity this$0;

    ExportPostActivity$initUi$13(ExportPostActivity exportPostActivity) {
        this.this$0 = exportPostActivity;
    }

    public final void onCheckedChanged(CompoundButton compoundButton, boolean z) {
        this.this$0.onChangeAutoSavePreference(z);
    }
}
