package com.memes.chat.routing;

import android.content.Context;
import android.content.Intent;
import com.memes.chat.p036ui.channel.create.CreateChannelActivity;
import com.memes.chat.p036ui.channel.info.ChannelInfoActivity;
import com.memes.chat.p036ui.channel.list.ChannelsActivity;
import com.memes.chat.p036ui.channel.members.ChannelMembersActivity;
import com.memes.chat.p036ui.channel.members.add.AddChannelMembersActivity;
import com.memes.chat.p036ui.channel.messages.ChannelMessagesActivity;
import com.memes.chat.p036ui.directmessaging.DirectMessagingActivity;
import com.memes.chat.p036ui.startup.ChatStartupActivity;
import com.memes.plus.p040ui.create_post.tagpeople.TagPeopleActivity;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import p015io.getstream.chat.android.client.models.Channel;
import tools.activityproxy.ActivityProxyBridge;
import tools.targetednavigation.TargetedNavigation;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\n\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0016\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0004J\u000e\u0010\u0011\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fJ\u0016\u0010\u0012\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0013\u001a\u00020\u0014J\u0016\u0010\u0012\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0004J\u0016\u0010\u0015\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0013\u001a\u00020\u0014J\"\u0010\u0015\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00042\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u0004J\u0016\u0010\u0017\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0004J\u000e\u0010\u0018\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fJ\u000e\u0010\u0019\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fJ\u000e\u0010\u001a\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fJ\u0016\u0010\u001b\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u001c\u001a\u00020\u0004J\u0016\u0010\u001d\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u001c\u001a\u00020\u0004R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u001e"}, mo26107d2 = {"Lcom/memes/chat/routing/ChatRouting;", "", "()V", "EXTRA_CHANNEL_DELETED", "", "EXTRA_CHANNEL_ID", "EXTRA_CHANNEL_IMAGE_CHANGED", "EXTRA_CHANNEL_LEFT", "EXTRA_CHANNEL_MEMBERS_UPDATED", "EXTRA_CHANNEL_NAME_CHANGED", "EXTRA_MESSAGE_ID", "EXTRA_PUSH_MESSAGE", "getAddChannelMembersIntent", "Landroid/content/Intent;", "context", "Landroid/content/Context;", "channelId", "getAppHomeIntent", "getChannelInfoIntent", "channel", "Lio/getstream/chat/android/client/models/Channel;", "getChannelIntent", "messageId", "getChannelMembersIntent", "getChannelsIntent", "getChatStartupIntent", "getCreateChannelIntent", "getDirectMessagingIntent", "userId", "getUserProfileIntent", "chat_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
/* compiled from: ChatRouting.kt */
public final class ChatRouting {
    public static final String EXTRA_CHANNEL_DELETED = "intent_extra_channel_deleted";
    public static final String EXTRA_CHANNEL_ID = "intent_extra_channel_id";
    public static final String EXTRA_CHANNEL_IMAGE_CHANGED = "intent_extra_channel_image_changed";
    public static final String EXTRA_CHANNEL_LEFT = "intent_extra_channel_left";
    public static final String EXTRA_CHANNEL_MEMBERS_UPDATED = "intent_extra_channel_members_updated";
    public static final String EXTRA_CHANNEL_NAME_CHANGED = "intent_extra_channel_name_changed";
    public static final String EXTRA_MESSAGE_ID = "intent_extra_message_id";
    public static final String EXTRA_PUSH_MESSAGE = "intent_extra_chat_push_message";
    public static final ChatRouting INSTANCE = new ChatRouting();

    private ChatRouting() {
    }

    public final Intent getAppHomeIntent(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        return ActivityProxyBridge.INSTANCE.getHomeIntent(context);
    }

    public final Intent getChatStartupIntent(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        return new Intent(context, ChatStartupActivity.class);
    }

    public final Intent getChannelsIntent(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        return new Intent(context, ChannelsActivity.class);
    }

    public final Intent getCreateChannelIntent(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        return new Intent(context, CreateChannelActivity.class);
    }

    public final Intent getChannelIntent(Context context, Channel channel) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(channel, "channel");
        return getChannelIntent$default(this, context, channel.getCid(), (String) null, 4, (Object) null);
    }

    public static /* synthetic */ Intent getChannelIntent$default(ChatRouting chatRouting, Context context, String str, String str2, int i, Object obj) {
        if ((i & 4) != 0) {
            str2 = null;
        }
        return chatRouting.getChannelIntent(context, str, str2);
    }

    public final Intent getChannelIntent(Context context, String str, String str2) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(str, "channelId");
        if (StringsKt.contains$default((CharSequence) str, (CharSequence) ":", false, 2, (Object) null)) {
            Intent intent = new Intent(context, ChannelMessagesActivity.class);
            intent.putExtra(EXTRA_CHANNEL_ID, str);
            intent.putExtra(EXTRA_MESSAGE_ID, str2);
            return intent;
        }
        throw new IllegalArgumentException("Only CIDs are allowed when opening a channel.");
    }

    public final Intent getChannelInfoIntent(Context context, Channel channel) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(channel, "channel");
        return getChannelInfoIntent(context, channel.getCid());
    }

    public final Intent getChannelInfoIntent(Context context, String str) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(str, "channelId");
        Intent intent = new Intent(context, ChannelInfoActivity.class);
        intent.putExtra(EXTRA_CHANNEL_ID, str);
        return intent;
    }

    public final Intent getChannelMembersIntent(Context context, String str) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(str, "channelId");
        Intent intent = new Intent(context, ChannelMembersActivity.class);
        intent.putExtra(EXTRA_CHANNEL_ID, str);
        return intent;
    }

    public final Intent getAddChannelMembersIntent(Context context, String str) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(str, "channelId");
        Intent intent = new Intent(context, AddChannelMembersActivity.class);
        intent.putExtra(EXTRA_CHANNEL_ID, str);
        return intent;
    }

    public final Intent getDirectMessagingIntent(Context context, String str) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(str, TagPeopleActivity.USER_ID);
        return DirectMessagingActivity.Companion.getStartIntent(context, str);
    }

    public final Intent getUserProfileIntent(Context context, String str) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(str, TagPeopleActivity.USER_ID);
        return TargetedNavigation.INSTANCE.createLaunchIntent(context, new TargetedNavigation.ProfilePageRequest(str, (String) null));
    }
}
