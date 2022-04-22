package com.google.crypto.tink.subtle;

import com.google.crypto.tink.subtle.Ed25519;
import java.lang.reflect.Array;
import java.math.BigInteger;

final class Ed25519Constants {

    /* renamed from: B2 */
    static final Ed25519.CachedXYT[] f760B2 = new Ed25519.CachedXYT[8];
    static final Ed25519.CachedXYT[][] B_TABLE = ((Ed25519.CachedXYT[][]) Array.newInstance(Ed25519.CachedXYT.class, new int[]{32, 8}));

    /* renamed from: D */
    static final long[] f761D;

    /* renamed from: D2 */
    static final long[] f762D2;
    private static final BigInteger D2_BI;
    private static final BigInteger D_BI;
    private static final BigInteger P_BI;
    static final long[] SQRTM1;
    private static final BigInteger SQRTM1_BI;

    Ed25519Constants() {
    }

    static {
        BigInteger subtract = BigInteger.valueOf(2).pow(255).subtract(BigInteger.valueOf(19));
        P_BI = subtract;
        BigInteger mod = BigInteger.valueOf(-121665).multiply(BigInteger.valueOf(121666).modInverse(subtract)).mod(subtract);
        D_BI = mod;
        BigInteger mod2 = BigInteger.valueOf(2).multiply(mod).mod(subtract);
        D2_BI = mod2;
        BigInteger modPow = BigInteger.valueOf(2).modPow(subtract.subtract(BigInteger.ONE).divide(BigInteger.valueOf(4)), subtract);
        SQRTM1_BI = modPow;
        Point point = new Point();
        BigInteger unused = point.f764y = BigInteger.valueOf(4).multiply(BigInteger.valueOf(5).modInverse(subtract)).mod(subtract);
        BigInteger unused2 = point.f763x = recoverX(point.f764y);
        f761D = Field25519.expand(toLittleEndian(mod));
        f762D2 = Field25519.expand(toLittleEndian(mod2));
        SQRTM1 = Field25519.expand(toLittleEndian(modPow));
        Point point2 = point;
        for (int i = 0; i < 32; i++) {
            Point point3 = point2;
            for (int i2 = 0; i2 < 8; i2++) {
                B_TABLE[i][i2] = getCachedXYT(point3);
                point3 = edwards(point3, point2);
            }
            for (int i3 = 0; i3 < 8; i3++) {
                point2 = edwards(point2, point2);
            }
        }
        Point edwards = edwards(point, point);
        for (int i4 = 0; i4 < 8; i4++) {
            f760B2[i4] = getCachedXYT(point);
            point = edwards(point, edwards);
        }
    }

    private static class Point {
        /* access modifiers changed from: private */

        /* renamed from: x */
        public BigInteger f763x;
        /* access modifiers changed from: private */

        /* renamed from: y */
        public BigInteger f764y;

        private Point() {
        }
    }

    private static BigInteger recoverX(BigInteger bigInteger) {
        BigInteger subtract = bigInteger.pow(2).subtract(BigInteger.ONE);
        BigInteger add = D_BI.multiply(bigInteger.pow(2)).add(BigInteger.ONE);
        BigInteger bigInteger2 = P_BI;
        BigInteger multiply = subtract.multiply(add.modInverse(bigInteger2));
        BigInteger modPow = multiply.modPow(bigInteger2.add(BigInteger.valueOf(3)).divide(BigInteger.valueOf(8)), bigInteger2);
        if (!modPow.pow(2).subtract(multiply).mod(bigInteger2).equals(BigInteger.ZERO)) {
            modPow = modPow.multiply(SQRTM1_BI).mod(bigInteger2);
        }
        return modPow.testBit(0) ? bigInteger2.subtract(modPow) : modPow;
    }

    private static Point edwards(Point point, Point point2) {
        Point point3 = new Point();
        BigInteger multiply = D_BI.multiply(point.f763x.multiply(point2.f763x).multiply(point.f764y).multiply(point2.f764y));
        BigInteger bigInteger = P_BI;
        BigInteger mod = multiply.mod(bigInteger);
        BigInteger unused = point3.f763x = point.f763x.multiply(point2.f764y).add(point2.f763x.multiply(point.f764y)).multiply(BigInteger.ONE.add(mod).modInverse(bigInteger)).mod(bigInteger);
        BigInteger unused2 = point3.f764y = point.f764y.multiply(point2.f764y).add(point.f763x.multiply(point2.f763x)).multiply(BigInteger.ONE.subtract(mod).modInverse(bigInteger)).mod(bigInteger);
        return point3;
    }

    private static byte[] toLittleEndian(BigInteger bigInteger) {
        byte[] bArr = new byte[32];
        byte[] byteArray = bigInteger.toByteArray();
        System.arraycopy(byteArray, 0, bArr, 32 - byteArray.length, byteArray.length);
        for (int i = 0; i < 16; i++) {
            byte b = bArr[i];
            int i2 = (32 - i) - 1;
            bArr[i] = bArr[i2];
            bArr[i2] = b;
        }
        return bArr;
    }

    private static Ed25519.CachedXYT getCachedXYT(Point point) {
        BigInteger add = point.f764y.add(point.f763x);
        BigInteger bigInteger = P_BI;
        return new Ed25519.CachedXYT(Field25519.expand(toLittleEndian(add.mod(bigInteger))), Field25519.expand(toLittleEndian(point.f764y.subtract(point.f763x).mod(bigInteger))), Field25519.expand(toLittleEndian(D2_BI.multiply(point.f763x).multiply(point.f764y).mod(bigInteger))));
    }
}
