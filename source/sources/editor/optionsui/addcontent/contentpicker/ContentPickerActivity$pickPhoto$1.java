package editor.optionsui.addcontent.contentpicker;

import com.memes.commons.media.MediaContent;
import editor.common.mediapicker.MediaPickResult;
import editor.util.ExtKt;
import java.util.Arrays;
import java.util.Locale;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import timber.log.Timber;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003H\n¢\u0006\u0002\b\u0004"}, mo26107d2 = {"<anonymous>", "", "result", "Leditor/common/mediapicker/MediaPickResult;", "invoke"}, mo26108k = 3, mo26109mv = {1, 4, 2})
/* compiled from: ContentPickerActivity.kt */
final class ContentPickerActivity$pickPhoto$1 extends Lambda implements Function1<MediaPickResult, Unit> {
    final /* synthetic */ ContentPickerActivity this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    ContentPickerActivity$pickPhoto$1(ContentPickerActivity contentPickerActivity) {
        super(1);
        this.this$0 = contentPickerActivity;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((MediaPickResult) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(MediaPickResult mediaPickResult) {
        if (mediaPickResult == null) {
            this.this$0.exit();
            return;
        }
        MediaContent content = mediaPickResult.getContent();
        if (content != null) {
            String contentUrl = content.getContentUrl();
            Locale locale = Locale.ENGLISH;
            Intrinsics.checkNotNullExpressionValue(locale, "Locale.ENGLISH");
            Objects.requireNonNull(contentUrl, "null cannot be cast to non-null type java.lang.String");
            String lowerCase = contentUrl.toLowerCase(locale);
            Intrinsics.checkNotNullExpressionValue(lowerCase, "(this as java.lang.String).toLowerCase(locale)");
            String[] allowedExtensions = ContentPickerActivity.access$getPickerTarget$p(this.this$0).allowedExtensions();
            if (ExtKt.endsWithAnyOf(lowerCase, (String[]) Arrays.copyOf(allowedExtensions, allowedExtensions.length))) {
                this.this$0.getViewModel().download(content);
            } else {
                this.this$0.showWrongContentPicked(content);
            }
        } else {
            Timber.m303e("Unable to pick photo; " + mediaPickResult.getMessage(), new Object[0]);
            this.this$0.exitWithError("Unable to pick photo");
        }
    }
}
