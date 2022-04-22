package org.jetbrains.anko;

import android.text.style.ClickableSpan;
import android.view.View;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo26105bv = {1, 0, 1}, mo26106d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0016¨\u0006\u0007"}, mo26107d2 = {"org/jetbrains/anko/BuildSpannedKt$clickable$1", "Landroid/text/style/ClickableSpan;", "(Lkotlin/jvm/functions/Function1;)V", "onClick", "", "widget", "Landroid/view/View;", "commons_release"}, mo26108k = 1, mo26109mv = {1, 1, 5})
/* compiled from: buildSpanned.kt */
public final class BuildSpannedKt$clickable$1 extends ClickableSpan {
    final /* synthetic */ Function1 $onClick;

    public BuildSpannedKt$clickable$1(Function1 function1) {
        this.$onClick = function1;
    }

    public void onClick(View view) {
        Intrinsics.checkParameterIsNotNull(view, "widget");
        this.$onClick.invoke(view);
    }
}
