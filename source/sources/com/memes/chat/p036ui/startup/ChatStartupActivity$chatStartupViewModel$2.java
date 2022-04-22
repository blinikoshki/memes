package com.memes.chat.p036ui.startup;

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

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, mo26107d2 = {"<anonymous>", "Lcom/memes/chat/ui/startup/ChatStartupViewModel;", "invoke"}, mo26108k = 3, mo26109mv = {1, 4, 2})
/* renamed from: com.memes.chat.ui.startup.ChatStartupActivity$chatStartupViewModel$2 */
/* compiled from: ChatStartupActivity.kt */
final class ChatStartupActivity$chatStartupViewModel$2 extends Lambda implements Function0<ChatStartupViewModel> {
    final /* synthetic */ ChatStartupActivity this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    ChatStartupActivity$chatStartupViewModel$2(ChatStartupActivity chatStartupActivity) {
        super(0);
        this.this$0 = chatStartupActivity;
    }

    public final ChatStartupViewModel invoke() {
        ViewModel viewModel = new ViewModelProvider((ViewModelStoreOwner) this.this$0, (ViewModelProvider.Factory) new BaseViewModelFactory(new Function0<ChatStartupViewModel>(this) {
            final /* synthetic */ ChatStartupActivity$chatStartupViewModel$2 this$0;

            {
                this.this$0 = r1;
            }

            public final ChatStartupViewModel invoke() {
                return new ChatStartupViewModel(ChatClient.Companion.instance(), ChatDatabaseManager.INSTANCE.mo56374db(this.this$0.this$0), new ChatCredentialsSharedPref(this.this$0.this$0));
            }
        })).get(ChatStartupViewModel.class);
        Intrinsics.checkNotNullExpressionValue(viewModel, "ViewModelProvider(this, …ator)).get(T::class.java)");
        return (ChatStartupViewModel) viewModel;
    }
}
