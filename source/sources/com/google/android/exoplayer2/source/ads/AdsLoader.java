package com.google.android.exoplayer2.source.ads;

import android.view.View;
import android.view.ViewGroup;
import com.google.android.exoplayer2.Player;
import com.google.android.exoplayer2.source.ads.AdsMediaSource;
import com.google.android.exoplayer2.upstream.DataSpec;
import com.google.common.collect.ImmutableList;
import java.io.IOException;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.List;

public interface AdsLoader {

    public interface EventListener {

        /* renamed from: com.google.android.exoplayer2.source.ads.AdsLoader$EventListener$-CC  reason: invalid class name */
        public final /* synthetic */ class CC {
            public static void $default$onAdClicked(EventListener eventListener) {
            }

            public static void $default$onAdLoadError(EventListener eventListener, AdsMediaSource.AdLoadException adLoadException, DataSpec dataSpec) {
            }

            public static void $default$onAdPlaybackState(EventListener eventListener, AdPlaybackState adPlaybackState) {
            }

            public static void $default$onAdTapped(EventListener eventListener) {
            }
        }

        void onAdClicked();

        void onAdLoadError(AdsMediaSource.AdLoadException adLoadException, DataSpec dataSpec);

        void onAdPlaybackState(AdPlaybackState adPlaybackState);

        void onAdTapped();
    }

    void handlePrepareComplete(int i, int i2);

    void handlePrepareError(int i, int i2, IOException iOException);

    void release();

    void setAdTagDataSpec(DataSpec dataSpec);

    void setPlayer(Player player);

    void setSupportedContentTypes(int... iArr);

    void start(EventListener eventListener, AdViewProvider adViewProvider);

    void stop();

    public interface AdViewProvider {
        List<OverlayInfo> getAdOverlayInfos();

        @Deprecated
        View[] getAdOverlayViews();

        ViewGroup getAdViewGroup();

        /* renamed from: com.google.android.exoplayer2.source.ads.AdsLoader$AdViewProvider$-CC  reason: invalid class name */
        public final /* synthetic */ class CC {
            @Deprecated
            public static View[] $default$getAdOverlayViews(AdViewProvider adViewProvider) {
                return new View[0];
            }

            public static List $default$getAdOverlayInfos(AdViewProvider _this) {
                ImmutableList.Builder builder = new ImmutableList.Builder();
                for (View overlayInfo : _this.getAdOverlayViews()) {
                    builder.add((Object) new OverlayInfo(overlayInfo, 0));
                }
                return builder.build();
            }
        }
    }

    public static final class OverlayInfo {
        public static final int PURPOSE_CLOSE_AD = 1;
        public static final int PURPOSE_CONTROLS = 0;
        public static final int PURPOSE_NOT_VISIBLE = 3;
        public static final int PURPOSE_OTHER = 2;
        public final int purpose;
        public final String reasonDetail;
        public final View view;

        @Documented
        @Retention(RetentionPolicy.SOURCE)
        public @interface Purpose {
        }

        public OverlayInfo(View view2, int i) {
            this(view2, i, (String) null);
        }

        public OverlayInfo(View view2, int i, String str) {
            this.view = view2;
            this.purpose = i;
            this.reasonDetail = str;
        }
    }
}
