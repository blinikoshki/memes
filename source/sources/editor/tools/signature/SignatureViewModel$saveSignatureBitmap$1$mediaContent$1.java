package editor.tools.signature;

import android.graphics.Bitmap;
import com.memes.commons.media.MediaContent;
import com.memes.commons.media.MediaType;
import editor.util.ExtKt;
import java.io.File;
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

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u0002H@¢\u0006\u0004\b\u0003\u0010\u0004"}, mo26107d2 = {"<anonymous>", "Lcom/memes/commons/media/MediaContent;", "Lkotlinx/coroutines/CoroutineScope;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;"}, mo26108k = 3, mo26109mv = {1, 4, 2})
@DebugMetadata(mo26807c = "editor.tools.signature.SignatureViewModel$saveSignatureBitmap$1$mediaContent$1", mo26808f = "SignatureViewModel.kt", mo26809i = {}, mo26810l = {}, mo26811m = "invokeSuspend", mo26812n = {}, mo26813s = {})
/* compiled from: SignatureViewModel.kt */
final class SignatureViewModel$saveSignatureBitmap$1$mediaContent$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super MediaContent>, Object> {
    int label;
    final /* synthetic */ SignatureViewModel$saveSignatureBitmap$1 this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    SignatureViewModel$saveSignatureBitmap$1$mediaContent$1(SignatureViewModel$saveSignatureBitmap$1 signatureViewModel$saveSignatureBitmap$1, Continuation continuation) {
        super(2, continuation);
        this.this$0 = signatureViewModel$saveSignatureBitmap$1;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        Intrinsics.checkNotNullParameter(continuation, "completion");
        return new SignatureViewModel$saveSignatureBitmap$1$mediaContent$1(this.this$0, continuation);
    }

    public final Object invoke(Object obj, Object obj2) {
        return ((SignatureViewModel$saveSignatureBitmap$1$mediaContent$1) create(obj, (Continuation) obj2)).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            int width = this.this$0.$bitmap.getWidth();
            int height = this.this$0.$bitmap.getHeight();
            if (!ExtKt.writeBitmap((File) this.this$0.$outputFile.element, this.this$0.$bitmap, Bitmap.CompressFormat.PNG, 90)) {
                this.this$0.this$0.showErrorOnBlockingProgress("Unable to retrieve signature data");
                return null;
            }
            this.this$0.$bitmap.recycle();
            String absolutePath = ((File) this.this$0.$outputFile.element).getAbsolutePath();
            Intrinsics.checkNotNullExpressionValue(absolutePath, "outputFile.absolutePath");
            return new MediaContent(MediaType.PHOTO, absolutePath, Boxing.boxInt(width), Boxing.boxInt(height));
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
