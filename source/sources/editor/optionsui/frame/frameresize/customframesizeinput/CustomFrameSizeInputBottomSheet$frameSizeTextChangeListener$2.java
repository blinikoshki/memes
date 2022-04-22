package editor.optionsui.frame.frameresize.customframesizeinput;

import android.text.Editable;
import android.text.TextWatcher;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\t\n\u0000\n\u0002\b\u0003*\u0001\u0001\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, mo26107d2 = {"<anonymous>", "editor/optionsui/frame/frameresize/customframesizeinput/CustomFrameSizeInputBottomSheet$frameSizeTextChangeListener$2$1", "invoke", "()Leditor/optionsui/frame/frameresize/customframesizeinput/CustomFrameSizeInputBottomSheet$frameSizeTextChangeListener$2$1;"}, mo26108k = 3, mo26109mv = {1, 4, 2})
/* compiled from: CustomFrameSizeInputBottomSheet.kt */
final class CustomFrameSizeInputBottomSheet$frameSizeTextChangeListener$2 extends Lambda implements Function0<C48481> {
    final /* synthetic */ CustomFrameSizeInputBottomSheet this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    CustomFrameSizeInputBottomSheet$frameSizeTextChangeListener$2(CustomFrameSizeInputBottomSheet customFrameSizeInputBottomSheet) {
        super(0);
        this.this$0 = customFrameSizeInputBottomSheet;
    }

    public final C48481 invoke() {
        return new TextWatcher(this) {
            final /* synthetic */ CustomFrameSizeInputBottomSheet$frameSizeTextChangeListener$2 this$0;

            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            {
                this.this$0 = r1;
            }

            public void afterTextChanged(Editable editable) {
                this.this$0.this$0.updateFrameSizePreview();
            }
        };
    }
}
