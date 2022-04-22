package com.giphy.sdk.p013ui.utils;

import kotlin.Metadata;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0010\u0011\n\u0002\b\u001c\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0014\u0010\u0003\u001a\u00020\u0004XD¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0007\u001a\u00020\u0004XD¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0006R\u0014\u0010\t\u001a\u00020\u0004XD¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u0006R\u0014\u0010\u000b\u001a\u00020\u0004XD¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u0006R\u0019\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00040\u000e¢\u0006\n\n\u0002\u0010\u0011\u001a\u0004\b\u000f\u0010\u0010R\u0014\u0010\u0012\u001a\u00020\u0004XD¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0006R\u0014\u0010\u0014\u001a\u00020\u0004XD¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0006R\u0014\u0010\u0016\u001a\u00020\u0004XD¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0006R\u0014\u0010\u0018\u001a\u00020\u0004XD¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0006R\u0014\u0010\u001a\u001a\u00020\u0004XD¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u0006R\u0014\u0010\u001c\u001a\u00020\u0004XD¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u0006R\u0014\u0010\u001e\u001a\u00020\u0004XD¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010\u0006R\u0014\u0010 \u001a\u00020\u0004XD¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\u0006R\u0014\u0010\"\u001a\u00020\u0004XD¢\u0006\b\n\u0000\u001a\u0004\b#\u0010\u0006R\u0011\u0010$\u001a\u00020\u00048F¢\u0006\u0006\u001a\u0004\b%\u0010\u0006R\u0014\u0010&\u001a\u00020\u0004XD¢\u0006\b\n\u0000\u001a\u0004\b'\u0010\u0006R\u0014\u0010(\u001a\u00020\u0004XD¢\u0006\b\n\u0000\u001a\u0004\b)\u0010\u0006¨\u0006*"}, mo26107d2 = {"Lcom/giphy/sdk/ui/utils/GPHColor;", "", "()V", "black", "", "getBlack", "()I", "giphyAqua", "getGiphyAqua", "giphyBlack", "getGiphyBlack", "giphyBlue", "getGiphyBlue", "giphyColors", "", "getGiphyColors", "()[Ljava/lang/Integer;", "[Ljava/lang/Integer;", "giphyDarkGrey", "getGiphyDarkGrey", "giphyGreen", "getGiphyGreen", "giphyIndigo", "getGiphyIndigo", "giphyLightGrey", "getGiphyLightGrey", "giphyLightestGrey", "getGiphyLightestGrey", "giphyPink", "getGiphyPink", "giphyPurple", "getGiphyPurple", "giphyRed", "getGiphyRed", "giphyYellow", "getGiphyYellow", "randomColor", "getRandomColor", "transparent", "getTransparent", "white", "getWhite", "ui-sdk_release"}, mo26108k = 1, mo26109mv = {1, 1, 13})
/* renamed from: com.giphy.sdk.ui.utils.GPHColor */
/* compiled from: ColorExtensions.kt */
public final class GPHColor {
    public static final GPHColor INSTANCE = new GPHColor();
    private static final int black = -16777216;
    private static final int giphyAqua;
    private static final int giphyBlack = ((int) 4279374354L);
    private static final int giphyBlue;
    private static final Integer[] giphyColors;
    private static final int giphyDarkGrey = ((int) 4281216558L);
    private static final int giphyGreen = ((int) 4278255513L);
    private static final int giphyIndigo;
    private static final int giphyLightGrey = ((int) 4289111718L);
    private static final int giphyLightestGrey = ((int) 4293256677L);
    private static final int giphyPink;
    private static final int giphyPurple;
    private static final int giphyRed = ((int) 4294927974L);
    private static final int giphyYellow = ((int) 4294964060L);
    private static final int transparent = 0;
    private static final int white = -1;

    static {
        int i = (int) 4278242559L;
        giphyBlue = i;
        int i2 = (int) 4288230399L;
        giphyPurple = i2;
        int i3 = (int) 4284569599L;
        giphyIndigo = i3;
        int i4 = (int) 4293281462L;
        giphyPink = i4;
        int i5 = (int) 4278249164L;
        giphyAqua = i5;
        giphyColors = new Integer[]{Integer.valueOf(i5), Integer.valueOf(i4), Integer.valueOf(i3), Integer.valueOf(i), Integer.valueOf(i2)};
    }

    private GPHColor() {
    }

    public final int getTransparent() {
        return transparent;
    }

    public final int getWhite() {
        return white;
    }

    public final int getBlack() {
        return black;
    }

    public final int getGiphyBlack() {
        return giphyBlack;
    }

    public final int getGiphyLightestGrey() {
        return giphyLightestGrey;
    }

    public final int getGiphyLightGrey() {
        return giphyLightGrey;
    }

    public final int getGiphyDarkGrey() {
        return giphyDarkGrey;
    }

    public final int getGiphyGreen() {
        return giphyGreen;
    }

    public final int getGiphyBlue() {
        return giphyBlue;
    }

    public final int getGiphyPurple() {
        return giphyPurple;
    }

    public final int getGiphyIndigo() {
        return giphyIndigo;
    }

    public final int getGiphyRed() {
        return giphyRed;
    }

    public final int getGiphyYellow() {
        return giphyYellow;
    }

    public final int getGiphyPink() {
        return giphyPink;
    }

    public final int getGiphyAqua() {
        return giphyAqua;
    }

    public final int getRandomColor() {
        Integer[] numArr = giphyColors;
        return numArr[((int) (Math.random() % ((double) 100))) % numArr.length].intValue();
    }

    public final Integer[] getGiphyColors() {
        return giphyColors;
    }
}
