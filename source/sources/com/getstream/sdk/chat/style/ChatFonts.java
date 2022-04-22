package com.getstream.sdk.chat.style;

import android.graphics.Typeface;
import android.widget.TextView;
import kotlin.Metadata;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0018\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\tH&¨\u0006\n"}, mo26107d2 = {"Lcom/getstream/sdk/chat/style/ChatFonts;", "", "getFont", "Landroid/graphics/Typeface;", "textStyle", "Lcom/getstream/sdk/chat/style/TextStyle;", "setFont", "", "textView", "Landroid/widget/TextView;", "stream-chat-android-ui-common_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
/* compiled from: ChatFonts.kt */
public interface ChatFonts {
    Typeface getFont(TextStyle textStyle);

    void setFont(TextStyle textStyle, TextView textView);
}
