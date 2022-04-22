package com.getstream.sdk.chat.adapter;

import com.getstream.sdk.chat.utils.ListenerDelegate;
import com.getstream.sdk.chat.view.MessageListView;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.MutablePropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b-\b\u0000\u0018\u00002\u00020\u0001:\u0001=BU\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\t\u0012\b\b\u0002\u0010\n\u001a\u00020\u000b\u0012\b\b\u0002\u0010\f\u001a\u00020\r\u0012\b\b\u0002\u0010\u000e\u001a\u00020\u000f\u0012\b\b\u0002\u0010\u0010\u001a\u00020\u0011¢\u0006\u0002\u0010\u0012R+\u0010\b\u001a\u00020\t2\u0006\u0010\u0013\u001a\u00020\t8V@VX\u0002¢\u0006\u0012\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R+\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0013\u001a\u00020\u00118V@VX\u0002¢\u0006\u0012\n\u0004\b\u001e\u0010\u0019\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR+\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0013\u001a\u00020\u00038V@VX\u0002¢\u0006\u0012\n\u0004\b#\u0010\u0019\u001a\u0004\b\u001f\u0010 \"\u0004\b!\u0010\"R+\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0013\u001a\u00020\u00058V@VX\u0002¢\u0006\u0012\n\u0004\b(\u0010\u0019\u001a\u0004\b$\u0010%\"\u0004\b&\u0010'R+\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u0013\u001a\u00020\u00078V@VX\u0002¢\u0006\u0012\n\u0004\b-\u0010\u0019\u001a\u0004\b)\u0010*\"\u0004\b+\u0010,R+\u0010\n\u001a\u00020\u000b2\u0006\u0010\u0013\u001a\u00020\u000b8V@VX\u0002¢\u0006\u0012\n\u0004\b2\u0010\u0019\u001a\u0004\b.\u0010/\"\u0004\b0\u00101R+\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0013\u001a\u00020\u000f8V@VX\u0002¢\u0006\u0012\n\u0004\b7\u0010\u0019\u001a\u0004\b3\u00104\"\u0004\b5\u00106R+\u0010\f\u001a\u00020\r2\u0006\u0010\u0013\u001a\u00020\r8V@VX\u0002¢\u0006\u0012\n\u0004\b<\u0010\u0019\u001a\u0004\b8\u00109\"\u0004\b:\u0010;¨\u0006>"}, mo26107d2 = {"Lcom/getstream/sdk/chat/adapter/ListenerContainerImpl;", "Lcom/getstream/sdk/chat/adapter/ListenerContainer;", "messageClickListener", "Lcom/getstream/sdk/chat/view/MessageListView$MessageClickListener;", "messageLongClickListener", "Lcom/getstream/sdk/chat/view/MessageListView$MessageLongClickListener;", "messageRetryListener", "Lcom/getstream/sdk/chat/view/MessageListView$MessageRetryListener;", "attachmentClickListener", "Lcom/getstream/sdk/chat/view/MessageListView$AttachmentClickListener;", "reactionViewClickListener", "Lcom/getstream/sdk/chat/view/MessageListView$ReactionViewClickListener;", "userClickListener", "Lcom/getstream/sdk/chat/view/MessageListView$UserClickListener;", "readStateClickListener", "Lcom/getstream/sdk/chat/view/MessageListView$ReadStateClickListener;", "giphySendListener", "Lcom/getstream/sdk/chat/view/MessageListView$GiphySendListener;", "(Lcom/getstream/sdk/chat/view/MessageListView$MessageClickListener;Lcom/getstream/sdk/chat/view/MessageListView$MessageLongClickListener;Lcom/getstream/sdk/chat/view/MessageListView$MessageRetryListener;Lcom/getstream/sdk/chat/view/MessageListView$AttachmentClickListener;Lcom/getstream/sdk/chat/view/MessageListView$ReactionViewClickListener;Lcom/getstream/sdk/chat/view/MessageListView$UserClickListener;Lcom/getstream/sdk/chat/view/MessageListView$ReadStateClickListener;Lcom/getstream/sdk/chat/view/MessageListView$GiphySendListener;)V", "<set-?>", "getAttachmentClickListener", "()Lcom/getstream/sdk/chat/view/MessageListView$AttachmentClickListener;", "setAttachmentClickListener", "(Lcom/getstream/sdk/chat/view/MessageListView$AttachmentClickListener;)V", "attachmentClickListener$delegate", "Lcom/getstream/sdk/chat/utils/ListenerDelegate;", "getGiphySendListener", "()Lcom/getstream/sdk/chat/view/MessageListView$GiphySendListener;", "setGiphySendListener", "(Lcom/getstream/sdk/chat/view/MessageListView$GiphySendListener;)V", "giphySendListener$delegate", "getMessageClickListener", "()Lcom/getstream/sdk/chat/view/MessageListView$MessageClickListener;", "setMessageClickListener", "(Lcom/getstream/sdk/chat/view/MessageListView$MessageClickListener;)V", "messageClickListener$delegate", "getMessageLongClickListener", "()Lcom/getstream/sdk/chat/view/MessageListView$MessageLongClickListener;", "setMessageLongClickListener", "(Lcom/getstream/sdk/chat/view/MessageListView$MessageLongClickListener;)V", "messageLongClickListener$delegate", "getMessageRetryListener", "()Lcom/getstream/sdk/chat/view/MessageListView$MessageRetryListener;", "setMessageRetryListener", "(Lcom/getstream/sdk/chat/view/MessageListView$MessageRetryListener;)V", "messageRetryListener$delegate", "getReactionViewClickListener", "()Lcom/getstream/sdk/chat/view/MessageListView$ReactionViewClickListener;", "setReactionViewClickListener", "(Lcom/getstream/sdk/chat/view/MessageListView$ReactionViewClickListener;)V", "reactionViewClickListener$delegate", "getReadStateClickListener", "()Lcom/getstream/sdk/chat/view/MessageListView$ReadStateClickListener;", "setReadStateClickListener", "(Lcom/getstream/sdk/chat/view/MessageListView$ReadStateClickListener;)V", "readStateClickListener$delegate", "getUserClickListener", "()Lcom/getstream/sdk/chat/view/MessageListView$UserClickListener;", "setUserClickListener", "(Lcom/getstream/sdk/chat/view/MessageListView$UserClickListener;)V", "userClickListener$delegate", "EmptyFunctions", "stream-chat-android_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
/* compiled from: ListenerContainerImpl.kt */
public final class ListenerContainerImpl implements ListenerContainer {
    static final /* synthetic */ KProperty[] $$delegatedProperties;
    private final ListenerDelegate attachmentClickListener$delegate;
    private final ListenerDelegate giphySendListener$delegate;
    private final ListenerDelegate messageClickListener$delegate;
    private final ListenerDelegate messageLongClickListener$delegate;
    private final ListenerDelegate messageRetryListener$delegate;
    private final ListenerDelegate reactionViewClickListener$delegate;
    private final ListenerDelegate readStateClickListener$delegate;
    private final ListenerDelegate userClickListener$delegate;

    static {
        Class<ListenerContainerImpl> cls = ListenerContainerImpl.class;
        $$delegatedProperties = new KProperty[]{Reflection.mutableProperty1(new MutablePropertyReference1Impl(cls, "messageClickListener", "getMessageClickListener()Lcom/getstream/sdk/chat/view/MessageListView$MessageClickListener;", 0)), Reflection.mutableProperty1(new MutablePropertyReference1Impl(cls, "messageLongClickListener", "getMessageLongClickListener()Lcom/getstream/sdk/chat/view/MessageListView$MessageLongClickListener;", 0)), Reflection.mutableProperty1(new MutablePropertyReference1Impl(cls, "messageRetryListener", "getMessageRetryListener()Lcom/getstream/sdk/chat/view/MessageListView$MessageRetryListener;", 0)), Reflection.mutableProperty1(new MutablePropertyReference1Impl(cls, "attachmentClickListener", "getAttachmentClickListener()Lcom/getstream/sdk/chat/view/MessageListView$AttachmentClickListener;", 0)), Reflection.mutableProperty1(new MutablePropertyReference1Impl(cls, "reactionViewClickListener", "getReactionViewClickListener()Lcom/getstream/sdk/chat/view/MessageListView$ReactionViewClickListener;", 0)), Reflection.mutableProperty1(new MutablePropertyReference1Impl(cls, "userClickListener", "getUserClickListener()Lcom/getstream/sdk/chat/view/MessageListView$UserClickListener;", 0)), Reflection.mutableProperty1(new MutablePropertyReference1Impl(cls, "readStateClickListener", "getReadStateClickListener()Lcom/getstream/sdk/chat/view/MessageListView$ReadStateClickListener;", 0)), Reflection.mutableProperty1(new MutablePropertyReference1Impl(cls, "giphySendListener", "getGiphySendListener()Lcom/getstream/sdk/chat/view/MessageListView$GiphySendListener;", 0))};
    }

    public ListenerContainerImpl() {
        this((MessageListView.MessageClickListener) null, (MessageListView.MessageLongClickListener) null, (MessageListView.MessageRetryListener) null, (MessageListView.AttachmentClickListener) null, (MessageListView.ReactionViewClickListener) null, (MessageListView.UserClickListener) null, (MessageListView.ReadStateClickListener) null, (MessageListView.GiphySendListener) null, 255, (DefaultConstructorMarker) null);
    }

    public MessageListView.AttachmentClickListener getAttachmentClickListener() {
        return (MessageListView.AttachmentClickListener) this.attachmentClickListener$delegate.getValue(this, $$delegatedProperties[3]);
    }

    public MessageListView.GiphySendListener getGiphySendListener() {
        return (MessageListView.GiphySendListener) this.giphySendListener$delegate.getValue(this, $$delegatedProperties[7]);
    }

    public MessageListView.MessageClickListener getMessageClickListener() {
        return (MessageListView.MessageClickListener) this.messageClickListener$delegate.getValue(this, $$delegatedProperties[0]);
    }

    public MessageListView.MessageLongClickListener getMessageLongClickListener() {
        return (MessageListView.MessageLongClickListener) this.messageLongClickListener$delegate.getValue(this, $$delegatedProperties[1]);
    }

    public MessageListView.MessageRetryListener getMessageRetryListener() {
        return (MessageListView.MessageRetryListener) this.messageRetryListener$delegate.getValue(this, $$delegatedProperties[2]);
    }

    public MessageListView.ReactionViewClickListener getReactionViewClickListener() {
        return (MessageListView.ReactionViewClickListener) this.reactionViewClickListener$delegate.getValue(this, $$delegatedProperties[4]);
    }

    public MessageListView.ReadStateClickListener getReadStateClickListener() {
        return (MessageListView.ReadStateClickListener) this.readStateClickListener$delegate.getValue(this, $$delegatedProperties[6]);
    }

    public MessageListView.UserClickListener getUserClickListener() {
        return (MessageListView.UserClickListener) this.userClickListener$delegate.getValue(this, $$delegatedProperties[5]);
    }

    public void setAttachmentClickListener(MessageListView.AttachmentClickListener attachmentClickListener) {
        Intrinsics.checkNotNullParameter(attachmentClickListener, "<set-?>");
        this.attachmentClickListener$delegate.setValue(this, $$delegatedProperties[3], attachmentClickListener);
    }

    public void setGiphySendListener(MessageListView.GiphySendListener giphySendListener) {
        Intrinsics.checkNotNullParameter(giphySendListener, "<set-?>");
        this.giphySendListener$delegate.setValue(this, $$delegatedProperties[7], giphySendListener);
    }

    public void setMessageClickListener(MessageListView.MessageClickListener messageClickListener) {
        Intrinsics.checkNotNullParameter(messageClickListener, "<set-?>");
        this.messageClickListener$delegate.setValue(this, $$delegatedProperties[0], messageClickListener);
    }

    public void setMessageLongClickListener(MessageListView.MessageLongClickListener messageLongClickListener) {
        Intrinsics.checkNotNullParameter(messageLongClickListener, "<set-?>");
        this.messageLongClickListener$delegate.setValue(this, $$delegatedProperties[1], messageLongClickListener);
    }

    public void setMessageRetryListener(MessageListView.MessageRetryListener messageRetryListener) {
        Intrinsics.checkNotNullParameter(messageRetryListener, "<set-?>");
        this.messageRetryListener$delegate.setValue(this, $$delegatedProperties[2], messageRetryListener);
    }

    public void setReactionViewClickListener(MessageListView.ReactionViewClickListener reactionViewClickListener) {
        Intrinsics.checkNotNullParameter(reactionViewClickListener, "<set-?>");
        this.reactionViewClickListener$delegate.setValue(this, $$delegatedProperties[4], reactionViewClickListener);
    }

    public void setReadStateClickListener(MessageListView.ReadStateClickListener readStateClickListener) {
        Intrinsics.checkNotNullParameter(readStateClickListener, "<set-?>");
        this.readStateClickListener$delegate.setValue(this, $$delegatedProperties[6], readStateClickListener);
    }

    public void setUserClickListener(MessageListView.UserClickListener userClickListener) {
        Intrinsics.checkNotNullParameter(userClickListener, "<set-?>");
        this.userClickListener$delegate.setValue(this, $$delegatedProperties[5], userClickListener);
    }

    public ListenerContainerImpl(MessageListView.MessageClickListener messageClickListener, MessageListView.MessageLongClickListener messageLongClickListener, MessageListView.MessageRetryListener messageRetryListener, MessageListView.AttachmentClickListener attachmentClickListener, MessageListView.ReactionViewClickListener reactionViewClickListener, MessageListView.UserClickListener userClickListener, MessageListView.ReadStateClickListener readStateClickListener, MessageListView.GiphySendListener giphySendListener) {
        Intrinsics.checkNotNullParameter(messageClickListener, "messageClickListener");
        Intrinsics.checkNotNullParameter(messageLongClickListener, "messageLongClickListener");
        Intrinsics.checkNotNullParameter(messageRetryListener, "messageRetryListener");
        Intrinsics.checkNotNullParameter(attachmentClickListener, "attachmentClickListener");
        Intrinsics.checkNotNullParameter(reactionViewClickListener, "reactionViewClickListener");
        Intrinsics.checkNotNullParameter(userClickListener, "userClickListener");
        Intrinsics.checkNotNullParameter(readStateClickListener, "readStateClickListener");
        Intrinsics.checkNotNullParameter(giphySendListener, "giphySendListener");
        this.messageClickListener$delegate = new ListenerDelegate(messageClickListener, ListenerContainerImpl$messageClickListener$2.INSTANCE);
        this.messageLongClickListener$delegate = new ListenerDelegate(messageLongClickListener, ListenerContainerImpl$messageLongClickListener$2.INSTANCE);
        this.messageRetryListener$delegate = new ListenerDelegate(messageRetryListener, ListenerContainerImpl$messageRetryListener$2.INSTANCE);
        this.attachmentClickListener$delegate = new ListenerDelegate(attachmentClickListener, ListenerContainerImpl$attachmentClickListener$2.INSTANCE);
        this.reactionViewClickListener$delegate = new ListenerDelegate(reactionViewClickListener, ListenerContainerImpl$reactionViewClickListener$2.INSTANCE);
        this.userClickListener$delegate = new ListenerDelegate(userClickListener, ListenerContainerImpl$userClickListener$2.INSTANCE);
        this.readStateClickListener$delegate = new ListenerDelegate(readStateClickListener, ListenerContainerImpl$readStateClickListener$2.INSTANCE);
        this.giphySendListener$delegate = new ListenerDelegate(giphySendListener, ListenerContainerImpl$giphySendListener$2.INSTANCE);
    }

    /* JADX WARNING: type inference failed for: r8v0, types: [com.getstream.sdk.chat.adapter.ListenerContainerImpl$sam$com_getstream_sdk_chat_view_MessageListView_GiphySendListener$0] */
    /* JADX WARNING: type inference failed for: r8v1, types: [com.getstream.sdk.chat.adapter.ListenerContainerImpl$sam$com_getstream_sdk_chat_view_MessageListView_ReadStateClickListener$0] */
    /* JADX WARNING: type inference failed for: r7v8, types: [com.getstream.sdk.chat.adapter.ListenerContainerImpl$sam$com_getstream_sdk_chat_view_MessageListView_UserClickListener$0] */
    /* JADX WARNING: type inference failed for: r6v8, types: [com.getstream.sdk.chat.adapter.ListenerContainerImpl$sam$com_getstream_sdk_chat_view_MessageListView_ReactionViewClickListener$0] */
    /* JADX WARNING: type inference failed for: r5v8, types: [com.getstream.sdk.chat.adapter.ListenerContainerImpl$sam$com_getstream_sdk_chat_view_MessageListView_AttachmentClickListener$0] */
    /* JADX WARNING: type inference failed for: r4v8, types: [com.getstream.sdk.chat.adapter.ListenerContainerImpl$sam$com_getstream_sdk_chat_view_MessageListView_MessageRetryListener$0] */
    /* JADX WARNING: type inference failed for: r3v8, types: [com.getstream.sdk.chat.adapter.ListenerContainerImpl$sam$com_getstream_sdk_chat_view_MessageListView_MessageLongClickListener$0] */
    /* JADX WARNING: type inference failed for: r2v8, types: [com.getstream.sdk.chat.adapter.ListenerContainerImpl$sam$com_getstream_sdk_chat_view_MessageListView_MessageClickListener$0] */
    /* JADX WARNING: Illegal instructions before constructor call */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ ListenerContainerImpl(com.getstream.sdk.chat.view.MessageListView.MessageClickListener r10, com.getstream.sdk.chat.view.MessageListView.MessageLongClickListener r11, com.getstream.sdk.chat.view.MessageListView.MessageRetryListener r12, com.getstream.sdk.chat.view.MessageListView.AttachmentClickListener r13, com.getstream.sdk.chat.view.MessageListView.ReactionViewClickListener r14, com.getstream.sdk.chat.view.MessageListView.UserClickListener r15, com.getstream.sdk.chat.view.MessageListView.ReadStateClickListener r16, com.getstream.sdk.chat.view.MessageListView.GiphySendListener r17, int r18, kotlin.jvm.internal.DefaultConstructorMarker r19) {
        /*
            r9 = this;
            r0 = r18
            r1 = r0 & 1
            if (r1 == 0) goto L_0x0017
            com.getstream.sdk.chat.adapter.ListenerContainerImpl$EmptyFunctions r1 = com.getstream.sdk.chat.adapter.ListenerContainerImpl.EmptyFunctions.INSTANCE
            kotlin.jvm.functions.Function1 r1 = r1.getONE_PARAM()
            if (r1 == 0) goto L_0x0014
            com.getstream.sdk.chat.adapter.ListenerContainerImpl$sam$com_getstream_sdk_chat_view_MessageListView_MessageClickListener$0 r2 = new com.getstream.sdk.chat.adapter.ListenerContainerImpl$sam$com_getstream_sdk_chat_view_MessageListView_MessageClickListener$0
            r2.<init>(r1)
            r1 = r2
        L_0x0014:
            com.getstream.sdk.chat.view.MessageListView$MessageClickListener r1 = (com.getstream.sdk.chat.view.MessageListView.MessageClickListener) r1
            goto L_0x0018
        L_0x0017:
            r1 = r10
        L_0x0018:
            r2 = r0 & 2
            if (r2 == 0) goto L_0x002d
            com.getstream.sdk.chat.adapter.ListenerContainerImpl$EmptyFunctions r2 = com.getstream.sdk.chat.adapter.ListenerContainerImpl.EmptyFunctions.INSTANCE
            kotlin.jvm.functions.Function1 r2 = r2.getONE_PARAM()
            if (r2 == 0) goto L_0x002a
            com.getstream.sdk.chat.adapter.ListenerContainerImpl$sam$com_getstream_sdk_chat_view_MessageListView_MessageLongClickListener$0 r3 = new com.getstream.sdk.chat.adapter.ListenerContainerImpl$sam$com_getstream_sdk_chat_view_MessageListView_MessageLongClickListener$0
            r3.<init>(r2)
            r2 = r3
        L_0x002a:
            com.getstream.sdk.chat.view.MessageListView$MessageLongClickListener r2 = (com.getstream.sdk.chat.view.MessageListView.MessageLongClickListener) r2
            goto L_0x002e
        L_0x002d:
            r2 = r11
        L_0x002e:
            r3 = r0 & 4
            if (r3 == 0) goto L_0x0043
            com.getstream.sdk.chat.adapter.ListenerContainerImpl$EmptyFunctions r3 = com.getstream.sdk.chat.adapter.ListenerContainerImpl.EmptyFunctions.INSTANCE
            kotlin.jvm.functions.Function1 r3 = r3.getONE_PARAM()
            if (r3 == 0) goto L_0x0040
            com.getstream.sdk.chat.adapter.ListenerContainerImpl$sam$com_getstream_sdk_chat_view_MessageListView_MessageRetryListener$0 r4 = new com.getstream.sdk.chat.adapter.ListenerContainerImpl$sam$com_getstream_sdk_chat_view_MessageListView_MessageRetryListener$0
            r4.<init>(r3)
            r3 = r4
        L_0x0040:
            com.getstream.sdk.chat.view.MessageListView$MessageRetryListener r3 = (com.getstream.sdk.chat.view.MessageListView.MessageRetryListener) r3
            goto L_0x0044
        L_0x0043:
            r3 = r12
        L_0x0044:
            r4 = r0 & 8
            if (r4 == 0) goto L_0x0059
            com.getstream.sdk.chat.adapter.ListenerContainerImpl$EmptyFunctions r4 = com.getstream.sdk.chat.adapter.ListenerContainerImpl.EmptyFunctions.INSTANCE
            kotlin.jvm.functions.Function2 r4 = r4.getTWO_PARAM()
            if (r4 == 0) goto L_0x0056
            com.getstream.sdk.chat.adapter.ListenerContainerImpl$sam$com_getstream_sdk_chat_view_MessageListView_AttachmentClickListener$0 r5 = new com.getstream.sdk.chat.adapter.ListenerContainerImpl$sam$com_getstream_sdk_chat_view_MessageListView_AttachmentClickListener$0
            r5.<init>(r4)
            r4 = r5
        L_0x0056:
            com.getstream.sdk.chat.view.MessageListView$AttachmentClickListener r4 = (com.getstream.sdk.chat.view.MessageListView.AttachmentClickListener) r4
            goto L_0x005a
        L_0x0059:
            r4 = r13
        L_0x005a:
            r5 = r0 & 16
            if (r5 == 0) goto L_0x006f
            com.getstream.sdk.chat.adapter.ListenerContainerImpl$EmptyFunctions r5 = com.getstream.sdk.chat.adapter.ListenerContainerImpl.EmptyFunctions.INSTANCE
            kotlin.jvm.functions.Function1 r5 = r5.getONE_PARAM()
            if (r5 == 0) goto L_0x006c
            com.getstream.sdk.chat.adapter.ListenerContainerImpl$sam$com_getstream_sdk_chat_view_MessageListView_ReactionViewClickListener$0 r6 = new com.getstream.sdk.chat.adapter.ListenerContainerImpl$sam$com_getstream_sdk_chat_view_MessageListView_ReactionViewClickListener$0
            r6.<init>(r5)
            r5 = r6
        L_0x006c:
            com.getstream.sdk.chat.view.MessageListView$ReactionViewClickListener r5 = (com.getstream.sdk.chat.view.MessageListView.ReactionViewClickListener) r5
            goto L_0x0070
        L_0x006f:
            r5 = r14
        L_0x0070:
            r6 = r0 & 32
            if (r6 == 0) goto L_0x0085
            com.getstream.sdk.chat.adapter.ListenerContainerImpl$EmptyFunctions r6 = com.getstream.sdk.chat.adapter.ListenerContainerImpl.EmptyFunctions.INSTANCE
            kotlin.jvm.functions.Function1 r6 = r6.getONE_PARAM()
            if (r6 == 0) goto L_0x0082
            com.getstream.sdk.chat.adapter.ListenerContainerImpl$sam$com_getstream_sdk_chat_view_MessageListView_UserClickListener$0 r7 = new com.getstream.sdk.chat.adapter.ListenerContainerImpl$sam$com_getstream_sdk_chat_view_MessageListView_UserClickListener$0
            r7.<init>(r6)
            r6 = r7
        L_0x0082:
            com.getstream.sdk.chat.view.MessageListView$UserClickListener r6 = (com.getstream.sdk.chat.view.MessageListView.UserClickListener) r6
            goto L_0x0086
        L_0x0085:
            r6 = r15
        L_0x0086:
            r7 = r0 & 64
            if (r7 == 0) goto L_0x009b
            com.getstream.sdk.chat.adapter.ListenerContainerImpl$EmptyFunctions r7 = com.getstream.sdk.chat.adapter.ListenerContainerImpl.EmptyFunctions.INSTANCE
            kotlin.jvm.functions.Function1 r7 = r7.getONE_PARAM()
            if (r7 == 0) goto L_0x0098
            com.getstream.sdk.chat.adapter.ListenerContainerImpl$sam$com_getstream_sdk_chat_view_MessageListView_ReadStateClickListener$0 r8 = new com.getstream.sdk.chat.adapter.ListenerContainerImpl$sam$com_getstream_sdk_chat_view_MessageListView_ReadStateClickListener$0
            r8.<init>(r7)
            r7 = r8
        L_0x0098:
            com.getstream.sdk.chat.view.MessageListView$ReadStateClickListener r7 = (com.getstream.sdk.chat.view.MessageListView.ReadStateClickListener) r7
            goto L_0x009d
        L_0x009b:
            r7 = r16
        L_0x009d:
            r0 = r0 & 128(0x80, float:1.794E-43)
            if (r0 == 0) goto L_0x00b2
            com.getstream.sdk.chat.adapter.ListenerContainerImpl$EmptyFunctions r0 = com.getstream.sdk.chat.adapter.ListenerContainerImpl.EmptyFunctions.INSTANCE
            kotlin.jvm.functions.Function2 r0 = r0.getTWO_PARAM()
            if (r0 == 0) goto L_0x00af
            com.getstream.sdk.chat.adapter.ListenerContainerImpl$sam$com_getstream_sdk_chat_view_MessageListView_GiphySendListener$0 r8 = new com.getstream.sdk.chat.adapter.ListenerContainerImpl$sam$com_getstream_sdk_chat_view_MessageListView_GiphySendListener$0
            r8.<init>(r0)
            r0 = r8
        L_0x00af:
            com.getstream.sdk.chat.view.MessageListView$GiphySendListener r0 = (com.getstream.sdk.chat.view.MessageListView.GiphySendListener) r0
            goto L_0x00b4
        L_0x00b2:
            r0 = r17
        L_0x00b4:
            r10 = r9
            r11 = r1
            r12 = r2
            r13 = r3
            r14 = r4
            r15 = r5
            r16 = r6
            r17 = r7
            r18 = r0
            r10.<init>(r11, r12, r13, r14, r15, r16, r17, r18)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.getstream.sdk.chat.adapter.ListenerContainerImpl.<init>(com.getstream.sdk.chat.view.MessageListView$MessageClickListener, com.getstream.sdk.chat.view.MessageListView$MessageLongClickListener, com.getstream.sdk.chat.view.MessageListView$MessageRetryListener, com.getstream.sdk.chat.view.MessageListView$AttachmentClickListener, com.getstream.sdk.chat.view.MessageListView$ReactionViewClickListener, com.getstream.sdk.chat.view.MessageListView$UserClickListener, com.getstream.sdk.chat.view.MessageListView$ReadStateClickListener, com.getstream.sdk.chat.view.MessageListView$GiphySendListener, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }

    @Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\bÂ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u001d\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R#\u0010\b\u001a\u0014\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u00050\t¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\f"}, mo26107d2 = {"Lcom/getstream/sdk/chat/adapter/ListenerContainerImpl$EmptyFunctions;", "", "()V", "ONE_PARAM", "Lkotlin/Function1;", "", "getONE_PARAM", "()Lkotlin/jvm/functions/Function1;", "TWO_PARAM", "Lkotlin/Function2;", "getTWO_PARAM", "()Lkotlin/jvm/functions/Function2;", "stream-chat-android_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
    /* compiled from: ListenerContainerImpl.kt */
    private static final class EmptyFunctions {
        public static final EmptyFunctions INSTANCE = new EmptyFunctions();
        private static final Function1<Object, Unit> ONE_PARAM = ListenerContainerImpl$EmptyFunctions$ONE_PARAM$1.INSTANCE;
        private static final Function2<Object, Object, Unit> TWO_PARAM = ListenerContainerImpl$EmptyFunctions$TWO_PARAM$1.INSTANCE;

        private EmptyFunctions() {
        }

        public final Function1<Object, Unit> getONE_PARAM() {
            return ONE_PARAM;
        }

        public final Function2<Object, Object, Unit> getTWO_PARAM() {
            return TWO_PARAM;
        }
    }
}
