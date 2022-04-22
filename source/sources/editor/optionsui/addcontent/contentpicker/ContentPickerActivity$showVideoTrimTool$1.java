package editor.optionsui.addcontent.contentpicker;

import androidx.activity.result.ActivityResultCallback;
import com.memes.commons.media.MediaContent;
import java.io.File;
import kotlin.Metadata;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003H\n¢\u0006\u0002\b\u0004"}, mo26107d2 = {"<anonymous>", "", "outputFilePath", "", "onActivityResult"}, mo26108k = 3, mo26109mv = {1, 4, 2})
/* compiled from: ContentPickerActivity.kt */
final class ContentPickerActivity$showVideoTrimTool$1<O> implements ActivityResultCallback<String> {
    final /* synthetic */ MediaContent $content;
    final /* synthetic */ ContentPickerActivity this$0;

    ContentPickerActivity$showVideoTrimTool$1(ContentPickerActivity contentPickerActivity, MediaContent mediaContent) {
        this.this$0 = contentPickerActivity;
        this.$content = mediaContent;
    }

    public final void onActivityResult(String str) {
        if (str == null) {
            this.this$0.exit();
        } else if (new File(str).exists()) {
            this.$content.setContentUrl(str);
            this.this$0.getViewModel().download(this.$content);
        } else {
            this.this$0.exitWithError("Trimmed video file doesn't exist.");
        }
    }
}
