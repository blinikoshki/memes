package editor.tools.filters.deepfryfilters;

import android.view.LayoutInflater;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\n \u0002*\u0004\u0018\u00010\u00010\u0001H\n¢\u0006\u0002\b\u0003"}, mo26107d2 = {"<anonymous>", "Landroid/view/LayoutInflater;", "kotlin.jvm.PlatformType", "invoke"}, mo26108k = 3, mo26109mv = {1, 4, 2})
/* compiled from: DeepFryFiltersAdapter.kt */
final class DeepFryFiltersAdapter$layoutInflater$2 extends Lambda implements Function0<LayoutInflater> {
    final /* synthetic */ DeepFryFiltersAdapter this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    DeepFryFiltersAdapter$layoutInflater$2(DeepFryFiltersAdapter deepFryFiltersAdapter) {
        super(0);
        this.this$0 = deepFryFiltersAdapter;
    }

    public final LayoutInflater invoke() {
        return LayoutInflater.from(this.this$0.context);
    }
}
