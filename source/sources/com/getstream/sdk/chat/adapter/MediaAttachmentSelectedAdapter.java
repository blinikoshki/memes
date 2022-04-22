package com.getstream.sdk.chat.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.facebook.share.internal.MessengerShareContentUtility;
import com.getstream.sdk.chat.C1673R;
import com.getstream.sdk.chat.databinding.StreamItemAttachedMediaBinding;
import com.getstream.sdk.chat.images.StreamImageLoader;
import com.getstream.sdk.chat.images.ViewExtensionsKt;
import com.getstream.sdk.chat.model.AttachmentMetaData;
import com.getstream.sdk.chat.utils.MediaStringUtil;
import com.getstream.sdk.chat.utils.roundedImageView.PorterShapeImageView;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import top.defaults.drawabletoolbox.DrawableBuilder;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\t\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0000\u0018\u00002\f\u0012\b\u0012\u00060\u0002R\u00020\u00000\u0001:\u0001\u001eB+\u0012\u000e\b\u0002\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004\u0012\u0014\b\u0002\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\b0\u0007¢\u0006\u0002\u0010\tJ\u000e\u0010\u000e\u001a\u00020\b2\u0006\u0010\u000f\u001a\u00020\u0005J\u0006\u0010\u0010\u001a\u00020\bJ\b\u0010\u0011\u001a\u00020\u0012H\u0016J\u001c\u0010\u0013\u001a\u00020\b2\n\u0010\u0014\u001a\u00060\u0002R\u00020\u00002\u0006\u0010\u0015\u001a\u00020\u0012H\u0016J\u001c\u0010\u0016\u001a\u00060\u0002R\u00020\u00002\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u0012H\u0016J\u000e\u0010\u001a\u001a\u00020\b2\u0006\u0010\u000f\u001a\u00020\u0005J\u001b\u0010\u001b\u001a\u00020\b2\f\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004H\u0000¢\u0006\u0002\b\u001dR&\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\b0\u0007X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u000e¢\u0006\u0002\n\u0000¨\u0006\u001f"}, mo26107d2 = {"Lcom/getstream/sdk/chat/adapter/MediaAttachmentSelectedAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/getstream/sdk/chat/adapter/MediaAttachmentSelectedAdapter$MyViewHolder;", "selectedAttachments", "", "Lcom/getstream/sdk/chat/model/AttachmentMetaData;", "cancelListener", "Lkotlin/Function1;", "", "(Ljava/util/List;Lkotlin/jvm/functions/Function1;)V", "getCancelListener", "()Lkotlin/jvm/functions/Function1;", "setCancelListener", "(Lkotlin/jvm/functions/Function1;)V", "addAttachment", "attachment", "clear", "getItemCount", "", "onBindViewHolder", "holder", "position", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "removeAttachment", "setAttachments", "attachments", "setAttachments$stream_chat_android_release", "MyViewHolder", "stream-chat-android_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
/* compiled from: MediaAttachmentSelectedAdapter.kt */
public final class MediaAttachmentSelectedAdapter extends RecyclerView.Adapter<MyViewHolder> {
    private Function1<? super AttachmentMetaData, Unit> cancelListener;
    private List<AttachmentMetaData> selectedAttachments;

    public MediaAttachmentSelectedAdapter() {
        this((List) null, (Function1) null, 3, (DefaultConstructorMarker) null);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ MediaAttachmentSelectedAdapter(List list, Function1 function1, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? CollectionsKt.emptyList() : list, (i & 2) != 0 ? C17031.INSTANCE : function1);
    }

    public final Function1<AttachmentMetaData, Unit> getCancelListener() {
        return this.cancelListener;
    }

    public final void setCancelListener(Function1<? super AttachmentMetaData, Unit> function1) {
        Intrinsics.checkNotNullParameter(function1, "<set-?>");
        this.cancelListener = function1;
    }

    public MediaAttachmentSelectedAdapter(List<AttachmentMetaData> list, Function1<? super AttachmentMetaData, Unit> function1) {
        Intrinsics.checkNotNullParameter(list, "selectedAttachments");
        Intrinsics.checkNotNullParameter(function1, "cancelListener");
        this.selectedAttachments = list;
        this.cancelListener = function1;
    }

    public MyViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        Intrinsics.checkNotNullParameter(viewGroup, "parent");
        StreamItemAttachedMediaBinding inflate = StreamItemAttachedMediaBinding.inflate(LayoutInflater.from(viewGroup.getContext()), viewGroup, false);
        Intrinsics.checkNotNullExpressionValue(inflate, "StreamItemAttachedMediaB…tInflater, parent, false)");
        return new MyViewHolder(this, inflate);
    }

    public void onBindViewHolder(MyViewHolder myViewHolder, int i) {
        Intrinsics.checkNotNullParameter(myViewHolder, "holder");
        myViewHolder.bind(this.selectedAttachments.get(i), this.cancelListener);
    }

    public int getItemCount() {
        return this.selectedAttachments.size();
    }

    public final void setAttachments$stream_chat_android_release(List<AttachmentMetaData> list) {
        Intrinsics.checkNotNullParameter(list, "attachments");
        this.selectedAttachments = list;
        notifyDataSetChanged();
    }

    public final void removeAttachment(AttachmentMetaData attachmentMetaData) {
        Intrinsics.checkNotNullParameter(attachmentMetaData, MessengerShareContentUtility.ATTACHMENT);
        int indexOf = this.selectedAttachments.indexOf(attachmentMetaData);
        this.selectedAttachments = CollectionsKt.minus(this.selectedAttachments, attachmentMetaData);
        if (indexOf != -1) {
            notifyItemRemoved(indexOf);
        } else {
            notifyDataSetChanged();
        }
    }

    public final void addAttachment(AttachmentMetaData attachmentMetaData) {
        Intrinsics.checkNotNullParameter(attachmentMetaData, MessengerShareContentUtility.ATTACHMENT);
        List<AttachmentMetaData> plus = CollectionsKt.plus(this.selectedAttachments, attachmentMetaData);
        this.selectedAttachments = plus;
        notifyItemInserted(CollectionsKt.getLastIndex(plus));
    }

    public final void clear() {
        this.selectedAttachments = CollectionsKt.emptyList();
        notifyDataSetChanged();
    }

    @Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\"\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0012\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u00060\nR\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000¨\u0006\u000b"}, mo26107d2 = {"Lcom/getstream/sdk/chat/adapter/MediaAttachmentSelectedAdapter$MyViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "binding", "Lcom/getstream/sdk/chat/databinding/StreamItemAttachedMediaBinding;", "(Lcom/getstream/sdk/chat/adapter/MediaAttachmentSelectedAdapter;Lcom/getstream/sdk/chat/databinding/StreamItemAttachedMediaBinding;)V", "bind", "", "attachment", "Lcom/getstream/sdk/chat/model/AttachmentMetaData;", "cancelListener", "Lkotlin/Function1;", "stream-chat-android_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
    /* compiled from: MediaAttachmentSelectedAdapter.kt */
    public final class MyViewHolder extends RecyclerView.ViewHolder {
        private final StreamItemAttachedMediaBinding binding;
        final /* synthetic */ MediaAttachmentSelectedAdapter this$0;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public MyViewHolder(MediaAttachmentSelectedAdapter mediaAttachmentSelectedAdapter, StreamItemAttachedMediaBinding streamItemAttachedMediaBinding) {
            super(streamItemAttachedMediaBinding.getRoot());
            Intrinsics.checkNotNullParameter(streamItemAttachedMediaBinding, "binding");
            this.this$0 = mediaAttachmentSelectedAdapter;
            this.binding = streamItemAttachedMediaBinding;
        }

        public final void bind(AttachmentMetaData attachmentMetaData, Function1<? super AttachmentMetaData, Unit> function1) {
            Intrinsics.checkNotNullParameter(attachmentMetaData, MessengerShareContentUtility.ATTACHMENT);
            Intrinsics.checkNotNullParameter(function1, "cancelListener");
            View view = this.itemView;
            Intrinsics.checkNotNullExpressionValue(view, "itemView");
            Context context = view.getContext();
            Intrinsics.checkNotNullExpressionValue(context, "itemView.context");
            int dimensionPixelSize = context.getResources().getDimensionPixelSize(C1673R.dimen.stream_input_upload_media_radius);
            PorterShapeImageView porterShapeImageView = this.binding.ivMedia;
            View view2 = this.itemView;
            Intrinsics.checkNotNullExpressionValue(view2, "itemView");
            porterShapeImageView.setShape(view2.getContext(), new DrawableBuilder().rectangle().solidColor(-16777216).cornerRadii(dimensionPixelSize, dimensionPixelSize, dimensionPixelSize, dimensionPixelSize).build());
            if (Intrinsics.areEqual((Object) attachmentMetaData.getType(), (Object) "video")) {
                PorterShapeImageView porterShapeImageView2 = this.binding.ivMedia;
                Intrinsics.checkNotNullExpressionValue(porterShapeImageView2, "binding.ivMedia");
                ViewExtensionsKt.loadVideoThumbnail$default(porterShapeImageView2, attachmentMetaData.getUri(), Integer.valueOf(C1673R.C1676drawable.stream_placeholder), (StreamImageLoader.ImageTransformation) null, (Function0) null, (Function0) null, 28, (Object) null);
            } else {
                PorterShapeImageView porterShapeImageView3 = this.binding.ivMedia;
                Intrinsics.checkNotNullExpressionValue(porterShapeImageView3, "binding.ivMedia");
                ViewExtensionsKt.load$default(porterShapeImageView3, attachmentMetaData.getUri(), Integer.valueOf(C1673R.C1676drawable.stream_placeholder), (StreamImageLoader.ImageTransformation) null, (Function0) null, (Function0) null, 28, (Object) null);
            }
            if (Intrinsics.areEqual((Object) "video", (Object) attachmentMetaData.getType())) {
                TextView textView = this.binding.tvLength;
                Intrinsics.checkNotNullExpressionValue(textView, "binding.tvLength");
                textView.setText(MediaStringUtil.convertVideoLength(attachmentMetaData.getVideoLength()));
            } else {
                TextView textView2 = this.binding.tvLength;
                Intrinsics.checkNotNullExpressionValue(textView2, "binding.tvLength");
                textView2.setText("");
            }
            this.binding.btnClose.setOnClickListener(new MediaAttachmentSelectedAdapter$MyViewHolder$bind$1(function1, attachmentMetaData));
            ImageView imageView = this.binding.ivMask;
            Intrinsics.checkNotNullExpressionValue(imageView, "binding.ivMask");
            imageView.setVisibility(4);
            ProgressBar progressBar = this.binding.progressBar;
            Intrinsics.checkNotNullExpressionValue(progressBar, "binding.progressBar");
            progressBar.setVisibility(4);
        }
    }
}
