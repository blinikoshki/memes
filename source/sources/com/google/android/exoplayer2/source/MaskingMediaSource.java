package com.google.android.exoplayer2.source;

import com.google.android.exoplayer2.C1844C;
import com.google.android.exoplayer2.MediaItem;
import com.google.android.exoplayer2.Timeline;
import com.google.android.exoplayer2.source.MediaSource;
import com.google.android.exoplayer2.upstream.Allocator;
import com.google.android.exoplayer2.upstream.TransferListener;
import com.google.android.exoplayer2.util.Util;
import org.checkerframework.checker.nullness.qual.RequiresNonNull;

public final class MaskingMediaSource extends CompositeMediaSource<Void> {
    private boolean hasRealTimeline;
    private boolean hasStartedPreparing;
    private boolean isPrepared;
    private final MediaSource mediaSource;
    private final Timeline.Period period;
    private MaskingTimeline timeline;
    private MaskingMediaPeriod unpreparedMaskingMediaPeriod;
    private final boolean useLazyPreparation;
    private final Timeline.Window window;

    public void maybeThrowSourceInfoRefreshError() {
    }

    public MaskingMediaSource(MediaSource mediaSource2, boolean z) {
        this.mediaSource = mediaSource2;
        this.useLazyPreparation = z && mediaSource2.isSingleWindow();
        this.window = new Timeline.Window();
        this.period = new Timeline.Period();
        Timeline initialTimeline = mediaSource2.getInitialTimeline();
        if (initialTimeline != null) {
            this.timeline = MaskingTimeline.createWithRealTimeline(initialTimeline, (Object) null, (Object) null);
            this.hasRealTimeline = true;
            return;
        }
        this.timeline = MaskingTimeline.createWithPlaceholderTimeline(mediaSource2.getMediaItem());
    }

    public Timeline getTimeline() {
        return this.timeline;
    }

    public void prepareSourceInternal(TransferListener transferListener) {
        super.prepareSourceInternal(transferListener);
        if (!this.useLazyPreparation) {
            this.hasStartedPreparing = true;
            prepareChildSource(null, this.mediaSource);
        }
    }

    @Deprecated
    public Object getTag() {
        return this.mediaSource.getTag();
    }

    public MediaItem getMediaItem() {
        return this.mediaSource.getMediaItem();
    }

    public MaskingMediaPeriod createPeriod(MediaSource.MediaPeriodId mediaPeriodId, Allocator allocator, long j) {
        MaskingMediaPeriod maskingMediaPeriod = new MaskingMediaPeriod(this.mediaSource, mediaPeriodId, allocator, j);
        if (this.isPrepared) {
            maskingMediaPeriod.createPeriod(mediaPeriodId.copyWithPeriodUid(getInternalPeriodUid(mediaPeriodId.periodUid)));
        } else {
            this.unpreparedMaskingMediaPeriod = maskingMediaPeriod;
            if (!this.hasStartedPreparing) {
                this.hasStartedPreparing = true;
                prepareChildSource(null, this.mediaSource);
            }
        }
        return maskingMediaPeriod;
    }

    public void releasePeriod(MediaPeriod mediaPeriod) {
        ((MaskingMediaPeriod) mediaPeriod).releasePeriod();
        if (mediaPeriod == this.unpreparedMaskingMediaPeriod) {
            this.unpreparedMaskingMediaPeriod = null;
        }
    }

    public void releaseSourceInternal() {
        this.isPrepared = false;
        this.hasStartedPreparing = false;
        super.releaseSourceInternal();
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x006e  */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x0075  */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x007f  */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x009e  */
    /* JADX WARNING: Removed duplicated region for block: B:30:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onChildSourceInfoRefreshed(java.lang.Void r12, com.google.android.exoplayer2.source.MediaSource r13, com.google.android.exoplayer2.Timeline r14) {
        /*
            r11 = this;
            boolean r12 = r11.isPrepared
            if (r12 == 0) goto L_0x0019
            com.google.android.exoplayer2.source.MaskingMediaSource$MaskingTimeline r12 = r11.timeline
            com.google.android.exoplayer2.source.MaskingMediaSource$MaskingTimeline r12 = r12.cloneWithUpdatedTimeline(r14)
            r11.timeline = r12
            com.google.android.exoplayer2.source.MaskingMediaPeriod r12 = r11.unpreparedMaskingMediaPeriod
            if (r12 == 0) goto L_0x0091
            long r12 = r12.getPreparePositionOverrideUs()
            r11.setPreparePositionOverrideToUnpreparedMaskingPeriod(r12)
            goto L_0x0091
        L_0x0019:
            boolean r12 = r14.isEmpty()
            if (r12 == 0) goto L_0x0035
            boolean r12 = r11.hasRealTimeline
            if (r12 == 0) goto L_0x002a
            com.google.android.exoplayer2.source.MaskingMediaSource$MaskingTimeline r12 = r11.timeline
            com.google.android.exoplayer2.source.MaskingMediaSource$MaskingTimeline r12 = r12.cloneWithUpdatedTimeline(r14)
            goto L_0x0032
        L_0x002a:
            java.lang.Object r12 = com.google.android.exoplayer2.Timeline.Window.SINGLE_WINDOW_UID
            java.lang.Object r13 = com.google.android.exoplayer2.source.MaskingMediaSource.MaskingTimeline.MASKING_EXTERNAL_PERIOD_UID
            com.google.android.exoplayer2.source.MaskingMediaSource$MaskingTimeline r12 = com.google.android.exoplayer2.source.MaskingMediaSource.MaskingTimeline.createWithRealTimeline(r14, r12, r13)
        L_0x0032:
            r11.timeline = r12
            goto L_0x0091
        L_0x0035:
            r12 = 0
            com.google.android.exoplayer2.Timeline$Window r13 = r11.window
            r14.getWindow(r12, r13)
            com.google.android.exoplayer2.Timeline$Window r12 = r11.window
            long r12 = r12.getDefaultPositionUs()
            com.google.android.exoplayer2.source.MaskingMediaPeriod r0 = r11.unpreparedMaskingMediaPeriod
            if (r0 == 0) goto L_0x0051
            long r0 = r0.getPreparePositionUs()
            r2 = 0
            int r4 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r4 == 0) goto L_0x0051
            r9 = r0
            goto L_0x0052
        L_0x0051:
            r9 = r12
        L_0x0052:
            com.google.android.exoplayer2.Timeline$Window r12 = r11.window
            java.lang.Object r12 = r12.uid
            com.google.android.exoplayer2.Timeline$Window r6 = r11.window
            com.google.android.exoplayer2.Timeline$Period r7 = r11.period
            r8 = 0
            r5 = r14
            android.util.Pair r13 = r5.getPeriodPosition(r6, r7, r8, r9)
            java.lang.Object r0 = r13.first
            java.lang.Object r13 = r13.second
            java.lang.Long r13 = (java.lang.Long) r13
            long r1 = r13.longValue()
            boolean r13 = r11.hasRealTimeline
            if (r13 == 0) goto L_0x0075
            com.google.android.exoplayer2.source.MaskingMediaSource$MaskingTimeline r12 = r11.timeline
            com.google.android.exoplayer2.source.MaskingMediaSource$MaskingTimeline r12 = r12.cloneWithUpdatedTimeline(r14)
            goto L_0x0079
        L_0x0075:
            com.google.android.exoplayer2.source.MaskingMediaSource$MaskingTimeline r12 = com.google.android.exoplayer2.source.MaskingMediaSource.MaskingTimeline.createWithRealTimeline(r14, r12, r0)
        L_0x0079:
            r11.timeline = r12
            com.google.android.exoplayer2.source.MaskingMediaPeriod r12 = r11.unpreparedMaskingMediaPeriod
            if (r12 == 0) goto L_0x0091
            r11.setPreparePositionOverrideToUnpreparedMaskingPeriod(r1)
            com.google.android.exoplayer2.source.MediaSource$MediaPeriodId r13 = r12.f528id
            com.google.android.exoplayer2.source.MediaSource$MediaPeriodId r12 = r12.f528id
            java.lang.Object r12 = r12.periodUid
            java.lang.Object r12 = r11.getInternalPeriodUid(r12)
            com.google.android.exoplayer2.source.MediaSource$MediaPeriodId r12 = r13.copyWithPeriodUid(r12)
            goto L_0x0092
        L_0x0091:
            r12 = 0
        L_0x0092:
            r13 = 1
            r11.hasRealTimeline = r13
            r11.isPrepared = r13
            com.google.android.exoplayer2.source.MaskingMediaSource$MaskingTimeline r13 = r11.timeline
            r11.refreshSourceInfo(r13)
            if (r12 == 0) goto L_0x00a9
            com.google.android.exoplayer2.source.MaskingMediaPeriod r13 = r11.unpreparedMaskingMediaPeriod
            java.lang.Object r13 = com.google.android.exoplayer2.util.Assertions.checkNotNull(r13)
            com.google.android.exoplayer2.source.MaskingMediaPeriod r13 = (com.google.android.exoplayer2.source.MaskingMediaPeriod) r13
            r13.createPeriod(r12)
        L_0x00a9:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.source.MaskingMediaSource.onChildSourceInfoRefreshed(java.lang.Void, com.google.android.exoplayer2.source.MediaSource, com.google.android.exoplayer2.Timeline):void");
    }

    /* access modifiers changed from: protected */
    public MediaSource.MediaPeriodId getMediaPeriodIdForChildMediaPeriodId(Void voidR, MediaSource.MediaPeriodId mediaPeriodId) {
        return mediaPeriodId.copyWithPeriodUid(getExternalPeriodUid(mediaPeriodId.periodUid));
    }

    private Object getInternalPeriodUid(Object obj) {
        return (this.timeline.replacedInternalPeriodUid == null || !obj.equals(MaskingTimeline.MASKING_EXTERNAL_PERIOD_UID)) ? obj : this.timeline.replacedInternalPeriodUid;
    }

    private Object getExternalPeriodUid(Object obj) {
        return (this.timeline.replacedInternalPeriodUid == null || !this.timeline.replacedInternalPeriodUid.equals(obj)) ? obj : MaskingTimeline.MASKING_EXTERNAL_PERIOD_UID;
    }

    @RequiresNonNull({"unpreparedMaskingMediaPeriod"})
    private void setPreparePositionOverrideToUnpreparedMaskingPeriod(long j) {
        MaskingMediaPeriod maskingMediaPeriod = this.unpreparedMaskingMediaPeriod;
        int indexOfPeriod = this.timeline.getIndexOfPeriod(maskingMediaPeriod.f528id.periodUid);
        if (indexOfPeriod != -1) {
            long j2 = this.timeline.getPeriod(indexOfPeriod, this.period).durationUs;
            if (j2 != C1844C.TIME_UNSET && j >= j2) {
                j = Math.max(0, j2 - 1);
            }
            maskingMediaPeriod.overridePreparePositionUs(j);
        }
    }

    private static final class MaskingTimeline extends ForwardingTimeline {
        public static final Object MASKING_EXTERNAL_PERIOD_UID = new Object();
        /* access modifiers changed from: private */
        public final Object replacedInternalPeriodUid;
        private final Object replacedInternalWindowUid;

        public static MaskingTimeline createWithPlaceholderTimeline(MediaItem mediaItem) {
            return new MaskingTimeline(new PlaceholderTimeline(mediaItem), Timeline.Window.SINGLE_WINDOW_UID, MASKING_EXTERNAL_PERIOD_UID);
        }

        public static MaskingTimeline createWithRealTimeline(Timeline timeline, Object obj, Object obj2) {
            return new MaskingTimeline(timeline, obj, obj2);
        }

        private MaskingTimeline(Timeline timeline, Object obj, Object obj2) {
            super(timeline);
            this.replacedInternalWindowUid = obj;
            this.replacedInternalPeriodUid = obj2;
        }

        public MaskingTimeline cloneWithUpdatedTimeline(Timeline timeline) {
            return new MaskingTimeline(timeline, this.replacedInternalWindowUid, this.replacedInternalPeriodUid);
        }

        public Timeline getTimeline() {
            return this.timeline;
        }

        public Timeline.Window getWindow(int i, Timeline.Window window, long j) {
            this.timeline.getWindow(i, window, j);
            if (Util.areEqual(window.uid, this.replacedInternalWindowUid)) {
                window.uid = Timeline.Window.SINGLE_WINDOW_UID;
            }
            return window;
        }

        public Timeline.Period getPeriod(int i, Timeline.Period period, boolean z) {
            this.timeline.getPeriod(i, period, z);
            if (Util.areEqual(period.uid, this.replacedInternalPeriodUid) && z) {
                period.uid = MASKING_EXTERNAL_PERIOD_UID;
            }
            return period;
        }

        public int getIndexOfPeriod(Object obj) {
            Object obj2;
            Timeline timeline = this.timeline;
            if (MASKING_EXTERNAL_PERIOD_UID.equals(obj) && (obj2 = this.replacedInternalPeriodUid) != null) {
                obj = obj2;
            }
            return timeline.getIndexOfPeriod(obj);
        }

        public Object getUidOfPeriod(int i) {
            Object uidOfPeriod = this.timeline.getUidOfPeriod(i);
            return Util.areEqual(uidOfPeriod, this.replacedInternalPeriodUid) ? MASKING_EXTERNAL_PERIOD_UID : uidOfPeriod;
        }
    }

    public static final class PlaceholderTimeline extends Timeline {
        private final MediaItem mediaItem;

        public int getPeriodCount() {
            return 1;
        }

        public int getWindowCount() {
            return 1;
        }

        public PlaceholderTimeline(MediaItem mediaItem2) {
            this.mediaItem = mediaItem2;
        }

        public Timeline.Window getWindow(int i, Timeline.Window window, long j) {
            Timeline.Window window2 = window;
            window.set(Timeline.Window.SINGLE_WINDOW_UID, this.mediaItem, (Object) null, C1844C.TIME_UNSET, C1844C.TIME_UNSET, C1844C.TIME_UNSET, false, true, false, 0, C1844C.TIME_UNSET, 0, 0, 0);
            Timeline.Window window3 = window;
            window3.isPlaceholder = true;
            return window3;
        }

        public Timeline.Period getPeriod(int i, Timeline.Period period, boolean z) {
            Object obj = null;
            Integer num = z ? 0 : null;
            if (z) {
                obj = MaskingTimeline.MASKING_EXTERNAL_PERIOD_UID;
            }
            return period.set(num, obj, 0, C1844C.TIME_UNSET, 0);
        }

        public int getIndexOfPeriod(Object obj) {
            return obj == MaskingTimeline.MASKING_EXTERNAL_PERIOD_UID ? 0 : -1;
        }

        public Object getUidOfPeriod(int i) {
            return MaskingTimeline.MASKING_EXTERNAL_PERIOD_UID;
        }
    }
}
