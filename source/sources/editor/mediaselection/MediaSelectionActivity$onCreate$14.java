package editor.mediaselection;

import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.Observer;
import com.memes.editor.C4175R;
import editor.common.alertmessagebottomsheet.AlertMessageBottomSheet;
import editor.common.alertmessagebottomsheet.AlertMessageConfig;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, mo26107d2 = {"<anonymous>", "", "message", "", "kotlin.jvm.PlatformType", "onChanged"}, mo26108k = 3, mo26109mv = {1, 4, 2})
/* compiled from: MediaSelectionActivity.kt */
final class MediaSelectionActivity$onCreate$14<T> implements Observer<String> {
    final /* synthetic */ MediaSelectionActivity this$0;

    MediaSelectionActivity$onCreate$14(MediaSelectionActivity mediaSelectionActivity) {
        this.this$0 = mediaSelectionActivity;
    }

    public final void onChanged(String str) {
        String string = this.this$0.getString(C4175R.string.n_import_failed);
        Intrinsics.checkNotNullExpressionValue(string, "getString(R.string.n_import_failed)");
        String string2 = this.this$0.getString(C4175R.string.n_import_failed_message);
        Intrinsics.checkNotNullExpressionValue(string2, "getString(R.string.n_import_failed_message)");
        AlertMessageConfig alertMessageConfig = new AlertMessageConfig(string, string2, this.this$0.getString(C4175R.string.retry), this.this$0.getString(C4175R.string.cancel));
        AlertMessageBottomSheet alertMessageBottomSheet = new AlertMessageBottomSheet();
        FragmentManager supportFragmentManager = this.this$0.getSupportFragmentManager();
        Intrinsics.checkNotNullExpressionValue(supportFragmentManager, "supportFragmentManager");
        alertMessageBottomSheet.show(supportFragmentManager, alertMessageConfig, new Function0<Unit>(this) {
            final /* synthetic */ MediaSelectionActivity$onCreate$14 this$0;

            {
                this.this$0 = r1;
            }

            public final void invoke() {
                this.this$0.this$0.getMediaImportViewModel().importItems(this.this$0.this$0.getMediaSelectionItemsAdapter().getItems());
            }
        });
    }
}
