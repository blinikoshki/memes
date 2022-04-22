package editor.optionsui.layout.background;

import android.content.Context;
import editor.common.assetsprovider.AssetsProvider;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, mo26107d2 = {"<anonymous>", "Leditor/common/assetsprovider/AssetsProvider;", "invoke"}, mo26108k = 3, mo26109mv = {1, 4, 2})
/* compiled from: LayoutBackgroundTabsFragment.kt */
final class LayoutBackgroundTabsFragment$assetsProvider$2 extends Lambda implements Function0<AssetsProvider> {
    final /* synthetic */ LayoutBackgroundTabsFragment this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    LayoutBackgroundTabsFragment$assetsProvider$2(LayoutBackgroundTabsFragment layoutBackgroundTabsFragment) {
        super(0);
        this.this$0 = layoutBackgroundTabsFragment;
    }

    public final AssetsProvider invoke() {
        AssetsProvider.Companion companion = AssetsProvider.Companion;
        Context requireContext = this.this$0.requireContext();
        Intrinsics.checkNotNullExpressionValue(requireContext, "requireContext()");
        return companion.from(requireContext);
    }
}
