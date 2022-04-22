package editor.editor.equipment.property;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0011\n\u0002\b\u0005\b\u0000\u0018\u0000 \u00122\u00020\u0001:\u0001\u0012B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\u0002\u0010\u0007J\u001f\u0010\f\u001a\u00020\u00002\u0012\u0010\r\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00060\u000e\"\u00020\u0006¢\u0006\u0002\u0010\u000fJ\u001f\u0010\u0010\u001a\u00020\u00002\u0012\u0010\r\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00060\u000e\"\u00020\u0006¢\u0006\u0002\u0010\u000fJ\b\u0010\u0011\u001a\u00020\u0003H\u0016R\u0017\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0013"}, mo26107d2 = {"Leditor/editor/equipment/property/NicoPropertyBundle;", "", "token", "", "properties", "", "Leditor/editor/equipment/property/NicoProperty;", "(Ljava/lang/String;Ljava/util/List;)V", "getProperties", "()Ljava/util/List;", "getToken", "()Ljava/lang/String;", "addProperties", "newProperties", "", "([Leditor/editor/equipment/property/NicoProperty;)Leditor/editor/equipment/property/NicoPropertyBundle;", "setProperties", "toString", "Companion", "editor_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
/* compiled from: NicoPropertyBundle.kt */
public final class NicoPropertyBundle {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private final List<NicoProperty> properties;
    private final String token;

    public NicoPropertyBundle(String str, List<NicoProperty> list) {
        Intrinsics.checkNotNullParameter(str, "token");
        Intrinsics.checkNotNullParameter(list, "properties");
        this.token = str;
        this.properties = list;
    }

    public final String getToken() {
        return this.token;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ NicoPropertyBundle(String str, List list, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, (i & 2) != 0 ? new ArrayList() : list);
    }

    public final List<NicoProperty> getProperties() {
        return this.properties;
    }

    @Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J'\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0012\u0010\u0007\u001a\n\u0012\u0006\b\u0001\u0012\u00020\t0\b\"\u00020\t¢\u0006\u0002\u0010\n¨\u0006\u000b"}, mo26107d2 = {"Leditor/editor/equipment/property/NicoPropertyBundle$Companion;", "", "()V", "from", "Leditor/editor/equipment/property/NicoPropertyBundle;", "token", "", "properties", "", "Leditor/editor/equipment/property/NicoProperty;", "(Ljava/lang/String;[Leditor/editor/equipment/property/NicoProperty;)Leditor/editor/equipment/property/NicoPropertyBundle;", "editor_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
    /* compiled from: NicoPropertyBundle.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final NicoPropertyBundle from(String str, NicoProperty... nicoPropertyArr) {
            Intrinsics.checkNotNullParameter(str, "token");
            Intrinsics.checkNotNullParameter(nicoPropertyArr, "properties");
            NicoPropertyBundle nicoPropertyBundle = new NicoPropertyBundle(str, (List) null, 2, (DefaultConstructorMarker) null);
            nicoPropertyBundle.addProperties((NicoProperty[]) Arrays.copyOf(nicoPropertyArr, nicoPropertyArr.length));
            return nicoPropertyBundle;
        }
    }

    public final NicoPropertyBundle addProperties(NicoProperty... nicoPropertyArr) {
        Intrinsics.checkNotNullParameter(nicoPropertyArr, "newProperties");
        CollectionsKt.addAll(this.properties, (T[]) nicoPropertyArr);
        return this;
    }

    public final NicoPropertyBundle setProperties(NicoProperty... nicoPropertyArr) {
        Intrinsics.checkNotNullParameter(nicoPropertyArr, "newProperties");
        this.properties.clear();
        CollectionsKt.addAll(this.properties, (T[]) nicoPropertyArr);
        return this;
    }

    public String toString() {
        return "NicoPropertyBundle(token='" + this.token + "', properties=" + this.properties + ')';
    }
}
