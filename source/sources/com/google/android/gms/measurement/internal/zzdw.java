package com.google.android.gms.measurement.internal;

import android.content.Context;
import androidx.work.WorkRequest;
import com.google.android.exoplayer2.audio.AacUtil;
import com.google.android.gms.internal.measurement.zzen;
import com.google.android.gms.internal.measurement.zzex;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.apache.commons.lang3.time.DateUtils;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@18.0.2 */
public final class zzdw {
    public static final zzdv<Long> zzA = zzb("measurement.upload.retry_time", 1800000L, 1800000L, zzbm.zza);
    public static final zzdv<Integer> zzB = zzb("measurement.upload.retry_count", 6, 6, zzbn.zza);
    public static final zzdv<Long> zzC = zzb("measurement.upload.max_queue_time", 2419200000L, 2419200000L, zzbo.zza);
    public static final zzdv<Integer> zzD = zzb("measurement.lifetimevalue.max_currency_tracked", 4, 4, zzbp.zza);
    public static final zzdv<Integer> zzE = zzb("measurement.audience.filter_result_max_count", 200, 200, zzbr.zza);
    public static final zzdv<Integer> zzF = zzb("measurement.upload.max_public_user_properties", 25, 25, (zzdt) null);
    public static final zzdv<Integer> zzG = zzb("measurement.upload.max_event_name_cardinality", 500, 500, (zzdt) null);
    public static final zzdv<Integer> zzH = zzb("measurement.upload.max_public_event_params", 25, 25, (zzdt) null);
    public static final zzdv<Long> zzI = zzb("measurement.service_client.idle_disconnect_millis", 5000L, 5000L, zzbs.zza);
    public static final zzdv<Boolean> zzJ = zzb("measurement.test.boolean_flag", false, false, zzbt.zza);
    public static final zzdv<String> zzK = zzb("measurement.test.string_flag", "---", "---", zzbu.zza);
    public static final zzdv<Long> zzL = zzb("measurement.test.long_flag", -1L, -1L, zzbv.zza);
    public static final zzdv<Integer> zzM = zzb("measurement.test.int_flag", -2, -2, zzbw.zza);
    public static final zzdv<Double> zzN;
    public static final zzdv<Integer> zzO = zzb("measurement.experiment.max_ids", 50, 50, zzby.zza);
    public static final zzdv<Integer> zzP = zzb("measurement.max_bundles_per_iteration", 100, 100, zzbz.zza);
    public static final zzdv<Long> zzQ = zzb("measurement.sdk.attribution.cache.ttl", 604800000L, 604800000L, zzca.zza);
    public static final zzdv<Boolean> zzR = zzb("measurement.validation.internal_limits_internal_event_params", false, false, zzcc.zza);
    public static final zzdv<Boolean> zzS = zzb("measurement.collection.firebase_global_collection_flag_enabled", true, true, zzcd.zza);
    public static final zzdv<Boolean> zzT = zzb("measurement.collection.redundant_engagement_removal_enabled", false, false, zzce.zza);
    public static final zzdv<Boolean> zzU = zzb("measurement.collection.log_event_and_bundle_v2", true, true, zzcf.zza);
    public static final zzdv<Boolean> zzV = zzb("measurement.quality.checksum", false, false, (zzdt) null);
    public static final zzdv<Boolean> zzW = zzb("measurement.sdk.dynamite.allow_remote_dynamite3", true, true, zzcg.zza);
    public static final zzdv<Boolean> zzX = zzb("measurement.sdk.collection.validate_param_names_alphabetical", true, true, zzch.zza);
    public static final zzdv<Boolean> zzY = zzb("measurement.audience.use_bundle_end_timestamp_for_non_sequence_property_filters", false, false, zzci.zza);
    public static final zzdv<Boolean> zzZ = zzb("measurement.audience.refresh_event_count_filters_timestamp", false, false, zzcj.zza);
    public static final zzdv<Long> zza;
    public static final zzdv<Boolean> zzaA = zzb("measurement.service.directly_maybe_log_error_events", false, false, zzdn.zza);
    public static final zzdv<Boolean> zzaB = zzb("measurement.client.safer_resources", true, true, zzdo.zza);
    /* access modifiers changed from: private */
    public static final List<zzdv<?>> zzaC = Collections.synchronizedList(new ArrayList());
    private static final Set<zzdv<?>> zzaD = Collections.synchronizedSet(new HashSet());
    public static final zzdv<Boolean> zzaa = zzb("measurement.audience.use_bundle_timestamp_for_event_count_filters", false, false, zzck.zza);
    public static final zzdv<Boolean> zzab = zzb("measurement.sdk.collection.retrieve_deeplink_from_bow_2", true, true, zzcl.zza);
    public static final zzdv<Boolean> zzac = zzb("measurement.sdk.collection.last_deep_link_referrer2", true, true, zzcn.zza);
    public static final zzdv<Boolean> zzad = zzb("measurement.sdk.collection.last_deep_link_referrer_campaign2", false, false, zzco.zza);
    public static final zzdv<Boolean> zzae = zzb("measurement.sdk.collection.last_gclid_from_referrer2", false, false, zzcp.zza);
    public static final zzdv<Boolean> zzaf = zzb("measurement.sdk.collection.enable_extend_user_property_size", true, true, zzcq.zza);
    public static final zzdv<Boolean> zzag = zzb("measurement.upload.file_lock_state_check", false, false, zzcr.zza);
    public static final zzdv<Boolean> zzah = zzb("measurement.ga.ga_app_id", false, false, zzcs.zza);
    public static final zzdv<Boolean> zzai = zzb("measurement.lifecycle.app_in_background_parameter", false, false, zzct.zza);
    public static final zzdv<Boolean> zzaj = zzb("measurement.integration.disable_firebase_instance_id", false, false, zzcu.zza);
    public static final zzdv<Boolean> zzak = zzb("measurement.lifecycle.app_backgrounded_engagement", false, false, zzcv.zza);
    public static final zzdv<Boolean> zzal = zzb("measurement.collection.service.update_with_analytics_fix", false, false, zzcw.zza);
    public static final zzdv<Boolean> zzam = zzb("measurement.service.use_appinfo_modified", false, false, zzcy.zza);
    public static final zzdv<Boolean> zzan = zzb("measurement.client.firebase_feature_rollout.v1.enable", true, true, zzcz.zza);
    public static final zzdv<Boolean> zzao = zzb("measurement.client.sessions.check_on_reset_and_enable2", true, true, zzda.zza);
    public static final zzdv<Boolean> zzap = zzb("measurement.scheduler.task_thread.cleanup_on_exit", false, false, zzdb.zza);
    public static final zzdv<Boolean> zzaq = zzb("measurement.upload.file_truncate_fix", false, false, zzdc.zza);
    public static final zzdv<Boolean> zzar = zzb("measurement.sdk.referrer.delayed_install_referrer_api", false, false, zzdd.zza);
    public static final zzdv<Boolean> zzas = zzb("measurement.sdk.screen.disabling_automatic_reporting", true, true, zzde.zza);
    public static final zzdv<Boolean> zzat = zzb("measurement.sdk.screen.manual_screen_view_logging", true, true, zzdf.zza);
    public static final zzdv<Boolean> zzau = zzb("measurement.collection.synthetic_data_mitigation", false, false, zzdg.zza);
    public static final zzdv<Boolean> zzav = zzb("measurement.androidId.delete_feature", true, true, zzdh.zza);
    public static final zzdv<Boolean> zzaw = zzb("measurement.client.consent_state_v1", true, true, zzdj.zza);
    public static final zzdv<Boolean> zzax = zzb("measurement.client.3p_consent_state_v1", true, true, zzdk.zza);
    public static final zzdv<Boolean> zzay = zzb("measurement.service.consent_state_v1_W36", true, true, zzdl.zza);
    public static final zzdv<Integer> zzaz = zzb("measurement.service.storage_consent_support_version", 203590, 203590, zzdm.zza);
    public static final zzdv<Long> zzb;
    public static final zzdv<Long> zzc;
    public static final zzdv<String> zzd = zzb("measurement.config.url_scheme", "https", "https", zzcb.zza);
    public static final zzdv<String> zze = zzb("measurement.config.url_authority", "app-measurement.com", "app-measurement.com", zzcm.zza);
    public static final zzdv<Integer> zzf = zzb("measurement.upload.max_bundles", 100, 100, zzcx.zza);
    public static final zzdv<Integer> zzg = zzb("measurement.upload.max_batch_size", 65536, 65536, zzdi.zza);
    public static final zzdv<Integer> zzh = zzb("measurement.upload.max_bundle_size", 65536, 65536, zzdp.zza);
    public static final zzdv<Integer> zzi = zzb("measurement.upload.max_events_per_bundle", 1000, 1000, zzdq.zza);
    public static final zzdv<Integer> zzj;
    public static final zzdv<Integer> zzk = zzb("measurement.upload.max_error_events_per_day", 1000, 1000, zzav.zza);
    public static final zzdv<Integer> zzl = zzb("measurement.upload.max_public_events_per_day", 50000, 50000, zzaw.zza);
    public static final zzdv<Integer> zzm = zzb("measurement.upload.max_conversions_per_day", 10000, 10000, zzax.zza);
    public static final zzdv<Integer> zzn = zzb("measurement.upload.max_realtime_events_per_day", 10, 10, zzay.zza);
    public static final zzdv<Integer> zzo;
    public static final zzdv<String> zzp = zzb("measurement.upload.url", "https://app-measurement.com/a", "https://app-measurement.com/a", zzba.zza);
    public static final zzdv<Long> zzq = zzb("measurement.upload.backoff_period", 43200000L, 43200000L, zzbb.zza);
    public static final zzdv<Long> zzr;
    public static final zzdv<Long> zzs;
    public static final zzdv<Long> zzt;
    public static final zzdv<Long> zzu = zzb("measurement.upload.debug_upload_interval", 1000L, 1000L, zzbg.zza);
    public static final zzdv<Long> zzv = zzb("measurement.upload.minimum_delay", 500L, 500L, zzbh.zza);
    public static final zzdv<Long> zzw = zzb("measurement.alarm_manager.minimum_interval", 60000L, 60000L, zzbi.zza);
    public static final zzdv<Long> zzx;
    public static final zzdv<Long> zzy = zzb("measurement.upload.refresh_blacklisted_config_interval", 604800000L, 604800000L, zzbk.zza);
    public static final zzdv<Long> zzz = zzb("measurement.upload.initial_upload_delay_time", 15000L, 15000L, zzbl.zza);

    static {
        Long valueOf = Long.valueOf(WorkRequest.MIN_BACKOFF_MILLIS);
        zza = zzb("measurement.ad_id_cache_time", valueOf, valueOf, zzau.zza);
        Long valueOf2 = Long.valueOf(DateUtils.MILLIS_PER_DAY);
        zzb = zzb("measurement.monitoring.sample_period_millis", valueOf2, valueOf2, zzbf.zza);
        Long valueOf3 = Long.valueOf(DateUtils.MILLIS_PER_HOUR);
        zzc = zzb("measurement.config.cache_time", valueOf2, valueOf3, zzbq.zza);
        Integer valueOf4 = Integer.valueOf(AacUtil.AAC_LC_MAX_RATE_BYTES_PER_SECOND);
        zzj = zzb("measurement.upload.max_events_per_day", valueOf4, valueOf4, zzdr.zza);
        zzo = zzb("measurement.store.max_stored_events_per_app", valueOf4, valueOf4, zzaz.zza);
        zzr = zzb("measurement.upload.window_interval", valueOf3, valueOf3, zzbc.zza);
        zzs = zzb("measurement.upload.interval", valueOf3, valueOf3, zzbd.zza);
        zzt = zzb("measurement.upload.realtime_upload_interval", valueOf, valueOf, zzbe.zza);
        zzx = zzb("measurement.upload.stale_data_deletion_interval", valueOf2, valueOf2, zzbj.zza);
        Double valueOf5 = Double.valueOf(-3.0d);
        zzN = zzb("measurement.test.double_flag", valueOf5, valueOf5, zzbx.zza);
    }

    public static Map<String, String> zza(Context context) {
        zzen zza2 = zzen.zza(context.getContentResolver(), zzex.zza("com.google.android.gms.measurement"));
        return zza2 == null ? Collections.emptyMap() : zza2.zzb();
    }

    static <V> zzdv<V> zzb(String str, V v, V v2, zzdt<V> zzdt) {
        zzdv zzdv = new zzdv(str, v, v2, zzdt, (zzds) null);
        zzaC.add(zzdv);
        return zzdv;
    }
}
