package coil;

import android.content.Context;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\"\u0016\u0010\u0000\u001a\u00020\u0001*\u00020\u00028Ç\u0002¢\u0006\u0006\u001a\u0004\b\u0000\u0010\u0003¨\u0006\u0004"}, mo26107d2 = {"imageLoader", "Lcoil/ImageLoader;", "Landroid/content/Context;", "(Landroid/content/Context;)Lcoil/ImageLoader;", "coil-singleton_release"}, mo26108k = 2, mo26109mv = {1, 4, 1})
/* compiled from: Contexts.kt */
public final class Contexts {
    public static final ImageLoader imageLoader(Context context) {
        Intrinsics.checkNotNullParameter(context, "$this$imageLoader");
        return Coil.imageLoader(context);
    }
}
