package com.google.android.gms.internal.measurement;

import com.google.android.gms.internal.measurement.zzho;
import com.google.android.gms.internal.measurement.zzhs;
import java.io.IOException;

/* compiled from: com.google.android.gms:play-services-measurement-base@@18.0.2 */
public class zzho<MessageType extends zzhs<MessageType, BuilderType>, BuilderType extends zzho<MessageType, BuilderType>> extends zzga<MessageType, BuilderType> {
    protected MessageType zza;
    protected boolean zzb = false;
    private final MessageType zzc;

    protected zzho(MessageType messagetype) {
        this.zzc = messagetype;
        this.zza = (zzhs) messagetype.zzl(4, (Object) null, (Object) null);
    }

    private static final void zza(MessageType messagetype, MessageType messagetype2) {
        zzjf.zza().zzb(messagetype.getClass()).zzd(messagetype, messagetype2);
    }

    public final MessageType zzaA() {
        MessageType zzaz = zzaD();
        Boolean bool = Boolean.TRUE;
        boolean z = true;
        byte byteValue = ((Byte) zzaz.zzl(1, (Object) null, (Object) null)).byteValue();
        if (byteValue != 1) {
            if (byteValue == 0) {
                z = false;
            } else {
                boolean zzj = zzjf.zza().zzb(zzaz.getClass()).zzj(zzaz);
                zzaz.zzl(2, true != zzj ? null : zzaz, (Object) null);
                z = zzj;
            }
        }
        if (z) {
            return zzaz;
        }
        throw new zzjv(zzaz);
    }

    public final BuilderType zzaB(MessageType messagetype) {
        if (this.zzb) {
            zzax();
            this.zzb = false;
        }
        zza(this.zza, messagetype);
        return this;
    }

    public final BuilderType zzaC(byte[] bArr, int i, int i2, zzhe zzhe) throws zzic {
        if (this.zzb) {
            zzax();
            this.zzb = false;
        }
        try {
            zzjf.zza().zzb(this.zza.getClass()).zzh(this.zza, bArr, 0, i2, new zzge(zzhe));
            return this;
        } catch (zzic e) {
            throw e;
        } catch (IndexOutOfBoundsException unused) {
            throw zzic.zza();
        } catch (IOException e2) {
            throw new RuntimeException("Reading from byte array should not throw IOException.", e2);
        }
    }

    public final /* bridge */ /* synthetic */ zzga zzar(byte[] bArr, int i, int i2) throws zzic {
        zzaC(bArr, 0, i2, zzhe.zza());
        return this;
    }

    public final /* bridge */ /* synthetic */ zzga zzas(byte[] bArr, int i, int i2, zzhe zzhe) throws zzic {
        zzaC(bArr, 0, i2, zzhe);
        return this;
    }

    /* access modifiers changed from: protected */
    public final /* bridge */ /* synthetic */ zzga zzat(zzgb zzgb) {
        zzaB((zzhs) zzgb);
        return this;
    }

    /* access modifiers changed from: protected */
    public void zzax() {
        MessageType messagetype = (zzhs) this.zza.zzl(4, (Object) null, (Object) null);
        zza(messagetype, this.zza);
        this.zza = messagetype;
    }

    /* renamed from: zzay */
    public final BuilderType zzaq() {
        BuilderType buildertype = (zzho) this.zzc.zzl(5, (Object) null, (Object) null);
        buildertype.zzaB(zzaD());
        return buildertype;
    }

    /* renamed from: zzaz */
    public MessageType zzaD() {
        if (this.zzb) {
            return this.zza;
        }
        MessageType messagetype = this.zza;
        zzjf.zza().zzb(messagetype.getClass()).zzi(messagetype);
        this.zzb = true;
        return this.zza;
    }

    public final /* bridge */ /* synthetic */ zzix zzbK() {
        return this.zzc;
    }
}
