package coil.size;

import android.view.View;
import coil.size.ViewSizeResolver;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0000\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u00022\b\u0012\u0004\u0012\u0002H\u00010\u0003B\u0015\u0012\u0006\u0010\u0004\u001a\u00028\u0000\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\u0013\u0010\r\u001a\u00020\u00062\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fH\u0002J\b\u0010\u0010\u001a\u00020\u0011H\u0016J\b\u0010\u0012\u001a\u00020\u0013H\u0016R\u0014\u0010\u0005\u001a\u00020\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0016\u0010\u0004\u001a\u00028\u0000X\u0004¢\u0006\n\n\u0002\u0010\f\u001a\u0004\b\n\u0010\u000b¨\u0006\u0014"}, mo26107d2 = {"Lcoil/size/RealViewSizeResolver;", "T", "Landroid/view/View;", "Lcoil/size/ViewSizeResolver;", "view", "subtractPadding", "", "(Landroid/view/View;Z)V", "getSubtractPadding", "()Z", "getView", "()Landroid/view/View;", "Landroid/view/View;", "equals", "other", "", "hashCode", "", "toString", "", "coil-base_release"}, mo26108k = 1, mo26109mv = {1, 4, 1})
/* compiled from: RealViewSizeResolver.kt */
public final class RealViewSizeResolver<T extends View> implements ViewSizeResolver<T> {
    private final boolean subtractPadding;
    private final T view;

    public RealViewSizeResolver(T t, boolean z) {
        Intrinsics.checkNotNullParameter(t, ViewHierarchyConstants.VIEW_KEY);
        this.view = t;
        this.subtractPadding = z;
    }

    public Object size(Continuation<? super Size> continuation) {
        return ViewSizeResolver.DefaultImpls.size(this, continuation);
    }

    public T getView() {
        return this.view;
    }

    public boolean getSubtractPadding() {
        return this.subtractPadding;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof RealViewSizeResolver) {
            RealViewSizeResolver realViewSizeResolver = (RealViewSizeResolver) obj;
            if (!Intrinsics.areEqual((Object) getView(), (Object) realViewSizeResolver.getView()) || getSubtractPadding() != realViewSizeResolver.getSubtractPadding()) {
                return false;
            }
            return true;
        }
        return false;
    }

    public int hashCode() {
        return (getView().hashCode() * 31) + C$r8$backportedMethods$utility$Boolean$1$hashCode.hashCode(getSubtractPadding());
    }

    public String toString() {
        return "RealViewSizeResolver(view=" + getView() + ", subtractPadding=" + getSubtractPadding() + ')';
    }
}
