package kotlin.reflect.jvm;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KClass;
import kotlin.reflect.jvm.internal.KClassImpl;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0019\u0010\u0000\u001a\u00020\u0001*\u0006\u0012\u0002\b\u00030\u00028F¢\u0006\u0006\u001a\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, mo26107d2 = {"jvmName", "", "Lkotlin/reflect/KClass;", "getJvmName", "(Lkotlin/reflect/KClass;)Ljava/lang/String;", "kotlin-reflection"}, mo26108k = 2, mo26109mv = {1, 4, 1})
/* compiled from: KClassesJvm.kt */
public final class KClassesJvm {
    public static final String getJvmName(KClass<?> kClass) {
        Intrinsics.checkNotNullParameter(kClass, "$this$jvmName");
        String name = ((KClassImpl) kClass).getJClass().getName();
        Intrinsics.checkNotNullExpressionValue(name, "(this as KClassImpl).jClass.name");
        return name;
    }
}
