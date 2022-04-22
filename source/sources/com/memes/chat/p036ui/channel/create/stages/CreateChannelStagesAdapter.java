package com.memes.chat.p036ui.channel.create.stages;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;
import com.memes.chat.p036ui.channel.create.stages.channelinfoinput.ChannelInfoInputFragment;
import com.memes.chat.p036ui.channel.create.stages.memberselection.ChooseChannelMembersFragment;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import timber.log.Timber;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0016J\b\u0010\t\u001a\u00020\bH\u0016¨\u0006\n"}, mo26107d2 = {"Lcom/memes/chat/ui/channel/create/stages/CreateChannelStagesAdapter;", "Landroidx/viewpager2/adapter/FragmentStateAdapter;", "activity", "Landroidx/appcompat/app/AppCompatActivity;", "(Landroidx/appcompat/app/AppCompatActivity;)V", "createFragment", "Landroidx/fragment/app/Fragment;", "position", "", "getItemCount", "chat_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
/* renamed from: com.memes.chat.ui.channel.create.stages.CreateChannelStagesAdapter */
/* compiled from: CreateChannelStagesAdapter.kt */
public final class CreateChannelStagesAdapter extends FragmentStateAdapter {
    public int getItemCount() {
        return 2;
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public CreateChannelStagesAdapter(AppCompatActivity appCompatActivity) {
        super((FragmentActivity) appCompatActivity);
        Intrinsics.checkNotNullParameter(appCompatActivity, "activity");
    }

    public Fragment createFragment(int i) {
        Timber.m300d(this + ".createFragment(" + i + ')', new Object[0]);
        if (i == CreateChannelStage.CHOOSE_MEMBERS.getPosition()) {
            return new ChooseChannelMembersFragment();
        }
        if (i == CreateChannelStage.CHANNEL_INFO_INPUT.getPosition()) {
            return new ChannelInfoInputFragment();
        }
        throw new RuntimeException("Unknown position: " + i);
    }
}
