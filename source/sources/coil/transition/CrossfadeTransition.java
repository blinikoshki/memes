package coil.transition;

import kotlin.Metadata;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0007\b\u0017¢\u0006\u0002\u0010\u0002B\u0011\b\u0017\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005B\u0019\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u0013\u0010\r\u001a\u00020\u00072\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fH\u0002J\b\u0010\u0010\u001a\u00020\u0004H\u0016J\b\u0010\u0011\u001a\u00020\u0012H\u0016J!\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0018H@ø\u0001\u0000¢\u0006\u0002\u0010\u0019R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f\u0002\u0004\n\u0002\b\u0019¨\u0006\u001a"}, mo26107d2 = {"Lcoil/transition/CrossfadeTransition;", "Lcoil/transition/Transition;", "()V", "durationMillis", "", "(I)V", "preferExactIntrinsicSize", "", "(IZ)V", "getDurationMillis", "()I", "getPreferExactIntrinsicSize", "()Z", "equals", "other", "", "hashCode", "toString", "", "transition", "", "target", "Lcoil/transition/TransitionTarget;", "result", "Lcoil/request/ImageResult;", "(Lcoil/transition/TransitionTarget;Lcoil/request/ImageResult;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "coil-base_release"}, mo26108k = 1, mo26109mv = {1, 4, 1})
/* compiled from: CrossfadeTransition.kt */
public final class CrossfadeTransition implements Transition {
    private final int durationMillis;
    private final boolean preferExactIntrinsicSize;

    public CrossfadeTransition(int i, boolean z) {
        this.durationMillis = i;
        this.preferExactIntrinsicSize = z;
        if (!(i > 0)) {
            throw new IllegalArgumentException("durationMillis must be > 0.".toString());
        }
    }

    public final int getDurationMillis() {
        return this.durationMillis;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ CrossfadeTransition(int i, boolean z, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i2 & 1) != 0 ? 100 : i, (i2 & 2) != 0 ? false : z);
    }

    public final boolean getPreferExactIntrinsicSize() {
        return this.preferExactIntrinsicSize;
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v8, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v12, resolved type: kotlin.jvm.internal.Ref$ObjectRef} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:15:0x004f  */
    /* JADX WARNING: Removed duplicated region for block: B:54:0x0114 A[Catch:{ all -> 0x0138 }] */
    /* JADX WARNING: Removed duplicated region for block: B:55:0x011b A[Catch:{ all -> 0x0138 }] */
    /* JADX WARNING: Removed duplicated region for block: B:60:0x012f A[Catch:{ all -> 0x0138 }] */
    /* JADX WARNING: Removed duplicated region for block: B:62:0x0134 A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x002c  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.Object transition(coil.transition.TransitionTarget r19, coil.request.ImageResult r20, kotlin.coroutines.Continuation<? super kotlin.Unit> r21) {
        /*
            r18 = this;
            r1 = r18
            r0 = r19
            r2 = r20
            r3 = r21
            boolean r4 = r3 instanceof coil.transition.CrossfadeTransition$transition$1
            if (r4 == 0) goto L_0x001c
            r4 = r3
            coil.transition.CrossfadeTransition$transition$1 r4 = (coil.transition.CrossfadeTransition$transition$1) r4
            int r5 = r4.label
            r6 = -2147483648(0xffffffff80000000, float:-0.0)
            r5 = r5 & r6
            if (r5 == 0) goto L_0x001c
            int r3 = r4.label
            int r3 = r3 - r6
            r4.label = r3
            goto L_0x0021
        L_0x001c:
            coil.transition.CrossfadeTransition$transition$1 r4 = new coil.transition.CrossfadeTransition$transition$1
            r4.<init>(r1, r3)
        L_0x0021:
            java.lang.Object r3 = r4.result
            java.lang.Object r5 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r6 = r4.label
            r7 = 1
            if (r6 == 0) goto L_0x004f
            if (r6 != r7) goto L_0x0047
            java.lang.Object r0 = r4.L$3
            r2 = r0
            kotlin.jvm.internal.Ref$ObjectRef r2 = (kotlin.jvm.internal.Ref.ObjectRef) r2
            java.lang.Object r0 = r4.L$2
            coil.request.ImageResult r0 = (coil.request.ImageResult) r0
            java.lang.Object r0 = r4.L$1
            coil.transition.TransitionTarget r0 = (coil.transition.TransitionTarget) r0
            java.lang.Object r0 = r4.L$0
            coil.transition.CrossfadeTransition r0 = (coil.transition.CrossfadeTransition) r0
            kotlin.ResultKt.throwOnFailure(r3)     // Catch:{ all -> 0x0044 }
            goto L_0x0135
        L_0x0044:
            r0 = move-exception
            goto L_0x013a
        L_0x0047:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.String r2 = "call to 'resume' before 'invoke' with coroutine"
            r0.<init>(r2)
            throw r0
        L_0x004f:
            kotlin.ResultKt.throwOnFailure(r3)
            boolean r3 = r2 instanceof coil.request.SuccessResult
            if (r3 == 0) goto L_0x006f
            r6 = r2
            coil.request.SuccessResult r6 = (coil.request.SuccessResult) r6
            coil.request.ImageResult$Metadata r8 = r6.getMetadata()
            coil.decode.DataSource r8 = r8.getDataSource()
            coil.decode.DataSource r9 = coil.decode.DataSource.MEMORY_CACHE
            if (r8 != r9) goto L_0x006f
            android.graphics.drawable.Drawable r2 = r6.getDrawable()
            r0.onSuccess(r2)
            kotlin.Unit r0 = kotlin.Unit.INSTANCE
            return r0
        L_0x006f:
            android.view.View r6 = r19.getView()
            int r6 = r6.getVisibility()
            r8 = 0
            if (r6 != 0) goto L_0x007c
            r6 = 1
            goto L_0x007d
        L_0x007c:
            r6 = 0
        L_0x007d:
            if (r6 != 0) goto L_0x0099
            if (r3 == 0) goto L_0x008b
            coil.request.SuccessResult r2 = (coil.request.SuccessResult) r2
            android.graphics.drawable.Drawable r2 = r2.getDrawable()
            r0.onSuccess(r2)
            goto L_0x0096
        L_0x008b:
            boolean r3 = r2 instanceof coil.request.ErrorResult
            if (r3 == 0) goto L_0x0096
            android.graphics.drawable.Drawable r2 = r20.getDrawable()
            r0.onError(r2)
        L_0x0096:
            kotlin.Unit r0 = kotlin.Unit.INSTANCE
            return r0
        L_0x0099:
            kotlin.jvm.internal.Ref$ObjectRef r3 = new kotlin.jvm.internal.Ref$ObjectRef
            r3.<init>()
            r6 = 0
            r9 = r6
            coil.drawable.CrossfadeDrawable r9 = (coil.drawable.CrossfadeDrawable) r9
            r3.element = r9
            r4.L$0 = r1     // Catch:{ all -> 0x0138 }
            r4.L$1 = r0     // Catch:{ all -> 0x0138 }
            r4.L$2 = r2     // Catch:{ all -> 0x0138 }
            r4.L$3 = r3     // Catch:{ all -> 0x0138 }
            r4.label = r7     // Catch:{ all -> 0x0138 }
            kotlinx.coroutines.CancellableContinuationImpl r9 = new kotlinx.coroutines.CancellableContinuationImpl     // Catch:{ all -> 0x0138 }
            kotlin.coroutines.Continuation r10 = kotlin.coroutines.intrinsics.IntrinsicsKt.intercepted(r4)     // Catch:{ all -> 0x0138 }
            r9.<init>(r10, r7)     // Catch:{ all -> 0x0138 }
            r9.initCancellability()     // Catch:{ all -> 0x0138 }
            r10 = r9
            kotlinx.coroutines.CancellableContinuation r10 = (kotlinx.coroutines.CancellableContinuation) r10     // Catch:{ all -> 0x0138 }
            coil.drawable.CrossfadeDrawable r15 = new coil.drawable.CrossfadeDrawable     // Catch:{ all -> 0x0138 }
            android.graphics.drawable.Drawable r12 = r19.getDrawable()     // Catch:{ all -> 0x0138 }
            android.graphics.drawable.Drawable r13 = r20.getDrawable()     // Catch:{ all -> 0x0138 }
            android.view.View r11 = r19.getView()     // Catch:{ all -> 0x0138 }
            boolean r14 = r11 instanceof android.widget.ImageView     // Catch:{ all -> 0x0138 }
            if (r14 != 0) goto L_0x00d0
            goto L_0x00d1
        L_0x00d0:
            r6 = r11
        L_0x00d1:
            android.widget.ImageView r6 = (android.widget.ImageView) r6     // Catch:{ all -> 0x0138 }
            if (r6 == 0) goto L_0x00dc
            coil.size.Scale r6 = coil.util.Extensions.getScale(r6)     // Catch:{ all -> 0x0138 }
            if (r6 == 0) goto L_0x00dc
            goto L_0x00de
        L_0x00dc:
            coil.size.Scale r6 = coil.size.Scale.FILL     // Catch:{ all -> 0x0138 }
        L_0x00de:
            r14 = r6
            int r6 = r18.getDurationMillis()     // Catch:{ all -> 0x0138 }
            boolean r11 = r2 instanceof coil.request.SuccessResult     // Catch:{ all -> 0x0138 }
            if (r11 == 0) goto L_0x00f8
            r11 = r2
            coil.request.SuccessResult r11 = (coil.request.SuccessResult) r11     // Catch:{ all -> 0x0138 }
            coil.request.ImageResult$Metadata r11 = r11.getMetadata()     // Catch:{ all -> 0x0138 }
            boolean r11 = r11.isPlaceholderMemoryCacheKeyPresent()     // Catch:{ all -> 0x0138 }
            if (r11 != 0) goto L_0x00f5
            goto L_0x00f8
        L_0x00f5:
            r16 = 0
            goto L_0x00fa
        L_0x00f8:
            r16 = 1
        L_0x00fa:
            boolean r17 = r18.getPreferExactIntrinsicSize()     // Catch:{ all -> 0x0138 }
            r11 = r15
            r7 = r15
            r15 = r6
            r11.<init>(r12, r13, r14, r15, r16, r17)     // Catch:{ all -> 0x0138 }
            r3.element = r7     // Catch:{ all -> 0x0138 }
            coil.transition.CrossfadeTransition$transition$2$1 r6 = new coil.transition.CrossfadeTransition$transition$2$1     // Catch:{ all -> 0x0138 }
            r6.<init>(r7, r10)     // Catch:{ all -> 0x0138 }
            androidx.vectordrawable.graphics.drawable.Animatable2Compat$AnimationCallback r6 = (androidx.vectordrawable.graphics.drawable.Animatable2Compat.AnimationCallback) r6     // Catch:{ all -> 0x0138 }
            r7.registerAnimationCallback(r6)     // Catch:{ all -> 0x0138 }
            boolean r6 = r2 instanceof coil.request.SuccessResult     // Catch:{ all -> 0x0138 }
            if (r6 == 0) goto L_0x011b
            r15 = r7
            android.graphics.drawable.Drawable r15 = (android.graphics.drawable.Drawable) r15     // Catch:{ all -> 0x0138 }
            r0.onSuccess(r15)     // Catch:{ all -> 0x0138 }
            goto L_0x0125
        L_0x011b:
            boolean r2 = r2 instanceof coil.request.ErrorResult     // Catch:{ all -> 0x0138 }
            if (r2 == 0) goto L_0x0125
            r15 = r7
            android.graphics.drawable.Drawable r15 = (android.graphics.drawable.Drawable) r15     // Catch:{ all -> 0x0138 }
            r0.onError(r15)     // Catch:{ all -> 0x0138 }
        L_0x0125:
            java.lang.Object r0 = r9.getResult()     // Catch:{ all -> 0x0138 }
            java.lang.Object r2 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()     // Catch:{ all -> 0x0138 }
            if (r0 != r2) goto L_0x0132
            kotlin.coroutines.jvm.internal.DebugProbesKt.probeCoroutineSuspended(r4)     // Catch:{ all -> 0x0138 }
        L_0x0132:
            if (r0 != r5) goto L_0x0135
            return r5
        L_0x0135:
            kotlin.Unit r0 = kotlin.Unit.INSTANCE
            return r0
        L_0x0138:
            r0 = move-exception
            r2 = r3
        L_0x013a:
            T r2 = r2.element
            coil.drawable.CrossfadeDrawable r2 = (coil.drawable.CrossfadeDrawable) r2
            if (r2 == 0) goto L_0x0143
            r2.stop()
        L_0x0143:
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: coil.transition.CrossfadeTransition.transition(coil.transition.TransitionTarget, coil.request.ImageResult, kotlin.coroutines.Continuation):java.lang.Object");
    }

    public boolean equals(Object obj) {
        return this == obj || ((obj instanceof CrossfadeTransition) && this.durationMillis == ((CrossfadeTransition) obj).durationMillis);
    }

    public int hashCode() {
        return this.durationMillis;
    }

    public String toString() {
        return "CrossfadeTransition(durationMillis=" + this.durationMillis + ')';
    }

    public CrossfadeTransition() {
        this(0, false, 3, (DefaultConstructorMarker) null);
    }

    public CrossfadeTransition(int i) {
        this(i, false, 2, (DefaultConstructorMarker) null);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ CrossfadeTransition(int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i2 & 1) != 0 ? 100 : i);
    }
}
