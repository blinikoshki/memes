package com.google.crypto.tink;

import com.google.crypto.tink.proto.KeyStatusType;
import com.google.crypto.tink.proto.Keyset;
import com.google.crypto.tink.proto.OutputPrefixType;
import com.google.crypto.tink.subtle.Hex;
import java.security.GeneralSecurityException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

public final class PrimitiveSet<P> {
    private Entry<P> primary;
    private final Class<P> primitiveClass;
    private final ConcurrentMap<Prefix, List<Entry<P>>> primitives = new ConcurrentHashMap();

    public static final class Entry<P> {
        private final byte[] identifier;
        private final int keyId;
        private final OutputPrefixType outputPrefixType;
        private final P primitive;
        private final KeyStatusType status;

        Entry(P p, byte[] bArr, KeyStatusType keyStatusType, OutputPrefixType outputPrefixType2, int i) {
            this.primitive = p;
            this.identifier = Arrays.copyOf(bArr, bArr.length);
            this.status = keyStatusType;
            this.outputPrefixType = outputPrefixType2;
            this.keyId = i;
        }

        public P getPrimitive() {
            return this.primitive;
        }

        public KeyStatusType getStatus() {
            return this.status;
        }

        public OutputPrefixType getOutputPrefixType() {
            return this.outputPrefixType;
        }

        public final byte[] getIdentifier() {
            byte[] bArr = this.identifier;
            if (bArr == null) {
                return null;
            }
            return Arrays.copyOf(bArr, bArr.length);
        }

        public int getKeyId() {
            return this.keyId;
        }
    }

    public Entry<P> getPrimary() {
        return this.primary;
    }

    public List<Entry<P>> getRawPrimitives() {
        return getPrimitive(CryptoFormat.RAW_PREFIX);
    }

    public List<Entry<P>> getPrimitive(byte[] bArr) {
        List<Entry<P>> list = (List) this.primitives.get(new Prefix(bArr));
        return list != null ? list : Collections.emptyList();
    }

    /* access modifiers changed from: protected */
    public List<Entry<P>> getPrimitive(Keyset.Key key) throws GeneralSecurityException {
        return getPrimitive(CryptoFormat.getOutputPrefix(key));
    }

    public Collection<List<Entry<P>>> getAll() {
        return this.primitives.values();
    }

    private PrimitiveSet(Class<P> cls) {
        this.primitiveClass = cls;
    }

    public static <P> PrimitiveSet<P> newPrimitiveSet(Class<P> cls) {
        return new PrimitiveSet<>(cls);
    }

    public void setPrimary(Entry<P> entry) {
        if (entry == null) {
            throw new IllegalArgumentException("the primary entry must be non-null");
        } else if (entry.getStatus() != KeyStatusType.ENABLED) {
            throw new IllegalArgumentException("the primary entry has to be ENABLED");
        } else if (!getPrimitive(entry.getIdentifier()).isEmpty()) {
            this.primary = entry;
        } else {
            throw new IllegalArgumentException("the primary entry cannot be set to an entry which is not held by this primitive set");
        }
    }

    public Entry<P> addPrimitive(P p, Keyset.Key key) throws GeneralSecurityException {
        if (key.getStatus() == KeyStatusType.ENABLED) {
            Entry entry = new Entry(p, CryptoFormat.getOutputPrefix(key), key.getStatus(), key.getOutputPrefixType(), key.getKeyId());
            ArrayList arrayList = new ArrayList();
            arrayList.add(entry);
            Prefix prefix = new Prefix(entry.getIdentifier());
            List list = (List) this.primitives.put(prefix, Collections.unmodifiableList(arrayList));
            if (list != null) {
                ArrayList arrayList2 = new ArrayList();
                arrayList2.addAll(list);
                arrayList2.add(entry);
                this.primitives.put(prefix, Collections.unmodifiableList(arrayList2));
            }
            return entry;
        }
        throw new GeneralSecurityException("only ENABLED key is allowed");
    }

    public Class<P> getPrimitiveClass() {
        return this.primitiveClass;
    }

    private static class Prefix implements Comparable<Prefix> {
        private final byte[] prefix;

        private Prefix(byte[] bArr) {
            this.prefix = Arrays.copyOf(bArr, bArr.length);
        }

        public int hashCode() {
            return Arrays.hashCode(this.prefix);
        }

        public boolean equals(Object obj) {
            if (!(obj instanceof Prefix)) {
                return false;
            }
            return Arrays.equals(this.prefix, ((Prefix) obj).prefix);
        }

        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v2, resolved type: byte} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v3, resolved type: byte} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v5, resolved type: byte} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v5, resolved type: byte} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v6, resolved type: byte} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v6, resolved type: byte} */
        /* JADX WARNING: Multi-variable type inference failed */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public int compareTo(com.google.crypto.tink.PrimitiveSet.Prefix r7) {
            /*
                r6 = this;
                byte[] r0 = r6.prefix
                int r1 = r0.length
                byte[] r2 = r7.prefix
                int r3 = r2.length
                if (r1 == r3) goto L_0x000c
                int r7 = r0.length
                int r0 = r2.length
            L_0x000a:
                int r7 = r7 - r0
                return r7
            L_0x000c:
                r0 = 0
                r1 = 0
            L_0x000e:
                byte[] r2 = r6.prefix
                int r3 = r2.length
                if (r1 >= r3) goto L_0x0023
                byte r3 = r2[r1]
                byte[] r4 = r7.prefix
                byte r5 = r4[r1]
                if (r3 == r5) goto L_0x0020
                byte r7 = r2[r1]
                byte r0 = r4[r1]
                goto L_0x000a
            L_0x0020:
                int r1 = r1 + 1
                goto L_0x000e
            L_0x0023:
                return r0
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.crypto.tink.PrimitiveSet.Prefix.compareTo(com.google.crypto.tink.PrimitiveSet$Prefix):int");
        }

        public String toString() {
            return Hex.encode(this.prefix);
        }
    }
}
