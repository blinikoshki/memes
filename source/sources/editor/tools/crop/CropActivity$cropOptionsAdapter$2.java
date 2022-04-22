package editor.tools.crop;

import editor.tools.crop.CropOption;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, mo26107d2 = {"<anonymous>", "Leditor/tools/crop/CropOptionsAdapter;", "invoke"}, mo26108k = 3, mo26109mv = {1, 4, 2})
/* compiled from: CropActivity.kt */
final class CropActivity$cropOptionsAdapter$2 extends Lambda implements Function0<CropOptionsAdapter> {
    final /* synthetic */ CropActivity this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    CropActivity$cropOptionsAdapter$2(CropActivity cropActivity) {
        super(0);
        this.this$0 = cropActivity;
    }

    public final CropOptionsAdapter invoke() {
        return new CropOptionsAdapter(this.this$0, new Function1<CropOption.Preview, Unit>(this) {
            final /* synthetic */ CropActivity$cropOptionsAdapter$2 this$0;

            {
                this.this$0 = r1;
            }

            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((CropOption.Preview) obj);
                return Unit.INSTANCE;
            }

            public final void invoke(CropOption.Preview preview) {
                Intrinsics.checkNotNullParameter(preview, "cropOption");
                this.this$0.this$0.onCropOptionSelected(preview);
            }
        });
    }
}
