package com.memes.plus.work;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u00012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H@"}, mo26107d2 = {"doWork", "", "continuation", "Lkotlin/coroutines/Continuation;", "Landroidx/work/ListenableWorker$Result;"}, mo26108k = 3, mo26109mv = {1, 4, 2})
@DebugMetadata(mo26807c = "com.memes.plus.work.RegisterPurchaseWorker", mo26808f = "RegisterPurchaseWorker.kt", mo26809i = {}, mo26810l = {62}, mo26811m = "doWork", mo26812n = {}, mo26813s = {})
/* compiled from: RegisterPurchaseWorker.kt */
final class RegisterPurchaseWorker$doWork$1 extends ContinuationImpl {
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ RegisterPurchaseWorker this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    RegisterPurchaseWorker$doWork$1(RegisterPurchaseWorker registerPurchaseWorker, Continuation continuation) {
        super(continuation);
        this.this$0 = registerPurchaseWorker;
    }

    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.doWork(this);
    }
}
