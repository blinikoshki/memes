package com.google.android.exoplayer2.metadata.emsg;

import com.google.android.exoplayer2.metadata.Metadata;
import com.google.android.exoplayer2.metadata.MetadataInputBuffer;
import com.google.android.exoplayer2.metadata.SimpleMetadataDecoder;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.ParsableByteArray;
import java.nio.ByteBuffer;
import java.util.Arrays;

public final class EventMessageDecoder extends SimpleMetadataDecoder {
    /* access modifiers changed from: protected */
    public Metadata decode(MetadataInputBuffer metadataInputBuffer, ByteBuffer byteBuffer) {
        return new Metadata(decode(new ParsableByteArray(byteBuffer.array(), byteBuffer.limit())));
    }

    public EventMessage decode(ParsableByteArray parsableByteArray) {
        return new EventMessage((String) Assertions.checkNotNull(parsableByteArray.readNullTerminatedString()), (String) Assertions.checkNotNull(parsableByteArray.readNullTerminatedString()), parsableByteArray.readUnsignedInt(), parsableByteArray.readUnsignedInt(), Arrays.copyOfRange(parsableByteArray.getData(), parsableByteArray.getPosition(), parsableByteArray.limit()));
    }
}
