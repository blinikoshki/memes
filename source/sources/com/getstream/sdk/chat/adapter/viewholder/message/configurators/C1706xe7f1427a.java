package com.getstream.sdk.chat.adapter.viewholder.message.configurators;

import android.view.View;
import com.getstream.sdk.chat.adapter.MessageListItem;
import java.util.List;
import kotlin.Metadata;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005¨\u0006\u0006"}, mo26107d2 = {"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick", "com/getstream/sdk/chat/adapter/viewholder/message/configurators/IndicatorConfigurator$configReadIndicator$1$1"}, mo26108k = 3, mo26109mv = {1, 4, 2})
/* renamed from: com.getstream.sdk.chat.adapter.viewholder.message.configurators.IndicatorConfigurator$configReadIndicator$$inlined$apply$lambda$1 */
/* compiled from: IndicatorConfigurator.kt */
final class C1706xe7f1427a implements View.OnClickListener {
    final /* synthetic */ MessageListItem.MessageItem $messageItem$inlined;
    final /* synthetic */ List $readBy$inlined;
    final /* synthetic */ IndicatorConfigurator this$0;

    C1706xe7f1427a(IndicatorConfigurator indicatorConfigurator, List list, MessageListItem.MessageItem messageItem) {
        this.this$0 = indicatorConfigurator;
        this.$readBy$inlined = list;
        this.$messageItem$inlined = messageItem;
    }

    public final void onClick(View view) {
        this.this$0.readStateClickListener.onReadStateClick(this.$readBy$inlined);
    }
}
