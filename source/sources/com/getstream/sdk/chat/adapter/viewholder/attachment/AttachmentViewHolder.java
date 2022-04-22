package com.getstream.sdk.chat.adapter.viewholder.attachment;

import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.facebook.share.internal.MessengerShareContentUtility;
import com.getstream.sdk.chat.C1673R;
import com.getstream.sdk.chat.ChatUI;
import com.getstream.sdk.chat.adapter.AttachmentListItem;
import com.getstream.sdk.chat.adapter.FileAttachmentSelectedAdapter;
import com.getstream.sdk.chat.adapter.MessageListItem;
import com.getstream.sdk.chat.databinding.StreamItemAttachMediaBinding;
import com.getstream.sdk.chat.databinding.StreamItemAttachmentBinding;
import com.getstream.sdk.chat.images.StreamImageLoader;
import com.getstream.sdk.chat.images.ViewExtensionsKt;
import com.getstream.sdk.chat.model.AttachmentMetaData;
import com.getstream.sdk.chat.model.ModelType;
import com.getstream.sdk.chat.style.TextStyle;
import com.getstream.sdk.chat.utils.roundedImageView.PorterShapeImageView;
import com.getstream.sdk.chat.view.MessageListView;
import com.getstream.sdk.chat.view.MessageListViewStyle;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import p015io.getstream.chat.android.client.models.Attachment;
import p015io.getstream.chat.android.client.models.Message;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0000\u0018\u00002\u00020\u0001BO\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\r\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u000f\u0012\b\b\u0002\u0010\u0010\u001a\u00020\u0011¢\u0006\u0002\u0010\u0012J\b\u0010\u0017\u001a\u00020\u0018H\u0002J\u0010\u0010\u0019\u001a\u00020\u00182\u0006\u0010\u001a\u001a\u00020\u001bH\u0016J\u0010\u0010\u001c\u001a\u00020\u00182\u0006\u0010\u001d\u001a\u00020\u001eH\u0002J\b\u0010\u001f\u001a\u00020\u0018H\u0002J\b\u0010 \u001a\u00020\u0018H\u0002J\b\u0010!\u001a\u00020\u0018H\u0002J\b\u0010\"\u001a\u00020\u0018H\u0002J\b\u0010#\u001a\u00020\u0018H\u0002R\u000e\u0010\u0013\u001a\u00020\u0014X.¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0016X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000¨\u0006$"}, mo26107d2 = {"Lcom/getstream/sdk/chat/adapter/viewholder/attachment/AttachmentViewHolder;", "Lcom/getstream/sdk/chat/adapter/viewholder/attachment/BaseAttachmentViewHolder;", "parent", "Landroid/view/ViewGroup;", "style", "Lcom/getstream/sdk/chat/view/MessageListViewStyle;", "bubbleHelper", "Lcom/getstream/sdk/chat/view/MessageListView$BubbleHelper;", "messageItem", "Lcom/getstream/sdk/chat/adapter/MessageListItem$MessageItem;", "clickListener", "Lcom/getstream/sdk/chat/view/MessageListView$AttachmentClickListener;", "longClickListener", "Lcom/getstream/sdk/chat/view/MessageListView$MessageLongClickListener;", "longClickListenerView", "Lcom/getstream/sdk/chat/view/MessageListView$MessageLongClickListenerView;", "binding", "Lcom/getstream/sdk/chat/databinding/StreamItemAttachmentBinding;", "(Landroid/view/ViewGroup;Lcom/getstream/sdk/chat/view/MessageListViewStyle;Lcom/getstream/sdk/chat/view/MessageListView$BubbleHelper;Lcom/getstream/sdk/chat/adapter/MessageListItem$MessageItem;Lcom/getstream/sdk/chat/view/MessageListView$AttachmentClickListener;Lcom/getstream/sdk/chat/view/MessageListView$MessageLongClickListener;Lcom/getstream/sdk/chat/view/MessageListView$MessageLongClickListenerView;Lcom/getstream/sdk/chat/databinding/StreamItemAttachmentBinding;)V", "attachment", "Lio/getstream/chat/android/client/models/Attachment;", "mediaBinding", "Lcom/getstream/sdk/chat/databinding/StreamItemAttachMediaBinding;", "applyStyle", "", "bind", "attachmentListItem", "Lcom/getstream/sdk/chat/adapter/AttachmentListItem;", "configAttachViewBackground", "view", "Landroid/view/View;", "configAttachment", "configClickListeners", "configFileAttach", "configImageThumbBackground", "configMediaAttach", "stream-chat-android_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
/* compiled from: AttachmentViewHolder.kt */
public final class AttachmentViewHolder extends BaseAttachmentViewHolder {
    /* access modifiers changed from: private */
    public Attachment attachment;
    private final StreamItemAttachmentBinding binding;
    private final MessageListView.BubbleHelper bubbleHelper;
    /* access modifiers changed from: private */
    public final MessageListView.AttachmentClickListener clickListener;
    /* access modifiers changed from: private */
    public final MessageListView.MessageLongClickListener longClickListener;
    /* access modifiers changed from: private */
    public final MessageListView.MessageLongClickListenerView longClickListenerView;
    private final StreamItemAttachMediaBinding mediaBinding;
    /* access modifiers changed from: private */
    public final MessageListItem.MessageItem messageItem;
    private final MessageListViewStyle style;

    public static final /* synthetic */ Attachment access$getAttachment$p(AttachmentViewHolder attachmentViewHolder) {
        Attachment attachment2 = attachmentViewHolder.attachment;
        if (attachment2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException(MessengerShareContentUtility.ATTACHMENT);
        }
        return attachment2;
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ AttachmentViewHolder(android.view.ViewGroup r13, com.getstream.sdk.chat.view.MessageListViewStyle r14, com.getstream.sdk.chat.view.MessageListView.BubbleHelper r15, com.getstream.sdk.chat.adapter.MessageListItem.MessageItem r16, com.getstream.sdk.chat.view.MessageListView.AttachmentClickListener r17, com.getstream.sdk.chat.view.MessageListView.MessageLongClickListener r18, com.getstream.sdk.chat.view.MessageListView.MessageLongClickListenerView r19, com.getstream.sdk.chat.databinding.StreamItemAttachmentBinding r20, int r21, kotlin.jvm.internal.DefaultConstructorMarker r22) {
        /*
            r12 = this;
            r0 = r21
            r1 = r0 & 32
            r2 = 0
            if (r1 == 0) goto L_0x000c
            r1 = r2
            com.getstream.sdk.chat.view.MessageListView$MessageLongClickListener r1 = (com.getstream.sdk.chat.view.MessageListView.MessageLongClickListener) r1
            r9 = r1
            goto L_0x000e
        L_0x000c:
            r9 = r18
        L_0x000e:
            r1 = r0 & 64
            if (r1 == 0) goto L_0x0017
            r1 = r2
            com.getstream.sdk.chat.view.MessageListView$MessageLongClickListenerView r1 = (com.getstream.sdk.chat.view.MessageListView.MessageLongClickListenerView) r1
            r10 = r1
            goto L_0x0019
        L_0x0017:
            r10 = r19
        L_0x0019:
            r0 = r0 & 128(0x80, float:1.794E-43)
            if (r0 == 0) goto L_0x0037
            android.content.Context r0 = r13.getContext()
            android.view.LayoutInflater r0 = android.view.LayoutInflater.from(r0)
            java.lang.String r1 = "LayoutInflater.from(context)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r0, r1)
            r1 = 0
            r2 = r13
            com.getstream.sdk.chat.databinding.StreamItemAttachmentBinding r0 = com.getstream.sdk.chat.databinding.StreamItemAttachmentBinding.inflate(r0, r13, r1)
            java.lang.String r1 = "StreamItemAttachmentBind….inflater, parent, false)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r0, r1)
            r11 = r0
            goto L_0x003a
        L_0x0037:
            r2 = r13
            r11 = r20
        L_0x003a:
            r3 = r12
            r4 = r13
            r5 = r14
            r6 = r15
            r7 = r16
            r8 = r17
            r3.<init>(r4, r5, r6, r7, r8, r9, r10, r11)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.getstream.sdk.chat.adapter.viewholder.attachment.AttachmentViewHolder.<init>(android.view.ViewGroup, com.getstream.sdk.chat.view.MessageListViewStyle, com.getstream.sdk.chat.view.MessageListView$BubbleHelper, com.getstream.sdk.chat.adapter.MessageListItem$MessageItem, com.getstream.sdk.chat.view.MessageListView$AttachmentClickListener, com.getstream.sdk.chat.view.MessageListView$MessageLongClickListener, com.getstream.sdk.chat.view.MessageListView$MessageLongClickListenerView, com.getstream.sdk.chat.databinding.StreamItemAttachmentBinding, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public AttachmentViewHolder(android.view.ViewGroup r2, com.getstream.sdk.chat.view.MessageListViewStyle r3, com.getstream.sdk.chat.view.MessageListView.BubbleHelper r4, com.getstream.sdk.chat.adapter.MessageListItem.MessageItem r5, com.getstream.sdk.chat.view.MessageListView.AttachmentClickListener r6, com.getstream.sdk.chat.view.MessageListView.MessageLongClickListener r7, com.getstream.sdk.chat.view.MessageListView.MessageLongClickListenerView r8, com.getstream.sdk.chat.databinding.StreamItemAttachmentBinding r9) {
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
            java.lang.String r2 = "clickListener"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r6, r2)
            java.lang.String r2 = "binding"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r9, r2)
            androidx.constraintlayout.widget.ConstraintLayout r2 = r9.getRoot()
            java.lang.String r0 = "binding.root"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r2, r0)
            android.view.View r2 = (android.view.View) r2
            r1.<init>(r2)
            r1.style = r3
            r1.bubbleHelper = r4
            r1.messageItem = r5
            r1.clickListener = r6
            r1.longClickListener = r7
            r1.longClickListenerView = r8
            r1.binding = r9
            com.getstream.sdk.chat.databinding.StreamItemAttachMediaBinding r2 = r9.clAttachmentMedia
            java.lang.String r4 = "binding.clAttachmentMedia"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r2, r4)
            r1.mediaBinding = r2
            android.widget.TextView r2 = r2.tvMediaDes
            java.lang.String r4 = "mediaBinding.tvMediaDes"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r2, r4)
            int r3 = r3.getAttachmentPreviewMaxLines()
            r2.setMaxLines(r3)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.getstream.sdk.chat.adapter.viewholder.attachment.AttachmentViewHolder.<init>(android.view.ViewGroup, com.getstream.sdk.chat.view.MessageListViewStyle, com.getstream.sdk.chat.view.MessageListView$BubbleHelper, com.getstream.sdk.chat.adapter.MessageListItem$MessageItem, com.getstream.sdk.chat.view.MessageListView$AttachmentClickListener, com.getstream.sdk.chat.view.MessageListView$MessageLongClickListener, com.getstream.sdk.chat.view.MessageListView$MessageLongClickListenerView, com.getstream.sdk.chat.databinding.StreamItemAttachmentBinding):void");
    }

    public void bind(AttachmentListItem attachmentListItem) {
        Intrinsics.checkNotNullParameter(attachmentListItem, "attachmentListItem");
        this.attachment = attachmentListItem.getAttachment();
        applyStyle();
        configAttachment();
    }

    private final void applyStyle() {
        if (this.messageItem.isMine()) {
            TextStyle attachmentTitleTextMine = this.style.getAttachmentTitleTextMine();
            TextView textView = this.mediaBinding.tvMediaTitle;
            Intrinsics.checkNotNullExpressionValue(textView, "mediaBinding.tvMediaTitle");
            attachmentTitleTextMine.apply(textView);
            TextStyle attachmentDescriptionTextMine = this.style.getAttachmentDescriptionTextMine();
            TextView textView2 = this.mediaBinding.tvMediaDes;
            Intrinsics.checkNotNullExpressionValue(textView2, "mediaBinding.tvMediaDes");
            attachmentDescriptionTextMine.apply(textView2);
            return;
        }
        TextStyle attachmentTitleTextTheirs = this.style.getAttachmentTitleTextTheirs();
        TextView textView3 = this.mediaBinding.tvMediaTitle;
        Intrinsics.checkNotNullExpressionValue(textView3, "mediaBinding.tvMediaTitle");
        attachmentTitleTextTheirs.apply(textView3);
        TextStyle attachmentDescriptionTextTheirs = this.style.getAttachmentDescriptionTextTheirs();
        TextView textView4 = this.mediaBinding.tvMediaDes;
        Intrinsics.checkNotNullExpressionValue(textView4, "mediaBinding.tvMediaDes");
        attachmentDescriptionTextTheirs.apply(textView4);
    }

    private final void configAttachment() {
        boolean z;
        Iterator<Attachment> it = this.messageItem.getMessage().getAttachments().iterator();
        boolean z2 = false;
        boolean z3 = false;
        while (true) {
            z = true;
            if (!it.hasNext()) {
                break;
            }
            Attachment next = it.next();
            if (next.getType() != null) {
                if (Intrinsics.areEqual((Object) next.getType(), (Object) "file")) {
                    z3 = true;
                } else {
                    z2 = true;
                }
            }
        }
        if (z2) {
            ConstraintLayout root = this.mediaBinding.getRoot();
            Intrinsics.checkNotNullExpressionValue(root, "mediaBinding.root");
            root.setVisibility(0);
            configMediaAttach();
        } else {
            ConstraintLayout root2 = this.mediaBinding.getRoot();
            Intrinsics.checkNotNullExpressionValue(root2, "mediaBinding.root");
            root2.setVisibility(8);
        }
        if (z3) {
            ListView listView = this.binding.lvAttachmentFile;
            Intrinsics.checkNotNullExpressionValue(listView, "binding.lvAttachmentFile");
            listView.setVisibility(0);
            configFileAttach();
        } else {
            ListView listView2 = this.binding.lvAttachmentFile;
            Intrinsics.checkNotNullExpressionValue(listView2, "binding.lvAttachmentFile");
            listView2.setVisibility(8);
        }
        if (!z2 && !z3) {
            PorterShapeImageView porterShapeImageView = this.mediaBinding.ivMediaThumb;
            Intrinsics.checkNotNullExpressionValue(porterShapeImageView, "mediaBinding.ivMediaThumb");
            porterShapeImageView.setVisibility(8);
            Attachment attachment2 = this.attachment;
            if (attachment2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException(MessengerShareContentUtility.ATTACHMENT);
            }
            CharSequence title = attachment2.getTitle();
            if (!(title == null || title.length() == 0)) {
                ConstraintLayout root3 = this.mediaBinding.getRoot();
                Intrinsics.checkNotNullExpressionValue(root3, "mediaBinding.root");
                root3.setVisibility(0);
                TextView textView = this.mediaBinding.tvMediaTitle;
                Intrinsics.checkNotNullExpressionValue(textView, "mediaBinding.tvMediaTitle");
                textView.setVisibility(0);
                TextView textView2 = this.mediaBinding.tvMediaTitle;
                Intrinsics.checkNotNullExpressionValue(textView2, "mediaBinding.tvMediaTitle");
                Attachment attachment3 = this.attachment;
                if (attachment3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException(MessengerShareContentUtility.ATTACHMENT);
                }
                textView2.setText(attachment3.getTitle());
            } else {
                TextView textView3 = this.mediaBinding.tvMediaTitle;
                Intrinsics.checkNotNullExpressionValue(textView3, "mediaBinding.tvMediaTitle");
                textView3.setVisibility(8);
            }
            Attachment attachment4 = this.attachment;
            if (attachment4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException(MessengerShareContentUtility.ATTACHMENT);
            }
            CharSequence text = attachment4.getText();
            if (!(text == null || text.length() == 0)) {
                z = false;
            }
            if (!z) {
                ConstraintLayout root4 = this.mediaBinding.getRoot();
                Intrinsics.checkNotNullExpressionValue(root4, "mediaBinding.root");
                root4.setVisibility(0);
                TextView textView4 = this.mediaBinding.tvMediaDes;
                Intrinsics.checkNotNullExpressionValue(textView4, "mediaBinding.tvMediaDes");
                textView4.setVisibility(0);
                TextView textView5 = this.mediaBinding.tvMediaDes;
                Intrinsics.checkNotNullExpressionValue(textView5, "mediaBinding.tvMediaDes");
                Attachment attachment5 = this.attachment;
                if (attachment5 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException(MessengerShareContentUtility.ATTACHMENT);
                }
                textView5.setText(attachment5.getText());
                return;
            }
            TextView textView6 = this.mediaBinding.tvMediaDes;
            Intrinsics.checkNotNullExpressionValue(textView6, "mediaBinding.tvMediaDes");
            textView6.setVisibility(8);
        }
    }

    private final void configMediaAttach() {
        for (Attachment attachment2 : this.messageItem.getMessage().getAttachments()) {
            if (!Intrinsics.areEqual((Object) attachment2.getType(), (Object) "file")) {
                String type = attachment2.getType();
                String imageUrl = attachment2.getImageUrl();
                if (type != null) {
                    if (Intrinsics.areEqual((Object) "image", (Object) type)) {
                        imageUrl = attachment2.getImageUrl();
                    } else if (Intrinsics.areEqual((Object) ModelType.attach_giphy, (Object) type)) {
                        imageUrl = attachment2.getThumbUrl();
                    } else if (Intrinsics.areEqual((Object) "video", (Object) type)) {
                        imageUrl = attachment2.getThumbUrl();
                    } else if (imageUrl == null) {
                        imageUrl = attachment2.getImage();
                    }
                }
                CharSequence charSequence = imageUrl;
                int i = 0;
                if (charSequence == null || charSequence.length() == 0) {
                    ConstraintLayout root = this.mediaBinding.getRoot();
                    Intrinsics.checkNotNullExpressionValue(root, "mediaBinding.root");
                    root.setVisibility(8);
                    return;
                }
                ConstraintLayout root2 = this.mediaBinding.getRoot();
                Intrinsics.checkNotNullExpressionValue(root2, "mediaBinding.root");
                root2.setVisibility(0);
                ConstraintLayout root3 = this.mediaBinding.getRoot();
                Intrinsics.checkNotNullExpressionValue(root3, "mediaBinding.root");
                configAttachViewBackground(root3);
                configImageThumbBackground();
                configClickListeners();
                if (!StringsKt.contains$default(charSequence, (CharSequence) "https:", false, 2, (Object) null)) {
                    imageUrl = "https:" + imageUrl;
                }
                PorterShapeImageView porterShapeImageView = this.mediaBinding.ivMediaThumb;
                Intrinsics.checkNotNullExpressionValue(porterShapeImageView, "mediaBinding.ivMediaThumb");
                ViewExtensionsKt.load$default(porterShapeImageView, ChatUI.Companion.instance().getUrlSigner().signImageUrl(imageUrl), (Integer) null, (StreamImageLoader.ImageTransformation) null, (Function0) null, (Function0) null, 30, (Object) null);
                if (!Intrinsics.areEqual((Object) this.messageItem.getMessage().getType(), (Object) ModelType.message_ephemeral)) {
                    TextView textView = this.mediaBinding.tvMediaTitle;
                    Intrinsics.checkNotNullExpressionValue(textView, "mediaBinding.tvMediaTitle");
                    textView.setText(attachment2.getTitle());
                }
                TextView textView2 = this.mediaBinding.tvMediaDes;
                Intrinsics.checkNotNullExpressionValue(textView2, "mediaBinding.tvMediaDes");
                textView2.setText(attachment2.getText());
                TextView textView3 = this.mediaBinding.tvMediaDes;
                Intrinsics.checkNotNullExpressionValue(textView3, "mediaBinding.tvMediaDes");
                View view = textView3;
                CharSequence text = attachment2.getText();
                view.setVisibility((text == null || text.length() == 0) ^ true ? 0 : 8);
                TextView textView4 = this.mediaBinding.tvMediaTitle;
                Intrinsics.checkNotNullExpressionValue(textView4, "mediaBinding.tvMediaTitle");
                View view2 = textView4;
                CharSequence title = attachment2.getTitle();
                view2.setVisibility((title == null || title.length() == 0) ^ true ? 0 : 8);
                TextView textView5 = this.mediaBinding.tvMediaPlay;
                Intrinsics.checkNotNullExpressionValue(textView5, "mediaBinding.tvMediaPlay");
                View view3 = textView5;
                if (!Intrinsics.areEqual((Object) type, (Object) "video")) {
                    i = 8;
                }
                view3.setVisibility(i);
                return;
            }
        }
        throw new NoSuchElementException("Collection contains no element matching the predicate.");
    }

    private final void configAttachViewBackground(View view) {
        int messageBubbleDrawable = this.style.getMessageBubbleDrawable(this.messageItem.isMine());
        if (messageBubbleDrawable != -1) {
            view.setBackground(getContext().getDrawable(messageBubbleDrawable));
        }
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
        this.mediaBinding.ivMediaThumb.setShape(getContext(), bubbleHelper2.getDrawableForAttachment(message, isMine, positions, attachment2));
        TextView textView = this.mediaBinding.tvMediaDes;
        Intrinsics.checkNotNullExpressionValue(textView, "mediaBinding.tvMediaDes");
        boolean z = true;
        if (!(textView.getVisibility() == 0)) {
            TextView textView2 = this.mediaBinding.tvMediaTitle;
            Intrinsics.checkNotNullExpressionValue(textView2, "mediaBinding.tvMediaTitle");
            if (textView2.getVisibility() != 0) {
                z = false;
            }
            if (!z) {
                return;
            }
        }
        Drawable drawableForAttachmentDescription = this.bubbleHelper.getDrawableForAttachmentDescription(this.messageItem.getMessage(), this.messageItem.isMine(), this.messageItem.getPositions());
        ConstraintLayout constraintLayout = this.mediaBinding.clDes;
        Intrinsics.checkNotNullExpressionValue(constraintLayout, "mediaBinding.clDes");
        constraintLayout.setBackground(drawableForAttachmentDescription);
    }

    private final void configClickListeners() {
        this.mediaBinding.getRoot().setOnClickListener(new AttachmentViewHolder$configClickListeners$1(this));
        this.mediaBinding.getRoot().setOnLongClickListener(new AttachmentViewHolder$configClickListeners$2(this));
    }

    private final void configFileAttach() {
        ListView listView = this.binding.lvAttachmentFile;
        Intrinsics.checkNotNullExpressionValue(listView, "binding.lvAttachmentFile");
        configAttachViewBackground(listView);
        Collection arrayList = new ArrayList();
        for (Object next : this.messageItem.getMessage().getAttachments()) {
            if (Intrinsics.areEqual((Object) ((Attachment) next).getType(), (Object) "file")) {
                arrayList.add(next);
            }
        }
        List list = (List) arrayList;
        ListView listView2 = this.binding.lvAttachmentFile;
        Intrinsics.checkNotNullExpressionValue(listView2, "binding.lvAttachmentFile");
        Iterable<Attachment> iterable = list;
        Collection arrayList2 = new ArrayList(CollectionsKt.collectionSizeOrDefault(iterable, 10));
        for (Attachment attachmentMetaData : iterable) {
            arrayList2.add(new AttachmentMetaData(attachmentMetaData));
        }
        listView2.setAdapter(new FileAttachmentSelectedAdapter((List) arrayList2, false, (Function1) null, 4, (DefaultConstructorMarker) null));
        ListView listView3 = this.binding.lvAttachmentFile;
        Intrinsics.checkNotNullExpressionValue(listView3, "binding.lvAttachmentFile");
        listView3.setOnItemClickListener(new AttachmentViewHolder$configFileAttach$2(this));
        ListView listView4 = this.binding.lvAttachmentFile;
        Intrinsics.checkNotNullExpressionValue(listView4, "binding.lvAttachmentFile");
        listView4.setOnItemLongClickListener(new AttachmentViewHolder$configFileAttach$3(this));
        ListView listView5 = this.binding.lvAttachmentFile;
        Intrinsics.checkNotNullExpressionValue(listView5, "binding.lvAttachmentFile");
        View view = listView5;
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        Objects.requireNonNull(layoutParams, "null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
        ViewGroup.LayoutParams layoutParams2 = (ConstraintLayout.LayoutParams) layoutParams;
        ((ConstraintLayout.LayoutParams) layoutParams2).height = ((int) getContext().getResources().getDimension(C1673R.dimen.stream_attach_file_height)) * list.size();
        view.setLayoutParams(layoutParams2);
    }
}
