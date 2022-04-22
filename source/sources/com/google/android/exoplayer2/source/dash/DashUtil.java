package com.google.android.exoplayer2.source.dash;

import android.net.Uri;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.extractor.ChunkIndex;
import com.google.android.exoplayer2.extractor.mkv.MatroskaExtractor;
import com.google.android.exoplayer2.extractor.mp4.FragmentedMp4Extractor;
import com.google.android.exoplayer2.source.chunk.BundledChunkExtractor;
import com.google.android.exoplayer2.source.chunk.ChunkExtractor;
import com.google.android.exoplayer2.source.chunk.InitializationChunk;
import com.google.android.exoplayer2.source.dash.manifest.DashManifest;
import com.google.android.exoplayer2.source.dash.manifest.DashManifestParser;
import com.google.android.exoplayer2.source.dash.manifest.Period;
import com.google.android.exoplayer2.source.dash.manifest.RangedUri;
import com.google.android.exoplayer2.source.dash.manifest.Representation;
import com.google.android.exoplayer2.upstream.DataSource;
import com.google.android.exoplayer2.upstream.DataSpec;
import com.google.android.exoplayer2.upstream.ParsingLoadable;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.MimeTypes;
import java.io.IOException;
import java.util.List;

public final class DashUtil {
    public static DataSpec buildDataSpec(Representation representation, RangedUri rangedUri) {
        return new DataSpec.Builder().setUri(rangedUri.resolveUri(representation.baseUrl)).setPosition(rangedUri.start).setLength(rangedUri.length).setKey(representation.getCacheKey()).build();
    }

    public static DashManifest loadManifest(DataSource dataSource, Uri uri) throws IOException {
        return (DashManifest) ParsingLoadable.load(dataSource, new DashManifestParser(), uri, 4);
    }

    public static Format loadFormatWithDrmInitData(DataSource dataSource, Period period) throws IOException {
        int i = 2;
        Representation firstRepresentation = getFirstRepresentation(period, 2);
        if (firstRepresentation == null) {
            i = 1;
            firstRepresentation = getFirstRepresentation(period, 1);
            if (firstRepresentation == null) {
                return null;
            }
        }
        Format format = firstRepresentation.format;
        Format loadSampleFormat = loadSampleFormat(dataSource, i, firstRepresentation);
        return loadSampleFormat == null ? format : loadSampleFormat.withManifestFormatInfo(format);
    }

    /* JADX INFO: finally extract failed */
    public static Format loadSampleFormat(DataSource dataSource, int i, Representation representation) throws IOException {
        if (representation.getInitializationUri() == null) {
            return null;
        }
        ChunkExtractor newChunkExtractor = newChunkExtractor(i, representation.format);
        try {
            loadInitializationData(newChunkExtractor, dataSource, representation, false);
            newChunkExtractor.release();
            return ((Format[]) Assertions.checkStateNotNull(newChunkExtractor.getSampleFormats()))[0];
        } catch (Throwable th) {
            newChunkExtractor.release();
            throw th;
        }
    }

    /* JADX INFO: finally extract failed */
    public static ChunkIndex loadChunkIndex(DataSource dataSource, int i, Representation representation) throws IOException {
        if (representation.getInitializationUri() == null) {
            return null;
        }
        ChunkExtractor newChunkExtractor = newChunkExtractor(i, representation.format);
        try {
            loadInitializationData(newChunkExtractor, dataSource, representation, true);
            newChunkExtractor.release();
            return newChunkExtractor.getChunkIndex();
        } catch (Throwable th) {
            newChunkExtractor.release();
            throw th;
        }
    }

    private static void loadInitializationData(ChunkExtractor chunkExtractor, DataSource dataSource, Representation representation, boolean z) throws IOException {
        RangedUri rangedUri = (RangedUri) Assertions.checkNotNull(representation.getInitializationUri());
        if (z) {
            RangedUri indexUri = representation.getIndexUri();
            if (indexUri != null) {
                RangedUri attemptMerge = rangedUri.attemptMerge(indexUri, representation.baseUrl);
                if (attemptMerge == null) {
                    loadInitializationData(dataSource, representation, chunkExtractor, rangedUri);
                    rangedUri = indexUri;
                } else {
                    rangedUri = attemptMerge;
                }
            } else {
                return;
            }
        }
        loadInitializationData(dataSource, representation, chunkExtractor, rangedUri);
    }

    private static void loadInitializationData(DataSource dataSource, Representation representation, ChunkExtractor chunkExtractor, RangedUri rangedUri) throws IOException {
        new InitializationChunk(dataSource, buildDataSpec(representation, rangedUri), representation.format, 0, (Object) null, chunkExtractor).load();
    }

    private static ChunkExtractor newChunkExtractor(int i, Format format) {
        String str = format.containerMimeType;
        return new BundledChunkExtractor(str != null && (str.startsWith(MimeTypes.VIDEO_WEBM) || str.startsWith(MimeTypes.AUDIO_WEBM)) ? new MatroskaExtractor() : new FragmentedMp4Extractor(), i, format);
    }

    private static Representation getFirstRepresentation(Period period, int i) {
        int adaptationSetIndex = period.getAdaptationSetIndex(i);
        if (adaptationSetIndex == -1) {
            return null;
        }
        List<Representation> list = period.adaptationSets.get(adaptationSetIndex).representations;
        if (list.isEmpty()) {
            return null;
        }
        return list.get(0);
    }

    private DashUtil() {
    }
}
