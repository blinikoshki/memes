package com.google.android.exoplayer2.metadata.icy;

import com.google.android.exoplayer2.metadata.Metadata;
import com.google.android.exoplayer2.metadata.MetadataInputBuffer;
import com.google.android.exoplayer2.metadata.SimpleMetadataDecoder;
import com.google.android.exoplayer2.util.Util;
import com.google.common.base.Charsets;
import java.nio.ByteBuffer;
import java.nio.charset.CharacterCodingException;
import java.nio.charset.CharsetDecoder;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class IcyDecoder extends SimpleMetadataDecoder {
    private static final Pattern METADATA_ELEMENT = Pattern.compile("(.+?)='(.*?)';", 32);
    private static final String STREAM_KEY_NAME = "streamtitle";
    private static final String STREAM_KEY_URL = "streamurl";
    private final CharsetDecoder iso88591Decoder = Charsets.ISO_8859_1.newDecoder();
    private final CharsetDecoder utf8Decoder = Charsets.UTF_8.newDecoder();

    /* access modifiers changed from: protected */
    public Metadata decode(MetadataInputBuffer metadataInputBuffer, ByteBuffer byteBuffer) {
        String decodeToString = decodeToString(byteBuffer);
        byte[] bArr = new byte[byteBuffer.limit()];
        byteBuffer.get(bArr);
        String str = null;
        if (decodeToString == null) {
            return new Metadata(new IcyInfo(bArr, (String) null, (String) null));
        }
        Matcher matcher = METADATA_ELEMENT.matcher(decodeToString);
        String str2 = null;
        for (int i = 0; matcher.find(i); i = matcher.end()) {
            String lowerInvariant = Util.toLowerInvariant(matcher.group(1));
            String group = matcher.group(2);
            if (lowerInvariant != null) {
                lowerInvariant.hashCode();
                if (lowerInvariant.equals(STREAM_KEY_URL)) {
                    str2 = group;
                } else if (lowerInvariant.equals(STREAM_KEY_NAME)) {
                    str = group;
                }
            }
        }
        return new Metadata(new IcyInfo(bArr, str, str2));
    }

    private String decodeToString(ByteBuffer byteBuffer) {
        try {
            return this.utf8Decoder.decode(byteBuffer).toString();
        } catch (CharacterCodingException unused) {
            try {
                return this.iso88591Decoder.decode(byteBuffer).toString();
            } catch (CharacterCodingException unused2) {
                return null;
            } finally {
                this.iso88591Decoder.reset();
                byteBuffer.rewind();
            }
        } finally {
            this.utf8Decoder.reset();
            byteBuffer.rewind();
        }
    }
}
