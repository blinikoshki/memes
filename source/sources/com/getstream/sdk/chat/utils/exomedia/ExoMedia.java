package com.getstream.sdk.chat.utils.exomedia;

import com.getstream.sdk.chat.utils.exomedia.core.source.MediaSourceProvider;
import com.getstream.sdk.chat.utils.exomedia.core.source.builder.DashMediaSourceBuilder;
import com.getstream.sdk.chat.utils.exomedia.core.source.builder.HlsMediaSourceBuilder;
import com.getstream.sdk.chat.utils.exomedia.core.source.builder.SsMediaSourceBuilder;
import com.google.android.exoplayer2.LoadControl;
import com.google.android.exoplayer2.Renderer;
import com.google.android.exoplayer2.upstream.DataSource;
import com.google.android.exoplayer2.upstream.HttpDataSource;
import com.google.android.exoplayer2.upstream.TransferListener;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class ExoMedia {

    public interface DataSourceFactoryProvider {
        DataSource.Factory provide(String str, TransferListener transferListener);
    }

    @Deprecated
    public interface HttpDataSourceFactoryProvider {
        HttpDataSource.BaseFactory provide(String str, TransferListener transferListener);
    }

    public enum RendererType {
        AUDIO,
        VIDEO,
        CLOSED_CAPTION,
        METADATA
    }

    public static void registerRenderer(RendererType rendererType, Class<? extends Renderer> cls) {
        Data.registeredRendererClasses.get(rendererType).add(cls.getName());
    }

    public static void registerMediaSourceBuilder(MediaSourceProvider.SourceTypeBuilder sourceTypeBuilder) {
        Data.sourceTypeBuilders.add(0, sourceTypeBuilder);
    }

    @Deprecated
    public static void setHttpDataSourceFactoryProvider(HttpDataSourceFactoryProvider httpDataSourceFactoryProvider) {
        Data.httpDataSourceFactoryProvider = httpDataSourceFactoryProvider;
    }

    public static void setDataSourceFactoryProvider(DataSourceFactoryProvider dataSourceFactoryProvider) {
        Data.dataSourceFactoryProvider = dataSourceFactoryProvider;
    }

    public static void setLoadControl(LoadControl loadControl) {
        Data.loadControl = loadControl;
    }

    public static class Data {
        public static volatile DataSourceFactoryProvider dataSourceFactoryProvider;
        @Deprecated
        public static volatile HttpDataSourceFactoryProvider httpDataSourceFactoryProvider;
        public static volatile LoadControl loadControl;
        public static volatile MediaSourceProvider mediaSourceProvider = new MediaSourceProvider();
        public static final Map<RendererType, List<String>> registeredRendererClasses = new HashMap();
        public static final List<MediaSourceProvider.SourceTypeBuilder> sourceTypeBuilders = new ArrayList();

        static {
            instantiateRendererClasses();
            instantiateSourceProviders();
        }

        private static void instantiateRendererClasses() {
            Map<RendererType, List<String>> map = registeredRendererClasses;
            map.put(RendererType.AUDIO, new LinkedList());
            map.put(RendererType.VIDEO, new LinkedList());
            map.put(RendererType.CLOSED_CAPTION, new LinkedList());
            map.put(RendererType.METADATA, new LinkedList());
            List list = map.get(RendererType.AUDIO);
            list.add("com.google.android.exoplayer2.ext.opus.LibopusAudioRenderer");
            list.add("com.google.android.exoplayer2.ext.flac.LibflacAudioRenderer");
            list.add("com.google.android.exoplayer2.ext.ffmpeg.FfmpegAudioRenderer");
            map.get(RendererType.VIDEO).add("com.google.android.exoplayer2.ext.vp9.LibvpxVideoRenderer");
        }

        private static void instantiateSourceProviders() {
            List<MediaSourceProvider.SourceTypeBuilder> list = sourceTypeBuilders;
            list.add(new MediaSourceProvider.SourceTypeBuilder(new HlsMediaSourceBuilder(), (String) null, ".m3u8", ".*\\.m3u8.*"));
            list.add(new MediaSourceProvider.SourceTypeBuilder(new DashMediaSourceBuilder(), (String) null, ".mpd", ".*\\.mpd.*"));
            list.add(new MediaSourceProvider.SourceTypeBuilder(new SsMediaSourceBuilder(), (String) null, ".ism", ".*\\.ism.*"));
        }
    }
}
