package com.memes.chat.util.usecases;

import com.memes.chat.util.usecases.FileUploadUseCase;
import com.memes.network.chat.api.ChatDataSource;
import com.memes.network.core.UniversalResult;
import java.io.File;
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
import timber.log.Timber;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H@¢\u0006\u0004\b\u0003\u0010\u0004"}, mo26107d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;"}, mo26108k = 3, mo26109mv = {1, 4, 2})
@DebugMetadata(mo26807c = "com.memes.chat.util.usecases.FileUploadUseCase$execute$2", mo26808f = "FileUploadUseCase.kt", mo26809i = {}, mo26810l = {41}, mo26811m = "invokeSuspend", mo26812n = {}, mo26813s = {})
/* compiled from: FileUploadUseCase.kt */
final class FileUploadUseCase$execute$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super String>, Object> {
    final /* synthetic */ FileUploadUseCase.Request $request;
    int label;
    final /* synthetic */ FileUploadUseCase this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    FileUploadUseCase$execute$2(FileUploadUseCase fileUploadUseCase, FileUploadUseCase.Request request, Continuation continuation) {
        super(2, continuation);
        this.this$0 = fileUploadUseCase;
        this.$request = request;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        Intrinsics.checkNotNullParameter(continuation, "completion");
        return new FileUploadUseCase$execute$2(this.this$0, this.$request, continuation);
    }

    public final Object invoke(Object obj, Object obj2) {
        return ((FileUploadUseCase$execute$2) create(obj, (Continuation) obj2)).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        boolean z;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            boolean z2 = false;
            Timber.m300d("execute: " + this.$request, new Object[0]);
            try {
                z = this.$request.getFile().exists();
            } catch (SecurityException unused) {
                z = false;
            }
            if (z) {
                String realUserId = this.this$0.credentialsSharedPref.realUserId();
                String str = this.this$0.credentialsSharedPref.token();
                CharSequence charSequence = realUserId;
                if (!(charSequence == null || StringsKt.isBlank(charSequence))) {
                    CharSequence charSequence2 = str;
                    if (charSequence2 == null || StringsKt.isBlank(charSequence2)) {
                        z2 = true;
                    }
                    if (!z2) {
                        ChatDataSource access$getChatDataSource$p = this.this$0.chatDataSource;
                        File file = this.$request.getFile();
                        this.label = 1;
                        obj = access$getChatDataSource$p.uploadPhotoFile(realUserId, str, file, this);
                        if (obj == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                    }
                }
                throw new RuntimeException("Failed to retrieve valid login information.");
            }
            throw new RuntimeException("Target file is not accessible.");
        } else if (i == 1) {
            ResultKt.throwOnFailure(obj);
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        UniversalResult universalResult = (UniversalResult) obj;
        if (!universalResult.isError() && !universalResult.hasNoItem()) {
            return universalResult.requireItem();
        }
        throw new RuntimeException(universalResult.getMessage());
    }
}
