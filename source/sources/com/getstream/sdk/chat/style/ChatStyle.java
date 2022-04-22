package com.getstream.sdk.chat.style;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001:\u0001\u0006J\b\u0010\u0002\u001a\u00020\u0003H&J\b\u0010\u0004\u001a\u00020\u0005H&¨\u0006\u0007"}, mo26107d2 = {"Lcom/getstream/sdk/chat/style/ChatStyle;", "", "getDefaultTextStyle", "Lcom/getstream/sdk/chat/style/TextStyle;", "hasDefaultFont", "", "Builder", "stream-chat-android-ui-common_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
/* compiled from: ChatStyle.kt */
public interface ChatStyle {
    TextStyle getDefaultTextStyle();

    boolean hasDefaultFont();

    @Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0006\u0010\u0005\u001a\u00020\u0006J\u0010\u0010\u0007\u001a\u00020\u00002\b\b\u0001\u0010\b\u001a\u00020\tJ\u000e\u0010\u0007\u001a\u00020\u00002\u0006\u0010\n\u001a\u00020\u000bR\u000e\u0010\u0003\u001a\u00020\u0004X\u000e¢\u0006\u0002\n\u0000¨\u0006\f"}, mo26107d2 = {"Lcom/getstream/sdk/chat/style/ChatStyle$Builder;", "", "()V", "result", "Lcom/getstream/sdk/chat/style/ChatStyleImpl;", "build", "Lcom/getstream/sdk/chat/style/ChatStyle;", "setDefaultFont", "fontRes", "", "assetPath", "", "stream-chat-android-ui-common_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
    /* compiled from: ChatStyle.kt */
    public static final class Builder {
        private ChatStyleImpl result = new ChatStyleImpl();

        public final Builder setDefaultFont(String str) {
            Intrinsics.checkNotNullParameter(str, "assetPath");
            Builder builder = this;
            ChatStyleImpl chatStyleImpl = builder.result;
            TextStyle textStyle = new TextStyle();
            textStyle.setFontAssetsPath(str);
            Unit unit = Unit.INSTANCE;
            chatStyleImpl.setDefaultTextStyle$stream_chat_android_ui_common_release(textStyle);
            return builder;
        }

        public final Builder setDefaultFont(int i) {
            Builder builder = this;
            ChatStyleImpl chatStyleImpl = builder.result;
            TextStyle textStyle = new TextStyle();
            textStyle.setFontResource(i);
            Unit unit = Unit.INSTANCE;
            chatStyleImpl.setDefaultTextStyle$stream_chat_android_ui_common_release(textStyle);
            return builder;
        }

        public final ChatStyle build() {
            return this.result;
        }
    }
}
