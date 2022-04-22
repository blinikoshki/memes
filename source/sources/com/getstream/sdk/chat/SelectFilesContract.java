package com.getstream.sdk.chat;

import android.content.ClipData;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import androidx.activity.result.contract.ActivityResultContract;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import p015io.getstream.chat.android.core.internal.InternalStreamChatApi;

@InternalStreamChatApi
@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0007\u0018\u00002\u0014\u0012\u0004\u0012\u00020\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u00030\u0001B\u0005¢\u0006\u0002\u0010\u0005J\u001f\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u0002H\u0016¢\u0006\u0002\u0010\u000bJ\u0018\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\b\u0010\r\u001a\u0004\u0018\u00010\u000eH\u0002J \u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u0006\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0007H\u0016¨\u0006\u0013"}, mo26107d2 = {"Lcom/getstream/sdk/chat/SelectFilesContract;", "Landroidx/activity/result/contract/ActivityResultContract;", "", "", "Landroid/net/Uri;", "()V", "createIntent", "Landroid/content/Intent;", "context", "Landroid/content/Context;", "input", "(Landroid/content/Context;Lkotlin/Unit;)Landroid/content/Intent;", "parseMultipleResults", "clipData", "Landroid/content/ClipData;", "parseResult", "resultCode", "", "intent", "stream-chat-android-ui-common_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
/* compiled from: SelectFilesContract.kt */
public final class SelectFilesContract extends ActivityResultContract<Unit, List<? extends Uri>> {
    public Intent createIntent(Context context, Unit unit) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intent intent = new Intent("android.intent.action.OPEN_DOCUMENT");
        intent.setType("*/*");
        intent.addCategory("android.intent.category.OPENABLE");
        intent.putExtra("android.intent.extra.ALLOW_MULTIPLE", true);
        return intent;
    }

    public List<Uri> parseResult(int i, Intent intent) {
        ClipData clipData;
        List<Uri> listOf;
        ClipData clipData2 = null;
        Uri data = intent != null ? intent.getData() : null;
        boolean z = true;
        if (!(i == -1)) {
            data = null;
        }
        if (data != null && (listOf = CollectionsKt.listOf(data)) != null) {
            return listOf;
        }
        if (!(intent == null || (clipData = intent.getClipData()) == null)) {
            if (i != -1) {
                z = false;
            }
            if (z) {
                clipData2 = clipData;
            }
        }
        return parseMultipleResults(clipData2);
    }

    private final List<Uri> parseMultipleResults(ClipData clipData) {
        if (clipData == null) {
            return CollectionsKt.emptyList();
        }
        List<Uri> arrayList = new ArrayList<>();
        int itemCount = clipData.getItemCount();
        for (int i = 0; i < itemCount; i++) {
            ClipData.Item itemAt = clipData.getItemAt(i);
            Intrinsics.checkNotNullExpressionValue(itemAt, "it.getItemAt(i)");
            arrayList.add(itemAt.getUri());
        }
        return arrayList;
    }
}
