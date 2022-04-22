package com.getstream.sdk.chat.view.messages;

import com.getstream.sdk.chat.adapter.MessageListItem;
import com.google.firebase.analytics.FirebaseAnalytics;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u000f\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B3\u0012\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006\u0012\b\b\u0002\u0010\b\u001a\u00020\u0006¢\u0006\u0002\u0010\tJ\u000f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003J\t\u0010\u000f\u001a\u00020\u0006HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0006HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0006HÆ\u0003J7\u0010\u0012\u001a\u00020\u00002\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\u00062\b\b\u0002\u0010\b\u001a\u00020\u0006HÆ\u0001J\u0013\u0010\u0013\u001a\u00020\u00062\b\u0010\u0014\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0015\u001a\u00020\u0016HÖ\u0001J\t\u0010\u0017\u001a\u00020\u0018HÖ\u0001R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\b\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u000bR\u0011\u0010\u0007\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\u000bR\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\r¨\u0006\u0019"}, mo26107d2 = {"Lcom/getstream/sdk/chat/view/messages/MessageListItemWrapper;", "", "items", "", "Lcom/getstream/sdk/chat/adapter/MessageListItem;", "hasNewMessages", "", "isTyping", "isThread", "(Ljava/util/List;ZZZ)V", "getHasNewMessages", "()Z", "getItems", "()Ljava/util/List;", "component1", "component2", "component3", "component4", "copy", "equals", "other", "hashCode", "", "toString", "", "stream-chat-android-ui-common_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
/* compiled from: MessageListItemWrapper.kt */
public final class MessageListItemWrapper {
    private final boolean hasNewMessages;
    private final boolean isThread;
    private final boolean isTyping;
    private final List<MessageListItem> items;

    public MessageListItemWrapper() {
        this((List) null, false, false, false, 15, (DefaultConstructorMarker) null);
    }

    public static /* synthetic */ MessageListItemWrapper copy$default(MessageListItemWrapper messageListItemWrapper, List<MessageListItem> list, boolean z, boolean z2, boolean z3, int i, Object obj) {
        if ((i & 1) != 0) {
            list = messageListItemWrapper.items;
        }
        if ((i & 2) != 0) {
            z = messageListItemWrapper.hasNewMessages;
        }
        if ((i & 4) != 0) {
            z2 = messageListItemWrapper.isTyping;
        }
        if ((i & 8) != 0) {
            z3 = messageListItemWrapper.isThread;
        }
        return messageListItemWrapper.copy(list, z, z2, z3);
    }

    public final List<MessageListItem> component1() {
        return this.items;
    }

    public final boolean component2() {
        return this.hasNewMessages;
    }

    public final boolean component3() {
        return this.isTyping;
    }

    public final boolean component4() {
        return this.isThread;
    }

    public final MessageListItemWrapper copy(List<? extends MessageListItem> list, boolean z, boolean z2, boolean z3) {
        Intrinsics.checkNotNullParameter(list, FirebaseAnalytics.Param.ITEMS);
        return new MessageListItemWrapper(list, z, z2, z3);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof MessageListItemWrapper)) {
            return false;
        }
        MessageListItemWrapper messageListItemWrapper = (MessageListItemWrapper) obj;
        return Intrinsics.areEqual((Object) this.items, (Object) messageListItemWrapper.items) && this.hasNewMessages == messageListItemWrapper.hasNewMessages && this.isTyping == messageListItemWrapper.isTyping && this.isThread == messageListItemWrapper.isThread;
    }

    public int hashCode() {
        List<MessageListItem> list = this.items;
        int hashCode = (list != null ? list.hashCode() : 0) * 31;
        boolean z = this.hasNewMessages;
        boolean z2 = true;
        if (z) {
            z = true;
        }
        int i = (hashCode + (z ? 1 : 0)) * 31;
        boolean z3 = this.isTyping;
        if (z3) {
            z3 = true;
        }
        int i2 = (i + (z3 ? 1 : 0)) * 31;
        boolean z4 = this.isThread;
        if (!z4) {
            z2 = z4;
        }
        return i2 + (z2 ? 1 : 0);
    }

    public String toString() {
        return "MessageListItemWrapper(items=" + this.items + ", hasNewMessages=" + this.hasNewMessages + ", isTyping=" + this.isTyping + ", isThread=" + this.isThread + ")";
    }

    public MessageListItemWrapper(List<? extends MessageListItem> list, boolean z, boolean z2, boolean z3) {
        Intrinsics.checkNotNullParameter(list, FirebaseAnalytics.Param.ITEMS);
        this.items = list;
        this.hasNewMessages = z;
        this.isTyping = z2;
        this.isThread = z3;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ MessageListItemWrapper(List list, boolean z, boolean z2, boolean z3, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? CollectionsKt.emptyList() : list, (i & 2) != 0 ? false : z, (i & 4) != 0 ? false : z2, (i & 8) != 0 ? false : z3);
    }

    public final List<MessageListItem> getItems() {
        return this.items;
    }

    public final boolean getHasNewMessages() {
        return this.hasNewMessages;
    }

    public final boolean isTyping() {
        return this.isTyping;
    }

    public final boolean isThread() {
        return this.isThread;
    }
}
