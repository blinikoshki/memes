package com.memes.plus.p040ui.home;

import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStoreOwner;
import com.memes.chat.events.viewmodel.ChatEventsViewModel;
import com.memes.commons.viewmodel.BaseViewModelFactory;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, mo26107d2 = {"<anonymous>", "Lcom/memes/chat/events/viewmodel/ChatEventsViewModel;", "invoke"}, mo26108k = 3, mo26109mv = {1, 4, 2})
/* renamed from: com.memes.plus.ui.home.HomeActivity$chatEventsViewModel$2 */
/* compiled from: HomeActivity.kt */
final class HomeActivity$chatEventsViewModel$2 extends Lambda implements Function0<ChatEventsViewModel> {
    final /* synthetic */ HomeActivity this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    HomeActivity$chatEventsViewModel$2(HomeActivity homeActivity) {
        super(0);
        this.this$0 = homeActivity;
    }

    public final ChatEventsViewModel invoke() {
        ViewModel viewModel;
        HomeActivity homeActivity = this.this$0;
        Function0 function0 = C42661.INSTANCE;
        if (function0 == null) {
            viewModel = new ViewModelProvider(homeActivity).get(ChatEventsViewModel.class);
            Intrinsics.checkNotNullExpressionValue(viewModel, "ViewModelProvider(this).get(T::class.java)");
        } else {
            viewModel = new ViewModelProvider((ViewModelStoreOwner) homeActivity, (ViewModelProvider.Factory) new BaseViewModelFactory(function0)).get(ChatEventsViewModel.class);
            Intrinsics.checkNotNullExpressionValue(viewModel, "ViewModelProvider(this, …ator)).get(T::class.java)");
        }
        return (ChatEventsViewModel) viewModel;
    }
}
