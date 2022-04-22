package com.getstream.sdk.chat.style;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\b\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\t\u001a\u00020\u0004H\u0016J\b\u0010\n\u001a\u00020\u000bH\u0016R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\b¨\u0006\f"}, mo26107d2 = {"Lcom/getstream/sdk/chat/style/ChatStyleImpl;", "Lcom/getstream/sdk/chat/style/ChatStyle;", "()V", "defaultTextStyle", "Lcom/getstream/sdk/chat/style/TextStyle;", "getDefaultTextStyle$stream_chat_android_ui_common_release", "()Lcom/getstream/sdk/chat/style/TextStyle;", "setDefaultTextStyle$stream_chat_android_ui_common_release", "(Lcom/getstream/sdk/chat/style/TextStyle;)V", "getDefaultTextStyle", "hasDefaultFont", "", "stream-chat-android-ui-common_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
/* compiled from: ChatStyleImpl.kt */
public final class ChatStyleImpl implements ChatStyle {
    private TextStyle defaultTextStyle;

    public final TextStyle getDefaultTextStyle$stream_chat_android_ui_common_release() {
        return this.defaultTextStyle;
    }

    public final void setDefaultTextStyle$stream_chat_android_ui_common_release(TextStyle textStyle) {
        this.defaultTextStyle = textStyle;
    }

    public boolean hasDefaultFont() {
        TextStyle textStyle = this.defaultTextStyle;
        return textStyle != null && textStyle.hasFont();
    }

    public TextStyle getDefaultTextStyle() {
        TextStyle textStyle = this.defaultTextStyle;
        Intrinsics.checkNotNull(textStyle);
        return textStyle;
    }
}
