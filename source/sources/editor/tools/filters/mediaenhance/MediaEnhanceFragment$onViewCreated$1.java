package editor.tools.filters.mediaenhance;

import androidx.lifecycle.Observer;
import editor.custom.optionbutton.SmallOptionButton;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0004\b\u0005\u0010\u0006"}, mo26107d2 = {"<anonymous>", "", "applied", "", "kotlin.jvm.PlatformType", "onChanged", "(Ljava/lang/Boolean;)V"}, mo26108k = 3, mo26109mv = {1, 4, 2})
/* compiled from: MediaEnhanceFragment.kt */
final class MediaEnhanceFragment$onViewCreated$1<T> implements Observer<Boolean> {
    final /* synthetic */ MediaEnhanceFragment this$0;

    MediaEnhanceFragment$onViewCreated$1(MediaEnhanceFragment mediaEnhanceFragment) {
        this.this$0 = mediaEnhanceFragment;
    }

    public final void onChanged(Boolean bool) {
        SmallOptionButton smallOptionButton = MediaEnhanceFragment.access$getBinding$p(this.this$0).contrastOptionView;
        Intrinsics.checkNotNullExpressionValue(smallOptionButton, "binding.contrastOptionView");
        Intrinsics.checkNotNullExpressionValue(bool, "applied");
        smallOptionButton.setSelected(bool.booleanValue());
    }
}
