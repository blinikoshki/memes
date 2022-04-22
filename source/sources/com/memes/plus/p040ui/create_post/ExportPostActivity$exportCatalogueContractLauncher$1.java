package com.memes.plus.p040ui.create_post;

import android.content.Intent;
import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import com.memes.commons.util.ActivityResultExtKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, mo26107d2 = {"<anonymous>", "", "activityResult", "Landroidx/activity/result/ActivityResult;", "kotlin.jvm.PlatformType", "onActivityResult"}, mo26108k = 3, mo26109mv = {1, 4, 2})
/* renamed from: com.memes.plus.ui.create_post.ExportPostActivity$exportCatalogueContractLauncher$1 */
/* compiled from: ExportPostActivity.kt */
final class ExportPostActivity$exportCatalogueContractLauncher$1<O> implements ActivityResultCallback<ActivityResult> {
    final /* synthetic */ ExportPostActivity this$0;

    ExportPostActivity$exportCatalogueContractLauncher$1(ExportPostActivity exportPostActivity) {
        this.this$0 = exportPostActivity;
    }

    public final void onActivityResult(ActivityResult activityResult) {
        Intrinsics.checkNotNullExpressionValue(activityResult, "activityResult");
        Intent dataIfOkResult = ActivityResultExtKt.getDataIfOkResult(activityResult);
        if (dataIfOkResult != null) {
            String stringExtra = dataIfOkResult.getStringExtra("android.intent.extra.TEXT");
            CharSequence charSequence = stringExtra;
            if (!(charSequence == null || StringsKt.isBlank(charSequence))) {
                this.this$0.getSavedHashTagsAdapter().addItem(stringExtra);
            }
        }
    }
}
