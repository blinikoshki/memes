package com.memes.chat.p036ui.channel.settings;

import kotlin.Metadata;
import kotlin.jvm.internal.MutablePropertyReference0Impl;
import p015io.getstream.chat.android.client.models.Channel;

@Metadata(mo26105bv = {1, 0, 3}, mo26108k = 3, mo26109mv = {1, 4, 2})
/* renamed from: com.memes.chat.ui.channel.settings.ChannelSettingsViewModel$refreshUnsavedChangesAvailability$1 */
/* compiled from: ChannelSettingsViewModel.kt */
final /* synthetic */ class ChannelSettingsViewModel$refreshUnsavedChangesAvailability$1 extends MutablePropertyReference0Impl {
    ChannelSettingsViewModel$refreshUnsavedChangesAvailability$1(ChannelSettingsViewModel channelSettingsViewModel) {
        super(channelSettingsViewModel, ChannelSettingsViewModel.class, "channel", "getChannel()Lio/getstream/chat/android/client/models/Channel;", 0);
    }

    public Object get() {
        return ChannelSettingsViewModel.access$getChannel$p((ChannelSettingsViewModel) this.receiver);
    }

    public void set(Object obj) {
        ((ChannelSettingsViewModel) this.receiver).channel = (Channel) obj;
    }
}
