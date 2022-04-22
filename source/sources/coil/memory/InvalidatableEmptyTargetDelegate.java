package coil.memory;

import android.graphics.Bitmap;
import coil.bitmap.BitmapReferenceCounter;
import coil.request.SuccessResult;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0019\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH@ø\u0001\u0000¢\u0006\u0002\u0010\tR\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000\u0002\u0004\n\u0002\b\u0019¨\u0006\n"}, mo26107d2 = {"Lcoil/memory/InvalidatableEmptyTargetDelegate;", "Lcoil/memory/TargetDelegate;", "referenceCounter", "Lcoil/bitmap/BitmapReferenceCounter;", "(Lcoil/bitmap/BitmapReferenceCounter;)V", "success", "", "result", "Lcoil/request/SuccessResult;", "(Lcoil/request/SuccessResult;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "coil-base_release"}, mo26108k = 1, mo26109mv = {1, 4, 1})
/* compiled from: TargetDelegate.kt */
public final class InvalidatableEmptyTargetDelegate extends TargetDelegate {
    private final BitmapReferenceCounter referenceCounter;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public InvalidatableEmptyTargetDelegate(BitmapReferenceCounter bitmapReferenceCounter) {
        super((DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(bitmapReferenceCounter, "referenceCounter");
        this.referenceCounter = bitmapReferenceCounter;
    }

    public Object success(SuccessResult successResult, Continuation<? super Unit> continuation) {
        BitmapReferenceCounter bitmapReferenceCounter = this.referenceCounter;
        Bitmap access$getBitmap$p = TargetDelegateKt.getBitmap(successResult);
        if (access$getBitmap$p != null) {
            bitmapReferenceCounter.setValid(access$getBitmap$p, false);
        }
        return Unit.INSTANCE;
    }
}
