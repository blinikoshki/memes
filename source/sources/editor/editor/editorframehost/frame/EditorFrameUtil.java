package editor.editor.editorframehost.frame;

import android.view.View;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import editor.editor.equipment.core.CoreConfig;
import editor.editor.equipment.core.CoreEntity;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bÀ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J \u0010\u0003\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u0005j\u0002`\u00060\u00042\u0006\u0010\u0007\u001a\u00020\b¨\u0006\t"}, mo26107d2 = {"Leditor/editor/editorframehost/frame/EditorFrameUtil;", "", "()V", "createSortedEntities", "", "Leditor/editor/equipment/core/CoreEntity;", "Leditor/util/TypedCoreEntity;", "frame", "Leditor/editor/editorframehost/frame/EditorFrame;", "editor_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
/* compiled from: EditorFrameUtil.kt */
public final class EditorFrameUtil {
    public static final EditorFrameUtil INSTANCE = new EditorFrameUtil();

    private EditorFrameUtil() {
    }

    public final List<CoreEntity<?, ?>> createSortedEntities(EditorFrame editorFrame) {
        Intrinsics.checkNotNullParameter(editorFrame, "frame");
        Map linkedHashMap = new LinkedHashMap();
        for (CoreEntity next : editorFrame.getEntities()) {
            next.getView().setTag(next.getToken());
            linkedHashMap.put(next.getToken(), next);
        }
        List<String> arrayList = new ArrayList<>();
        int childCount = editorFrame.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = editorFrame.getChildAt(i);
            Intrinsics.checkNotNullExpressionValue(childAt, ViewHierarchyConstants.VIEW_KEY);
            Object tag = childAt.getTag();
            if ((tag instanceof String) && StringsKt.startsWith$default((String) tag, CoreConfig.ENTITY_TOKEN_PREFIX, false, 2, (Object) null) && (!Intrinsics.areEqual(tag, (Object) editorFrame.getFrameEntity().getToken()))) {
                arrayList.add(tag);
            }
        }
        List<CoreEntity<?, ?>> arrayList2 = new ArrayList<>();
        for (String str : arrayList) {
            Object obj = linkedHashMap.get(str);
            if (obj != null) {
                arrayList2.add((CoreEntity) obj);
            } else {
                throw new IllegalArgumentException("Required value was null.".toString());
            }
        }
        return arrayList2;
    }
}
