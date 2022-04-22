package kotlin.reflect.jvm.internal.impl.utils;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* compiled from: JavaTypeEnhancementState.kt */
final class JavaTypeEnhancementState$description$2 extends Lambda implements Function0<String[]> {
    final /* synthetic */ JavaTypeEnhancementState this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    JavaTypeEnhancementState$description$2(JavaTypeEnhancementState javaTypeEnhancementState) {
        super(0);
        this.this$0 = javaTypeEnhancementState;
    }

    public final String[] invoke() {
        List arrayList = new ArrayList();
        arrayList.add(this.this$0.getGlobalJsr305Level().getDescription());
        ReportLevel migrationLevelForJsr305 = this.this$0.getMigrationLevelForJsr305();
        if (migrationLevelForJsr305 != null) {
            arrayList.add(Intrinsics.stringPlus("under-migration:", migrationLevelForJsr305.getDescription()));
        }
        for (Map.Entry next : this.this$0.getUserDefinedLevelForSpecificJsr305Annotation().entrySet()) {
            arrayList.add('@' + ((String) next.getKey()) + ':' + ((ReportLevel) next.getValue()).getDescription());
        }
        Object[] array = arrayList.toArray(new String[0]);
        Objects.requireNonNull(array, "null cannot be cast to non-null type kotlin.Array<T>");
        return (String[]) array;
    }
}
