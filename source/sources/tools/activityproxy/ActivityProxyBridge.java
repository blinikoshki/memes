package tools.activityproxy;

import android.content.Context;
import android.content.Intent;
import com.gaelmarhic.quadrant.QuadrantConstants;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\n\u0010\u0003\u001a\u0006\u0012\u0002\b\u00030\u0004J\u000e\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bJ\u0018\u0010\t\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\u000bH\u0002J\n\u0010\f\u001a\u0006\u0012\u0002\b\u00030\u0004JQ\u0010\r\u001a\u00020\u000e2\u0006\u0010\u0007\u001a\u00020\b2A\u0010\u000f\u001a=\u0012\u0004\u0012\u00020\u0006\u0012\u0013\u0012\u00110\u000b¢\u0006\f\b\u0011\u0012\b\b\u0012\u0012\u0004\b\b(\u0013\u0012\u0013\u0012\u00110\u000b¢\u0006\f\b\u0011\u0012\b\b\u0012\u0012\u0004\b\b(\u0014\u0012\u0004\u0012\u00020\u000e0\u0010¢\u0006\u0002\b\u0015J@\u0010\u0016\u001a\u00020\u000e2\u0006\u0010\u0007\u001a\u00020\b20\b\u0002\u0010\u000f\u001a*\u0012\u0004\u0012\u00020\u0006\u0012\u0013\u0012\u00110\u000b¢\u0006\f\b\u0011\u0012\b\b\u0012\u0012\u0004\b\b(\u0018\u0012\u0004\u0012\u00020\u000e\u0018\u00010\u0017¢\u0006\u0002\b\u0015J<\u0010\u0019\u001a\u00020\u000e2\u0006\u0010\u0007\u001a\u00020\b2,\u0010\u000f\u001a(\u0012\u0004\u0012\u00020\u0006\u0012\u0013\u0012\u00110\u000b¢\u0006\f\b\u0011\u0012\b\b\u0012\u0012\u0004\b\b(\u001a\u0012\u0004\u0012\u00020\u000e0\u0017¢\u0006\u0002\b\u0015J@\u0010\u001b\u001a\u00020\u000e2\u0006\u0010\u0007\u001a\u00020\b20\b\u0002\u0010\u000f\u001a*\u0012\u0004\u0012\u00020\u0006\u0012\u0013\u0012\u00110\u000b¢\u0006\f\b\u0011\u0012\b\b\u0012\u0012\u0004\b\b(\u0018\u0012\u0004\u0012\u00020\u000e\u0018\u00010\u0017¢\u0006\u0002\b\u0015¨\u0006\u001c"}, mo26107d2 = {"Ltools/activityproxy/ActivityProxyBridge;", "", "()V", "getFiltersPageClass", "Ljava/lang/Class;", "getHomeIntent", "Landroid/content/Intent;", "context", "Landroid/content/Context;", "getIntent", "className", "", "getVideoTrimPageClass", "launchDraftPreviewPage", "", "fillUpAction", "Lkotlin/Function3;", "Lkotlin/ParameterName;", "name", "draftIdKey", "draftThumbnailPathKey", "Lkotlin/ExtensionFunctionType;", "launchEditorEntryPage", "Lkotlin/Function2;", "key", "launchEditorExportPreviewPage", "mediaContentKey", "launchEditorPage", "activityproxy_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
/* compiled from: ActivityProxyBridge.kt */
public final class ActivityProxyBridge {
    public static final ActivityProxyBridge INSTANCE = new ActivityProxyBridge();

    private ActivityProxyBridge() {
    }

    private final Intent getIntent(Context context, String str) {
        return new Intent(context, Class.forName(str));
    }

    public final Intent getHomeIntent(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        return getIntent(context, QuadrantConstants.HOME_ACTIVITY);
    }

    public static /* synthetic */ void launchEditorEntryPage$default(ActivityProxyBridge activityProxyBridge, Context context, Function2 function2, int i, Object obj) {
        if ((i & 2) != 0) {
            function2 = null;
        }
        activityProxyBridge.launchEditorEntryPage(context, function2);
    }

    public final void launchEditorEntryPage(Context context, Function2<? super Intent, ? super String, Unit> function2) {
        Intrinsics.checkNotNullParameter(context, "context");
        context.startActivity(getIntent(context, QuadrantConstants.EDITOR_ENTRY_SELECTION_ACTIVITY));
    }

    public static /* synthetic */ void launchEditorPage$default(ActivityProxyBridge activityProxyBridge, Context context, Function2 function2, int i, Object obj) {
        if ((i & 2) != 0) {
            function2 = null;
        }
        activityProxyBridge.launchEditorPage(context, function2);
    }

    public final void launchEditorPage(Context context, Function2<? super Intent, ? super String, Unit> function2) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intent intent = getIntent(context, QuadrantConstants.EDITOR_PROXY_ACTIVITY);
        if (function2 != null) {
            function2.invoke(intent, ActivityExtra.DRAFT_ID);
            function2.invoke(intent, ActivityExtra.WIREFRAME_ID);
            function2.invoke(intent, ActivityExtra.FRAME_SIZE);
            function2.invoke(intent, ActivityExtra.TRENDING_TEMPLATE);
            function2.invoke(intent, ActivityExtra.EXTRA_CONTENTS);
        }
        context.startActivity(intent);
    }

    public final void launchDraftPreviewPage(Context context, Function3<? super Intent, ? super String, ? super String, Unit> function3) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(function3, "fillUpAction");
        Intent intent = getIntent(context, QuadrantConstants.EDITOR_DRAFT_PREVIEW_ACTIVITY);
        function3.invoke(intent, ActivityExtra.DRAFT_ID, ActivityExtra.DRAFT_THUMB_PATH);
        context.startActivity(intent);
    }

    public final void launchEditorExportPreviewPage(Context context, Function2<? super Intent, ? super String, Unit> function2) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(function2, "fillUpAction");
        Intent intent = getIntent(context, QuadrantConstants.EXPORT_POST_ACTIVITY);
        function2.invoke(intent, ActivityExtra.MEDIA_CONTENT);
        context.startActivity(intent);
    }

    public final Class<?> getVideoTrimPageClass() {
        Class<?> cls = Class.forName(QuadrantConstants.VIDEO_TRIMMER_PROXY_ACTIVITY);
        Intrinsics.checkNotNullExpressionValue(cls, "Class.forName(QuadrantCo…O_TRIMMER_PROXY_ACTIVITY)");
        return cls;
    }

    public final Class<?> getFiltersPageClass() {
        Class<?> cls = Class.forName(QuadrantConstants.FILTERS_PROXY_ACTIVITY);
        Intrinsics.checkNotNullExpressionValue(cls, "Class.forName(QuadrantCo…s.FILTERS_PROXY_ACTIVITY)");
        return cls;
    }
}
