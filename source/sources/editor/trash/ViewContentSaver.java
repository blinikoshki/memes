package editor.trash;

import android.graphics.Bitmap;
import android.graphics.Rect;
import android.os.Handler;
import android.os.Looper;
import android.view.PixelCopy;
import android.view.View;
import android.view.Window;
import androidx.fragment.app.FragmentActivity;
import com.memes.commons.util.Bitmaps;
import java.io.File;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.Result;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.SafeContinuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import timber.log.Timber;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0007\u0018\u0000 \u000e2\u00020\u0001:\u0001\u000eB\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J#\u0010\u0007\u001a\u0004\u0018\u00010\u00062\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\u0005\u001a\u00020\u0006H@ø\u0001\u0000¢\u0006\u0002\u0010\nJ\u0012\u0010\u000b\u001a\u0004\u0018\u00010\u00062\u0006\u0010\b\u001a\u00020\tH\u0003J\u001b\u0010\f\u001a\u0004\u0018\u00010\u00062\u0006\u0010\b\u001a\u00020\tH@ø\u0001\u0000¢\u0006\u0002\u0010\rR\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X.¢\u0006\u0002\n\u0000\u0002\u0004\n\u0002\b\u0019¨\u0006\u000f"}, mo26107d2 = {"Leditor/trash/ViewContentSaver;", "", "activity", "Landroidx/fragment/app/FragmentActivity;", "(Landroidx/fragment/app/FragmentActivity;)V", "outputFile", "Ljava/io/File;", "save", "view", "Landroid/view/View;", "(Landroid/view/View;Ljava/io/File;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "saveWithDrawingCache", "saveWithPixelCopy", "(Landroid/view/View;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Companion", "editor_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
@Deprecated(message = "Not in use", replaceWith = @ReplaceWith(expression = "kotlin.Nothing :D", imports = {}))
/* compiled from: ViewContentSaver.kt */
public final class ViewContentSaver {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private final FragmentActivity activity;
    /* access modifiers changed from: private */
    public File outputFile;

    private ViewContentSaver(FragmentActivity fragmentActivity) {
        this.activity = fragmentActivity;
    }

    public /* synthetic */ ViewContentSaver(FragmentActivity fragmentActivity, DefaultConstructorMarker defaultConstructorMarker) {
        this(fragmentActivity);
    }

    public static final /* synthetic */ File access$getOutputFile$p(ViewContentSaver viewContentSaver) {
        File file = viewContentSaver.outputFile;
        if (file == null) {
            Intrinsics.throwUninitializedPropertyAccessException("outputFile");
        }
        return file;
    }

    @Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006¨\u0006\u0007"}, mo26107d2 = {"Leditor/trash/ViewContentSaver$Companion;", "", "()V", "fromWindowOwner", "Leditor/trash/ViewContentSaver;", "activity", "Landroidx/fragment/app/FragmentActivity;", "editor_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
    /* compiled from: ViewContentSaver.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final ViewContentSaver fromWindowOwner(FragmentActivity fragmentActivity) {
            Intrinsics.checkNotNullParameter(fragmentActivity, "activity");
            return new ViewContentSaver(fragmentActivity, (DefaultConstructorMarker) null);
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x0032  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0024  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object save(android.view.View r5, java.io.File r6, kotlin.coroutines.Continuation<? super java.io.File> r7) {
        /*
            r4 = this;
            boolean r0 = r7 instanceof editor.trash.ViewContentSaver$save$1
            if (r0 == 0) goto L_0x0014
            r0 = r7
            editor.trash.ViewContentSaver$save$1 r0 = (editor.trash.ViewContentSaver$save$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L_0x0014
            int r7 = r0.label
            int r7 = r7 - r2
            r0.label = r7
            goto L_0x0019
        L_0x0014:
            editor.trash.ViewContentSaver$save$1 r0 = new editor.trash.ViewContentSaver$save$1
            r0.<init>(r4, r7)
        L_0x0019:
            java.lang.Object r7 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L_0x0032
            if (r2 != r3) goto L_0x002a
            kotlin.ResultKt.throwOnFailure(r7)
            goto L_0x0046
        L_0x002a:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L_0x0032:
            kotlin.ResultKt.throwOnFailure(r7)
            r4.outputFile = r6
            int r6 = android.os.Build.VERSION.SDK_INT
            r7 = 26
            if (r6 < r7) goto L_0x0049
            r0.label = r3
            java.lang.Object r7 = r4.saveWithPixelCopy(r5, r0)
            if (r7 != r1) goto L_0x0046
            return r1
        L_0x0046:
            java.io.File r7 = (java.io.File) r7
            goto L_0x004d
        L_0x0049:
            java.io.File r7 = r4.saveWithDrawingCache(r5)
        L_0x004d:
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: editor.trash.ViewContentSaver.save(android.view.View, java.io.File, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ Object saveWithPixelCopy(View view, Continuation<? super File> continuation) {
        Ref.ObjectRef objectRef = new Ref.ObjectRef();
        T window = this.activity.getWindow();
        if (window == null) {
            return null;
        }
        objectRef.element = window;
        int[] iArr = new int[2];
        view.getLocationInWindow(iArr);
        Ref.ObjectRef objectRef2 = new Ref.ObjectRef();
        objectRef2.element = new Rect(iArr[0], iArr[1], iArr[0] + view.getWidth(), iArr[1] + view.getHeight());
        SafeContinuation safeContinuation = new SafeContinuation(IntrinsicsKt.intercepted(continuation));
        Continuation continuation2 = safeContinuation;
        try {
            Bitmap createBitmap = Bitmap.createBitmap(view.getWidth(), view.getHeight(), Bitmap.Config.ARGB_8888);
            PixelCopy.request((Window) objectRef.element, (Rect) objectRef2.element, createBitmap, new C4936xb99eff8e(createBitmap, continuation2, this, view, objectRef, objectRef2), new Handler(Looper.getMainLooper()));
        } catch (IllegalArgumentException e) {
            Timber.m304e(e);
            Result.Companion companion = Result.Companion;
            continuation2.resumeWith(Result.m1029constructorimpl((Object) null));
        }
        Object orThrow = safeContinuation.getOrThrow();
        if (orThrow == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            DebugProbesKt.probeCoroutineSuspended(continuation);
        }
        return orThrow;
    }

    @Deprecated(message = "see above")
    private final File saveWithDrawingCache(View view) {
        view.setDrawingCacheEnabled(true);
        Bitmaps bitmaps = Bitmaps.INSTANCE;
        Bitmap drawingCache = view.getDrawingCache();
        Intrinsics.checkNotNullExpressionValue(drawingCache, "view.drawingCache");
        File file = this.outputFile;
        if (file == null) {
            Intrinsics.throwUninitializedPropertyAccessException("outputFile");
        }
        File save$default = Bitmaps.save$default(bitmaps, drawingCache, file, (Bitmap.CompressFormat) null, 0, 12, (Object) null);
        view.setDrawingCacheEnabled(false);
        return save$default;
    }
}
