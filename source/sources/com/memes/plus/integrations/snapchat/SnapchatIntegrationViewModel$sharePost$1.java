package com.memes.plus.integrations.snapchat;

import com.memes.commons.output.OutputExtension;
import com.memes.commons.output.OutputTargetGenerator;
import com.memes.commons.viewmodel.BaseViewModel;
import com.memes.plus.integrations.screenshots.ScreenshotItem;
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
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Job;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H@¢\u0006\u0004\b\u0003\u0010\u0004"}, mo26107d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;"}, mo26108k = 3, mo26109mv = {1, 4, 2})
@DebugMetadata(mo26807c = "com.memes.plus.integrations.snapchat.SnapchatIntegrationViewModel$sharePost$1", mo26808f = "SnapchatIntegrationViewModel.kt", mo26809i = {}, mo26810l = {}, mo26811m = "invokeSuspend", mo26812n = {}, mo26813s = {})
/* compiled from: SnapchatIntegrationViewModel.kt */
final class SnapchatIntegrationViewModel$sharePost$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $postId;
    final /* synthetic */ ScreenshotItem $screenshotItem;
    int label;
    final /* synthetic */ SnapchatIntegrationViewModel this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    SnapchatIntegrationViewModel$sharePost$1(SnapchatIntegrationViewModel snapchatIntegrationViewModel, String str, ScreenshotItem screenshotItem, Continuation continuation) {
        super(2, continuation);
        this.this$0 = snapchatIntegrationViewModel;
        this.$postId = str;
        this.$screenshotItem = screenshotItem;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        Intrinsics.checkNotNullParameter(continuation, "completion");
        return new SnapchatIntegrationViewModel$sharePost$1(this.this$0, this.$postId, this.$screenshotItem, continuation);
    }

    public final Object invoke(Object obj, Object obj2) {
        return ((SnapchatIntegrationViewModel$sharePost$1) create(obj, (Continuation) obj2)).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            BaseViewModel.showBlockingProgressDialog$default(this.this$0, (String) null, 1, (Object) null);
            OutputTargetGenerator access$getOutputTargetGenerator$p = this.this$0.outputTargetGenerator;
            File outputFile = OutputTargetGenerator.setDefaultOutputDestination$default(access$getOutputTargetGenerator$p, ".sharepost", "post-screenshot-" + this.$postId, OutputExtension.PNG, false, false, 24, (Object) null).getOutputFile();
            this.$screenshotItem.obtainScreenshot(outputFile);
            this.this$0.hideBlockingProgressDialog();
            Job unused = this.this$0.sharePost(this.$postId, outputFile);
            return Unit.INSTANCE;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
