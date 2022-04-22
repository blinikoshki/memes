package com.getstream.sdk.chat.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import com.getstream.sdk.chat.C1673R;
import com.getstream.sdk.chat.databinding.StreamItemAttachFileBinding;
import com.getstream.sdk.chat.model.AttachmentMetaData;
import com.getstream.sdk.chat.utils.MediaStringUtil;
import com.getstream.sdk.chat.utils.UiUtils;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0000\u0018\u00002\u00020\u0001B1\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0014\b\u0002\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\t0\b¢\u0006\u0002\u0010\nJ\u0006\u0010\u000f\u001a\u00020\tJ\u0018\u0010\u0010\u001a\u00020\t2\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0004H\u0002J\b\u0010\u0014\u001a\u00020\u0015H\u0016J\u0010\u0010\u0016\u001a\u00020\u00042\u0006\u0010\u0017\u001a\u00020\u0015H\u0016J\u0010\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u0017\u001a\u00020\u0015H\u0016J\"\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u0017\u001a\u00020\u00152\b\u0010\u001c\u001a\u0004\u0018\u00010\u001b2\u0006\u0010\u001d\u001a\u00020\u001eH\u0016J\u0014\u0010\u001f\u001a\u00020\t2\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003R\u0014\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003X\u000e¢\u0006\u0002\n\u0000R&\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\t0\bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u000e\u0010\u0005\u001a\u00020\u0006X\u0004¢\u0006\u0002\n\u0000¨\u0006 "}, mo26107d2 = {"Lcom/getstream/sdk/chat/adapter/FileAttachmentSelectedAdapter;", "Landroid/widget/BaseAdapter;", "attachments", "", "Lcom/getstream/sdk/chat/model/AttachmentMetaData;", "localAttach", "", "cancelListener", "Lkotlin/Function1;", "", "(Ljava/util/List;ZLkotlin/jvm/functions/Function1;)V", "getCancelListener", "()Lkotlin/jvm/functions/Function1;", "setCancelListener", "(Lkotlin/jvm/functions/Function1;)V", "clear", "configureFileAttach", "binding", "Lcom/getstream/sdk/chat/databinding/StreamItemAttachFileBinding;", "attachment", "getCount", "", "getItem", "position", "getItemId", "", "getView", "Landroid/view/View;", "convertView", "parent", "Landroid/view/ViewGroup;", "setAttachments", "stream-chat-android_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
/* compiled from: FileAttachmentSelectedAdapter.kt */
public final class FileAttachmentSelectedAdapter extends BaseAdapter {
    private List<AttachmentMetaData> attachments;
    private Function1<? super AttachmentMetaData, Unit> cancelListener;
    private final boolean localAttach;

    public long getItemId(int i) {
        return (long) i;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ FileAttachmentSelectedAdapter(List list, boolean z, Function1 function1, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(list, z, (i & 4) != 0 ? C16851.INSTANCE : function1);
    }

    public final Function1<AttachmentMetaData, Unit> getCancelListener() {
        return this.cancelListener;
    }

    public final void setCancelListener(Function1<? super AttachmentMetaData, Unit> function1) {
        Intrinsics.checkNotNullParameter(function1, "<set-?>");
        this.cancelListener = function1;
    }

    public FileAttachmentSelectedAdapter(List<AttachmentMetaData> list, boolean z, Function1<? super AttachmentMetaData, Unit> function1) {
        Intrinsics.checkNotNullParameter(list, "attachments");
        Intrinsics.checkNotNullParameter(function1, "cancelListener");
        this.attachments = list;
        this.localAttach = z;
        this.cancelListener = function1;
    }

    public int getCount() {
        return this.attachments.size();
    }

    public AttachmentMetaData getItem(int i) {
        return this.attachments.get(i);
    }

    public View getView(int i, View view, ViewGroup viewGroup) {
        Intrinsics.checkNotNullParameter(viewGroup, "parent");
        if (view == null) {
            view = LayoutInflater.from(viewGroup.getContext()).inflate(C1673R.C1679layout.stream_item_attach_file, viewGroup, false);
        }
        StreamItemAttachFileBinding bind = StreamItemAttachFileBinding.bind(view);
        Intrinsics.checkNotNullExpressionValue(bind, "StreamItemAttachFileBinding.bind(view)");
        configureFileAttach(bind, this.attachments.get(i));
        Intrinsics.checkNotNullExpressionValue(view, ViewHierarchyConstants.VIEW_KEY);
        return view;
    }

    private final void configureFileAttach(StreamItemAttachFileBinding streamItemAttachFileBinding, AttachmentMetaData attachmentMetaData) {
        streamItemAttachFileBinding.ivFileThumb.setImageResource(UiUtils.INSTANCE.getIcon(attachmentMetaData.getMimeType()));
        TextView textView = streamItemAttachFileBinding.tvFileTitle;
        Intrinsics.checkNotNullExpressionValue(textView, "binding.tvFileTitle");
        textView.setText(attachmentMetaData.getTitle());
        ImageView imageView = streamItemAttachFileBinding.ivLargeFileMark;
        Intrinsics.checkNotNullExpressionValue(imageView, "binding.ivLargeFileMark");
        imageView.setVisibility(4);
        ImageView imageView2 = streamItemAttachFileBinding.ivSelectMark;
        Intrinsics.checkNotNullExpressionValue(imageView2, "binding.ivSelectMark");
        imageView2.setVisibility(8);
        ImageView imageView3 = streamItemAttachFileBinding.ivClose;
        Intrinsics.checkNotNullExpressionValue(imageView3, "binding.ivClose");
        imageView3.setVisibility(4);
        ProgressBar progressBar = streamItemAttachFileBinding.progressBar;
        Intrinsics.checkNotNullExpressionValue(progressBar, "binding.progressBar");
        progressBar.setVisibility(8);
        TextView textView2 = streamItemAttachFileBinding.tvFileSize;
        Intrinsics.checkNotNullExpressionValue(textView2, "binding.tvFileSize");
        textView2.setText(MediaStringUtil.convertFileSizeByteCount(attachmentMetaData.getSize()));
        if (this.localAttach) {
            ImageView imageView4 = streamItemAttachFileBinding.ivClose;
            Intrinsics.checkNotNullExpressionValue(imageView4, "binding.ivClose");
            imageView4.setVisibility(0);
            streamItemAttachFileBinding.ivClose.setOnClickListener(new FileAttachmentSelectedAdapter$configureFileAttach$1(this, attachmentMetaData));
        }
    }

    public final void setAttachments(List<AttachmentMetaData> list) {
        Intrinsics.checkNotNullParameter(list, "attachments");
        this.attachments = list;
        notifyDataSetChanged();
    }

    public final void clear() {
        this.attachments = CollectionsKt.emptyList();
        notifyDataSetChanged();
    }
}
