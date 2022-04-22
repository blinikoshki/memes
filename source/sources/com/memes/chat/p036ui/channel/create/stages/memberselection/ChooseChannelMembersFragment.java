package com.memes.chat.p036ui.channel.create.stages.memberselection;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import com.memes.chat.databinding.ChooseChannelMembersFragmentBinding;
import com.memes.chat.p036ui.channel.create.stages.memberselection.ChannelMemberUpdate;
import com.memes.chat.p036ui.custom.ChatSearchInputLayout;
import com.memes.commons.contentlayout.ContentLayout;
import com.memes.commons.fragment.BaseFragment;
import com.memes.commons.pagination.Paginator;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0000\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003B\u0005¢\u0006\u0002\u0010\u0004J\u0010\u0010'\u001a\u00020(2\u0006\u0010)\u001a\u00020*H\u0002J\u0010\u0010+\u001a\u00020(2\u0006\u0010,\u001a\u00020-H\u0016J\u0018\u0010.\u001a\u00020(2\u0006\u0010/\u001a\u0002002\u0006\u00101\u001a\u000200H\u0016J&\u00102\u001a\u0004\u0018\u0001032\u0006\u00104\u001a\u0002052\b\u00106\u001a\u0004\u0018\u0001072\b\u00108\u001a\u0004\u0018\u000109H\u0016J\u0012\u0010:\u001a\u00020(2\b\u0010;\u001a\u0004\u0018\u00010\fH\u0016J\u001a\u0010<\u001a\u00020(2\u0006\u0010=\u001a\u0002032\b\u00108\u001a\u0004\u0018\u000109H\u0016R\u001b\u0010\u0005\u001a\u00020\u00068BX\u0002¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u0007\u0010\bR\u0014\u0010\u000b\u001a\u00020\fXD¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u000e\u0010\u000f\u001a\u00020\u0010X.¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X.¢\u0006\u0002\n\u0000R\u001b\u0010\u0013\u001a\u00020\u00148BX\u0002¢\u0006\f\n\u0004\b\u0017\u0010\n\u001a\u0004\b\u0015\u0010\u0016R\u001b\u0010\u0018\u001a\u00020\u00198BX\u0002¢\u0006\f\n\u0004\b\u001c\u0010\n\u001a\u0004\b\u001a\u0010\u001bR\u001b\u0010\u001d\u001a\u00020\u001e8BX\u0002¢\u0006\f\n\u0004\b!\u0010\n\u001a\u0004\b\u001f\u0010 R\u001b\u0010\"\u001a\u00020#8BX\u0002¢\u0006\f\n\u0004\b&\u0010\n\u001a\u0004\b$\u0010%¨\u0006>"}, mo26107d2 = {"Lcom/memes/chat/ui/channel/create/stages/memberselection/ChooseChannelMembersFragment;", "Lcom/memes/commons/fragment/BaseFragment;", "Lcom/memes/chat/ui/custom/ChatSearchInputLayout$Callback;", "Lcom/memes/commons/contentlayout/ContentLayout$Callback;", "()V", "addedChannelMembersAdapter", "Lcom/memes/chat/ui/channel/create/stages/memberselection/ChosenChannelMembersAdapter;", "getAddedChannelMembersAdapter", "()Lcom/memes/chat/ui/channel/create/stages/memberselection/ChosenChannelMembersAdapter;", "addedChannelMembersAdapter$delegate", "Lkotlin/Lazy;", "assignedFragmentTag", "", "getAssignedFragmentTag", "()Ljava/lang/String;", "binding", "Lcom/memes/chat/databinding/ChooseChannelMembersFragmentBinding;", "channelMembersSelectionChangedListener", "Lcom/memes/chat/ui/channel/create/stages/memberselection/OnChannelMembersSelectionChangedListener;", "chooseChannelMembersViewModel", "Lcom/memes/chat/ui/channel/create/stages/memberselection/ChooseChannelMembersViewModel;", "getChooseChannelMembersViewModel", "()Lcom/memes/chat/ui/channel/create/stages/memberselection/ChooseChannelMembersViewModel;", "chooseChannelMembersViewModel$delegate", "userSearchResultsAdapter", "Lcom/memes/chat/ui/channel/create/stages/memberselection/UserSearchResultsAdapter;", "getUserSearchResultsAdapter", "()Lcom/memes/chat/ui/channel/create/stages/memberselection/UserSearchResultsAdapter;", "userSearchResultsAdapter$delegate", "userSearchResultsLayoutManager", "Landroidx/recyclerview/widget/LinearLayoutManager;", "getUserSearchResultsLayoutManager", "()Landroidx/recyclerview/widget/LinearLayoutManager;", "userSearchResultsLayoutManager$delegate", "userSearchResultsPaginator", "Lcom/memes/commons/pagination/Paginator;", "getUserSearchResultsPaginator", "()Lcom/memes/commons/pagination/Paginator;", "userSearchResultsPaginator$delegate", "handleChannelMemberSelectionChanged", "", "update", "Lcom/memes/chat/ui/channel/create/stages/memberselection/ChannelMemberUpdate;", "onAttach", "context", "Landroid/content/Context;", "onContentLayoutErrorResolutionButtonTapped", "who", "", "why", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onSearchRequested", "query", "onViewCreated", "view", "chat_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
/* renamed from: com.memes.chat.ui.channel.create.stages.memberselection.ChooseChannelMembersFragment */
/* compiled from: ChooseChannelMembersFragment.kt */
public final class ChooseChannelMembersFragment extends BaseFragment implements ChatSearchInputLayout.Callback, ContentLayout.Callback {
    private final Lazy addedChannelMembersAdapter$delegate = LazyKt.lazy(new ChooseChannelMembersFragment$addedChannelMembersAdapter$2(this));
    private final String assignedFragmentTag = "ChooseChannelMembersFragment";
    /* access modifiers changed from: private */
    public ChooseChannelMembersFragmentBinding binding;
    private OnChannelMembersSelectionChangedListener channelMembersSelectionChangedListener;
    private final Lazy chooseChannelMembersViewModel$delegate = LazyKt.lazy(new ChooseChannelMembersFragment$chooseChannelMembersViewModel$2(this));
    private final Lazy userSearchResultsAdapter$delegate = LazyKt.lazy(new ChooseChannelMembersFragment$userSearchResultsAdapter$2(this));
    private final Lazy userSearchResultsLayoutManager$delegate = LazyKt.lazy(new ChooseChannelMembersFragment$userSearchResultsLayoutManager$2(this));
    private final Lazy userSearchResultsPaginator$delegate = LazyKt.lazy(new ChooseChannelMembersFragment$userSearchResultsPaginator$2(this));

    /* access modifiers changed from: private */
    public final ChosenChannelMembersAdapter getAddedChannelMembersAdapter() {
        return (ChosenChannelMembersAdapter) this.addedChannelMembersAdapter$delegate.getValue();
    }

    /* access modifiers changed from: private */
    public final ChooseChannelMembersViewModel getChooseChannelMembersViewModel() {
        return (ChooseChannelMembersViewModel) this.chooseChannelMembersViewModel$delegate.getValue();
    }

    /* access modifiers changed from: private */
    public final UserSearchResultsAdapter getUserSearchResultsAdapter() {
        return (UserSearchResultsAdapter) this.userSearchResultsAdapter$delegate.getValue();
    }

    /* access modifiers changed from: private */
    public final LinearLayoutManager getUserSearchResultsLayoutManager() {
        return (LinearLayoutManager) this.userSearchResultsLayoutManager$delegate.getValue();
    }

    /* access modifiers changed from: private */
    public final Paginator getUserSearchResultsPaginator() {
        return (Paginator) this.userSearchResultsPaginator$delegate.getValue();
    }

    public static final /* synthetic */ ChooseChannelMembersFragmentBinding access$getBinding$p(ChooseChannelMembersFragment chooseChannelMembersFragment) {
        ChooseChannelMembersFragmentBinding chooseChannelMembersFragmentBinding = chooseChannelMembersFragment.binding;
        if (chooseChannelMembersFragmentBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        return chooseChannelMembersFragmentBinding;
    }

    public String getAssignedFragmentTag() {
        return this.assignedFragmentTag;
    }

    public void onAttach(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        super.onAttach(context);
        this.channelMembersSelectionChangedListener = (OnChannelMembersSelectionChangedListener) context;
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        Intrinsics.checkNotNullParameter(layoutInflater, "inflater");
        ChooseChannelMembersFragmentBinding inflate = ChooseChannelMembersFragmentBinding.inflate(layoutInflater, viewGroup, false);
        Intrinsics.checkNotNullExpressionValue(inflate, "ChooseChannelMembersFrag…flater, container, false)");
        this.binding = inflate;
        if (inflate == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        return inflate.getRoot();
    }

    public void onViewCreated(View view, Bundle bundle) {
        Intrinsics.checkNotNullParameter(view, ViewHierarchyConstants.VIEW_KEY);
        registerViewModels(getChooseChannelMembersViewModel());
        ChooseChannelMembersFragmentBinding chooseChannelMembersFragmentBinding = this.binding;
        if (chooseChannelMembersFragmentBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        chooseChannelMembersFragmentBinding.nameInputLayout.setCallback(this);
        ChooseChannelMembersFragmentBinding chooseChannelMembersFragmentBinding2 = this.binding;
        if (chooseChannelMembersFragmentBinding2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        chooseChannelMembersFragmentBinding2.searchResultsContentLayout.setCallback(this);
        ChooseChannelMembersFragmentBinding chooseChannelMembersFragmentBinding3 = this.binding;
        if (chooseChannelMembersFragmentBinding3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        chooseChannelMembersFragmentBinding3.nameInputLayout.setDrawableStartVisible(false);
        ChooseChannelMembersFragmentBinding chooseChannelMembersFragmentBinding4 = this.binding;
        if (chooseChannelMembersFragmentBinding4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        RecyclerView recyclerView = chooseChannelMembersFragmentBinding4.channelMembersRecyclerView;
        Intrinsics.checkNotNullExpressionValue(recyclerView, "binding.channelMembersRecyclerView");
        recyclerView.setLayoutManager(new LinearLayoutManager(requireContext(), 0, false));
        getAddedChannelMembersAdapter().setAdapterItemCountChangeListener(new ChooseChannelMembersFragment$onViewCreated$1(this));
        ChooseChannelMembersFragmentBinding chooseChannelMembersFragmentBinding5 = this.binding;
        if (chooseChannelMembersFragmentBinding5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        RecyclerView recyclerView2 = chooseChannelMembersFragmentBinding5.channelMembersRecyclerView;
        Intrinsics.checkNotNullExpressionValue(recyclerView2, "binding.channelMembersRecyclerView");
        recyclerView2.setAdapter(getAddedChannelMembersAdapter());
        ChooseChannelMembersFragmentBinding chooseChannelMembersFragmentBinding6 = this.binding;
        if (chooseChannelMembersFragmentBinding6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        RecyclerView recyclerView3 = chooseChannelMembersFragmentBinding6.searchResultsRecyclerView;
        Intrinsics.checkNotNullExpressionValue(recyclerView3, "binding.searchResultsRecyclerView");
        recyclerView3.setLayoutManager(getUserSearchResultsLayoutManager());
        ChooseChannelMembersFragmentBinding chooseChannelMembersFragmentBinding7 = this.binding;
        if (chooseChannelMembersFragmentBinding7 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        RecyclerView recyclerView4 = chooseChannelMembersFragmentBinding7.searchResultsRecyclerView;
        Intrinsics.checkNotNullExpressionValue(recyclerView4, "binding.searchResultsRecyclerView");
        recyclerView4.setAdapter(getUserSearchResultsAdapter());
        getChooseChannelMembersViewModel().userSearchResults().observe(getViewLifecycleOwner(), new ChooseChannelMembersFragment$onViewCreated$2(this));
        getChooseChannelMembersViewModel().userSearchResultsState().observe(getViewLifecycleOwner(), new ChooseChannelMembersFragment$onViewCreated$3(this));
        getChooseChannelMembersViewModel().loadingNextSearchResults().observe(getViewLifecycleOwner(), new ChooseChannelMembersFragment$onViewCreated$4(this));
        getChooseChannelMembersViewModel().channelMemberSelectionUpdated().observe(getViewLifecycleOwner(), new ChooseChannelMembersFragment$onViewCreated$5(this));
        ChooseChannelMembersFragmentBinding chooseChannelMembersFragmentBinding8 = this.binding;
        if (chooseChannelMembersFragmentBinding8 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        chooseChannelMembersFragmentBinding8.nameInputLayout.showKeyboard();
    }

    /* access modifiers changed from: private */
    public final void handleChannelMemberSelectionChanged(ChannelMemberUpdate channelMemberUpdate) {
        ChannelMemberUpdate.Type type = channelMemberUpdate.getType();
        if (type instanceof ChannelMemberUpdate.Type.Added) {
            ChannelMemberUpdate.Type.Added added = (ChannelMemberUpdate.Type.Added) type;
            getAddedChannelMembersAdapter().addChannelMember(added.getUpdatedMember());
            getUserSearchResultsAdapter().setSelectedItemById(added.getUpdatedMember().getId());
            ChooseChannelMembersFragmentBinding chooseChannelMembersFragmentBinding = this.binding;
            if (chooseChannelMembersFragmentBinding == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
            }
            chooseChannelMembersFragmentBinding.channelMembersRecyclerView.post(new C4087x7cf735e3(this));
        } else if (type instanceof ChannelMemberUpdate.Type.Removed) {
            ChannelMemberUpdate.Type.Removed removed = (ChannelMemberUpdate.Type.Removed) type;
            getAddedChannelMembersAdapter().removeChannelMember(removed.getUpdatedMember());
            getUserSearchResultsAdapter().removeItemSelectionById(removed.getUpdatedMember().getId());
        }
        OnChannelMembersSelectionChangedListener onChannelMembersSelectionChangedListener = this.channelMembersSelectionChangedListener;
        if (onChannelMembersSelectionChangedListener == null) {
            Intrinsics.throwUninitializedPropertyAccessException("channelMembersSelectionChangedListener");
        }
        onChannelMembersSelectionChangedListener.onChannelMembersSelectionChanged(channelMemberUpdate.getAllMembers());
    }

    public void onSearchRequested(String str) {
        CharSequence charSequence = str;
        if (charSequence == null || StringsKt.isBlank(charSequence)) {
            str = null;
        }
        getChooseChannelMembersViewModel().searchUsers(str);
    }

    public void onContentLayoutErrorResolutionButtonTapped(int i, int i2) {
        ChooseChannelMembersFragmentBinding chooseChannelMembersFragmentBinding = this.binding;
        if (chooseChannelMembersFragmentBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        ContentLayout contentLayout = chooseChannelMembersFragmentBinding.searchResultsContentLayout;
        Intrinsics.checkNotNullExpressionValue(contentLayout, "binding.searchResultsContentLayout");
        if (contentLayout.getId() == i && i2 == 1211) {
            getChooseChannelMembersViewModel().refreshSearchResults();
            return;
        }
        throw new RuntimeException("Unable to resolve content-layout error resolution: " + i + ' ' + i2);
    }
}
