package editor.mediaselection.stockmemes;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u00012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H@"}, mo26107d2 = {"searchInternal", "", "continuation", "Lkotlin/coroutines/Continuation;", ""}, mo26108k = 3, mo26109mv = {1, 4, 2})
@DebugMetadata(mo26807c = "editor.mediaselection.stockmemes.StockMemesViewModel", mo26808f = "StockMemesViewModel.kt", mo26809i = {0, 0}, mo26810l = {105}, mo26811m = "searchInternal", mo26812n = {"this", "currentPage"}, mo26813s = {"L$0", "I$0"})
/* compiled from: StockMemesViewModel.kt */
final class StockMemesViewModel$searchInternal$1 extends ContinuationImpl {
    int I$0;
    Object L$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ StockMemesViewModel this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    StockMemesViewModel$searchInternal$1(StockMemesViewModel stockMemesViewModel, Continuation continuation) {
        super(continuation);
        this.this$0 = stockMemesViewModel;
    }

    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.searchInternal(this);
    }
}
