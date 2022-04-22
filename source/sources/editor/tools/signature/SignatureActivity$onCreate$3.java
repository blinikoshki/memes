package editor.tools.signature;

import android.content.Context;
import android.view.View;
import com.memes.commons.util.ExtensionsKt;
import com.memes.editor.C4175R;
import kotlin.Metadata;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, mo26107d2 = {"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onLongClick"}, mo26108k = 3, mo26109mv = {1, 4, 2})
/* compiled from: SignatureActivity.kt */
final class SignatureActivity$onCreate$3 implements View.OnLongClickListener {
    final /* synthetic */ SignatureActivity this$0;

    SignatureActivity$onCreate$3(SignatureActivity signatureActivity) {
        this.this$0 = signatureActivity;
    }

    public final boolean onLongClick(View view) {
        ExtensionsKt.toast((Context) this.this$0, C4175R.string.erase_signature);
        return true;
    }
}
