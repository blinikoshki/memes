package editor.tools.signature;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u000b\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\n¢\u0006\u0002\b\u0006"}, mo26107d2 = {"<anonymous>", "", "value", "", "fromUser", "", "invoke"}, mo26108k = 3, mo26109mv = {1, 4, 2})
/* compiled from: SignatureActivity.kt */
final class SignatureActivity$onCreate$1 extends Lambda implements Function2<Float, Boolean, Unit> {
    final /* synthetic */ SignatureActivity this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    SignatureActivity$onCreate$1(SignatureActivity signatureActivity) {
        super(2);
        this.this$0 = signatureActivity;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke(((Number) obj).floatValue(), ((Boolean) obj2).booleanValue());
        return Unit.INSTANCE;
    }

    public final void invoke(float f, boolean z) {
        if (z) {
            float f2 = (float) 1;
            float f3 = f > f2 ? f - f2 : f;
            if (f < ((float) 99)) {
                f += f2;
            }
            this.this$0.getBinding().signaturePad.setMinWidth(f3);
            this.this$0.getBinding().signaturePad.setMaxWidth(f);
        }
    }
}
