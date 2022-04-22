package com.memes.chat.p036ui.channel.create.stages.channelinfoinput;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import com.google.android.material.textfield.TextInputEditText;
import com.memes.chat.C4059R;
import com.memes.chat.databinding.ChannelInfoInputFragmentBinding;
import com.memes.chat.p036ui.channel.create.CreateChannelViewModel;
import com.memes.chat.p036ui.custom.ChatUserAvatarView;
import com.memes.commons.fragment.BaseFragment;
import com.memes.commons.imageselection.ImageContent;
import com.memes.commons.imageselection.ImageSelector;
import com.memes.commons.imageselection.choices.ChoicesBasedImageSelectorWithRemovePhotoOption;
import com.memes.commons.media.MediaFile;
import com.memes.commons.util.SoftKeyboardUtil;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0000\u0018\u0000 )2\u00020\u00012\u00020\u00022\u00020\u0003:\u0001)B\u0005¢\u0006\u0002\u0010\u0004J\u0010\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0016H\u0016J\b\u0010\u0017\u001a\u00020\u0014H\u0002J$\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u001b2\b\u0010\u001c\u001a\u0004\u0018\u00010\u001d2\b\u0010\u001e\u001a\u0004\u0018\u00010\u001fH\u0016J\u0018\u0010 \u001a\u00020\u00142\u0006\u0010!\u001a\u00020\"2\u0006\u0010#\u001a\u00020$H\u0016J\b\u0010%\u001a\u00020\u0014H\u0016J\b\u0010&\u001a\u00020\u0014H\u0016J\u001a\u0010'\u001a\u00020\u00142\u0006\u0010(\u001a\u00020\u00192\b\u0010\u001e\u001a\u0004\u0018\u00010\u001fH\u0016R\u0014\u0010\u0005\u001a\u00020\u0006XD¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u000e\u0010\t\u001a\u00020\nX.¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX.¢\u0006\u0002\n\u0000R\u001b\u0010\r\u001a\u00020\u000e8BX\u0002¢\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u000f\u0010\u0010¨\u0006*"}, mo26107d2 = {"Lcom/memes/chat/ui/channel/create/stages/channelinfoinput/ChannelInfoInputFragment;", "Lcom/memes/commons/fragment/BaseFragment;", "Lcom/memes/commons/imageselection/ImageSelector$Callback;", "Lcom/memes/commons/imageselection/choices/ChoicesBasedImageSelectorWithRemovePhotoOption$RemovePhotoOptionSelectedListener;", "()V", "assignedFragmentTag", "", "getAssignedFragmentTag", "()Ljava/lang/String;", "binding", "Lcom/memes/chat/databinding/ChannelInfoInputFragmentBinding;", "channelImageSelectorProvider", "Lcom/memes/chat/ui/channel/create/stages/channelinfoinput/ChannelImageSelectorProvider;", "createChannelViewModel", "Lcom/memes/chat/ui/channel/create/CreateChannelViewModel;", "getCreateChannelViewModel", "()Lcom/memes/chat/ui/channel/create/CreateChannelViewModel;", "createChannelViewModel$delegate", "Lkotlin/Lazy;", "onAttach", "", "context", "Landroid/content/Context;", "onChannelAvatarViewTapped", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onImageFileSelected", "requestIdentifier", "", "imageContent", "Lcom/memes/commons/imageselection/ImageContent;", "onRemovePhotoOptionSelected", "onResume", "onViewCreated", "view", "Companion", "chat_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
/* renamed from: com.memes.chat.ui.channel.create.stages.channelinfoinput.ChannelInfoInputFragment */
/* compiled from: ChannelInfoInputFragment.kt */
public final class ChannelInfoInputFragment extends BaseFragment implements ImageSelector.Callback, ChoicesBasedImageSelectorWithRemovePhotoOption.RemovePhotoOptionSelectedListener {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    public static final int RC_CHOOSE_PHOTO = 5644;
    private final String assignedFragmentTag = "ChannelInfoInputFragment";
    private ChannelInfoInputFragmentBinding binding;
    private ChannelImageSelectorProvider channelImageSelectorProvider;
    private final Lazy createChannelViewModel$delegate = LazyKt.lazy(new ChannelInfoInputFragment$createChannelViewModel$2(this));

    /* access modifiers changed from: private */
    public final CreateChannelViewModel getCreateChannelViewModel() {
        return (CreateChannelViewModel) this.createChannelViewModel$delegate.getValue();
    }

    @Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, mo26107d2 = {"Lcom/memes/chat/ui/channel/create/stages/channelinfoinput/ChannelInfoInputFragment$Companion;", "", "()V", "RC_CHOOSE_PHOTO", "", "chat_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
    /* renamed from: com.memes.chat.ui.channel.create.stages.channelinfoinput.ChannelInfoInputFragment$Companion */
    /* compiled from: ChannelInfoInputFragment.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public String getAssignedFragmentTag() {
        return this.assignedFragmentTag;
    }

    public void onAttach(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        super.onAttach(context);
        this.channelImageSelectorProvider = (ChannelImageSelectorProvider) context;
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        Intrinsics.checkNotNullParameter(layoutInflater, "inflater");
        ChannelInfoInputFragmentBinding inflate = ChannelInfoInputFragmentBinding.inflate(layoutInflater, viewGroup, false);
        Intrinsics.checkNotNullExpressionValue(inflate, "ChannelInfoInputFragment…flater, container, false)");
        this.binding = inflate;
        if (inflate == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        inflate.channelAvatarView.loadDrawable(C4059R.C4062drawable.chat_group_avatar_placeholder_thumb);
        ChannelInfoInputFragmentBinding channelInfoInputFragmentBinding = this.binding;
        if (channelInfoInputFragmentBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        LinearLayout root = channelInfoInputFragmentBinding.getRoot();
        Intrinsics.checkNotNullExpressionValue(root, "binding.root");
        return root;
    }

    public void onViewCreated(View view, Bundle bundle) {
        Intrinsics.checkNotNullParameter(view, ViewHierarchyConstants.VIEW_KEY);
        ChannelInfoInputFragmentBinding channelInfoInputFragmentBinding = this.binding;
        if (channelInfoInputFragmentBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        TextInputEditText textInputEditText = channelInfoInputFragmentBinding.channelNameEditText;
        Intrinsics.checkNotNullExpressionValue(textInputEditText, "binding.channelNameEditText");
        textInputEditText.addTextChangedListener(new C4083x99e98d69(this));
        ChannelInfoInputFragmentBinding channelInfoInputFragmentBinding2 = this.binding;
        if (channelInfoInputFragmentBinding2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        channelInfoInputFragmentBinding2.channelAvatarView.setOnClickListener(new ChannelInfoInputFragment$onViewCreated$2(this));
        ChannelInfoInputFragmentBinding channelInfoInputFragmentBinding3 = this.binding;
        if (channelInfoInputFragmentBinding3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        channelInfoInputFragmentBinding3.changeChannelAvatarAnchorView.setOnClickListener(new ChannelInfoInputFragment$onViewCreated$3(this));
    }

    public void onResume() {
        super.onResume();
        ChannelInfoInputFragmentBinding channelInfoInputFragmentBinding = this.binding;
        if (channelInfoInputFragmentBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        TextInputEditText textInputEditText = channelInfoInputFragmentBinding.channelNameEditText;
        Intrinsics.checkNotNullExpressionValue(textInputEditText, "binding.channelNameEditText");
        CharSequence text = textInputEditText.getText();
        if (text == null || StringsKt.isBlank(text)) {
            SoftKeyboardUtil softKeyboardUtil = SoftKeyboardUtil.INSTANCE;
            ChannelInfoInputFragmentBinding channelInfoInputFragmentBinding2 = this.binding;
            if (channelInfoInputFragmentBinding2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
            }
            TextInputEditText textInputEditText2 = channelInfoInputFragmentBinding2.channelNameEditText;
            Intrinsics.checkNotNullExpressionValue(textInputEditText2, "binding.channelNameEditText");
            softKeyboardUtil.showKeyboard(textInputEditText2);
        }
    }

    /* access modifiers changed from: private */
    public final void onChannelAvatarViewTapped() {
        boolean hasChannelImageInput = getCreateChannelViewModel().hasChannelImageInput();
        ChannelImageSelectorProvider channelImageSelectorProvider2 = this.channelImageSelectorProvider;
        if (channelImageSelectorProvider2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("channelImageSelectorProvider");
        }
        channelImageSelectorProvider2.getChannelImageSelector().setHasImageInput(hasChannelImageInput).setRemovePhotoOptionSelectedListener(this).requestIdentifier(5644).enableCrop(ImageSelector.Companion.getCROP_SQUARE()).callback(this).start();
    }

    public void onImageFileSelected(int i, ImageContent imageContent) {
        Intrinsics.checkNotNullParameter(imageContent, "imageContent");
        if (i == 5644) {
            MediaFile file = imageContent.getFile();
            ChannelInfoInputFragmentBinding channelInfoInputFragmentBinding = this.binding;
            if (channelInfoInputFragmentBinding == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
            }
            ChatUserAvatarView.loadUrl$default(channelInfoInputFragmentBinding.channelAvatarView, file.getAbsolutePath(), 0, 2, (Object) null);
            getCreateChannelViewModel().channelImageInputChanged(file.getAbsolutePath());
        }
    }

    public void onRemovePhotoOptionSelected() {
        getCreateChannelViewModel().channelImageInputChanged("");
        ChannelInfoInputFragmentBinding channelInfoInputFragmentBinding = this.binding;
        if (channelInfoInputFragmentBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        channelInfoInputFragmentBinding.channelAvatarView.loadDrawable(C4059R.C4062drawable.chat_group_avatar_placeholder_thumb);
    }
}
