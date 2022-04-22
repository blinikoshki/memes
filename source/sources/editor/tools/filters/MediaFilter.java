package editor.tools.filters;

import android.os.Parcel;
import android.os.Parcelable;
import editor.gpu.conflation.GlConflatedFilter;
import editor.gpu.util.ImageFilterRange;
import editor.gpu.util.VideoFilterRange;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0001\u0018\u00002\u00020\u0001BO\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0005\u0012\b\b\u0002\u0010\b\u001a\u00020\u0005\u0012\b\b\u0002\u0010\t\u001a\u00020\u0005\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b¢\u0006\u0002\u0010\fJ\u0006\u0010\u0012\u001a\u00020\u0013J\u0006\u0010\u0014\u001a\u00020\u0013J\u0006\u0010\u0015\u001a\u00020\u0013J\u0006\u0010\u0016\u001a\u00020\u0013J\u0006\u0010\u0017\u001a\u00020\u0013J\u0006\u0010\u0018\u001a\u00020\u0013J\u0006\u0010\u0019\u001a\u00020\u0013J\u0006\u0010\u001a\u001a\u00020\u0000J\t\u0010\u001b\u001a\u00020\u0003HÖ\u0001J\u0006\u0010\u001c\u001a\u00020\u0005J\b\u0010\u001d\u001a\u0004\u0018\u00010\u001eJ\u0006\u0010\u001f\u001a\u00020\u0005J\u0006\u0010 \u001a\u00020\u0005J\u0006\u0010!\u001a\u00020\u0005J\u0006\u0010\"\u001a\u00020\u0005J\u0006\u0010#\u001a\u00020\u0005J\u0006\u0010$\u001a\u00020\u0005J\u0006\u0010%\u001a\u00020\u0005J\u0006\u0010&\u001a\u00020\u0005J\u0006\u0010'\u001a\u00020\u0005J\u0006\u0010(\u001a\u00020)J\u0006\u0010*\u001a\u00020)J\u0006\u0010+\u001a\u00020)J\u0006\u0010,\u001a\u00020)J\u0006\u0010-\u001a\u00020)J\u0006\u0010.\u001a\u00020)J\u000e\u0010/\u001a\u00020\u00132\u0006\u00100\u001a\u00020\u001eJ\u000e\u00101\u001a\u00020\u00132\u0006\u0010\u0006\u001a\u00020\u0005J\u000e\u00102\u001a\u00020\u00132\u0006\u0010\u0004\u001a\u00020\u0005J\u000e\u00103\u001a\u00020\u00132\u0006\u0010\b\u001a\u00020\u0005J\u000e\u00104\u001a\u00020\u00132\u0006\u0010\u0007\u001a\u00020\u0005J\u000e\u00105\u001a\u00020\u00132\u0006\u0010\t\u001a\u00020\u0005J\b\u00106\u001a\u00020\u000bH\u0016J\u0019\u00107\u001a\u00020\u00132\u0006\u00108\u001a\u0002092\u0006\u0010:\u001a\u00020\u0003HÖ\u0001R\u000e\u0010\u0006\u001a\u00020\u0005X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u000e¢\u0006\u0002\n\u0000R\u001e\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u000e¢\u0006\u0010\n\u0002\u0010\u0011\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u000e\u0010\u0004\u001a\u00020\u0005X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0005X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0005X\u000e¢\u0006\u0002\n\u0000¨\u0006;"}, mo26107d2 = {"Leditor/tools/filters/MediaFilter;", "Landroid/os/Parcelable;", "contentType", "", "contrast", "", "brightness", "saturation", "pixelation", "sharpness", "conflatedFilterClassName", "", "(Ljava/lang/Integer;FFFFFLjava/lang/String;)V", "getContentType", "()Ljava/lang/Integer;", "setContentType", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "clear", "", "clearAppliedConflatedFilter", "clearBrightness", "clearContrast", "clearPixelation", "clearSaturation", "clearSharpness", "copy", "describeContents", "getAppliedBrightness", "getAppliedConflatedFilter", "Leditor/gpu/conflation/GlConflatedFilter;", "getAppliedContrast", "getAppliedPixelation", "getAppliedSaturation", "getAppliedSharpness", "getDefaultBrightness", "getDefaultContrast", "getDefaultPixelation", "getDefaultSaturation", "getDefaultSharpness", "hasBrightness", "", "hasContrast", "hasPixelation", "hasSaturation", "hasSharpness", "isCleared", "setAppliedConflatedFilter", "filter", "setBrightness", "setContrast", "setPixelation", "setSaturation", "setSharpness", "toString", "writeToParcel", "parcel", "Landroid/os/Parcel;", "flags", "editor_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
/* compiled from: MediaFilter.kt */
public final class MediaFilter implements Parcelable {
    public static final Parcelable.Creator<MediaFilter> CREATOR = new Creator();
    private float brightness;
    private String conflatedFilterClassName;
    private Integer contentType;
    private float contrast;
    private float pixelation;
    private float saturation;
    private float sharpness;

    @Metadata(mo26105bv = {1, 0, 3}, mo26108k = 3, mo26109mv = {1, 4, 2})
    public static class Creator implements Parcelable.Creator<MediaFilter> {
        public final MediaFilter createFromParcel(Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "in");
            return new MediaFilter(parcel.readInt() != 0 ? Integer.valueOf(parcel.readInt()) : null, parcel.readFloat(), parcel.readFloat(), parcel.readFloat(), parcel.readFloat(), parcel.readFloat(), parcel.readString());
        }

        public final MediaFilter[] newArray(int i) {
            return new MediaFilter[i];
        }
    }

    public MediaFilter() {
        this((Integer) null, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, (String) null, 127, (DefaultConstructorMarker) null);
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        int i2;
        Intrinsics.checkNotNullParameter(parcel, "parcel");
        Integer num = this.contentType;
        if (num != null) {
            parcel.writeInt(1);
            i2 = num.intValue();
        } else {
            i2 = 0;
        }
        parcel.writeInt(i2);
        parcel.writeFloat(this.contrast);
        parcel.writeFloat(this.brightness);
        parcel.writeFloat(this.saturation);
        parcel.writeFloat(this.pixelation);
        parcel.writeFloat(this.sharpness);
        parcel.writeString(this.conflatedFilterClassName);
    }

    public MediaFilter(Integer num, float f, float f2, float f3, float f4, float f5, String str) {
        this.contentType = num;
        this.contrast = f;
        this.brightness = f2;
        this.saturation = f3;
        this.pixelation = f4;
        this.sharpness = f5;
        this.conflatedFilterClassName = str;
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ MediaFilter(java.lang.Integer r6, float r7, float r8, float r9, float r10, float r11, java.lang.String r12, int r13, kotlin.jvm.internal.DefaultConstructorMarker r14) {
        /*
            r5 = this;
            r14 = r13 & 1
            r0 = 0
            if (r14 == 0) goto L_0x0008
            r6 = r0
            java.lang.Integer r6 = (java.lang.Integer) r6
        L_0x0008:
            r14 = r13 & 2
            r1 = 2143289344(0x7fc00000, float:NaN)
            if (r14 == 0) goto L_0x0011
            r14 = 2143289344(0x7fc00000, float:NaN)
            goto L_0x0012
        L_0x0011:
            r14 = r7
        L_0x0012:
            r7 = r13 & 4
            if (r7 == 0) goto L_0x0019
            r2 = 2143289344(0x7fc00000, float:NaN)
            goto L_0x001a
        L_0x0019:
            r2 = r8
        L_0x001a:
            r7 = r13 & 8
            if (r7 == 0) goto L_0x0021
            r3 = 2143289344(0x7fc00000, float:NaN)
            goto L_0x0022
        L_0x0021:
            r3 = r9
        L_0x0022:
            r7 = r13 & 16
            if (r7 == 0) goto L_0x0029
            r4 = 2143289344(0x7fc00000, float:NaN)
            goto L_0x002a
        L_0x0029:
            r4 = r10
        L_0x002a:
            r7 = r13 & 32
            if (r7 == 0) goto L_0x002f
            goto L_0x0030
        L_0x002f:
            r1 = r11
        L_0x0030:
            r7 = r13 & 64
            if (r7 == 0) goto L_0x0037
            r12 = r0
            java.lang.String r12 = (java.lang.String) r12
        L_0x0037:
            r0 = r12
            r7 = r5
            r8 = r6
            r9 = r14
            r10 = r2
            r11 = r3
            r12 = r4
            r13 = r1
            r14 = r0
            r7.<init>(r8, r9, r10, r11, r12, r13, r14)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: editor.tools.filters.MediaFilter.<init>(java.lang.Integer, float, float, float, float, float, java.lang.String, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }

    public final Integer getContentType() {
        return this.contentType;
    }

    public final void setContentType(Integer num) {
        this.contentType = num;
    }

    public final void setAppliedConflatedFilter(GlConflatedFilter glConflatedFilter) {
        Intrinsics.checkNotNullParameter(glConflatedFilter, "filter");
        this.conflatedFilterClassName = glConflatedFilter.getClass().getName();
    }

    public final GlConflatedFilter getAppliedConflatedFilter() {
        String str = this.conflatedFilterClassName;
        CharSequence charSequence = str;
        if (charSequence == null || StringsKt.isBlank(charSequence)) {
            return null;
        }
        Object newInstance = Class.forName(str).getConstructor(new Class[0]).newInstance(new Object[0]);
        Objects.requireNonNull(newInstance, "null cannot be cast to non-null type editor.gpu.conflation.GlConflatedFilter");
        return (GlConflatedFilter) newInstance;
    }

    public final void clearAppliedConflatedFilter() {
        this.conflatedFilterClassName = null;
    }

    public final boolean isCleared() {
        return !hasContrast() && !hasBrightness() && !hasSaturation() && !hasPixelation() && !hasSharpness();
    }

    public final MediaFilter copy() {
        MediaFilter mediaFilter = new MediaFilter(this.contentType, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, (String) null, 126, (DefaultConstructorMarker) null);
        mediaFilter.setContrast(getAppliedContrast());
        mediaFilter.setBrightness(getAppliedBrightness());
        mediaFilter.setSaturation(getAppliedSaturation());
        mediaFilter.setPixelation(getAppliedPixelation());
        mediaFilter.setSharpness(getAppliedSharpness());
        return mediaFilter;
    }

    public final void clear() {
        clearContrast();
        clearBrightness();
        clearSaturation();
        clearPixelation();
        clearSharpness();
    }

    public final float getDefaultContrast() {
        Integer num = this.contentType;
        if (num != null && num.intValue() == 1231) {
            return ImageFilterRange.INSTANCE.getCONTRAST().defaultPercent();
        }
        if ((num != null && num.intValue() == 1232) || (num != null && num.intValue() == 1237)) {
            return VideoFilterRange.INSTANCE.getCONTRAST().defaultPercent();
        }
        return ImageFilterRange.INSTANCE.getCONTRAST().defaultPercent();
    }

    public final float getAppliedContrast() {
        if (hasContrast()) {
            return this.contrast;
        }
        return getDefaultContrast();
    }

    public final void setContrast(float f) {
        this.contrast = f;
    }

    public final boolean hasContrast() {
        return !Float.isNaN(this.contrast) && this.contrast != getDefaultContrast();
    }

    public final void clearContrast() {
        this.contrast = Float.NaN;
    }

    public final float getDefaultBrightness() {
        Integer num = this.contentType;
        if (num != null && num.intValue() == 1231) {
            return ImageFilterRange.INSTANCE.getBRIGHTNESS().defaultPercent();
        }
        if ((num != null && num.intValue() == 1232) || (num != null && num.intValue() == 1237)) {
            return VideoFilterRange.INSTANCE.getBRIGHTNESS().defaultPercent();
        }
        return ImageFilterRange.INSTANCE.getBRIGHTNESS().defaultPercent();
    }

    public final float getAppliedBrightness() {
        if (hasBrightness()) {
            return this.brightness;
        }
        return getDefaultBrightness();
    }

    public final void setBrightness(float f) {
        this.brightness = f;
    }

    public final boolean hasBrightness() {
        return !Float.isNaN(this.brightness) && this.brightness != getDefaultBrightness();
    }

    public final void clearBrightness() {
        this.brightness = Float.NaN;
    }

    public final float getDefaultSaturation() {
        Integer num = this.contentType;
        if (num != null && num.intValue() == 1231) {
            return ImageFilterRange.INSTANCE.getSATURATION().defaultPercent();
        }
        if ((num != null && num.intValue() == 1232) || (num != null && num.intValue() == 1237)) {
            return VideoFilterRange.INSTANCE.getSATURATION().defaultPercent();
        }
        return ImageFilterRange.INSTANCE.getSATURATION().defaultPercent();
    }

    public final float getAppliedSaturation() {
        if (hasSaturation()) {
            return this.saturation;
        }
        return getDefaultSaturation();
    }

    public final void setSaturation(float f) {
        this.saturation = f;
    }

    public final boolean hasSaturation() {
        return !Float.isNaN(this.saturation) && this.saturation != getDefaultSaturation();
    }

    public final void clearSaturation() {
        this.saturation = Float.NaN;
    }

    public final float getDefaultPixelation() {
        Integer num = this.contentType;
        if (num != null && num.intValue() == 1231) {
            return ImageFilterRange.INSTANCE.getPIXELATION().defaultPercent();
        }
        if ((num != null && num.intValue() == 1232) || (num != null && num.intValue() == 1237)) {
            return VideoFilterRange.INSTANCE.getPIXELATION().defaultPercent();
        }
        return ImageFilterRange.INSTANCE.getPIXELATION().defaultPercent();
    }

    public final float getAppliedPixelation() {
        if (hasPixelation()) {
            return this.pixelation;
        }
        return getDefaultPixelation();
    }

    public final void setPixelation(float f) {
        this.pixelation = f;
    }

    public final boolean hasPixelation() {
        return !Float.isNaN(this.pixelation) && this.pixelation != getDefaultPixelation();
    }

    public final void clearPixelation() {
        this.pixelation = Float.NaN;
    }

    public final float getDefaultSharpness() {
        Integer num = this.contentType;
        if (num != null && num.intValue() == 1231) {
            return ImageFilterRange.INSTANCE.getSHARPNESS().defaultPercent();
        }
        if ((num != null && num.intValue() == 1232) || (num != null && num.intValue() == 1237)) {
            return VideoFilterRange.INSTANCE.getSHARPNESS().defaultPercent();
        }
        return ImageFilterRange.INSTANCE.getSHARPNESS().defaultPercent();
    }

    public final float getAppliedSharpness() {
        if (hasSharpness()) {
            return this.sharpness;
        }
        return getDefaultSharpness();
    }

    public final void setSharpness(float f) {
        this.sharpness = f;
    }

    public final boolean hasSharpness() {
        return !Float.isNaN(this.sharpness) && this.sharpness != getDefaultSharpness();
    }

    public final void clearSharpness() {
        this.sharpness = Float.NaN;
    }

    public String toString() {
        return "MediaFilter(" + "contentType=" + this.contentType + ", " + "contrast=" + this.contrast + ", " + "brightness=" + this.brightness + ", " + "saturation=" + this.saturation + ", " + "pixelation=" + this.pixelation + ", " + "sharpness=" + this.sharpness + ")";
    }
}
