package com.getstream.sdk.chat.adapter;

import com.facebook.share.internal.MessengerShareContentUtility;
import com.facebook.share.internal.ShareConstants;
import com.getstream.sdk.chat.view.MessageListView;
import kotlin.Function;
import kotlin.Metadata;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.FunctionAdapter;
import kotlin.jvm.internal.Intrinsics;
import p015io.getstream.chat.android.client.models.Attachment;
import p015io.getstream.chat.android.client.models.Message;

@Metadata(mo26105bv = {1, 0, 3}, mo26108k = 3, mo26109mv = {1, 4, 2})
/* renamed from: com.getstream.sdk.chat.adapter.ListenerContainerImpl$sam$com_getstream_sdk_chat_view_MessageListView_AttachmentClickListener$0 */
/* compiled from: ListenerContainerImpl.kt */
final class C1693xcd61db75 implements MessageListView.AttachmentClickListener, FunctionAdapter {
    private final /* synthetic */ Function2 function;

    C1693xcd61db75(Function2 function2) {
        this.function = function2;
    }

    public boolean equals(Object obj) {
        return (obj instanceof MessageListView.AttachmentClickListener) && (obj instanceof FunctionAdapter) && Intrinsics.areEqual((Object) this.function, (Object) ((FunctionAdapter) obj).getFunctionDelegate());
    }

    public Function getFunctionDelegate() {
        return this.function;
    }

    public int hashCode() {
        return this.function.hashCode();
    }

    public final /* synthetic */ void onAttachmentClick(Message message, Attachment attachment) {
        Intrinsics.checkNotNullParameter(message, ShareConstants.WEB_DIALOG_PARAM_MESSAGE);
        Intrinsics.checkNotNullParameter(attachment, MessengerShareContentUtility.ATTACHMENT);
        Intrinsics.checkNotNullExpressionValue(this.function.invoke(message, attachment), "invoke(...)");
    }
}
