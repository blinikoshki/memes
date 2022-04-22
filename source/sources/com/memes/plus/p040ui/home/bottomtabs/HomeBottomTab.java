package com.memes.plus.p040ui.home.bottomtabs;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0018\n\u0002\u0010\u0002\n\u0002\b\u0005\b\b\u0018\u0000 )2\u00020\u0001:\u0001)B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\t\u0010\u0016\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0017\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\u0018\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u0019\u001a\u00020\f2\b\u0010\u001a\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\b\u0010\u001b\u001a\u0004\u0018\u00010\u0005J\b\u0010\u001c\u001a\u0004\u0018\u00010\u0005J\r\u0010\u001d\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u001eJ\t\u0010\u001f\u001a\u00020\u0003HÖ\u0001J\u0010\u0010 \u001a\u00020\u00002\b\u0010!\u001a\u0004\u0018\u00010\u0005J\u000e\u0010\"\u001a\u00020\u00002\u0006\u0010\b\u001a\u00020\u0005J\u0010\u0010#\u001a\u00020\u00002\b\b\u0001\u0010\t\u001a\u00020\u0003J\u000e\u0010$\u001a\u00020%2\u0006\u0010&\u001a\u00020\fJ\u000e\u0010'\u001a\u00020%2\u0006\u0010&\u001a\u00020\fJ\t\u0010(\u001a\u00020\u0005HÖ\u0001R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\u0005X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u0004\u0018\u00010\u0005X\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\t\u001a\u0004\u0018\u00010\u0003X\u000e¢\u0006\u0004\n\u0002\u0010\nR\u001e\u0010\r\u001a\u00020\f2\u0006\u0010\u000b\u001a\u00020\f@BX\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u001e\u0010\u0012\u001a\u00020\f2\u0006\u0010\u000b\u001a\u00020\f@BX\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u000fR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015¨\u0006*"}, mo26107d2 = {"Lcom/memes/plus/ui/home/bottomtabs/HomeBottomTab;", "", "id", "", "title", "", "(ILjava/lang/String;)V", "badgeText", "iconPath", "iconRes", "Ljava/lang/Integer;", "<set-?>", "", "iconRoundingAllowed", "getIconRoundingAllowed", "()Z", "getId", "()I", "tintAllowed", "getTintAllowed", "getTitle", "()Ljava/lang/String;", "component1", "component2", "copy", "equals", "other", "getBadgeText", "getIconPath", "getIconResource", "()Ljava/lang/Integer;", "hashCode", "setBadgeText", "text", "setIconPath", "setIconResource", "setIconRoundingAllowed", "", "allowed", "setTintAllowed", "toString", "Companion", "app_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
/* renamed from: com.memes.plus.ui.home.bottomtabs.HomeBottomTab */
/* compiled from: HomeBottomTab.kt */
public final class HomeBottomTab {
    public static final int CHAT = 3;
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    public static final int EDITOR = 2;
    public static final int EXPLORE = 1;
    public static final int FEED = 0;
    public static final int PROFILE = 4;
    private String badgeText;
    private String iconPath;
    private Integer iconRes;
    private boolean iconRoundingAllowed;

    /* renamed from: id */
    private final int f1030id;
    private boolean tintAllowed = true;
    private final String title;

    public static /* synthetic */ HomeBottomTab copy$default(HomeBottomTab homeBottomTab, int i, String str, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = homeBottomTab.f1030id;
        }
        if ((i2 & 2) != 0) {
            str = homeBottomTab.title;
        }
        return homeBottomTab.copy(i, str);
    }

    public final int component1() {
        return this.f1030id;
    }

    public final String component2() {
        return this.title;
    }

    public final HomeBottomTab copy(int i, String str) {
        Intrinsics.checkNotNullParameter(str, "title");
        return new HomeBottomTab(i, str);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof HomeBottomTab)) {
            return false;
        }
        HomeBottomTab homeBottomTab = (HomeBottomTab) obj;
        return this.f1030id == homeBottomTab.f1030id && Intrinsics.areEqual((Object) this.title, (Object) homeBottomTab.title);
    }

    public int hashCode() {
        int i = this.f1030id * 31;
        String str = this.title;
        return i + (str != null ? str.hashCode() : 0);
    }

    public String toString() {
        return "HomeBottomTab(id=" + this.f1030id + ", title=" + this.title + ")";
    }

    public HomeBottomTab(int i, String str) {
        Intrinsics.checkNotNullParameter(str, "title");
        this.f1030id = i;
        this.title = str;
    }

    public final int getId() {
        return this.f1030id;
    }

    public final String getTitle() {
        return this.title;
    }

    @Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\t"}, mo26107d2 = {"Lcom/memes/plus/ui/home/bottomtabs/HomeBottomTab$Companion;", "", "()V", "CHAT", "", "EDITOR", "EXPLORE", "FEED", "PROFILE", "app_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
    /* renamed from: com.memes.plus.ui.home.bottomtabs.HomeBottomTab$Companion */
    /* compiled from: HomeBottomTab.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public final boolean getTintAllowed() {
        return this.tintAllowed;
    }

    public final boolean getIconRoundingAllowed() {
        return this.iconRoundingAllowed;
    }

    public final Integer getIconResource() {
        Integer num = this.iconRes;
        if (num != null && num.intValue() == 0) {
            return null;
        }
        return this.iconRes;
    }

    public final HomeBottomTab setIconResource(int i) {
        this.iconRes = Integer.valueOf(i);
        this.iconPath = null;
        return this;
    }

    public final String getIconPath() {
        CharSequence charSequence = this.iconPath;
        if (charSequence == null || StringsKt.isBlank(charSequence)) {
            return null;
        }
        return this.iconPath;
    }

    public final HomeBottomTab setIconPath(String str) {
        Intrinsics.checkNotNullParameter(str, "iconPath");
        this.iconRes = 0;
        this.iconPath = str;
        return this;
    }

    public final void setTintAllowed(boolean z) {
        this.tintAllowed = z;
    }

    public final void setIconRoundingAllowed(boolean z) {
        this.iconRoundingAllowed = z;
    }

    public final String getBadgeText() {
        return this.badgeText;
    }

    public final HomeBottomTab setBadgeText(String str) {
        this.badgeText = str;
        return this;
    }
}
