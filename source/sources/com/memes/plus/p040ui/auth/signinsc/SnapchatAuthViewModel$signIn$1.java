package com.memes.plus.p040ui.auth.signinsc;

import com.memes.commons.viewmodel.BaseViewModel;
import com.memes.network.core.UniversalResult;
import com.memes.network.memes.api.MemesDataSource;
import com.memes.network.memes.api.model.auth.AuthResult;
import com.memes.network.memes.api.model.auth.SnapchatSignInRequest;
import com.memes.plus.App;
import com.memes.plus.data.storage.InstantStorage;
import com.memes.plus.firebase.firebase_token.FirebaseTokenProvider;
import com.memes.plus.firebase.firebase_token.FirebaseTokenSender;
import com.memes.plus.p040ui.profile.edit_profile.NotificationEnabler;
import com.memes.plus.p040ui.profile.edit_profile.notification_settings.NotificationSettingsRequest;
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
import kotlin.text.StringsKt;
import kotlinx.coroutines.CoroutineScope;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H@¢\u0006\u0004\b\u0003\u0010\u0004"}, mo26107d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;"}, mo26108k = 3, mo26109mv = {1, 4, 2})
@DebugMetadata(mo26807c = "com.memes.plus.ui.auth.signinsc.SnapchatAuthViewModel$signIn$1", mo26808f = "SnapchatAuthViewModel.kt", mo26809i = {}, mo26810l = {65}, mo26811m = "invokeSuspend", mo26812n = {}, mo26813s = {})
/* renamed from: com.memes.plus.ui.auth.signinsc.SnapchatAuthViewModel$signIn$1 */
/* compiled from: SnapchatAuthViewModel.kt */
final class SnapchatAuthViewModel$signIn$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $snapchatAccessToken;
    int label;
    final /* synthetic */ SnapchatAuthViewModel this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    SnapchatAuthViewModel$signIn$1(SnapchatAuthViewModel snapchatAuthViewModel, String str, Continuation continuation) {
        super(2, continuation);
        this.this$0 = snapchatAuthViewModel;
        this.$snapchatAccessToken = str;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        Intrinsics.checkNotNullParameter(continuation, "completion");
        return new SnapchatAuthViewModel$signIn$1(this.this$0, this.$snapchatAccessToken, continuation);
    }

    public final Object invoke(Object obj, Object obj2) {
        return ((SnapchatAuthViewModel$signIn$1) create(obj, (Continuation) obj2)).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            BaseViewModel.showBlockingProgressDialog$default(this.this$0, (String) null, 1, (Object) null);
            String firebaseToken = this.this$0.storageRepository.firebaseToken();
            CharSequence charSequence = firebaseToken;
            if (charSequence == null || StringsKt.isBlank(charSequence)) {
                firebaseToken = FirebaseTokenProvider.NOT_ALLOWED;
            }
            SnapchatSignInRequest snapchatSignInRequest = new SnapchatSignInRequest(this.$snapchatAccessToken, firebaseToken);
            MemesDataSource access$getMemesDataSource$p = this.this$0.memesDataSource;
            this.label = 1;
            obj = access$getMemesDataSource$p.signIn(snapchatSignInRequest, (Continuation<? super UniversalResult<AuthResult>>) this);
            if (obj == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else if (i == 1) {
            ResultKt.throwOnFailure(obj);
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        UniversalResult universalResult = (UniversalResult) obj;
        if (universalResult.isError() || universalResult.hasNoItem()) {
            this.this$0.hideBlockingProgressDialog();
            SnapchatAuthViewModel snapchatAuthViewModel = this.this$0;
            snapchatAuthViewModel.toast("Error: " + universalResult.getMessage());
            return Unit.INSTANCE;
        }
        AuthResult authResult = (AuthResult) universalResult.requireItem();
        this.this$0.hideBlockingProgressDialog();
        InstantStorage.INSTANCE.saveAuthResult(this.this$0.storageRepository, authResult);
        this.this$0._signInComplete.setValue(Boxing.boxBoolean(true));
        App.Companion.trackingManager().onSnapchatUserSignedIn(authResult.getUserId());
        FirebaseTokenSender.INSTANCE.sendFrom(this.this$0.storageRepository);
        NotificationEnabler.toggleNotificationStatus$default(NotificationEnabler.INSTANCE, (NotificationSettingsRequest) null, 1, (Object) null);
        return Unit.INSTANCE;
    }
}
