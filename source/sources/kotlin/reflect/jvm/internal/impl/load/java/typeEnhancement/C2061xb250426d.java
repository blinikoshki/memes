package kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement;

import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.SignatureEnhancementBuilder;

/* renamed from: kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.PredefinedEnhancementInfoKt$PREDEFINED_FUNCTION_ENHANCEMENT_INFO_BY_SIGNATURE$1$1$1$1 */
/* compiled from: predefinedEnhancementInfo.kt */
final class C2061xb250426d extends Lambda implements Function1<SignatureEnhancementBuilder.ClassEnhancementBuilder.FunctionEnhancementBuilder, Unit> {
    final /* synthetic */ String $JFConsumer;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    C2061xb250426d(String str) {
        super(1);
        this.$JFConsumer = str;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((SignatureEnhancementBuilder.ClassEnhancementBuilder.FunctionEnhancementBuilder) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(SignatureEnhancementBuilder.ClassEnhancementBuilder.FunctionEnhancementBuilder functionEnhancementBuilder) {
        Intrinsics.checkNotNullParameter(functionEnhancementBuilder, "<this>");
        functionEnhancementBuilder.parameter(this.$JFConsumer, PredefinedEnhancementInfoKt.NOT_PLATFORM, PredefinedEnhancementInfoKt.NOT_PLATFORM);
    }
}
