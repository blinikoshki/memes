package editor.editor.plan;

import editor.optionsui.text.textfont.TextFont;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0004\r\u000e\u000f\u0010B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0006\u0010\t\u001a\u00020\nJ\u0006\u0010\u000b\u001a\u00020\u0006J\u0006\u0010\f\u001a\u00020\u0006R\u000e\u0010\u0005\u001a\u00020\u0006X\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b\u0001\u0004\u0011\u0012\u0013\u0014¨\u0006\u0015"}, mo26107d2 = {"Leditor/editor/plan/EditorPlanRequirement;", "", "requiredPlanType", "Leditor/editor/plan/EditorPlanType;", "(Leditor/editor/plan/EditorPlanType;)V", "expired", "", "getRequiredPlanType", "()Leditor/editor/plan/EditorPlanType;", "expire", "", "isExpired", "isNotExpired", "OfGlFilter", "OfOfficialWatermarkVisibility", "OfTextFont", "OfVideoTrimDuration", "Leditor/editor/plan/EditorPlanRequirement$OfTextFont;", "Leditor/editor/plan/EditorPlanRequirement$OfOfficialWatermarkVisibility;", "Leditor/editor/plan/EditorPlanRequirement$OfVideoTrimDuration;", "Leditor/editor/plan/EditorPlanRequirement$OfGlFilter;", "editor_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
/* compiled from: EditorPlanRequirement.kt */
public abstract class EditorPlanRequirement {
    private boolean expired;
    private final EditorPlanType requiredPlanType;

    private EditorPlanRequirement(EditorPlanType editorPlanType) {
        this.requiredPlanType = editorPlanType;
    }

    public /* synthetic */ EditorPlanRequirement(EditorPlanType editorPlanType, DefaultConstructorMarker defaultConstructorMarker) {
        this(editorPlanType);
    }

    public final EditorPlanType getRequiredPlanType() {
        return this.requiredPlanType;
    }

    public final boolean isExpired() {
        return this.expired;
    }

    public final boolean isNotExpired() {
        return !isExpired();
    }

    public final void expire() {
        this.expired = true;
    }

    @Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, mo26107d2 = {"Leditor/editor/plan/EditorPlanRequirement$OfTextFont;", "Leditor/editor/plan/EditorPlanRequirement;", "font", "Leditor/optionsui/text/textfont/TextFont;", "(Leditor/optionsui/text/textfont/TextFont;)V", "getFont", "()Leditor/optionsui/text/textfont/TextFont;", "editor_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
    /* compiled from: EditorPlanRequirement.kt */
    public static final class OfTextFont extends EditorPlanRequirement {
        private final TextFont font;

        public final TextFont getFont() {
            return this.font;
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public OfTextFont(TextFont textFont) {
            super(EditorPlanType.Premium, (DefaultConstructorMarker) null);
            Intrinsics.checkNotNullParameter(textFont, "font");
            this.font = textFont;
        }
    }

    @Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, mo26107d2 = {"Leditor/editor/plan/EditorPlanRequirement$OfOfficialWatermarkVisibility;", "Leditor/editor/plan/EditorPlanRequirement;", "shouldShow", "", "(Z)V", "getShouldShow", "()Z", "editor_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
    /* compiled from: EditorPlanRequirement.kt */
    public static final class OfOfficialWatermarkVisibility extends EditorPlanRequirement {
        private final boolean shouldShow;

        public final boolean getShouldShow() {
            return this.shouldShow;
        }

        public OfOfficialWatermarkVisibility(boolean z) {
            super(EditorPlanType.Premium, (DefaultConstructorMarker) null);
            this.shouldShow = z;
        }
    }

    @Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, mo26107d2 = {"Leditor/editor/plan/EditorPlanRequirement$OfVideoTrimDuration;", "Leditor/editor/plan/EditorPlanRequirement;", "()V", "editor_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
    /* compiled from: EditorPlanRequirement.kt */
    public static final class OfVideoTrimDuration extends EditorPlanRequirement {
        public OfVideoTrimDuration() {
            super(EditorPlanType.Premium, (DefaultConstructorMarker) null);
        }
    }

    @Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, mo26107d2 = {"Leditor/editor/plan/EditorPlanRequirement$OfGlFilter;", "Leditor/editor/plan/EditorPlanRequirement;", "()V", "editor_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
    /* compiled from: EditorPlanRequirement.kt */
    public static final class OfGlFilter extends EditorPlanRequirement {
        public OfGlFilter() {
            super(EditorPlanType.Premium, (DefaultConstructorMarker) null);
        }
    }
}
