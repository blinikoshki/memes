package editor.mediaselection.targetedmediabrowser;

import android.content.Intent;
import android.view.View;
import com.google.gson.Gson;
import kotlin.Metadata;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, mo26107d2 = {"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"}, mo26108k = 3, mo26109mv = {1, 4, 2})
/* compiled from: TargetedMediaSelectionActivity.kt */
final class TargetedMediaSelectionActivity$onCreate$2 implements View.OnClickListener {
    final /* synthetic */ TargetedMediaSelectionActivity this$0;

    TargetedMediaSelectionActivity$onCreate$2(TargetedMediaSelectionActivity targetedMediaSelectionActivity) {
        this.this$0 = targetedMediaSelectionActivity;
    }

    public final void onClick(View view) {
        String json = new Gson().toJson((Object) this.this$0.newlySelectedItems.values());
        String json2 = new Gson().toJson((Object) this.this$0.selectedItemIds);
        Intent intent = new Intent();
        intent.putExtra(TargetedMediaSelectionActivityContract.EXTRA_NEWLY_SELECTED_ITEMS_JSON, json);
        intent.putExtra(TargetedMediaSelectionActivityContract.EXTRA_SELECTED_ITEM_IDS_JSON, json2);
        this.this$0.setResult(-1, intent);
        this.this$0.finish();
    }
}
