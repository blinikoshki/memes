package coil.request;

import coil.target.ViewTarget;
import coil.util.Extensions;
import java.util.UUID;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\b\u0000\u0018\u00002\u00020\u0001B\u0019\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\u0010\u0004\u001a\u0006\u0012\u0002\b\u00030\u0005¢\u0006\u0002\u0010\u0006J\u0011\u0010\n\u001a\u00020\u000bH@ø\u0001\u0000¢\u0006\u0002\u0010\fJ\b\u0010\r\u001a\u00020\u000bH\u0016R\u0014\u0010\u0007\u001a\u00020\b8VX\u0004¢\u0006\u0006\u001a\u0004\b\u0007\u0010\tR\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u0012\u0010\u0004\u001a\u0006\u0012\u0002\b\u00030\u0005X\u0004¢\u0006\u0002\n\u0000\u0002\u0004\n\u0002\b\u0019¨\u0006\u000e"}, mo26107d2 = {"Lcoil/request/ViewTargetDisposable;", "Lcoil/request/Disposable;", "requestId", "Ljava/util/UUID;", "target", "Lcoil/target/ViewTarget;", "(Ljava/util/UUID;Lcoil/target/ViewTarget;)V", "isDisposed", "", "()Z", "await", "", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "dispose", "coil-base_release"}, mo26108k = 1, mo26109mv = {1, 4, 1})
/* compiled from: Disposable.kt */
public final class ViewTargetDisposable implements Disposable {
    private final UUID requestId;
    private final ViewTarget<?> target;

    public ViewTargetDisposable(UUID uuid, ViewTarget<?> viewTarget) {
        Intrinsics.checkNotNullParameter(uuid, "requestId");
        Intrinsics.checkNotNullParameter(viewTarget, "target");
        this.requestId = uuid;
        this.target = viewTarget;
    }

    public boolean isDisposed() {
        return !Intrinsics.areEqual((Object) Extensions.getRequestManager(this.target.getView()).getCurrentRequestId(), (Object) this.requestId);
    }

    public void dispose() {
        if (!isDisposed()) {
            Extensions.getRequestManager(this.target.getView()).clearCurrentRequest();
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x0032  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0024  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.Object await(kotlin.coroutines.Continuation<? super kotlin.Unit> r5) {
        /*
            r4 = this;
            boolean r0 = r5 instanceof coil.request.ViewTargetDisposable$await$1
            if (r0 == 0) goto L_0x0014
            r0 = r5
            coil.request.ViewTargetDisposable$await$1 r0 = (coil.request.ViewTargetDisposable$await$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L_0x0014
            int r5 = r0.label
            int r5 = r5 - r2
            r0.label = r5
            goto L_0x0019
        L_0x0014:
            coil.request.ViewTargetDisposable$await$1 r0 = new coil.request.ViewTargetDisposable$await$1
            r0.<init>(r4, r5)
        L_0x0019:
            java.lang.Object r5 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L_0x0032
            if (r2 != r3) goto L_0x002a
            kotlin.ResultKt.throwOnFailure(r5)
            goto L_0x0057
        L_0x002a:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r0)
            throw r5
        L_0x0032:
            kotlin.ResultKt.throwOnFailure(r5)
            boolean r5 = r4.isDisposed()
            if (r5 == 0) goto L_0x003e
            kotlin.Unit r5 = kotlin.Unit.INSTANCE
            return r5
        L_0x003e:
            coil.target.ViewTarget<?> r5 = r4.target
            android.view.View r5 = r5.getView()
            coil.memory.ViewTargetRequestManager r5 = coil.util.Extensions.getRequestManager(r5)
            kotlinx.coroutines.Job r5 = r5.getCurrentRequestJob()
            if (r5 == 0) goto L_0x0057
            r0.label = r3
            java.lang.Object r5 = r5.join(r0)
            if (r5 != r1) goto L_0x0057
            return r1
        L_0x0057:
            kotlin.Unit r5 = kotlin.Unit.INSTANCE
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: coil.request.ViewTargetDisposable.await(kotlin.coroutines.Continuation):java.lang.Object");
    }
}
