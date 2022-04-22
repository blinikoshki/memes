package com.google.android.exoplayer2.source.hls;

import android.net.Uri;
import com.google.android.exoplayer2.C1844C;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.drm.DrmInitData;
import com.google.android.exoplayer2.extractor.DefaultExtractorInput;
import com.google.android.exoplayer2.extractor.ExtractorInput;
import com.google.android.exoplayer2.metadata.Metadata;
import com.google.android.exoplayer2.metadata.id3.Id3Decoder;
import com.google.android.exoplayer2.metadata.id3.PrivFrame;
import com.google.android.exoplayer2.source.chunk.MediaChunk;
import com.google.android.exoplayer2.upstream.DataSource;
import com.google.android.exoplayer2.upstream.DataSpec;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.ParsableByteArray;
import com.google.android.exoplayer2.util.TimestampAdjuster;
import com.google.android.exoplayer2.util.Util;
import com.google.common.collect.ImmutableList;
import java.io.EOFException;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.math.BigInteger;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import org.checkerframework.checker.nullness.qual.EnsuresNonNull;
import org.checkerframework.checker.nullness.qual.RequiresNonNull;

final class HlsMediaChunk extends MediaChunk {
    public static final String PRIV_TIMESTAMP_FRAME_OWNER = "com.apple.streaming.transportStreamTimestamp";
    private static final AtomicInteger uidSource = new AtomicInteger();
    public final int discontinuitySequenceNumber;
    private final DrmInitData drmInitData;
    private HlsMediaChunkExtractor extractor;
    private final HlsExtractorFactory extractorFactory;
    private boolean extractorInvalidated;
    private final boolean hasGapTag;
    private final Id3Decoder id3Decoder;
    private boolean initDataLoadRequired;
    private final DataSource initDataSource;
    private final DataSpec initDataSpec;
    private final boolean initSegmentEncrypted;
    private final boolean isMasterTimestampSource;
    private volatile boolean loadCanceled;
    private boolean loadCompleted;
    private final boolean mediaSegmentEncrypted;
    private final List<Format> muxedCaptionFormats;
    private int nextLoadPosition;
    private HlsSampleStreamWrapper output;
    public final Uri playlistUrl;
    private final HlsMediaChunkExtractor previousExtractor;
    private ImmutableList<Integer> sampleQueueFirstSampleIndices;
    private final ParsableByteArray scratchId3Data;
    public final boolean shouldSpliceIn;
    private final TimestampAdjuster timestampAdjuster;
    public final int uid;

    /* JADX WARNING: Code restructure failed: missing block: B:30:0x00b0, code lost:
        if (r20 >= r3.endTimeUs) goto L_0x00bc;
     */
    /* JADX WARNING: Removed duplicated region for block: B:41:0x00cb  */
    /* JADX WARNING: Removed duplicated region for block: B:42:0x00ce  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.google.android.exoplayer2.source.hls.HlsMediaChunk createInstance(com.google.android.exoplayer2.source.hls.HlsExtractorFactory r37, com.google.android.exoplayer2.upstream.DataSource r38, com.google.android.exoplayer2.Format r39, long r40, com.google.android.exoplayer2.source.hls.playlist.HlsMediaPlaylist r42, int r43, android.net.Uri r44, java.util.List<com.google.android.exoplayer2.Format> r45, int r46, java.lang.Object r47, boolean r48, com.google.android.exoplayer2.source.hls.TimestampAdjusterProvider r49, com.google.android.exoplayer2.source.hls.HlsMediaChunk r50, byte[] r51, byte[] r52) {
        /*
            r0 = r38
            r1 = r42
            r2 = r43
            r3 = r50
            r4 = r51
            r5 = r52
            java.util.List<com.google.android.exoplayer2.source.hls.playlist.HlsMediaPlaylist$Segment> r6 = r1.segments
            java.lang.Object r6 = r6.get(r2)
            com.google.android.exoplayer2.source.hls.playlist.HlsMediaPlaylist$Segment r6 = (com.google.android.exoplayer2.source.hls.playlist.HlsMediaPlaylist.Segment) r6
            com.google.android.exoplayer2.upstream.DataSpec r13 = new com.google.android.exoplayer2.upstream.DataSpec
            java.lang.String r7 = r1.baseUri
            java.lang.String r8 = r6.url
            android.net.Uri r8 = com.google.android.exoplayer2.util.UriUtil.resolveToUri(r7, r8)
            long r9 = r6.byteRangeOffset
            long r11 = r6.byteRangeLength
            r7 = r13
            r7.<init>(r8, r9, r11)
            if (r4 == 0) goto L_0x002a
            r12 = 1
            goto L_0x002b
        L_0x002a:
            r12 = 0
        L_0x002b:
            if (r12 == 0) goto L_0x003a
            java.lang.String r10 = r6.encryptionIV
            java.lang.Object r10 = com.google.android.exoplayer2.util.Assertions.checkNotNull(r10)
            java.lang.String r10 = (java.lang.String) r10
            byte[] r10 = getEncryptionIvArray(r10)
            goto L_0x003b
        L_0x003a:
            r10 = 0
        L_0x003b:
            com.google.android.exoplayer2.upstream.DataSource r4 = buildDataSource(r0, r4, r10)
            com.google.android.exoplayer2.source.hls.playlist.HlsMediaPlaylist$Segment r10 = r6.initializationSegment
            if (r10 == 0) goto L_0x007a
            if (r5 == 0) goto L_0x0047
            r11 = 1
            goto L_0x0048
        L_0x0047:
            r11 = 0
        L_0x0048:
            if (r11 == 0) goto L_0x0057
            java.lang.String r14 = r10.encryptionIV
            java.lang.Object r14 = com.google.android.exoplayer2.util.Assertions.checkNotNull(r14)
            java.lang.String r14 = (java.lang.String) r14
            byte[] r14 = getEncryptionIvArray(r14)
            goto L_0x0058
        L_0x0057:
            r14 = 0
        L_0x0058:
            java.lang.String r15 = r1.baseUri
            java.lang.String r8 = r10.url
            android.net.Uri r18 = com.google.android.exoplayer2.util.UriUtil.resolveToUri(r15, r8)
            com.google.android.exoplayer2.upstream.DataSpec r8 = new com.google.android.exoplayer2.upstream.DataSpec
            r51 = r11
            r15 = r12
            long r11 = r10.byteRangeOffset
            long r9 = r10.byteRangeLength
            r17 = r8
            r19 = r11
            r21 = r9
            r17.<init>(r18, r19, r21)
            com.google.android.exoplayer2.upstream.DataSource r0 = buildDataSource(r0, r5, r14)
            r5 = r51
            r14 = r8
            goto L_0x007e
        L_0x007a:
            r15 = r12
            r0 = 0
            r5 = 0
            r14 = 0
        L_0x007e:
            long r8 = r6.relativeStartTimeUs
            long r20 = r40 + r8
            long r8 = r6.durationUs
            long r31 = r20 + r8
            int r8 = r1.discontinuitySequence
            int r9 = r6.relativeDiscontinuitySequence
            int r12 = r8 + r9
            if (r3 == 0) goto L_0x00d6
            android.net.Uri r8 = r3.playlistUrl
            r11 = r44
            boolean r8 = r11.equals(r8)
            if (r8 == 0) goto L_0x009e
            boolean r8 = r3.loadCompleted
            if (r8 == 0) goto L_0x009e
            r8 = 1
            goto L_0x009f
        L_0x009e:
            r8 = 0
        L_0x009f:
            com.google.android.exoplayer2.metadata.id3.Id3Decoder r9 = r3.id3Decoder
            com.google.android.exoplayer2.util.ParsableByteArray r10 = r3.scratchId3Data
            if (r8 != 0) goto L_0x00b9
            boolean r7 = r1.hasIndependentSegments
            if (r7 == 0) goto L_0x00b3
            r7 = r9
            r18 = r10
            long r9 = r3.endTimeUs
            int r19 = (r20 > r9 ? 1 : (r20 == r9 ? 0 : -1))
            if (r19 < 0) goto L_0x00b6
            goto L_0x00bc
        L_0x00b3:
            r7 = r9
            r18 = r10
        L_0x00b6:
            r16 = 0
            goto L_0x00be
        L_0x00b9:
            r7 = r9
            r18 = r10
        L_0x00bc:
            r16 = 1
        L_0x00be:
            r9 = 1
            r9 = r16 ^ 1
            if (r8 == 0) goto L_0x00ce
            boolean r8 = r3.extractorInvalidated
            if (r8 != 0) goto L_0x00ce
            int r8 = r3.discontinuitySequenceNumber
            if (r8 != r12) goto L_0x00ce
            com.google.android.exoplayer2.source.hls.HlsMediaChunkExtractor r3 = r3.extractor
            goto L_0x00cf
        L_0x00ce:
            r3 = 0
        L_0x00cf:
            r33 = r7
            r35 = r9
            r34 = r18
            goto L_0x00eb
        L_0x00d6:
            r11 = r44
            com.google.android.exoplayer2.metadata.id3.Id3Decoder r3 = new com.google.android.exoplayer2.metadata.id3.Id3Decoder
            r3.<init>()
            com.google.android.exoplayer2.util.ParsableByteArray r7 = new com.google.android.exoplayer2.util.ParsableByteArray
            r8 = 10
            r7.<init>((int) r8)
            r33 = r3
            r34 = r7
            r3 = 0
            r35 = 0
        L_0x00eb:
            com.google.android.exoplayer2.source.hls.HlsMediaChunk r36 = new com.google.android.exoplayer2.source.hls.HlsMediaChunk
            r7 = r36
            long r8 = r1.mediaSequence
            long r1 = (long) r2
            long r24 = r8 + r1
            boolean r1 = r6.hasGapTag
            r27 = r1
            r1 = r49
            com.google.android.exoplayer2.util.TimestampAdjuster r29 = r1.getAdjuster(r12)
            com.google.android.exoplayer2.drm.DrmInitData r1 = r6.drmInitData
            r30 = r1
            r8 = r37
            r9 = r4
            r10 = r13
            r11 = r39
            r1 = r12
            r12 = r15
            r13 = r0
            r15 = r5
            r16 = r44
            r17 = r45
            r18 = r46
            r19 = r47
            r22 = r31
            r26 = r1
            r28 = r48
            r31 = r3
            r32 = r33
            r33 = r34
            r34 = r35
            r7.<init>(r8, r9, r10, r11, r12, r13, r14, r15, r16, r17, r18, r19, r20, r22, r24, r26, r27, r28, r29, r30, r31, r32, r33, r34)
            return r36
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.source.hls.HlsMediaChunk.createInstance(com.google.android.exoplayer2.source.hls.HlsExtractorFactory, com.google.android.exoplayer2.upstream.DataSource, com.google.android.exoplayer2.Format, long, com.google.android.exoplayer2.source.hls.playlist.HlsMediaPlaylist, int, android.net.Uri, java.util.List, int, java.lang.Object, boolean, com.google.android.exoplayer2.source.hls.TimestampAdjusterProvider, com.google.android.exoplayer2.source.hls.HlsMediaChunk, byte[], byte[]):com.google.android.exoplayer2.source.hls.HlsMediaChunk");
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    private HlsMediaChunk(HlsExtractorFactory hlsExtractorFactory, DataSource dataSource, DataSpec dataSpec, Format format, boolean z, DataSource dataSource2, DataSpec dataSpec2, boolean z2, Uri uri, List<Format> list, int i, Object obj, long j, long j2, long j3, int i2, boolean z3, boolean z4, TimestampAdjuster timestampAdjuster2, DrmInitData drmInitData2, HlsMediaChunkExtractor hlsMediaChunkExtractor, Id3Decoder id3Decoder2, ParsableByteArray parsableByteArray, boolean z5) {
        super(dataSource, dataSpec, format, i, obj, j, j2, j3);
        DataSpec dataSpec3 = dataSpec2;
        this.mediaSegmentEncrypted = z;
        this.discontinuitySequenceNumber = i2;
        this.initDataSpec = dataSpec3;
        this.initDataSource = dataSource2;
        this.initDataLoadRequired = dataSpec3 != null;
        this.initSegmentEncrypted = z2;
        this.playlistUrl = uri;
        this.isMasterTimestampSource = z4;
        this.timestampAdjuster = timestampAdjuster2;
        this.hasGapTag = z3;
        this.extractorFactory = hlsExtractorFactory;
        this.muxedCaptionFormats = list;
        this.drmInitData = drmInitData2;
        this.previousExtractor = hlsMediaChunkExtractor;
        this.id3Decoder = id3Decoder2;
        this.scratchId3Data = parsableByteArray;
        this.shouldSpliceIn = z5;
        this.sampleQueueFirstSampleIndices = ImmutableList.m433of();
        this.uid = uidSource.getAndIncrement();
    }

    public void init(HlsSampleStreamWrapper hlsSampleStreamWrapper, ImmutableList<Integer> immutableList) {
        this.output = hlsSampleStreamWrapper;
        this.sampleQueueFirstSampleIndices = immutableList;
    }

    public int getFirstSampleIndex(int i) {
        Assertions.checkState(!this.shouldSpliceIn);
        if (i >= this.sampleQueueFirstSampleIndices.size()) {
            return 0;
        }
        return ((Integer) this.sampleQueueFirstSampleIndices.get(i)).intValue();
    }

    public void invalidateExtractor() {
        this.extractorInvalidated = true;
    }

    public boolean isLoadCompleted() {
        return this.loadCompleted;
    }

    public void cancelLoad() {
        this.loadCanceled = true;
    }

    public void load() throws IOException {
        HlsMediaChunkExtractor hlsMediaChunkExtractor;
        Assertions.checkNotNull(this.output);
        if (this.extractor == null && (hlsMediaChunkExtractor = this.previousExtractor) != null && hlsMediaChunkExtractor.isReusable()) {
            this.extractor = this.previousExtractor;
            this.initDataLoadRequired = false;
        }
        maybeLoadInitData();
        if (!this.loadCanceled) {
            if (!this.hasGapTag) {
                loadMedia();
            }
            this.loadCompleted = !this.loadCanceled;
        }
    }

    @RequiresNonNull({"output"})
    private void maybeLoadInitData() throws IOException {
        if (this.initDataLoadRequired) {
            Assertions.checkNotNull(this.initDataSource);
            Assertions.checkNotNull(this.initDataSpec);
            feedDataToExtractor(this.initDataSource, this.initDataSpec, this.initSegmentEncrypted);
            this.nextLoadPosition = 0;
            this.initDataLoadRequired = false;
        }
    }

    @RequiresNonNull({"output"})
    private void loadMedia() throws IOException {
        if (!this.isMasterTimestampSource) {
            try {
                this.timestampAdjuster.waitUntilInitialized();
            } catch (InterruptedException unused) {
                throw new InterruptedIOException();
            }
        } else if (this.timestampAdjuster.getFirstSampleTimestampUs() == Long.MAX_VALUE) {
            this.timestampAdjuster.setFirstSampleTimestampUs(this.startTimeUs);
        }
        feedDataToExtractor(this.dataSource, this.dataSpec, this.mediaSegmentEncrypted);
    }

    @RequiresNonNull({"output"})
    private void feedDataToExtractor(DataSource dataSource, DataSpec dataSpec, boolean z) throws IOException {
        DataSpec dataSpec2;
        DefaultExtractorInput prepareExtraction;
        boolean z2 = false;
        if (z) {
            if (this.nextLoadPosition != 0) {
                z2 = true;
            }
            dataSpec2 = dataSpec;
        } else {
            dataSpec2 = dataSpec.subrange((long) this.nextLoadPosition);
        }
        try {
            prepareExtraction = prepareExtraction(dataSource, dataSpec2);
            if (z2) {
                prepareExtraction.skipFully(this.nextLoadPosition);
            }
            do {
                if (this.loadCanceled || !this.extractor.read(prepareExtraction)) {
                    break;
                }
                break;
                break;
            } while (!this.extractor.read(prepareExtraction));
            break;
            this.nextLoadPosition = (int) (prepareExtraction.getPosition() - dataSpec.position);
            Util.closeQuietly(dataSource);
        } catch (Throwable th) {
            Util.closeQuietly(dataSource);
            throw th;
        }
    }

    @RequiresNonNull({"output"})
    @EnsuresNonNull({"extractor"})
    private DefaultExtractorInput prepareExtraction(DataSource dataSource, DataSpec dataSpec) throws IOException {
        HlsMediaChunkExtractor hlsMediaChunkExtractor;
        long j;
        DataSpec dataSpec2 = dataSpec;
        DataSource dataSource2 = dataSource;
        DefaultExtractorInput defaultExtractorInput = new DefaultExtractorInput(dataSource2, dataSpec2.position, dataSource.open(dataSpec));
        if (this.extractor == null) {
            long peekId3PrivTimestamp = peekId3PrivTimestamp(defaultExtractorInput);
            defaultExtractorInput.resetPeekPosition();
            HlsMediaChunkExtractor hlsMediaChunkExtractor2 = this.previousExtractor;
            if (hlsMediaChunkExtractor2 != null) {
                hlsMediaChunkExtractor = hlsMediaChunkExtractor2.recreate();
            } else {
                hlsMediaChunkExtractor = this.extractorFactory.createExtractor(dataSpec2.uri, this.trackFormat, this.muxedCaptionFormats, this.timestampAdjuster, dataSource.getResponseHeaders(), defaultExtractorInput);
            }
            this.extractor = hlsMediaChunkExtractor;
            if (hlsMediaChunkExtractor.isPackedAudioExtractor()) {
                HlsSampleStreamWrapper hlsSampleStreamWrapper = this.output;
                if (peekId3PrivTimestamp != C1844C.TIME_UNSET) {
                    j = this.timestampAdjuster.adjustTsTimestamp(peekId3PrivTimestamp);
                } else {
                    j = this.startTimeUs;
                }
                hlsSampleStreamWrapper.setSampleOffsetUs(j);
            } else {
                this.output.setSampleOffsetUs(0);
            }
            this.output.onNewExtractor();
            this.extractor.init(this.output);
        }
        this.output.setDrmInitData(this.drmInitData);
        return defaultExtractorInput;
    }

    private long peekId3PrivTimestamp(ExtractorInput extractorInput) throws IOException {
        extractorInput.resetPeekPosition();
        try {
            extractorInput.peekFully(this.scratchId3Data.getData(), 0, 10);
            this.scratchId3Data.reset(10);
            if (this.scratchId3Data.readUnsignedInt24() != 4801587) {
                return C1844C.TIME_UNSET;
            }
            this.scratchId3Data.skipBytes(3);
            int readSynchSafeInt = this.scratchId3Data.readSynchSafeInt();
            int i = readSynchSafeInt + 10;
            if (i > this.scratchId3Data.capacity()) {
                byte[] data = this.scratchId3Data.getData();
                this.scratchId3Data.reset(i);
                System.arraycopy(data, 0, this.scratchId3Data.getData(), 0, 10);
            }
            extractorInput.peekFully(this.scratchId3Data.getData(), 10, readSynchSafeInt);
            Metadata decode = this.id3Decoder.decode(this.scratchId3Data.getData(), readSynchSafeInt);
            if (decode == null) {
                return C1844C.TIME_UNSET;
            }
            int length = decode.length();
            for (int i2 = 0; i2 < length; i2++) {
                Metadata.Entry entry = decode.get(i2);
                if (entry instanceof PrivFrame) {
                    PrivFrame privFrame = (PrivFrame) entry;
                    if (PRIV_TIMESTAMP_FRAME_OWNER.equals(privFrame.owner)) {
                        System.arraycopy(privFrame.privateData, 0, this.scratchId3Data.getData(), 0, 8);
                        this.scratchId3Data.reset(8);
                        return this.scratchId3Data.readLong() & 8589934591L;
                    }
                }
            }
            return C1844C.TIME_UNSET;
        } catch (EOFException unused) {
        }
    }

    private static byte[] getEncryptionIvArray(String str) {
        if (Util.toLowerInvariant(str).startsWith("0x")) {
            str = str.substring(2);
        }
        byte[] byteArray = new BigInteger(str, 16).toByteArray();
        byte[] bArr = new byte[16];
        int length = byteArray.length > 16 ? byteArray.length - 16 : 0;
        System.arraycopy(byteArray, length, bArr, (16 - byteArray.length) + length, byteArray.length - length);
        return bArr;
    }

    private static DataSource buildDataSource(DataSource dataSource, byte[] bArr, byte[] bArr2) {
        if (bArr == null) {
            return dataSource;
        }
        Assertions.checkNotNull(bArr2);
        return new Aes128DataSource(dataSource, bArr, bArr2);
    }
}
