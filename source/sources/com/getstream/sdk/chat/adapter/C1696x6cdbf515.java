package com.getstream.sdk.chat.adapter;

import com.facebook.share.internal.ShareConstants;
import com.getstream.sdk.chat.view.MessageListView;
import kotlin.Function;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionAdapter;
import kotlin.jvm.internal.Intrinsics;
import p015io.getstream.chat.android.client.models.Message;

@Metadata(mo26105bv = {1, 0, 3}, mo26108k = 3, mo26109mv = {1, 4, 2})
/* renamed from: com.getstream.sdk.chat.adapter.ListenerContainerImpl$sam$com_getstream_sdk_chat_view_MessageListView_MessageLongClickListener$0 */
/* compiled from: ListenerContainerImpl.kt */
final class C1696x6cdbf515 implements MessageListView.MessageLongClickListener, FunctionAdapter {
    private final /* synthetic */ Function1 function;

    C1696x6cdbf515(Function1 function1) {
        this.function = function1;
    }

    public boolean equals(Object obj) {
        return (obj instanceof MessageListView.MessageLongClickListener) && (obj instanceof FunctionAdapter) && Intrinsics.areEqual((Object) this.function, (Object) ((FunctionAdapter) obj).getFunctionDelegate());
    }

    public Function getFunctionDelegate() {
        return this.function;
    }

    public int hashCode() {
        return this.function.hashCode();
    }

    public final /* synthetic */ void onMessageLongClick(Message message) {
        Intrinsics.checkNotNullParameter(message, ShareConstants.WEB_DIALOG_PARAM_MESSAGE);
        Intrinsics.checkNotNullExpressionValue(this.function.invoke(message), "invoke(...)");
    }
}
