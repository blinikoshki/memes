package com.giphy.sdk.p013ui.views;

import com.giphy.sdk.p013ui.views.GPHMediaTypeView;
import com.google.firebase.crashlytics.internal.settings.model.AppSettingsData;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0005"}, mo26107d2 = {"<anonymous>", "", "old", "Lcom/giphy/sdk/ui/views/GPHMediaTypeView$LayoutType;", "new", "invoke"}, mo26108k = 3, mo26109mv = {1, 1, 13})
/* renamed from: com.giphy.sdk.ui.views.GPHMediaTypeView$layoutTypeListener$1 */
/* compiled from: GPHMediaTypeView.kt */
final class GPHMediaTypeView$layoutTypeListener$1 extends Lambda implements Function2<GPHMediaTypeView.LayoutType, GPHMediaTypeView.LayoutType, Unit> {
    public static final GPHMediaTypeView$layoutTypeListener$1 INSTANCE = new GPHMediaTypeView$layoutTypeListener$1();

    GPHMediaTypeView$layoutTypeListener$1() {
        super(2);
    }

    public final void invoke(GPHMediaTypeView.LayoutType layoutType, GPHMediaTypeView.LayoutType layoutType2) {
        Intrinsics.checkParameterIsNotNull(layoutType, "old");
        Intrinsics.checkParameterIsNotNull(layoutType2, AppSettingsData.STATUS_NEW);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((GPHMediaTypeView.LayoutType) obj, (GPHMediaTypeView.LayoutType) obj2);
        return Unit.INSTANCE;
    }
}
