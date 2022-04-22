package coil.size;

import android.content.Context;
import android.content.res.Resources;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CancellableContinuation;
import kotlinx.coroutines.CancellableContinuationImpl;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u0000 \u001d*\b\b\u0000\u0010\u0001*\u00020\u00022\u00020\u0003:\u0001\u001dJ(\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\f2\u0006\u0010\u0010\u001a\u00020\u0005H\u0002J\b\u0010\u0011\u001a\u00020\fH\u0002J\n\u0010\u0012\u001a\u0004\u0018\u00010\u0013H\u0002J\b\u0010\u0014\u001a\u00020\fH\u0002J\u0011\u0010\u0015\u001a\u00020\u0016H@ø\u0001\u0000¢\u0006\u0002\u0010\u0017J\u0014\u0010\u0018\u001a\u00020\u0019*\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u001cH\u0002R\u0014\u0010\u0004\u001a\u00020\u00058VX\u0004¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007R\u0012\u0010\b\u001a\u00028\u0000X¦\u0004¢\u0006\u0006\u001a\u0004\b\t\u0010\n\u0002\u0004\n\u0002\b\u0019¨\u0006\u001e"}, mo26107d2 = {"Lcoil/size/ViewSizeResolver;", "T", "Landroid/view/View;", "Lcoil/size/SizeResolver;", "subtractPadding", "", "getSubtractPadding", "()Z", "view", "getView", "()Landroid/view/View;", "getDimension", "", "paramSize", "viewSize", "paddingSize", "isWidth", "getHeight", "getSize", "Lcoil/size/PixelSize;", "getWidth", "size", "Lcoil/size/Size;", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "removePreDrawListenerSafe", "", "Landroid/view/ViewTreeObserver;", "victim", "Landroid/view/ViewTreeObserver$OnPreDrawListener;", "Companion", "coil-base_release"}, mo26108k = 1, mo26109mv = {1, 4, 1})
/* compiled from: ViewSizeResolver.kt */
public interface ViewSizeResolver<T extends View> extends SizeResolver {
    public static final Companion Companion = Companion.$$INSTANCE;

    /* renamed from: coil.size.ViewSizeResolver$-CC  reason: invalid class name */
    /* compiled from: ViewSizeResolver.kt */
    public final /* synthetic */ class CC {
        @JvmStatic
        public static <T extends View> ViewSizeResolver<T> create(T t) {
            return Companion.create$default(ViewSizeResolver.Companion, t, false, 2, (Object) null);
        }

        @JvmStatic
        public static <T extends View> ViewSizeResolver<T> create(T t, boolean z) {
            return ViewSizeResolver.Companion.create(t, z);
        }
    }

    boolean getSubtractPadding();

    T getView();

    Object size(Continuation<? super Size> continuation);

    @Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J2\u0010\u0003\u001a\b\u0012\u0004\u0012\u0002H\u00050\u0004\"\b\b\u0001\u0010\u0005*\u00020\u00062\u0006\u0010\u0007\u001a\u0002H\u00052\b\b\u0002\u0010\b\u001a\u00020\tH\u0002¢\u0006\u0004\b\n\u0010\u000b¨\u0006\f"}, mo26107d2 = {"Lcoil/size/ViewSizeResolver$Companion;", "", "()V", "invoke", "Lcoil/size/ViewSizeResolver;", "T", "Landroid/view/View;", "view", "subtractPadding", "", "create", "(Landroid/view/View;Z)Lcoil/size/ViewSizeResolver;", "coil-base_release"}, mo26108k = 1, mo26109mv = {1, 4, 1})
    /* compiled from: ViewSizeResolver.kt */
    public static final class Companion {
        static final /* synthetic */ Companion $$INSTANCE = new Companion();

        @JvmStatic
        public final <T extends View> ViewSizeResolver<T> create(T t) {
            return create$default(this, t, false, 2, (Object) null);
        }

        private Companion() {
        }

        public static /* synthetic */ ViewSizeResolver create$default(Companion companion, View view, boolean z, int i, Object obj) {
            if ((i & 2) != 0) {
                z = true;
            }
            return companion.create(view, z);
        }

        @JvmStatic
        public final <T extends View> ViewSizeResolver<T> create(T t, boolean z) {
            Intrinsics.checkNotNullParameter(t, ViewHierarchyConstants.VIEW_KEY);
            return new RealViewSizeResolver<>(t, z);
        }
    }

    @Metadata(mo26105bv = {1, 0, 3}, mo26108k = 3, mo26109mv = {1, 4, 1})
    /* compiled from: ViewSizeResolver.kt */
    public static final class DefaultImpls {
        public static <T extends View> boolean getSubtractPadding(ViewSizeResolver<T> viewSizeResolver) {
            return true;
        }

        public static <T extends View> Object size(ViewSizeResolver<T> viewSizeResolver, Continuation<? super Size> continuation) {
            PixelSize size = getSize(viewSizeResolver);
            if (size != null) {
                return size;
            }
            CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(IntrinsicsKt.intercepted(continuation), 1);
            cancellableContinuationImpl.initCancellability();
            CancellableContinuation cancellableContinuation = cancellableContinuationImpl;
            ViewTreeObserver viewTreeObserver = viewSizeResolver.getView().getViewTreeObserver();
            C0939xc6aa5ea2 viewSizeResolver$size$$inlined$suspendCancellableCoroutine$lambda$1 = new C0939xc6aa5ea2(viewTreeObserver, cancellableContinuation, viewSizeResolver);
            viewTreeObserver.addOnPreDrawListener(viewSizeResolver$size$$inlined$suspendCancellableCoroutine$lambda$1);
            cancellableContinuation.invokeOnCancellation(new C0940xc6aa5ea3(viewTreeObserver, viewSizeResolver$size$$inlined$suspendCancellableCoroutine$lambda$1, viewSizeResolver));
            Object result = cancellableContinuationImpl.getResult();
            if (result == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
                DebugProbesKt.probeCoroutineSuspended(continuation);
            }
            return result;
        }

        /* access modifiers changed from: private */
        public static <T extends View> PixelSize getSize(ViewSizeResolver<T> viewSizeResolver) {
            int height;
            int width = getWidth(viewSizeResolver);
            if (width > 0 && (height = getHeight(viewSizeResolver)) > 0) {
                return new PixelSize(width, height);
            }
            return null;
        }

        private static <T extends View> int getWidth(ViewSizeResolver<T> viewSizeResolver) {
            ViewGroup.LayoutParams layoutParams = viewSizeResolver.getView().getLayoutParams();
            return getDimension(viewSizeResolver, layoutParams != null ? layoutParams.width : -1, viewSizeResolver.getView().getWidth(), viewSizeResolver.getSubtractPadding() ? viewSizeResolver.getView().getPaddingLeft() + viewSizeResolver.getView().getPaddingRight() : 0, true);
        }

        private static <T extends View> int getHeight(ViewSizeResolver<T> viewSizeResolver) {
            ViewGroup.LayoutParams layoutParams = viewSizeResolver.getView().getLayoutParams();
            return getDimension(viewSizeResolver, layoutParams != null ? layoutParams.height : -1, viewSizeResolver.getView().getHeight(), viewSizeResolver.getSubtractPadding() ? viewSizeResolver.getView().getPaddingTop() + viewSizeResolver.getView().getPaddingBottom() : 0, false);
        }

        private static <T extends View> int getDimension(ViewSizeResolver<T> viewSizeResolver, int i, int i2, int i3, boolean z) {
            int i4 = i - i3;
            if (i4 > 0) {
                return i4;
            }
            int i5 = i2 - i3;
            if (i5 > 0) {
                return i5;
            }
            if (i != -2) {
                return -1;
            }
            Context context = viewSizeResolver.getView().getContext();
            Intrinsics.checkNotNullExpressionValue(context, "view.context");
            Resources resources = context.getResources();
            Intrinsics.checkNotNullExpressionValue(resources, "view.context.resources");
            DisplayMetrics displayMetrics = resources.getDisplayMetrics();
            return z ? displayMetrics.widthPixels : displayMetrics.heightPixels;
        }

        /* access modifiers changed from: private */
        public static <T extends View> void removePreDrawListenerSafe(ViewSizeResolver<T> viewSizeResolver, ViewTreeObserver viewTreeObserver, ViewTreeObserver.OnPreDrawListener onPreDrawListener) {
            if (viewTreeObserver.isAlive()) {
                viewTreeObserver.removeOnPreDrawListener(onPreDrawListener);
            } else {
                viewSizeResolver.getView().getViewTreeObserver().removeOnPreDrawListener(onPreDrawListener);
            }
        }
    }
}
