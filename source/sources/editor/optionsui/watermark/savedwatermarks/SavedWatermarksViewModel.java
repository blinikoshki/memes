package editor.optionsui.watermark.savedwatermarks;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModelKt;
import com.memes.commons.output.OutputTargetGenerator;
import com.memes.commons.util.SingleLiveEvent;
import editor.contentport.ContentPortUtil;
import editor.core.NicoViewModel;
import editor.custom.liveevent.LiveEvent;
import editor.database.dao.SavedWatermarksDao;
import editor.editor.equipment.core.CoreEntity;
import editor.editor.equipment.frame.FrameEntity;
import editor.optionsui.watermark.Watermark;
import editor.util.rules.RuleFailedException;
import editor.util.rules.musthavefreespace.MustHaveFreeSpaceRule;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
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
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineExceptionHandler;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;
import org.apache.commons.lang3.ClassUtils;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010!\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0003\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0000\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u000e\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\nJ\u0010\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u001fH\u0002J\u0012\u0010 \u001a\u00020\u001d2\b\u0010!\u001a\u0004\u0018\u00010\"H\u0002J\u000e\u0010#\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\nJ\u0010\u0010$\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\nH\u0002J\u0012\u0010%\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\f0&J\u0012\u0010'\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\f0&J\u0012\u0010(\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\f0&J\"\u0010)\u001a\u00020\u001a2\u0006\u0010*\u001a\u00020+2\u0012\u0010,\u001a\u000e\u0012\u0002\b\u0003\u0012\u0002\b\u00030-j\u0002`.J\u0012\u0010/\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\t0&R\u001a\u0010\u0007\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\t0\bX\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u000b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\f0\bX\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\r\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\f0\bX\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u000e\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\f0\bX\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\n0\u0010X\u0004¢\u0006\u0002\n\u0000R\u001b\u0010\u0011\u001a\u00020\u00128BX\u0002¢\u0006\f\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0013\u0010\u0014R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0018X\u0004¢\u0006\u0002\n\u0000¨\u00060"}, mo26107d2 = {"Leditor/optionsui/watermark/savedwatermarks/SavedWatermarksViewModel;", "Leditor/core/NicoViewModel;", "savedWatermarksDao", "Leditor/database/dao/SavedWatermarksDao;", "outputTargetGenerator", "Lcom/memes/commons/output/OutputTargetGenerator;", "(Leditor/database/dao/SavedWatermarksDao;Lcom/memes/commons/output/OutputTargetGenerator;)V", "_savedWatermarks", "Lcom/memes/commons/util/SingleLiveEvent;", "", "Leditor/optionsui/watermark/Watermark;", "_watermarkDeleted", "Leditor/custom/liveevent/LiveEvent;", "_watermarkImportLiveData", "_watermarkSaved", "availableWatermarks", "", "portUtil", "Leditor/contentport/ContentPortUtil;", "getPortUtil", "()Leditor/contentport/ContentPortUtil;", "portUtil$delegate", "Lkotlin/Lazy;", "watermarkExceptionHandler", "Lkotlinx/coroutines/CoroutineExceptionHandler;", "deleteWatermark", "", "watermark", "handleFailedRule", "", "exception", "Leditor/util/rules/RuleFailedException;", "handleWatermarksException", "throwable", "", "importWatermark", "notifyWatermarkSaved", "onWatermarkDeleted", "Landroidx/lifecycle/LiveData;", "onWatermarkImportRequested", "onWatermarkSaved", "saveWatermark", "frameEntity", "Leditor/editor/equipment/frame/FrameEntity;", "entity", "Leditor/editor/equipment/core/CoreEntity;", "Leditor/util/TypedCoreEntity;", "savedWatermarks", "editor_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
/* compiled from: SavedWatermarksViewModel.kt */
public final class SavedWatermarksViewModel extends NicoViewModel {
    /* access modifiers changed from: private */
    public final SingleLiveEvent<List<Watermark>> _savedWatermarks = new SingleLiveEvent<>();
    /* access modifiers changed from: private */
    public final SingleLiveEvent<LiveEvent<Watermark>> _watermarkDeleted = new SingleLiveEvent<>();
    /* access modifiers changed from: private */
    public final SingleLiveEvent<LiveEvent<Watermark>> _watermarkImportLiveData = new SingleLiveEvent<>();
    private final SingleLiveEvent<LiveEvent<Watermark>> _watermarkSaved = new SingleLiveEvent<>();
    /* access modifiers changed from: private */
    public final List<Watermark> availableWatermarks = new ArrayList();
    private final Lazy portUtil$delegate;
    /* access modifiers changed from: private */
    public final SavedWatermarksDao savedWatermarksDao;
    private final CoroutineExceptionHandler watermarkExceptionHandler;

    /* access modifiers changed from: private */
    public final ContentPortUtil getPortUtil() {
        return (ContentPortUtil) this.portUtil$delegate.getValue();
    }

    public SavedWatermarksViewModel(SavedWatermarksDao savedWatermarksDao2, OutputTargetGenerator outputTargetGenerator) {
        Intrinsics.checkNotNullParameter(savedWatermarksDao2, "savedWatermarksDao");
        Intrinsics.checkNotNullParameter(outputTargetGenerator, "outputTargetGenerator");
        this.savedWatermarksDao = savedWatermarksDao2;
        this.portUtil$delegate = LazyKt.lazy(new SavedWatermarksViewModel$portUtil$2(outputTargetGenerator));
        this.watermarkExceptionHandler = new C4900x656529c(CoroutineExceptionHandler.Key, this);
        Job unused = BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), (CoroutineContext) null, (CoroutineStart) null, new C48981(this, (Continuation) null), 3, (Object) null);
    }

    public final LiveData<List<Watermark>> savedWatermarks() {
        return this._savedWatermarks;
    }

    public final LiveData<LiveEvent<Watermark>> onWatermarkImportRequested() {
        return this._watermarkImportLiveData;
    }

    public final LiveData<LiveEvent<Watermark>> onWatermarkSaved() {
        return this._watermarkSaved;
    }

    public final LiveData<LiveEvent<Watermark>> onWatermarkDeleted() {
        return this._watermarkDeleted;
    }

    @Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H@¢\u0006\u0004\b\u0003\u0010\u0004"}, mo26107d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;"}, mo26108k = 3, mo26109mv = {1, 4, 2})
    @DebugMetadata(mo26807c = "editor.optionsui.watermark.savedwatermarks.SavedWatermarksViewModel$1", mo26808f = "SavedWatermarksViewModel.kt", mo26809i = {}, mo26810l = {63}, mo26811m = "invokeSuspend", mo26812n = {}, mo26813s = {})
    /* renamed from: editor.optionsui.watermark.savedwatermarks.SavedWatermarksViewModel$1 */
    /* compiled from: SavedWatermarksViewModel.kt */
    static final class C48981 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;
        final /* synthetic */ SavedWatermarksViewModel this$0;

        {
            this.this$0 = r1;
        }

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            Intrinsics.checkNotNullParameter(continuation, "completion");
            return new C48981(this.this$0, continuation);
        }

        public final Object invoke(Object obj, Object obj2) {
            return ((C48981) create(obj, (Continuation) obj2)).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                this.label = 1;
                if (BuildersKt.withContext(Dispatchers.getIO(), new Function2<CoroutineScope, Continuation<? super Boolean>, Object>(this, (Continuation) null) {
                    int label;
                    final /* synthetic */ C48981 this$0;

                    {
                        this.this$0 = r1;
                    }

                    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                        Intrinsics.checkNotNullParameter(continuation, "completion");
                        return 

                        public final void saveWatermark(FrameEntity frameEntity, CoreEntity<?, ?> coreEntity) {
                            Intrinsics.checkNotNullParameter(frameEntity, "frameEntity");
                            Intrinsics.checkNotNullParameter(coreEntity, "entity");
                            if (coreEntity.isWatermark()) {
                                Job unused = BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), this.watermarkExceptionHandler, (CoroutineStart) null, new SavedWatermarksViewModel$saveWatermark$1(this, frameEntity, coreEntity, (Continuation) null), 2, (Object) null);
                                return;
                            }
                            throw new RuntimeException("This entity is not a watermark, entity=" + coreEntity + ClassUtils.PACKAGE_SEPARATOR_CHAR);
                        }

                        /* access modifiers changed from: private */
                        public final void notifyWatermarkSaved(Watermark watermark) {
                            this._watermarkSaved.setValue(new LiveEvent(watermark));
                            Iterator<Watermark> it = this.availableWatermarks.iterator();
                            int i = 0;
                            while (true) {
                                if (!it.hasNext()) {
                                    i = -1;
                                    break;
                                } else if (Intrinsics.areEqual((Object) it.next().getUid(), (Object) watermark.getUid())) {
                                    break;
                                } else {
                                    i++;
                                }
                            }
                            if (i == -1) {
                                this.availableWatermarks.add(0, watermark);
                            } else {
                                this.availableWatermarks.set(i, watermark);
                            }
                            this._savedWatermarks.setValue(this.availableWatermarks);
                        }

                        public final void importWatermark(Watermark watermark) {
                            Intrinsics.checkNotNullParameter(watermark, "watermark");
                            Job unused = BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), this.watermarkExceptionHandler, (CoroutineStart) null, new SavedWatermarksViewModel$importWatermark$1(this, watermark, (Continuation) null), 2, (Object) null);
                        }

                        public final void deleteWatermark(Watermark watermark) {
                            Intrinsics.checkNotNullParameter(watermark, "watermark");
                            Job unused = BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), (CoroutineContext) null, (CoroutineStart) null, new SavedWatermarksViewModel$deleteWatermark$1(this, watermark, (Continuation) null), 3, (Object) null);
                        }

                        /* access modifiers changed from: private */
                        public final boolean handleWatermarksException(Throwable th) {
                            if (th instanceof RuleFailedException) {
                                return handleFailedRule((RuleFailedException) th);
                            }
                            return false;
                        }

                        private final boolean handleFailedRule(RuleFailedException ruleFailedException) {
                            boolean z = false;
                            if (!(ruleFailedException.getFailedRule() instanceof MustHaveFreeSpaceRule)) {
                                return false;
                            }
                            StringBuilder sb = new StringBuilder();
                            sb.append("The watermark cannot be saved or imported because of low storage space.");
                            Intrinsics.checkNotNullExpressionValue(sb, "append(value)");
                            sb.append(10);
                            Intrinsics.checkNotNullExpressionValue(sb, "append('\\n')");
                            CharSequence message = ruleFailedException.getMessage();
                            if (message == null || StringsKt.isBlank(message)) {
                                z = true;
                            }
                            if (!z) {
                                sb.append(10);
                                Intrinsics.checkNotNullExpressionValue(sb, "append('\\n')");
                                sb.append(ruleFailedException.getMessage());
                            }
                            String sb2 = sb.toString();
                            Intrinsics.checkNotNullExpressionValue(sb2, "StringBuilder().apply(builderAction).toString()");
                            showErrorOnBlockingProgress(sb2);
                            return true;
                        }
                    }
