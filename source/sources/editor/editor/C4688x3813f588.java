package editor.editor;

import kotlin.Metadata;
import kotlin.coroutines.AbstractCoroutineContextElement;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.CoroutineExceptionHandler;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000!\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0003\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u00012\u00020\u0002J\u0018\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0016¨\u0006\t¸\u0006\u0000"}, mo26107d2 = {"kotlinx/coroutines/CoroutineExceptionHandlerKt$CoroutineExceptionHandler$1", "Lkotlin/coroutines/AbstractCoroutineContextElement;", "Lkotlinx/coroutines/CoroutineExceptionHandler;", "handleException", "", "context", "Lkotlin/coroutines/CoroutineContext;", "exception", "", "kotlinx-coroutines-core"}, mo26108k = 1, mo26109mv = {1, 4, 2})
/* renamed from: editor.editor.EditorViewModel$frameworkExceptionHandler$2$$special$$inlined$CoroutineExceptionHandler$1 */
/* compiled from: CoroutineExceptionHandler.kt */
public final class C4688x3813f588 extends AbstractCoroutineContextElement implements CoroutineExceptionHandler {
    final /* synthetic */ EditorViewModel$frameworkExceptionHandler$2 this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public C4688x3813f588(CoroutineContext.Key key, EditorViewModel$frameworkExceptionHandler$2 editorViewModel$frameworkExceptionHandler$2) {
        super(key);
        this.this$0 = editorViewModel$frameworkExceptionHandler$2;
    }

    public void handleException(CoroutineContext coroutineContext, Throwable th) {
        StringBuilder sb = new StringBuilder();
        sb.append("Unexpected error occurred while creating meme.");
        Intrinsics.checkNotNullExpressionValue(sb, "append(value)");
        sb.append(10);
        Intrinsics.checkNotNullExpressionValue(sb, "append('\\n')");
        CharSequence message = th.getMessage();
        if (!(message == null || StringsKt.isBlank(message))) {
            sb.append("Root Cause: " + th.getMessage());
        }
        String sb2 = sb.toString();
        Intrinsics.checkNotNullExpressionValue(sb2, "StringBuilder().apply(builderAction).toString()");
        this.this$0.this$0.showErrorOnBlockingProgress(sb2);
    }
}
