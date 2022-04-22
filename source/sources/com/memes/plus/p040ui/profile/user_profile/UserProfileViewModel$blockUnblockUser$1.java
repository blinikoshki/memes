package com.memes.plus.p040ui.profile.user_profile;

import com.memes.plus.data.mapped_response.UniversalResult;
import com.memes.plus.data.source.memes.MemesRepository;
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

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H@¢\u0006\u0004\b\u0003\u0010\u0004"}, mo26107d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;"}, mo26108k = 3, mo26109mv = {1, 4, 2})
@DebugMetadata(mo26807c = "com.memes.plus.ui.profile.user_profile.UserProfileViewModel$blockUnblockUser$1", mo26808f = "UserProfileViewModel.kt", mo26809i = {}, mo26810l = {334}, mo26811m = "invokeSuspend", mo26812n = {}, mo26813s = {})
/* renamed from: com.memes.plus.ui.profile.user_profile.UserProfileViewModel$blockUnblockUser$1 */
/* compiled from: UserProfileViewModel.kt */
final class UserProfileViewModel$blockUnblockUser$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ UserProfileViewModel this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    UserProfileViewModel$blockUnblockUser$1(UserProfileViewModel userProfileViewModel, Continuation continuation) {
        super(2, continuation);
        this.this$0 = userProfileViewModel;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        Intrinsics.checkNotNullParameter(continuation, "completion");
        return new UserProfileViewModel$blockUnblockUser$1(this.this$0, continuation);
    }

    public final Object invoke(Object obj, Object obj2) {
        return ((UserProfileViewModel$blockUnblockUser$1) create(obj, (Continuation) obj2)).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            BlockUnblockUserRequest blockUnblockUserRequest = new BlockUnblockUserRequest(this.this$0.targetUserId);
            MemesRepository access$getMemesRepository$p = this.this$0.memesRepository;
            this.label = 1;
            obj = access$getMemesRepository$p.blockUnblockUser(blockUnblockUserRequest, this);
            if (obj == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else if (i == 1) {
            ResultKt.throwOnFailure(obj);
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        UniversalResult universalResult = (UniversalResult) obj;
        this.this$0.hideBlockingProgressDialog();
        if (!universalResult.isError()) {
            BlockUnblockUserResponse blockUnblockUserResponse = (BlockUnblockUserResponse) universalResult.getItem();
            if (blockUnblockUserResponse == null) {
                UserProfileViewModel userProfileViewModel = this.this$0;
                userProfileViewModel.toast("Error Empty Response: " + universalResult.getMessage());
                return Unit.INSTANCE;
            }
            UserProfile access$getUserProfile$p = this.this$0.userProfile;
            if (access$getUserProfile$p != null) {
                access$getUserProfile$p.setBlocked(blockUnblockUserResponse.isBlocked());
            }
            this.this$0.getBlockUnblockLiveData().setValue(Boxing.boxBoolean(blockUnblockUserResponse.isBlocked()));
            return Unit.INSTANCE;
        } else if (universalResult.isSessionExpired()) {
            this.this$0.showSessionExpiredDialog(universalResult.getMessage());
            return Unit.INSTANCE;
        } else {
            UserProfileViewModel userProfileViewModel2 = this.this$0;
            userProfileViewModel2.toast("Error: " + universalResult.getMessage());
            return Unit.INSTANCE;
        }
    }
}
