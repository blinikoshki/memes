package com.google.android.exoplayer2.text.tx3g;

import android.text.SpannableStringBuilder;
import android.text.style.ForegroundColorSpan;
import android.text.style.StyleSpan;
import android.text.style.TypefaceSpan;
import android.text.style.UnderlineSpan;
import com.google.android.exoplayer2.C1844C;
import com.google.android.exoplayer2.text.SimpleSubtitleDecoder;
import com.google.android.exoplayer2.text.SubtitleDecoderException;
import com.google.android.exoplayer2.util.ParsableByteArray;
import com.google.android.exoplayer2.util.Util;
import com.google.common.base.Ascii;
import com.google.common.base.Charsets;
import java.util.List;

public final class Tx3gDecoder extends SimpleSubtitleDecoder {
    private static final char BOM_UTF16_BE = '﻿';
    private static final char BOM_UTF16_LE = '￾';
    private static final int DEFAULT_COLOR = -1;
    private static final int DEFAULT_FONT_FACE = 0;
    private static final String DEFAULT_FONT_FAMILY = "sans-serif";
    private static final float DEFAULT_VERTICAL_PLACEMENT = 0.85f;
    private static final int FONT_FACE_BOLD = 1;
    private static final int FONT_FACE_ITALIC = 2;
    private static final int FONT_FACE_UNDERLINE = 4;
    private static final int SIZE_ATOM_HEADER = 8;
    private static final int SIZE_BOM_UTF16 = 2;
    private static final int SIZE_SHORT = 2;
    private static final int SIZE_STYLE_RECORD = 12;
    private static final int SPAN_PRIORITY_HIGH = 0;
    private static final int SPAN_PRIORITY_LOW = 16711680;
    private static final String TX3G_SERIF = "Serif";
    private static final int TYPE_STYL = 1937013100;
    private static final int TYPE_TBOX = 1952608120;
    private int calculatedVideoTrackHeight;
    private boolean customVerticalPlacement;
    private int defaultColorRgba;
    private int defaultFontFace;
    private String defaultFontFamily;
    private float defaultVerticalPlacement;
    private final ParsableByteArray parsableByteArray = new ParsableByteArray();

    public Tx3gDecoder(List<byte[]> list) {
        super("Tx3gDecoder");
        String str = "sans-serif";
        boolean z = false;
        if (list != null && list.size() == 1 && (list.get(0).length == 48 || list.get(0).length == 53)) {
            byte[] bArr = list.get(0);
            this.defaultFontFace = bArr[24];
            this.defaultColorRgba = ((bArr[26] & 255) << Ascii.CAN) | ((bArr[27] & 255) << Ascii.DLE) | ((bArr[28] & 255) << 8) | (bArr[29] & 255);
            this.defaultFontFamily = TX3G_SERIF.equals(Util.fromUtf8Bytes(bArr, 43, bArr.length - 43)) ? C1844C.SERIF_NAME : str;
            int i = bArr[25] * Ascii.DC4;
            this.calculatedVideoTrackHeight = i;
            z = (bArr[0] & 32) != 0 ? true : z;
            this.customVerticalPlacement = z;
            if (z) {
                float f = ((float) ((bArr[11] & 255) | ((bArr[10] & 255) << 8))) / ((float) i);
                this.defaultVerticalPlacement = f;
                this.defaultVerticalPlacement = Util.constrainValue(f, 0.0f, 0.95f);
                return;
            }
            this.defaultVerticalPlacement = DEFAULT_VERTICAL_PLACEMENT;
            return;
        }
        this.defaultFontFace = 0;
        this.defaultColorRgba = -1;
        this.defaultFontFamily = str;
        this.customVerticalPlacement = false;
        this.defaultVerticalPlacement = DEFAULT_VERTICAL_PLACEMENT;
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v5, resolved type: boolean} */
    /* JADX WARNING: type inference failed for: r1v3 */
    /* JADX WARNING: type inference failed for: r1v9 */
    /* JADX WARNING: type inference failed for: r1v10, types: [int] */
    /* JADX WARNING: type inference failed for: r1v12 */
    /* access modifiers changed from: protected */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public com.google.android.exoplayer2.text.Subtitle decode(byte[] r7, int r8, boolean r9) throws com.google.android.exoplayer2.text.SubtitleDecoderException {
        /*
            r6 = this;
            com.google.android.exoplayer2.util.ParsableByteArray r9 = r6.parsableByteArray
            r9.reset(r7, r8)
            com.google.android.exoplayer2.util.ParsableByteArray r7 = r6.parsableByteArray
            java.lang.String r7 = readSubtitleText(r7)
            boolean r8 = r7.isEmpty()
            if (r8 == 0) goto L_0x0014
            com.google.android.exoplayer2.text.tx3g.Tx3gSubtitle r7 = com.google.android.exoplayer2.text.tx3g.Tx3gSubtitle.EMPTY
            return r7
        L_0x0014:
            android.text.SpannableStringBuilder r8 = new android.text.SpannableStringBuilder
            r8.<init>(r7)
            int r1 = r6.defaultFontFace
            r2 = 0
            r3 = 0
            int r4 = r8.length()
            r5 = 16711680(0xff0000, float:2.3418052E-38)
            r0 = r8
            attachFontFace(r0, r1, r2, r3, r4, r5)
            int r1 = r6.defaultColorRgba
            r2 = -1
            int r4 = r8.length()
            attachColor(r0, r1, r2, r3, r4, r5)
            java.lang.String r1 = r6.defaultFontFamily
            int r4 = r8.length()
            java.lang.String r2 = "sans-serif"
            attachFontFamily(r0, r1, r2, r3, r4, r5)
            float r7 = r6.defaultVerticalPlacement
        L_0x003e:
            com.google.android.exoplayer2.util.ParsableByteArray r9 = r6.parsableByteArray
            int r9 = r9.bytesLeft()
            r0 = 8
            r1 = 0
            if (r9 < r0) goto L_0x00ae
            com.google.android.exoplayer2.util.ParsableByteArray r9 = r6.parsableByteArray
            int r9 = r9.getPosition()
            com.google.android.exoplayer2.util.ParsableByteArray r0 = r6.parsableByteArray
            int r0 = r0.readInt()
            com.google.android.exoplayer2.util.ParsableByteArray r2 = r6.parsableByteArray
            int r2 = r2.readInt()
            r3 = 1937013100(0x7374796c, float:1.936925E31)
            r4 = 2
            r5 = 1
            if (r2 != r3) goto L_0x007f
            com.google.android.exoplayer2.util.ParsableByteArray r2 = r6.parsableByteArray
            int r2 = r2.bytesLeft()
            if (r2 < r4) goto L_0x006b
            goto L_0x006c
        L_0x006b:
            r5 = 0
        L_0x006c:
            assertTrue(r5)
            com.google.android.exoplayer2.util.ParsableByteArray r2 = r6.parsableByteArray
            int r2 = r2.readUnsignedShort()
        L_0x0075:
            if (r1 >= r2) goto L_0x00a7
            com.google.android.exoplayer2.util.ParsableByteArray r3 = r6.parsableByteArray
            r6.applyStyleRecord(r3, r8)
            int r1 = r1 + 1
            goto L_0x0075
        L_0x007f:
            r3 = 1952608120(0x74626f78, float:7.176025E31)
            if (r2 != r3) goto L_0x00a7
            boolean r2 = r6.customVerticalPlacement
            if (r2 == 0) goto L_0x00a7
            com.google.android.exoplayer2.util.ParsableByteArray r7 = r6.parsableByteArray
            int r7 = r7.bytesLeft()
            if (r7 < r4) goto L_0x0091
            r1 = 1
        L_0x0091:
            assertTrue(r1)
            com.google.android.exoplayer2.util.ParsableByteArray r7 = r6.parsableByteArray
            int r7 = r7.readUnsignedShort()
            float r7 = (float) r7
            int r1 = r6.calculatedVideoTrackHeight
            float r1 = (float) r1
            float r7 = r7 / r1
            r1 = 0
            r2 = 1064514355(0x3f733333, float:0.95)
            float r7 = com.google.android.exoplayer2.util.Util.constrainValue((float) r7, (float) r1, (float) r2)
        L_0x00a7:
            com.google.android.exoplayer2.util.ParsableByteArray r1 = r6.parsableByteArray
            int r9 = r9 + r0
            r1.setPosition(r9)
            goto L_0x003e
        L_0x00ae:
            com.google.android.exoplayer2.text.tx3g.Tx3gSubtitle r9 = new com.google.android.exoplayer2.text.tx3g.Tx3gSubtitle
            com.google.android.exoplayer2.text.Cue$Builder r0 = new com.google.android.exoplayer2.text.Cue$Builder
            r0.<init>()
            com.google.android.exoplayer2.text.Cue$Builder r8 = r0.setText(r8)
            com.google.android.exoplayer2.text.Cue$Builder r7 = r8.setLine(r7, r1)
            com.google.android.exoplayer2.text.Cue$Builder r7 = r7.setLineAnchor(r1)
            com.google.android.exoplayer2.text.Cue r7 = r7.build()
            r9.<init>(r7)
            return r9
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.text.tx3g.Tx3gDecoder.decode(byte[], int, boolean):com.google.android.exoplayer2.text.Subtitle");
    }

    private static String readSubtitleText(ParsableByteArray parsableByteArray2) throws SubtitleDecoderException {
        char peekChar;
        assertTrue(parsableByteArray2.bytesLeft() >= 2);
        int readUnsignedShort = parsableByteArray2.readUnsignedShort();
        if (readUnsignedShort == 0) {
            return "";
        }
        if (parsableByteArray2.bytesLeft() < 2 || ((peekChar = parsableByteArray2.peekChar()) != 65279 && peekChar != 65534)) {
            return parsableByteArray2.readString(readUnsignedShort, Charsets.UTF_8);
        }
        return parsableByteArray2.readString(readUnsignedShort, Charsets.UTF_16);
    }

    private void applyStyleRecord(ParsableByteArray parsableByteArray2, SpannableStringBuilder spannableStringBuilder) throws SubtitleDecoderException {
        assertTrue(parsableByteArray2.bytesLeft() >= 12);
        int readUnsignedShort = parsableByteArray2.readUnsignedShort();
        int readUnsignedShort2 = parsableByteArray2.readUnsignedShort();
        parsableByteArray2.skipBytes(2);
        int readUnsignedByte = parsableByteArray2.readUnsignedByte();
        parsableByteArray2.skipBytes(1);
        int readInt = parsableByteArray2.readInt();
        SpannableStringBuilder spannableStringBuilder2 = spannableStringBuilder;
        int i = readUnsignedShort;
        int i2 = readUnsignedShort2;
        attachFontFace(spannableStringBuilder2, readUnsignedByte, this.defaultFontFace, i, i2, 0);
        attachColor(spannableStringBuilder2, readInt, this.defaultColorRgba, i, i2, 0);
    }

    private static void attachFontFace(SpannableStringBuilder spannableStringBuilder, int i, int i2, int i3, int i4, int i5) {
        if (i != i2) {
            int i6 = i5 | 33;
            boolean z = true;
            boolean z2 = (i & 1) != 0;
            boolean z3 = (i & 2) != 0;
            if (z2) {
                if (z3) {
                    spannableStringBuilder.setSpan(new StyleSpan(3), i3, i4, i6);
                } else {
                    spannableStringBuilder.setSpan(new StyleSpan(1), i3, i4, i6);
                }
            } else if (z3) {
                spannableStringBuilder.setSpan(new StyleSpan(2), i3, i4, i6);
            }
            if ((i & 4) == 0) {
                z = false;
            }
            if (z) {
                spannableStringBuilder.setSpan(new UnderlineSpan(), i3, i4, i6);
            }
            if (!z && !z2 && !z3) {
                spannableStringBuilder.setSpan(new StyleSpan(0), i3, i4, i6);
            }
        }
    }

    private static void attachColor(SpannableStringBuilder spannableStringBuilder, int i, int i2, int i3, int i4, int i5) {
        if (i != i2) {
            spannableStringBuilder.setSpan(new ForegroundColorSpan((i >>> 8) | ((i & 255) << 24)), i3, i4, i5 | 33);
        }
    }

    private static void attachFontFamily(SpannableStringBuilder spannableStringBuilder, String str, String str2, int i, int i2, int i3) {
        if (str != str2) {
            spannableStringBuilder.setSpan(new TypefaceSpan(str), i, i2, i3 | 33);
        }
    }

    private static void assertTrue(boolean z) throws SubtitleDecoderException {
        if (!z) {
            throw new SubtitleDecoderException("Unexpected subtitle format.");
        }
    }
}
