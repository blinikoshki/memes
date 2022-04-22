package com.getstream.sdk.chat.adapter.viewholder.message;

import android.text.format.DateUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.ContextCompat;
import com.getstream.sdk.chat.adapter.MessageListItem;
import com.getstream.sdk.chat.adapter.MessageListItemPayloadDiff;
import com.getstream.sdk.chat.databinding.StreamItemDateSeparatorBinding;
import com.getstream.sdk.chat.enums.Dates;
import com.getstream.sdk.chat.enums.DatesKt;
import com.getstream.sdk.chat.style.TextStyle;
import com.getstream.sdk.chat.view.MessageListViewStyle;
import java.util.Date;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\b\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u001f\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b¢\u0006\u0002\u0010\tJ\b\u0010\n\u001a\u00020\u000bH\u0002J\u0018\u0010\f\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\u00022\u0006\u0010\u000e\u001a\u00020\u000fH\u0014J\u0010\u0010\u0010\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\u0002H\u0002J\u0010\u0010\u0011\u001a\u00020\u000b2\u0006\u0010\u0012\u001a\u00020\u0013H\u0002R\u000e\u0010\u0007\u001a\u00020\bX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0014"}, mo26107d2 = {"Lcom/getstream/sdk/chat/adapter/viewholder/message/DateSeparatorViewHolder;", "Lcom/getstream/sdk/chat/adapter/viewholder/message/BaseMessageListItemViewHolder;", "Lcom/getstream/sdk/chat/adapter/MessageListItem$DateSeparatorItem;", "parent", "Landroid/view/ViewGroup;", "style", "Lcom/getstream/sdk/chat/view/MessageListViewStyle;", "binding", "Lcom/getstream/sdk/chat/databinding/StreamItemDateSeparatorBinding;", "(Landroid/view/ViewGroup;Lcom/getstream/sdk/chat/view/MessageListViewStyle;Lcom/getstream/sdk/chat/databinding/StreamItemDateSeparatorBinding;)V", "applyStyle", "", "bind", "messageListItem", "diff", "Lcom/getstream/sdk/chat/adapter/MessageListItemPayloadDiff;", "configDate", "configSeparatorLineWidth", "view", "Landroid/view/View;", "stream-chat-android_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
/* compiled from: DateSeparatorViewHolder.kt */
public final class DateSeparatorViewHolder extends BaseMessageListItemViewHolder<MessageListItem.DateSeparatorItem> {
    private final StreamItemDateSeparatorBinding binding;
    private final MessageListViewStyle style;

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public DateSeparatorViewHolder(android.view.ViewGroup r2, com.getstream.sdk.chat.view.MessageListViewStyle r3, com.getstream.sdk.chat.databinding.StreamItemDateSeparatorBinding r4) {
        /*
            r1 = this;
            java.lang.String r0 = "parent"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r2, r0)
            java.lang.String r2 = "style"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r3, r2)
            java.lang.String r2 = "binding"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r4, r2)
            androidx.constraintlayout.widget.ConstraintLayout r2 = r4.getRoot()
            java.lang.String r0 = "binding.root"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r2, r0)
            android.view.View r2 = (android.view.View) r2
            r1.<init>(r2)
            r1.style = r3
            r1.binding = r4
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.getstream.sdk.chat.adapter.viewholder.message.DateSeparatorViewHolder.<init>(android.view.ViewGroup, com.getstream.sdk.chat.view.MessageListViewStyle, com.getstream.sdk.chat.databinding.StreamItemDateSeparatorBinding):void");
    }

    /* access modifiers changed from: protected */
    public void bind(MessageListItem.DateSeparatorItem dateSeparatorItem, MessageListItemPayloadDiff messageListItemPayloadDiff) {
        Intrinsics.checkNotNullParameter(dateSeparatorItem, "messageListItem");
        Intrinsics.checkNotNullParameter(messageListItemPayloadDiff, "diff");
        configDate(dateSeparatorItem);
        applyStyle();
    }

    private final void configDate(MessageListItem.DateSeparatorItem dateSeparatorItem) {
        CharSequence charSequence;
        long time = dateSeparatorItem.getDate().getTime();
        if (new Date().getTime() - time < ((long) 60000)) {
            charSequence = DatesKt.getLabel(Dates.JUST_NOW);
        } else {
            charSequence = DateUtils.getRelativeTimeSpanString(time);
        }
        TextView textView = this.binding.tvDate;
        Intrinsics.checkNotNullExpressionValue(textView, "binding.tvDate");
        textView.setText(charSequence);
    }

    private final void applyStyle() {
        TextStyle dateSeparatorDateText = this.style.getDateSeparatorDateText();
        TextView textView = this.binding.tvDate;
        Intrinsics.checkNotNullExpressionValue(textView, "binding.tvDate");
        dateSeparatorDateText.apply(textView);
        if (this.style.getDateSeparatorLineDrawable() != -1) {
            int dateSeparatorLineDrawable = this.style.getDateSeparatorLineDrawable();
            ImageView imageView = this.binding.ivLineRight;
            Intrinsics.checkNotNullExpressionValue(imageView, "binding.ivLineRight");
            imageView.setBackground(ContextCompat.getDrawable(getContext(), dateSeparatorLineDrawable));
            ImageView imageView2 = this.binding.ivLineLeft;
            Intrinsics.checkNotNullExpressionValue(imageView2, "binding.ivLineLeft");
            imageView2.setBackground(ContextCompat.getDrawable(getContext(), dateSeparatorLineDrawable));
        } else {
            this.binding.ivLineRight.setBackgroundColor(this.style.getDateSeparatorLineColor());
            this.binding.ivLineLeft.setBackgroundColor(this.style.getDateSeparatorLineColor());
        }
        ImageView imageView3 = this.binding.ivLineRight;
        Intrinsics.checkNotNullExpressionValue(imageView3, "binding.ivLineRight");
        configSeparatorLineWidth(imageView3);
        ImageView imageView4 = this.binding.ivLineLeft;
        Intrinsics.checkNotNullExpressionValue(imageView4, "binding.ivLineLeft");
        configSeparatorLineWidth(imageView4);
    }

    private final void configSeparatorLineWidth(View view) {
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        Objects.requireNonNull(layoutParams, "null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
        ViewGroup.LayoutParams layoutParams2 = (ConstraintLayout.LayoutParams) layoutParams;
        ((ConstraintLayout.LayoutParams) layoutParams2).height = this.style.getDateSeparatorLineWidth();
        view.setLayoutParams(layoutParams2);
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ DateSeparatorViewHolder(android.view.ViewGroup r1, com.getstream.sdk.chat.view.MessageListViewStyle r2, com.getstream.sdk.chat.databinding.StreamItemDateSeparatorBinding r3, int r4, kotlin.jvm.internal.DefaultConstructorMarker r5) {
        /*
            r0 = this;
            r4 = r4 & 4
            if (r4 == 0) goto L_0x001b
            android.content.Context r3 = r1.getContext()
            android.view.LayoutInflater r3 = android.view.LayoutInflater.from(r3)
            java.lang.String r4 = "LayoutInflater.from(context)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r3, r4)
            r4 = 0
            com.getstream.sdk.chat.databinding.StreamItemDateSeparatorBinding r3 = com.getstream.sdk.chat.databinding.StreamItemDateSeparatorBinding.inflate(r3, r1, r4)
            java.lang.String r4 = "StreamItemDateSeparatorB….inflater, parent, false)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r3, r4)
        L_0x001b:
            r0.<init>(r1, r2, r3)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.getstream.sdk.chat.adapter.viewholder.message.DateSeparatorViewHolder.<init>(android.view.ViewGroup, com.getstream.sdk.chat.view.MessageListViewStyle, com.getstream.sdk.chat.databinding.StreamItemDateSeparatorBinding, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }
}
