package com.google.android.exoplayer2.extractor;

import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.upstream.DataReader;
import com.google.android.exoplayer2.util.ParsableByteArray;
import java.io.IOException;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.Arrays;

public interface TrackOutput {
    public static final int SAMPLE_DATA_PART_ENCRYPTION = 1;
    public static final int SAMPLE_DATA_PART_MAIN = 0;
    public static final int SAMPLE_DATA_PART_SUPPLEMENTAL = 2;

    @Documented
    @Retention(RetentionPolicy.SOURCE)
    public @interface SampleDataPart {
    }

    void format(Format format);

    int sampleData(DataReader dataReader, int i, boolean z) throws IOException;

    int sampleData(DataReader dataReader, int i, boolean z, int i2) throws IOException;

    void sampleData(ParsableByteArray parsableByteArray, int i);

    void sampleData(ParsableByteArray parsableByteArray, int i, int i2);

    void sampleMetadata(long j, int i, int i2, int i3, CryptoData cryptoData);

    public static final class CryptoData {
        public final int clearBlocks;
        public final int cryptoMode;
        public final int encryptedBlocks;
        public final byte[] encryptionKey;

        public CryptoData(int i, byte[] bArr, int i2, int i3) {
            this.cryptoMode = i;
            this.encryptionKey = bArr;
            this.encryptedBlocks = i2;
            this.clearBlocks = i3;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || getClass() != obj.getClass()) {
                return false;
            }
            CryptoData cryptoData = (CryptoData) obj;
            if (this.cryptoMode == cryptoData.cryptoMode && this.encryptedBlocks == cryptoData.encryptedBlocks && this.clearBlocks == cryptoData.clearBlocks && Arrays.equals(this.encryptionKey, cryptoData.encryptionKey)) {
                return true;
            }
            return false;
        }

        public int hashCode() {
            return (((((this.cryptoMode * 31) + Arrays.hashCode(this.encryptionKey)) * 31) + this.encryptedBlocks) * 31) + this.clearBlocks;
        }
    }

    /* renamed from: com.google.android.exoplayer2.extractor.TrackOutput$-CC  reason: invalid class name */
    public final /* synthetic */ class CC {
        public static int $default$sampleData(TrackOutput _this, DataReader dataReader, int i, boolean z) throws IOException {
            return _this.sampleData(dataReader, i, z, 0);
        }

        public static void $default$sampleData(TrackOutput _this, ParsableByteArray parsableByteArray, int i) {
            _this.sampleData(parsableByteArray, i, 0);
        }
    }
}
