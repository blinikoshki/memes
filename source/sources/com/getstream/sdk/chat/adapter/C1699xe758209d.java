package com.getstream.sdk.chat.adapter;

import com.getstream.sdk.chat.view.MessageListView;
import java.util.List;
import kotlin.Function;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionAdapter;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo26105bv = {1, 0, 3}, mo26108k = 3, mo26109mv = {1, 4, 2})
/* renamed from: com.getstream.sdk.chat.adapter.ListenerContainerImpl$sam$com_getstream_sdk_chat_view_MessageListView_ReadStateClickListener$0 */
/* compiled from: ListenerContainerImpl.kt */
final class C1699xe758209d implements MessageListView.ReadStateClickListener, FunctionAdapter {
    private final /* synthetic */ Function1 function;

    C1699xe758209d(Function1 function1) {
        this.function = function1;
    }

    public boolean equals(Object obj) {
        return (obj instanceof MessageListView.ReadStateClickListener) && (obj instanceof FunctionAdapter) && Intrinsics.areEqual((Object) this.function, (Object) ((FunctionAdapter) obj).getFunctionDelegate());
    }

    public Function getFunctionDelegate() {
        return this.function;
    }

    public int hashCode() {
        return this.function.hashCode();
    }

    public final /* synthetic */ void onReadStateClick(List list) {
        Intrinsics.checkNotNullParameter(list, "reads");
        Intrinsics.checkNotNullExpressionValue(this.function.invoke(list), "invoke(...)");
    }
}
