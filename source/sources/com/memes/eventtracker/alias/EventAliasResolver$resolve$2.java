package com.memes.eventtracker.alias;

import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u0002H@¢\u0006\u0004\b\u0003\u0010\u0004"}, mo26107d2 = {"<anonymous>", "Lcom/memes/eventtracker/alias/EventAlias;", "Lkotlinx/coroutines/CoroutineScope;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;"}, mo26108k = 3, mo26109mv = {1, 4, 2})
@DebugMetadata(mo26807c = "com.memes.eventtracker.alias.EventAliasResolver$resolve$2", mo26808f = "EventAliasResolver.kt", mo26809i = {}, mo26810l = {}, mo26811m = "invokeSuspend", mo26812n = {}, mo26813s = {})
/* compiled from: EventAliasResolver.kt */
final class EventAliasResolver$resolve$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super EventAlias>, Object> {
    final /* synthetic */ String $eventId;
    int label;
    final /* synthetic */ EventAliasResolver this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    EventAliasResolver$resolve$2(EventAliasResolver eventAliasResolver, String str, Continuation continuation) {
        super(2, continuation);
        this.this$0 = eventAliasResolver;
        this.$eventId = str;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        Intrinsics.checkNotNullParameter(continuation, "completion");
        return new EventAliasResolver$resolve$2(this.this$0, this.$eventId, continuation);
    }

    public final Object invoke(Object obj, Object obj2) {
        return ((EventAliasResolver$resolve$2) create(obj, (Continuation) obj2)).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            if (this.this$0.aliases.isEmpty()) {
                List unused = this.this$0.fetchAliases();
            }
            for (EventAlias eventAlias : this.this$0.aliases) {
                if (eventAlias != null && Intrinsics.areEqual((Object) eventAlias.getId(), (Object) this.$eventId)) {
                    return eventAlias;
                }
            }
            return null;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
