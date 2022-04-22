package editor.optionsui.layout.wireframes;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;
import wireframe.language.Wireframe;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\b\u0004"}, mo26107d2 = {"<anonymous>", "", "p1", "Lwireframe/language/Wireframe;", "invoke"}, mo26108k = 3, mo26109mv = {1, 4, 2})
/* compiled from: WireframesFragment.kt */
final /* synthetic */ class WireframesFragment$onViewCreated$adapter$1 extends FunctionReferenceImpl implements Function1<Wireframe, Unit> {
    WireframesFragment$onViewCreated$adapter$1(WireframesViewModel wireframesViewModel) {
        super(1, wireframesViewModel, WireframesViewModel.class, "selectWireframe", "selectWireframe(Lwireframe/language/Wireframe;)V", 0);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((Wireframe) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(Wireframe wireframe2) {
        Intrinsics.checkNotNullParameter(wireframe2, "p1");
        ((WireframesViewModel) this.receiver).selectWireframe(wireframe2);
    }
}
