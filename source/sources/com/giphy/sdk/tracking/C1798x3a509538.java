package com.giphy.sdk.tracking;

import com.giphy.sdk.core.network.api.CompletionHandler;
import com.giphy.sdk.core.network.response.ListMediaResponse;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0003\n\u0000\u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\n¢\u0006\u0002\b\u0006"}, mo26107d2 = {"superComplete", "", "a", "Lcom/giphy/sdk/core/network/response/ListMediaResponse;", "g", "", "invoke"}, mo26108k = 3, mo26109mv = {1, 1, 13})
/* renamed from: com.giphy.sdk.tracking.CompletionHandlerExtensionKt$completionHandlerWithUserDictionary$1 */
/* compiled from: CompletionHandlerExtension.kt */
final class C1798x3a509538 extends Lambda implements Function2<ListMediaResponse, Throwable, Unit> {
    final /* synthetic */ CompletionHandler $this_completionHandlerWithUserDictionary;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    C1798x3a509538(CompletionHandler completionHandler) {
        super(2);
        this.$this_completionHandlerWithUserDictionary = completionHandler;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((ListMediaResponse) obj, (Throwable) obj2);
        return Unit.INSTANCE;
    }

    public final void invoke(ListMediaResponse listMediaResponse, Throwable th) {
        this.$this_completionHandlerWithUserDictionary.onComplete(listMediaResponse, th);
    }
}
