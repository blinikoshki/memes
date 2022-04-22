package editor.optionsui.layerpaint.pattern;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModelKt;
import editor.common.assetsprovider.AssetsProvider;
import editor.core.NicoViewModel;
import editor.optionsui.layerpaint.LayerPaint;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0010\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\bJ\u0017\u0010\r\u001a\b\u0012\u0004\u0012\u00020\b0\u0007H@ø\u0001\u0000¢\u0006\u0002\u0010\u000eJ\u0012\u0010\u000f\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00070\u0010J\u000e\u0010\u0011\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\b0\u0010R\u001a\u0010\u0005\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00070\u0006X\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\t\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\b0\u0006X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000\u0002\u0004\n\u0002\b\u0019¨\u0006\u0012"}, mo26107d2 = {"Leditor/optionsui/layerpaint/pattern/PatternsViewModel;", "Leditor/core/NicoViewModel;", "assetsProvider", "Leditor/common/assetsprovider/AssetsProvider;", "(Leditor/common/assetsprovider/AssetsProvider;)V", "_patternsAvailable", "Landroidx/lifecycle/MutableLiveData;", "", "Leditor/optionsui/layerpaint/LayerPaint$Pattern;", "_selectedPatternChanged", "changeSelectedPatternPaint", "", "paint", "fetchPatterns", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "onPatternsAvailable", "Landroidx/lifecycle/LiveData;", "onSelectedPatternChanged", "editor_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
/* compiled from: PatternsViewModel.kt */
public final class PatternsViewModel extends NicoViewModel {
    /* access modifiers changed from: private */
    public final MutableLiveData<List<LayerPaint.Pattern>> _patternsAvailable = new MutableLiveData<>();
    private final MutableLiveData<LayerPaint.Pattern> _selectedPatternChanged = new MutableLiveData<>();
    /* access modifiers changed from: private */
    public final AssetsProvider assetsProvider;

    public PatternsViewModel(AssetsProvider assetsProvider2) {
        Intrinsics.checkNotNullParameter(assetsProvider2, "assetsProvider");
        this.assetsProvider = assetsProvider2;
        Job unused = BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), (CoroutineContext) null, (CoroutineStart) null, new C48581(this, (Continuation) null), 3, (Object) null);
    }

    public final LiveData<List<LayerPaint.Pattern>> onPatternsAvailable() {
        return this._patternsAvailable;
    }

    public final LiveData<LayerPaint.Pattern> onSelectedPatternChanged() {
        return this._selectedPatternChanged;
    }

    @Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H@¢\u0006\u0004\b\u0003\u0010\u0004"}, mo26107d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;"}, mo26108k = 3, mo26109mv = {1, 4, 2})
    @DebugMetadata(mo26807c = "editor.optionsui.layerpaint.pattern.PatternsViewModel$1", mo26808f = "PatternsViewModel.kt", mo26809i = {}, mo26810l = {28}, mo26811m = "invokeSuspend", mo26812n = {}, mo26813s = {})
    /* renamed from: editor.optionsui.layerpaint.pattern.PatternsViewModel$1 */
    /* compiled from: PatternsViewModel.kt */
    static final class C48581 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        Object L$0;
        int label;
        final /* synthetic */ PatternsViewModel this$0;

        {
            this.this$0 = r1;
        }

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            Intrinsics.checkNotNullParameter(continuation, "completion");
            return new C48581(this.this$0, continuation);
        }

        public final Object invoke(Object obj, Object obj2) {
            return ((C48581) create(obj, (Continuation) obj2)).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object obj) {
            MutableLiveData mutableLiveData;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                MutableLiveData access$get_patternsAvailable$p = this.this$0._patternsAvailable;
                PatternsViewModel patternsViewModel = this.this$0;
                this.L$0 = access$get_patternsAvailable$p;
                this.label = 1;
                Object fetchPatterns = patternsViewModel.fetchPatterns(this);
                if (fetchPatterns == coroutine_suspended) {
                    return coroutine_suspended;
                }
                mutableLiveData = access$get_patternsAvailable$p;
                obj = fetchPatterns;
            } else if (i == 1) {
                mutableLiveData = (MutableLiveData) this.L$0;
                ResultKt.throwOnFailure(obj);
            } else {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            mutableLiveData.setValue(obj);
            return Unit.INSTANCE;
        }
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ Object fetchPatterns(Continuation<? super List<LayerPaint.Pattern>> continuation) {
        return BuildersKt.withContext(Dispatchers.getIO(), new PatternsViewModel$fetchPatterns$2(this, (Continuation) null), continuation);
    }

    public final void changeSelectedPatternPaint(LayerPaint.Pattern pattern) {
        this._selectedPatternChanged.setValue(pattern);
    }
}
