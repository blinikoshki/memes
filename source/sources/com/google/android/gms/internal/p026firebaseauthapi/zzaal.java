package com.google.android.gms.internal.p026firebaseauthapi;

import java.io.IOException;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzaal */
/* compiled from: com.google.firebase:firebase-auth@@20.0.2 */
public class zzaal extends IOException {
    private zzabg zza = null;

    public zzaal(String str) {
        super(str);
    }

    static zzaal zzb() {
        return new zzaal("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either that the input has been truncated or that an embedded message misreported its own length.");
    }

    static zzaal zzc() {
        return new zzaal("CodedInputStream encountered an embedded string or message which claimed to have negative size.");
    }

    static zzaal zzd() {
        return new zzaal("CodedInputStream encountered a malformed varint.");
    }

    static zzaal zze() {
        return new zzaal("Protocol message contained an invalid tag (zero).");
    }

    static zzaal zzf() {
        return new zzaal("Protocol message end-group tag did not match expected tag.");
    }

    static zzaak zzg() {
        return new zzaak("Protocol message tag had invalid wire type.");
    }

    static zzaal zzh() {
        return new zzaal("Failed to parse the message.");
    }

    static zzaal zzi() {
        return new zzaal("Protocol message had invalid UTF-8.");
    }

    public final zzaal zza(zzabg zzabg) {
        this.zza = zzabg;
        return this;
    }
}
