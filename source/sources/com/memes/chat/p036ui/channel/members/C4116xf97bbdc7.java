package com.memes.chat.p036ui.channel.members;

import com.memes.chat.util.extensions.ExtensionsKt;
import com.memes.commons.recycleradapter.AdapterUpdate;
import java.util.List;
import kotlin.Metadata;
import kotlin.coroutines.AbstractCoroutineContextElement;
import kotlin.coroutines.CoroutineContext;
import kotlinx.coroutines.CoroutineExceptionHandler;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000!\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0003\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u00012\u00020\u0002J\u0018\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0016¨\u0006\t¸\u0006\u0000"}, mo26107d2 = {"kotlinx/coroutines/CoroutineExceptionHandlerKt$CoroutineExceptionHandler$1", "Lkotlin/coroutines/AbstractCoroutineContextElement;", "Lkotlinx/coroutines/CoroutineExceptionHandler;", "handleException", "", "context", "Lkotlin/coroutines/CoroutineContext;", "exception", "", "kotlinx-coroutines-core"}, mo26108k = 1, mo26109mv = {1, 4, 2})
/* renamed from: com.memes.chat.ui.channel.members.ChannelMembersViewModel$_membersExceptionHandler$2$$special$$inlined$CoroutineExceptionHandler$1 */
/* compiled from: CoroutineExceptionHandler.kt */
public final class C4116xf97bbdc7 extends AbstractCoroutineContextElement implements CoroutineExceptionHandler {
    final /* synthetic */ ChannelMembersViewModel$_membersExceptionHandler$2 this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public C4116xf97bbdc7(CoroutineContext.Key key, ChannelMembersViewModel$_membersExceptionHandler$2 channelMembersViewModel$_membersExceptionHandler$2) {
        super(key);
        this.this$0 = channelMembersViewModel$_membersExceptionHandler$2;
    }

    public void handleException(CoroutineContext coroutineContext, Throwable th) {
        this.this$0.this$0._channelMembers.setValue(new AdapterUpdate(0, (List) null));
        this.this$0.this$0.showError(this.this$0.this$0._channelMembersContentVisibility, ExtensionsKt.getErrorMessage(th));
    }
}
