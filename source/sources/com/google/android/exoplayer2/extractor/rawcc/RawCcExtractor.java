package com.google.android.exoplayer2.extractor.rawcc;

import com.google.android.exoplayer2.C1844C;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.ParserException;
import com.google.android.exoplayer2.extractor.Extractor;
import com.google.android.exoplayer2.extractor.ExtractorInput;
import com.google.android.exoplayer2.extractor.ExtractorOutput;
import com.google.android.exoplayer2.extractor.PositionHolder;
import com.google.android.exoplayer2.extractor.SeekMap;
import com.google.android.exoplayer2.extractor.TrackOutput;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.ParsableByteArray;
import java.io.IOException;
import org.checkerframework.checker.nullness.qual.RequiresNonNull;

public final class RawCcExtractor implements Extractor {
    private static final int HEADER_ID = 1380139777;
    private static final int HEADER_SIZE = 8;
    private static final int SCRATCH_SIZE = 9;
    private static final int STATE_READING_HEADER = 0;
    private static final int STATE_READING_SAMPLES = 2;
    private static final int STATE_READING_TIMESTAMP_AND_COUNT = 1;
    private static final int TIMESTAMP_SIZE_V0 = 4;
    private static final int TIMESTAMP_SIZE_V1 = 8;
    private final ParsableByteArray dataScratch = new ParsableByteArray(9);
    private final Format format;
    private int parserState = 0;
    private int remainingSampleCount;
    private int sampleBytesWritten;
    private long timestampUs;
    private TrackOutput trackOutput;
    private int version;

    public void release() {
    }

    public RawCcExtractor(Format format2) {
        this.format = format2;
    }

    public void init(ExtractorOutput extractorOutput) {
        extractorOutput.seekMap(new SeekMap.Unseekable(C1844C.TIME_UNSET));
        TrackOutput track = extractorOutput.track(0, 3);
        this.trackOutput = track;
        track.format(this.format);
        extractorOutput.endTracks();
    }

    public boolean sniff(ExtractorInput extractorInput) throws IOException {
        this.dataScratch.reset(8);
        extractorInput.peekFully(this.dataScratch.getData(), 0, 8);
        if (this.dataScratch.readInt() == HEADER_ID) {
            return true;
        }
        return false;
    }

    public int read(ExtractorInput extractorInput, PositionHolder positionHolder) throws IOException {
        Assertions.checkStateNotNull(this.trackOutput);
        while (true) {
            int i = this.parserState;
            if (i != 0) {
                if (i != 1) {
                    if (i == 2) {
                        parseSamples(extractorInput);
                        this.parserState = 1;
                        return 0;
                    }
                    throw new IllegalStateException();
                } else if (parseTimestampAndSampleCount(extractorInput)) {
                    this.parserState = 2;
                } else {
                    this.parserState = 0;
                    return -1;
                }
            } else if (!parseHeader(extractorInput)) {
                return -1;
            } else {
                this.parserState = 1;
            }
        }
    }

    public void seek(long j, long j2) {
        this.parserState = 0;
    }

    private boolean parseHeader(ExtractorInput extractorInput) throws IOException {
        this.dataScratch.reset(8);
        if (!extractorInput.readFully(this.dataScratch.getData(), 0, 8, true)) {
            return false;
        }
        if (this.dataScratch.readInt() == HEADER_ID) {
            this.version = this.dataScratch.readUnsignedByte();
            return true;
        }
        throw new IOException("Input not RawCC");
    }

    private boolean parseTimestampAndSampleCount(ExtractorInput extractorInput) throws IOException {
        int i = this.version;
        if (i == 0) {
            this.dataScratch.reset(5);
            if (!extractorInput.readFully(this.dataScratch.getData(), 0, 5, true)) {
                return false;
            }
            this.timestampUs = (this.dataScratch.readUnsignedInt() * 1000) / 45;
        } else if (i == 1) {
            this.dataScratch.reset(9);
            if (!extractorInput.readFully(this.dataScratch.getData(), 0, 9, true)) {
                return false;
            }
            this.timestampUs = this.dataScratch.readLong();
        } else {
            int i2 = this.version;
            StringBuilder sb = new StringBuilder(39);
            sb.append("Unsupported version number: ");
            sb.append(i2);
            throw new ParserException(sb.toString());
        }
        this.remainingSampleCount = this.dataScratch.readUnsignedByte();
        this.sampleBytesWritten = 0;
        return true;
    }

    @RequiresNonNull({"trackOutput"})
    private void parseSamples(ExtractorInput extractorInput) throws IOException {
        while (this.remainingSampleCount > 0) {
            this.dataScratch.reset(3);
            extractorInput.readFully(this.dataScratch.getData(), 0, 3);
            this.trackOutput.sampleData(this.dataScratch, 3);
            this.sampleBytesWritten += 3;
            this.remainingSampleCount--;
        }
        int i = this.sampleBytesWritten;
        if (i > 0) {
            this.trackOutput.sampleMetadata(this.timestampUs, 1, i, 0, (TrackOutput.CryptoData) null);
        }
    }
}
