package com.memes.chat.p036ui.channel.members;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.LifecycleOwner;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.memes.chat.C4059R;
import com.memes.chat.base.BaseChatActivity;
import com.memes.chat.databinding.ChannelMembersActivityBinding;
import com.memes.chat.p036ui.channel.events.ChannelEventsViewModel;
import com.memes.chat.p036ui.channel.members.ChannelMembersAdapter;
import com.memes.chat.p036ui.channel.members.options.UserActionsBottomSheet;
import com.memes.chat.p036ui.custom.StyledAlertDialog;
import com.memes.chat.routing.ChatRouting;
import com.memes.commons.contentlayout.ContentLayout;
import com.memes.commons.pagination.Paginator;
import com.zhuinden.livedatacombinetuplekt.LiveDataCombineTupleKt;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import p015io.getstream.chat.android.client.models.Channel;
import p015io.getstream.chat.android.client.models.ContentUtils;
import p015io.getstream.chat.android.client.models.Member;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0000\u0018\u0000 ;2\u00020\u00012\u00020\u00022\u00020\u0003:\u0001;B\u0005¢\u0006\u0002\u0010\u0004J\"\u0010(\u001a\u00020)2\u0006\u0010*\u001a\u00020+2\u0006\u0010,\u001a\u00020+2\b\u0010-\u001a\u0004\u0018\u00010'H\u0014J\b\u0010.\u001a\u00020)H\u0016J\u0010\u0010/\u001a\u00020)2\u0006\u00100\u001a\u000201H\u0016J\u0018\u00102\u001a\u00020)2\u0006\u00103\u001a\u00020+2\u0006\u00104\u001a\u00020+H\u0016J\u0012\u00105\u001a\u00020)2\b\u00106\u001a\u0004\u0018\u000107H\u0014J\b\u00108\u001a\u00020)H\u0014J\u0010\u00109\u001a\u00020)2\u0006\u00100\u001a\u000201H\u0016J\b\u0010:\u001a\u00020)H\u0002R\u001b\u0010\u0005\u001a\u00020\u00068BX\u0002¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u0007\u0010\bR\u001b\u0010\u000b\u001a\u00020\f8BX\u0002¢\u0006\f\n\u0004\b\u000f\u0010\n\u001a\u0004\b\r\u0010\u000eR\u000e\u0010\u0010\u001a\u00020\u0011X.¢\u0006\u0002\n\u0000R\u001b\u0010\u0012\u001a\u00020\u00138BX\u0002¢\u0006\f\n\u0004\b\u0016\u0010\n\u001a\u0004\b\u0014\u0010\u0015R\u001b\u0010\u0017\u001a\u00020\u00188BX\u0002¢\u0006\f\n\u0004\b\u001b\u0010\n\u001a\u0004\b\u0019\u0010\u001aR\u001b\u0010\u001c\u001a\u00020\u001d8BX\u0002¢\u0006\f\n\u0004\b \u0010\n\u001a\u0004\b\u001e\u0010\u001fR\u001b\u0010!\u001a\u00020\"8BX\u0002¢\u0006\f\n\u0004\b%\u0010\n\u001a\u0004\b#\u0010$R\u000e\u0010&\u001a\u00020'X\u0004¢\u0006\u0002\n\u0000¨\u0006<"}, mo26107d2 = {"Lcom/memes/chat/ui/channel/members/ChannelMembersActivity;", "Lcom/memes/chat/base/BaseChatActivity;", "Lcom/memes/chat/ui/channel/members/ChannelMembersAdapter$Callback;", "Lcom/memes/commons/contentlayout/ContentLayout$Callback;", "()V", "binding", "Lcom/memes/chat/databinding/ChannelMembersActivityBinding;", "getBinding", "()Lcom/memes/chat/databinding/ChannelMembersActivityBinding;", "binding$delegate", "Lkotlin/Lazy;", "channelEventsViewModel", "Lcom/memes/chat/ui/channel/events/ChannelEventsViewModel;", "getChannelEventsViewModel", "()Lcom/memes/chat/ui/channel/events/ChannelEventsViewModel;", "channelEventsViewModel$delegate", "channelId", "", "channelMembersAdapter", "Lcom/memes/chat/ui/channel/members/ChannelMembersAdapter;", "getChannelMembersAdapter", "()Lcom/memes/chat/ui/channel/members/ChannelMembersAdapter;", "channelMembersAdapter$delegate", "channelMembersViewModel", "Lcom/memes/chat/ui/channel/members/ChannelMembersViewModel;", "getChannelMembersViewModel", "()Lcom/memes/chat/ui/channel/members/ChannelMembersViewModel;", "channelMembersViewModel$delegate", "membersLayoutManager", "Landroidx/recyclerview/widget/LinearLayoutManager;", "getMembersLayoutManager", "()Landroidx/recyclerview/widget/LinearLayoutManager;", "membersLayoutManager$delegate", "membersPaginator", "Lcom/memes/commons/pagination/Paginator;", "getMembersPaginator", "()Lcom/memes/commons/pagination/Paginator;", "membersPaginator$delegate", "resultIntent", "Landroid/content/Intent;", "onActivityResult", "", "requestCode", "", "resultCode", "data", "onBackPressed", "onChannelMemberViewTapped", "channelMember", "Lio/getstream/chat/android/client/models/Member;", "onContentLayoutErrorResolutionButtonTapped", "who", "why", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "onRemoveChannelMemberViewTapped", "setupChannelMembers", "Companion", "chat_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
/* renamed from: com.memes.chat.ui.channel.members.ChannelMembersActivity */
/* compiled from: ChannelMembersActivity.kt */
public final class ChannelMembersActivity extends BaseChatActivity implements ChannelMembersAdapter.Callback, ContentLayout.Callback {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private static final int RC_ADD_CHANNEL_MEMBERS = 46545;
    private final Lazy binding$delegate = LazyKt.lazy(new ChannelMembersActivity$binding$2(this));
    private final Lazy channelEventsViewModel$delegate = LazyKt.lazy(new ChannelMembersActivity$channelEventsViewModel$2(this));
    /* access modifiers changed from: private */
    public String channelId;
    private final Lazy channelMembersAdapter$delegate = LazyKt.lazy(new ChannelMembersActivity$channelMembersAdapter$2(this));
    private final Lazy channelMembersViewModel$delegate = LazyKt.lazy(new ChannelMembersActivity$channelMembersViewModel$2(this));
    private final Lazy membersLayoutManager$delegate = LazyKt.lazy(new ChannelMembersActivity$membersLayoutManager$2(this));
    private final Lazy membersPaginator$delegate = LazyKt.lazy(new ChannelMembersActivity$membersPaginator$2(this));
    /* access modifiers changed from: private */
    public final Intent resultIntent = new Intent();

    /* access modifiers changed from: private */
    public final ChannelMembersActivityBinding getBinding() {
        return (ChannelMembersActivityBinding) this.binding$delegate.getValue();
    }

    private final ChannelEventsViewModel getChannelEventsViewModel() {
        return (ChannelEventsViewModel) this.channelEventsViewModel$delegate.getValue();
    }

    /* access modifiers changed from: private */
    public final ChannelMembersAdapter getChannelMembersAdapter() {
        return (ChannelMembersAdapter) this.channelMembersAdapter$delegate.getValue();
    }

    /* access modifiers changed from: private */
    public final ChannelMembersViewModel getChannelMembersViewModel() {
        return (ChannelMembersViewModel) this.channelMembersViewModel$delegate.getValue();
    }

    /* access modifiers changed from: private */
    public final LinearLayoutManager getMembersLayoutManager() {
        return (LinearLayoutManager) this.membersLayoutManager$delegate.getValue();
    }

    /* access modifiers changed from: private */
    public final Paginator getMembersPaginator() {
        return (Paginator) this.membersPaginator$delegate.getValue();
    }

    public static final /* synthetic */ String access$getChannelId$p(ChannelMembersActivity channelMembersActivity) {
        String str = channelMembersActivity.channelId;
        if (str == null) {
            Intrinsics.throwUninitializedPropertyAccessException("channelId");
        }
        return str;
    }

    @Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, mo26107d2 = {"Lcom/memes/chat/ui/channel/members/ChannelMembersActivity$Companion;", "", "()V", "RC_ADD_CHANNEL_MEMBERS", "", "chat_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
    /* renamed from: com.memes.chat.ui.channel.members.ChannelMembersActivity$Companion */
    /* compiled from: ChannelMembersActivity.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        ChannelMembersActivityBinding binding = getBinding();
        Intrinsics.checkNotNullExpressionValue(binding, "binding");
        setContentView((View) binding.getRoot());
        registerViewModels(getChannelMembersViewModel(), getChannelEventsViewModel());
        getBinding().backImageView.setOnClickListener(new ChannelMembersActivity$onCreate$1(this));
        getBinding().addMembersImageView.setOnClickListener(new ChannelMembersActivity$onCreate$2(this));
        getBinding().contentLayout.setCallback(this);
        getBinding().swipeRefreshLayout.setOnRefreshListener(new ChannelMembersActivity$onCreate$3(this));
        RecyclerView recyclerView = getBinding().membersRecyclerView;
        Intrinsics.checkNotNullExpressionValue(recyclerView, "binding.membersRecyclerView");
        recyclerView.setLayoutManager(getMembersLayoutManager());
        RecyclerView recyclerView2 = getBinding().membersRecyclerView;
        Intrinsics.checkNotNullExpressionValue(recyclerView2, "binding.membersRecyclerView");
        recyclerView2.setAdapter(getChannelMembersAdapter());
        setupChannelMembers();
    }

    public void onBackPressed() {
        setResult(-1, this.resultIntent);
        super.onBackPressed();
    }

    /* access modifiers changed from: protected */
    public void onActivityResult(int i, int i2, Intent intent) {
        if (i != RC_ADD_CHANNEL_MEMBERS || i2 != -1 || intent == null) {
            super.onActivityResult(i, i2, intent);
        } else if (intent.getBooleanExtra(ChatRouting.EXTRA_CHANNEL_MEMBERS_UPDATED, false)) {
            this.resultIntent.putExtra(ChatRouting.EXTRA_CHANNEL_MEMBERS_UPDATED, true);
            getChannelMembersViewModel().refreshChannelMembers();
        }
    }

    /* access modifiers changed from: protected */
    public void onDestroy() {
        getBinding().membersRecyclerView.clearOnScrollListeners();
        super.onDestroy();
    }

    private final void setupChannelMembers() {
        String stringExtra = getIntent().getStringExtra(ChatRouting.EXTRA_CHANNEL_ID);
        if (stringExtra != null) {
            this.channelId = stringExtra;
            LifecycleOwner lifecycleOwner = this;
            LiveDataCombineTupleKt.combineTuple(getChannelMembersViewModel().currentUser(), getChannelMembersViewModel().channel()).observe(lifecycleOwner, new ChannelMembersActivity$setupChannelMembers$2(this));
            getChannelMembersViewModel().canAddMembers().observe(lifecycleOwner, new ChannelMembersActivity$setupChannelMembers$3(this));
            getChannelMembersViewModel().channelMembers().observe(lifecycleOwner, new ChannelMembersActivity$setupChannelMembers$4(this));
            getChannelMembersViewModel().channelMembersContentVisibilityChanged().observe(lifecycleOwner, new ChannelMembersActivity$setupChannelMembers$5(this));
            getChannelMembersViewModel().loadingNextMembers().observe(lifecycleOwner, new ChannelMembersActivity$setupChannelMembers$6(this));
            getChannelMembersViewModel().channelMemberRemoved().observe(lifecycleOwner, new ChannelMembersActivity$setupChannelMembers$7(this));
            ChannelMembersViewModel channelMembersViewModel = getChannelMembersViewModel();
            String str = this.channelId;
            if (str == null) {
                Intrinsics.throwUninitializedPropertyAccessException("channelId");
            }
            channelMembersViewModel.setChannelId(str);
            getChannelMembersViewModel().fetchChannelMembers();
            ChannelEventsViewModel channelEventsViewModel = getChannelEventsViewModel();
            String str2 = this.channelId;
            if (str2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("channelId");
            }
            channelEventsViewModel.setChannelId(str2);
            getChannelEventsViewModel().addedChannelMemberEvent().observe(lifecycleOwner, new ChannelMembersActivity$setupChannelMembers$8(this));
            getChannelEventsViewModel().removedChannelMemberEvent().observe(lifecycleOwner, new ChannelMembersActivity$setupChannelMembers$9(this));
            getChannelEventsViewModel().removedCurrentUserFromChannelEvent().observe(lifecycleOwner, new ChannelMembersActivity$setupChannelMembers$10(this));
            getChannelEventsViewModel().channelDeletedEvent().observe(lifecycleOwner, new ChannelMembersActivity$setupChannelMembers$11(this));
            return;
        }
        throw new IllegalStateException("Specifying a channel id is required when showing channel-members".toString());
    }

    public void onChannelMemberViewTapped(Member member) {
        Intrinsics.checkNotNullParameter(member, "channelMember");
        Channel value = getChannelMembersViewModel().channel().getValue();
        if (value != null) {
            UserActionsBottomSheet userActionsBottomSheet = new UserActionsBottomSheet();
            FragmentManager supportFragmentManager = getSupportFragmentManager();
            Intrinsics.checkNotNullExpressionValue(supportFragmentManager, "supportFragmentManager");
            userActionsBottomSheet.show(supportFragmentManager, member.getUser(), value);
        }
    }

    public void onRemoveChannelMemberViewTapped(Member member) {
        Intrinsics.checkNotNullParameter(member, "channelMember");
        String string = getString(C4059R.string.chat_remove_channel_member_msg, new Object[]{ContentUtils.getName(member.getUser())});
        Intrinsics.checkNotNullExpressionValue(string, "getString(\n            R…annelMember.user.name\n\t\t)");
        StyledAlertDialog.INSTANCE.getDangerDialogBuilder(this).setTitle(C4059R.string.chat_remove_channel_member_title).setMessage((CharSequence) string).setPositiveButton(C4059R.string.chat_remove_channel_member_positive_action, (DialogInterface.OnClickListener) new ChannelMembersActivity$onRemoveChannelMemberViewTapped$1(this, member)).setNegativeButton(C4059R.string.chat_remove_channel_member_negative_action, (DialogInterface.OnClickListener) null).show();
    }

    public void onContentLayoutErrorResolutionButtonTapped(int i, int i2) {
        ContentLayout contentLayout = getBinding().contentLayout;
        Intrinsics.checkNotNullExpressionValue(contentLayout, "binding.contentLayout");
        if (contentLayout.getId() == i && i2 == 1211) {
            getChannelMembersViewModel().refreshChannelMembers();
            return;
        }
        throw new RuntimeException("Unable to resolve content-layout error resolution: " + i + ' ' + i2);
    }
}
