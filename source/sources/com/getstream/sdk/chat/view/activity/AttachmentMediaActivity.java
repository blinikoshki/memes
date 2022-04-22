package com.getstream.sdk.chat.view.activity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.ImageView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import com.getstream.sdk.chat.ChatUI;
import com.getstream.sdk.chat.utils.exomedia.listener.OnPreparedListener;
import com.getstream.sdk.chat.utils.exomedia.p012ui.widget.VideoView;
import com.google.android.exoplayer2.util.MimeTypes;
import p015io.getstream.chat.android.client.logger.ChatLogger;
import p015io.getstream.chat.android.client.logger.TaggedLogger;
import p015io.getstream.chat.android.p016ui.common.C1891R;

public class AttachmentMediaActivity extends AppCompatActivity {
    public static final String TYPE_KEY = "type";
    public static final String URL_KEY = "url";
    ImageView iv_audio;
    private final TaggedLogger logger = ChatLogger.Companion.get("AttachmentMediaActivity");
    VideoView videoView;

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(C1891R.C1897layout.stream_activity_attachment_media);
        this.videoView = (VideoView) findViewById(C1891R.C1895id.videoView);
        this.iv_audio = (ImageView) findViewById(C1891R.C1895id.iv_audio);
        init();
    }

    private void init() {
        Intent intent = getIntent();
        String stringExtra = intent.getStringExtra("type");
        String stringExtra2 = intent.getStringExtra("url");
        if (TextUtils.isEmpty(stringExtra) || TextUtils.isEmpty(stringExtra2)) {
            this.logger.logE("This file can't be displayed. The TYPE or the URL are null");
            Toast.makeText(this, getString(C1891R.string.stream_ui_attachment_display_error), 0).show();
            return;
        }
        if (stringExtra.contains(MimeTypes.BASE_TYPE_AUDIO)) {
            this.iv_audio.setVisibility(0);
        } else {
            this.iv_audio.setVisibility(8);
        }
        playVideo(ChatUI.instance().getUrlSigner().signFileUrl(stringExtra2));
    }

    public void playVideo(String str) {
        this.videoView.setVideoURI(Uri.parse(ChatUI.instance().getUrlSigner().signFileUrl(str)));
        this.videoView.setOnPreparedListener(new OnPreparedListener() {
            public final void onPrepared() {
                AttachmentMediaActivity.this.lambda$playVideo$0$AttachmentMediaActivity();
            }
        });
    }

    public /* synthetic */ void lambda$playVideo$0$AttachmentMediaActivity() {
        this.videoView.start();
    }
}
