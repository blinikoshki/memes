package com.memes.chat.p036ui.channel.list;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;
import com.memes.chat.p036ui.channel.list.pages.p037private.PrivateChannelsFragment;
import com.memes.chat.p036ui.channel.list.pages.p038public.PublicChannelsFragment;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import timber.log.Timber;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0016J\b\u0010\t\u001a\u00020\bH\u0016J\u000e\u0010\n\u001a\u00020\u000b2\u0006\u0010\u0007\u001a\u00020\b¨\u0006\f"}, mo26107d2 = {"Lcom/memes/chat/ui/channel/list/ChannelsTabsAdapter;", "Landroidx/viewpager2/adapter/FragmentStateAdapter;", "activity", "Landroidx/appcompat/app/AppCompatActivity;", "(Landroidx/appcompat/app/AppCompatActivity;)V", "createFragment", "Landroidx/fragment/app/Fragment;", "position", "", "getItemCount", "getPageTitle", "", "chat_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
/* renamed from: com.memes.chat.ui.channel.list.ChannelsTabsAdapter */
/* compiled from: ChannelsTabsAdapter.kt */
public final class ChannelsTabsAdapter extends FragmentStateAdapter {
    public int getItemCount() {
        return 2;
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ChannelsTabsAdapter(AppCompatActivity appCompatActivity) {
        super((FragmentActivity) appCompatActivity);
        Intrinsics.checkNotNullParameter(appCompatActivity, "activity");
    }

    public Fragment createFragment(int i) {
        Timber.m300d(this + ".createFragment(" + i + ')', new Object[0]);
        if (i == ChannelTabType.PUBLIC.getPosition()) {
            return new PublicChannelsFragment();
        }
        if (i == ChannelTabType.PRIVATE.getPosition()) {
            return new PrivateChannelsFragment();
        }
        throw new RuntimeException("Unknown position: " + i);
    }

    public final String getPageTitle(int i) {
        if (i == ChannelTabType.PUBLIC.getPosition()) {
            return "Public";
        }
        if (i == ChannelTabType.PRIVATE.getPosition()) {
            return "Private";
        }
        throw new RuntimeException("Unknown position: " + i);
    }
}
