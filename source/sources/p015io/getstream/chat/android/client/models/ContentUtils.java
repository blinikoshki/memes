package p015io.getstream.chat.android.client.models;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Regex;
import kotlin.text.StringsKt;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000:\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010$\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0002\u001a\u0018\u0010\u0016\u001a\u00020\u00012\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u0001H\u0000\u001a9\u0010\u001a\u001a\u0002H\u001b\"\u0004\b\u0000\u0010\u001c\"\u0004\b\u0001\u0010\u001b*\u000e\u0012\u0004\u0012\u0002H\u001c\u0012\u0004\u0012\u0002H\u001b0\u001d2\u0006\u0010\u0019\u001a\u0002H\u001c2\u0006\u0010\u001e\u001a\u0002H\u001bH\u0000¢\u0006\u0002\u0010\u001f\u001a\u0012\u0010 \u001a\u00020\u0001*\u00020\u00132\u0006\u0010!\u001a\u00020\u0001\u001a\u0014\u0010\"\u001a\u00020#*\u00020\u00052\b\b\u0002\u0010$\u001a\u00020\u0001\u001a\f\u0010\r\u001a\u00020\u0001*\u00020\u0001H\u0000\"\u000e\u0010\u0000\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u0002\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"(\u0010\u0004\u001a\u00020\u0001*\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00018F@FX\u000e¢\u0006\f\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\t\"(\u0010\u0004\u001a\u00020\u0001*\u00020\n2\u0006\u0010\u0003\u001a\u00020\u00018F@FX\u000e¢\u0006\f\u001a\u0004\b\u0006\u0010\u000b\"\u0004\b\b\u0010\f\"\u0015\u0010\r\u001a\u00020\u0001*\u00020\u00058F¢\u0006\u0006\u001a\u0004\b\u000e\u0010\u0007\"\u0015\u0010\r\u001a\u00020\u0001*\u00020\n8F¢\u0006\u0006\u001a\u0004\b\u000e\u0010\u000b\"(\u0010\u000f\u001a\u00020\u0001*\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00018F@FX\u000e¢\u0006\f\u001a\u0004\b\u0010\u0010\u0007\"\u0004\b\u0011\u0010\t\"(\u0010\u000f\u001a\u00020\u0001*\u00020\n2\u0006\u0010\u0003\u001a\u00020\u00018F@FX\u000e¢\u0006\f\u001a\u0004\b\u0010\u0010\u000b\"\u0004\b\u0011\u0010\f\"\u0015\u0010\u0012\u001a\u00020\u0001*\u00020\u00138F¢\u0006\u0006\u001a\u0004\b\u0014\u0010\u0015¨\u0006%"}, mo26107d2 = {"EXTRA_IMAGE", "", "EXTRA_NAME", "value", "image", "Lio/getstream/chat/android/client/models/Channel;", "getImage", "(Lio/getstream/chat/android/client/models/Channel;)Ljava/lang/String;", "setImage", "(Lio/getstream/chat/android/client/models/Channel;Ljava/lang/String;)V", "Lio/getstream/chat/android/client/models/User;", "(Lio/getstream/chat/android/client/models/User;)Ljava/lang/String;", "(Lio/getstream/chat/android/client/models/User;Ljava/lang/String;)V", "initials", "getInitials", "name", "getName", "setName", "originalLanguage", "Lio/getstream/chat/android/client/models/Message;", "getOriginalLanguage", "(Lio/getstream/chat/android/client/models/Message;)Ljava/lang/String;", "getExternalField", "obj", "Lio/getstream/chat/android/client/models/CustomObject;", "key", "get", "B", "A", "", "default", "(Ljava/util/Map;Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "getTranslation", "language", "getUnreadMessagesCount", "", "forUserId", "stream-chat-android-client_release"}, mo26108k = 2, mo26109mv = {1, 4, 2})
/* renamed from: io.getstream.chat.android.client.models.ContentUtils */
/* compiled from: Extensions.kt */
public final class ContentUtils {
    public static final String EXTRA_IMAGE = "image";
    public static final String EXTRA_NAME = "name";

    public static final String getInitials(Channel channel) {
        Intrinsics.checkNotNullParameter(channel, "$this$initials");
        return initials(getName(channel));
    }

    public static final String getInitials(User user) {
        Intrinsics.checkNotNullParameter(user, "$this$initials");
        return initials(getName(user));
    }

    public static final String getTranslation(Message message, String str) {
        Intrinsics.checkNotNullParameter(message, "$this$getTranslation");
        Intrinsics.checkNotNullParameter(str, "language");
        Map<String, String> i18n = message.getI18n();
        return (String) get(i18n, str + "_text", "");
    }

    public static final String getOriginalLanguage(Message message) {
        Intrinsics.checkNotNullParameter(message, "$this$originalLanguage");
        return (String) get(message.getI18n(), "language", "");
    }

    public static /* synthetic */ int getUnreadMessagesCount$default(Channel channel, String str, int i, Object obj) {
        if ((i & 1) != 0) {
            str = "";
        }
        return getUnreadMessagesCount(channel, str);
    }

    public static final int getUnreadMessagesCount(Channel channel, String str) {
        Intrinsics.checkNotNullParameter(channel, "$this$getUnreadMessagesCount");
        Intrinsics.checkNotNullParameter(str, "forUserId");
        int i = 0;
        if (str.length() == 0) {
            for (ChannelUserRead unreadMessages : channel.getRead()) {
                i += unreadMessages.getUnreadMessages();
            }
        } else {
            Collection arrayList = new ArrayList();
            for (Object next : channel.getRead()) {
                if (Intrinsics.areEqual((Object) ((ChannelUserRead) next).getUser().getId(), (Object) str)) {
                    arrayList.add(next);
                }
            }
            for (ChannelUserRead unreadMessages2 : (List) arrayList) {
                i += unreadMessages2.getUnreadMessages();
            }
        }
        return i;
    }

    public static final String getImage(User user) {
        Intrinsics.checkNotNullParameter(user, "$this$image");
        return getExternalField(user, "image");
    }

    public static final void setImage(User user, String str) {
        Intrinsics.checkNotNullParameter(user, "$this$image");
        Intrinsics.checkNotNullParameter(str, "value");
        user.getExtraData().put("image", str);
    }

    public static final String getName(User user) {
        Intrinsics.checkNotNullParameter(user, "$this$name");
        return getExternalField(user, "name");
    }

    public static final void setName(User user, String str) {
        Intrinsics.checkNotNullParameter(user, "$this$name");
        Intrinsics.checkNotNullParameter(str, "value");
        user.getExtraData().put("name", str);
    }

    public static final String getImage(Channel channel) {
        Intrinsics.checkNotNullParameter(channel, "$this$image");
        return getExternalField(channel, "image");
    }

    public static final void setImage(Channel channel, String str) {
        Intrinsics.checkNotNullParameter(channel, "$this$image");
        Intrinsics.checkNotNullParameter(str, "value");
        channel.getExtraData().put("image", str);
    }

    public static final String getName(Channel channel) {
        Intrinsics.checkNotNullParameter(channel, "$this$name");
        return getExternalField(channel, "name");
    }

    public static final void setName(Channel channel, String str) {
        Intrinsics.checkNotNullParameter(channel, "$this$name");
        Intrinsics.checkNotNullParameter(str, "value");
        channel.getExtraData().put("name", str);
    }

    public static final String getExternalField(CustomObject customObject, String str) {
        Intrinsics.checkNotNullParameter(customObject, "obj");
        Intrinsics.checkNotNullParameter(str, "key");
        Object obj = customObject.getExtraData().get(str);
        return (obj != null && (obj instanceof String)) ? (String) obj : "";
    }

    public static final <A, B> B get(Map<A, ? extends B> map, A a, B b) {
        Intrinsics.checkNotNullParameter(map, "$this$get");
        B b2 = map.get(a);
        return b2 != null ? b2 : b;
    }

    public static final String initials(String str) {
        Intrinsics.checkNotNullParameter(str, "$this$initials");
        return CollectionsKt.joinToString$default(CollectionsKt.take(new Regex("\\s+").split(StringsKt.trim((CharSequence) str).toString(), 0), 2), "", (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, ContentUtils$initials$1.INSTANCE, 30, (Object) null);
    }
}
