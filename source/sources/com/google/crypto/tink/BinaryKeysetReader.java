package com.google.crypto.tink;

import com.google.crypto.tink.proto.EncryptedKeyset;
import com.google.crypto.tink.proto.Keyset;
import com.google.crypto.tink.shaded.protobuf.ExtensionRegistryLite;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

public final class BinaryKeysetReader implements KeysetReader {
    private final boolean closeStreamAfterReading;
    private final InputStream inputStream;

    public static KeysetReader withInputStream(InputStream inputStream2) {
        return new BinaryKeysetReader(inputStream2, false);
    }

    public static KeysetReader withBytes(byte[] bArr) {
        return new BinaryKeysetReader(new ByteArrayInputStream(bArr), true);
    }

    public static KeysetReader withFile(File file) throws IOException {
        return new BinaryKeysetReader(new FileInputStream(file), true);
    }

    private BinaryKeysetReader(InputStream inputStream2, boolean z) {
        this.inputStream = inputStream2;
        this.closeStreamAfterReading = z;
    }

    public Keyset read() throws IOException {
        try {
            return Keyset.parseFrom(this.inputStream, ExtensionRegistryLite.getEmptyRegistry());
        } finally {
            if (this.closeStreamAfterReading) {
                this.inputStream.close();
            }
        }
    }

    public EncryptedKeyset readEncrypted() throws IOException {
        try {
            return EncryptedKeyset.parseFrom(this.inputStream, ExtensionRegistryLite.getEmptyRegistry());
        } finally {
            if (this.closeStreamAfterReading) {
                this.inputStream.close();
            }
        }
    }
}
