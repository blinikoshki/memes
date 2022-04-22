package com.getstream.sdk.chat.view.messageinput;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.regex.Pattern;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.text.StringsKt;
import p015io.getstream.chat.android.client.models.Command;
import p015io.getstream.chat.android.client.models.ContentUtils;
import p015io.getstream.chat.android.client.models.Member;
import p015io.getstream.chat.android.client.models.User;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000,\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u001a\f\u0010\u0004\u001a\u00020\u0005*\u00020\u0006H\u0002\u001a\f\u0010\u0007\u001a\u00020\u0005*\u00020\u0006H\u0002\u001a \u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\t*\b\u0012\u0004\u0012\u00020\n0\t2\u0006\u0010\u000b\u001a\u00020\u0006H\u0002\u001a \u0010\f\u001a\b\u0012\u0004\u0012\u00020\r0\t*\b\u0012\u0004\u0012\u00020\u000e0\t2\u0006\u0010\u000b\u001a\u00020\u0006H\u0002\"\u0016\u0010\u0000\u001a\n \u0002*\u0004\u0018\u00010\u00010\u0001X\u0004¢\u0006\u0002\n\u0000\"\u0016\u0010\u0003\u001a\n \u0002*\u0004\u0018\u00010\u00010\u0001X\u0004¢\u0006\u0002\n\u0000¨\u0006\u000f"}, mo26107d2 = {"COMMAND_PATTERN", "Ljava/util/regex/Pattern;", "kotlin.jvm.PlatformType", "MENTION_PATTERN", "isCommandMessage", "", "", "isMentionMessage", "matchName", "", "Lio/getstream/chat/android/client/models/Command;", "namePattern", "matchUserName", "Lio/getstream/chat/android/client/models/User;", "Lio/getstream/chat/android/client/models/Member;", "stream-chat-android_release"}, mo26108k = 2, mo26109mv = {1, 4, 2})
/* compiled from: MessageInputController.kt */
public final class MessageInputControllerKt {
    private static final Pattern COMMAND_PATTERN = Pattern.compile("^/[a-z]*$");
    private static final Pattern MENTION_PATTERN = Pattern.compile("^(.* )?@([a-zA-Z]+[0-9]*)*$");

    /* access modifiers changed from: private */
    public static final boolean isCommandMessage(String str) {
        return COMMAND_PATTERN.matcher(str).find();
    }

    /* access modifiers changed from: private */
    public static final boolean isMentionMessage(String str) {
        return MENTION_PATTERN.matcher(str).find();
    }

    /* access modifiers changed from: private */
    public static final List<Command> matchName(List<Command> list, String str) {
        Collection arrayList = new ArrayList();
        for (Object next : list) {
            if (StringsKt.startsWith$default(((Command) next).getName(), str, false, 2, (Object) null)) {
                arrayList.add(next);
            }
        }
        return (List) arrayList;
    }

    /* access modifiers changed from: private */
    public static final List<User> matchUserName(List<Member> list, String str) {
        Iterable<Member> iterable = list;
        Collection arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(iterable, 10));
        for (Member user : iterable) {
            arrayList.add(user.getUser());
        }
        Collection arrayList2 = new ArrayList();
        for (Object next : (List) arrayList) {
            if (StringsKt.contains((CharSequence) ContentUtils.getName((User) next), (CharSequence) str, true)) {
                arrayList2.add(next);
            }
        }
        return (List) arrayList2;
    }
}
