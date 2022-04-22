package com.getstream.sdk.chat.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.getstream.sdk.chat.C1673R;
import com.getstream.sdk.chat.databinding.StreamViewChannelHeaderBinding;
import com.getstream.sdk.chat.style.TextStyle;
import com.getstream.sdk.chat.utils.extensions.MemberUtils;
import com.getstream.sdk.chat.view.MessageListView;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import p015io.getstream.chat.android.client.models.Channel;
import p015io.getstream.chat.android.client.models.Member;
import p015io.getstream.chat.android.client.models.ModelFields;
import p015io.getstream.chat.android.client.models.User;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000j\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B%\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\b\u0010\u001a\u001a\u00020\u0013H\u0002J\u0014\u0010\u001b\u001a\u00020\u00132\f\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u001e0\u001dJ\u0010\u0010\u001f\u001a\u00020\n2\u0006\u0010\u0002\u001a\u00020\u0003H\u0002J\u000e\u0010 \u001a\u00020\u00132\u0006\u0010!\u001a\u00020\"J\u000e\u0010#\u001a\u00020\u00132\u0006\u0010$\u001a\u00020%J\u0010\u0010&\u001a\u00020\u00132\b\u0010'\u001a\u0004\u0018\u00010(J\u000e\u0010)\u001a\u00020\u00132\u0006\u0010$\u001a\u00020*J\u0010\u0010+\u001a\u00020\u00132\b\u0010,\u001a\u0004\u0018\u00010(R\u000e\u0010\t\u001a\u00020\nX\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\u000b\u001a\u0004\u0018\u00010\fX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R \u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00130\u0012X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\u000e\u0010\u0018\u001a\u00020\u0019X\u0004¢\u0006\u0002\n\u0000¨\u0006-"}, mo26107d2 = {"Lcom/getstream/sdk/chat/view/ChannelHeaderView;", "Landroid/widget/RelativeLayout;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "binding", "Lcom/getstream/sdk/chat/databinding/StreamViewChannelHeaderBinding;", "currentChannel", "Lio/getstream/chat/android/client/models/Channel;", "getCurrentChannel", "()Lio/getstream/chat/android/client/models/Channel;", "setCurrentChannel", "(Lio/getstream/chat/android/client/models/Channel;)V", "onBackClick", "Lkotlin/Function0;", "", "getOnBackClick", "()Lkotlin/jvm/functions/Function0;", "setOnBackClick", "(Lkotlin/jvm/functions/Function0;)V", "style", "Lcom/getstream/sdk/chat/view/ChannelHeaderViewStyle;", "applyStyle", "configHeaderAvatar", "members", "", "Lio/getstream/chat/android/client/models/Member;", "initBinding", "setActiveBadge", "isActive", "", "setHeaderAvatarGroupClickListener", "headerOptionsClickListener", "Lcom/getstream/sdk/chat/view/MessageListView$HeaderAvatarGroupClickListener;", "setHeaderLastActive", "lastActive", "", "setHeaderOptionsClickListener", "Lcom/getstream/sdk/chat/view/MessageListView$HeaderOptionsClickListener;", "setHeaderTitle", "title", "stream-chat-android_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
/* compiled from: ChannelHeaderView.kt */
public final class ChannelHeaderView extends RelativeLayout {
    private final StreamViewChannelHeaderBinding binding;
    private Channel currentChannel;
    private Function0<Unit> onBackClick;
    private final ChannelHeaderViewStyle style;

    public ChannelHeaderView(Context context) {
        this(context, (AttributeSet) null, 0, 6, (DefaultConstructorMarker) null);
    }

    public ChannelHeaderView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, (DefaultConstructorMarker) null);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ ChannelHeaderView(Context context, AttributeSet attributeSet, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i2 & 2) != 0 ? null : attributeSet, (i2 & 4) != 0 ? 0 : i);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ChannelHeaderView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Intrinsics.checkNotNullParameter(context, "context");
        this.onBackClick = ChannelHeaderView$onBackClick$1.INSTANCE;
        this.binding = initBinding(context);
        this.style = new ChannelHeaderViewStyle(context, attributeSet);
        applyStyle();
    }

    public final Function0<Unit> getOnBackClick() {
        return this.onBackClick;
    }

    public final void setOnBackClick(Function0<Unit> function0) {
        Intrinsics.checkNotNullParameter(function0, "<set-?>");
        this.onBackClick = function0;
    }

    public final Channel getCurrentChannel() {
        return this.currentChannel;
    }

    public final void setCurrentChannel(Channel channel) {
        this.currentChannel = channel;
    }

    public final void setHeaderTitle(String str) {
        TextView textView = this.binding.tvChannelName;
        Intrinsics.checkNotNullExpressionValue(textView, "binding.tvChannelName");
        textView.setText(str);
    }

    public final void setHeaderLastActive(String str) {
        TextView textView = this.binding.tvActive;
        Intrinsics.checkNotNullExpressionValue(textView, "binding.tvActive");
        textView.setText(str);
    }

    public final void setActiveBadge(boolean z) {
        if (z) {
            this.binding.ivActiveBadge.setImageResource(C1673R.C1676drawable.stream_circle_user_online);
        } else {
            this.binding.ivActiveBadge.setImageResource(C1673R.C1676drawable.stream_circle_user_offline);
        }
    }

    public final void configHeaderAvatar(List<Member> list) {
        Intrinsics.checkNotNullParameter(list, ModelFields.MEMBERS);
        this.binding.avatarGroup.setLastActiveUsers(MemberUtils.getOtherUsers$default(list, (User) null, 1, (Object) null), this.style.getAvatarStyle());
    }

    private final StreamViewChannelHeaderBinding initBinding(Context context) {
        StreamViewChannelHeaderBinding inflate = StreamViewChannelHeaderBinding.inflate(LayoutInflater.from(context), this, true);
        Intrinsics.checkNotNullExpressionValue(inflate, "StreamViewChannelHeaderB…rom(context), this, true)");
        inflate.btnBack.setOnClickListener(new ChannelHeaderView$initBinding$$inlined$apply$lambda$1(this));
        return inflate;
    }

    public final void setHeaderOptionsClickListener(MessageListView.HeaderOptionsClickListener headerOptionsClickListener) {
        Intrinsics.checkNotNullParameter(headerOptionsClickListener, "headerOptionsClickListener");
        this.binding.btnOption.setOnClickListener(new ChannelHeaderView$setHeaderOptionsClickListener$1(this, headerOptionsClickListener));
    }

    public final void setHeaderAvatarGroupClickListener(MessageListView.HeaderAvatarGroupClickListener headerAvatarGroupClickListener) {
        Intrinsics.checkNotNullParameter(headerAvatarGroupClickListener, "headerOptionsClickListener");
        this.binding.avatarGroup.setOnClickListener(new ChannelHeaderView$setHeaderAvatarGroupClickListener$1(this, headerAvatarGroupClickListener));
    }

    private final void applyStyle() {
        TextStyle channelTitleText = this.style.getChannelTitleText();
        TextView textView = this.binding.tvChannelName;
        Intrinsics.checkNotNullExpressionValue(textView, "binding.tvChannelName");
        channelTitleText.apply(textView);
        TextStyle lastActiveText = this.style.getLastActiveText();
        TextView textView2 = this.binding.tvActive;
        Intrinsics.checkNotNullExpressionValue(textView2, "binding.tvActive");
        lastActiveText.apply(textView2);
        TextView textView3 = this.binding.tvActive;
        Intrinsics.checkNotNullExpressionValue(textView3, "binding.tvActive");
        int i = 0;
        textView3.setVisibility(this.style.isLastActiveShow() ? 0 : 8);
        Button button = this.binding.btnBack;
        Intrinsics.checkNotNullExpressionValue(button, "binding.btnBack");
        button.setVisibility(this.style.isBackButtonShow() ? 0 : 8);
        Button button2 = this.binding.btnBack;
        Intrinsics.checkNotNullExpressionValue(button2, "binding.btnBack");
        button2.setBackground(this.style.getBackButtonBackground());
        AvatarView avatarView = this.binding.avatarGroup;
        Intrinsics.checkNotNullExpressionValue(avatarView, "binding.avatarGroup");
        avatarView.setVisibility(this.style.isAvatarGroupShow() ? 0 : 8);
        Button button3 = this.binding.btnOption;
        Intrinsics.checkNotNullExpressionValue(button3, "binding.btnOption");
        button3.setVisibility(this.style.isOptionsButtonShow() ? 0 : 8);
        Button button4 = this.binding.btnOption;
        Intrinsics.checkNotNullExpressionValue(button4, "binding.btnOption");
        button4.setBackground(this.style.getOptionsButtonBackground());
        Button button5 = this.binding.btnOption;
        Intrinsics.checkNotNullExpressionValue(button5, "binding.btnOption");
        button5.setTextSize((float) this.style.getOptionsButtonTextSize());
        Button button6 = this.binding.btnOption;
        Intrinsics.checkNotNullExpressionValue(button6, "binding.btnOption");
        button6.setWidth(this.style.getOptionsButtonWidth());
        Button button7 = this.binding.btnOption;
        Intrinsics.checkNotNullExpressionValue(button7, "binding.btnOption");
        button7.setHeight(this.style.getOptionsButtonHeight());
        if (!this.style.isAvatarGroupShow()) {
            ImageView imageView = this.binding.ivActiveBadge;
            Intrinsics.checkNotNullExpressionValue(imageView, "binding.ivActiveBadge");
            imageView.setVisibility(8);
            return;
        }
        ImageView imageView2 = this.binding.ivActiveBadge;
        Intrinsics.checkNotNullExpressionValue(imageView2, "binding.ivActiveBadge");
        if (!this.style.isActiveBadgeShow()) {
            i = 8;
        }
        imageView2.setVisibility(i);
    }
}
