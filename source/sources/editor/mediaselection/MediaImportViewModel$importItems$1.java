package editor.mediaselection;

import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H@¢\u0006\u0004\b\u0003\u0010\u0004"}, mo26107d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;"}, mo26108k = 3, mo26109mv = {1, 4, 2})
@DebugMetadata(mo26807c = "editor.mediaselection.MediaImportViewModel$importItems$1", mo26808f = "MediaImportViewModel.kt", mo26809i = {0, 0}, mo26810l = {95}, mo26811m = "invokeSuspend", mo26812n = {"downloadedContents", "index"}, mo26813s = {"L$0", "I$0"})
/* compiled from: MediaImportViewModel.kt */
final class MediaImportViewModel$importItems$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ List $items;
    int I$0;
    Object L$0;
    Object L$1;
    int label;
    final /* synthetic */ MediaImportViewModel this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    MediaImportViewModel$importItems$1(MediaImportViewModel mediaImportViewModel, List list, Continuation continuation) {
        super(2, continuation);
        this.this$0 = mediaImportViewModel;
        this.$items = list;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        Intrinsics.checkNotNullParameter(continuation, "completion");
        return new MediaImportViewModel$importItems$1(this.this$0, this.$items, continuation);
    }

    public final Object invoke(Object obj, Object obj2) {
        return ((MediaImportViewModel$importItems$1) create(obj, (Continuation) obj2)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARNING: Removed duplicated region for block: B:31:0x00e1  */
    /* JADX WARNING: Removed duplicated region for block: B:9:0x0044  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object invokeSuspend(java.lang.Object r12) {
        /*
            r11 = this;
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r1 = r11.label
            r2 = 0
            r3 = 1
            if (r1 == 0) goto L_0x0028
            if (r1 != r3) goto L_0x0020
            int r1 = r11.I$0
            java.lang.Object r4 = r11.L$1
            java.util.Iterator r4 = (java.util.Iterator) r4
            java.lang.Object r5 = r11.L$0
            java.util.List r5 = (java.util.List) r5
            kotlin.ResultKt.throwOnFailure(r12)
            r6 = r5
            r5 = r4
            r4 = r1
            r1 = r0
            r0 = r11
            goto L_0x00dd
        L_0x0020:
            java.lang.IllegalStateException r12 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r12.<init>(r0)
            throw r12
        L_0x0028:
            kotlin.ResultKt.throwOnFailure(r12)
            java.util.ArrayList r12 = new java.util.ArrayList
            r12.<init>()
            java.util.List r12 = (java.util.List) r12
            java.util.List r1 = r11.$items
            java.lang.Iterable r1 = (java.lang.Iterable) r1
            java.util.Iterator r1 = r1.iterator()
            r5 = r12
            r4 = r1
            r1 = 0
            r12 = r11
        L_0x003e:
            boolean r6 = r4.hasNext()
            if (r6 == 0) goto L_0x00f2
            java.lang.Object r6 = r4.next()
            editor.mediaselection.items.MediaSelectionItem r6 = (editor.mediaselection.items.MediaSelectionItem) r6
            editor.mediaselection.MediaImportViewModel r7 = r12.this$0
            java.lang.StringBuilder r8 = new java.lang.StringBuilder
            r8.<init>()
            java.lang.String r9 = "Importing "
            r8.append(r9)
            int r9 = r1 + 1
            r8.append(r9)
            r9 = 47
            r8.append(r9)
            java.util.List r9 = r12.$items
            int r9 = r9.size()
            r8.append(r9)
            java.lang.String r9 = "..."
            r8.append(r9)
            java.lang.String r8 = r8.toString()
            r7.showBlockingProgress(r8)
            editor.mediaselection.MediaImportViewModel r7 = r12.this$0
            java.lang.String r8 = "0%"
            r7.updateBlockingProgress(r2, r8)
            boolean r7 = r6 instanceof editor.mediaselection.items.MediaSelectionItem.Paint
            if (r7 == 0) goto L_0x0082
            r6 = 0
            goto L_0x00c3
        L_0x0082:
            boolean r7 = r6 instanceof editor.mediaselection.items.MediaSelectionItem.Giphy
            if (r7 == 0) goto L_0x0093
            editor.mediaselection.MediaImportViewModel r7 = r12.this$0
            editor.mediaselection.items.MediaSelectionItem$Giphy r6 = (editor.mediaselection.items.MediaSelectionItem.Giphy) r6
            com.memes.network.giphy.api.model.GiphyGif r6 = r6.getGiphyGif()
            com.memes.commons.media.MediaContent r6 = r7.createMediaContent((com.memes.network.giphy.api.model.GiphyGif) r6)
            goto L_0x00c3
        L_0x0093:
            boolean r7 = r6 instanceof editor.mediaselection.items.MediaSelectionItem.Meme
            if (r7 == 0) goto L_0x00a4
            editor.mediaselection.MediaImportViewModel r7 = r12.this$0
            editor.mediaselection.items.MediaSelectionItem$Meme r6 = (editor.mediaselection.items.MediaSelectionItem.Meme) r6
            com.memes.network.memes.api.model.stockmemes.StockMeme r6 = r6.getStockMeme()
            com.memes.commons.media.MediaContent r6 = r7.createMediaContent((com.memes.network.memes.api.model.stockmemes.StockMeme) r6)
            goto L_0x00c3
        L_0x00a4:
            boolean r7 = r6 instanceof editor.mediaselection.items.MediaSelectionItem.Reddit
            if (r7 == 0) goto L_0x00b5
            editor.mediaselection.MediaImportViewModel r7 = r12.this$0
            editor.mediaselection.items.MediaSelectionItem$Reddit r6 = (editor.mediaselection.items.MediaSelectionItem.Reddit) r6
            com.memes.network.reddit.api.model.RedditPost r6 = r6.getRedditPost()
            com.memes.commons.media.MediaContent r6 = r7.createMediaContent((com.memes.network.reddit.api.model.RedditPost) r6)
            goto L_0x00c3
        L_0x00b5:
            boolean r7 = r6 instanceof editor.mediaselection.items.MediaSelectionItem.LocalContent
            if (r7 == 0) goto L_0x00ec
            editor.mediaselection.items.MediaSelectionItem$LocalContent r6 = (editor.mediaselection.items.MediaSelectionItem.LocalContent) r6
            editor.mediaselection.localmedia.IdBasedMedia r6 = r6.getIdBasedMedia()
            com.memes.commons.media.MediaContent r6 = r6.getContent()
        L_0x00c3:
            if (r6 == 0) goto L_0x00e9
            editor.mediaselection.MediaImportViewModel r7 = r12.this$0
            r12.L$0 = r5
            r12.L$1 = r4
            r12.I$0 = r1
            r12.label = r3
            java.lang.Object r6 = r7.download(r6, r12)
            if (r6 != r0) goto L_0x00d6
            return r0
        L_0x00d6:
            r10 = r0
            r0 = r12
            r12 = r6
            r6 = r5
            r5 = r4
            r4 = r1
            r1 = r10
        L_0x00dd:
            com.memes.commons.media.MediaContent r12 = (com.memes.commons.media.MediaContent) r12
            if (r12 == 0) goto L_0x00e4
            r6.add(r12)
        L_0x00e4:
            r12 = r0
            r0 = r1
            r1 = r4
            r4 = r5
            r5 = r6
        L_0x00e9:
            int r1 = r1 + r3
            goto L_0x003e
        L_0x00ec:
            kotlin.NoWhenBranchMatchedException r12 = new kotlin.NoWhenBranchMatchedException
            r12.<init>()
            throw r12
        L_0x00f2:
            editor.mediaselection.MediaImportViewModel r0 = r12.this$0
            r0.hideBlockingProgress()
            editor.mediaselection.MediaImportViewModel r12 = r12.this$0
            androidx.lifecycle.MutableLiveData r12 = r12._contentsDownloaded
            r12.setValue(r5)
            kotlin.Unit r12 = kotlin.Unit.INSTANCE
            return r12
        */
        throw new UnsupportedOperationException("Method not decompiled: editor.mediaselection.MediaImportViewModel$importItems$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
