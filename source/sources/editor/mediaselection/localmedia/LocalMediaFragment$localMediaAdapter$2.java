package editor.mediaselection.localmedia;

import androidx.fragment.app.FragmentActivity;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, mo26107d2 = {"<anonymous>", "Leditor/mediaselection/localmedia/LocalMediaAdapter;", "invoke"}, mo26108k = 3, mo26109mv = {1, 4, 2})
/* compiled from: LocalMediaFragment.kt */
final class LocalMediaFragment$localMediaAdapter$2 extends Lambda implements Function0<LocalMediaAdapter> {
    final /* synthetic */ LocalMediaFragment this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    LocalMediaFragment$localMediaAdapter$2(LocalMediaFragment localMediaFragment) {
        super(0);
        this.this$0 = localMediaFragment;
    }

    public final LocalMediaAdapter invoke() {
        FragmentActivity requireActivity = this.this$0.requireActivity();
        Intrinsics.checkNotNullExpressionValue(requireActivity, "requireActivity()");
        return new LocalMediaAdapter(requireActivity, new Function2<LocalMedia, Boolean, Boolean>(this) {
            final /* synthetic */ LocalMediaFragment$localMediaAdapter$2 this$0;

            {
                this.this$0 = r1;
            }

            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                return Boolean.valueOf(invoke((LocalMedia) obj, ((Boolean) obj2).booleanValue()));
            }

            public final boolean invoke(LocalMedia localMedia, boolean z) {
                Intrinsics.checkNotNullParameter(localMedia, "mediaContent");
                return LocalMediaFragment.access$getLocalMediaSelectedListener$p(this.this$0.this$0).onLocalMediaSelected(localMedia, z);
            }
        });
    }
}
