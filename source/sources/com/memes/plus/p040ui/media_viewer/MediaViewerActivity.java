package com.memes.plus.p040ui.media_viewer;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import androidx.fragment.app.FragmentActivity;
import com.bumptech.glide.Glide;
import com.google.android.exoplayer2.ExoPlaybackException;
import com.google.android.exoplayer2.p024ui.PlayerView;
import com.livinglifetechway.quickpermissions_kotlin.PermissionsManagerKt;
import com.livinglifetechway.quickpermissions_kotlin.util.QuickPermissionsOptions;
import com.memes.commons.contentlayout.ContentLayout;
import com.memes.commons.media.MediaFile;
import com.memes.plus.C4199R;
import com.memes.plus.base.BaseActivity;
import com.memes.plus.custom.player.ExoPlayerHelper;
import com.memes.plus.custom.player.PlayerEventListenerAdapter;
import com.memes.plus.databinding.MediaViewerActivityBinding;
import com.memes.plus.util.DialogUtil;
import java.io.File;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0004\u0018\u0000 !2\u00020\u0001:\u0002!\"B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\r\u001a\u00020\u000eH\u0002J\b\u0010\u000f\u001a\u00020\u000eH\u0016J\u0012\u0010\u0010\u001a\u00020\u000e2\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012H\u0014J\b\u0010\u0013\u001a\u00020\u000eH\u0014J\b\u0010\u0014\u001a\u00020\u000eH\u0014J\b\u0010\u0015\u001a\u00020\u000eH\u0014J\u0018\u0010\u0016\u001a\u00020\u000e2\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u0018H\u0002J\u0010\u0010\u001a\u001a\u00020\u000e2\u0006\u0010\u001b\u001a\u00020\u0018H\u0002J\u0010\u0010\u001c\u001a\u00020\u000e2\u0006\u0010\u001b\u001a\u00020\u0018H\u0002J\u0018\u0010\u001d\u001a\u00020\u000e2\u0006\u0010\u001e\u001a\u00020\u001f2\u0006\u0010\u001b\u001a\u00020\u0018H\u0002J\u0010\u0010 \u001a\u00020\u000e2\u0006\u0010\u001b\u001a\u00020\u0018H\u0002R\u001b\u0010\u0003\u001a\u00020\u00048BX\u0002¢\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\u0005\u0010\u0006R\u000e\u0010\t\u001a\u00020\nX\u0004¢\u0006\u0002\n\u0000R\u0012\u0010\u000b\u001a\u00060\fR\u00020\u0000X\u0004¢\u0006\u0002\n\u0000¨\u0006#"}, mo26107d2 = {"Lcom/memes/plus/ui/media_viewer/MediaViewerActivity;", "Lcom/memes/plus/base/BaseActivity;", "()V", "binding", "Lcom/memes/plus/databinding/MediaViewerActivityBinding;", "getBinding", "()Lcom/memes/plus/databinding/MediaViewerActivityBinding;", "binding$delegate", "Lkotlin/Lazy;", "exoPlayerHelper", "Lcom/memes/plus/custom/player/ExoPlayerHelper;", "playerStateCallback", "Lcom/memes/plus/ui/media_viewer/MediaViewerActivity$PlayerStateCallback;", "initData", "", "onBackPressed", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "onPause", "onResume", "showExitDialog", "title", "", "message", "showLocalPhoto", "path", "showLocalVideo", "showNetworkPhoto", "mediaType", "", "showNetworkVideo", "Companion", "PlayerStateCallback", "app_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
/* renamed from: com.memes.plus.ui.media_viewer.MediaViewerActivity */
/* compiled from: MediaViewerActivity.kt */
public final class MediaViewerActivity extends BaseActivity {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private static final String EXTRA_MEDIA_PATH = "intent_extra_media_path";
    private static final String EXTRA_MEDIA_THUMBNAIL_PATH = "intent_extra_media_thumbnail_path";
    private static final String EXTRA_MEDIA_TYPE = "intent_extra_media_type";
    private final Lazy binding$delegate = LazyKt.lazy(new MediaViewerActivity$binding$2(this));
    /* access modifiers changed from: private */
    public final ExoPlayerHelper exoPlayerHelper = new ExoPlayerHelper(this);
    private final PlayerStateCallback playerStateCallback = new PlayerStateCallback();

    /* access modifiers changed from: private */
    public final MediaViewerActivityBinding getBinding() {
        return (MediaViewerActivityBinding) this.binding$delegate.getValue();
    }

    @Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0016\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fJ\u001e\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0004R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0010"}, mo26107d2 = {"Lcom/memes/plus/ui/media_viewer/MediaViewerActivity$Companion;", "", "()V", "EXTRA_MEDIA_PATH", "", "EXTRA_MEDIA_THUMBNAIL_PATH", "EXTRA_MEDIA_TYPE", "getStartIntent", "Landroid/content/Intent;", "context", "Landroid/content/Context;", "mediaFile", "Lcom/memes/commons/media/MediaFile;", "mediaType", "", "filePath", "app_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
    /* renamed from: com.memes.plus.ui.media_viewer.MediaViewerActivity$Companion */
    /* compiled from: MediaViewerActivity.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final Intent getStartIntent(Context context, MediaFile mediaFile) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(mediaFile, "mediaFile");
            Intent intent = new Intent(context, MediaViewerActivity.class);
            intent.putExtra(MediaViewerActivity.EXTRA_MEDIA_TYPE, mediaFile.getType());
            intent.putExtra(MediaViewerActivity.EXTRA_MEDIA_PATH, mediaFile.getAbsolutePath());
            intent.putExtra(MediaViewerActivity.EXTRA_MEDIA_THUMBNAIL_PATH, mediaFile.getThumbnail());
            return intent;
        }

        public final Intent getStartIntent(Context context, int i, String str) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(str, "filePath");
            Intent intent = new Intent(context, MediaViewerActivity.class);
            intent.putExtra(MediaViewerActivity.EXTRA_MEDIA_TYPE, i);
            intent.putExtra(MediaViewerActivity.EXTRA_MEDIA_PATH, str);
            intent.putExtra(MediaViewerActivity.EXTRA_MEDIA_THUMBNAIL_PATH, str);
            return intent;
        }
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        MediaViewerActivityBinding binding = getBinding();
        Intrinsics.checkNotNullExpressionValue(binding, "binding");
        setContentView((View) binding.getRoot());
        getBinding().backImageView.setOnClickListener(new MediaViewerActivity$onCreate$1(this));
        PermissionsManagerKt.runWithPermissions$default((Context) this, new String[]{"android.permission.READ_EXTERNAL_STORAGE"}, (QuickPermissionsOptions) null, (Function0) new MediaViewerActivity$onCreate$2(this), 2, (Object) null);
    }

    /* access modifiers changed from: private */
    public final void initData() {
        Intent intent = getIntent();
        String str = null;
        Integer valueOf = intent != null ? Integer.valueOf(intent.getIntExtra(EXTRA_MEDIA_TYPE, -1)) : null;
        Intent intent2 = getIntent();
        String stringExtra = intent2 != null ? intent2.getStringExtra(EXTRA_MEDIA_PATH) : null;
        Intent intent3 = getIntent();
        if (intent3 != null) {
            str = intent3.getStringExtra(EXTRA_MEDIA_THUMBNAIL_PATH);
        }
        if (stringExtra == null) {
            String string = getString(C4199R.string.error_file_not_found);
            Intrinsics.checkNotNullExpressionValue(string, "getString(R.string.error_file_not_found)");
            String string2 = getString(C4199R.string.error_file_not_found_msg);
            Intrinsics.checkNotNullExpressionValue(string2, "getString(R.string.error_file_not_found_msg)");
            showExitDialog(string, string2);
            return;
        }
        CharSequence charSequence = str;
        if (!(charSequence == null || StringsKt.isBlank(charSequence))) {
            ImageView imageView = getBinding().previewImageView;
            Intrinsics.checkNotNullExpressionValue(imageView, "binding.previewImageView");
            imageView.setVisibility(0);
            Glide.with((FragmentActivity) this).load(str).into(getBinding().previewImageView);
        }
        PlayerView playerView = getBinding().previewPlayerView;
        Intrinsics.checkNotNullExpressionValue(playerView, "binding.previewPlayerView");
        playerView.setVisibility(0);
        if (valueOf != null && valueOf.intValue() == 1231) {
            showLocalPhoto(stringExtra);
        } else if (valueOf != null && valueOf.intValue() == 1232) {
            showLocalVideo(stringExtra);
        } else if (valueOf != null && valueOf.intValue() == 1237) {
            showLocalVideo(stringExtra);
        } else if ((valueOf != null && valueOf.intValue() == 1236) || (valueOf != null && valueOf.intValue() == 1233)) {
            showNetworkPhoto(valueOf.intValue(), stringExtra);
        } else if (valueOf != null && valueOf.intValue() == 1234) {
            showNetworkVideo(stringExtra);
        }
    }

    private final void showLocalPhoto(String str) {
        Glide.with((FragmentActivity) this).load(new File(str)).into(getBinding().previewImageView);
        ImageView imageView = getBinding().previewImageView;
        Intrinsics.checkNotNullExpressionValue(imageView, "binding.previewImageView");
        imageView.setVisibility(0);
    }

    private final void showLocalVideo(String str) {
        this.exoPlayerHelper.release();
        ExoPlayerHelper exoPlayerHelper2 = this.exoPlayerHelper;
        Uri fromFile = Uri.fromFile(new File(str));
        Intrinsics.checkExpressionValueIsNotNull(fromFile, "Uri.fromFile(this)");
        PlayerView playerView = getBinding().previewPlayerView;
        Intrinsics.checkNotNullExpressionValue(playerView, "binding.previewPlayerView");
        exoPlayerHelper2.start(fromFile, playerView, this.playerStateCallback);
    }

    private final void showNetworkPhoto(int i, String str) {
        if (i == 1231) {
            Intrinsics.checkNotNullExpressionValue(Glide.with((FragmentActivity) this).load(str).into(getBinding().previewImageView), "Glide.with(this)\n\t\t\t\t\t.l…binding.previewImageView)");
        } else if (i == 1236) {
            Intrinsics.checkNotNullExpressionValue(Glide.with((FragmentActivity) this).asGif().load(str).into(getBinding().previewImageView), "Glide.with(this)\n\t\t\t\t\t.a…binding.previewImageView)");
        }
        ImageView imageView = getBinding().previewImageView;
        Intrinsics.checkNotNullExpressionValue(imageView, "binding.previewImageView");
        imageView.setVisibility(0);
    }

    private final void showNetworkVideo(String str) {
        this.exoPlayerHelper.release();
        ExoPlayerHelper exoPlayerHelper2 = this.exoPlayerHelper;
        Uri parse = Uri.parse(str);
        PlayerView playerView = getBinding().previewPlayerView;
        Intrinsics.checkNotNullExpressionValue(playerView, "binding.previewPlayerView");
        exoPlayerHelper2.start(parse, playerView, this.playerStateCallback);
    }

    /* access modifiers changed from: private */
    public final void showExitDialog(String str, String str2) {
        DialogUtil.INSTANCE.showInformation(this, str, str2, false, new MediaViewerActivity$showExitDialog$1(this));
    }

    /* access modifiers changed from: protected */
    public void onPause() {
        this.exoPlayerHelper.pause();
        super.onPause();
    }

    /* access modifiers changed from: protected */
    public void onResume() {
        super.onResume();
        this.exoPlayerHelper.resume();
    }

    public void onBackPressed() {
        ImageView imageView = getBinding().previewImageView;
        Intrinsics.checkNotNullExpressionValue(imageView, "binding.previewImageView");
        imageView.setVisibility(0);
        supportFinishAfterTransition();
    }

    /* access modifiers changed from: protected */
    public void onDestroy() {
        this.exoPlayerHelper.release();
        super.onDestroy();
    }

    @Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\b\u0004\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J\u0018\u0010\u0007\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0016¨\u0006\f"}, mo26107d2 = {"Lcom/memes/plus/ui/media_viewer/MediaViewerActivity$PlayerStateCallback;", "Lcom/memes/plus/custom/player/PlayerEventListenerAdapter;", "(Lcom/memes/plus/ui/media_viewer/MediaViewerActivity;)V", "onPlayerError", "", "playbackException", "Lcom/google/android/exoplayer2/ExoPlaybackException;", "onPlayerStateChanged", "playWhenReady", "", "playbackState", "", "app_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
    /* renamed from: com.memes.plus.ui.media_viewer.MediaViewerActivity$PlayerStateCallback */
    /* compiled from: MediaViewerActivity.kt */
    private final class PlayerStateCallback extends PlayerEventListenerAdapter {
        public PlayerStateCallback() {
        }

        public void onPlayerError(ExoPlaybackException exoPlaybackException) {
            Intrinsics.checkNotNullParameter(exoPlaybackException, "playbackException");
            MediaViewerActivity.this.getBinding().contentLayout.showContent();
            MediaViewerActivity.this.exoPlayerHelper.release();
            MediaViewerActivity mediaViewerActivity = MediaViewerActivity.this;
            String string = mediaViewerActivity.getString(C4199R.string.error_cant_play_video);
            Intrinsics.checkNotNullExpressionValue(string, "getString(R.string.error_cant_play_video)");
            String string2 = MediaViewerActivity.this.getString(C4199R.string.error_cant_play_video_msg, new Object[]{exoPlaybackException.getMessage()});
            Intrinsics.checkNotNullExpressionValue(string2, "getString(R.string.error…laybackException.message)");
            mediaViewerActivity.showExitDialog(string, string2);
        }

        public void onPlayerStateChanged(boolean z, int i) {
            if (i == 2) {
                ContentLayout.showProgress$default(MediaViewerActivity.this.getBinding().contentLayout, (String) null, 1, (Object) null);
            }
            if (i == 3 && z) {
                MediaViewerActivity.this.getBinding().contentLayout.showContent();
                ImageView imageView = MediaViewerActivity.this.getBinding().previewImageView;
                Intrinsics.checkNotNullExpressionValue(imageView, "binding.previewImageView");
                imageView.setVisibility(8);
            }
        }
    }
}
