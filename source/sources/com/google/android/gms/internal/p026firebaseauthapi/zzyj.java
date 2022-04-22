package com.google.android.gms.internal.p026firebaseauthapi;

import com.google.android.gms.internal.p026firebaseauthapi.zzyi;
import com.google.android.gms.internal.p026firebaseauthapi.zzyj;
import java.io.IOException;
import java.io.OutputStream;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzyj */
/* compiled from: com.google.firebase:firebase-auth@@20.0.2 */
public abstract class zzyj<MessageType extends zzyj<MessageType, BuilderType>, BuilderType extends zzyi<MessageType, BuilderType>> implements zzabg {
    protected int zza = 0;

    public final byte[] zzI() {
        try {
            byte[] bArr = new byte[zzw()];
            zzzl zzx = zzzl.zzx(bArr);
            zzv(zzx);
            zzx.zzI();
            return bArr;
        } catch (IOException e) {
            String name = getClass().getName();
            StringBuilder sb = new StringBuilder(String.valueOf(name).length() + 72);
            sb.append("Serializing ");
            sb.append(name);
            sb.append(" to a ");
            sb.append("byte array");
            sb.append(" threw an IOException (should never happen).");
            throw new RuntimeException(sb.toString(), e);
        }
    }

    public final zzzb zzn() {
        try {
            zzyx zzr = zzzb.zzr(zzw());
            zzv(zzr.zzb());
            return zzr.zza();
        } catch (IOException e) {
            String name = getClass().getName();
            StringBuilder sb = new StringBuilder(String.valueOf(name).length() + 72);
            sb.append("Serializing ");
            sb.append(name);
            sb.append(" to a ");
            sb.append("ByteString");
            sb.append(" threw an IOException (should never happen).");
            throw new RuntimeException(sb.toString(), e);
        }
    }

    public final void zzp(OutputStream outputStream) throws IOException {
        zzzl zzw = zzzl.zzw(outputStream, zzzl.zzv(zzw()));
        zzv(zzw);
        zzw.zzu();
    }

    /* access modifiers changed from: package-private */
    public int zzq() {
        throw null;
    }

    /* access modifiers changed from: package-private */
    public void zzr(int i) {
        throw null;
    }
}
