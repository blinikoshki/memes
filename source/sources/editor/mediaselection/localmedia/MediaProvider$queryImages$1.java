package editor.mediaselection.localmedia;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u00012\u0012\u0010\u0002\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u00040\u0003H@"}, mo26107d2 = {"queryImages", "", "continuation", "Lkotlin/coroutines/Continuation;", "", "Leditor/mediaselection/localmedia/LocalMedia;"}, mo26108k = 3, mo26109mv = {1, 4, 2})
@DebugMetadata(mo26807c = "editor.mediaselection.localmedia.MediaProvider", mo26808f = "MediaProvider.kt", mo26809i = {0}, mo26810l = {33}, mo26811m = "queryImages", mo26812n = {"liteMediaContents"}, mo26813s = {"L$0"})
/* compiled from: MediaProvider.kt */
final class MediaProvider$queryImages$1 extends ContinuationImpl {
    Object L$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ MediaProvider this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    MediaProvider$queryImages$1(MediaProvider mediaProvider, Continuation continuation) {
        super(continuation);
        this.this$0 = mediaProvider;
    }

    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.queryImages(this);
    }
}
