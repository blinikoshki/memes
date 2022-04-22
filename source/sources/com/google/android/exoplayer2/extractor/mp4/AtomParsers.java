package com.google.android.exoplayer2.extractor.mp4;

import android.util.Pair;
import com.facebook.imagepipeline.common.RotationOptions;
import com.google.android.exoplayer2.C1844C;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.ParserException;
import com.google.android.exoplayer2.drm.DrmInitData;
import com.google.android.exoplayer2.extractor.GaplessInfoHolder;
import com.google.android.exoplayer2.extractor.mp4.Atom;
import com.google.android.exoplayer2.metadata.Metadata;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.Log;
import com.google.android.exoplayer2.util.MimeTypes;
import com.google.android.exoplayer2.util.ParsableByteArray;
import com.google.android.exoplayer2.util.Util;
import com.google.android.exoplayer2.video.AvcConfig;
import com.google.android.exoplayer2.video.DolbyVisionConfig;
import com.google.android.exoplayer2.video.HevcConfig;
import com.google.common.base.Function;
import com.google.common.collect.ImmutableList;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

final class AtomParsers {
    private static final int MAX_GAPLESS_TRIM_SIZE_SAMPLES = 4;
    private static final String TAG = "AtomParsers";
    private static final int TYPE_clcp = 1668047728;
    private static final int TYPE_mdta = 1835299937;
    private static final int TYPE_meta = 1835365473;
    private static final int TYPE_sbtl = 1935832172;
    private static final int TYPE_soun = 1936684398;
    private static final int TYPE_subt = 1937072756;
    private static final int TYPE_text = 1952807028;
    private static final int TYPE_vide = 1986618469;
    private static final byte[] opusMagic = Util.getUtf8Bytes("OpusHead");

    private interface SampleSizeBox {
        int getFixedSampleSize();

        int getSampleCount();

        int readNextSampleSize();
    }

    private static int getTrackTypeForHdlr(int i) {
        if (i == TYPE_soun) {
            return 1;
        }
        if (i == TYPE_vide) {
            return 2;
        }
        if (i == TYPE_text || i == TYPE_sbtl || i == TYPE_subt || i == TYPE_clcp) {
            return 3;
        }
        return i == 1835365473 ? 4 : -1;
    }

    public static List<TrackSampleTable> parseTraks(Atom.ContainerAtom containerAtom, GaplessInfoHolder gaplessInfoHolder, long j, DrmInitData drmInitData, boolean z, boolean z2, Function<Track, Track> function) throws ParserException {
        Atom.ContainerAtom containerAtom2 = containerAtom;
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < containerAtom2.containerChildren.size(); i++) {
            Atom.ContainerAtom containerAtom3 = containerAtom2.containerChildren.get(i);
            if (containerAtom3.type != 1953653099) {
                GaplessInfoHolder gaplessInfoHolder2 = gaplessInfoHolder;
                Function<Track, Track> function2 = function;
            } else {
                Track apply = function.apply(parseTrak(containerAtom3, (Atom.LeafAtom) Assertions.checkNotNull(containerAtom.getLeafAtomOfType(Atom.TYPE_mvhd)), j, drmInitData, z, z2));
                if (apply == null) {
                    GaplessInfoHolder gaplessInfoHolder3 = gaplessInfoHolder;
                } else {
                    GaplessInfoHolder gaplessInfoHolder4 = gaplessInfoHolder;
                    arrayList.add(parseStbl(apply, (Atom.ContainerAtom) Assertions.checkNotNull(((Atom.ContainerAtom) Assertions.checkNotNull(((Atom.ContainerAtom) Assertions.checkNotNull(containerAtom3.getContainerAtomOfType(Atom.TYPE_mdia))).getContainerAtomOfType(Atom.TYPE_minf))).getContainerAtomOfType(Atom.TYPE_stbl)), gaplessInfoHolder));
                }
            }
        }
        return arrayList;
    }

    public static Metadata parseUdta(Atom.LeafAtom leafAtom, boolean z) {
        if (z) {
            return null;
        }
        ParsableByteArray parsableByteArray = leafAtom.data;
        parsableByteArray.setPosition(8);
        while (parsableByteArray.bytesLeft() >= 8) {
            int position = parsableByteArray.getPosition();
            int readInt = parsableByteArray.readInt();
            if (parsableByteArray.readInt() == 1835365473) {
                parsableByteArray.setPosition(position);
                return parseUdtaMeta(parsableByteArray, position + readInt);
            }
            parsableByteArray.setPosition(position + readInt);
        }
        return null;
    }

    public static Metadata parseMdtaFromMeta(Atom.ContainerAtom containerAtom) {
        Atom.LeafAtom leafAtomOfType = containerAtom.getLeafAtomOfType(Atom.TYPE_hdlr);
        Atom.LeafAtom leafAtomOfType2 = containerAtom.getLeafAtomOfType(Atom.TYPE_keys);
        Atom.LeafAtom leafAtomOfType3 = containerAtom.getLeafAtomOfType(Atom.TYPE_ilst);
        if (leafAtomOfType == null || leafAtomOfType2 == null || leafAtomOfType3 == null || parseHdlr(leafAtomOfType.data) != TYPE_mdta) {
            return null;
        }
        ParsableByteArray parsableByteArray = leafAtomOfType2.data;
        parsableByteArray.setPosition(12);
        int readInt = parsableByteArray.readInt();
        String[] strArr = new String[readInt];
        for (int i = 0; i < readInt; i++) {
            int readInt2 = parsableByteArray.readInt();
            parsableByteArray.skipBytes(4);
            strArr[i] = parsableByteArray.readString(readInt2 - 8);
        }
        ParsableByteArray parsableByteArray2 = leafAtomOfType3.data;
        parsableByteArray2.setPosition(8);
        ArrayList arrayList = new ArrayList();
        while (parsableByteArray2.bytesLeft() > 8) {
            int position = parsableByteArray2.getPosition();
            int readInt3 = parsableByteArray2.readInt();
            int readInt4 = parsableByteArray2.readInt() - 1;
            if (readInt4 < 0 || readInt4 >= readInt) {
                StringBuilder sb = new StringBuilder(52);
                sb.append("Skipped metadata with unknown key index: ");
                sb.append(readInt4);
                Log.m358w(TAG, sb.toString());
            } else {
                MdtaMetadataEntry parseMdtaMetadataEntryFromIlst = MetadataUtil.parseMdtaMetadataEntryFromIlst(parsableByteArray2, position + readInt3, strArr[readInt4]);
                if (parseMdtaMetadataEntryFromIlst != null) {
                    arrayList.add(parseMdtaMetadataEntryFromIlst);
                }
            }
            parsableByteArray2.setPosition(position + readInt3);
        }
        if (arrayList.isEmpty()) {
            return null;
        }
        return new Metadata((List<? extends Metadata.Entry>) arrayList);
    }

    private static Track parseTrak(Atom.ContainerAtom containerAtom, Atom.LeafAtom leafAtom, long j, DrmInitData drmInitData, boolean z, boolean z2) throws ParserException {
        long j2;
        Atom.LeafAtom leafAtom2;
        long[] jArr;
        long[] jArr2;
        Atom.ContainerAtom containerAtomOfType;
        Pair<long[], long[]> parseEdts;
        Atom.ContainerAtom containerAtom2 = containerAtom;
        Atom.ContainerAtom containerAtom3 = (Atom.ContainerAtom) Assertions.checkNotNull(containerAtom2.getContainerAtomOfType(Atom.TYPE_mdia));
        int trackTypeForHdlr = getTrackTypeForHdlr(parseHdlr(((Atom.LeafAtom) Assertions.checkNotNull(containerAtom3.getLeafAtomOfType(Atom.TYPE_hdlr))).data));
        if (trackTypeForHdlr == -1) {
            return null;
        }
        TkhdData parseTkhd = parseTkhd(((Atom.LeafAtom) Assertions.checkNotNull(containerAtom2.getLeafAtomOfType(Atom.TYPE_tkhd))).data);
        long j3 = C1844C.TIME_UNSET;
        if (j == C1844C.TIME_UNSET) {
            leafAtom2 = leafAtom;
            j2 = parseTkhd.duration;
        } else {
            leafAtom2 = leafAtom;
            j2 = j;
        }
        long parseMvhd = parseMvhd(leafAtom2.data);
        if (j2 != C1844C.TIME_UNSET) {
            j3 = Util.scaleLargeTimestamp(j2, 1000000, parseMvhd);
        }
        long j4 = j3;
        Pair<Long, String> parseMdhd = parseMdhd(((Atom.LeafAtom) Assertions.checkNotNull(containerAtom3.getLeafAtomOfType(Atom.TYPE_mdhd))).data);
        StsdData parseStsd = parseStsd(((Atom.LeafAtom) Assertions.checkNotNull(((Atom.ContainerAtom) Assertions.checkNotNull(((Atom.ContainerAtom) Assertions.checkNotNull(containerAtom3.getContainerAtomOfType(Atom.TYPE_minf))).getContainerAtomOfType(Atom.TYPE_stbl))).getLeafAtomOfType(Atom.TYPE_stsd))).data, parseTkhd.f511id, parseTkhd.rotationDegrees, (String) parseMdhd.second, drmInitData, z2);
        if (z || (containerAtomOfType = containerAtom2.getContainerAtomOfType(Atom.TYPE_edts)) == null || (parseEdts = parseEdts(containerAtomOfType)) == null) {
            jArr2 = null;
            jArr = null;
        } else {
            jArr = (long[]) parseEdts.second;
            jArr2 = (long[]) parseEdts.first;
        }
        if (parseStsd.format == null) {
            return null;
        }
        return new Track(parseTkhd.f511id, trackTypeForHdlr, ((Long) parseMdhd.first).longValue(), parseMvhd, j4, parseStsd.format, parseStsd.requiredSampleTransformation, parseStsd.trackEncryptionBoxes, parseStsd.nalUnitLengthFieldLength, jArr2, jArr);
    }

    /* JADX WARNING: Removed duplicated region for block: B:107:0x0254  */
    /* JADX WARNING: Removed duplicated region for block: B:108:0x0257  */
    /* JADX WARNING: Removed duplicated region for block: B:113:0x02bd  */
    /* JADX WARNING: Removed duplicated region for block: B:115:0x02cd  */
    /* JADX WARNING: Removed duplicated region for block: B:139:0x0384  */
    /* JADX WARNING: Removed duplicated region for block: B:145:0x03bc  */
    /* JADX WARNING: Removed duplicated region for block: B:48:0x0102  */
    /* JADX WARNING: Removed duplicated region for block: B:53:0x0137  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static com.google.android.exoplayer2.extractor.mp4.TrackSampleTable parseStbl(com.google.android.exoplayer2.extractor.mp4.Track r36, com.google.android.exoplayer2.extractor.mp4.Atom.ContainerAtom r37, com.google.android.exoplayer2.extractor.GaplessInfoHolder r38) throws com.google.android.exoplayer2.ParserException {
        /*
            r1 = r36
            r0 = r37
            r2 = r38
            r3 = 1937011578(0x7374737a, float:1.936741E31)
            com.google.android.exoplayer2.extractor.mp4.Atom$LeafAtom r3 = r0.getLeafAtomOfType(r3)
            if (r3 == 0) goto L_0x0015
            com.google.android.exoplayer2.extractor.mp4.AtomParsers$StszSampleSizeBox r4 = new com.google.android.exoplayer2.extractor.mp4.AtomParsers$StszSampleSizeBox
            r4.<init>(r3)
            goto L_0x0023
        L_0x0015:
            r3 = 1937013298(0x73747a32, float:1.9369489E31)
            com.google.android.exoplayer2.extractor.mp4.Atom$LeafAtom r3 = r0.getLeafAtomOfType(r3)
            if (r3 == 0) goto L_0x0530
            com.google.android.exoplayer2.extractor.mp4.AtomParsers$Stz2SampleSizeBox r4 = new com.google.android.exoplayer2.extractor.mp4.AtomParsers$Stz2SampleSizeBox
            r4.<init>(r3)
        L_0x0023:
            int r3 = r4.getSampleCount()
            r5 = 0
            if (r3 != 0) goto L_0x0041
            com.google.android.exoplayer2.extractor.mp4.TrackSampleTable r9 = new com.google.android.exoplayer2.extractor.mp4.TrackSampleTable
            long[] r2 = new long[r5]
            int[] r3 = new int[r5]
            r4 = 0
            long[] r6 = new long[r5]
            int[] r7 = new int[r5]
            r10 = 0
            r0 = r9
            r1 = r36
            r5 = r6
            r6 = r7
            r7 = r10
            r0.<init>(r1, r2, r3, r4, r5, r6, r7)
            return r9
        L_0x0041:
            r6 = 1937007471(0x7374636f, float:1.9362445E31)
            com.google.android.exoplayer2.extractor.mp4.Atom$LeafAtom r6 = r0.getLeafAtomOfType(r6)
            r7 = 1
            if (r6 != 0) goto L_0x005a
            r6 = 1668232756(0x636f3634, float:4.4126776E21)
            com.google.android.exoplayer2.extractor.mp4.Atom$LeafAtom r6 = r0.getLeafAtomOfType(r6)
            java.lang.Object r6 = com.google.android.exoplayer2.util.Assertions.checkNotNull(r6)
            com.google.android.exoplayer2.extractor.mp4.Atom$LeafAtom r6 = (com.google.android.exoplayer2.extractor.mp4.Atom.LeafAtom) r6
            r8 = 1
            goto L_0x005b
        L_0x005a:
            r8 = 0
        L_0x005b:
            com.google.android.exoplayer2.util.ParsableByteArray r6 = r6.data
            r9 = 1937011555(0x73747363, float:1.9367382E31)
            com.google.android.exoplayer2.extractor.mp4.Atom$LeafAtom r9 = r0.getLeafAtomOfType(r9)
            java.lang.Object r9 = com.google.android.exoplayer2.util.Assertions.checkNotNull(r9)
            com.google.android.exoplayer2.extractor.mp4.Atom$LeafAtom r9 = (com.google.android.exoplayer2.extractor.mp4.Atom.LeafAtom) r9
            com.google.android.exoplayer2.util.ParsableByteArray r9 = r9.data
            r10 = 1937011827(0x73747473, float:1.9367711E31)
            com.google.android.exoplayer2.extractor.mp4.Atom$LeafAtom r10 = r0.getLeafAtomOfType(r10)
            java.lang.Object r10 = com.google.android.exoplayer2.util.Assertions.checkNotNull(r10)
            com.google.android.exoplayer2.extractor.mp4.Atom$LeafAtom r10 = (com.google.android.exoplayer2.extractor.mp4.Atom.LeafAtom) r10
            com.google.android.exoplayer2.util.ParsableByteArray r10 = r10.data
            r11 = 1937011571(0x73747373, float:1.9367401E31)
            com.google.android.exoplayer2.extractor.mp4.Atom$LeafAtom r11 = r0.getLeafAtomOfType(r11)
            if (r11 == 0) goto L_0x0087
            com.google.android.exoplayer2.util.ParsableByteArray r11 = r11.data
            goto L_0x0088
        L_0x0087:
            r11 = 0
        L_0x0088:
            r13 = 1668576371(0x63747473, float:4.5093966E21)
            com.google.android.exoplayer2.extractor.mp4.Atom$LeafAtom r0 = r0.getLeafAtomOfType(r13)
            if (r0 == 0) goto L_0x0094
            com.google.android.exoplayer2.util.ParsableByteArray r0 = r0.data
            goto L_0x0095
        L_0x0094:
            r0 = 0
        L_0x0095:
            com.google.android.exoplayer2.extractor.mp4.AtomParsers$ChunkIterator r13 = new com.google.android.exoplayer2.extractor.mp4.AtomParsers$ChunkIterator
            r13.<init>(r9, r6, r8)
            r6 = 12
            r10.setPosition(r6)
            int r8 = r10.readUnsignedIntToInt()
            int r8 = r8 - r7
            int r9 = r10.readUnsignedIntToInt()
            int r14 = r10.readUnsignedIntToInt()
            if (r0 == 0) goto L_0x00b6
            r0.setPosition(r6)
            int r15 = r0.readUnsignedIntToInt()
            goto L_0x00b7
        L_0x00b6:
            r15 = 0
        L_0x00b7:
            r12 = -1
            if (r11 == 0) goto L_0x00cc
            r11.setPosition(r6)
            int r6 = r11.readUnsignedIntToInt()
            if (r6 <= 0) goto L_0x00ca
            int r16 = r11.readUnsignedIntToInt()
            int r16 = r16 + -1
            goto L_0x00cf
        L_0x00ca:
            r11 = 0
            goto L_0x00cd
        L_0x00cc:
            r6 = 0
        L_0x00cd:
            r16 = -1
        L_0x00cf:
            int r5 = r4.getFixedSampleSize()
            com.google.android.exoplayer2.Format r7 = r1.format
            java.lang.String r7 = r7.sampleMimeType
            if (r5 == r12) goto L_0x00fc
            java.lang.String r12 = "audio/raw"
            boolean r12 = r12.equals(r7)
            if (r12 != 0) goto L_0x00f1
            java.lang.String r12 = "audio/g711-mlaw"
            boolean r12 = r12.equals(r7)
            if (r12 != 0) goto L_0x00f1
            java.lang.String r12 = "audio/g711-alaw"
            boolean r7 = r12.equals(r7)
            if (r7 == 0) goto L_0x00fc
        L_0x00f1:
            if (r8 != 0) goto L_0x00fc
            if (r15 != 0) goto L_0x00fc
            if (r6 != 0) goto L_0x00fc
            r37 = r8
            r12 = r9
            r7 = 1
            goto L_0x0100
        L_0x00fc:
            r37 = r8
            r12 = r9
            r7 = 0
        L_0x0100:
            if (r7 == 0) goto L_0x0137
            int r0 = r13.length
            long[] r0 = new long[r0]
            int r4 = r13.length
            int[] r4 = new int[r4]
        L_0x010a:
            boolean r6 = r13.moveNext()
            if (r6 == 0) goto L_0x011d
            int r6 = r13.index
            long r10 = r13.offset
            r0[r6] = r10
            int r6 = r13.index
            int r7 = r13.numSamples
            r4[r6] = r7
            goto L_0x010a
        L_0x011d:
            long r6 = (long) r14
            com.google.android.exoplayer2.extractor.mp4.FixedSampleSizeRechunker$Results r0 = com.google.android.exoplayer2.extractor.mp4.FixedSampleSizeRechunker.rechunk(r5, r0, r4, r6)
            long[] r4 = r0.offsets
            int[] r5 = r0.sizes
            int r6 = r0.maximumSize
            long[] r7 = r0.timestamps
            int[] r10 = r0.flags
            long r11 = r0.duration
            r0 = r3
            r2 = r4
            r3 = r5
            r5 = r7
            r14 = r10
            r15 = r11
            r4 = r1
            goto L_0x02ac
        L_0x0137:
            long[] r5 = new long[r3]
            int[] r7 = new int[r3]
            long[] r8 = new long[r3]
            int[] r9 = new int[r3]
            r22 = r10
            r2 = r16
            r1 = 0
            r10 = 0
            r19 = 0
            r20 = 0
            r21 = 0
            r23 = 0
            r25 = 0
            r16 = r15
            r15 = r14
            r14 = r12
        L_0x0153:
            java.lang.String r12 = "AtomParsers"
            if (r1 >= r3) goto L_0x021a
            r26 = r25
            r25 = r20
            r20 = 1
        L_0x015d:
            if (r25 != 0) goto L_0x017a
            boolean r20 = r13.moveNext()
            if (r20 == 0) goto L_0x017a
            r28 = r14
            r29 = r15
            long r14 = r13.offset
            r30 = r3
            int r3 = r13.numSamples
            r25 = r3
            r26 = r14
            r14 = r28
            r15 = r29
            r3 = r30
            goto L_0x015d
        L_0x017a:
            r30 = r3
            r28 = r14
            r29 = r15
            if (r20 != 0) goto L_0x019e
            java.lang.String r2 = "Unexpected end of chunk data"
            com.google.android.exoplayer2.util.Log.m358w(r12, r2)
            long[] r5 = java.util.Arrays.copyOf(r5, r1)
            int[] r7 = java.util.Arrays.copyOf(r7, r1)
            long[] r8 = java.util.Arrays.copyOf(r8, r1)
            int[] r9 = java.util.Arrays.copyOf(r9, r1)
            r3 = r1
            r2 = r19
            r1 = r25
            goto L_0x0222
        L_0x019e:
            if (r0 == 0) goto L_0x01b1
        L_0x01a0:
            if (r21 != 0) goto L_0x01af
            if (r16 <= 0) goto L_0x01af
            int r21 = r0.readUnsignedIntToInt()
            int r19 = r0.readInt()
            int r16 = r16 + -1
            goto L_0x01a0
        L_0x01af:
            int r21 = r21 + -1
        L_0x01b1:
            r3 = r19
            r5[r1] = r26
            int r12 = r4.readNextSampleSize()
            r7[r1] = r12
            r12 = r7[r1]
            if (r12 <= r10) goto L_0x01c1
            r10 = r7[r1]
        L_0x01c1:
            long r14 = (long) r3
            long r14 = r23 + r14
            r8[r1] = r14
            if (r11 != 0) goto L_0x01ca
            r12 = 1
            goto L_0x01cb
        L_0x01ca:
            r12 = 0
        L_0x01cb:
            r9[r1] = r12
            if (r1 != r2) goto L_0x01e1
            r12 = 1
            r9[r1] = r12
            int r6 = r6 + -1
            if (r6 <= 0) goto L_0x01e1
            java.lang.Object r2 = com.google.android.exoplayer2.util.Assertions.checkNotNull(r11)
            com.google.android.exoplayer2.util.ParsableByteArray r2 = (com.google.android.exoplayer2.util.ParsableByteArray) r2
            int r2 = r2.readUnsignedIntToInt()
            int r2 = r2 - r12
        L_0x01e1:
            r15 = r2
            r12 = r3
            r14 = r29
            long r2 = (long) r14
            long r23 = r23 + r2
            int r2 = r28 + -1
            if (r2 != 0) goto L_0x01f9
            if (r37 <= 0) goto L_0x01f9
            int r2 = r22.readUnsignedIntToInt()
            int r3 = r22.readInt()
            int r14 = r37 + -1
            goto L_0x01fc
        L_0x01f9:
            r3 = r14
            r14 = r37
        L_0x01fc:
            r37 = r2
            r2 = r7[r1]
            r19 = r3
            long r2 = (long) r2
            long r2 = r26 + r2
            int r20 = r25 + -1
            int r1 = r1 + 1
            r25 = r2
            r2 = r15
            r15 = r19
            r3 = r30
            r19 = r12
            r35 = r14
            r14 = r37
            r37 = r35
            goto L_0x0153
        L_0x021a:
            r30 = r3
            r28 = r14
            r2 = r19
            r1 = r20
        L_0x0222:
            long r13 = (long) r2
            long r13 = r23 + r13
            if (r0 == 0) goto L_0x0237
        L_0x0227:
            if (r16 <= 0) goto L_0x0237
            int r2 = r0.readUnsignedIntToInt()
            if (r2 == 0) goto L_0x0231
            r0 = 0
            goto L_0x0238
        L_0x0231:
            r0.readInt()
            int r16 = r16 + -1
            goto L_0x0227
        L_0x0237:
            r0 = 1
        L_0x0238:
            if (r6 != 0) goto L_0x024c
            if (r28 != 0) goto L_0x024c
            if (r1 != 0) goto L_0x024c
            if (r37 != 0) goto L_0x024c
            r2 = r21
            if (r2 != 0) goto L_0x024e
            if (r0 != 0) goto L_0x0247
            goto L_0x024e
        L_0x0247:
            r4 = r36
            r16 = r3
            goto L_0x02a4
        L_0x024c:
            r2 = r21
        L_0x024e:
            r4 = r36
            int r11 = r4.f512id
            if (r0 != 0) goto L_0x0257
            java.lang.String r0 = ", ctts invalid"
            goto L_0x0259
        L_0x0257:
            java.lang.String r0 = ""
        L_0x0259:
            int r15 = r0.length()
            int r15 = r15 + 262
            r16 = r3
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>(r15)
            java.lang.String r15 = "Inconsistent stbl box for track "
            r3.append(r15)
            r3.append(r11)
            java.lang.String r11 = ": remainingSynchronizationSamples "
            r3.append(r11)
            r3.append(r6)
            java.lang.String r6 = ", remainingSamplesAtTimestampDelta "
            r3.append(r6)
            r6 = r28
            r3.append(r6)
            java.lang.String r6 = ", remainingSamplesInChunk "
            r3.append(r6)
            r3.append(r1)
            java.lang.String r1 = ", remainingTimestampDeltaChanges "
            r3.append(r1)
            r1 = r37
            r3.append(r1)
            java.lang.String r1 = ", remainingSamplesAtTimestampOffset "
            r3.append(r1)
            r3.append(r2)
            r3.append(r0)
            java.lang.String r0 = r3.toString()
            com.google.android.exoplayer2.util.Log.m358w(r12, r0)
        L_0x02a4:
            r2 = r5
            r3 = r7
            r5 = r8
            r6 = r10
            r0 = r16
            r15 = r13
            r14 = r9
        L_0x02ac:
            r9 = 1000000(0xf4240, double:4.940656E-318)
            long r11 = r4.timescale
            r7 = r15
            long r7 = com.google.android.exoplayer2.util.Util.scaleLargeTimestamp(r7, r9, r11)
            long[] r1 = r4.editListDurations
            r12 = 1000000(0xf4240, double:4.940656E-318)
            if (r1 != 0) goto L_0x02cd
            long r0 = r4.timescale
            com.google.android.exoplayer2.util.Util.scaleLargeTimestampsInPlace(r5, r12, r0)
            com.google.android.exoplayer2.extractor.mp4.TrackSampleTable r9 = new com.google.android.exoplayer2.extractor.mp4.TrackSampleTable
            r0 = r9
            r1 = r36
            r4 = r6
            r6 = r14
            r0.<init>(r1, r2, r3, r4, r5, r6, r7)
            return r9
        L_0x02cd:
            long[] r1 = r4.editListDurations
            int r1 = r1.length
            r7 = 1
            if (r1 != r7) goto L_0x036d
            int r1 = r4.type
            if (r1 != r7) goto L_0x036d
            int r1 = r5.length
            r7 = 2
            if (r1 < r7) goto L_0x036d
            long[] r1 = r4.editListMediaTimes
            java.lang.Object r1 = com.google.android.exoplayer2.util.Assertions.checkNotNull(r1)
            long[] r1 = (long[]) r1
            r7 = 0
            r19 = r1[r7]
            long[] r1 = r4.editListDurations
            r21 = r1[r7]
            long r7 = r4.timescale
            long r9 = r4.movieTimescale
            r23 = r7
            r25 = r9
            long r7 = com.google.android.exoplayer2.util.Util.scaleLargeTimestamp(r21, r23, r25)
            long r21 = r19 + r7
            r7 = r5
            r8 = r15
            r10 = r19
            r23 = r0
            r0 = r12
            r12 = r21
            boolean r7 = canApplyEditWithGaplessInfo(r7, r8, r10, r12)
            if (r7 == 0) goto L_0x036f
            long r8 = r15 - r21
            r7 = 0
            r10 = r5[r7]
            long r24 = r19 - r10
            com.google.android.exoplayer2.Format r7 = r4.format
            int r7 = r7.sampleRate
            long r10 = (long) r7
            long r12 = r4.timescale
            r26 = r10
            r28 = r12
            long r12 = com.google.android.exoplayer2.util.Util.scaleLargeTimestamp(r24, r26, r28)
            com.google.android.exoplayer2.Format r7 = r4.format
            int r7 = r7.sampleRate
            long r10 = (long) r7
            long r0 = r4.timescale
            r37 = r14
            r21 = r15
            r14 = r12
            r12 = r0
            long r0 = com.google.android.exoplayer2.util.Util.scaleLargeTimestamp(r8, r10, r12)
            r7 = 0
            int r9 = (r14 > r7 ? 1 : (r14 == r7 ? 0 : -1))
            if (r9 != 0) goto L_0x0338
            int r9 = (r0 > r7 ? 1 : (r0 == r7 ? 0 : -1))
            if (r9 == 0) goto L_0x0373
        L_0x0338:
            r7 = 2147483647(0x7fffffff, double:1.060997895E-314)
            int r9 = (r14 > r7 ? 1 : (r14 == r7 ? 0 : -1))
            if (r9 > 0) goto L_0x0373
            int r9 = (r0 > r7 ? 1 : (r0 == r7 ? 0 : -1))
            if (r9 > 0) goto L_0x0373
            int r7 = (int) r14
            r8 = r38
            r8.encoderDelay = r7
            int r1 = (int) r0
            r8.encoderPadding = r1
            long r0 = r4.timescale
            r7 = 1000000(0xf4240, double:4.940656E-318)
            com.google.android.exoplayer2.util.Util.scaleLargeTimestampsInPlace(r5, r7, r0)
            long[] r0 = r4.editListDurations
            r1 = 0
            r7 = r0[r1]
            r9 = 1000000(0xf4240, double:4.940656E-318)
            long r11 = r4.movieTimescale
            long r7 = com.google.android.exoplayer2.util.Util.scaleLargeTimestamp(r7, r9, r11)
            com.google.android.exoplayer2.extractor.mp4.TrackSampleTable r9 = new com.google.android.exoplayer2.extractor.mp4.TrackSampleTable
            r0 = r9
            r1 = r36
            r4 = r6
            r6 = r37
            r0.<init>(r1, r2, r3, r4, r5, r6, r7)
            return r9
        L_0x036d:
            r23 = r0
        L_0x036f:
            r37 = r14
            r21 = r15
        L_0x0373:
            long[] r0 = r4.editListDurations
            int r0 = r0.length
            r1 = 1
            if (r0 != r1) goto L_0x03bc
            long[] r0 = r4.editListDurations
            r1 = 0
            r7 = r0[r1]
            r9 = 0
            int r0 = (r7 > r9 ? 1 : (r7 == r9 ? 0 : -1))
            if (r0 != 0) goto L_0x03bc
            long[] r0 = r4.editListMediaTimes
            java.lang.Object r0 = com.google.android.exoplayer2.util.Assertions.checkNotNull(r0)
            long[] r0 = (long[]) r0
            r7 = r0[r1]
            r0 = 0
        L_0x038f:
            int r1 = r5.length
            if (r0 >= r1) goto L_0x03a5
            r9 = r5[r0]
            long r11 = r9 - r7
            r13 = 1000000(0xf4240, double:4.940656E-318)
            long r9 = r4.timescale
            r15 = r9
            long r9 = com.google.android.exoplayer2.util.Util.scaleLargeTimestamp(r11, r13, r15)
            r5[r0] = r9
            int r0 = r0 + 1
            goto L_0x038f
        L_0x03a5:
            long r9 = r21 - r7
            r11 = 1000000(0xf4240, double:4.940656E-318)
            long r13 = r4.timescale
            long r7 = com.google.android.exoplayer2.util.Util.scaleLargeTimestamp(r9, r11, r13)
            com.google.android.exoplayer2.extractor.mp4.TrackSampleTable r9 = new com.google.android.exoplayer2.extractor.mp4.TrackSampleTable
            r0 = r9
            r1 = r36
            r4 = r6
            r6 = r37
            r0.<init>(r1, r2, r3, r4, r5, r6, r7)
            return r9
        L_0x03bc:
            int r0 = r4.type
            r1 = 1
            if (r0 != r1) goto L_0x03c3
            r12 = 1
            goto L_0x03c4
        L_0x03c3:
            r12 = 0
        L_0x03c4:
            long[] r0 = r4.editListDurations
            int r0 = r0.length
            int[] r0 = new int[r0]
            long[] r1 = r4.editListDurations
            int r1 = r1.length
            int[] r1 = new int[r1]
            long[] r7 = r4.editListMediaTimes
            java.lang.Object r7 = com.google.android.exoplayer2.util.Assertions.checkNotNull(r7)
            long[] r7 = (long[]) r7
            r8 = 0
            r9 = 0
            r10 = 0
            r11 = 0
        L_0x03da:
            long[] r13 = r4.editListDurations
            int r13 = r13.length
            if (r8 >= r13) goto L_0x0446
            r13 = r7[r8]
            r15 = -1
            int r19 = (r13 > r15 ? 1 : (r13 == r15 ? 0 : -1))
            if (r19 == 0) goto L_0x0433
            long[] r15 = r4.editListDurations
            r24 = r15[r8]
            r15 = r6
            r38 = r7
            long r6 = r4.timescale
            r16 = r2
            r19 = r3
            long r2 = r4.movieTimescale
            r26 = r6
            r28 = r2
            long r2 = com.google.android.exoplayer2.util.Util.scaleLargeTimestamp(r24, r26, r28)
            r6 = 1
            int r7 = com.google.android.exoplayer2.util.Util.binarySearchFloor((long[]) r5, (long) r13, (boolean) r6, (boolean) r6)
            r0[r8] = r7
            long r13 = r13 + r2
            r2 = 0
            int r3 = com.google.android.exoplayer2.util.Util.binarySearchCeil((long[]) r5, (long) r13, (boolean) r12, (boolean) r2)
            r1[r8] = r3
        L_0x040d:
            r3 = r0[r8]
            r7 = r1[r8]
            if (r3 >= r7) goto L_0x0420
            r3 = r0[r8]
            r3 = r37[r3]
            r3 = r3 & r6
            if (r3 != 0) goto L_0x0420
            r3 = r0[r8]
            int r3 = r3 + r6
            r0[r8] = r3
            goto L_0x040d
        L_0x0420:
            r3 = r1[r8]
            r7 = r0[r8]
            int r3 = r3 - r7
            int r10 = r10 + r3
            r3 = r0[r8]
            if (r11 == r3) goto L_0x042c
            r3 = 1
            goto L_0x042d
        L_0x042c:
            r3 = 0
        L_0x042d:
            r3 = r3 | r9
            r7 = r1[r8]
            r9 = r3
            r11 = r7
            goto L_0x043c
        L_0x0433:
            r16 = r2
            r19 = r3
            r15 = r6
            r38 = r7
            r2 = 0
            r6 = 1
        L_0x043c:
            int r8 = r8 + 1
            r7 = r38
            r6 = r15
            r2 = r16
            r3 = r19
            goto L_0x03da
        L_0x0446:
            r16 = r2
            r19 = r3
            r15 = r6
            r3 = r23
            r2 = 0
            r6 = 1
            if (r10 == r3) goto L_0x0453
            r7 = 1
            goto L_0x0454
        L_0x0453:
            r7 = 0
        L_0x0454:
            r3 = r9 | r7
            if (r3 == 0) goto L_0x045b
            long[] r6 = new long[r10]
            goto L_0x045d
        L_0x045b:
            r6 = r16
        L_0x045d:
            if (r3 == 0) goto L_0x0462
            int[] r7 = new int[r10]
            goto L_0x0464
        L_0x0462:
            r7 = r19
        L_0x0464:
            if (r3 == 0) goto L_0x0467
            r15 = 0
        L_0x0467:
            if (r3 == 0) goto L_0x046c
            int[] r8 = new int[r10]
            goto L_0x046e
        L_0x046c:
            r8 = r37
        L_0x046e:
            long[] r9 = new long[r10]
            r10 = 0
            r11 = 0
        L_0x0473:
            long[] r13 = r4.editListDurations
            int r13 = r13.length
            if (r2 >= r13) goto L_0x050e
            long[] r13 = r4.editListMediaTimes
            r17 = r13[r2]
            r13 = r0[r2]
            r14 = r1[r2]
            r26 = r0
            if (r3 == 0) goto L_0x049a
            int r0 = r14 - r13
            r27 = r1
            r1 = r16
            java.lang.System.arraycopy(r1, r13, r6, r10, r0)
            r1 = r19
            java.lang.System.arraycopy(r1, r13, r7, r10, r0)
            r38 = r15
            r15 = r37
            java.lang.System.arraycopy(r15, r13, r8, r10, r0)
            goto L_0x04a2
        L_0x049a:
            r27 = r1
            r38 = r15
            r1 = r19
            r15 = r37
        L_0x04a2:
            r0 = r38
        L_0x04a4:
            if (r13 >= r14) goto L_0x04ec
            r22 = 1000000(0xf4240, double:4.940656E-318)
            r37 = r14
            r19 = r15
            long r14 = r4.movieTimescale
            r20 = r11
            r24 = r14
            long r14 = com.google.android.exoplayer2.util.Util.scaleLargeTimestamp(r20, r22, r24)
            r20 = r5[r13]
            r22 = r5
            r28 = r6
            long r5 = r20 - r17
            r20 = r11
            r11 = 0
            long r29 = java.lang.Math.max(r11, r5)
            r31 = 1000000(0xf4240, double:4.940656E-318)
            long r5 = r4.timescale
            r33 = r5
            long r5 = com.google.android.exoplayer2.util.Util.scaleLargeTimestamp(r29, r31, r33)
            long r14 = r14 + r5
            r9[r10] = r14
            if (r3 == 0) goto L_0x04dd
            r5 = r7[r10]
            if (r5 <= r0) goto L_0x04dd
            r0 = r1[r13]
        L_0x04dd:
            int r10 = r10 + 1
            int r13 = r13 + 1
            r14 = r37
            r15 = r19
            r11 = r20
            r5 = r22
            r6 = r28
            goto L_0x04a4
        L_0x04ec:
            r22 = r5
            r28 = r6
            r20 = r11
            r19 = r15
            r11 = 0
            long[] r5 = r4.editListDurations
            r13 = r5[r2]
            long r5 = r20 + r13
            int r2 = r2 + 1
            r15 = r0
            r11 = r5
            r37 = r19
            r5 = r22
            r0 = r26
            r6 = r28
            r19 = r1
            r1 = r27
            goto L_0x0473
        L_0x050e:
            r28 = r6
            r20 = r11
            r38 = r15
            r22 = 1000000(0xf4240, double:4.940656E-318)
            long r0 = r4.movieTimescale
            r24 = r0
            long r10 = com.google.android.exoplayer2.util.Util.scaleLargeTimestamp(r20, r22, r24)
            com.google.android.exoplayer2.extractor.mp4.TrackSampleTable r12 = new com.google.android.exoplayer2.extractor.mp4.TrackSampleTable
            r0 = r12
            r1 = r36
            r2 = r28
            r3 = r7
            r4 = r38
            r5 = r9
            r6 = r8
            r7 = r10
            r0.<init>(r1, r2, r3, r4, r5, r6, r7)
            return r12
        L_0x0530:
            com.google.android.exoplayer2.ParserException r0 = new com.google.android.exoplayer2.ParserException
            java.lang.String r1 = "Track has no sample table size information"
            r0.<init>((java.lang.String) r1)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.extractor.mp4.AtomParsers.parseStbl(com.google.android.exoplayer2.extractor.mp4.Track, com.google.android.exoplayer2.extractor.mp4.Atom$ContainerAtom, com.google.android.exoplayer2.extractor.GaplessInfoHolder):com.google.android.exoplayer2.extractor.mp4.TrackSampleTable");
    }

    private static Metadata parseUdtaMeta(ParsableByteArray parsableByteArray, int i) {
        parsableByteArray.skipBytes(12);
        while (parsableByteArray.getPosition() < i) {
            int position = parsableByteArray.getPosition();
            int readInt = parsableByteArray.readInt();
            if (parsableByteArray.readInt() == 1768715124) {
                parsableByteArray.setPosition(position);
                return parseIlst(parsableByteArray, position + readInt);
            }
            parsableByteArray.setPosition(position + readInt);
        }
        return null;
    }

    private static Metadata parseIlst(ParsableByteArray parsableByteArray, int i) {
        parsableByteArray.skipBytes(8);
        ArrayList arrayList = new ArrayList();
        while (parsableByteArray.getPosition() < i) {
            Metadata.Entry parseIlstElement = MetadataUtil.parseIlstElement(parsableByteArray);
            if (parseIlstElement != null) {
                arrayList.add(parseIlstElement);
            }
        }
        if (arrayList.isEmpty()) {
            return null;
        }
        return new Metadata((List<? extends Metadata.Entry>) arrayList);
    }

    private static long parseMvhd(ParsableByteArray parsableByteArray) {
        int i = 8;
        parsableByteArray.setPosition(8);
        if (Atom.parseFullAtomVersion(parsableByteArray.readInt()) != 0) {
            i = 16;
        }
        parsableByteArray.skipBytes(i);
        return parsableByteArray.readUnsignedInt();
    }

    private static TkhdData parseTkhd(ParsableByteArray parsableByteArray) {
        boolean z;
        int i = 8;
        parsableByteArray.setPosition(8);
        int parseFullAtomVersion = Atom.parseFullAtomVersion(parsableByteArray.readInt());
        parsableByteArray.skipBytes(parseFullAtomVersion == 0 ? 8 : 16);
        int readInt = parsableByteArray.readInt();
        parsableByteArray.skipBytes(4);
        int position = parsableByteArray.getPosition();
        if (parseFullAtomVersion == 0) {
            i = 4;
        }
        int i2 = 0;
        int i3 = 0;
        while (true) {
            if (i3 >= i) {
                z = true;
                break;
            } else if (parsableByteArray.getData()[position + i3] != -1) {
                z = false;
                break;
            } else {
                i3++;
            }
        }
        long j = C1844C.TIME_UNSET;
        if (z) {
            parsableByteArray.skipBytes(i);
        } else {
            long readUnsignedInt = parseFullAtomVersion == 0 ? parsableByteArray.readUnsignedInt() : parsableByteArray.readUnsignedLongToLong();
            if (readUnsignedInt != 0) {
                j = readUnsignedInt;
            }
        }
        parsableByteArray.skipBytes(16);
        int readInt2 = parsableByteArray.readInt();
        int readInt3 = parsableByteArray.readInt();
        parsableByteArray.skipBytes(4);
        int readInt4 = parsableByteArray.readInt();
        int readInt5 = parsableByteArray.readInt();
        if (readInt2 == 0 && readInt3 == 65536 && readInt4 == -65536 && readInt5 == 0) {
            i2 = 90;
        } else if (readInt2 == 0 && readInt3 == -65536 && readInt4 == 65536 && readInt5 == 0) {
            i2 = RotationOptions.ROTATE_270;
        } else if (readInt2 == -65536 && readInt3 == 0 && readInt4 == 0 && readInt5 == -65536) {
            i2 = RotationOptions.ROTATE_180;
        }
        return new TkhdData(readInt, j, i2);
    }

    private static int parseHdlr(ParsableByteArray parsableByteArray) {
        parsableByteArray.setPosition(16);
        return parsableByteArray.readInt();
    }

    private static Pair<Long, String> parseMdhd(ParsableByteArray parsableByteArray) {
        int i = 8;
        parsableByteArray.setPosition(8);
        int parseFullAtomVersion = Atom.parseFullAtomVersion(parsableByteArray.readInt());
        parsableByteArray.skipBytes(parseFullAtomVersion == 0 ? 8 : 16);
        long readUnsignedInt = parsableByteArray.readUnsignedInt();
        if (parseFullAtomVersion == 0) {
            i = 4;
        }
        parsableByteArray.skipBytes(i);
        int readUnsignedShort = parsableByteArray.readUnsignedShort();
        StringBuilder sb = new StringBuilder(3);
        sb.append((char) (((readUnsignedShort >> 10) & 31) + 96));
        sb.append((char) (((readUnsignedShort >> 5) & 31) + 96));
        sb.append((char) ((readUnsignedShort & 31) + 96));
        return Pair.create(Long.valueOf(readUnsignedInt), sb.toString());
    }

    private static StsdData parseStsd(ParsableByteArray parsableByteArray, int i, int i2, String str, DrmInitData drmInitData, boolean z) throws ParserException {
        int i3;
        ParsableByteArray parsableByteArray2 = parsableByteArray;
        int i4 = i;
        parsableByteArray2.setPosition(12);
        int readInt = parsableByteArray.readInt();
        StsdData stsdData = new StsdData(readInt);
        for (int i5 = 0; i5 < readInt; i5++) {
            int position = parsableByteArray.getPosition();
            int readInt2 = parsableByteArray.readInt();
            Assertions.checkState(readInt2 > 0, "childAtomSize should be positive");
            int readInt3 = parsableByteArray.readInt();
            if (readInt3 == 1635148593 || readInt3 == 1635148595 || readInt3 == 1701733238 || readInt3 == 1836070006 || readInt3 == 1752589105 || readInt3 == 1751479857 || readInt3 == 1932670515 || readInt3 == 1987063864 || readInt3 == 1987063865 || readInt3 == 1635135537 || readInt3 == 1685479798 || readInt3 == 1685479729 || readInt3 == 1685481573 || readInt3 == 1685481521) {
                i3 = position;
                parseVideoSampleEntry(parsableByteArray, readInt3, i3, readInt2, i, i2, drmInitData, stsdData, i5);
            } else if (readInt3 == 1836069985 || readInt3 == 1701733217 || readInt3 == 1633889587 || readInt3 == 1700998451 || readInt3 == 1633889588 || readInt3 == 1685353315 || readInt3 == 1685353317 || readInt3 == 1685353320 || readInt3 == 1685353324 || readInt3 == 1935764850 || readInt3 == 1935767394 || readInt3 == 1819304813 || readInt3 == 1936684916 || readInt3 == 1953984371 || readInt3 == 778924082 || readInt3 == 778924083 || readInt3 == 1634492771 || readInt3 == 1634492791 || readInt3 == 1970037111 || readInt3 == 1332770163 || readInt3 == 1716281667) {
                i3 = position;
                parseAudioSampleEntry(parsableByteArray, readInt3, position, readInt2, i, str, z, drmInitData, stsdData, i5);
            } else {
                if (readInt3 == 1414810956 || readInt3 == 1954034535 || readInt3 == 2004251764 || readInt3 == 1937010800 || readInt3 == 1664495672) {
                    parseTextSampleEntry(parsableByteArray, readInt3, position, readInt2, i, str, stsdData);
                } else if (readInt3 == 1835365492) {
                    parseMetaDataSampleEntry(parsableByteArray2, readInt3, position, i4, stsdData);
                } else if (readInt3 == 1667329389) {
                    stsdData.format = new Format.Builder().setId(i4).setSampleMimeType(MimeTypes.APPLICATION_CAMERA_MOTION).build();
                }
                i3 = position;
            }
            parsableByteArray2.setPosition(i3 + readInt2);
        }
        return stsdData;
    }

    private static void parseTextSampleEntry(ParsableByteArray parsableByteArray, int i, int i2, int i3, int i4, String str, StsdData stsdData) {
        parsableByteArray.setPosition(i2 + 8 + 8);
        String str2 = MimeTypes.APPLICATION_TTML;
        ImmutableList immutableList = null;
        long j = Long.MAX_VALUE;
        if (i != 1414810956) {
            if (i == 1954034535) {
                int i5 = (i3 - 8) - 8;
                byte[] bArr = new byte[i5];
                parsableByteArray.readBytes(bArr, 0, i5);
                immutableList = ImmutableList.m434of(bArr);
                str2 = MimeTypes.APPLICATION_TX3G;
            } else if (i == 2004251764) {
                str2 = MimeTypes.APPLICATION_MP4VTT;
            } else if (i == 1937010800) {
                j = 0;
            } else if (i == 1664495672) {
                stsdData.requiredSampleTransformation = 1;
                str2 = MimeTypes.APPLICATION_MP4CEA608;
            } else {
                throw new IllegalStateException();
            }
        }
        stsdData.format = new Format.Builder().setId(i4).setSampleMimeType(str2).setLanguage(str).setSubsampleOffsetUs(j).setInitializationData(immutableList).build();
    }

    private static void parseVideoSampleEntry(ParsableByteArray parsableByteArray, int i, int i2, int i3, int i4, int i5, DrmInitData drmInitData, StsdData stsdData, int i6) throws ParserException {
        DrmInitData drmInitData2;
        List<byte[]> list;
        List<byte[]> list2;
        String str;
        String str2;
        ParsableByteArray parsableByteArray2 = parsableByteArray;
        int i7 = i2;
        int i8 = i3;
        DrmInitData drmInitData3 = drmInitData;
        StsdData stsdData2 = stsdData;
        parsableByteArray2.setPosition(i7 + 8 + 8);
        parsableByteArray2.skipBytes(16);
        int readUnsignedShort = parsableByteArray.readUnsignedShort();
        int readUnsignedShort2 = parsableByteArray.readUnsignedShort();
        parsableByteArray2.skipBytes(50);
        int position = parsableByteArray.getPosition();
        String str3 = null;
        int i9 = i;
        if (i9 == 1701733238) {
            Pair<Integer, TrackEncryptionBox> parseSampleEntryEncryptionData = parseSampleEntryEncryptionData(parsableByteArray2, i7, i8);
            if (parseSampleEntryEncryptionData != null) {
                i9 = ((Integer) parseSampleEntryEncryptionData.first).intValue();
                if (drmInitData3 == null) {
                    drmInitData3 = null;
                } else {
                    drmInitData3 = drmInitData3.copyWithSchemeType(((TrackEncryptionBox) parseSampleEntryEncryptionData.second).schemeType);
                }
                stsdData2.trackEncryptionBoxes[i6] = (TrackEncryptionBox) parseSampleEntryEncryptionData.second;
            }
            parsableByteArray2.setPosition(position);
        }
        byte[] bArr = null;
        List<byte[]> list3 = null;
        String str4 = null;
        int i10 = -1;
        float f = 1.0f;
        boolean z = false;
        while (true) {
            if (position - i7 >= i8) {
                drmInitData2 = drmInitData3;
                list = list3;
                break;
            }
            parsableByteArray2.setPosition(position);
            int position2 = parsableByteArray.getPosition();
            drmInitData2 = drmInitData3;
            int readInt = parsableByteArray.readInt();
            if (readInt == 0) {
                list = list3;
                if (parsableByteArray.getPosition() - i7 == i8) {
                    break;
                }
            } else {
                list = list3;
            }
            Assertions.checkState(readInt > 0, "childAtomSize should be positive");
            int readInt2 = parsableByteArray.readInt();
            if (readInt2 == 1635148611) {
                Assertions.checkState(str4 == null);
                parsableByteArray2.setPosition(position2 + 8);
                AvcConfig parse = AvcConfig.parse(parsableByteArray);
                list2 = parse.initializationData;
                stsdData2.nalUnitLengthFieldLength = parse.nalUnitLengthFieldLength;
                if (!z) {
                    f = parse.pixelWidthAspectRatio;
                }
                str = MimeTypes.VIDEO_H264;
            } else if (readInt2 == 1752589123) {
                Assertions.checkState(str4 == null);
                parsableByteArray2.setPosition(position2 + 8);
                HevcConfig parse2 = HevcConfig.parse(parsableByteArray);
                list2 = parse2.initializationData;
                stsdData2.nalUnitLengthFieldLength = parse2.nalUnitLengthFieldLength;
                str = MimeTypes.VIDEO_H265;
            } else {
                if (readInt2 == 1685480259 || readInt2 == 1685485123) {
                    DolbyVisionConfig parse3 = DolbyVisionConfig.parse(parsableByteArray);
                    if (parse3 != null) {
                        str3 = parse3.codecs;
                        str4 = MimeTypes.VIDEO_DOLBY_VISION;
                    }
                } else {
                    if (readInt2 == 1987076931) {
                        Assertions.checkState(str4 == null);
                        str2 = i9 == 1987063864 ? MimeTypes.VIDEO_VP8 : MimeTypes.VIDEO_VP9;
                    } else if (readInt2 == 1635135811) {
                        Assertions.checkState(str4 == null);
                        str2 = MimeTypes.VIDEO_AV1;
                    } else if (readInt2 == 1681012275) {
                        Assertions.checkState(str4 == null);
                        str2 = MimeTypes.VIDEO_H263;
                    } else {
                        if (readInt2 == 1702061171) {
                            Assertions.checkState(str4 == null);
                            Pair<String, byte[]> parseEsdsFromParent = parseEsdsFromParent(parsableByteArray2, position2);
                            String str5 = (String) parseEsdsFromParent.first;
                            byte[] bArr2 = (byte[]) parseEsdsFromParent.second;
                            list3 = bArr2 != null ? ImmutableList.m434of(bArr2) : list;
                            str4 = str5;
                        } else if (readInt2 == 1885434736) {
                            list3 = list;
                            f = parsePaspFromParent(parsableByteArray2, position2);
                            z = true;
                        } else if (readInt2 == 1937126244) {
                            list3 = list;
                            bArr = parseProjFromParent(parsableByteArray2, position2, readInt);
                        } else if (readInt2 == 1936995172) {
                            int readUnsignedByte = parsableByteArray.readUnsignedByte();
                            parsableByteArray2.skipBytes(3);
                            if (readUnsignedByte == 0) {
                                int readUnsignedByte2 = parsableByteArray.readUnsignedByte();
                                if (readUnsignedByte2 == 0) {
                                    list3 = list;
                                    i10 = 0;
                                } else if (readUnsignedByte2 == 1) {
                                    list3 = list;
                                    i10 = 1;
                                } else if (readUnsignedByte2 == 2) {
                                    list3 = list;
                                    i10 = 2;
                                } else if (readUnsignedByte2 == 3) {
                                    list3 = list;
                                    i10 = 3;
                                }
                            }
                        }
                        position += readInt;
                        i7 = i2;
                        i8 = i3;
                        drmInitData3 = drmInitData2;
                    }
                    list3 = list;
                    str4 = str2;
                    position += readInt;
                    i7 = i2;
                    i8 = i3;
                    drmInitData3 = drmInitData2;
                }
                list3 = list;
                position += readInt;
                i7 = i2;
                i8 = i3;
                drmInitData3 = drmInitData2;
            }
            str4 = str;
            list3 = list2;
            position += readInt;
            i7 = i2;
            i8 = i3;
            drmInitData3 = drmInitData2;
        }
        if (str4 != null) {
            stsdData2.format = new Format.Builder().setId(i4).setSampleMimeType(str4).setCodecs(str3).setWidth(readUnsignedShort).setHeight(readUnsignedShort2).setPixelWidthHeightRatio(f).setRotationDegrees(i5).setProjectionData(bArr).setStereoMode(i10).setInitializationData(list).setDrmInitData(drmInitData2).build();
        }
    }

    private static void parseMetaDataSampleEntry(ParsableByteArray parsableByteArray, int i, int i2, int i3, StsdData stsdData) {
        parsableByteArray.setPosition(i2 + 8 + 8);
        if (i == 1835365492) {
            parsableByteArray.readNullTerminatedString();
            String readNullTerminatedString = parsableByteArray.readNullTerminatedString();
            if (readNullTerminatedString != null) {
                stsdData.format = new Format.Builder().setId(i3).setSampleMimeType(readNullTerminatedString).build();
            }
        }
    }

    private static Pair<long[], long[]> parseEdts(Atom.ContainerAtom containerAtom) {
        Atom.LeafAtom leafAtomOfType = containerAtom.getLeafAtomOfType(Atom.TYPE_elst);
        if (leafAtomOfType == null) {
            return null;
        }
        ParsableByteArray parsableByteArray = leafAtomOfType.data;
        parsableByteArray.setPosition(8);
        int parseFullAtomVersion = Atom.parseFullAtomVersion(parsableByteArray.readInt());
        int readUnsignedIntToInt = parsableByteArray.readUnsignedIntToInt();
        long[] jArr = new long[readUnsignedIntToInt];
        long[] jArr2 = new long[readUnsignedIntToInt];
        int i = 0;
        while (i < readUnsignedIntToInt) {
            jArr[i] = parseFullAtomVersion == 1 ? parsableByteArray.readUnsignedLongToLong() : parsableByteArray.readUnsignedInt();
            jArr2[i] = parseFullAtomVersion == 1 ? parsableByteArray.readLong() : (long) parsableByteArray.readInt();
            if (parsableByteArray.readShort() == 1) {
                parsableByteArray.skipBytes(2);
                i++;
            } else {
                throw new IllegalArgumentException("Unsupported media rate.");
            }
        }
        return Pair.create(jArr, jArr2);
    }

    private static float parsePaspFromParent(ParsableByteArray parsableByteArray, int i) {
        parsableByteArray.setPosition(i + 8);
        return ((float) parsableByteArray.readUnsignedIntToInt()) / ((float) parsableByteArray.readUnsignedIntToInt());
    }

    /* JADX WARNING: type inference failed for: r1v19, types: [java.util.List] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:132:0x0299 A[ADDED_TO_REGION] */
    /* JADX WARNING: Removed duplicated region for block: B:142:? A[ADDED_TO_REGION, RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:84:0x0136  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static void parseAudioSampleEntry(com.google.android.exoplayer2.util.ParsableByteArray r20, int r21, int r22, int r23, int r24, java.lang.String r25, boolean r26, com.google.android.exoplayer2.drm.DrmInitData r27, com.google.android.exoplayer2.extractor.mp4.AtomParsers.StsdData r28, int r29) throws com.google.android.exoplayer2.ParserException {
        /*
            r0 = r20
            r1 = r22
            r2 = r23
            r3 = r24
            r4 = r25
            r5 = r27
            r6 = r28
            int r7 = r1 + 8
            r8 = 8
            int r7 = r7 + r8
            r0.setPosition(r7)
            r7 = 6
            if (r26 == 0) goto L_0x0021
            int r8 = r20.readUnsignedShort()
            r0.skipBytes(r7)
            goto L_0x0025
        L_0x0021:
            r0.skipBytes(r8)
            r8 = 0
        L_0x0025:
            r10 = 16
            r11 = 2
            r12 = 1
            if (r8 == 0) goto L_0x0047
            if (r8 != r12) goto L_0x002e
            goto L_0x0047
        L_0x002e:
            if (r8 != r11) goto L_0x0046
            r0.skipBytes(r10)
            double r7 = r20.readDouble()
            long r7 = java.lang.Math.round(r7)
            int r8 = (int) r7
            int r7 = r20.readUnsignedIntToInt()
            r10 = 20
            r0.skipBytes(r10)
            goto L_0x0059
        L_0x0046:
            return
        L_0x0047:
            int r13 = r20.readUnsignedShort()
            r0.skipBytes(r7)
            int r7 = r20.readUnsignedFixedPoint1616()
            if (r8 != r12) goto L_0x0057
            r0.skipBytes(r10)
        L_0x0057:
            r8 = r7
            r7 = r13
        L_0x0059:
            int r10 = r20.getPosition()
            r13 = 1701733217(0x656e6361, float:7.0359778E22)
            r15 = r21
            if (r15 != r13) goto L_0x008f
            android.util.Pair r13 = parseSampleEntryEncryptionData(r0, r1, r2)
            if (r13 == 0) goto L_0x008a
            java.lang.Object r15 = r13.first
            java.lang.Integer r15 = (java.lang.Integer) r15
            int r15 = r15.intValue()
            if (r5 != 0) goto L_0x0076
            r14 = 0
            goto L_0x0081
        L_0x0076:
            java.lang.Object r14 = r13.second
            com.google.android.exoplayer2.extractor.mp4.TrackEncryptionBox r14 = (com.google.android.exoplayer2.extractor.mp4.TrackEncryptionBox) r14
            java.lang.String r14 = r14.schemeType
            com.google.android.exoplayer2.drm.DrmInitData r5 = r5.copyWithSchemeType(r14)
            r14 = r5
        L_0x0081:
            com.google.android.exoplayer2.extractor.mp4.TrackEncryptionBox[] r5 = r6.trackEncryptionBoxes
            java.lang.Object r13 = r13.second
            com.google.android.exoplayer2.extractor.mp4.TrackEncryptionBox r13 = (com.google.android.exoplayer2.extractor.mp4.TrackEncryptionBox) r13
            r5[r29] = r13
            goto L_0x008b
        L_0x008a:
            r14 = r5
        L_0x008b:
            r0.setPosition(r10)
            goto L_0x0090
        L_0x008f:
            r14 = r5
        L_0x0090:
            r5 = 1633889587(0x61632d33, float:2.6191674E20)
            r13 = 1634492771(0x616c6163, float:2.7252807E20)
            java.lang.String r17 = "audio/raw"
            if (r15 != r5) goto L_0x009f
            java.lang.String r17 = "audio/ac3"
        L_0x009c:
            r5 = -1
            goto L_0x012d
        L_0x009f:
            r5 = 1700998451(0x65632d33, float:6.7050686E22)
            if (r15 != r5) goto L_0x00a7
            java.lang.String r17 = "audio/eac3"
            goto L_0x009c
        L_0x00a7:
            r5 = 1633889588(0x61632d34, float:2.6191676E20)
            if (r15 != r5) goto L_0x00af
            java.lang.String r17 = "audio/ac4"
            goto L_0x009c
        L_0x00af:
            r5 = 1685353315(0x64747363, float:1.803728E22)
            if (r15 != r5) goto L_0x00b7
            java.lang.String r17 = "audio/vnd.dts"
            goto L_0x009c
        L_0x00b7:
            r5 = 1685353320(0x64747368, float:1.8037286E22)
            if (r15 == r5) goto L_0x0129
            r5 = 1685353324(0x6474736c, float:1.803729E22)
            if (r15 != r5) goto L_0x00c3
            goto L_0x0129
        L_0x00c3:
            r5 = 1685353317(0x64747365, float:1.8037282E22)
            if (r15 != r5) goto L_0x00cb
            java.lang.String r17 = "audio/vnd.dts.hd;profile=lbr"
            goto L_0x009c
        L_0x00cb:
            r5 = 1935764850(0x73616d72, float:1.7860208E31)
            if (r15 != r5) goto L_0x00d3
            java.lang.String r17 = "audio/3gpp"
            goto L_0x009c
        L_0x00d3:
            r5 = 1935767394(0x73617762, float:1.7863284E31)
            if (r15 != r5) goto L_0x00db
            java.lang.String r17 = "audio/amr-wb"
            goto L_0x009c
        L_0x00db:
            r5 = 1819304813(0x6c70636d, float:1.1624469E27)
            if (r15 == r5) goto L_0x0127
            r5 = 1936684916(0x736f7774, float:1.89725E31)
            if (r15 != r5) goto L_0x00e6
            goto L_0x0127
        L_0x00e6:
            r5 = 1953984371(0x74776f73, float:7.841539E31)
            if (r15 != r5) goto L_0x00ee
            r5 = 268435456(0x10000000, float:2.5243549E-29)
            goto L_0x012d
        L_0x00ee:
            r5 = 778924082(0x2e6d7032, float:5.398721E-11)
            if (r15 == r5) goto L_0x0123
            r5 = 778924083(0x2e6d7033, float:5.3987214E-11)
            if (r15 != r5) goto L_0x00f9
            goto L_0x0123
        L_0x00f9:
            if (r15 != r13) goto L_0x00fe
            java.lang.String r17 = "audio/alac"
            goto L_0x009c
        L_0x00fe:
            r5 = 1634492791(0x616c6177, float:2.7252842E20)
            if (r15 != r5) goto L_0x0106
            java.lang.String r17 = "audio/g711-alaw"
            goto L_0x009c
        L_0x0106:
            r5 = 1970037111(0x756c6177, float:2.9964816E32)
            if (r15 != r5) goto L_0x010e
            java.lang.String r17 = "audio/g711-mlaw"
            goto L_0x009c
        L_0x010e:
            r5 = 1332770163(0x4f707573, float:4.03422899E9)
            if (r15 != r5) goto L_0x0116
            java.lang.String r17 = "audio/opus"
            goto L_0x009c
        L_0x0116:
            r5 = 1716281667(0x664c6143, float:2.4128923E23)
            if (r15 != r5) goto L_0x011f
            java.lang.String r17 = "audio/flac"
            goto L_0x009c
        L_0x011f:
            r5 = -1
            r17 = 0
            goto L_0x012d
        L_0x0123:
            java.lang.String r17 = "audio/mpeg"
            goto L_0x009c
        L_0x0127:
            r5 = 2
            goto L_0x012d
        L_0x0129:
            java.lang.String r17 = "audio/vnd.dts.hd"
            goto L_0x009c
        L_0x012d:
            r11 = r17
            r15 = 0
            r19 = 0
        L_0x0132:
            int r13 = r10 - r1
            if (r13 >= r2) goto L_0x0295
            r0.setPosition(r10)
            int r13 = r20.readInt()
            if (r13 <= 0) goto L_0x0140
            goto L_0x0141
        L_0x0140:
            r12 = 0
        L_0x0141:
            java.lang.String r9 = "childAtomSize should be positive"
            com.google.android.exoplayer2.util.Assertions.checkState(r12, r9)
            int r9 = r20.readInt()
            r12 = 1702061171(0x65736473, float:7.183675E22)
            if (r9 == r12) goto L_0x0258
            if (r26 == 0) goto L_0x015f
            r12 = 2002876005(0x77617665, float:4.5729223E33)
            if (r9 != r12) goto L_0x015f
            r1 = 1702061171(0x65736473, float:7.183675E22)
            r2 = 0
            r12 = 1
            r16 = 2
            goto L_0x025f
        L_0x015f:
            r12 = 1684103987(0x64616333, float:1.6630662E22)
            if (r9 != r12) goto L_0x017c
            int r9 = r10 + 8
            r0.setPosition(r9)
            java.lang.String r9 = java.lang.Integer.toString(r24)
            com.google.android.exoplayer2.Format r9 = com.google.android.exoplayer2.audio.Ac3Util.parseAc3AnnexFFormat(r0, r9, r4, r14)
            r6.format = r9
        L_0x0173:
            r1 = 1634492771(0x616c6163, float:2.7252807E20)
            r9 = 0
            r12 = 1
            r16 = 2
            goto L_0x0256
        L_0x017c:
            r12 = 1684366131(0x64656333, float:1.692581E22)
            if (r9 != r12) goto L_0x0191
            int r9 = r10 + 8
            r0.setPosition(r9)
            java.lang.String r9 = java.lang.Integer.toString(r24)
            com.google.android.exoplayer2.Format r9 = com.google.android.exoplayer2.audio.Ac3Util.parseEAc3AnnexFFormat(r0, r9, r4, r14)
            r6.format = r9
            goto L_0x0173
        L_0x0191:
            r12 = 1684103988(0x64616334, float:1.6630663E22)
            if (r9 != r12) goto L_0x01a6
            int r9 = r10 + 8
            r0.setPosition(r9)
            java.lang.String r9 = java.lang.Integer.toString(r24)
            com.google.android.exoplayer2.Format r9 = com.google.android.exoplayer2.audio.Ac4Util.parseAc4AnnexEFormat(r0, r9, r4, r14)
            r6.format = r9
            goto L_0x0173
        L_0x01a6:
            r12 = 1684305011(0x64647473, float:1.6856995E22)
            if (r9 != r12) goto L_0x01cf
            com.google.android.exoplayer2.Format$Builder r9 = new com.google.android.exoplayer2.Format$Builder
            r9.<init>()
            com.google.android.exoplayer2.Format$Builder r9 = r9.setId((int) r3)
            com.google.android.exoplayer2.Format$Builder r9 = r9.setSampleMimeType(r11)
            com.google.android.exoplayer2.Format$Builder r9 = r9.setChannelCount(r7)
            com.google.android.exoplayer2.Format$Builder r9 = r9.setSampleRate(r8)
            com.google.android.exoplayer2.Format$Builder r9 = r9.setDrmInitData(r14)
            com.google.android.exoplayer2.Format$Builder r9 = r9.setLanguage(r4)
            com.google.android.exoplayer2.Format r9 = r9.build()
            r6.format = r9
            goto L_0x0173
        L_0x01cf:
            r12 = 1682927731(0x644f7073, float:1.5306315E22)
            if (r9 != r12) goto L_0x01f3
            int r9 = r13 + -8
            byte[] r12 = opusMagic
            int r1 = r12.length
            int r1 = r1 + r9
            byte[] r1 = java.util.Arrays.copyOf(r12, r1)
            int r2 = r10 + 8
            r0.setPosition(r2)
            int r2 = r12.length
            r0.readBytes(r1, r2, r9)
            java.util.List r1 = com.google.android.exoplayer2.audio.OpusUtil.buildInitializationData(r1)
            r19 = r1
            r9 = -1
            r12 = 1
            r16 = 2
            goto L_0x028e
        L_0x01f3:
            r1 = 1684425825(0x64664c61, float:1.6993019E22)
            if (r9 != r1) goto L_0x0223
            int r1 = r13 + -12
            int r2 = r1 + 4
            byte[] r2 = new byte[r2]
            r9 = 102(0x66, float:1.43E-43)
            r12 = 0
            r2[r12] = r9
            r9 = 76
            r12 = 1
            r2[r12] = r9
            r9 = 97
            r16 = 2
            r2[r16] = r9
            r9 = 3
            r18 = 67
            r2[r9] = r18
            int r9 = r10 + 12
            r0.setPosition(r9)
            r9 = 4
            r0.readBytes(r2, r9, r1)
            com.google.common.collect.ImmutableList r1 = com.google.common.collect.ImmutableList.m434of(r2)
            r19 = r1
            goto L_0x0256
        L_0x0223:
            r1 = 1634492771(0x616c6163, float:2.7252807E20)
            r12 = 1
            r16 = 2
            if (r9 != r1) goto L_0x0255
            int r2 = r13 + -12
            byte[] r7 = new byte[r2]
            int r8 = r10 + 12
            r0.setPosition(r8)
            r9 = 0
            r0.readBytes(r7, r9, r2)
            android.util.Pair r2 = com.google.android.exoplayer2.util.CodecSpecificDataUtil.parseAlacAudioSpecificConfig(r7)
            java.lang.Object r8 = r2.first
            java.lang.Integer r8 = (java.lang.Integer) r8
            int r8 = r8.intValue()
            java.lang.Object r2 = r2.second
            java.lang.Integer r2 = (java.lang.Integer) r2
            int r2 = r2.intValue()
            com.google.common.collect.ImmutableList r7 = com.google.common.collect.ImmutableList.m434of(r7)
            r19 = r7
            r9 = -1
            r7 = r2
            goto L_0x028e
        L_0x0255:
            r9 = 0
        L_0x0256:
            r9 = -1
            goto L_0x028e
        L_0x0258:
            r2 = 0
            r12 = 1
            r16 = 2
            r1 = 1702061171(0x65736473, float:7.183675E22)
        L_0x025f:
            if (r9 != r1) goto L_0x0263
            r1 = r10
            goto L_0x0267
        L_0x0263:
            int r1 = findEsdsPosition(r0, r10, r13)
        L_0x0267:
            r9 = -1
            if (r1 == r9) goto L_0x028e
            android.util.Pair r1 = parseEsdsFromParent(r0, r1)
            java.lang.Object r11 = r1.first
            java.lang.String r11 = (java.lang.String) r11
            java.lang.Object r1 = r1.second
            byte[] r1 = (byte[]) r1
            if (r1 == 0) goto L_0x028e
            java.lang.String r2 = "audio/mp4a-latm"
            boolean r2 = r2.equals(r11)
            if (r2 == 0) goto L_0x028a
            com.google.android.exoplayer2.audio.AacUtil$Config r2 = com.google.android.exoplayer2.audio.AacUtil.parseAudioSpecificConfig(r1)
            int r8 = r2.sampleRateHz
            int r7 = r2.channelCount
            java.lang.String r15 = r2.codecs
        L_0x028a:
            com.google.common.collect.ImmutableList r19 = com.google.common.collect.ImmutableList.m434of(r1)
        L_0x028e:
            int r10 = r10 + r13
            r1 = r22
            r2 = r23
            goto L_0x0132
        L_0x0295:
            com.google.android.exoplayer2.Format r0 = r6.format
            if (r0 != 0) goto L_0x02cc
            if (r11 == 0) goto L_0x02cc
            com.google.android.exoplayer2.Format$Builder r0 = new com.google.android.exoplayer2.Format$Builder
            r0.<init>()
            com.google.android.exoplayer2.Format$Builder r0 = r0.setId((int) r3)
            com.google.android.exoplayer2.Format$Builder r0 = r0.setSampleMimeType(r11)
            com.google.android.exoplayer2.Format$Builder r0 = r0.setCodecs(r15)
            com.google.android.exoplayer2.Format$Builder r0 = r0.setChannelCount(r7)
            com.google.android.exoplayer2.Format$Builder r0 = r0.setSampleRate(r8)
            com.google.android.exoplayer2.Format$Builder r0 = r0.setPcmEncoding(r5)
            r1 = r19
            com.google.android.exoplayer2.Format$Builder r0 = r0.setInitializationData(r1)
            com.google.android.exoplayer2.Format$Builder r0 = r0.setDrmInitData(r14)
            com.google.android.exoplayer2.Format$Builder r0 = r0.setLanguage(r4)
            com.google.android.exoplayer2.Format r0 = r0.build()
            r6.format = r0
        L_0x02cc:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.extractor.mp4.AtomParsers.parseAudioSampleEntry(com.google.android.exoplayer2.util.ParsableByteArray, int, int, int, int, java.lang.String, boolean, com.google.android.exoplayer2.drm.DrmInitData, com.google.android.exoplayer2.extractor.mp4.AtomParsers$StsdData, int):void");
    }

    private static int findEsdsPosition(ParsableByteArray parsableByteArray, int i, int i2) {
        int position = parsableByteArray.getPosition();
        while (position - i < i2) {
            parsableByteArray.setPosition(position);
            int readInt = parsableByteArray.readInt();
            Assertions.checkState(readInt > 0, "childAtomSize should be positive");
            if (parsableByteArray.readInt() == 1702061171) {
                return position;
            }
            position += readInt;
        }
        return -1;
    }

    private static Pair<String, byte[]> parseEsdsFromParent(ParsableByteArray parsableByteArray, int i) {
        parsableByteArray.setPosition(i + 8 + 4);
        parsableByteArray.skipBytes(1);
        parseExpandableClassSize(parsableByteArray);
        parsableByteArray.skipBytes(2);
        int readUnsignedByte = parsableByteArray.readUnsignedByte();
        if ((readUnsignedByte & 128) != 0) {
            parsableByteArray.skipBytes(2);
        }
        if ((readUnsignedByte & 64) != 0) {
            parsableByteArray.skipBytes(parsableByteArray.readUnsignedShort());
        }
        if ((readUnsignedByte & 32) != 0) {
            parsableByteArray.skipBytes(2);
        }
        parsableByteArray.skipBytes(1);
        parseExpandableClassSize(parsableByteArray);
        String mimeTypeFromMp4ObjectType = MimeTypes.getMimeTypeFromMp4ObjectType(parsableByteArray.readUnsignedByte());
        if (MimeTypes.AUDIO_MPEG.equals(mimeTypeFromMp4ObjectType) || MimeTypes.AUDIO_DTS.equals(mimeTypeFromMp4ObjectType) || MimeTypes.AUDIO_DTS_HD.equals(mimeTypeFromMp4ObjectType)) {
            return Pair.create(mimeTypeFromMp4ObjectType, (Object) null);
        }
        parsableByteArray.skipBytes(12);
        parsableByteArray.skipBytes(1);
        int parseExpandableClassSize = parseExpandableClassSize(parsableByteArray);
        byte[] bArr = new byte[parseExpandableClassSize];
        parsableByteArray.readBytes(bArr, 0, parseExpandableClassSize);
        return Pair.create(mimeTypeFromMp4ObjectType, bArr);
    }

    private static Pair<Integer, TrackEncryptionBox> parseSampleEntryEncryptionData(ParsableByteArray parsableByteArray, int i, int i2) {
        Pair<Integer, TrackEncryptionBox> parseCommonEncryptionSinfFromParent;
        int position = parsableByteArray.getPosition();
        while (position - i < i2) {
            parsableByteArray.setPosition(position);
            int readInt = parsableByteArray.readInt();
            Assertions.checkState(readInt > 0, "childAtomSize should be positive");
            if (parsableByteArray.readInt() == 1936289382 && (parseCommonEncryptionSinfFromParent = parseCommonEncryptionSinfFromParent(parsableByteArray, position, readInt)) != null) {
                return parseCommonEncryptionSinfFromParent;
            }
            position += readInt;
        }
        return null;
    }

    static Pair<Integer, TrackEncryptionBox> parseCommonEncryptionSinfFromParent(ParsableByteArray parsableByteArray, int i, int i2) {
        int i3 = i + 8;
        boolean z = false;
        String str = null;
        Integer num = null;
        int i4 = -1;
        int i5 = 0;
        while (i3 - i < i2) {
            parsableByteArray.setPosition(i3);
            int readInt = parsableByteArray.readInt();
            int readInt2 = parsableByteArray.readInt();
            if (readInt2 == 1718775137) {
                num = Integer.valueOf(parsableByteArray.readInt());
            } else if (readInt2 == 1935894637) {
                parsableByteArray.skipBytes(4);
                str = parsableByteArray.readString(4);
            } else if (readInt2 == 1935894633) {
                i4 = i3;
                i5 = readInt;
            }
            i3 += readInt;
        }
        if (!C1844C.CENC_TYPE_cenc.equals(str) && !C1844C.CENC_TYPE_cbc1.equals(str) && !C1844C.CENC_TYPE_cens.equals(str) && !C1844C.CENC_TYPE_cbcs.equals(str)) {
            return null;
        }
        Assertions.checkStateNotNull(num, "frma atom is mandatory");
        if (i4 != -1) {
            z = true;
        }
        Assertions.checkState(z, "schi atom is mandatory");
        return Pair.create(num, (TrackEncryptionBox) Assertions.checkStateNotNull(parseSchiFromParent(parsableByteArray, i4, i5, str), "tenc atom is mandatory"));
    }

    private static TrackEncryptionBox parseSchiFromParent(ParsableByteArray parsableByteArray, int i, int i2, String str) {
        int i3;
        int i4;
        int i5 = i + 8;
        while (true) {
            byte[] bArr = null;
            if (i5 - i >= i2) {
                return null;
            }
            parsableByteArray.setPosition(i5);
            int readInt = parsableByteArray.readInt();
            if (parsableByteArray.readInt() == 1952804451) {
                int parseFullAtomVersion = Atom.parseFullAtomVersion(parsableByteArray.readInt());
                parsableByteArray.skipBytes(1);
                if (parseFullAtomVersion == 0) {
                    parsableByteArray.skipBytes(1);
                    i4 = 0;
                    i3 = 0;
                } else {
                    int readUnsignedByte = parsableByteArray.readUnsignedByte();
                    i3 = readUnsignedByte & 15;
                    i4 = (readUnsignedByte & 240) >> 4;
                }
                boolean z = parsableByteArray.readUnsignedByte() == 1;
                int readUnsignedByte2 = parsableByteArray.readUnsignedByte();
                byte[] bArr2 = new byte[16];
                parsableByteArray.readBytes(bArr2, 0, 16);
                if (z && readUnsignedByte2 == 0) {
                    int readUnsignedByte3 = parsableByteArray.readUnsignedByte();
                    bArr = new byte[readUnsignedByte3];
                    parsableByteArray.readBytes(bArr, 0, readUnsignedByte3);
                }
                return new TrackEncryptionBox(z, str, readUnsignedByte2, bArr2, i4, i3, bArr);
            }
            i5 += readInt;
        }
    }

    private static byte[] parseProjFromParent(ParsableByteArray parsableByteArray, int i, int i2) {
        int i3 = i + 8;
        while (i3 - i < i2) {
            parsableByteArray.setPosition(i3);
            int readInt = parsableByteArray.readInt();
            if (parsableByteArray.readInt() == 1886547818) {
                return Arrays.copyOfRange(parsableByteArray.getData(), i3, readInt + i3);
            }
            i3 += readInt;
        }
        return null;
    }

    private static int parseExpandableClassSize(ParsableByteArray parsableByteArray) {
        int readUnsignedByte = parsableByteArray.readUnsignedByte();
        int i = readUnsignedByte & 127;
        while ((readUnsignedByte & 128) == 128) {
            readUnsignedByte = parsableByteArray.readUnsignedByte();
            i = (i << 7) | (readUnsignedByte & 127);
        }
        return i;
    }

    private static boolean canApplyEditWithGaplessInfo(long[] jArr, long j, long j2, long j3) {
        int length = jArr.length - 1;
        int constrainValue = Util.constrainValue(4, 0, length);
        int constrainValue2 = Util.constrainValue(jArr.length - 4, 0, length);
        if (jArr[0] > j2 || j2 >= jArr[constrainValue] || jArr[constrainValue2] >= j3 || j3 > j) {
            return false;
        }
        return true;
    }

    private AtomParsers() {
    }

    private static final class ChunkIterator {
        private final ParsableByteArray chunkOffsets;
        private final boolean chunkOffsetsAreLongs;
        public int index;
        public final int length;
        private int nextSamplesPerChunkChangeIndex;
        public int numSamples;
        public long offset;
        private int remainingSamplesPerChunkChanges;
        private final ParsableByteArray stsc;

        public ChunkIterator(ParsableByteArray parsableByteArray, ParsableByteArray parsableByteArray2, boolean z) {
            this.stsc = parsableByteArray;
            this.chunkOffsets = parsableByteArray2;
            this.chunkOffsetsAreLongs = z;
            parsableByteArray2.setPosition(12);
            this.length = parsableByteArray2.readUnsignedIntToInt();
            parsableByteArray.setPosition(12);
            this.remainingSamplesPerChunkChanges = parsableByteArray.readUnsignedIntToInt();
            Assertions.checkState(parsableByteArray.readInt() != 1 ? false : true, "first_chunk must be 1");
            this.index = -1;
        }

        public boolean moveNext() {
            long j;
            int i = this.index + 1;
            this.index = i;
            if (i == this.length) {
                return false;
            }
            if (this.chunkOffsetsAreLongs) {
                j = this.chunkOffsets.readUnsignedLongToLong();
            } else {
                j = this.chunkOffsets.readUnsignedInt();
            }
            this.offset = j;
            if (this.index == this.nextSamplesPerChunkChangeIndex) {
                this.numSamples = this.stsc.readUnsignedIntToInt();
                this.stsc.skipBytes(4);
                int i2 = this.remainingSamplesPerChunkChanges - 1;
                this.remainingSamplesPerChunkChanges = i2;
                this.nextSamplesPerChunkChangeIndex = i2 > 0 ? this.stsc.readUnsignedIntToInt() - 1 : -1;
            }
            return true;
        }
    }

    private static final class TkhdData {
        /* access modifiers changed from: private */
        public final long duration;
        /* access modifiers changed from: private */

        /* renamed from: id */
        public final int f511id;
        /* access modifiers changed from: private */
        public final int rotationDegrees;

        public TkhdData(int i, long j, int i2) {
            this.f511id = i;
            this.duration = j;
            this.rotationDegrees = i2;
        }
    }

    private static final class StsdData {
        public static final int STSD_HEADER_SIZE = 8;
        public Format format;
        public int nalUnitLengthFieldLength;
        public int requiredSampleTransformation = 0;
        public final TrackEncryptionBox[] trackEncryptionBoxes;

        public StsdData(int i) {
            this.trackEncryptionBoxes = new TrackEncryptionBox[i];
        }
    }

    static final class StszSampleSizeBox implements SampleSizeBox {
        private final ParsableByteArray data;
        private final int fixedSampleSize;
        private final int sampleCount;

        public StszSampleSizeBox(Atom.LeafAtom leafAtom) {
            ParsableByteArray parsableByteArray = leafAtom.data;
            this.data = parsableByteArray;
            parsableByteArray.setPosition(12);
            int readUnsignedIntToInt = parsableByteArray.readUnsignedIntToInt();
            this.fixedSampleSize = readUnsignedIntToInt == 0 ? -1 : readUnsignedIntToInt;
            this.sampleCount = parsableByteArray.readUnsignedIntToInt();
        }

        public int getSampleCount() {
            return this.sampleCount;
        }

        public int getFixedSampleSize() {
            return this.fixedSampleSize;
        }

        public int readNextSampleSize() {
            int i = this.fixedSampleSize;
            return i == -1 ? this.data.readUnsignedIntToInt() : i;
        }
    }

    static final class Stz2SampleSizeBox implements SampleSizeBox {
        private int currentByte;
        private final ParsableByteArray data;
        private final int fieldSize;
        private final int sampleCount;
        private int sampleIndex;

        public int getFixedSampleSize() {
            return -1;
        }

        public Stz2SampleSizeBox(Atom.LeafAtom leafAtom) {
            ParsableByteArray parsableByteArray = leafAtom.data;
            this.data = parsableByteArray;
            parsableByteArray.setPosition(12);
            this.fieldSize = parsableByteArray.readUnsignedIntToInt() & 255;
            this.sampleCount = parsableByteArray.readUnsignedIntToInt();
        }

        public int getSampleCount() {
            return this.sampleCount;
        }

        public int readNextSampleSize() {
            int i = this.fieldSize;
            if (i == 8) {
                return this.data.readUnsignedByte();
            }
            if (i == 16) {
                return this.data.readUnsignedShort();
            }
            int i2 = this.sampleIndex;
            this.sampleIndex = i2 + 1;
            if (i2 % 2 != 0) {
                return this.currentByte & 15;
            }
            int readUnsignedByte = this.data.readUnsignedByte();
            this.currentByte = readUnsignedByte;
            return (readUnsignedByte & 240) >> 4;
        }
    }
}
