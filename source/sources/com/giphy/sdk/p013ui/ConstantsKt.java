package com.giphy.sdk.p013ui;

import java.util.List;
import java.util.Random;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\u0016\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\b\u0005\u001a\u0006\u0010\b\u001a\u00020\u0001\u001a\u000e\u0010\b\u001a\u00020\u00012\u0006\u0010\t\u001a\u00020\u0001\"\u000e\u0010\u0000\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u0002\u001a\u00020\u0003XT¢\u0006\u0002\n\u0000\"\u0017\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\n"}, mo26107d2 = {"GIF_QUERY_LIMIT", "", "GIPHY_GIF_LINK", "", "PLACEHOLDER_COLORS", "", "getPLACEHOLDER_COLORS", "()Ljava/util/List;", "getPlaceholderColor", "position", "ui-sdk_release"}, mo26108k = 2, mo26109mv = {1, 1, 13})
/* renamed from: com.giphy.sdk.ui.ConstantsKt */
/* compiled from: Constants.kt */
public final class ConstantsKt {
    public static final int GIF_QUERY_LIMIT = 25;
    public static final String GIPHY_GIF_LINK = "https://giphy.com/gifs/";
    private static final List<Integer> PLACEHOLDER_COLORS = CollectionsKt.listOf(Integer.valueOf((int) 4294927974L), Integer.valueOf((int) 4288230399L), Integer.valueOf((int) 4278255513L), Integer.valueOf((int) 4278242559L), Integer.valueOf((int) 4294964060L));

    public static final List<Integer> getPLACEHOLDER_COLORS() {
        return PLACEHOLDER_COLORS;
    }

    public static final int getPlaceholderColor(int i) {
        List<Integer> list = PLACEHOLDER_COLORS;
        return list.get(i % list.size()).intValue();
    }

    public static final int getPlaceholderColor() {
        List<Integer> list = PLACEHOLDER_COLORS;
        return list.get(new Random().nextInt(list.size() - 1)).intValue();
    }
}
