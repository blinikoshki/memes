package editor.mediaselection.localmedia;

import java.util.Objects;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0010\n\u0002\u0010\u0007\n\u0002\b\u0010\b\b\u0018\u00002\u00020\u0001BU\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\b\u0012\b\b\u0002\u0010\n\u001a\u00020\u000b\u0012\b\b\u0002\u0010\f\u001a\u00020\u000b\u0012\b\b\u0002\u0010\r\u001a\u00020\b\u0012\b\b\u0002\u0010\u000e\u001a\u00020\b¢\u0006\u0002\u0010\u000fJ\u0006\u0010\u001b\u001a\u00020\u001cJ\t\u0010\u001d\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001f\u001a\u00020\u0006HÆ\u0003J\t\u0010 \u001a\u00020\bHÆ\u0003J\t\u0010!\u001a\u00020\bHÆ\u0003J\t\u0010\"\u001a\u00020\u000bHÆ\u0003J\t\u0010#\u001a\u00020\u000bHÆ\u0003J\t\u0010$\u001a\u00020\bHÆ\u0003J\t\u0010%\u001a\u00020\bHÆ\u0003Jc\u0010&\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\b2\b\b\u0002\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\f\u001a\u00020\u000b2\b\b\u0002\u0010\r\u001a\u00020\b2\b\b\u0002\u0010\u000e\u001a\u00020\bHÆ\u0001J\u0013\u0010'\u001a\u00020\u000b2\b\u0010(\u001a\u0004\u0018\u00010\u0001H\u0002J\u0006\u0010)\u001a\u00020\u0006J\b\u0010*\u001a\u00020\bH\u0016J\t\u0010+\u001a\u00020\u0006HÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\u000e\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0011R\u0011\u0010\n\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u0015R\u0011\u0010\f\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u0015R\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0013R\u0011\u0010\t\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0013R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R\u0011\u0010\r\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0013¨\u0006,"}, mo26107d2 = {"Leditor/mediaselection/localmedia/LocalMedia;", "", "id", "", "dateAddedSeconds", "source", "", "mediaTye", "", "mimeType", "isPhoto", "", "isVideo", "width", "height", "(JJLjava/lang/String;IIZZII)V", "getDateAddedSeconds", "()J", "getHeight", "()I", "getId", "()Z", "getMediaTye", "getMimeType", "getSource", "()Ljava/lang/String;", "getWidth", "aspectRatio", "", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "equals", "other", "getIdentifier", "hashCode", "toString", "editor_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
/* compiled from: LocalMedia.kt */
public final class LocalMedia {
    private final long dateAddedSeconds;
    private final int height;

    /* renamed from: id */
    private final long f1432id;
    private final boolean isPhoto;
    private final boolean isVideo;
    private final int mediaTye;
    private final int mimeType;
    private final String source;
    private final int width;

    public static /* synthetic */ LocalMedia copy$default(LocalMedia localMedia, long j, long j2, String str, int i, int i2, boolean z, boolean z2, int i3, int i4, int i5, Object obj) {
        LocalMedia localMedia2 = localMedia;
        int i6 = i5;
        return localMedia.copy((i6 & 1) != 0 ? localMedia2.f1432id : j, (i6 & 2) != 0 ? localMedia2.dateAddedSeconds : j2, (i6 & 4) != 0 ? localMedia2.source : str, (i6 & 8) != 0 ? localMedia2.mediaTye : i, (i6 & 16) != 0 ? localMedia2.mimeType : i2, (i6 & 32) != 0 ? localMedia2.isPhoto : z, (i6 & 64) != 0 ? localMedia2.isVideo : z2, (i6 & 128) != 0 ? localMedia2.width : i3, (i6 & 256) != 0 ? localMedia2.height : i4);
    }

    public final long component1() {
        return this.f1432id;
    }

    public final long component2() {
        return this.dateAddedSeconds;
    }

    public final String component3() {
        return this.source;
    }

    public final int component4() {
        return this.mediaTye;
    }

    public final int component5() {
        return this.mimeType;
    }

    public final boolean component6() {
        return this.isPhoto;
    }

    public final boolean component7() {
        return this.isVideo;
    }

    public final int component8() {
        return this.width;
    }

    public final int component9() {
        return this.height;
    }

    public final LocalMedia copy(long j, long j2, String str, int i, int i2, boolean z, boolean z2, int i3, int i4) {
        String str2 = str;
        Intrinsics.checkNotNullParameter(str2, "source");
        return new LocalMedia(j, j2, str2, i, i2, z, z2, i3, i4);
    }

    public String toString() {
        return "LocalMedia(id=" + this.f1432id + ", dateAddedSeconds=" + this.dateAddedSeconds + ", source=" + this.source + ", mediaTye=" + this.mediaTye + ", mimeType=" + this.mimeType + ", isPhoto=" + this.isPhoto + ", isVideo=" + this.isVideo + ", width=" + this.width + ", height=" + this.height + ")";
    }

    public LocalMedia(long j, long j2, String str, int i, int i2, boolean z, boolean z2, int i3, int i4) {
        Intrinsics.checkNotNullParameter(str, "source");
        this.f1432id = j;
        this.dateAddedSeconds = j2;
        this.source = str;
        this.mediaTye = i;
        this.mimeType = i2;
        this.isPhoto = z;
        this.isVideo = z2;
        this.width = i3;
        this.height = i4;
    }

    public final long getId() {
        return this.f1432id;
    }

    public final long getDateAddedSeconds() {
        return this.dateAddedSeconds;
    }

    public final String getSource() {
        return this.source;
    }

    public final int getMediaTye() {
        return this.mediaTye;
    }

    public final int getMimeType() {
        return this.mimeType;
    }

    public final boolean isPhoto() {
        return this.isPhoto;
    }

    public final boolean isVideo() {
        return this.isVideo;
    }

    public final int getWidth() {
        return this.width;
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ LocalMedia(long r16, long r18, java.lang.String r20, int r21, int r22, boolean r23, boolean r24, int r25, int r26, int r27, kotlin.jvm.internal.DefaultConstructorMarker r28) {
        /*
            r15 = this;
            r0 = r27
            r1 = r0 & 32
            r2 = 0
            if (r1 == 0) goto L_0x0009
            r11 = 0
            goto L_0x000b
        L_0x0009:
            r11 = r23
        L_0x000b:
            r1 = r0 & 64
            if (r1 == 0) goto L_0x0011
            r12 = 0
            goto L_0x0013
        L_0x0011:
            r12 = r24
        L_0x0013:
            r1 = r0 & 128(0x80, float:1.794E-43)
            r2 = -1
            if (r1 == 0) goto L_0x001a
            r13 = -1
            goto L_0x001c
        L_0x001a:
            r13 = r25
        L_0x001c:
            r0 = r0 & 256(0x100, float:3.59E-43)
            if (r0 == 0) goto L_0x0022
            r14 = -1
            goto L_0x0024
        L_0x0022:
            r14 = r26
        L_0x0024:
            r3 = r15
            r4 = r16
            r6 = r18
            r8 = r20
            r9 = r21
            r10 = r22
            r3.<init>(r4, r6, r8, r9, r10, r11, r12, r13, r14)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: editor.mediaselection.localmedia.LocalMedia.<init>(long, long, java.lang.String, int, int, boolean, boolean, int, int, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }

    public final int getHeight() {
        return this.height;
    }

    public final String getIdentifier() {
        return String.valueOf(this.f1432id);
    }

    public final float aspectRatio() {
        int i;
        int i2 = this.width;
        if (i2 <= 0 || (i = this.height) <= 0) {
            return 1.0f;
        }
        return ((float) i2) / ((float) i);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!Intrinsics.areEqual((Object) getClass(), (Object) obj != null ? obj.getClass() : null)) {
            return false;
        }
        Objects.requireNonNull(obj, "null cannot be cast to non-null type editor.mediaselection.localmedia.LocalMedia");
        if (this.f1432id != ((LocalMedia) obj).f1432id) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        return C$r8$backportedMethods$utility$Long$1$hashCode.hashCode(this.f1432id);
    }
}
