package com.getstream.sdk.chat.adapter.viewholder.attachment;

import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.ContextCompat;
import com.facebook.share.internal.MessengerShareContentUtility;
import com.getstream.sdk.chat.C1673R;
import com.getstream.sdk.chat.adapter.AttachmentListItem;
import com.getstream.sdk.chat.adapter.MessageListItem;
import com.getstream.sdk.chat.databinding.StreamItemAttachMediaBinding;
import com.getstream.sdk.chat.images.StreamImageLoader;
import com.getstream.sdk.chat.images.ViewExtensionsKt;
import com.getstream.sdk.chat.model.ModelType;
import com.getstream.sdk.chat.style.TextStyle;
import com.getstream.sdk.chat.utils.Utils;
import com.getstream.sdk.chat.utils.roundedImageView.PorterShapeImageView;
import com.getstream.sdk.chat.view.MessageListView;
import com.getstream.sdk.chat.view.MessageListViewStyle;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import p015io.getstream.chat.android.client.models.Attachment;
import p015io.getstream.chat.android.client.models.Message;
import top.defaults.drawabletoolbox.DrawableBuilder;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\b\u0000\u0018\u00002\u00020\u0001BW\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\u0006\u0010\f\u001a\u00020\r\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u000f\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u0011\u0012\b\b\u0002\u0010\u0012\u001a\u00020\u0013¢\u0006\u0002\u0010\u0014J\b\u0010\u0017\u001a\u00020\u0018H\u0002J\u0010\u0010\u0019\u001a\u00020\u00182\u0006\u0010\u001a\u001a\u00020\u001bH\u0016J\b\u0010\u001c\u001a\u00020\u0018H\u0002J\b\u0010\u001d\u001a\u00020\u0018H\u0002J\b\u0010\u001e\u001a\u00020\u0018H\u0002J\b\u0010\u001f\u001a\u00020\u0018H\u0002J\b\u0010 \u001a\u00020\u0018H\u0002J\u0010\u0010!\u001a\u00020\u00182\u0006\u0010\"\u001a\u00020#H\u0002R\u000e\u0010\u0015\u001a\u00020\u0016X.¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000¨\u0006$"}, mo26107d2 = {"Lcom/getstream/sdk/chat/adapter/viewholder/attachment/AttachmentViewHolderMedia;", "Lcom/getstream/sdk/chat/adapter/viewholder/attachment/BaseAttachmentViewHolder;", "parent", "Landroid/view/ViewGroup;", "style", "Lcom/getstream/sdk/chat/view/MessageListViewStyle;", "bubbleHelper", "Lcom/getstream/sdk/chat/view/MessageListView$BubbleHelper;", "messageItem", "Lcom/getstream/sdk/chat/adapter/MessageListItem$MessageItem;", "giphySendListener", "Lcom/getstream/sdk/chat/view/MessageListView$GiphySendListener;", "clickListener", "Lcom/getstream/sdk/chat/view/MessageListView$AttachmentClickListener;", "longClickListener", "Lcom/getstream/sdk/chat/view/MessageListView$MessageLongClickListener;", "longClickListenerView", "Lcom/getstream/sdk/chat/view/MessageListView$MessageLongClickListenerView;", "binding", "Lcom/getstream/sdk/chat/databinding/StreamItemAttachMediaBinding;", "(Landroid/view/ViewGroup;Lcom/getstream/sdk/chat/view/MessageListViewStyle;Lcom/getstream/sdk/chat/view/MessageListView$BubbleHelper;Lcom/getstream/sdk/chat/adapter/MessageListItem$MessageItem;Lcom/getstream/sdk/chat/view/MessageListView$GiphySendListener;Lcom/getstream/sdk/chat/view/MessageListView$AttachmentClickListener;Lcom/getstream/sdk/chat/view/MessageListView$MessageLongClickListener;Lcom/getstream/sdk/chat/view/MessageListView$MessageLongClickListenerView;Lcom/getstream/sdk/chat/databinding/StreamItemAttachMediaBinding;)V", "attachment", "Lio/getstream/chat/android/client/models/Attachment;", "applyStyle", "", "bind", "attachmentListItem", "Lcom/getstream/sdk/chat/adapter/AttachmentListItem;", "configActions", "configClickListeners", "configGiphyAction", "configImageThumbBackground", "configMediaAttach", "enableSendGiphyButtons", "isEnable", "", "stream-chat-android_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
/* compiled from: AttachmentViewHolderMedia.kt */
public final class AttachmentViewHolderMedia extends BaseAttachmentViewHolder {
    /* access modifiers changed from: private */
    public Attachment attachment;
    /* access modifiers changed from: private */
    public final StreamItemAttachMediaBinding binding;
    private final MessageListView.BubbleHelper bubbleHelper;
    /* access modifiers changed from: private */
    public final MessageListView.AttachmentClickListener clickListener;
    /* access modifiers changed from: private */
    public final MessageListView.GiphySendListener giphySendListener;
    /* access modifiers changed from: private */
    public final MessageListView.MessageLongClickListener longClickListener;
    /* access modifiers changed from: private */
    public final MessageListView.MessageLongClickListenerView longClickListenerView;
    /* access modifiers changed from: private */
    public final MessageListItem.MessageItem messageItem;
    private final MessageListViewStyle style;

    public static final /* synthetic */ Attachment access$getAttachment$p(AttachmentViewHolderMedia attachmentViewHolderMedia) {
        Attachment attachment2 = attachmentViewHolderMedia.attachment;
        if (attachment2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException(MessengerShareContentUtility.ATTACHMENT);
        }
        return attachment2;
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ AttachmentViewHolderMedia(android.view.ViewGroup r14, com.getstream.sdk.chat.view.MessageListViewStyle r15, com.getstream.sdk.chat.view.MessageListView.BubbleHelper r16, com.getstream.sdk.chat.adapter.MessageListItem.MessageItem r17, com.getstream.sdk.chat.view.MessageListView.GiphySendListener r18, com.getstream.sdk.chat.view.MessageListView.AttachmentClickListener r19, com.getstream.sdk.chat.view.MessageListView.MessageLongClickListener r20, com.getstream.sdk.chat.view.MessageListView.MessageLongClickListenerView r21, com.getstream.sdk.chat.databinding.StreamItemAttachMediaBinding r22, int r23, kotlin.jvm.internal.DefaultConstructorMarker r24) {
        /*
            r13 = this;
            r0 = r23
            r1 = r0 & 64
            r2 = 0
            if (r1 == 0) goto L_0x000c
            r1 = r2
            com.getstream.sdk.chat.view.MessageListView$MessageLongClickListener r1 = (com.getstream.sdk.chat.view.MessageListView.MessageLongClickListener) r1
            r10 = r1
            goto L_0x000e
        L_0x000c:
            r10 = r20
        L_0x000e:
            r1 = r0 & 128(0x80, float:1.794E-43)
            if (r1 == 0) goto L_0x0017
            r1 = r2
            com.getstream.sdk.chat.view.MessageListView$MessageLongClickListenerView r1 = (com.getstream.sdk.chat.view.MessageListView.MessageLongClickListenerView) r1
            r11 = r1
            goto L_0x0019
        L_0x0017:
            r11 = r21
        L_0x0019:
            r0 = r0 & 256(0x100, float:3.59E-43)
            if (r0 == 0) goto L_0x0037
            android.content.Context r0 = r14.getContext()
            android.view.LayoutInflater r0 = android.view.LayoutInflater.from(r0)
            java.lang.String r1 = "LayoutInflater.from(context)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r0, r1)
            r1 = 0
            r2 = r14
            com.getstream.sdk.chat.databinding.StreamItemAttachMediaBinding r0 = com.getstream.sdk.chat.databinding.StreamItemAttachMediaBinding.inflate(r0, r14, r1)
            java.lang.String r1 = "StreamItemAttachMediaBin….inflater, parent, false)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r0, r1)
            r12 = r0
            goto L_0x003a
        L_0x0037:
            r2 = r14
            r12 = r22
        L_0x003a:
            r3 = r13
            r4 = r14
            r5 = r15
            r6 = r16
            r7 = r17
            r8 = r18
            r9 = r19
            r3.<init>(r4, r5, r6, r7, r8, r9, r10, r11, r12)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.getstream.sdk.chat.adapter.viewholder.attachment.AttachmentViewHolderMedia.<init>(android.view.ViewGroup, com.getstream.sdk.chat.view.MessageListViewStyle, com.getstream.sdk.chat.view.MessageListView$BubbleHelper, com.getstream.sdk.chat.adapter.MessageListItem$MessageItem, com.getstream.sdk.chat.view.MessageListView$GiphySendListener, com.getstream.sdk.chat.view.MessageListView$AttachmentClickListener, com.getstream.sdk.chat.view.MessageListView$MessageLongClickListener, com.getstream.sdk.chat.view.MessageListView$MessageLongClickListenerView, com.getstream.sdk.chat.databinding.StreamItemAttachMediaBinding, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public AttachmentViewHolderMedia(android.view.ViewGroup r2, com.getstream.sdk.chat.view.MessageListViewStyle r3, com.getstream.sdk.chat.view.MessageListView.BubbleHelper r4, com.getstream.sdk.chat.adapter.MessageListItem.MessageItem r5, com.getstream.sdk.chat.view.MessageListView.GiphySendListener r6, com.getstream.sdk.chat.view.MessageListView.AttachmentClickListener r7, com.getstream.sdk.chat.view.MessageListView.MessageLongClickListener r8, com.getstream.sdk.chat.view.MessageListView.MessageLongClickListenerView r9, com.getstream.sdk.chat.databinding.StreamItemAttachMediaBinding r10) {
        /*
            r1 = this;
            java.lang.String r0 = "parent"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r2, r0)
            java.lang.String r2 = "style"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r3, r2)
            java.lang.String r2 = "bubbleHelper"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r4, r2)
            java.lang.String r2 = "messageItem"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r5, r2)
            java.lang.String r2 = "giphySendListener"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r6, r2)
            java.lang.String r2 = "clickListener"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r7, r2)
            java.lang.String r2 = "binding"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r10, r2)
            androidx.constraintlayout.widget.ConstraintLayout r2 = r10.getRoot()
            java.lang.String r0 = "binding.root"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r2, r0)
            android.view.View r2 = (android.view.View) r2
            r1.<init>(r2)
            r1.style = r3
            r1.bubbleHelper = r4
            r1.messageItem = r5
            r1.giphySendListener = r6
            r1.clickListener = r7
            r1.longClickListener = r8
            r1.longClickListenerView = r9
            r1.binding = r10
            android.widget.TextView r2 = r10.tvMediaDes
            java.lang.String r4 = "binding.tvMediaDes"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r2, r4)
            int r3 = r3.getAttachmentPreviewMaxLines()
            r2.setMaxLines(r3)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.getstream.sdk.chat.adapter.viewholder.attachment.AttachmentViewHolderMedia.<init>(android.view.ViewGroup, com.getstream.sdk.chat.view.MessageListViewStyle, com.getstream.sdk.chat.view.MessageListView$BubbleHelper, com.getstream.sdk.chat.adapter.MessageListItem$MessageItem, com.getstream.sdk.chat.view.MessageListView$GiphySendListener, com.getstream.sdk.chat.view.MessageListView$AttachmentClickListener, com.getstream.sdk.chat.view.MessageListView$MessageLongClickListener, com.getstream.sdk.chat.view.MessageListView$MessageLongClickListenerView, com.getstream.sdk.chat.databinding.StreamItemAttachMediaBinding):void");
    }

    public void bind(AttachmentListItem attachmentListItem) {
        Intrinsics.checkNotNullParameter(attachmentListItem, "attachmentListItem");
        this.attachment = attachmentListItem.getAttachment();
        applyStyle();
        configMediaAttach();
        configActions();
        configClickListeners();
    }

    private final void applyStyle() {
        if (this.messageItem.isMine()) {
            TextStyle attachmentTitleTextMine = this.style.getAttachmentTitleTextMine();
            TextView textView = this.binding.tvMediaTitle;
            Intrinsics.checkNotNullExpressionValue(textView, "binding.tvMediaTitle");
            attachmentTitleTextMine.apply(textView);
            TextStyle attachmentDescriptionTextMine = this.style.getAttachmentDescriptionTextMine();
            TextView textView2 = this.binding.tvMediaDes;
            Intrinsics.checkNotNullExpressionValue(textView2, "binding.tvMediaDes");
            attachmentDescriptionTextMine.apply(textView2);
            return;
        }
        TextStyle attachmentTitleTextTheirs = this.style.getAttachmentTitleTextTheirs();
        TextView textView3 = this.binding.tvMediaTitle;
        Intrinsics.checkNotNullExpressionValue(textView3, "binding.tvMediaTitle");
        attachmentTitleTextTheirs.apply(textView3);
        TextStyle attachmentDescriptionTextTheirs = this.style.getAttachmentDescriptionTextTheirs();
        TextView textView4 = this.binding.tvMediaDes;
        Intrinsics.checkNotNullExpressionValue(textView4, "binding.tvMediaDes");
        attachmentDescriptionTextTheirs.apply(textView4);
    }

    private final void configMediaAttach() {
        Attachment attachment2 = this.attachment;
        if (attachment2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException(MessengerShareContentUtility.ATTACHMENT);
        }
        String type = attachment2.getType();
        configImageThumbBackground();
        Attachment attachment3 = this.attachment;
        if (attachment3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException(MessengerShareContentUtility.ATTACHMENT);
        }
        String thumbUrl = attachment3.getThumbUrl();
        CharSequence charSequence = thumbUrl;
        boolean z = true;
        if (charSequence == null || charSequence.length() == 0) {
            Attachment attachment4 = this.attachment;
            if (attachment4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException(MessengerShareContentUtility.ATTACHMENT);
            }
            thumbUrl = attachment4.getImageUrl();
        }
        String str = thumbUrl;
        PorterShapeImageView porterShapeImageView = this.binding.ivMediaThumb;
        Intrinsics.checkNotNullExpressionValue(porterShapeImageView, "binding.ivMediaThumb");
        ViewExtensionsKt.load$default(porterShapeImageView, str, Integer.valueOf(C1673R.C1676drawable.stream_placeholder), (StreamImageLoader.ImageTransformation) null, new AttachmentViewHolderMedia$configMediaAttach$1(this), new AttachmentViewHolderMedia$configMediaAttach$2(this), 4, (Object) null);
        if (!Intrinsics.areEqual((Object) this.messageItem.getMessage().getType(), (Object) ModelType.message_ephemeral)) {
            TextView textView = this.binding.tvMediaTitle;
            Intrinsics.checkNotNullExpressionValue(textView, "binding.tvMediaTitle");
            Attachment attachment5 = this.attachment;
            if (attachment5 == null) {
                Intrinsics.throwUninitializedPropertyAccessException(MessengerShareContentUtility.ATTACHMENT);
            }
            textView.setText(attachment5.getTitle());
        }
        TextView textView2 = this.binding.tvMediaDes;
        Intrinsics.checkNotNullExpressionValue(textView2, "binding.tvMediaDes");
        Attachment attachment6 = this.attachment;
        if (attachment6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException(MessengerShareContentUtility.ATTACHMENT);
        }
        textView2.setText(attachment6.getText());
        TextView textView3 = this.binding.tvMediaTitle;
        Intrinsics.checkNotNullExpressionValue(textView3, "binding.tvMediaTitle");
        View view = textView3;
        Attachment attachment7 = this.attachment;
        if (attachment7 == null) {
            Intrinsics.throwUninitializedPropertyAccessException(MessengerShareContentUtility.ATTACHMENT);
        }
        CharSequence title = attachment7.getTitle();
        int i = 8;
        view.setVisibility((title == null || title.length() == 0) ^ true ? 0 : 8);
        TextView textView4 = this.binding.tvMediaDes;
        Intrinsics.checkNotNullExpressionValue(textView4, "binding.tvMediaDes");
        View view2 = textView4;
        Attachment attachment8 = this.attachment;
        if (attachment8 == null) {
            Intrinsics.throwUninitializedPropertyAccessException(MessengerShareContentUtility.ATTACHMENT);
        }
        CharSequence text = attachment8.getText();
        view2.setVisibility((text == null || text.length() == 0) ^ true ? 0 : 8);
        TextView textView5 = this.binding.tvMediaPlay;
        Intrinsics.checkNotNullExpressionValue(textView5, "binding.tvMediaPlay");
        textView5.setVisibility(Intrinsics.areEqual((Object) type, (Object) "video") ? 0 : 8);
        ImageView imageView = this.binding.ivCommandLogo;
        Intrinsics.checkNotNullExpressionValue(imageView, "binding.ivCommandLogo");
        View view3 = imageView;
        if (Intrinsics.areEqual((Object) type, (Object) ModelType.attach_giphy)) {
            i = 0;
        }
        view3.setVisibility(i);
        TextView textView6 = this.binding.tvMediaDes;
        Intrinsics.checkNotNullExpressionValue(textView6, "binding.tvMediaDes");
        if (!(textView6.getVisibility() == 0)) {
            TextView textView7 = this.binding.tvMediaTitle;
            Intrinsics.checkNotNullExpressionValue(textView7, "binding.tvMediaTitle");
            if (textView7.getVisibility() != 0) {
                z = false;
            }
            if (!z) {
                return;
            }
        }
        Drawable drawableForAttachmentDescription = this.bubbleHelper.getDrawableForAttachmentDescription(this.messageItem.getMessage(), this.messageItem.isMine(), this.messageItem.getPositions());
        ConstraintLayout constraintLayout = this.binding.clDes;
        Intrinsics.checkNotNullExpressionValue(constraintLayout, "binding.clDes");
        constraintLayout.setBackground(drawableForAttachmentDescription);
    }

    private final void configImageThumbBackground() {
        MessageListView.BubbleHelper bubbleHelper2 = this.bubbleHelper;
        Message message = this.messageItem.getMessage();
        boolean isMine = this.messageItem.isMine();
        List<MessageListItem.Position> positions = this.messageItem.getPositions();
        Attachment attachment2 = this.attachment;
        if (attachment2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException(MessengerShareContentUtility.ATTACHMENT);
        }
        this.binding.ivMediaThumb.setShape(getContext(), bubbleHelper2.getDrawableForAttachment(message, isMine, positions, attachment2));
    }

    private final void configActions() {
        if (!Intrinsics.areEqual((Object) this.messageItem.getMessage().getType(), (Object) ModelType.message_ephemeral) || !Intrinsics.areEqual((Object) this.messageItem.getMessage().getCommand(), (Object) ModelType.attach_giphy)) {
            ConstraintLayout constraintLayout = this.binding.clAction;
            Intrinsics.checkNotNullExpressionValue(constraintLayout, "binding.clAction");
            constraintLayout.setVisibility(8);
            return;
        }
        configGiphyAction();
    }

    private final void configGiphyAction() {
        ConstraintLayout constraintLayout = this.binding.clAction;
        Intrinsics.checkNotNullExpressionValue(constraintLayout, "binding.clAction");
        constraintLayout.setVisibility(0);
        TextView textView = this.binding.tvActionSend;
        Intrinsics.checkNotNullExpressionValue(textView, "binding.tvActionSend");
        textView.setBackground(new DrawableBuilder().rectangle().rounded().strokeColor(-1).strokeWidth(Utils.dpToPx(2)).solidColor(ContextCompat.getColor(getContext(), C1673R.C1675color.stream_input_message_send_button)).solidColorPressed(-3355444).build());
        TextView textView2 = this.binding.tvActionShuffle;
        Intrinsics.checkNotNullExpressionValue(textView2, "binding.tvActionShuffle");
        textView2.setBackground(new DrawableBuilder().rectangle().rounded().strokeColor(ContextCompat.getColor(getContext(), C1673R.C1675color.stream_message_stroke)).strokeWidth(Utils.dpToPx(2)).solidColor(-1).solidColorPressed(-3355444).build());
        TextView textView3 = this.binding.tvActionCancel;
        Intrinsics.checkNotNullExpressionValue(textView3, "binding.tvActionCancel");
        textView3.setBackground(new DrawableBuilder().rectangle().rounded().strokeColor(ContextCompat.getColor(getContext(), C1673R.C1675color.stream_message_stroke)).strokeWidth(Utils.dpToPx(2)).solidColor(-1).solidColorPressed(-3355444).build());
        this.binding.tvActionSend.setOnClickListener(new AttachmentViewHolderMedia$configGiphyAction$1(this));
        this.binding.tvActionShuffle.setOnClickListener(new AttachmentViewHolderMedia$configGiphyAction$2(this));
        this.binding.tvActionCancel.setOnClickListener(new AttachmentViewHolderMedia$configGiphyAction$3(this));
    }

    /* access modifiers changed from: private */
    public final void enableSendGiphyButtons(boolean z) {
        ProgressBar progressBar = this.binding.progressBar;
        Intrinsics.checkNotNullExpressionValue(progressBar, "binding.progressBar");
        progressBar.setVisibility(z ^ true ? 0 : 8);
        TextView textView = this.binding.tvActionSend;
        Intrinsics.checkNotNullExpressionValue(textView, "binding.tvActionSend");
        textView.setEnabled(z);
        TextView textView2 = this.binding.tvActionShuffle;
        Intrinsics.checkNotNullExpressionValue(textView2, "binding.tvActionShuffle");
        textView2.setEnabled(z);
        TextView textView3 = this.binding.tvActionCancel;
        Intrinsics.checkNotNullExpressionValue(textView3, "binding.tvActionCancel");
        textView3.setEnabled(z);
    }

    private final void configClickListeners() {
        this.binding.ivMediaThumb.setOnClickListener(new AttachmentViewHolderMedia$configClickListeners$1(this));
        this.binding.ivMediaThumb.setOnLongClickListener(new AttachmentViewHolderMedia$configClickListeners$2(this));
    }
}
