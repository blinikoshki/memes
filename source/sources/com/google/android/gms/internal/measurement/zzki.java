package com.google.android.gms.internal.measurement;

import com.google.common.base.Ascii;
import okio.Utf8;

/* compiled from: com.google.android.gms:play-services-measurement-base@@18.0.2 */
final class zzki {
    static /* synthetic */ boolean zza(byte b) {
        return b >= 0;
    }

    static /* synthetic */ boolean zzb(byte b) {
        return b < -32;
    }

    static /* synthetic */ void zzc(byte b, byte b2, char[] cArr, int i) throws zzic {
        if (b < -62 || zzg(b2)) {
            throw zzic.zzf();
        }
        cArr[i] = (char) (((b & Ascii.f591US) << 6) | (b2 & Utf8.REPLACEMENT_BYTE));
    }

    static /* synthetic */ boolean zzd(byte b) {
        return b < -16;
    }

    static /* synthetic */ void zze(byte b, byte b2, byte b3, char[] cArr, int i) throws zzic {
        if (!zzg(b2)) {
            if (b == -32) {
                if (b2 >= -96) {
                    b = -32;
                }
            }
            if (b == -19) {
                if (b2 < -96) {
                    b = -19;
                }
            }
            if (!zzg(b3)) {
                cArr[i] = (char) (((b & Ascii.f588SI) << Ascii.f581FF) | ((b2 & Utf8.REPLACEMENT_BYTE) << 6) | (b3 & Utf8.REPLACEMENT_BYTE));
                return;
            }
        }
        throw zzic.zzf();
    }

    static /* synthetic */ void zzf(byte b, byte b2, byte b3, byte b4, char[] cArr, int i) throws zzic {
        if (zzg(b2) || (((b << Ascii.f582FS) + (b2 + 112)) >> 30) != 0 || zzg(b3) || zzg(b4)) {
            throw zzic.zzf();
        }
        byte b5 = ((b & 7) << Ascii.DC2) | ((b2 & Utf8.REPLACEMENT_BYTE) << Ascii.f581FF) | ((b3 & Utf8.REPLACEMENT_BYTE) << 6) | (b4 & Utf8.REPLACEMENT_BYTE);
        cArr[i] = (char) ((b5 >>> 10) + Utf8.HIGH_SURROGATE_HEADER);
        cArr[i + 1] = (char) ((b5 & 1023) + Utf8.LOG_SURROGATE_HEADER);
    }

    private static boolean zzg(byte b) {
        return b > -65;
    }
}
