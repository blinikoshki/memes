package com.facebook.imagepipeline.bitmaps;

import com.facebook.common.memory.PooledByteBuffer;
import com.facebook.common.memory.PooledByteBufferFactory;
import com.facebook.common.memory.PooledByteBufferOutputStream;
import com.facebook.common.references.CloseableReference;
import com.memes.plus.p040ui.posts.post_basics.post_options.PostOptionsBottomSheet;
import java.io.IOException;

public class EmptyJpegGenerator {
    private static final byte[] EMPTY_JPEG_PREFIX = {-1, -40, -1, -37, 0, 67, 0, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -64, 0, 17, 8};
    private static final byte[] EMPTY_JPEG_SUFFIX;
    private final PooledByteBufferFactory mPooledByteBufferFactory;

    static {
        byte[] bArr = new byte[PostOptionsBottomSheet.ENABLE_NOTIFICATIONS];
        // fill-array-data instruction
        bArr[0] = 3;
        bArr[1] = 1;
        bArr[2] = 34;
        bArr[3] = 0;
        bArr[4] = 2;
        bArr[5] = 17;
        bArr[6] = 0;
        bArr[7] = 3;
        bArr[8] = 17;
        bArr[9] = 0;
        bArr[10] = -1;
        bArr[11] = -60;
        bArr[12] = 0;
        bArr[13] = 31;
        bArr[14] = 0;
        bArr[15] = 0;
        bArr[16] = 1;
        bArr[17] = 5;
        bArr[18] = 1;
        bArr[19] = 1;
        bArr[20] = 1;
        bArr[21] = 1;
        bArr[22] = 1;
        bArr[23] = 1;
        bArr[24] = 0;
        bArr[25] = 0;
        bArr[26] = 0;
        bArr[27] = 0;
        bArr[28] = 0;
        bArr[29] = 0;
        bArr[30] = 0;
        bArr[31] = 0;
        bArr[32] = 1;
        bArr[33] = 2;
        bArr[34] = 3;
        bArr[35] = 4;
        bArr[36] = 5;
        bArr[37] = 6;
        bArr[38] = 7;
        bArr[39] = 8;
        bArr[40] = 9;
        bArr[41] = 10;
        bArr[42] = 11;
        bArr[43] = -1;
        bArr[44] = -60;
        bArr[45] = 0;
        bArr[46] = -75;
        bArr[47] = 16;
        bArr[48] = 0;
        bArr[49] = 2;
        bArr[50] = 1;
        bArr[51] = 3;
        bArr[52] = 3;
        bArr[53] = 2;
        bArr[54] = 4;
        bArr[55] = 3;
        bArr[56] = 5;
        bArr[57] = 5;
        bArr[58] = 4;
        bArr[59] = 4;
        bArr[60] = 0;
        bArr[61] = 0;
        bArr[62] = 1;
        bArr[63] = 125;
        bArr[64] = 1;
        bArr[65] = 2;
        bArr[66] = 3;
        bArr[67] = 0;
        bArr[68] = 4;
        bArr[69] = 17;
        bArr[70] = 5;
        bArr[71] = 18;
        bArr[72] = 33;
        bArr[73] = 49;
        bArr[74] = 65;
        bArr[75] = 6;
        bArr[76] = 19;
        bArr[77] = 81;
        bArr[78] = 97;
        bArr[79] = 7;
        bArr[80] = 34;
        bArr[81] = 113;
        bArr[82] = 20;
        bArr[83] = 50;
        bArr[84] = -127;
        bArr[85] = -111;
        bArr[86] = -95;
        bArr[87] = 8;
        bArr[88] = 35;
        bArr[89] = 66;
        bArr[90] = -79;
        bArr[91] = -63;
        bArr[92] = 21;
        bArr[93] = 82;
        bArr[94] = -47;
        bArr[95] = -16;
        bArr[96] = 36;
        bArr[97] = 51;
        bArr[98] = 98;
        bArr[99] = 114;
        bArr[100] = -126;
        bArr[101] = 9;
        bArr[102] = 10;
        bArr[103] = 22;
        bArr[104] = 23;
        bArr[105] = 24;
        bArr[106] = 25;
        bArr[107] = 26;
        bArr[108] = 37;
        bArr[109] = 38;
        bArr[110] = 39;
        bArr[111] = 40;
        bArr[112] = 41;
        bArr[113] = 42;
        bArr[114] = 52;
        bArr[115] = 53;
        bArr[116] = 54;
        bArr[117] = 55;
        bArr[118] = 56;
        bArr[119] = 57;
        bArr[120] = 58;
        bArr[121] = 67;
        bArr[122] = 68;
        bArr[123] = 69;
        bArr[124] = 70;
        bArr[125] = 71;
        bArr[126] = 72;
        bArr[127] = 73;
        bArr[128] = 74;
        bArr[129] = 83;
        bArr[130] = 84;
        bArr[131] = 85;
        bArr[132] = 86;
        bArr[133] = 87;
        bArr[134] = 88;
        bArr[135] = 89;
        bArr[136] = 90;
        bArr[137] = 99;
        bArr[138] = 100;
        bArr[139] = 101;
        bArr[140] = 102;
        bArr[141] = 103;
        bArr[142] = 104;
        bArr[143] = 105;
        bArr[144] = 106;
        bArr[145] = 115;
        bArr[146] = 116;
        bArr[147] = 117;
        bArr[148] = 118;
        bArr[149] = 119;
        bArr[150] = 120;
        bArr[151] = 121;
        bArr[152] = 122;
        bArr[153] = -125;
        bArr[154] = -124;
        bArr[155] = -123;
        bArr[156] = -122;
        bArr[157] = -121;
        bArr[158] = -120;
        bArr[159] = -119;
        bArr[160] = -118;
        bArr[161] = -110;
        bArr[162] = -109;
        bArr[163] = -108;
        bArr[164] = -107;
        bArr[165] = -106;
        bArr[166] = -105;
        bArr[167] = -104;
        bArr[168] = -103;
        bArr[169] = -102;
        bArr[170] = -94;
        bArr[171] = -93;
        bArr[172] = -92;
        bArr[173] = -91;
        bArr[174] = -90;
        bArr[175] = -89;
        bArr[176] = -88;
        bArr[177] = -87;
        bArr[178] = -86;
        bArr[179] = -78;
        bArr[180] = -77;
        bArr[181] = -76;
        bArr[182] = -75;
        bArr[183] = -74;
        bArr[184] = -73;
        bArr[185] = -72;
        bArr[186] = -71;
        bArr[187] = -70;
        bArr[188] = -62;
        bArr[189] = -61;
        bArr[190] = -60;
        bArr[191] = -59;
        bArr[192] = -58;
        bArr[193] = -57;
        bArr[194] = -56;
        bArr[195] = -55;
        bArr[196] = -54;
        bArr[197] = -46;
        bArr[198] = -45;
        bArr[199] = -44;
        bArr[200] = -43;
        bArr[201] = -42;
        bArr[202] = -41;
        bArr[203] = -40;
        bArr[204] = -39;
        bArr[205] = -38;
        bArr[206] = -31;
        bArr[207] = -30;
        bArr[208] = -29;
        bArr[209] = -28;
        bArr[210] = -27;
        bArr[211] = -26;
        bArr[212] = -25;
        bArr[213] = -24;
        bArr[214] = -23;
        bArr[215] = -22;
        bArr[216] = -15;
        bArr[217] = -14;
        bArr[218] = -13;
        bArr[219] = -12;
        bArr[220] = -11;
        bArr[221] = -10;
        bArr[222] = -9;
        bArr[223] = -8;
        bArr[224] = -7;
        bArr[225] = -6;
        bArr[226] = -1;
        bArr[227] = -60;
        bArr[228] = 0;
        bArr[229] = 31;
        bArr[230] = 1;
        bArr[231] = 0;
        bArr[232] = 3;
        bArr[233] = 1;
        bArr[234] = 1;
        bArr[235] = 1;
        bArr[236] = 1;
        bArr[237] = 1;
        bArr[238] = 1;
        bArr[239] = 1;
        bArr[240] = 1;
        bArr[241] = 1;
        bArr[242] = 0;
        bArr[243] = 0;
        bArr[244] = 0;
        bArr[245] = 0;
        bArr[246] = 0;
        bArr[247] = 0;
        bArr[248] = 1;
        bArr[249] = 2;
        bArr[250] = 3;
        bArr[251] = 4;
        bArr[252] = 5;
        bArr[253] = 6;
        bArr[254] = 7;
        bArr[255] = 8;
        bArr[256] = 9;
        bArr[257] = 10;
        bArr[258] = 11;
        bArr[259] = -1;
        bArr[260] = -60;
        bArr[261] = 0;
        bArr[262] = -75;
        bArr[263] = 17;
        bArr[264] = 0;
        bArr[265] = 2;
        bArr[266] = 1;
        bArr[267] = 2;
        bArr[268] = 4;
        bArr[269] = 4;
        bArr[270] = 3;
        bArr[271] = 4;
        bArr[272] = 7;
        bArr[273] = 5;
        bArr[274] = 4;
        bArr[275] = 4;
        bArr[276] = 0;
        bArr[277] = 1;
        bArr[278] = 2;
        bArr[279] = 119;
        bArr[280] = 0;
        bArr[281] = 1;
        bArr[282] = 2;
        bArr[283] = 3;
        bArr[284] = 17;
        bArr[285] = 4;
        bArr[286] = 5;
        bArr[287] = 33;
        bArr[288] = 49;
        bArr[289] = 6;
        bArr[290] = 18;
        bArr[291] = 65;
        bArr[292] = 81;
        bArr[293] = 7;
        bArr[294] = 97;
        bArr[295] = 113;
        bArr[296] = 19;
        bArr[297] = 34;
        bArr[298] = 50;
        bArr[299] = -127;
        bArr[300] = 8;
        bArr[301] = 20;
        bArr[302] = 66;
        bArr[303] = -111;
        bArr[304] = -95;
        bArr[305] = -79;
        bArr[306] = -63;
        bArr[307] = 9;
        bArr[308] = 35;
        bArr[309] = 51;
        bArr[310] = 82;
        bArr[311] = -16;
        bArr[312] = 21;
        bArr[313] = 98;
        bArr[314] = 114;
        bArr[315] = -47;
        bArr[316] = 10;
        bArr[317] = 22;
        bArr[318] = 36;
        bArr[319] = 52;
        bArr[320] = -31;
        bArr[321] = 37;
        bArr[322] = -15;
        bArr[323] = 23;
        bArr[324] = 24;
        bArr[325] = 25;
        bArr[326] = 26;
        bArr[327] = 38;
        bArr[328] = 39;
        bArr[329] = 40;
        bArr[330] = 41;
        bArr[331] = 42;
        bArr[332] = 53;
        bArr[333] = 54;
        bArr[334] = 55;
        bArr[335] = 56;
        bArr[336] = 57;
        bArr[337] = 58;
        bArr[338] = 67;
        bArr[339] = 68;
        bArr[340] = 69;
        bArr[341] = 70;
        bArr[342] = 71;
        bArr[343] = 72;
        bArr[344] = 73;
        bArr[345] = 74;
        bArr[346] = 83;
        bArr[347] = 84;
        bArr[348] = 85;
        bArr[349] = 86;
        bArr[350] = 87;
        bArr[351] = 88;
        bArr[352] = 89;
        bArr[353] = 90;
        bArr[354] = 99;
        bArr[355] = 100;
        bArr[356] = 101;
        bArr[357] = 102;
        bArr[358] = 103;
        bArr[359] = 104;
        bArr[360] = 105;
        bArr[361] = 106;
        bArr[362] = 115;
        bArr[363] = 116;
        bArr[364] = 117;
        bArr[365] = 118;
        bArr[366] = 119;
        bArr[367] = 120;
        bArr[368] = 121;
        bArr[369] = 122;
        bArr[370] = -126;
        bArr[371] = -125;
        bArr[372] = -124;
        bArr[373] = -123;
        bArr[374] = -122;
        bArr[375] = -121;
        bArr[376] = -120;
        bArr[377] = -119;
        bArr[378] = -118;
        bArr[379] = -110;
        bArr[380] = -109;
        bArr[381] = -108;
        bArr[382] = -107;
        bArr[383] = -106;
        bArr[384] = -105;
        bArr[385] = -104;
        bArr[386] = -103;
        bArr[387] = -102;
        bArr[388] = -94;
        bArr[389] = -93;
        bArr[390] = -92;
        bArr[391] = -91;
        bArr[392] = -90;
        bArr[393] = -89;
        bArr[394] = -88;
        bArr[395] = -87;
        bArr[396] = -86;
        bArr[397] = -78;
        bArr[398] = -77;
        bArr[399] = -76;
        bArr[400] = -75;
        bArr[401] = -74;
        bArr[402] = -73;
        bArr[403] = -72;
        bArr[404] = -71;
        bArr[405] = -70;
        bArr[406] = -62;
        bArr[407] = -61;
        bArr[408] = -60;
        bArr[409] = -59;
        bArr[410] = -58;
        bArr[411] = -57;
        bArr[412] = -56;
        bArr[413] = -55;
        bArr[414] = -54;
        bArr[415] = -46;
        bArr[416] = -45;
        bArr[417] = -44;
        bArr[418] = -43;
        bArr[419] = -42;
        bArr[420] = -41;
        bArr[421] = -40;
        bArr[422] = -39;
        bArr[423] = -38;
        bArr[424] = -30;
        bArr[425] = -29;
        bArr[426] = -28;
        bArr[427] = -27;
        bArr[428] = -26;
        bArr[429] = -25;
        bArr[430] = -24;
        bArr[431] = -23;
        bArr[432] = -22;
        bArr[433] = -14;
        bArr[434] = -13;
        bArr[435] = -12;
        bArr[436] = -11;
        bArr[437] = -10;
        bArr[438] = -9;
        bArr[439] = -8;
        bArr[440] = -7;
        bArr[441] = -6;
        bArr[442] = -1;
        bArr[443] = -38;
        bArr[444] = 0;
        bArr[445] = 12;
        bArr[446] = 3;
        bArr[447] = 1;
        bArr[448] = 0;
        bArr[449] = 2;
        bArr[450] = 17;
        bArr[451] = 3;
        bArr[452] = 17;
        bArr[453] = 0;
        bArr[454] = 63;
        bArr[455] = 0;
        bArr[456] = -114;
        bArr[457] = -118;
        bArr[458] = 40;
        bArr[459] = -96;
        bArr[460] = 15;
        bArr[461] = -1;
        bArr[462] = -39;
        EMPTY_JPEG_SUFFIX = bArr;
    }

    public EmptyJpegGenerator(PooledByteBufferFactory pooledByteBufferFactory) {
        this.mPooledByteBufferFactory = pooledByteBufferFactory;
    }

    public CloseableReference<PooledByteBuffer> generate(short s, short s2) {
        PooledByteBufferOutputStream pooledByteBufferOutputStream = null;
        try {
            PooledByteBufferFactory pooledByteBufferFactory = this.mPooledByteBufferFactory;
            byte[] bArr = EMPTY_JPEG_PREFIX;
            int length = bArr.length;
            byte[] bArr2 = EMPTY_JPEG_SUFFIX;
            PooledByteBufferOutputStream newOutputStream = pooledByteBufferFactory.newOutputStream(length + bArr2.length + 4);
            newOutputStream.write(bArr);
            newOutputStream.write((byte) (s2 >> 8));
            newOutputStream.write((byte) (s2 & 255));
            newOutputStream.write((byte) (s >> 8));
            newOutputStream.write((byte) (s & 255));
            newOutputStream.write(bArr2);
            CloseableReference<PooledByteBuffer> of = CloseableReference.m121of(newOutputStream.toByteBuffer());
            if (newOutputStream != null) {
                newOutputStream.close();
            }
            return of;
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (Throwable th) {
            if (pooledByteBufferOutputStream != null) {
                pooledByteBufferOutputStream.close();
            }
            throw th;
        }
    }
}
