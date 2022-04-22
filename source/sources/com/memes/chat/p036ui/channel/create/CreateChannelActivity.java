package com.memes.chat.p036ui.channel.create;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import androidx.lifecycle.LifecycleOwner;
import androidx.viewpager2.widget.ViewPager2;
import com.memes.chat.C4059R;
import com.memes.chat.databinding.CreateChannelActivityBinding;
import com.memes.chat.p036ui.channel.create.stages.CreateChannelStage;
import com.memes.chat.p036ui.channel.create.stages.CreateChannelStagesAdapter;
import com.memes.chat.p036ui.channel.create.stages.channelinfoinput.ChannelImageSelectorProvider;
import com.memes.chat.p036ui.channel.create.stages.memberselection.OnChannelMembersSelectionChangedListener;
import com.memes.chat.routing.ChatRouting;
import com.memes.commons.activity.BaseActivity;
import com.memes.commons.imageselection.choices.ChoicesBasedImageSelectorWithRemovePhotoOption;
import com.memes.commons.provider.SimpleFileProvider;
import com.memes.commons.util.SoftKeyboardUtil;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import p015io.getstream.chat.android.client.models.Channel;
import p015io.getstream.chat.android.client.models.User;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0000\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003B\u0005¢\u0006\u0002\u0010\u0004J\b\u0010\u0012\u001a\u00020\u0011H\u0016J\b\u0010\u0013\u001a\u00020\u0014H\u0002J\b\u0010\u0015\u001a\u00020\u0014H\u0016J\u001a\u0010\u0016\u001a\u00020\u00142\u0010\u0010\u0017\u001a\f\u0012\b\u0012\u00060\u0019j\u0002`\u001a0\u0018H\u0016J\u0012\u0010\u001b\u001a\u00020\u00142\b\u0010\u001c\u001a\u0004\u0018\u00010\u001dH\u0014J\b\u0010\u001e\u001a\u00020\u0014H\u0014J\u0010\u0010\u001f\u001a\u00020\u00142\u0006\u0010 \u001a\u00020!H\u0002J\u0010\u0010\"\u001a\u00020\u00142\u0006\u0010#\u001a\u00020$H\u0002J\u0010\u0010%\u001a\u00020\u00142\u0006\u0010 \u001a\u00020!H\u0002R\u001b\u0010\u0005\u001a\u00020\u00068BX\u0002¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u0007\u0010\bR\u001b\u0010\u000b\u001a\u00020\f8BX\u0002¢\u0006\f\n\u0004\b\u000f\u0010\n\u001a\u0004\b\r\u0010\u000eR\u000e\u0010\u0010\u001a\u00020\u0011X\u0004¢\u0006\u0002\n\u0000¨\u0006&"}, mo26107d2 = {"Lcom/memes/chat/ui/channel/create/CreateChannelActivity;", "Lcom/memes/commons/activity/BaseActivity;", "Lcom/memes/chat/ui/channel/create/stages/memberselection/OnChannelMembersSelectionChangedListener;", "Lcom/memes/chat/ui/channel/create/stages/channelinfoinput/ChannelImageSelectorProvider;", "()V", "binding", "Lcom/memes/chat/databinding/CreateChannelActivityBinding;", "getBinding", "()Lcom/memes/chat/databinding/CreateChannelActivityBinding;", "binding$delegate", "Lkotlin/Lazy;", "createChannelViewModel", "Lcom/memes/chat/ui/channel/create/CreateChannelViewModel;", "getCreateChannelViewModel", "()Lcom/memes/chat/ui/channel/create/CreateChannelViewModel;", "createChannelViewModel$delegate", "imageSelector", "Lcom/memes/commons/imageselection/choices/ChoicesBasedImageSelectorWithRemovePhotoOption;", "getChannelImageSelector", "initViewPager", "", "onBackPressed", "onChannelMembersSelectionChanged", "channelMembers", "", "Lio/getstream/chat/android/client/models/User;", "Lcom/memes/chat/ui/channel/create/stages/memberselection/ChannelMember;", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onPause", "refreshActionButtonText", "stage", "Lcom/memes/chat/ui/channel/create/stages/CreateChannelStage;", "showChannel", "channel", "Lio/getstream/chat/android/client/models/Channel;", "showStage", "chat_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
/* renamed from: com.memes.chat.ui.channel.create.CreateChannelActivity */
/* compiled from: CreateChannelActivity.kt */
public final class CreateChannelActivity extends BaseActivity implements OnChannelMembersSelectionChangedListener, ChannelImageSelectorProvider {
    private final Lazy binding$delegate = LazyKt.lazy(new CreateChannelActivity$binding$2(this));
    private final Lazy createChannelViewModel$delegate = LazyKt.lazy(new CreateChannelActivity$createChannelViewModel$2(this));
    private final ChoicesBasedImageSelectorWithRemovePhotoOption imageSelector = new ChoicesBasedImageSelectorWithRemovePhotoOption(this, SimpleFileProvider.NAME);

    @Metadata(mo26105bv = {1, 0, 3}, mo26108k = 3, mo26109mv = {1, 4, 2})
    /* renamed from: com.memes.chat.ui.channel.create.CreateChannelActivity$WhenMappings */
    public final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[CreateChannelStage.values().length];
            $EnumSwitchMapping$0 = iArr;
            iArr[CreateChannelStage.CHOOSE_MEMBERS.ordinal()] = 1;
            iArr[CreateChannelStage.CHANNEL_INFO_INPUT.ordinal()] = 2;
        }
    }

    private final CreateChannelActivityBinding getBinding() {
        return (CreateChannelActivityBinding) this.binding$delegate.getValue();
    }

    /* access modifiers changed from: private */
    public final CreateChannelViewModel getCreateChannelViewModel() {
        return (CreateChannelViewModel) this.createChannelViewModel$delegate.getValue();
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        CreateChannelActivityBinding binding = getBinding();
        Intrinsics.checkNotNullExpressionValue(binding, "binding");
        setContentView((View) binding.getRoot());
        registerViewModels(getCreateChannelViewModel());
        getBinding().backImageView.setOnClickListener(new CreateChannelActivity$onCreate$1(this));
        getBinding().actionTextView.setOnClickListener(new CreateChannelActivity$onCreate$2(this));
        initViewPager();
        LifecycleOwner lifecycleOwner = this;
        getCreateChannelViewModel().channelCreationStage().observe(lifecycleOwner, new CreateChannelActivity$onCreate$3(this));
        getCreateChannelViewModel().channelCreated().observe(lifecycleOwner, new CreateChannelActivity$onCreate$4(this));
    }

    /* access modifiers changed from: protected */
    public void onPause() {
        super.onPause();
        SoftKeyboardUtil.INSTANCE.hideKeyboard((Activity) this);
    }

    public void onBackPressed() {
        SoftKeyboardUtil.INSTANCE.hideKeyboard((Activity) this);
        if (!getCreateChannelViewModel().handleOnBackPressed()) {
            super.onBackPressed();
        }
    }

    private final void initViewPager() {
        CreateChannelStagesAdapter createChannelStagesAdapter = new CreateChannelStagesAdapter(this);
        ViewPager2 viewPager2 = getBinding().viewPager;
        Intrinsics.checkNotNullExpressionValue(viewPager2, "binding.viewPager");
        viewPager2.setAdapter(createChannelStagesAdapter);
        ViewPager2 viewPager22 = getBinding().viewPager;
        Intrinsics.checkNotNullExpressionValue(viewPager22, "binding.viewPager");
        viewPager22.setUserInputEnabled(false);
    }

    /* access modifiers changed from: private */
    public final void showChannel(Channel channel) {
        startActivity(ChatRouting.INSTANCE.getChannelIntent(this, channel));
        finish();
    }

    /* access modifiers changed from: private */
    public final void showStage(CreateChannelStage createChannelStage) {
        ViewPager2 viewPager2 = getBinding().viewPager;
        Intrinsics.checkNotNullExpressionValue(viewPager2, "binding.viewPager");
        viewPager2.setCurrentItem(createChannelStage.getPosition());
        refreshActionButtonText(createChannelStage);
    }

    private final void refreshActionButtonText(CreateChannelStage createChannelStage) {
        int selectedMemberCount = getCreateChannelViewModel().getSelectedMemberCount();
        int i = WhenMappings.$EnumSwitchMapping$0[createChannelStage.ordinal()];
        if (i != 1) {
            if (i == 2) {
                if (selectedMemberCount == 0 || selectedMemberCount == 1) {
                    throw new IllegalStateException("selectedMemberCount<=1, but " + createChannelStage + " requires at least 2 members");
                }
                getBinding().actionTextView.setText(C4059R.string.chat_create_channel_action);
                TextView textView = getBinding().actionTextView;
                Intrinsics.checkNotNullExpressionValue(textView, "binding.actionTextView");
                textView.setSelected(true);
            }
        } else if (selectedMemberCount == 0) {
            getBinding().actionTextView.setText(C4059R.string.chat_create_channel_action);
            TextView textView2 = getBinding().actionTextView;
            Intrinsics.checkNotNullExpressionValue(textView2, "binding.actionTextView");
            textView2.setSelected(false);
        } else if (selectedMemberCount != 1) {
            getBinding().actionTextView.setText(C4059R.string.chat_next);
            TextView textView3 = getBinding().actionTextView;
            Intrinsics.checkNotNullExpressionValue(textView3, "binding.actionTextView");
            textView3.setSelected(true);
        } else {
            getBinding().actionTextView.setText(C4059R.string.chat_create_channel_action);
            TextView textView4 = getBinding().actionTextView;
            Intrinsics.checkNotNullExpressionValue(textView4, "binding.actionTextView");
            textView4.setSelected(true);
        }
    }

    public void onChannelMembersSelectionChanged(List<User> list) {
        Intrinsics.checkNotNullParameter(list, "channelMembers");
        getCreateChannelViewModel().channelMembersChanged(list);
        refreshActionButtonText(CreateChannelStage.CHOOSE_MEMBERS);
    }

    public ChoicesBasedImageSelectorWithRemovePhotoOption getChannelImageSelector() {
        return this.imageSelector;
    }
}
