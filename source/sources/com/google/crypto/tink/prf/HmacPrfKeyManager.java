package com.google.crypto.tink.prf;

import com.google.crypto.tink.KeyTemplate;
import com.google.crypto.tink.KeyTypeManager;
import com.google.crypto.tink.Registry;
import com.google.crypto.tink.proto.HashType;
import com.google.crypto.tink.proto.HmacPrfKey;
import com.google.crypto.tink.proto.HmacPrfKeyFormat;
import com.google.crypto.tink.proto.HmacPrfParams;
import com.google.crypto.tink.proto.KeyData;
import com.google.crypto.tink.shaded.protobuf.ByteString;
import com.google.crypto.tink.shaded.protobuf.ExtensionRegistryLite;
import com.google.crypto.tink.shaded.protobuf.InvalidProtocolBufferException;
import com.google.crypto.tink.subtle.PrfHmacJce;
import com.google.crypto.tink.subtle.Random;
import com.google.crypto.tink.subtle.Validators;
import java.io.IOException;
import java.io.InputStream;
import java.security.GeneralSecurityException;
import javax.crypto.spec.SecretKeySpec;

public final class HmacPrfKeyManager extends KeyTypeManager<HmacPrfKey> {
    private static final int MIN_KEY_SIZE_IN_BYTES = 16;

    public String getKeyType() {
        return "type.googleapis.com/google.crypto.tink.HmacPrfKey";
    }

    public int getVersion() {
        return 0;
    }

    public HmacPrfKeyManager() {
        super(HmacPrfKey.class, new KeyTypeManager.PrimitiveFactory<Prf, HmacPrfKey>(Prf.class) {
            public Prf getPrimitive(HmacPrfKey hmacPrfKey) throws GeneralSecurityException {
                HashType hash = hmacPrfKey.getParams().getHash();
                SecretKeySpec secretKeySpec = new SecretKeySpec(hmacPrfKey.getKeyValue().toByteArray(), "HMAC");
                int i = C35273.$SwitchMap$com$google$crypto$tink$proto$HashType[hash.ordinal()];
                if (i == 1) {
                    return new PrfHmacJce("HMACSHA1", secretKeySpec);
                }
                if (i == 2) {
                    return new PrfHmacJce("HMACSHA256", secretKeySpec);
                }
                if (i == 3) {
                    return new PrfHmacJce("HMACSHA512", secretKeySpec);
                }
                throw new GeneralSecurityException("unknown hash");
            }
        });
    }

    /* renamed from: com.google.crypto.tink.prf.HmacPrfKeyManager$3 */
    static /* synthetic */ class C35273 {
        static final /* synthetic */ int[] $SwitchMap$com$google$crypto$tink$proto$HashType;

        /* JADX WARNING: Can't wrap try/catch for region: R(6:0|1|2|3|4|(3:5|6|8)) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        static {
            /*
                com.google.crypto.tink.proto.HashType[] r0 = com.google.crypto.tink.proto.HashType.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                $SwitchMap$com$google$crypto$tink$proto$HashType = r0
                com.google.crypto.tink.proto.HashType r1 = com.google.crypto.tink.proto.HashType.SHA1     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = $SwitchMap$com$google$crypto$tink$proto$HashType     // Catch:{ NoSuchFieldError -> 0x001d }
                com.google.crypto.tink.proto.HashType r1 = com.google.crypto.tink.proto.HashType.SHA256     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = $SwitchMap$com$google$crypto$tink$proto$HashType     // Catch:{ NoSuchFieldError -> 0x0028 }
                com.google.crypto.tink.proto.HashType r1 = com.google.crypto.tink.proto.HashType.SHA512     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.crypto.tink.prf.HmacPrfKeyManager.C35273.<clinit>():void");
        }
    }

    public KeyData.KeyMaterialType keyMaterialType() {
        return KeyData.KeyMaterialType.SYMMETRIC;
    }

    public void validateKey(HmacPrfKey hmacPrfKey) throws GeneralSecurityException {
        Validators.validateVersion(hmacPrfKey.getVersion(), getVersion());
        if (hmacPrfKey.getKeyValue().size() >= 16) {
            validateParams(hmacPrfKey.getParams());
            return;
        }
        throw new GeneralSecurityException("key too short");
    }

    public HmacPrfKey parseKey(ByteString byteString) throws InvalidProtocolBufferException {
        return HmacPrfKey.parseFrom(byteString, ExtensionRegistryLite.getEmptyRegistry());
    }

    /* access modifiers changed from: private */
    public static void validateParams(HmacPrfParams hmacPrfParams) throws GeneralSecurityException {
        if (hmacPrfParams.getHash() != HashType.SHA1 && hmacPrfParams.getHash() != HashType.SHA256 && hmacPrfParams.getHash() != HashType.SHA512) {
            throw new GeneralSecurityException("unknown hash type");
        }
    }

    public KeyTypeManager.KeyFactory<HmacPrfKeyFormat, HmacPrfKey> keyFactory() {
        return new KeyTypeManager.KeyFactory<HmacPrfKeyFormat, HmacPrfKey>(HmacPrfKeyFormat.class) {
            public void validateKeyFormat(HmacPrfKeyFormat hmacPrfKeyFormat) throws GeneralSecurityException {
                if (hmacPrfKeyFormat.getKeySize() >= 16) {
                    HmacPrfKeyManager.validateParams(hmacPrfKeyFormat.getParams());
                    return;
                }
                throw new GeneralSecurityException("key too short");
            }

            public HmacPrfKeyFormat parseKeyFormat(ByteString byteString) throws InvalidProtocolBufferException {
                return HmacPrfKeyFormat.parseFrom(byteString, ExtensionRegistryLite.getEmptyRegistry());
            }

            public HmacPrfKey createKey(HmacPrfKeyFormat hmacPrfKeyFormat) {
                return (HmacPrfKey) HmacPrfKey.newBuilder().setVersion(HmacPrfKeyManager.this.getVersion()).setParams(hmacPrfKeyFormat.getParams()).setKeyValue(ByteString.copyFrom(Random.randBytes(hmacPrfKeyFormat.getKeySize()))).build();
            }

            public HmacPrfKey deriveKey(HmacPrfKeyFormat hmacPrfKeyFormat, InputStream inputStream) throws GeneralSecurityException {
                Validators.validateVersion(hmacPrfKeyFormat.getVersion(), HmacPrfKeyManager.this.getVersion());
                byte[] bArr = new byte[hmacPrfKeyFormat.getKeySize()];
                try {
                    if (inputStream.read(bArr) == hmacPrfKeyFormat.getKeySize()) {
                        return (HmacPrfKey) HmacPrfKey.newBuilder().setVersion(HmacPrfKeyManager.this.getVersion()).setParams(hmacPrfKeyFormat.getParams()).setKeyValue(ByteString.copyFrom(bArr)).build();
                    }
                    throw new GeneralSecurityException("Not enough pseudorandomness given");
                } catch (IOException e) {
                    throw new GeneralSecurityException("Reading pseudorandomness failed", e);
                }
            }
        };
    }

    public static void register(boolean z) throws GeneralSecurityException {
        Registry.registerKeyManager(new HmacPrfKeyManager(), z);
    }

    public static final KeyTemplate hmacSha256Template() {
        return createTemplate(32, HashType.SHA256);
    }

    public static final KeyTemplate hmacSha512Template() {
        return createTemplate(64, HashType.SHA512);
    }

    private static KeyTemplate createTemplate(int i, HashType hashType) {
        return KeyTemplate.create(new HmacPrfKeyManager().getKeyType(), ((HmacPrfKeyFormat) HmacPrfKeyFormat.newBuilder().setParams((HmacPrfParams) HmacPrfParams.newBuilder().setHash(hashType).build()).setKeySize(i).build()).toByteArray(), KeyTemplate.OutputPrefixType.RAW);
    }
}
