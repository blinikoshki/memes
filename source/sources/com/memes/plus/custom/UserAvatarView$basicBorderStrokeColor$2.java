package com.memes.plus.custom;

import android.content.Context;
import androidx.core.content.ContextCompat;
import com.memes.plus.C4199R;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\b\n\u0000\n\u0002\u0010\b\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, mo26107d2 = {"<anonymous>", "", "invoke"}, mo26108k = 3, mo26109mv = {1, 4, 2})
/* compiled from: UserAvatarView.kt */
final class UserAvatarView$basicBorderStrokeColor$2 extends Lambda implements Function0<Integer> {
    final /* synthetic */ Context $context;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    UserAvatarView$basicBorderStrokeColor$2(Context context) {
        super(0);
        this.$context = context;
    }

    public final int invoke() {
        return ContextCompat.getColor(this.$context, C4199R.C4201color.colorAccentDark);
    }
}
