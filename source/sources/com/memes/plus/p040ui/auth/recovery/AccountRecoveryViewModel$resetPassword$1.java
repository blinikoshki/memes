package com.memes.plus.p040ui.auth.recovery;

import com.memes.commons.viewmodel.BaseViewModel;
import com.memes.network.core.UniversalResult;
import com.memes.network.memes.api.MemesDataSource;
import com.memes.network.memes.api.model.auth.ResetPasswordRequest;
import com.memes.plus.p040ui.auth.recovery.stages.AccountRecoveryStage;
import java.util.Locale;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.CoroutineScope;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H@¢\u0006\u0004\b\u0003\u0010\u0004"}, mo26107d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;"}, mo26108k = 3, mo26109mv = {1, 4, 2})
@DebugMetadata(mo26807c = "com.memes.plus.ui.auth.recovery.AccountRecoveryViewModel$resetPassword$1", mo26808f = "AccountRecoveryViewModel.kt", mo26809i = {}, mo26810l = {244}, mo26811m = "invokeSuspend", mo26812n = {}, mo26813s = {})
/* renamed from: com.memes.plus.ui.auth.recovery.AccountRecoveryViewModel$resetPassword$1 */
/* compiled from: AccountRecoveryViewModel.kt */
final class AccountRecoveryViewModel$resetPassword$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $newPassword;
    final /* synthetic */ String $otp;
    final /* synthetic */ String $userId;
    int label;
    final /* synthetic */ AccountRecoveryViewModel this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    AccountRecoveryViewModel$resetPassword$1(AccountRecoveryViewModel accountRecoveryViewModel, String str, String str2, String str3, Continuation continuation) {
        super(2, continuation);
        this.this$0 = accountRecoveryViewModel;
        this.$userId = str;
        this.$otp = str2;
        this.$newPassword = str3;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        Intrinsics.checkNotNullParameter(continuation, "completion");
        return new AccountRecoveryViewModel$resetPassword$1(this.this$0, this.$userId, this.$otp, this.$newPassword, continuation);
    }

    public final Object invoke(Object obj, Object obj2) {
        return ((AccountRecoveryViewModel$resetPassword$1) create(obj, (Continuation) obj2)).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            BaseViewModel.showBlockingProgressDialog$default(this.this$0, (String) null, 1, (Object) null);
            ResetPasswordRequest resetPasswordRequest = new ResetPasswordRequest(this.$userId, this.$otp, this.$newPassword);
            MemesDataSource access$getMemesDataSource$p = this.this$0.memesDataSource;
            this.label = 1;
            obj = access$getMemesDataSource$p.resetPassword(resetPasswordRequest, this);
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
        if (universalResult.isError()) {
            String message = universalResult.getMessage();
            Locale locale = Locale.ENGLISH;
            Intrinsics.checkNotNullExpressionValue(locale, "Locale.ENGLISH");
            Objects.requireNonNull(message, "null cannot be cast to non-null type java.lang.String");
            String lowerCase = message.toLowerCase(locale);
            Intrinsics.checkNotNullExpressionValue(lowerCase, "(this as java.lang.String).toLowerCase(locale)");
            AccountRecoveryViewModel accountRecoveryViewModel = this.this$0;
            accountRecoveryViewModel.toast("Error: " + lowerCase);
            CharSequence charSequence = lowerCase;
            if (StringsKt.contains$default(charSequence, (CharSequence) "otp", false, 2, (Object) null) || StringsKt.contains$default(charSequence, (CharSequence) "passcode", false, 2, (Object) null)) {
                this.this$0.goToStage(AccountRecoveryStage.CONFIRM_OTP);
            }
            return Unit.INSTANCE;
        }
        this.this$0.toast("Account recovery completed successfully.");
        this.this$0._recoveryCompleted.setValue(universalResult.getMessage());
        return Unit.INSTANCE;
    }
}
