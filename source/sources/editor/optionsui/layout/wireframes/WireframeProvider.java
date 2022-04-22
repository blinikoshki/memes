package editor.optionsui.layout.wireframes;

import com.memes.editor.C4175R;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import wireframe.language.Wireframe;
import wireframe.language.elements.WfElement;
import wireframe.language.elements.WfLayoutElement;
import wireframe.language.elements.WfMediaElement;
import wireframe.language.elements.WfTextElement;
import wireframe.language.properties.WfColor;
import wireframe.language.properties.WfDimension;
import wireframe.language.properties.WfGravity;
import wireframe.language.properties.WfMargin;
import wireframe.language.properties.WfOrientation;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u001a\b\u0000\u0018\u0000 \u001e2\u00020\u0001:\u0001\u001eB\u0005¢\u0006\u0002\u0010\u0002J\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004J\b\u0010\u0006\u001a\u00020\u0005H\u0002J\b\u0010\u0007\u001a\u00020\u0005H\u0002J\b\u0010\b\u001a\u00020\u0005H\u0002J\b\u0010\t\u001a\u00020\u0005H\u0002J\b\u0010\n\u001a\u00020\u0005H\u0002J\b\u0010\u000b\u001a\u00020\u0005H\u0002J\b\u0010\f\u001a\u00020\u0005H\u0002J\b\u0010\r\u001a\u00020\u0005H\u0002J\b\u0010\u000e\u001a\u00020\u0005H\u0002J\b\u0010\u000f\u001a\u00020\u0005H\u0002J\b\u0010\u0010\u001a\u00020\u0005H\u0002J\b\u0010\u0011\u001a\u00020\u0005H\u0002J\b\u0010\u0012\u001a\u00020\u0005H\u0002J\b\u0010\u0013\u001a\u00020\u0005H\u0002J\b\u0010\u0014\u001a\u00020\u0005H\u0002J\b\u0010\u0015\u001a\u00020\u0005H\u0002J\b\u0010\u0016\u001a\u00020\u0005H\u0002J\b\u0010\u0017\u001a\u00020\u0005H\u0002J\b\u0010\u0018\u001a\u00020\u0005H\u0002J\b\u0010\u0019\u001a\u00020\u0005H\u0002J\b\u0010\u001a\u001a\u00020\u0005H\u0002J\b\u0010\u001b\u001a\u00020\u0005H\u0002J\b\u0010\u001c\u001a\u00020\u0005H\u0002J\b\u0010\u001d\u001a\u00020\u0005H\u0002¨\u0006\u001f"}, mo26107d2 = {"Leditor/optionsui/layout/wireframes/WireframeProvider;", "", "()V", "all", "", "Lwireframe/language/Wireframe;", "createWireframe01", "createWireframe02", "createWireframe03", "createWireframe04", "createWireframe05", "createWireframe06", "createWireframe07", "createWireframe08", "createWireframe09", "createWireframe10", "createWireframe11", "createWireframe12", "createWireframe13", "createWireframe14", "createWireframe15", "createWireframe16", "createWireframe17", "createWireframe18", "createWireframe19", "createWireframe20", "createWireframe21", "createWireframe22", "createWireframe23", "createWireframe24", "Companion", "editor_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
/* compiled from: WireframeProvider.kt */
public final class WireframeProvider {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);

    @Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0006\u0010\u0003\u001a\u00020\u0004¨\u0006\u0005"}, mo26107d2 = {"Leditor/optionsui/layout/wireframes/WireframeProvider$Companion;", "", "()V", "getDefaultWireframe", "Lwireframe/language/Wireframe;", "editor_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
    /* compiled from: WireframeProvider.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final Wireframe getDefaultWireframe() {
            return new WireframeProvider().createWireframe04();
        }
    }

    public final List<Wireframe> all() {
        return CollectionsKt.listOf(createWireframe01(), createWireframe02(), createWireframe03(), createWireframe04(), createWireframe05(), createWireframe06(), createWireframe07(), createWireframe08(), createWireframe09(), createWireframe10(), createWireframe11(), createWireframe12(), createWireframe13(), createWireframe14(), createWireframe15(), createWireframe16(), createWireframe17(), createWireframe18(), createWireframe19(), createWireframe20(), createWireframe21(), createWireframe22(), createWireframe23(), createWireframe24());
    }

    private final Wireframe createWireframe01() {
        WfMediaElement wfMediaElement = new WfMediaElement();
        wfMediaElement.setWidth((WfDimension) WfDimension.MatchParent.INSTANCE);
        wfMediaElement.setHeight((WfDimension) WfDimension.MatchParent.INSTANCE);
        return new Wireframe("wf01", wfMediaElement, 0, C4175R.C4181layout.n_wireframe_preview_01, 4, (DefaultConstructorMarker) null);
    }

    private final Wireframe createWireframe02() {
        WfTextElement wfTextElement = new WfTextElement();
        wfTextElement.setWidth((WfDimension) WfDimension.MatchParent.INSTANCE);
        wfTextElement.setHeight((WfDimension) WfDimension.MatchParent.INSTANCE);
        return new Wireframe("wf02", wfTextElement, 0, C4175R.C4181layout.n_wireframe_preview_02, 4, (DefaultConstructorMarker) null);
    }

    private final Wireframe createWireframe03() {
        WfTextElement wfTextElement = new WfTextElement();
        wfTextElement.setWidth((WfDimension) WfDimension.MatchParent.INSTANCE);
        wfTextElement.setHeight((WfDimension) WfDimension.WrapContent.INSTANCE);
        wfTextElement.setGravityInParent(WfGravity.CENTER);
        WfMediaElement wfMediaElement = new WfMediaElement();
        wfMediaElement.setWidth((WfDimension) WfDimension.MatchParent.INSTANCE);
        wfMediaElement.setHeight((WfDimension) WfDimension.MatchParent.INSTANCE);
        WfLayoutElement wfLayoutElement = new WfLayoutElement();
        wfLayoutElement.setWidth((WfDimension) WfDimension.MatchParent.INSTANCE);
        wfLayoutElement.setHeight((WfDimension) WfDimension.MatchParent.INSTANCE);
        wfLayoutElement.setOrientation(WfOrientation.STACKED);
        wfLayoutElement.addElement(wfMediaElement);
        wfLayoutElement.addElement(wfTextElement);
        return new Wireframe("wf03", wfLayoutElement, 0, C4175R.C4181layout.n_wireframe_preview_03, 4, (DefaultConstructorMarker) null);
    }

    /* access modifiers changed from: private */
    public final Wireframe createWireframe04() {
        WfTextElement wfTextElement = new WfTextElement();
        wfTextElement.setWidth((WfDimension) WfDimension.MatchParent.INSTANCE);
        wfTextElement.setHeight(0);
        wfTextElement.setWeight(2);
        wfTextElement.setMargin(new WfMargin(30, 0, 30, 0));
        WfMediaElement wfMediaElement = new WfMediaElement();
        wfMediaElement.setWidth((WfDimension) WfDimension.MatchParent.INSTANCE);
        wfMediaElement.setHeight(0);
        wfMediaElement.setWeight(8);
        wfMediaElement.setMargin(new WfMargin(30, 0, 30, 30));
        WfLayoutElement wfLayoutElement = new WfLayoutElement();
        wfLayoutElement.setWidth((WfDimension) WfDimension.MatchParent.INSTANCE);
        wfLayoutElement.setHeight((WfDimension) WfDimension.MatchParent.INSTANCE);
        wfLayoutElement.setOrientation(WfOrientation.VERTICAL);
        wfLayoutElement.addElement(wfTextElement);
        wfLayoutElement.addElement(wfMediaElement);
        return new Wireframe("wf04", wfLayoutElement, 0, C4175R.C4181layout.n_wireframe_preview_04, 4, (DefaultConstructorMarker) null);
    }

    private final Wireframe createWireframe05() {
        WfTextElement wfTextElement = new WfTextElement();
        wfTextElement.setWidth((WfDimension) WfDimension.MatchParent.INSTANCE);
        wfTextElement.setHeight(0);
        wfTextElement.setWeight(2);
        wfTextElement.setMargin(new WfMargin(30, 0, 30, 0));
        WfMediaElement wfMediaElement = new WfMediaElement();
        wfMediaElement.setWidth((WfDimension) WfDimension.MatchParent.INSTANCE);
        wfMediaElement.setHeight(0);
        wfMediaElement.setWeight(8);
        wfMediaElement.setMargin(new WfMargin(30, 0, 30, 0));
        WfLayoutElement wfLayoutElement = new WfLayoutElement();
        wfLayoutElement.setWidth((WfDimension) WfDimension.MatchParent.INSTANCE);
        wfLayoutElement.setHeight((WfDimension) WfDimension.MatchParent.INSTANCE);
        wfLayoutElement.setOrientation(WfOrientation.VERTICAL);
        wfLayoutElement.addElement(wfTextElement);
        wfLayoutElement.addElement(wfMediaElement);
        return new Wireframe("wf05", wfLayoutElement, 0, C4175R.C4181layout.n_wireframe_preview_05, 4, (DefaultConstructorMarker) null);
    }

    private final Wireframe createWireframe06() {
        WfMediaElement wfMediaElement = new WfMediaElement();
        wfMediaElement.setWidth((WfDimension) WfDimension.MatchParent.INSTANCE);
        wfMediaElement.setHeight(0);
        wfMediaElement.setWeight(8);
        wfMediaElement.setMargin(new WfMargin(30, 30, 30, 0));
        WfTextElement wfTextElement = new WfTextElement();
        wfTextElement.setWidth((WfDimension) WfDimension.MatchParent.INSTANCE);
        wfTextElement.setHeight(0);
        wfTextElement.setWeight(2);
        wfTextElement.setMargin(new WfMargin(30, 0, 30, 0));
        WfLayoutElement wfLayoutElement = new WfLayoutElement();
        wfLayoutElement.setWidth((WfDimension) WfDimension.MatchParent.INSTANCE);
        wfLayoutElement.setHeight((WfDimension) WfDimension.MatchParent.INSTANCE);
        wfLayoutElement.setOrientation(WfOrientation.VERTICAL);
        wfLayoutElement.addElement(wfMediaElement);
        wfLayoutElement.addElement(wfTextElement);
        return new Wireframe("wf06", wfLayoutElement, 0, C4175R.C4181layout.n_wireframe_preview_06, 4, (DefaultConstructorMarker) null);
    }

    private final Wireframe createWireframe07() {
        WfTextElement wfTextElement = new WfTextElement();
        wfTextElement.setWidth((WfDimension) WfDimension.MatchParent.INSTANCE);
        wfTextElement.setHeight(0);
        wfTextElement.setWeight(2);
        WfMediaElement wfMediaElement = new WfMediaElement();
        wfMediaElement.setWidth((WfDimension) WfDimension.MatchParent.INSTANCE);
        wfMediaElement.setHeight(0);
        wfMediaElement.setWeight(8);
        WfLayoutElement wfLayoutElement = new WfLayoutElement();
        wfLayoutElement.setWidth((WfDimension) WfDimension.MatchParent.INSTANCE);
        wfLayoutElement.setHeight((WfDimension) WfDimension.MatchParent.INSTANCE);
        wfLayoutElement.setOrientation(WfOrientation.VERTICAL);
        wfLayoutElement.addElement(wfTextElement);
        wfLayoutElement.addElement(wfMediaElement);
        return new Wireframe("wf07", wfLayoutElement, 0, C4175R.C4181layout.n_wireframe_preview_07, 4, (DefaultConstructorMarker) null);
    }

    private final Wireframe createWireframe08() {
        WfTextElement wfTextElement = new WfTextElement();
        wfTextElement.setWidth((WfDimension) WfDimension.MatchParent.INSTANCE);
        wfTextElement.setHeight(0);
        wfTextElement.setWeight(2);
        WfMediaElement wfMediaElement = new WfMediaElement();
        wfMediaElement.setWidth((WfDimension) WfDimension.MatchParent.INSTANCE);
        wfMediaElement.setHeight(0);
        wfMediaElement.setWeight(6);
        WfLayoutElement wfLayoutElement = new WfLayoutElement();
        wfLayoutElement.setOrientation(WfOrientation.VERTICAL);
        WfElement wfElement = wfTextElement;
        wfLayoutElement.addElement(wfElement);
        wfLayoutElement.addElement(wfMediaElement);
        wfLayoutElement.addElement(wfElement);
        return new Wireframe("wf08", wfLayoutElement, 0, C4175R.C4181layout.n_wireframe_preview_08, 4, (DefaultConstructorMarker) null);
    }

    private final Wireframe createWireframe09() {
        WfTextElement wfTextElement = new WfTextElement();
        wfTextElement.setWidth((WfDimension) WfDimension.MatchParent.INSTANCE);
        wfTextElement.setHeight(0);
        wfTextElement.setWeight(5);
        WfMediaElement wfMediaElement = new WfMediaElement();
        wfMediaElement.setWidth((WfDimension) WfDimension.MatchParent.INSTANCE);
        wfMediaElement.setHeight(0);
        wfMediaElement.setWeight(5);
        WfLayoutElement wfLayoutElement = new WfLayoutElement();
        wfLayoutElement.setWidth((WfDimension) WfDimension.MatchParent.INSTANCE);
        wfLayoutElement.setHeight((WfDimension) WfDimension.MatchParent.INSTANCE);
        wfLayoutElement.setOrientation(WfOrientation.VERTICAL);
        wfLayoutElement.addElement(wfTextElement);
        wfLayoutElement.addElement(wfMediaElement);
        return new Wireframe("wf09", wfLayoutElement, 0, C4175R.C4181layout.n_wireframe_preview_09, 4, (DefaultConstructorMarker) null);
    }

    private final Wireframe createWireframe10() {
        WfTextElement wfTextElement = new WfTextElement();
        wfTextElement.setWidth((WfDimension) WfDimension.MatchParent.INSTANCE);
        wfTextElement.setHeight(0);
        wfTextElement.setWeight(5);
        WfMediaElement wfMediaElement = new WfMediaElement();
        wfMediaElement.setWidth((WfDimension) WfDimension.MatchParent.INSTANCE);
        wfMediaElement.setHeight(0);
        wfMediaElement.setWeight(5);
        WfLayoutElement wfLayoutElement = new WfLayoutElement();
        wfLayoutElement.setWidth((WfDimension) WfDimension.MatchParent.INSTANCE);
        wfLayoutElement.setHeight((WfDimension) WfDimension.MatchParent.INSTANCE);
        wfLayoutElement.setOrientation(WfOrientation.VERTICAL);
        wfLayoutElement.addElement(wfMediaElement);
        wfLayoutElement.addElement(wfTextElement);
        return new Wireframe("wf10", wfLayoutElement, 0, C4175R.C4181layout.n_wireframe_preview_10, 4, (DefaultConstructorMarker) null);
    }

    private final Wireframe createWireframe11() {
        WfTextElement wfTextElement = new WfTextElement();
        wfTextElement.setWidth(0);
        wfTextElement.setHeight((WfDimension) WfDimension.MatchParent.INSTANCE);
        wfTextElement.setWeight(5);
        WfMediaElement wfMediaElement = new WfMediaElement();
        wfMediaElement.setWidth(0);
        wfMediaElement.setHeight((WfDimension) WfDimension.MatchParent.INSTANCE);
        wfMediaElement.setWeight(5);
        WfLayoutElement wfLayoutElement = new WfLayoutElement();
        wfLayoutElement.setWidth((WfDimension) WfDimension.MatchParent.INSTANCE);
        wfLayoutElement.setHeight((WfDimension) WfDimension.MatchParent.INSTANCE);
        wfLayoutElement.setOrientation(WfOrientation.HORIZONTAL);
        wfLayoutElement.addElement(wfTextElement);
        wfLayoutElement.addElement(wfMediaElement);
        return new Wireframe("wf11", wfLayoutElement, 0, C4175R.C4181layout.n_wireframe_preview_11, 4, (DefaultConstructorMarker) null);
    }

    private final Wireframe createWireframe12() {
        WfTextElement wfTextElement = new WfTextElement();
        wfTextElement.setWidth(0);
        wfTextElement.setHeight((WfDimension) WfDimension.MatchParent.INSTANCE);
        wfTextElement.setWeight(5);
        WfMediaElement wfMediaElement = new WfMediaElement();
        wfMediaElement.setWidth(0);
        wfMediaElement.setHeight((WfDimension) WfDimension.MatchParent.INSTANCE);
        wfMediaElement.setWeight(5);
        WfLayoutElement wfLayoutElement = new WfLayoutElement();
        wfLayoutElement.setWidth((WfDimension) WfDimension.MatchParent.INSTANCE);
        wfLayoutElement.setHeight((WfDimension) WfDimension.MatchParent.INSTANCE);
        wfLayoutElement.setOrientation(WfOrientation.HORIZONTAL);
        wfLayoutElement.addElement(wfMediaElement);
        wfLayoutElement.addElement(wfTextElement);
        return new Wireframe("wf12", wfLayoutElement, 0, C4175R.C4181layout.n_wireframe_preview_12, 4, (DefaultConstructorMarker) null);
    }

    private final Wireframe createWireframe13() {
        WfTextElement wfTextElement = new WfTextElement();
        wfTextElement.setWidth((WfDimension) WfDimension.MatchParent.INSTANCE);
        wfTextElement.setHeight(0);
        wfTextElement.setWeight(5);
        WfTextElement wfTextElement2 = new WfTextElement();
        wfTextElement2.setWidth((WfDimension) WfDimension.MatchParent.INSTANCE);
        wfTextElement2.setHeight(0);
        wfTextElement2.setWeight(5);
        WfLayoutElement wfLayoutElement = new WfLayoutElement();
        wfLayoutElement.setWidth(0);
        wfLayoutElement.setHeight((WfDimension) WfDimension.MatchParent.INSTANCE);
        wfLayoutElement.setWeight(5);
        wfLayoutElement.setOrientation(WfOrientation.VERTICAL);
        wfLayoutElement.addElement(wfTextElement);
        wfLayoutElement.addElement(wfTextElement2);
        WfMediaElement wfMediaElement = new WfMediaElement();
        wfMediaElement.setWidth(0);
        wfMediaElement.setWeight(5);
        wfMediaElement.setHeight((WfDimension) WfDimension.MatchParent.INSTANCE);
        WfLayoutElement wfLayoutElement2 = new WfLayoutElement();
        wfLayoutElement2.setOrientation(WfOrientation.HORIZONTAL);
        wfLayoutElement2.addElement(wfLayoutElement);
        wfLayoutElement2.addElement(wfMediaElement);
        return new Wireframe("wf13", wfLayoutElement2, 0, C4175R.C4181layout.n_wireframe_preview_13, 4, (DefaultConstructorMarker) null);
    }

    private final Wireframe createWireframe14() {
        WfTextElement wfTextElement = new WfTextElement();
        wfTextElement.setWidth((WfDimension) WfDimension.MatchParent.INSTANCE);
        wfTextElement.setHeight(0);
        wfTextElement.setWeight(5);
        WfTextElement wfTextElement2 = new WfTextElement();
        wfTextElement2.setWidth((WfDimension) WfDimension.MatchParent.INSTANCE);
        wfTextElement2.setHeight(0);
        wfTextElement2.setWeight(5);
        WfLayoutElement wfLayoutElement = new WfLayoutElement();
        wfLayoutElement.setWidth(0);
        wfLayoutElement.setHeight((WfDimension) WfDimension.MatchParent.INSTANCE);
        wfLayoutElement.setWeight(5);
        wfLayoutElement.setOrientation(WfOrientation.VERTICAL);
        wfLayoutElement.addElement(wfTextElement);
        wfLayoutElement.addElement(wfTextElement2);
        WfMediaElement wfMediaElement = new WfMediaElement();
        wfMediaElement.setWidth(0);
        wfMediaElement.setWeight(5);
        wfMediaElement.setHeight((WfDimension) WfDimension.MatchParent.INSTANCE);
        WfLayoutElement wfLayoutElement2 = new WfLayoutElement();
        wfLayoutElement2.setOrientation(WfOrientation.HORIZONTAL);
        wfLayoutElement2.addElement(wfMediaElement);
        wfLayoutElement2.addElement(wfLayoutElement);
        return new Wireframe("wf14", wfLayoutElement2, 0, C4175R.C4181layout.n_wireframe_preview_14, 4, (DefaultConstructorMarker) null);
    }

    private final Wireframe createWireframe15() {
        WfMediaElement wfMediaElement = new WfMediaElement();
        wfMediaElement.setWidth((WfDimension) WfDimension.MatchParent.INSTANCE);
        wfMediaElement.setHeight(0);
        wfMediaElement.setWeight(7);
        wfMediaElement.setBackgroundColor(WfColor.Companion.getBLACK());
        WfTextElement wfTextElement = new WfTextElement();
        wfTextElement.setWidth((WfDimension) WfDimension.MatchParent.INSTANCE);
        wfTextElement.setWidth(0);
        wfTextElement.setWeight(3);
        WfLayoutElement wfLayoutElement = new WfLayoutElement();
        wfLayoutElement.setOrientation(WfOrientation.HORIZONTAL);
        wfLayoutElement.setHeight(0);
        wfLayoutElement.setWeight(8);
        wfLayoutElement.addElement(wfTextElement);
        wfLayoutElement.addElement(wfMediaElement);
        WfTextElement wfTextElement2 = new WfTextElement();
        wfTextElement2.setWidth((WfDimension) WfDimension.MatchParent.INSTANCE);
        wfTextElement2.setHeight(0);
        wfTextElement2.setWeight(2);
        WfLayoutElement wfLayoutElement2 = new WfLayoutElement();
        wfLayoutElement2.setOrientation(WfOrientation.HORIZONTAL);
        wfLayoutElement2.setWidth(0);
        wfLayoutElement2.setWeight(2);
        wfLayoutElement2.addElement(wfTextElement2);
        WfLayoutElement wfLayoutElement3 = new WfLayoutElement();
        wfLayoutElement3.setOrientation(WfOrientation.VERTICAL);
        wfLayoutElement3.addElement(wfLayoutElement);
        wfLayoutElement3.addElement(wfLayoutElement2);
        return new Wireframe("wf15", wfLayoutElement3, 0, C4175R.C4181layout.n_wireframe_preview_15, 4, (DefaultConstructorMarker) null);
    }

    private final Wireframe createWireframe16() {
        WfMediaElement wfMediaElement = new WfMediaElement();
        wfMediaElement.setWidth((WfDimension) WfDimension.MatchParent.INSTANCE);
        wfMediaElement.setHeight(0);
        wfMediaElement.setWeight(7);
        wfMediaElement.setBackgroundColor(WfColor.Companion.getBLACK());
        WfTextElement wfTextElement = new WfTextElement();
        wfTextElement.setWidth((WfDimension) WfDimension.MatchParent.INSTANCE);
        wfTextElement.setWidth(0);
        wfTextElement.setWeight(3);
        WfLayoutElement wfLayoutElement = new WfLayoutElement();
        wfLayoutElement.setOrientation(WfOrientation.HORIZONTAL);
        wfLayoutElement.setHeight(0);
        wfLayoutElement.setWeight(8);
        wfLayoutElement.addElement(wfTextElement);
        wfLayoutElement.addElement(wfMediaElement);
        WfTextElement wfTextElement2 = new WfTextElement();
        wfTextElement2.setWidth((WfDimension) WfDimension.MatchParent.INSTANCE);
        wfTextElement2.setHeight(0);
        wfTextElement2.setWeight(2);
        WfLayoutElement wfLayoutElement2 = new WfLayoutElement();
        wfLayoutElement2.setOrientation(WfOrientation.HORIZONTAL);
        wfLayoutElement2.setWidth(0);
        wfLayoutElement2.setWeight(2);
        wfLayoutElement2.addElement(wfTextElement2);
        WfLayoutElement wfLayoutElement3 = new WfLayoutElement();
        wfLayoutElement3.setOrientation(WfOrientation.VERTICAL);
        wfLayoutElement3.addElement(wfLayoutElement2);
        wfLayoutElement3.addElement(wfLayoutElement);
        return new Wireframe("wf16", wfLayoutElement3, 0, C4175R.C4181layout.n_wireframe_preview_16, 4, (DefaultConstructorMarker) null);
    }

    private final Wireframe createWireframe17() {
        WfTextElement wfTextElement = new WfTextElement();
        wfTextElement.setWidth((WfDimension) WfDimension.MatchParent.INSTANCE);
        wfTextElement.setHeight(0);
        wfTextElement.setWeight(2);
        WfMediaElement wfMediaElement = new WfMediaElement();
        wfMediaElement.setWidth(0);
        wfMediaElement.setHeight((WfDimension) WfDimension.MatchParent.INSTANCE);
        wfMediaElement.setWeight(5);
        wfMediaElement.setMargin(10, 10, 0, 10);
        wfMediaElement.setBackgroundColor(WfColor.Companion.getBLACK());
        WfMediaElement wfMediaElement2 = new WfMediaElement();
        wfMediaElement2.setWidth(0);
        wfMediaElement2.setHeight((WfDimension) WfDimension.MatchParent.INSTANCE);
        wfMediaElement2.setWeight(5);
        wfMediaElement2.setMargin(0, 10, 10, 10);
        wfMediaElement2.setBackgroundColor(WfColor.Companion.getBLACK());
        WfLayoutElement wfLayoutElement = new WfLayoutElement();
        wfLayoutElement.setOrientation(WfOrientation.HORIZONTAL);
        wfLayoutElement.setWeight(8);
        wfLayoutElement.addElement(wfMediaElement);
        wfLayoutElement.addElement(wfMediaElement2);
        WfLayoutElement wfLayoutElement2 = new WfLayoutElement();
        wfLayoutElement2.setOrientation(WfOrientation.VERTICAL);
        wfLayoutElement2.addElement(wfTextElement);
        wfLayoutElement2.addElement(wfLayoutElement);
        return new Wireframe("wf17", wfLayoutElement2, 0, C4175R.C4181layout.n_wireframe_preview_17, 4, (DefaultConstructorMarker) null);
    }

    private final Wireframe createWireframe18() {
        WfTextElement wfTextElement = new WfTextElement();
        wfTextElement.setWidth(0);
        wfTextElement.setHeight((WfDimension) WfDimension.MatchParent.INSTANCE);
        wfTextElement.setWeight(5);
        WfLayoutElement wfLayoutElement = new WfLayoutElement();
        wfLayoutElement.setOrientation(WfOrientation.HORIZONTAL);
        wfLayoutElement.setHeight(0);
        wfLayoutElement.setWeight(2);
        WfElement wfElement = wfTextElement;
        wfLayoutElement.addElement(wfElement);
        wfLayoutElement.addElement(wfElement);
        WfMediaElement wfMediaElement = new WfMediaElement();
        wfMediaElement.setWidth(0);
        wfMediaElement.setHeight((WfDimension) WfDimension.MatchParent.INSTANCE);
        wfMediaElement.setWeight(5);
        wfMediaElement.setBackgroundColor(WfColor.Companion.getBLACK());
        WfLayoutElement wfLayoutElement2 = new WfLayoutElement();
        wfLayoutElement2.setOrientation(WfOrientation.HORIZONTAL);
        wfLayoutElement2.setWidth(0);
        wfLayoutElement2.setWeight(8);
        WfElement wfElement2 = wfMediaElement;
        wfLayoutElement2.addElement(wfElement2);
        wfLayoutElement2.addElement(wfElement2);
        WfLayoutElement wfLayoutElement3 = new WfLayoutElement();
        wfLayoutElement3.setOrientation(WfOrientation.VERTICAL);
        wfLayoutElement3.addElement(wfLayoutElement);
        wfLayoutElement3.addElement(wfLayoutElement2);
        return new Wireframe("wf18", wfLayoutElement3, 0, C4175R.C4181layout.n_wireframe_preview_18, 4, (DefaultConstructorMarker) null);
    }

    private final Wireframe createWireframe19() {
        WfTextElement wfTextElement = new WfTextElement();
        wfTextElement.setWidth(0);
        wfTextElement.setHeight((WfDimension) WfDimension.MatchParent.INSTANCE);
        wfTextElement.setWeight(3);
        WfMediaElement wfMediaElement = new WfMediaElement();
        wfMediaElement.setWidth(0);
        wfMediaElement.setHeight((WfDimension) WfDimension.MatchParent.INSTANCE);
        wfMediaElement.setWeight(7);
        wfMediaElement.setBackgroundColor(WfColor.Companion.getBLACK());
        WfLayoutElement wfLayoutElement = new WfLayoutElement();
        wfLayoutElement.setOrientation(WfOrientation.HORIZONTAL);
        wfLayoutElement.addElement(wfTextElement);
        wfLayoutElement.addElement(wfMediaElement);
        return new Wireframe("wf19", wfLayoutElement, 0, C4175R.C4181layout.n_wireframe_preview_19, 4, (DefaultConstructorMarker) null);
    }

    private final Wireframe createWireframe20() {
        WfTextElement wfTextElement = new WfTextElement();
        wfTextElement.setWidth(0);
        wfTextElement.setHeight((WfDimension) WfDimension.MatchParent.INSTANCE);
        wfTextElement.setWeight(3);
        WfMediaElement wfMediaElement = new WfMediaElement();
        wfMediaElement.setWidth(0);
        wfMediaElement.setHeight((WfDimension) WfDimension.MatchParent.INSTANCE);
        wfMediaElement.setWeight(7);
        wfMediaElement.setBackgroundColor(WfColor.Companion.getBLACK());
        WfLayoutElement wfLayoutElement = new WfLayoutElement();
        wfLayoutElement.setOrientation(WfOrientation.HORIZONTAL);
        wfLayoutElement.addElement(wfMediaElement);
        wfLayoutElement.addElement(wfTextElement);
        return new Wireframe("wf20", wfLayoutElement, 0, C4175R.C4181layout.n_wireframe_preview_20, 4, (DefaultConstructorMarker) null);
    }

    private final Wireframe createWireframe21() {
        WfMediaElement wfMediaElement = new WfMediaElement();
        wfMediaElement.setWidth((WfDimension) WfDimension.MatchParent.INSTANCE);
        wfMediaElement.setHeight(0);
        wfMediaElement.setWeight(3);
        wfMediaElement.setBackgroundColor(WfColor.Companion.getBLACK());
        WfLayoutElement wfLayoutElement = new WfLayoutElement();
        wfLayoutElement.setOrientation(WfOrientation.VERTICAL);
        wfLayoutElement.setWidth(0);
        wfLayoutElement.setWeight(4);
        WfElement wfElement = wfMediaElement;
        wfLayoutElement.addElement(wfElement);
        wfLayoutElement.addElement(wfElement);
        wfLayoutElement.addElement(wfElement);
        WfTextElement wfTextElement = new WfTextElement();
        wfTextElement.setWidth((WfDimension) WfDimension.MatchParent.INSTANCE);
        wfTextElement.setHeight(0);
        wfTextElement.setWeight(3);
        WfLayoutElement wfLayoutElement2 = new WfLayoutElement();
        wfLayoutElement2.setOrientation(WfOrientation.VERTICAL);
        wfLayoutElement.setWidth(0);
        wfLayoutElement2.setWeight(6);
        WfElement wfElement2 = wfTextElement;
        wfLayoutElement2.addElement(wfElement2);
        wfLayoutElement2.addElement(wfElement2);
        wfLayoutElement2.addElement(wfElement2);
        WfLayoutElement wfLayoutElement3 = new WfLayoutElement();
        wfLayoutElement3.setOrientation(WfOrientation.HORIZONTAL);
        wfLayoutElement3.addElement(wfLayoutElement);
        wfLayoutElement3.addElement(wfLayoutElement2);
        return new Wireframe("wf21", wfLayoutElement3, 0, C4175R.C4181layout.n_wireframe_preview_21, 4, (DefaultConstructorMarker) null);
    }

    private final Wireframe createWireframe22() {
        WfMediaElement wfMediaElement = new WfMediaElement();
        wfMediaElement.setWidth((WfDimension) WfDimension.MatchParent.INSTANCE);
        wfMediaElement.setHeight(0);
        wfMediaElement.setWeight(2);
        wfMediaElement.setBackgroundColor(WfColor.Companion.getBLACK());
        WfLayoutElement wfLayoutElement = new WfLayoutElement();
        wfLayoutElement.setOrientation(WfOrientation.VERTICAL);
        wfLayoutElement.setWidth(0);
        wfLayoutElement.setWeight(4);
        WfElement wfElement = wfMediaElement;
        wfLayoutElement.addElement(wfElement);
        wfLayoutElement.addElement(wfElement);
        wfLayoutElement.addElement(wfElement);
        wfLayoutElement.addElement(wfElement);
        wfLayoutElement.addElement(wfElement);
        WfTextElement wfTextElement = new WfTextElement();
        wfTextElement.setWidth((WfDimension) WfDimension.MatchParent.INSTANCE);
        wfTextElement.setHeight(0);
        wfTextElement.setWeight(2);
        WfLayoutElement wfLayoutElement2 = new WfLayoutElement();
        wfLayoutElement2.setOrientation(WfOrientation.VERTICAL);
        wfLayoutElement.setWidth(0);
        wfLayoutElement2.setWeight(6);
        WfElement wfElement2 = wfTextElement;
        wfLayoutElement2.addElement(wfElement2);
        wfLayoutElement2.addElement(wfElement2);
        wfLayoutElement2.addElement(wfElement2);
        wfLayoutElement2.addElement(wfElement2);
        wfLayoutElement2.addElement(wfElement2);
        WfLayoutElement wfLayoutElement3 = new WfLayoutElement();
        wfLayoutElement3.setOrientation(WfOrientation.HORIZONTAL);
        wfLayoutElement3.addElement(wfLayoutElement);
        wfLayoutElement3.addElement(wfLayoutElement2);
        return new Wireframe("wf22", wfLayoutElement3, 0, C4175R.C4181layout.n_wireframe_preview_22, 4, (DefaultConstructorMarker) null);
    }

    private final Wireframe createWireframe23() {
        WfMediaElement wfMediaElement = new WfMediaElement();
        wfMediaElement.setWidth((WfDimension) WfDimension.MatchParent.INSTANCE);
        wfMediaElement.setHeight(0);
        wfMediaElement.setWeight(1);
        wfMediaElement.setBackgroundColor(WfColor.Companion.getBLACK());
        WfLayoutElement wfLayoutElement = new WfLayoutElement();
        wfLayoutElement.setOrientation(WfOrientation.VERTICAL);
        WfElement wfElement = wfMediaElement;
        wfLayoutElement.addElement(wfElement);
        wfLayoutElement.addElement(wfElement);
        return new Wireframe("wf23", wfLayoutElement, 0, C4175R.C4181layout.n_wireframe_preview_23, 4, (DefaultConstructorMarker) null);
    }

    private final Wireframe createWireframe24() {
        WfMediaElement wfMediaElement = new WfMediaElement();
        wfMediaElement.setWidth((WfDimension) WfDimension.MatchParent.INSTANCE);
        wfMediaElement.setHeight(0);
        wfMediaElement.setWeight(1);
        wfMediaElement.setBackgroundColor(WfColor.Companion.getBLACK());
        WfLayoutElement wfLayoutElement = new WfLayoutElement();
        wfLayoutElement.setOrientation(WfOrientation.VERTICAL);
        WfElement wfElement = wfMediaElement;
        wfLayoutElement.addElement(wfElement);
        wfLayoutElement.addElement(wfElement);
        wfLayoutElement.addElement(wfElement);
        return new Wireframe("wf24", wfLayoutElement, 0, C4175R.C4181layout.n_wireframe_preview_24, 4, (DefaultConstructorMarker) null);
    }
}
