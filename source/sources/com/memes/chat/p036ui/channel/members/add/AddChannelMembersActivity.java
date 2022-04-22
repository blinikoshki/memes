package com.memes.chat.p036ui.channel.members.add;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import com.memes.chat.C4059R;
import com.memes.chat.databinding.AddChannelMembersActivityBinding;
import com.memes.chat.p036ui.channel.create.stages.memberselection.OnChannelMembersSelectionChangedListener;
import com.memes.chat.routing.ChatRouting;
import com.memes.commons.activity.BaseActivity;
import com.memes.commons.util.SoftKeyboardUtil;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import p015io.getstream.chat.android.client.models.User;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0000\u0018\u00002\u00020\u00012\u00020\u0002B\u0005¢\u0006\u0002\u0010\u0003J\b\u0010\u000f\u001a\u00020\u0010H\u0002J\b\u0010\u0011\u001a\u00020\u0010H\u0016J\u001a\u0010\u0012\u001a\u00020\u00102\u0010\u0010\u0013\u001a\f\u0012\b\u0012\u00060\u0015j\u0002`\u00160\u0014H\u0016J\u0012\u0010\u0017\u001a\u00020\u00102\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019H\u0014J\b\u0010\u001a\u001a\u00020\u0010H\u0014R\u001b\u0010\u0004\u001a\u00020\u00058BX\u0002¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\u0006\u0010\u0007R\u001b\u0010\n\u001a\u00020\u000b8BX\u0002¢\u0006\f\n\u0004\b\u000e\u0010\t\u001a\u0004\b\f\u0010\r¨\u0006\u001b"}, mo26107d2 = {"Lcom/memes/chat/ui/channel/members/add/AddChannelMembersActivity;", "Lcom/memes/commons/activity/BaseActivity;", "Lcom/memes/chat/ui/channel/create/stages/memberselection/OnChannelMembersSelectionChangedListener;", "()V", "addChannelMembersViewModel", "Lcom/memes/chat/ui/channel/members/add/AddChannelMembersViewModel;", "getAddChannelMembersViewModel", "()Lcom/memes/chat/ui/channel/members/add/AddChannelMembersViewModel;", "addChannelMembersViewModel$delegate", "Lkotlin/Lazy;", "binding", "Lcom/memes/chat/databinding/AddChannelMembersActivityBinding;", "getBinding", "()Lcom/memes/chat/databinding/AddChannelMembersActivityBinding;", "binding$delegate", "ensureChannelId", "", "onBackPressed", "onChannelMembersSelectionChanged", "channelMembers", "", "Lio/getstream/chat/android/client/models/User;", "Lcom/memes/chat/ui/channel/create/stages/memberselection/ChannelMember;", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onPause", "chat_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
/* renamed from: com.memes.chat.ui.channel.members.add.AddChannelMembersActivity */
/* compiled from: AddChannelMembersActivity.kt */
public final class AddChannelMembersActivity extends BaseActivity implements OnChannelMembersSelectionChangedListener {
    private final Lazy addChannelMembersViewModel$delegate = LazyKt.lazy(new AddChannelMembersActivity$addChannelMembersViewModel$2(this));
    private final Lazy binding$delegate = LazyKt.lazy(new AddChannelMembersActivity$binding$2(this));

    /* access modifiers changed from: private */
    public final AddChannelMembersViewModel getAddChannelMembersViewModel() {
        return (AddChannelMembersViewModel) this.addChannelMembersViewModel$delegate.getValue();
    }

    private final AddChannelMembersActivityBinding getBinding() {
        return (AddChannelMembersActivityBinding) this.binding$delegate.getValue();
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        AddChannelMembersActivityBinding binding = getBinding();
        Intrinsics.checkNotNullExpressionValue(binding, "binding");
        setContentView((View) binding.getRoot());
        registerViewModels(getAddChannelMembersViewModel());
        getBinding().backImageView.setOnClickListener(new AddChannelMembersActivity$onCreate$1(this));
        getBinding().actionImageView.setOnClickListener(new AddChannelMembersActivity$onCreate$2(this));
        getAddChannelMembersViewModel().channelMembersAdded().observe(this, new AddChannelMembersActivity$onCreate$3(this));
        ensureChannelId();
    }

    private final void ensureChannelId() {
        String stringExtra = getIntent().getStringExtra(ChatRouting.EXTRA_CHANNEL_ID);
        if (stringExtra != null) {
            getAddChannelMembersViewModel().channelIdChanged(stringExtra);
            return;
        }
        throw new IllegalStateException("Specifying a channel id is required when adding members".toString());
    }

    /* access modifiers changed from: protected */
    public void onPause() {
        super.onPause();
        SoftKeyboardUtil.INSTANCE.hideKeyboard((Activity) this);
    }

    public void onBackPressed() {
        SoftKeyboardUtil.INSTANCE.hideKeyboard((Activity) this);
        super.onBackPressed();
    }

    public void onChannelMembersSelectionChanged(List<User> list) {
        Intrinsics.checkNotNullParameter(list, "channelMembers");
        getAddChannelMembersViewModel().channelMembersChanged(list);
        if (list.size() != 0) {
            getBinding().actionImageView.setText(C4059R.string.chat_done);
            TextView textView = getBinding().actionImageView;
            Intrinsics.checkNotNullExpressionValue(textView, "binding.actionImageView");
            textView.setSelected(true);
            return;
        }
        getBinding().actionImageView.setText(C4059R.string.chat_done);
        TextView textView2 = getBinding().actionImageView;
        Intrinsics.checkNotNullExpressionValue(textView2, "binding.actionImageView");
        textView2.setSelected(false);
    }
}
