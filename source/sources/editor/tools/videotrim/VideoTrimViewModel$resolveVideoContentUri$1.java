package editor.tools.videotrim;

import android.net.Uri;
import com.memes.commons.media.MediaType;
import com.memes.commons.util.UriResolverHelper;
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
@DebugMetadata(mo26807c = "editor.tools.videotrim.VideoTrimViewModel$resolveVideoContentUri$1", mo26808f = "VideoTrimViewModel.kt", mo26809i = {}, mo26810l = {}, mo26811m = "invokeSuspend", mo26812n = {}, mo26813s = {})
/* compiled from: VideoTrimViewModel.kt */
final class VideoTrimViewModel$resolveVideoContentUri$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $possibleUriStr;
    int label;
    final /* synthetic */ VideoTrimViewModel this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    VideoTrimViewModel$resolveVideoContentUri$1(VideoTrimViewModel videoTrimViewModel, String str, Continuation continuation) {
        super(2, continuation);
        this.this$0 = videoTrimViewModel;
        this.$possibleUriStr = str;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        Intrinsics.checkNotNullParameter(continuation, "completion");
        return new VideoTrimViewModel$resolveVideoContentUri$1(this.this$0, this.$possibleUriStr, continuation);
    }

    public final Object invoke(Object obj, Object obj2) {
        return ((VideoTrimViewModel$resolveVideoContentUri$1) create(obj, (Continuation) obj2)).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            CharSequence charSequence = this.$possibleUriStr;
            if (charSequence == null || StringsKt.isBlank(charSequence)) {
                this.this$0._trimmerErrorLiveData.setValue("We are unable to access selected file. Please try again after moving this file to another folder.");
                return Unit.INSTANCE;
            }
            Uri parse = Uri.parse(this.$possibleUriStr);
            if (Intrinsics.areEqual((Object) parse, (Object) Uri.EMPTY)) {
                this.this$0._trimmerErrorLiveData.setValue("We are unable to access selected file. Please try again after moving this file to another folder.");
                return Unit.INSTANCE;
            }
            this.this$0.showBlockingProgress("Finding selected video..");
            UriResolverHelper access$getUriResolverHelper$p = this.this$0.uriResolverHelper;
            Intrinsics.checkNotNullExpressionValue(parse, "possibleUri");
            access$getUriResolverHelper$p.m2572import(parse, (int) MediaType.VIDEO, (UriResolverHelper.Callback) this.this$0);
            return Unit.INSTANCE;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
