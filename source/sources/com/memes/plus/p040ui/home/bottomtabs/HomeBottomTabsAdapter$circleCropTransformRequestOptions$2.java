package com.memes.plus.p040ui.home.bottomtabs;

import com.bumptech.glide.request.RequestOptions;
import com.memes.plus.C4199R;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, mo26107d2 = {"<anonymous>", "Lcom/bumptech/glide/request/RequestOptions;", "invoke"}, mo26108k = 3, mo26109mv = {1, 4, 2})
/* renamed from: com.memes.plus.ui.home.bottomtabs.HomeBottomTabsAdapter$circleCropTransformRequestOptions$2 */
/* compiled from: HomeBottomTabsAdapter.kt */
final class HomeBottomTabsAdapter$circleCropTransformRequestOptions$2 extends Lambda implements Function0<RequestOptions> {
    public static final HomeBottomTabsAdapter$circleCropTransformRequestOptions$2 INSTANCE = new HomeBottomTabsAdapter$circleCropTransformRequestOptions$2();

    HomeBottomTabsAdapter$circleCropTransformRequestOptions$2() {
        super(0);
    }

    public final RequestOptions invoke() {
        return (RequestOptions) RequestOptions.circleCropTransform().error((int) C4199R.C4202drawable.ic_error);
    }
}
