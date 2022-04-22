package com.getstream.sdk.chat.adapter;

import com.getstream.sdk.chat.view.MessageListView;
import kotlin.Function;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionAdapter;
import kotlin.jvm.internal.Intrinsics;
import p015io.getstream.chat.android.client.models.User;

@Metadata(mo26105bv = {1, 0, 3}, mo26108k = 3, mo26109mv = {1, 4, 2})
/* renamed from: com.getstream.sdk.chat.adapter.ListenerContainerImpl$sam$com_getstream_sdk_chat_view_MessageListView_UserClickListener$0 */
/* compiled from: ListenerContainerImpl.kt */
final class C1700xb873c7cd implements MessageListView.UserClickListener, FunctionAdapter {
    private final /* synthetic */ Function1 function;

    C1700xb873c7cd(Function1 function1) {
        this.function = function1;
    }

    public boolean equals(Object obj) {
        return (obj instanceof MessageListView.UserClickListener) && (obj instanceof FunctionAdapter) && Intrinsics.areEqual((Object) this.function, (Object) ((FunctionAdapter) obj).getFunctionDelegate());
    }

    public Function getFunctionDelegate() {
        return this.function;
    }

    public int hashCode() {
        return this.function.hashCode();
    }

    public final /* synthetic */ void onUserClick(User user) {
        Intrinsics.checkNotNullParameter(user, "user");
        Intrinsics.checkNotNullExpressionValue(this.function.invoke(user), "invoke(...)");
    }
}
