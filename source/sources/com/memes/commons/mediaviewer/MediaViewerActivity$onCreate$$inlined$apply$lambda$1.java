package com.memes.commons.mediaviewer;

import android.content.Context;
import com.livinglifetechway.quickpermissions_kotlin.util.QuickPermissionsRequest;
import com.memes.commons.util.ExtensionsKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004¨\u0006\u0005"}, mo26107d2 = {"<anonymous>", "", "it", "Lcom/livinglifetechway/quickpermissions_kotlin/util/QuickPermissionsRequest;", "invoke", "com/memes/commons/mediaviewer/MediaViewerActivity$onCreate$3$1"}, mo26108k = 3, mo26109mv = {1, 4, 2})
/* compiled from: MediaViewerActivity.kt */
final class MediaViewerActivity$onCreate$$inlined$apply$lambda$1 extends Lambda implements Function1<QuickPermissionsRequest, Unit> {
    final /* synthetic */ MediaViewerActivity this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    MediaViewerActivity$onCreate$$inlined$apply$lambda$1(MediaViewerActivity mediaViewerActivity) {
        super(1);
        this.this$0 = mediaViewerActivity;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((QuickPermissionsRequest) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(QuickPermissionsRequest quickPermissionsRequest) {
        Intrinsics.checkNotNullParameter(quickPermissionsRequest, "it");
        ExtensionsKt.toast((Context) this.this$0, "Storage permission is required to view files.");
        this.this$0.finish();
    }
}
