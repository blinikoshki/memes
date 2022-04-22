package com.memes.chat.p036ui.channel.list.pages;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import com.getstream.sdk.chat.view.channels.ChannelsView;
import com.getstream.sdk.chat.viewmodel.channels.ChannelsViewModel;
import com.getstream.sdk.chat.viewmodel.channels.ChannelsViewModelBinding;
import com.getstream.sdk.chat.viewmodel.factory.ChannelsViewModelFactory;
import com.memes.chat.databinding.ChannelsFragmentBinding;
import com.memes.chat.p036ui.channel.options.ChannelOption;
import com.memes.chat.p036ui.channel.options.ChannelOptionsBottomSheet;
import com.memes.chat.p036ui.channel.options.ChannelOptionsViewModel;
import com.memes.chat.routing.ChatRouting;
import com.memes.commons.fragment.BaseFragment;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import p015io.getstream.chat.android.client.models.Channel;
import p015io.getstream.chat.android.client.models.User;
import p015io.getstream.chat.android.client.utils.FilterObject;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b \u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u0015\u001a\u00020\u0016H$J\u0010\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0010\u001a\u00020\u0011H$J\u0018\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u001eH\u0002J$\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020\"2\b\u0010#\u001a\u0004\u0018\u00010$2\b\u0010%\u001a\u0004\u0018\u00010&H\u0016J\u001a\u0010'\u001a\u00020\u001a2\u0006\u0010(\u001a\u00020 2\b\u0010%\u001a\u0004\u0018\u00010&H\u0016J\u0010\u0010)\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u001cH\u0002J\u0010\u0010*\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u001cH\u0002R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0005\u001a\u00020\u00048BX\u0004¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007R\u001b\u0010\b\u001a\u00020\t8BX\u0002¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\n\u0010\u000bR\u000e\u0010\u000e\u001a\u00020\u000fX.¢\u0006\u0002\n\u0000R\u001b\u0010\u0010\u001a\u00020\u00118BX\u0002¢\u0006\f\n\u0004\b\u0014\u0010\r\u001a\u0004\b\u0012\u0010\u0013¨\u0006+"}, mo26107d2 = {"Lcom/memes/chat/ui/channel/list/pages/ChannelsFragment;", "Lcom/memes/commons/fragment/BaseFragment;", "()V", "_binding", "Lcom/memes/chat/databinding/ChannelsFragmentBinding;", "binding", "getBinding", "()Lcom/memes/chat/databinding/ChannelsFragmentBinding;", "channelOptionsViewModel", "Lcom/memes/chat/ui/channel/options/ChannelOptionsViewModel;", "getChannelOptionsViewModel", "()Lcom/memes/chat/ui/channel/options/ChannelOptionsViewModel;", "channelOptionsViewModel$delegate", "Lkotlin/Lazy;", "channelsViewModel", "Lcom/getstream/sdk/chat/viewmodel/channels/ChannelsViewModel;", "currentUser", "Lio/getstream/chat/android/client/models/User;", "getCurrentUser", "()Lio/getstream/chat/android/client/models/User;", "currentUser$delegate", "channelType", "", "createFilter", "Lio/getstream/chat/android/client/utils/FilterObject;", "onChannelOptionSelected", "", "channel", "Lio/getstream/chat/android/client/models/Channel;", "channelOption", "Lcom/memes/chat/ui/channel/options/ChannelOption;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onViewCreated", "view", "showChannel", "showChannelOptions", "chat_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
/* renamed from: com.memes.chat.ui.channel.list.pages.ChannelsFragment */
/* compiled from: ChannelsFragment.kt */
public abstract class ChannelsFragment extends BaseFragment {
    private ChannelsFragmentBinding _binding;
    private final Lazy channelOptionsViewModel$delegate = LazyKt.lazy(new ChannelsFragment$channelOptionsViewModel$2(this));
    private ChannelsViewModel channelsViewModel;
    private final Lazy currentUser$delegate = LazyKt.lazy(ChannelsFragment$currentUser$2.INSTANCE);

    @Metadata(mo26105bv = {1, 0, 3}, mo26108k = 3, mo26109mv = {1, 4, 2})
    /* renamed from: com.memes.chat.ui.channel.list.pages.ChannelsFragment$WhenMappings */
    public final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[ChannelOption.values().length];
            $EnumSwitchMapping$0 = iArr;
            iArr[ChannelOption.MUTE.ordinal()] = 1;
            iArr[ChannelOption.UNMUTE.ordinal()] = 2;
        }
    }

    private final ChannelOptionsViewModel getChannelOptionsViewModel() {
        return (ChannelOptionsViewModel) this.channelOptionsViewModel$delegate.getValue();
    }

    private final User getCurrentUser() {
        return (User) this.currentUser$delegate.getValue();
    }

    /* access modifiers changed from: protected */
    public abstract String channelType();

    /* access modifiers changed from: protected */
    public abstract FilterObject createFilter(User user);

    /* access modifiers changed from: private */
    public final ChannelsFragmentBinding getBinding() {
        ChannelsFragmentBinding channelsFragmentBinding = this._binding;
        if (channelsFragmentBinding != null) {
            return channelsFragmentBinding;
        }
        throw new IllegalArgumentException("Required value was null.".toString());
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        Intrinsics.checkNotNullParameter(layoutInflater, "inflater");
        this._binding = ChannelsFragmentBinding.inflate(layoutInflater, viewGroup, false);
        getBinding().channelsView.setOnChannelClickListener(new ChannelsFragment$onCreateView$1(this));
        getBinding().channelsView.setOnLongClickListener(new ChannelsFragment$onCreateView$2(this));
        ConstraintLayout root = getBinding().getRoot();
        Intrinsics.checkNotNullExpressionValue(root, "binding.root");
        return root;
    }

    public void onViewCreated(View view, Bundle bundle) {
        Intrinsics.checkNotNullParameter(view, ViewHierarchyConstants.VIEW_KEY);
        registerViewModels(getChannelOptionsViewModel());
        ChannelsViewModel channelsViewModel2 = (ChannelsViewModel) new ChannelsViewModelFactory(createFilter(getCurrentUser()), ChannelsViewModel.DEFAULT_SORT, 0, 4, (DefaultConstructorMarker) null).create(ChannelsViewModel.class);
        this.channelsViewModel = channelsViewModel2;
        if (channelsViewModel2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("channelsViewModel");
        }
        channelsViewModel2.getPaginationState().observe(getViewLifecycleOwner(), new ChannelsFragment$onViewCreated$1(this));
        ChannelsView channelsView = getBinding().channelsView;
        Context requireContext = requireContext();
        Intrinsics.checkNotNullExpressionValue(requireContext, "requireContext()");
        channelsView.setViewHolderFactory(new ChannelTypeAwareChannelViewHolderFactory(requireContext, channelType()));
        ChannelsViewModel channelsViewModel3 = this.channelsViewModel;
        if (channelsViewModel3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("channelsViewModel");
        }
        ChannelsView channelsView2 = getBinding().channelsView;
        Intrinsics.checkNotNullExpressionValue(channelsView2, "binding.channelsView");
        ChannelsViewModelBinding.bind(channelsViewModel3, channelsView2, this);
    }

    /* access modifiers changed from: private */
    public final void showChannel(Channel channel) {
        ChatRouting chatRouting = ChatRouting.INSTANCE;
        Context requireContext = requireContext();
        Intrinsics.checkNotNullExpressionValue(requireContext, "requireContext()");
        startActivity(chatRouting.getChannelIntent(requireContext, channel));
    }

    /* access modifiers changed from: private */
    public final void showChannelOptions(Channel channel) {
        List<ChannelOption> channelOptions = getChannelOptionsViewModel().getChannelOptions(channel);
        if (!channelOptions.isEmpty()) {
            ChannelOptionsBottomSheet channelOptionsBottomSheet = new ChannelOptionsBottomSheet();
            FragmentActivity requireActivity = requireActivity();
            Intrinsics.checkNotNullExpressionValue(requireActivity, "requireActivity()");
            FragmentManager supportFragmentManager = requireActivity.getSupportFragmentManager();
            Intrinsics.checkNotNullExpressionValue(supportFragmentManager, "requireActivity().supportFragmentManager");
            channelOptionsBottomSheet.show(supportFragmentManager, channelOptions, new ChannelsFragment$showChannelOptions$1(this, channel));
        }
    }

    /* access modifiers changed from: private */
    public final void onChannelOptionSelected(Channel channel, ChannelOption channelOption) {
        int i = WhenMappings.$EnumSwitchMapping$0[channelOption.ordinal()];
        if (i == 1) {
            getChannelOptionsViewModel().muteChannel(channel);
        } else if (i == 2) {
            getChannelOptionsViewModel().unmuteChannel(channel);
        }
    }
}
