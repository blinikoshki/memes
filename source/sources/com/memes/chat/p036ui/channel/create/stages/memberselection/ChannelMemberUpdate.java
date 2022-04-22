package com.memes.chat.p036ui.channel.create.stages.memberselection;

import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import p015io.getstream.chat.android.client.models.User;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001:\u0001\u0017B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0010\u0010\u0004\u001a\f\u0012\b\u0012\u00060\u0006j\u0002`\u00070\u0005¢\u0006\u0002\u0010\bJ\t\u0010\r\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\u000e\u001a\f\u0012\b\u0012\u00060\u0006j\u0002`\u00070\u0005HÆ\u0003J'\u0010\u000f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u0012\b\u0002\u0010\u0004\u001a\f\u0012\b\u0012\u00060\u0006j\u0002`\u00070\u0005HÆ\u0001J\u0013\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001J\t\u0010\u0015\u001a\u00020\u0016HÖ\u0001R\u001b\u0010\u0004\u001a\f\u0012\b\u0012\u00060\u0006j\u0002`\u00070\u0005¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f¨\u0006\u0018"}, mo26107d2 = {"Lcom/memes/chat/ui/channel/create/stages/memberselection/ChannelMemberUpdate;", "", "type", "Lcom/memes/chat/ui/channel/create/stages/memberselection/ChannelMemberUpdate$Type;", "allMembers", "", "Lio/getstream/chat/android/client/models/User;", "Lcom/memes/chat/ui/channel/create/stages/memberselection/ChannelMember;", "(Lcom/memes/chat/ui/channel/create/stages/memberselection/ChannelMemberUpdate$Type;Ljava/util/List;)V", "getAllMembers", "()Ljava/util/List;", "getType", "()Lcom/memes/chat/ui/channel/create/stages/memberselection/ChannelMemberUpdate$Type;", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "", "Type", "chat_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
/* renamed from: com.memes.chat.ui.channel.create.stages.memberselection.ChannelMemberUpdate */
/* compiled from: ChannelMemberUpdate.kt */
public final class ChannelMemberUpdate {
    private final List<User> allMembers;
    private final Type type;

    public static /* synthetic */ ChannelMemberUpdate copy$default(ChannelMemberUpdate channelMemberUpdate, Type type2, List<User> list, int i, Object obj) {
        if ((i & 1) != 0) {
            type2 = channelMemberUpdate.type;
        }
        if ((i & 2) != 0) {
            list = channelMemberUpdate.allMembers;
        }
        return channelMemberUpdate.copy(type2, list);
    }

    public final Type component1() {
        return this.type;
    }

    public final List<User> component2() {
        return this.allMembers;
    }

    public final ChannelMemberUpdate copy(Type type2, List<User> list) {
        Intrinsics.checkNotNullParameter(type2, "type");
        Intrinsics.checkNotNullParameter(list, "allMembers");
        return new ChannelMemberUpdate(type2, list);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ChannelMemberUpdate)) {
            return false;
        }
        ChannelMemberUpdate channelMemberUpdate = (ChannelMemberUpdate) obj;
        return Intrinsics.areEqual((Object) this.type, (Object) channelMemberUpdate.type) && Intrinsics.areEqual((Object) this.allMembers, (Object) channelMemberUpdate.allMembers);
    }

    public int hashCode() {
        Type type2 = this.type;
        int i = 0;
        int hashCode = (type2 != null ? type2.hashCode() : 0) * 31;
        List<User> list = this.allMembers;
        if (list != null) {
            i = list.hashCode();
        }
        return hashCode + i;
    }

    public String toString() {
        return "ChannelMemberUpdate(type=" + this.type + ", allMembers=" + this.allMembers + ")";
    }

    public ChannelMemberUpdate(Type type2, List<User> list) {
        Intrinsics.checkNotNullParameter(type2, "type");
        Intrinsics.checkNotNullParameter(list, "allMembers");
        this.type = type2;
        this.allMembers = list;
    }

    public final Type getType() {
        return this.type;
    }

    public final List<User> getAllMembers() {
        return this.allMembers;
    }

    @Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0002\u0003\u0004B\u0007\b\u0002¢\u0006\u0002\u0010\u0002\u0001\u0002\u0005\u0006¨\u0006\u0007"}, mo26107d2 = {"Lcom/memes/chat/ui/channel/create/stages/memberselection/ChannelMemberUpdate$Type;", "", "()V", "Added", "Removed", "Lcom/memes/chat/ui/channel/create/stages/memberselection/ChannelMemberUpdate$Type$Added;", "Lcom/memes/chat/ui/channel/create/stages/memberselection/ChannelMemberUpdate$Type$Removed;", "chat_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
    /* renamed from: com.memes.chat.ui.channel.create.stages.memberselection.ChannelMemberUpdate$Type */
    /* compiled from: ChannelMemberUpdate.kt */
    public static abstract class Type {

        @Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B\u0011\u0012\n\u0010\u0002\u001a\u00060\u0003j\u0002`\u0004¢\u0006\u0002\u0010\u0005J\r\u0010\b\u001a\u00060\u0003j\u0002`\u0004HÆ\u0003J\u0017\u0010\t\u001a\u00020\u00002\f\b\u0002\u0010\u0002\u001a\u00060\u0003j\u0002`\u0004HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0003J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001R\u0015\u0010\u0002\u001a\u00060\u0003j\u0002`\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0012"}, mo26107d2 = {"Lcom/memes/chat/ui/channel/create/stages/memberselection/ChannelMemberUpdate$Type$Added;", "Lcom/memes/chat/ui/channel/create/stages/memberselection/ChannelMemberUpdate$Type;", "updatedMember", "Lio/getstream/chat/android/client/models/User;", "Lcom/memes/chat/ui/channel/create/stages/memberselection/ChannelMember;", "(Lio/getstream/chat/android/client/models/User;)V", "getUpdatedMember", "()Lio/getstream/chat/android/client/models/User;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "chat_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
        /* renamed from: com.memes.chat.ui.channel.create.stages.memberselection.ChannelMemberUpdate$Type$Added */
        /* compiled from: ChannelMemberUpdate.kt */
        public static final class Added extends Type {
            private final User updatedMember;

            public static /* synthetic */ Added copy$default(Added added, User user, int i, Object obj) {
                if ((i & 1) != 0) {
                    user = added.updatedMember;
                }
                return added.copy(user);
            }

            public final User component1() {
                return this.updatedMember;
            }

            public final Added copy(User user) {
                Intrinsics.checkNotNullParameter(user, "updatedMember");
                return new Added(user);
            }

            public boolean equals(Object obj) {
                if (this != obj) {
                    return (obj instanceof Added) && Intrinsics.areEqual((Object) this.updatedMember, (Object) ((Added) obj).updatedMember);
                }
                return true;
            }

            public int hashCode() {
                User user = this.updatedMember;
                if (user != null) {
                    return user.hashCode();
                }
                return 0;
            }

            public String toString() {
                return "Added(updatedMember=" + this.updatedMember + ")";
            }

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            public Added(User user) {
                super((DefaultConstructorMarker) null);
                Intrinsics.checkNotNullParameter(user, "updatedMember");
                this.updatedMember = user;
            }

            public final User getUpdatedMember() {
                return this.updatedMember;
            }
        }

        private Type() {
        }

        public /* synthetic */ Type(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B\u0011\u0012\n\u0010\u0002\u001a\u00060\u0003j\u0002`\u0004¢\u0006\u0002\u0010\u0005J\r\u0010\b\u001a\u00060\u0003j\u0002`\u0004HÆ\u0003J\u0017\u0010\t\u001a\u00020\u00002\f\b\u0002\u0010\u0002\u001a\u00060\u0003j\u0002`\u0004HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0003J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001R\u0015\u0010\u0002\u001a\u00060\u0003j\u0002`\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0012"}, mo26107d2 = {"Lcom/memes/chat/ui/channel/create/stages/memberselection/ChannelMemberUpdate$Type$Removed;", "Lcom/memes/chat/ui/channel/create/stages/memberselection/ChannelMemberUpdate$Type;", "updatedMember", "Lio/getstream/chat/android/client/models/User;", "Lcom/memes/chat/ui/channel/create/stages/memberselection/ChannelMember;", "(Lio/getstream/chat/android/client/models/User;)V", "getUpdatedMember", "()Lio/getstream/chat/android/client/models/User;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "chat_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
        /* renamed from: com.memes.chat.ui.channel.create.stages.memberselection.ChannelMemberUpdate$Type$Removed */
        /* compiled from: ChannelMemberUpdate.kt */
        public static final class Removed extends Type {
            private final User updatedMember;

            public static /* synthetic */ Removed copy$default(Removed removed, User user, int i, Object obj) {
                if ((i & 1) != 0) {
                    user = removed.updatedMember;
                }
                return removed.copy(user);
            }

            public final User component1() {
                return this.updatedMember;
            }

            public final Removed copy(User user) {
                Intrinsics.checkNotNullParameter(user, "updatedMember");
                return new Removed(user);
            }

            public boolean equals(Object obj) {
                if (this != obj) {
                    return (obj instanceof Removed) && Intrinsics.areEqual((Object) this.updatedMember, (Object) ((Removed) obj).updatedMember);
                }
                return true;
            }

            public int hashCode() {
                User user = this.updatedMember;
                if (user != null) {
                    return user.hashCode();
                }
                return 0;
            }

            public String toString() {
                return "Removed(updatedMember=" + this.updatedMember + ")";
            }

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            public Removed(User user) {
                super((DefaultConstructorMarker) null);
                Intrinsics.checkNotNullParameter(user, "updatedMember");
                this.updatedMember = user;
            }

            public final User getUpdatedMember() {
                return this.updatedMember;
            }
        }
    }
}
