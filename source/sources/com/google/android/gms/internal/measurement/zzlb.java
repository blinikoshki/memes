package com.google.android.gms.internal.measurement;

import android.support.p003v4.media.session.PlaybackStateCompat;
import androidx.work.WorkRequest;
import org.apache.commons.lang3.time.DateUtils;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@18.0.2 */
public final class zzlb implements zzla {
    public static final zzfg<Long> zzA;
    public static final zzfg<Long> zzB;
    public static final zzfg<Long> zzC;
    public static final zzfg<Long> zzD;
    public static final zzfg<Long> zzE;
    public static final zzfg<Long> zzF;
    public static final zzfg<Long> zzG;
    public static final zzfg<Long> zzH;
    public static final zzfg<Long> zzI;
    public static final zzfg<Long> zzJ;
    public static final zzfg<String> zzK;
    public static final zzfg<Long> zzL;
    public static final zzfg<Long> zza;
    public static final zzfg<Long> zzb;
    public static final zzfg<Long> zzc;
    public static final zzfg<String> zzd;
    public static final zzfg<String> zze;
    public static final zzfg<String> zzf;
    public static final zzfg<Long> zzg;
    public static final zzfg<Long> zzh;
    public static final zzfg<Long> zzi;
    public static final zzfg<Long> zzj;
    public static final zzfg<Long> zzk;
    public static final zzfg<Long> zzl;
    public static final zzfg<Long> zzm;
    public static final zzfg<Long> zzn;
    public static final zzfg<Long> zzo;
    public static final zzfg<Long> zzp;
    public static final zzfg<Long> zzq;
    public static final zzfg<Long> zzr;
    public static final zzfg<String> zzs;
    public static final zzfg<Long> zzt;
    public static final zzfg<Long> zzu;
    public static final zzfg<Long> zzv;
    public static final zzfg<Long> zzw;
    public static final zzfg<Long> zzx;
    public static final zzfg<Long> zzy;
    public static final zzfg<Long> zzz;

    static {
        zzfe zzfe = new zzfe(zzex.zza("com.google.android.gms.measurement"));
        zza = zzfe.zza("measurement.ad_id_cache_time", WorkRequest.MIN_BACKOFF_MILLIS);
        zzb = zzfe.zza("measurement.max_bundles_per_iteration", 100);
        zzc = zzfe.zza("measurement.config.cache_time", DateUtils.MILLIS_PER_DAY);
        zzd = zzfe.zzd("measurement.log_tag", "FA");
        zze = zzfe.zzd("measurement.config.url_authority", "app-measurement.com");
        zzf = zzfe.zzd("measurement.config.url_scheme", "https");
        zzg = zzfe.zza("measurement.upload.debug_upload_interval", 1000);
        zzh = zzfe.zza("measurement.lifetimevalue.max_currency_tracked", 4);
        zzi = zzfe.zza("measurement.store.max_stored_events_per_app", 100000);
        zzj = zzfe.zza("measurement.experiment.max_ids", 50);
        zzk = zzfe.zza("measurement.audience.filter_result_max_count", 200);
        zzl = zzfe.zza("measurement.alarm_manager.minimum_interval", 60000);
        zzm = zzfe.zza("measurement.upload.minimum_delay", 500);
        zzn = zzfe.zza("measurement.monitoring.sample_period_millis", DateUtils.MILLIS_PER_DAY);
        zzo = zzfe.zza("measurement.upload.realtime_upload_interval", WorkRequest.MIN_BACKOFF_MILLIS);
        zzp = zzfe.zza("measurement.upload.refresh_blacklisted_config_interval", 604800000);
        zzq = zzfe.zza("measurement.config.cache_time.service", DateUtils.MILLIS_PER_HOUR);
        zzr = zzfe.zza("measurement.service_client.idle_disconnect_millis", 5000);
        zzs = zzfe.zzd("measurement.log_tag.service", "FA-SVC");
        zzt = zzfe.zza("measurement.upload.stale_data_deletion_interval", DateUtils.MILLIS_PER_DAY);
        zzu = zzfe.zza("measurement.sdk.attribution.cache.ttl", 604800000);
        zzv = zzfe.zza("measurement.upload.backoff_period", 43200000);
        zzw = zzfe.zza("measurement.upload.initial_upload_delay_time", 15000);
        zzx = zzfe.zza("measurement.upload.interval", DateUtils.MILLIS_PER_HOUR);
        zzy = zzfe.zza("measurement.upload.max_bundle_size", PlaybackStateCompat.ACTION_PREPARE_FROM_SEARCH);
        zzz = zzfe.zza("measurement.upload.max_bundles", 100);
        zzA = zzfe.zza("measurement.upload.max_conversions_per_day", 500);
        zzB = zzfe.zza("measurement.upload.max_error_events_per_day", 1000);
        zzC = zzfe.zza("measurement.upload.max_events_per_bundle", 1000);
        zzD = zzfe.zza("measurement.upload.max_events_per_day", 100000);
        zzE = zzfe.zza("measurement.upload.max_public_events_per_day", 50000);
        zzF = zzfe.zza("measurement.upload.max_queue_time", 2419200000L);
        zzG = zzfe.zza("measurement.upload.max_realtime_events_per_day", 10);
        zzH = zzfe.zza("measurement.upload.max_batch_size", PlaybackStateCompat.ACTION_PREPARE_FROM_SEARCH);
        zzI = zzfe.zza("measurement.upload.retry_count", 6);
        zzJ = zzfe.zza("measurement.upload.retry_time", 1800000);
        zzK = zzfe.zzd("measurement.upload.url", "https://app-measurement.com/a");
        zzL = zzfe.zza("measurement.upload.window_interval", DateUtils.MILLIS_PER_HOUR);
    }

    public final long zzA() {
        return zzD.zze().longValue();
    }

    public final long zzB() {
        return zzE.zze().longValue();
    }

    public final long zzC() {
        return zzF.zze().longValue();
    }

    public final long zzD() {
        return zzG.zze().longValue();
    }

    public final long zzE() {
        return zzH.zze().longValue();
    }

    public final long zzF() {
        return zzI.zze().longValue();
    }

    public final long zzG() {
        return zzJ.zze().longValue();
    }

    public final String zzH() {
        return zzK.zze();
    }

    public final long zzI() {
        return zzL.zze().longValue();
    }

    public final long zza() {
        return zza.zze().longValue();
    }

    public final long zzb() {
        return zzb.zze().longValue();
    }

    public final long zzc() {
        return zzc.zze().longValue();
    }

    public final String zzd() {
        return zze.zze();
    }

    public final String zze() {
        return zzf.zze();
    }

    public final long zzf() {
        return zzg.zze().longValue();
    }

    public final long zzg() {
        return zzh.zze().longValue();
    }

    public final long zzh() {
        return zzi.zze().longValue();
    }

    public final long zzi() {
        return zzj.zze().longValue();
    }

    public final long zzj() {
        return zzk.zze().longValue();
    }

    public final long zzk() {
        return zzl.zze().longValue();
    }

    public final long zzl() {
        return zzm.zze().longValue();
    }

    public final long zzm() {
        return zzn.zze().longValue();
    }

    public final long zzn() {
        return zzo.zze().longValue();
    }

    public final long zzo() {
        return zzp.zze().longValue();
    }

    public final long zzp() {
        return zzr.zze().longValue();
    }

    public final long zzq() {
        return zzt.zze().longValue();
    }

    public final long zzr() {
        return zzu.zze().longValue();
    }

    public final long zzs() {
        return zzv.zze().longValue();
    }

    public final long zzt() {
        return zzw.zze().longValue();
    }

    public final long zzu() {
        return zzx.zze().longValue();
    }

    public final long zzv() {
        return zzy.zze().longValue();
    }

    public final long zzw() {
        return zzz.zze().longValue();
    }

    public final long zzx() {
        return zzA.zze().longValue();
    }

    public final long zzy() {
        return zzB.zze().longValue();
    }

    public final long zzz() {
        return zzC.zze().longValue();
    }
}
