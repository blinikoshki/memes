package editor.optionsui.addcontent.contentpicker;

import com.memes.commons.media.MediaContent;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u000e\u0010\u0004\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u0005H@"}, mo26107d2 = {"convertGifToVideo", "", "content", "Lcom/memes/commons/media/MediaContent;", "continuation", "Lkotlin/coroutines/Continuation;"}, mo26108k = 3, mo26109mv = {1, 4, 2})
@DebugMetadata(mo26807c = "editor.optionsui.addcontent.contentpicker.ContentPickerViewModel", mo26808f = "ContentPickerViewModel.kt", mo26809i = {0, 0}, mo26810l = {141}, mo26811m = "convertGifToVideo", mo26812n = {"this", "content"}, mo26813s = {"L$0", "L$1"})
/* compiled from: ContentPickerViewModel.kt */
final class ContentPickerViewModel$convertGifToVideo$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ ContentPickerViewModel this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    ContentPickerViewModel$convertGifToVideo$1(ContentPickerViewModel contentPickerViewModel, Continuation continuation) {
        super(continuation);
        this.this$0 = contentPickerViewModel;
    }

    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.convertGifToVideo((MediaContent) null, this);
    }
}
