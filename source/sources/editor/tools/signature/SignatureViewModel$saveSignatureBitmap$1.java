package editor.tools.signature;

import android.graphics.Bitmap;
import com.memes.commons.media.MediaContent;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H@¢\u0006\u0004\b\u0003\u0010\u0004"}, mo26107d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;"}, mo26108k = 3, mo26109mv = {1, 4, 2})
@DebugMetadata(mo26807c = "editor.tools.signature.SignatureViewModel$saveSignatureBitmap$1", mo26808f = "SignatureViewModel.kt", mo26809i = {}, mo26810l = {46}, mo26811m = "invokeSuspend", mo26812n = {}, mo26813s = {})
/* compiled from: SignatureViewModel.kt */
final class SignatureViewModel$saveSignatureBitmap$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Bitmap $bitmap;
    final /* synthetic */ Ref.ObjectRef $outputFile;
    int label;
    final /* synthetic */ SignatureViewModel this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    SignatureViewModel$saveSignatureBitmap$1(SignatureViewModel signatureViewModel, Bitmap bitmap, Ref.ObjectRef objectRef, Continuation continuation) {
        super(2, continuation);
        this.this$0 = signatureViewModel;
        this.$bitmap = bitmap;
        this.$outputFile = objectRef;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        Intrinsics.checkNotNullParameter(continuation, "completion");
        return new SignatureViewModel$saveSignatureBitmap$1(this.this$0, this.$bitmap, this.$outputFile, continuation);
    }

    public final Object invoke(Object obj, Object obj2) {
        return ((SignatureViewModel$saveSignatureBitmap$1) create(obj, (Continuation) obj2)).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            this.label = 1;
            obj = BuildersKt.withContext(Dispatchers.getIO(), new SignatureViewModel$saveSignatureBitmap$1$mediaContent$1(this, (Continuation) null), this);
            if (obj == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else if (i == 1) {
            ResultKt.throwOnFailure(obj);
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        MediaContent mediaContent = (MediaContent) obj;
        this.this$0.hideBlockingProgress();
        if (mediaContent != null) {
            this.this$0._signatureCreated.setValue(mediaContent);
        }
        return Unit.INSTANCE;
    }
}
