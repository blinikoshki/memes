package editor.mediaselection;

import androidx.activity.result.ActivityResultCallback;
import androidx.lifecycle.Observer;
import editor.mediaselection.targetedmediabrowser.TargetedMediaSelectionConfig;
import kotlin.Metadata;
import kotlin.Pair;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, mo26107d2 = {"<anonymous>", "", "config", "Leditor/mediaselection/targetedmediabrowser/TargetedMediaSelectionConfig;", "kotlin.jvm.PlatformType", "onChanged"}, mo26108k = 3, mo26109mv = {1, 4, 2})
/* compiled from: MediaSelectionActivity.kt */
final class MediaSelectionActivity$onCreate$12<T> implements Observer<TargetedMediaSelectionConfig> {
    final /* synthetic */ MediaSelectionActivity this$0;

    MediaSelectionActivity$onCreate$12(MediaSelectionActivity mediaSelectionActivity) {
        this.this$0 = mediaSelectionActivity;
    }

    public final void onChanged(final TargetedMediaSelectionConfig targetedMediaSelectionConfig) {
        this.this$0.targetedMediaSelectionContractLauncher.launch(targetedMediaSelectionConfig, new ActivityResultCallback<Pair<? extends String, ? extends String>>(this) {
            final /* synthetic */ MediaSelectionActivity$onCreate$12 this$0;

            {
                this.this$0 = r1;
            }

            public final void onActivityResult(Pair<String, String> pair) {
                this.this$0.this$0.getViewModel().handleTargetedMediaSelectionResult(targetedMediaSelectionConfig.getSelectionTarget(), pair);
            }
        });
    }
}
