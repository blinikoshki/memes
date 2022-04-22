package editor.editor.plan;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0004\u0018\u0000 \u000f2\u00020\u0001:\u0001\u000fB\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u000e\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0002\u001a\u00020\u0003J\u0006\u0010\u0007\u001a\u00020\bJ\u0006\u0010\t\u001a\u00020\bJ\u000e\u0010\n\u001a\u00020\b2\u0006\u0010\u0002\u001a\u00020\u0003J\b\u0010\u000b\u001a\u00020\fH\u0016J\u000e\u0010\r\u001a\u00020\u00062\u0006\u0010\u000e\u001a\u00020\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u000e¢\u0006\u0002\n\u0000¨\u0006\u0010"}, mo26107d2 = {"Leditor/editor/plan/EditorPlan;", "", "type", "Leditor/editor/plan/EditorPlanType;", "(Leditor/editor/plan/EditorPlanType;)V", "changePlan", "", "isPremium", "", "isRookie", "ofType", "toString", "", "updateBy", "plan", "Companion", "editor_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
/* compiled from: EditorPlan.kt */
public final class EditorPlan {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private EditorPlanType type;

    private EditorPlan(EditorPlanType editorPlanType) {
        this.type = editorPlanType;
    }

    public /* synthetic */ EditorPlan(EditorPlanType editorPlanType, DefaultConstructorMarker defaultConstructorMarker) {
        this(editorPlanType);
    }

    @Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0006\u0010\u0003\u001a\u00020\u0004¨\u0006\u0005"}, mo26107d2 = {"Leditor/editor/plan/EditorPlan$Companion;", "", "()V", "rookie", "Leditor/editor/plan/EditorPlan;", "editor_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
    /* compiled from: EditorPlan.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final EditorPlan rookie() {
            return new EditorPlan(EditorPlanType.Rookie, (DefaultConstructorMarker) null);
        }
    }

    public final boolean isRookie() {
        return this.type == EditorPlanType.Rookie;
    }

    public final boolean isPremium() {
        return this.type == EditorPlanType.Premium;
    }

    public final boolean ofType(EditorPlanType editorPlanType) {
        Intrinsics.checkNotNullParameter(editorPlanType, "type");
        return this.type == editorPlanType;
    }

    public final void changePlan(EditorPlanType editorPlanType) {
        Intrinsics.checkNotNullParameter(editorPlanType, "type");
        this.type = editorPlanType;
    }

    public final void updateBy(EditorPlan editorPlan) {
        Intrinsics.checkNotNullParameter(editorPlan, "plan");
        changePlan(editorPlan.type);
    }

    public String toString() {
        return "EditorPlan(type=" + this.type + ')';
    }
}
