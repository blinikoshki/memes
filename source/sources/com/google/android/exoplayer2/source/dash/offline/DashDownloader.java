package com.google.android.exoplayer2.source.dash.offline;

import android.net.Uri;
import com.google.android.exoplayer2.C1844C;
import com.google.android.exoplayer2.MediaItem;
import com.google.android.exoplayer2.extractor.ChunkIndex;
import com.google.android.exoplayer2.offline.SegmentDownloader;
import com.google.android.exoplayer2.offline.StreamKey;
import com.google.android.exoplayer2.source.dash.DashSegmentIndex;
import com.google.android.exoplayer2.source.dash.DashUtil;
import com.google.android.exoplayer2.source.dash.DashWrappingSegmentIndex;
import com.google.android.exoplayer2.source.dash.manifest.AdaptationSet;
import com.google.android.exoplayer2.source.dash.manifest.DashManifest;
import com.google.android.exoplayer2.source.dash.manifest.DashManifestParser;
import com.google.android.exoplayer2.source.dash.manifest.Period;
import com.google.android.exoplayer2.source.dash.manifest.RangedUri;
import com.google.android.exoplayer2.source.dash.manifest.Representation;
import com.google.android.exoplayer2.upstream.DataSource;
import com.google.android.exoplayer2.upstream.DataSpec;
import com.google.android.exoplayer2.upstream.ParsingLoadable;
import com.google.android.exoplayer2.upstream.cache.CacheDataSource;
import com.google.android.exoplayer2.util.RunnableFutureTask;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executor;

public final class DashDownloader extends SegmentDownloader<DashManifest> {
    @Deprecated
    public DashDownloader(Uri uri, List<StreamKey> list, CacheDataSource.Factory factory) {
        this(uri, list, factory, (Executor) $$Lambda$PNiE7SuEFxRjAZH7pJpZIFOFjWg.INSTANCE);
    }

    public DashDownloader(MediaItem mediaItem, CacheDataSource.Factory factory) {
        this(mediaItem, factory, (Executor) $$Lambda$PNiE7SuEFxRjAZH7pJpZIFOFjWg.INSTANCE);
    }

    @Deprecated
    public DashDownloader(Uri uri, List<StreamKey> list, CacheDataSource.Factory factory, Executor executor) {
        this(new MediaItem.Builder().setUri(uri).setStreamKeys(list).build(), factory, executor);
    }

    public DashDownloader(MediaItem mediaItem, CacheDataSource.Factory factory, Executor executor) {
        this(mediaItem, (ParsingLoadable.Parser<DashManifest>) new DashManifestParser(), factory, executor);
    }

    public DashDownloader(MediaItem mediaItem, ParsingLoadable.Parser<DashManifest> parser, CacheDataSource.Factory factory, Executor executor) {
        super(mediaItem, parser, factory, executor);
    }

    /* access modifiers changed from: protected */
    public List<SegmentDownloader.Segment> getSegments(DataSource dataSource, DashManifest dashManifest, boolean z) throws IOException, InterruptedException {
        DashManifest dashManifest2 = dashManifest;
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < dashManifest.getPeriodCount(); i++) {
            Period period = dashManifest2.getPeriod(i);
            long msToUs = C1844C.msToUs(period.startMs);
            long periodDurationUs = dashManifest2.getPeriodDurationUs(i);
            int i2 = 0;
            for (List<AdaptationSet> list = period.adaptationSets; i2 < list.size(); list = list) {
                addSegmentsForAdaptationSet(dataSource, list.get(i2), msToUs, periodDurationUs, z, arrayList);
                i2++;
            }
        }
        return arrayList;
    }

    /* JADX WARNING: Removed duplicated region for block: B:38:0x0089 A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:42:0x0084 A[SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void addSegmentsForAdaptationSet(com.google.android.exoplayer2.upstream.DataSource r23, com.google.android.exoplayer2.source.dash.manifest.AdaptationSet r24, long r25, long r27, boolean r29, java.util.ArrayList<com.google.android.exoplayer2.offline.SegmentDownloader.Segment> r30) throws java.io.IOException, java.lang.InterruptedException {
        /*
            r22 = this;
            r1 = r24
            r2 = r25
            r4 = r29
            r5 = r30
            r0 = 0
            r6 = 0
        L_0x000a:
            java.util.List<com.google.android.exoplayer2.source.dash.manifest.Representation> r0 = r1.representations
            int r0 = r0.size()
            if (r6 >= r0) goto L_0x008a
            java.util.List<com.google.android.exoplayer2.source.dash.manifest.Representation> r0 = r1.representations
            java.lang.Object r0 = r0.get(r6)
            com.google.android.exoplayer2.source.dash.manifest.Representation r0 = (com.google.android.exoplayer2.source.dash.manifest.Representation) r0
            int r7 = r1.type     // Catch:{ IOException -> 0x007b }
            r8 = r22
            r9 = r23
            com.google.android.exoplayer2.source.dash.DashSegmentIndex r7 = r8.getSegmentIndex(r9, r7, r0, r4)     // Catch:{ IOException -> 0x0079 }
            if (r7 == 0) goto L_0x006d
            r10 = r27
            int r12 = r7.getSegmentCount(r10)
            r13 = -1
            if (r12 == r13) goto L_0x0065
            java.lang.String r13 = r0.baseUrl
            com.google.android.exoplayer2.source.dash.manifest.RangedUri r14 = r0.getInitializationUri()
            if (r14 == 0) goto L_0x003a
            addSegment(r2, r13, r14, r5)
        L_0x003a:
            com.google.android.exoplayer2.source.dash.manifest.RangedUri r0 = r0.getIndexUri()
            if (r0 == 0) goto L_0x0043
            addSegment(r2, r13, r0, r5)
        L_0x0043:
            long r14 = r7.getFirstSegmentNum()
            long r0 = (long) r12
            long r0 = r0 + r14
            r16 = 1
            long r0 = r0 - r16
        L_0x004d:
            int r12 = (r14 > r0 ? 1 : (r14 == r0 ? 0 : -1))
            if (r12 > 0) goto L_0x0084
            long r18 = r7.getTimeUs(r14)
            r20 = r0
            long r0 = r2 + r18
            com.google.android.exoplayer2.source.dash.manifest.RangedUri r12 = r7.getSegmentUrl(r14)
            addSegment(r0, r13, r12, r5)
            long r14 = r14 + r16
            r0 = r20
            goto L_0x004d
        L_0x0065:
            com.google.android.exoplayer2.offline.DownloadException r0 = new com.google.android.exoplayer2.offline.DownloadException
            java.lang.String r1 = "Unbounded segment index"
            r0.<init>((java.lang.String) r1)
            throw r0
        L_0x006d:
            r10 = r27
            com.google.android.exoplayer2.offline.DownloadException r0 = new com.google.android.exoplayer2.offline.DownloadException     // Catch:{ IOException -> 0x0077 }
            java.lang.String r1 = "Missing segment index"
            r0.<init>((java.lang.String) r1)     // Catch:{ IOException -> 0x0077 }
            throw r0     // Catch:{ IOException -> 0x0077 }
        L_0x0077:
            r0 = move-exception
            goto L_0x0082
        L_0x0079:
            r0 = move-exception
            goto L_0x0080
        L_0x007b:
            r0 = move-exception
            r8 = r22
            r9 = r23
        L_0x0080:
            r10 = r27
        L_0x0082:
            if (r4 == 0) goto L_0x0089
        L_0x0084:
            int r6 = r6 + 1
            r1 = r24
            goto L_0x000a
        L_0x0089:
            throw r0
        L_0x008a:
            r8 = r22
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.source.dash.offline.DashDownloader.addSegmentsForAdaptationSet(com.google.android.exoplayer2.upstream.DataSource, com.google.android.exoplayer2.source.dash.manifest.AdaptationSet, long, long, boolean, java.util.ArrayList):void");
    }

    private static void addSegment(long j, String str, RangedUri rangedUri, ArrayList<SegmentDownloader.Segment> arrayList) {
        arrayList.add(new SegmentDownloader.Segment(j, new DataSpec(rangedUri.resolveUri(str), rangedUri.start, rangedUri.length)));
    }

    private DashSegmentIndex getSegmentIndex(final DataSource dataSource, final int i, final Representation representation, boolean z) throws IOException, InterruptedException {
        DashSegmentIndex index = representation.getIndex();
        if (index != null) {
            return index;
        }
        ChunkIndex chunkIndex = (ChunkIndex) execute(new RunnableFutureTask<ChunkIndex, IOException>(this) {
            /* access modifiers changed from: protected */
            public ChunkIndex doWork() throws IOException {
                return DashUtil.loadChunkIndex(dataSource, i, representation);
            }
        }, z);
        if (chunkIndex == null) {
            return null;
        }
        return new DashWrappingSegmentIndex(chunkIndex, representation.presentationTimeOffsetUs);
    }
}
