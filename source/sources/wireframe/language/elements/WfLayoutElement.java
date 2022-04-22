package wireframe.language.elements;

import com.facebook.share.internal.MessengerShareContentUtility;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import wireframe.language.properties.WfOrientation;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u0001J\u0006\u0010\n\u001a\u00020\u000bJ\u0006\u0010\f\u001a\u00020\u000bJ\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00010\u0004J\u0006\u0010\u000e\u001a\u00020\u0006J\u0006\u0010\u000f\u001a\u00020\u000bJ\u0014\u0010\u0010\u001a\u00020\b2\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00010\u0004J\u000e\u0010\u0011\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u0006R\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00010\u0004X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u000e¢\u0006\u0002\n\u0000¨\u0006\u0012"}, mo26107d2 = {"Lwireframe/language/elements/WfLayoutElement;", "Lwireframe/language/elements/WfElement;", "()V", "elements", "", "orientation", "Lwireframe/language/properties/WfOrientation;", "addElement", "", "element", "computeTotalWeightedElements", "", "computeWeightSum", "getElements", "getOrientation", "getTotalElements", "setElements", "setOrientation", "wireframe-lang"}, mo26108k = 1, mo26109mv = {1, 4, 2})
/* compiled from: WfLayoutElement.kt */
public final class WfLayoutElement extends WfElement {
    private List<WfElement> elements = new ArrayList();
    private WfOrientation orientation = WfOrientation.STACKED;

    public final WfOrientation getOrientation() {
        return this.orientation;
    }

    public final void setOrientation(WfOrientation wfOrientation) {
        Intrinsics.checkNotNullParameter(wfOrientation, "orientation");
        this.orientation = wfOrientation;
    }

    public final List<WfElement> getElements() {
        return this.elements;
    }

    public final void setElements(List<WfElement> list) {
        Intrinsics.checkNotNullParameter(list, MessengerShareContentUtility.ELEMENTS);
        this.elements = list;
    }

    public final void addElement(WfElement wfElement) {
        Intrinsics.checkNotNullParameter(wfElement, "element");
        this.elements.add(wfElement);
    }

    public final int computeWeightSum() {
        int i = 0;
        for (WfElement weight : this.elements) {
            i += weight.getWeight();
        }
        return i;
    }

    public final int computeTotalWeightedElements() {
        Iterable<WfElement> iterable = this.elements;
        if ((iterable instanceof Collection) && ((Collection) iterable).isEmpty()) {
            return 0;
        }
        int i = 0;
        for (WfElement weight : iterable) {
            if ((weight.getWeight() != 0) && (i = i + 1) < 0) {
                CollectionsKt.throwCountOverflow();
            }
        }
        return i;
    }

    public final int getTotalElements() {
        return this.elements.size();
    }
}
