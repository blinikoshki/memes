package com.getstream.sdk.chat.adapter;

import com.facebook.internal.NativeProtocol;
import com.facebook.share.internal.ShareConstants;
import com.getstream.sdk.chat.enums.GiphyAction;
import com.getstream.sdk.chat.view.MessageListView;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import p015io.getstream.chat.android.client.models.Message;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00010\u0003H\n¢\u0006\u0002\b\u0004"}, mo26107d2 = {"<anonymous>", "Lcom/getstream/sdk/chat/view/MessageListView$GiphySendListener;", "realListener", "Lkotlin/Function0;", "invoke"}, mo26108k = 3, mo26109mv = {1, 4, 2})
/* compiled from: ListenerContainerImpl.kt */
final class ListenerContainerImpl$giphySendListener$2 extends Lambda implements Function1<Function0<? extends MessageListView.GiphySendListener>, MessageListView.GiphySendListener> {
    public static final ListenerContainerImpl$giphySendListener$2 INSTANCE = new ListenerContainerImpl$giphySendListener$2();

    ListenerContainerImpl$giphySendListener$2() {
        super(1);
    }

    public final MessageListView.GiphySendListener invoke(final Function0<? extends MessageListView.GiphySendListener> function0) {
        Intrinsics.checkNotNullParameter(function0, "realListener");
        return new MessageListView.GiphySendListener() {
            public final void onGiphySend(Message message, GiphyAction giphyAction) {
                Intrinsics.checkNotNullParameter(message, ShareConstants.WEB_DIALOG_PARAM_MESSAGE);
                Intrinsics.checkNotNullParameter(giphyAction, NativeProtocol.WEB_DIALOG_ACTION);
                ((MessageListView.GiphySendListener) function0.invoke()).onGiphySend(message, giphyAction);
            }
        };
    }
}
