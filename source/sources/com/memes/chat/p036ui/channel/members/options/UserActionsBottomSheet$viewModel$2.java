package com.memes.chat.p036ui.channel.members.options;

import android.content.Context;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStoreOwner;
import com.memes.chat.p035db.ChatDatabaseManager;
import com.memes.commons.viewmodel.BaseViewModelFactory;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import p015io.getstream.chat.android.client.ChatClient;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, mo26107d2 = {"<anonymous>", "Lcom/memes/chat/ui/channel/members/options/UserActionsViewModel;", "invoke"}, mo26108k = 3, mo26109mv = {1, 4, 2})
/* renamed from: com.memes.chat.ui.channel.members.options.UserActionsBottomSheet$viewModel$2 */
/* compiled from: UserActionsBottomSheet.kt */
final class UserActionsBottomSheet$viewModel$2 extends Lambda implements Function0<UserActionsViewModel> {
    final /* synthetic */ UserActionsBottomSheet this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    UserActionsBottomSheet$viewModel$2(UserActionsBottomSheet userActionsBottomSheet) {
        super(0);
        this.this$0 = userActionsBottomSheet;
    }

    public final UserActionsViewModel invoke() {
        FragmentActivity requireActivity = this.this$0.requireActivity();
        Intrinsics.checkNotNullExpressionValue(requireActivity, "requireActivity()");
        ViewModel viewModel = new ViewModelProvider((ViewModelStoreOwner) requireActivity, (ViewModelProvider.Factory) new BaseViewModelFactory(new Function0<UserActionsViewModel>(this) {
            final /* synthetic */ UserActionsBottomSheet$viewModel$2 this$0;

            {
                this.this$0 = r1;
            }

            public final UserActionsViewModel invoke() {
                ChatClient instance = ChatClient.Companion.instance();
                ChatDatabaseManager chatDatabaseManager = ChatDatabaseManager.INSTANCE;
                Context requireContext = this.this$0.this$0.requireContext();
                Intrinsics.checkNotNullExpressionValue(requireContext, "requireContext()");
                return new UserActionsViewModel(instance, chatDatabaseManager.mo56374db(requireContext));
            }
        })).get(UserActionsViewModel.class);
        Intrinsics.checkNotNullExpressionValue(viewModel, "ViewModelProvider(this, …ator)).get(T::class.java)");
        return (UserActionsViewModel) viewModel;
    }
}
