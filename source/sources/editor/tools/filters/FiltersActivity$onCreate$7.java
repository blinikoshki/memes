package editor.tools.filters;

import android.content.Intent;
import androidx.lifecycle.Observer;
import editor.tools.filters.conflation.FilterResult;
import kotlin.Metadata;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, mo26107d2 = {"<anonymous>", "", "filterResult", "Leditor/tools/filters/conflation/FilterResult;", "kotlin.jvm.PlatformType", "onChanged"}, mo26108k = 3, mo26109mv = {1, 4, 2})
/* compiled from: FiltersActivity.kt */
final class FiltersActivity$onCreate$7<T> implements Observer<FilterResult> {
    final /* synthetic */ FiltersActivity this$0;

    FiltersActivity$onCreate$7(FiltersActivity filtersActivity) {
        this.this$0 = filtersActivity;
    }

    public final void onChanged(FilterResult filterResult) {
        Intent intent = new Intent();
        intent.putExtra(FiltersActivity.EXTRA_FILTER_RESULT, filterResult);
        this.this$0.setResult(-1, intent);
        this.this$0.finish();
    }
}
