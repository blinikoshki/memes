package editor.common.mediapicker;

import android.net.Uri;
import androidx.activity.result.ActivityResultCallback;
import com.memes.commons.activity.ContractLauncher;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, mo26107d2 = {"<anonymous>", "", "invoke"}, mo26108k = 3, mo26109mv = {1, 4, 2})
/* compiled from: MimeMediaPicker.kt */
final class MimeMediaPicker$start$1 extends Lambda implements Function0<Unit> {
    final /* synthetic */ ContractLauncher $contractLauncher;
    final /* synthetic */ Function1 $listener;
    final /* synthetic */ String $mediaInput;
    final /* synthetic */ int $mediaType;
    final /* synthetic */ MimeMediaPicker this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    MimeMediaPicker$start$1(MimeMediaPicker mimeMediaPicker, ContractLauncher contractLauncher, String str, int i, Function1 function1) {
        super(0);
        this.this$0 = mimeMediaPicker;
        this.$contractLauncher = contractLauncher;
        this.$mediaInput = str;
        this.$mediaType = i;
        this.$listener = function1;
    }

    public final void invoke() {
        this.$contractLauncher.launch(this.$mediaInput, new ActivityResultCallback<Uri>(this) {
            final /* synthetic */ MimeMediaPicker$start$1 this$0;

            {
                this.this$0 = r1;
            }

            public final void onActivityResult(Uri uri) {
                if (uri != null) {
                    this.this$0.this$0.resolveContent(this.this$0.$mediaType, uri);
                } else {
                    this.this$0.$listener.invoke(null);
                }
            }
        });
    }
}
