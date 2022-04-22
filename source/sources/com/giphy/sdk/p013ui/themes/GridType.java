package com.giphy.sdk.p013ui.themes;

import kotlin.Metadata;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0006\u0010\u0003\u001a\u00020\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007¨\u0006\b"}, mo26107d2 = {"Lcom/giphy/sdk/ui/themes/GridType;", "", "(Ljava/lang/String;I)V", "hasSearchBar", "", "waterfall", "carousel", "emoji", "ui-sdk_release"}, mo26108k = 1, mo26109mv = {1, 1, 13})
/* renamed from: com.giphy.sdk.ui.themes.GridType */
/* compiled from: GridType.kt */
public enum GridType {
    waterfall,
    carousel,
    emoji;

    public final boolean hasSearchBar() {
        GridType gridType = this;
        return gridType == waterfall || gridType == carousel;
    }
}
