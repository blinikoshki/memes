package editor.editor.equipment.media;

import android.content.Context;
import android.net.Uri;
import android.os.Handler;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.bumptech.glide.Glide;
import com.google.android.exoplayer2.p024ui.PlayerView;
import com.memes.commons.media.MediaContent;
import com.memes.commons.media.MediaFile;
import com.memes.editor.databinding.NMediaViewBinding;
import editor.common.mediaplayback.MediaPlaybackOrganiser;
import java.io.File;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import timber.log.Timber;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\f\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0000\u0018\u00002\u00020\u0001B\u0019\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006J\u0006\u0010\u001a\u001a\u00020\u001bJ\b\u0010\u001c\u001a\u00020\u001bH\u0002J\b\u0010\u001d\u001a\u00020\u001bH\u0002J\u0006\u0010\u001e\u001a\u00020\bJ\u0006\u0010\u001f\u001a\u00020\u001bJ\u0006\u0010 \u001a\u00020\u001bJ\u0006\u0010!\u001a\u00020\u001bJ\u0006\u0010\"\u001a\u00020\u001bJ\b\u0010#\u001a\u00020\u001bH\u0002J\b\u0010$\u001a\u00020\u001bH\u0002J\u0006\u0010%\u001a\u00020\u001bJ\u000e\u0010&\u001a\u00020\u001b2\u0006\u0010'\u001a\u00020(J\u0010\u0010)\u001a\u00020\u001b2\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014J\u0010\u0010*\u001a\u00020\u001b2\u0006\u0010+\u001a\u00020,H\u0002J\u0010\u0010-\u001a\u00020\u001b2\u0006\u0010+\u001a\u00020.H\u0002J\u0010\u0010/\u001a\u00020\u001b2\u0006\u0010+\u001a\u00020,H\u0002R\u001a\u0010\u0007\u001a\u00020\bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u001b\u0010\r\u001a\u00020\u000e8BX\u0002¢\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u000f\u0010\u0010R\u0010\u0010\u0013\u001a\u0004\u0018\u00010\u0014X\u000e¢\u0006\u0002\n\u0000R\u001b\u0010\u0015\u001a\u00020\u00168BX\u0002¢\u0006\f\n\u0004\b\u0019\u0010\u0012\u001a\u0004\b\u0017\u0010\u0018¨\u00060"}, mo26107d2 = {"Leditor/editor/equipment/media/MediaLayerView;", "Landroid/widget/FrameLayout;", "context", "Landroid/content/Context;", "attributeSet", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "areAspectsFixed", "", "getAreAspectsFixed", "()Z", "setAreAspectsFixed", "(Z)V", "binding", "Lcom/memes/editor/databinding/NMediaViewBinding;", "getBinding", "()Lcom/memes/editor/databinding/NMediaViewBinding;", "binding$delegate", "Lkotlin/Lazy;", "content", "Lcom/memes/commons/media/MediaContent;", "organiser", "Leditor/common/mediaplayback/MediaPlaybackOrganiser;", "getOrganiser", "()Leditor/common/mediaplayback/MediaPlaybackOrganiser;", "organiser$delegate", "destroy", "", "disablePlaceholder", "enablePlaceholder", "isPlayable", "mute", "pause", "play", "refresh", "removePhoto", "removeVideo", "reset", "setAspectRatio", "ratio", "", "setContent", "showGif", "file", "Ljava/io/File;", "showPhoto", "Lcom/memes/commons/media/MediaFile;", "showVideo", "editor_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
/* compiled from: MediaLayerView.kt */
public final class MediaLayerView extends FrameLayout {
    private boolean areAspectsFixed;
    private final Lazy binding$delegate;
    private MediaContent content;
    private final Lazy organiser$delegate;

    /* access modifiers changed from: private */
    public final NMediaViewBinding getBinding() {
        return (NMediaViewBinding) this.binding$delegate.getValue();
    }

    /* access modifiers changed from: private */
    public final MediaPlaybackOrganiser getOrganiser() {
        return (MediaPlaybackOrganiser) this.organiser$delegate.getValue();
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ MediaLayerView(Context context, AttributeSet attributeSet, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i & 2) != 0 ? null : attributeSet);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public MediaLayerView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        Intrinsics.checkNotNullParameter(context, "context");
        this.binding$delegate = LazyKt.lazy(new MediaLayerView$binding$2(this, context));
        this.organiser$delegate = LazyKt.lazy(MediaLayerView$organiser$2.INSTANCE);
        getBinding();
        PlayerView playerView = getBinding().videoView;
        Intrinsics.checkNotNullExpressionValue(playerView, "binding.videoView");
        playerView.setResizeMode(4);
        PlayerView playerView2 = getBinding().videoView;
        Intrinsics.checkNotNullExpressionValue(playerView2, "binding.videoView");
        playerView2.setControllerAutoShow(false);
        PlayerView playerView3 = getBinding().videoView;
        Intrinsics.checkNotNullExpressionValue(playerView3, "binding.videoView");
        playerView3.setUseController(false);
        getBinding().playbackToggleButton.setOnClickListener(new View.OnClickListener(this) {
            final /* synthetic */ MediaLayerView this$0;

            {
                this.this$0 = r1;
            }

            public final void onClick(View view) {
                boolean z = this.this$0.getOrganiser().togglePlaybackState();
                ImageView imageView = this.this$0.getBinding().playbackToggleButton;
                Intrinsics.checkNotNullExpressionValue(imageView, "binding.playbackToggleButton");
                imageView.setSelected(z);
                if (!z || !this.this$0.getOrganiser().hasAudioTrack()) {
                    ImageView imageView2 = this.this$0.getBinding().volumeToggleButton;
                    Intrinsics.checkNotNullExpressionValue(imageView2, "binding.volumeToggleButton");
                    imageView2.setVisibility(8);
                    return;
                }
                ImageView imageView3 = this.this$0.getBinding().volumeToggleButton;
                Intrinsics.checkNotNullExpressionValue(imageView3, "binding.volumeToggleButton");
                imageView3.setVisibility(0);
            }
        });
        getBinding().volumeToggleButton.setOnClickListener(new View.OnClickListener(this) {
            final /* synthetic */ MediaLayerView this$0;

            {
                this.this$0 = r1;
            }

            public final void onClick(View view) {
                boolean z = this.this$0.getOrganiser().toggleVolume();
                ImageView imageView = this.this$0.getBinding().volumeToggleButton;
                Intrinsics.checkNotNullExpressionValue(imageView, "binding.volumeToggleButton");
                imageView.setSelected(z);
            }
        });
    }

    public final boolean getAreAspectsFixed() {
        return this.areAspectsFixed;
    }

    public final void setAreAspectsFixed(boolean z) {
        this.areAspectsFixed = z;
    }

    private final void showPhoto(MediaFile mediaFile) {
        Timber.m300d("~> showPhoto: file=" + mediaFile, new Object[0]);
        Glide.with(getContext()).load((File) mediaFile).into(getBinding().photoView);
        ImageView imageView = getBinding().photoView;
        Intrinsics.checkNotNullExpressionValue(imageView, "binding.photoView");
        imageView.setVisibility(0);
        LinearLayout linearLayout = getBinding().mediaControlsLayout;
        Intrinsics.checkNotNullExpressionValue(linearLayout, "binding.mediaControlsLayout");
        linearLayout.setVisibility(8);
    }

    private final void showGif(File file) {
        Timber.m300d("~> showGif: file=" + file, new Object[0]);
        Glide.with(getContext()).asGif().load(file).into(getBinding().photoView);
        ImageView imageView = getBinding().photoView;
        Intrinsics.checkNotNullExpressionValue(imageView, "binding.photoView");
        imageView.setVisibility(0);
        LinearLayout linearLayout = getBinding().mediaControlsLayout;
        Intrinsics.checkNotNullExpressionValue(linearLayout, "binding.mediaControlsLayout");
        linearLayout.setVisibility(8);
    }

    private final void showVideo(File file) {
        Timber.m300d("~> showVideo: file=" + file, new Object[0]);
        getOrganiser().releaseSafely();
        MediaPlaybackOrganiser organiser = getOrganiser();
        Uri fromFile = Uri.fromFile(file);
        PlayerView playerView = getBinding().videoView;
        Intrinsics.checkNotNullExpressionValue(playerView, "binding.videoView");
        organiser.start(fromFile, playerView);
        pause();
        mute();
        PlayerView playerView2 = getBinding().videoView;
        Intrinsics.checkNotNullExpressionValue(playerView2, "binding.videoView");
        playerView2.setVisibility(0);
        LinearLayout linearLayout = getBinding().mediaControlsLayout;
        Intrinsics.checkNotNullExpressionValue(linearLayout, "binding.mediaControlsLayout");
        linearLayout.setVisibility(0);
    }

    private final void removePhoto() {
        ImageView imageView = getBinding().photoView;
        Intrinsics.checkNotNullExpressionValue(imageView, "binding.photoView");
        imageView.setVisibility(8);
        getBinding().photoView.setImageResource(0);
    }

    private final void removeVideo() {
        PlayerView playerView = getBinding().videoView;
        Intrinsics.checkNotNullExpressionValue(playerView, "binding.videoView");
        playerView.setVisibility(8);
        if (isPlayable()) {
            getOrganiser().release();
        }
    }

    private final void enablePlaceholder() {
        setBackgroundColor(-16777216);
        ImageView imageView = getBinding().placeholderView;
        Intrinsics.checkNotNullExpressionValue(imageView, "binding.placeholderView");
        imageView.setVisibility(0);
        LinearLayout linearLayout = getBinding().mediaControlsLayout;
        Intrinsics.checkNotNullExpressionValue(linearLayout, "binding.mediaControlsLayout");
        linearLayout.setVisibility(8);
    }

    private final void disablePlaceholder() {
        setBackgroundColor(0);
        ImageView imageView = getBinding().placeholderView;
        Intrinsics.checkNotNullExpressionValue(imageView, "binding.placeholderView");
        imageView.setVisibility(8);
    }

    public final void reset() {
        removePhoto();
        removeVideo();
        LinearLayout linearLayout = getBinding().mediaControlsLayout;
        Intrinsics.checkNotNullExpressionValue(linearLayout, "binding.mediaControlsLayout");
        linearLayout.setVisibility(8);
        this.content = null;
        enablePlaceholder();
    }

    public final void setContent(MediaContent mediaContent) {
        this.content = mediaContent;
        if (mediaContent == null) {
            reset();
            return;
        }
        ImageView imageView = getBinding().photoView;
        Intrinsics.checkNotNullExpressionValue(imageView, "binding.photoView");
        imageView.setScaleType(ImageView.ScaleType.FIT_CENTER);
        if (mediaContent.isPhoto()) {
            showPhoto(MediaFile.Companion.from(mediaContent));
            removeVideo();
        } else if (mediaContent.isGif()) {
            showGif(mediaContent.asFile());
            removeVideo();
        } else if (mediaContent.isPlayableVideo()) {
            showVideo(mediaContent.asFile());
            removePhoto();
        } else {
            throw new RuntimeException("Unknown content-type: " + mediaContent);
        }
        ImageView imageView2 = getBinding().photoView;
        Intrinsics.checkNotNullExpressionValue(imageView2, "binding.photoView");
        imageView2.setScaleType(ImageView.ScaleType.CENTER_CROP);
        if (!this.areAspectsFixed) {
            setAspectRatio(mediaContent.aspectRatio());
        }
        disablePlaceholder();
    }

    public final void setAspectRatio(float f) {
        post(new MediaLayerView$setAspectRatio$1(this, f));
    }

    public final boolean isPlayable() {
        MediaContent mediaContent = this.content;
        return mediaContent != null && mediaContent.isPlayableVideo();
    }

    public final void play() {
        getOrganiser().resume();
        ImageView imageView = getBinding().playbackToggleButton;
        Intrinsics.checkNotNullExpressionValue(imageView, "binding.playbackToggleButton");
        imageView.setSelected(true);
        if (getOrganiser().hasAudioTrack()) {
            ImageView imageView2 = getBinding().volumeToggleButton;
            Intrinsics.checkNotNullExpressionValue(imageView2, "binding.volumeToggleButton");
            imageView2.setVisibility(0);
        }
    }

    public final void pause() {
        if (isPlayable()) {
            getOrganiser().pause();
            ImageView imageView = getBinding().playbackToggleButton;
            Intrinsics.checkNotNullExpressionValue(imageView, "binding.playbackToggleButton");
            imageView.setSelected(false);
            ImageView imageView2 = getBinding().volumeToggleButton;
            Intrinsics.checkNotNullExpressionValue(imageView2, "binding.volumeToggleButton");
            imageView2.setVisibility(8);
        }
    }

    public final void refresh() {
        if (isPlayable()) {
            play();
            Handler handler = getHandler();
            if (handler == null) {
                handler = new Handler();
            }
            handler.postDelayed(new MediaLayerView$refresh$1(this), 200);
        }
    }

    public final void mute() {
        if (isPlayable()) {
            getOrganiser().mute();
            ImageView imageView = getBinding().volumeToggleButton;
            Intrinsics.checkNotNullExpressionValue(imageView, "binding.volumeToggleButton");
            imageView.setSelected(false);
        }
    }

    public final void destroy() {
        removePhoto();
        removeVideo();
        this.content = null;
    }
}
