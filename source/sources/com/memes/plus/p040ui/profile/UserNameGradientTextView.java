package com.memes.plus.p040ui.profile;

import android.content.Context;
import android.graphics.LinearGradient;
import android.graphics.Shader;
import android.text.TextPaint;
import android.util.AttributeSet;
import android.widget.TextView;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\b\u0010\t\u001a\u00020\nH\u0002J\b\u0010\u000b\u001a\u00020\nH\u0002J0\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\b2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0012\u001a\u00020\u00102\u0006\u0010\u0013\u001a\u00020\u0010H\u0014J\u000e\u0010\u0014\u001a\u00020\r2\u0006\u0010\u0007\u001a\u00020\bR\u000e\u0010\u0007\u001a\u00020\bX\u000e¢\u0006\u0002\n\u0000¨\u0006\u0015"}, mo26107d2 = {"Lcom/memes/plus/ui/profile/UserNameGradientTextView;", "Landroid/widget/TextView;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "isProUser", "", "createNormalGradient", "Landroid/graphics/LinearGradient;", "createProGradient", "onLayout", "", "changed", "left", "", "top", "right", "bottom", "setProUser", "app_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
/* renamed from: com.memes.plus.ui.profile.UserNameGradientTextView */
/* compiled from: UserNameGradientTextView.kt */
public final class UserNameGradientTextView extends TextView {
    private boolean isProUser;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public UserNameGradientTextView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(attributeSet, "attrs");
    }

    public final void setProUser(boolean z) {
        this.isProUser = z;
    }

    /* access modifiers changed from: protected */
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        Shader shader;
        super.onLayout(z, i, i2, i3, i4);
        if (z) {
            TextPaint paint = getPaint();
            Intrinsics.checkNotNullExpressionValue(paint, "paint");
            if (this.isProUser) {
                shader = createProGradient();
            } else {
                shader = createNormalGradient();
            }
            paint.setShader(shader);
        }
    }

    private final LinearGradient createProGradient() {
        return new LinearGradient(0.0f, 0.0f, (float) getWidth(), (float) getHeight(), (int) 4294960426L, (int) 4294920812L, Shader.TileMode.CLAMP);
    }

    private final LinearGradient createNormalGradient() {
        return new LinearGradient(0.0f, 0.0f, (float) getWidth(), (float) getHeight(), (int) 4281264886L, (int) 4282513807L, Shader.TileMode.CLAMP);
    }
}
