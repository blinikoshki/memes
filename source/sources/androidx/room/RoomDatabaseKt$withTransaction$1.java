package androidx.room;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.functions.Function1;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\u0018\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u0004\u0018\u00010\u0001\"\u0004\b\u0000\u0010\u0002*\u00020\u00032\u001c\u0010\u0004\u001a\u0018\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00020\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u00052\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0006H@"}, mo26107d2 = {"withTransaction", "", "R", "Landroidx/room/RoomDatabase;", "block", "Lkotlin/Function1;", "Lkotlin/coroutines/Continuation;", "continuation"}, mo26108k = 3, mo26109mv = {1, 1, 15})
@DebugMetadata(mo26807c = "androidx.room.RoomDatabaseKt", mo26808f = "RoomDatabase.kt", mo26809i = {0, 0, 1, 1, 1}, mo26810l = {50, 51}, mo26811m = "withTransaction", mo26812n = {"$this$withTransaction", "block", "$this$withTransaction", "block", "transactionContext"}, mo26813s = {"L$0", "L$1", "L$0", "L$1", "L$2"})
/* compiled from: RoomDatabase.kt */
final class RoomDatabaseKt$withTransaction$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    Object L$2;
    int label;
    /* synthetic */ Object result;

    RoomDatabaseKt$withTransaction$1(Continuation continuation) {
        super(continuation);
    }

    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return RoomDatabaseKt.withTransaction((RoomDatabase) null, (Function1) null, this);
    }
}
