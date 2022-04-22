package editor.core;

import android.content.Context;
import com.memes.commons.util.ExtensionsKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, mo26107d2 = {"<anonymous>", "", "messageRes", "", "invoke"}, mo26108k = 3, mo26109mv = {1, 4, 2})
/* compiled from: NicoActivity.kt */
final class NicoActivity$registerViewModel$2 extends Lambda implements Function1<Integer, Unit> {
    final /* synthetic */ NicoActivity this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    NicoActivity$registerViewModel$2(NicoActivity nicoActivity) {
        super(1);
        this.this$0 = nicoActivity;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke(((Number) obj).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(int i) {
        ExtensionsKt.toast((Context) this.this$0, i);
    }
}
