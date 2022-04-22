package editor.optionsui.layout.templates;

import com.facebook.share.internal.ShareConstants;
import com.memes.commons.media.MediaContent;
import com.memes.commons.media.MediaContentDownloader;
import com.memes.commons.media.MediaType;
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

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H@¢\u0006\u0004\b\u0003\u0010\u0004"}, mo26107d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;"}, mo26108k = 3, mo26109mv = {1, 4, 2})
@DebugMetadata(mo26807c = "editor.optionsui.layout.templates.TemplatesViewModel$downloadTemplate$1", mo26808f = "TemplatesViewModel.kt", mo26809i = {}, mo26810l = {}, mo26811m = "invokeSuspend", mo26812n = {}, mo26813s = {})
/* compiled from: TemplatesViewModel.kt */
final class TemplatesViewModel$downloadTemplate$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Template $template;
    int label;
    final /* synthetic */ TemplatesViewModel this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    TemplatesViewModel$downloadTemplate$1(TemplatesViewModel templatesViewModel, Template template, Continuation continuation) {
        super(2, continuation);
        this.this$0 = templatesViewModel;
        this.$template = template;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        Intrinsics.checkNotNullParameter(continuation, "completion");
        return new TemplatesViewModel$downloadTemplate$1(this.this$0, this.$template, continuation);
    }

    public final Object invoke(Object obj, Object obj2) {
        return ((TemplatesViewModel$downloadTemplate$1) create(obj, (Continuation) obj2)).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            this.this$0.showBlockingProgress("Downloading Template...");
            final MediaContent mediaContent = new MediaContent(MediaType.NETWORK_PHOTO, this.$template.getThumbnailPath(), Boxing.boxInt(this.$template.getWidth()), Boxing.boxInt(this.$template.getHeight()));
            MediaContentDownloader.Companion.get().storeAt(this.this$0.outputTargetGenerator.getRootDirectory().getAbsolutePath() + ".templates/").callback(new MediaContentDownloader.Callback(this) {
                final /* synthetic */ TemplatesViewModel$downloadTemplate$1 this$0;

                {
                    this.this$0 = r1;
                }

                public void onProgressChanged(int i) {
                    String str;
                    if (i >= 0 && 100 >= i) {
                        StringBuilder sb = new StringBuilder();
                        sb.append(i);
                        sb.append('%');
                        str = sb.toString();
                    } else {
                        str = "";
                    }
                    this.this$0.this$0.updateBlockingProgress(i, str);
                }

                public void onDownloadComplete(File file) {
                    Intrinsics.checkNotNullParameter(file, "file");
                    this.this$0.this$0.hideBlockingProgress();
                    MediaContent mediaContent = mediaContent;
                    String absolutePath = file.getAbsolutePath();
                    Intrinsics.checkNotNullExpressionValue(absolutePath, "file.absolutePath");
                    mediaContent.setContentUrl(absolutePath);
                    mediaContent.optimizeContentType();
                    this.this$0.this$0._templateDownloaded.setValue(new Template(this.this$0.$template.getId(), mediaContent.getContentUrl(), this.this$0.$template.getWidth(), this.this$0.$template.getHeight()));
                }

                public void onError(String str) {
                    Intrinsics.checkNotNullParameter(str, ShareConstants.WEB_DIALOG_PARAM_MESSAGE);
                    this.this$0.this$0.hideBlockingProgress();
                    this.this$0.this$0._templateDownloaded.setValue(null);
                }
            }).download(mediaContent);
            return Unit.INSTANCE;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
