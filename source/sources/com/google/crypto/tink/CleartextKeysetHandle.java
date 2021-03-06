package com.google.crypto.tink;

import com.google.crypto.tink.proto.Keyset;
import com.google.crypto.tink.shaded.protobuf.ExtensionRegistryLite;
import com.google.crypto.tink.shaded.protobuf.InvalidProtocolBufferException;
import java.io.IOException;
import java.security.GeneralSecurityException;

public final class CleartextKeysetHandle {
    @Deprecated
    public static final KeysetHandle parseFrom(byte[] bArr) throws GeneralSecurityException {
        try {
            return KeysetHandle.fromKeyset(Keyset.parseFrom(bArr, ExtensionRegistryLite.getEmptyRegistry()));
        } catch (InvalidProtocolBufferException unused) {
            throw new GeneralSecurityException("invalid keyset");
        }
    }

    public static KeysetHandle read(KeysetReader keysetReader) throws GeneralSecurityException, IOException {
        return KeysetHandle.fromKeyset(keysetReader.read());
    }

    public static Keyset getKeyset(KeysetHandle keysetHandle) {
        return keysetHandle.getKeyset();
    }

    public static KeysetHandle fromKeyset(Keyset keyset) throws GeneralSecurityException {
        return KeysetHandle.fromKeyset(keyset);
    }

    public static void write(KeysetHandle keysetHandle, KeysetWriter keysetWriter) throws IOException {
        keysetWriter.write(keysetHandle.getKeyset());
    }
}
