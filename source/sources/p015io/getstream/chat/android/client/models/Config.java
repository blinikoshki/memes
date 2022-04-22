package p015io.getstream.chat.android.client.models;

import com.google.gson.annotations.SerializedName;
import java.util.Date;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b4\b\b\u0018\u00002\u00020\u0001B\u0001\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006\u0012\b\b\u0002\u0010\b\u001a\u00020\u0006\u0012\b\b\u0002\u0010\t\u001a\u00020\u0006\u0012\b\b\u0002\u0010\n\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u000b\u001a\u00020\u0006\u0012\b\b\u0002\u0010\f\u001a\u00020\u0006\u0012\b\b\u0002\u0010\r\u001a\u00020\u000e\u0012\b\b\u0002\u0010\u000f\u001a\u00020\u0010\u0012\b\b\u0002\u0010\u0011\u001a\u00020\u0010\u0012\b\b\u0002\u0010\u0012\u001a\u00020\u0010\u0012\u000e\b\u0002\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00150\u0014¢\u0006\u0002\u0010\u0016J\u000b\u00106\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u00107\u001a\u00020\u000eHÆ\u0003J\t\u00108\u001a\u00020\u0010HÆ\u0003J\t\u00109\u001a\u00020\u0010HÆ\u0003J\t\u0010:\u001a\u00020\u0010HÆ\u0003J\u000f\u0010;\u001a\b\u0012\u0004\u0012\u00020\u00150\u0014HÆ\u0003J\u000b\u0010<\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010=\u001a\u00020\u0006HÆ\u0003J\t\u0010>\u001a\u00020\u0006HÆ\u0003J\t\u0010?\u001a\u00020\u0006HÆ\u0003J\t\u0010@\u001a\u00020\u0006HÆ\u0003J\t\u0010A\u001a\u00020\u0006HÆ\u0003J\t\u0010B\u001a\u00020\u0006HÆ\u0003J\t\u0010C\u001a\u00020\u0006HÆ\u0003J\u0001\u0010D\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\u00062\b\b\u0002\u0010\b\u001a\u00020\u00062\b\b\u0002\u0010\t\u001a\u00020\u00062\b\b\u0002\u0010\n\u001a\u00020\u00062\b\b\u0002\u0010\u000b\u001a\u00020\u00062\b\b\u0002\u0010\f\u001a\u00020\u00062\b\b\u0002\u0010\r\u001a\u00020\u000e2\b\b\u0002\u0010\u000f\u001a\u00020\u00102\b\b\u0002\u0010\u0011\u001a\u00020\u00102\b\b\u0002\u0010\u0012\u001a\u00020\u00102\u000e\b\u0002\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00150\u0014HÆ\u0001J\u0013\u0010E\u001a\u00020\u00062\b\u0010F\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010G\u001a\u00020\u000eHÖ\u0001J\t\u0010H\u001a\u00020\u0010HÖ\u0001R\u001a\u0010\u000f\u001a\u00020\u0010X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR \u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00150\u0014X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001eR \u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010 \"\u0004\b!\u0010\"R\u001a\u0010\u0011\u001a\u00020\u0010X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b#\u0010\u0018\"\u0004\b$\u0010\u001aR\u001e\u0010\b\u001a\u00020\u00068\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010%\"\u0004\b&\u0010'R\u001e\u0010\f\u001a\u00020\u00068\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010%\"\u0004\b(\u0010'R\u001e\u0010\n\u001a\u00020\u00068\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010%\"\u0004\b)\u0010'R\u001e\u0010\u0007\u001a\u00020\u00068\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010%\"\u0004\b*\u0010'R\u001e\u0010\u000b\u001a\u00020\u00068\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010%\"\u0004\b+\u0010'R\u001e\u0010\t\u001a\u00020\u00068\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010%\"\u0004\b,\u0010'R\u001e\u0010\u0005\u001a\u00020\u00068\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010%\"\u0004\b-\u0010'R\u001e\u0010\r\u001a\u00020\u000e8\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b.\u0010/\"\u0004\b0\u00101R\u001a\u0010\u0012\u001a\u00020\u0010X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b2\u0010\u0018\"\u0004\b3\u0010\u001aR \u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b4\u0010 \"\u0004\b5\u0010\"¨\u0006I"}, mo26107d2 = {"Lio/getstream/chat/android/client/models/Config;", "", "created_at", "Ljava/util/Date;", "updated_at", "isTypingEvents", "", "isReadEvents", "isConnectEvents", "isSearch", "isReactionsEnabled", "isRepliesEnabled", "isMutes", "maxMessageLength", "", "automod", "", "infinite", "name", "commands", "", "Lio/getstream/chat/android/client/models/Command;", "(Ljava/util/Date;Ljava/util/Date;ZZZZZZZILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;)V", "getAutomod", "()Ljava/lang/String;", "setAutomod", "(Ljava/lang/String;)V", "getCommands", "()Ljava/util/List;", "setCommands", "(Ljava/util/List;)V", "getCreated_at", "()Ljava/util/Date;", "setCreated_at", "(Ljava/util/Date;)V", "getInfinite", "setInfinite", "()Z", "setConnectEvents", "(Z)V", "setMutes", "setReactionsEnabled", "setReadEvents", "setRepliesEnabled", "setSearch", "setTypingEvents", "getMaxMessageLength", "()I", "setMaxMessageLength", "(I)V", "getName", "setName", "getUpdated_at", "setUpdated_at", "component1", "component10", "component11", "component12", "component13", "component14", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "equals", "other", "hashCode", "toString", "stream-chat-android-client_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
/* renamed from: io.getstream.chat.android.client.models.Config */
/* compiled from: Config.kt */
public final class Config {
    private String automod;
    private List<Command> commands;
    @SerializedName("created_at")
    private Date created_at;
    private String infinite;
    @SerializedName("connect_events")
    private boolean isConnectEvents;
    @SerializedName("mutes")
    private boolean isMutes;
    @SerializedName("reactions")
    private boolean isReactionsEnabled;
    @SerializedName("read_events")
    private boolean isReadEvents;
    @SerializedName("replies")
    private boolean isRepliesEnabled;
    @SerializedName("search")
    private boolean isSearch;
    @SerializedName("typing_events")
    private boolean isTypingEvents;
    @SerializedName("max_message_length")
    private int maxMessageLength;
    private String name;
    @SerializedName("updated_at")
    private Date updated_at;

    public Config() {
        this((Date) null, (Date) null, false, false, false, false, false, false, false, 0, (String) null, (String) null, (String) null, (List) null, 16383, (DefaultConstructorMarker) null);
    }

    public static /* synthetic */ Config copy$default(Config config, Date date, Date date2, boolean z, boolean z2, boolean z3, boolean z4, boolean z5, boolean z6, boolean z7, int i, String str, String str2, String str3, List list, int i2, Object obj) {
        Config config2 = config;
        int i3 = i2;
        return config.copy((i3 & 1) != 0 ? config2.created_at : date, (i3 & 2) != 0 ? config2.updated_at : date2, (i3 & 4) != 0 ? config2.isTypingEvents : z, (i3 & 8) != 0 ? config2.isReadEvents : z2, (i3 & 16) != 0 ? config2.isConnectEvents : z3, (i3 & 32) != 0 ? config2.isSearch : z4, (i3 & 64) != 0 ? config2.isReactionsEnabled : z5, (i3 & 128) != 0 ? config2.isRepliesEnabled : z6, (i3 & 256) != 0 ? config2.isMutes : z7, (i3 & 512) != 0 ? config2.maxMessageLength : i, (i3 & 1024) != 0 ? config2.automod : str, (i3 & 2048) != 0 ? config2.infinite : str2, (i3 & 4096) != 0 ? config2.name : str3, (i3 & 8192) != 0 ? config2.commands : list);
    }

    public final Date component1() {
        return this.created_at;
    }

    public final int component10() {
        return this.maxMessageLength;
    }

    public final String component11() {
        return this.automod;
    }

    public final String component12() {
        return this.infinite;
    }

    public final String component13() {
        return this.name;
    }

    public final List<Command> component14() {
        return this.commands;
    }

    public final Date component2() {
        return this.updated_at;
    }

    public final boolean component3() {
        return this.isTypingEvents;
    }

    public final boolean component4() {
        return this.isReadEvents;
    }

    public final boolean component5() {
        return this.isConnectEvents;
    }

    public final boolean component6() {
        return this.isSearch;
    }

    public final boolean component7() {
        return this.isReactionsEnabled;
    }

    public final boolean component8() {
        return this.isRepliesEnabled;
    }

    public final boolean component9() {
        return this.isMutes;
    }

    public final Config copy(Date date, Date date2, boolean z, boolean z2, boolean z3, boolean z4, boolean z5, boolean z6, boolean z7, int i, String str, String str2, String str3, List<Command> list) {
        String str4 = str;
        Intrinsics.checkNotNullParameter(str4, "automod");
        String str5 = str2;
        Intrinsics.checkNotNullParameter(str5, "infinite");
        String str6 = str3;
        Intrinsics.checkNotNullParameter(str6, "name");
        List<Command> list2 = list;
        Intrinsics.checkNotNullParameter(list2, "commands");
        return new Config(date, date2, z, z2, z3, z4, z5, z6, z7, i, str4, str5, str6, list2);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Config)) {
            return false;
        }
        Config config = (Config) obj;
        return Intrinsics.areEqual((Object) this.created_at, (Object) config.created_at) && Intrinsics.areEqual((Object) this.updated_at, (Object) config.updated_at) && this.isTypingEvents == config.isTypingEvents && this.isReadEvents == config.isReadEvents && this.isConnectEvents == config.isConnectEvents && this.isSearch == config.isSearch && this.isReactionsEnabled == config.isReactionsEnabled && this.isRepliesEnabled == config.isRepliesEnabled && this.isMutes == config.isMutes && this.maxMessageLength == config.maxMessageLength && Intrinsics.areEqual((Object) this.automod, (Object) config.automod) && Intrinsics.areEqual((Object) this.infinite, (Object) config.infinite) && Intrinsics.areEqual((Object) this.name, (Object) config.name) && Intrinsics.areEqual((Object) this.commands, (Object) config.commands);
    }

    public int hashCode() {
        Date date = this.created_at;
        int i = 0;
        int hashCode = (date != null ? date.hashCode() : 0) * 31;
        Date date2 = this.updated_at;
        int hashCode2 = (hashCode + (date2 != null ? date2.hashCode() : 0)) * 31;
        boolean z = this.isTypingEvents;
        boolean z2 = true;
        if (z) {
            z = true;
        }
        int i2 = (hashCode2 + (z ? 1 : 0)) * 31;
        boolean z3 = this.isReadEvents;
        if (z3) {
            z3 = true;
        }
        int i3 = (i2 + (z3 ? 1 : 0)) * 31;
        boolean z4 = this.isConnectEvents;
        if (z4) {
            z4 = true;
        }
        int i4 = (i3 + (z4 ? 1 : 0)) * 31;
        boolean z5 = this.isSearch;
        if (z5) {
            z5 = true;
        }
        int i5 = (i4 + (z5 ? 1 : 0)) * 31;
        boolean z6 = this.isReactionsEnabled;
        if (z6) {
            z6 = true;
        }
        int i6 = (i5 + (z6 ? 1 : 0)) * 31;
        boolean z7 = this.isRepliesEnabled;
        if (z7) {
            z7 = true;
        }
        int i7 = (i6 + (z7 ? 1 : 0)) * 31;
        boolean z8 = this.isMutes;
        if (!z8) {
            z2 = z8;
        }
        int i8 = (((i7 + (z2 ? 1 : 0)) * 31) + this.maxMessageLength) * 31;
        String str = this.automod;
        int hashCode3 = (i8 + (str != null ? str.hashCode() : 0)) * 31;
        String str2 = this.infinite;
        int hashCode4 = (hashCode3 + (str2 != null ? str2.hashCode() : 0)) * 31;
        String str3 = this.name;
        int hashCode5 = (hashCode4 + (str3 != null ? str3.hashCode() : 0)) * 31;
        List<Command> list = this.commands;
        if (list != null) {
            i = list.hashCode();
        }
        return hashCode5 + i;
    }

    public String toString() {
        return "Config(created_at=" + this.created_at + ", updated_at=" + this.updated_at + ", isTypingEvents=" + this.isTypingEvents + ", isReadEvents=" + this.isReadEvents + ", isConnectEvents=" + this.isConnectEvents + ", isSearch=" + this.isSearch + ", isReactionsEnabled=" + this.isReactionsEnabled + ", isRepliesEnabled=" + this.isRepliesEnabled + ", isMutes=" + this.isMutes + ", maxMessageLength=" + this.maxMessageLength + ", automod=" + this.automod + ", infinite=" + this.infinite + ", name=" + this.name + ", commands=" + this.commands + ")";
    }

    public Config(Date date, Date date2, boolean z, boolean z2, boolean z3, boolean z4, boolean z5, boolean z6, boolean z7, int i, String str, String str2, String str3, List<Command> list) {
        Intrinsics.checkNotNullParameter(str, "automod");
        Intrinsics.checkNotNullParameter(str2, "infinite");
        Intrinsics.checkNotNullParameter(str3, "name");
        Intrinsics.checkNotNullParameter(list, "commands");
        this.created_at = date;
        this.updated_at = date2;
        this.isTypingEvents = z;
        this.isReadEvents = z2;
        this.isConnectEvents = z3;
        this.isSearch = z4;
        this.isReactionsEnabled = z5;
        this.isRepliesEnabled = z6;
        this.isMutes = z7;
        this.maxMessageLength = i;
        this.automod = str;
        this.infinite = str2;
        this.name = str3;
        this.commands = list;
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ Config(java.util.Date r16, java.util.Date r17, boolean r18, boolean r19, boolean r20, boolean r21, boolean r22, boolean r23, boolean r24, int r25, java.lang.String r26, java.lang.String r27, java.lang.String r28, java.util.List r29, int r30, kotlin.jvm.internal.DefaultConstructorMarker r31) {
        /*
            r15 = this;
            r0 = r30
            r1 = r0 & 1
            r2 = 0
            if (r1 == 0) goto L_0x000b
            r1 = r2
            java.util.Date r1 = (java.util.Date) r1
            goto L_0x000d
        L_0x000b:
            r1 = r16
        L_0x000d:
            r3 = r0 & 2
            if (r3 == 0) goto L_0x0014
            java.util.Date r2 = (java.util.Date) r2
            goto L_0x0016
        L_0x0014:
            r2 = r17
        L_0x0016:
            r3 = r0 & 4
            r4 = 0
            if (r3 == 0) goto L_0x001d
            r3 = 0
            goto L_0x001f
        L_0x001d:
            r3 = r18
        L_0x001f:
            r5 = r0 & 8
            if (r5 == 0) goto L_0x0025
            r5 = 0
            goto L_0x0027
        L_0x0025:
            r5 = r19
        L_0x0027:
            r6 = r0 & 16
            if (r6 == 0) goto L_0x002d
            r6 = 0
            goto L_0x002f
        L_0x002d:
            r6 = r20
        L_0x002f:
            r7 = r0 & 32
            if (r7 == 0) goto L_0x0035
            r7 = 0
            goto L_0x0037
        L_0x0035:
            r7 = r21
        L_0x0037:
            r8 = r0 & 64
            if (r8 == 0) goto L_0x003d
            r8 = 0
            goto L_0x003f
        L_0x003d:
            r8 = r22
        L_0x003f:
            r9 = r0 & 128(0x80, float:1.794E-43)
            if (r9 == 0) goto L_0x0045
            r9 = 0
            goto L_0x0047
        L_0x0045:
            r9 = r23
        L_0x0047:
            r10 = r0 & 256(0x100, float:3.59E-43)
            if (r10 == 0) goto L_0x004c
            goto L_0x004e
        L_0x004c:
            r4 = r24
        L_0x004e:
            r10 = r0 & 512(0x200, float:7.175E-43)
            if (r10 == 0) goto L_0x0056
            r10 = 2147483647(0x7fffffff, float:NaN)
            goto L_0x0058
        L_0x0056:
            r10 = r25
        L_0x0058:
            r11 = r0 & 1024(0x400, float:1.435E-42)
            java.lang.String r12 = ""
            if (r11 == 0) goto L_0x0060
            r11 = r12
            goto L_0x0062
        L_0x0060:
            r11 = r26
        L_0x0062:
            r13 = r0 & 2048(0x800, float:2.87E-42)
            if (r13 == 0) goto L_0x0068
            r13 = r12
            goto L_0x006a
        L_0x0068:
            r13 = r27
        L_0x006a:
            r14 = r0 & 4096(0x1000, float:5.74E-42)
            if (r14 == 0) goto L_0x006f
            goto L_0x0071
        L_0x006f:
            r12 = r28
        L_0x0071:
            r0 = r0 & 8192(0x2000, float:1.14794E-41)
            if (r0 == 0) goto L_0x007d
            java.util.ArrayList r0 = new java.util.ArrayList
            r0.<init>()
            java.util.List r0 = (java.util.List) r0
            goto L_0x007f
        L_0x007d:
            r0 = r29
        L_0x007f:
            r16 = r15
            r17 = r1
            r18 = r2
            r19 = r3
            r20 = r5
            r21 = r6
            r22 = r7
            r23 = r8
            r24 = r9
            r25 = r4
            r26 = r10
            r27 = r11
            r28 = r13
            r29 = r12
            r30 = r0
            r16.<init>(r17, r18, r19, r20, r21, r22, r23, r24, r25, r26, r27, r28, r29, r30)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: p015io.getstream.chat.android.client.models.Config.<init>(java.util.Date, java.util.Date, boolean, boolean, boolean, boolean, boolean, boolean, boolean, int, java.lang.String, java.lang.String, java.lang.String, java.util.List, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }

    public final Date getCreated_at() {
        return this.created_at;
    }

    public final void setCreated_at(Date date) {
        this.created_at = date;
    }

    public final Date getUpdated_at() {
        return this.updated_at;
    }

    public final void setUpdated_at(Date date) {
        this.updated_at = date;
    }

    public final boolean isTypingEvents() {
        return this.isTypingEvents;
    }

    public final void setTypingEvents(boolean z) {
        this.isTypingEvents = z;
    }

    public final boolean isReadEvents() {
        return this.isReadEvents;
    }

    public final void setReadEvents(boolean z) {
        this.isReadEvents = z;
    }

    public final boolean isConnectEvents() {
        return this.isConnectEvents;
    }

    public final void setConnectEvents(boolean z) {
        this.isConnectEvents = z;
    }

    public final boolean isSearch() {
        return this.isSearch;
    }

    public final void setSearch(boolean z) {
        this.isSearch = z;
    }

    public final boolean isReactionsEnabled() {
        return this.isReactionsEnabled;
    }

    public final void setReactionsEnabled(boolean z) {
        this.isReactionsEnabled = z;
    }

    public final boolean isRepliesEnabled() {
        return this.isRepliesEnabled;
    }

    public final void setRepliesEnabled(boolean z) {
        this.isRepliesEnabled = z;
    }

    public final boolean isMutes() {
        return this.isMutes;
    }

    public final void setMutes(boolean z) {
        this.isMutes = z;
    }

    public final int getMaxMessageLength() {
        return this.maxMessageLength;
    }

    public final void setMaxMessageLength(int i) {
        this.maxMessageLength = i;
    }

    public final String getAutomod() {
        return this.automod;
    }

    public final void setAutomod(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.automod = str;
    }

    public final String getInfinite() {
        return this.infinite;
    }

    public final void setInfinite(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.infinite = str;
    }

    public final String getName() {
        return this.name;
    }

    public final void setName(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.name = str;
    }

    public final List<Command> getCommands() {
        return this.commands;
    }

    public final void setCommands(List<Command> list) {
        Intrinsics.checkNotNullParameter(list, "<set-?>");
        this.commands = list;
    }
}
