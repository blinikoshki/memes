package com.memes.plus.p040ui.auth.signup;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u0002H@¢\u0006\u0004\b\u0003\u0010\u0004"}, mo26107d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;"}, mo26108k = 3, mo26109mv = {1, 4, 2})
@DebugMetadata(mo26807c = "com.memes.plus.ui.auth.signup.SignUpViewModel$createProfilePicBase64Encoded$2", mo26808f = "SignUpViewModel.kt", mo26809i = {}, mo26810l = {272}, mo26811m = "invokeSuspend", mo26812n = {}, mo26813s = {})
/* renamed from: com.memes.plus.ui.auth.signup.SignUpViewModel$createProfilePicBase64Encoded$2 */
/* compiled from: SignUpViewModel.kt */
final class SignUpViewModel$createProfilePicBase64Encoded$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super String>, Object> {
    final /* synthetic */ String $filePath;
    int label;
    final /* synthetic */ SignUpViewModel this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    SignUpViewModel$createProfilePicBase64Encoded$2(SignUpViewModel signUpViewModel, String str, Continuation continuation) {
        super(2, continuation);
        this.this$0 = signUpViewModel;
        this.$filePath = str;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        Intrinsics.checkNotNullParameter(continuation, "completion");
        return new SignUpViewModel$createProfilePicBase64Encoded$2(this.this$0, this.$filePath, continuation);
    }

    public final Object invoke(Object obj, Object obj2) {
        return ((SignUpViewModel$createProfilePicBase64Encoded$2) create(obj, (Continuation) obj2)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARNING: Removed duplicated region for block: B:24:0x0082 A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x0083  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object invokeSuspend(java.lang.Object r12) {
        /*
            r11 = this;
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r1 = r11.label
            r2 = 0
            r3 = 0
            r4 = 1
            if (r1 == 0) goto L_0x001a
            if (r1 != r4) goto L_0x0012
            kotlin.ResultKt.throwOnFailure(r12)
            goto L_0x007e
        L_0x0012:
            java.lang.IllegalStateException r12 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r12.<init>(r0)
            throw r12
        L_0x001a:
            kotlin.ResultKt.throwOnFailure(r12)
            java.lang.String r12 = r11.$filePath
            java.lang.CharSequence r12 = (java.lang.CharSequence) r12
            if (r12 == 0) goto L_0x002c
            boolean r12 = kotlin.text.StringsKt.isBlank(r12)
            if (r12 == 0) goto L_0x002a
            goto L_0x002c
        L_0x002a:
            r12 = 0
            goto L_0x002d
        L_0x002c:
            r12 = 1
        L_0x002d:
            if (r12 == 0) goto L_0x0031
            r12 = r2
            goto L_0x0038
        L_0x0031:
            java.io.File r12 = new java.io.File
            java.lang.String r1 = r11.$filePath
            r12.<init>(r1)
        L_0x0038:
            if (r12 == 0) goto L_0x006f
            boolean r1 = r12.exists()
            if (r1 != 0) goto L_0x0041
            goto L_0x006f
        L_0x0041:
            com.squareup.picasso.Picasso r5 = com.squareup.picasso.Picasso.get()
            java.lang.String r0 = "Picasso.get()"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r5, r0)
            com.memes.plus.ui.auth.signup.SignUpViewModel r6 = r11.this$0
            java.lang.String r7 = r11.$filePath
            r8 = 0
            r9 = 4
            r10 = 0
            com.squareup.picasso.Picasso r0 = com.memes.plus.util.picasso.PicassoExtKt.log$default((com.squareup.picasso.Picasso) r5, (java.lang.Object) r6, (java.lang.String) r7, (java.lang.String) r8, (int) r9, (java.lang.Object) r10)
            com.squareup.picasso.RequestCreator r12 = r0.load((java.io.File) r12)
            r0 = 256(0x100, float:3.59E-43)
            com.squareup.picasso.RequestCreator r12 = r12.resize(r0, r0)
            com.memes.plus.custom.picasso_plus.CircleTransformation r0 = new com.memes.plus.custom.picasso_plus.CircleTransformation
            r0.<init>()
            com.squareup.picasso.Transformation r0 = (com.squareup.picasso.Transformation) r0
            com.squareup.picasso.RequestCreator r12 = r12.transform((com.squareup.picasso.Transformation) r0)
            android.graphics.Bitmap r12 = r12.get()
            goto L_0x0080
        L_0x006f:
            com.memes.plus.ui.auth.signup.SignUpViewModel r12 = r11.this$0
            com.memes.plus.util.assetfile.AssetFileProvider r12 = r12.assetFileProvider
            r11.label = r4
            java.lang.Object r12 = r12.createDefaultProfileThumbBitmap(r11)
            if (r12 != r0) goto L_0x007e
            return r0
        L_0x007e:
            android.graphics.Bitmap r12 = (android.graphics.Bitmap) r12
        L_0x0080:
            if (r12 != 0) goto L_0x0083
            return r2
        L_0x0083:
            java.io.ByteArrayOutputStream r0 = new java.io.ByteArrayOutputStream
            r0.<init>()
            android.graphics.Bitmap$CompressFormat r1 = android.graphics.Bitmap.CompressFormat.JPEG
            r2 = 90
            r4 = r0
            java.io.OutputStream r4 = (java.io.OutputStream) r4
            r12.compress(r1, r2, r4)
            r12.recycle()
            byte[] r12 = r0.toByteArray()
            java.lang.String r12 = android.util.Base64.encodeToString(r12, r3)
            return r12
        */
        throw new UnsupportedOperationException("Method not decompiled: com.memes.plus.p040ui.auth.signup.SignUpViewModel$createProfilePicBase64Encoded$2.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
