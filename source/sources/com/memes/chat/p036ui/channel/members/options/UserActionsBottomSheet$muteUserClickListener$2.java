package com.memes.chat.p036ui.channel.members.options;

import android.content.Context;
import android.content.DialogInterface;
import android.view.View;
import com.memes.chat.C4059R;
import com.memes.chat.p036ui.custom.StyledAlertDialog;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, mo26107d2 = {"<anonymous>", "Landroid/view/View$OnClickListener;", "invoke"}, mo26108k = 3, mo26109mv = {1, 4, 2})
/* renamed from: com.memes.chat.ui.channel.members.options.UserActionsBottomSheet$muteUserClickListener$2 */
/* compiled from: UserActionsBottomSheet.kt */
final class UserActionsBottomSheet$muteUserClickListener$2 extends Lambda implements Function0<View.OnClickListener> {
    final /* synthetic */ UserActionsBottomSheet this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    UserActionsBottomSheet$muteUserClickListener$2(UserActionsBottomSheet userActionsBottomSheet) {
        super(0);
        this.this$0 = userActionsBottomSheet;
    }

    public final View.OnClickListener invoke() {
        return new View.OnClickListener(this) {
            final /* synthetic */ UserActionsBottomSheet$muteUserClickListener$2 this$0;

            {
                this.this$0 = r1;
            }

            public final void onClick(View view) {
                StyledAlertDialog styledAlertDialog = StyledAlertDialog.INSTANCE;
                Context requireContext = this.this$0.this$0.requireContext();
                Intrinsics.checkNotNullExpressionValue(requireContext, "requireContext()");
                styledAlertDialog.getDangerDialogBuilder(requireContext).setTitle(C4059R.string.chat_mute_user_title).setMessage(C4059R.string.chat_mute_user_msg).setPositiveButton(C4059R.string.chat_mute_user_positive_action, (DialogInterface.OnClickListener) new DialogInterface.OnClickListener(this) {
                    final /* synthetic */ C41221 this$0;

                    {
                        this.this$0 = r1;
                    }

                    public final void onClick(DialogInterface dialogInterface, int i) {
                        this.this$0.this$0.this$0.getViewModel().muteUser();
                        this.this$0.this$0.this$0.dismiss();
                    }
                }).setNegativeButton(C4059R.string.chat_mute_user_negative_action, (DialogInterface.OnClickListener) null).show();
            }
        };
    }
}
