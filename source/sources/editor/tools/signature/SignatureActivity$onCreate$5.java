package editor.tools.signature;

import android.content.Intent;
import editor.signature.views.SignaturePad;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, mo26107d2 = {"<anonymous>", "", "invoke"}, mo26108k = 3, mo26109mv = {1, 4, 2})
/* compiled from: SignatureActivity.kt */
final class SignatureActivity$onCreate$5 extends Lambda implements Function0<Unit> {
    final /* synthetic */ SignatureActivity this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    SignatureActivity$onCreate$5(SignatureActivity signatureActivity) {
        super(0);
        this.this$0 = signatureActivity;
    }

    public final void invoke() {
        if (this.this$0.isSignatureErased) {
            SignaturePad signaturePad = this.this$0.getBinding().signaturePad;
            Intrinsics.checkNotNullExpressionValue(signaturePad, "binding.signaturePad");
            if (signaturePad.isEmpty()) {
                this.this$0.finish();
                return;
            }
        }
        Intent intent = this.this$0.getIntent();
        String stringExtra = intent != null ? intent.getStringExtra(SignatureActivity.EXTRA_OUTPUT_PATH) : null;
        SignaturePad signaturePad2 = this.this$0.getBinding().signaturePad;
        Intrinsics.checkNotNullExpressionValue(signaturePad2, "binding.signaturePad");
        this.this$0.getSignatureViewModel().saveSignatureBitmap(signaturePad2.getTransparentSignatureBitmap(), stringExtra);
    }
}
