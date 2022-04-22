package com.google.android.gms.internal.p026firebaseauthapi;

import com.google.android.gms.internal.p026firebaseauthapi.zzaad;
import com.google.android.gms.internal.p026firebaseauthapi.zzzz;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzzz */
/* compiled from: com.google.firebase:firebase-auth@@20.0.2 */
public class zzzz<MessageType extends zzaad<MessageType, BuilderType>, BuilderType extends zzzz<MessageType, BuilderType>> extends zzyi<MessageType, BuilderType> {
    protected MessageType zza;
    protected boolean zzb = false;
    private final MessageType zzc;

    protected zzzz(MessageType messagetype) {
        this.zzc = messagetype;
        this.zza = (zzaad) messagetype.zzj(4, (Object) null, (Object) null);
    }

    private static final void zza(MessageType messagetype, MessageType messagetype2) {
        zzabo.zza().zzb(messagetype.getClass()).zzd(messagetype, messagetype2);
    }

    /* access modifiers changed from: protected */
    public final /* bridge */ /* synthetic */ zzyi zzg(zzyj zzyj) {
        zzm((zzaad) zzyj);
        return this;
    }

    /* access modifiers changed from: protected */
    public void zzi() {
        MessageType messagetype = (zzaad) this.zza.zzj(4, (Object) null, (Object) null);
        zza(messagetype, this.zza);
        this.zza = messagetype;
    }

    /* renamed from: zzj */
    public final BuilderType zzf() {
        BuilderType buildertype = (zzzz) this.zzc.zzj(5, (Object) null, (Object) null);
        buildertype.zzm(zzn());
        return buildertype;
    }

    /* renamed from: zzk */
    public MessageType zzn() {
        if (this.zzb) {
            return this.zza;
        }
        MessageType messagetype = this.zza;
        zzabo.zza().zzb(messagetype.getClass()).zzj(messagetype);
        this.zzb = true;
        return this.zza;
    }

    public final MessageType zzl() {
        MessageType zzk = zzn();
        if (zzk.zzt()) {
            return zzk;
        }
        throw new zzacf(zzk);
    }

    public final BuilderType zzm(MessageType messagetype) {
        if (this.zzb) {
            zzi();
            this.zzb = false;
        }
        zza(this.zza, messagetype);
        return this;
    }

    public final /* bridge */ /* synthetic */ zzabg zzo() {
        return this.zzc;
    }
}
