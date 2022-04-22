package editor.trash;

import android.view.View;
import java.io.File;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\u0018\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u000e\u0010\u0006\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u0007H@"}, mo26107d2 = {"save", "", "view", "Landroid/view/View;", "outputFile", "Ljava/io/File;", "continuation", "Lkotlin/coroutines/Continuation;"}, mo26108k = 3, mo26109mv = {1, 4, 2})
@DebugMetadata(mo26807c = "editor.trash.ViewContentSaver", mo26808f = "ViewContentSaver.kt", mo26809i = {}, mo26810l = {38}, mo26811m = "save", mo26812n = {}, mo26813s = {})
/* compiled from: ViewContentSaver.kt */
final class ViewContentSaver$save$1 extends ContinuationImpl {
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ ViewContentSaver this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    ViewContentSaver$save$1(ViewContentSaver viewContentSaver, Continuation continuation) {
        super(continuation);
        this.this$0 = viewContentSaver;
    }

    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.save((View) null, (File) null, this);
    }
}
