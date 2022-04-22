package kotlin.reflect.jvm.internal;

import java.lang.reflect.Type;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0000\u001a\n \u0002*\u0004\u0018\u00010\u00010\u0001\"\u0006\b\u0000\u0010\u0003 \u0001H\n¢\u0006\u0002\b\u0004"}, mo26107d2 = {"<anonymous>", "Lkotlin/reflect/jvm/internal/KTypeImpl;", "kotlin.jvm.PlatformType", "R", "invoke"}, mo26108k = 3, mo26109mv = {1, 4, 1})
/* compiled from: KCallableImpl.kt */
final class KCallableImpl$_returnType$1 extends Lambda implements Function0<KTypeImpl> {
    final /* synthetic */ KCallableImpl this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    KCallableImpl$_returnType$1(KCallableImpl kCallableImpl) {
        super(0);
        this.this$0 = kCallableImpl;
    }

    public final KTypeImpl invoke() {
        KotlinType returnType = this.this$0.getDescriptor().getReturnType();
        Intrinsics.checkNotNull(returnType);
        Intrinsics.checkNotNullExpressionValue(returnType, "descriptor.returnType!!");
        return new KTypeImpl(returnType, new Function0<Type>(this) {
            final /* synthetic */ KCallableImpl$_returnType$1 this$0;

            {
                this.this$0 = r1;
            }

            public final Type invoke() {
                Type access$extractContinuationArgument = this.this$0.this$0.extractContinuationArgument();
                return access$extractContinuationArgument != null ? access$extractContinuationArgument : this.this$0.this$0.getCaller().getReturnType();
            }
        });
    }
}
