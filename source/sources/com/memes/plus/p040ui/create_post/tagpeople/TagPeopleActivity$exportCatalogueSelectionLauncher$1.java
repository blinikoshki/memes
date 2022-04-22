package com.memes.plus.p040ui.create_post.tagpeople;

import android.content.Intent;
import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import com.memes.commons.util.ActivityResultExtKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.anko.DimensionsKt;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, mo26107d2 = {"<anonymous>", "", "activityResult", "Landroidx/activity/result/ActivityResult;", "kotlin.jvm.PlatformType", "onActivityResult"}, mo26108k = 3, mo26109mv = {1, 4, 2})
/* renamed from: com.memes.plus.ui.create_post.tagpeople.TagPeopleActivity$exportCatalogueSelectionLauncher$1 */
/* compiled from: TagPeopleActivity.kt */
final class TagPeopleActivity$exportCatalogueSelectionLauncher$1<O> implements ActivityResultCallback<ActivityResult> {
    final /* synthetic */ TagPeopleActivity this$0;

    TagPeopleActivity$exportCatalogueSelectionLauncher$1(TagPeopleActivity tagPeopleActivity) {
        this.this$0 = tagPeopleActivity;
    }

    public final void onActivityResult(ActivityResult activityResult) {
        Intrinsics.checkNotNullExpressionValue(activityResult, "activityResult");
        Intent dataIfOkResult = ActivityResultExtKt.getDataIfOkResult(activityResult);
        if (dataIfOkResult != null) {
            String stringExtra = dataIfOkResult.getStringExtra(TagPeopleActivity.USER_NAME);
            this.this$0.addTaggedPerson(new TaggedPerson(dataIfOkResult.getStringExtra(TagPeopleActivity.IMAGE_URL), dataIfOkResult.getStringExtra(TagPeopleActivity.FULL_NAME), stringExtra, dataIfOkResult.getStringExtra(TagPeopleActivity.USER_ID), dataIfOkResult.getBooleanExtra(TagPeopleActivity.IS_PRO_USER, false), 0.0f, 0.0f, 0.0f, 0.0f, DimensionsKt.XXHDPI, (DefaultConstructorMarker) null));
        }
    }
}
