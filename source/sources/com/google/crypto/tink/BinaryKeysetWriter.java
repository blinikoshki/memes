package com.google.crypto.tink;

import com.google.crypto.tink.proto.EncryptedKeyset;
import com.google.crypto.tink.proto.Keyset;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

public final class BinaryKeysetWriter implements KeysetWriter {
    private final boolean closeStreamAfterReading;
    private final OutputStream outputStream;

    private BinaryKeysetWriter(OutputStream outputStream2, boolean z) {
        this.outputStream = outputStream2;
        this.closeStreamAfterReading = z;
    }

    public static KeysetWriter withOutputStream(OutputStream outputStream2) {
        return new BinaryKeysetWriter(outputStream2, false);
    }

    public static KeysetWriter withFile(File file) throws IOException {
        return new BinaryKeysetWriter(new FileOutputStream(file), true);
    }

    public void write(Keyset keyset) throws IOException {
        try {
            keyset.writeTo(this.outputStream);
        } finally {
            if (this.closeStreamAfterReading) {
                this.outputStream.close();
            }
        }
    }

    public void write(EncryptedKeyset encryptedKeyset) throws IOException {
        try {
            encryptedKeyset.writeTo(this.outputStream);
        } finally {
            if (this.closeStreamAfterReading) {
                this.outputStream.close();
            }
        }
    }
}
