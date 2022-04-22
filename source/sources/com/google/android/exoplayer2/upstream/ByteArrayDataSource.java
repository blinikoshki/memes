package com.google.android.exoplayer2.upstream;

import android.net.Uri;
import com.google.android.exoplayer2.util.Assertions;
import java.io.IOException;

public final class ByteArrayDataSource extends BaseDataSource {
    private int bytesRemaining;
    private final byte[] data;
    private boolean opened;
    private int readPosition;
    private Uri uri;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ByteArrayDataSource(byte[] bArr) {
        super(false);
        boolean z = false;
        Assertions.checkNotNull(bArr);
        Assertions.checkArgument(bArr.length > 0 ? true : z);
        this.data = bArr;
    }

    public long open(DataSpec dataSpec) throws IOException {
        this.uri = dataSpec.uri;
        transferInitializing(dataSpec);
        this.readPosition = (int) dataSpec.position;
        int length = (int) (dataSpec.length == -1 ? ((long) this.data.length) - dataSpec.position : dataSpec.length);
        this.bytesRemaining = length;
        if (length <= 0 || this.readPosition + length > this.data.length) {
            int i = this.readPosition;
            long j = dataSpec.length;
            int length2 = this.data.length;
            StringBuilder sb = new StringBuilder(77);
            sb.append("Unsatisfiable range: [");
            sb.append(i);
            sb.append(", ");
            sb.append(j);
            sb.append("], length: ");
            sb.append(length2);
            throw new IOException(sb.toString());
        }
        this.opened = true;
        transferStarted(dataSpec);
        return (long) this.bytesRemaining;
    }

    public int read(byte[] bArr, int i, int i2) {
        if (i2 == 0) {
            return 0;
        }
        int i3 = this.bytesRemaining;
        if (i3 == 0) {
            return -1;
        }
        int min = Math.min(i2, i3);
        System.arraycopy(this.data, this.readPosition, bArr, i, min);
        this.readPosition += min;
        this.bytesRemaining -= min;
        bytesTransferred(min);
        return min;
    }

    public Uri getUri() {
        return this.uri;
    }

    public void close() {
        if (this.opened) {
            this.opened = false;
            transferEnded();
        }
        this.uri = null;
    }
}
