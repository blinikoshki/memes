package kotlin.reflect.jvm.internal.impl.types;

import java.util.List;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.jvm.internal.impl.types.AbstractTypeConstructor;
import kotlin.reflect.jvm.internal.impl.types.checker.KotlinTypeRefinerKt;

/* renamed from: kotlin.reflect.jvm.internal.impl.types.AbstractTypeConstructor$ModuleViewTypeConstructor$refinedSupertypes$2 */
/* compiled from: AbstractTypeConstructor.kt */
final class C2202x16a0f668 extends Lambda implements Function0<List<? extends KotlinType>> {
    final /* synthetic */ AbstractTypeConstructor.ModuleViewTypeConstructor this$0;
    final /* synthetic */ AbstractTypeConstructor this$1;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    C2202x16a0f668(AbstractTypeConstructor.ModuleViewTypeConstructor moduleViewTypeConstructor, AbstractTypeConstructor abstractTypeConstructor) {
        super(0);
        this.this$0 = moduleViewTypeConstructor;
        this.this$1 = abstractTypeConstructor;
    }

    public final List<KotlinType> invoke() {
        return KotlinTypeRefinerKt.refineTypes(this.this$0.kotlinTypeRefiner, this.this$1.getSupertypes());
    }
}
