package editor.common.choicesbottomsheet;

import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010!\n\u0000\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0003\b\u0000\u0018\u0000 \u00192\u00020\u0001:\u0001\u0019B7\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u000e\b\u0002\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00000\b\u0012\u0006\u0010\t\u001a\u00020\n¢\u0006\u0002\u0010\u000bJ\u000e\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0000J\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00000\u0017J\u0006\u0010\u0018\u001a\u00020\u0006R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0014\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00000\bX\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000fR\u0011\u0010\t\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012¨\u0006\u001a"}, mo26107d2 = {"Leditor/common/choicesbottomsheet/Choice;", "", "id", "", "title", "enabled", "", "subChoices", "", "type", "", "(Ljava/lang/String;Ljava/lang/String;ZLjava/util/List;I)V", "getEnabled", "()Z", "getId", "()Ljava/lang/String;", "getTitle", "getType", "()I", "addChoice", "", "choice", "getSubChoices", "", "hasSubChoices", "Companion", "editor_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
/* compiled from: Choice.kt */
public final class Choice {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    public static final int TYPE_CHOICE = 12;
    public static final int TYPE_DIVIDER = 13;
    private final boolean enabled;

    /* renamed from: id */
    private final String f1424id;
    private final List<Choice> subChoices;
    private final String title;
    private final int type;

    private Choice(String str, String str2, boolean z, List<Choice> list, int i) {
        this.f1424id = str;
        this.title = str2;
        this.enabled = z;
        this.subChoices = list;
        this.type = i;
    }

    public final String getId() {
        return this.f1424id;
    }

    public final String getTitle() {
        return this.title;
    }

    public final boolean getEnabled() {
        return this.enabled;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    /* synthetic */ Choice(String str, String str2, boolean z, List list, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, str2, z, (i2 & 8) != 0 ? new ArrayList() : list, i);
    }

    public final int getType() {
        return this.type;
    }

    @Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J \u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\t2\b\b\u0002\u0010\u000b\u001a\u00020\fJ\u0006\u0010\r\u001a\u00020\u0007R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u000e"}, mo26107d2 = {"Leditor/common/choicesbottomsheet/Choice$Companion;", "", "()V", "TYPE_CHOICE", "", "TYPE_DIVIDER", "create", "Leditor/common/choicesbottomsheet/Choice;", "id", "", "title", "enabled", "", "divider", "editor_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
    /* compiled from: Choice.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public static /* synthetic */ Choice create$default(Companion companion, String str, String str2, boolean z, int i, Object obj) {
            if ((i & 4) != 0) {
                z = true;
            }
            return companion.create(str, str2, z);
        }

        public final Choice create(String str, String str2, boolean z) {
            Intrinsics.checkNotNullParameter(str, "id");
            Intrinsics.checkNotNullParameter(str2, "title");
            return new Choice(str, str2, z, (List) null, 12, 8, (DefaultConstructorMarker) null);
        }

        public final Choice divider() {
            return new Choice("divider", "divider", true, (List) null, 13, 8, (DefaultConstructorMarker) null);
        }
    }

    public final boolean hasSubChoices() {
        return !this.subChoices.isEmpty();
    }

    public final List<Choice> getSubChoices() {
        return this.subChoices;
    }

    public final void addChoice(Choice choice) {
        Intrinsics.checkNotNullParameter(choice, "choice");
        this.subChoices.add(choice);
    }
}
