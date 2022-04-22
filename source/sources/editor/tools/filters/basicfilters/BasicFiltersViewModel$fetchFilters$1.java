package editor.tools.filters.basicfilters;

import androidx.lifecycle.MutableLiveData;
import editor.gpu.conflation.filters.basic.NChromeConflatedFilter;
import editor.gpu.conflation.filters.basic.NCinematicConflatedFilter;
import editor.gpu.conflation.filters.basic.NCoolConflatedFilter;
import editor.gpu.conflation.filters.basic.NGrittyConflatedFilter;
import editor.gpu.conflation.filters.basic.NHalftoneConflatedFilter;
import editor.gpu.conflation.filters.basic.NInstantConflatedFilter;
import editor.gpu.conflation.filters.basic.NMonoConflatedFilter;
import editor.gpu.conflation.filters.basic.NNormalConflatedFilter;
import editor.gpu.conflation.filters.basic.NPopRocketConflatedFilter;
import editor.gpu.conflation.filters.basic.NTonaConflatedFilter;
import editor.gpu.conflation.filters.basic.NWarmConflatedFilter;
import editor.tools.filters.basicfilters.BasicFilter;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H@¢\u0006\u0004\b\u0003\u0010\u0004"}, mo26107d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;"}, mo26108k = 3, mo26109mv = {1, 4, 2})
@DebugMetadata(mo26807c = "editor.tools.filters.basicfilters.BasicFiltersViewModel$fetchFilters$1", mo26808f = "BasicFiltersViewModel.kt", mo26809i = {}, mo26810l = {45}, mo26811m = "invokeSuspend", mo26812n = {}, mo26813s = {})
/* compiled from: BasicFiltersViewModel.kt */
final class BasicFiltersViewModel$fetchFilters$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    Object L$0;
    int label;
    final /* synthetic */ BasicFiltersViewModel this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    BasicFiltersViewModel$fetchFilters$1(BasicFiltersViewModel basicFiltersViewModel, Continuation continuation) {
        super(2, continuation);
        this.this$0 = basicFiltersViewModel;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        Intrinsics.checkNotNullParameter(continuation, "completion");
        return new BasicFiltersViewModel$fetchFilters$1(this.this$0, continuation);
    }

    public final Object invoke(Object obj, Object obj2) {
        return ((BasicFiltersViewModel$fetchFilters$1) create(obj, (Continuation) obj2)).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        MutableLiveData mutableLiveData;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            MutableLiveData access$get_filters$p = this.this$0._filters;
            this.L$0 = access$get_filters$p;
            this.label = 1;
            Object withContext = BuildersKt.withContext(Dispatchers.getIO(), new C49231((Continuation) null), this);
            if (withContext == coroutine_suspended) {
                return coroutine_suspended;
            }
            mutableLiveData = access$get_filters$p;
            obj = withContext;
        } else if (i == 1) {
            mutableLiveData = (MutableLiveData) this.L$0;
            ResultKt.throwOnFailure(obj);
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        mutableLiveData.setValue(obj);
        return Unit.INSTANCE;
    }

    @Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\u0003H@¢\u0006\u0004\b\u0004\u0010\u0005"}, mo26107d2 = {"<anonymous>", "", "Leditor/tools/filters/basicfilters/BasicFilter;", "Lkotlinx/coroutines/CoroutineScope;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;"}, mo26108k = 3, mo26109mv = {1, 4, 2})
    @DebugMetadata(mo26807c = "editor.tools.filters.basicfilters.BasicFiltersViewModel$fetchFilters$1$1", mo26808f = "BasicFiltersViewModel.kt", mo26809i = {}, mo26810l = {}, mo26811m = "invokeSuspend", mo26812n = {}, mo26813s = {})
    /* renamed from: editor.tools.filters.basicfilters.BasicFiltersViewModel$fetchFilters$1$1 */
    /* compiled from: BasicFiltersViewModel.kt */
    static final class C49231 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super List<? extends BasicFilter>>, Object> {
        int label;

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            Intrinsics.checkNotNullParameter(continuation, "completion");
            return new C49231(continuation);
        }

        public final Object invoke(Object obj, Object obj2) {
            return ((C49231) create(obj, (Continuation) obj2)).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label == 0) {
                ResultKt.throwOnFailure(obj);
                return CollectionsKt.listOf(new BasicFilter.Preview(new NNormalConflatedFilter()), BasicFilter.Divider.INSTANCE, new BasicFilter.Preview(new NHalftoneConflatedFilter()), new BasicFilter.Preview(new NPopRocketConflatedFilter()), new BasicFilter.Preview(new NCoolConflatedFilter()), new BasicFilter.Preview(new NGrittyConflatedFilter()), new BasicFilter.Preview(new NTonaConflatedFilter()), new BasicFilter.Preview(new NWarmConflatedFilter()), new BasicFilter.Preview(new NMonoConflatedFilter()), new BasicFilter.Preview(new NCinematicConflatedFilter()), new BasicFilter.Preview(new NChromeConflatedFilter()), new BasicFilter.Preview(new NInstantConflatedFilter()));
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }
}
