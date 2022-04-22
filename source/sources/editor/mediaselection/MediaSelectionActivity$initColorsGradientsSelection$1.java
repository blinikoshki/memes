package editor.mediaselection;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, mo26107d2 = {"<anonymous>", "", "selectedTabTitle", "", "invoke"}, mo26108k = 3, mo26109mv = {1, 4, 2})
/* compiled from: MediaSelectionActivity.kt */
final class MediaSelectionActivity$initColorsGradientsSelection$1 extends Lambda implements Function1<String, Unit> {
    final /* synthetic */ String $colorsChoice;
    final /* synthetic */ String $gradientsChoice;
    final /* synthetic */ MediaSelectionActivity this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    MediaSelectionActivity$initColorsGradientsSelection$1(MediaSelectionActivity mediaSelectionActivity, String str, String str2) {
        super(1);
        this.this$0 = mediaSelectionActivity;
        this.$colorsChoice = str;
        this.$gradientsChoice = str2;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((String) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(String str) {
        BaseMediaCategoryAdapter baseMediaCategoryAdapter;
        Intrinsics.checkNotNullParameter(str, "selectedTabTitle");
        if (Intrinsics.areEqual((Object) str, (Object) this.$colorsChoice)) {
            baseMediaCategoryAdapter = this.this$0.getColorsAdapter();
        } else if (Intrinsics.areEqual((Object) str, (Object) this.$gradientsChoice)) {
            baseMediaCategoryAdapter = this.this$0.getGradientsAdapter();
        } else {
            return;
        }
        this.this$0.getBinding().colorsGradientsCategoryView.setAdapter(baseMediaCategoryAdapter);
    }
}
