package p015io.noties.markwon.utils;

import android.content.Context;

/* renamed from: io.noties.markwon.utils.Dip */
public class Dip {
    private final float density;

    public static Dip create(Context context) {
        return new Dip(context.getResources().getDisplayMetrics().density);
    }

    public static Dip create(float f) {
        return new Dip(f);
    }

    public Dip(float f) {
        this.density = f;
    }

    public int toPx(int i) {
        return (int) ((((float) i) * this.density) + 0.5f);
    }
}
