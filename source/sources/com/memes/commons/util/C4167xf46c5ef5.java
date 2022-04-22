package com.memes.commons.util;

import com.memes.commons.pagination.Paginator;
import kotlin.Function;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.FunctionAdapter;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo26105bv = {1, 0, 3}, mo26108k = 3, mo26109mv = {1, 4, 2})
/* renamed from: com.memes.commons.util.ExtensionsKt$sam$i$com_memes_commons_pagination_Paginator_OnLoadMoreListener$0 */
/* compiled from: Extensions.kt */
public final class C4167xf46c5ef5 implements Paginator.OnLoadMoreListener, FunctionAdapter {
    private final /* synthetic */ Function0 function;

    public C4167xf46c5ef5(Function0 function0) {
        this.function = function0;
    }

    public boolean equals(Object obj) {
        return (obj instanceof Paginator.OnLoadMoreListener) && (obj instanceof FunctionAdapter) && Intrinsics.areEqual((Object) this.function, (Object) ((FunctionAdapter) obj).getFunctionDelegate());
    }

    public Function getFunctionDelegate() {
        return this.function;
    }

    public int hashCode() {
        return this.function.hashCode();
    }

    public final /* synthetic */ void onLoadMore() {
        Intrinsics.checkNotNullExpressionValue(this.function.invoke(), "invoke(...)");
    }
}
