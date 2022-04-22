package com.getstream.sdk.chat.adapter;

import com.facebook.internal.NativeProtocol;
import com.facebook.share.internal.ShareConstants;
import com.getstream.sdk.chat.enums.GiphyAction;
import com.getstream.sdk.chat.view.MessageListView;
import kotlin.Function;
import kotlin.Metadata;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.FunctionAdapter;
import kotlin.jvm.internal.Intrinsics;
import p015io.getstream.chat.android.client.models.Message;

@Metadata(mo26105bv = {1, 0, 3}, mo26108k = 3, mo26109mv = {1, 4, 2})
/* renamed from: com.getstream.sdk.chat.adapter.ListenerContainerImpl$sam$com_getstream_sdk_chat_view_MessageListView_GiphySendListener$0 */
/* compiled from: ListenerContainerImpl.kt */
final class C1694xe0fe5057 implements MessageListView.GiphySendListener, FunctionAdapter {
    private final /* synthetic */ Function2 function;

    C1694xe0fe5057(Function2 function2) {
        this.function = function2;
    }

    public boolean equals(Object obj) {
        return (obj instanceof MessageListView.GiphySendListener) && (obj instanceof FunctionAdapter) && Intrinsics.areEqual((Object) this.function, (Object) ((FunctionAdapter) obj).getFunctionDelegate());
    }

    public Function getFunctionDelegate() {
        return this.function;
    }

    public int hashCode() {
        return this.function.hashCode();
    }

    public final /* synthetic */ void onGiphySend(Message message, GiphyAction giphyAction) {
        Intrinsics.checkNotNullParameter(message, ShareConstants.WEB_DIALOG_PARAM_MESSAGE);
        Intrinsics.checkNotNullParameter(giphyAction, NativeProtocol.WEB_DIALOG_ACTION);
        Intrinsics.checkNotNullExpressionValue(this.function.invoke(message, giphyAction), "invoke(...)");
    }
}
