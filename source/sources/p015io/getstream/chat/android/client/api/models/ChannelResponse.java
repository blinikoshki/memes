package p015io.getstream.chat.android.client.api.models;

import java.util.Date;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import p015io.getstream.chat.android.client.models.Channel;
import p015io.getstream.chat.android.client.models.ChannelUserRead;
import p015io.getstream.chat.android.client.models.Member;
import p015io.getstream.chat.android.client.models.Message;
import p015io.getstream.chat.android.client.models.User;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b!\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001Bw\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0010\b\u0002\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005\u0012\u0010\b\u0002\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0005\u0012\u0010\b\u0002\u0010\t\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\u0005\u0012\u0010\b\u0002\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u0005\u0012\b\b\u0002\u0010\r\u001a\u00020\u000e\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0010\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0012¢\u0006\u0002\u0010\u0013J\t\u0010&\u001a\u00020\u0003HÆ\u0003J\u0011\u0010'\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005HÆ\u0003J\u0011\u0010(\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0005HÆ\u0003J\u0011\u0010)\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\u0005HÆ\u0003J\u0011\u0010*\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u0005HÆ\u0003J\t\u0010+\u001a\u00020\u000eHÆ\u0003J\u0010\u0010,\u001a\u0004\u0018\u00010\u0010HÆ\u0003¢\u0006\u0002\u0010\u0017J\u000b\u0010-\u001a\u0004\u0018\u00010\u0012HÆ\u0003J\u0001\u0010.\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u0010\b\u0002\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u00052\u0010\b\u0002\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u00052\u0010\b\u0002\u0010\t\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\u00052\u0010\b\u0002\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u00052\b\b\u0002\u0010\r\u001a\u00020\u000e2\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u00102\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0012HÆ\u0001¢\u0006\u0002\u0010/J\u0013\u00100\u001a\u00020\u00102\b\u00101\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u00102\u001a\u00020\u000eHÖ\u0001J\t\u00103\u001a\u000204HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0015\u0010\u000f\u001a\u0004\u0018\u00010\u0010¢\u0006\n\n\u0002\u0010\u0018\u001a\u0004\b\u0016\u0010\u0017R\u0013\u0010\u0011\u001a\u0004\u0018\u00010\u0012¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001aR\"\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001eR\u0019\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010\u001cR\"\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b \u0010\u001c\"\u0004\b!\u0010\u001eR\u0011\u0010\r\u001a\u00020\u000e¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010#R\"\u0010\t\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b$\u0010\u001c\"\u0004\b%\u0010\u001e¨\u00065"}, mo26107d2 = {"Lio/getstream/chat/android/client/api/models/ChannelResponse;", "", "channel", "Lio/getstream/chat/android/client/models/Channel;", "messages", "", "Lio/getstream/chat/android/client/models/Message;", "members", "Lio/getstream/chat/android/client/models/Member;", "watchers", "Lio/getstream/chat/android/client/models/User;", "read", "Lio/getstream/chat/android/client/models/ChannelUserRead;", "watcher_count", "", "hidden", "", "hide_messages_before", "Ljava/util/Date;", "(Lio/getstream/chat/android/client/models/Channel;Ljava/util/List;Ljava/util/List;Ljava/util/List;Ljava/util/List;ILjava/lang/Boolean;Ljava/util/Date;)V", "getChannel", "()Lio/getstream/chat/android/client/models/Channel;", "getHidden", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "getHide_messages_before", "()Ljava/util/Date;", "getMembers", "()Ljava/util/List;", "setMembers", "(Ljava/util/List;)V", "getMessages", "getRead", "setRead", "getWatcher_count", "()I", "getWatchers", "setWatchers", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "copy", "(Lio/getstream/chat/android/client/models/Channel;Ljava/util/List;Ljava/util/List;Ljava/util/List;Ljava/util/List;ILjava/lang/Boolean;Ljava/util/Date;)Lio/getstream/chat/android/client/api/models/ChannelResponse;", "equals", "other", "hashCode", "toString", "", "stream-chat-android-client_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
/* renamed from: io.getstream.chat.android.client.api.models.ChannelResponse */
/* compiled from: ChannelResponse.kt */
public final class ChannelResponse {
    private final Channel channel;
    private final Boolean hidden;
    private final Date hide_messages_before;
    private List<Member> members;
    private final List<Message> messages;
    private List<ChannelUserRead> read;
    private final int watcher_count;
    private List<User> watchers;

    public static /* synthetic */ ChannelResponse copy$default(ChannelResponse channelResponse, Channel channel2, List list, List list2, List list3, List list4, int i, Boolean bool, Date date, int i2, Object obj) {
        ChannelResponse channelResponse2 = channelResponse;
        int i3 = i2;
        return channelResponse.copy((i3 & 1) != 0 ? channelResponse2.channel : channel2, (i3 & 2) != 0 ? channelResponse2.messages : list, (i3 & 4) != 0 ? channelResponse2.members : list2, (i3 & 8) != 0 ? channelResponse2.watchers : list3, (i3 & 16) != 0 ? channelResponse2.read : list4, (i3 & 32) != 0 ? channelResponse2.watcher_count : i, (i3 & 64) != 0 ? channelResponse2.hidden : bool, (i3 & 128) != 0 ? channelResponse2.hide_messages_before : date);
    }

    public final Channel component1() {
        return this.channel;
    }

    public final List<Message> component2() {
        return this.messages;
    }

    public final List<Member> component3() {
        return this.members;
    }

    public final List<User> component4() {
        return this.watchers;
    }

    public final List<ChannelUserRead> component5() {
        return this.read;
    }

    public final int component6() {
        return this.watcher_count;
    }

    public final Boolean component7() {
        return this.hidden;
    }

    public final Date component8() {
        return this.hide_messages_before;
    }

    public final ChannelResponse copy(Channel channel2, List<Message> list, List<Member> list2, List<User> list3, List<ChannelUserRead> list4, int i, Boolean bool, Date date) {
        Intrinsics.checkNotNullParameter(channel2, "channel");
        return new ChannelResponse(channel2, list, list2, list3, list4, i, bool, date);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ChannelResponse)) {
            return false;
        }
        ChannelResponse channelResponse = (ChannelResponse) obj;
        return Intrinsics.areEqual((Object) this.channel, (Object) channelResponse.channel) && Intrinsics.areEqual((Object) this.messages, (Object) channelResponse.messages) && Intrinsics.areEqual((Object) this.members, (Object) channelResponse.members) && Intrinsics.areEqual((Object) this.watchers, (Object) channelResponse.watchers) && Intrinsics.areEqual((Object) this.read, (Object) channelResponse.read) && this.watcher_count == channelResponse.watcher_count && Intrinsics.areEqual((Object) this.hidden, (Object) channelResponse.hidden) && Intrinsics.areEqual((Object) this.hide_messages_before, (Object) channelResponse.hide_messages_before);
    }

    public int hashCode() {
        Channel channel2 = this.channel;
        int i = 0;
        int hashCode = (channel2 != null ? channel2.hashCode() : 0) * 31;
        List<Message> list = this.messages;
        int hashCode2 = (hashCode + (list != null ? list.hashCode() : 0)) * 31;
        List<Member> list2 = this.members;
        int hashCode3 = (hashCode2 + (list2 != null ? list2.hashCode() : 0)) * 31;
        List<User> list3 = this.watchers;
        int hashCode4 = (hashCode3 + (list3 != null ? list3.hashCode() : 0)) * 31;
        List<ChannelUserRead> list4 = this.read;
        int hashCode5 = (((hashCode4 + (list4 != null ? list4.hashCode() : 0)) * 31) + this.watcher_count) * 31;
        Boolean bool = this.hidden;
        int hashCode6 = (hashCode5 + (bool != null ? bool.hashCode() : 0)) * 31;
        Date date = this.hide_messages_before;
        if (date != null) {
            i = date.hashCode();
        }
        return hashCode6 + i;
    }

    public String toString() {
        return "ChannelResponse(channel=" + this.channel + ", messages=" + this.messages + ", members=" + this.members + ", watchers=" + this.watchers + ", read=" + this.read + ", watcher_count=" + this.watcher_count + ", hidden=" + this.hidden + ", hide_messages_before=" + this.hide_messages_before + ")";
    }

    public ChannelResponse(Channel channel2, List<Message> list, List<Member> list2, List<User> list3, List<ChannelUserRead> list4, int i, Boolean bool, Date date) {
        Intrinsics.checkNotNullParameter(channel2, "channel");
        this.channel = channel2;
        this.messages = list;
        this.members = list2;
        this.watchers = list3;
        this.read = list4;
        this.watcher_count = i;
        this.hidden = bool;
        this.hide_messages_before = date;
    }

    public final Channel getChannel() {
        return this.channel;
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ ChannelResponse(p015io.getstream.chat.android.client.models.Channel r9, java.util.List r10, java.util.List r11, java.util.List r12, java.util.List r13, int r14, java.lang.Boolean r15, java.util.Date r16, int r17, kotlin.jvm.internal.DefaultConstructorMarker r18) {
        /*
            r8 = this;
            r0 = r17
            r1 = r0 & 2
            r2 = 0
            if (r1 == 0) goto L_0x000b
            r1 = r2
            java.util.List r1 = (java.util.List) r1
            goto L_0x000c
        L_0x000b:
            r1 = r10
        L_0x000c:
            r3 = r0 & 4
            if (r3 == 0) goto L_0x0014
            r3 = r2
            java.util.List r3 = (java.util.List) r3
            goto L_0x0015
        L_0x0014:
            r3 = r11
        L_0x0015:
            r4 = r0 & 8
            if (r4 == 0) goto L_0x001d
            r4 = r2
            java.util.List r4 = (java.util.List) r4
            goto L_0x001e
        L_0x001d:
            r4 = r12
        L_0x001e:
            r5 = r0 & 16
            if (r5 == 0) goto L_0x0026
            r5 = r2
            java.util.List r5 = (java.util.List) r5
            goto L_0x0027
        L_0x0026:
            r5 = r13
        L_0x0027:
            r6 = r0 & 32
            if (r6 == 0) goto L_0x002d
            r6 = 0
            goto L_0x002e
        L_0x002d:
            r6 = r14
        L_0x002e:
            r7 = r0 & 64
            if (r7 == 0) goto L_0x0036
            r7 = r2
            java.lang.Boolean r7 = (java.lang.Boolean) r7
            goto L_0x0037
        L_0x0036:
            r7 = r15
        L_0x0037:
            r0 = r0 & 128(0x80, float:1.794E-43)
            if (r0 == 0) goto L_0x003f
            r0 = r2
            java.util.Date r0 = (java.util.Date) r0
            goto L_0x0041
        L_0x003f:
            r0 = r16
        L_0x0041:
            r10 = r8
            r11 = r9
            r12 = r1
            r13 = r3
            r14 = r4
            r15 = r5
            r16 = r6
            r17 = r7
            r18 = r0
            r10.<init>(r11, r12, r13, r14, r15, r16, r17, r18)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: p015io.getstream.chat.android.client.api.models.ChannelResponse.<init>(io.getstream.chat.android.client.models.Channel, java.util.List, java.util.List, java.util.List, java.util.List, int, java.lang.Boolean, java.util.Date, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }

    public final List<Message> getMessages() {
        return this.messages;
    }

    public final List<Member> getMembers() {
        return this.members;
    }

    public final void setMembers(List<Member> list) {
        this.members = list;
    }

    public final List<User> getWatchers() {
        return this.watchers;
    }

    public final void setWatchers(List<User> list) {
        this.watchers = list;
    }

    public final List<ChannelUserRead> getRead() {
        return this.read;
    }

    public final void setRead(List<ChannelUserRead> list) {
        this.read = list;
    }

    public final int getWatcher_count() {
        return this.watcher_count;
    }

    public final Boolean getHidden() {
        return this.hidden;
    }

    public final Date getHide_messages_before() {
        return this.hide_messages_before;
    }
}
