package editor.util;

import android.animation.Animator;
import android.animation.LayoutTransition;
import android.animation.ValueAnimator;
import android.graphics.Color;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewPropertyAnimator;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import com.facebook.internal.NativeProtocol;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.random.Random;
import kotlin.text.StringsKt;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000l\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\u0004\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u0018\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u0001H\u0000\u001a\u0018\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0004H\u0000\u001a\u0014\u0010\u0005\u001a\u00020\u0006*\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t\u001a+\u0010\n\u001a\u0002H\u000b\"\u0004\b\u0000\u0010\u000b*\u00020\f2\u0012\u0010\r\u001a\n\u0012\u0006\b\u0001\u0012\u0002H\u000b0\u000e\"\u0002H\u000bH\u0000¢\u0006\u0002\u0010\u000f\u001a\f\u0010\u0010\u001a\u00020\u0011*\u00020\u0011H\u0000\u001a\f\u0010\u0012\u001a\u00020\u0013*\u00020\u0014H\u0000\u001a\f\u0010\u0015\u001a\u00020\u0013*\u00020\u0007H\u0001\u001a\n\u0010\u0016\u001a\u00020\u0013*\u00020\u0017\u001a#\u0010\u0018\u001a\u00020\u0019*\u00020\u00112\u0012\u0010\u001a\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00110\u000e\"\u00020\u0011¢\u0006\u0002\u0010\u001b\u001a\u0012\u0010\u001c\u001a\u00020\u0019*\u00020\u00142\u0006\u0010\u001d\u001a\u00020\u0011\u001a\f\u0010\u001e\u001a\u00020\u001f*\u00020\fH\u0000\u001a\u0016\u0010 \u001a\u00020\u001f*\u00020\f2\b\b\u0002\u0010!\u001a\u00020\u001fH\u0000\u001a$\u0010\"\u001a\u00020\u0019*\u00020#2\u0006\u0010$\u001a\u00020%2\u0006\u0010&\u001a\u00020'2\u0006\u0010(\u001a\u00020\u001fH\u0000¨\u0006)"}, mo26107d2 = {"percentage", "", "value", "total", "", "animator", "Landroid/view/ViewPropertyAnimator;", "Landroid/view/View;", "duration", "", "anyOf", "T", "Lkotlin/random/Random;", "options", "", "(Lkotlin/random/Random;[Ljava/lang/Object;)Ljava/lang/Object;", "capWords", "", "clearBackStack", "", "Landroidx/fragment/app/FragmentManager;", "disableTouch", "enableChangingTransitionType", "Landroid/view/ViewGroup;", "endsWithAnyOf", "", "params", "(Ljava/lang/String;[Ljava/lang/String;)Z", "fragmentTagExists", "tag", "nextColor", "", "nextRgb", "darkness", "writeBitmap", "Ljava/io/File;", "bitmap", "Landroid/graphics/Bitmap;", "format", "Landroid/graphics/Bitmap$CompressFormat;", "quality", "editor_release"}, mo26108k = 2, mo26109mv = {1, 4, 2})
/* compiled from: Ext.kt */
public final class ExtKt {
    public static final float percentage(float f, float f2) {
        return (f * ((float) 100)) / f2;
    }

    public static final int nextColor(Random random) {
        Intrinsics.checkNotNullParameter(random, "$this$nextColor");
        return Color.argb(Random.Default.nextInt(0, 255), Random.Default.nextInt(0, 255), Random.Default.nextInt(0, 255), Random.Default.nextInt(0, 255));
    }

    public static /* synthetic */ int nextRgb$default(Random random, int i, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = 0;
        }
        return nextRgb(random, i);
    }

    public static final int nextRgb(Random random, int i) {
        Intrinsics.checkNotNullParameter(random, "$this$nextRgb");
        return Color.rgb(Random.Default.nextInt(i, 255), Random.Default.nextInt(i, 255), Random.Default.nextInt(i, 255));
    }

    public static final <T> T anyOf(Random random, T... tArr) {
        Intrinsics.checkNotNullParameter(random, "$this$anyOf");
        Intrinsics.checkNotNullParameter(tArr, "options");
        if (!(tArr.length == 0)) {
            return tArr[Random.Default.nextInt(0, tArr.length)];
        }
        throw new RuntimeException("No options passed");
    }

    public static final float percentage(Number number, Number number2) {
        Intrinsics.checkNotNullParameter(number, "value");
        Intrinsics.checkNotNullParameter(number2, "total");
        return percentage(number.floatValue(), number2.floatValue());
    }

    public static final String capWords(String str) {
        Intrinsics.checkNotNullParameter(str, "$this$capWords");
        CharSequence charSequence = str;
        if (StringsKt.isBlank(charSequence)) {
            return StringsKt.trim(charSequence).toString();
        }
        StringBuilder sb = new StringBuilder();
        Character ch = null;
        char[] charArray = str.toCharArray();
        Intrinsics.checkNotNullExpressionValue(charArray, "(this as java.lang.String).toCharArray()");
        for (char c : charArray) {
            if (ch != null) {
                char charValue = ch.charValue();
                if ('a' <= c && 'z' >= c) {
                    if (('A' > charValue || 'Z' < charValue) && ('a' > charValue || 'z' < charValue)) {
                        sb.append((char) (c - ' '));
                    } else {
                        sb.append(c);
                    }
                } else if ('A' > c || 'Z' < c) {
                    sb.append(c);
                } else if ('A' <= charValue && 'Z' >= charValue) {
                    sb.append((char) (c + ' '));
                } else {
                    sb.append(c);
                }
            } else if ('a' <= c && 'z' >= c) {
                sb.append((char) (c - ' '));
            } else {
                sb.append(c);
            }
            ch = Character.valueOf(c);
        }
        String sb2 = sb.toString();
        Intrinsics.checkNotNullExpressionValue(sb2, "builder.toString()");
        Objects.requireNonNull(sb2, "null cannot be cast to non-null type kotlin.CharSequence");
        return StringsKt.trim((CharSequence) sb2).toString();
    }

    public static final void disableTouch(View view) {
        Intrinsics.checkNotNullParameter(view, "$this$disableTouch");
        view.setOnTouchListener(ExtKt$disableTouch$1.INSTANCE);
    }

    public static final void clearBackStack(FragmentManager fragmentManager) {
        Intrinsics.checkNotNullParameter(fragmentManager, "$this$clearBackStack");
        if (fragmentManager.getBackStackEntryCount() > 0) {
            for (Fragment next : fragmentManager.getFragments()) {
            }
            FragmentManager.BackStackEntry backStackEntryAt = fragmentManager.getBackStackEntryAt(0);
            Intrinsics.checkNotNullExpressionValue(backStackEntryAt, "getBackStackEntryAt(0)");
            fragmentManager.popBackStack(backStackEntryAt.getId(), 1);
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:12:0x003b, code lost:
        r4 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:13:0x003c, code lost:
        kotlin.p017io.CloseableKt.closeFinally(r0, r3);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:14:0x003f, code lost:
        throw r4;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final boolean writeBitmap(java.io.File r3, android.graphics.Bitmap r4, android.graphics.Bitmap.CompressFormat r5, int r6) {
        /*
            java.lang.String r0 = "$this$writeBitmap"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r3, r0)
            java.lang.String r0 = "bitmap"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r4, r0)
            java.lang.String r0 = "format"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r5, r0)
            boolean r0 = r4.isRecycled()
            if (r0 == 0) goto L_0x001e
            r3 = 0
            java.lang.Object[] r4 = new java.lang.Object[r3]
            java.lang.String r5 = "Tried to use File.writeBitmap with recycled-bitmap; returning"
            timber.log.Timber.m303e(r5, r4)
            return r3
        L_0x001e:
            java.io.FileOutputStream r0 = new java.io.FileOutputStream
            r0.<init>(r3)
            java.io.Closeable r0 = (java.io.Closeable) r0
            r3 = 0
            java.lang.Throwable r3 = (java.lang.Throwable) r3
            r1 = r0
            java.io.FileOutputStream r1 = (java.io.FileOutputStream) r1     // Catch:{ all -> 0x0039 }
            r2 = r1
            java.io.OutputStream r2 = (java.io.OutputStream) r2     // Catch:{ all -> 0x0039 }
            r4.compress(r5, r6, r2)     // Catch:{ all -> 0x0039 }
            r1.flush()     // Catch:{ all -> 0x0039 }
            r4 = 1
            kotlin.p017io.CloseableKt.closeFinally(r0, r3)
            return r4
        L_0x0039:
            r3 = move-exception
            throw r3     // Catch:{ all -> 0x003b }
        L_0x003b:
            r4 = move-exception
            kotlin.p017io.CloseableKt.closeFinally(r0, r3)
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: editor.util.ExtKt.writeBitmap(java.io.File, android.graphics.Bitmap, android.graphics.Bitmap$CompressFormat, int):boolean");
    }

    public static final void enableChangingTransitionType(ViewGroup viewGroup) {
        Intrinsics.checkNotNullParameter(viewGroup, "$this$enableChangingTransitionType");
        LayoutTransition layoutTransition = viewGroup.getLayoutTransition();
        if (layoutTransition != null) {
            layoutTransition.enableTransitionType(4);
        }
    }

    public static final boolean endsWithAnyOf(String str, String... strArr) {
        Intrinsics.checkNotNullParameter(str, "$this$endsWithAnyOf");
        Intrinsics.checkNotNullParameter(strArr, NativeProtocol.WEB_DIALOG_PARAMS);
        for (String endsWith$default : strArr) {
            if (StringsKt.endsWith$default(str, endsWith$default, false, 2, (Object) null)) {
                return true;
            }
        }
        return false;
    }

    public static final boolean fragmentTagExists(FragmentManager fragmentManager, String str) {
        Intrinsics.checkNotNullParameter(fragmentManager, "$this$fragmentTagExists");
        Intrinsics.checkNotNullParameter(str, ViewHierarchyConstants.TAG_KEY);
        return fragmentManager.findFragmentByTag(str) != null;
    }

    public static /* synthetic */ ViewPropertyAnimator animator$default(View view, long j, int i, Object obj) {
        if ((i & 1) != 0) {
            j = 200;
        }
        return animator(view, j);
    }

    public static final ViewPropertyAnimator animator(View view, long j) {
        Intrinsics.checkNotNullParameter(view, "$this$animator");
        ViewPropertyAnimator listener = view.animate().setDuration(j).setStartDelay(0).setUpdateListener((ValueAnimator.AnimatorUpdateListener) null).setListener((Animator.AnimatorListener) null);
        Intrinsics.checkNotNullExpressionValue(listener, "animate()\n\t\t.setDuration…ull)\n\t\t.setListener(null)");
        return listener;
    }
}
