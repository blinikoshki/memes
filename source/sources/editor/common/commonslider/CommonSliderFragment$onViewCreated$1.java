package editor.common.commonslider;

import androidx.lifecycle.Observer;
import editor.common.sheetheader.TitleWithResetHeader;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, mo26107d2 = {"<anonymous>", "", "title", "", "kotlin.jvm.PlatformType", "onChanged"}, mo26108k = 3, mo26109mv = {1, 4, 2})
/* compiled from: CommonSliderFragment.kt */
final class CommonSliderFragment$onViewCreated$1<T> implements Observer<String> {
    final /* synthetic */ CommonSliderFragment this$0;

    CommonSliderFragment$onViewCreated$1(CommonSliderFragment commonSliderFragment) {
        this.this$0 = commonSliderFragment;
    }

    public final void onChanged(String str) {
        TitleWithResetHeader titleWithResetHeader = CommonSliderFragment.access$getBinding$p(this.this$0).header;
        Intrinsics.checkNotNullExpressionValue(str, "title");
        titleWithResetHeader.setTitle(str);
    }
}
