package com.memes.chat.p036ui.channel.create.stages.memberselection;

import com.memes.chat.util.usecases.CheckUserExistenceUseCase;
import com.memes.network.memes.source.remote.model.usersearch.UserSearchResult;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import p015io.getstream.chat.android.client.models.User;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H@¢\u0006\u0004\b\u0003\u0010\u0004"}, mo26107d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;"}, mo26108k = 3, mo26109mv = {1, 4, 2})
@DebugMetadata(mo26807c = "com.memes.chat.ui.channel.create.stages.memberselection.ChooseChannelMembersViewModel$onUserSearchResultTapped$1", mo26808f = "ChooseChannelMembersViewModel.kt", mo26809i = {}, mo26810l = {215}, mo26811m = "invokeSuspend", mo26812n = {}, mo26813s = {})
/* renamed from: com.memes.chat.ui.channel.create.stages.memberselection.ChooseChannelMembersViewModel$onUserSearchResultTapped$1 */
/* compiled from: ChooseChannelMembersViewModel.kt */
final class ChooseChannelMembersViewModel$onUserSearchResultTapped$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $userId;
    final /* synthetic */ UserSearchResult $userSearchResult;
    int label;
    final /* synthetic */ ChooseChannelMembersViewModel this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    ChooseChannelMembersViewModel$onUserSearchResultTapped$1(ChooseChannelMembersViewModel chooseChannelMembersViewModel, UserSearchResult userSearchResult, String str, Continuation continuation) {
        super(2, continuation);
        this.this$0 = chooseChannelMembersViewModel;
        this.$userSearchResult = userSearchResult;
        this.$userId = str;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        Intrinsics.checkNotNullParameter(continuation, "completion");
        return new ChooseChannelMembersViewModel$onUserSearchResultTapped$1(this.this$0, this.$userSearchResult, this.$userId, continuation);
    }

    public final Object invoke(Object obj, Object obj2) {
        return ((ChooseChannelMembersViewModel$onUserSearchResultTapped$1) create(obj, (Continuation) obj2)).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        Object obj2;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            Iterator it = this.this$0.channelMembers.iterator();
            while (true) {
                if (!it.hasNext()) {
                    obj2 = null;
                    break;
                }
                obj2 = it.next();
                if (Boxing.boxBoolean(Intrinsics.areEqual((Object) ((User) obj2).getId(), (Object) this.$userSearchResult.chatUserId())).booleanValue()) {
                    break;
                }
            }
            User user = (User) obj2;
            if (user != null) {
                this.this$0.removeChannelMember(user);
                return Unit.INSTANCE;
            }
            ChooseChannelMembersViewModel chooseChannelMembersViewModel = this.this$0;
            chooseChannelMembersViewModel.showBlockingProgressDialog("Adding '" + this.$userSearchResult.getUserName() + "'...");
            CheckUserExistenceUseCase.Request request = new CheckUserExistenceUseCase.Request(this.$userId);
            CheckUserExistenceUseCase access$getCheckUserExistenceUseCase$p = this.this$0.checkUserExistenceUseCase;
            this.label = 1;
            obj = access$getCheckUserExistenceUseCase$p.execute(request, this);
            if (obj == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else if (i == 1) {
            ResultKt.throwOnFailure(obj);
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        User user2 = (User) obj;
        this.this$0.hideBlockingProgressDialog();
        for (User id : this.this$0.channelMembers) {
            if (Intrinsics.areEqual((Object) id.getId(), (Object) user2.getId())) {
                return Unit.INSTANCE;
            }
        }
        this.this$0.addChannelMember(user2);
        return Unit.INSTANCE;
    }
}
