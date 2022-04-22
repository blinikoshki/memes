package coil.memory;

import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import coil.request.ErrorResult;
import coil.request.SuccessResult;
import coil.target.Target;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b0\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\u0007\u001a\u00020\bH\u0017J\u0019\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\u000bH@ø\u0001\u0000¢\u0006\u0002\u0010\fJ\u001c\u0010\r\u001a\u00020\b2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011H\u0017J\u0019\u0010\u0012\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\u0013H@ø\u0001\u0000¢\u0006\u0002\u0010\u0014R\u0016\u0010\u0003\u001a\u0004\u0018\u00010\u00048VX\u0004¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006\u0001\u0004\u0015\u0016\u0017\u0018\u0002\u0004\n\u0002\b\u0019¨\u0006\u0019"}, mo26107d2 = {"Lcoil/memory/TargetDelegate;", "", "()V", "target", "Lcoil/target/Target;", "getTarget", "()Lcoil/target/Target;", "clear", "", "error", "result", "Lcoil/request/ErrorResult;", "(Lcoil/request/ErrorResult;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "start", "placeholder", "Landroid/graphics/drawable/Drawable;", "cached", "Landroid/graphics/Bitmap;", "success", "Lcoil/request/SuccessResult;", "(Lcoil/request/SuccessResult;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lcoil/memory/EmptyTargetDelegate;", "Lcoil/memory/InvalidatableEmptyTargetDelegate;", "Lcoil/memory/InvalidatableTargetDelegate;", "Lcoil/memory/PoolableTargetDelegate;", "coil-base_release"}, mo26108k = 1, mo26109mv = {1, 4, 1})
/* compiled from: TargetDelegate.kt */
public abstract class TargetDelegate {
    public void clear() {
    }

    public Object error(ErrorResult errorResult, Continuation<? super Unit> continuation) {
        return Unit.INSTANCE;
    }

    public Target getTarget() {
        return null;
    }

    public void start(Drawable drawable, Bitmap bitmap) {
    }

    public Object success(SuccessResult successResult, Continuation<? super Unit> continuation) {
        return Unit.INSTANCE;
    }

    private TargetDelegate() {
    }

    public /* synthetic */ TargetDelegate(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }
}
