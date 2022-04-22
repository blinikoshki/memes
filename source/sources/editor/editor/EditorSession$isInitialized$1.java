package editor.editor;

import kotlin.Metadata;
import kotlin.jvm.internal.MutablePropertyReference0Impl;

@Metadata(mo26105bv = {1, 0, 3}, mo26108k = 3, mo26109mv = {1, 4, 2})
/* compiled from: EditorSession.kt */
final /* synthetic */ class EditorSession$isInitialized$1 extends MutablePropertyReference0Impl {
    EditorSession$isInitialized$1(EditorSession editorSession) {
        super(editorSession, EditorSession.class, "value", "getValue()Ljava/lang/String;", 0);
    }

    public Object get() {
        return EditorSession.access$getValue$p((EditorSession) this.receiver);
    }

    public void set(Object obj) {
        EditorSession.value = (String) obj;
    }
}
