package editor.tools.signature;

import com.memes.editor.databinding.NSignatureActivityBinding;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, mo26107d2 = {"<anonymous>", "Lcom/memes/editor/databinding/NSignatureActivityBinding;", "invoke"}, mo26108k = 3, mo26109mv = {1, 4, 2})
/* compiled from: SignatureActivity.kt */
final class SignatureActivity$binding$2 extends Lambda implements Function0<NSignatureActivityBinding> {
    final /* synthetic */ SignatureActivity this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    SignatureActivity$binding$2(SignatureActivity signatureActivity) {
        super(0);
        this.this$0 = signatureActivity;
    }

    public final NSignatureActivityBinding invoke() {
        return NSignatureActivityBinding.inflate(this.this$0.getLayoutInflater());
    }
}
