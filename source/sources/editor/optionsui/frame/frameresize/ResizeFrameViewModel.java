package editor.optionsui.frame.frameresize;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModelKt;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.memes.commons.util.SingleLiveEvent;
import editor.common.assetsprovider.AssetsProvider;
import editor.core.NicoViewModel;
import editor.editor.equipment.frame.FrameStyle;
import editor.editor.equipment.property.FrameProperty;
import editor.optionsui.OnPropertyUpdatedListener;
import editor.optionsui.frame.frameresize.ResizeFrameItem;
import java.util.ArrayList;
import java.util.Iterator;
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

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010!\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\b\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u000e\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0007J\f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00070\u0018J\u000e\u0010\u0019\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0007J\u0012\u0010\u001a\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000b0\n0\u0018J\f\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\r0\u0018J\u000e\u0010\u001c\u001a\u00020\u00152\u0006\u0010\u001d\u001a\u00020\u0011J\u000e\u0010\u001e\u001a\u00020\u00152\u0006\u0010\u001f\u001a\u00020 R\u0014\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006X\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000b0\n0\tX\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\f\u001a\b\u0012\u0004\u0012\u00020\r0\tX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u000b0\u000fX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X.¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X\u000e¢\u0006\u0002\n\u0000¨\u0006!"}, mo26107d2 = {"Leditor/optionsui/frame/frameresize/ResizeFrameViewModel;", "Leditor/core/NicoViewModel;", "assetsProvider", "Leditor/common/assetsprovider/AssetsProvider;", "(Leditor/common/assetsprovider/AssetsProvider;)V", "_customFrameSizeInput", "Lcom/memes/commons/util/SingleLiveEvent;", "Leditor/optionsui/frame/frameresize/FrameSize;", "_resizeFrameItems", "Landroidx/lifecycle/MutableLiveData;", "", "Leditor/optionsui/frame/frameresize/ResizeFrameItem;", "_selectedFrameRatio", "", "frameSizeItems", "", "propertyUpdatedListener", "Leditor/optionsui/OnPropertyUpdatedListener;", "shouldPromptCustomFrameSizeInput", "", "applyCustomFrameSize", "", "frameSize", "onCustomFrameSizeInputRequested", "Landroidx/lifecycle/LiveData;", "onFrameSizeSelected", "resizeFrameItems", "selectedFrameRatio", "setOnPropertyUpdatedListener", "listener", "setStyle", "style", "Leditor/editor/equipment/frame/FrameStyle;", "editor_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
/* compiled from: ResizeFrameViewModel.kt */
public final class ResizeFrameViewModel extends NicoViewModel {
    private final SingleLiveEvent<FrameSize> _customFrameSizeInput = new SingleLiveEvent<>();
    /* access modifiers changed from: private */
    public final MutableLiveData<List<ResizeFrameItem>> _resizeFrameItems = new MutableLiveData<>();
    private final MutableLiveData<Float> _selectedFrameRatio = new MutableLiveData<>();
    /* access modifiers changed from: private */
    public final AssetsProvider assetsProvider;
    /* access modifiers changed from: private */
    public final List<ResizeFrameItem> frameSizeItems = new ArrayList();
    private OnPropertyUpdatedListener propertyUpdatedListener;
    private boolean shouldPromptCustomFrameSizeInput;

    public ResizeFrameViewModel(AssetsProvider assetsProvider2) {
        Intrinsics.checkNotNullParameter(assetsProvider2, "assetsProvider");
        this.assetsProvider = assetsProvider2;
        Job unused = BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), (CoroutineContext) null, (CoroutineStart) null, new C48471(this, (Continuation) null), 3, (Object) null);
    }

    public final LiveData<List<ResizeFrameItem>> resizeFrameItems() {
        return this._resizeFrameItems;
    }

    public final LiveData<Float> selectedFrameRatio() {
        return this._selectedFrameRatio;
    }

    public final LiveData<FrameSize> onCustomFrameSizeInputRequested() {
        return this._customFrameSizeInput;
    }

    @Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H@¢\u0006\u0004\b\u0003\u0010\u0004"}, mo26107d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;"}, mo26108k = 3, mo26109mv = {1, 4, 2})
    @DebugMetadata(mo26807c = "editor.optionsui.frame.frameresize.ResizeFrameViewModel$1", mo26808f = "ResizeFrameViewModel.kt", mo26809i = {}, mo26810l = {54}, mo26811m = "invokeSuspend", mo26812n = {}, mo26813s = {})
    /* renamed from: editor.optionsui.frame.frameresize.ResizeFrameViewModel$1 */
    /* compiled from: ResizeFrameViewModel.kt */
    static final class C48471 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;
        final /* synthetic */ ResizeFrameViewModel this$0;

        {
            this.this$0 = r1;
        }

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            Intrinsics.checkNotNullParameter(continuation, "completion");
            return new C48471(this.this$0, continuation);
        }

        public final Object invoke(Object obj, Object obj2) {
            return ((C48471) create(obj, (Continuation) obj2)).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                this.this$0.frameSizeItems.clear();
                this.this$0.frameSizeItems.add(new ResizeFrameItem.Preview(new FrameSize("Original", 4.0f, 5.0f, FrameSizeType.ORIGINAL, (String) null, 16, (DefaultConstructorMarker) null)));
                this.this$0.frameSizeItems.add(ResizeFrameItem.Divider.INSTANCE);
                this.this$0.frameSizeItems.add(new ResizeFrameItem.Preview(FrameSize.Companion.getDEFAULT_CUSTOM_FRAME_SIZE()));
                this.label = 1;
                obj = BuildersKt.withContext(Dispatchers.getIO(), new ResizeFrameViewModel$1$sizes$1(this, (Continuation) null), this);
                if (obj == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else if (i == 1) {
                ResultKt.throwOnFailure(obj);
            } else {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            this.this$0.frameSizeItems.addAll((List) obj);
            this.this$0._resizeFrameItems.setValue(this.this$0.frameSizeItems);
            return Unit.INSTANCE;
        }
    }

    public final void setStyle(FrameStyle frameStyle) {
        Intrinsics.checkNotNullParameter(frameStyle, "style");
        this._selectedFrameRatio.setValue(Float.valueOf(frameStyle.getAspectRatio()));
    }

    public final void setOnPropertyUpdatedListener(OnPropertyUpdatedListener onPropertyUpdatedListener) {
        Intrinsics.checkNotNullParameter(onPropertyUpdatedListener, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
        this.propertyUpdatedListener = onPropertyUpdatedListener;
    }

    public final void applyCustomFrameSize(FrameSize frameSize) {
        Intrinsics.checkNotNullParameter(frameSize, "frameSize");
        if (frameSize.getType() == FrameSizeType.CUSTOM) {
            Iterator<ResizeFrameItem> it = this.frameSizeItems.iterator();
            int i = 0;
            while (true) {
                if (!it.hasNext()) {
                    i = -1;
                    break;
                }
                ResizeFrameItem next = it.next();
                if ((next instanceof ResizeFrameItem.Preview) && ((ResizeFrameItem.Preview) next).getSize().getType() == FrameSizeType.CUSTOM) {
                    break;
                }
                i++;
            }
            if (i == -1 || i >= this.frameSizeItems.size()) {
                throw new RuntimeException("Custom Frame Size index is out of range. index=" + i);
            }
            this.frameSizeItems.set(i, new ResizeFrameItem.Preview(frameSize));
            this._resizeFrameItems.setValue(this.frameSizeItems);
            this._selectedFrameRatio.setValue(Float.valueOf(frameSize.ratio()));
            FrameProperty.AspectRatio aspectRatio = new FrameProperty.AspectRatio(frameSize.ratio());
            OnPropertyUpdatedListener onPropertyUpdatedListener = this.propertyUpdatedListener;
            if (onPropertyUpdatedListener == null) {
                Intrinsics.throwUninitializedPropertyAccessException("propertyUpdatedListener");
            }
            onPropertyUpdatedListener.onPropertyUpdated(aspectRatio);
            return;
        }
        throw new RuntimeException("Only Custom Frame Sizes can be modified, " + "failure while trying to modify frame size with type=" + frameSize.getType());
    }

    public final void onFrameSizeSelected(FrameSize frameSize) {
        Intrinsics.checkNotNullParameter(frameSize, "frameSize");
        float ratio = frameSize.ratio();
        this._selectedFrameRatio.setValue(Float.valueOf(ratio));
        FrameProperty.AspectRatio aspectRatio = new FrameProperty.AspectRatio(ratio);
        OnPropertyUpdatedListener onPropertyUpdatedListener = this.propertyUpdatedListener;
        if (onPropertyUpdatedListener == null) {
            Intrinsics.throwUninitializedPropertyAccessException("propertyUpdatedListener");
        }
        onPropertyUpdatedListener.onPropertyUpdated(aspectRatio);
        if (frameSize.getType() != FrameSizeType.CUSTOM) {
            this.shouldPromptCustomFrameSizeInput = false;
        } else if (frameSize.isDefaultCustomSize() || this.shouldPromptCustomFrameSizeInput) {
            this._customFrameSizeInput.setValue(frameSize);
        } else {
            this.shouldPromptCustomFrameSizeInput = true;
        }
    }
}
