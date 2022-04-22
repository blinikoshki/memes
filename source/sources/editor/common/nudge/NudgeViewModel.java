package editor.common.nudge;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelKt;
import com.memes.commons.util.SingleLiveEvent;
import editor.editor.equipment.property.NicoProperty;
import editor.editor.equipment.property.NicoPropertyBundle;
import java.util.List;
import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Job;
import timber.log.Timber;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\u000e\u001a\u00020\t2\u0006\u0010\u000f\u001a\u00020\u0010H\u0002J\u0006\u0010\u0011\u001a\u00020\u0012J\u001a\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u000f\u001a\u00020\u00102\b\b\u0002\u0010\u0014\u001a\u00020\u000bH\u0002J\u000e\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0015\u001a\u00020\u0016J\f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00050\u0018J\u000e\u0010\u0019\u001a\u00020\u00122\u0006\u0010\u001a\u001a\u00020\u001bR\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007XD¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u000bX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0005X.¢\u0006\u0002\n\u0000¨\u0006\u001c"}, mo26107d2 = {"Leditor/common/nudge/NudgeViewModel;", "Landroidx/lifecycle/ViewModel;", "()V", "_nudgeAction", "Lcom/memes/commons/util/SingleLiveEvent;", "Leditor/editor/equipment/property/NicoPropertyBundle;", "nudgeIntervalMillis", "", "nudgeJob", "Lkotlinx/coroutines/Job;", "nudgedX", "", "nudgedY", "propertyBundle", "createNudgeJob", "direction", "Leditor/common/nudge/NudgeDirection;", "discardChanges", "", "nudge", "nudgeAmount", "event", "Leditor/common/nudge/NudgeEvent;", "onNudged", "Landroidx/lifecycle/LiveData;", "setToken", "token", "", "editor_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
/* compiled from: NudgeViewModel.kt */
public final class NudgeViewModel extends ViewModel {
    /* access modifiers changed from: private */
    public final SingleLiveEvent<NicoPropertyBundle> _nudgeAction = new SingleLiveEvent<>();
    /* access modifiers changed from: private */
    public final long nudgeIntervalMillis = 200;
    private Job nudgeJob;
    /* access modifiers changed from: private */
    public float nudgedX;
    /* access modifiers changed from: private */
    public float nudgedY;
    /* access modifiers changed from: private */
    public NicoPropertyBundle propertyBundle;

    @Metadata(mo26105bv = {1, 0, 3}, mo26108k = 3, mo26109mv = {1, 4, 2})
    public final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;
        public static final /* synthetic */ int[] $EnumSwitchMapping$1;

        static {
            int[] iArr = new int[NudgeEvent.values().length];
            $EnumSwitchMapping$0 = iArr;
            iArr[NudgeEvent.SINGLE_PUSH.ordinal()] = 1;
            iArr[NudgeEvent.SESSION_BEGIN.ordinal()] = 2;
            iArr[NudgeEvent.IDLE.ordinal()] = 3;
            iArr[NudgeEvent.SESSION_END.ordinal()] = 4;
            int[] iArr2 = new int[NudgeDirection.values().length];
            $EnumSwitchMapping$1 = iArr2;
            iArr2[NudgeDirection.UP.ordinal()] = 1;
            iArr2[NudgeDirection.DOWN.ordinal()] = 2;
            iArr2[NudgeDirection.LEFT.ordinal()] = 3;
            iArr2[NudgeDirection.RIGHT.ordinal()] = 4;
        }
    }

    public static final /* synthetic */ NicoPropertyBundle access$getPropertyBundle$p(NudgeViewModel nudgeViewModel) {
        NicoPropertyBundle nicoPropertyBundle = nudgeViewModel.propertyBundle;
        if (nicoPropertyBundle == null) {
            Intrinsics.throwUninitializedPropertyAccessException("propertyBundle");
        }
        return nicoPropertyBundle;
    }

    public final LiveData<NicoPropertyBundle> onNudged() {
        return this._nudgeAction;
    }

    public final void setToken(String str) {
        Intrinsics.checkNotNullParameter(str, "token");
        this.propertyBundle = new NicoPropertyBundle(str, (List) null, 2, (DefaultConstructorMarker) null);
        this.nudgedX = 0.0f;
        this.nudgedY = 0.0f;
    }

    public final void nudge(NudgeEvent nudgeEvent) {
        Job job;
        Intrinsics.checkNotNullParameter(nudgeEvent, "event");
        Timber.m300d("~> nudge-event=" + nudgeEvent + " ========================", new Object[0]);
        int i = WhenMappings.$EnumSwitchMapping$0[nudgeEvent.ordinal()];
        if (i == 1) {
            Job job2 = this.nudgeJob;
            if (job2 != null) {
                Job.DefaultImpls.cancel$default(job2, (CancellationException) null, 1, (Object) null);
            }
            nudge$default(this, nudgeEvent.direction(), 0.0f, 2, (Object) null);
        } else if (i == 2) {
            Job job3 = this.nudgeJob;
            if (job3 == null || !job3.isActive()) {
                this.nudgeJob = createNudgeJob(nudgeEvent.direction());
            }
        } else if ((i == 3 || i == 4) && (job = this.nudgeJob) != null) {
            Job.DefaultImpls.cancel$default(job, (CancellationException) null, 1, (Object) null);
        }
    }

    static /* synthetic */ void nudge$default(NudgeViewModel nudgeViewModel, NudgeDirection nudgeDirection, float f, int i, Object obj) {
        if ((i & 2) != 0) {
            f = 4.0f;
        }
        nudgeViewModel.nudge(nudgeDirection, f);
    }

    /* access modifiers changed from: private */
    public final void nudge(NudgeDirection nudgeDirection, float f) {
        NicoProperty.Translate translate;
        int i = WhenMappings.$EnumSwitchMapping$1[nudgeDirection.ordinal()];
        if (i == 1) {
            translate = new NicoProperty.Translate(0.0f, -f);
        } else if (i == 2) {
            translate = new NicoProperty.Translate(0.0f, f);
        } else if (i == 3) {
            translate = new NicoProperty.Translate(-f, 0.0f);
        } else if (i == 4) {
            translate = new NicoProperty.Translate(f, 0.0f);
        } else {
            throw new NoWhenBranchMatchedException();
        }
        this.nudgedX += translate.getValueX();
        this.nudgedY += translate.getValueY();
        SingleLiveEvent<NicoPropertyBundle> singleLiveEvent = this._nudgeAction;
        NicoPropertyBundle nicoPropertyBundle = this.propertyBundle;
        if (nicoPropertyBundle == null) {
            Intrinsics.throwUninitializedPropertyAccessException("propertyBundle");
        }
        singleLiveEvent.setValue(nicoPropertyBundle.setProperties(translate));
    }

    public final void discardChanges() {
        Job job = this.nudgeJob;
        if (job != null) {
            Job.DefaultImpls.cancel$default(job, (CancellationException) null, 1, (Object) null);
        }
        Job unused = BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), (CoroutineContext) null, (CoroutineStart) null, new NudgeViewModel$discardChanges$1(this, (Continuation) null), 3, (Object) null);
    }

    private final Job createNudgeJob(NudgeDirection nudgeDirection) {
        return BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), (CoroutineContext) null, (CoroutineStart) null, new NudgeViewModel$createNudgeJob$1(this, nudgeDirection, (Continuation) null), 3, (Object) null);
    }
}
