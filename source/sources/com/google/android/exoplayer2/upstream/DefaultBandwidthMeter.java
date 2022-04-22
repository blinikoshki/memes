package com.google.android.exoplayer2.upstream;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Handler;
import android.os.Looper;
import android.support.p003v4.media.session.PlaybackStateCompat;
import com.google.android.exoplayer2.upstream.BandwidthMeter;
import com.google.android.exoplayer2.upstream.DefaultBandwidthMeter;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.Clock;
import com.google.android.exoplayer2.util.SlidingPercentile;
import com.google.android.exoplayer2.util.Util;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableListMultimap;
import com.google.common.collect.ImmutableMap;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public final class DefaultBandwidthMeter implements BandwidthMeter, TransferListener {
    private static final int BYTES_TRANSFERRED_FOR_ESTIMATE = 524288;
    private static final int COUNTRY_GROUP_INDEX_2G = 1;
    private static final int COUNTRY_GROUP_INDEX_3G = 2;
    private static final int COUNTRY_GROUP_INDEX_4G = 3;
    private static final int COUNTRY_GROUP_INDEX_5G_NSA = 4;
    private static final int COUNTRY_GROUP_INDEX_WIFI = 0;
    public static final ImmutableListMultimap<String, Integer> DEFAULT_INITIAL_BITRATE_COUNTRY_GROUPS = createInitialBitrateCountryGroupAssignment();
    public static final long DEFAULT_INITIAL_BITRATE_ESTIMATE = 1000000;
    public static final ImmutableList<Long> DEFAULT_INITIAL_BITRATE_ESTIMATES_2G = ImmutableList.m438of(218000L, 159000L, 145000L, 130000L, 112000L);
    public static final ImmutableList<Long> DEFAULT_INITIAL_BITRATE_ESTIMATES_3G = ImmutableList.m438of(2200000L, 1300000L, 930000L, 730000L, 530000L);
    public static final ImmutableList<Long> DEFAULT_INITIAL_BITRATE_ESTIMATES_4G = ImmutableList.m438of(4800000L, 2700000L, 1800000L, 1200000L, 630000L);
    public static final ImmutableList<Long> DEFAULT_INITIAL_BITRATE_ESTIMATES_5G_NSA = ImmutableList.m438of(12000000L, 8800000L, 5900000L, 3500000L, 1800000L);
    public static final ImmutableList<Long> DEFAULT_INITIAL_BITRATE_ESTIMATES_WIFI = ImmutableList.m438of(6100000L, 3800000L, 2100000L, 1300000L, 590000L);
    public static final int DEFAULT_SLIDING_WINDOW_MAX_WEIGHT = 2000;
    private static final int ELAPSED_MILLIS_FOR_ESTIMATE = 2000;
    private static DefaultBandwidthMeter singletonInstance;
    private long bitrateEstimate;
    private final Clock clock;
    private final Context context;
    private final BandwidthMeter.EventListener.EventDispatcher eventDispatcher;
    private final ImmutableMap<Integer, Long> initialBitrateEstimates;
    private long lastReportedBitrateEstimate;
    private int networkType;
    private int networkTypeOverride;
    private boolean networkTypeOverrideSet;
    private long sampleBytesTransferred;
    private long sampleStartTimeMs;
    private final SlidingPercentile slidingPercentile;
    private int streamCount;
    private long totalBytesTransferred;
    private long totalElapsedTimeMs;

    public TransferListener getTransferListener() {
        return this;
    }

    public void onTransferInitializing(DataSource dataSource, DataSpec dataSpec, boolean z) {
    }

    public static final class Builder {
        private Clock clock;
        private final Context context;
        private Map<Integer, Long> initialBitrateEstimates;
        private boolean resetOnNetworkTypeChange;
        private int slidingWindowMaxWeight;

        public Builder(Context context2) {
            Context context3;
            if (context2 == null) {
                context3 = null;
            } else {
                context3 = context2.getApplicationContext();
            }
            this.context = context3;
            this.initialBitrateEstimates = getInitialBitrateEstimatesForCountry(Util.getCountryCode(context2));
            this.slidingWindowMaxWeight = 2000;
            this.clock = Clock.DEFAULT;
            this.resetOnNetworkTypeChange = true;
        }

        public Builder setSlidingWindowMaxWeight(int i) {
            this.slidingWindowMaxWeight = i;
            return this;
        }

        public Builder setInitialBitrateEstimate(long j) {
            for (Integer intValue : this.initialBitrateEstimates.keySet()) {
                setInitialBitrateEstimate(intValue.intValue(), j);
            }
            return this;
        }

        public Builder setInitialBitrateEstimate(int i, long j) {
            this.initialBitrateEstimates.put(Integer.valueOf(i), Long.valueOf(j));
            return this;
        }

        public Builder setInitialBitrateEstimate(String str) {
            this.initialBitrateEstimates = getInitialBitrateEstimatesForCountry(Util.toUpperInvariant(str));
            return this;
        }

        public Builder setClock(Clock clock2) {
            this.clock = clock2;
            return this;
        }

        public Builder setResetOnNetworkTypeChange(boolean z) {
            this.resetOnNetworkTypeChange = z;
            return this;
        }

        public DefaultBandwidthMeter build() {
            return new DefaultBandwidthMeter(this.context, this.initialBitrateEstimates, this.slidingWindowMaxWeight, this.clock, this.resetOnNetworkTypeChange);
        }

        private static Map<Integer, Long> getInitialBitrateEstimatesForCountry(String str) {
            ImmutableList<Integer> countryGroupIndices = getCountryGroupIndices(str);
            HashMap hashMap = new HashMap(6);
            hashMap.put(0, 1000000L);
            hashMap.put(2, (Long) DefaultBandwidthMeter.DEFAULT_INITIAL_BITRATE_ESTIMATES_WIFI.get(countryGroupIndices.get(0).intValue()));
            hashMap.put(3, (Long) DefaultBandwidthMeter.DEFAULT_INITIAL_BITRATE_ESTIMATES_2G.get(countryGroupIndices.get(1).intValue()));
            hashMap.put(4, (Long) DefaultBandwidthMeter.DEFAULT_INITIAL_BITRATE_ESTIMATES_3G.get(countryGroupIndices.get(2).intValue()));
            hashMap.put(5, (Long) DefaultBandwidthMeter.DEFAULT_INITIAL_BITRATE_ESTIMATES_4G.get(countryGroupIndices.get(3).intValue()));
            hashMap.put(9, (Long) DefaultBandwidthMeter.DEFAULT_INITIAL_BITRATE_ESTIMATES_5G_NSA.get(countryGroupIndices.get(4).intValue()));
            hashMap.put(7, (Long) DefaultBandwidthMeter.DEFAULT_INITIAL_BITRATE_ESTIMATES_WIFI.get(countryGroupIndices.get(0).intValue()));
            return hashMap;
        }

        private static ImmutableList<Integer> getCountryGroupIndices(String str) {
            ImmutableList<Integer> immutableList = DefaultBandwidthMeter.DEFAULT_INITIAL_BITRATE_COUNTRY_GROUPS.get((Object) str);
            return immutableList.isEmpty() ? ImmutableList.m438of(2, 2, 2, 2, 2) : immutableList;
        }
    }

    public static synchronized DefaultBandwidthMeter getSingletonInstance(Context context2) {
        DefaultBandwidthMeter defaultBandwidthMeter;
        synchronized (DefaultBandwidthMeter.class) {
            if (singletonInstance == null) {
                singletonInstance = new Builder(context2).build();
            }
            defaultBandwidthMeter = singletonInstance;
        }
        return defaultBandwidthMeter;
    }

    @Deprecated
    public DefaultBandwidthMeter() {
        this((Context) null, ImmutableMap.m452of(), 2000, Clock.DEFAULT, false);
    }

    private DefaultBandwidthMeter(Context context2, Map<Integer, Long> map, int i, Clock clock2, boolean z) {
        Context context3;
        int i2;
        if (context2 == null) {
            context3 = null;
        } else {
            context3 = context2.getApplicationContext();
        }
        this.context = context3;
        this.initialBitrateEstimates = ImmutableMap.copyOf(map);
        this.eventDispatcher = new BandwidthMeter.EventListener.EventDispatcher();
        this.slidingPercentile = new SlidingPercentile(i);
        this.clock = clock2;
        if (context2 == null) {
            i2 = 0;
        } else {
            i2 = Util.getNetworkType(context2);
        }
        this.networkType = i2;
        this.bitrateEstimate = getInitialBitrateEstimateForNetworkType(i2);
        if (context2 != null && z) {
            ConnectivityActionReceiver.getInstance(context2).register(this);
        }
    }

    public synchronized void setNetworkTypeOverride(int i) {
        this.networkTypeOverride = i;
        this.networkTypeOverrideSet = true;
        onConnectivityAction();
    }

    public synchronized long getBitrateEstimate() {
        return this.bitrateEstimate;
    }

    public void addEventListener(Handler handler, BandwidthMeter.EventListener eventListener) {
        Assertions.checkNotNull(handler);
        Assertions.checkNotNull(eventListener);
        this.eventDispatcher.addListener(handler, eventListener);
    }

    public void removeEventListener(BandwidthMeter.EventListener eventListener) {
        this.eventDispatcher.removeListener(eventListener);
    }

    public synchronized void onTransferStart(DataSource dataSource, DataSpec dataSpec, boolean z) {
        if (isTransferAtFullNetworkSpeed(dataSpec, z)) {
            if (this.streamCount == 0) {
                this.sampleStartTimeMs = this.clock.elapsedRealtime();
            }
            this.streamCount++;
        }
    }

    public synchronized void onBytesTransferred(DataSource dataSource, DataSpec dataSpec, boolean z, int i) {
        if (isTransferAtFullNetworkSpeed(dataSpec, z)) {
            this.sampleBytesTransferred += (long) i;
        }
    }

    public synchronized void onTransferEnd(DataSource dataSource, DataSpec dataSpec, boolean z) {
        if (isTransferAtFullNetworkSpeed(dataSpec, z)) {
            Assertions.checkState(this.streamCount > 0);
            long elapsedRealtime = this.clock.elapsedRealtime();
            int i = (int) (elapsedRealtime - this.sampleStartTimeMs);
            this.totalElapsedTimeMs += (long) i;
            long j = this.totalBytesTransferred;
            long j2 = this.sampleBytesTransferred;
            this.totalBytesTransferred = j + j2;
            if (i > 0) {
                this.slidingPercentile.addSample((int) Math.sqrt((double) j2), (((float) j2) * 8000.0f) / ((float) i));
                if (this.totalElapsedTimeMs >= 2000 || this.totalBytesTransferred >= PlaybackStateCompat.ACTION_SET_SHUFFLE_MODE_ENABLED) {
                    this.bitrateEstimate = (long) this.slidingPercentile.getPercentile(0.5f);
                }
                maybeNotifyBandwidthSample(i, this.sampleBytesTransferred, this.bitrateEstimate);
                this.sampleStartTimeMs = elapsedRealtime;
                this.sampleBytesTransferred = 0;
            }
            this.streamCount--;
        }
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Code restructure failed: missing block: B:28:0x0057, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized void onConnectivityAction() {
        /*
            r10 = this;
            monitor-enter(r10)
            boolean r0 = r10.networkTypeOverrideSet     // Catch:{ all -> 0x0058 }
            r1 = 0
            if (r0 == 0) goto L_0x0009
            int r0 = r10.networkTypeOverride     // Catch:{ all -> 0x0058 }
            goto L_0x0013
        L_0x0009:
            android.content.Context r0 = r10.context     // Catch:{ all -> 0x0058 }
            if (r0 != 0) goto L_0x000f
            r0 = 0
            goto L_0x0013
        L_0x000f:
            int r0 = com.google.android.exoplayer2.util.Util.getNetworkType(r0)     // Catch:{ all -> 0x0058 }
        L_0x0013:
            int r2 = r10.networkType     // Catch:{ all -> 0x0058 }
            if (r2 != r0) goto L_0x0019
            monitor-exit(r10)
            return
        L_0x0019:
            r10.networkType = r0     // Catch:{ all -> 0x0058 }
            r2 = 1
            if (r0 == r2) goto L_0x0056
            if (r0 == 0) goto L_0x0056
            r2 = 8
            if (r0 != r2) goto L_0x0025
            goto L_0x0056
        L_0x0025:
            long r2 = r10.getInitialBitrateEstimateForNetworkType(r0)     // Catch:{ all -> 0x0058 }
            r10.bitrateEstimate = r2     // Catch:{ all -> 0x0058 }
            com.google.android.exoplayer2.util.Clock r0 = r10.clock     // Catch:{ all -> 0x0058 }
            long r2 = r0.elapsedRealtime()     // Catch:{ all -> 0x0058 }
            int r0 = r10.streamCount     // Catch:{ all -> 0x0058 }
            if (r0 <= 0) goto L_0x003c
            long r0 = r10.sampleStartTimeMs     // Catch:{ all -> 0x0058 }
            long r0 = r2 - r0
            int r1 = (int) r0     // Catch:{ all -> 0x0058 }
            r5 = r1
            goto L_0x003d
        L_0x003c:
            r5 = 0
        L_0x003d:
            long r6 = r10.sampleBytesTransferred     // Catch:{ all -> 0x0058 }
            long r8 = r10.bitrateEstimate     // Catch:{ all -> 0x0058 }
            r4 = r10
            r4.maybeNotifyBandwidthSample(r5, r6, r8)     // Catch:{ all -> 0x0058 }
            r10.sampleStartTimeMs = r2     // Catch:{ all -> 0x0058 }
            r0 = 0
            r10.sampleBytesTransferred = r0     // Catch:{ all -> 0x0058 }
            r10.totalBytesTransferred = r0     // Catch:{ all -> 0x0058 }
            r10.totalElapsedTimeMs = r0     // Catch:{ all -> 0x0058 }
            com.google.android.exoplayer2.util.SlidingPercentile r0 = r10.slidingPercentile     // Catch:{ all -> 0x0058 }
            r0.reset()     // Catch:{ all -> 0x0058 }
            monitor-exit(r10)
            return
        L_0x0056:
            monitor-exit(r10)
            return
        L_0x0058:
            r0 = move-exception
            monitor-exit(r10)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.upstream.DefaultBandwidthMeter.onConnectivityAction():void");
    }

    private void maybeNotifyBandwidthSample(int i, long j, long j2) {
        if (i != 0 || j != 0 || j2 != this.lastReportedBitrateEstimate) {
            this.lastReportedBitrateEstimate = j2;
            this.eventDispatcher.bandwidthSample(i, j, j2);
        }
    }

    private long getInitialBitrateEstimateForNetworkType(int i) {
        Long l = this.initialBitrateEstimates.get(Integer.valueOf(i));
        if (l == null) {
            l = this.initialBitrateEstimates.get(0);
        }
        if (l == null) {
            l = 1000000L;
        }
        return l.longValue();
    }

    private static boolean isTransferAtFullNetworkSpeed(DataSpec dataSpec, boolean z) {
        return z && !dataSpec.isFlagSet(8);
    }

    private static class ConnectivityActionReceiver extends BroadcastReceiver {
        private static ConnectivityActionReceiver staticInstance;
        private final ArrayList<WeakReference<DefaultBandwidthMeter>> bandwidthMeters = new ArrayList<>();
        private final Handler mainHandler = new Handler(Looper.getMainLooper());

        public static synchronized ConnectivityActionReceiver getInstance(Context context) {
            ConnectivityActionReceiver connectivityActionReceiver;
            synchronized (ConnectivityActionReceiver.class) {
                if (staticInstance == null) {
                    staticInstance = new ConnectivityActionReceiver();
                    IntentFilter intentFilter = new IntentFilter();
                    intentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
                    context.registerReceiver(staticInstance, intentFilter);
                }
                connectivityActionReceiver = staticInstance;
            }
            return connectivityActionReceiver;
        }

        private ConnectivityActionReceiver() {
        }

        public synchronized void register(DefaultBandwidthMeter defaultBandwidthMeter) {
            removeClearedReferences();
            this.bandwidthMeters.add(new WeakReference(defaultBandwidthMeter));
            this.mainHandler.post(new Runnable(defaultBandwidthMeter) {
                public final /* synthetic */ DefaultBandwidthMeter f$1;

                {
                    this.f$1 = r2;
                }

                public final void run() {
                    DefaultBandwidthMeter.ConnectivityActionReceiver.this.mo38471xc0d413df(this.f$1);
                }
            });
        }

        public synchronized void onReceive(Context context, Intent intent) {
            if (!isInitialStickyBroadcast()) {
                removeClearedReferences();
                for (int i = 0; i < this.bandwidthMeters.size(); i++) {
                    DefaultBandwidthMeter defaultBandwidthMeter = (DefaultBandwidthMeter) this.bandwidthMeters.get(i).get();
                    if (defaultBandwidthMeter != null) {
                        mo38471xc0d413df(defaultBandwidthMeter);
                    }
                }
            }
        }

        /* access modifiers changed from: private */
        /* renamed from: updateBandwidthMeter */
        public void mo38471xc0d413df(DefaultBandwidthMeter defaultBandwidthMeter) {
            defaultBandwidthMeter.onConnectivityAction();
        }

        private void removeClearedReferences() {
            for (int size = this.bandwidthMeters.size() - 1; size >= 0; size--) {
                if (((DefaultBandwidthMeter) this.bandwidthMeters.get(size).get()) == null) {
                    this.bandwidthMeters.remove(size);
                }
            }
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v0, resolved type: java.lang.Integer[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v0, resolved type: java.lang.Integer} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v2, resolved type: java.lang.Integer[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v3, resolved type: java.lang.Integer[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v4, resolved type: java.lang.Integer[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v5, resolved type: java.lang.Integer[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v6, resolved type: java.lang.Integer[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v7, resolved type: java.lang.Integer[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v8, resolved type: java.lang.Integer[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v9, resolved type: java.lang.Integer[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v10, resolved type: java.lang.Integer[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v11, resolved type: java.lang.Integer[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v12, resolved type: java.lang.Integer[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v13, resolved type: java.lang.Integer[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v14, resolved type: java.lang.Integer[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v15, resolved type: java.lang.Integer[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v16, resolved type: java.lang.Integer[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v17, resolved type: java.lang.Integer[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v18, resolved type: java.lang.Integer[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v19, resolved type: java.lang.Integer[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v20, resolved type: java.lang.Integer[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v21, resolved type: java.lang.Integer[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v22, resolved type: java.lang.Integer[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v23, resolved type: java.lang.Integer[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v24, resolved type: java.lang.Integer[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v25, resolved type: java.lang.Integer[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v26, resolved type: java.lang.Integer[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v27, resolved type: java.lang.Integer[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v28, resolved type: java.lang.Integer[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v29, resolved type: java.lang.Integer[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v30, resolved type: java.lang.Integer[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v31, resolved type: java.lang.Integer[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v32, resolved type: java.lang.Integer[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v33, resolved type: java.lang.Integer[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v34, resolved type: java.lang.Integer[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v35, resolved type: java.lang.Integer[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v36, resolved type: java.lang.Integer[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v37, resolved type: java.lang.Integer[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v38, resolved type: java.lang.Integer[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v40, resolved type: java.lang.Integer[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v41, resolved type: java.lang.Integer[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v42, resolved type: java.lang.Integer[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v43, resolved type: java.lang.Integer[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v44, resolved type: java.lang.Integer[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v45, resolved type: java.lang.Integer[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v46, resolved type: java.lang.Integer[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v47, resolved type: java.lang.Integer[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v48, resolved type: java.lang.Integer[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v49, resolved type: java.lang.Integer[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v50, resolved type: java.lang.Integer[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v51, resolved type: java.lang.Integer[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v52, resolved type: java.lang.Integer[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v53, resolved type: java.lang.Integer[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v54, resolved type: java.lang.Integer[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v55, resolved type: java.lang.Integer[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v56, resolved type: java.lang.Integer[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v57, resolved type: java.lang.Integer[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v58, resolved type: java.lang.Integer[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v59, resolved type: java.lang.Integer[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v60, resolved type: java.lang.Integer[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v61, resolved type: java.lang.Integer[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v62, resolved type: java.lang.Integer[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v63, resolved type: java.lang.Integer[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v64, resolved type: java.lang.Integer[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v66, resolved type: java.lang.Integer[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v67, resolved type: java.lang.Integer[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v68, resolved type: java.lang.Integer[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v69, resolved type: java.lang.Integer[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v70, resolved type: java.lang.Integer[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v71, resolved type: java.lang.Integer[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v72, resolved type: java.lang.Integer[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v73, resolved type: java.lang.Integer[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v74, resolved type: java.lang.Integer[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v75, resolved type: java.lang.Integer[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v76, resolved type: java.lang.Integer[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v77, resolved type: java.lang.Integer[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v78, resolved type: java.lang.Integer[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v79, resolved type: java.lang.Integer[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v80, resolved type: java.lang.Integer[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v81, resolved type: java.lang.Integer[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v82, resolved type: java.lang.Integer[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v83, resolved type: java.lang.Integer[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v84, resolved type: java.lang.Integer[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v85, resolved type: java.lang.Integer[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v86, resolved type: java.lang.Integer[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v87, resolved type: java.lang.Integer[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v88, resolved type: java.lang.Integer[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v89, resolved type: java.lang.Integer[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v90, resolved type: java.lang.Integer[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v91, resolved type: java.lang.Integer[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v92, resolved type: java.lang.Integer[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v93, resolved type: java.lang.Integer[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v94, resolved type: java.lang.Integer[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v95, resolved type: java.lang.Integer[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v96, resolved type: java.lang.Integer[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v97, resolved type: java.lang.Integer[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v98, resolved type: java.lang.Integer[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v99, resolved type: java.lang.Integer[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v100, resolved type: java.lang.Integer[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v101, resolved type: java.lang.Integer[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v102, resolved type: java.lang.Integer[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v103, resolved type: java.lang.Integer[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v104, resolved type: java.lang.Integer[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v105, resolved type: java.lang.Integer[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v106, resolved type: java.lang.Integer[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v107, resolved type: java.lang.Integer[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v108, resolved type: java.lang.Integer[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v109, resolved type: java.lang.Integer[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v110, resolved type: java.lang.Integer[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v111, resolved type: java.lang.Integer[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v112, resolved type: java.lang.Integer[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v113, resolved type: java.lang.Integer[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v114, resolved type: java.lang.Integer[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v115, resolved type: java.lang.Integer[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v116, resolved type: java.lang.Integer[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v117, resolved type: java.lang.Integer[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v118, resolved type: java.lang.Integer[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v119, resolved type: java.lang.Integer[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v120, resolved type: java.lang.Integer[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v121, resolved type: java.lang.Integer[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v122, resolved type: java.lang.Integer[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v123, resolved type: java.lang.Integer[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v124, resolved type: java.lang.Integer[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v125, resolved type: java.lang.Integer[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v126, resolved type: java.lang.Integer[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v127, resolved type: java.lang.Integer[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v128, resolved type: java.lang.Integer[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v129, resolved type: java.lang.Integer[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v130, resolved type: java.lang.Integer[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v131, resolved type: java.lang.Integer[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v132, resolved type: java.lang.Integer[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v133, resolved type: java.lang.Integer[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v134, resolved type: java.lang.Integer[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v135, resolved type: java.lang.Integer[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v136, resolved type: java.lang.Integer[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v137, resolved type: java.lang.Integer[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v138, resolved type: java.lang.Integer[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v139, resolved type: java.lang.Integer[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v140, resolved type: java.lang.Integer[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v141, resolved type: java.lang.Integer[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v142, resolved type: java.lang.Integer[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v143, resolved type: java.lang.Integer[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v144, resolved type: java.lang.Integer[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v145, resolved type: java.lang.Integer[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v146, resolved type: java.lang.Integer[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v147, resolved type: java.lang.Integer[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v148, resolved type: java.lang.Integer[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v149, resolved type: java.lang.Integer[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v150, resolved type: java.lang.Integer[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v151, resolved type: java.lang.Integer[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v152, resolved type: java.lang.Integer[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v153, resolved type: java.lang.Integer[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v154, resolved type: java.lang.Integer[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v155, resolved type: java.lang.Integer[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v156, resolved type: java.lang.Integer[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v157, resolved type: java.lang.Integer[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v158, resolved type: java.lang.Integer[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v159, resolved type: java.lang.Integer[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v160, resolved type: java.lang.Integer[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v161, resolved type: java.lang.Integer[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v162, resolved type: java.lang.Integer[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v163, resolved type: java.lang.Integer[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v164, resolved type: java.lang.Integer[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v165, resolved type: java.lang.Integer[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v166, resolved type: java.lang.Integer[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v167, resolved type: java.lang.Integer[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v168, resolved type: java.lang.Integer[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v169, resolved type: java.lang.Integer[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v170, resolved type: java.lang.Integer[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v171, resolved type: java.lang.Integer[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v172, resolved type: java.lang.Integer[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v173, resolved type: java.lang.Integer[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v174, resolved type: java.lang.Integer[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v175, resolved type: java.lang.Integer[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v176, resolved type: java.lang.Integer[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v177, resolved type: java.lang.Integer[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v178, resolved type: java.lang.Integer[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v179, resolved type: java.lang.Integer[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v180, resolved type: java.lang.Integer[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v181, resolved type: java.lang.Integer[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v182, resolved type: java.lang.Integer[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v183, resolved type: java.lang.Integer[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v184, resolved type: java.lang.Integer[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v185, resolved type: java.lang.Integer[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v186, resolved type: java.lang.Integer[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v187, resolved type: java.lang.Integer[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v188, resolved type: java.lang.Integer[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v189, resolved type: java.lang.Integer[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v190, resolved type: java.lang.Integer[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v191, resolved type: java.lang.Integer[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v192, resolved type: java.lang.Integer[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v193, resolved type: java.lang.Integer[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v194, resolved type: java.lang.Integer[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v195, resolved type: java.lang.Integer[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v196, resolved type: java.lang.Integer[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v197, resolved type: java.lang.Integer[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v198, resolved type: java.lang.Integer[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v199, resolved type: java.lang.Integer[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v200, resolved type: java.lang.Integer[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v201, resolved type: java.lang.Integer[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v202, resolved type: java.lang.Integer[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v203, resolved type: java.lang.Integer[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v204, resolved type: java.lang.Integer[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v205, resolved type: java.lang.Integer[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v206, resolved type: java.lang.Integer[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v207, resolved type: java.lang.Integer[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v208, resolved type: java.lang.Integer[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v209, resolved type: java.lang.Integer[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v210, resolved type: java.lang.Integer[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v211, resolved type: java.lang.Integer[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v212, resolved type: java.lang.Integer[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v213, resolved type: java.lang.Integer[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v214, resolved type: java.lang.Integer[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v215, resolved type: java.lang.Integer[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v216, resolved type: java.lang.Integer[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v217, resolved type: java.lang.Integer[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v219, resolved type: java.lang.Integer[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v220, resolved type: java.lang.Integer[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v221, resolved type: java.lang.Integer[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v222, resolved type: java.lang.Integer[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v223, resolved type: java.lang.Integer[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v224, resolved type: java.lang.Integer[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v225, resolved type: java.lang.Integer[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v226, resolved type: java.lang.Integer[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v227, resolved type: java.lang.Integer[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v228, resolved type: java.lang.Integer[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v229, resolved type: java.lang.Integer[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v230, resolved type: java.lang.Integer[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v231, resolved type: java.lang.Integer[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v232, resolved type: java.lang.Integer[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v233, resolved type: java.lang.Integer[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v234, resolved type: java.lang.Integer[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v235, resolved type: java.lang.Integer[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v236, resolved type: java.lang.Integer[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v1, resolved type: java.lang.Integer[]} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static com.google.common.collect.ImmutableListMultimap<java.lang.String, java.lang.Integer> createInitialBitrateCountryGroupAssignment() {
        /*
            com.google.common.collect.ImmutableListMultimap$Builder r0 = com.google.common.collect.ImmutableListMultimap.builder()
            r1 = 5
            java.lang.Integer[] r2 = new java.lang.Integer[r1]
            r3 = 1
            java.lang.Integer r4 = java.lang.Integer.valueOf(r3)
            r5 = 0
            java.lang.Integer r6 = java.lang.Integer.valueOf(r5)
            r2[r5] = r4
            r7 = 2
            java.lang.Integer r8 = java.lang.Integer.valueOf(r7)
            r2[r3] = r8
            r2[r7] = r6
            r9 = 3
            java.lang.Integer r10 = java.lang.Integer.valueOf(r9)
            r2[r9] = r6
            r11 = 4
            java.lang.Integer r12 = java.lang.Integer.valueOf(r11)
            r2[r11] = r8
            java.lang.String r13 = "AD"
            r0.putAll(r13, (V[]) r2)
            java.lang.Integer[] r2 = new java.lang.Integer[r1]
            r2[r5] = r4
            r2[r3] = r12
            r2[r7] = r12
            r2[r9] = r12
            r2[r11] = r4
            java.lang.String r13 = "AE"
            r0.putAll(r13, (V[]) r2)
            java.lang.Integer[] r2 = new java.lang.Integer[r1]
            r2[r5] = r12
            r2[r3] = r12
            r2[r7] = r10
            r2[r9] = r12
            r2[r11] = r8
            java.lang.String r13 = "AF"
            r0.putAll(r13, (V[]) r2)
            java.lang.Integer[] r2 = new java.lang.Integer[r1]
            r2[r5] = r8
            r2[r3] = r8
            r2[r7] = r4
            r2[r9] = r4
            r2[r11] = r8
            java.lang.String r13 = "AG"
            r0.putAll(r13, (V[]) r2)
            java.lang.Integer[] r2 = new java.lang.Integer[r1]
            r2[r5] = r4
            r2[r3] = r8
            r2[r7] = r8
            r2[r9] = r8
            r2[r11] = r8
            java.lang.String r13 = "AI"
            r0.putAll(r13, (V[]) r2)
            java.lang.Integer[] r2 = new java.lang.Integer[r1]
            r2[r5] = r4
            r2[r3] = r4
            r2[r7] = r6
            r2[r9] = r4
            r2[r11] = r8
            java.lang.String r13 = "AL"
            r0.putAll(r13, (V[]) r2)
            java.lang.Integer[] r2 = new java.lang.Integer[r1]
            r2[r5] = r8
            r2[r3] = r8
            r2[r7] = r4
            r2[r9] = r8
            r2[r11] = r8
            java.lang.String r13 = "AM"
            r0.putAll(r13, (V[]) r2)
            java.lang.Integer[] r2 = new java.lang.Integer[r1]
            r2[r5] = r10
            r2[r3] = r12
            r2[r7] = r12
            r2[r9] = r8
            r2[r11] = r8
            java.lang.String r13 = "AO"
            r0.putAll(r13, (V[]) r2)
            java.lang.Integer[] r2 = new java.lang.Integer[r1]
            r2[r5] = r8
            r2[r3] = r12
            r2[r7] = r8
            r2[r9] = r8
            r2[r11] = r8
            java.lang.String r13 = "AR"
            r0.putAll(r13, (V[]) r2)
            java.lang.Integer[] r2 = new java.lang.Integer[r1]
            r2[r5] = r8
            r2[r3] = r8
            r2[r7] = r12
            r2[r9] = r10
            r2[r11] = r8
            java.lang.String r13 = "AS"
            r0.putAll(r13, (V[]) r2)
            java.lang.Integer[] r2 = new java.lang.Integer[r1]
            r2[r5] = r6
            r2[r3] = r10
            r2[r7] = r6
            r2[r9] = r6
            r2[r11] = r8
            java.lang.String r13 = "AT"
            r0.putAll(r13, (V[]) r2)
            java.lang.Integer[] r2 = new java.lang.Integer[r1]
            r2[r5] = r6
            r2[r3] = r8
            r2[r7] = r6
            r2[r9] = r4
            r2[r11] = r4
            java.lang.String r13 = "AU"
            r0.putAll(r13, (V[]) r2)
            java.lang.Integer[] r2 = new java.lang.Integer[r1]
            r2[r5] = r4
            r2[r3] = r8
            r2[r7] = r6
            r2[r9] = r12
            r2[r11] = r8
            java.lang.String r13 = "AW"
            r0.putAll(r13, (V[]) r2)
            java.lang.Integer[] r2 = new java.lang.Integer[r1]
            r2[r5] = r6
            r2[r3] = r8
            r2[r7] = r8
            r2[r9] = r8
            r2[r11] = r8
            java.lang.String r13 = "AX"
            r0.putAll(r13, (V[]) r2)
            java.lang.Integer[] r2 = new java.lang.Integer[r1]
            r2[r5] = r10
            r2[r3] = r10
            r2[r7] = r10
            r2[r9] = r12
            r2[r11] = r8
            java.lang.String r13 = "AZ"
            r0.putAll(r13, (V[]) r2)
            java.lang.Integer[] r2 = new java.lang.Integer[r1]
            r2[r5] = r4
            r2[r3] = r4
            r2[r7] = r6
            r2[r9] = r4
            r2[r11] = r8
            java.lang.String r13 = "BA"
            r0.putAll(r13, (V[]) r2)
            java.lang.Integer[] r2 = new java.lang.Integer[r1]
            r2[r5] = r6
            r2[r3] = r8
            r2[r7] = r6
            r2[r9] = r6
            r2[r11] = r8
            java.lang.String r13 = "BB"
            r0.putAll(r13, (V[]) r2)
            java.lang.Integer[] r2 = new java.lang.Integer[r1]
            r2[r5] = r8
            r2[r3] = r6
            r2[r7] = r10
            r2[r9] = r10
            r2[r11] = r8
            java.lang.String r13 = "BD"
            r0.putAll(r13, (V[]) r2)
            java.lang.Integer[] r2 = new java.lang.Integer[r1]
            r2[r5] = r6
            r2[r3] = r4
            r2[r7] = r8
            r2[r9] = r10
            r2[r11] = r8
            java.lang.String r13 = "BE"
            r0.putAll(r13, (V[]) r2)
            java.lang.Integer[] r2 = new java.lang.Integer[r1]
            r2[r5] = r12
            r2[r3] = r12
            r2[r7] = r12
            r2[r9] = r8
            r2[r11] = r8
            java.lang.String r13 = "BF"
            r0.putAll(r13, (V[]) r2)
            java.lang.Integer[] r2 = new java.lang.Integer[r1]
            r2[r5] = r6
            r2[r3] = r4
            r2[r7] = r6
            r2[r9] = r6
            r2[r11] = r8
            java.lang.String r13 = "BG"
            r0.putAll(r13, (V[]) r2)
            java.lang.Integer[] r2 = new java.lang.Integer[r1]
            r2[r5] = r4
            r2[r3] = r6
            r2[r7] = r8
            r2[r9] = r12
            r2[r11] = r8
            java.lang.String r13 = "BH"
            r0.putAll(r13, (V[]) r2)
            java.lang.Integer[] r2 = new java.lang.Integer[r1]
            r2[r5] = r12
            r2[r3] = r12
            r2[r7] = r12
            r2[r9] = r12
            r2[r11] = r8
            java.lang.String r13 = "BI"
            r0.putAll(r13, (V[]) r2)
            java.lang.Integer[] r2 = new java.lang.Integer[r1]
            r2[r5] = r12
            r2[r3] = r12
            r2[r7] = r10
            r2[r9] = r12
            r2[r11] = r8
            java.lang.String r13 = "BJ"
            r0.putAll(r13, (V[]) r2)
            java.lang.Integer[] r2 = new java.lang.Integer[r1]
            r2[r5] = r4
            r2[r3] = r8
            r2[r7] = r8
            r2[r9] = r8
            r2[r11] = r8
            java.lang.String r13 = "BL"
            r0.putAll(r13, (V[]) r2)
            java.lang.Integer[] r2 = new java.lang.Integer[r1]
            r2[r5] = r4
            r2[r3] = r8
            r2[r7] = r6
            r2[r9] = r6
            r2[r11] = r8
            java.lang.String r13 = "BM"
            r0.putAll(r13, (V[]) r2)
            java.lang.Integer[] r2 = new java.lang.Integer[r1]
            r2[r5] = r12
            r2[r3] = r6
            r2[r7] = r4
            r2[r9] = r4
            r2[r11] = r8
            java.lang.String r13 = "BN"
            r0.putAll(r13, (V[]) r2)
            java.lang.Integer[] r2 = new java.lang.Integer[r1]
            r2[r5] = r8
            r2[r3] = r10
            r2[r7] = r10
            r2[r9] = r8
            r2[r11] = r8
            java.lang.String r13 = "BO"
            r0.putAll(r13, (V[]) r2)
            java.lang.Integer[] r2 = new java.lang.Integer[r1]
            r2[r5] = r4
            r2[r3] = r8
            r2[r7] = r4
            r2[r9] = r8
            r2[r11] = r8
            java.lang.String r13 = "BQ"
            r0.putAll(r13, (V[]) r2)
            java.lang.Integer[] r2 = new java.lang.Integer[r1]
            r2[r5] = r8
            r2[r3] = r12
            r2[r7] = r8
            r2[r9] = r4
            r2[r11] = r8
            java.lang.String r13 = "BR"
            r0.putAll(r13, (V[]) r2)
            java.lang.Integer[] r2 = new java.lang.Integer[r1]
            r2[r5] = r10
            r2[r3] = r8
            r2[r7] = r8
            r2[r9] = r10
            r2[r11] = r8
            java.lang.String r13 = "BS"
            r0.putAll(r13, (V[]) r2)
            java.lang.Integer[] r2 = new java.lang.Integer[r1]
            r2[r5] = r10
            r2[r3] = r6
            r2[r7] = r10
            r2[r9] = r8
            r2[r11] = r8
            java.lang.String r13 = "BT"
            r0.putAll(r13, (V[]) r2)
            java.lang.Integer[] r2 = new java.lang.Integer[r1]
            r2[r5] = r10
            r2[r3] = r12
            r2[r7] = r8
            r2[r9] = r8
            r2[r11] = r8
            java.lang.String r13 = "BW"
            r0.putAll(r13, (V[]) r2)
            java.lang.Integer[] r2 = new java.lang.Integer[r1]
            r2[r5] = r4
            r2[r3] = r6
            r2[r7] = r8
            r2[r9] = r4
            r2[r11] = r8
            java.lang.String r13 = "BY"
            r0.putAll(r13, (V[]) r2)
            java.lang.Integer[] r2 = new java.lang.Integer[r1]
            r2[r5] = r8
            r2[r3] = r8
            r2[r7] = r8
            r2[r9] = r4
            r2[r11] = r8
            java.lang.String r13 = "BZ"
            r0.putAll(r13, (V[]) r2)
            java.lang.Integer[] r2 = new java.lang.Integer[r1]
            r2[r5] = r6
            r2[r3] = r10
            r2[r7] = r4
            r2[r9] = r8
            r2[r11] = r10
            java.lang.String r13 = "CA"
            r0.putAll(r13, (V[]) r2)
            java.lang.Integer[] r2 = new java.lang.Integer[r1]
            r2[r5] = r12
            r2[r3] = r10
            r2[r7] = r8
            r2[r9] = r8
            r2[r11] = r8
            java.lang.String r13 = "CD"
            r0.putAll(r13, (V[]) r2)
            java.lang.Integer[] r2 = new java.lang.Integer[r1]
            r2[r5] = r12
            r2[r3] = r8
            r2[r7] = r8
            r2[r9] = r8
            r2[r11] = r8
            java.lang.String r13 = "CF"
            r0.putAll(r13, (V[]) r2)
            java.lang.Integer[] r2 = new java.lang.Integer[r1]
            r2[r5] = r10
            r2[r3] = r12
            r2[r7] = r4
            r2[r9] = r4
            r2[r11] = r8
            java.lang.String r13 = "CG"
            r0.putAll(r13, (V[]) r2)
            java.lang.Integer[] r2 = new java.lang.Integer[r1]
            r2[r5] = r6
            r2[r3] = r4
            r2[r7] = r6
            r2[r9] = r6
            r2[r11] = r6
            java.lang.String r13 = "CH"
            r0.putAll(r13, (V[]) r2)
            java.lang.Integer[] r2 = new java.lang.Integer[r1]
            r2[r5] = r10
            r2[r3] = r10
            r2[r7] = r10
            r2[r9] = r10
            r2[r11] = r8
            java.lang.String r13 = "CI"
            r0.putAll(r13, (V[]) r2)
            java.lang.Integer[] r2 = new java.lang.Integer[r1]
            r2[r5] = r10
            r2[r3] = r8
            r2[r7] = r4
            r2[r9] = r6
            r2[r11] = r8
            java.lang.String r13 = "CK"
            r0.putAll(r13, (V[]) r2)
            java.lang.Integer[] r2 = new java.lang.Integer[r1]
            r2[r5] = r4
            r2[r3] = r4
            r2[r7] = r8
            r2[r9] = r10
            r2[r11] = r8
            java.lang.String r13 = "CL"
            r0.putAll(r13, (V[]) r2)
            java.lang.Integer[] r2 = new java.lang.Integer[r1]
            r2[r5] = r10
            r2[r3] = r12
            r2[r7] = r10
            r2[r9] = r8
            r2[r11] = r8
            java.lang.String r13 = "CM"
            r0.putAll(r13, (V[]) r2)
            java.lang.Integer[] r2 = new java.lang.Integer[r1]
            r2[r5] = r8
            r2[r3] = r8
            r2[r7] = r8
            r2[r9] = r4
            r2[r11] = r10
            java.lang.String r13 = "CN"
            r0.putAll(r13, (V[]) r2)
            java.lang.Integer[] r2 = new java.lang.Integer[r1]
            r2[r5] = r8
            r2[r3] = r12
            r2[r7] = r10
            r2[r9] = r8
            r2[r11] = r8
            java.lang.String r13 = "CO"
            r0.putAll(r13, (V[]) r2)
            java.lang.Integer[] r2 = new java.lang.Integer[r1]
            r2[r5] = r8
            r2[r3] = r10
            r2[r7] = r12
            r2[r9] = r12
            r2[r11] = r8
            java.lang.String r13 = "CR"
            r0.putAll(r13, (V[]) r2)
            java.lang.Integer[] r2 = new java.lang.Integer[r1]
            r2[r5] = r12
            r2[r3] = r12
            r2[r7] = r8
            r2[r9] = r4
            r2[r11] = r8
            java.lang.String r13 = "CU"
            r0.putAll(r13, (V[]) r2)
            java.lang.Integer[] r2 = new java.lang.Integer[r1]
            r2[r5] = r8
            r2[r3] = r10
            r2[r7] = r10
            r2[r9] = r10
            r2[r11] = r8
            java.lang.String r13 = "CV"
            r0.putAll(r13, (V[]) r2)
            java.lang.Integer[] r2 = new java.lang.Integer[r1]
            r2[r5] = r4
            r2[r3] = r8
            r2[r7] = r6
            r2[r9] = r6
            r2[r11] = r8
            java.lang.String r13 = "CW"
            r0.putAll(r13, (V[]) r2)
            java.lang.Integer[] r2 = new java.lang.Integer[r1]
            r2[r5] = r4
            r2[r3] = r8
            r2[r7] = r6
            r2[r9] = r6
            r2[r11] = r8
            java.lang.String r13 = "CY"
            r0.putAll(r13, (V[]) r2)
            java.lang.Integer[] r2 = new java.lang.Integer[r1]
            r2[r5] = r6
            r2[r3] = r4
            r2[r7] = r6
            r2[r9] = r6
            r2[r11] = r8
            java.lang.String r13 = "CZ"
            r0.putAll(r13, (V[]) r2)
            java.lang.Integer[] r2 = new java.lang.Integer[r1]
            r2[r5] = r6
            r2[r3] = r4
            r2[r7] = r4
            r2[r9] = r8
            r2[r11] = r6
            java.lang.String r13 = "DE"
            r0.putAll(r13, (V[]) r2)
            java.lang.Integer[] r2 = new java.lang.Integer[r1]
            r2[r5] = r12
            r2[r3] = r4
            r2[r7] = r12
            r2[r9] = r12
            r2[r11] = r8
            java.lang.String r13 = "DJ"
            r0.putAll(r13, (V[]) r2)
            java.lang.Integer[] r2 = new java.lang.Integer[r1]
            r2[r5] = r6
            r2[r3] = r6
            r2[r7] = r4
            r2[r9] = r6
            r2[r11] = r8
            java.lang.String r13 = "DK"
            r0.putAll(r13, (V[]) r2)
            java.lang.Integer[] r2 = new java.lang.Integer[r1]
            r2[r5] = r4
            r2[r3] = r8
            r2[r7] = r8
            r2[r9] = r8
            r2[r11] = r8
            java.lang.String r13 = "DM"
            r0.putAll(r13, (V[]) r2)
            java.lang.Integer[] r2 = new java.lang.Integer[r1]
            r2[r5] = r10
            r2[r3] = r12
            r2[r7] = r12
            r2[r9] = r12
            r2[r11] = r8
            java.lang.String r13 = "DO"
            r0.putAll(r13, (V[]) r2)
            java.lang.Integer[] r2 = new java.lang.Integer[r1]
            r2[r5] = r10
            r2[r3] = r8
            r2[r7] = r12
            r2[r9] = r12
            r2[r11] = r8
            java.lang.String r13 = "DZ"
            r0.putAll(r13, (V[]) r2)
            java.lang.Integer[] r2 = new java.lang.Integer[r1]
            r2[r5] = r8
            r2[r3] = r12
            r2[r7] = r10
            r2[r9] = r8
            r2[r11] = r8
            java.lang.String r13 = "EC"
            r0.putAll(r13, (V[]) r2)
            java.lang.Integer[] r2 = new java.lang.Integer[r1]
            r2[r5] = r6
            r2[r3] = r6
            r2[r7] = r6
            r2[r9] = r6
            r2[r11] = r8
            java.lang.String r13 = "EE"
            r0.putAll(r13, (V[]) r2)
            java.lang.Integer[] r2 = new java.lang.Integer[r1]
            r2[r5] = r10
            r2[r3] = r12
            r2[r7] = r8
            r2[r9] = r4
            r2[r11] = r8
            java.lang.String r13 = "EG"
            r0.putAll(r13, (V[]) r2)
            java.lang.Integer[] r2 = new java.lang.Integer[r1]
            r2[r5] = r8
            r2[r3] = r8
            r2[r7] = r8
            r2[r9] = r8
            r2[r11] = r8
            java.lang.String r13 = "EH"
            r0.putAll(r13, (V[]) r2)
            java.lang.Integer[] r2 = new java.lang.Integer[r1]
            r2[r5] = r12
            r2[r3] = r8
            r2[r7] = r8
            r2[r9] = r8
            r2[r11] = r8
            java.lang.String r13 = "ER"
            r0.putAll(r13, (V[]) r2)
            java.lang.Integer[] r2 = new java.lang.Integer[r1]
            r2[r5] = r6
            r2[r3] = r4
            r2[r7] = r8
            r2[r9] = r4
            r2[r11] = r8
            java.lang.String r13 = "ES"
            r0.putAll(r13, (V[]) r2)
            java.lang.Integer[] r2 = new java.lang.Integer[r1]
            r2[r5] = r12
            r2[r3] = r12
            r2[r7] = r12
            r2[r9] = r4
            r2[r11] = r8
            java.lang.String r13 = "ET"
            r0.putAll(r13, (V[]) r2)
            java.lang.Integer[] r2 = new java.lang.Integer[r1]
            r2[r5] = r6
            r2[r3] = r6
            r2[r7] = r4
            r2[r9] = r6
            r2[r11] = r6
            java.lang.String r13 = "FI"
            r0.putAll(r13, (V[]) r2)
            java.lang.Integer[] r2 = new java.lang.Integer[r1]
            r2[r5] = r10
            r2[r3] = r6
            r2[r7] = r10
            r2[r9] = r10
            r2[r11] = r8
            java.lang.String r13 = "FJ"
            r0.putAll(r13, (V[]) r2)
            java.lang.Integer[] r2 = new java.lang.Integer[r1]
            r2[r5] = r8
            r2[r3] = r8
            r2[r7] = r8
            r2[r9] = r8
            r2[r11] = r8
            java.lang.String r13 = "FK"
            r0.putAll(r13, (V[]) r2)
            java.lang.Integer[] r2 = new java.lang.Integer[r1]
            r2[r5] = r12
            r2[r3] = r8
            r2[r7] = r12
            r2[r9] = r10
            r2[r11] = r8
            java.lang.String r13 = "FM"
            r0.putAll(r13, (V[]) r2)
            java.lang.Integer[] r2 = new java.lang.Integer[r1]
            r2[r5] = r6
            r2[r3] = r8
            r2[r7] = r6
            r2[r9] = r6
            r2[r11] = r8
            java.lang.String r13 = "FO"
            r0.putAll(r13, (V[]) r2)
            java.lang.Integer[] r2 = new java.lang.Integer[r1]
            r2[r5] = r4
            r2[r3] = r6
            r2[r7] = r8
            r2[r9] = r4
            r2[r11] = r8
            java.lang.String r13 = "FR"
            r0.putAll(r13, (V[]) r2)
            java.lang.Integer[] r2 = new java.lang.Integer[r1]
            r2[r5] = r10
            r2[r3] = r10
            r2[r7] = r4
            r2[r9] = r6
            r2[r11] = r8
            java.lang.String r13 = "GA"
            r0.putAll(r13, (V[]) r2)
            java.lang.Integer[] r2 = new java.lang.Integer[r1]
            r2[r5] = r6
            r2[r3] = r6
            r2[r7] = r4
            r2[r9] = r8
            r2[r11] = r8
            java.lang.String r13 = "GB"
            r0.putAll(r13, (V[]) r2)
            java.lang.Integer[] r2 = new java.lang.Integer[r1]
            r2[r5] = r4
            r2[r3] = r8
            r2[r7] = r8
            r2[r9] = r8
            r2[r11] = r8
            java.lang.String r13 = "GD"
            r0.putAll(r13, (V[]) r2)
            java.lang.Integer[] r2 = new java.lang.Integer[r1]
            r2[r5] = r4
            r2[r3] = r6
            r2[r7] = r4
            r2[r9] = r10
            r2[r11] = r8
            java.lang.String r13 = "GE"
            r0.putAll(r13, (V[]) r2)
            java.lang.Integer[] r2 = new java.lang.Integer[r1]
            r2[r5] = r8
            r2[r3] = r8
            r2[r7] = r8
            r2[r9] = r12
            r2[r11] = r8
            java.lang.String r13 = "GF"
            r0.putAll(r13, (V[]) r2)
            java.lang.Integer[] r2 = new java.lang.Integer[r1]
            r2[r5] = r6
            r2[r3] = r8
            r2[r7] = r6
            r2[r9] = r6
            r2[r11] = r8
            java.lang.String r13 = "GG"
            r0.putAll(r13, (V[]) r2)
            java.lang.Integer[] r2 = new java.lang.Integer[r1]
            r2[r5] = r10
            r2[r3] = r8
            r2[r7] = r10
            r2[r9] = r8
            r2[r11] = r8
            java.lang.String r13 = "GH"
            r0.putAll(r13, (V[]) r2)
            java.lang.Integer[] r2 = new java.lang.Integer[r1]
            r2[r5] = r6
            r2[r3] = r8
            r2[r7] = r6
            r2[r9] = r6
            r2[r11] = r8
            java.lang.String r13 = "GI"
            r0.putAll(r13, (V[]) r2)
            java.lang.Integer[] r2 = new java.lang.Integer[r1]
            r2[r5] = r4
            r2[r3] = r8
            r2[r7] = r8
            r2[r9] = r4
            r2[r11] = r8
            java.lang.String r13 = "GL"
            r0.putAll(r13, (V[]) r2)
            java.lang.Integer[] r2 = new java.lang.Integer[r1]
            r2[r5] = r12
            r2[r3] = r10
            r2[r7] = r8
            r2[r9] = r12
            r2[r11] = r8
            java.lang.String r13 = "GM"
            r0.putAll(r13, (V[]) r2)
            java.lang.Integer[] r2 = new java.lang.Integer[r1]
            r2[r5] = r12
            r2[r3] = r10
            r2[r7] = r12
            r2[r9] = r8
            r2[r11] = r8
            java.lang.String r13 = "GN"
            r0.putAll(r13, (V[]) r2)
            java.lang.Integer[] r2 = new java.lang.Integer[r1]
            r2[r5] = r8
            r2[r3] = r8
            r2[r7] = r10
            r2[r9] = r12
            r2[r11] = r8
            java.lang.String r13 = "GP"
            r0.putAll(r13, (V[]) r2)
            java.lang.Integer[] r2 = new java.lang.Integer[r1]
            r2[r5] = r12
            r2[r3] = r8
            r2[r7] = r10
            r2[r9] = r12
            r2[r11] = r8
            java.lang.String r13 = "GQ"
            r0.putAll(r13, (V[]) r2)
            java.lang.Integer[] r2 = new java.lang.Integer[r1]
            r2[r5] = r4
            r2[r3] = r4
            r2[r7] = r6
            r2[r9] = r4
            r2[r11] = r8
            java.lang.String r13 = "GR"
            r0.putAll(r13, (V[]) r2)
            java.lang.Integer[] r2 = new java.lang.Integer[r1]
            r2[r5] = r10
            r2[r3] = r8
            r2[r7] = r10
            r2[r9] = r8
            r2[r11] = r8
            java.lang.String r13 = "GT"
            r0.putAll(r13, (V[]) r2)
            java.lang.Integer[] r2 = new java.lang.Integer[r1]
            r2[r5] = r4
            r2[r3] = r8
            r2[r7] = r12
            r2[r9] = r12
            r2[r11] = r8
            java.lang.String r13 = "GU"
            r0.putAll(r13, (V[]) r2)
            java.lang.Integer[] r2 = new java.lang.Integer[r1]
            r2[r5] = r10
            r2[r3] = r12
            r2[r7] = r12
            r2[r9] = r10
            r2[r11] = r8
            java.lang.String r13 = "GW"
            r0.putAll(r13, (V[]) r2)
            java.lang.Integer[] r2 = new java.lang.Integer[r1]
            r2[r5] = r10
            r2[r3] = r10
            r2[r7] = r4
            r2[r9] = r6
            r2[r11] = r8
            java.lang.String r13 = "GY"
            r0.putAll(r13, (V[]) r2)
            java.lang.Integer[] r2 = new java.lang.Integer[r1]
            r2[r5] = r6
            r2[r3] = r8
            r2[r7] = r10
            r2[r9] = r12
            r2[r11] = r8
            java.lang.String r13 = "HK"
            r0.putAll(r13, (V[]) r2)
            java.lang.Integer[] r2 = new java.lang.Integer[r1]
            r2[r5] = r10
            r2[r3] = r6
            r2[r7] = r10
            r2[r9] = r10
            r2[r11] = r8
            java.lang.String r13 = "HN"
            r0.putAll(r13, (V[]) r2)
            java.lang.Integer[] r2 = new java.lang.Integer[r1]
            r2[r5] = r4
            r2[r3] = r4
            r2[r7] = r6
            r2[r9] = r4
            r2[r11] = r8
            java.lang.String r13 = "HR"
            r0.putAll(r13, (V[]) r2)
            java.lang.Integer[] r2 = new java.lang.Integer[r1]
            r2[r5] = r12
            r2[r3] = r10
            r2[r7] = r12
            r2[r9] = r12
            r2[r11] = r8
            java.lang.String r13 = "HT"
            r0.putAll(r13, (V[]) r2)
            java.lang.Integer[] r2 = new java.lang.Integer[r1]
            r2[r5] = r6
            r2[r3] = r4
            r2[r7] = r6
            r2[r9] = r6
            r2[r11] = r8
            java.lang.String r13 = "HU"
            r0.putAll(r13, (V[]) r2)
            java.lang.Integer[] r2 = new java.lang.Integer[r1]
            r2[r5] = r10
            r2[r3] = r8
            r2[r7] = r8
            r2[r9] = r10
            r2[r11] = r8
            java.lang.String r13 = "ID"
            r0.putAll(r13, (V[]) r2)
            java.lang.Integer[] r2 = new java.lang.Integer[r1]
            r2[r5] = r6
            r2[r3] = r6
            r2[r7] = r4
            r2[r9] = r4
            r2[r11] = r8
            java.lang.String r13 = "IE"
            r0.putAll(r13, (V[]) r2)
            java.lang.Integer[] r2 = new java.lang.Integer[r1]
            r2[r5] = r4
            r2[r3] = r6
            r2[r7] = r8
            r2[r9] = r10
            r2[r11] = r8
            java.lang.String r13 = "IL"
            r0.putAll(r13, (V[]) r2)
            java.lang.Integer[] r2 = new java.lang.Integer[r1]
            r2[r5] = r6
            r2[r3] = r8
            r2[r7] = r6
            r2[r9] = r4
            r2[r11] = r8
            java.lang.String r13 = "IM"
            r0.putAll(r13, (V[]) r2)
            java.lang.Integer[] r2 = new java.lang.Integer[r1]
            r2[r5] = r8
            r2[r3] = r4
            r2[r7] = r10
            r2[r9] = r10
            r2[r11] = r8
            java.lang.String r13 = "IN"
            r0.putAll(r13, (V[]) r2)
            java.lang.Integer[] r2 = new java.lang.Integer[r1]
            r2[r5] = r12
            r2[r3] = r8
            r2[r7] = r8
            r2[r9] = r12
            r2[r11] = r8
            java.lang.String r13 = "IO"
            r0.putAll(r13, (V[]) r2)
            java.lang.Integer[] r2 = new java.lang.Integer[r1]
            r2[r5] = r10
            r2[r3] = r8
            r2[r7] = r12
            r2[r9] = r10
            r2[r11] = r8
            java.lang.String r13 = "IQ"
            r0.putAll(r13, (V[]) r2)
            java.lang.Integer[] r2 = new java.lang.Integer[r1]
            r2[r5] = r12
            r2[r3] = r8
            r2[r7] = r10
            r2[r9] = r12
            r2[r11] = r8
            java.lang.String r13 = "IR"
            r0.putAll(r13, (V[]) r2)
            java.lang.Integer[] r2 = new java.lang.Integer[r1]
            r2[r5] = r6
            r2[r3] = r8
            r2[r7] = r6
            r2[r9] = r6
            r2[r11] = r8
            java.lang.String r13 = "IS"
            r0.putAll(r13, (V[]) r2)
            java.lang.Integer[] r2 = new java.lang.Integer[r1]
            r2[r5] = r6
            r2[r3] = r6
            r2[r7] = r4
            r2[r9] = r4
            r2[r11] = r8
            java.lang.String r13 = "IT"
            r0.putAll(r13, (V[]) r2)
            java.lang.Integer[] r2 = new java.lang.Integer[r1]
            r2[r5] = r8
            r2[r3] = r8
            r2[r7] = r6
            r2[r9] = r8
            r2[r11] = r8
            java.lang.String r13 = "JE"
            r0.putAll(r13, (V[]) r2)
            java.lang.Integer[] r2 = new java.lang.Integer[r1]
            r2[r5] = r10
            r2[r3] = r10
            r2[r7] = r12
            r2[r9] = r12
            r2[r11] = r8
            java.lang.String r13 = "JM"
            r0.putAll(r13, (V[]) r2)
            java.lang.Integer[] r2 = new java.lang.Integer[r1]
            r2[r5] = r4
            r2[r3] = r8
            r2[r7] = r4
            r2[r9] = r4
            r2[r11] = r8
            java.lang.String r13 = "JO"
            r0.putAll(r13, (V[]) r2)
            java.lang.Integer[] r2 = new java.lang.Integer[r1]
            r2[r5] = r6
            r2[r3] = r8
            r2[r7] = r6
            r2[r9] = r4
            r2[r11] = r10
            java.lang.String r13 = "JP"
            r0.putAll(r13, (V[]) r2)
            java.lang.Integer[] r2 = new java.lang.Integer[r1]
            r2[r5] = r10
            r2[r3] = r12
            r2[r7] = r8
            r2[r9] = r8
            r2[r11] = r8
            java.lang.String r13 = "KE"
            r0.putAll(r13, (V[]) r2)
            java.lang.Integer[] r2 = new java.lang.Integer[r1]
            r2[r5] = r4
            r2[r3] = r6
            r2[r7] = r8
            r2[r9] = r8
            r2[r11] = r8
            java.lang.String r13 = "KG"
            r0.putAll(r13, (V[]) r2)
            java.lang.Integer[] r2 = new java.lang.Integer[r1]
            r2[r5] = r8
            r2[r3] = r6
            r2[r7] = r12
            r2[r9] = r10
            r2[r11] = r8
            java.lang.String r13 = "KH"
            r0.putAll(r13, (V[]) r2)
            java.lang.Integer[] r2 = new java.lang.Integer[r1]
            r2[r5] = r12
            r2[r3] = r8
            r2[r7] = r10
            r2[r9] = r4
            r2[r11] = r8
            java.lang.String r13 = "KI"
            r0.putAll(r13, (V[]) r2)
            java.lang.Integer[] r2 = new java.lang.Integer[r1]
            r2[r5] = r12
            r2[r3] = r8
            r2[r7] = r8
            r2[r9] = r10
            r2[r11] = r8
            java.lang.String r13 = "KM"
            r0.putAll(r13, (V[]) r2)
            java.lang.Integer[] r2 = new java.lang.Integer[r1]
            r2[r5] = r4
            r2[r3] = r8
            r2[r7] = r8
            r2[r9] = r8
            r2[r11] = r8
            java.lang.String r13 = "KN"
            r0.putAll(r13, (V[]) r2)
            java.lang.Integer[] r2 = new java.lang.Integer[r1]
            r2[r5] = r12
            r2[r3] = r8
            r2[r7] = r8
            r2[r9] = r8
            r2[r11] = r8
            java.lang.String r13 = "KP"
            r0.putAll(r13, (V[]) r2)
            java.lang.Integer[] r2 = new java.lang.Integer[r1]
            r2[r5] = r6
            r2[r3] = r8
            r2[r7] = r4
            r2[r9] = r4
            r2[r11] = r4
            java.lang.String r13 = "KR"
            r0.putAll(r13, (V[]) r2)
            java.lang.Integer[] r2 = new java.lang.Integer[r1]
            r2[r5] = r8
            r2[r3] = r10
            r2[r7] = r4
            r2[r9] = r4
            r2[r11] = r4
            java.lang.String r13 = "KW"
            r0.putAll(r13, (V[]) r2)
            java.lang.Integer[] r2 = new java.lang.Integer[r1]
            r2[r5] = r4
            r2[r3] = r8
            r2[r7] = r6
            r2[r9] = r6
            r2[r11] = r8
            java.lang.String r13 = "KY"
            r0.putAll(r13, (V[]) r2)
            java.lang.Integer[] r2 = new java.lang.Integer[r1]
            r2[r5] = r4
            r2[r3] = r8
            r2[r7] = r8
            r2[r9] = r10
            r2[r11] = r8
            java.lang.String r13 = "KZ"
            r0.putAll(r13, (V[]) r2)
            java.lang.Integer[] r2 = new java.lang.Integer[r1]
            r2[r5] = r8
            r2[r3] = r8
            r2[r7] = r4
            r2[r9] = r4
            r2[r11] = r8
            java.lang.String r13 = "LA"
            r0.putAll(r13, (V[]) r2)
            java.lang.Integer[] r2 = new java.lang.Integer[r1]
            r2[r5] = r10
            r2[r3] = r8
            r2[r7] = r6
            r2[r9] = r6
            r2[r11] = r8
            java.lang.String r13 = "LB"
            r0.putAll(r13, (V[]) r2)
            java.lang.Integer[] r2 = new java.lang.Integer[r1]
            r2[r5] = r4
            r2[r3] = r4
            r2[r7] = r6
            r2[r9] = r6
            r2[r11] = r8
            java.lang.String r13 = "LC"
            r0.putAll(r13, (V[]) r2)
            java.lang.Integer[] r2 = new java.lang.Integer[r1]
            r2[r5] = r6
            r2[r3] = r8
            r2[r7] = r8
            r2[r9] = r8
            r2[r11] = r8
            java.lang.String r13 = "LI"
            r0.putAll(r13, (V[]) r2)
            java.lang.Integer[] r2 = new java.lang.Integer[r1]
            r2[r5] = r8
            r2[r3] = r6
            r2[r7] = r8
            r2[r9] = r10
            r2[r11] = r8
            java.lang.String r13 = "LK"
            r0.putAll(r13, (V[]) r2)
            java.lang.Integer[] r2 = new java.lang.Integer[r1]
            r2[r5] = r10
            r2[r3] = r12
            r2[r7] = r10
            r2[r9] = r8
            r2[r11] = r8
            java.lang.String r13 = "LR"
            r0.putAll(r13, (V[]) r2)
            java.lang.Integer[] r2 = new java.lang.Integer[r1]
            r2[r5] = r10
            r2[r3] = r10
            r2[r7] = r8
            r2[r9] = r10
            r2[r11] = r8
            java.lang.String r13 = "LS"
            r0.putAll(r13, (V[]) r2)
            java.lang.Integer[] r2 = new java.lang.Integer[r1]
            r2[r5] = r6
            r2[r3] = r6
            r2[r7] = r6
            r2[r9] = r6
            r2[r11] = r8
            java.lang.String r13 = "LT"
            r0.putAll(r13, (V[]) r2)
            java.lang.Integer[] r2 = new java.lang.Integer[r1]
            r2[r5] = r6
            r2[r3] = r6
            r2[r7] = r6
            r2[r9] = r6
            r2[r11] = r8
            java.lang.String r13 = "LU"
            r0.putAll(r13, (V[]) r2)
            java.lang.Integer[] r2 = new java.lang.Integer[r1]
            r2[r5] = r6
            r2[r3] = r6
            r2[r7] = r6
            r2[r9] = r6
            r2[r11] = r8
            java.lang.String r13 = "LV"
            r0.putAll(r13, (V[]) r2)
            java.lang.Integer[] r2 = new java.lang.Integer[r1]
            r2[r5] = r12
            r2[r3] = r8
            r2[r7] = r12
            r2[r9] = r10
            r2[r11] = r8
            java.lang.String r13 = "LY"
            r0.putAll(r13, (V[]) r2)
            java.lang.Integer[] r2 = new java.lang.Integer[r1]
            r2[r5] = r8
            r2[r3] = r4
            r2[r7] = r8
            r2[r9] = r4
            r2[r11] = r8
            java.lang.String r13 = "MA"
            r0.putAll(r13, (V[]) r2)
            java.lang.Integer[] r2 = new java.lang.Integer[r1]
            r2[r5] = r6
            r2[r3] = r8
            r2[r7] = r8
            r2[r9] = r8
            r2[r11] = r8
            java.lang.String r13 = "MC"
            r0.putAll(r13, (V[]) r2)
            java.lang.Integer[] r2 = new java.lang.Integer[r1]
            r2[r5] = r4
            r2[r3] = r8
            r2[r7] = r6
            r2[r9] = r6
            r2[r11] = r8
            java.lang.String r13 = "MD"
            r0.putAll(r13, (V[]) r2)
            java.lang.Integer[] r2 = new java.lang.Integer[r1]
            r2[r5] = r4
            r2[r3] = r8
            r2[r7] = r4
            r2[r9] = r8
            r2[r11] = r8
            java.lang.String r13 = "ME"
            r0.putAll(r13, (V[]) r2)
            java.lang.Integer[] r2 = new java.lang.Integer[r1]
            r2[r5] = r4
            r2[r3] = r8
            r2[r7] = r4
            r2[r9] = r6
            r2[r11] = r8
            java.lang.String r13 = "MF"
            r0.putAll(r13, (V[]) r2)
            java.lang.Integer[] r2 = new java.lang.Integer[r1]
            r2[r5] = r10
            r2[r3] = r12
            r2[r7] = r10
            r2[r9] = r10
            r2[r11] = r8
            java.lang.String r13 = "MG"
            r0.putAll(r13, (V[]) r2)
            java.lang.Integer[] r2 = new java.lang.Integer[r1]
            r2[r5] = r12
            r2[r3] = r8
            r2[r7] = r8
            r2[r9] = r12
            r2[r11] = r8
            java.lang.String r13 = "MH"
            r0.putAll(r13, (V[]) r2)
            java.lang.Integer[] r2 = new java.lang.Integer[r1]
            r2[r5] = r4
            r2[r3] = r6
            r2[r7] = r6
            r2[r9] = r6
            r2[r11] = r8
            java.lang.String r13 = "MK"
            r0.putAll(r13, (V[]) r2)
            java.lang.Integer[] r2 = new java.lang.Integer[r1]
            r2[r5] = r12
            r2[r3] = r12
            r2[r7] = r4
            r2[r9] = r4
            r2[r11] = r8
            java.lang.String r13 = "ML"
            r0.putAll(r13, (V[]) r2)
            java.lang.Integer[] r2 = new java.lang.Integer[r1]
            r2[r5] = r8
            r2[r3] = r10
            r2[r7] = r8
            r2[r9] = r8
            r2[r11] = r8
            java.lang.String r13 = "MM"
            r0.putAll(r13, (V[]) r2)
            java.lang.Integer[] r2 = new java.lang.Integer[r1]
            r2[r5] = r8
            r2[r3] = r12
            r2[r7] = r4
            r2[r9] = r4
            r2[r11] = r8
            java.lang.String r13 = "MN"
            r0.putAll(r13, (V[]) r2)
            java.lang.Integer[] r2 = new java.lang.Integer[r1]
            r2[r5] = r6
            r2[r3] = r8
            r2[r7] = r12
            r2[r9] = r12
            r2[r11] = r8
            java.lang.String r13 = "MO"
            r0.putAll(r13, (V[]) r2)
            java.lang.Integer[] r2 = new java.lang.Integer[r1]
            r2[r5] = r6
            r2[r3] = r8
            r2[r7] = r8
            r2[r9] = r8
            r2[r11] = r8
            java.lang.String r13 = "MP"
            r0.putAll(r13, (V[]) r2)
            java.lang.Integer[] r2 = new java.lang.Integer[r1]
            r2[r5] = r8
            r2[r3] = r8
            r2[r7] = r8
            r2[r9] = r10
            r2[r11] = r8
            java.lang.String r13 = "MQ"
            r0.putAll(r13, (V[]) r2)
            java.lang.Integer[] r2 = new java.lang.Integer[r1]
            r2[r5] = r10
            r2[r3] = r6
            r2[r7] = r12
            r2[r9] = r8
            r2[r11] = r8
            java.lang.String r13 = "MR"
            r0.putAll(r13, (V[]) r2)
            java.lang.Integer[] r2 = new java.lang.Integer[r1]
            r2[r5] = r4
            r2[r3] = r8
            r2[r7] = r8
            r2[r9] = r8
            r2[r11] = r8
            java.lang.String r13 = "MS"
            r0.putAll(r13, (V[]) r2)
            java.lang.Integer[] r2 = new java.lang.Integer[r1]
            r2[r5] = r6
            r2[r3] = r8
            r2[r7] = r6
            r2[r9] = r4
            r2[r11] = r8
            java.lang.String r13 = "MT"
            r0.putAll(r13, (V[]) r2)
            java.lang.Integer[] r2 = new java.lang.Integer[r1]
            r2[r5] = r10
            r2[r3] = r4
            r2[r7] = r8
            r2[r9] = r10
            r2[r11] = r8
            java.lang.String r13 = "MU"
            r0.putAll(r13, (V[]) r2)
            java.lang.Integer[] r2 = new java.lang.Integer[r1]
            r2[r5] = r12
            r2[r3] = r10
            r2[r7] = r4
            r2[r9] = r12
            r2[r11] = r8
            java.lang.String r13 = "MV"
            r0.putAll(r13, (V[]) r2)
            java.lang.Integer[] r2 = new java.lang.Integer[r1]
            r2[r5] = r12
            r2[r3] = r4
            r2[r7] = r4
            r2[r9] = r6
            r2[r11] = r8
            java.lang.String r13 = "MW"
            r0.putAll(r13, (V[]) r2)
            java.lang.Integer[] r2 = new java.lang.Integer[r1]
            r2[r5] = r8
            r2[r3] = r12
            r2[r7] = r10
            r2[r9] = r10
            r2[r11] = r8
            java.lang.String r13 = "MX"
            r0.putAll(r13, (V[]) r2)
            java.lang.Integer[] r2 = new java.lang.Integer[r1]
            r2[r5] = r8
            r2[r3] = r6
            r2[r7] = r10
            r2[r9] = r10
            r2[r11] = r8
            java.lang.String r13 = "MY"
            r0.putAll(r13, (V[]) r2)
            java.lang.Integer[] r2 = new java.lang.Integer[r1]
            r2[r5] = r10
            r2[r3] = r10
            r2[r7] = r8
            r2[r9] = r10
            r2[r11] = r8
            java.lang.String r13 = "MZ"
            r0.putAll(r13, (V[]) r2)
            java.lang.Integer[] r2 = new java.lang.Integer[r1]
            r2[r5] = r12
            r2[r3] = r10
            r2[r7] = r8
            r2[r9] = r8
            r2[r11] = r8
            java.lang.String r13 = "NA"
            r0.putAll(r13, (V[]) r2)
            java.lang.Integer[] r2 = new java.lang.Integer[r1]
            r2[r5] = r8
            r2[r3] = r6
            r2[r7] = r12
            r2[r9] = r12
            r2[r11] = r8
            java.lang.String r13 = "NC"
            r0.putAll(r13, (V[]) r2)
            java.lang.Integer[] r2 = new java.lang.Integer[r1]
            r2[r5] = r12
            r2[r3] = r12
            r2[r7] = r12
            r2[r9] = r12
            r2[r11] = r8
            java.lang.String r13 = "NE"
            r0.putAll(r13, (V[]) r2)
            java.lang.Integer[] r2 = new java.lang.Integer[r1]
            r2[r5] = r8
            r2[r3] = r8
            r2[r7] = r8
            r2[r9] = r8
            r2[r11] = r8
            java.lang.String r13 = "NF"
            r0.putAll(r13, (V[]) r2)
            java.lang.Integer[] r2 = new java.lang.Integer[r1]
            r2[r5] = r10
            r2[r3] = r10
            r2[r7] = r8
            r2[r9] = r8
            r2[r11] = r8
            java.lang.String r13 = "NG"
            r0.putAll(r13, (V[]) r2)
            java.lang.Integer[] r2 = new java.lang.Integer[r1]
            r2[r5] = r10
            r2[r3] = r4
            r2[r7] = r12
            r2[r9] = r12
            r2[r11] = r8
            java.lang.String r13 = "NI"
            r0.putAll(r13, (V[]) r2)
            java.lang.Integer[] r2 = new java.lang.Integer[r1]
            r2[r5] = r6
            r2[r3] = r8
            r2[r7] = r12
            r2[r9] = r8
            r2[r11] = r6
            java.lang.String r13 = "NL"
            r0.putAll(r13, (V[]) r2)
            java.lang.Integer[] r2 = new java.lang.Integer[r1]
            r2[r5] = r6
            r2[r3] = r4
            r2[r7] = r4
            r2[r9] = r6
            r2[r11] = r8
            java.lang.String r13 = "NO"
            r0.putAll(r13, (V[]) r2)
            java.lang.Integer[] r2 = new java.lang.Integer[r1]
            r2[r5] = r8
            r2[r3] = r6
            r2[r7] = r12
            r2[r9] = r10
            r2[r11] = r8
            java.lang.String r13 = "NP"
            r0.putAll(r13, (V[]) r2)
            java.lang.Integer[] r2 = new java.lang.Integer[r1]
            r2[r5] = r12
            r2[r3] = r8
            r2[r7] = r10
            r2[r9] = r4
            r2[r11] = r8
            java.lang.String r13 = "NR"
            r0.putAll(r13, (V[]) r2)
            java.lang.Integer[] r2 = new java.lang.Integer[r1]
            r2[r5] = r12
            r2[r3] = r8
            r2[r7] = r8
            r2[r9] = r8
            r2[r11] = r8
            java.lang.String r13 = "NU"
            r0.putAll(r13, (V[]) r2)
            java.lang.Integer[] r2 = new java.lang.Integer[r1]
            r2[r5] = r6
            r2[r3] = r8
            r2[r7] = r4
            r2[r9] = r8
            r2[r11] = r12
            java.lang.String r13 = "NZ"
            r0.putAll(r13, (V[]) r2)
            java.lang.Integer[] r2 = new java.lang.Integer[r1]
            r2[r5] = r8
            r2[r3] = r8
            r2[r7] = r6
            r2[r9] = r8
            r2[r11] = r8
            java.lang.String r13 = "OM"
            r0.putAll(r13, (V[]) r2)
            java.lang.Integer[] r2 = new java.lang.Integer[r1]
            r2[r5] = r4
            r2[r3] = r10
            r2[r7] = r10
            r2[r9] = r12
            r2[r11] = r8
            java.lang.String r13 = "PA"
            r0.putAll(r13, (V[]) r2)
            java.lang.Integer[] r2 = new java.lang.Integer[r1]
            r2[r5] = r8
            r2[r3] = r12
            r2[r7] = r12
            r2[r9] = r12
            r2[r11] = r8
            java.lang.String r13 = "PE"
            r0.putAll(r13, (V[]) r2)
            java.lang.Integer[] r2 = new java.lang.Integer[r1]
            r2[r5] = r8
            r2[r3] = r8
            r2[r7] = r4
            r2[r9] = r4
            r2[r11] = r8
            java.lang.String r13 = "PF"
            r0.putAll(r13, (V[]) r2)
            java.lang.Integer[] r2 = new java.lang.Integer[r1]
            r2[r5] = r12
            r2[r3] = r10
            r2[r7] = r10
            r2[r9] = r8
            r2[r11] = r8
            java.lang.String r13 = "PG"
            r0.putAll(r13, (V[]) r2)
            java.lang.Integer[] r2 = new java.lang.Integer[r1]
            r2[r5] = r10
            r2[r3] = r6
            r2[r7] = r10
            r2[r9] = r12
            r2[r11] = r12
            java.lang.String r13 = "PH"
            r0.putAll(r13, (V[]) r2)
            java.lang.Integer[] r2 = new java.lang.Integer[r1]
            r2[r5] = r10
            r2[r3] = r8
            r2[r7] = r10
            r2[r9] = r10
            r2[r11] = r8
            java.lang.String r13 = "PK"
            r0.putAll(r13, (V[]) r2)
            java.lang.Integer[] r2 = new java.lang.Integer[r1]
            r2[r5] = r4
            r2[r3] = r6
            r2[r7] = r8
            r2[r9] = r8
            r2[r11] = r8
            java.lang.String r13 = "PL"
            r0.putAll(r13, (V[]) r2)
            java.lang.Integer[] r2 = new java.lang.Integer[r1]
            r2[r5] = r6
            r2[r3] = r8
            r2[r7] = r8
            r2[r9] = r8
            r2[r11] = r8
            java.lang.String r13 = "PM"
            r0.putAll(r13, (V[]) r2)
            java.lang.Integer[] r2 = new java.lang.Integer[r1]
            r2[r5] = r4
            r2[r3] = r8
            r2[r7] = r8
            r2[r9] = r10
            r2[r11] = r12
            java.lang.String r13 = "PR"
            r0.putAll(r13, (V[]) r2)
            java.lang.Integer[] r2 = new java.lang.Integer[r1]
            r2[r5] = r10
            r2[r3] = r10
            r2[r7] = r8
            r2[r9] = r8
            r2[r11] = r8
            java.lang.String r13 = "PS"
            r0.putAll(r13, (V[]) r2)
            java.lang.Integer[] r2 = new java.lang.Integer[r1]
            r2[r5] = r4
            r2[r3] = r4
            r2[r7] = r6
            r2[r9] = r6
            r2[r11] = r8
            java.lang.String r13 = "PT"
            r0.putAll(r13, (V[]) r2)
            java.lang.Integer[] r2 = new java.lang.Integer[r1]
            r2[r5] = r4
            r2[r3] = r8
            r2[r7] = r10
            r2[r9] = r6
            r2[r11] = r8
            java.lang.String r13 = "PW"
            r0.putAll(r13, (V[]) r2)
            java.lang.Integer[] r2 = new java.lang.Integer[r1]
            r2[r5] = r8
            r2[r3] = r6
            r2[r7] = r10
            r2[r9] = r10
            r2[r11] = r8
            java.lang.String r13 = "PY"
            r0.putAll(r13, (V[]) r2)
            java.lang.Integer[] r2 = new java.lang.Integer[r1]
            r2[r5] = r8
            r2[r3] = r10
            r2[r7] = r4
            r2[r9] = r8
            r2[r11] = r8
            java.lang.String r13 = "QA"
            r0.putAll(r13, (V[]) r2)
            java.lang.Integer[] r2 = new java.lang.Integer[r1]
            r2[r5] = r4
            r2[r3] = r6
            r2[r7] = r8
            r2[r9] = r4
            r2[r11] = r8
            java.lang.String r13 = "RE"
            r0.putAll(r13, (V[]) r2)
            java.lang.Integer[] r2 = new java.lang.Integer[r1]
            r2[r5] = r4
            r2[r3] = r4
            r2[r7] = r4
            r2[r9] = r8
            r2[r11] = r8
            java.lang.String r13 = "RO"
            r0.putAll(r13, (V[]) r2)
            java.lang.Integer[] r2 = new java.lang.Integer[r1]
            r2[r5] = r4
            r2[r3] = r8
            r2[r7] = r6
            r2[r9] = r6
            r2[r11] = r8
            java.lang.String r13 = "RS"
            r0.putAll(r13, (V[]) r2)
            java.lang.Integer[] r2 = new java.lang.Integer[r1]
            r2[r5] = r6
            r2[r3] = r4
            r2[r7] = r6
            r2[r9] = r4
            r2[r11] = r8
            java.lang.String r13 = "RU"
            r0.putAll(r13, (V[]) r2)
            java.lang.Integer[] r2 = new java.lang.Integer[r1]
            r2[r5] = r12
            r2[r3] = r10
            r2[r7] = r10
            r2[r9] = r12
            r2[r11] = r8
            java.lang.String r13 = "RW"
            r0.putAll(r13, (V[]) r2)
            java.lang.Integer[] r2 = new java.lang.Integer[r1]
            r2[r5] = r8
            r2[r3] = r8
            r2[r7] = r8
            r2[r9] = r4
            r2[r11] = r8
            java.lang.String r13 = "SA"
            r0.putAll(r13, (V[]) r2)
            java.lang.Integer[] r2 = new java.lang.Integer[r1]
            r2[r5] = r12
            r2[r3] = r8
            r2[r7] = r12
            r2[r9] = r8
            r2[r11] = r8
            java.lang.String r13 = "SB"
            r0.putAll(r13, (V[]) r2)
            java.lang.Integer[] r2 = new java.lang.Integer[r1]
            r2[r5] = r12
            r2[r3] = r8
            r2[r7] = r6
            r2[r9] = r4
            r2[r11] = r8
            java.lang.String r13 = "SC"
            r0.putAll(r13, (V[]) r2)
            java.lang.Integer[] r2 = new java.lang.Integer[r1]
            r2[r5] = r12
            r2[r3] = r12
            r2[r7] = r12
            r2[r9] = r10
            r2[r11] = r8
            java.lang.String r13 = "SD"
            r0.putAll(r13, (V[]) r2)
            java.lang.Integer[] r2 = new java.lang.Integer[r1]
            r2[r5] = r6
            r2[r3] = r6
            r2[r7] = r6
            r2[r9] = r6
            r2[r11] = r8
            java.lang.String r13 = "SE"
            r0.putAll(r13, (V[]) r2)
            java.lang.Integer[] r2 = new java.lang.Integer[r1]
            r2[r5] = r6
            r2[r3] = r6
            r2[r7] = r10
            r2[r9] = r10
            r2[r11] = r12
            java.lang.String r13 = "SG"
            r0.putAll(r13, (V[]) r2)
            java.lang.Integer[] r2 = new java.lang.Integer[r1]
            r2[r5] = r12
            r2[r3] = r8
            r2[r7] = r8
            r2[r9] = r8
            r2[r11] = r8
            java.lang.String r13 = "SH"
            r0.putAll(r13, (V[]) r2)
            java.lang.Integer[] r2 = new java.lang.Integer[r1]
            r2[r5] = r6
            r2[r3] = r4
            r2[r7] = r6
            r2[r9] = r6
            r2[r11] = r8
            java.lang.String r13 = "SI"
            r0.putAll(r13, (V[]) r2)
            java.lang.Integer[] r2 = new java.lang.Integer[r1]
            r2[r5] = r8
            r2[r3] = r8
            r2[r7] = r8
            r2[r9] = r8
            r2[r11] = r8
            java.lang.String r13 = "SJ"
            r0.putAll(r13, (V[]) r2)
            java.lang.Integer[] r2 = new java.lang.Integer[r1]
            r2[r5] = r6
            r2[r3] = r4
            r2[r7] = r6
            r2[r9] = r6
            r2[r11] = r8
            java.lang.String r13 = "SK"
            r0.putAll(r13, (V[]) r2)
            java.lang.Integer[] r2 = new java.lang.Integer[r1]
            r2[r5] = r12
            r2[r3] = r10
            r2[r7] = r10
            r2[r9] = r4
            r2[r11] = r8
            java.lang.String r13 = "SL"
            r0.putAll(r13, (V[]) r2)
            java.lang.Integer[] r2 = new java.lang.Integer[r1]
            r2[r5] = r6
            r2[r3] = r8
            r2[r7] = r8
            r2[r9] = r8
            r2[r11] = r8
            java.lang.String r13 = "SM"
            r0.putAll(r13, (V[]) r2)
            java.lang.Integer[] r2 = new java.lang.Integer[r1]
            r2[r5] = r12
            r2[r3] = r12
            r2[r7] = r12
            r2[r9] = r10
            r2[r11] = r8
            java.lang.String r13 = "SN"
            r0.putAll(r13, (V[]) r2)
            java.lang.Integer[] r2 = new java.lang.Integer[r1]
            r2[r5] = r10
            r2[r3] = r12
            r2[r7] = r12
            r2[r9] = r12
            r2[r11] = r8
            java.lang.String r13 = "SO"
            r0.putAll(r13, (V[]) r2)
            java.lang.Integer[] r2 = new java.lang.Integer[r1]
            r2[r5] = r10
            r2[r3] = r8
            r2[r7] = r10
            r2[r9] = r4
            r2[r11] = r8
            java.lang.String r13 = "SR"
            r0.putAll(r13, (V[]) r2)
            java.lang.Integer[] r2 = new java.lang.Integer[r1]
            r2[r5] = r12
            r2[r3] = r4
            r2[r7] = r12
            r2[r9] = r8
            r2[r11] = r8
            java.lang.String r13 = "SS"
            r0.putAll(r13, (V[]) r2)
            java.lang.Integer[] r2 = new java.lang.Integer[r1]
            r2[r5] = r8
            r2[r3] = r8
            r2[r7] = r4
            r2[r9] = r8
            r2[r11] = r8
            java.lang.String r13 = "ST"
            r0.putAll(r13, (V[]) r2)
            java.lang.Integer[] r2 = new java.lang.Integer[r1]
            r2[r5] = r8
            r2[r3] = r4
            r2[r7] = r12
            r2[r9] = r12
            r2[r11] = r8
            java.lang.String r13 = "SV"
            r0.putAll(r13, (V[]) r2)
            java.lang.Integer[] r2 = new java.lang.Integer[r1]
            r2[r5] = r8
            r2[r3] = r8
            r2[r7] = r4
            r2[r9] = r6
            r2[r11] = r8
            java.lang.String r13 = "SX"
            r0.putAll(r13, (V[]) r2)
            java.lang.Integer[] r2 = new java.lang.Integer[r1]
            r2[r5] = r12
            r2[r3] = r10
            r2[r7] = r8
            r2[r9] = r8
            r2[r11] = r8
            java.lang.String r13 = "SY"
            r0.putAll(r13, (V[]) r2)
            java.lang.Integer[] r2 = new java.lang.Integer[r1]
            r2[r5] = r10
            r2[r3] = r12
            r2[r7] = r10
            r2[r9] = r12
            r2[r11] = r8
            java.lang.String r13 = "SZ"
            r0.putAll(r13, (V[]) r2)
            java.lang.Integer[] r2 = new java.lang.Integer[r1]
            r2[r5] = r4
            r2[r3] = r8
            r2[r7] = r4
            r2[r9] = r6
            r2[r11] = r8
            java.lang.String r13 = "TC"
            r0.putAll(r13, (V[]) r2)
            java.lang.Integer[] r2 = new java.lang.Integer[r1]
            r2[r5] = r12
            r2[r3] = r12
            r2[r7] = r12
            r2[r9] = r12
            r2[r11] = r8
            java.lang.String r13 = "TD"
            r0.putAll(r13, (V[]) r2)
            java.lang.Integer[] r2 = new java.lang.Integer[r1]
            r2[r5] = r10
            r2[r3] = r8
            r2[r7] = r4
            r2[r9] = r6
            r2[r11] = r8
            java.lang.String r13 = "TG"
            r0.putAll(r13, (V[]) r2)
            java.lang.Integer[] r2 = new java.lang.Integer[r1]
            r2[r5] = r4
            r2[r3] = r10
            r2[r7] = r12
            r2[r9] = r10
            r2[r11] = r6
            java.lang.String r13 = "TH"
            r0.putAll(r13, (V[]) r2)
            java.lang.Integer[] r2 = new java.lang.Integer[r1]
            r2[r5] = r12
            r2[r3] = r12
            r2[r7] = r12
            r2[r9] = r12
            r2[r11] = r8
            java.lang.String r13 = "TJ"
            r0.putAll(r13, (V[]) r2)
            java.lang.Integer[] r2 = new java.lang.Integer[r1]
            r2[r5] = r12
            r2[r3] = r4
            r2[r7] = r12
            r2[r9] = r12
            r2[r11] = r8
            java.lang.String r13 = "TL"
            r0.putAll(r13, (V[]) r2)
            java.lang.Integer[] r2 = new java.lang.Integer[r1]
            r2[r5] = r12
            r2[r3] = r8
            r2[r7] = r4
            r2[r9] = r8
            r2[r11] = r8
            java.lang.String r13 = "TM"
            r0.putAll(r13, (V[]) r2)
            java.lang.Integer[] r2 = new java.lang.Integer[r1]
            r2[r5] = r8
            r2[r3] = r4
            r2[r7] = r4
            r2[r9] = r4
            r2[r11] = r8
            java.lang.String r13 = "TN"
            r0.putAll(r13, (V[]) r2)
            java.lang.Integer[] r2 = new java.lang.Integer[r1]
            r2[r5] = r10
            r2[r3] = r10
            r2[r7] = r12
            r2[r9] = r8
            r2[r11] = r8
            java.lang.String r13 = "TO"
            r0.putAll(r13, (V[]) r2)
            java.lang.Integer[] r2 = new java.lang.Integer[r1]
            r2[r5] = r4
            r2[r3] = r8
            r2[r7] = r4
            r2[r9] = r4
            r2[r11] = r8
            java.lang.String r13 = "TR"
            r0.putAll(r13, (V[]) r2)
            java.lang.Integer[] r2 = new java.lang.Integer[r1]
            r2[r5] = r4
            r2[r3] = r10
            r2[r7] = r4
            r2[r9] = r10
            r2[r11] = r8
            java.lang.String r13 = "TT"
            r0.putAll(r13, (V[]) r2)
            java.lang.Integer[] r2 = new java.lang.Integer[r1]
            r2[r5] = r10
            r2[r3] = r8
            r2[r7] = r8
            r2[r9] = r12
            r2[r11] = r8
            java.lang.String r13 = "TV"
            r0.putAll(r13, (V[]) r2)
            java.lang.Integer[] r2 = new java.lang.Integer[r1]
            r2[r5] = r6
            r2[r3] = r6
            r2[r7] = r6
            r2[r9] = r6
            r2[r11] = r4
            java.lang.String r13 = "TW"
            r0.putAll(r13, (V[]) r2)
            java.lang.Integer[] r2 = new java.lang.Integer[r1]
            r2[r5] = r10
            r2[r3] = r10
            r2[r7] = r10
            r2[r9] = r8
            r2[r11] = r8
            java.lang.String r13 = "TZ"
            r0.putAll(r13, (V[]) r2)
            java.lang.Integer[] r2 = new java.lang.Integer[r1]
            r2[r5] = r6
            r2[r3] = r10
            r2[r7] = r6
            r2[r9] = r6
            r2[r11] = r8
            java.lang.String r13 = "UA"
            r0.putAll(r13, (V[]) r2)
            java.lang.Integer[] r2 = new java.lang.Integer[r1]
            r2[r5] = r10
            r2[r3] = r8
            r2[r7] = r8
            r2[r9] = r10
            r2[r11] = r8
            java.lang.String r13 = "UG"
            r0.putAll(r13, (V[]) r2)
            java.lang.Integer[] r2 = new java.lang.Integer[r1]
            r2[r5] = r6
            r2[r3] = r4
            r2[r7] = r10
            r2[r9] = r10
            r2[r11] = r10
            java.lang.String r13 = "US"
            r0.putAll(r13, (V[]) r2)
            java.lang.Integer[] r2 = new java.lang.Integer[r1]
            r2[r5] = r8
            r2[r3] = r4
            r2[r7] = r4
            r2[r9] = r4
            r2[r11] = r8
            java.lang.String r13 = "UY"
            r0.putAll(r13, (V[]) r2)
            java.lang.Integer[] r2 = new java.lang.Integer[r1]
            r2[r5] = r8
            r2[r3] = r6
            r2[r7] = r10
            r2[r9] = r8
            r2[r11] = r8
            java.lang.String r13 = "UZ"
            r0.putAll(r13, (V[]) r2)
            java.lang.Integer[] r2 = new java.lang.Integer[r1]
            r2[r5] = r8
            r2[r3] = r8
            r2[r7] = r8
            r2[r9] = r8
            r2[r11] = r8
            java.lang.String r13 = "VC"
            r0.putAll(r13, (V[]) r2)
            java.lang.Integer[] r2 = new java.lang.Integer[r1]
            r2[r5] = r12
            r2[r3] = r12
            r2[r7] = r12
            r2[r9] = r12
            r2[r11] = r8
            java.lang.String r13 = "VE"
            r0.putAll(r13, (V[]) r2)
            java.lang.Integer[] r2 = new java.lang.Integer[r1]
            r2[r5] = r8
            r2[r3] = r8
            r2[r7] = r4
            r2[r9] = r8
            r2[r11] = r8
            java.lang.String r13 = "VG"
            r0.putAll(r13, (V[]) r2)
            java.lang.Integer[] r2 = new java.lang.Integer[r1]
            r2[r5] = r4
            r2[r3] = r8
            r2[r7] = r8
            r2[r9] = r12
            r2[r11] = r8
            java.lang.String r13 = "VI"
            r0.putAll(r13, (V[]) r2)
            java.lang.Integer[] r2 = new java.lang.Integer[r1]
            r2[r5] = r6
            r2[r3] = r4
            r2[r7] = r12
            r2[r9] = r12
            r2[r11] = r8
            java.lang.String r13 = "VN"
            r0.putAll(r13, (V[]) r2)
            java.lang.Integer[] r2 = new java.lang.Integer[r1]
            r2[r5] = r12
            r2[r3] = r4
            r2[r7] = r10
            r2[r9] = r4
            r2[r11] = r8
            java.lang.String r13 = "VU"
            r0.putAll(r13, (V[]) r2)
            java.lang.Integer[] r2 = new java.lang.Integer[r1]
            r2[r5] = r10
            r2[r3] = r4
            r2[r7] = r12
            r2[r9] = r8
            r2[r11] = r8
            java.lang.String r13 = "WS"
            r0.putAll(r13, (V[]) r2)
            java.lang.Integer[] r2 = new java.lang.Integer[r1]
            r2[r5] = r4
            r2[r3] = r4
            r2[r7] = r4
            r2[r9] = r6
            r2[r11] = r8
            java.lang.String r6 = "XK"
            r0.putAll(r6, (V[]) r2)
            java.lang.Integer[] r2 = new java.lang.Integer[r1]
            r2[r5] = r12
            r2[r3] = r12
            r2[r7] = r12
            r2[r9] = r12
            r2[r11] = r8
            java.lang.String r6 = "YE"
            r0.putAll(r6, (V[]) r2)
            java.lang.Integer[] r2 = new java.lang.Integer[r1]
            r2[r5] = r10
            r2[r3] = r8
            r2[r7] = r4
            r2[r9] = r10
            r2[r11] = r8
            java.lang.String r4 = "YT"
            r0.putAll(r4, (V[]) r2)
            java.lang.Integer[] r2 = new java.lang.Integer[r1]
            r2[r5] = r8
            r2[r3] = r10
            r2[r7] = r8
            r2[r9] = r8
            r2[r11] = r8
            java.lang.String r4 = "ZA"
            r0.putAll(r4, (V[]) r2)
            java.lang.Integer[] r2 = new java.lang.Integer[r1]
            r2[r5] = r10
            r2[r3] = r8
            r2[r7] = r8
            r2[r9] = r10
            r2[r11] = r8
            java.lang.String r4 = "ZM"
            r0.putAll(r4, (V[]) r2)
            java.lang.Integer[] r1 = new java.lang.Integer[r1]
            r1[r5] = r10
            r1[r3] = r10
            r1[r7] = r10
            r1[r9] = r10
            r1[r11] = r8
            java.lang.String r2 = "ZW"
            r0.putAll(r2, (V[]) r1)
            com.google.common.collect.ImmutableListMultimap r0 = r0.build()
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.upstream.DefaultBandwidthMeter.createInitialBitrateCountryGroupAssignment():com.google.common.collect.ImmutableListMultimap");
    }
}
