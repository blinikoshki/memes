package editor.common.colorshadeselector;

import android.graphics.Color;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000e\n\u0002\u0010\u0002\n\u0002\b\u0002\b\u0000\u0018\u00002\u00020\u0001B\u000f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004B\u000f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006B'\b\u0016\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\u0006\u0010\b\u001a\u00020\u0003\u0012\u0006\u0010\t\u001a\u00020\u0003\u0012\u0006\u0010\n\u001a\u00020\u0003¢\u0006\u0002\u0010\u000bB\u0007\b\u0002¢\u0006\u0002\u0010\fJ\u000e\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0002\u001a\u00020\u0003J\u0006\u0010\u0015\u001a\u00020\u0003R\u001e\u0010\u0007\u001a\u00020\u00032\u0006\u0010\r\u001a\u00020\u0003@BX\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u001e\u0010\n\u001a\u00020\u00032\u0006\u0010\r\u001a\u00020\u0003@BX\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000fR\u001e\u0010\t\u001a\u00020\u00032\u0006\u0010\r\u001a\u00020\u0003@BX\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u000fR\u001e\u0010\b\u001a\u00020\u00032\u0006\u0010\r\u001a\u00020\u0003@BX\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u000f¨\u0006\u0016"}, mo26107d2 = {"Leditor/common/colorshadeselector/ArgbColor;", "", "color", "", "(I)V", "", "(Ljava/lang/String;)V", "alpha", "red", "green", "blue", "(IIII)V", "()V", "<set-?>", "getAlpha", "()I", "getBlue", "getGreen", "getRed", "setColor", "", "toInt", "editor_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
/* compiled from: ArgbColor.kt */
public final class ArgbColor {
    private int alpha;
    private int blue;
    private int green;
    private int red;

    private ArgbColor() {
    }

    public ArgbColor(int i) {
        this();
        setColor(i);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public ArgbColor(String str) {
        this(Color.parseColor(str));
        Intrinsics.checkNotNullParameter(str, TtmlNode.ATTR_TTS_COLOR);
    }

    public ArgbColor(int i, int i2, int i3, int i4) {
        this();
        this.alpha = i;
        this.red = i2;
        this.green = i3;
        this.blue = i4;
    }

    public final int getRed() {
        return this.red;
    }

    public final int getGreen() {
        return this.green;
    }

    public final int getBlue() {
        return this.blue;
    }

    public final int getAlpha() {
        return this.alpha;
    }

    public final void setColor(int i) {
        this.alpha = (i >> 24) & 255;
        this.red = (i >> 16) & 255;
        this.green = (i >> 8) & 255;
        this.blue = i & 255;
    }

    public final int toInt() {
        return Color.argb(this.alpha, this.red, this.green, this.blue);
    }
}
