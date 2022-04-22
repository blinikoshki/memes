package com.memes.chat.p036ui.channel.list;

import android.os.Bundle;
import android.util.TypedValue;
import android.view.View;
import androidx.viewpager2.widget.ViewPager2;
import com.google.android.material.badge.BadgeDrawable;
import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;
import com.memes.chat.C4059R;
import com.memes.chat.base.BaseChatActivity;
import com.memes.chat.databinding.ChannelsActivityBinding;
import com.memes.chat.events.viewmodel.ChatEventsViewModel;
import com.memes.chat.p036ui.channel.list.ChannelTabType;
import com.memes.chat.routing.ChatRouting;
import com.memes.commons.util.ExtensionsKt;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\b\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u0013\u001a\u00020\u0014H\u0002J\b\u0010\u0015\u001a\u00020\u0014H\u0016J\u0012\u0010\u0016\u001a\u00020\u00142\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018H\u0014J\b\u0010\u0019\u001a\u00020\u0014H\u0002J\u0010\u0010\u001a\u001a\u00020\u00142\u0006\u0010\u001b\u001a\u00020\u001cH\u0002R\u001b\u0010\u0003\u001a\u00020\u00048BX\u0002¢\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\u0005\u0010\u0006R\u001b\u0010\t\u001a\u00020\n8BX\u0002¢\u0006\f\n\u0004\b\r\u0010\b\u001a\u0004\b\u000b\u0010\fR\u001b\u0010\u000e\u001a\u00020\u000f8BX\u0002¢\u0006\f\n\u0004\b\u0012\u0010\b\u001a\u0004\b\u0010\u0010\u0011¨\u0006\u001d"}, mo26107d2 = {"Lcom/memes/chat/ui/channel/list/ChannelsActivity;", "Lcom/memes/chat/base/BaseChatActivity;", "()V", "binding", "Lcom/memes/chat/databinding/ChannelsActivityBinding;", "getBinding", "()Lcom/memes/chat/databinding/ChannelsActivityBinding;", "binding$delegate", "Lkotlin/Lazy;", "chatEventsViewModel", "Lcom/memes/chat/events/viewmodel/ChatEventsViewModel;", "getChatEventsViewModel", "()Lcom/memes/chat/events/viewmodel/ChatEventsViewModel;", "chatEventsViewModel$delegate", "tabsAdapter", "Lcom/memes/chat/ui/channel/list/ChannelsTabsAdapter;", "getTabsAdapter", "()Lcom/memes/chat/ui/channel/list/ChannelsTabsAdapter;", "tabsAdapter$delegate", "initViewPager", "", "onBackPressed", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "showCreateChannelPage", "updateChatBadgeCount", "count", "", "chat_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
/* renamed from: com.memes.chat.ui.channel.list.ChannelsActivity */
/* compiled from: ChannelsActivity.kt */
public final class ChannelsActivity extends BaseChatActivity {
    private final Lazy binding$delegate = LazyKt.lazy(new ChannelsActivity$binding$2(this));
    private final Lazy chatEventsViewModel$delegate = LazyKt.lazy(new ChannelsActivity$chatEventsViewModel$2(this));
    private final Lazy tabsAdapter$delegate = LazyKt.lazy(new ChannelsActivity$tabsAdapter$2(this));

    @Metadata(mo26105bv = {1, 0, 3}, mo26108k = 3, mo26109mv = {1, 4, 2})
    /* renamed from: com.memes.chat.ui.channel.list.ChannelsActivity$WhenMappings */
    public final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[ChannelTabType.values().length];
            $EnumSwitchMapping$0 = iArr;
            iArr[ChannelTabType.PRIVATE.ordinal()] = 1;
            iArr[ChannelTabType.PUBLIC.ordinal()] = 2;
        }
    }

    private final ChannelsActivityBinding getBinding() {
        return (ChannelsActivityBinding) this.binding$delegate.getValue();
    }

    /* access modifiers changed from: private */
    public final ChatEventsViewModel getChatEventsViewModel() {
        return (ChatEventsViewModel) this.chatEventsViewModel$delegate.getValue();
    }

    /* access modifiers changed from: private */
    public final ChannelsTabsAdapter getTabsAdapter() {
        return (ChannelsTabsAdapter) this.tabsAdapter$delegate.getValue();
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        ChannelsActivityBinding binding = getBinding();
        Intrinsics.checkNotNullExpressionValue(binding, "binding");
        setContentView((View) binding.getRoot());
        registerViewModels(getChatEventsViewModel());
        getBinding().backImageView.setOnClickListener(new ChannelsActivity$onCreate$1(this));
        getBinding().createChannelImageView.setOnClickListener(new ChannelsActivity$onCreate$2(this));
        initViewPager();
        getChatEventsViewModel().chatBadgeCount().observe(this, new ChannelsActivity$onCreate$3(this));
    }

    public void onBackPressed() {
        if (isTaskRoot()) {
            startActivity(ChatRouting.INSTANCE.getAppHomeIntent(this));
        }
        super.onBackPressed();
    }

    private final void initViewPager() {
        getBinding().channelsViewPager.registerOnPageChangeCallback(new ChannelsActivity$initViewPager$1(this));
        ViewPager2 viewPager2 = getBinding().channelsViewPager;
        Intrinsics.checkNotNullExpressionValue(viewPager2, "binding.channelsViewPager");
        viewPager2.setAdapter(getTabsAdapter());
        new TabLayoutMediator(getBinding().channelsTabLayout, getBinding().channelsViewPager, new ChannelsActivity$initViewPager$2(this)).attach();
    }

    /* access modifiers changed from: private */
    public final void updateChatBadgeCount(int i) {
        TabLayout.Tab tabAt = getBinding().channelsTabLayout.getTabAt(ChannelTabType.PRIVATE.getPosition());
        if (tabAt != null) {
            Intrinsics.checkNotNullExpressionValue(tabAt, "binding.channelsTabLayou…IVATE.position) ?: return");
            BadgeDrawable orCreateBadge = tabAt.getOrCreateBadge();
            Intrinsics.checkNotNullExpressionValue(orCreateBadge, "privateChannelsTab.getOrCreateBadge()");
            orCreateBadge.setBackgroundColor(ExtensionsKt.getColorFromAttr$default(this, C4059R.attr.colorChatBadgeBackground, (TypedValue) null, false, 6, (Object) null));
            ChannelTabType.Companion companion = ChannelTabType.Companion;
            ViewPager2 viewPager2 = getBinding().channelsViewPager;
            Intrinsics.checkNotNullExpressionValue(viewPager2, "binding.channelsViewPager");
            int i2 = WhenMappings.$EnumSwitchMapping$0[companion.tabTypeForPosition(viewPager2.getCurrentItem()).ordinal()];
            if (i2 == 1) {
                orCreateBadge.setVisible(false);
            } else if (i2 == 2) {
                if (i > 0) {
                    orCreateBadge.setVisible(true);
                } else {
                    orCreateBadge.setVisible(false);
                }
            }
        }
    }

    /* access modifiers changed from: private */
    public final void showCreateChannelPage() {
        startActivity(ChatRouting.INSTANCE.getCreateChannelIntent(this));
    }
}
