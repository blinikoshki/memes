package com.giphy.sdk.p013ui;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.core.app.FrameMetricsAggregator;
import com.giphy.sdk.core.models.enums.RatingType;
import com.giphy.sdk.core.models.enums.RenditionType;
import com.giphy.sdk.p013ui.themes.GridType;
import com.giphy.sdk.p013ui.themes.Theme;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b-\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001Bi\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\u000e\b\u0002\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007\u0012\b\b\u0002\u0010\t\u001a\u00020\n\u0012\b\b\u0002\u0010\u000b\u001a\u00020\n\u0012\b\b\u0002\u0010\f\u001a\u00020\n\u0012\b\b\u0002\u0010\r\u001a\u00020\u000e\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0010\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0010¢\u0006\u0002\u0010\u0012J\t\u00102\u001a\u00020\u0003HÆ\u0003J\t\u00103\u001a\u00020\u0005HÆ\u0003J\u0014\u00104\u001a\b\u0012\u0004\u0012\u00020\b0\u0007HÆ\u0003¢\u0006\u0002\u0010 J\t\u00105\u001a\u00020\nHÆ\u0003J\t\u00106\u001a\u00020\nHÆ\u0003J\t\u00107\u001a\u00020\nHÆ\u0003J\t\u00108\u001a\u00020\u000eHÆ\u0003J\u000b\u00109\u001a\u0004\u0018\u00010\u0010HÆ\u0003J\u000b\u0010:\u001a\u0004\u0018\u00010\u0010HÆ\u0003Jr\u0010;\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\u000e\b\u0002\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u00072\b\b\u0002\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u000b\u001a\u00020\n2\b\b\u0002\u0010\f\u001a\u00020\n2\b\b\u0002\u0010\r\u001a\u00020\u000e2\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u00102\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0010HÆ\u0001¢\u0006\u0002\u0010<J\t\u0010=\u001a\u00020>HÖ\u0001J\u0013\u0010?\u001a\u00020\n2\b\u0010@\u001a\u0004\u0018\u00010AHÖ\u0003J\t\u0010B\u001a\u00020>HÖ\u0001J\t\u0010C\u001a\u00020DHÖ\u0001J\u0019\u0010E\u001a\u00020F2\u0006\u0010G\u001a\u00020H2\u0006\u0010I\u001a\u00020>HÖ\u0001R\u001c\u0010\u0011\u001a\u0004\u0018\u00010\u0010X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\u001a\u0010\t\u001a\u00020\nX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR\u001a\u0010\u0002\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001eR\"\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007X\u000e¢\u0006\u0010\n\u0002\u0010#\u001a\u0004\b\u001f\u0010 \"\u0004\b!\u0010\"R\u001a\u0010\r\u001a\u00020\u000eX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b$\u0010%\"\u0004\b&\u0010'R\u001c\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b(\u0010\u0014\"\u0004\b)\u0010\u0016R\u001a\u0010\f\u001a\u00020\nX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b*\u0010\u0018\"\u0004\b+\u0010\u001aR\u001a\u0010\u000b\u001a\u00020\nX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b,\u0010\u0018\"\u0004\b-\u0010\u001aR\u001a\u0010\u0004\u001a\u00020\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b.\u0010/\"\u0004\b0\u00101¨\u0006J"}, mo26107d2 = {"Lcom/giphy/sdk/ui/GPHSettings;", "Landroid/os/Parcelable;", "gridType", "Lcom/giphy/sdk/ui/themes/GridType;", "theme", "Lcom/giphy/sdk/ui/themes/Theme;", "mediaTypeConfig", "", "Lcom/giphy/sdk/ui/GPHContentType;", "dimBackground", "", "showConfirmationScreen", "showAttribution", "rating", "Lcom/giphy/sdk/core/models/enums/RatingType;", "renditionType", "Lcom/giphy/sdk/core/models/enums/RenditionType;", "confirmationRenditionType", "(Lcom/giphy/sdk/ui/themes/GridType;Lcom/giphy/sdk/ui/themes/Theme;[Lcom/giphy/sdk/ui/GPHContentType;ZZZLcom/giphy/sdk/core/models/enums/RatingType;Lcom/giphy/sdk/core/models/enums/RenditionType;Lcom/giphy/sdk/core/models/enums/RenditionType;)V", "getConfirmationRenditionType", "()Lcom/giphy/sdk/core/models/enums/RenditionType;", "setConfirmationRenditionType", "(Lcom/giphy/sdk/core/models/enums/RenditionType;)V", "getDimBackground", "()Z", "setDimBackground", "(Z)V", "getGridType", "()Lcom/giphy/sdk/ui/themes/GridType;", "setGridType", "(Lcom/giphy/sdk/ui/themes/GridType;)V", "getMediaTypeConfig", "()[Lcom/giphy/sdk/ui/GPHContentType;", "setMediaTypeConfig", "([Lcom/giphy/sdk/ui/GPHContentType;)V", "[Lcom/giphy/sdk/ui/GPHContentType;", "getRating", "()Lcom/giphy/sdk/core/models/enums/RatingType;", "setRating", "(Lcom/giphy/sdk/core/models/enums/RatingType;)V", "getRenditionType", "setRenditionType", "getShowAttribution", "setShowAttribution", "getShowConfirmationScreen", "setShowConfirmationScreen", "getTheme", "()Lcom/giphy/sdk/ui/themes/Theme;", "setTheme", "(Lcom/giphy/sdk/ui/themes/Theme;)V", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "(Lcom/giphy/sdk/ui/themes/GridType;Lcom/giphy/sdk/ui/themes/Theme;[Lcom/giphy/sdk/ui/GPHContentType;ZZZLcom/giphy/sdk/core/models/enums/RatingType;Lcom/giphy/sdk/core/models/enums/RenditionType;Lcom/giphy/sdk/core/models/enums/RenditionType;)Lcom/giphy/sdk/ui/GPHSettings;", "describeContents", "", "equals", "other", "", "hashCode", "toString", "", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "ui-sdk_release"}, mo26108k = 1, mo26109mv = {1, 1, 13})
/* renamed from: com.giphy.sdk.ui.GPHSettings */
/* compiled from: GPHSettings.kt */
public final class GPHSettings implements Parcelable {
    public static final Parcelable.Creator CREATOR = new Creator();
    private RenditionType confirmationRenditionType;
    private boolean dimBackground;
    private GridType gridType;
    private GPHContentType[] mediaTypeConfig;
    private RatingType rating;
    private RenditionType renditionType;
    private boolean showAttribution;
    private boolean showConfirmationScreen;
    private Theme theme;

    @Metadata(mo26105bv = {1, 0, 3}, mo26108k = 3, mo26109mv = {1, 1, 13})
    /* renamed from: com.giphy.sdk.ui.GPHSettings$Creator */
    public static class Creator implements Parcelable.Creator {
        public final Object createFromParcel(Parcel parcel) {
            Intrinsics.checkParameterIsNotNull(parcel, "in");
            GridType gridType = (GridType) Enum.valueOf(GridType.class, parcel.readString());
            Theme theme = (Theme) parcel.readParcelable(GPHSettings.class.getClassLoader());
            int readInt = parcel.readInt();
            GPHContentType[] gPHContentTypeArr = new GPHContentType[readInt];
            for (int i = 0; readInt > i; i++) {
                gPHContentTypeArr[i] = (GPHContentType) Enum.valueOf(GPHContentType.class, parcel.readString());
            }
            return new GPHSettings(gridType, theme, gPHContentTypeArr, parcel.readInt() != 0, parcel.readInt() != 0, parcel.readInt() != 0, (RatingType) Enum.valueOf(RatingType.class, parcel.readString()), parcel.readInt() != 0 ? (RenditionType) Enum.valueOf(RenditionType.class, parcel.readString()) : null, parcel.readInt() != 0 ? (RenditionType) Enum.valueOf(RenditionType.class, parcel.readString()) : null);
        }

        public final Object[] newArray(int i) {
            return new GPHSettings[i];
        }
    }

    public GPHSettings() {
        this((GridType) null, (Theme) null, (GPHContentType[]) null, false, false, false, (RatingType) null, (RenditionType) null, (RenditionType) null, FrameMetricsAggregator.EVERY_DURATION, (DefaultConstructorMarker) null);
    }

    public static /* synthetic */ GPHSettings copy$default(GPHSettings gPHSettings, GridType gridType2, Theme theme2, GPHContentType[] gPHContentTypeArr, boolean z, boolean z2, boolean z3, RatingType ratingType, RenditionType renditionType2, RenditionType renditionType3, int i, Object obj) {
        GPHSettings gPHSettings2 = gPHSettings;
        int i2 = i;
        return gPHSettings.copy((i2 & 1) != 0 ? gPHSettings2.gridType : gridType2, (i2 & 2) != 0 ? gPHSettings2.theme : theme2, (i2 & 4) != 0 ? gPHSettings2.mediaTypeConfig : gPHContentTypeArr, (i2 & 8) != 0 ? gPHSettings2.dimBackground : z, (i2 & 16) != 0 ? gPHSettings2.showConfirmationScreen : z2, (i2 & 32) != 0 ? gPHSettings2.showAttribution : z3, (i2 & 64) != 0 ? gPHSettings2.rating : ratingType, (i2 & 128) != 0 ? gPHSettings2.renditionType : renditionType2, (i2 & 256) != 0 ? gPHSettings2.confirmationRenditionType : renditionType3);
    }

    public final GridType component1() {
        return this.gridType;
    }

    public final Theme component2() {
        return this.theme;
    }

    public final GPHContentType[] component3() {
        return this.mediaTypeConfig;
    }

    public final boolean component4() {
        return this.dimBackground;
    }

    public final boolean component5() {
        return this.showConfirmationScreen;
    }

    public final boolean component6() {
        return this.showAttribution;
    }

    public final RatingType component7() {
        return this.rating;
    }

    public final RenditionType component8() {
        return this.renditionType;
    }

    public final RenditionType component9() {
        return this.confirmationRenditionType;
    }

    public final GPHSettings copy(GridType gridType2, Theme theme2, GPHContentType[] gPHContentTypeArr, boolean z, boolean z2, boolean z3, RatingType ratingType, RenditionType renditionType2, RenditionType renditionType3) {
        Intrinsics.checkParameterIsNotNull(gridType2, "gridType");
        Intrinsics.checkParameterIsNotNull(theme2, "theme");
        Intrinsics.checkParameterIsNotNull(gPHContentTypeArr, "mediaTypeConfig");
        RatingType ratingType2 = ratingType;
        Intrinsics.checkParameterIsNotNull(ratingType2, "rating");
        return new GPHSettings(gridType2, theme2, gPHContentTypeArr, z, z2, z3, ratingType2, renditionType2, renditionType3);
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this != obj) {
            if (obj instanceof GPHSettings) {
                GPHSettings gPHSettings = (GPHSettings) obj;
                if (Intrinsics.areEqual((Object) this.gridType, (Object) gPHSettings.gridType) && Intrinsics.areEqual((Object) this.theme, (Object) gPHSettings.theme) && Intrinsics.areEqual((Object) this.mediaTypeConfig, (Object) gPHSettings.mediaTypeConfig)) {
                    if (this.dimBackground == gPHSettings.dimBackground) {
                        if (this.showConfirmationScreen == gPHSettings.showConfirmationScreen) {
                            if (!(this.showAttribution == gPHSettings.showAttribution) || !Intrinsics.areEqual((Object) this.rating, (Object) gPHSettings.rating) || !Intrinsics.areEqual((Object) this.renditionType, (Object) gPHSettings.renditionType) || !Intrinsics.areEqual((Object) this.confirmationRenditionType, (Object) gPHSettings.confirmationRenditionType)) {
                                return false;
                            }
                        }
                    }
                }
            }
            return false;
        }
        return true;
    }

    public int hashCode() {
        GridType gridType2 = this.gridType;
        int i = 0;
        int hashCode = (gridType2 != null ? gridType2.hashCode() : 0) * 31;
        Theme theme2 = this.theme;
        int hashCode2 = (hashCode + (theme2 != null ? theme2.hashCode() : 0)) * 31;
        GPHContentType[] gPHContentTypeArr = this.mediaTypeConfig;
        int hashCode3 = (hashCode2 + (gPHContentTypeArr != null ? Arrays.hashCode(gPHContentTypeArr) : 0)) * 31;
        boolean z = this.dimBackground;
        boolean z2 = true;
        if (z) {
            z = true;
        }
        int i2 = (hashCode3 + (z ? 1 : 0)) * 31;
        boolean z3 = this.showConfirmationScreen;
        if (z3) {
            z3 = true;
        }
        int i3 = (i2 + (z3 ? 1 : 0)) * 31;
        boolean z4 = this.showAttribution;
        if (!z4) {
            z2 = z4;
        }
        int i4 = (i3 + (z2 ? 1 : 0)) * 31;
        RatingType ratingType = this.rating;
        int hashCode4 = (i4 + (ratingType != null ? ratingType.hashCode() : 0)) * 31;
        RenditionType renditionType2 = this.renditionType;
        int hashCode5 = (hashCode4 + (renditionType2 != null ? renditionType2.hashCode() : 0)) * 31;
        RenditionType renditionType3 = this.confirmationRenditionType;
        if (renditionType3 != null) {
            i = renditionType3.hashCode();
        }
        return hashCode5 + i;
    }

    public String toString() {
        return "GPHSettings(gridType=" + this.gridType + ", theme=" + this.theme + ", mediaTypeConfig=" + Arrays.toString(this.mediaTypeConfig) + ", dimBackground=" + this.dimBackground + ", showConfirmationScreen=" + this.showConfirmationScreen + ", showAttribution=" + this.showAttribution + ", rating=" + this.rating + ", renditionType=" + this.renditionType + ", confirmationRenditionType=" + this.confirmationRenditionType + ")";
    }

    public void writeToParcel(Parcel parcel, int i) {
        Intrinsics.checkParameterIsNotNull(parcel, "parcel");
        parcel.writeString(this.gridType.name());
        parcel.writeParcelable(this.theme, i);
        GPHContentType[] gPHContentTypeArr = this.mediaTypeConfig;
        int length = gPHContentTypeArr.length;
        parcel.writeInt(length);
        for (int i2 = 0; length > i2; i2++) {
            parcel.writeString(gPHContentTypeArr[i2].name());
        }
        parcel.writeInt(this.dimBackground ? 1 : 0);
        parcel.writeInt(this.showConfirmationScreen ? 1 : 0);
        parcel.writeInt(this.showAttribution ? 1 : 0);
        parcel.writeString(this.rating.name());
        RenditionType renditionType2 = this.renditionType;
        if (renditionType2 != null) {
            parcel.writeInt(1);
            parcel.writeString(renditionType2.name());
        } else {
            parcel.writeInt(0);
        }
        RenditionType renditionType3 = this.confirmationRenditionType;
        if (renditionType3 != null) {
            parcel.writeInt(1);
            parcel.writeString(renditionType3.name());
            return;
        }
        parcel.writeInt(0);
    }

    public GPHSettings(GridType gridType2, Theme theme2, GPHContentType[] gPHContentTypeArr, boolean z, boolean z2, boolean z3, RatingType ratingType, RenditionType renditionType2, RenditionType renditionType3) {
        Intrinsics.checkParameterIsNotNull(gridType2, "gridType");
        Intrinsics.checkParameterIsNotNull(theme2, "theme");
        Intrinsics.checkParameterIsNotNull(gPHContentTypeArr, "mediaTypeConfig");
        Intrinsics.checkParameterIsNotNull(ratingType, "rating");
        this.gridType = gridType2;
        this.theme = theme2;
        this.mediaTypeConfig = gPHContentTypeArr;
        this.dimBackground = z;
        this.showConfirmationScreen = z2;
        this.showAttribution = z3;
        this.rating = ratingType;
        this.renditionType = renditionType2;
        this.confirmationRenditionType = renditionType3;
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ GPHSettings(com.giphy.sdk.p013ui.themes.GridType r11, com.giphy.sdk.p013ui.themes.Theme r12, com.giphy.sdk.p013ui.GPHContentType[] r13, boolean r14, boolean r15, boolean r16, com.giphy.sdk.core.models.enums.RatingType r17, com.giphy.sdk.core.models.enums.RenditionType r18, com.giphy.sdk.core.models.enums.RenditionType r19, int r20, kotlin.jvm.internal.DefaultConstructorMarker r21) {
        /*
            r10 = this;
            r0 = r20
            r1 = r0 & 1
            if (r1 == 0) goto L_0x0009
            com.giphy.sdk.ui.themes.GridType r1 = com.giphy.sdk.p013ui.themes.GridType.waterfall
            goto L_0x000a
        L_0x0009:
            r1 = r11
        L_0x000a:
            r2 = r0 & 2
            if (r2 == 0) goto L_0x0013
            com.giphy.sdk.ui.themes.LightTheme r2 = com.giphy.sdk.p013ui.themes.LightTheme.INSTANCE
            com.giphy.sdk.ui.themes.Theme r2 = (com.giphy.sdk.p013ui.themes.Theme) r2
            goto L_0x0014
        L_0x0013:
            r2 = r12
        L_0x0014:
            r3 = r0 & 4
            r4 = 0
            r5 = 1
            if (r3 == 0) goto L_0x0030
            r3 = 4
            com.giphy.sdk.ui.GPHContentType[] r3 = new com.giphy.sdk.p013ui.GPHContentType[r3]
            com.giphy.sdk.ui.GPHContentType r6 = com.giphy.sdk.p013ui.GPHContentType.gif
            r3[r4] = r6
            com.giphy.sdk.ui.GPHContentType r6 = com.giphy.sdk.p013ui.GPHContentType.sticker
            r3[r5] = r6
            com.giphy.sdk.ui.GPHContentType r6 = com.giphy.sdk.p013ui.GPHContentType.text
            r7 = 2
            r3[r7] = r6
            r6 = 3
            com.giphy.sdk.ui.GPHContentType r7 = com.giphy.sdk.p013ui.GPHContentType.emoji
            r3[r6] = r7
            goto L_0x0031
        L_0x0030:
            r3 = r13
        L_0x0031:
            r6 = r0 & 8
            if (r6 == 0) goto L_0x0037
            r6 = 0
            goto L_0x0038
        L_0x0037:
            r6 = r14
        L_0x0038:
            r7 = r0 & 16
            if (r7 == 0) goto L_0x003d
            goto L_0x003e
        L_0x003d:
            r4 = r15
        L_0x003e:
            r7 = r0 & 32
            if (r7 == 0) goto L_0x0043
            goto L_0x0045
        L_0x0043:
            r5 = r16
        L_0x0045:
            r7 = r0 & 64
            if (r7 == 0) goto L_0x004c
            com.giphy.sdk.core.models.enums.RatingType r7 = com.giphy.sdk.core.models.enums.RatingType.pg13
            goto L_0x004e
        L_0x004c:
            r7 = r17
        L_0x004e:
            r8 = r0 & 128(0x80, float:1.794E-43)
            r9 = 0
            if (r8 == 0) goto L_0x0057
            r8 = r9
            com.giphy.sdk.core.models.enums.RenditionType r8 = (com.giphy.sdk.core.models.enums.RenditionType) r8
            goto L_0x0059
        L_0x0057:
            r8 = r18
        L_0x0059:
            r0 = r0 & 256(0x100, float:3.59E-43)
            if (r0 == 0) goto L_0x0061
            r0 = r9
            com.giphy.sdk.core.models.enums.RenditionType r0 = (com.giphy.sdk.core.models.enums.RenditionType) r0
            goto L_0x0063
        L_0x0061:
            r0 = r19
        L_0x0063:
            r11 = r10
            r12 = r1
            r13 = r2
            r14 = r3
            r15 = r6
            r16 = r4
            r17 = r5
            r18 = r7
            r19 = r8
            r20 = r0
            r11.<init>(r12, r13, r14, r15, r16, r17, r18, r19, r20)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.giphy.sdk.p013ui.GPHSettings.<init>(com.giphy.sdk.ui.themes.GridType, com.giphy.sdk.ui.themes.Theme, com.giphy.sdk.ui.GPHContentType[], boolean, boolean, boolean, com.giphy.sdk.core.models.enums.RatingType, com.giphy.sdk.core.models.enums.RenditionType, com.giphy.sdk.core.models.enums.RenditionType, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }

    public final GridType getGridType() {
        return this.gridType;
    }

    public final void setGridType(GridType gridType2) {
        Intrinsics.checkParameterIsNotNull(gridType2, "<set-?>");
        this.gridType = gridType2;
    }

    public final Theme getTheme() {
        return this.theme;
    }

    public final void setTheme(Theme theme2) {
        Intrinsics.checkParameterIsNotNull(theme2, "<set-?>");
        this.theme = theme2;
    }

    public final GPHContentType[] getMediaTypeConfig() {
        return this.mediaTypeConfig;
    }

    public final void setMediaTypeConfig(GPHContentType[] gPHContentTypeArr) {
        Intrinsics.checkParameterIsNotNull(gPHContentTypeArr, "<set-?>");
        this.mediaTypeConfig = gPHContentTypeArr;
    }

    public final boolean getDimBackground() {
        return this.dimBackground;
    }

    public final void setDimBackground(boolean z) {
        this.dimBackground = z;
    }

    public final boolean getShowConfirmationScreen() {
        return this.showConfirmationScreen;
    }

    public final void setShowConfirmationScreen(boolean z) {
        this.showConfirmationScreen = z;
    }

    public final boolean getShowAttribution() {
        return this.showAttribution;
    }

    public final void setShowAttribution(boolean z) {
        this.showAttribution = z;
    }

    public final RatingType getRating() {
        return this.rating;
    }

    public final void setRating(RatingType ratingType) {
        Intrinsics.checkParameterIsNotNull(ratingType, "<set-?>");
        this.rating = ratingType;
    }

    public final RenditionType getRenditionType() {
        return this.renditionType;
    }

    public final void setRenditionType(RenditionType renditionType2) {
        this.renditionType = renditionType2;
    }

    public final RenditionType getConfirmationRenditionType() {
        return this.confirmationRenditionType;
    }

    public final void setConfirmationRenditionType(RenditionType renditionType2) {
        this.confirmationRenditionType = renditionType2;
    }
}
