package editor.tools.filters;

import androidx.fragment.app.FragmentContainerView;
import androidx.fragment.app.FragmentManager;
import editor.transporter.FragmentManagerUtil;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, mo26107d2 = {"<anonymous>", "Leditor/transporter/FragmentManagerUtil;", "invoke"}, mo26108k = 3, mo26109mv = {1, 4, 2})
/* compiled from: FiltersActivity.kt */
final class FiltersActivity$fragmentManagerUtil$2 extends Lambda implements Function0<FragmentManagerUtil> {
    final /* synthetic */ FiltersActivity this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    FiltersActivity$fragmentManagerUtil$2(FiltersActivity filtersActivity) {
        super(0);
        this.this$0 = filtersActivity;
    }

    public final FragmentManagerUtil invoke() {
        FragmentContainerView fragmentContainerView = this.this$0.getBinding().filtersFragmentContainer;
        Intrinsics.checkNotNullExpressionValue(fragmentContainerView, "binding.filtersFragmentContainer");
        int id = fragmentContainerView.getId();
        FragmentManager supportFragmentManager = this.this$0.getSupportFragmentManager();
        Intrinsics.checkNotNullExpressionValue(supportFragmentManager, "supportFragmentManager");
        return new FragmentManagerUtil(id, supportFragmentManager);
    }
}
