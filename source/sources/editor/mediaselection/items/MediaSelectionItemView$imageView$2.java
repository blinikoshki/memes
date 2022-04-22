package editor.mediaselection.items;

import android.content.Context;
import android.util.TypedValue;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.core.content.ContextCompat;
import com.memes.editor.C4175R;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, mo26107d2 = {"<anonymous>", "Landroid/widget/ImageView;", "invoke"}, mo26108k = 3, mo26109mv = {1, 4, 2})
/* compiled from: MediaSelectionItemView.kt */
final class MediaSelectionItemView$imageView$2 extends Lambda implements Function0<ImageView> {
    final /* synthetic */ Context $context;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    MediaSelectionItemView$imageView$2(Context context) {
        super(0);
        this.$context = context;
    }

    public final ImageView invoke() {
        ImageView imageView = new ImageView(this.$context);
        TypedValue typedValue = new TypedValue();
        this.$context.getTheme().resolveAttribute(C4175R.attr.colorSurfaceDark, typedValue, true);
        imageView.setBackgroundColor(ContextCompat.getColor(this.$context, typedValue.resourceId));
        imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
        imageView.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        return imageView;
    }
}
