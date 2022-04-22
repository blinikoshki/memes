package com.google.android.exoplayer2.util;

import android.net.Uri;
import com.memes.commons.output.OutputExtension;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.List;
import java.util.Map;

public final class FileTypes {
    public static final int AC3 = 0;
    public static final int AC4 = 1;
    public static final int ADTS = 2;
    public static final int AMR = 3;
    private static final String EXTENSION_AAC = ".aac";
    private static final String EXTENSION_AC3 = ".ac3";
    private static final String EXTENSION_AC4 = ".ac4";
    private static final String EXTENSION_ADTS = ".adts";
    private static final String EXTENSION_AMR = ".amr";
    private static final String EXTENSION_EC3 = ".ec3";
    private static final String EXTENSION_FLAC = ".flac";
    private static final String EXTENSION_FLV = ".flv";
    private static final String EXTENSION_M2P = ".m2p";
    private static final String EXTENSION_MP3 = ".mp3";
    private static final String EXTENSION_MP4 = ".mp4";
    private static final String EXTENSION_MPEG = ".mpeg";
    private static final String EXTENSION_MPG = ".mpg";
    private static final String EXTENSION_OPUS = ".opus";
    private static final String EXTENSION_PREFIX_CMF = ".cmf";
    private static final String EXTENSION_PREFIX_M4 = ".m4";
    private static final String EXTENSION_PREFIX_MK = ".mk";
    private static final String EXTENSION_PREFIX_MP4 = ".mp4";
    private static final String EXTENSION_PREFIX_OG = ".og";
    private static final String EXTENSION_PREFIX_TS = ".ts";
    private static final String EXTENSION_PS = ".ps";
    private static final String EXTENSION_TS = ".ts";
    private static final String EXTENSION_VTT = ".vtt";
    private static final String EXTENSION_WAV = ".wav";
    private static final String EXTENSION_WAVE = ".wave";
    private static final String EXTENSION_WEBM = ".webm";
    private static final String EXTENSION_WEBVTT = ".webvtt";
    public static final int FLAC = 4;
    public static final int FLV = 5;
    static final String HEADER_CONTENT_TYPE = "Content-Type";
    public static final int MATROSKA = 6;
    public static final int MP3 = 7;
    public static final int MP4 = 8;
    public static final int OGG = 9;

    /* renamed from: PS */
    public static final int f543PS = 10;

    /* renamed from: TS */
    public static final int f544TS = 11;
    public static final int UNKNOWN = -1;
    public static final int WAV = 12;
    public static final int WEBVTT = 13;

    @Documented
    @Retention(RetentionPolicy.SOURCE)
    public @interface Type {
    }

    private FileTypes() {
    }

    public static int inferFileTypeFromResponseHeaders(Map<String, List<String>> map) {
        List list = map.get("Content-Type");
        return inferFileTypeFromMimeType((list == null || list.isEmpty()) ? null : (String) list.get(0));
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static int inferFileTypeFromMimeType(java.lang.String r15) {
        /*
            r0 = -1
            if (r15 != 0) goto L_0x0004
            return r0
        L_0x0004:
            java.lang.String r15 = com.google.android.exoplayer2.util.MimeTypes.normalizeMimeType(r15)
            r15.hashCode()
            int r1 = r15.hashCode()
            r2 = 13
            r3 = 12
            r4 = 11
            r5 = 10
            r6 = 9
            r7 = 8
            r8 = 7
            r9 = 6
            r10 = 5
            r11 = 4
            r12 = 3
            r13 = 1
            r14 = 0
            switch(r1) {
                case -2123537834: goto L_0x0145;
                case -1662384011: goto L_0x0139;
                case -1662384007: goto L_0x012d;
                case -1662095187: goto L_0x0121;
                case -1606874997: goto L_0x0115;
                case -1248337486: goto L_0x0109;
                case -1004728940: goto L_0x00fd;
                case -387023398: goto L_0x00f1;
                case -43467528: goto L_0x00e3;
                case 13915911: goto L_0x00d5;
                case 187078296: goto L_0x00c7;
                case 187078297: goto L_0x00b9;
                case 187078669: goto L_0x00ab;
                case 187090232: goto L_0x009d;
                case 187091926: goto L_0x0090;
                case 187099443: goto L_0x0083;
                case 1331848029: goto L_0x0076;
                case 1503095341: goto L_0x0069;
                case 1504578661: goto L_0x005c;
                case 1504619009: goto L_0x004f;
                case 1504831518: goto L_0x0042;
                case 1505118770: goto L_0x0035;
                case 2039520277: goto L_0x0028;
                default: goto L_0x0025;
            }
        L_0x0025:
            r15 = -1
            goto L_0x0150
        L_0x0028:
            java.lang.String r1 = "video/x-matroska"
            boolean r15 = r15.equals(r1)
            if (r15 != 0) goto L_0x0031
            goto L_0x0025
        L_0x0031:
            r15 = 22
            goto L_0x0150
        L_0x0035:
            java.lang.String r1 = "audio/webm"
            boolean r15 = r15.equals(r1)
            if (r15 != 0) goto L_0x003e
            goto L_0x0025
        L_0x003e:
            r15 = 21
            goto L_0x0150
        L_0x0042:
            java.lang.String r1 = "audio/mpeg"
            boolean r15 = r15.equals(r1)
            if (r15 != 0) goto L_0x004b
            goto L_0x0025
        L_0x004b:
            r15 = 20
            goto L_0x0150
        L_0x004f:
            java.lang.String r1 = "audio/flac"
            boolean r15 = r15.equals(r1)
            if (r15 != 0) goto L_0x0058
            goto L_0x0025
        L_0x0058:
            r15 = 19
            goto L_0x0150
        L_0x005c:
            java.lang.String r1 = "audio/eac3"
            boolean r15 = r15.equals(r1)
            if (r15 != 0) goto L_0x0065
            goto L_0x0025
        L_0x0065:
            r15 = 18
            goto L_0x0150
        L_0x0069:
            java.lang.String r1 = "audio/3gpp"
            boolean r15 = r15.equals(r1)
            if (r15 != 0) goto L_0x0072
            goto L_0x0025
        L_0x0072:
            r15 = 17
            goto L_0x0150
        L_0x0076:
            java.lang.String r1 = "video/mp4"
            boolean r15 = r15.equals(r1)
            if (r15 != 0) goto L_0x007f
            goto L_0x0025
        L_0x007f:
            r15 = 16
            goto L_0x0150
        L_0x0083:
            java.lang.String r1 = "audio/wav"
            boolean r15 = r15.equals(r1)
            if (r15 != 0) goto L_0x008c
            goto L_0x0025
        L_0x008c:
            r15 = 15
            goto L_0x0150
        L_0x0090:
            java.lang.String r1 = "audio/ogg"
            boolean r15 = r15.equals(r1)
            if (r15 != 0) goto L_0x0099
            goto L_0x0025
        L_0x0099:
            r15 = 14
            goto L_0x0150
        L_0x009d:
            java.lang.String r1 = "audio/mp4"
            boolean r15 = r15.equals(r1)
            if (r15 != 0) goto L_0x00a7
            goto L_0x0025
        L_0x00a7:
            r15 = 13
            goto L_0x0150
        L_0x00ab:
            java.lang.String r1 = "audio/amr"
            boolean r15 = r15.equals(r1)
            if (r15 != 0) goto L_0x00b5
            goto L_0x0025
        L_0x00b5:
            r15 = 12
            goto L_0x0150
        L_0x00b9:
            java.lang.String r1 = "audio/ac4"
            boolean r15 = r15.equals(r1)
            if (r15 != 0) goto L_0x00c3
            goto L_0x0025
        L_0x00c3:
            r15 = 11
            goto L_0x0150
        L_0x00c7:
            java.lang.String r1 = "audio/ac3"
            boolean r15 = r15.equals(r1)
            if (r15 != 0) goto L_0x00d1
            goto L_0x0025
        L_0x00d1:
            r15 = 10
            goto L_0x0150
        L_0x00d5:
            java.lang.String r1 = "video/x-flv"
            boolean r15 = r15.equals(r1)
            if (r15 != 0) goto L_0x00df
            goto L_0x0025
        L_0x00df:
            r15 = 9
            goto L_0x0150
        L_0x00e3:
            java.lang.String r1 = "application/webm"
            boolean r15 = r15.equals(r1)
            if (r15 != 0) goto L_0x00ed
            goto L_0x0025
        L_0x00ed:
            r15 = 8
            goto L_0x0150
        L_0x00f1:
            java.lang.String r1 = "audio/x-matroska"
            boolean r15 = r15.equals(r1)
            if (r15 != 0) goto L_0x00fb
            goto L_0x0025
        L_0x00fb:
            r15 = 7
            goto L_0x0150
        L_0x00fd:
            java.lang.String r1 = "text/vtt"
            boolean r15 = r15.equals(r1)
            if (r15 != 0) goto L_0x0107
            goto L_0x0025
        L_0x0107:
            r15 = 6
            goto L_0x0150
        L_0x0109:
            java.lang.String r1 = "application/mp4"
            boolean r15 = r15.equals(r1)
            if (r15 != 0) goto L_0x0113
            goto L_0x0025
        L_0x0113:
            r15 = 5
            goto L_0x0150
        L_0x0115:
            java.lang.String r1 = "audio/amr-wb"
            boolean r15 = r15.equals(r1)
            if (r15 != 0) goto L_0x011f
            goto L_0x0025
        L_0x011f:
            r15 = 4
            goto L_0x0150
        L_0x0121:
            java.lang.String r1 = "video/webm"
            boolean r15 = r15.equals(r1)
            if (r15 != 0) goto L_0x012b
            goto L_0x0025
        L_0x012b:
            r15 = 3
            goto L_0x0150
        L_0x012d:
            java.lang.String r1 = "video/mp2t"
            boolean r15 = r15.equals(r1)
            if (r15 != 0) goto L_0x0137
            goto L_0x0025
        L_0x0137:
            r15 = 2
            goto L_0x0150
        L_0x0139:
            java.lang.String r1 = "video/mp2p"
            boolean r15 = r15.equals(r1)
            if (r15 != 0) goto L_0x0143
            goto L_0x0025
        L_0x0143:
            r15 = 1
            goto L_0x0150
        L_0x0145:
            java.lang.String r1 = "audio/eac3-joc"
            boolean r15 = r15.equals(r1)
            if (r15 != 0) goto L_0x014f
            goto L_0x0025
        L_0x014f:
            r15 = 0
        L_0x0150:
            switch(r15) {
                case 0: goto L_0x0160;
                case 1: goto L_0x015f;
                case 2: goto L_0x015e;
                case 3: goto L_0x015d;
                case 4: goto L_0x015c;
                case 5: goto L_0x015b;
                case 6: goto L_0x015a;
                case 7: goto L_0x015d;
                case 8: goto L_0x015d;
                case 9: goto L_0x0159;
                case 10: goto L_0x0160;
                case 11: goto L_0x0158;
                case 12: goto L_0x015c;
                case 13: goto L_0x015b;
                case 14: goto L_0x0157;
                case 15: goto L_0x0156;
                case 16: goto L_0x015b;
                case 17: goto L_0x015c;
                case 18: goto L_0x0160;
                case 19: goto L_0x0155;
                case 20: goto L_0x0154;
                case 21: goto L_0x015d;
                case 22: goto L_0x015d;
                default: goto L_0x0153;
            }
        L_0x0153:
            return r0
        L_0x0154:
            return r8
        L_0x0155:
            return r11
        L_0x0156:
            return r3
        L_0x0157:
            return r6
        L_0x0158:
            return r13
        L_0x0159:
            return r10
        L_0x015a:
            return r2
        L_0x015b:
            return r7
        L_0x015c:
            return r12
        L_0x015d:
            return r9
        L_0x015e:
            return r4
        L_0x015f:
            return r5
        L_0x0160:
            return r14
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.util.FileTypes.inferFileTypeFromMimeType(java.lang.String):int");
    }

    public static int inferFileTypeFromUri(Uri uri) {
        String lastPathSegment = uri.getLastPathSegment();
        if (lastPathSegment == null) {
            return -1;
        }
        if (lastPathSegment.endsWith(EXTENSION_AC3) || lastPathSegment.endsWith(EXTENSION_EC3)) {
            return 0;
        }
        if (lastPathSegment.endsWith(EXTENSION_AC4)) {
            return 1;
        }
        if (lastPathSegment.endsWith(EXTENSION_ADTS) || lastPathSegment.endsWith(EXTENSION_AAC)) {
            return 2;
        }
        if (lastPathSegment.endsWith(EXTENSION_AMR)) {
            return 3;
        }
        if (lastPathSegment.endsWith(EXTENSION_FLAC)) {
            return 4;
        }
        if (lastPathSegment.endsWith(EXTENSION_FLV)) {
            return 5;
        }
        if (lastPathSegment.startsWith(EXTENSION_PREFIX_MK, lastPathSegment.length() - 4) || lastPathSegment.endsWith(EXTENSION_WEBM)) {
            return 6;
        }
        if (lastPathSegment.endsWith(EXTENSION_MP3)) {
            return 7;
        }
        if (lastPathSegment.endsWith(OutputExtension.MP4) || lastPathSegment.startsWith(EXTENSION_PREFIX_M4, lastPathSegment.length() - 4) || lastPathSegment.startsWith(OutputExtension.MP4, lastPathSegment.length() - 5) || lastPathSegment.startsWith(EXTENSION_PREFIX_CMF, lastPathSegment.length() - 5)) {
            return 8;
        }
        if (lastPathSegment.startsWith(EXTENSION_PREFIX_OG, lastPathSegment.length() - 4) || lastPathSegment.endsWith(EXTENSION_OPUS)) {
            return 9;
        }
        if (lastPathSegment.endsWith(EXTENSION_PS) || lastPathSegment.endsWith(EXTENSION_MPEG) || lastPathSegment.endsWith(EXTENSION_MPG) || lastPathSegment.endsWith(EXTENSION_M2P)) {
            return 10;
        }
        if (lastPathSegment.endsWith(".ts") || lastPathSegment.startsWith(".ts", lastPathSegment.length() - 4)) {
            return 11;
        }
        if (lastPathSegment.endsWith(EXTENSION_WAV) || lastPathSegment.endsWith(EXTENSION_WAVE)) {
            return 12;
        }
        if (lastPathSegment.endsWith(EXTENSION_VTT) || lastPathSegment.endsWith(EXTENSION_WEBVTT)) {
            return 13;
        }
        return -1;
    }
}
