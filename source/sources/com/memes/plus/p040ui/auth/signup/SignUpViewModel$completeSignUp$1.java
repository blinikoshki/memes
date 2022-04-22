package com.memes.plus.p040ui.auth.signup;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H@¢\u0006\u0004\b\u0003\u0010\u0004"}, mo26107d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;"}, mo26108k = 3, mo26109mv = {1, 4, 2})
@DebugMetadata(mo26807c = "com.memes.plus.ui.auth.signup.SignUpViewModel$completeSignUp$1", mo26808f = "SignUpViewModel.kt", mo26809i = {0}, mo26810l = {238, 242}, mo26811m = "invokeSuspend", mo26812n = {"firebaseToken"}, mo26813s = {"L$0"})
/* renamed from: com.memes.plus.ui.auth.signup.SignUpViewModel$completeSignUp$1 */
/* compiled from: SignUpViewModel.kt */
final class SignUpViewModel$completeSignUp$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $email;
    final /* synthetic */ String $fullName;
    final /* synthetic */ String $password;
    final /* synthetic */ String $username;
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    Object L$4;
    Object L$5;
    Object L$6;
    int label;
    final /* synthetic */ SignUpViewModel this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    SignUpViewModel$completeSignUp$1(SignUpViewModel signUpViewModel, String str, String str2, String str3, String str4, Continuation continuation) {
        super(2, continuation);
        this.this$0 = signUpViewModel;
        this.$email = str;
        this.$username = str2;
        this.$password = str3;
        this.$fullName = str4;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        Intrinsics.checkNotNullParameter(continuation, "completion");
        return new SignUpViewModel$completeSignUp$1(this.this$0, this.$email, this.$username, this.$password, this.$fullName, continuation);
    }

    public final Object invoke(Object obj, Object obj2) {
        return ((SignUpViewModel$completeSignUp$1) create(obj, (Continuation) obj2)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARNING: Removed duplicated region for block: B:27:0x00df  */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x0122  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object invokeSuspend(java.lang.Object r23) {
        /*
            r22 = this;
            r0 = r22
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 2
            r4 = 1
            r5 = 0
            if (r2 == 0) goto L_0x004e
            if (r2 == r4) goto L_0x0020
            if (r2 != r3) goto L_0x0018
            kotlin.ResultKt.throwOnFailure(r23)
            r2 = r23
            goto L_0x00d0
        L_0x0018:
            java.lang.IllegalStateException r1 = new java.lang.IllegalStateException
            java.lang.String r2 = "call to 'resume' before 'invoke' with coroutine"
            r1.<init>(r2)
            throw r1
        L_0x0020:
            java.lang.Object r2 = r0.L$6
            java.lang.String r2 = (java.lang.String) r2
            java.lang.Object r6 = r0.L$5
            java.lang.String r6 = (java.lang.String) r6
            java.lang.Object r7 = r0.L$4
            java.lang.String r7 = (java.lang.String) r7
            java.lang.Object r8 = r0.L$3
            java.lang.String r8 = (java.lang.String) r8
            java.lang.Object r9 = r0.L$2
            java.lang.String r9 = (java.lang.String) r9
            java.lang.Object r10 = r0.L$1
            java.lang.String r10 = (java.lang.String) r10
            java.lang.Object r11 = r0.L$0
            java.lang.String r11 = (java.lang.String) r11
            kotlin.ResultKt.throwOnFailure(r23)
            r12 = r23
        L_0x0041:
            r19 = r2
            r18 = r6
            r17 = r7
            r16 = r8
            r15 = r9
            r14 = r10
            r21 = r11
            goto L_0x00a9
        L_0x004e:
            kotlin.ResultKt.throwOnFailure(r23)
            com.memes.plus.ui.auth.signup.SignUpViewModel r2 = r0.this$0
            com.memes.commons.viewmodel.BaseViewModel.showBlockingProgressDialog$default(r2, r5, r4, r5)
            com.memes.plus.ui.auth.signup.SignUpViewModel r2 = r0.this$0
            com.memes.plus.data.storage.StorageRepository r2 = r2.storageRepository
            java.lang.String r2 = r2.firebaseToken()
            r6 = r2
            java.lang.CharSequence r6 = (java.lang.CharSequence) r6
            if (r6 == 0) goto L_0x006e
            boolean r6 = kotlin.text.StringsKt.isBlank(r6)
            if (r6 == 0) goto L_0x006c
            goto L_0x006e
        L_0x006c:
            r6 = 0
            goto L_0x006f
        L_0x006e:
            r6 = 1
        L_0x006f:
            if (r6 == 0) goto L_0x0073
            java.lang.String r2 = "NOT_ALLOW"
        L_0x0073:
            r11 = r2
            java.lang.String r10 = r0.$email
            java.lang.String r9 = r0.$username
            java.lang.String r8 = r0.$password
            java.lang.String r7 = r0.$fullName
            com.memes.plus.ui.auth.signup.SignUpViewModel r2 = r0.this$0
            com.memes.plus.ui.auth.signup.selectgender.Gender r2 = r2.getGender()
            java.lang.String r6 = r2.toString()
            com.memes.plus.ui.auth.signup.SignUpViewModel r2 = r0.this$0
            java.lang.String r2 = r2.birthday
            com.memes.plus.ui.auth.signup.SignUpViewModel r12 = r0.this$0
            java.lang.String r13 = r12.picturePath
            r0.L$0 = r11
            r0.L$1 = r10
            r0.L$2 = r9
            r0.L$3 = r8
            r0.L$4 = r7
            r0.L$5 = r6
            r0.L$6 = r2
            r0.label = r4
            java.lang.Object r12 = r12.createProfilePicBase64Encoded(r13, r0)
            if (r12 != r1) goto L_0x0041
            return r1
        L_0x00a9:
            r20 = r12
            java.lang.String r20 = (java.lang.String) r20
            com.memes.network.memes.api.model.auth.EmailSignUpRequest r2 = new com.memes.network.memes.api.model.auth.EmailSignUpRequest
            r13 = r2
            r13.<init>(r14, r15, r16, r17, r18, r19, r20, r21)
            com.memes.plus.ui.auth.signup.SignUpViewModel r6 = r0.this$0
            com.memes.network.memes.api.MemesDataSource r6 = r6.memesDataSource
            r0.L$0 = r5
            r0.L$1 = r5
            r0.L$2 = r5
            r0.L$3 = r5
            r0.L$4 = r5
            r0.L$5 = r5
            r0.L$6 = r5
            r0.label = r3
            java.lang.Object r2 = r6.signUp(r2, r0)
            if (r2 != r1) goto L_0x00d0
            return r1
        L_0x00d0:
            com.memes.network.core.UniversalResult r2 = (com.memes.network.core.UniversalResult) r2
            boolean r1 = r2.isError()
            if (r1 != 0) goto L_0x0122
            boolean r1 = r2.hasNoItem()
            if (r1 == 0) goto L_0x00df
            goto L_0x0122
        L_0x00df:
            java.lang.Object r1 = r2.requireItem()
            com.memes.network.memes.api.model.auth.AuthResult r1 = (com.memes.network.memes.api.model.auth.AuthResult) r1
            com.memes.plus.ui.auth.signup.SignUpViewModel r3 = r0.this$0
            r3.hideBlockingProgressDialog()
            com.memes.plus.data.storage.InstantStorage r3 = com.memes.plus.data.storage.InstantStorage.INSTANCE
            com.memes.plus.ui.auth.signup.SignUpViewModel r6 = r0.this$0
            com.memes.plus.data.storage.StorageRepository r6 = r6.storageRepository
            r3.saveAuthResult(r6, r1)
            com.memes.plus.ui.auth.signup.SignUpViewModel r3 = r0.this$0
            com.memes.commons.util.SingleLiveEvent r3 = r3._signUpResult
            java.lang.String r2 = r2.getMessage()
            r3.setValue(r2)
            java.lang.String r1 = r1.getUserId()
            com.memes.plus.App$Companion r2 = com.memes.plus.App.Companion
            com.memes.eventtracker.tracking.EventTrackingManager r2 = r2.trackingManager()
            r2.onUserSignedUp(r1)
            com.memes.plus.firebase.firebase_token.FirebaseTokenSender r1 = com.memes.plus.firebase.firebase_token.FirebaseTokenSender.INSTANCE
            com.memes.plus.ui.auth.signup.SignUpViewModel r2 = r0.this$0
            com.memes.plus.data.storage.StorageRepository r2 = r2.storageRepository
            r1.sendFrom(r2)
            com.memes.plus.ui.profile.edit_profile.NotificationEnabler r1 = com.memes.plus.p040ui.profile.edit_profile.NotificationEnabler.INSTANCE
            com.memes.plus.p040ui.profile.edit_profile.NotificationEnabler.toggleNotificationStatus$default(r1, r5, r4, r5)
            kotlin.Unit r1 = kotlin.Unit.INSTANCE
            return r1
        L_0x0122:
            com.memes.plus.ui.auth.signup.SignUpViewModel r1 = r0.this$0
            r1.hideBlockingProgressDialog()
            com.memes.plus.ui.auth.signup.SignUpViewModel r1 = r0.this$0
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            java.lang.String r4 = "Error: "
            r3.append(r4)
            java.lang.String r2 = r2.getMessage()
            r3.append(r2)
            java.lang.String r2 = r3.toString()
            r1.toast((java.lang.String) r2)
            kotlin.Unit r1 = kotlin.Unit.INSTANCE
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.memes.plus.p040ui.auth.signup.SignUpViewModel$completeSignUp$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
