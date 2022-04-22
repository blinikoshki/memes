package editor.editor;

import java.util.UUID;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\bÀ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0006\u0010\u0005\u001a\u00020\u0004J\u0006\u0010\u0006\u001a\u00020\u0004J\u0006\u0010\u0007\u001a\u00020\bR\u000e\u0010\u0003\u001a\u00020\u0004X.¢\u0006\u0002\n\u0000¨\u0006\t"}, mo26107d2 = {"Leditor/editor/EditorSession;", "", "()V", "value", "", "create", "getValue", "isInitialized", "", "editor_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
/* compiled from: EditorSession.kt */
public final class EditorSession {
    public static final EditorSession INSTANCE = new EditorSession();
    /* access modifiers changed from: private */
    public static String value;

    private EditorSession() {
    }

    public static final /* synthetic */ String access$getValue$p(EditorSession editorSession) {
        String str = value;
        if (str == null) {
            Intrinsics.throwUninitializedPropertyAccessException("value");
        }
        return str;
    }

    public final String create() {
        String uuid = UUID.randomUUID().toString();
        Intrinsics.checkNotNullExpressionValue(uuid, "UUID.randomUUID().toString()");
        value = uuid;
        if (uuid == null) {
            Intrinsics.throwUninitializedPropertyAccessException("value");
        }
        return uuid;
    }

    public final boolean isInitialized() {
        return value != null;
    }

    public final String getValue() {
        String str = value;
        if (str == null) {
            Intrinsics.throwUninitializedPropertyAccessException("value");
        }
        return str;
    }
}
