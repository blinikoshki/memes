package com.google.android.exoplayer2.extractor.p023ts;

import com.google.android.exoplayer2.C1844C;
import com.google.android.exoplayer2.extractor.BinarySearchSeeker;
import com.google.android.exoplayer2.extractor.ExtractorInput;
import com.google.android.exoplayer2.util.ParsableByteArray;
import com.google.android.exoplayer2.util.TimestampAdjuster;
import com.google.android.exoplayer2.util.Util;
import java.io.IOException;

/* renamed from: com.google.android.exoplayer2.extractor.ts.TsBinarySearchSeeker */
final class TsBinarySearchSeeker extends BinarySearchSeeker {
    private static final int MINIMUM_SEARCH_RANGE_BYTES = 940;
    private static final long SEEK_TOLERANCE_US = 100000;

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public TsBinarySearchSeeker(com.google.android.exoplayer2.util.TimestampAdjuster r17, long r18, long r20, int r22, int r23) {
        /*
            r16 = this;
            com.google.android.exoplayer2.extractor.BinarySearchSeeker$DefaultSeekTimestampConverter r1 = new com.google.android.exoplayer2.extractor.BinarySearchSeeker$DefaultSeekTimestampConverter
            r1.<init>()
            com.google.android.exoplayer2.extractor.ts.TsBinarySearchSeeker$TsPcrSeeker r2 = new com.google.android.exoplayer2.extractor.ts.TsBinarySearchSeeker$TsPcrSeeker
            r0 = r17
            r3 = r22
            r4 = r23
            r2.<init>(r3, r0, r4)
            r3 = 1
            long r7 = r18 + r3
            r5 = 0
            r9 = 0
            r13 = 188(0xbc, double:9.3E-322)
            r15 = 940(0x3ac, float:1.317E-42)
            r0 = r16
            r3 = r18
            r11 = r20
            r0.<init>(r1, r2, r3, r5, r7, r9, r11, r13, r15)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.extractor.p023ts.TsBinarySearchSeeker.<init>(com.google.android.exoplayer2.util.TimestampAdjuster, long, long, int, int):void");
    }

    /* renamed from: com.google.android.exoplayer2.extractor.ts.TsBinarySearchSeeker$TsPcrSeeker */
    private static final class TsPcrSeeker implements BinarySearchSeeker.TimestampSeeker {
        private final ParsableByteArray packetBuffer = new ParsableByteArray();
        private final int pcrPid;
        private final TimestampAdjuster pcrTimestampAdjuster;
        private final int timestampSearchBytes;

        public TsPcrSeeker(int i, TimestampAdjuster timestampAdjuster, int i2) {
            this.pcrPid = i;
            this.pcrTimestampAdjuster = timestampAdjuster;
            this.timestampSearchBytes = i2;
        }

        public BinarySearchSeeker.TimestampSearchResult searchForTimestamp(ExtractorInput extractorInput, long j) throws IOException {
            long position = extractorInput.getPosition();
            int min = (int) Math.min((long) this.timestampSearchBytes, extractorInput.getLength() - position);
            this.packetBuffer.reset(min);
            extractorInput.peekFully(this.packetBuffer.getData(), 0, min);
            return searchForPcrValueInBuffer(this.packetBuffer, j, position);
        }

        private BinarySearchSeeker.TimestampSearchResult searchForPcrValueInBuffer(ParsableByteArray parsableByteArray, long j, long j2) {
            int findSyncBytePosition;
            int i;
            ParsableByteArray parsableByteArray2 = parsableByteArray;
            long j3 = j2;
            int limit = parsableByteArray.limit();
            long j4 = -1;
            long j5 = -1;
            long j6 = -9223372036854775807L;
            while (parsableByteArray.bytesLeft() >= 188 && (i = findSyncBytePosition + TsExtractor.TS_PACKET_SIZE) <= limit) {
                long readPcrFromPacket = TsUtil.readPcrFromPacket(parsableByteArray2, (findSyncBytePosition = TsUtil.findSyncBytePosition(parsableByteArray.getData(), parsableByteArray.getPosition(), limit)), this.pcrPid);
                if (readPcrFromPacket != C1844C.TIME_UNSET) {
                    long adjustTsTimestamp = this.pcrTimestampAdjuster.adjustTsTimestamp(readPcrFromPacket);
                    if (adjustTsTimestamp > j) {
                        if (j6 == C1844C.TIME_UNSET) {
                            return BinarySearchSeeker.TimestampSearchResult.overestimatedResult(adjustTsTimestamp, j3);
                        }
                        return BinarySearchSeeker.TimestampSearchResult.targetFoundResult(j3 + j5);
                    } else if (TsBinarySearchSeeker.SEEK_TOLERANCE_US + adjustTsTimestamp > j) {
                        return BinarySearchSeeker.TimestampSearchResult.targetFoundResult(j3 + ((long) findSyncBytePosition));
                    } else {
                        j5 = (long) findSyncBytePosition;
                        j6 = adjustTsTimestamp;
                    }
                }
                parsableByteArray2.setPosition(i);
                j4 = (long) i;
            }
            if (j6 != C1844C.TIME_UNSET) {
                return BinarySearchSeeker.TimestampSearchResult.underestimatedResult(j6, j3 + j4);
            }
            return BinarySearchSeeker.TimestampSearchResult.NO_TIMESTAMP_IN_RANGE_RESULT;
        }

        public void onSeekFinished() {
            this.packetBuffer.reset(Util.EMPTY_BYTE_ARRAY);
        }
    }
}
