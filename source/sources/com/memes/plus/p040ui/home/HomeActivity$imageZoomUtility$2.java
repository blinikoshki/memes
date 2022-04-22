package com.memes.plus.p040ui.home;

import com.memes.plus.util.zoom.ImageZoomUtility;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, mo26107d2 = {"<anonymous>", "Lcom/memes/plus/util/zoom/ImageZoomUtility;", "invoke"}, mo26108k = 3, mo26109mv = {1, 4, 2})
/* renamed from: com.memes.plus.ui.home.HomeActivity$imageZoomUtility$2 */
/* compiled from: HomeActivity.kt */
final class HomeActivity$imageZoomUtility$2 extends Lambda implements Function0<ImageZoomUtility> {
    public static final HomeActivity$imageZoomUtility$2 INSTANCE = new HomeActivity$imageZoomUtility$2();

    HomeActivity$imageZoomUtility$2() {
        super(0);
    }

    public final ImageZoomUtility invoke() {
        return ImageZoomUtility.Companion.getInstance();
    }
}
