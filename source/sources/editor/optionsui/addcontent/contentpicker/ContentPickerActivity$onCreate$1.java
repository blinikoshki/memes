package editor.optionsui.addcontent.contentpicker;

import android.content.Intent;
import androidx.lifecycle.Observer;
import com.memes.commons.media.MediaContent;
import kotlin.Metadata;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, mo26107d2 = {"<anonymous>", "", "content", "Lcom/memes/commons/media/MediaContent;", "kotlin.jvm.PlatformType", "onChanged"}, mo26108k = 3, mo26109mv = {1, 4, 2})
/* compiled from: ContentPickerActivity.kt */
final class ContentPickerActivity$onCreate$1<T> implements Observer<MediaContent> {
    final /* synthetic */ ContentPickerActivity this$0;

    ContentPickerActivity$onCreate$1(ContentPickerActivity contentPickerActivity) {
        this.this$0 = contentPickerActivity;
    }

    public final void onChanged(MediaContent mediaContent) {
        Intent intent = new Intent();
        intent.putExtra(ContentPickerActivityContract.EXTRA_PICKER_RESULT, mediaContent);
        this.this$0.setResult(-1, intent);
        this.this$0.finish();
    }
}
