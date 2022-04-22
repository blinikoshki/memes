package com.getstream.sdk.chat.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.facebook.share.internal.ShareConstants;
import com.getstream.sdk.chat.databinding.StreamReplyToViewBinding;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import p015io.getstream.chat.android.client.models.ContentUtils;
import p015io.getstream.chat.android.client.models.Message;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0000\u0018\u00002\u00020\u0001:\u0001\u0017B%\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u0016\u0010\u0012\u001a\u00020\r2\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0016R\u000e\u0010\t\u001a\u00020\nX\u0004¢\u0006\u0002\n\u0000R \u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\r0\fX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011¨\u0006\u0018"}, mo26107d2 = {"Lcom/getstream/sdk/chat/view/PreviewMessageView;", "Landroid/widget/RelativeLayout;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "binding", "Lcom/getstream/sdk/chat/databinding/StreamReplyToViewBinding;", "onCloseClick", "Lkotlin/Function0;", "", "getOnCloseClick", "()Lkotlin/jvm/functions/Function0;", "setOnCloseClick", "(Lkotlin/jvm/functions/Function0;)V", "setMessage", "message", "Lio/getstream/chat/android/client/models/Message;", "mode", "Lcom/getstream/sdk/chat/view/PreviewMessageView$Mode;", "Mode", "stream-chat-android_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
/* compiled from: PreviewMessageView.kt */
public final class PreviewMessageView extends RelativeLayout {
    private final StreamReplyToViewBinding binding;
    private Function0<Unit> onCloseClick;

    @Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0004\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004¨\u0006\u0005"}, mo26107d2 = {"Lcom/getstream/sdk/chat/view/PreviewMessageView$Mode;", "", "(Ljava/lang/String;I)V", "EDIT", "REPLY_TO", "stream-chat-android_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
    /* compiled from: PreviewMessageView.kt */
    public enum Mode {
        EDIT,
        REPLY_TO
    }

    public PreviewMessageView(Context context) {
        this(context, (AttributeSet) null, 0, 6, (DefaultConstructorMarker) null);
    }

    public PreviewMessageView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, (DefaultConstructorMarker) null);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ PreviewMessageView(Context context, AttributeSet attributeSet, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i2 & 2) != 0 ? null : attributeSet, (i2 & 4) != 0 ? 0 : i);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public PreviewMessageView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Intrinsics.checkNotNullParameter(context, "context");
        StreamReplyToViewBinding inflate = StreamReplyToViewBinding.inflate(LayoutInflater.from(context), this, true);
        Intrinsics.checkNotNullExpressionValue(inflate, "StreamReplyToViewBinding…rom(context), this, true)");
        inflate.ivClose.setOnClickListener(new PreviewMessageView$$special$$inlined$apply$lambda$1(this));
        Unit unit = Unit.INSTANCE;
        this.binding = inflate;
        this.onCloseClick = PreviewMessageView$onCloseClick$1.INSTANCE;
    }

    public final Function0<Unit> getOnCloseClick() {
        return this.onCloseClick;
    }

    public final void setOnCloseClick(Function0<Unit> function0) {
        Intrinsics.checkNotNullParameter(function0, "<set-?>");
        this.onCloseClick = function0;
    }

    public final void setMessage(Message message, Mode mode) {
        Intrinsics.checkNotNullParameter(message, ShareConstants.WEB_DIALOG_PARAM_MESSAGE);
        Intrinsics.checkNotNullParameter(mode, "mode");
        TextView textView = this.binding.tvMessage;
        Intrinsics.checkNotNullExpressionValue(textView, "binding.tvMessage");
        textView.setText(message.getText());
        TextView textView2 = this.binding.tvUserName;
        Intrinsics.checkNotNullExpressionValue(textView2, "binding.tvUserName");
        textView2.setText(ContentUtils.getName(message.getUser()));
        this.binding.ivMode.setImageResource(PreviewMessageViewKt.getDrawable(mode));
    }
}
