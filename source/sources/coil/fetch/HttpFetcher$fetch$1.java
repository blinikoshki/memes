package coil.fetch;

import coil.bitmap.BitmapPool;
import coil.decode.Options;
import coil.size.Size;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000&\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u0001\"\b\b\u0000\u0010\u0002*\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u0002H\u00022\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000bH@"}, mo26107d2 = {"fetch", "", "T", "pool", "Lcoil/bitmap/BitmapPool;", "data", "size", "Lcoil/size/Size;", "options", "Lcoil/decode/Options;", "continuation", "Lkotlin/coroutines/Continuation;", "Lcoil/fetch/FetchResult;"}, mo26108k = 3, mo26109mv = {1, 4, 1})
@DebugMetadata(mo26807c = "coil.fetch.HttpFetcher", mo26808f = "HttpFetcher.kt", mo26809i = {0, 0}, mo26810l = {125}, mo26811m = "fetch$suspendImpl", mo26812n = {"this", "url"}, mo26813s = {"L$0", "L$1"})
/* compiled from: HttpFetcher.kt */
final class HttpFetcher$fetch$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    Object L$2;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ HttpFetcher this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    HttpFetcher$fetch$1(HttpFetcher httpFetcher, Continuation continuation) {
        super(continuation);
        this.this$0 = httpFetcher;
    }

    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return HttpFetcher.fetch$suspendImpl(this.this$0, (BitmapPool) null, (Object) null, (Size) null, (Options) null, this);
    }
}
