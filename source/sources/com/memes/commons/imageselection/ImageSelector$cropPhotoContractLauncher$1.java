package com.memes.commons.imageselection;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, mo26107d2 = {"<anonymous>", "", "result", "Landroidx/activity/result/ActivityResult;", "kotlin.jvm.PlatformType", "onActivityResult"}, mo26108k = 3, mo26109mv = {1, 4, 2})
/* compiled from: ImageSelector.kt */
final class ImageSelector$cropPhotoContractLauncher$1<O> implements ActivityResultCallback<ActivityResult> {
    final /* synthetic */ ImageSelector this$0;

    ImageSelector$cropPhotoContractLauncher$1(ImageSelector imageSelector) {
        this.this$0 = imageSelector;
    }

    public final void onActivityResult(ActivityResult activityResult) {
        ImageSelector imageSelector = this.this$0;
        Intrinsics.checkNotNullExpressionValue(activityResult, "result");
        imageSelector.handleCropPhotoActivityResult(activityResult);
    }
}
