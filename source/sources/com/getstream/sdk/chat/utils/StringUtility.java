package com.getstream.sdk.chat.utils;

import com.facebook.share.internal.ShareConstants;
import com.getstream.sdk.chat.C1673R;
import com.getstream.sdk.chat.ChatUI;
import com.memes.plus.p040ui.create_post.tagpeople.TagPeopleActivity;
import java.util.Collection;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Regex;
import kotlin.text.StringsKt;
import org.apache.commons.lang3.StringUtils;
import p015io.getstream.chat.android.client.models.Message;
import p015io.getstream.chat.android.client.models.User;
import p015io.getstream.chat.android.core.internal.InternalStreamChatApi;

@InternalStreamChatApi
@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0018\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0004H\u0007J\u0010\u0010\u0007\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\tH\u0007J\u000e\u0010\n\u001a\u00020\u000b2\u0006\u0010\b\u001a\u00020\u0004¨\u0006\f"}, mo26107d2 = {"Lcom/getstream/sdk/chat/utils/StringUtility;", "", "()V", "convertMentionedText", "", "text", "userName", "getDeletedOrMentionedText", "message", "Lio/getstream/chat/android/client/models/Message;", "isEmoji", "", "stream-chat-android_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
/* compiled from: StringUtility.kt */
public final class StringUtility {
    public static final StringUtility INSTANCE = new StringUtility();

    private StringUtility() {
    }

    public final boolean isEmoji(String str) {
        Intrinsics.checkNotNullParameter(str, ShareConstants.WEB_DIALOG_PARAM_MESSAGE);
        return new Regex("(?:[🌀-🗿]|[🤀-🧿]|[😀-🙏]|[🚀-🛿]|[☀-⛿]️?|[✀-➿]️?|Ⓜ️?|[🇦-🇿]{1,2}|[🅰🅱🅾🅿🆎🆑-🆚]️?|[#*0-9]️?⃣|[↔-↙↩-↪]️?|[⬅-⬇⬛⬜⭐⭕]️?|[⤴⤵]️?|[〰〽]️?|[㊗㊙]️?|[🈁🈂🈚🈯🈲-🈺🉐🉑]️?|[‼⁉]️?|[▪▫▶◀◻-◾]️?|[©®]️?|[™ℹ]️?|🀄️?|🃏️?|[⌚⌛⌨⏏⏩-⏳⏸-⏺]️?)+").matches(str);
    }

    @JvmStatic
    public static final String getDeletedOrMentionedText(Message message) {
        String str;
        Intrinsics.checkNotNullParameter(message, ShareConstants.WEB_DIALOG_PARAM_MESSAGE);
        String replace = new Regex("^[\r\n]+|[\r\n]+$").replace((CharSequence) message.getText(), "");
        if (message.getDeletedAt() != null) {
            return "_" + ChatUI.Companion.instance().getStrings().get(C1673R.string.stream_delete_message) + "_";
        }
        Collection mentionedUsers = message.getMentionedUsers();
        if (!(mentionedUsers == null || mentionedUsers.isEmpty())) {
            Iterator<User> it = message.getMentionedUsers().iterator();
            while (true) {
                str = replace;
                if (!it.hasNext()) {
                    break;
                }
                String str2 = (String) it.next().getExtraValue("name", "");
                int indexOf$default = StringsKt.indexOf$default((CharSequence) str, str2, 0, false, 6, (Object) null);
                if (indexOf$default <= 1 || str.charAt(indexOf$default - 2) == ' ') {
                    replace = StringsKt.replace$default(str, '@' + str2, "**@" + str2 + "**", false, 4, (Object) null);
                } else {
                    replace = StringsKt.replace$default(str, '@' + str2, " **@" + str2 + "**", false, 4, (Object) null);
                }
            }
            replace = str;
        }
        return new Regex(StringUtils.f466LF).replace((CharSequence) replace, "  \n");
    }

    @JvmStatic
    public static final String convertMentionedText(String str, String str2) {
        Intrinsics.checkNotNullParameter(str, "text");
        Intrinsics.checkNotNullParameter(str2, TagPeopleActivity.USER_NAME);
        if (StringsKt.last(str) == '@') {
            return str + str2;
        }
        String substringAfterLast$default = StringsKt.substringAfterLast$default(str, '@', (String) null, 2, (Object) null);
        StringBuilder sb = new StringBuilder();
        String substring = str.substring(0, str.length() - substringAfterLast$default.length());
        Intrinsics.checkNotNullExpressionValue(substring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
        sb.append(substring);
        sb.append(str2);
        return sb.toString();
    }
}
