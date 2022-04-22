package com.giphy.sdk.p013ui.views;

import android.view.View;
import com.giphy.sdk.core.models.Media;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\n¢\u0006\u0002\b\u0006"}, mo26107d2 = {"<anonymous>", "", "media", "Lcom/giphy/sdk/core/models/Media;", "anchor", "Landroid/view/View;", "invoke"}, mo26108k = 3, mo26109mv = {1, 1, 13})
/* renamed from: com.giphy.sdk.ui.views.GifsRecyclerView$onGifLongPressListener$1 */
/* compiled from: GifsRecyclerView.kt */
final class GifsRecyclerView$onGifLongPressListener$1 extends Lambda implements Function2<Media, View, Unit> {
    public static final GifsRecyclerView$onGifLongPressListener$1 INSTANCE = new GifsRecyclerView$onGifLongPressListener$1();

    GifsRecyclerView$onGifLongPressListener$1() {
        super(2);
    }

    public final void invoke(Media media, View view) {
        Intrinsics.checkParameterIsNotNull(media, "media");
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((Media) obj, (View) obj2);
        return Unit.INSTANCE;
    }
}
