package editor.optionsui.text.textedit;

import android.view.View;
import androidx.appcompat.widget.AppCompatImageView;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, mo26107d2 = {"<anonymous>", "", "view", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"}, mo26108k = 3, mo26109mv = {1, 4, 2})
/* compiled from: TextEditFragment.kt */
final class TextEditFragment$setTextCapModeListeners$3 implements View.OnClickListener {
    final /* synthetic */ TextEditFragment this$0;

    TextEditFragment$setTextCapModeListeners$3(TextEditFragment textEditFragment) {
        this.this$0 = textEditFragment;
    }

    public final void onClick(View view) {
        Intrinsics.checkNotNullExpressionValue(view, ViewHierarchyConstants.VIEW_KEY);
        view.setSelected(!view.isSelected());
        this.this$0.getTextEditViewModel().changeCapMode(new TextCapMode(false, false, view.isSelected(), 3, (DefaultConstructorMarker) null));
        AppCompatImageView appCompatImageView = TextEditFragment.access$getBinding$p(this.this$0).allCapsOptionView;
        Intrinsics.checkNotNullExpressionValue(appCompatImageView, "binding.allCapsOptionView");
        appCompatImageView.setSelected(false);
        AppCompatImageView appCompatImageView2 = TextEditFragment.access$getBinding$p(this.this$0).wordCapsOptionView;
        Intrinsics.checkNotNullExpressionValue(appCompatImageView2, "binding.wordCapsOptionView");
        appCompatImageView2.setSelected(false);
    }
}
