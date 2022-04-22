package wireframe.language;

import com.facebook.internal.logging.monitor.MonitorLogServerProtocol;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import wireframe.language.elements.WfElement;
import wireframe.language.elements.WfEmptyElement;
import wireframe.language.elements.WfLayoutElement;
import wireframe.language.elements.WfMediaElement;
import wireframe.language.elements.WfTextElement;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0011\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0002\b\u0003\b\b\u0018\u0000 #2\u00020\u0001:\u0001#B)\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\u0007¢\u0006\u0002\u0010\tJ\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0007HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0007HÆ\u0003J1\u0010\u0017\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\u0007HÆ\u0001J\u0013\u0010\u0018\u001a\u00020\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\u0006\u0010\u001b\u001a\u00020\u0007J\u0006\u0010\u001c\u001a\u00020\u0007J\u0006\u0010\u001d\u001a\u00020\u0019J\u0006\u0010\u001e\u001a\u00020\u0019J\t\u0010\u001f\u001a\u00020\u0007HÖ\u0001J\u0010\u0010 \u001a\u00020!2\u0006\u0010\u0004\u001a\u00020\u0005H\u0002J\t\u0010\"\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\b\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\rR\u000e\u0010\u0011\u001a\u00020\u0007X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0007X\u000e¢\u0006\u0002\n\u0000¨\u0006$"}, mo26107d2 = {"Lwireframe/language/Wireframe;", "", "id", "", "element", "Lwireframe/language/elements/WfElement;", "iconResId", "", "layoutResId", "(Ljava/lang/String;Lwireframe/language/elements/WfElement;II)V", "getElement", "()Lwireframe/language/elements/WfElement;", "getIconResId", "()I", "getId", "()Ljava/lang/String;", "getLayoutResId", "mediaElementCount", "textElementCount", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "getMediaElementCount", "getTextElementCount", "hasIcon", "hasLayout", "hashCode", "processElement", "", "toString", "Companion", "wireframe-lang"}, mo26108k = 1, mo26109mv = {1, 4, 2})
/* compiled from: Wireframe.kt */
public final class Wireframe {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    /* access modifiers changed from: private */
    public static final Wireframe DEFAULT = new Wireframe(MonitorLogServerProtocol.DEFAULT_SAMPLE_RATES_KEY, new WfEmptyElement(), 0, 0, 8, (DefaultConstructorMarker) null);
    private final WfElement element;
    private final int iconResId;

    /* renamed from: id */
    private final String f510id;
    private final int layoutResId;
    private int mediaElementCount;
    private int textElementCount;

    public static /* synthetic */ Wireframe copy$default(Wireframe wireframe2, String str, WfElement wfElement, int i, int i2, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            str = wireframe2.f510id;
        }
        if ((i3 & 2) != 0) {
            wfElement = wireframe2.element;
        }
        if ((i3 & 4) != 0) {
            i = wireframe2.iconResId;
        }
        if ((i3 & 8) != 0) {
            i2 = wireframe2.layoutResId;
        }
        return wireframe2.copy(str, wfElement, i, i2);
    }

    public final String component1() {
        return this.f510id;
    }

    public final WfElement component2() {
        return this.element;
    }

    public final int component3() {
        return this.iconResId;
    }

    public final int component4() {
        return this.layoutResId;
    }

    public final Wireframe copy(String str, WfElement wfElement, int i, int i2) {
        Intrinsics.checkNotNullParameter(str, "id");
        Intrinsics.checkNotNullParameter(wfElement, "element");
        return new Wireframe(str, wfElement, i, i2);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Wireframe)) {
            return false;
        }
        Wireframe wireframe2 = (Wireframe) obj;
        return Intrinsics.areEqual((Object) this.f510id, (Object) wireframe2.f510id) && Intrinsics.areEqual((Object) this.element, (Object) wireframe2.element) && this.iconResId == wireframe2.iconResId && this.layoutResId == wireframe2.layoutResId;
    }

    public int hashCode() {
        String str = this.f510id;
        int i = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        WfElement wfElement = this.element;
        if (wfElement != null) {
            i = wfElement.hashCode();
        }
        return ((((hashCode + i) * 31) + this.iconResId) * 31) + this.layoutResId;
    }

    public String toString() {
        return "Wireframe(id=" + this.f510id + ", element=" + this.element + ", iconResId=" + this.iconResId + ", layoutResId=" + this.layoutResId + ")";
    }

    public Wireframe(String str, WfElement wfElement, int i, int i2) {
        Intrinsics.checkNotNullParameter(str, "id");
        Intrinsics.checkNotNullParameter(wfElement, "element");
        this.f510id = str;
        this.element = wfElement;
        this.iconResId = i;
        this.layoutResId = i2;
        processElement(wfElement);
    }

    public final String getId() {
        return this.f510id;
    }

    public final WfElement getElement() {
        return this.element;
    }

    public final int getIconResId() {
        return this.iconResId;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ Wireframe(String str, WfElement wfElement, int i, int i2, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, wfElement, (i3 & 4) != 0 ? 0 : i, (i3 & 8) != 0 ? 0 : i2);
    }

    public final int getLayoutResId() {
        return this.layoutResId;
    }

    @Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, mo26107d2 = {"Lwireframe/language/Wireframe$Companion;", "", "()V", "DEFAULT", "Lwireframe/language/Wireframe;", "getDEFAULT", "()Lwireframe/language/Wireframe;", "wireframe-lang"}, mo26108k = 1, mo26109mv = {1, 4, 2})
    /* compiled from: Wireframe.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final Wireframe getDEFAULT() {
            return Wireframe.DEFAULT;
        }
    }

    public final int getTextElementCount() {
        return this.textElementCount;
    }

    public final int getMediaElementCount() {
        return this.mediaElementCount;
    }

    public final boolean hasIcon() {
        return this.iconResId != 0;
    }

    public final boolean hasLayout() {
        return this.layoutResId != 0;
    }

    private final void processElement(WfElement wfElement) {
        if (wfElement instanceof WfTextElement) {
            this.textElementCount++;
        } else if (wfElement instanceof WfMediaElement) {
            this.mediaElementCount++;
        } else if (wfElement instanceof WfLayoutElement) {
            for (WfElement processElement : ((WfLayoutElement) wfElement).getElements()) {
                processElement(processElement);
            }
        }
    }
}
