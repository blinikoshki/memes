package com.memes.chat.p036ui.channel.members.options;

import android.content.Context;
import android.view.View;
import com.memes.chat.routing.ChatRouting;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, mo26107d2 = {"<anonymous>", "Landroid/view/View$OnClickListener;", "invoke"}, mo26108k = 3, mo26109mv = {1, 4, 2})
/* renamed from: com.memes.chat.ui.channel.members.options.UserActionsBottomSheet$sendMessageClickListener$2 */
/* compiled from: UserActionsBottomSheet.kt */
final class UserActionsBottomSheet$sendMessageClickListener$2 extends Lambda implements Function0<View.OnClickListener> {
    final /* synthetic */ UserActionsBottomSheet this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    UserActionsBottomSheet$sendMessageClickListener$2(UserActionsBottomSheet userActionsBottomSheet) {
        super(0);
        this.this$0 = userActionsBottomSheet;
    }

    public final View.OnClickListener invoke() {
        return new View.OnClickListener(this) {
            final /* synthetic */ UserActionsBottomSheet$sendMessageClickListener$2 this$0;

            {
                this.this$0 = r1;
            }

            public final void onClick(View view) {
                ChatRouting chatRouting = ChatRouting.INSTANCE;
                Context requireContext = this.this$0.this$0.requireContext();
                Intrinsics.checkNotNullExpressionValue(requireContext, "requireContext()");
                this.this$0.this$0.startActivity(chatRouting.getDirectMessagingIntent(requireContext, UserActionsBottomSheet.access$getUser$p(this.this$0.this$0).getId()));
                this.this$0.this$0.dismiss();
            }
        };
    }
}
