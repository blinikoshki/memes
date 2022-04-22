package editor.optionsui.frame.frameresize;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\b\u0004"}, mo26107d2 = {"<anonymous>", "", "p1", "Leditor/optionsui/frame/frameresize/FrameSize;", "invoke"}, mo26108k = 3, mo26109mv = {1, 4, 2})
/* compiled from: ResizeFrameFragment.kt */
final /* synthetic */ class ResizeFrameFragment$onViewCreated$adapter$1 extends FunctionReferenceImpl implements Function1<FrameSize, Unit> {
    ResizeFrameFragment$onViewCreated$adapter$1(ResizeFrameViewModel resizeFrameViewModel) {
        super(1, resizeFrameViewModel, ResizeFrameViewModel.class, "onFrameSizeSelected", "onFrameSizeSelected(Leditor/optionsui/frame/frameresize/FrameSize;)V", 0);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((FrameSize) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(FrameSize frameSize) {
        Intrinsics.checkNotNullParameter(frameSize, "p1");
        ((ResizeFrameViewModel) this.receiver).onFrameSizeSelected(frameSize);
    }
}
