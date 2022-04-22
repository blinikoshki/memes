package coil.memory;

import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import coil.EventListener;
import coil.bitmap.BitmapReferenceCounter;
import coil.bitmap.EmptyBitmapReferenceCounter;
import coil.target.PoolableViewTarget;
import coil.util.Extensions;
import coil.util.Logger;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0000\u0018\u00002\u00020\u0001B+\u0012\n\u0010\u0002\u001a\u0006\u0012\u0002\b\u00030\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\b\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\u0002\u0010\nJ\b\u0010\r\u001a\u00020\u000eH\u0016J\u0012\u0010\u000f\u001a\u00020\u000e2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011H\u0002J\u0019\u0010\u0012\u001a\u00020\u000e2\u0006\u0010\u0013\u001a\u00020\u0014H@ø\u0001\u0000¢\u0006\u0002\u0010\u0015J\u0012\u0010\u0016\u001a\u00020\u000e2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011H\u0002J0\u0010\u0017\u001a\u00020\u000e2\b\u0010\u0010\u001a\u0004\u0018\u00010\u00112\u001b\u0010\u0018\u001a\u0017\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u0003\u0012\u0004\u0012\u00020\u000e0\u0019¢\u0006\u0002\b\u001aH\bJ\u001c\u0010\u001b\u001a\u00020\u000e2\b\u0010\u001c\u001a\u0004\u0018\u00010\u001d2\b\u0010\u001e\u001a\u0004\u0018\u00010\u0011H\u0016J\u0019\u0010\u001f\u001a\u00020\u000e2\u0006\u0010\u0013\u001a\u00020 H@ø\u0001\u0000¢\u0006\u0002\u0010!R\u000e\u0010\u0006\u001a\u00020\u0007X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u0018\u0010\u0002\u001a\u0006\u0012\u0002\b\u00030\u0003X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f\u0002\u0004\n\u0002\b\u0019¨\u0006\""}, mo26107d2 = {"Lcoil/memory/PoolableTargetDelegate;", "Lcoil/memory/TargetDelegate;", "target", "Lcoil/target/PoolableViewTarget;", "referenceCounter", "Lcoil/bitmap/BitmapReferenceCounter;", "eventListener", "Lcoil/EventListener;", "logger", "Lcoil/util/Logger;", "(Lcoil/target/PoolableViewTarget;Lcoil/bitmap/BitmapReferenceCounter;Lcoil/EventListener;Lcoil/util/Logger;)V", "getTarget", "()Lcoil/target/PoolableViewTarget;", "clear", "", "decrement", "bitmap", "Landroid/graphics/Bitmap;", "error", "result", "Lcoil/request/ErrorResult;", "(Lcoil/request/ErrorResult;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "increment", "replace", "update", "Lkotlin/Function1;", "Lkotlin/ExtensionFunctionType;", "start", "placeholder", "Landroid/graphics/drawable/Drawable;", "cached", "success", "Lcoil/request/SuccessResult;", "(Lcoil/request/SuccessResult;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "coil-base_release"}, mo26108k = 1, mo26109mv = {1, 4, 1})
/* compiled from: TargetDelegate.kt */
public final class PoolableTargetDelegate extends TargetDelegate {
    private final EventListener eventListener;
    private final Logger logger;
    /* access modifiers changed from: private */
    public final BitmapReferenceCounter referenceCounter;
    private final PoolableViewTarget<?> target;

    public PoolableViewTarget<?> getTarget() {
        return this.target;
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public PoolableTargetDelegate(PoolableViewTarget<?> poolableViewTarget, BitmapReferenceCounter bitmapReferenceCounter, EventListener eventListener2, Logger logger2) {
        super((DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(poolableViewTarget, "target");
        Intrinsics.checkNotNullParameter(bitmapReferenceCounter, "referenceCounter");
        Intrinsics.checkNotNullParameter(eventListener2, "eventListener");
        this.target = poolableViewTarget;
        this.referenceCounter = bitmapReferenceCounter;
        this.eventListener = eventListener2;
        this.logger = logger2;
    }

    /* JADX WARNING: Removed duplicated region for block: B:14:0x005d  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x002b  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.Object success(coil.request.SuccessResult r18, kotlin.coroutines.Continuation<? super kotlin.Unit> r19) {
        /*
            r17 = this;
            r0 = r17
            r1 = r18
            r2 = r19
            boolean r3 = r2 instanceof coil.memory.PoolableTargetDelegate$success$1
            if (r3 == 0) goto L_0x001a
            r3 = r2
            coil.memory.PoolableTargetDelegate$success$1 r3 = (coil.memory.PoolableTargetDelegate$success$1) r3
            int r4 = r3.label
            r5 = -2147483648(0xffffffff80000000, float:-0.0)
            r4 = r4 & r5
            if (r4 == 0) goto L_0x001a
            int r2 = r3.label
            int r2 = r2 - r5
            r3.label = r2
            goto L_0x001f
        L_0x001a:
            coil.memory.PoolableTargetDelegate$success$1 r3 = new coil.memory.PoolableTargetDelegate$success$1
            r3.<init>(r0, r2)
        L_0x001f:
            java.lang.Object r2 = r3.result
            java.lang.Object r4 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r5 = r3.label
            r6 = 2
            r7 = 1
            if (r5 == 0) goto L_0x005d
            if (r5 == r7) goto L_0x004e
            if (r5 != r6) goto L_0x0046
            java.lang.Object r1 = r3.L$3
            coil.EventListener r1 = (coil.EventListener) r1
            java.lang.Object r4 = r3.L$2
            coil.request.SuccessResult r4 = (coil.request.SuccessResult) r4
            java.lang.Object r5 = r3.L$1
            android.graphics.Bitmap r5 = (android.graphics.Bitmap) r5
            java.lang.Object r3 = r3.L$0
            coil.memory.PoolableTargetDelegate r3 = (coil.memory.PoolableTargetDelegate) r3
            kotlin.ResultKt.throwOnFailure(r2)
            r8 = r1
            r1 = r4
            goto L_0x0172
        L_0x0046:
            java.lang.IllegalStateException r1 = new java.lang.IllegalStateException
            java.lang.String r2 = "call to 'resume' before 'invoke' with coroutine"
            r1.<init>(r2)
            throw r1
        L_0x004e:
            java.lang.Object r1 = r3.L$1
            coil.EventListener r1 = (coil.EventListener) r1
            java.lang.Object r3 = r3.L$0
            coil.request.SuccessResult r3 = (coil.request.SuccessResult) r3
            kotlin.ResultKt.throwOnFailure(r2)
            r6 = r1
            r1 = r3
            goto L_0x00ed
        L_0x005d:
            kotlin.ResultKt.throwOnFailure(r2)
            r2 = r1
            coil.request.ImageResult r2 = (coil.request.ImageResult) r2
            android.graphics.Bitmap r5 = coil.memory.TargetDelegateKt.getBitmap(r2)
            coil.bitmap.BitmapReferenceCounter r8 = r17.referenceCounter
            boolean r8 = r8 instanceof coil.bitmap.EmptyBitmapReferenceCounter
            r9 = 0
            java.lang.String r10 = "' does not implement coil.transition.TransitionTarget."
            java.lang.String r11 = "' as '"
            java.lang.String r12 = "Ignoring '"
            r13 = 3
            java.lang.String r14 = "TargetDelegate"
            if (r8 == 0) goto L_0x00f6
            coil.target.PoolableViewTarget r5 = r17.getTarget()
            coil.target.Target r5 = (coil.target.Target) r5
            coil.EventListener r6 = r0.eventListener
            coil.util.Logger r8 = r0.logger
            coil.request.ImageRequest r15 = r18.getRequest()
            coil.transition.Transition r15 = r15.getTransition()
            coil.transition.Transition r7 = coil.transition.Transition.NONE
            if (r15 != r7) goto L_0x0098
            android.graphics.drawable.Drawable r1 = r18.getDrawable()
            r5.onSuccess(r1)
            goto L_0x017c
        L_0x0098:
            boolean r7 = r5 instanceof coil.transition.TransitionTarget
            if (r7 != 0) goto L_0x00d6
            coil.request.ImageRequest r2 = r18.getRequest()
            coil.request.DefinedRequestOptions r2 = r2.getDefined()
            coil.transition.Transition r2 = r2.getTransition()
            if (r2 == 0) goto L_0x00cd
            if (r8 == 0) goto L_0x00cd
            int r2 = r8.getLevel()
            if (r2 > r13) goto L_0x00cd
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            r2.append(r12)
            r2.append(r15)
            r2.append(r11)
            r2.append(r5)
            r2.append(r10)
            java.lang.String r2 = r2.toString()
            r8.log(r14, r13, r2, r9)
        L_0x00cd:
            android.graphics.drawable.Drawable r1 = r18.getDrawable()
            r5.onSuccess(r1)
            goto L_0x017c
        L_0x00d6:
            coil.request.ImageRequest r7 = r18.getRequest()
            r6.transitionStart(r7)
            coil.transition.TransitionTarget r5 = (coil.transition.TransitionTarget) r5
            r3.L$0 = r1
            r3.L$1 = r6
            r7 = 1
            r3.label = r7
            java.lang.Object r2 = r15.transition(r5, r2, r3)
            if (r2 != r4) goto L_0x00ed
            return r4
        L_0x00ed:
            coil.request.ImageRequest r1 = r1.getRequest()
            r6.transitionEnd(r1)
            goto L_0x017c
        L_0x00f6:
            r0.increment(r5)
            coil.target.PoolableViewTarget r7 = r17.getTarget()
            coil.target.Target r7 = (coil.target.Target) r7
            coil.EventListener r8 = r0.eventListener
            coil.util.Logger r15 = r0.logger
            coil.request.ImageRequest r16 = r18.getRequest()
            coil.transition.Transition r6 = r16.getTransition()
            coil.transition.Transition r9 = coil.transition.Transition.NONE
            if (r6 != r9) goto L_0x0117
            android.graphics.drawable.Drawable r1 = r18.getDrawable()
            r7.onSuccess(r1)
            goto L_0x0154
        L_0x0117:
            boolean r9 = r7 instanceof coil.transition.TransitionTarget
            if (r9 != 0) goto L_0x0156
            coil.request.ImageRequest r2 = r18.getRequest()
            coil.request.DefinedRequestOptions r2 = r2.getDefined()
            coil.transition.Transition r2 = r2.getTransition()
            if (r2 == 0) goto L_0x014d
            if (r15 == 0) goto L_0x014d
            int r2 = r15.getLevel()
            if (r2 > r13) goto L_0x014d
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            r2.append(r12)
            r2.append(r6)
            r2.append(r11)
            r2.append(r7)
            r2.append(r10)
            java.lang.String r2 = r2.toString()
            r3 = 0
            r15.log(r14, r13, r2, r3)
        L_0x014d:
            android.graphics.drawable.Drawable r1 = r18.getDrawable()
            r7.onSuccess(r1)
        L_0x0154:
            r3 = r0
            goto L_0x0179
        L_0x0156:
            coil.request.ImageRequest r9 = r18.getRequest()
            r8.transitionStart(r9)
            coil.transition.TransitionTarget r7 = (coil.transition.TransitionTarget) r7
            r3.L$0 = r0
            r3.L$1 = r5
            r3.L$2 = r1
            r3.L$3 = r8
            r9 = 2
            r3.label = r9
            java.lang.Object r2 = r6.transition(r7, r2, r3)
            if (r2 != r4) goto L_0x0171
            return r4
        L_0x0171:
            r3 = r0
        L_0x0172:
            coil.request.ImageRequest r1 = r1.getRequest()
            r8.transitionEnd(r1)
        L_0x0179:
            r3.decrement(r5)
        L_0x017c:
            kotlin.Unit r1 = kotlin.Unit.INSTANCE
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: coil.memory.PoolableTargetDelegate.success(coil.request.SuccessResult, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARNING: Removed duplicated region for block: B:14:0x0050  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0026  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.Object error(coil.request.ErrorResult r14, kotlin.coroutines.Continuation<? super kotlin.Unit> r15) {
        /*
            r13 = this;
            boolean r0 = r15 instanceof coil.memory.PoolableTargetDelegate$error$1
            if (r0 == 0) goto L_0x0014
            r0 = r15
            coil.memory.PoolableTargetDelegate$error$1 r0 = (coil.memory.PoolableTargetDelegate$error$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L_0x0014
            int r15 = r0.label
            int r15 = r15 - r2
            r0.label = r15
            goto L_0x0019
        L_0x0014:
            coil.memory.PoolableTargetDelegate$error$1 r0 = new coil.memory.PoolableTargetDelegate$error$1
            r0.<init>(r13, r15)
        L_0x0019:
            java.lang.Object r15 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 2
            r4 = 1
            r5 = 0
            if (r2 == 0) goto L_0x0050
            if (r2 == r4) goto L_0x0043
            if (r2 != r3) goto L_0x003b
            java.lang.Object r14 = r0.L$2
            coil.EventListener r14 = (coil.EventListener) r14
            java.lang.Object r1 = r0.L$1
            coil.request.ErrorResult r1 = (coil.request.ErrorResult) r1
            java.lang.Object r0 = r0.L$0
            coil.memory.PoolableTargetDelegate r0 = (coil.memory.PoolableTargetDelegate) r0
            kotlin.ResultKt.throwOnFailure(r15)
            goto L_0x0162
        L_0x003b:
            java.lang.IllegalStateException r14 = new java.lang.IllegalStateException
            java.lang.String r15 = "call to 'resume' before 'invoke' with coroutine"
            r14.<init>(r15)
            throw r14
        L_0x0043:
            java.lang.Object r14 = r0.L$1
            coil.EventListener r14 = (coil.EventListener) r14
            java.lang.Object r0 = r0.L$0
            coil.request.ErrorResult r0 = (coil.request.ErrorResult) r0
            kotlin.ResultKt.throwOnFailure(r15)
            goto L_0x00dc
        L_0x0050:
            kotlin.ResultKt.throwOnFailure(r15)
            coil.bitmap.BitmapReferenceCounter r15 = r13.referenceCounter
            boolean r15 = r15 instanceof coil.bitmap.EmptyBitmapReferenceCounter
            java.lang.String r2 = "' does not implement coil.transition.TransitionTarget."
            java.lang.String r6 = "' as '"
            java.lang.String r7 = "Ignoring '"
            r8 = 3
            java.lang.String r9 = "TargetDelegate"
            if (r15 == 0) goto L_0x00e5
            coil.target.PoolableViewTarget r15 = r13.getTarget()
            coil.target.Target r15 = (coil.target.Target) r15
            coil.EventListener r3 = r13.eventListener
            coil.util.Logger r10 = r13.logger
            coil.request.ImageRequest r11 = r14.getRequest()
            coil.transition.Transition r11 = r11.getTransition()
            coil.transition.Transition r12 = coil.transition.Transition.NONE
            if (r11 != r12) goto L_0x0083
            android.graphics.drawable.Drawable r14 = r14.getDrawable()
            r15.onError(r14)
            goto L_0x016c
        L_0x0083:
            boolean r12 = r15 instanceof coil.transition.TransitionTarget
            if (r12 != 0) goto L_0x00c1
            coil.request.ImageRequest r0 = r14.getRequest()
            coil.request.DefinedRequestOptions r0 = r0.getDefined()
            coil.transition.Transition r0 = r0.getTransition()
            if (r0 == 0) goto L_0x00b8
            if (r10 == 0) goto L_0x00b8
            int r0 = r10.getLevel()
            if (r0 > r8) goto L_0x00b8
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            r0.append(r7)
            r0.append(r11)
            r0.append(r6)
            r0.append(r15)
            r0.append(r2)
            java.lang.String r0 = r0.toString()
            r10.log(r9, r8, r0, r5)
        L_0x00b8:
            android.graphics.drawable.Drawable r14 = r14.getDrawable()
            r15.onError(r14)
            goto L_0x016c
        L_0x00c1:
            coil.request.ImageRequest r2 = r14.getRequest()
            r3.transitionStart(r2)
            coil.transition.TransitionTarget r15 = (coil.transition.TransitionTarget) r15
            r2 = r14
            coil.request.ImageResult r2 = (coil.request.ImageResult) r2
            r0.L$0 = r14
            r0.L$1 = r3
            r0.label = r4
            java.lang.Object r15 = r11.transition(r15, r2, r0)
            if (r15 != r1) goto L_0x00da
            return r1
        L_0x00da:
            r0 = r14
            r14 = r3
        L_0x00dc:
            coil.request.ImageRequest r15 = r0.getRequest()
            r14.transitionEnd(r15)
            goto L_0x016c
        L_0x00e5:
            r13.increment(r5)
            coil.target.PoolableViewTarget r15 = r13.getTarget()
            coil.target.Target r15 = (coil.target.Target) r15
            coil.EventListener r4 = r13.eventListener
            coil.util.Logger r10 = r13.logger
            coil.request.ImageRequest r11 = r14.getRequest()
            coil.transition.Transition r11 = r11.getTransition()
            coil.transition.Transition r12 = coil.transition.Transition.NONE
            if (r11 != r12) goto L_0x0106
            android.graphics.drawable.Drawable r14 = r14.getDrawable()
            r15.onError(r14)
            goto L_0x0142
        L_0x0106:
            boolean r12 = r15 instanceof coil.transition.TransitionTarget
            if (r12 != 0) goto L_0x0144
            coil.request.ImageRequest r0 = r14.getRequest()
            coil.request.DefinedRequestOptions r0 = r0.getDefined()
            coil.transition.Transition r0 = r0.getTransition()
            if (r0 == 0) goto L_0x013b
            if (r10 == 0) goto L_0x013b
            int r0 = r10.getLevel()
            if (r0 > r8) goto L_0x013b
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            r0.append(r7)
            r0.append(r11)
            r0.append(r6)
            r0.append(r15)
            r0.append(r2)
            java.lang.String r0 = r0.toString()
            r10.log(r9, r8, r0, r5)
        L_0x013b:
            android.graphics.drawable.Drawable r14 = r14.getDrawable()
            r15.onError(r14)
        L_0x0142:
            r0 = r13
            goto L_0x0169
        L_0x0144:
            coil.request.ImageRequest r2 = r14.getRequest()
            r4.transitionStart(r2)
            coil.transition.TransitionTarget r15 = (coil.transition.TransitionTarget) r15
            r2 = r14
            coil.request.ImageResult r2 = (coil.request.ImageResult) r2
            r0.L$0 = r13
            r0.L$1 = r14
            r0.L$2 = r4
            r0.label = r3
            java.lang.Object r15 = r11.transition(r15, r2, r0)
            if (r15 != r1) goto L_0x015f
            return r1
        L_0x015f:
            r0 = r13
            r1 = r14
            r14 = r4
        L_0x0162:
            coil.request.ImageRequest r15 = r1.getRequest()
            r14.transitionEnd(r15)
        L_0x0169:
            r0.decrement(r5)
        L_0x016c:
            kotlin.Unit r14 = kotlin.Unit.INSTANCE
            return r14
        */
        throw new UnsupportedOperationException("Method not decompiled: coil.memory.PoolableTargetDelegate.error(coil.request.ErrorResult, kotlin.coroutines.Continuation):java.lang.Object");
    }

    private final void replace(Bitmap bitmap, Function1<? super PoolableViewTarget<?>, Unit> function1) {
        if (this.referenceCounter instanceof EmptyBitmapReferenceCounter) {
            function1.invoke(getTarget());
            return;
        }
        increment(bitmap);
        function1.invoke(getTarget());
        decrement(bitmap);
    }

    /* access modifiers changed from: private */
    public final void increment(Bitmap bitmap) {
        if (bitmap != null) {
            this.referenceCounter.increment(bitmap);
        }
    }

    /* access modifiers changed from: private */
    public final void decrement(Bitmap bitmap) {
        Bitmap put = Extensions.getRequestManager(getTarget().getView()).put(this, bitmap);
        if (put != null) {
            this.referenceCounter.decrement(put);
        }
    }

    public void start(Drawable drawable, Bitmap bitmap) {
        if (this.referenceCounter instanceof EmptyBitmapReferenceCounter) {
            getTarget().onStart(drawable);
            return;
        }
        increment(bitmap);
        getTarget().onStart(drawable);
        decrement(bitmap);
    }

    public void clear() {
        if (this.referenceCounter instanceof EmptyBitmapReferenceCounter) {
            getTarget().onClear();
            return;
        }
        increment((Bitmap) null);
        getTarget().onClear();
        decrement((Bitmap) null);
    }
}
