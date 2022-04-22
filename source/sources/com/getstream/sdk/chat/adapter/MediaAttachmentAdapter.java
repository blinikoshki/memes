package com.getstream.sdk.chat.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.recyclerview.widget.RecyclerView;
import com.facebook.share.internal.MessengerShareContentUtility;
import com.getstream.sdk.chat.C1673R;
import com.getstream.sdk.chat.databinding.StreamItemSelectPhotoBinding;
import com.getstream.sdk.chat.images.StreamImageLoader;
import com.getstream.sdk.chat.images.ViewExtensionsKt;
import com.getstream.sdk.chat.model.AttachmentMetaData;
import com.getstream.sdk.chat.utils.AttachmentConstants;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0003\b\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\"B:\u0012\u000e\b\u0002\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004\u0012#\b\u0002\u0010\u0006\u001a\u001d\u0012\u0013\u0012\u00110\u0005¢\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\n\u0012\u0004\u0012\u00020\u000b0\u0007¢\u0006\u0002\u0010\fJ\u0006\u0010\u0011\u001a\u00020\u000bJ\b\u0010\u0012\u001a\u00020\u0013H\u0016J\u0018\u0010\u0014\u001a\u00020\u000b2\u0006\u0010\u0015\u001a\u00020\u00022\u0006\u0010\u0016\u001a\u00020\u0013H\u0016J\u0018\u0010\u0017\u001a\u00020\u00022\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u0013H\u0016J\u000e\u0010\u001b\u001a\u00020\u000b2\u0006\u0010\u001c\u001a\u00020\u0005J\u0014\u0010\u001d\u001a\u00020\u000b2\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004J\u0018\u0010\u001e\u001a\u00020\u000b2\u0006\u0010\u001c\u001a\u00020\u00052\u0006\u0010\u001f\u001a\u00020 H\u0002J\u000e\u0010!\u001a\u00020\u000b2\u0006\u0010\u001c\u001a\u00020\u0005R\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u000e¢\u0006\u0002\n\u0000R5\u0010\u0006\u001a\u001d\u0012\u0013\u0012\u00110\u0005¢\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\n\u0012\u0004\u0012\u00020\u000b0\u0007X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010¨\u0006#"}, mo26107d2 = {"Lcom/getstream/sdk/chat/adapter/MediaAttachmentAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/getstream/sdk/chat/adapter/MediaAttachmentAdapter$MyViewHolder;", "attachments", "", "Lcom/getstream/sdk/chat/model/AttachmentMetaData;", "listener", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "attachmentMetaData", "", "(Ljava/util/List;Lkotlin/jvm/functions/Function1;)V", "getListener", "()Lkotlin/jvm/functions/Function1;", "setListener", "(Lkotlin/jvm/functions/Function1;)V", "clear", "getItemCount", "", "onBindViewHolder", "holder", "position", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "selectAttachment", "attachment", "setAttachments", "toggleSelection", "isSelected", "", "unselectAttachment", "MyViewHolder", "stream-chat-android_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
/* compiled from: MediaAttachmentAdapter.kt */
public final class MediaAttachmentAdapter extends RecyclerView.Adapter<MyViewHolder> {
    private List<AttachmentMetaData> attachments;
    private Function1<? super AttachmentMetaData, Unit> listener;

    public MediaAttachmentAdapter() {
        this((List) null, (Function1) null, 3, (DefaultConstructorMarker) null);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ MediaAttachmentAdapter(List list, Function1 function1, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? CollectionsKt.emptyList() : list, (i & 2) != 0 ? C17021.INSTANCE : function1);
    }

    public final Function1<AttachmentMetaData, Unit> getListener() {
        return this.listener;
    }

    public final void setListener(Function1<? super AttachmentMetaData, Unit> function1) {
        Intrinsics.checkNotNullParameter(function1, "<set-?>");
        this.listener = function1;
    }

    public MediaAttachmentAdapter(List<AttachmentMetaData> list, Function1<? super AttachmentMetaData, Unit> function1) {
        Intrinsics.checkNotNullParameter(list, "attachments");
        Intrinsics.checkNotNullParameter(function1, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
        this.attachments = list;
        this.listener = function1;
    }

    public MyViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        Intrinsics.checkNotNullParameter(viewGroup, "parent");
        StreamItemSelectPhotoBinding inflate = StreamItemSelectPhotoBinding.inflate(LayoutInflater.from(viewGroup.getContext()), viewGroup, false);
        Intrinsics.checkNotNullExpressionValue(inflate, "StreamItemSelectPhotoBin…      false\n            )");
        return new MyViewHolder(inflate, this.listener);
    }

    public void onBindViewHolder(MyViewHolder myViewHolder, int i) {
        Intrinsics.checkNotNullParameter(myViewHolder, "holder");
        myViewHolder.bind(this.attachments.get(i));
    }

    public int getItemCount() {
        return this.attachments.size();
    }

    public final void setAttachments(List<AttachmentMetaData> list) {
        Intrinsics.checkNotNullParameter(list, "attachments");
        this.attachments = list;
        notifyDataSetChanged();
    }

    public final void selectAttachment(AttachmentMetaData attachmentMetaData) {
        Intrinsics.checkNotNullParameter(attachmentMetaData, MessengerShareContentUtility.ATTACHMENT);
        toggleSelection(attachmentMetaData, true);
    }

    public final void unselectAttachment(AttachmentMetaData attachmentMetaData) {
        Intrinsics.checkNotNullParameter(attachmentMetaData, MessengerShareContentUtility.ATTACHMENT);
        toggleSelection(attachmentMetaData, false);
    }

    private final void toggleSelection(AttachmentMetaData attachmentMetaData, boolean z) {
        int indexOf = this.attachments.indexOf(attachmentMetaData);
        if (indexOf != -1) {
            this.attachments.get(indexOf).setSelected(z);
            notifyItemChanged(indexOf);
        }
    }

    public final void clear() {
        this.attachments = CollectionsKt.emptyList();
        notifyDataSetChanged();
    }

    @Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B0\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012!\u0010\u0004\u001a\u001d\u0012\u0013\u0012\u00110\u0006¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\t\u0012\u0004\u0012\u00020\n0\u0005¢\u0006\u0002\u0010\u000bJ\u000e\u0010\f\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\u0006R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R)\u0010\u0004\u001a\u001d\u0012\u0013\u0012\u00110\u0006¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\t\u0012\u0004\u0012\u00020\n0\u0005X\u0004¢\u0006\u0002\n\u0000¨\u0006\u000e"}, mo26107d2 = {"Lcom/getstream/sdk/chat/adapter/MediaAttachmentAdapter$MyViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "binding", "Lcom/getstream/sdk/chat/databinding/StreamItemSelectPhotoBinding;", "listener", "Lkotlin/Function1;", "Lcom/getstream/sdk/chat/model/AttachmentMetaData;", "Lkotlin/ParameterName;", "name", "attachmentMetaData", "", "(Lcom/getstream/sdk/chat/databinding/StreamItemSelectPhotoBinding;Lkotlin/jvm/functions/Function1;)V", "bind", "attachment", "stream-chat-android_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
    /* compiled from: MediaAttachmentAdapter.kt */
    public static final class MyViewHolder extends RecyclerView.ViewHolder {
        private final StreamItemSelectPhotoBinding binding;
        /* access modifiers changed from: private */
        public final Function1<AttachmentMetaData, Unit> listener;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public MyViewHolder(StreamItemSelectPhotoBinding streamItemSelectPhotoBinding, Function1<? super AttachmentMetaData, Unit> function1) {
            super(streamItemSelectPhotoBinding.getRoot());
            Intrinsics.checkNotNullParameter(streamItemSelectPhotoBinding, "binding");
            Intrinsics.checkNotNullParameter(function1, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
            this.binding = streamItemSelectPhotoBinding;
            this.listener = function1;
        }

        public final void bind(AttachmentMetaData attachmentMetaData) {
            Intrinsics.checkNotNullParameter(attachmentMetaData, MessengerShareContentUtility.ATTACHMENT);
            if (Intrinsics.areEqual((Object) attachmentMetaData.getType(), (Object) "video")) {
                ImageView imageView = this.binding.ivMedia;
                Intrinsics.checkNotNullExpressionValue(imageView, "binding.ivMedia");
                ViewExtensionsKt.loadVideoThumbnail$default(imageView, attachmentMetaData.getUri(), Integer.valueOf(C1673R.C1676drawable.stream_placeholder), (StreamImageLoader.ImageTransformation) null, (Function0) null, (Function0) null, 28, (Object) null);
            } else {
                ImageView imageView2 = this.binding.ivMedia;
                Intrinsics.checkNotNullExpressionValue(imageView2, "binding.ivMedia");
                ViewExtensionsKt.load$default(imageView2, attachmentMetaData.getUri(), Integer.valueOf(C1673R.C1676drawable.stream_placeholder), (StreamImageLoader.ImageTransformation) null, (Function0) null, (Function0) null, 28, (Object) null);
            }
            ImageView imageView3 = this.binding.ivSelectMark;
            Intrinsics.checkNotNullExpressionValue(imageView3, "binding.ivSelectMark");
            int i = 8;
            imageView3.setVisibility(attachmentMetaData.isSelected() ? 0 : 8);
            ImageView imageView4 = this.binding.ivLargeFileMark;
            Intrinsics.checkNotNullExpressionValue(imageView4, "binding.ivLargeFileMark");
            View view = imageView4;
            if (attachmentMetaData.getSize() > AttachmentConstants.MAX_UPLOAD_FILE_SIZE) {
                i = 0;
            }
            view.setVisibility(i);
            this.itemView.setOnClickListener(new MediaAttachmentAdapter$MyViewHolder$bind$1(this, attachmentMetaData));
        }
    }
}
