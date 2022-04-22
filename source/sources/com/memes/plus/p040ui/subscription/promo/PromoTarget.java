package com.memes.plus.p040ui.subscription.promo;

import com.memes.plus.C4199R;
import java.util.EnumSet;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000b\b\u0001\u0018\u0000 \u000f2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u000fB\u0019\b\u0002\u0012\b\b\u0001\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000e¨\u0006\u0010"}, mo26107d2 = {"Lcom/memes/plus/ui/subscription/promo/PromoTarget;", "", "imageRes", "", "promoLine", "", "(Ljava/lang/String;IILjava/lang/String;)V", "getImageRes", "()I", "getPromoLine", "()Ljava/lang/String;", "FONTS", "WATERMARK", "TRIM_DURATION", "FREESTYLE_FRAME", "Companion", "app_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
/* renamed from: com.memes.plus.ui.subscription.promo.PromoTarget */
/* compiled from: PromoTarget.kt */
public enum PromoTarget {
    FONTS(C4199R.C4202drawable.promo_unlimited_fonts, "Access To Exclusive\nFonts"),
    WATERMARK(C4199R.C4202drawable.promo_remove_watermark, "Remove Memes Watermark"),
    TRIM_DURATION(C4199R.C4202drawable.promo_trim_duration, "Increase Video\nDuration"),
    FREESTYLE_FRAME(C4199R.C4202drawable.promo_freestyle_frame, "Access the Freestyle Frame");
    
    public static final Companion Companion = null;
    private final int imageRes;
    private final String promoLine;

    private PromoTarget(int i, String str) {
        this.imageRes = i;
        this.promoLine = str;
    }

    public final int getImageRes() {
        return this.imageRes;
    }

    public final String getPromoLine() {
        return this.promoLine;
    }

    static {
        Companion = new Companion((DefaultConstructorMarker) null);
    }

    @Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004¨\u0006\u0006"}, mo26107d2 = {"Lcom/memes/plus/ui/subscription/promo/PromoTarget$Companion;", "", "()V", "all", "", "Lcom/memes/plus/ui/subscription/promo/PromoTarget;", "app_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
    /* renamed from: com.memes.plus.ui.subscription.promo.PromoTarget$Companion */
    /* compiled from: PromoTarget.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final List<PromoTarget> all() {
            EnumSet<E> allOf = EnumSet.allOf(PromoTarget.class);
            Intrinsics.checkNotNullExpressionValue(allOf, "EnumSet.allOf(PromoTarget::class.java)");
            return CollectionsKt.toList(allOf);
        }
    }
}
