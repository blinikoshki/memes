package com.memes.network.chat.source.remote;

import java.io.File;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\u001e\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u00062\u0012\u0010\u0007\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\t0\bH@"}, mo26107d2 = {"uploadPhotoFile", "", "userId", "", "userToken", "file", "Ljava/io/File;", "continuation", "Lkotlin/coroutines/Continuation;", "Lcom/memes/network/core/UniversalResult;"}, mo26108k = 3, mo26109mv = {1, 4, 2})
@DebugMetadata(mo26807c = "com.memes.network.chat.source.remote.RemoteChatDataSource", mo26808f = "RemoteChatDataSource.kt", mo26809i = {0, 0, 1, 1, 2}, mo26810l = {41, 71, 106}, mo26811m = "uploadPhotoFile", mo26812n = {"this", "file", "this", "file", "fileAccessUrl"}, mo26813s = {"L$0", "L$1", "L$0", "L$1", "L$0"})
/* compiled from: RemoteChatDataSource.kt */
final class RemoteChatDataSource$uploadPhotoFile$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ RemoteChatDataSource this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    RemoteChatDataSource$uploadPhotoFile$1(RemoteChatDataSource remoteChatDataSource, Continuation continuation) {
        super(continuation);
        this.this$0 = remoteChatDataSource;
    }

    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.uploadPhotoFile((String) null, (String) null, (File) null, this);
    }
}
